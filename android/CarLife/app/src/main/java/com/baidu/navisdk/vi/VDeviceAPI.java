package com.baidu.navisdk.vi;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
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
import android.webkit.MimeTypeMap;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navi.util.ShareTools;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.VersionInfo;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import org.apache.http.util.EncodingUtils;

public class VDeviceAPI {
    public static final String APP_NAME_BAIDU_MAP = "BaiduMap";
    public static final String APP_PRODUCT_KIND = "baiduNavi_SDK_FOR_Map";
    private static final int ERROR_INVALID_ADDRESS = 1;
    private static final int ERROR_INVALID_FILE_FORMAT = 2;
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
        long blockSize = 0;
        long availCount = 0;
        try {
            StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
            blockSize = (long) sf.getBlockSize();
            availCount = (long) sf.getAvailableBlocks();
        } catch (Exception e) {
            LogUtil.e(TAG, "getSdcardFreeSpace fail");
        }
        return (blockSize * availCount) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getTotalMemory() {
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader("/proc/meminfo");
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            initial_memory = (long) Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue();
            localBufferedReader.close();
            localFileReader.close();
            return initial_memory;
        } catch (IOException e) {
            return initial_memory;
        }
    }

    public static long getAvailableMemory() {
        ActivityManager am = (ActivityManager) BNaviModuleManager.getContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        return mi.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static String getPhoneType() {
        String type = Build.MODEL;
        if (type == null || (type != null && type.length() == 0)) {
            return "unknown";
        }
        return type;
    }

    public static String getMacAddress() {
        WifiManager wm = (WifiManager) BNaviModuleManager.getContext().getSystemService(C1981b.f6365e);
        if (wm == null || wm.getConnectionInfo() == null) {
            return "";
        }
        String macAddress = wm.getConnectionInfo().getMacAddress();
        LogUtil.e(TAG, "===Mac Address = " + macAddress);
        return macAddress;
    }

    public static void setupSoftware(String apkPath) {
        Intent install = new Intent("android.intent.action.VIEW");
        install.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnd.android.package-archive");
        BNaviModuleManager.getContext().startActivity(install);
    }

    public static String getModuleFileName() {
        return BNaviModuleManager.getContext().getFilesDir().getAbsolutePath();
    }

    public static String getSdcardPath() {
        return SysOSAPI.getInstance().GetSDCardPath();
    }

    public static void showJniToast(String toast) {
        if (BNSettingManager.isShowJavaLog() && BNaviModuleManager.getActivity() != null) {
            LogUtil.e("showJniToast", " showJniToast toast: " + toast);
            BNWorkerCenter.getInstance().submitMainThreadTask(new VDeviceAPI$1("ShowJniToast-" + VDeviceAPI.class.getSimpleName(), null, toast), new BNWorkerConfig(100, 0));
        }
    }

    public static String getCachePath() {
        return SysOSAPI.getInstance().GetSDCardCachePath();
    }

    public static String getDataVersion() {
        return VersionInfo.getDataVersion();
    }

    public static String getSDKVersion() {
        return VersionInfo.getApiVersion();
    }

    public static String getAppPackageVersion() {
        return PackageUtil.getVersionName();
    }

    public static int getAppVersionCode() {
        return PackageUtil.getVersionCode();
    }

    public static String getAppPackageName() {
        return PackageUtil.getPackageName();
    }

    public static int getCurrentNetworkType() {
        return NetworkUtils.getCurrentNetworkType();
    }

    public static int isWifiConnected() {
        return NetworkUtils.isWifiConnected() ? 1 : 0;
    }

    public static VNetworkInfo getNetworkInfo(int type) {
        return NetworkUtils.getNetworkInfo(type);
    }

    public static boolean setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        mNetworkStateReceiver = new VDeviceAPI$2();
        IntentFilter filter = new IntentFilter(NetworkListener.f2257d);
        try {
            Context context = BNaviModuleManager.getContext();
            if (context != null) {
                context.getApplicationContext().registerReceiver(mNetworkStateReceiver, filter);
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean unsetNetworkChangedCallback() {
        if (mNetworkStateReceiver != null) {
            try {
                Context context = BNaviModuleManager.getContext();
                if (context != null) {
                    context.getApplicationContext().unregisterReceiver(mNetworkStateReceiver);
                }
                mNetworkStateReceiver = null;
            } catch (Exception e) {
                mNetworkStateReceiver = null;
            }
        }
        return true;
    }

    public static ScanResult[] getWifiHotpot() {
        List<ScanResult> results = ((WifiManager) BNaviModuleManager.getContext().getSystemService(C1981b.f6365e)).getScanResults();
        return (ScanResult[]) results.toArray(new ScanResult[results.size()]);
    }

    public static float getSystemMetricsX() {
        return (float) ScreenUtil.getInstance().getWidthPixels();
    }

    public static float getSystemMetricsY() {
        return (float) ScreenUtil.getInstance().getHeightPixels();
    }

    public static int getWindowWidth() {
        return ScreenUtil.getInstance().getWindowWidthPixels();
    }

    public static int getWindowHeight() {
        return ScreenUtil.getInstance().getWindowHeightPixels();
    }

    public static float getScreenDensity() {
        return ScreenUtil.getInstance().getDensity();
    }

    public static int getScreenDensityDpi() {
        return ScreenUtil.getInstance().getDPI();
    }

    @SuppressLint({"Wakelock"})
    public static void setScreenAlwaysOn(boolean setValue) {
        if (setValue) {
            try {
                if (mWakeLock == null) {
                    try {
                        PowerManager pm = (PowerManager) BNaviModuleManager.getContext().getSystemService("power");
                        if (pm != null) {
                            mWakeLock = pm.newWakeLock(536870922, "VDeviceAPI");
                        }
                    } catch (Exception e) {
                    }
                }
                if (mWakeLock != null) {
                    mWakeLock.acquire();
                }
            } catch (Exception e2) {
            }
        } else if (mWakeLock != null && mWakeLock.isHeld()) {
            mWakeLock.release();
        }
    }

    public static int getScreenBrightness() {
        ContentResolver cr = BNaviModuleManager.getContext().getContentResolver();
        int brightnessmode = 0;
        try {
            brightnessmode = System.getInt(cr, "screen_brightness_mode");
        } catch (SettingNotFoundException e) {
            LogUtil.e("", e.toString());
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
        BNaviModuleManager.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + number)));
    }

    public static void sendSMS(String number, String content) {
        Intent sendIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + number));
        sendIntent.putExtra("sms_body", content);
        BNaviModuleManager.getContext().startActivity(sendIntent);
    }

    public static int sendMMS(String number, String subject, String content, String extFile) {
        if (PhoneNumberUtils.isWellFormedSmsAddress(number)) {
            try {
                String mimetype = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(extFile)).toString()));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, number);
                intent.putExtra(ShareTools.BUNDLE_KEY_SUBJECT, subject);
                intent.putExtra("sms_body", content);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + extFile));
                intent.setType(mimetype);
                BNaviModuleManager.getContext().startActivity(intent);
                return 0;
            } catch (Exception e) {
                LogUtil.e(TAG, "can't get the mimetype of this file: " + extFile);
                return 2;
            }
        }
        LogUtil.e(TAG, "invalid address: " + number);
        return 1;
    }

    public static void openUrl(String url) {
        BNaviModuleManager.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    public static String getCellId() {
        if (!SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            return " ";
        }
        TelephonyManager manager = (TelephonyManager) BNaviModuleManager.getContext().getSystemService("phone");
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
        if (!SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            return "";
        }
        TelephonyManager manager = (TelephonyManager) BNaviModuleManager.getContext().getSystemService("phone");
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
        String deviceId;
        if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            TelephonyManager manager = (TelephonyManager) BNaviModuleManager.getContext().getSystemService("phone");
            if (manager != null) {
                try {
                    deviceId = manager.getDeviceId();
                } catch (Exception e) {
                }
                return deviceId;
            }
        }
        deviceId = "";
        if (deviceId == null || deviceId.length() == 0 || deviceId.equals("null")) {
            deviceId = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        }
        LogUtil.e(TAG, "VDeviceAPI getImei = " + deviceId);
        return deviceId;
    }

    public static String getImeiWithDefault() {
        if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            TelephonyManager manager = (TelephonyManager) BNaviModuleManager.getContext().getSystemService("phone");
            if (manager != null) {
                try {
                    return manager.getDeviceId();
                } catch (Exception e) {
                }
            }
        }
        LogUtil.e(TAG, "VDeviceAPI getImei with default = 000000000000000");
        return Config.NULL_DEVICE_ID;
    }

    public static String getImsi() {
        if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            TelephonyManager manager = (TelephonyManager) BNaviModuleManager.getContext().getSystemService("phone");
            if (manager != null) {
                try {
                    return manager.getSubscriberId();
                } catch (Exception exception) {
                    if (LogUtil.LOGGABLE) {
                        exception.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static String getChannelID() {
        String channel = "baidu";
        String path = "/data/data/" + BNaviModuleManager.getContext().getPackageName() + "/channel";
        File f = new File(path);
        if (f.exists()) {
            try {
                InputStream in = new FileInputStream(f);
                channel = new BufferedReader(new InputStreamReader(in, "UTF-8")).readLine().toString();
                in.close();
            } catch (Exception e) {
                LogUtil.e("", e.toString());
            }
        } else {
            try {
                InputStream is = JarUtils.getResources().getAssets().open("channel");
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                FileOutputStream os = new FileOutputStream(new File(path));
                os.write(buffer);
                channel = EncodingUtils.getString(buffer, "UTF-8");
                os.close();
                is.close();
            } catch (IOException e2) {
                LogUtil.e("", e2.toString());
            }
        }
        return channel.trim();
    }

    public static String getAppProductKind() {
        LogUtil.e("VDeviceAPI", "getAppProductKind");
        return "baiduNavi_SDK_FOR_Map";
    }

    public static String getCuid() {
        LogUtil.e("VDeviceAPI", "getCuid");
        return PackageUtil.getCuid();
    }

    public static String add(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }

    public static String subtract(String a, String b) {
        return new BigInteger(a).subtract(new BigInteger(b)).toString();
    }

    public static String multiply(String a, String b) {
        return new BigInteger(a).multiply(new BigInteger(b)).toString();
    }

    public static String divide(String a, String b) {
        return new BigInteger(a).divide(new BigInteger(b)).toString();
    }

    public static String mod(String a, String b) {
        return new BigInteger(a).mod(new BigInteger(b)).toString();
    }

    public static boolean gt(String a, String b) {
        return new BigInteger(a).compareTo(new BigInteger(b)) > 0;
    }

    public static boolean lt(String a, String b) {
        return new BigInteger(a).compareTo(new BigInteger(b)) < 0;
    }

    public static boolean nlt(String a, String b) {
        return new BigInteger(a).compareTo(new BigInteger(b)) >= 0;
    }

    public static boolean equals(String a, String b) {
        return new BigInteger(a).compareTo(new BigInteger(b)) == 0;
    }

    public static String powerMod(String a, int p, String b) {
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger c = new BigInteger("1");
        int power = p;
        while (power > 0) {
            if (power % 2 != 0) {
                c = c.multiply(ba).mod(bb);
                power--;
            } else {
                ba = ba.multiply(ba).mod(bb);
                power /= 2;
            }
        }
        return c.mod(bb).toString();
    }
}
