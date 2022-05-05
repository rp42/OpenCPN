/*************************************************************************
 *
 * Project: OpenCPN
 * Purpose: Implement observable.h
 *
 * Copyright (C) 2022 Alec Leamas
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the
 * Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,  USA.
 **************************************************************************/

#include <atomic>
#include <sstream>

#include <wx/log.h>

#include "config_var.h"

namespace ocpn {

std::string ptr_key(const void* ptr) {
  std::ostringstream oss;
  oss << ptr;
  return oss.str();
}

/**
 * Add >> support for wxString, for some reason missing in wxWidgets 3.0,
 * required by ConfigVar::get()
 */
std::istream& operator>>(std::istream& input, wxString& ws) {
  std::string s;
  input >> s;
  ws.Append(s);
  return input;
}

SingletonVar* SingletonVar::getInstance(const std::string& key) {
  static std::unordered_map<std::string, SingletonVar*> instances;

  if (instances.find(key) == instances.end()) {
    instances[key] = new SingletonVar();
  }
  return instances[key];
}


/* ObservedVar implementation. */

void ObservedVar::listen(wxEvtHandler* listener, wxEventType ev_type) {
  const auto& listeners = singleton->listeners;
  if (listeners.find(listener) != listeners.end())
    wxLogWarning("Duplicate window listener %",  listener);
  singleton->listeners[listener] = ev_type;
}

bool ObservedVar::unlisten(wxEvtHandler* listener) {
  auto& listeners = singleton->listeners;
  if (listeners.find(listener) == listeners.end()) return false;
  listeners.erase(listener);
  return true;
}

const void ObservedVar::notify(const std::string& s, void* client_data) {
  auto& listeners = singleton->listeners;
  for (auto l = listeners.begin(); l != listeners.end(); l++) {
    wxCommandEvent ev(l->second);
    ev.SetClientData(client_data);
    ev.SetString(s);
    wxPostEvent(l->first, ev);
  }
}

const void ObservedVar::notify() { notify("", 0); }

using Listener = ObservedVar::Listener;

Listener ObservedVar::get_listener(wxEvtHandler* eh, wxEventType ev) {
  return Listener(new ObservedVarListener(*this, eh, ev));
}


/* EventVar implementation. */

std::string EventVar::autokey() {
  static  std::atomic<unsigned long> last_ix(0);
  return std::string("!@%/+") + std::to_string(last_ix++);
}


/* ConfigVar implementation. */

template <typename T>
ConfigVar<T>::ConfigVar(const std::string& section_, const std::string& key_,
                        wxConfigBase* cb)
    : ObservedVar(section_ + "/" + key_),
      section(section_),
      key(key_),
      config(cb) {}

template <typename T>
const T ConfigVar<T>::get(const T& default_val) {
  std::istringstream iss;
  config->SetPath(section);
  auto value = config->Read(key, "").ToStdString();
  iss.str(value);
  T r;
  iss >> r;
  return iss.fail() ? default_val : r;
}

template <typename T>
void ConfigVar<T>::set(const T& arg) {
  std::ostringstream oss;
  oss << arg;
  if (oss.fail()) {
    wxLogWarning("Cannot dump failed buffer for key %s:%s", section.c_str(),
                 key.c_str());
    return;
  }
  config->SetPath(section);
  if (!config->Write(key.c_str(), oss.str().c_str())) {
    wxLogWarning("Error writing buffer to key %s:%s", section.c_str(),
                 key.c_str());
  }
  ObservedVar::notify();
}

/* Explicitly instantiate the types we support. */
template class ConfigVar<bool>;
template class ConfigVar<double>;
template class ConfigVar<int>;
template class ConfigVar<std::string>;
template class ConfigVar<wxString>;

}  // namespace ocpn
