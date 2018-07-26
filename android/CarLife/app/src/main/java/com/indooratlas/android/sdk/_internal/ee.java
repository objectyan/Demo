package com.indooratlas.android.sdk._internal;

import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class ee {
    /* renamed from: a */
    private static C5866a f23513a = new C5867b();

    /* renamed from: com.indooratlas.android.sdk._internal.ee$a */
    public static abstract class C5866a {
        /* renamed from: a */
        public abstract void mo4671a(String str, String str2, Object... objArr);

        /* renamed from: a */
        public abstract void mo4672a(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: a */
        public abstract boolean mo4673a(String str, int i);
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ee$b */
    public static class C5867b extends C5866a {
        /* renamed from: a */
        public final void mo4671a(String str, String str2, Object... objArr) {
            Log.e(str, ee.m20412b(str2, objArr));
        }

        /* renamed from: a */
        public final void mo4672a(String str, Throwable th, String str2, Object... objArr) {
            Log.e(str, ee.m20412b(str2, objArr), th);
        }

        /* renamed from: a */
        public final boolean mo4673a(String str, int i) {
            return Log.isLoggable(str, i);
        }
    }

    /* renamed from: a */
    public static void m20409a(String str, String str2, Object... objArr) {
        f23513a.mo4671a(str, str2, objArr);
    }

    /* renamed from: a */
    public static void m20410a(String str, Throwable th, String str2, Object... objArr) {
        f23513a.mo4672a(str, th, str2, objArr);
    }

    /* renamed from: b */
    private static String m20412b(String str, Object... objArr) {
        if (objArr != null) {
            try {
                str = String.format(Locale.US, str, objArr);
            } catch (IllegalFormatException e) {
                Log.e(m20407a("Logger"), "formatting message failed: " + str);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m20411a(String str, int i) {
        return f23513a.mo4673a(str, i);
    }

    /* renamed from: a */
    public static final String m20406a(Class cls) {
        return m20407a(cls.getSimpleName());
    }

    /* renamed from: a */
    public static final String m20407a(String str) {
        if (!str.startsWith("IA")) {
            str = "IA" + str;
        }
        return str.length() > 23 ? str.substring(0, 23) : str;
    }
}
