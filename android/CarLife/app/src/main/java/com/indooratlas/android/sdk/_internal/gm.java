package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gd.C5917a;

public final class gm {
    /* renamed from: a */
    public final gk f23972a;
    /* renamed from: b */
    final gi f23973b;
    /* renamed from: c */
    public final int f23974c;
    /* renamed from: d */
    final String f23975d;
    /* renamed from: e */
    public final gc f23976e;
    /* renamed from: f */
    public final gd f23977f;
    /* renamed from: g */
    public final gn f23978g;
    /* renamed from: h */
    gm f23979h;
    /* renamed from: i */
    gm f23980i;
    /* renamed from: j */
    final gm f23981j;
    /* renamed from: k */
    private volatile fq f23982k;

    /* renamed from: com.indooratlas.android.sdk._internal.gm$a */
    public static class C5927a {
        /* renamed from: a */
        public gk f23962a;
        /* renamed from: b */
        public gi f23963b;
        /* renamed from: c */
        public int f23964c;
        /* renamed from: d */
        public String f23965d;
        /* renamed from: e */
        public gc f23966e;
        /* renamed from: f */
        C5917a f23967f;
        /* renamed from: g */
        public gn f23968g;
        /* renamed from: h */
        gm f23969h;
        /* renamed from: i */
        gm f23970i;
        /* renamed from: j */
        gm f23971j;

        public C5927a() {
            this.f23964c = -1;
            this.f23967f = new C5917a();
        }

        private C5927a(gm gmVar) {
            this.f23964c = -1;
            this.f23962a = gmVar.f23972a;
            this.f23963b = gmVar.f23973b;
            this.f23964c = gmVar.f23974c;
            this.f23965d = gmVar.f23975d;
            this.f23966e = gmVar.f23976e;
            this.f23967f = gmVar.f23977f.m20616a();
            this.f23968g = gmVar.f23978g;
            this.f23969h = gmVar.f23979h;
            this.f23970i = gmVar.f23980i;
            this.f23971j = gmVar.f23981j;
        }

        /* renamed from: a */
        public final C5927a m20723a(String str, String str2) {
            this.f23967f.m20615c(str, str2);
            return this;
        }

        /* renamed from: b */
        public final C5927a m20726b(String str, String str2) {
            this.f23967f.m20612a(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C5927a m20721a(gd gdVar) {
            this.f23967f = gdVar.m20616a();
            return this;
        }

        /* renamed from: a */
        public final C5927a m20722a(gm gmVar) {
            if (gmVar != null) {
                C5927a.m20720a("networkResponse", gmVar);
            }
            this.f23969h = gmVar;
            return this;
        }

        /* renamed from: b */
        public final C5927a m20725b(gm gmVar) {
            if (gmVar != null) {
                C5927a.m20720a("cacheResponse", gmVar);
            }
            this.f23970i = gmVar;
            return this;
        }

        /* renamed from: c */
        public final C5927a m20727c(gm gmVar) {
            if (gmVar == null || gmVar.f23978g == null) {
                this.f23971j = gmVar;
                return this;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        /* renamed from: a */
        public final gm m20724a() {
            if (this.f23962a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f23963b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f23964c >= 0) {
                return new gm();
            } else {
                throw new IllegalStateException("code < 0: " + this.f23964c);
            }
        }

        /* renamed from: a */
        private static void m20720a(String str, gm gmVar) {
            if (gmVar.f23978g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (gmVar.f23979h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (gmVar.f23980i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (gmVar.f23981j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }
    }

    private gm(C5927a c5927a) {
        this.f23972a = c5927a.f23962a;
        this.f23973b = c5927a.f23963b;
        this.f23974c = c5927a.f23964c;
        this.f23975d = c5927a.f23965d;
        this.f23976e = c5927a.f23966e;
        this.f23977f = c5927a.f23967f.m20613a();
        this.f23978g = c5927a.f23968g;
        this.f23979h = c5927a.f23969h;
        this.f23980i = c5927a.f23970i;
        this.f23981j = c5927a.f23971j;
    }

    /* renamed from: a */
    public final gk m20728a() {
        return this.f23972a;
    }

    /* renamed from: b */
    public final int m20730b() {
        return this.f23974c;
    }

    /* renamed from: c */
    public final boolean m20731c() {
        return this.f23974c >= 200 && this.f23974c < 300;
    }

    /* renamed from: d */
    public final String m20732d() {
        return this.f23975d;
    }

    /* renamed from: e */
    public final gd m20733e() {
        return this.f23977f;
    }

    /* renamed from: f */
    public final gn m20734f() {
        return this.f23978g;
    }

    /* renamed from: g */
    public final C5927a m20735g() {
        return new C5927a();
    }

    /* renamed from: h */
    public final fq m20736h() {
        fq fqVar = this.f23982k;
        if (fqVar != null) {
            return fqVar;
        }
        fqVar = fq.m20565a(this.f23977f);
        this.f23982k = fqVar;
        return fqVar;
    }

    public final String toString() {
        return "Response{protocol=" + this.f23973b + ", code=" + this.f23974c + ", message=" + this.f23975d + ", url=" + this.f23972a.f23952a + '}';
    }

    /* renamed from: a */
    public final String m20729a(String str) {
        String a = this.f23977f.m20618a(str);
        return a != null ? a : null;
    }
}
