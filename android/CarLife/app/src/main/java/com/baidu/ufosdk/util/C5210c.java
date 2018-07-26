package com.baidu.ufosdk.util;

import android.util.Log;
import com.baidu.ufosdk.C5167a;

/* compiled from: BLog */
/* renamed from: com.baidu.ufosdk.util.c */
public final class C5210c {
    /* renamed from: a */
    public static String f21694a = "UFO";

    /* renamed from: a */
    public static int m17732a(String str) {
        if (C5167a.f21367m <= 1) {
            return Log.d(f21694a, str);
        }
        return 0;
    }

    /* renamed from: b */
    public static int m17734b(String str) {
        if (C5167a.f21367m <= 2) {
            return Log.i(f21694a, str);
        }
        return 0;
    }

    /* renamed from: c */
    public static int m17735c(String str) {
        if (C5167a.f21367m <= 3) {
            return Log.w(f21694a, str);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m17736d(String str) {
        if (C5167a.f21367m <= 4) {
            return Log.e(f21694a, str);
        }
        return 0;
    }

    /* renamed from: a */
    public static int m17733a(String str, Throwable th) {
        if (C5167a.f21367m <= 4) {
            return Log.e(f21694a, str, th);
        }
        return 0;
    }
}
