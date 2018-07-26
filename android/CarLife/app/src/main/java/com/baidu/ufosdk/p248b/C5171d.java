package com.baidu.ufosdk.p248b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.ufosdk.util.C5210c;

/* compiled from: PackageCollector */
/* renamed from: com.baidu.ufosdk.b.d */
public final class C5171d {
    /* renamed from: a */
    private static Context f21384a;
    /* renamed from: b */
    private static PackageManager f21385b;
    /* renamed from: c */
    private static PackageInfo f21386c;
    /* renamed from: d */
    private static String f21387d;

    /* renamed from: a */
    public static void m17559a(Context context) {
        if (f21384a == null) {
            f21384a = context;
            f21385b = context.getPackageManager();
            try {
                f21386c = f21385b.getPackageInfo(f21384a.getPackageName(), 0);
            } catch (Throwable e) {
                C5210c.m17733a("PackageCollector.init fail.", e);
            }
        }
    }

    /* renamed from: a */
    public static String m17558a() {
        if (f21384a == null) {
            return "N/A";
        }
        return f21384a.getPackageName();
    }

    /* renamed from: b */
    public static String m17560b() {
        if (f21387d == null) {
            if (f21386c == null) {
                return "N/A";
            }
            f21387d = f21386c.applicationInfo.loadLabel(f21385b).toString();
        }
        return f21387d;
    }

    /* renamed from: c */
    public static String m17561c() {
        if (f21386c == null) {
            return "N/A";
        }
        return f21386c.versionName;
    }
}
