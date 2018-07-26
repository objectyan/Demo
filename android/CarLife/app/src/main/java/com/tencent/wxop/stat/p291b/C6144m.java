package com.tencent.wxop.stat.p291b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.SystemAuth;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6161k;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.b.m */
public class C6144m {
    /* renamed from: a */
    private static String f24940a = null;
    /* renamed from: b */
    private static String f24941b = null;
    /* renamed from: c */
    private static String f24942c = null;
    /* renamed from: d */
    private static String f24943d = null;
    /* renamed from: e */
    private static Random f24944e = null;
    /* renamed from: f */
    private static DisplayMetrics f24945f = null;
    /* renamed from: g */
    private static String f24946g = null;
    /* renamed from: h */
    private static String f24947h = "";
    /* renamed from: i */
    private static String f24948i = "";
    /* renamed from: j */
    private static int f24949j = -1;
    /* renamed from: k */
    private static C6133b f24950k = null;
    /* renamed from: l */
    private static String f24951l = null;
    /* renamed from: m */
    private static String f24952m = null;
    /* renamed from: n */
    private static volatile int f24953n = -1;
    /* renamed from: o */
    private static String f24954o = null;
    /* renamed from: p */
    private static String f24955p = null;
    /* renamed from: q */
    private static long f24956q = -1;
    /* renamed from: r */
    private static String f24957r = "";
    /* renamed from: s */
    private static C6147p f24958s = null;
    /* renamed from: t */
    private static String f24959t = "__MTA_FIRST_ACTIVATE__";
    /* renamed from: u */
    private static int f24960u = -1;
    /* renamed from: v */
    private static long f24961v = -1;
    /* renamed from: w */
    private static int f24962w = 0;
    /* renamed from: x */
    private static String f24963x = "";

    /* renamed from: A */
    public static int m21856A(Context context) {
        return C6149r.m21910a(context, "mta.qq.com.difftime", 0);
    }

    /* renamed from: B */
    public static boolean m21857B(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                return runningAppProcessInfo.importance == 400;
            }
        }
        return false;
    }

    /* renamed from: C */
    public static String m21858C(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    /* renamed from: D */
    private static long m21859D(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static int m21860a() {
        return C6144m.m21884g().nextInt(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static int m21861a(Context context, boolean z) {
        if (z) {
            f24962w = C6144m.m21856A(context);
        }
        return f24962w;
    }

    /* renamed from: a */
    public static Long m21862a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    /* renamed from: a */
    public static String m21863a(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    /* renamed from: a */
    public static String m21864a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    /* renamed from: a */
    public static String m21865a(Context context, String str) {
        if (!C6156f.m22049y()) {
            return str;
        }
        if (f24952m == null) {
            f24952m = C6144m.m21895q(context);
        }
        return f24952m != null ? str + JNISearchConst.LAYER_ID_DIVIDER + f24952m : str;
    }

    /* renamed from: a */
    public static String m21866a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    /* renamed from: a */
    public static HttpHost m21867a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
    }

    /* renamed from: a */
    public static void m21868a(Context context, int i) {
        f24962w = i;
        C6149r.m21914b(context, "mta.qq.com.difftime", i);
    }

    /* renamed from: a */
    public static boolean m21869a(C6161k c6161k) {
        return c6161k == null ? false : C6144m.m21876c(c6161k.m22156c());
    }

    /* renamed from: a */
    public static byte[] m21870a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    /* renamed from: b */
    public static long m21871b(String str) {
        return C6144m.m21862a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    /* renamed from: b */
    public static synchronized C6133b m21872b() {
        C6133b c6133b;
        synchronized (C6144m.class) {
            if (f24950k == null) {
                c6133b = new C6133b(C6132a.f24885m);
                f24950k = c6133b;
                c6133b.m21822a(false);
            }
            c6133b = f24950k;
        }
        return c6133b;
    }

    /* renamed from: b */
    public static synchronized String m21873b(Context context) {
        String a;
        synchronized (C6144m.class) {
            if (f24940a == null || f24940a.trim().length() == 0) {
                a = C6150s.m21917a(context);
                f24940a = a;
                if (a == null || f24940a.trim().length() == 0) {
                    f24940a = Integer.toString(C6144m.m21884g().nextInt(Integer.MAX_VALUE));
                }
                a = f24940a;
            } else {
                a = f24940a;
            }
        }
        return a;
    }

    /* renamed from: c */
    public static long m21874c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f24950k.m21826b(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    /* renamed from: c */
    public static synchronized String m21875c(Context context) {
        String str;
        synchronized (C6144m.class) {
            if (f24942c == null || f24942c.trim().length() == 0) {
                f24942c = C6150s.m21922b(context);
            }
            str = f24942c;
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m21876c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* renamed from: d */
    public static DisplayMetrics m21877d(Context context) {
        if (f24945f == null) {
            f24945f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f24945f);
        }
        return f24945f;
    }

    /* renamed from: d */
    public static String m21878d() {
        if (C6144m.m21876c(f24955p)) {
            return f24955p;
        }
        long e = C6144m.m21879e() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(e);
        f24955p = str;
        return str;
    }

    /* renamed from: e */
    public static long m21879e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: e */
    public static boolean m21880e(Context context) {
        try {
            if (C6150s.m21921a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            f24950k.m21829e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
    }

    /* renamed from: f */
    public static String m21882f(Context context) {
        if (f24941b != null) {
            return f24941b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f24941b = string;
                    return string;
                }
                f24950k.m21825b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f24950k.m21825b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: g */
    public static String m21883g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f24950k.m21830f("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f24950k.m21832h("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: g */
    private static synchronized Random m21884g() {
        Random random;
        synchronized (C6144m.class) {
            if (f24944e == null) {
                f24944e = new Random();
            }
            random = f24944e;
        }
        return random;
    }

    /* renamed from: h */
    private static long m21885h() {
        if (f24956q > 0) {
            return f24956q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        f24956q = j;
        return j;
    }

    /* renamed from: h */
    public static String m21886h(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    /* renamed from: i */
    public static String m21887i(Context context) {
        if (f24946g != null) {
            return f24946g;
        }
        try {
            if (!C6150s.m21921a(context, SystemAuth.READ_PHONE_STATE_AUTH)) {
                f24950k.m21832h("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (C6144m.m21889k(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f24946g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
        return f24946g;
    }

    /* renamed from: j */
    public static String m21888j(Context context) {
        if (C6144m.m21876c(f24947h)) {
            return f24947h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f24947h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
        return f24947h;
    }

    /* renamed from: k */
    public static boolean m21889k(Context context) {
        return context.getPackageManager().checkPermission(SystemAuth.READ_PHONE_STATE_AUTH, context.getPackageName()) == 0;
    }

    /* renamed from: l */
    public static String m21890l(Context context) {
        String str = "";
        try {
            if (C6150s.m21921a(context, "android.permission.INTERNET") && C6150s.m21921a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            f24950k.m21832h("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            f24950k.m21826b(th);
            return str;
        }
    }

    /* renamed from: m */
    public static Integer m21891m(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: n */
    public static String m21892n(Context context) {
        if (C6144m.m21876c(f24948i)) {
            return f24948i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f24948i = str;
            if (str == null || f24948i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
        return f24948i;
    }

    /* renamed from: o */
    public static int m21893o(Context context) {
        if (f24949j != -1) {
            return f24949j;
        }
        try {
            if (C6148q.m21909a()) {
                f24949j = 1;
            }
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
        f24949j = 0;
        return 0;
    }

    /* renamed from: p */
    public static String m21894p(Context context) {
        if (C6144m.m21876c(f24951l)) {
            return f24951l;
        }
        try {
            if (C6150s.m21921a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        f24951l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            f24950k.m21829e("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
    }

    /* renamed from: q */
    static String m21895q(Context context) {
        try {
            if (f24952m != null) {
                return f24952m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    f24952m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f24952m;
        } catch (Throwable th) {
        }
    }

    /* renamed from: r */
    public static String m21896r(Context context) {
        return C6144m.m21865a(context, C6132a.f24884l);
    }

    /* renamed from: s */
    public static synchronized Integer m21897s(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (C6144m.class) {
            if (f24953n <= 0) {
                f24953n = C6149r.m21910a(context, "MTA_EVENT_INDEX", 0);
                C6149r.m21914b(context, "MTA_EVENT_INDEX", f24953n + 1000);
            } else if (f24953n % 1000 == 0) {
                try {
                    int i2 = f24953n + 1000;
                    if (f24953n < 2147383647) {
                        i = i2;
                    }
                    C6149r.m21914b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    f24950k.m21830f(th);
                }
            }
            i = f24953n + 1;
            f24953n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    /* renamed from: t */
    public static String m21898t(Context context) {
        try {
            return String.valueOf(C6144m.m21859D(context) / 1000000) + "/" + String.valueOf(C6144m.m21885h() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: u */
    public static JSONObject m21899u(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", C6145n.m21905a());
            String d = C6145n.m21908d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = C6145n.m21906b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = C6145n.m21907c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
            Log.w(C6132a.f24885m, "get cpu error", th);
        }
        return jSONObject;
    }

    /* renamed from: v */
    public static String m21900v(Context context) {
        if (C6144m.m21876c(f24957r)) {
            return f24957r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    f24957r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            f24950k.m21826b(th);
        }
        return f24957r;
    }

    /* renamed from: w */
    public static synchronized int m21901w(Context context) {
        int i;
        synchronized (C6144m.class) {
            if (f24960u != -1) {
                i = f24960u;
            } else {
                C6144m.m21902x(context);
                i = f24960u;
            }
        }
        return i;
    }

    /* renamed from: x */
    public static void m21902x(Context context) {
        int a = C6149r.m21910a(context, f24959t, 1);
        f24960u = a;
        if (a == 1) {
            C6149r.m21914b(context, f24959t, 0);
        }
    }

    /* renamed from: y */
    public static boolean m21903y(Context context) {
        if (f24961v < 0) {
            f24961v = C6149r.m21911a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f24961v) > 86400000;
    }

    /* renamed from: z */
    public static void m21904z(Context context) {
        f24961v = System.currentTimeMillis();
        C6149r.m21915b(context, "mta.qq.com.checktime", f24961v);
    }
}
