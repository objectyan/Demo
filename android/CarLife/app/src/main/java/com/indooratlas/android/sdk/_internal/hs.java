package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gd.C5917a;
import com.indooratlas.android.sdk._internal.gm.C5927a;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class hs implements hx {
    /* renamed from: a */
    final ig f24268a;
    /* renamed from: b */
    final ip f24269b;
    /* renamed from: c */
    final io f24270c;
    /* renamed from: d */
    int f24271d = 0;
    /* renamed from: e */
    private hv f24272e;

    /* renamed from: com.indooratlas.android.sdk._internal.hs$a */
    abstract class C5967a implements jd {
        /* renamed from: a */
        protected final it f24250a;
        /* renamed from: b */
        protected boolean f24251b;
        /* renamed from: c */
        final /* synthetic */ hs f24252c;

        private C5967a(hs hsVar) {
            this.f24252c = hsVar;
            this.f24250a = new it(this.f24252c.f24269b.a());
        }

        /* renamed from: a */
        public final je m21009a() {
            return this.f24250a;
        }

        /* renamed from: a */
        protected final void m21010a(boolean z) throws IOException {
            if (this.f24252c.f24271d != 6) {
                if (this.f24252c.f24271d != 5) {
                    throw new IllegalStateException("state: " + this.f24252c.f24271d);
                }
                hs.m21016a(this.f24250a);
                this.f24252c.f24271d = 6;
                if (this.f24252c.f24268a != null) {
                    this.f24252c.f24268a.a(!z, this.f24252c);
                }
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hs$b */
    final class C5968b implements jc {
        /* renamed from: a */
        final /* synthetic */ hs f24253a;
        /* renamed from: b */
        private final it f24254b;
        /* renamed from: c */
        private boolean f24255c;

        private C5968b(hs hsVar) {
            this.f24253a = hsVar;
            this.f24254b = new it(this.f24253a.f24270c.a());
        }

        /* renamed from: a */
        public final je m21011a() {
            return this.f24254b;
        }

        public final void a_(in inVar, long j) throws IOException {
            if (this.f24255c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.f24253a.f24270c.i(j);
                this.f24253a.f24270c.b("\r\n");
                this.f24253a.f24270c.a_(inVar, j);
                this.f24253a.f24270c.b("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.f24255c) {
                this.f24253a.f24270c.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.f24255c) {
                this.f24255c = true;
                this.f24253a.f24270c.b("0\r\n\r\n");
                hs.m21016a(this.f24254b);
                this.f24253a.f24271d = 3;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hs$c */
    class C5969c extends C5967a {
        /* renamed from: d */
        final /* synthetic */ hs f24256d;
        /* renamed from: e */
        private long f24257e = -1;
        /* renamed from: f */
        private boolean f24258f = true;
        /* renamed from: g */
        private final hv f24259g;

        C5969c(hs hsVar, hv hvVar) throws IOException {
            this.f24256d = hsVar;
            super();
            this.f24259g = hvVar;
        }

        /* renamed from: a */
        public final long m21012a(in inVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.f24258f) {
                return -1;
            } else {
                if (this.f24257e == 0 || this.f24257e == -1) {
                    if (this.f24257e != -1) {
                        this.f24256d.f24269b.m();
                    }
                    try {
                        this.f24257e = this.f24256d.f24269b.j();
                        String trim = this.f24256d.f24269b.m().trim();
                        if (this.f24257e < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f24257e + trim + "\"");
                        }
                        if (this.f24257e == 0) {
                            this.f24258f = false;
                            this.f24259g.a(this.f24256d.m21028e());
                            m21010a(true);
                        }
                        if (!this.f24258f) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long a = this.f24256d.f24269b.a(inVar, Math.min(j, this.f24257e));
                if (a == -1) {
                    m21010a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f24257e -= a;
                return a;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (this.f24258f && !gy.m20794a((jd) this, TimeUnit.MILLISECONDS)) {
                    m21010a(false);
                }
                this.b = true;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hs$d */
    final class C5970d implements jc {
        /* renamed from: a */
        final /* synthetic */ hs f24260a;
        /* renamed from: b */
        private final it f24261b;
        /* renamed from: c */
        private boolean f24262c;
        /* renamed from: d */
        private long f24263d;

        private C5970d(hs hsVar, long j) {
            this.f24260a = hsVar;
            this.f24261b = new it(this.f24260a.f24270c.a());
            this.f24263d = j;
        }

        /* renamed from: a */
        public final je m21013a() {
            return this.f24261b;
        }

        public final void a_(in inVar, long j) throws IOException {
            if (this.f24262c) {
                throw new IllegalStateException("closed");
            }
            gy.m20789a(inVar.f24392b, j);
            if (j > this.f24263d) {
                throw new ProtocolException("expected " + this.f24263d + " bytes but received " + j);
            }
            this.f24260a.f24270c.a_(inVar, j);
            this.f24263d -= j;
        }

        public final void flush() throws IOException {
            if (!this.f24262c) {
                this.f24260a.f24270c.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.f24262c) {
                this.f24262c = true;
                if (this.f24263d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                hs.m21016a(this.f24261b);
                this.f24260a.f24271d = 3;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hs$e */
    class C5971e extends C5967a {
        /* renamed from: d */
        final /* synthetic */ hs f24264d;
        /* renamed from: e */
        private long f24265e;

        public C5971e(hs hsVar, long j) throws IOException {
            this.f24264d = hsVar;
            super();
            this.f24265e = j;
            if (this.f24265e == 0) {
                m21010a(true);
            }
        }

        /* renamed from: a */
        public final long m21014a(in inVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f24265e == 0) {
                return -1;
            } else {
                long a = this.f24264d.f24269b.a(inVar, Math.min(this.f24265e, j));
                if (a == -1) {
                    m21010a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f24265e -= a;
                if (this.f24265e == 0) {
                    m21010a(true);
                }
                return a;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (!(this.f24265e == 0 || gy.m20794a((jd) this, TimeUnit.MILLISECONDS))) {
                    m21010a(false);
                }
                this.b = true;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hs$f */
    class C5972f extends C5967a {
        /* renamed from: d */
        final /* synthetic */ hs f24266d;
        /* renamed from: e */
        private boolean f24267e;

        private C5972f(hs hsVar) {
            this.f24266d = hsVar;
            super();
        }

        /* renamed from: a */
        public final long m21015a(in inVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f24267e) {
                return -1;
            } else {
                long a = this.f24266d.f24269b.a(inVar, j);
                if (a != -1) {
                    return a;
                }
                this.f24267e = true;
                m21010a(true);
                return -1;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (!this.f24267e) {
                    m21010a(false);
                }
                this.b = true;
            }
        }
    }

    public hs(ig igVar, ip ipVar, io ioVar) {
        this.f24268a = igVar;
        this.f24269b = ipVar;
        this.f24270c = ioVar;
    }

    /* renamed from: a */
    public final void m21023a(hv hvVar) {
        this.f24272e = hvVar;
    }

    /* renamed from: a */
    public final jc m21018a(gk gkVar, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(gkVar.m20710a("Transfer-Encoding"))) {
            if (this.f24271d != 1) {
                throw new IllegalStateException("state: " + this.f24271d);
            }
            this.f24271d = 2;
            return new C5968b();
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f24271d != 1) {
            throw new IllegalStateException("state: " + this.f24271d);
        } else {
            this.f24271d = 2;
            return new C5970d(j);
        }
    }

    /* renamed from: a */
    public final void m21020a() {
        ii a = this.f24268a.a();
        if (a != null) {
            gy.m20792a(a.f24357b);
        }
    }

    /* renamed from: a */
    public final void m21022a(gk gkVar) throws IOException {
        Object obj;
        this.f24272e.a();
        Type type = this.f24272e.f24304c.a().m20575a().f23984b.type();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gkVar.f23953b);
        stringBuilder.append(' ');
        if (gkVar.m20716g() || type != Type.HTTP) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            stringBuilder.append(gkVar.f23952a);
        } else {
            stringBuilder.append(ib.a(gkVar.f23952a));
        }
        stringBuilder.append(" HTTP/1.1");
        m21021a(gkVar.f23954c, stringBuilder.toString());
    }

    /* renamed from: b */
    public final C5927a m21025b() throws IOException {
        return m21027d();
    }

    /* renamed from: a */
    public final gn m21017a(gm gmVar) throws IOException {
        jd a;
        if (!hv.c(gmVar)) {
            a = m21019a(0);
        } else if ("chunked".equalsIgnoreCase(gmVar.m20729a("Transfer-Encoding"))) {
            hv hvVar = this.f24272e;
            if (this.f24271d != 4) {
                throw new IllegalStateException("state: " + this.f24271d);
            }
            this.f24271d = 5;
            a = new C5969c(this, hvVar);
        } else {
            long a2 = hy.a(gmVar);
            if (a2 != -1) {
                a = m21019a(a2);
            } else if (this.f24271d != 4) {
                throw new IllegalStateException("state: " + this.f24271d);
            } else if (this.f24268a == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.f24271d = 5;
                this.f24268a.a(true, false, false);
                a = new C5972f();
            }
        }
        return new hz(gmVar.f23977f, ix.a(a));
    }

    /* renamed from: c */
    public final void m21026c() throws IOException {
        this.f24270c.flush();
    }

    /* renamed from: a */
    public final void m21021a(gd gdVar, String str) throws IOException {
        if (this.f24271d != 0) {
            throw new IllegalStateException("state: " + this.f24271d);
        }
        this.f24270c.b(str).b("\r\n");
        int length = gdVar.f23845a.length / 2;
        for (int i = 0; i < length; i++) {
            this.f24270c.b(gdVar.m20617a(i)).b(": ").b(gdVar.m20619b(i)).b("\r\n");
        }
        this.f24270c.b("\r\n");
        this.f24271d = 1;
    }

    /* renamed from: d */
    public final C5927a m21027d() throws IOException {
        if (this.f24271d == 1 || this.f24271d == 3) {
            C5927a c5927a;
            C5979if a;
            do {
                try {
                    a = C5979if.a(this.f24269b.m());
                    c5927a = new C5927a();
                    c5927a.f23963b = a.f24344a;
                    c5927a.f23964c = a.f24345b;
                    c5927a.f23965d = a.f24346c;
                    c5927a = c5927a.m20721a(m21028e());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f24268a);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a.f24345b == 100);
            this.f24271d = 4;
            return c5927a;
        }
        throw new IllegalStateException("state: " + this.f24271d);
    }

    /* renamed from: e */
    public final gd m21028e() throws IOException {
        C5917a c5917a = new C5917a();
        while (true) {
            String m = this.f24269b.m();
            if (m.length() == 0) {
                return c5917a.m20613a();
            }
            gs.f23877b.mo4686a(c5917a, m);
        }
    }

    /* renamed from: a */
    public final void m21024a(ic icVar) throws IOException {
        if (this.f24271d != 1) {
            throw new IllegalStateException("state: " + this.f24271d);
        }
        this.f24271d = 3;
        icVar.a(this.f24270c);
    }

    /* renamed from: a */
    public final jd m21019a(long j) throws IOException {
        if (this.f24271d != 4) {
            throw new IllegalStateException("state: " + this.f24271d);
        }
        this.f24271d = 5;
        return new C5971e(this, j);
    }

    /* renamed from: a */
    static /* synthetic */ void m21016a(it itVar) {
        je jeVar = itVar.f24402a;
        je jeVar2 = je.f24380b;
        if (jeVar2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        itVar.f24402a = jeVar2;
        jeVar.e_();
        jeVar.d();
    }
}
