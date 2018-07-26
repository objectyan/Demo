package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.pm.PackageInfo;

public final class ck {
    /* renamed from: d */
    private static ck f23315d;
    /* renamed from: a */
    public final String f23316a;
    /* renamed from: b */
    public final String f23317b;
    /* renamed from: c */
    public final int f23318c;

    private ck(Context context) {
        PackageInfo packageInfo;
        PackageInfo packageInfo2 = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (Throwable th) {
            packageInfo = packageInfo2;
        }
        this.f23316a = packageInfo != null ? packageInfo.packageName : "n/a";
        this.f23317b = packageInfo != null ? packageInfo.versionName : "n/a";
        this.f23318c = packageInfo != null ? packageInfo.versionCode : -1;
    }

    /* renamed from: a */
    public static synchronized ck m20223a(Context context) {
        ck ckVar;
        synchronized (ck.class) {
            if (f23315d == null) {
                f23315d = new ck(context);
            }
            ckVar = f23315d;
        }
        return ckVar;
    }
}
