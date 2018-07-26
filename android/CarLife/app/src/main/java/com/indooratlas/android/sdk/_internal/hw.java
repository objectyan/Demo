package com.indooratlas.android.sdk._internal;

public final class hw {
    /* renamed from: a */
    public static boolean m21068a(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: b */
    public static boolean m21069b(String str) {
        return m21068a(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}
