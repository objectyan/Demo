package com.indooratlas.android.sdk._internal;

public final class eg {
    /* renamed from: a */
    public static <T> T m20413a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(m20415a(str, objArr));
    }

    /* renamed from: a */
    public static String m20414a(String str, String str2, Object... objArr) {
        if (str != null && !"".equals(str.trim())) {
            return str;
        }
        throw new IllegalArgumentException(m20415a(str2, objArr));
    }

    /* renamed from: a */
    private static String m20415a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        return objArr != null ? String.format(valueOf, objArr) : valueOf;
    }
}
