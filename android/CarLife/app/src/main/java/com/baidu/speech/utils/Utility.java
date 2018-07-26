package com.baidu.speech.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class Utility {
    private static final int BYTES_PER_SAMPLE_16BIT = 2;
    private static final int BYTES_PER_SAMPLE_8BIT = 1;
    private static final int BYTES_PER_SHORT = 2;
    private static int EVR_NETWORK_TYPE_2G = 1;
    private static int EVR_NETWORK_TYPE_3G = 2;
    private static int EVR_NETWORK_TYPE_4G = 3;
    private static int EVR_NETWORK_TYPE_NO = 0;
    private static int EVR_NETWORK_TYPE_WIFI = 4;
    private static final String TAG = "Utility";
    private static final int THOUSAND_DIV = 1000;
    private static ConnectivityManager mConnManager = null;
    private static int maxCpuFreq = 0;

    private Utility() {
    }

    public static boolean checkPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String fun(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        return stackTrace == null ? "" : stackTrace[0].getMethodName() + "()";
    }

    static String generatePlatformString() {
        StringBuilder stringBuilder = new StringBuilder(C1253f.jb);
        stringBuilder.append('&');
        try {
            stringBuilder.append(URLEncoder.encode(Build.MODEL, "utf-8"));
            stringBuilder.append('&');
            stringBuilder.append(URLEncoder.encode(VERSION.RELEASE, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        stringBuilder.append('&');
        stringBuilder.append(VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static int getCpuInfo() {
        try {
            String readLine;
            String str = "";
            str = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 1024);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (readLine.indexOf("BogoMIPS") == -1);
            str = readLine.split("\\s+")[2];
            bufferedReader.close();
            return (int) (Float.parseFloat(str.trim()) * 1000.0f);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getFileName(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        return (stackTrace == null || stackTrace.length == 0) ? null : stackTrace[0].getFileName();
    }

    public static String getLineNumber(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        return (stackTrace == null || stackTrace.length == 0) ? null : stackTrace[0].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackTrace[0].getLineNumber();
    }

    public static int getMaxCpuFreq() {
        try {
            String str = "";
            if (maxCpuFreq != 0) {
                return maxCpuFreq;
            }
            Object obj;
            if (isRunningEmulator()) {
                Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start();
                InputStream inputStream = start.getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream.read(bArr) != -1) {
                    str = str + new String(bArr);
                }
                inputStream.close();
                start.destroy();
                obj = str;
            } else {
                Reader fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
                String str2 = str;
            }
            int cpuInfo = getCpuInfo();
            if (TextUtils.isEmpty(obj)) {
                return cpuInfo;
            }
            int parseInt = Integer.parseInt(obj.trim());
            if (parseInt >= cpuInfo) {
                cpuInfo = parseInt;
            }
            maxCpuFreq = cpuInfo;
            return maxCpuFreq;
        } catch (Exception e) {
            return 0;
        }
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    static int getStatusType(int i) {
        return -65536 & i;
    }

    public static int getVoiceDataSizeInShort(int i, int i2, int i3) {
        int i4 = 2;
        if (i3 == 2 || i3 == 3) {
            if (i3 == 3) {
                i4 = 1;
            }
            return ((i4 * (i * i2)) / 1000) / 2;
        }
        throw new IllegalArgumentException("audio format invalid");
    }

    @SuppressLint({"DefaultLocale"})
    public static int getWifiOr2gOr3G(Context context) {
        int i;
        int i2 = EVR_NETWORK_TYPE_NO;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (!isNetworkPerission(context)) {
                    return i2;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    if (activeNetworkInfo.getTypeName().toLowerCase().equals(C1981b.f6365e)) {
                        i = EVR_NETWORK_TYPE_WIFI;
                    } else {
                        i = EVR_NETWORK_TYPE_2G;
                        try {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 11:
                                    break;
                                case 3:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 5:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 6:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 7:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 8:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 9:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 10:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 12:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 13:
                                    i = EVR_NETWORK_TYPE_4G;
                                    break;
                                case 14:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                case 15:
                                    i = EVR_NETWORK_TYPE_3G;
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                            Exception e2 = e;
                            e2.printStackTrace();
                            return i;
                        }
                    }
                    return i;
                }
            } catch (Exception e3) {
                Exception exception = e3;
                i = i2;
                e2 = exception;
                e2.printStackTrace();
                return i;
            }
        }
        i = i2;
        return i;
    }

    static void init(Context context) {
        if (context != null) {
            mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
    }

    public static boolean is2G(Context context) {
        try {
            String str = "";
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (!isNetworkPerission(context)) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                if (activeNetworkInfo.getTypeName().toLowerCase().equals(C1981b.f6365e)) {
                    return false;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean isNetworkPerission(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isRunningEmulator() {
        return Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk");
    }

    @SuppressLint({"DefaultLocale"})
    static boolean isUsingWifi() {
        if (mConnManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = mConnManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? C1981b.f6365e.equals(activeNetworkInfo.getTypeName().toLowerCase()) : false;
    }

    static boolean isUsingWifi(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (!isNetworkPerission(context)) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && C1981b.f6365e.equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    public static String urlEncode(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                str = URLEncoder.encode(str, str2);
            }
        } catch (UnsupportedEncodingException e) {
        }
        return str;
    }
}
