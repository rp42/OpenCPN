/***************************************************************************
 *
 * Project:  OpenCPN
 * Purpose:  NMEA Data Multiplexer Object
 * Author:   David Register
 *
 ***************************************************************************
 *   Copyright (C) 2010 by David S. Register                               *
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

#ifndef _COMMN0183_OUT_H
#define _COMMN0183_OUT_H


#include "wx/wxprec.h"

#ifndef WX_PRECOMP
#include "wx/wx.h"
#endif  // precompiled headers

#include "pluginmanager.h"  // for PlugInManager

class RoutePoint;
class Route;
class SendToGpsDlg;
class ConnectionParams;


//      Garmin interface private error codes
#define ERR_GARMIN_INITIALIZE -1
#define ERR_GARMIN_GENERAL -2

class CommN0183Out : public wxEvtHandler {
public:
  CommN0183Out();
  ~CommN0183Out();

  void SendNMEAMessage(const wxString &msg);

  int SendRouteToGPS(Route *pr, const wxString &com_name, bool bsend_waypoints,
                     SendToGpsDlg *dialog);
  int SendWaypointToGPS(RoutePoint *prp, const wxString &com_name,
                        SendToGpsDlg *dialog);

private:


  //      A set of temporarily saved parameters
  const ConnectionParams *params_save;
};
#endif  // _COMMN0183_OUT_H
