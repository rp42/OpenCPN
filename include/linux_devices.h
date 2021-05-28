/***************************************************************************
 *
 * Project:  OpenCPN
 * Purpose:  Low-level USB device management
 * Author:   Alec Leamas
 *
 ***************************************************************************
 *   Copyright (C) 2011 Alec Leamas                                        *
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
#ifndef LINUX_DEVICES_H
#define LINUX_DEVICES_H

#include <string>

#include "config.h"

typedef struct usbdata {
    std::string vendor_id;
    std::string product_id;
    std::string vendor;
    std::string product;
    std::string serial_nr;

    usbdata(const std::string& v, const std::string& p, const char* s = 0)
        :vendor_id(v), product_id(p), serial_nr(s ? s : "") {}
    bool is_ok() { return vendor_id.length() > 0; }
} usbdata;

bool is_dongle_permissions_wrong();
bool is_device_permissions_ok(const char* path);

std::string get_dongle_rule();
std::string make_udev_link();
std::string get_device_rule(const char* device, const char* symlink);


#endif
