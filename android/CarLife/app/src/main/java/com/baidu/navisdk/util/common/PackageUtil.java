package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Random;

public class PackageUtil {
    public static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");
    private static long apkUpdateTime = 0;
    public static final String bNaviSDKVersion = "3.2.0";
    private static boolean fileexit = true;
    public static int iVersionCode;
    private static byte[] mPackageSignature;
    public static int sdkVersion = 0;
    private static String strBuildNo = "0";
    static String strCPUType;
    static String strCUID;
    public static String strChannel;
    static String strDeviceAndroidId;
    static String strDeviceIMEI;
    static String strDeviceIMSI;
    static String strDeviceImeiRand;
    static String strDeviceMac;
    public static String strOSVersion;
    private static String strOem = "baidu";
    private static String strPackageName;
    public static String strPhoneType;
    static String strRealDeviceID = null;
    public static String strSoftWareVer;

    static class Hex {
        Hex() {
        }

        public static String encode(byte[] b) {
            char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(b.length * 2);
            for (int i = 0; i < b.length; i++) {
                sb.append(HEX_DIGITS[(b[i] & RGHUDDataModel.MAX_CAR_SPEED) >> 4]);
                sb.append(HEX_DIGITS[b[i] & 15]);
            }
            return sb.toString();
        }
    }

    public static void init(Context context) {
        initAppVersion(context);
        initAndroidId(context);
        initIMEIandIMSI(context);
        initMacNum(context);
        initApkUpdateTime(context);
        readAndCopyChannel(context, context.getAssets());
    }

    private static void initAppVersion(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            strPackageName = context.getPackageName();
            PackageInfo info = manager.getPackageInfo(strPackageName, 0);
            strSoftWareVer = info.versionName;
            iVersionCode = info.versionCode;
            mPackageSignature = context.getPackageManager().getPackageInfo(strPackageName, 64).signatures[0].toByteArray();
        } catch (Exception e) {
            strSoftWareVer = "1.0.0";
            iVersionCode = 1;
        }
        try {
            sdkVersion = Integer.parseInt(VERSION.SDK);
        } catch (Exception e2) {
        }
        strPhoneType = Build.MODEL;
        strOSVersion = C1253f.jb + VERSION.SDK;
    }

    private static void initIMEIandIMSI(Context context) {
        if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            TelephonyManager manager = (TelephonyManager) context.getSystemService("phone");
            if (manager != null) {
                try {
                    strDeviceIMSI = manager.getSubscriberId();
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            strDeviceIMSI = "0000";
        }
        strDeviceIMEI = generateImeiNum(context);
        strDeviceImeiRand = generateImeiRand(context);
        if (strCUID == null || StringUtils.isEmpty(strCUID)) {
            try {
                Class<?> commonParam = Class.forName("com.baidu.android.common.util.CommonParam");
                if (commonParam != null) {
                    strCUID = (String) commonParam.getMethod("getCUID", new Class[]{Context.class}).invoke(commonParam, new Object[]{context});
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static void initAndroidId(Context context) {
        try {
            strDeviceAndroidId = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            strDeviceAndroidId = "0000000000000000";
        }
    }

    private static void initMacNum(Context context) {
        if (context != null && SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            try {
                if (((TelephonyManager) context.getSystemService("phone")) != null) {
                    WifiManager wifi = (WifiManager) context.getSystemService(C1981b.f6365e);
                    if (wifi != null) {
                        WifiInfo info = wifi.getConnectionInfo();
                        if (info != null) {
                            strDeviceMac = info.getMacAddress();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static String getImeiNum() {
        return strDeviceIMEI;
    }

    public static String getImeiRand() {
        return strDeviceImeiRand;
    }

    public static String getImsiNum() {
        return strDeviceIMSI;
    }

    public static String getAndroidId() {
        return strDeviceAndroidId;
    }

    public static String getCuid() {
        if (strCUID == null || strCUID.length() <= 0) {
            return "00000000000000000000000000000000|000000000000000";
        }
        return strCUID;
    }

    public static void setCuid(String cuid) {
        strCUID = cuid;
    }

    public static String getMacNum() {
        return strDeviceMac;
    }

    private static String generateImeiRand(Context context) {
        Exception e;
        String imeirand = null;
        String FILENAME = "imei.dat";
        try {
            if (!fileexit) {
                imeirand = generateImeiRand();
                FileOutputStream fos = context.openFileOutput(FILENAME, 32768);
                fos.write(("|" + imeirand).getBytes("UTF-8"));
                fos.close();
                return imeirand;
            } else if (context == null) {
                return null;
            } else {
                FileInputStream inputStream = context.openFileInput(FILENAME);
                byte[] b = new byte[inputStream.available()];
                inputStream.read(b);
                inputStream.close();
                String imeirand2 = new String(b, "UTF-8");
                try {
                    return imeirand2.substring(imeirand2.indexOf(124) + 1);
                } catch (Exception e2) {
                    e = e2;
                    imeirand = imeirand2;
                    LogUtil.m15791e("", e.toString());
                    return imeirand;
                }
            }
        } catch (Exception e3) {
            e = e3;
            LogUtil.m15791e("", e.toString());
            return imeirand;
        }
    }

    public static int getVersionCode() {
        return iVersionCode;
    }

    public static String getVersionName() {
        return strSoftWareVer;
    }

    public static String getPackageName() {
        return strPackageName;
    }

    public static int getVersionCode(Context context) {
        return iVersionCode;
    }

    public static byte[] getPackageSignature() {
        return mPackageSignature;
    }

    public static int getSystemVersion() {
        return sdkVersion;
    }

    public static boolean isCalling(Context context) {
        if (!SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            return false;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getCallState()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    private static String generateImeiNum(Context context) {
        Exception e;
        String imei = null;
        String FILENAME = "imei.dat";
        if (context == null) {
            return "";
        }
        if (context.getFilesDir() != null) {
            try {
                if (new File(context.getFilesDir().getAbsolutePath() + "/" + FILENAME).exists()) {
                    fileexit = true;
                    FileInputStream inputStream = context.openFileInput(FILENAME);
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    inputStream.close();
                    String imei2 = new String(b, "UTF-8");
                    try {
                        imei = imei2.substring(0, imei2.indexOf(124));
                    } catch (Exception e2) {
                        e = e2;
                        imei = imei2;
                        LogUtil.m15791e("", e.toString());
                        return imei;
                    }
                }
                fileexit = false;
                imei = getDeviceId(context);
                FileOutputStream fos = context.openFileOutput(FILENAME, 32768);
                fos.write(imei.getBytes("UTF-8"));
                fos.close();
            } catch (Exception e3) {
                e = e3;
                LogUtil.m15791e("", e.toString());
                return imei;
            }
        }
        imei = "";
        return imei;
    }

    private static String generateImeiRand() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer(10);
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static String getDeviceId(Context context) {
        String deviceId = null;
        if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
            try {
                TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
                if (tm != null) {
                    deviceId = tm.getDeviceId();
                }
            } catch (Exception e) {
                LogUtil.m15791e("", e.toString());
            }
        }
        if (TextUtils.isEmpty(deviceId)) {
            return Config.NULL_DEVICE_ID;
        }
        return deviceId;
    }

    private static void readAndCopyChannel(Context context, AssetManager am) {
        try {
            File fchannel = new File(SysOSAPI.getInstance().GetModuleFileName() + "/channel");
            InputStream input = am.open("channel");
            long srcFileLen = (long) input.available();
            if (fchannel.exists() && srcFileLen == fchannel.length() && fchannel.lastModified() > getApkUpdateTime()) {
                input.close();
                strChannel = PreferenceHelper.getInstance(context).getString(PreferenceHelperConst.SP_CHANNEL_ID, strChannel);
                return;
            }
            byte[] b = new byte[((int) srcFileLen)];
            input.read(b);
            input.close();
            strChannel = new String(b).trim();
            PreferenceHelper.getInstance(context).putString(PreferenceHelperConst.SP_CHANNEL_ID, strChannel);
            b = strChannel.getBytes("UTF-8");
            fchannel.createNewFile();
            FileOutputStream out = new FileOutputStream(fchannel);
            out.write(b);
            out.close();
        } catch (Exception e) {
        }
    }

    public static String getChannel() {
        if (strChannel == null || strChannel.length() <= 0) {
            return "baidu";
        }
        return strChannel;
    }

    public static boolean isChannelGooglePlay() {
        return "d1021".equals(strChannel);
    }

    public static boolean isChannelAnzhi() {
        return "d1008".equals(strChannel);
    }

    public static String getBuildNo() {
        return strBuildNo;
    }

    private static void readBuildNumber(Context context) {
        try {
            InputStream input = context.getResources().getAssets().open("build");
            byte[] b = new byte[input.available()];
            input.read(b);
            strBuildNo = new String(b).trim();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readSDKBuildNumber() {
        try {
            InputStream input = JarUtils.getResources().getAssets().open("build");
            byte[] b = new byte[input.available()];
            input.read(b);
            strBuildNo = new String(b).trim();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readAndCopyOem(Context context, AssetManager am) {
        try {
            File oemFile = new File(SysOSAPI.getInstance().GetModuleFileName() + "/oem");
            if (oemFile.exists()) {
                strOem = PreferenceHelper.getInstance(context).getString(PreferenceHelperConst.SP_OEM_ID, strOem);
                return;
            }
            InputStream input = am.open("oem");
            byte[] b = new byte[input.available()];
            input.read(b);
            strOem = new String(b, "UTF-8").trim();
            PreferenceHelper.getInstance(context).putString(PreferenceHelperConst.SP_OEM_ID, strOem);
            b = new String(b).trim().getBytes("UTF-8");
            input.close();
            oemFile.createNewFile();
            FileOutputStream out = new FileOutputStream(oemFile);
            out.write(b);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initApkUpdateTime(Context context) {
        try {
            File apkFile = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            boolean apkFileExists = apkFile.exists();
            LogUtil.m15791e("PackageUtil", "initApkUpdateTime: apkFileExists " + apkFileExists);
            apkUpdateTime = apkFileExists ? apkFile.lastModified() : System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getApkUpdateTime() {
        return apkUpdateTime;
    }

    public static String getAuthString(Context context) {
        String packageName = context.getPackageName();
        return getFingerPrint(context, packageName) + ";" + packageName;
    }

    protected static String getFingerPrint(Context context, String packageName) {
        String hexFingerprint_SHA1 = "";
        try {
            hexFingerprint_SHA1 = getFingerprintAsString((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(getPackageSignature())));
        } catch (CertificateException e) {
        }
        StringBuffer sb = new StringBuffer();
        if (hexFingerprint_SHA1 != null) {
            int i = 0;
            while (i < hexFingerprint_SHA1.length()) {
                sb.append(hexFingerprint_SHA1.charAt(i));
                if (i > 0 && i % 2 == 1 && i < hexFingerprint_SHA1.length() - 1) {
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                }
                i++;
            }
        }
        return sb.toString();
    }

    static String getFingerprintAsString(X509Certificate cert) {
        try {
            return Hex.encode(generateSHA1Fingerprint(cert.getEncoded()));
        } catch (CertificateEncodingException e) {
            return null;
        }
    }

    static byte[] generateSHA1Fingerprint(byte[] ba) {
        try {
            return MessageDigest.getInstance("SHA1").digest(ba);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String getBNaviSDKVersion() {
        return bNaviSDKVersion;
    }

    public static String getCPUType() {
        return strCPUType;
    }

    public static void setCPUType(String cpuType) {
        strCPUType = cpuType;
    }

    public static boolean isSmartisanPhone() {
        if (Build.MANUFACTURER.equals("smartisan")) {
            return true;
        }
        return false;
    }
}
