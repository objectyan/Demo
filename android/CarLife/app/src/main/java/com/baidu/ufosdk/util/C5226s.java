package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: PermissionUtil */
/* renamed from: com.baidu.ufosdk.util.s */
public final class C5226s {
    /* renamed from: a */
    private static PackageManager f21722a;
    /* renamed from: b */
    private static Context f21723b;

    /* renamed from: a */
    public static void m17791a(Context context) {
        f21723b = context;
        PackageManager packageManager = context.getPackageManager();
        f21722a = packageManager;
        if (packageManager == null) {
            C5210c.m17736d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    /* renamed from: a */
    public static boolean m17792a(String str) {
        if (f21722a == null) {
            C5210c.m17736d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            if (f21722a.checkPermission(str, f21723b.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C5210c.m17733a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
