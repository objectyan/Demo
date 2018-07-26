package com.indooratlas.android.sdk._internal;

import java.util.Date;

public final class hq {
    /* renamed from: a */
    public final gk f24248a;
    /* renamed from: b */
    public final gm f24249b;

    /* renamed from: com.indooratlas.android.sdk._internal.hq$a */
    public static class C5966a {
        /* renamed from: a */
        public final long f24236a;
        /* renamed from: b */
        public final gk f24237b;
        /* renamed from: c */
        public final gm f24238c;
        /* renamed from: d */
        public Date f24239d;
        /* renamed from: e */
        public String f24240e;
        /* renamed from: f */
        public Date f24241f;
        /* renamed from: g */
        public String f24242g;
        /* renamed from: h */
        public Date f24243h;
        /* renamed from: i */
        public long f24244i;
        /* renamed from: j */
        public long f24245j;
        /* renamed from: k */
        public String f24246k;
        /* renamed from: l */
        public int f24247l = -1;

        public C5966a(long j, gk gkVar, gm gmVar) {
            this.f24236a = j;
            this.f24237b = gkVar;
            this.f24238c = gmVar;
            if (gmVar != null) {
                gd gdVar = gmVar.f23977f;
                int length = gdVar.f23845a.length / 2;
                for (int i = 0; i < length; i++) {
                    String a = gdVar.m20617a(i);
                    String b = gdVar.m20619b(i);
                    if ("Date".equalsIgnoreCase(a)) {
                        this.f24239d = hu.m21041a(b);
                        this.f24240e = b;
                    } else if ("Expires".equalsIgnoreCase(a)) {
                        this.f24243h = hu.m21041a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a)) {
                        this.f24241f = hu.m21041a(b);
                        this.f24242g = b;
                    } else if ("ETag".equalsIgnoreCase(a)) {
                        this.f24246k = b;
                    } else if ("Age".equalsIgnoreCase(a)) {
                        this.f24247l = hr.m21007a(b, -1);
                    } else if (hy.f24321b.equalsIgnoreCase(a)) {
                        this.f24244i = Long.parseLong(b);
                    } else if (hy.f24322c.equalsIgnoreCase(a)) {
                        this.f24245j = Long.parseLong(b);
                    }
                }
            }
        }

        /* renamed from: a */
        public static boolean m21005a(gk gkVar) {
            return (gkVar.m20710a("If-Modified-Since") == null && gkVar.m20710a("If-None-Match") == null) ? false : true;
        }
    }

    private hq(gk gkVar, gm gmVar) {
        this.f24248a = gkVar;
        this.f24249b = gmVar;
    }

    /* renamed from: a */
    public static boolean m21006a(gm gmVar, gk gkVar) {
        switch (gmVar.f23974c) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case 308:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            case 302:
            case 307:
                if (gmVar.m20729a("Expires") == null && gmVar.m20736h().f23732e == -1 && !gmVar.m20736h().f23734g && !gmVar.m20736h().f23733f) {
                    return false;
                }
            default:
                return false;
        }
        return (gmVar.m20736h().f23731d || gkVar.m20715f().f23731d) ? false : true;
    }
}
