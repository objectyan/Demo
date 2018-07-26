package com.indooratlas.android.sdk._internal;

import cz.msebera.android.httpclient.C6591q;

public final class hy {
    /* renamed from: a */
    static final String f24320a = gw.b();
    /* renamed from: b */
    public static final String f24321b = (f24320a + "-Sent-Millis");
    /* renamed from: c */
    public static final String f24322c = (f24320a + "-Received-Millis");
    /* renamed from: d */
    public static final String f24323d = (f24320a + "-Selected-Protocol");
    /* renamed from: e */
    public static final String f24324e = (f24320a + "-Response-Source");

    static {
        gw.a();
    }

    /* renamed from: a */
    public static long m21078a(gd gdVar) {
        return m21082b(gdVar.a("Content-Length"));
    }

    /* renamed from: b */
    private static long m21082b(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    /* renamed from: a */
    static boolean m21081a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || C6591q.f26537T.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || C6591q.f26541X.equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: a */
    public static long m21079a(gk gkVar) {
        return m21078a(gkVar.f23954c);
    }

    /* renamed from: a */
    public static long m21080a(gm gmVar) {
        return m21078a(gmVar.f23977f);
    }
}
