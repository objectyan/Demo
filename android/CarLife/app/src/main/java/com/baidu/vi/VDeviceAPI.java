package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navi.util.ShareTools;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class VDeviceAPI {
    private static final int ERROR_INVALID_ADDRESS = 1;
    private static final int ERROR_INVALID_FILE_FORMAT = 2;
    private static final int NETWORK_TYPE_BLUETOOTH = 4;
    private static final int NETWORK_TYPE_MOBILE = 3;
    private static final int NETWORK_TYPE_NONE = 0;
    private static final int NETWORK_TYPE_UNKNOWN = 1;
    private static final int NETWORK_TYPE_WIFI = 2;
    private static final String TAG = "VDeviceAPI in java";
    private static BroadcastReceiver mNetworkStateReceiver = null;
    private static WakeLock mWakeLock = null;

    public static native void onNetworkStateChanged();

    public static long getTotalSpace() {
        StatFs sf = new StatFs(Environment.getRootDirectory().getPath());
        return (((long) sf.getBlockSize()) * ((long) sf.getBlockCount())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getFreeSpace() {
        StatFs sf = new StatFs(Environment.getRootDirectory().getPath());
        return (((long) sf.getBlockSize()) * ((long) sf.getAvailableBlocks())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getSdcardTotalSpace() {
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) sf.getBlockSize()) * ((long) sf.getBlockCount())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getSdcardFreeSpace() {
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) sf.getBlockSize()) * ((long) sf.getAvailableBlocks())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getTotalMemory() {
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader("/proc/meminfo");
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            String str2 = localBufferedReader.readLine();
            if (str2 != null) {
                initial_memory = (long) Integer.valueOf(str2.split("\\s+")[1]).intValue();
            }
            localBufferedReader.close();
            if (localFileReader != null) {
                localFileReader.close();
            }
        } catch (IOException e) {
        }
        return initial_memory;
    }

    public static long getAvailableMemory() {
        ActivityManager am = (ActivityManager) VIContext.getContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        return mi.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static String getOsVersion() {
        return "android";
    }

    public static void setupSoftware(String apkPath) {
        Intent install = new Intent("android.intent.action.VIEW");
        install.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnd.android.package-archive");
        VIContext.getContext().startActivity(install);
    }

    public static String getModuleFileName() {
        return VIContext.getContext().getFilesDir().getAbsolutePath();
    }

    public static String getSdcardPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return externalStorageDirectory != null ? externalStorageDirectory.getAbsolutePath() : null;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getAppVersion() {
        return "10.1.0";
    }

    public static int getCurrentNetworkType() {
        int netType = -1;
        try {
            netType = Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
        } catch (Exception e) {
        }
        return netType;
    }

    public static boolean isWifiConnected() {
        NetworkInfo info = ((ConnectivityManager) VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (info == null || !info.isConnected()) {
            return false;
        }
        return true;
    }

    public static VNetworkInfo getNetworkInfo(int type) {
        ConnectivityManager cm = (ConnectivityManager) VIContext.getContext().getSystemService("connectivity");
        NetworkInfo info = null;
        switch (type) {
            case 2:
                info = cm.getNetworkInfo(1);
                break;
            case 3:
                info = cm.getNetworkInfo(0);
                break;
        }
        if (info != null) {
            return new VNetworkInfo(info);
        }
        return null;
    }

    @Deprecated
    public static int getTelecomInfo() {
        String imsi = ((TelephonyManager) VIContext.getContext().getSystemService("phone")).getSubscriberId();
        if (imsi == null) {
            return -1;
        }
        if (imsi.startsWith("46000") || imsi.startsWith("46002")) {
            return 0;
        }
        if (imsi.startsWith("46001")) {
            return 1;
        }
        if (imsi.startsWith("46003")) {
            return 2;
        }
        return -1;
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        mNetworkStateReceiver = new VDeviceAPI$1();
        VIContext.getContext().registerReceiver(mNetworkStateReceiver, new IntentFilter(NetworkListener.f2257d));
    }

    public static void unsetNetworkChangedCallback() {
        if (mNetworkStateReceiver != null) {
            VIContext.getContext().unregisterReceiver(mNetworkStateReceiver);
            mNetworkStateReceiver = null;
        }
    }

    public static ScanResult[] getWifiHotpot() {
        List<ScanResult> results = ((WifiManager) VIContext.getContext().getSystemService(C1981b.f6365e)).getScanResults();
        return (ScanResult[]) results.toArray(new ScanResult[results.size()]);
    }

    public static float getSystemMetricsX() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wmgr = (WindowManager) VIContext.getContext().getSystemService("window");
        if (wmgr != null) {
            wmgr.getDefaultDisplay().getMetrics(metrics);
        }
        return (float) metrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wmgr = (WindowManager) VIContext.getContext().getSystemService("window");
        if (wmgr != null) {
            wmgr.getDefaultDisplay().getMetrics(metrics);
        }
        return (float) metrics.heightPixels;
    }

    public static float getScreenDensity() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wmgr = (WindowManager) VIContext.getContext().getSystemService("window");
        if (wmgr != null) {
            wmgr.getDefaultDisplay().getMetrics(metrics);
        }
        return metrics.density;
    }

    public static int getScreenDensityDpi() {
        if (VIContext.getContext() == null) {
            return 0;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wmgr = (WindowManager) VIContext.getContext().getSystemService("window");
        if (!(wmgr == null || wmgr.getDefaultDisplay() == null)) {
            wmgr.getDefaultDisplay().getMetrics(metrics);
        }
        return metrics.densityDpi;
    }

    public static void setScreenAlwaysOn(boolean setValue) {
        if (setValue) {
            if (mWakeLock == null) {
                mWakeLock = ((PowerManager) VIContext.getContext().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
            }
            mWakeLock.acquire();
        } else if (mWakeLock != null && mWakeLock.isHeld()) {
            mWakeLock.release();
            mWakeLock = null;
        }
    }

    @TargetApi(8)
    public static int getScreenBrightness() {
        ContentResolver cr = VIContext.getContext().getContentResolver();
        int brightnessmode = 0;
        if (8 <= VERSION.SDK_INT) {
            try {
                brightnessmode = System.getInt(cr, "screen_brightness_mode");
            } catch (Exception e) {
            }
        }
        if (brightnessmode == 1) {
            return -1;
        }
        try {
            return System.getInt(cr, "screen_brightness");
        } catch (SettingNotFoundException e2) {
            return -1;
        }
    }

    public static void makeCall(String number) {
        VIContext.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + number)));
    }

    public static void sendSMS(String number, String content) {
        Intent sendIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + number));
        sendIntent.putExtra("sms_body", content);
        VIContext.getContext().startActivity(sendIntent);
    }

    public static int sendMMS(String number, String subject, String content, String extFile) {
        if (!PhoneNumberUtils.isWellFormedSmsAddress(number)) {
            return 1;
        }
        try {
            String mimetype = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(extFile)).toString()));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, number);
            intent.putExtra(ShareTools.BUNDLE_KEY_SUBJECT, subject);
            intent.putExtra("sms_body", content);
            intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + extFile));
            intent.setType(mimetype);
            VIContext.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            return 2;
        }
    }

    public static void openUrl(String url) {
        VIContext.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    public static String getCellId() {
        TelephonyManager manager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (manager == null) {
            return null;
        }
        CellLocation cellloc = manager.getCellLocation();
        if (cellloc instanceof GsmCellLocation) {
            return " " + ((GsmCellLocation) cellloc).getCid();
        }
        return " ";
    }

    public static String getLac() {
        TelephonyManager manager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (manager == null) {
            return null;
        }
        CellLocation cellloc = manager.getCellLocation();
        if (cellloc instanceof GsmCellLocation) {
            return "" + ((GsmCellLocation) cellloc).getLac();
        }
        return "";
    }

    public static String getImei() {
        TelephonyManager manager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (manager != null) {
            return manager.getDeviceId();
        }
        return null;
    }

    public static String getImsi() {
        TelephonyManager manager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (manager != null) {
            return manager.getSubscriberId();
        }
        return null;
    }

    public static String getCuid() {
        return SysOSAPIv2.getInstance().getCuid();
    }
}
