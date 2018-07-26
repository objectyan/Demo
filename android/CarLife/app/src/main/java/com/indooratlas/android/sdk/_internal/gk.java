package com.indooratlas.android.sdk._internal;

import com.facebook.common.p141m.C2924g;
import com.indooratlas.android.sdk._internal.gd.C5917a;
import java.net.URL;

public final class gk {
    /* renamed from: a */
    public final ge f23952a;
    /* renamed from: b */
    public final String f23953b;
    /* renamed from: c */
    public final gd f23954c;
    /* renamed from: d */
    public final gl f23955d;
    /* renamed from: e */
    final Object f23956e;
    /* renamed from: f */
    private volatile fq f23957f;

    /* renamed from: com.indooratlas.android.sdk._internal.gk$a */
    public static class C5925a {
        /* renamed from: a */
        ge f23947a;
        /* renamed from: b */
        String f23948b;
        /* renamed from: c */
        C5917a f23949c;
        /* renamed from: d */
        gl f23950d;
        /* renamed from: e */
        Object f23951e;

        public C5925a() {
            this.f23948b = "GET";
            this.f23949c = new C5917a();
        }

        private C5925a(gk gkVar) {
            this.f23947a = gkVar.f23952a;
            this.f23948b = gkVar.f23953b;
            this.f23950d = gkVar.f23955d;
            this.f23951e = gkVar.f23956e;
            this.f23949c = gkVar.f23954c.m20616a();
        }

        /* renamed from: a */
        public final C5925a m20699a(ge geVar) {
            if (geVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f23947a = geVar;
            return this;
        }

        /* renamed from: a */
        public final C5925a m20702a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
            }
            ge d = ge.m20645d(str);
            if (d != null) {
                return m20699a(d);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        /* renamed from: a */
        public final C5925a m20705a(URL url) {
            ge a = ge.m20632a(url);
            if (a != null) {
                return m20699a(a);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        /* renamed from: a */
        public final C5925a m20704a(String str, String str2) {
            this.f23949c.m20615c(str, str2);
            return this;
        }

        /* renamed from: b */
        public final C5925a m20708b(String str, String str2) {
            this.f23949c.m20612a(str, str2);
            return this;
        }

        /* renamed from: b */
        public final C5925a m20707b(String str) {
            this.f23949c.m20611a(str);
            return this;
        }

        /* renamed from: a */
        public final C5925a m20700a(gl glVar) {
            return m20703a("PUT", glVar);
        }

        /* renamed from: a */
        public final C5925a m20703a(String str, gl glVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (glVar != null && !hw.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (glVar == null && hw.a(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f23948b = str;
                this.f23950d = glVar;
                return this;
            }
        }

        /* renamed from: a */
        public final C5925a m20701a(Object obj) {
            this.f23951e = obj;
            return this;
        }

        /* renamed from: a */
        public final gk m20706a() {
            if (this.f23947a != null) {
                return new gk();
            }
            throw new IllegalStateException("url == null");
        }
    }

    private gk(C5925a c5925a) {
        Object obj;
        this.f23952a = c5925a.f23947a;
        this.f23953b = c5925a.f23948b;
        this.f23954c = c5925a.f23949c.m20613a();
        this.f23955d = c5925a.f23950d;
        if (c5925a.f23951e != null) {
            obj = c5925a.f23951e;
        } else {
            gk gkVar = this;
        }
        this.f23956e = obj;
    }

    /* renamed from: a */
    public final ge m20709a() {
        return this.f23952a;
    }

    /* renamed from: b */
    public final String m20711b() {
        return this.f23953b;
    }

    /* renamed from: c */
    public final gd m20712c() {
        return this.f23954c;
    }

    /* renamed from: a */
    public final String m20710a(String str) {
        return this.f23954c.m20618a(str);
    }

    /* renamed from: d */
    public final gl m20713d() {
        return this.f23955d;
    }

    /* renamed from: e */
    public final C5925a m20714e() {
        return new C5925a();
    }

    /* renamed from: f */
    public final fq m20715f() {
        fq fqVar = this.f23957f;
        if (fqVar != null) {
            return fqVar;
        }
        fqVar = fq.m20565a(this.f23954c);
        this.f23957f = fqVar;
        return fqVar;
    }

    /* renamed from: g */
    public final boolean m20716g() {
        return this.f23952a.f23861a.equals(C2924g.f12888b);
    }

    public final String toString() {
        return "Request{method=" + this.f23953b + ", url=" + this.f23952a + ", tag=" + (this.f23956e != this ? this.f23956e : null) + '}';
    }
}
