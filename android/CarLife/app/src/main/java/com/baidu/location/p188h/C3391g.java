package com.baidu.location.p188h;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.wifihistory.SClient;
import com.baidu.navisdk.util.common.SystemAuth;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;

/* renamed from: com.baidu.location.h.g */
public class C3391g {
    /* renamed from: A */
    public static float f18348A = 2.3f;
    /* renamed from: B */
    public static float f18349B = 3.8f;
    /* renamed from: C */
    public static int f18350C = 3;
    /* renamed from: D */
    public static int f18351D = 10;
    /* renamed from: E */
    public static int f18352E = 2;
    /* renamed from: F */
    public static int f18353F = 7;
    /* renamed from: G */
    public static int f18354G = 20;
    /* renamed from: H */
    public static int f18355H = 70;
    /* renamed from: I */
    public static int f18356I = 120;
    /* renamed from: J */
    public static float f18357J = 2.0f;
    /* renamed from: K */
    public static float f18358K = 10.0f;
    /* renamed from: L */
    public static float f18359L = 50.0f;
    /* renamed from: M */
    public static float f18360M = 200.0f;
    /* renamed from: N */
    public static int f18361N = 16;
    /* renamed from: O */
    public static float f18362O = 0.9f;
    /* renamed from: P */
    public static int f18363P = 10000;
    /* renamed from: Q */
    public static float f18364Q = 0.5f;
    /* renamed from: R */
    public static float f18365R = 0.0f;
    /* renamed from: S */
    public static float f18366S = 0.1f;
    /* renamed from: T */
    public static int f18367T = 30;
    /* renamed from: U */
    public static int f18368U = 100;
    /* renamed from: V */
    public static int f18369V = 0;
    /* renamed from: W */
    public static int f18370W = 0;
    /* renamed from: X */
    public static int f18371X = 0;
    /* renamed from: Y */
    public static int f18372Y = 420000;
    /* renamed from: Z */
    public static boolean f18373Z = true;
    /* renamed from: a */
    public static boolean f18374a = false;
    private static String aA = "http://loc.map.baidu.com/iofd.php";
    private static String aB = "http://loc.map.baidu.com/wloc";
    public static boolean aa = true;
    public static int ab = 20;
    public static int ac = 300;
    public static int ad = 1000;
    public static int ae = Integer.MAX_VALUE;
    public static long af = 900000;
    public static long ag = 420000;
    public static long ah = 180000;
    public static long ai = 0;
    public static long aj = 15;
    public static long ak = 300000;
    public static int al = 1000;
    public static int am = 0;
    public static int an = 30000;
    public static int ao = 30000;
    public static float ap = 10.0f;
    public static float aq = 6.0f;
    public static float ar = 10.0f;
    public static int as = 60;
    public static int at = 70;
    public static int au = 6;
    private static String av = "http://loc.map.baidu.com/sdk.php";
    private static String aw = "http://loc.map.baidu.com/user_err.php";
    private static String ax = "http://loc.map.baidu.com/oqur.php";
    private static String ay = "http://loc.map.baidu.com/tcu.php";
    private static String az = "http://loc.map.baidu.com/rtbu.php";
    /* renamed from: b */
    public static boolean f18375b = false;
    /* renamed from: c */
    public static boolean f18376c = false;
    /* renamed from: d */
    public static int f18377d = 0;
    /* renamed from: e */
    public static String f18378e = "http://loc.map.baidu.com/sdk_ep.php";
    /* renamed from: f */
    public static String f18379f = "https://loc.map.baidu.com/sdk.php";
    /* renamed from: g */
    public static String f18380g = C2848p.f9292S;
    /* renamed from: h */
    public static boolean f18381h = false;
    /* renamed from: i */
    public static boolean f18382i = false;
    /* renamed from: j */
    public static boolean f18383j = false;
    /* renamed from: k */
    public static boolean f18384k = false;
    /* renamed from: l */
    public static boolean f18385l = false;
    /* renamed from: m */
    public static String f18386m = "gcj02";
    /* renamed from: n */
    public static String f18387n = "";
    /* renamed from: o */
    public static boolean f18388o = true;
    /* renamed from: p */
    public static int f18389p = 3;
    /* renamed from: q */
    public static double f18390q = 0.0d;
    /* renamed from: r */
    public static double f18391r = 0.0d;
    /* renamed from: s */
    public static double f18392s = 0.0d;
    /* renamed from: t */
    public static double f18393t = 0.0d;
    /* renamed from: u */
    public static int f18394u = 0;
    /* renamed from: v */
    public static byte[] f18395v = null;
    /* renamed from: w */
    public static boolean f18396w = false;
    /* renamed from: x */
    public static int f18397x = 0;
    /* renamed from: y */
    public static float f18398y = 1.1f;
    /* renamed from: z */
    public static float f18399z = 2.2f;

    /* renamed from: a */
    public static int m14428a(String str, String str2, String str3) {
        int i = Integer.MIN_VALUE;
        if (!(str == null || str.equals(""))) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                indexOf += str2.length();
                int indexOf2 = str.indexOf(str3, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf, indexOf2);
                    if (!(substring == null || substring.equals(""))) {
                        try {
                            i = Integer.parseInt(substring);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public static Object m14429a(Context context, String str) {
        Object obj = null;
        if (context != null) {
            try {
                obj = context.getApplicationContext().getSystemService(str);
            } catch (Throwable th) {
            }
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m14430a(Object obj, String str, Object... objArr) throws Exception {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    /* renamed from: a */
    public static String m14431a() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    /* renamed from: a */
    public static String m14432a(C3362a c3362a, C3372e c3372e, Location location, String str) {
        String b;
        StringBuffer stringBuffer = new StringBuffer();
        if (c3362a != null) {
            b = C3364b.m14262a().m14275b(c3362a);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (c3372e != null) {
            try {
                b = c3372e.m14331a(15);
            } catch (Exception e) {
                b = null;
            }
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (location != null) {
            b = f18377d != 0 ? C3371d.m14308c(location) : C3371d.m14303b(location);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        b = C3381b.m14398a().m14399a(false);
        if (b != null) {
            stringBuffer.append(b);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (c3362a != null) {
            b = C3364b.m14262a().m14274a(c3362a);
            if (b != null && b.length() + stringBuffer.length() < 750) {
                stringBuffer.append(b);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m14433a(C3362a c3362a, C3372e c3372e, Location location, String str, int i) {
        return C3391g.m14434a(c3362a, c3372e, location, str, i, false);
    }

    /* renamed from: a */
    public static String m14434a(C3362a c3362a, C3372e c3372e, Location location, String str, int i, boolean z) {
        String b;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (c3362a != null) {
            b = C3364b.m14262a().m14275b(c3362a);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (c3372e != null) {
            b = i == 0 ? z ? c3372e.m14336b() : c3372e.m14338c() : c3372e.m14341d();
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (location != null) {
            b = (f18377d == 0 || i == 0) ? C3371d.m14303b(location) : C3371d.m14308c(location);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        boolean z2 = false;
        if (i == 0) {
            z2 = true;
        }
        b = C3381b.m14398a().m14399a(z2);
        if (b != null) {
            stringBuffer.append(b);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        Object d = C3218c.m13487a().m13493d();
        if (!TextUtils.isEmpty(d)) {
            stringBuffer.append("&bc=").append(d);
        }
        if (i == 0) {
            b = SClient.getInstance().getWifiHistoryString();
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (c3362a != null) {
            b = C3364b.m14262a().m14274a(c3362a);
            if (b != null && b.length() + stringBuffer.length() < 750) {
                stringBuffer.append(b);
            }
        }
        b = stringBuffer.toString();
        if (location == null || c3372e == null) {
            f18389p = 3;
        } else {
            try {
                float speed = location.getSpeed();
                int i2 = f18377d;
                int j = c3372e.m14350j();
                int a = c3372e.m14330a();
                boolean k = c3372e.m14351k();
                if (speed < aq && ((i2 == 1 || i2 == 0) && (j < as || k))) {
                    f18389p = 1;
                } else if (speed >= ar || (!(i2 == 1 || i2 == 0 || i2 == 3) || (j >= at && a <= au))) {
                    f18389p = 3;
                } else {
                    f18389p = 2;
                }
            } catch (Exception e) {
                f18389p = 3;
            }
        }
        return b;
    }

    /* renamed from: a */
    public static String m14435a(File file, String str) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m14436a(String str) {
        return Jni.en1(f18387n + ";" + str);
    }

    /* renamed from: a */
    public static boolean m14437a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m14438a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    /* renamed from: b */
    public static int m14439b(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception e) {
            return 2;
        }
    }

    /* renamed from: b */
    private static int m14440b(Context context, String str) {
        int i;
        try {
            i = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
        } catch (Exception e) {
            i = 1;
        }
        return i == 0 ? 0 : 1;
    }

    /* renamed from: b */
    public static int m14441b(Object obj, String str, Object... objArr) throws Exception {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    /* renamed from: b */
    public static String m14442b() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        int i7 = instance.get(14);
        return String.format(Locale.CHINA, "%d-%02d-%02d_%02d:%02d:%02d.%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
    }

    /* renamed from: b */
    public static boolean m14443b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str3.getBytes())));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(str.getBytes());
            return instance.verify(Base64.decode(str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static int m14444c(Context context) {
        int i = -1;
        if (VERSION.SDK_INT < 19) {
            return -2;
        }
        try {
            return Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: c */
    public static String m14445c() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        return String.format(Locale.CHINA, "%d-%02d-%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)});
    }

    /* renamed from: d */
    public static String m14446d() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        byte[] address = inetAddress.getAddress();
                        int i = 0;
                        String str = "";
                        while (i < address.length) {
                            String toHexString = Integer.toHexString(address[i] & 255);
                            if (toHexString.length() == 1) {
                                toHexString = '0' + toHexString;
                            }
                            i++;
                            str = str + toHexString;
                        }
                        return str;
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: d */
    public static String m14447d(Context context) {
        int b = C3391g.m14440b(context, "android.permission.ACCESS_COARSE_LOCATION");
        int b2 = C3391g.m14440b(context, "android.permission.ACCESS_FINE_LOCATION");
        return "&per=" + b + "|" + b2 + "|" + C3391g.m14440b(context, SystemAuth.READ_PHONE_STATE_AUTH);
    }

    /* renamed from: e */
    public static String m14448e() {
        return av;
    }

    /* renamed from: e */
    public static String m14449e(Context context) {
        int type;
        int i = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    type = activeNetworkInfo.getType();
                    i = type;
                    return "&netc=" + i;
                }
            } catch (Exception e) {
            }
        }
        type = -1;
        i = type;
        return "&netc=" + i;
    }

    /* renamed from: f */
    public static String m14450f() {
        return ay;
    }

    /* renamed from: g */
    public static String m14451g() {
        return az;
    }

    /* renamed from: h */
    public static String m14452h() {
        return ax;
    }

    /* renamed from: i */
    public static String m14453i() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    /* renamed from: j */
    public static String m14454j() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path + "/baidu/tempdata");
            if (file.exists()) {
                return path;
            }
            file.mkdirs();
            return path;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: k */
    public static String m14455k() {
        String j = C3391g.m14454j();
        return j == null ? null : j + "/baidu/tempdata";
    }

    /* renamed from: l */
    public static String m14456l() {
        try {
            File file = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: m */
    public static String m14457m() {
        try {
            File file = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return C3377f.getServiceContext().getFilesDir().getPath();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: n */
    public static String m14458n() {
        try {
            File file = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "iadt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
}
