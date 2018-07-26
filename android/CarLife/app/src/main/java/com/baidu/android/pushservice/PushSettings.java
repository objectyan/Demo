package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p025d.C0473d;
import com.baidu.android.pushservice.p031j.C0562b;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;

public class PushSettings {
    /* renamed from: a */
    private static int f1343a = -1;
    /* renamed from: b */
    private static int f1344b = -1;
    /* renamed from: c */
    private static int f1345c = -1;
    /* renamed from: d */
    private static int f1346d = -1;
    /* renamed from: e */
    private static int f1347e = -1;

    /* renamed from: a */
    public static String m1816a(Context context) {
        Object a = C0562b.m2419a(context, "com.baidu.pushservice.channel_id");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        a = C0574m.m2465a(context, "com.baidu.pushservice.channel_id");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        CharSequence d = C0472c.m2035d(context);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String str = d;
        for (ResolveInfo resolveInfo : C0578p.m2502F(context) ? C0578p.m2588o(context.getApplicationContext()) : C0578p.m2587n(context.getApplicationContext())) {
            str = C0473d.m2043a(context, resolveInfo.activityInfo.packageName);
            if (!TextUtils.isEmpty(str)) {
                m1819a(context, str);
                return str;
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m1817a(Context context, int i) {
        if (context != null) {
            C0574m.m2466a(context, "com.baidu.pushservice.sd", i);
        }
    }

    /* renamed from: a */
    public static void m1818a(Context context, long j) {
        if (context != null) {
            C0574m.m2467a(context, "com.baidu.pushservice.cst", j);
        }
    }

    /* renamed from: a */
    protected static void m1819a(Context context, String str) {
        C0562b.m2422a(context, "com.baidu.pushservice.channel_id", str);
        C0574m.m2470a(context, "com.baidu.pushservice.channel_id", str);
        C0472c.m2024a(context, str);
    }

    /* renamed from: a */
    public static void m1820a(Context context, boolean z) {
        Object obj = null;
        if (context != null && !TextUtils.isEmpty(context.getPackageName())) {
            Object a = C0574m.m2465a(context, "com.baidu.pushservice.le");
            if (!TextUtils.isEmpty(a)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String str : a.trim().split(",")) {
                    if (str.equals(context.getPackageName())) {
                        obj = 1;
                        if (!z) {
                        }
                    }
                    stringBuilder.append(str + ",");
                }
                if (obj == null) {
                    stringBuilder.append(context.getPackageName() + ",");
                }
                C0574m.m2470a(context, "com.baidu.pushservice.le", stringBuilder.toString());
            } else if (z) {
                C0574m.m2470a(context, "com.baidu.pushservice.le", context.getPackageName() + ",");
            }
        }
    }

    /* renamed from: b */
    public static String m1821b(Context context) {
        return C0574m.m2465a(context, "com.baidu.pushservice.app_id");
    }

    /* renamed from: b */
    public static void m1822b(Context context, int i) {
        if (context != null) {
            C0574m.m2466a(context, "com.baidu.pushservice.lsi", i * 1000);
        }
    }

    /* renamed from: b */
    public static void m1823b(Context context, long j) {
        if (context != null) {
            C0574m.m2467a(context, "com.baidu.pushservice.st", j);
        }
    }

    /* renamed from: b */
    protected static void m1824b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            C0574m.m2470a(context, "com.baidu.pushservice.app_id", str);
        }
    }

    /* renamed from: b */
    private static void m1825b(Context context, boolean z) {
        try {
            String packageName = context.getPackageName();
            CharSequence v = C0578p.m2603v(context);
            String str = "com.baidu.android.pushservice.action.OPENDEBUGMODE";
            if (!TextUtils.isEmpty(v) && !packageName.equals(v)) {
                if (!z) {
                    str = "com.baidu.android.pushservice.action.CLOSEDEBUGMODE";
                }
                C0577o.m2484a(context, new Intent(str));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static void m1826c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Object a = C0574m.m2465a(context, "com.baidu.pushservice.le");
            if (!TextUtils.isEmpty(a)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String str2 : a.trim().split(",")) {
                    if (!str2.equals(str)) {
                        stringBuilder.append(str2 + ",");
                    }
                }
                C0574m.m2470a(context, "com.baidu.pushservice.le", stringBuilder.toString());
            }
        }
    }

    /* renamed from: c */
    public static boolean m1827c(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        int d = C0574m.m2476d(context, "com.baidu.android.pushservice.PushSettings.debug_mode", -1);
        if (f1343a == 1) {
            return d == -1 || d == 1;
        } else {
            if (d != 1) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: d */
    public static long m1828d(Context context) {
        return context == null ? 0 : C0574m.m2474c(context, "com.baidu.pushservice.cst");
    }

    /* renamed from: e */
    public static long m1829e(Context context) {
        long c = C0574m.m2474c(context, "com.baidu.pushservice.st");
        return c <= 0 ? 86400000 : c;
    }

    public static void enableDebugMode(Context context, boolean z) {
        if (z) {
            C0574m.m2475c(context, "com.baidu.android.pushservice.PushSettings.debug_mode", 1);
        } else {
            C0574m.m2475c(context, "com.baidu.android.pushservice.PushSettings.debug_mode", 0);
        }
        if (!C0448d.m1945g(context)) {
            m1825b(context, z);
        }
    }

    /* renamed from: f */
    public static boolean m1830f(Context context) {
        return C0574m.m2471b(context, "com.baidu.pushservice.sd", 0) == 1;
    }

    /* renamed from: g */
    public static int m1831g(Context context) {
        if (context == null) {
            return 0;
        }
        int b = C0574m.m2471b(context, "com.baidu.pushservice.lsi", -1);
        return b < 0 ? 1800000 : b;
    }

    /* renamed from: h */
    public static boolean m1832h(Context context) {
        return !TextUtils.isEmpty(C0574m.m2465a(context, "com.baidu.pushservice.le"));
    }

    /* renamed from: i */
    public static boolean m1833i(Context context) {
        return TextUtils.equals(C0574m.m2465a(context, "com.baidu.pushservice.lms"), "off");
    }

    /* renamed from: j */
    public static void m1834j(Context context) {
        if (context == null) {
            C0574m.m2470a(context, "com.baidu.pushservice.lms", "off");
        } else {
            C0574m.m2470a(context, "com.baidu.pushservice.lms", "off");
        }
    }

    /* renamed from: k */
    public static void m1835k(Context context) {
        if (context == null) {
            C0574m.m2470a(context, "com.baidu.pushservice.lms", "");
        } else {
            C0574m.m2470a(context, "com.baidu.pushservice.lms", "");
        }
    }

    /* renamed from: l */
    public static void m1836l(Context context) {
        if (context != null) {
            Object a = C0574m.m2465a(context, "com.baidu.pushservice.le");
            if (!TextUtils.isEmpty(a)) {
                StringBuilder stringBuilder = new StringBuilder();
                String[] split = a.trim().split(",");
                PackageManager packageManager = context.getPackageManager();
                for (String str : split) {
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(str, 0);
                    } catch (Exception e) {
                    }
                    if (packageInfo != null) {
                        stringBuilder.append(str + ",");
                    }
                }
                C0574m.m2470a(context, "com.baidu.pushservice.le", stringBuilder.toString());
            }
        }
    }

    /* renamed from: m */
    public static boolean m1837m(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (f1344b == -1) {
            f1344b = C0574m.m2471b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
        }
        if (f1344b != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: n */
    public static boolean m1838n(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (f1346d == -1) {
            f1346d = C0574m.m2471b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
        }
        if (f1346d != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: o */
    public static boolean m1839o(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (f1347e == -1) {
            f1347e = C0574m.m2471b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
        }
        if (f1347e != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: p */
    public static boolean m1840p(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (f1345c == -1) {
            f1345c = C0574m.m2471b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
        }
        if (f1345c != 1) {
            z = false;
        }
        return z;
    }
}
