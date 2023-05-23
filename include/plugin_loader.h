/***************************************************************************
 *
 *
 * Project:  OpenCPN
 * Purpose:  PlugIn Manager Object
 * Author:   David Register
 *
 ***************************************************************************
 *   Copyright (C) 2010-2023 by David S. Register                          *
 *   Copyright (C) 2023 Alec Leamas
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

#ifndef PLUGIN_LOADER_H_GUARD
#define PLUGIN_LOADER_H_GUARD

#include <functional>

#include <wx/wx.h>
#include <wx/bitmap.h>
#include <wx/dynarray.h>
#include <wx/dynlib.h>

#include "config.h"

#include "catalog_parser.h"
#include "observable_evtvar.h"
#include "ocpn_plugin.h"
#include "plugin_blacklist.h"
#include "semantic_vers.h"


enum class PluginStatus {
  System,     //!< One of the four system plugins, unmanaged.
  Managed,    //!< Managed by installer.
  Unmanaged,  //!< Unmanaged, probably a package.
  Ghost,      //!< Managed, shadowing another (packaged?) plugin.
  Unknown,
  LegacyUpdateAvailable,
  ManagedInstallAvailable,
  ManagedInstalledUpdateAvailable,
  ManagedInstalledCurrentVersion,
  ManagedInstalledDowngradeAvailable,
  PendingListRemoval
};

class PlugInContainer;  // forward

/** Basic data for a loaded plugin, trivially copyable */
class PlugInData {
public:
  /** Create a container with applicable fields defined from metadata. */
  explicit PlugInData(const PluginMetadata& md);

  /** "Downcast" a PlugInContainer to a PlugInData. */
  explicit PlugInData(const PlugInContainer& pic);

  PlugInData();

  bool m_bEnabled;
  bool m_bInitState;
  bool m_bToolboxPanel;
  int m_cap_flag;                    //!< PlugIn Capabilities descriptor
  wxString m_plugin_file;            //!< The full file path
  wxString m_plugin_filename;        //!< The short file path
  wxDateTime m_plugin_modification;  //!< used to detect upgraded plugins
  wxString m_common_name;            //!< A common name string for the plugin
  wxString m_short_description;
  wxString m_long_description;
  int m_api_version;
  int m_version_major;
  int m_version_minor;
  PluginStatus m_pluginStatus;
  PluginMetadata m_ManagedMetadata;
  wxBitmap* m_bitmap;
  wxString m_version_str;  //!< Complete version as of semantic_vers
  std::string m_InstalledManagedVersion;  //!< As detected from manifest
  opencpn_plugin* m_pplugin;

  /** sort key. */
  std::string Key() const;
};

/**
 * Data for a loaded plugin, including dl-loaded library.
 * Due to the library it is not copyable.
 */
class PlugInContainer : public PlugInData {
public:
  PlugInContainer();

  ~PlugInContainer() { delete m_bitmap; }

  wxDynamicLibrary m_library;
  destroy_t* m_destroy_fn;
};

class LoadError {
public:
  enum class Type {
    Unloadable,  //<! wrong magic, wrong type of binary...
    Unreadable,
    Incompatible,
    NoCreate,   //<! Missing linkage (is this a plugin?)
    NoDestroy,  //<! Missing linkage (is this a plugin?)
    Blacklisted
  } type;
  const std::string lib_path;            //<! Complete path to failing library
  //<! As determined from plugin API
  const SemanticVersion plugin_version;  //<! As determined from plugin API

  LoadError(Type t, const std::string& l, SemanticVersion pv)
      : type(t), lib_path(l),  plugin_version(pv) {}


  LoadError(Type t, std::string l)
      : type(t),
        lib_path(std::move(l)),
        plugin_version(SemanticVersion()) {}
};

//    Declare an array of PlugIn Containers
WX_DEFINE_ARRAY_PTR(PlugInContainer*, ArrayOfPlugIns);

/**
 * PluginLoader is a backend module without any direct GUI functionality.
 * Instead, it generates events listed here. Each event is mirrored by a
 * public variable, by convention having the same name in lower case.
 *
 * The general usage pattern to process events, here using EVT_LOAD_PLUGIN:
 *
 *   PluginLoader::getInstance()->evt_load_plugin.listen(this, EVT_LOAD_PLUGIN)
 *   Bind(EVT_LOAD_PLUGIN, [&](ObservedEvt ev) {
 *          code to run on event...
 *   });
 *
 * The code in plugin_loader uses evt_load_plugin.Notify() to trigger the
 * event. Notify() might have a string or void* argument; these are
 * available as ev.GetString() or ev.GetClientData() in the Bind() lambda
 * function. There is a also a generic std::shared_ptr available as using
 * GetSharedPtr();
 *
 * Examples: PlugInManager::PlugInManager() in pluginmanager.cpp
 */
class PluginLoader {
public:
  static PluginLoader* getInstance();
  virtual ~PluginLoader() = default;

  EventVar evt_blacklisted_plugin;

  EventVar evt_load_directory;
  EventVar evt_load_plugin;
  EventVar evt_plugin_unload;
  EventVar evt_pluglist_change;
  EventVar evt_unreadable_plugin;

  /**
   *  Carries a malloc'ed read-only copy of a PlugInContainer owned by listener.
   */
  EventVar evt_deactivate_plugin;

  EventVar evt_update_chart_types;

  /**
   * Emitted after all plugins are loaded. Event carries
   * a std::vector<LoadError> available though GetSharedPtr()
   */
  EventVar evt_plugin_loadall_finalize;

  EventVar evt_version_incompatible_plugin;

  /**
   * Update catalog with imported metadata and load all plugin library files.
   *
   * @param enabled_plugins If true, only load enabled plugins
   * @return false on load errors, else true.
   */
  bool LoadAllPlugIns(bool enabled_plugins);

  void SetPluginDefaultIcon(const wxBitmap* bitmap);

  /** Callback invoked in late stage on deactivating a plugin. */
  void SetOnDeactivateCb(std::function<void(const PlugInContainer*)> cb) {
    m_on_deactivate_cb = cb;
  }


  /** Remove a plugin from *GetPluginArray().  */
  void RemovePlugin(const PlugInData& pd);

  /** Sort GetPluginArray(). */
  void SortPlugins(int (*cmp_func)(PlugInContainer**, PlugInContainer**));

  /** Unload, delete and remove item ix in GetPlugInArray(). */
  bool UnLoadPlugIn(size_t ix);

  bool UnLoadAllPlugIns();
  bool DeactivateAllPlugIns();
  bool DeactivatePlugIn(PlugInContainer* pic);
  bool DeactivatePlugIn(const PlugInData& pic);
  bool UpdatePlugIns();
  void UpdateManagedPlugins();
  PlugInContainer* LoadPlugIn(const wxString& plugin_file);
  PlugInContainer* LoadPlugIn(const wxString& plugin_file, PlugInContainer* pic);

  const ArrayOfPlugIns* GetPlugInArray() { return &plugin_array; }
  bool IsPlugInAvailable(const wxString& commonName);
  bool CheckPluginCompatibility(const wxString& plugin_file);

private:
  PluginLoader();
  bool LoadPlugInDirectory(const wxString& plugin_dir, bool load_enabled);
  bool LoadPluginCandidate(const wxString& file_name, bool load_enabled);
  std::unique_ptr<AbstractBlacklist> m_blacklist;
  ArrayOfPlugIns plugin_array;
  wxString m_last_error_string;
  wxString m_plugin_location;
  const wxBitmap* m_default_plugin_icon;
  std::function<void(const PlugInContainer*)> m_on_deactivate_cb;

  std::vector<LoadError> load_errors;
};

#endif  // PLUGIN_LOADER_H_GUARD
