package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gd.C5917a;
import com.indooratlas.android.sdk._internal.gf.C5920a;
import com.indooratlas.android.sdk._internal.gm.C5927a;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class hv {
    /* renamed from: a */
    public static final gn f24302a = new C59751();
    /* renamed from: b */
    public final gh f24303b;
    /* renamed from: c */
    public final ig f24304c;
    /* renamed from: d */
    public final gm f24305d;
    /* renamed from: e */
    public hx f24306e;
    /* renamed from: f */
    public long f24307f = -1;
    /* renamed from: g */
    public boolean f24308g;
    /* renamed from: h */
    public final boolean f24309h;
    /* renamed from: i */
    public final gk f24310i;
    /* renamed from: j */
    public gk f24311j;
    /* renamed from: k */
    public gm f24312k;
    /* renamed from: l */
    public gm f24313l;
    /* renamed from: m */
    public jc f24314m;
    /* renamed from: n */
    public io f24315n;
    /* renamed from: o */
    public final boolean f24316o;
    /* renamed from: p */
    public final boolean f24317p;
    /* renamed from: q */
    public hp f24318q;
    /* renamed from: r */
    public hq f24319r;

    /* renamed from: com.indooratlas.android.sdk._internal.hv$1 */
    static class C59751 extends gn {
        C59751() {
        }

        /* renamed from: a */
        public final gg m21042a() {
            return null;
        }

        /* renamed from: b */
        public final long m21043b() {
            return 0;
        }

        /* renamed from: c */
        public final ip m21044c() {
            return new in();
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hv$2 */
    public class C59762 implements jd {
        /* renamed from: a */
        boolean f24293a;
        /* renamed from: b */
        final /* synthetic */ ip f24294b;
        /* renamed from: c */
        final /* synthetic */ hp f24295c;
        /* renamed from: d */
        final /* synthetic */ io f24296d;
        /* renamed from: e */
        final /* synthetic */ hv f24297e;

        public C59762(hv hvVar, ip ipVar, hp hpVar, io ioVar) {
            this.f24297e = hvVar;
            this.f24294b = ipVar;
            this.f24295c = hpVar;
            this.f24296d = ioVar;
        }

        /* renamed from: a */
        public final long mo4730a(in inVar, long j) throws IOException {
            try {
                long a = this.f24294b.mo4730a(inVar, j);
                if (a == -1) {
                    if (!this.f24293a) {
                        this.f24293a = true;
                        this.f24296d.close();
                    }
                    return -1;
                }
                inVar.m21181a(this.f24296d.mo4741b(), inVar.f24392b - a, a);
                this.f24296d.mo4765p();
                return a;
            } catch (IOException e) {
                if (!this.f24293a) {
                    this.f24293a = true;
                }
                throw e;
            }
        }

        /* renamed from: a */
        public final je mo4731a() {
            return this.f24294b.mo4731a();
        }

        public final void close() throws IOException {
            if (!(this.f24293a || gy.a(this, TimeUnit.MILLISECONDS))) {
                this.f24293a = true;
            }
            this.f24294b.close();
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hv$a */
    public class C5977a implements C5920a {
        /* renamed from: a */
        final /* synthetic */ hv f24298a;
        /* renamed from: b */
        private final int f24299b;
        /* renamed from: c */
        private final gk f24300c;
        /* renamed from: d */
        private int f24301d;

        public C5977a(hv hvVar, int i, gk gkVar) {
            this.f24298a = hvVar;
            this.f24299b = i;
            this.f24300c = gkVar;
        }

        /* renamed from: b */
        public final fv m21051b() {
            return this.f24298a.f24304c.m21105a();
        }

        /* renamed from: a */
        public final gk m21049a() {
            return this.f24300c;
        }

        /* renamed from: a */
        public final gm m21050a(gk gkVar) throws IOException {
            gf gfVar;
            this.f24301d++;
            if (this.f24299b > 0) {
                gfVar = (gf) this.f24298a.f24303b.f23909f.get(this.f24299b - 1);
                fn fnVar = m21051b().a().f23983a;
                if (!gkVar.f23952a.f23862b.equals(fnVar.f23707a.f23862b) || gkVar.f23952a.f23863c != fnVar.f23707a.f23863c) {
                    throw new IllegalStateException("network interceptor " + gfVar + " must retain the same host and port");
                } else if (this.f24301d > 1) {
                    throw new IllegalStateException("network interceptor " + gfVar + " must call proceed() exactly once");
                }
            }
            if (this.f24299b < this.f24298a.f24303b.f23909f.size()) {
                Object c5977a = new C5977a(this.f24298a, this.f24299b + 1, gkVar);
                gfVar = (gf) this.f24298a.f24303b.f23909f.get(this.f24299b);
                gm a = gfVar.a(c5977a);
                if (c5977a.f24301d != 1) {
                    throw new IllegalStateException("network interceptor " + gfVar + " must call proceed() exactly once");
                } else if (a != null) {
                    return a;
                } else {
                    throw new NullPointerException("network interceptor " + gfVar + " returned null");
                }
            }
            this.f24298a.f24306e.m21073a(gkVar);
            this.f24298a.f24311j = gkVar;
            if (hv.m21057a(gkVar) && gkVar.f23955d != null) {
                io a2 = ix.m21258a(this.f24298a.f24306e.m21071a(gkVar, gkVar.f23955d.b()));
                gkVar.f23955d.a(a2);
                a2.close();
            }
            gm b = this.f24298a.m21067c();
            int i = b.f23974c;
            if ((i != 204 && i != 205) || b.f23978g.b() <= 0) {
                return b;
            }
            throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + b.f23978g.b());
        }
    }

    public hv(gh ghVar, gk gkVar, boolean z, boolean z2, boolean z3, ig igVar, gm gmVar) {
        this.f24303b = ghVar;
        this.f24310i = gkVar;
        this.f24309h = z;
        this.f24316o = z2;
        this.f24317p = z3;
        if (igVar == null) {
            fw fwVar = ghVar.f23920q;
            SSLSocketFactory sSLSocketFactory = null;
            HostnameVerifier hostnameVerifier = null;
            ft ftVar = null;
            if (gkVar.g()) {
                sSLSocketFactory = ghVar.f23915l;
                hostnameVerifier = ghVar.f23916m;
                ftVar = ghVar.f23917n;
            }
            ig igVar2 = new ig(fwVar, new fn(gkVar.f23952a.f23862b, gkVar.f23952a.f23863c, ghVar.f23921r, ghVar.f23914k, sSLSocketFactory, hostnameVerifier, ftVar, ghVar.f23918o, ghVar.f23905b, ghVar.f23906c, ghVar.f23907d, ghVar.f23910g));
        }
        this.f24304c = igVar;
        this.f24314m = null;
        this.f24305d = gmVar;
    }

    /* renamed from: a */
    public static gm m21054a(gm gmVar) {
        if (gmVar == null || gmVar.f23978g == null) {
            return gmVar;
        }
        C5927a g = gmVar.g();
        g.f23968g = null;
        return g.a();
    }

    /* renamed from: a */
    public final void m21062a() {
        if (this.f24307f != -1) {
            throw new IllegalStateException();
        }
        this.f24307f = System.currentTimeMillis();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final com.indooratlas.android.sdk._internal.hv m21061a(java.io.IOException r9) {
        /*
        r8 = this;
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r3 = r8.f24304c;
        r4 = r3.f24350d;
        if (r4 == 0) goto L_0x000c;
    L_0x0009:
        r3.m21107a(r9);
    L_0x000c:
        r4 = r3.f24349c;
        if (r4 == 0) goto L_0x0027;
    L_0x0010:
        r3 = r3.f24349c;
        r4 = r3.m21098c();
        if (r4 != 0) goto L_0x0024;
    L_0x0018:
        r4 = r3.m21097b();
        if (r4 != 0) goto L_0x0024;
    L_0x001e:
        r3 = r3.m21099d();
        if (r3 == 0) goto L_0x0032;
    L_0x0024:
        r3 = r1;
    L_0x0025:
        if (r3 == 0) goto L_0x002e;
    L_0x0027:
        r3 = r9 instanceof java.net.ProtocolException;
        if (r3 == 0) goto L_0x0034;
    L_0x002b:
        r3 = r2;
    L_0x002c:
        if (r3 != 0) goto L_0x002f;
    L_0x002e:
        r1 = r2;
    L_0x002f:
        if (r1 != 0) goto L_0x0051;
    L_0x0031:
        return r0;
    L_0x0032:
        r3 = r2;
        goto L_0x0025;
    L_0x0034:
        r3 = r9 instanceof java.io.InterruptedIOException;
        if (r3 == 0) goto L_0x003b;
    L_0x0038:
        r3 = r9 instanceof java.net.SocketTimeoutException;
        goto L_0x002c;
    L_0x003b:
        r3 = r9 instanceof javax.net.ssl.SSLHandshakeException;
        if (r3 == 0) goto L_0x0049;
    L_0x003f:
        r3 = r9.getCause();
        r3 = r3 instanceof java.security.cert.CertificateException;
        if (r3 == 0) goto L_0x0049;
    L_0x0047:
        r3 = r2;
        goto L_0x002c;
    L_0x0049:
        r3 = r9 instanceof javax.net.ssl.SSLPeerUnverifiedException;
        if (r3 == 0) goto L_0x004f;
    L_0x004d:
        r3 = r2;
        goto L_0x002c;
    L_0x004f:
        r3 = r1;
        goto L_0x002c;
    L_0x0051:
        r1 = r8.f24303b;
        r1 = r1.f23924u;
        if (r1 == 0) goto L_0x0031;
    L_0x0057:
        r6 = r8.m21066b();
        r0 = new com.indooratlas.android.sdk._internal.hv;
        r1 = r8.f24303b;
        r2 = r8.f24310i;
        r3 = r8.f24309h;
        r4 = r8.f24316o;
        r5 = r8.f24317p;
        r7 = r8.f24305d;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.hv.a(java.io.IOException):com.indooratlas.android.sdk._internal.hv");
    }

    /* renamed from: b */
    public final ig m21066b() {
        if (this.f24315n != null) {
            gy.a(this.f24315n);
        } else if (this.f24314m != null) {
            gy.a(this.f24314m);
        }
        if (this.f24313l != null) {
            gy.a(this.f24313l.f23978g);
        } else {
            this.f24304c.m21107a(null);
        }
        return this.f24304c;
    }

    /* renamed from: b */
    public final gm m21065b(gm gmVar) throws IOException {
        if (!this.f24308g || !"gzip".equalsIgnoreCase(this.f24313l.a("Content-Encoding")) || gmVar.f23978g == null) {
            return gmVar;
        }
        jd ivVar = new iv(gmVar.f23978g.c());
        gd a = gmVar.f23977f.a().a("Content-Encoding").a("Content-Length").a();
        C5927a a2 = gmVar.g().a(a);
        a2.f23968g = new hz(a, ix.m21259a(ivVar));
        return a2.a();
    }

    /* renamed from: c */
    public static boolean m21060c(gm gmVar) {
        if (gmVar.f23972a.f23953b.equals("HEAD")) {
            return false;
        }
        int i = gmVar.f23974c;
        if ((i < 100 || i >= 200) && i != 204 && i != 304) {
            return true;
        }
        if (hy.m21080a(gmVar) != -1 || "chunked".equalsIgnoreCase(gmVar.a("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static String m21056a(List<fy> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            fy fyVar = (fy) list.get(i);
            stringBuilder.append(fyVar.f23822a).append('=').append(fyVar.f23823b);
        }
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public final gm m21067c() throws IOException {
        this.f24306e.m21077c();
        C5927a b = this.f24306e.m21076b();
        b.f23962a = this.f24311j;
        b.f23966e = this.f24304c.m21105a().f24359d;
        gm a = b.a(hy.f24321b, Long.toString(this.f24307f)).a(hy.f24322c, Long.toString(System.currentTimeMillis())).a();
        if (!this.f24317p) {
            C5927a g = a.g();
            g.f23968g = this.f24306e.m21070a(a);
            a = g.a();
        }
        if ("close".equalsIgnoreCase(a.f23972a.a("Connection")) || "close".equalsIgnoreCase(a.a("Connection"))) {
            this.f24304c.m21109a(true, false, false);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m21058a(gm gmVar, gm gmVar2) {
        if (gmVar2.f23974c == 304) {
            return true;
        }
        Date b = gmVar.f23977f.b("Last-Modified");
        if (b != null) {
            Date b2 = gmVar2.f23977f.b("Last-Modified");
            if (b2 != null && b2.getTime() < b.getTime()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static gd m21052a(gd gdVar, gd gdVar2) throws IOException {
        int i;
        int i2 = 0;
        C5917a c5917a = new C5917a();
        int length = gdVar.f23845a.length / 2;
        for (i = 0; i < length; i++) {
            String a = gdVar.a(i);
            String b = gdVar.b(i);
            if (!("Warning".equalsIgnoreCase(a) && b.startsWith("1")) && (!hy.m21081a(a) || gdVar2.a(a) == null)) {
                c5917a.a(a, b);
            }
        }
        i = gdVar2.f23845a.length / 2;
        while (i2 < i) {
            String a2 = gdVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a2) && hy.m21081a(a2)) {
                c5917a.a(a2, gdVar2.b(i2));
            }
            i2++;
        }
        return c5917a.a();
    }

    /* renamed from: a */
    public final void m21063a(gd gdVar) throws IOException {
        if (this.f24303b.f23911h != fz.f23831a && !fy.a(this.f24310i.f23952a, gdVar).isEmpty()) {
            this.f24303b.f23911h.a();
        }
    }

    /* renamed from: a */
    public final boolean m21064a(ge geVar) {
        ge geVar2 = this.f24310i.f23952a;
        return geVar2.f23862b.equals(geVar.f23862b) && geVar2.f23863c == geVar.f23863c && geVar2.f23861a.equals(geVar.f23861a);
    }

    /* renamed from: a */
    public static boolean m21057a(gk gkVar) {
        return hw.m21069b(gkVar.f23953b);
    }
}
