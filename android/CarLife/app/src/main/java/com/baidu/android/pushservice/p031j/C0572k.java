package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;

/* renamed from: com.baidu.android.pushservice.j.k */
public class C0572k {
    /* renamed from: a */
    private static ConnectivityManager f1864a = null;

    /* renamed from: a */
    public static boolean m2457a(Context context) {
        NetworkInfo c = C0572k.m2459c(context);
        return c != null ? c.isConnectedOrConnecting() : false;
    }

    /* renamed from: b */
    public static boolean m2458b(Context context) {
        NetworkInfo c = C0572k.m2459c(context);
        return c != null && c.getType() == 1;
    }

    /* renamed from: c */
    public static NetworkInfo m2459c(Context context) {
        NetworkInfo networkInfo = null;
        try {
            ConnectivityManager f;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                f = C0572k.m2462f(applicationContext);
            } else {
                f = C0572k.m2462f(applicationContext);
            }
            if (f != null) {
                networkInfo = f.getActiveNetworkInfo();
                if (networkInfo == null) {
                    return networkInfo;
                }
            }
        } catch (Exception e) {
        }
        return networkInfo;
    }

    /* renamed from: d */
    public static String m2460d(Context context) {
        String str = "connectionless";
        if (!C0572k.m2457a(context)) {
            return str;
        }
        NetworkInfo c = C0572k.m2459c(context);
        int i = -1;
        if (c != null) {
            i = c.getType();
        }
        switch (i) {
            case 0:
                return "mobile";
            case 1:
                return C1981b.f6365e;
            case 2:
                return "mobile_mms";
            case 3:
                return "mobile_supl";
            case 4:
                return "mobile_dun";
            case 5:
                return "mobile_hipri";
            case 6:
                return "wimax";
            default:
                return str;
        }
    }

    /* renamed from: e */
    public static boolean m2461e(Context context) {
        boolean a = C0572k.m2457a(context);
        if (a || !C0578p.m2601u(context, "android.permission.INTERNET")) {
            return a;
        }
        try {
            C0520a a2 = C0521b.m2163a(C0554h.m2370a(), "GET", null);
            return (a2.m2162b() == 0 || a2.m2159a() == null) ? a : true;
        } catch (Exception e) {
            return a;
        }
    }

    /* renamed from: f */
    private static ConnectivityManager m2462f(Context context) {
        if (context == null) {
            return f1864a;
        }
        if (f1864a == null) {
            f1864a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f1864a;
    }
}
