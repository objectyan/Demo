package com.baidu.che.codriver.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.bluetooth.C1079i;
import com.baidu.che.codriver.C2510a;
import com.baidu.che.codriver.p123i.C2544a;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.util.C2724g.C2723a;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.StatService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CoDriverUtil */
/* renamed from: com.baidu.che.codriver.util.c */
public class C2716c {
    /* renamed from: a */
    private static final String f8888a = "CoDriverUtil";
    /* renamed from: b */
    private static final String f8889b = "unknow";
    /* renamed from: c */
    private static String f8890c;
    /* renamed from: d */
    private static String f8891d;
    /* renamed from: e */
    private static int f8892e = -1;
    /* renamed from: f */
    private static int f8893f;
    /* renamed from: g */
    private static int f8894g;
    /* renamed from: h */
    private static String f8895h;
    /* renamed from: i */
    private static String f8896i;
    /* renamed from: j */
    private static String f8897j;
    /* renamed from: k */
    private static String f8898k;
    /* renamed from: l */
    private static String f8899l;
    /* renamed from: m */
    private static String f8900m;
    /* renamed from: n */
    private static String f8901n;
    /* renamed from: o */
    private static String f8902o;
    /* renamed from: p */
    private static String f8903p;
    /* renamed from: q */
    private static Context f8904q;

    /* renamed from: a */
    public static void m10142a(Context context) {
        f8904q = context;
        try {
            PackageInfo pi = f8904q.getPackageManager().getPackageInfo(f8904q.getPackageName(), 0);
            f8890c = pi.packageName;
            f8891d = pi.versionName;
            f8892e = pi.versionCode;
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) f8904q.getSystemService("window")).getDefaultDisplay().getMetrics(dm);
            f8893f = Math.max(dm.widthPixels, dm.heightPixels);
            f8894g = Math.min(dm.widthPixels, dm.heightPixels);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m10145a(Context context, String av, String ak, String channel, String cuid) {
        C2716c.m10142a(context);
        C2716c.m10150b(av);
        C2716c.m10153c(ak);
        C2716c.m10146a(channel);
        C2716c.m10158e(cuid);
    }

    /* renamed from: a */
    public static Context m10141a() {
        return f8904q;
    }

    /* renamed from: b */
    public static String m10147b() {
        return f8893f + "*" + f8894g;
    }

    /* renamed from: c */
    public static int m10151c() {
        return f8893f;
    }

    /* renamed from: d */
    public static int m10154d() {
        return f8894g;
    }

    /* renamed from: e */
    public static String m10157e() {
        return TextUtils.isEmpty(f8890c) ? "unknow" : f8890c;
    }

    /* renamed from: f */
    public static String m10159f() {
        return TextUtils.isEmpty(f8891d) ? "unknow" : f8891d;
    }

    /* renamed from: g */
    public static int m10161g() {
        return f8892e;
    }

    /* renamed from: h */
    public static String m10162h() {
        return VERSION.RELEASE;
    }

    /* renamed from: i */
    public static String m10163i() {
        return Build.MODEL;
    }

    /* renamed from: j */
    public static String m10164j() {
        if (TextUtils.isEmpty(f8895h)) {
            f8895h = C2716c.m10176v();
        }
        return f8895h;
    }

    /* renamed from: a */
    public static void m10146a(String channel) {
        f8895h = channel;
        C2544a.m9643a(channel);
    }

    /* renamed from: k */
    public static String m10165k() {
        if (TextUtils.isEmpty(f8896i)) {
            f8896i = "3";
        }
        return f8896i;
    }

    /* renamed from: b */
    public static void m10150b(String av) {
        f8896i = av;
    }

    /* renamed from: l */
    public static String m10166l() {
        if (TextUtils.isEmpty(f8897j)) {
            f8897j = "nc";
        }
        return f8897j;
    }

    /* renamed from: c */
    public static void m10153c(String ak) {
        f8897j = ak;
        C2544a.m9645b(ak);
    }

    /* renamed from: m */
    public static String m10167m() {
        return f8903p;
    }

    /* renamed from: d */
    public static void m10156d(String ext) {
        f8903p = ext;
    }

    /* renamed from: n */
    public static String m10168n() {
        return f8898k;
    }

    /* renamed from: e */
    public static void m10158e(String cuid) {
        f8898k = cuid;
    }

    /* renamed from: f */
    public static String m10160f(String input) {
        ArrayList<C2723a> tokens = C2724g.m10195a().m10198a(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0) {
            Iterator it = tokens.iterator();
            while (it.hasNext()) {
                C2723a token = (C2723a) it.next();
                if (2 == token.f8926e) {
                    sb.append(token.f8928g);
                } else {
                    sb.append(token.f8927f);
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: a */
    public static int m10140a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static void m10143a(Context context, String eventId) {
        if (context != null) {
            StatService.onEvent(context.getApplicationContext(), eventId, "StatOnEvent", 1);
        }
    }

    /* renamed from: a */
    public static void m10144a(Context context, String eventId, String label) {
        if (context != null) {
            StatService.onEvent(context.getApplicationContext(), eventId, label, 1);
        }
    }

    /* renamed from: b */
    public static void m10149b(Context context, String eventId) {
        if (context != null) {
            StatService.onEventStart(context.getApplicationContext(), eventId, "StatOnEvent");
            C2725h.m10207b(C2725h.f8938a, "Send mtj event start：" + eventId);
        }
    }

    /* renamed from: c */
    public static void m10152c(Context context, String eventId) {
        if (context != null) {
            StatService.onEventEnd(context.getApplicationContext(), eventId, "StatOnEvent");
            C2725h.m10207b(C2725h.f8938a, "Send mtj event end：" + eventId);
        }
    }

    /* renamed from: d */
    public static void m10155d(Context context, String eventId) {
        if (context != null) {
            StatService.onEventDuration(context.getApplicationContext(), eventId, "StatOnEvent", 1);
            C2725h.m10207b(C2725h.f8938a, "Send mtj event duration：" + eventId);
        }
    }

    /* renamed from: o */
    public static boolean m10169o() {
        return C2510a.f8193j < 6;
    }

    /* renamed from: b */
    private static void m10148b(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService("power");
        if (!pm.isScreenOn()) {
            WakeLock wl = pm.newWakeLock(268435462, "bright");
            wl.acquire();
            wl.release();
        }
    }

    /* renamed from: p */
    public static String m10170p() {
        if (TextUtils.isEmpty(f8899l)) {
            f8899l = ((TelephonyManager) C2716c.m10141a().getSystemService("phone")).getDeviceId();
        }
        if (f8899l == null) {
            f8899l = "";
        }
        return f8899l;
    }

    /* renamed from: q */
    public static String m10171q() {
        if (TextUtils.isEmpty(f8900m)) {
            f8900m = ((TelephonyManager) C2716c.m10141a().getSystemService("phone")).getSubscriberId();
        }
        if (f8900m == null) {
            f8900m = "";
        }
        return f8900m;
    }

    /* renamed from: r */
    public static String m10172r() {
        f8901n = ((WifiManager) C2716c.m10141a().getApplicationContext().getSystemService(C1981b.f6365e)).getConnectionInfo().getMacAddress();
        if (TextUtils.isEmpty(f8901n)) {
            return "";
        }
        f8901n = f8901n.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
        return f8901n;
    }

    /* renamed from: s */
    public static String m10173s() {
        f8902o = C1079i.m3605a();
        if (TextUtils.isEmpty(f8902o)) {
            return "";
        }
        f8902o = f8902o.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
        return f8902o;
    }

    /* renamed from: t */
    public static String m10174t() {
        return Secure.getString(C2716c.m10141a().getContentResolver(), "android_id");
    }

    /* renamed from: u */
    public static boolean m10175u() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C2716c.m10141a().getSystemService("connectivity");
        NetworkInfo activeNetInfo = null;
        if (connectivityManager != null) {
            activeNetInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (activeNetInfo == null || activeNetInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: v */
    private static String m10176v() {
        Exception e;
        Throwable th;
        InputStream in = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            in = f8904q.getResources().openRawResource(C0965R.raw.tnconfig);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    int length = in.read(buffer);
                    if (length == -1) {
                        break;
                    }
                    bos.write(buffer, 0, length);
                }
                String result = new String(bos.toByteArray()).trim();
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e2) {
                        C2725h.m10214e(f8888a, e2.toString());
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e22) {
                        C2725h.m10214e(f8888a, e22.toString());
                    }
                }
                byteArrayOutputStream = bos;
                return result;
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = bos;
                try {
                    C2725h.m10214e(f8888a, e.toString());
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e222) {
                            C2725h.m10214e(f8888a, e222.toString());
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e2222) {
                            C2725h.m10214e(f8888a, e2222.toString());
                        }
                    }
                    return "CoDriver";
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22222) {
                            C2725h.m10214e(f8888a, e22222.toString());
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e222222) {
                            C2725h.m10214e(f8888a, e222222.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = bos;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            C2725h.m10214e(f8888a, e.toString());
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (in != null) {
                in.close();
            }
            return "CoDriver";
        }
    }
}
