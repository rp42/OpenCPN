/***************************************************************************
 *
 * Project:  OpenCPN
 * Purpose:  Implement comm_drv_n2k.h -- Nmea2000 serial driver.
 * Author:   David Register, Alec Leamas
 *
 ***************************************************************************
 *   Copyright (C) 2022 by David Register, Alec Leamas                     *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,  USA.         *
 **************************************************************************/

// TODO:
// - Remove malloc/free
// - Remove raw pointers
// - Clean up buffer variables
// - MAke varous Map...() functions return bReady.
// - Clean up variable names.
// - Make fastMessages a std::vector

#include <algorithm>
#include <mutex>  // std::mutex
#include <queue>  // std::queue
#include <thread>
#include <vector>

#include <sys/time.h>

#include <wx/datetime.h>
#include <wx/event.h>
#include <wx/log.h>
#include <wx/string.h>
#include <wx/utils.h>

#include "atomic_queue.h"
#include "comm_drv_n2k_socketcan.h"
#include "comm_navmsg_bus.h"
#include "comm_drv_registry.h"

#define NOT_FOUND -1
#define CONST_MAX_MESSAGES 100
#define CONST_TIME_EXCEEDED 250

// Decodes a 29 bit CAN header from an int
void DecodeCanHeader(const int canId, CanHeader* header) {
  unsigned char buf[4];
  buf[0] = canId & 0xFF;
  buf[1] = (canId >> 8) & 0xFF;
  buf[2] = (canId >> 16) & 0xFF;
  buf[3] = (canId >> 24) & 0xFF;

  header->source = buf[0];
  header->destination = buf[2] < 240 ? buf[1] : 255;
  header->pgn =
      (buf[3] & 0x01) << 16 | (buf[2] << 8) | (buf[2] < 240 ? 0 : buf[1]);
  header->priority = (buf[3] & 0x1c) >> 2;
}

class CommDriverN2KSocketCANEvent;  // fwd

// Buffer used to re-assemble sequences of multi frame Fast Packet messages
typedef struct FastMessageEntry {
  unsigned char isFree;            // indicate whether this entry is free
  unsigned long long timeArrived;  // time of last message in microseconds.
  CanHeader header;  // the header of the message. Used to "map" the incoming
                     // fast message fragments
  unsigned int sid;  // message sequence identifier, used to check if a received
                     // message is the next message in the sequence
  unsigned int expectedLength;  // total data length obtained from first frame
  unsigned int cursor;  // cursor into the current position in the below data
  unsigned char* data;  // pointer to memory allocated for the data. Note: must
                        // be freed when IsFree is set to TRUE.
} FastMessageEntry;

unsigned long long GetTimeInMicroseconds() {
#if (defined(__APPLE__) && defined(__MACH__)) || defined(__LINUX__)
  struct timeval currentTime;
  gettimeofday(&currentTime, NULL);
  return (currentTime.tv_sec * 1e6) + currentTime.tv_usec;
#endif
}

class CommDriverN2KSocketCANThread {
public:
  CommDriverN2KSocketCANThread(CommDriverN2KSocketCAN* Launcher,
                               const wxString& PortName);

  void* Entry();
  bool SetOutMsg(const wxString& msg);
  void OnExit(void);

private:
  void ThreadMessage(const wxString& msg);

  bool IsFastMessage(const CanHeader header);
  int MapFindMatchingEntry(const CanHeader header, const unsigned char sid);
  int MapFindFreeEntry(void);
  int MapGarbageCollector(void);
  void MapInsertEntry(const CanHeader header, const unsigned char* data,
                      const int position, bool& bReady);
  int MapAppendEntry(const CanHeader header, const unsigned char* data,
                     const int position, bool& bReady);
  void MapInitialize(void);

  void PushCompleteMsg(std::vector<unsigned char>& data,
                       const CanHeader header, int position,
                       const struct can_frame& socket_frame);
  void PushFastMsgFragment(std::vector<unsigned char>& data,
                           const CanHeader& header, int position);

  CommDriverN2KSocketCAN* m_pParentDriver;
  wxString m_PortName;

  n2k_atomic_queue<char*> out_que;

  // The Fast Packet buffer - used to reassemble Fast packet messages
  FastMessageEntry fastMessages[CONST_MAX_MESSAGES];
  int droppedFrames;
  wxDateTime droppedFrameTime;

  // CAN connection variables
  struct sockaddr_can can_address;
  // Interface Request
  struct ifreq can_request;
  // Socket Descriptor
  int can_socket;
  int flags;
};

class CommDriverN2KSocketCANEvent;
wxDECLARE_EVENT(wxEVT_COMMDRIVER_N2K_SOCKETCAN, CommDriverN2KSocketCANEvent);

class CommDriverN2KSocketCANEvent : public wxEvent {
public:
  CommDriverN2KSocketCANEvent(wxEventType commandType = wxEVT_NULL, int id = 0)
      : wxEvent(id, commandType){};
  ~CommDriverN2KSocketCANEvent(){};

  // accessors
  void SetPayload(std::shared_ptr<std::vector<unsigned char>> data) {
    m_payload = data;
  }
  std::shared_ptr<std::vector<unsigned char>> GetPayload() { return m_payload; }

  // required for sending with wxPostEvent()
  wxEvent* Clone() const {
    CommDriverN2KSocketCANEvent* newevent =
        new CommDriverN2KSocketCANEvent(*this);
    newevent->m_payload = this->m_payload;
    return newevent;
  };

private:
  std::shared_ptr<std::vector<unsigned char>> m_payload;
};

//========================================================================
/*    CommDriverN2KSocketCAN implementation
 * */

CommDriverN2KSocketCAN::CommDriverN2KSocketCAN(const ConnectionParams* params,
                                               DriverListener& listener)
    : CommDriverN2K(((ConnectionParams*)params)->GetStrippedDSPort()),
      m_Thread_run_flag(-1),
      m_bok(false),
      m_portstring(params->GetDSPort()),
      m_pSecondary_Thread(NULL),
      m_params(*params),
      m_listener(listener) {
  m_BaudRate = wxString::Format("%i", params->Baudrate), SetSecThreadInActive();

  Open();
}

CommDriverN2KSocketCAN::~CommDriverN2KSocketCAN() {
  if (m_pSecondary_Thread) Close();
}

bool CommDriverN2KSocketCAN::Open() {
  //    Kick off the  RX thread
  SetSecondaryThread(
      new CommDriverN2KSocketCANThread(this, m_params.socketCAN_port));
  SetThreadRunFlag(1);
  std::thread t(&CommDriverN2KSocketCANThread::Entry, GetSecondaryThread());
  t.detach();

  return true;
}

void CommDriverN2KSocketCAN::Close() {
  wxLogMessage("Closing N2K socketCAN: %s", m_params.socketCAN_port.c_str());

  //    Kill off the Secondary RX Thread if alive
  if (m_pSecondary_Thread) {
    if (m_bsec_thread_active)  // Try to be sure thread object is still alive
    {
      wxLogMessage("Stopping Secondary Thread");

      m_Thread_run_flag = 0;
      int tsec = 10;
      while ((m_Thread_run_flag >= 0) && (tsec--)) wxSleep(1);

      if (m_Thread_run_flag < 0)
        wxLogMessage("Stopped in %d sec.", 10 - tsec);
      else
        wxLogMessage("Not Stopped after 10 sec.");
    }
    delete m_pSecondary_Thread;
    m_pSecondary_Thread = NULL;
    m_bsec_thread_active = false;
  }
  // We cannot use shared_from_this() since we might be in the destructor.
  auto& registry = CommDriverRegistry::getInstance();
  auto me = FindDriver(registry.GetDrivers(), iface, bus);
  registry.Deactivate(me);
}

void CommDriverN2KSocketCAN::Activate() {
  CommDriverRegistry::getInstance().Activate(shared_from_this());
  // TODO: Read input data.
}

static uint64_t PayloadToName(const std::vector<unsigned char> payload) {
  uint64_t name;
  memcpy(&name, reinterpret_cast<const void*>(payload.data()), sizeof(name));
  return name;
}

#ifndef __ANDROID__

/**
 * This thread manages reading the N2K data stream provided by some N2K gateways
 * from the declared serial port.
 *
 */

// Commonly used raw format is actually inherited from an old paketizing format:
// <10><02><application data><CRC (1)><10><03>

// Actisense application data, from NGT-1 to PC
// <data code=93><length (1)><priority (1)><PGN (3)><destination(1)><source
// (1)><time (4)><len (1)><data (len)>

// As applied to a real application data element, after extraction from packet
// format: 93 13 02 01 F8 01 FF 01 76 C2 52 00 08 08 70 EB 14 E8 8E 52 D2 BB 10

// length (1):      0x13
// priority (1);    0x02
// PGN (3):         0x01 0xF8 0x01
// destination(1):  0xFF
// source (1):      0x01
// time (4):        0x76 0xC2 0x52 0x00
// len (1):         0x08
// data (len):      08 70 EB 14 E8 8E 52 D2
// packet CRC:      0xBB

CommDriverN2KSocketCANThread::CommDriverN2KSocketCANThread(
    CommDriverN2KSocketCAN* Launcher, const wxString& PortName) {
  m_pParentDriver = Launcher;  // This thread's immediate "parent"

  m_PortName = PortName;

  MapInitialize();
}

void CommDriverN2KSocketCANThread::OnExit(void) {}

void CommDriverN2KSocketCANThread::PushCompleteMsg(
     std::vector<unsigned char>& data, const CanHeader header, int position,
     const struct can_frame& socket_frame) {
  data.push_back(0x93);
  data.push_back(0x13);
  data.push_back(header.priority);
  data.push_back(header.pgn & 0xFF);
  data.push_back((header.pgn >> 8) & 0xFF);
  data.push_back((header.pgn >> 16) & 0xFF);
  data.push_back(header.destination);
  data.push_back(header.source);
  data.push_back(0xFF);  // FIXME (dave) generate the time fields
  data.push_back(0xFF);
  data.push_back(0xFF);
  data.push_back(0xFF);
  data.push_back(CAN_MAX_DLEN);  // nominally 8
  for (size_t n = 0; n < CAN_MAX_DLEN; n++)
    data.push_back(socket_frame.data[n]);
  data.push_back(0x55);  // CRC dummy, not checked
 }

void CommDriverN2KSocketCANThread::PushFastMsgFragment(
     std::vector<unsigned char>& data, const CanHeader& header,
     int position) {
  data.push_back(0x93);
  data.push_back(fastMessages[position].expectedLength + 11);
  data.push_back(header.priority);
  data.push_back(header.pgn & 0xFF);
  data.push_back((header.pgn >> 8) & 0xFF);
  data.push_back((header.pgn >> 16) & 0xFF);
  data.push_back(header.destination);
  data.push_back(header.source);
  data.push_back(0xFF);  // FIXME (dave) Could generate the time fields
  data.push_back(0xFF);
  data.push_back(0xFF);
  data.push_back(0xFF);
  data.push_back(fastMessages[position].expectedLength);
  for (size_t n = 0; n < fastMessages[position].expectedLength; n++)
    data.push_back(fastMessages[position].data[n]);
  data.push_back(0x55);  // CRC dummy
  free(fastMessages[position].data);
  fastMessages[position].isFree = TRUE;
  fastMessages[position].data = NULL;
}

void CommDriverN2KSocketCANThread::ThreadMessage(const wxString& msg) {
  //    Signal the main program thread
  //   OCPN_ThreadMessageEvent event(wxEVT_OCPN_THREADMSG, 0);
  //   event.SetSString(std::string(msg.mb_str()));
  //   if (gFrame) gFrame->GetEventHandler()->AddPendingEvent(event);
}

#ifndef __WXMSW__
void* CommDriverN2KSocketCANThread::Entry() {
  bool nl_found = false;
  wxString msg;

  CanHeader header;
  int recvbytes;
  struct can_frame canSocketFrame;

  // Create and open the CAN socket

  can_socket = socket(PF_CAN, SOCK_RAW, CAN_RAW);
  if (can_socket < 0) {
    wxString msg("SocketCAN socket create failed: ");
    ThreadMessage(msg + m_PortName);
    return 0;
  }

  // eg. Native Interface "can0", Serial Interface "slcan0", Virtual Interface
  // "vcan0"
  std::string port_name(m_PortName);
  strcpy(can_request.ifr_name, port_name.c_str());

  // Get the index of the interface
  if (ioctl(can_socket, SIOCGIFINDEX, &can_request) < 0) {
    wxString msg("SocketCAN socket IOCTL (SIOCGIFINDEX) failed: ");
    ThreadMessage(msg + m_PortName);
    return 0;
  }

  can_address.can_family = AF_CAN;
  can_address.can_ifindex = can_request.ifr_ifindex;

  // Check if the interface is UP
  if (ioctl(can_socket, SIOCGIFFLAGS, &can_request) < 0) {
    wxString msg("SocketCAN socket IOCTL (SIOCGIFFLAGS) failed: ");
    ThreadMessage(msg + m_PortName);
    return 0;
  }

  if (can_request.ifr_flags & IFF_UP) {
    ThreadMessage(wxString("socketCan interface is UP"));
  } else {
    return 0;
  }

  int r = bind(can_socket, (struct sockaddr*)&can_address, sizeof(can_address));
  if (r < 0) {
    wxString("SocketCAN socket bind() failed: ");
    ThreadMessage(wxString("SocketCAN socket bind() failed: ") + m_PortName);
    return 0;
  }

  m_pParentDriver->SetSecThreadActive();  // I am alive

  // The main loop
  while (m_pParentDriver->m_Thread_run_flag > 0) {
    recvbytes = read(can_socket, &canSocketFrame, sizeof(struct can_frame));
    if (recvbytes == -1) {
      if (errno == EAGAIN) {
        wxLogMessage("can socket %s: EAGAIN (retrying)", m_PortName.c_str());
        sleep(1);
        continue;
      } else {
        wxLogWarning("can socket %s: fatal error %s", m_PortName.c_str(),
                     strerror(errno));
        return 0;  // FIXME (leamas)
      }
    }
    if (recvbytes != 16) {
      wxLogWarning("can socket %s: bad frame size: %d (ignored)", recvbytes);
      sleep(1);
      continue;
    }
    int position = -1;
    bool bReady = false;

    DecodeCanHeader(canSocketFrame.can_id, &header);

    if (IsFastMessage(header) == TRUE) {
      position = MapFindMatchingEntry(header, canSocketFrame.data[0]);
      if (position == NOT_FOUND) {
        // Not an existing fast message, find a free slot
        position = MapFindFreeEntry();
        if (position == NOT_FOUND) {
          // No free slots, exit. FIXME (dave) return;
        }
        else {
          // Insert the first frame of the fast message
          MapInsertEntry(header, canSocketFrame.data, position, bReady);
        }
      }
      else {
        // An existing fast message is present, append the frame
        MapAppendEntry(header, canSocketFrame.data, position, bReady);
      }
    } else {
      // This is a single frame message, parse it
      bReady = true;
    }
    if (bReady) {
      //auto buffer = std::make_shared<std::vector<unsigned char>>();
      std::vector<unsigned char> vec;

      if (position >= 0) {
        // Re-assembled fast message
        PushFastMsgFragment(vec, header, position);
      } else {
        // Single frame message
        PushCompleteMsg(vec, header, position, canSocketFrame);
      }

      auto name = static_cast<uint64_t>(header.pgn);
      auto src_addr = m_pParentDriver->GetAddress(name);
      auto buffer = std::make_shared<std::vector<unsigned char>>(vec);
      auto msg = std::make_unique<const Nmea2000Msg>(header.pgn, *buffer, src_addr);
      m_pParentDriver->m_listener.Notify(std::move(msg));
    }  // bReady
  } // while

  // thread_exit:
  m_pParentDriver->SetSecThreadInActive();  // I am dead
  m_pParentDriver->m_Thread_run_flag = -1;

  return 0;
}

// Checks whether a frame is a single frame message or multiframe Fast Packet
// message
bool CommDriverN2KSocketCANThread::IsFastMessage(const CanHeader header) {
  static const std::vector<unsigned> haystack = {
      // All known multiframe fast messages
      65240u,  126208u, 126464u, 126996u, 126998u, 127233u, 127237u, 127489u,
      127496u, 127506u, 128275u, 129029u, 129038u, 129039u, 129040u, 129041u,
      129284u, 129285u, 129540u, 129793u, 129794u, 129795u, 129797u, 129798u,
      129801u, 129802u, 129808u, 129809u, 129810u, 130065u, 130074u, 130323u,
      130577u, 130820u, 130822u, 130824u};

  unsigned needle = static_cast<unsigned>(header.pgn);
  auto found = std::find_if(haystack.begin(), haystack.end(),
                            [needle](unsigned i) { return i == needle; });
  return found != haystack.end();
}

// Determine whether an entry with a matching header & sequence ID exists.
// If not, then assume this is the first frame of a multi-frame Fast Message
int CommDriverN2KSocketCANThread::MapFindMatchingEntry(
    const CanHeader header, const unsigned char sid) {
  for (int i = 0; i < CONST_MAX_MESSAGES; i++) {
    if (((sid & 0xE0) == (fastMessages[i].sid & 0xE0)) &&
        (fastMessages[i].isFree == FALSE) &&
        (fastMessages[i].header.pgn == header.pgn) &&
        (fastMessages[i].header.source == header.source) &&
        (fastMessages[i].header.destination == header.destination)) {
      return i;
    }
  }
  return NOT_FOUND;
}

// Find first free entry in fastMessages
int CommDriverN2KSocketCANThread::MapFindFreeEntry(void) {
  for (int i = 0; i < CONST_MAX_MESSAGES; i++) {
    if (fastMessages[i].isFree == TRUE) {
      return i;
    }
  }
  // Could also run the Garbage Collection routine in a separate thread, would
  // require locking etc. But this will look for stale entries in case there are
  // no free entries If there are no free entries, then indicative that we are
  // receiving more Fast messages than I anticipated.
  int staleEntries;
  staleEntries = MapGarbageCollector();
  if (staleEntries == 0) {
    return NOT_FOUND;
    // FIXME (dave) Log this so as to increase the number of FastMessages that
    // may be received
    //  wxLogError(_T("socketCan Device, No free entries in Fast Message Map"));
  } else {
    return MapFindFreeEntry();
  }
}

int CommDriverN2KSocketCANThread::MapGarbageCollector(void) {
  int staleEntries;
  staleEntries = 0;
  for (int i = 0; i < CONST_MAX_MESSAGES; i++) {
    if ((fastMessages[i].isFree == FALSE) &&
        (GetTimeInMicroseconds() - fastMessages[i].timeArrived >
         CONST_TIME_EXCEEDED)) {
      staleEntries++;
      free(fastMessages[i].data);
      fastMessages[i].isFree = TRUE;
    }
  }
  return staleEntries;
}

// Insert the first message of a sequence of fast messages
void CommDriverN2KSocketCANThread::MapInsertEntry(const CanHeader header,
                                                  const unsigned char* data,
                                                  const int position,
                                                  bool& bReady) {
  // first message of fast packet
  // data[0] Sequence Identifier (sid)
  // data[1] Length of data bytes
  // data[2..7] 6 data bytes

  // Ensure that this is indeed the first frame of a fast message
  if ((data[0] & 0x1F) == 0) {
    int totalDataLength;  // will also include padding as we memcpy all of the
                          // frame, because I'm lazy
    totalDataLength = (unsigned int)data[1];
    totalDataLength += 7 - ((totalDataLength - 6) % 7);

    fastMessages[position].sid = (unsigned int)data[0];
    fastMessages[position].expectedLength = (unsigned int)data[1];
    fastMessages[position].header = header;
    fastMessages[position].timeArrived = GetTimeInMicroseconds();
    ;
    fastMessages[position].isFree = FALSE;
    fastMessages[position].data = (unsigned char*)malloc(totalDataLength);
    memcpy(&fastMessages[position].data[0], &data[2], 6);
    // First frame of a multi-frame Fast Message contains six data bytes.
    // Position the cursor ready for next message
    fastMessages[position].cursor = 6;

    // Fusion, using fast messages to sends frames less than eight bytes
    if (fastMessages[position].expectedLength <= 6) {
      bReady = true;
    }
  }
  // No further processing is performed if this is not a start frame.
  // A start frame may have been dropped and we received a subsequent frame
}

// Append subsequent messages of a sequence of fast messages
// Subsequent messages of fast packet
// data[0] Sequence Identifier (sid)
// data[1..7] 7 data bytes
int CommDriverN2KSocketCANThread::MapAppendEntry(const CanHeader header,
                                                 const unsigned char* data,
                                                 const int position,
                                                 bool& bReady) {
  // Check that this is the next message in the sequence
  bReady = false;
  if ((fastMessages[position].sid + 1) == data[0]) {
    memcpy(&fastMessages[position].data[fastMessages[position].cursor],
           &data[1], 7);
    fastMessages[position].sid = data[0];
    // Subsequent messages contains seven data bytes (last message may be padded
    // with 0xFF)
    fastMessages[position].cursor += 7;
    // Is this the last message ?
    if (fastMessages[position].cursor >=
        fastMessages[position].expectedLength) {
      // Mark as ready for further processing
      bReady = true;
    }
    return TRUE;
  } else if ((data[0] & 0x1F) == 0) {
    // We've found a matching entry, however this is a start frame, therefore
    // we've missed an end frame, and now we have a start frame with the same id
    // (top 3 bits). The id has obviously rolled over. Should really double
    // check that (data[0] & 0xE0) Clear the entry as we don't want to leak
    // memory, prior to inserting a start frame
    free(fastMessages[position].data);
    fastMessages[position].isFree = TRUE;
    fastMessages[position].data = NULL;
    // And now insert it
    MapInsertEntry(header, data, position, bReady);
    // FIXME (dave) Should update the dropped frame stats
    return TRUE;
  } else {
    // This is not the next frame in the sequence and not a start frame
    // We've dropped an intermedite frame, so free the slot and do no further
    // processing
    free(fastMessages[position].data);
    fastMessages[position].isFree = TRUE;
    fastMessages[position].data = NULL;
    // Dropped Frame Statistics
    if (droppedFrames == 0) {
      droppedFrameTime = wxDateTime::Now();
      droppedFrames += 1;
    } else {
      droppedFrames += 1;
    }
    // FIXME (dave)
    //     if ((droppedFrames > CONST_DROPPEDFRAME_THRESHOLD) &&
    //     (wxDateTime::Now() < (droppedFrameTime +
    //     wxTimeSpan::Seconds(CONST_DROPPEDFRAME_PERIOD) ) ) ) {
    //       wxLogError(_T("TwoCan Device, Dropped Frames rate exceeded"));
    //       wxLogError(wxString::Format(_T("Frame: Source: %d Destination: %d
    //       Priority: %d PGN: %d"),header.source, header.destination,
    //       header.priority, header.pgn)); droppedFrames = 0;
    //     }
    return FALSE;
  }
}

// Initialize each entry in the Fast Message Map
void CommDriverN2KSocketCANThread::MapInitialize(void) {
  for (int i = 0; i < CONST_MAX_MESSAGES; i++) {
    fastMessages[i].isFree = TRUE;
    fastMessages[i].data = NULL;
  }
}

#endif
#endif
