package com.baidu.android.pushservice.p029h.p030a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController$BNMapConfigParams;
import com.baidu.navisdk.util.common.SystemInfoUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.a.b */
public class C0532b {

    /* renamed from: com.baidu.android.pushservice.h.a.b$a */
    public static class C0531a {
        /* renamed from: a */
        public int f1726a;
        /* renamed from: b */
        public int f1727b;
        /* renamed from: c */
        public int f1728c;
        /* renamed from: d */
        public double f1729d;
        /* renamed from: e */
        public long f1730e;
    }

    /* renamed from: a */
    public static C0531a m2250a() {
        RandomAccessFile randomAccessFile;
        String str;
        C0531a a;
        Throwable th;
        String str2 = "";
        Closeable closeable = null;
        try {
            byte[] bArr = new byte[1024];
            randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
            try {
                randomAccessFile.read(bArr);
                str = new String(bArr);
                int indexOf = str.indexOf(0);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                C0521b.m2169a(randomAccessFile);
            } catch (Exception e) {
                Object obj = randomAccessFile;
                C0521b.m2169a(closeable);
                str = str2;
                a = C0532b.m2251a(str);
                if (a != null) {
                    a.f1730e = (long) C0532b.m2262f();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                C0521b.m2169a(randomAccessFile);
                throw th;
            }
        } catch (Exception e2) {
            C0521b.m2169a(closeable);
            str = str2;
            a = C0532b.m2251a(str);
            if (a != null) {
                a.f1730e = (long) C0532b.m2262f();
            }
            return a;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
            C0521b.m2169a(randomAccessFile);
            throw th;
        }
        a = C0532b.m2251a(str);
        if (a != null) {
            a.f1730e = (long) C0532b.m2262f();
        }
        return a;
    }

    /* renamed from: a */
    private static C0531a m2251a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0531a c0531a = new C0531a();
        c0531a.f1726a = 0;
        c0531a.f1728c = 0;
        c0531a.f1727b = 1;
        c0531a.f1729d = 0.0d;
        if (str.contains("ARMv5")) {
            c0531a.f1726a = 1;
        } else if (str.contains("ARMv6")) {
            c0531a.f1726a = 16;
        } else if (str.contains("ARMv7")) {
            c0531a.f1726a = 256;
        }
        if (str.contains(SystemInfoUtils.K_CPU_FEATURE_NEON)) {
            c0531a.f1728c |= 256;
        }
        if (str.contains(SystemInfoUtils.K_CPU_FEATURE_VFPV3)) {
            c0531a.f1728c |= 16;
        }
        if (str.contains(" vfp")) {
            c0531a.f1728c |= 1;
        }
        String[] split = str.split("\n");
        if (split.length <= 0) {
            return c0531a;
        }
        for (String str2 : split) {
            int indexOf;
            if (str2.contains("CPU variant")) {
                indexOf = str2.indexOf(": ");
                if (indexOf >= 0) {
                    try {
                        c0531a.f1727b = Integer.decode(str2.substring(indexOf + 2)).intValue();
                        c0531a.f1727b = c0531a.f1727b == 0 ? 1 : c0531a.f1727b;
                    } catch (NumberFormatException e) {
                        c0531a.f1727b = 1;
                    }
                }
            } else if (str2.contains("BogoMIPS")) {
                indexOf = str2.indexOf(": ");
                if (indexOf >= 0) {
                    try {
                        c0531a.f1729d = Double.parseDouble(str2.substring(indexOf + 2));
                    } catch (NumberFormatException e2) {
                        c0531a.f1729d = 0.0d;
                    }
                }
            }
        }
        return c0531a;
    }

    /* renamed from: a */
    public static String m2252a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            } catch (IOException e) {
                C0521b.m2169a(inputStream, r1, bufferedReader);
            } catch (Throwable th) {
                C0521b.m2169a(inputStream, r1, bufferedReader);
            }
        }
        C0521b.m2169a(inputStream, r1, bufferedReader);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static int[] m2253a(Context context) {
        int[] iArr = new int[3];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            iArr[1] = displayMetrics.widthPixels;
            iArr[0] = displayMetrics.heightPixels;
        }
        iArr[2] = displayMetrics.densityDpi;
        return iArr;
    }

    /* renamed from: b */
    public static long m2254b() {
        Reader fileReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                String readLine = bufferedReader.readLine();
                long intValue = readLine != null ? (long) (Integer.valueOf(readLine.split("\\s+")[1]).intValue() / 1024) : 0;
                bufferedReader.close();
                C0521b.m2169a(fileReader);
                return intValue;
            } catch (IOException e) {
                C0521b.m2169a(fileReader);
                return -1;
            } catch (Throwable th2) {
                th = th2;
                C0521b.m2169a(fileReader);
                throw th;
            }
        } catch (IOException e2) {
            fileReader = null;
            C0521b.m2169a(fileReader);
            return -1;
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            C0521b.m2169a(fileReader);
            throw th;
        }
    }

    /* renamed from: b */
    public static String m2255b(Context context) {
        return C0572k.m2460d(context);
    }

    /* renamed from: c */
    public static String m2256c() {
        String str = "";
        C0531a a = C0532b.m2250a();
        return a != null ? (a.f1726a & 1) == 1 ? SystemInfoUtils.K_CPU_MODEL_V5 : (a.f1726a & 16) == 16 ? SystemInfoUtils.K_CPU_MODEL_V6 : (a.f1726a & 256) == 256 ? SystemInfoUtils.K_CPU_MODEL_V7 : "unknown" : str;
    }

    /* renamed from: c */
    public static boolean m2257c(Context context) {
        return C0572k.m2457a(context);
    }

    /* renamed from: d */
    public static String m2258d() {
        String str = "";
        C0531a a = C0532b.m2250a();
        return a != null ? (a.f1728c & 256) == 256 ? SystemInfoUtils.K_CPU_FEATURE_NEON : (a.f1728c & 1) == 1 ? SystemInfoUtils.K_CPU_FEATURE_VFP : (a.f1728c & 16) == 16 ? SystemInfoUtils.K_CPU_FEATURE_VFPV3 : "unknown" : str;
    }

    /* renamed from: d */
    public static JSONObject m2259d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                jSONObject.put("type", telephonyManager.getNetworkType());
                jSONObject.put("operator", telephonyManager.getNetworkOperatorName());
            }
            jSONObject.put("access_type", C0532b.m2255b(context));
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 4) {
                    jSONObject.put("mcc", -1);
                    jSONObject.put("mnc", -1);
                } else {
                    try {
                        jSONObject.put("mcc", Integer.parseInt(networkOperator.substring(0, 3)));
                        jSONObject.put("mnc", Integer.parseInt(networkOperator.substring(3)));
                    } catch (NumberFormatException e) {
                        jSONObject.put("mcc", -1);
                        jSONObject.put("mnc", -1);
                    }
                }
            }
            jSONObject.put("user_ip", C0532b.m2260e());
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static String m2260e() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            String str = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    str = !inetAddress.isLoopbackAddress() ? inetAddress.getHostAddress().toString() : str;
                }
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: e */
    public static JSONObject m2261e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String macAddress;
            jSONObject.put("os_name", C1253f.jb);
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put("os_version", VERSION.RELEASE);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("firmware", Build.FINGERPRINT);
            jSONObject.put("mem_size", String.valueOf(C0532b.m2254b()));
            int[] a = C0532b.m2253a(context);
            jSONObject.put(BNMapController$BNMapConfigParams.KEY_SCREEN_WIDTH, String.valueOf(a[0]));
            jSONObject.put(BNMapController$BNMapConfigParams.KEY_SCREEN_HEIGHT, String.valueOf(a[1]));
            jSONObject.put("cpu_model", C0532b.m2256c());
            jSONObject.put("cpu_feature", C0532b.m2258d());
            jSONObject.put("screen_density", String.valueOf(a[2]));
            jSONObject.put("sdk_int", String.valueOf(VERSION.SDK_INT));
            if (((TelephonyManager) context.getSystemService("phone")) != null) {
                jSONObject.put("wise_cuid", C0589e.m2639a(context));
            }
            String string = context.getSharedPreferences("pst", 0).getString("push_mac_id", null);
            if (string == null || string.length() == 0) {
                try {
                    macAddress = ((WifiManager) context.getApplicationContext().getSystemService(C1981b.f6365e)).getConnectionInfo().getMacAddress();
                    if (macAddress != null) {
                        try {
                            if (macAddress.length() > 0) {
                                context.getSharedPreferences("pst", 0).edit().putString("push_mac_id", macAddress).apply();
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    macAddress = string;
                }
            } else {
                macAddress = string;
            }
            if (macAddress != null) {
                if (macAddress.length() > 0) {
                    jSONObject.put("mac_id", macAddress);
                }
            }
        } catch (JSONException e3) {
        }
        return jSONObject;
    }

    /* renamed from: f */
    private static int m2262f() {
        Object obj;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        Reader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String readLine = bufferedReader.readLine();
                    int parseInt = readLine != null ? Integer.parseInt(readLine.trim()) : 0;
                    C0521b.m2169a(fileReader, bufferedReader);
                    return parseInt;
                } catch (Exception e) {
                    Object obj2 = bufferedReader;
                    obj = fileReader;
                    C0521b.m2169a(closeable, closeable2);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    C0521b.m2169a(fileReader, bufferedReader);
                    throw th;
                }
            } catch (Exception e2) {
                obj = fileReader;
                C0521b.m2169a(closeable, closeable2);
                return 0;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                C0521b.m2169a(fileReader, bufferedReader);
                throw th;
            }
        } catch (Exception e3) {
            closeable = null;
            C0521b.m2169a(closeable, closeable2);
            return 0;
        } catch (Throwable th32) {
            fileReader = null;
            th = th32;
            bufferedReader = null;
            C0521b.m2169a(fileReader, bufferedReader);
            throw th;
        }
    }
}
