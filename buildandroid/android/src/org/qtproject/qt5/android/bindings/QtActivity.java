/*
    Copyright (c) 2012-2013, BogDan Vatra <bogdan@kde.org>
    Contact: http://www.qt-project.org/legal

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.qtproject.qt5.android.bindings;

import com.arieslabs.assetbridge.Assetbridge;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.concurrent.Semaphore;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import android.util.Base64;
import java.util.Locale ;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import android.net.Uri;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStreamWriter;

import com.google.android.gms.common.GoogleApiAvailability;

import org.kde.necessitas.ministro.IMinistro;
import org.kde.necessitas.ministro.IMinistroCallback;

//import android.app.DialogFragment;
import android.support.v4.app.DialogFragment;

import android.support.v4.app.FragmentManager;

import android.os.SystemClock;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Environment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.DialogInterface.OnCancelListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.ContextThemeWrapper;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.content.IntentFilter;
import android.app.PendingIntent;
import android.net.ConnectivityManager;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.*;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.DisplayMetrics;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.webkit.WebView;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.Display;
import android.view.MenuInflater;
import android.view.InputDevice;
import android.view.LayoutInflater ;

import dalvik.system.DexClassLoader;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.Settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Handler;


import org.opencpn.opencpn.R;

//ANDROID-11
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
//ANDROID-11

import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import java.util.concurrent.atomic.AtomicReference;

import android.bluetooth.BluetoothAdapter;

import org.opencpn.GPSServer;
import org.opencpn.OCPNNativeLib;

import org.qtproject.qt5.android.QtNative;
import org.qtproject.qt5.android.QtActivityDelegate;

import android.bluetooth.BluetoothDevice;
import org.opencpn.BTScanHelper;
import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.BluetoothSPP.OnDataReceivedListener;

import org.opencpn.SpinnerNavItem;
import org.opencpn.TitleNavigationAdapter;
import org.opencpn.WebViewActivity;

import ar.com.daidalos.afiledialog.*;

import org.opencpn.UsbSerialHelper;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.ResultReceiver;

import org.opencpn.DownloadService;
import org.opencpn.OCPNResultReceiver;
import org.opencpn.OCPNResultReceiver.Receiver;
import android.support.v4.provider.DocumentFile;
import org.opencpn.UnzipService;

import com.caverock.androidsvg.SVG;
import android.graphics.Bitmap;

import android.support.v4.provider.DocumentFile;
import android.provider.OpenableColumns;
import android.provider.MediaStore;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetManager;
import java.util.Timer;
import java.util.TimerTask;

import org.opencpn.opencpn.ColorPickerDialog;

public class QtActivity extends FragmentActivity implements ActionBar.OnNavigationListener, Receiver
{
    private final static int MINISTRO_INSTALL_REQUEST_CODE = 0xf3ee; // request code used to know when Ministro instalation is finished
    private final static int OCPN_SETTINGS_REQUEST_CODE = 0xf3ef; // request code used to know when OCPNsettings dialog activity is done
    private final static int OCPN_GOOGLEMAPS_REQUEST_CODE = 0xf3ed; // request code used to know when GoogleMaps activity is done
    private final static int OCPN_GRIB_REQUEST_CODE = 0xf3ec; // request code used to know when OCPNGRIB activity is done

    private static final int MINISTRO_API_LEVEL = 4; // Ministro api level (check IMinistro.aidl file)
    private static final int NECESSITAS_API_LEVEL = 2; // Necessitas api level used by platform plugin
    private static final int QT_VERSION = 0x050100; // This app requires at least Qt version 5.1.0

    private final static int OCPN_FILECHOOSER_REQUEST_CODE = 0x5555;
    private final static int OCPN_AFILECHOOSER_REQUEST_CODE = 0x5556;
    private final static int OCPN_ARBITRARY_REQUEST_CODE = 0x5557;
    private final static int OCPN_SAF_DIALOG_A_REQUEST_CODE = 0x5558;

    private final static int OCPN_ACTION_FOLLOW = 0x1000;
    private final static int OCPN_ACTION_ROUTE = 0x1001;
    private final static int OCPN_ACTION_RMD = 0x1002;
    private final static int OCPN_ACTION_SETTINGS_BASIC = 0x1003;
    private final static int OCPN_ACTION_SETTINGS_EXPERT = 0x1004;
    private final static int OCPN_ACTION_TRACK_TOGGLE = 0x1005;
    private final static int OCPN_ACTION_MOB = 0x1006;
    private final static int OCPN_ACTION_TIDES_TOGGLE = 0x1007;
    private final static int OCPN_ACTION_CURRENTS_TOGGLE = 0x1008;
    private final static int OCPN_ACTION_ENCTEXT_TOGGLE = 0x1009;
    private final static int OCPN_ACTION_TRACK_ON = 0x100a;
    private final static int OCPN_ACTION_TRACK_OFF = 0x100b;
    private final static int OCPN_ACTION_ENCSOUNDINGS_TOGGLE = 0x100c;
    private final static int OCPN_ACTION_ENCLIGHTS_TOGGLE = 0x100d;


    //  Definitions found in OCPN "chart1.h"
    private final static int ID_CMD_APPLY_SETTINGS = 300;
    private final static int ID_CMD_NULL_REFRESH = 301;
    private final static int ID_CMD_TRIGGER_RESIZE  = 302;
    private final static int ID_CMD_SETVP = 303;
    private final static int ID_CMD_POST_JSON_TO_PLUGINS = 304;
    private final static int ID_CMD_SET_LOCALE = 305;

    private final static int CHART_TYPE_CM93COMP = 7;       // must line up with OCPN types
    private final static int CHART_FAMILY_RASTER = 1;
    private final static int CHART_FAMILY_VECTOR = 2;


    private static final String ERROR_CODE_KEY = "error.code";
    private static final String ERROR_MESSAGE_KEY = "error.message";
    private static final String DEX_PATH_KEY = "dex.path";
    private static final String LIB_PATH_KEY = "lib.path";
    private static final String LOADER_CLASS_NAME_KEY = "loader.class.name";
    private static final String NATIVE_LIBRARIES_KEY = "native.libraries";
    private static final String ENVIRONMENT_VARIABLES_KEY = "environment.variables";
    private static final String APPLICATION_PARAMETERS_KEY = "application.parameters";
    private static final String BUNDLED_LIBRARIES_KEY = "bundled.libraries";
    private static final String BUNDLED_IN_LIB_RESOURCE_ID_KEY = "android.app.bundled_in_lib_resource_id";
    private static final String BUNDLED_IN_ASSETS_RESOURCE_ID_KEY = "android.app.bundled_in_assets_resource_id";
    private static final String MAIN_LIBRARY_KEY = "main.library";
    private static final String STATIC_INIT_CLASSES_KEY = "static.init.classes";
    private static final String NECESSITAS_API_LEVEL_KEY = "necessitas.api.level";

    /// Ministro server parameter keys
    private static final String REQUIRED_MODULES_KEY = "required.modules";
    private static final String APPLICATION_TITLE_KEY = "application.title";
    private static final String MINIMUM_MINISTRO_API_KEY = "minimum.ministro.api";
    private static final String MINIMUM_QT_VERSION_KEY = "minimum.qt.version";
    private static final String SOURCES_KEY = "sources";               // needs MINISTRO_API_LEVEL >=3 !!!
                                                                       // Use this key to specify any 3rd party sources urls
                                                                       // Ministro will download these repositories into their
                                                                       // own folders, check http://community.kde.org/Necessitas/Ministro
                                                                       // for more details.

    private static final String REPOSITORY_KEY = "repository";         // use this key to overwrite the default ministro repsitory
    private static final String ANDROID_THEMES_KEY = "android.themes"; // themes that your application uses


    public String APPLICATION_PARAMETERS = null; // use this variable to pass any parameters to your application,
                                                               // the parameters must not contain any white spaces
                                                               // and must be separated with "\t"
                                                               // e.g "-param1\t-param2=value2\t-param3\tvalue3"

    public String ENVIRONMENT_VARIABLES = "QT_USE_ANDROID_NATIVE_STYLE=1\tQT_USE_ANDROID_NATIVE_DIALOGS=1\t";
                                                               // use this variable to add any environment variables to your application.
                                                               // the env vars must be separated with "\t"
                                                               // e.g. "ENV_VAR1=1\tENV_VAR2=2\t"
                                                               // Currently the following vars are used by the android plugin:
                                                               // * QT_USE_ANDROID_NATIVE_STYLE - 1 to use the android widget style if available.
                                                               // * QT_USE_ANDROID_NATIVE_DIALOGS -1 to use the android native dialogs.

    public String[] QT_ANDROID_THEMES = null;     // A list with all themes that your application want to use.
                                                  // The name of the theme must be the same with any theme from
                                                  // http://developer.android.com/reference/android/R.style.html
                                                  // The most used themes are:
                                                  //  * "Theme" - (fallback) check http://developer.android.com/reference/android/R.style.html#Theme
                                                  //  * "Theme_Black" - check http://developer.android.com/reference/android/R.style.html#Theme_Black
                                                  //  * "Theme_Light" - (default for API <=10) check http://developer.android.com/reference/android/R.style.html#Theme_Light
                                                  //  * "Theme_Holo" - check http://developer.android.com/reference/android/R.style.html#Theme_Holo
                                                  //  * "Theme_Holo_Light" - (default for API 11-13) check http://developer.android.com/reference/android/R.style.html#Theme_Holo_Light
                                                  //  * "Theme_DeviceDefault" - check http://developer.android.com/reference/android/R.style.html#Theme_DeviceDefault
                                                  //  * "Theme_DeviceDefault_Light" - (default for API 14+) check http://developer.android.com/reference/android/R.style.html#Theme_DeviceDefault_Light

    public String QT_ANDROID_DEFAULT_THEME = null; // sets the default theme.

    private static Activity m_activity = null;

    private static final int INCOMPATIBLE_MINISTRO_VERSION = 1; // Incompatible Ministro version. Ministro needs to be upgraded.
    private static final int BUFFER_SIZE = 1024;

    private ActivityInfo m_activityInfo = null; // activity info object, used to access the libs and the strings
    private DexClassLoader m_classLoader = null; // loader object
    private String[] m_sources = {"https://download.qt-project.org/ministro/android/qt5/qt-5.2"}; // Make sure you are using ONLY secure locations
    private String m_repository = "default"; // Overwrites the default Ministro repository
                                                        // Possible values:
                                                        // * default - Ministro default repository set with "Ministro configuration tool".
                                                        // By default the stable version is used. Only this or stable repositories should
                                                        // be used in production.
                                                        // * stable - stable repository, only this and default repositories should be used
                                                        // in production.
                                                        // * testing - testing repository, DO NOT use this repository in production,
                                                        // this repository is used to push a new release, and should be used to test your application.
                                                        // * unstable - unstable repository, DO NOT use this repository in production,
                                                        // this repository is used to push Qt snapshots.
    private String[] m_qtLibs = null; // required qt libs

    private String m_filesDir = "";
    public FragmentManager fm;

    private DownloadManager m_dm;
    private long m_enqueue;

    private static ActivityManager activityManager;

    private Float lastX;
    private Float lastY;

    private Boolean m_activityARBComplete = false;
    private String m_activityArbResult;
    private String m_arbResultStringName;           // name of string result expected

    private Boolean m_GPSServiceStarted = false;
    private GPSServer m_GPSServer;

    public ProgressDialog ringProgressDialog;
    public boolean m_hasGPS;
    private boolean m_backButtonEnable = true;

    private BTScanHelper scanHelper;
    private Boolean m_ScanHelperStarted = false;
    private BluetoothSPP m_BTSPP;
    private Boolean m_BTServiceCreated = false;
    private String m_BTStat;
    private Boolean m_FileChooserDone = false;
    private String m_filechooserString;

    private Boolean m_ColorDialogDone = false;
    private String m_ColorDialogString;

    private String m_downloadRet = "";

    public OCPNResultReceiver mReceiver;

    OCPNNativeLib nativeLib;

    private String m_GRIBReturn;

    private UsbSerialHelper uSerialHelper;

    // action bar
    private ActionBar actionBar;
    private boolean optionsMenuEnabled = true;

        // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;
    private SpinnerNavItem spinnerItemRaster;
    private SpinnerNavItem spinnerItemVector;
    private SpinnerNavItem spinnerItemcm93;

        // Navigation adapter
    private TitleNavigationAdapter adapter;

        // Menu item used to indicate "RouteCreate" is active
    MenuItem itemRouteAnnunciator;
    MenuItem itemRouteMenuItem;
    private boolean m_showRouteAnnunciator = false;

    MenuItem itemFollowInActive;
    MenuItem itemFollowActive;
    private boolean m_isFollowActive = false;

    MenuItem itemTrackInActive;
    MenuItem itemTrackActive;
    private boolean m_isTrackActive = false;

    private static AudioManager audioManager;
    private MediaPlayer mediaPlayer; // The media player to play the sounds, even in background

    BroadcastReceiver downloadBCReceiver = null;

    private double m_gminitialLat;
    private double m_gminitialLon;
    private double m_gminitialZoom;

    private boolean m_fullScreen;
    private String m_scannedSerial = "";

    public taskHandler m_taskHandler;
    public MyDocSpinnerDialog myDocSpinnerInstance;

    private String g_postResult = "";
    private boolean g_postActive = false;
    PostTask g_postTask;

    //BroadcastReceiver which receives broadcasted Intents
    private final BroadcastReceiver mLocaleChangeReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("OpenCPN", "mLocaleChangeReceiver");

                final String action = intent.getAction();
                Log.i("OpenCPN", "onLocaleChange: " + action);
                String language = getCurrentAndroidLocale().getLanguage();
                Log.i("OpenCPN", "  new language is: " + language);

                setAppLocale(getCurrentAndroidLocale());
            }
    };

    public Locale getCurrentAndroidLocale(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            return getResources().getConfiguration().getLocales().get(0);
//        }
//        else
        {
            //noinspection deprecation
            return getResources().getConfiguration().locale;
        }
    }

    public void setAppLocale( Locale newLocale){
        String lang = newLocale.getLanguage();
        String country = newLocale.getCountry();

        String toSet = lang;
        if(!country.isEmpty())
            toSet += "_" + country;

//        Log.i("OpenCPN", "  setAppLocale new language ID is: " + toSet);

//        nativeLib.invokeCmdEventCmdString( ID_CMD_SET_LOCALE, toSet);

    }



    public String getAndroidLocaleString( ){
        Locale locale  = getCurrentAndroidLocale();
        if(null != locale){
            String lang = locale.getLanguage();
            String country = locale.getCountry();

            String ret = lang;
            if(!country.isEmpty())
                ret += "_" + country;

            Log.i("OpenCPN", "  getAndroidLocaleString language ID is: " + ret);

            return ret;
        }
        else
            return "en_US";

    }


    public QtActivity()
    {
        if (Build.VERSION.SDK_INT <= 10) {
            QT_ANDROID_THEMES = new String[] {"Theme_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_Light";
        }
        else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13) {
            QT_ANDROID_THEMES = new String[] {"Theme_Holo_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_Holo_Light";
        } else {
            QT_ANDROID_THEMES = new String[] {"Theme_DeviceDefault_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_DeviceDefault_Light";
        }
        m_activity = QtActivity.this;


    }


    public String buildSVGIcon(String inFile, String outFile, int width, int height){

//        Log.i("OpenCPN", inFile + " " + outFile);

        int rwidth = width;
        int rheight = height;

        // Read an SVG file
        File file = new File( inFile);
        SVG svg = null;
        if (file.exists()) {
            FileInputStream inStream = null;
            try{
                inStream = new FileInputStream(inFile);
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon Read Stream Exception");
            }

        //SVG  svg = SVG.getFromAsset(getContext().getAssets(), inFile);
            try{
                svg = SVG.getFromInputStream(inStream);
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon SVG Parse ExceptionA");
            }

            //  Inkscape SVG Documents must be saved in "optimized SVG" format, with viewbox enabled....
            // https://code.google.com/archive/p/androidsvg/wikis/FAQ.wiki#My_SVG_won%27t_scale_to_fit_the_canvas_or_my_ImageView
            try{

                if((width < 0) || (height < 0)){
                    rwidth = Math.round(svg.getDocumentWidth());
                    rheight = Math.round(svg.getDocumentHeight());
                    //String report = String.valueOf( rwidth ) + "  " + String.valueOf( rheight );
                    //Log.i("OpenCPN", "buildSVGIcon document size:" + report);

                }

                svg.setDocumentWidth(rwidth);
                svg.setDocumentHeight(rheight);
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon SVG Parse ExceptionB");
            }

        // Create a canvas to draw onto
            if (svg.getDocumentWidth() != -1) {
                Bitmap  newBM = Bitmap.createBitmap(rwidth, rheight, Bitmap.Config.ARGB_8888);
                Canvas  bmcanvas = new Canvas(newBM);

           // Clear background to white
                //bmcanvas.drawRGB(255, 255, 255);

           // Render our document onto our canvas
                svg.renderToCanvas(bmcanvas);

           //  Write the file out
               FileOutputStream out = null;
               try {
                   out = new FileOutputStream(outFile);
                   newBM.compress(Bitmap.CompressFormat.PNG, 100, out);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else{
            Log.i("OpenCPN", "FileNotFound: " + inFile);
            return "FileNotFound";
        }

        return "OK";
    }


    public String enableOptionsMenu(int bEnable){
        Log.i("OpenCPN", "enableOptionsMenu " + bEnable);

        if(bEnable == 1)
            optionsMenuEnabled = true;
        else
            optionsMenuEnabled = false;

        // Can only mess with the UI view if this method is executed from the main UI thread.
        //  Otherwise, provokes a "CalledFromWrongThreadException"
        //  But, for some reason, this code don't work...
/*
        if(Looper.getMainLooper().getThread() == Thread.currentThread())
            invalidateOptionsMenu();
*/
        // So, do this:
        runOnUiThread(new Runnable() {
            public void run() {
                invalidateOptionsMenu();
            }
        });

        return "OK";
    }

    public String showDisclaimerDialog( String title, String message) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // set title
            alertDialogBuilder.setTitle(title);

            // set dialog message
            alertDialogBuilder
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    QtActivity.this.finish();
                            }
                      })
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                            }
                    });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                    return ("OK");

      }

      public String disclaimerDialog( final String title, final String message) {

          final QtActivityDelegate delegate = QtNative.activityDelegate();

          if(null != delegate){
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      showDisclaimerDialog( title, message );

                  }});
          }

          String ret = "OK";
          return ret;
      }


      public String showHTMLAlertDialog( String title, String htmlString) {

          WebView wv = new WebView(getApplicationContext());

          wv.getSettings().setLoadWithOverviewMode(true);
          wv.getSettings().setUseWideViewPort(true);
          wv.getSettings().setMinimumFontSize(50);
          //wv.loadData(htmlString, "text/html", "utf-8");
          wv.loadData(htmlString, "text/html; charset=UTF-8", null);


          AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);

              // set title
          alertDialogBuilder.setTitle(title);

              // set dialog message
          alertDialogBuilder
                      .setView(wv)
                      .setCancelable(false)
                      .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                              public void onClick(DialogInterface dialog,int id) {
                                      // if this button is clicked, just close
                                      // the dialog box and do nothing
                                      dialog.cancel();
                              }
                      });

 //                     alertDialogBuilder.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
 //                             public void onClick(DialogInterface dialog,int id) {
                                      // if this button is clicked, close
                                      // current activity
 //                                     QtActivity.this.finish();
 //                             }
 //                       });

                      // create alert dialog
                      AlertDialog alertDialog = alertDialogBuilder.create();

                      // show it
                      alertDialog.show();

                      return ("OK");

    }

    public String displayHTMLAlertDialog( final String title, final String htmlString) {
        //Log.i("OpenCPN", "displayHTMLAlertDialog" + htmlString);

            final QtActivityDelegate delegate = QtNative.activityDelegate();

            if(null != delegate){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showHTMLAlertDialog( title, htmlString );

                    }});
            }

            String ret = "OK";
            return ret;
    }


    private String m_settingsReturn;

    public class MyDocSpinnerDialog extends DialogFragment {

        ProgressDialog _dialog;

        public MyDocSpinnerDialog() {
            // use empty constructors. If something is needed use onCreate's
        }

        @Override
        public Dialog onCreateDialog(final Bundle savedInstanceState) {

            _dialog = new ProgressDialog(getActivity());
            this.setStyle(STYLE_NO_TITLE, getTheme()); // You can use styles or inflate a view
            _dialog.setMessage("Please stand by while OpenCPN installs the User Manual"); // set your messages if not inflated from XML

            _dialog.setCancelable(false);

            return _dialog;
        }

        public void setMyMessage( String message ){
            if(null != _dialog){
                _dialog.setMessage(message);
            }
        }
    }




    private Context docUnpackContext;

    public String launchHelpView(){
        String dirFiles = m_filesDir;

        // Docs unpacked yet?
        File dc = new File(dirFiles + "/doc/doc/help_en_US.html");
        if(!dc.exists())
        {
            myDocSpinnerInstance = new MyDocSpinnerDialog();
            myDocSpinnerInstance.show(fm, "some_tag");

            Log.i("OpenCPN", "Start UnpackUserManual");

            //Toast.makeText(getApplicationContext(), "Please stand by while OpenCPN configures the User Manual", Toast.LENGTH_LONG).show();
            docUnpackContext = (Context) this;

            Timer T=new Timer();
                 T.schedule(new TimerTask() {
                     @Override
                     public void run() {
                         Log.i("OpenCPN", "Timed Start UnpackUserManual");
                         UnpackUserManual task = new UnpackUserManual(m_filesDir, getAssets(), m_taskHandler, docUnpackContext);
                         task.execute((Void) null);

                     }
                 }, 200);

        }
        else{
            Log.i("OpenCPN", "launch Help WebView");

            Intent intent = new Intent(this, WebViewActivity.class);
            Bundle b = new Bundle();
            b.putString(WebViewActivity.SELECTED_URL, "file:///" + dirFiles + "/doc/doc/help_en_US.html");
            intent.putExtras(b);

            startActivity(intent);
        }

        return "OK";

    }

    public String launchWebView( String url){
        Log.i("OpenCPN", "launchWebView: " + url);

        Intent intent = new Intent(this, WebViewActivity.class);

        Bundle b = new Bundle();
        b.putString(WebViewActivity.SELECTED_URL, url);
        intent.putExtras(b);

        startActivity(intent);
        return "OK";
    }

    public String launchBrowser( String url){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse( url)));
        return "OK";
    }

    public String startActivityWithIntent( String target_package, String activity, String extra_name_in, String extra_data_in, String extra_data_out_name){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(target_package, target_package + "." + activity));
        Log.i("OpenCPN", "startActivityWithIntent: " + target_package + ", " + target_package + "." + activity);

        Bundle b = new Bundle();
        b.putString(extra_name_in, extra_data_in);
        intent.putExtras(b);

        m_activityARBComplete = false;      // Mark the activity as incomplete
        m_arbResultStringName = extra_data_out_name;

        startActivityForResult(intent, OCPN_ARBITRARY_REQUEST_CODE);

        return "OK";
    }

    public String getArbActivityStatus(){
        if(m_activityARBComplete)
            return "COMPLETE";
        else
            return "INCOMPLETE";
    }

    public String getArbActivityResult(){
        return m_activityArbResult;
    }

    private void toggleFullscreen(){
        m_fullScreen = !m_fullScreen;
        setFullscreen(m_fullScreen);
        nativeLib.notifyFullscreenChange(m_fullScreen);
    }

    public void setFullscreen( final boolean bfull){

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if(null != delegate){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    delegate.setFullScreen( bfull );

                }});
        }
    }

    public String setFullscreen( final int bfull){
        setFullscreen(bfull != 0);
        m_fullScreen = (bfull != 0);
        return "OK";
    }


    public String getFullscreen( ){
        if(m_fullScreen)
            return "YES";
        else
            return "NO";
    }

    public String terminateApp(){
        //Log.i("OpenCPN", "terminateApp");
        finish();
        return "";
    }

    public String makeToast( String msg ){
        //Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();

        return "OK";
    }


    public String invokeGoogleMaps(){
        Log.i("DEBUGGER_TAG", "invokeGoogleMaps");


        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNMapsActivity.class);

        String s = nativeLib.getVPCorners();
        if(s.isEmpty()){
            Log.i("DEBUGGER_TAG", "invokeGoogleMaps..Error, empty VPCorners");
            return "66";
        }

        String v = nativeLib.getVPS();
        Log.i("DEBUGGER_TAG", "initialPositionString" + v);

        StringTokenizer tkz = new StringTokenizer(v, ";");

        String initialLat = "";
        String initialLon = "";
        String initialZoom = "";

        if(tkz.hasMoreTokens()){
            initialLat = tkz.nextToken();
            initialLon = tkz.nextToken();
            initialZoom = tkz.nextToken();
        }

        m_gminitialZoom = Double.parseDouble(initialZoom);

        intent.putExtra("VP_CORNERS", s);
        intent.putExtra("VPS", v);

        int height = this.getWindow().getDecorView().getHeight();
        int width = this.getWindow().getDecorView().getWidth();
        intent.putExtra("WIDTH", width);
        intent.putExtra("HEIGHT", height);

        startActivityForResult(intent, OCPN_GOOGLEMAPS_REQUEST_CODE);

        int pss = 55;
        String ret;
        ret = String.format("%d", pss);
        return ret;
    }

    public String doGRIBActivity(String json){
//        Log.i("DEBUGGER_TAG", "doGRIBActivity");
//        Log.i("DEBUGGER_TAG", json);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("GRIB_PREFS_JSON", json);
        editor.apply();

        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNGRIBActivity.class);
        startActivityForResult(intent, OCPN_GRIB_REQUEST_CODE);

        int pss = 666;
        String ret;
        ret = String.format("%d", pss);
        return ret;

    }

    private String getAllFilesResult;
    private String getAllFilesFilespec;

    public void traverse (File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; ++i) {
                File file = files[i];
                if (file.isDirectory()) {
                    traverse(file);
                } else {
                    if(file.getName().matches(getAllFilesFilespec)){

                        //Log.i("OpenCPN", "traverse:File: " + file.getAbsolutePath());
                        getAllFilesResult += file.getAbsolutePath() + ";";
                    }
                }
            }
        }
    }

    public String getAllFilesWithFilespec(String dir, String filespec){
        getAllFilesResult = "";

        int dot_pos = filespec.lastIndexOf (".");
        if( (dot_pos < filespec.length() - 1) && (dot_pos >= 0) ){
            try{
                getAllFilesFilespec = "(.*)[.]" + filespec.substring( dot_pos+1) + "$";
                Log.i("OpenCPN", "getAllFilesWithFilespec " + getAllFilesFilespec );

                File dirt = new File( dir );
                traverse( dirt );
            }
            catch (Exception e) {
                Log.i("OpenCPN", "getAllFilesWithFilespec exception");
                e.printStackTrace();
            }
        }

        return getAllFilesResult;
    }


    public String doAndroidSettings(String settings){
        if(null != uSerialHelper)
            m_scannedSerial = scanSerialPorts( UsbSerialHelper.NOSCAN );      // No scan, just report latest results.

        m_settingsReturn = new String();

        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNSettingsActivity.class);
        intent.putExtra("SETTINGS_STRING",settings);
        intent.putExtra("DETECTEDSERIALPORTS_STRING",m_scannedSerial);
        Log.i("OpenCPN", "doAndroidSettings settings" + settings);
        Log.i("OpenCPN", "doAndroidSettings m_scannedSerial" + m_scannedSerial);

        startActivityForResult(intent, OCPN_SETTINGS_REQUEST_CODE);

        int pss = 55;
        String ret;
        ret = String.format("%d", pss);
        return ret;
    }


    public String checkAndroidSettings(  ){
        return m_settingsReturn;
    }


    public String Executer(String command) {

                Log.i("OpenCPN", "Executor process launched as: [" + command + "]");

                StringBuffer output = new StringBuffer();

                Process p;
                try {
                    p = Runtime.getRuntime().exec(command);
                    p.waitFor();
                    Log.i("OpenCPN", "Executer wait done");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    String line = "";
                    while ((line = reader.readLine())!= null) {
                        output.append(line + "\n");
                    }

                } catch (Exception e) {
                    Log.i("OpenCPN", "Executer exception");
                    e.printStackTrace();
                }
                String response = output.toString();
                return response;

    }

    public String xcreateProc( String cmd ){
        Log.i("OpenCPN", "createProc");

        long pid = 0;
        try
        {
            Process process = Runtime.getRuntime().exec( cmd );

        Log.i("OpenCPN", "Process launched as: {" + cmd + "}");

            Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

            if(process.getClass().getName().equals("java.lang.UNIXProcess")) {
              /* get the PID on unix/linux systems */
              Log.i("OpenCPN", "Fetching PID...");
              try {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                pid = f.getLong( process );
              } catch (Throwable e) {
              }
            }
            else{
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }

        } catch (Exception e) {
            Log.i("OpenCPN", "createProc exception");
            e.printStackTrace();
        }

        String ret = String.valueOf( pid );
        Log.i("OpenCPN", "Process PID: " + ret);
        return ret;
    }

    public String createProc( String cmd, String arg1, String arg2, String libPath ){
        Log.i("OpenCPN", "createProc");
        Log.i("OpenCPN", "cmd: " + cmd);
        Log.i("OpenCPN", "arg1: "  + arg1);
        Log.i("OpenCPN", "arg2: " + arg2);
        Log.i("OpenCPN", "libPath: " + libPath);


        long pid = 0;
        try
        {
            ProcessBuilder pb = new ProcessBuilder( cmd,  arg1,  arg2);

             Map<String, String> env = pb.environment();
             env.put("LD_LIBRARY_PATH", libPath);

             //env.remove("OTHERVAR");
             //env.put("VAR2", env.get("VAR1") + "suffix");

             //pb.directory(new File("myDir"));
             //File log = new File("log");
             //pb.redirectErrorStream(true);
             //pb.redirectOutput(Redirect.appendTo(log));

             Log.i("OpenCPN", "Process launched as: [" + cmd + "]");

             Process process = pb.start();

             Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

             if(process.getClass().getName().equals("java.lang.UNIXProcess")) {
               /* get the PID on unix/linux systems */
               Log.i("OpenCPN", "Fetching PID...");
               try {
                 Field f = process.getClass().getDeclaredField("pid");
                 f.setAccessible(true);
                 pid = f.getLong( process );
               } catch (Throwable e) {
               }
             }
             else{
                 pid = 1;
                 Log.i("OpenCPN", "Process:  unknown Class name");
             }


         } catch (Exception e) {
             Log.i("OpenCPN", "createProcB exception");
             e.printStackTrace();
         }

         String ret = String.valueOf( pid );
         Log.i("OpenCPN", "Process PID: " + ret);
         return ret;

     }


     public String createProcSync( String cmd, String arg1, String arg2, String libPath ){
         Log.i("OpenCPN", "createProc");
         Log.i("OpenCPN", "cmd: " + cmd);
         Log.i("OpenCPN", "arg1: "  + arg1);
         Log.i("OpenCPN", "arg2: " + arg2);
         Log.i("OpenCPN", "libPath: " + libPath);


         long pid = 0;
         try
         {
             ProcessBuilder pb = new ProcessBuilder( cmd,  arg1,  arg2);

              Map<String, String> env = pb.environment();
              env.put("LD_LIBRARY_PATH", libPath);

              //env.remove("OTHERVAR");
              //env.put("VAR2", env.get("VAR1") + "suffix");

              //pb.directory(new File("myDir"));
              //File log = new File("log");
              //pb.redirectErrorStream(true);
              //pb.redirectOutput(Redirect.appendTo(log));

              Log.i("OpenCPN", "Process launched as: [" + cmd + "]");
              Process process = pb.start();

              // Reads stdout.
              // NOTE: You can write to stdin of the command using
              //       process.getOutputStream().
              BufferedReader reader = new BufferedReader(
                      new InputStreamReader(process.getInputStream()));
              int read;
              char[] buffer = new char[4096];
              StringBuffer output = new StringBuffer();
              while ((read = reader.read(buffer)) > 0) {
                  output.append(buffer, 0, read);
              }
              reader.close();
              String result = output.toString();
              Log.i("OpenCPN", "createProcSync stdout output:\n " + result);


              BufferedReader ereader = new BufferedReader(
                      new InputStreamReader(process.getErrorStream()));
              int eread;
              char[] ebuffer = new char[4096];
              StringBuffer eoutput = new StringBuffer();
              while ((eread = ereader.read(ebuffer)) > 0) {
                  eoutput.append(ebuffer, 0, eread);
              }
              ereader.close();

              String eresult = eoutput.toString();
              Log.i("OpenCPN", "createProcSync stderr output:\n " + eresult);


              Log.i("OpenCPN", "\ncreateProcSync Process ClassName: " + process.getClass().getName());

              if(process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                  Field f = process.getClass().getDeclaredField("pid");
                  f.setAccessible(true);
                  pid = f.getLong( process );
                } catch (Throwable e) {
                }
              }
              else{
                  pid = 1;
                  Log.i("OpenCPN", "Process:  unknown Class name");
              }

              process.waitFor();

          } catch (Exception e) {
              Log.i("OpenCPN", "createProcSync exception");
              e.printStackTrace();
          }

          String ret = String.valueOf( pid );
          Log.i("OpenCPN", "createProcSync Process PID: " + ret);
          return ret;

      }


      public String createProcSync4( String cmd, String arg1, String arg2, String arg3, String arg4, String libPath ){
          Log.i("OpenCPN", "createProcSync4");
          Log.i("OpenCPN", "cmd: " + cmd);
          Log.i("OpenCPN", "arg1: " + arg1);
          Log.i("OpenCPN", "arg2: " + arg2);
          Log.i("OpenCPN", "arg3: " + arg3);
          Log.i("OpenCPN", "arg4: " + arg4);
          Log.i("OpenCPN", "libPath: " + libPath);


          long pid = 0;
          try
          {
              ProcessBuilder pb = new ProcessBuilder( cmd,  arg1,  arg2, arg3, arg4);

               Map<String, String> env = pb.environment();
               env.put("LD_LIBRARY_PATH", libPath);


               Log.i("OpenCPN", "Process launched as: [" + cmd + "]");

               Process process = pb.start();

               // Reads stdout.
               BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
               int read;
               char[] buffer = new char[4096];
               StringBuffer output = new StringBuffer();
               while ((read = reader.read(buffer)) > 0) {
                   output.append(buffer, 0, read);
               }
               reader.close();

               String result = output.toString();
               Log.i("OpenCPN", "createProcSync4 cmd output: " + result);

               Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

               if(process.getClass().getName().equals("java.lang.UNIXProcess")) {
                 /* get the PID on unix/linux systems */
                 Log.i("OpenCPN", "Fetching PID...");
                 try {
                   Field f = process.getClass().getDeclaredField("pid");
                   f.setAccessible(true);
                   pid = f.getLong( process );
                 } catch (Throwable e) {
                 }
               }
               else{
                   pid = 1;
                   Log.i("OpenCPN", "Process:  unknown Class name");
               }

               process.waitFor();

           } catch (Exception e) {
               Log.i("OpenCPN", "createProcSync4 exception");
               e.printStackTrace();
           }

           String ret = String.valueOf( pid );
           Log.i("OpenCPN", "Process PID: " + ret);
           return ret;

       }


    public String callFromCpp(){
        Log.i("OpenCPN", "callFromCpp");

        String res = "";
        ///String res = Executer("/data/user/0/org.opencpn.opencpn/oeserverda");
        //String res = Executer("/data/user/0/org.opencpn.opencpn/oeserverda -h");
        //String res = Executer("pwd");
        //String res = Executer("ls -l /data/user/0/org.opencpn.opencpn/lib/*");
        Log.i("OpenCPN", "Process launched");
        Log.i("OpenCPN", "result: " + res);
        return res;
    }



    public String callFromCpp(int pid){
        //Log.i("DEBUGGER_TAG", "callFromCpp");


        MemoryInfo mi = new MemoryInfo();
        int pids[] = new int[1];
        pids[0] = pid;

        android.os.Debug.MemoryInfo[] memoryInfoArray= activityManager.getProcessMemoryInfo( pids );
        int pss = memoryInfoArray[0].getTotalPss();

        String ret;
        ret = String.format("%d", pss);
        return ret;


    }

    public String getMemInfo(int pid){
//        Log.i("DEBUGGER_TAG", "getMemInfo");
        int pids[] = new int[1];
        pids[0] = pid;

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        android.os.Debug.MemoryInfo[] memoryInfoArray= activityManager.getProcessMemoryInfo( pids );
        int pss = memoryInfoArray[0].getTotalPss();

        String ret;
        ret = String.format("%d", pss);
        return ret;
    }


    public native String getJniString();
    public native int test();

    public String getDisplayMetrics(){
        //Log.i("DEBUGGER_TAG", "getDisplayDPI");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int statusBarHeight = 0;

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }


        int actionBarHeight = 0;
        ActionBar actionBar = getActionBar();
        if(actionBar.isShowing())
            actionBarHeight = actionBar.getHeight();

//            float getTextSize() //pixels
        int width = 600;
        int height = 400;

        Display display = getWindowManager().getDefaultDisplay();


        if (Build.VERSION.SDK_INT >= 13) {

            if(Build.VERSION.SDK_INT >= 17){
                //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT >= 17");
                width = dm.widthPixels;
                height = dm.heightPixels;
            }
            else{

                switch (Build.VERSION.SDK_INT){

                    case 16:
                        //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT == 16");
                        width = dm.widthPixels;
                        height = dm.heightPixels;
                        break;

                    case 15:
                    case 14:
                        Point outPoint = new Point();
                        display.getRealSize(outPoint);
                        if (outPoint != null){
                            width = outPoint.x;
                            height = outPoint.y;
                        }
                    break;

                    default:
                        width = dm.widthPixels;
                        height = dm.heightPixels;
                        break;

                }
            }
        }
        else{
            //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT < 13");
            width = display.getWidth();
            height = display.getHeight();
        }



//  In FullScreen immersive mode, height needs a fixup...
        if(m_fullScreen){
            Point outPoint = new Point();
            display.getRealSize(outPoint);
            if (outPoint != null){
                width = outPoint.x;
                height = outPoint.y;
            }
            height += statusBarHeight;
        }


        float tsize = new Button(this).getTextSize();       // in pixels

        String ret;

        ret = String.format("%f;%f;%d;%d;%d;%d;%d;%d;%d;%d;%f", dm.xdpi, dm.density, dm.densityDpi,
               width, height - statusBarHeight,
               width, height,
               dm.widthPixels, dm.heightPixels, actionBarHeight, tsize);

        //Log.i("DEBUGGER_TAG", ret);



        return ret;
    }

    public String getDeviceInfo(){
        String s="Device Info:";
                s += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
                s += "\n OS API Level: "+android.os.Build.VERSION.RELEASE + "{"+android.os.Build.VERSION.SDK_INT+"}";
                s += "\n Device: " + android.os.Build.DEVICE;
                s += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
                s += "\n" + getPackageName();

        //Log.i("OpenCPN", s);

        return s;
    }


    public String showBusyCircle(){
    //if(!m_fullScreen)
    {

        mutex = new Semaphore(0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(null == ringProgressDialog){
                   //Log.i("OpenCPN", "ShowBusyBuild");
                   ringProgressDialog = new ProgressDialog(QtActivity.this,R.style.MyTheme);
                   ringProgressDialog.setCancelable(false);
                   ringProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);

                   Drawable myIcon = getResources().getDrawable( R.drawable.progressbar_custom );
                   ringProgressDialog.setIndeterminateDrawable(myIcon);

                 //  THIS IS IMPORTANT...Keeps the busy spinner from surfacing the hidden navigation buttons.
                   ringProgressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                }

                ringProgressDialog.show();

                mutex.release();

         }});
     }

     // One way to wait for the runnable to be done...
       try {
           mutex.acquire();            // Cannot get mutex until runnable above exits.
       } catch (InterruptedException e) {
           e.printStackTrace();
       }


        String ret = "";
        return ret;
    }

    public String hideBusyCircle(){

        if(null == ringProgressDialog){
            return "";
        }

        mutex = new Semaphore(0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                 if(null != ringProgressDialog)
                    ringProgressDialog.dismiss();

                 mutex.release();
             }});

       // One way to wait for the runnable to be done...
         try {
             mutex.acquire();            // Cannot get mutex until runnable above exits.
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

        String ret = "";
        return ret;
    }






    public String setRouteAnnunciator( final int viz){
     //Log.i("DEBUGGER_TAG", "setRouteAnnunciator");

     m_showRouteAnnunciator = (viz != 0);

//    if( null != itemRouteAnnunciator)
    {

        runOnUiThread(new Runnable() {
                @Override
                public void run() {

//                    itemRouteAnnunciator.setVisible(viz != 0);
                    QtActivity.this.invalidateOptionsMenu();

                 }});

        return "OK";
     }
//     else
//        return "NO";
    }

    private boolean m_showAction = false;

    public String setFollowIconState( final int isActive){
        m_isFollowActive = (isActive != 0);


           runOnUiThread(new Runnable() {
                   @Override
                   public void run() {


                       QtActivity.this.invalidateOptionsMenu();

                    }});

           // testing playSound("/data/data/org.opencpn.opencpn/files/sounds/2bells.wav");

           m_showAction = (isActive != 0);

           return "OK";
       }

       public String setTrackIconState( final int isActive){
           m_isTrackActive = (isActive != 0);

              runOnUiThread(new Runnable() {
                      @Override
                      public void run() {


                          QtActivity.this.invalidateOptionsMenu();

                       }});

              return "OK";
          }



       public String setBackButtonState( final int isActive){
           Log.i("OpenCPN", "setBackButtonState" + isActive);
           m_backButtonEnable = (isActive != 0);
           return "OK";
          }


    public String queryGPSServer( final int parm ){

        if( GPSServer.GPS_PROVIDER_AVAILABLE == parm){
            String ret_string = "NO";
            if( m_hasGPS )
                ret_string = "YES";
            return ret_string;
        }



        if(!m_GPSServiceStarted){
            //Log.i("DEBUGGER_TAG", "Start GPS Server");
            m_GPSServer = new GPSServer(getApplicationContext(), nativeLib);
            m_GPSServiceStarted = true;
        }

        return m_GPSServer.doService( parm );
    }

    public String hasBluetooth( final int parm ){
        String ret = "Yes";
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            ret = "No";
        }

        return ret;
    }

    public String startBlueToothScan( final int parm ){
        Log.i("DEBUGGER_TAG", "startBlueToothScan");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(!m_ScanHelperStarted){
                    scanHelper = new BTScanHelper(QtActivity.this);
                    m_ScanHelperStarted = true;
                }

                scanHelper.doDiscovery();

             }});


        return( "OK" );

    }

    public String stopBlueToothScan( final int parm ){
//        Log.i("DEBUGGER_TAG", "stopBlueToothScan");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(m_ScanHelperStarted){
                    scanHelper.doDiscovery();
                    scanHelper.stopDiscovery();
                }


             }});


        return( "OK" );

    }

    public String getBlueToothScanResults( final int parm ){
        String ret_str = "";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(!m_ScanHelperStarted){
                    scanHelper = new BTScanHelper(QtActivity.this);
                    m_ScanHelperStarted = true;
                }


             }});

        if(m_ScanHelperStarted)
            ret_str = scanHelper.getDiscoveredDevices();;

//        Log.i("DEBUGGER_TAG", "results");
//        Log.i("DEBUGGER_TAG", ret_str);

        return ret_str;



    }


    public String startBTService( final String address){
        Log.i("DEBUGGER_TAG", "startBTService");
        Log.i("DEBUGGER_TAG", address);
        m_BTStat = "Unknown";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

///
                if(!m_BTServiceCreated){
//                    Log.i("DEBUGGER_TAG", "Bluetooth createBTService");
                    m_BTSPP = new BluetoothSPP(getApplicationContext());

                    if(!m_BTSPP.isBluetoothAvailable() || !m_BTSPP.isBluetoothEnabled()) {
 //                           Toast.makeText(getApplicationContext()
 //                                           , "Bluetooth is not available"
 //                                           , Toast.LENGTH_SHORT).show();
                    }

                    else {
                        m_BTSPP.setupService();
                        m_BTServiceCreated = true;
                    }
                }


                m_BTSPP.setOnDataReceivedListener(new OnDataReceivedListener() {
                    public void onDataReceived(byte[] data, String message) {
//                        Log.i("DEBUGGER_TAG", message);
                        // Do something when data incoming
                        nativeLib.processBTNMEA( message );

                    }
                });

                if(m_BTSPP.isServiceAvailable()){
//                    Log.i("DEBUGGER_TAG", "Bluetooth startService");
                    m_BTSPP.startService(BluetoothState.DEVICE_OTHER);

//                    Log.i("DEBUGGER_TAG", "Bluetooth connectA");
//                    m_BTSPP.connect(address);
                    m_BTSPP.resetAutoConnect();
                    m_BTSPP.autoConnectAddress(address);

                }

                if(!m_BTSPP.isBluetoothEnabled())
                    m_BTStat = "NOK.BTNotEnabled";
                else if(!m_BTSPP.isServiceAvailable())
                    m_BTStat = "NOK.ServiceNotAvailable";
                else
                    m_BTStat = "OK";



             }});


        Log.i("DEBUGGER_TAG", "startBTService return: " + m_BTStat);
        return m_BTStat;
    }


    public String stopBTService( final int parm){
        Log.i("DEBUGGER_TAG", "stopBTService");
        String ret_str = "";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(m_BTServiceCreated){
                    Log.i("DEBUGGER_TAG", "Bluetooth stopService");
                    m_BTSPP.stopService();
                }


             }});

        ret_str = "OK";
        return ret_str;
    }


    public String scanSerialPorts( final int parm ){

        String ret_str = "";
        if(null != uSerialHelper){
            ret_str = uSerialHelper.scanSerialPorts(parm);
        }

        m_scannedSerial = ret_str;
        return ret_str;
    }


    public String startSerialPort( final String name, final String baudRate ){

        String ret_str = "";
        if(null != uSerialHelper){
            ret_str = uSerialHelper.startUSBSerialPort( name, Integer.parseInt(baudRate) );
        }

        return ret_str;
    }

    public String stopSerialPort( final String name ){

        String ret_str = "";
        if(null != uSerialHelper){
            ret_str = uSerialHelper.stopUSBSerialPort(name);
        }

        return ret_str;
    }




    private Semaphore mutex = new Semaphore(0);
    private Query m_query = new Query();

    public String downloadFileDM( final String url, final String destination )
    {
        m_downloadRet = "";
        Log.i("OpenCPN", url);
        Log.i("OpenCPN", destination);

/*
        //  Delete any existing file of the same name.
        Uri fURI = Uri.parse(destination);
        try{
            File f = new File(fURI.getPath());
            if(f.exists())
                f.delete();
       }catch (Exception e) {
       }
*/
       if( downloadBCReceiver == null){
          downloadBCReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Log.i("OpenCPN", "onReceive: " + action);

                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);

                    m_query = new Query();
                    m_query.setFilterById(m_enqueue);
                    Cursor c = m_dm.query(m_query);


                    if (c.moveToFirst()) {
                        String uriString = c.getString(c.getColumnIndex(DownloadManager.COLUMN_URI));

                        int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if (DownloadManager.STATUS_SUCCESSFUL == c.getInt(columnIndex)) {
                            Log.i("OpenCPN", "Download successful " + downloadId + m_enqueue);
                            String totalBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                            Log.i("OpenCPN", "totalBytes: " + totalBytes);

                        }

                        nativeLib.setDownloadStatus( c.getInt(columnIndex), uriString);


                    }
                    c.close();
                }
            }
          };
        }

        registerReceiver(downloadBCReceiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));


        mutex = new Semaphore(0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                m_dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                Request request = new Request( Uri.parse(url) );
                request.setDestinationUri( Uri.parse(destination) );

                Log.i("OpenCPN", "enqueue");
                m_downloadRet = "PENDING";
                try{
                     m_enqueue = m_dm.enqueue(request);
                     String result = "OK;" + String.valueOf(m_enqueue);
                     Log.i("OpenCPN", result);
                     m_downloadRet = result;
                 }
                 catch(Exception e){
                     m_downloadRet = "NOK";
                     Log.i("OpenCPN", "exception: " + e.getMessage());
                 }


                 mutex.release();


             }});

        // One way to wait for the runnable to be done...
        try {
            mutex.acquire();            // Cannot get mutex until runnable above exits.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.i("OpenCPN", "m_downloadRet " + m_downloadRet);
        return m_downloadRet;
    }

    public String getDownloadStatusDM( final int ID )
    {
        Log.i("OpenCPN", "getDownloadStatus "  + String.valueOf(ID));

        String ret = "NOSTAT";
        if(m_dm != null){

            m_query.setFilterById(ID);
            Cursor c = m_dm.query(m_query);

            if (c.moveToFirst()) {
                int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int stat = c.getInt(columnIndex);
                String sstat = String.valueOf(stat);

                String sofarBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR ));
                String totalBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                ret =  sstat + ";" + sofarBytes + ";" + totalBytes;

            }
            c.close();

        }

        Log.i("OpenCPN", ret);
        return ret;
    }


    public String cancelDownload( final int ID )
    {
        Log.i("OpenCPN", "cancelDownload "  + String.valueOf(ID));
        if(m_dm != null){
            m_dm.remove( ID );
        }

        return "OK";
    }



    public String doHttpPostSync( final String turl, final String encodedData) {

        Log.i("OpenCPN", "POST parms: " + encodedData);

        HttpURLConnection urlc = null;
        OutputStreamWriter out = null;
        DataOutputStream dataout = null;
        BufferedReader in = null;
        String result = "";

        try {
            URL url = new URL(turl);
            urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("POST");
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setUseCaches(false);
            urlc.setAllowUserInteraction(false);
            //urlc.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE);
            urlc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            dataout = new DataOutputStream(urlc.getOutputStream());

            // perform POST operation
            dataout.writeBytes(encodedData);

            int responseCode = urlc.getResponseCode();
            Log.i("OpenCPN", "Response code: " +  Integer.toString(responseCode));

            in = new BufferedReader(new InputStreamReader(urlc.getInputStream()),8096);
            String response;
            // write html to System.out for debug
            while ((response = in.readLine()) != null) {
                Log.i("OpenCPN", response);
                result += response;
            }

            in.close();
            urlc.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
            result = "NOK";
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "NOK";
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
            e.printStackTrace();
                    result = "NOK";
                }
            }
        }

        return result;
    }



    class PostTask extends AsyncTask<String,Void,String>
    {

      @Override
      protected String doInBackground(String... arg0) {

          g_postActive = true;
          //Log.i("OpenCPN", "POST url: " + arg0[0]);
          //Log.i("OpenCPN", "POST parms: " + arg0[1]);

          HttpURLConnection urlc = null;
          OutputStreamWriter out = null;
          DataOutputStream dataout = null;
          BufferedReader in = null;
          String result = "";

          try {
              URL url = new URL(arg0[0]);
              urlc = (HttpURLConnection) url.openConnection();
              urlc.setRequestMethod("POST");
              urlc.setDoOutput(true);
              urlc.setDoInput(true);
              urlc.setUseCaches(false);
              urlc.setAllowUserInteraction(false);
              //urlc.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE);
              urlc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

              int timeout = 4950;
              try {
                  timeout = Integer.parseInt(arg0[2]);
              } catch(NumberFormatException nfe) {
                // Handle parse error.
                nfe.printStackTrace();
                Log.i("OpenCPN", "Timeout value parse exception");
              }
              urlc.setConnectTimeout(timeout);
              urlc.setReadTimeout(timeout);
              //Log.i("OpenCPN", "Timeout: " + String.valueOf(timeout));


              dataout = new DataOutputStream(urlc.getOutputStream());

              // perform POST operation
              //Log.i("OpenCPN", "doin it...");

              dataout.writeBytes(arg0[1]);

              int responseCode = urlc.getResponseCode();
              Log.i("OpenCPN", "AsyncTask HTTPPOST Response code: " +  Integer.toString(responseCode));

              in = new BufferedReader(new InputStreamReader(urlc.getInputStream()),8096);
              String response;
              // write html to System.out for debug
              while ((response = in.readLine()) != null) {
                  //Log.i("OpenCPN", response);
                  result += response;
              }

              in.close();
              urlc.disconnect();

          } catch (IOException e) {
              e.printStackTrace();
              Log.i("OpenCPN", "AsyncTask IOException 1");
              result = "NOK";
          } finally {
              if (out != null) {
                  try {
                      out.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                      Log.i("OpenCPN", "AsyncTask IOException 2");
                      result = "NOK";
                  }
              }
              if (in != null) {
                  try {
                      in.close();
                  } catch (IOException e) {
              e.printStackTrace();
                      Log.i("OpenCPN", "Exception 3");
                      result = "NOK";
                  }
              }
          }

          //Log.i("OpenCPN", "async result: " + result);

          return result;
      }

      @Override
      protected void onPostExecute(String result) {
          // TODO Auto-generated method stub
          super.onPostExecute(result);

          g_postResult = result;
          g_postActive = false;
      }
  }


  public String doHttpPostAsync( final String url, final String encodedData, final String timeoutMsec) {
      //Log.i("OpenCPN", "doHttpPostAsync start ");
      // Clear the data
      g_postActive = false;
      g_postResult = "";

      new PostTask().execute(url, encodedData, timeoutMsec);

      return "OK";
  }

  public String checkPostAsync(){
      if(g_postActive)
        return "ACTIVE";
      else
        return g_postResult;
  }







    public String doHttpPostX( final String url, final String parameters ){

        // Creating an instance of HttpClient.

          HttpClient httpclient = new DefaultHttpClient();
          try {

               // Creating an instance of HttpPost.
               HttpPost httpost = new HttpPost( url );

           // Extract the parameters
           // Adding all form parameters in a List of type NameValuePair
                //Log.i("OpenCPN", "POST parms: " + parameters);
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();

                StringTokenizer tkz = new StringTokenizer(parameters, ";");

                while(tkz.hasMoreTokens()){
                    String p0 = tkz.nextToken();
                    String p1 = tkz.nextToken();
                    //Log.i("OpenCPN", "parms: " + p0 + "  " + p1);
                    nvps.add(new BasicNameValuePair(p0, p1));
                }


           /**
            * UrlEncodedFormEntity encodes form parameters and produce an
            * output like param1=value1&param2=value2
            */
                try{
                    httpost.setEntity(new UrlEncodedFormEntity(nvps));
                }catch(Exception e) {
                    e.printStackTrace();
                }


           // Executing the request.
                HttpResponse response = httpclient.execute(httpost);

                //Log.i("OpenCPN", "POST Response Status line :" + response.getStatusLine());

                try {
                    // Do the needful with entity.
                    HttpEntity entity = response.getEntity();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        //Log.i("OpenCPN", line);
                        result.append(line);
                    }

                 }catch(Exception e) {
                     e.printStackTrace();
                 }
           }catch(Exception e) {
               e.printStackTrace();
           }

           return "OK";
       }



    public String downloadFile( final String url, final String destination ){

        Log.i("OpenCPN", "downloadFile " + url + " to " + destination);

        m_downloadURL = url;
        m_downloadStatus = 1;       //STATUS_PENDING
        m_downloadTotal = 0;

        Uri fURI = Uri.parse(destination);
        String destPath = "";
        try{
            destPath = fURI.getPath();
        }catch (Exception e) {
        }

        Log.i("OpenCPN", "downloadFile parsed destination: " + destPath);

        // We validate write access to the destination directory
        File dest = new File(destPath);
        File destDir = dest.getParentFile();

        DocumentFile dir = null;
        boolean buseDocFile = false;

        //  Is destination on an SDCard?
        String sdRoot = "";
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {

            sdRoot = getExtSdCardFolder(dest);
            if (null != sdRoot) {
                Log.i("OpenCPN", "downloadFile destination on SDCard");
                dir = getDocumentFile(destDir, true, false);

                if (null == dir) {
    //            startSAFDialog(44);
                    Log.i("OpenCPN", "downloadFile Needs to startSAF44a");
                    return "NOK";
                }

                if (!dir.canWrite()) {
    //                startSAFDialog(44);
                    Log.i("OpenCPN", "downloadFile Needs to startSAF44b");
                    return "NOK";
                }
                buseDocFile = true;
            }
        }

        Log.i("OpenCPN", "downloadFile writeable OK, starting service intent...");


        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("url", url);
        intent.putExtra("file", destination);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("useDocFile", buseDocFile);

        startService(intent);

        //Log.i("OpenCPN", "RET OK");
        return "OK;77";
    }


    public String getDownloadStatus( final int ID )
    {

        String ret = "NOSTAT";

        String sstat = String.valueOf(m_downloadStatus);
        ret =  sstat + ";" + m_downloadTotal + ";" + m_downloadFilelength;

        Log.i("OpenCPN", "getDownloadStatus "  + String.valueOf(ID) + " " + ret);
        return ret;
    }

    private int m_downloadTotal;
    private int m_downloadFilelength;
    private int m_downloadStatus;
    private String m_downloadURL;


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        //super.onReceiveResult(resultCode, resultData);
        if (resultCode == DownloadService.UPDATE_PROGRESS) {

            int progress = resultData.getInt("progress");

            m_downloadTotal = resultData.getInt("sofar");
            m_downloadFilelength = resultData.getInt("filelength");
            m_downloadStatus = 2;           // STATUS_RUNNING

//            Log.i("OpenCPN", "UPDATE_PROGRESS " + m_downloadTotal + " " + m_downloadFilelength + " " + progress);

            //mProgressDialog.setProgress(progress);
            //if (progress == 100) {
            //    mProgressDialog.dismiss();

            nativeLib.setDownloadStatus( m_downloadStatus, m_downloadURL);

        }
        if (resultCode == DownloadService.DOWNLOAD_DONE) {
            m_downloadTotal = resultData.getInt("sofar");
            m_downloadFilelength = resultData.getInt("filelength");
            m_downloadStatus = 8;           // STATUS_SUCCESSFUL
            if(0 == m_downloadTotal)
                m_downloadStatus = 16;      // STATUS_ERROR

            nativeLib.setDownloadStatus( m_downloadStatus, m_downloadURL);
            Log.i("OpenCPN", "DOWNLOAD_DONE " + m_downloadStatus + " " + m_downloadTotal + " " + m_downloadTotal + " " + m_downloadFilelength);
        }

        if (resultCode == UnzipService.UNZIP_DONE) {
            Log.i("OpenCPN", "UNZIP_DONE ");
            m_unzipDone = true;
        }


    }

    private boolean m_unzipDone;
    public String unzipFile( final String source, final String destination, String nStrip, String bRemoveZip ){

        Log.i("OpenCPN", "unzipFile " + source + " to " + destination);

        Intent intent = new Intent(this, UnzipService.class);
        intent.putExtra("sourceZip", source);
        intent.putExtra("targetDir", destination);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("nStrip", Integer.parseInt(nStrip));
        intent.putExtra("removeZip", Integer.parseInt(bRemoveZip));
        m_unzipDone = false;

        startService(intent);
        return "OK;78";

    }

    public String getUnzipStatus(String dummy){
        if(m_unzipDone)
            return "UNZIPDONE";
        else
            return "UNZIPPING";
    }


    public String isNetworkAvailable() {
            ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

    // test for connection
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable()
                    && cm.getActiveNetworkInfo().isConnected()) {
                return "YES";
            } else {
                return "NO";
            }
    }

    public String getGMAPILicense( )
    {
        String ret = "";

        GoogleApiAvailability av = GoogleApiAvailability.getInstance();
        if(av != null)
            ret = av.getOpenSourceSoftwareLicenseInfo (this);

        return ret;
    }



    /**
     * it will play the given file, when it finishes, or fails, it will play the next from the list
     *
     * @param fileName: the file name to start playing from it
     */
    public String playSound(final String fileName) {
        Log.i("DEBUGGER_TAG", "playSound " + fileName);
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }


        if (mediaPlayer != null) {
            //if (!mediaPlayer.isPlaying())

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fileName);
                        mediaPlayer.prepare();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                //playNextSoundTrack();
                            }
                        });
                        //Log.i("DEBUGGER_TAG", "playSoundStart");
                        mediaPlayer.start();
                    } catch (Exception e) {
                        // TODO: Remove this error checking before publishing
                    }


                 }});

        }

        return "OK";
    }

    public String FileChooserDialog(final String initialDir, final String Title, final String Suggestion, final String wildcard)
    {
        Log.i("OpenCPN", "FileChooserDialog");
        Log.i("OpenCPN", initialDir);
        Log.i("OpenCPN", Suggestion);

        m_FileChooserDone = false;

        boolean buseDialog = true;
        if(!buseDialog){
            Intent intent = new Intent(this, FileChooserActivity.class);
            intent.putExtra(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            intent.putExtra(FileChooserActivity.INPUT_FOLDER_MODE, false);
            intent.putExtra(FileChooserActivity.INPUT_SHOW_FULL_PATH_IN_TITLE, true);
            intent.putExtra(FileChooserActivity.INPUT_TITLE_STRING, Title);


        //  Creating a file?
            if(!Suggestion.isEmpty()){
                //Log.i("OpenCPN", "FileChooserDialog Creating");
                intent.putExtra(FileChooserActivity.INPUT_CAN_CREATE_FILES, true);
            }

            this.startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            return "OK";

        }

        //Log.i("DEBUGGER_TAG", "FileChooserDialog create and show " + initialDir);

        Thread thread = new Thread() {
            @Override
            public void run() {

        // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FileChooserDialog dialog = new FileChooserDialog(m_activity, initialDir);

                        dialog.setShowFullPath( true );
                        dialog.setTitle( Title );

                        //  Creating a file?
                        if(!Suggestion.isEmpty()){
                            Log.i("OpenCPN", "FileChooserDialog CanCreate");
                            dialog.setCanCreateFiles(true);
                        }

                        dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                            public void onFileSelected(Dialog source, File file) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                                //toast.show();
                                Log.i("OpenCPN", "FileChooserDialog selected: " + file.getName() );

                                m_filechooserString = "file:" + file.getPath();
                                m_FileChooserDone = true;

                            }
                            public void onFileSelected(Dialog source, File folder, String name) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, Toast.LENGTH_LONG);
                                //toast.show();
                                Log.i("OpenCPN", "Listener: FileChooserDialog created: " + folder.getName() + "/" + name);

                                m_filechooserString = "file:" + folder.getPath() + "/" + name;

                                final File newFile = new File(folder.getPath() +  File.separator + name);
                                if(!folder.canWrite()){
                                    if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                                        Log.i("OpenCPN", "FileChooserDialog listener needs SAF dialog");

                                        //  Is this on an SDCard?
                                        String sdRoot = getExtSdCardFolder(folder);
                                        if (null != sdRoot) {
                                            Log.i("OpenCPN", "FileChooserDialog listener found sdCard");

                                            // This will NOT create the file
                                            DocumentFile f = getDocumentFile(folder, true, false);
                                            if (null == f){
                                                startSAFDialog(OCPN_SAF_DIALOG_A_REQUEST_CODE);
                                                return;
                                            }
                                        }
                                    }
                                }

                                m_FileChooserDone = true;

                            }
                        });

                        dialog.setOnCancelListener(new OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                Log.i("OpenCPN", "FileChooserDialog Cancel");
                                m_filechooserString = "cancel:";
                                m_FileChooserDone = true;
                            }
                        });


                        dialog.setCanCreateFiles(true);
                        dialog.show();

                        //Log.i("DEBUGGER_TAG", "FileChooserDialog Back from show");

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        //Log.i("DEBUGGER_TAG", "FileChooserDialog Returning");

        return "OK";
   }

   public String doColorPickerDialog( final int initialColor)
   {
       m_ColorDialogDone = false;


        Log.i("OpenCPN", "ColorPicker create and show " + initialColor);

        Thread thread = new Thread() {
            @Override
            public void run() {

        // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final ColorPickerDialog dialog = new ColorPickerDialog(m_activity, initialColor){

                            @Override
                            public void onOK(int selectedColor)
                            {
                                String strI = String.valueOf(selectedColor);
                                Log.i("DEBUGGER_TAG", "Activity on OK button Color: " + strI);
                                m_ColorDialogString = "color:" + strI;
                                m_ColorDialogDone = true;

                              // do something
                            }

                            @Override
                            public void onCancel()
                            {
                                Log.i("DEBUGGER_TAG", "Activity on Cancel Color: ");
                                m_ColorDialogString = "cancel:";
                                m_ColorDialogDone = true;
                              // do something
                            }
                        };



//                        dialog.setTitle( Title );


                        dialog.show();

                        Log.i("DEBUGGER_TAG", "ColorPickerDialog Back from show");

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        Log.i("DEBUGGER_TAG", "ColorPickerDialog Returning");

       return "OK";
  }

  public String isColorPickerDialogFinished()
  {
      Log.i("DEBUGGER_TAG", "poll");

      if(m_ColorDialogDone){
          Log.i("DEBUGGER_TAG", "done");
           return m_ColorDialogString;
      }
      else{
          return "no";
      }
  }


   public String DirChooserDialog(final String initialDir, final String Title, final int addFile, final int spare)
   {
       m_FileChooserDone = false;

       boolean buseDialog = (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP);        //false;
       if(!buseDialog){
            //Intent intent = new Intent(this, FileChooserActivity.class);
            //intent.putExtra(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            //intent.putExtra(FileChooserActivity.INPUT_FOLDER_MODE, true);

            //this.startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            //return "OK";


            Log.i("OpenCPN", "DirChooserDialog start activity: " + initialDir);

            Bundle b = new Bundle();
            b.putString(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            b.putBoolean(FileChooserActivity.INPUT_FOLDER_MODE, true);
            b.putBoolean(FileChooserActivity.INPUT_CAN_CREATE_FILES, true);


            Intent intent = new Intent(this, FileChooserActivity.class);
            intent.putExtras(b);
            startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            return "OK";

        }

        Log.i("OpenCPN", "DirChooserDialog create and show " + initialDir);

        Thread thread = new Thread() {
            @Override
            public void run() {

        // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final FileChooserDialog dialog = new FileChooserDialog(m_activity, initialDir);

                        dialog.setShowFullPath( true );
                        dialog.setFolderMode( true );
                        dialog.setCanCreateFiles( addFile > 0 );


                        dialog.setTitle( Title );

                        dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                            public void onFileSelected(Dialog source, File file) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                                //toast.show();

                                //Log.i("OpenCPN", "Activity onFileSelectedA: " + file.getPath());
                                m_filechooserString = "file:" + file.getPath();
                                m_FileChooserDone = true;

                            }
                            public void onFileSelected(Dialog source, File folder, String name) {
                                //Log.i("OpenCPN", "Activity onFileSelectedB: " + folder.getPath() +  File.separator + name);

                                File newFolder = new File(folder.getPath() +  File.separator + name);
                                boolean success = true;
                                if (!newFolder.exists())
                                    success = newFolder.mkdirs();

                                if(!success){
                                    Toast toast = Toast.makeText(source.getContext(), "Could not create file in: " + folder.getPath(), Toast.LENGTH_LONG);
                                    toast.show();
                                }

                                dialog.loadFolder(folder.getPath());
                            }

                        });

                        dialog.setOnCancelListener(new OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                Log.i("OpenCPN", "DirChooserDialog Cancel");
                                m_filechooserString = "cancel:";
                                m_FileChooserDone = true;
                            }
                        });


                        dialog.show();

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        //Log.i("DEBUGGER_TAG", "DirChooserDialog Returning");

       return "OK";
  }

   public String isFileChooserFinished()
   {
       if(m_FileChooserDone){
            Log.i("OpenCPN", "isFileChooserFinished:  returning " + m_filechooserString);
            return m_filechooserString;
       }
       else{
           return "no";
       }
   }

   // ActionBar Spinner navigation to select chart display type

   //  Thread safe version, callable from another thread
   public String configureNavSpinnerTS(final int flag, final int sel){
       Thread thread = new Thread() {
            @Override
            public void run() {

       // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

       // After sleep finished blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configureNavSpinner(flag, sel);
                    }
                });
            }
       };

       // Don't forget to start the thread.
       thread.start();

       return "OK";
   }



   public String configureNavSpinner(int flag, int sel){

       navSpinner.clear();
       int nbits = 0;
       int n93 = -1;
       int nraster = -1;
       int nvector = -1;

       if((flag & 1) == 1){
           nraster = nbits;
           navSpinner.add(spinnerItemRaster);
           nbits++;
       }
       if((flag & 2) == 2){
           nvector = nbits;
           navSpinner.add(spinnerItemVector);
           nbits++;
       }
       if((flag & 4) == 4){
           n93 = nbits;
           navSpinner.add(spinnerItemcm93);
           nbits++;
       }



       // Select the proper item as directed
       int to_sel = 0;
       if(sel == 1)
            to_sel = nraster;
       else if(sel == 2)
            to_sel = nvector;
       else if(sel == 4)
            to_sel = n93;

       // Any bits set?
       if(nbits > 1){
           actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
           actionBar.setSelectedNavigationItem(to_sel);
       }
       else
           actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

       return "OK";
   }

   public String getSystemDirs(){
       String result = "";


//       String extFiles = getExternalFilesDir(null).getPath();   // Provisional

       //  Maybe the app has been migrated to SDCard...
       ApplicationInfo ai = getApplicationInfo();
       if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
           //Log.i("OpenCPN", "External");
           result = "EXTAPP;";
//           File[] fx = getExternalFilesDirs(null);
//           if(fx.length > 1){
//               extFiles = fx[1].getPath();
//           }
       }
       else{
           //Log.i("OpenCPN", "Internal");
           result = "INTAPP;";
       }

       String extFiles = m_filesDir;

       // Find the external cache directory
       String cacheDir = "";

       File cache = getExternalCacheDir();
       if(null == cache){
           File fc = new File(m_filesDir);
           cacheDir = fc.getParent() + "/cache";
       }
       else{
           cacheDir = cache.getAbsolutePath();
       }

       //  Verify the ExternalStorage Directory
       String sxsd = "";
       File xsd = Environment.getExternalStorageDirectory();
       if(null == xsd){
           sxsd = getFilesDir().getPath();
       }
       else{
           sxsd = xsd.getPath();
       }





       result = result.concat(getFilesDir().getPath() + ";");
       result = result.concat(getCacheDir().getPath() + ";");
       result = result.concat(extFiles + ";");
       result = result.concat(cacheDir + ";");
       result = result.concat(sxsd + ";");

       Log.i("OpenCPN", "getSystemDirs  result: " + result);

       return result;
   }






   //  ActionBar drop-down spinner navigation
   @Override
   public boolean onNavigationItemSelected(int itemPosition, long itemId) {
   // Action to be taken after selecting a spinner item from action bar

   //Log.i("DEBUGGER_TAG", "onNavigationItemSelected");
   String aa;
   aa = String.format("%d", itemPosition);
   //Log.i("DEBUGGER_TAG", aa);

        SpinnerNavItem item = navSpinner.get(itemPosition);
        if(item.getTitle().equalsIgnoreCase("cm93")){
            nativeLib.selectChartDisplay(CHART_TYPE_CM93COMP, -1);
            return true;
        }
        else if(item.getTitle().equalsIgnoreCase("raster")){
            nativeLib.selectChartDisplay(-1, CHART_FAMILY_RASTER);
            //Log.i("DEBUGGER_TAG", "onNavigationItemSelectedA");
            return true;
        }
        else if(item.getTitle().equalsIgnoreCase("vector")){
            nativeLib.selectChartDisplay(-1, CHART_FAMILY_VECTOR);
            return true;
        }


       return false;
   }

   private void relocateOCPNPlugins( )
   {
       // We need to relocate the PlugIns that have been included as "assets"

       // Reason:  PlugIns can only load from the apps dataDir, which is like:
       //          "/data/data/org.opencpn.opencpn"
       //          This is due to some policy in the system loader....
       //
       //           There is no need to relocate any data files needed by the PlugIns
       //           since they will have been added as assets and moved to the file system
       //           by assetbridge elsewhere.
       //
       //          Since this method runs on every restart, it may be used to condition manually installed
       //          PlugIns as well.  Just somehow install the PlugIn .so file into ".../files/plugins" dir,
       //          and it will be moved to the proper load location on restart.

       Log.i("OpenCPN", "relocateOCPNPlugins");
/*
       // On Moto G
       // This produces "/data/data/org.opencpn.opencpn/files"
       //  Which is where the app files would be with default load
       String iDir = getFilesDir().getPath();
       String ssd = iDir + "/plugins";


       //  Maybe the app has been migrated to SDCard...
       sApplicationInfo ai = getApplicationInfo();
       if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
           Log.i("OpenCPN", "relocateOCPNPlugins:  OCPN is on EXTERNAL_STORAGE");
           File[] fx = getExternalFilesDirs(null);
           if(fx.length > 1){
               ssd = fx[1].getPath() + File.separator + "plugins";
           }
       }
*/
       File fd = new File(m_filesDir);
       String ssd = fd.getPath() + File.separator + "plugins";

       File sourceDir = new File( ssd );

       // The PlugIn .so files are always relocated to here, which looks like:
       // "/data/data/org.opencpn.opencpn"
       String finalDestination = getApplicationInfo().dataDir;

       File[] dirs = sourceDir.listFiles();
       if (dirs != null) {
           for (int j=0; j < dirs.length; j++){
               File sfile = dirs[j];
               Log.i("OpenCPN", "relocateOCPNPlugins processing: " + sfile.getName());

               if (sfile.isFile()){

                              String source = sfile.getAbsolutePath();
                              String dest = finalDestination + "/" + sfile.getName();


                              try {
                                  InputStream inputStream = new FileInputStream(source);
                                  OutputStream outputStream = new FileOutputStream(dest);
                                  copyFile(inputStream, outputStream);
                                  inputStream.close();
                                  outputStream.close();
                                  Log.i("OpenCPN", "relocateOCPNPlugins copyFile OK: " + source + " to " + dest);

                                  if(!dest.endsWith(".so")){
                                      Log.i("OpenCPN", "relocateOCPNPlugins setting executable on: " + dest);
                                      File file = new File(dest);
                                      file.setExecutable(true);
                                  }

                              }
                              catch (Exception e) {
                                  e.printStackTrace();
                                  Log.i("OpenCPN", "relocateOCPNPlugins copyFile Exception");
                              }
              }
          }
      }
   }

   /**
       * Get a list of external SD card paths. (Kitkat or higher.)
       *
       * @return A list of external SD card paths.
       */
      private String[] getExtSdCardPaths() {
          List<String> paths = new ArrayList<String>();



              for (File file : this.getExternalFilesDirs("external")) {
                  if (file != null && !file.equals(this.getExternalFilesDir("external"))) {
                      int index = file.getAbsolutePath().lastIndexOf("/Android/data");
                      if (index < 0) {
                          //Log.w(Application.TAG, "Unexpected external file dir: " + file.getAbsolutePath());
                      } else {
                          String path = file.getAbsolutePath().substring(0, index);
                          try {
                              path = new File(path).getCanonicalPath();
                          } catch (IOException e) {
                              // Keep non-canonical path.
                          }
                          paths.add(path);
                      }
                  }
              }

          return paths.toArray(new String[paths.size()]);
      }


   void processStagingFiles(){
       Log.i("OpenCPN", "processStagingFiles starts...");



       // Is there anything in the "staging" directory?
       String stagingPath = getFilesDir().getPath() + File.separator + "staging";

/*
       //  The destination after unzipping
       String finalDestination = getFilesDir().getAbsolutePath() + File.separator;

       //  Maybe the app has been migrated to SDCard...
       ApplicationInfo ai = getApplicationInfo();
       if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
           Log.i("OpenCPN", "processStagingFiles:  OCPN is on EXTERNAL_STORAGE");
           File[] fx = getExternalFilesDirs(null);
           if(fx.length > 1){
               stagingPath = fx[1].getPath() + File.separator + "staging";
               finalDestination = fx[1].getAbsolutePath() + File.separator;
           }
       }
*/
       String finalDestination = m_filesDir + File.separator;
       Log.i("OpenCPN", "   Staging directory:: " + stagingPath );
       Log.i("OpenCPN", "   Destination directory:: " + finalDestination );

       File stageDir = new File( stagingPath );
       if(stageDir.exists()){
           if(stageDir.isDirectory()){
               Log.i("OpenCPN", "Staging directory exists at: " + stagingPath );

               File[] files = stageDir.listFiles();

               if (files != null) {
                   for (int j=0; j < files.length; j++){
                       File sfile = files[j];

                       if (sfile.isFile()){
                           Log.i("OpenCPN", "Processing staged file: " + sfile.getName());

                           String source = sfile.getAbsolutePath();
                           if(source.toUpperCase().endsWith("ZIP")){
                               Log.i("OpenCPN", "Processing staged ZIP file: " + sfile.getName());

                               // We unzip the file into the app "files" directory.
                               //  May be on SDCard for migrated apps.

                               // For normal plugin zip packages, that will put the plugin .so and helper files
                               // into "files/plugins/", from whence they will be relocated to the data directory for runtime.


                               unzip(sfile.getAbsolutePath(), finalDestination);

                           }
                           //  Finished, so delete the staged file
                           sfile.delete();
                       }
                   }
               }
           }
       }
       Log.i("OpenCPN", "processStagingFiles ends.");
   }

   public void unzip(String _zipFile, String _targetLocation) {
       Log.i("OpenCPN", "ZIP unzipping " + _zipFile + " to " + _targetLocation);

       ZipEntry ze = null;

    try {
        FileInputStream fin = new FileInputStream(_zipFile);
        ZipInputStream zin = new ZipInputStream(fin);
         while ((ze = zin.getNextEntry()) != null) {

            Log.i("OpenCPN", "ZIP Entry: " + ze.getName());

            //create dir if required while unzipping
            if (ze.isDirectory()) {
                Log.i("OpenCPN", "Unzip dir: "  + ze.getName());
                File dir = new File( ze.getName());
                if(!dir.exists()){
                     dir.mkdirs();
                }

            } else {
                int size;
                byte[] buffer = new byte[2048];
                Log.i("OpenCPN", "Unzip file: " + _targetLocation + ze.getName());

                FileOutputStream outStream = new FileOutputStream(_targetLocation + ze.getName());
                BufferedOutputStream bufferOut = new BufferedOutputStream(outStream, buffer.length);

                while((size = zin.read(buffer, 0, buffer.length)) != -1) {
                    bufferOut.write(buffer, 0, size);
                }

                bufferOut.flush();
                bufferOut.close();

                zin.closeEntry();


            }
        }
        zin.close();
        } catch (Exception e) {
            Log.i("OpenCPN", "ZIP Exception: " + ze.getName());
            System.out.println(e);
        }
   }

    // this function is used to load and start the loader
    private void loadApplication(Bundle loaderParams)
    {
        Log.i("OpenCPN", "LoadApplication");

        processStagingFiles();

        relocateOCPNPlugins();

        //callFromCpp();

        try {
            final int errorCode = loaderParams.getInt(ERROR_CODE_KEY);
            if (errorCode != 0) {
                if (errorCode == INCOMPATIBLE_MINISTRO_VERSION) {
                    downloadUpgradeMinistro(loaderParams.getString(ERROR_MESSAGE_KEY));
                    return;
                }

                // fatal error, show the error and quit
                AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();
                errorDialog.setMessage(loaderParams.getString(ERROR_MESSAGE_KEY));
                errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                errorDialog.show();
                return;
            }

            // add all bundled Qt libs to loader params
            ArrayList<String> libs = new ArrayList<String>();
            if ( m_activityInfo.metaData.containsKey("android.app.bundled_libs_resource_id") )
                libs.addAll(Arrays.asList(getResources().getStringArray(m_activityInfo.metaData.getInt("android.app.bundled_libs_resource_id"))));

                //  We want the default OCPN plugins bundled into the APK and installed
                //  into the proper app-lib.  So they are listed in ANDROID_EXTRA_LIBS.
                //  But we do not want to pre-load them.  So take them out of the DexClassLoader list.

//                libs.remove("dashboard_pi");
//                libs.remove("grib_pi");




            String libName = null;
            if ( m_activityInfo.metaData.containsKey("android.app.lib_name") ) {
                libName = m_activityInfo.metaData.getString("android.app.lib_name");
                loaderParams.putString(MAIN_LIBRARY_KEY, libName); //main library contains main() function
            }

            loaderParams.putStringArrayList(BUNDLED_LIBRARIES_KEY, libs);
            loaderParams.putInt(NECESSITAS_API_LEVEL_KEY, NECESSITAS_API_LEVEL);

            // load and start QtLoader class
            m_classLoader = new DexClassLoader(loaderParams.getString(DEX_PATH_KEY), // .jar/.apk files
                                               getDir("outdex", Context.MODE_PRIVATE).getAbsolutePath(), // directory where optimized DEX files should be written.
                                               loaderParams.containsKey(LIB_PATH_KEY) ? loaderParams.getString(LIB_PATH_KEY) : null, // libs folder (if exists)
                                               getClassLoader()); // parent loader

            @SuppressWarnings("rawtypes")
            Class loaderClass = m_classLoader.loadClass(loaderParams.getString(LOADER_CLASS_NAME_KEY)); // load QtLoader class
            Object qtLoader = loaderClass.newInstance(); // create an instance
            Method perpareAppMethod = qtLoader.getClass().getMethod("loadApplication",
                                                                    Activity.class,
                                                                    ClassLoader.class,
                                                                    Bundle.class);
            if (!(Boolean)perpareAppMethod.invoke(qtLoader, this, m_classLoader, loaderParams))
                throw new Exception("");

            QtApplication.setQtActivityDelegate(qtLoader);

            // now load the application library so it's accessible from this class loader
            if (libName != null)
                System.loadLibrary(libName);

            Method startAppMethod=qtLoader.getClass().getMethod("startApplication");
            if (!(Boolean)startAppMethod.invoke(qtLoader))
                throw new Exception("");


        } catch (Exception e) {
            e.printStackTrace();
            AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();
            if (m_activityInfo.metaData.containsKey("android.app.fatal_error_msg"))
                errorDialog.setMessage(m_activityInfo.metaData.getString("android.app.fatal_error_msg"));
            else
                errorDialog.setMessage("Fatal error, your application can't be started.");

            errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            errorDialog.show();
        }
    }

    private ServiceConnection m_ministroConnection=new ServiceConnection() {
        private IMinistro m_service = null;
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            m_service = IMinistro.Stub.asInterface(service);
            try {
                if (m_service != null) {
                    Bundle parameters = new Bundle();
                    parameters.putStringArray(REQUIRED_MODULES_KEY, m_qtLibs);
                    parameters.putString(APPLICATION_TITLE_KEY, (String)QtActivity.this.getTitle());
                    parameters.putInt(MINIMUM_MINISTRO_API_KEY, MINISTRO_API_LEVEL);
                    parameters.putInt(MINIMUM_QT_VERSION_KEY, QT_VERSION);
                    parameters.putString(ENVIRONMENT_VARIABLES_KEY, ENVIRONMENT_VARIABLES);
                    if (APPLICATION_PARAMETERS != null)
                        parameters.putString(APPLICATION_PARAMETERS_KEY, APPLICATION_PARAMETERS);
                    parameters.putStringArray(SOURCES_KEY, m_sources);
                    parameters.putString(REPOSITORY_KEY, m_repository);
                    if (QT_ANDROID_THEMES != null)
                        parameters.putStringArray(ANDROID_THEMES_KEY, QT_ANDROID_THEMES);
                    m_service.requestLoader(m_ministroCallback, parameters);
                }
            } catch (RemoteException e) {
                    e.printStackTrace();
            }
        }

        private IMinistroCallback m_ministroCallback = new IMinistroCallback.Stub() {
            // this function is called back by Ministro.
            @Override
            public void loaderReady(final Bundle loaderParams) throws RemoteException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        unbindService(m_ministroConnection);
                        loadApplication(loaderParams);
                    }
                });
            }
        };

        @Override
        public void onServiceDisconnected(ComponentName name) {
            m_service = null;
        }
    };

    private void downloadUpgradeMinistro(String msg)
    {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(this);
        downloadDialog.setMessage(msg);
        downloadDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Uri uri = Uri.parse("market://search?q=pname:org.kde.necessitas.ministro");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivityForResult(intent, MINISTRO_INSTALL_REQUEST_CODE);
                } catch (Exception e) {
                    e.printStackTrace();
                    ministroNotFound();
                }
            }
        });

        downloadDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                QtActivity.this.finish();
            }
        });
        downloadDialog.show();
    }

    private void ministroNotFound()
    {
        AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();

        if (m_activityInfo.metaData.containsKey("android.app.ministro_not_found_msg"))
            errorDialog.setMessage(m_activityInfo.metaData.getString("android.app.ministro_not_found_msg"));
        else
            errorDialog.setMessage("Can't find Ministro service.\nThe application can't start.");

        errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        errorDialog.show();
    }

    static private void copyFile(InputStream inputStream, OutputStream outputStream)
        throws IOException
    {
        byte[] buffer = new byte[BUFFER_SIZE];

        int count;
        while ((count = inputStream.read(buffer)) > 0)
            outputStream.write(buffer, 0, count);
    }


    private void copyAsset(String source, String destination)
        throws IOException
    {
        // Already exists, we don't have to do anything
        File destinationFile = new File(destination);
        if (destinationFile.exists())
            return;

        File parentDirectory = destinationFile.getParentFile();
        if (!parentDirectory.exists())
            parentDirectory.mkdirs();

        destinationFile.createNewFile();

        AssetManager assetsManager = getAssets();
        InputStream inputStream = assetsManager.open(source);
        OutputStream outputStream = new FileOutputStream(destinationFile);
        copyFile(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private static void createBundledBinary(String source, String destination)
        throws IOException
    {
        // Already exists, we don't have to do anything
        File destinationFile = new File(destination);
        if (destinationFile.exists())
            return;

        File parentDirectory = destinationFile.getParentFile();
        if (!parentDirectory.exists())
            parentDirectory.mkdirs();

        destinationFile.createNewFile();

        InputStream inputStream = new FileInputStream(source);
        OutputStream outputStream = new FileOutputStream(destinationFile);
        copyFile(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private boolean cleanCacheIfNecessary(String prefix, String cacheName)
    {
        Log.i("OpenCPN", "cleanCacheIfNecessary " + prefix);

        long packageVersion = -1;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            packageVersion = packageInfo.lastUpdateTime;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ApplicationInfo ai = getApplicationInfo();
        if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE)
            packageVersion++;

        Log.i("OpenCPN", "cleanCacheIfNecessary: current running packageVersion " + String.valueOf(packageVersion));



        File versionFile = new File(prefix + cacheName);

        Log.i("OpenCPN", "version file: " + prefix + cacheName);

        long cacheVersion = 0;
        if (versionFile.exists() && versionFile.canRead()) {
            Log.i("OpenCPN", "version file exists ");
            try {
                DataInputStream inputStream = new DataInputStream(new FileInputStream(versionFile));
                cacheVersion = inputStream.readLong();
                inputStream.close();
             } catch (Exception e) {
                e.printStackTrace();
             }
        }

        Log.i("OpenCPN", "cleanCacheIfNecessary:  cached value is: " + String.valueOf(cacheVersion));

        if (cacheVersion != packageVersion) {
            //deleteRecursively(new File(prefix));
 //           Log.i("OpenCPN", "cleanCacheIfNecessary return true");
            return true;
        } else {
 //           Log.i("OpenCPN", "cleanCacheIfNecessary return false");

            return false;
        }
    }

    private void extractBundledPluginsAndImports(String pluginsPrefix)
        throws IOException
    {
        Log.i("OpenCPN", "extractBundledPluginsAndImports:  pluginsPrefix is: " + pluginsPrefix);

        ArrayList<String> libs = new ArrayList<String>();

        String dataDir = getApplicationInfo().dataDir + "/";


//        if (!cleanCacheIfNecessary(pluginsPrefix, "cache.version"))
//            return;

        {
            Log.i("OpenCPN", "extractBundledPluginsAndImports:  writing new cache file to: " + pluginsPrefix);

            long packageVersion = -1;
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                packageVersion = packageInfo.lastUpdateTime;
            } catch (Exception e) {
                e.printStackTrace();
            }

            ApplicationInfo ai = getApplicationInfo();
            if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE)
                packageVersion++;

            Log.i("OpenCPN", "extractBundledPluginsAndImports:  value is: " + String.valueOf(packageVersion));

            File versionFile = new File(pluginsPrefix + "cache.version");

            File parentDirectory = versionFile.getParentFile();
            if (!parentDirectory.exists())
                parentDirectory.mkdirs();

            versionFile.createNewFile();

            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(versionFile));
            outputStream.writeLong(packageVersion);
            outputStream.close();
        }

        {
            String key = BUNDLED_IN_LIB_RESOURCE_ID_KEY;
            java.util.Set<String> keys = m_activityInfo.metaData.keySet();
            if (m_activityInfo.metaData.containsKey(key)) {
                String[] list = getResources().getStringArray(m_activityInfo.metaData.getInt(key));

                for (String bundledImportBinary : list) {
                    String[] split = bundledImportBinary.split(":");
                    String sourceFileName = dataDir + "lib/" + split[0];
                    String destinationFileName = pluginsPrefix + split[1];
                    createBundledBinary(sourceFileName, destinationFileName);
                }
            }
        }

        {
            String key = BUNDLED_IN_ASSETS_RESOURCE_ID_KEY;
            if (m_activityInfo.metaData.containsKey(key)) {
                String[] list = getResources().getStringArray(m_activityInfo.metaData.getInt(key));

                for (String fileName : list) {
                    String[] split = fileName.split(":");
                    String sourceFileName = split[0];
                    String destinationFileName = pluginsPrefix + split[1];
                    copyAsset(sourceFileName, destinationFileName);
                }
            }

        }
    }

    private void deleteRecursively(File directory)
    {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    deleteRecursively(file);
                else
                    file.delete();
            }

            directory.delete();
        }
    }

    private void cleanOldCacheIfNecessary(String oldLocalPrefix, String localPrefix)
    {
        Log.i("OpenCPN", "cleanOldCacheIfNecessary:  old: " + oldLocalPrefix + " new: " + localPrefix);

        File newCache = new File(localPrefix);
        if (!newCache.exists()) {
            {
                File oldPluginsCache = new File(oldLocalPrefix + "plugins/");
                if (oldPluginsCache.exists() && oldPluginsCache.isDirectory()){
                    Log.i("OpenCPN", "cleanOldCacheIfNecessary:  clearing old cache");
                    deleteRecursively(oldPluginsCache);
                }
            }

            {
                File oldImportsCache = new File(oldLocalPrefix + "imports/");
                if (oldImportsCache.exists() && oldImportsCache.isDirectory())
                    deleteRecursively(oldImportsCache);
            }

            {
                File oldQmlCache = new File(oldLocalPrefix + "qml/");
                if (oldQmlCache.exists() && oldQmlCache.isDirectory())
                    deleteRecursively(oldQmlCache);
            }
        }
    }

    private void startApp(final boolean firstStart)
    {
        try {
            if (m_activityInfo.metaData.containsKey("android.app.qt_sources_resource_id")) {
                int resourceId = m_activityInfo.metaData.getInt("android.app.qt_sources_resource_id");
                m_sources = getResources().getStringArray(resourceId);
            }

            if (m_activityInfo.metaData.containsKey("android.app.repository"))
                m_repository = m_activityInfo.metaData.getString("android.app.repository");

            if (m_activityInfo.metaData.containsKey("android.app.qt_libs_resource_id")) {
                int resourceId = m_activityInfo.metaData.getInt("android.app.qt_libs_resource_id");
                m_qtLibs = getResources().getStringArray(resourceId);
            }

            if (m_activityInfo.metaData.containsKey("android.app.use_local_qt_libs")
                    && m_activityInfo.metaData.getInt("android.app.use_local_qt_libs") == 1) {
                ArrayList<String> libraryList = new ArrayList<String>();


                String localPrefix = "/data/local/tmp/qt/";
                if (m_activityInfo.metaData.containsKey("android.app.libs_prefix"))
                    localPrefix = m_activityInfo.metaData.getString("android.app.libs_prefix");

                String pluginsPrefix = localPrefix;

                boolean bundlingQtLibs = false;
                if (m_activityInfo.metaData.containsKey("android.app.bundle_local_qt_libs")
                    && m_activityInfo.metaData.getInt("android.app.bundle_local_qt_libs") == 1) {
                    localPrefix = getApplicationInfo().dataDir + "/";
                    pluginsPrefix = localPrefix + "qt-reserved-files/";
                    cleanOldCacheIfNecessary(localPrefix, pluginsPrefix);
                    extractBundledPluginsAndImports(pluginsPrefix);
                    bundlingQtLibs = true;
                }

                if (m_qtLibs != null) {
                    for (int i=0;i<m_qtLibs.length;i++) {
                        libraryList.add(localPrefix
                                        + "lib/lib"
                                        + m_qtLibs[i]
                                        + ".so");
                    }
                }

                if (m_activityInfo.metaData.containsKey("android.app.load_local_libs")) {
                    String[] extraLibs = m_activityInfo.metaData.getString("android.app.load_local_libs").split(":");
                    for (String lib : extraLibs) {
                        if (lib.length() > 0) {
                            if (lib.startsWith("lib/"))
                                libraryList.add(localPrefix + lib);
                            else
                                libraryList.add(pluginsPrefix + lib);
                        }
                    }
                }


                String dexPaths = new String();
                String pathSeparator = System.getProperty("path.separator", ":");
                if (!bundlingQtLibs && m_activityInfo.metaData.containsKey("android.app.load_local_jars")) {
                    String[] jarFiles = m_activityInfo.metaData.getString("android.app.load_local_jars").split(":");
                    for (String jar:jarFiles) {
                        if (jar.length() > 0) {
                            if (dexPaths.length() > 0)
                                dexPaths += pathSeparator;
                            dexPaths += localPrefix + jar;
                        }
                    }
                }

                Bundle loaderParams = new Bundle();
                loaderParams.putInt(ERROR_CODE_KEY, 0);
                loaderParams.putString(DEX_PATH_KEY, dexPaths);
                loaderParams.putString(LOADER_CLASS_NAME_KEY, "org.qtproject.qt5.android.QtActivityDelegate");
                if (m_activityInfo.metaData.containsKey("android.app.static_init_classes")) {
                    loaderParams.putStringArray(STATIC_INIT_CLASSES_KEY,
                                                m_activityInfo.metaData.getString("android.app.static_init_classes").split(":"));
                }
                loaderParams.putStringArrayList(NATIVE_LIBRARIES_KEY, libraryList);
                loaderParams.putString(ENVIRONMENT_VARIABLES_KEY, ENVIRONMENT_VARIABLES
                                                                  + "\tQML2_IMPORT_PATH=" + pluginsPrefix + "/qml"
                                                                  + "\tQML_IMPORT_PATH=" + pluginsPrefix + "/imports"
                                                                  + "\tQT_PLUGIN_PATH=" + pluginsPrefix + "/plugins");

                Intent intent = getIntent();
                if (intent != null) {
                    String parameters = intent.getStringExtra("applicationArguments");
                    if (parameters != null)
                        loaderParams.putString(APPLICATION_PARAMETERS_KEY, parameters.replace(' ', '\t'));
                }

                loadApplication(loaderParams);

                activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

                PackageManager packMan = getPackageManager();
                m_hasGPS = packMan.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);

                return;
            }

            try {
                if (!bindService(new Intent(org.kde.necessitas.ministro.IMinistro.class.getCanonicalName()),
                                 m_ministroConnection,
                                 Context.BIND_AUTO_CREATE)) {
                    throw new SecurityException("");
                }
            } catch (Exception e) {
                if (firstStart) {
                    String msg = "This application requires Ministro service. Would you like to install it?";
                    if (m_activityInfo.metaData.containsKey("android.app.ministro_needed_msg"))
                        msg = m_activityInfo.metaData.getString("android.app.ministro_needed_msg");
                    downloadUpgradeMinistro(msg);
                } else {
                    ministroNotFound();
                }
            }
        } catch (Exception e) {
            Log.e(QtApplication.QtTAG, "Can't create main activity", e);
        }
    }

    /////////////////////////// forward all notifications ////////////////////////////
    /////////////////////////// Super class calls ////////////////////////////////////
    /////////////// PLEASE DO NOT CHANGE THE FOLLOWING CODE //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean dispatchKeyEvent(KeyEvent event)
    {
        if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
            Log.i("OpenCPN", "dispatchKeyEvent (KEYCODE_BACK): " + m_backButtonEnable);

            if(!m_backButtonEnable)
                return false;
        }
        Log.i("OpenCPN", "keyEvent");

        if (QtApplication.m_delegateObject != null && QtApplication.dispatchKeyEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchKeyEvent, event);
        else
            return super.dispatchKeyEvent(event);
    }
    public boolean super_dispatchKeyEvent(KeyEvent event)
    {
        return super.dispatchKeyEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event)
    {
        if (QtApplication.m_delegateObject != null && QtApplication.dispatchPopulateAccessibilityEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchPopulateAccessibilityEvent, event);
        else
            return super.dispatchPopulateAccessibilityEvent(event);
    }
    public boolean super_dispatchPopulateAccessibilityEvent(AccessibilityEvent event)
    {
        return super_dispatchPopulateAccessibilityEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        //Toast.makeText(getApplicationContext(), "dispatchTouchEvent",Toast.LENGTH_LONG).show();

        if( (ev.getAction() == MotionEvent.ACTION_MOVE) && (Math.abs(ev.getRawX() - lastX) < 1.0f) && (Math.abs(ev.getRawY() - lastY) < 1.0f))
            return true;

        lastX = ev.getRawX();
        lastY = ev.getRawY();

        if(ev.getAction() == MotionEvent.ACTION_UP){
            lastX = -1.0f;
            lastY = -1.0f;
        }
//        Log.i("Sending", String.format("%d  x = %5.2f, y=%5.2f", ev.getAction(), ev.getRawX(), ev.getRawY()));

        if (QtApplication.m_delegateObject != null && QtApplication.dispatchTouchEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchTouchEvent, ev);
        else
            return super.dispatchTouchEvent(ev);
    }
    public boolean super_dispatchTouchEvent(MotionEvent event)
    {
        return super.dispatchTouchEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev)
    {
        if (QtApplication.m_delegateObject != null && QtApplication.dispatchTrackballEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchTrackballEvent, ev);
        else
            return super.dispatchTrackballEvent(ev);
    }
    public boolean super_dispatchTrackballEvent(MotionEvent event)
    {
        return super.dispatchTrackballEvent(event);
    }
    //---------------------------------------------------------------------------


    protected void setAppLocale()
    {

        // defer a bit
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
             public void run() {
                  nativeLib.invokeCmdEventCmdString( ID_CMD_SET_LOCALE, "fr");
             }
        }, 100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == OCPN_SETTINGS_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                m_settingsReturn = data.getStringExtra("SettingsString");
                //Log.i("OpenCPN", "onActivityResult.SettingsString: " + m_settingsReturn);
                nativeLib.invokeCmdEventCmdString( ID_CMD_NULL_REFRESH, m_settingsReturn);

                // defer hte application of settings until the screen refreshes
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                     public void run() {
                          nativeLib.invokeCmdEventCmdString( ID_CMD_APPLY_SETTINGS, m_settingsReturn);
                     }
                }, 100);

            //  Apply any Android private settings
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

                Boolean bnoSleep = preferences.getBoolean("prefb_noSleep", false);
                if(bnoSleep)
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                else
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

            }
            else if (resultCode == RESULT_CANCELED){
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_FILECHOOSER_REQUEST_CODE) {
            //Log.i("DEBUGGER_TAG", "onqtActivityResultCf");
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                 //Log.i("DEBUGGER_TAG", "onqtActivityResultDf");
                 m_filechooserString = "file:" + data.getStringExtra("itemSelected");
                 //Log.i("DEBUGGER_TAG", m_filechooserString);
            }
            else if (resultCode == RESULT_CANCELED){
                //Log.i("DEBUGGER_TAG", "onqtActivityResultEf");
                m_filechooserString = "cancel:";
            }

            m_FileChooserDone = true;

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_AFILECHOOSER_REQUEST_CODE) {
            Log.i("OpenCPN", "onqtActivityResultCa");
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                Log.i("OpenCPN", "onqtActivityResultDa");
                boolean fileCreated = false;
                String filePath = "";

                Bundle bundle = data.getExtras();
                if(bundle != null)
                {
                    if(bundle.containsKey(FileChooserActivity.OUTPUT_NEW_FILE_NAME)) {
                            fileCreated = true;
                            File folder = (File) bundle.get(FileChooserActivity.OUTPUT_FILE_OBJECT);
                            String name = bundle.getString(FileChooserActivity.OUTPUT_NEW_FILE_NAME);
                            filePath = folder.getAbsolutePath() + "/" + name;
                    } else {
                            fileCreated = false;
                            File file = (File) bundle.get(FileChooserActivity.OUTPUT_FILE_OBJECT);
                            filePath = file.getAbsolutePath();
                    }

                    m_filechooserString = "file:" + filePath;

                }
            }
            else if (resultCode == Activity.RESULT_CANCELED){
                Log.i("OpenCPN", "onqtActivityResultEa");
                m_filechooserString = "cancel:";
            }

            m_FileChooserDone = true;

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_SAF_DIALOG_A_REQUEST_CODE) {
            Uri treeUri = null;

            if (resultCode == Activity.RESULT_OK) {

                treeUri = data.getData();

                Log.i("OpenCPN", "onqtActivityResult OCPN_SAF_DIALOG_A_REQUEST_CODE...URI is: " + treeUri.toString());

                // Persist URI in shared preference so that you can use it later.
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("SDURI", treeUri.toString());
                editor.commit();


                getContentResolver().takePersistableUriPermission(treeUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


                showPermisionGrantedDialog( true );

                m_FileChooserDone = true;


            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }



        if (requestCode == OCPN_GOOGLEMAPS_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                String finalPosition = data.getStringExtra("finalPosition");
//                Log.i("DEBUGGER_TAG", "finalPositionFromMaps " + finalPosition);

                StringTokenizer tkz = new StringTokenizer(finalPosition, ";");

                String finalLat = finalPosition.valueOf(m_gminitialLat);
                String finalLon = finalPosition.valueOf(m_gminitialLon);
                String finalZoom = finalPosition.valueOf(m_gminitialZoom);
                String zoomFactor = "1.0";

                if(tkz.hasMoreTokens()){
                    finalLat = tkz.nextToken();
                    finalLon = tkz.nextToken();
                    finalZoom = tkz.nextToken();
                    zoomFactor = tkz.nextToken();
                }

                double zoomF = Double.parseDouble(zoomFactor);
                finalZoom = String.valueOf(m_gminitialZoom * zoomF);


                String vpSet = "";

                vpSet = vpSet.concat(finalLat);
                vpSet = vpSet.concat(";");
                vpSet = vpSet.concat(finalLon);
                vpSet = vpSet.concat(";");
                vpSet = vpSet.concat(finalZoom);
                vpSet = vpSet.concat(";");


                Log.i("DEBUGGER_TAG", "finalPositionString " + vpSet);

                nativeLib.invokeCmdEventCmdString( ID_CMD_SETVP, vpSet);

            }
            else if (resultCode == RESULT_CANCELED){
//                Log.i("DEBUGGER_TAG", "onqtActivityResultE");
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_GRIB_REQUEST_CODE) {
//            Log.i("DEBUGGER_TAG", "onqtActivityResultGC");
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
//                Log.i("DEBUGGER_TAG", "onqtActivityResultGD");
                m_GRIBReturn = data.getStringExtra("GRIB_JSON");
//                Log.i("GRIB", m_GRIBReturn);

                //  Add a message ID string to the JSON for later processing
                String json = "";
                try {
                    JSONObject js  = new JSONObject( m_GRIBReturn );
                    js.put("MessageID", "GRIB_APPLY_JSON_CONFIG");
                    json = js.toString();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                nativeLib.invokeCmdEventCmdString( ID_CMD_POST_JSON_TO_PLUGINS, json);

//                nativeLib.sendPluginMessage( "GRIB_APPLY_JSON_CONFIG", m_GRIBReturn);

                // defer hte application of settings until the screen refreshes
                //Handler handler = new Handler();
                //handler.postDelayed(new Runnable() {
                  //   public void run() {
                    //      nativeLib.invokeCmdEventCmdString( ID_CMD_APPLY_SETTINGS, m_settingsReturn);
                    // }
               // }, 100);
            }
            else if (resultCode == RESULT_CANCELED){
//                Log.i("DEBUGGER_TAG", "onqtActivityResultGE");
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_ARBITRARY_REQUEST_CODE) {
            Log.i("OpenCPN", "onqtActivityResult ARB");

            // Make sure the request was successful
            if (resultCode == RESULT_OK){
                // Get the results

                Log.i("OpenCPN", "onqtActivityResult ARB OK");
                m_activityArbResult = data.getStringExtra(m_arbResultStringName);
                Log.i("OpenCPN", "onqtActivityResult ARB Result: " +  m_arbResultStringName + " : " + m_activityArbResult);

            }
            else if (resultCode == RESULT_CANCELED){
                Log.i("OpenCPN", "onqtActivityResult ARB Cancelled");
            }

            super.onActivityResult(requestCode, resultCode, data);

            m_activityARBComplete = true;       // Activity is complete
            return;
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onActivityResult != null) {
            QtApplication.invokeDelegateMethod(QtApplication.onActivityResult, requestCode, resultCode, data);
            return;
        }
        //Log.i("DEBUGGER_TAG", "onqtActivityResultB");
        if (requestCode == MINISTRO_INSTALL_REQUEST_CODE)
            startApp(false);

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void super_onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
    }


    //---------------------------------------------------------------------------
    //  Support for SailTimer Anemometer

    //Define strings for data received action

    public final static String ACTION_DATA_AVAILABLE = "com.ST.bluetooth.le.ACTION_DATA_AVAILABLE";
    public final static String AWD_DATA = "com.ST.bluetooth.le.AWD_DATA";
    public final static String AWS_DATA = "com.ST.bluetooth.le.AWS_DATA";

    double windSpeed = 0;
    double windDirection = 0;

    double windSpeedAvg = 0;
    double windDirectionAvg = 0;

    double averageCount = 10;

    //  Define string for hash code used to decrypt data
    //  This was obtained by executing "TheTask" just once, to get the hash results from SailTimer.com
    //  e.g. new TheTask().execute("https://www.sailtimermaps.com/getHash.php");

    public String hash = "v^2gUAZV7u=wS6xaD^hCxSGT";
/*
    class TheTask extends AsyncTask<String,Void,String>
     {

      @Override
      protected String doInBackground(String... arg0) {
          String text =null;
          try {
              Log.i("DEBUGGER_TAG", "TheTask");
              HttpClient httpclient = new DefaultHttpClient();
              HttpPost httppost = new HttpPost(arg0[0]);

              List < NameValuePair > nameValuePairs = new ArrayList < NameValuePair > (5);
              nameValuePairs.add(new BasicNameValuePair("user", "OpenCPN"));
              nameValuePairs.add(new BasicNameValuePair("password", "<(d!.U5}j6._]CHH"));
              httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


              HttpResponse resp = httpclient.execute(httppost);
              HttpEntity ent = resp.getEntity();
              text = EntityUtils.toString(ent);
          }
          catch (Exception e)
          {
               e.printStackTrace();
          }

          Log.i("DEBUGGER_TAG", "TheTask Text:" + text);
          return text;
      }

      @Override
      protected void onPostExecute(String result) {
          // TODO Auto-generated method stub
          super.onPostExecute(result);
      }

     }
*/
    //BroadcastReceiver which receives broadcasted Intents
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
//                Log.i("OpenCPN", "mGattUpdateReceiver");

                final String action = intent.getAction();
                Bundle b = intent.getExtras();
                if(null == b){
//                    Log.i("OpenCPN", "mGattUpdateReceiver:  NULL Bundle");
                }

                else{
//                    Log.i("OpenCPN", "mGattUpdateReceiver:  process Bundle");
                    if (ACTION_DATA_AVAILABLE.equals(action)) {
                        if (intent.getExtras().containsKey(AWD_DATA)) {
 //                           Log.i("OpenCPN", "mGattUpdateReceiver AWD_DATA");
                            String awd = intent.getStringExtra(AWD_DATA);

                            try {
                                 windDirection = Double.parseDouble(decryptIt(awd,hash));
                            } catch (Exception e) {
                            }
                        }

                        if (intent.getExtras().containsKey(AWS_DATA)) {
 //                           Log.i("OpenCPN", "mGattUpdateReceiver AWS_DATA");
                            String aws = intent.getStringExtra(AWS_DATA);

                            try {
                                windSpeed = Double.parseDouble(decryptIt(aws,hash));
                            } catch (Exception e) {
                            }
                        }
                    }

                //  Low pass filter...
                    windSpeedAvg = (windSpeedAvg * (averageCount-1) / averageCount) + ( windSpeed / averageCount );
                    windDirectionAvg = (windDirectionAvg * (averageCount-1) / averageCount) + ( windDirection / averageCount );

                    final double wsa = windSpeedAvg;
                    final double wda = windDirectionAvg;

                    if(null != nativeLib){
                        Thread thread = new Thread() {
                             @Override
                            public void run() {
                                 nativeLib.processSailTimer(wda, wsa);
                            }
                        };

                        // Don't forget to start the thread.
                        thread.start();
                    }
                }
            }
    };


    public static String decryptIt(String value, String cryptoPass) {
            try {

                DESKeySpec keySpec = new DESKeySpec(cryptoPass.getBytes("UTF8"));
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                SecretKey key = keyFactory.generateSecret(keySpec);
                byte[] encrypedPwdBytes = Base64.decode(value, Base64.DEFAULT);
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] decrypedValueBytes = (cipher.doFinal(encrypedPwdBytes));
                String decrypedValue = new String(decrypedValueBytes);
                return decrypedValue;

            } catch (InvalidKeyException e) {
                e.printStackTrace();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();

            } catch (InvalidKeySpecException e) {
                e.printStackTrace();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();

            } catch (BadPaddingException e) {
                e.printStackTrace();

            } catch (NoSuchPaddingException e) {
                e.printStackTrace();

            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();

            }

        return value;

    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DATA_AVAILABLE);
        return intentFilter;
    }

    private String createMWD( double magDirection, double speedKnots){
        // Create an NMEA sentence
        String s = "$STMWD,,,";

        String sDir = "";
        sDir=sDir.format("%.1f,M,%.1f,N,,M", magDirection, speedKnots);

        s = s.concat(sDir);

        byte[] sb = s.getBytes();

        int sum = 0;
        for(int i=1 ; i < s.length() ;i++){
            sum = sum ^ sb[i];
        }
        int xsum = sum; // % 256;
        String ssum = "";
        ssum =ssum.format("*%2X", xsum);

        s = s.concat(ssum);    // checksum

        return s;
    }


    //---------------------------------------------------------------------------

    @Override
    protected void onApplyThemeResource(Theme theme, int resid, boolean first)
    {
        if (!QtApplication.invokeDelegate(theme, resid, first).invoked)
            super.onApplyThemeResource(theme, resid, first);
    }
    public void super_onApplyThemeResource(Theme theme, int resid, boolean first)
    {
        super.onApplyThemeResource(theme, resid, first);
    }
    //---------------------------------------------------------------------------


    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title)
    {
        if (!QtApplication.invokeDelegate(childActivity, title).invoked)
            super.onChildTitleChanged(childActivity, title);
    }
    public void super_onChildTitleChanged(Activity childActivity, CharSequence title)
    {
        super.onChildTitleChanged(childActivity, title);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        Log.i("OpenCPN", "onConfigurationChanged");


        if (!QtApplication.invokeDelegate(newConfig).invoked)
            super.onConfigurationChanged(newConfig);

        int i = nativeLib.onConfigChange();

    }
    public void super_onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onContentChanged()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onContentChanged();
    }
    public void super_onContentChanged()
    {
        super.onContentChanged();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(item);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onContextItemSelected(item);
    }
    public boolean super_onContextItemSelected(MenuItem item)
    {
        return super.onContextItemSelected(item);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onContextMenuClosed(Menu menu)
    {
        if (!QtApplication.invokeDelegate(menu).invoked)
            super.onContextMenuClosed(menu);
    }
    public void super_onContextMenuClosed(Menu menu)
    {
        super.onContextMenuClosed(menu);
    }
    //---------------------------------------------------------------------------

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.i("OpenCPN", "onCreate" + this);
        String action = getIntent().getAction();
        Log.i("OpenCPN", "onCreate Action: " + action);

        //Toast.makeText(getApplicationContext(), "onCreate",Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);

        fm = getSupportFragmentManager();


        //  Bug fix, see http://code.google.com/p/android/issues/detail?id=26658
        if(!isTaskRoot()) {
            Log.i("OpenCPN", "onCreate NOT ROOT");
            finish();
            return;
        }

        try {
            String dir = getExternalCacheDir().getAbsolutePath();

            final File path = new File(getExternalCacheDir(), "OCPN_logs");
            if (!path.exists()) {
                path.mkdir();
            }
            String spath = path.getAbsolutePath() + File.separator + "OCPN_logcat" + ".txt";

            final File oldFile = new File(spath);
            if(oldFile.exists()){
                Log.i("OpenCPN", "Delete logfile: " + spath);
                oldFile.delete();
            }

            Runtime.getRuntime().exec( "logcat " + "-f " + spath + " -s OpenCPN -s libopencpn.so ");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("OpenCPN", "onCreate Root");


        m_backButtonEnable = false;
        Log.i("OpenCPN", "back button enable: " + m_backButtonEnable);
        setContentView(R.layout.activity_main);


        // We need to get the local data directory, available to all
        Log.i("OpenCPN", "Getting App filesDir..");

        // Verify we have access to the files directory
        //File fa = Environment.getDataDirectory();
        //if(null == fa)
          // Log.i("OpenCPN", "fa null");


        //String sa = Environment.getDataDirectory().getAbsolutePath();
        //if(null == sa)
           //Log.i("OpenCPN", "sa null");
        //else
           //Log.i("OpenCPN", "sa: " + sa);

        String filesDir = "";
        File fFiles = getExternalFilesDir(null);
        if(null != fFiles){
            filesDir = fFiles.getAbsolutePath();
        }
        else{
            filesDir = getFilesDir().getAbsolutePath();
        }


        //  Maybe the app has been migrated to SDCard...
        ApplicationInfo aif = getApplicationInfo();
        if((aif.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
            Log.i("OpenCPN", "App might be on EXTERNAL_STORAGE");

            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT)
            {
                File[] fx = getExternalFilesDirs(null);
                if(null != fx){
                    if(fx.length > 1){
                        Log.i("OpenCPN", "App is really on EXTERNAL_STORAGE");
                        filesDir = fx[1].getAbsolutePath();
                    }
                }
                else{
                    Log.i("OpenCPN", "App has no ExternalFilesDirs");
                }
            }
        }

        m_filesDir = filesDir;
        Log.i("OpenCPN", "Application filesDir: " + m_filesDir);


        //  Set up a handler to catch messages from async tasks
         m_taskHandler = new taskHandler();


        try {
            m_activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            for (Field f : Class.forName("android.R$style").getDeclaredFields()) {
                if (f.getInt(null) == m_activityInfo.getThemeResource()) {
                    QT_ANDROID_THEMES = new String[] {f.getName()};
                    QT_ANDROID_DEFAULT_THEME = f.getName();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            return;
        }

        try {
            setTheme(Class.forName("android.R$style").getDeclaredField(QT_ANDROID_DEFAULT_THEME).getInt(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT > 10) {
            try {
                setTitle("OpenCPN");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        nativeLib = OCPNNativeLib.getInstance();

        mReceiver = new OCPNResultReceiver(new Handler());
        mReceiver.setReceiver(this);


        // USB Serial Port setup
        PackageManager pm = getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_USB_HOST)) {
            uSerialHelper = new UsbSerialHelper();
            Log.i("OpenCPN", "onCreate initUSBSerial");
        }

        // On App Create, we really want the entire app to restart, includiong the Qt parts...
//        if (QtApplication.m_delegateObject != null && QtApplication.onCreate != null) {
//            Log.i("OpenCPN", "onCreate invoking delegate onCreate");
//            QtApplication.invokeDelegateMethod(QtApplication.onCreate, savedInstanceState);
//            return;
//      }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean bnoSleep = preferences.getBoolean("prefb_noSleep", false);
        if(bnoSleep)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        else
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

 //----------------------------------------------------------------------------
        // Set up ActionBar spinner navigation
        actionBar = getActionBar();

        // Setup Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();

        spinnerItemRaster = new SpinnerNavItem("Raster", R.drawable.ic_action_map);
        spinnerItemVector = new SpinnerNavItem("Vector", R.drawable.ic_action_map);
        spinnerItemcm93 = new SpinnerNavItem("cm93", R.drawable.ic_action_map);

        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);
        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(adapter, this);

        configureNavSpinner(7, 0);

//----------------------------------------------------------------------------

        // Register my desire to get locale change notifications
        IntentFilter filter = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
        registerReceiver(mLocaleChangeReceiver, filter);

        ENVIRONMENT_VARIABLES += "\tQT_ANDROID_THEME=" + QT_ANDROID_DEFAULT_THEME
                              + "/\tQT_ANDROID_THEME_DISPLAY_DPI=" + getResources().getDisplayMetrics().densityDpi + "\t";


        if (null == getLastNonConfigurationInstance())
        {
            // if splash screen is defined, then show it
            if (m_activityInfo.metaData.containsKey("android.app.splash_screen") )
                setContentView(m_activityInfo.metaData.getInt("android.app.splash_screen"));

    String tmpdir = "";
 //   ApplicationInfo ai = getApplicationInfo();
 //   if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE)
 //       tmpdir = getExternalFilesDir(null).getPath();
 //   else
        //tmpdir = getFilesDir().getPath();

        tmpdir = getApplicationInfo().dataDir + "/qt-reserved-files/";


        boolean b_needcopy = false;
        if (cleanCacheIfNecessary(tmpdir + "/", "OCPNcache.version"))
            b_needcopy = true;

        //  Take a look for a specific file in the data directory, just to confirm...
        File testFile = new File(m_filesDir + "/license.txt");
        Log.i("OpenCPN", "Checking for required UI files...");
        if(!testFile.exists()){
            Log.i("OpenCPN", "Force copy invoked.");
            b_needcopy = true;
        }


        try{
            long packageVersion = -1;
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                packageVersion = packageInfo.lastUpdateTime;
            } catch (Exception e) {
                e.printStackTrace();
            }

            ApplicationInfo ai = getApplicationInfo();
            if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE)
                    packageVersion++;

            File versionFile = new File(tmpdir + "/OCPNcache.version");

            File parentDirectory = versionFile.getParentFile();
            if (!parentDirectory.exists())
                parentDirectory.mkdirs();

            versionFile.createNewFile();

            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(versionFile));
            outputStream.writeLong(packageVersion);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(b_needcopy){
            Log.i("OpenCPN", "b_needcopy true");
        }
        else{
            Log.i("OpenCPN", "b_needcopy false");
        }





     if (b_needcopy){
        //Toast.makeText(getApplicationContext(), "Please stand by while OpenCPN initializes..." ,Toast.LENGTH_LONG).show();


/*
     // Verify we have access to the files directory
     File fa = Environment.getDataDirectory();
     if(null == fa)
        Log.i("OpenCPN", "fa null");


     String sa = Environment.getDataDirectory().getAbsolutePath();
     if(null == sa)
        Log.i("OpenCPN", "sa null");
     else
        Log.i("OpenCPN", "sa: " + sa);

     String sb = getExternalFilesDir(sa).getAbsolutePath();

     String dirFilesData = getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath();

     File f1 = new File(dirFilesData);
     String dirFiles = f1.getParent();

     File[] fx = getExternalFilesDirs(null);
     //dirData = fx[0].getAbsolutePath();

     //  Maybe the app has been migrated to SDCard...
     sApplicationInfo ai = getApplicationInfo();
     if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
         if(fx.length > 1){
             dirFiles = fx[1].getAbsolutePath();
         }
     }
*/
     String dirFiles = m_filesDir;

     Log.i("OpenCPN", "Checking write access to: " + dirFiles);
     File fc =new File(dirFiles);
     boolean bDirReady = false;
     if(!fc.exists()){
         Log.i("OpenCPN", "Dir does not exist: " + dirFiles);

         try{
             if(fc.mkdirs())
                bDirReady = true;
         }catch(Exception e){
             Log.i("OpenCPN", "Exception on mkdirs: " + dirFiles);
         }
     }
     else
        bDirReady = true;









     boolean bWrite = false;
     try{
         if(fc.canWrite()){
            bWrite = true;
        }
     }catch(Exception e){
        bWrite = false;
     }

     Log.i("OpenCPN", "Write access check result: " + String.valueOf(bWrite));

     // Actually try a write....
     File testWriteDir = new File (dirFiles + "/uidata");
     try{
         if(testWriteDir.mkdirs()){
             Log.i("OpenCPN", "Write access verify result: OK");
         }
     }catch(Exception e){
         Log.i("OpenCPN", "Write access verify result: FAILS");
         bWrite = false;
     }


    // Absolute bailout....
    if(!bWrite || !bDirReady){
        m_filesDir = getFilesDir().getAbsolutePath();
        dirFiles = m_filesDir;
        Log.i("OpenCPN", "Forcing Application filesDir to: " + m_filesDir );
    }






      Log.i("OpenCPN", "asset bridge start unpack");
      Assetbridge.unpackNoDoc(this, dirFiles);
      Log.i("OpenCPN", "asset bridge finish unpack");
    }




   /* Turn off multicast filter */
    WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
   if (wifi != null){
        WifiManager.MulticastLock lock = wifi.createMulticastLock("mylock");
        lock.acquire();
   }



            startApp(true);


        }
    }
    //---------------------------------------------------------------------------


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        if (!QtApplication.invokeDelegate(menu, v, menuInfo).invoked)
            super.onCreateContextMenu(menu, v, menuInfo);
    }
    public void super_onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //---------------------------------------------------------------------------

    @Override
    public CharSequence onCreateDescription()
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
        if (res.invoked)
            return (CharSequence)res.methodReturns;
        else
            return super.onCreateDescription();
    }
    public CharSequence super_onCreateDescription()
    {
        return super.onCreateDescription();
    }
    //---------------------------------------------------------------------------

    @Override
    protected Dialog onCreateDialog(int id)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(id);
        if (res.invoked)
            return (Dialog)res.methodReturns;
        else
            return super.onCreateDialog(id);
    }
    public Dialog super_onCreateDialog(int id)
    {
        return super.onCreateDialog(id);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Log.i("DEBUGGER_TAG", "onCreateOptionsMenu");

//      We don't use Qt menu system, since it does not support ActionBar.
//      We handle ActionBar here, in standard Android manner
//
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(menu);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onCreateOptionsMenu(menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        itemRouteAnnunciator = menu.findItem(R.id.ocpn_route_create_active);
        if( null != itemRouteAnnunciator) {
            itemRouteAnnunciator.setVisible(m_showRouteAnnunciator);
        }

         itemRouteMenuItem = menu.findItem(R.id.ocpn_action_createroute);
         if( null != itemRouteMenuItem) {
             itemRouteMenuItem.setVisible(!m_showRouteAnnunciator);
         }


        // Auto follow icon
         itemFollowActive = menu.findItem(R.id.ocpn_action_follow_active);
         if( null != itemFollowActive) {
             itemFollowActive.setVisible(m_isFollowActive);

          }
         itemFollowInActive = menu.findItem(R.id.ocpn_action_follow);
         if( null != itemFollowInActive) {
              itemFollowInActive.setVisible(!m_isFollowActive);
           }

         // Track icon
         itemTrackActive = menu.findItem(R.id.ocpn_action_track_toggle_ison);
         if( null != itemTrackActive) {
             itemTrackActive.setVisible(m_isTrackActive);
         }
         itemTrackInActive = menu.findItem(R.id.ocpn_action_track_toggle_isoff);
         if( null != itemTrackInActive) {
             itemTrackInActive.setVisible(!m_isTrackActive);
         }


         MenuItem itemSendEmailActive = menu.findItem(R.id.ocpn_action_email);
         itemSendEmailActive.setVisible(false);


        return super.onCreateOptionsMenu(menu);


    }
    public boolean super_onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, menu);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onCreatePanelMenu(featureId, menu);
    }
    public boolean super_onCreatePanelMenu(int featureId, Menu menu)
    {
        return super.onCreatePanelMenu(featureId, menu);
    }
    //---------------------------------------------------------------------------


    @Override
    public View onCreatePanelView(int featureId)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId);
        if (res.invoked)
            return (View)res.methodReturns;
        else
            return super.onCreatePanelView(featureId);
    }
    public View super_onCreatePanelView(int featureId)
    {
        return super.onCreatePanelView(featureId);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(outBitmap, canvas);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onCreateThumbnail(outBitmap, canvas);
    }
    public boolean super_onCreateThumbnail(Bitmap outBitmap, Canvas canvas)
    {
        return super.onCreateThumbnail(outBitmap, canvas);
    }
    //---------------------------------------------------------------------------

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs)
    {
//        Toast.makeText(getApplicationContext(), "onCreateView " + name,Toast.LENGTH_LONG).show();

        QtApplication.InvokeResult res = QtApplication.invokeDelegate(name, context, attrs);
        if (res.invoked)
            return (View)res.methodReturns;
        else
            return super.onCreateView(name, context, attrs);
    }
    public View super_onCreateView(String name, Context context, AttributeSet attrs)
    {
        return super.onCreateView(name, context, attrs);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onDestroy()
    {
        //Toast.makeText(getApplicationContext(), "onDestroy",Toast.LENGTH_LONG).show();
        Log.i("OpenCPN", "onDestroy " + this);

        nativeLib.onDestroy();

        // Disconnect the Locale broadcast receiver
        unregisterReceiver(mLocaleChangeReceiver);

        super.onDestroy();

        QtApplication.invokeDelegate();

        //  The Delegate will not return, since it does (in QtActivityDelegate.java)
        // System.exit(0);// FIXME remove it or find a better way

        Log.i("OpenCPN", "onDestroy Done");

    }
    //---------------------------------------------------------------------------


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_MENU){
            Log.i("OpenCPN", "Menu up");
            return false;
        }


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyDown != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyDown, keyCode, event);
        else
            return super.onKeyDown(keyCode, event);
    }
    public boolean super_onKeyDown(int keyCode, KeyEvent event)
    {
        return super.onKeyDown(keyCode, event);
    }
    //---------------------------------------------------------------------------


    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)
    {
        if (QtApplication.m_delegateObject != null && QtApplication.onKeyMultiple != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyMultiple, keyCode, repeatCount, event);
        else
            return super.onKeyMultiple(keyCode, repeatCount, event);
    }
    public boolean super_onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)
    {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_MENU){
            Log.i("OpenCPN", "Menu up");
            return false;
        }

                if(keyCode==KeyEvent.KEYCODE_BACK){
                    Log.i("OpenCPN", "Back UP, TLWCount " + nativeLib.getTLWCount());

                    if(!m_backButtonEnable)
                        return false;

                    if(nativeLib.getTLWCount() <= 3){

                       if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
                              toast = Toast.makeText(this, "Press back again to close OpenCPN", 3000);
                              toast.show();
                              this.lastBackPressTime = System.currentTimeMillis();
                              return false;
                        } else {
                        this.lastBackPressTime = System.currentTimeMillis();
                        if (toast != null)
                         toast.cancel();
                        }
                    }
                }

        if (QtApplication.m_delegateObject != null  && QtApplication.onKeyDown != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyUp, keyCode, event);
        else
            return super.onKeyUp(keyCode, event);
    }
    public boolean super_onKeyUp(int keyCode, KeyEvent event)
    {
        return super.onKeyUp(keyCode, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onLowMemory()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onLowMemory();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, item);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onMenuItemSelected(featureId, item);
    }
    public boolean super_onMenuItemSelected(int featureId, MenuItem item)
    {
        return super.onMenuItemSelected(featureId, item);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onMenuOpened(int featureId, Menu menu)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, menu);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onMenuOpened(featureId, menu);
    }
    public boolean super_onMenuOpened(int featureId, Menu menu)
    {
        return super.onMenuOpened(featureId, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onNewIntent(Intent intent)
    {
        if (!QtApplication.invokeDelegate(intent).invoked)
            super.onNewIntent(intent);

        Log.i("OpenCPN", "onNewIntent " + this);
/*
        if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(intent.getAction())) {
            //LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            Log.i("DEBUGGER_TAG", "ACTION_USB_DEVICE_ATTACHED");

        }
*/
    }
    public void super_onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(item);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onOptionsItemSelected(item);

        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.ocpn_action_follow:
                //Log.i("DEBUGGER_TAG", "Invoke OCPN_ACTION_FOLLOW while in-active");
                nativeLib.invokeMenuItem(OCPN_ACTION_FOLLOW);
                return true;

                case R.id.ocpn_action_follow_active:
                    //Log.i("DEBUGGER_TAG", "Invoke OCPN_ACTION_FOLLOW while active");
                    nativeLib.invokeMenuItem(OCPN_ACTION_FOLLOW);
                    return true;

                case R.id.ocpn_action_settings_basic:
                    nativeLib.invokeMenuItem(OCPN_ACTION_SETTINGS_BASIC);
                    return true;

                case R.id.ocpn_action_routemanager:
                    nativeLib.invokeMenuItem(OCPN_ACTION_RMD);
                    return true;

                case R.id.ocpn_action_track_toggle_ison:
                    nativeLib.invokeMenuItem(OCPN_ACTION_TRACK_TOGGLE);
                    return true;

                case R.id.ocpn_action_track_toggle_isoff:
                    nativeLib.invokeMenuItem(OCPN_ACTION_TRACK_TOGGLE);
                    return true;

                case R.id.ocpn_action_createroute:              // entering Route Create Mode
                    nativeLib.invokeMenuItem(OCPN_ACTION_ROUTE);
                    return true;

                case R.id.ocpn_route_create_active:             // exiting Route Create mode
                    nativeLib.invokeMenuItem(OCPN_ACTION_ROUTE);
                    return true;

                case R.id.ocpn_action_mob:
                    nativeLib.invokeMenuItem(OCPN_ACTION_MOB);
                    return true;

                case R.id.ocpn_action_tides:
                    nativeLib.invokeMenuItem(OCPN_ACTION_TIDES_TOGGLE);
                    return true;

                case R.id.ocpn_action_currents:
                    nativeLib.invokeMenuItem(OCPN_ACTION_CURRENTS_TOGGLE);
                    return true;

                case R.id.ocpn_action_encText:
                    nativeLib.invokeMenuItem(OCPN_ACTION_ENCTEXT_TOGGLE);
                    return true;

                case R.id.ocpn_action_encSoundings:
                    nativeLib.invokeMenuItem(OCPN_ACTION_ENCSOUNDINGS_TOGGLE);
                        return true;

                case R.id.ocpn_action_encLights:
                    nativeLib.invokeMenuItem(OCPN_ACTION_ENCLIGHTS_TOGGLE);
                        return true;

                case R.id.ocpn_action_googlemaps:
                        invokeGoogleMaps();
                        return true;

                case R.id.ocpn_action_toggle_fullscreen:
                        toggleFullscreen();
                        return true;

                case R.id.ocpn_action_email:
                        ShareViaEmail("OCPN_logs", "OCPN_logcat.txt");
                        return true;


            default:
                return super.onOptionsItemSelected(item);
            }

    }
    public boolean super_onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onOptionsMenuClosed(Menu menu)
    {
        if (!QtApplication.invokeDelegate(menu).invoked)
            super.onOptionsMenuClosed(menu);
    }
    public void super_onOptionsMenuClosed(Menu menu)
    {
        super.onOptionsMenuClosed(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onPanelClosed(int featureId, Menu menu)
    {
        if (!QtApplication.invokeDelegate(featureId, menu).invoked)
            super.onPanelClosed(featureId, menu);
    }
    public void super_onPanelClosed(int featureId, Menu menu)
    {
        super.onPanelClosed(featureId, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPause()
    {
        Log.i("OpenCPN", "onPause "  + this);

        if(null != nativeLib)
           nativeLib.onPause();

        // Disconnect the SailTimer API broadcast receiver
        unregisterReceiver(mGattUpdateReceiver);

        super.onPause();
        QtApplication.invokeDelegate();

        Log.i("OpenCPN", "onPause done");

    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        QtApplication.invokeDelegate(savedInstanceState);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPrepareDialog(int id, Dialog dialog)
    {
        if (!QtApplication.invokeDelegate(id, dialog).invoked)
            super.onPrepareDialog(id, dialog);
    }
    public void super_onPrepareDialog(int id, Dialog dialog)
    {
        super.onPrepareDialog(id, dialog);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        //Log.i("DEBUGGER_TAG", "onPrepareOptionsMenu");


// Use native instead og Qt
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(menu);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onPrepareOptionsMenu(menu);
        ActionBar actionBar = getActionBar();
        if(actionBar != null){

            // set the icon

            // crashes here on some 3.2 devices
            // So, lets require at least Version 4.0 for this method
            if (Build.VERSION.SDK_INT >= 14) {
                actionBar.setLogo(R.drawable.opencpn_mobile);
                actionBar.setDisplayUseLogoEnabled(true);
            }


            //  Use transparent ActionBar background?
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);//or add in style.xml
            //ColorDrawable newColor = new ColorDrawable(getResources().getColor(R.color.action_bar_color));//your color from res
            //newColor.setAlpha(0);//from 0(0%) to 256(100%)
            //getActionBar().setBackgroundDrawable(newColor);

            actionBar.show();
        }


        super.onPrepareOptionsMenu(menu);
        return optionsMenuEnabled;
    }
    public boolean super_onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, view, menu);
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onPreparePanel(featureId, view, menu);
    }
    public boolean super_onPreparePanel(int featureId, View view, Menu menu)
    {
        return super.onPreparePanel(featureId, view, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onRestart()
    {
        //Log.i("OpenCPN", "onRestart");
        super.onRestart();
        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        if (!QtApplication.invokeDelegate(savedInstanceState).invoked)
            super.onRestoreInstanceState(savedInstanceState);
    }
    public void super_onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onResume()
    {
        Log.i("OpenCPN", "onResume "  + this);


        if(null != nativeLib)
            nativeLib.onResume();


        if(null != uSerialHelper){
            uSerialHelper.initUSBSerial(this);
            m_scannedSerial = scanSerialPorts( UsbSerialHelper.SCAN );      // Full scan.
        }

        super.onResume();

        //Register SailTimer broadcast receiver for updates
        registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());


        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------
/*
    @Override
    public Object onRetainNonConfigurationInstance()
    {
        Log.i("OpenCPN", "onRetainNonConfigurationInstance "  + this);

        // We return "null" here, to induce the onCreate method to completely re-init the application
        // This is a bit sub-optimal, but happens mainly on locale changes.
        return null;

//        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
//        if (res.invoked)
//            return res.methodReturns;
//        else
//            return super.onRetainNonConfigurationInstance();
    }
*/
    public Object super_onRetainNonConfigurationInstance()
    {
        return super.onRetainNonConfigurationInstance();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        if (!QtApplication.invokeDelegate(outState).invoked)
            super.onSaveInstanceState(outState);
    }
    public void super_onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onSearchRequested()
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
        if (res.invoked)
            return (Boolean)res.methodReturns;
        else
            return super.onSearchRequested();
    }
    public boolean super_onSearchRequested()
    {
        return super.onSearchRequested();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onStart()
    {
        Log.i("OpenCPN", "onStart " + this);
        nativeLib.onStart();

        super.onStart();
        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onStop()
    {
        Log.i("OpenCPN", "onStop " + this);

        nativeLib.onStop();

        if(null != uSerialHelper)
            uSerialHelper.deinitUSBSerial(this);

        Log.i("OpenCPN", "onStop calling super");

        super.onStop();
        //Log.i("OpenCPN", "onStop invokeDelegate");
        //QtApplication.invokeDelegate();

        Log.i("OpenCPN", "onStop Done");

    }
    //---------------------------------------------------------------------------

    @Override
    protected void onTitleChanged(CharSequence title, int color)
    {
        if (!QtApplication.invokeDelegate(title, color).invoked)
            super.onTitleChanged(title, color);
    }
    public void super_onTitleChanged(CharSequence title, int color)
    {
        super.onTitleChanged(title, color);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (QtApplication.m_delegateObject != null  && QtApplication.onTouchEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onTouchEvent, event);
        else
            return super.onTouchEvent(event);
    }
    public boolean super_onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onTrackballEvent(MotionEvent event)
    {
        if (QtApplication.m_delegateObject != null  && QtApplication.onTrackballEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onTrackballEvent, event);
        else
            return super.onTrackballEvent(event);
    }
    public boolean super_onTrackballEvent(MotionEvent event)
    {
        return super.onTrackballEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onUserInteraction()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onUserInteraction();
    }
    public void super_onUserInteraction()
    {
        super.onUserInteraction();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onUserLeaveHint()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onUserLeaveHint();
    }
    public void super_onUserLeaveHint()
    {
        super.onUserLeaveHint();
    }
    //---------------------------------------------------------------------------

    @Override
    public void onWindowAttributesChanged(LayoutParams params)
    {
        if (!QtApplication.invokeDelegate(params).invoked)
            super.onWindowAttributesChanged(params);
    }
    public void super_onWindowAttributesChanged(LayoutParams params)
    {
        super.onWindowAttributesChanged(params);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        if (!QtApplication.invokeDelegate(hasFocus).invoked)
            super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            if(m_fullScreen){
/*
                 getWindow ().getDecorView().setSystemUiVisibility(
                         View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                         | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                         | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                         | View.SYSTEM_UI_FLAG_FULLSCREEN
                         | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
*/
                int flags =  View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


//                if(!m_showAction){
//                    flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                }

                getWindow ().getDecorView().setSystemUiVisibility( flags );




                     }
 //           else{
 //               getWindow ().getDecorView().setSystemUiVisibility(0);
 //           }
        }

    }
    public void super_onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
    }
    //---------------------------------------------------------------------------

    //////////////// Activity API 5 /////////////
//ANDROID-5
    @Override
    public void onAttachedToWindow()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onAttachedToWindow();
    }
    public void super_onAttachedToWindow()
    {
        super.onAttachedToWindow();
    }
    //---------------------------------------------------------------------------

    private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    public void onBackPressed() {
        Log.i("OpenCPN", "Back Press");

      if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
        toast = Toast.makeText(this, "Press back again to close OpenCPN", 3000);
        toast.show();
        this.lastBackPressTime = System.currentTimeMillis();
      } else {
        if (toast != null) {
        toast.cancel();
      }

      if (!QtApplication.invokeDelegate().invoked)
          super.onBackPressed();
     }
    }
/*
    @Override
    public void onBackPressed()
    {

        if (!QtApplication.invokeDelegate().invoked)
            super.onBackPressed();
    }
*/
    public void super_onBackPressed()
    {
        super.onBackPressed();
    }
    //---------------------------------------------------------------------------

    @Override
    public void onDetachedFromWindow()
    {
        if (!QtApplication.invokeDelegate().invoked)
            super.onDetachedFromWindow();
    }
    public void super_onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event)
    {
        Log.i("OpenCPN", "Long press");

        if (QtApplication.m_delegateObject != null  && QtApplication.onKeyLongPress != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyLongPress, keyCode, event);
        else
            return super.onKeyLongPress(keyCode, event);
    }
    public boolean super_onKeyLongPress(int keyCode, KeyEvent event)
    {
        return super.onKeyLongPress(keyCode, event);
    }
    //---------------------------------------------------------------------------
//ANDROID-5

//////////////// Activity API 8 /////////////
//ANDROID-8
@Override
    protected Dialog onCreateDialog(int id, Bundle args)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(id, args);
        if (res.invoked)
            return (Dialog)res.methodReturns;
        else
            return super.onCreateDialog(id, args);
    }
    public Dialog super_onCreateDialog(int id, Bundle args)
    {
        return super.onCreateDialog(id, args);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args)
    {
        if (!QtApplication.invokeDelegate(id, dialog, args).invoked)
            super.onPrepareDialog(id, dialog, args);
    }
    public void super_onPrepareDialog(int id, Dialog dialog, Bundle args)
    {
        super.onPrepareDialog(id, dialog, args);
    }
    //---------------------------------------------------------------------------
//ANDROID-8
    //////////////// Activity API 11 /////////////

//ANDROID-11
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event)
    {
        if (QtApplication.m_delegateObject != null  && QtApplication.dispatchKeyShortcutEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchKeyShortcutEvent, event);
        else
            return super.dispatchKeyShortcutEvent(event);
    }
    public boolean super_dispatchKeyShortcutEvent(KeyEvent event)
    {
        return super.dispatchKeyShortcutEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onActionModeFinished(ActionMode mode)
    {
        if (!QtApplication.invokeDelegate(mode).invoked)
            super.onActionModeFinished(mode);
    }
    public void super_onActionModeFinished(ActionMode mode)
    {
        super.onActionModeFinished(mode);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onActionModeStarted(ActionMode mode)
    {
        if (!QtApplication.invokeDelegate(mode).invoked)
            super.onActionModeStarted(mode);
    }
    public void super_onActionModeStarted(ActionMode mode)
    {
        super.onActionModeStarted(mode);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onAttachFragment(Fragment fragment)
    {
        if (!QtApplication.invokeDelegate(fragment).invoked)
            super.onAttachFragment(fragment);
    }
    public void super_onAttachFragment(Fragment fragment)
    {
        super.onAttachFragment(fragment);
    }
    //---------------------------------------------------------------------------

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(parent, name, context, attrs);
        if (res.invoked)
            return (View)res.methodReturns;
        else
            return super.onCreateView(parent, name, context, attrs);
    }
    public View super_onCreateView(View parent, String name, Context context,
            AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event)
    {
        if (QtApplication.m_delegateObject != null  && QtApplication.onKeyShortcut != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyShortcut, keyCode,event);
        else
            return super.onKeyShortcut(keyCode, event);
    }
    public boolean super_onKeyShortcut(int keyCode, KeyEvent event)
    {
        return super.onKeyShortcut(keyCode, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public ActionMode onWindowStartingActionMode(Callback callback)
    {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(callback);
        if (res.invoked)
            return (ActionMode)res.methodReturns;
        else
            return super.onWindowStartingActionMode(callback);
    }
    public ActionMode super_onWindowStartingActionMode(Callback callback)
    {
        return super.onWindowStartingActionMode(callback);
    }
    //---------------------------------------------------------------------------
//ANDROID-11
    //////////////// Activity API 12 /////////////

//ANDROID-12
    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev)
    {
        //Toast.makeText(getApplicationContext(), "dispatchGenericMotionEvent",Toast.LENGTH_LONG).show();

        if (QtApplication.m_delegateObject != null  && QtApplication.dispatchGenericMotionEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchGenericMotionEvent, ev);
        else
            return super.dispatchGenericMotionEvent(ev);
    }
    public boolean super_dispatchGenericMotionEvent(MotionEvent event)
    {
        return super.dispatchGenericMotionEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onGenericMotionEvent(MotionEvent event)
    {
//        Log.i("DEBUGGER_TAG", "onGenericMotionEvent");
//        Toast.makeText(getApplicationContext(), "onGenericMotionEvent",Toast.LENGTH_LONG).show();

        if (0 != (event.getSource() & InputDevice.SOURCE_CLASS_POINTER)) {
            switch (event.getAction()) {
              case MotionEvent.ACTION_SCROLL:
              if (event.getAxisValue(MotionEvent.AXIS_VSCROLL) < 0.0f){
                  Log.i("DEBUGGER_TAG", "Scroll Up");
                  nativeLib.onMouseWheel(-1);
              }
              else{
                  Log.i("DEBUGGER_TAG", "Scroll Down");
                  nativeLib.onMouseWheel(1);
              }
            }
          }

        if (QtApplication.m_delegateObject != null  && QtApplication.onGenericMotionEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onGenericMotionEvent, event);
        else
            return super.onGenericMotionEvent(event);
    }
    public boolean super_onGenericMotionEvent(MotionEvent event)
    {
        return super.onGenericMotionEvent(event);
    }
    //---------------------------------------------------------------------------
//ANDROID-12


    private void ShareViaEmail(String folder_name, String file_name) {
        try {
        File Root= getExternalCacheDir();
        String filelocation=Root.getAbsolutePath() + "/" + folder_name + "/" + file_name;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        String message="File to be shared is " + filelocation + ".";
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse( "file://"+filelocation));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setData(Uri.parse("mailto:bdbcat@yahoo.com"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
        } catch(Exception e)  {
        System.out.println("Exception raised during sending mail"+e);
        }
    }


    /**
      * Asynchronous task used to unpack the user manual.
      */

     static final int MESSAGE_DOC_UNPACK_DONE = 1;

     class UnpackUserManual extends AsyncTask<Void, Void, Boolean> {
         private final String mTarget;
         private android.os.Handler mHandler = null;
         private AssetManager mAssetManager;
         private Context mctx;


         UnpackUserManual(String targetDir, AssetManager assetManager, android.os.Handler handler, Context ctx){
             Log.i("OpenCPN", "ctor UnpackUserManual");
             mTarget = targetDir;
             mAssetManager = assetManager;
             mctx = ctx;
             mHandler = handler;
         }

         @Override
         protected Boolean doInBackground(Void... params) {

             Log.i("OpenCPN", "Start UnpackUserManual unpack");

             Assetbridge.unpackDocOnly(mAssetManager, mTarget);

             return true;
         }

         @Override
         protected void onPostExecute(final Boolean success) {


             Message message = Message.obtain (mHandler, MESSAGE_DOC_UNPACK_DONE, 0, 0, mctx);
             if(null != message)
                message.sendToTarget();

         }

         @Override
         protected void onCancelled() {

             Message message = Message.obtain (mHandler, MESSAGE_DOC_UNPACK_DONE, 0, 0, mctx);
             message.sendToTarget();
         }
     }


     public class taskHandler extends Handler {

         @Override
         public void handleMessage(Message msg) {
             Log.i("OpenCPN", "Got Message");

             switch (msg.what) {
                 case MESSAGE_DOC_UNPACK_DONE:
                    Log.i("OpenCPN", "launch Help WebView");
                    if(null != myDocSpinnerInstance)
                        myDocSpinnerInstance.dismiss();

                    Context ctx = (Context) msg.obj;
                    Intent intent = new Intent(ctx, WebViewActivity.class);
                    Bundle b = new Bundle();
                    b.putString(WebViewActivity.SELECTED_URL, "file:///" + m_filesDir + "/doc/doc/help_en_US.html");
                    intent.putExtras(b);

                    startActivity(intent);
                    break;
             }
         }
     }



     public String getExtSdCardFolder(final File file) {
         String[] extSdPaths = getExtSdCardPaths();
         try {
             for (int i = 0; i < extSdPaths.length; i++) {
                 if (file.getCanonicalPath().startsWith(extSdPaths[i])) {
                    return extSdPaths[i];
                 }
            }
         }
         catch (IOException e) {
            return null;
         }

         return null;
    }

     public DocumentFile getDocumentFile(final File file, final boolean isDirectory, boolean bCreate) {
         String baseFolder = getExtSdCardFolder(file);

         if (baseFolder == null) {
             return null;
         }

         String relativePath = null;
         try {
             String fullPath = file.getCanonicalPath();
             if(fullPath.length() > baseFolder.length())
                 relativePath = fullPath.substring(baseFolder.length() + 1);
             else
             relativePath = "";
             }
         catch (IOException e) {
             return null;
         }

         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
         String sUri = preferences.getString("SDURI", "");
         if(sUri.isEmpty())
             return null;

         Uri ltreeUri = Uri.parse(sUri);

         if (ltreeUri == null) {
             return null;
         }


         // start with root of SD card and then parse through document tree.
         DocumentFile document = DocumentFile.fromTreeUri(this, ltreeUri);

         if(relativePath.isEmpty())
             return document;

         try {
             String[] parts = relativePath.split("\\/");
             for (int i = 0; i < parts.length; i++) {
                 DocumentFile nextDocument = document.findFile(parts[i]);

                 if (nextDocument == null) {
                     if(!bCreate)
                     return null;
                     if ((i < parts.length - 1) || isDirectory) {
                         nextDocument = document.createDirectory(parts[i]);
                     } else {
                         nextDocument = document.createFile("image", parts[i]);
                     }
                 }
                 document = nextDocument;
                 }
             }catch(Exception e){
                 int yyp = 0;
             }

         return document;
         }



         private String SecureFileCopy( String inFile, String outFile){
             Log.i("OpenCPN", "SecureFileCopy: " + inFile + " to: " + outFile);

             try{
                FileOutputStream outStream = null;
                FileInputStream inStream;

                //  Is destination on an SDCard?
                if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                    File outFileObj = new File(outFile);
                    String sdRoot = getExtSdCardFolder(outFileObj);
                     if (null != sdRoot) {
                         Log.i("OpenCPN", "SecureFileCopy destination on SDCard");
                         DocumentFile targetDF = getDocumentFile(outFileObj, false, true);

                         try{
                            OutputStream os = getContentResolver().openOutputStream(targetDF.getUri());
                            outStream = (FileOutputStream) os;
                        }catch(Exception e){
                            Log.i("OpenCPN", "SecureFileCopy ExceptionB");
                        }

                    }
                    else{
                        outStream = new FileOutputStream(outFile);
                    }
                }
                else{
                    Log.i("OpenCPN", "SecureFileCopy destination on internal storage");
                    try{
                     outStream = new FileOutputStream(outFile);
                    }catch(Exception e){
                        Log.i("OpenCPN", "SecureFileCopy ExceptionC");
                        return "Exception";
                    }
                }

                inStream = new FileInputStream(inFile);

                try{
                     copyFile( inStream, outStream);
                 }catch(Exception e){
                     Log.i("OpenCPN", "SecureFileCopy ExceptionA");
                 }


                return "OK";

            }catch(Exception e){
                Log.i("OpenCPN", "SecureFileCopy Exception");
                return "Exception";
            }


         }


         private void startSAFDialog(final int code){
              ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AlertTheme1);
              AlertDialog.Builder builder1 = new AlertDialog.Builder(ctw);

              String msg = getString(R.string.sdcard_permission_help);
              builder1.setMessage(msg);
              builder1.setCancelable(true);

              builder1.setPositiveButton(
                      "OK",
                      new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int id) {
                              dialog.cancel();

                              Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                              intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                              intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                              startActivityForResult(intent, code);


                          }
                      });

              //builder1.setNegativeButton(
              //        "No",
              //        new DialogInterface.OnClickListener() {
              //            public void onClick(DialogInterface dialog, int id) {
              //                dialog.cancel();
              //            }
              //        });

              AlertDialog alert11 = builder1.create();
              alert11.show();
          }

          private void showPermisionGrantedDialog(boolean bGranted) {
              ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AlertTheme1);
              AlertDialog.Builder builder1 = new AlertDialog.Builder(ctw);

              if(bGranted)
                  builder1.setMessage(R.string.permission_granted);
              else
                  builder1.setMessage(R.string.permission_denied);

              builder1.setCancelable(true);

              builder1.setPositiveButton(R.string.ok_string,
                      new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int id) {
                              dialog.cancel();
                          }
                      });


              AlertDialog alert11 = builder1.create();
              alert11.show();

          }


}


