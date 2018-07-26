package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class hd {
    /* renamed from: j */
    static final /* synthetic */ boolean f24148j = (!hd.class.desiredAssertionStatus());
    /* renamed from: a */
    long f24149a = 0;
    /* renamed from: b */
    long f24150b;
    /* renamed from: c */
    final int f24151c;
    /* renamed from: d */
    final hc f24152d;
    /* renamed from: e */
    List<he> f24153e;
    /* renamed from: f */
    public final C5952b f24154f;
    /* renamed from: g */
    final C5951a f24155g;
    /* renamed from: h */
    public final C5953c f24156h = new C5953c(this);
    /* renamed from: i */
    public final C5953c f24157i = new C5953c(this);
    /* renamed from: k */
    private final List<he> f24158k;
    /* renamed from: l */
    private gz f24159l = null;

    /* renamed from: com.indooratlas.android.sdk._internal.hd$a */
    final class C5951a implements jc {
        /* renamed from: a */
        static final /* synthetic */ boolean f24135a = (!hd.class.desiredAssertionStatus());
        /* renamed from: b */
        final /* synthetic */ hd f24136b;
        /* renamed from: c */
        private final in f24137c = new in();
        /* renamed from: d */
        private boolean f24138d;
        /* renamed from: e */
        private boolean f24139e;

        C5951a(hd hdVar) {
            this.f24136b = hdVar;
        }

        public final void a_(in inVar, long j) throws IOException {
            if (f24135a || !Thread.holdsLock(this.f24136b)) {
                this.f24137c.a_(inVar, j);
                while (this.f24137c.f24392b >= 16384) {
                    m20886a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        private void m20886a(boolean z) throws IOException {
            synchronized (this.f24136b) {
                this.f24136b.f24157i.a_();
                while (this.f24136b.f24150b <= 0 && !this.f24139e && !this.f24138d && this.f24136b.f24159l == null) {
                    try {
                        this.f24136b.m20907f();
                    } catch (Throwable th) {
                        this.f24136b.f24157i.m20900b();
                    }
                }
                this.f24136b.f24157i.m20900b();
                hd.m20910h(this.f24136b);
                long min = Math.min(this.f24136b.f24150b, this.f24137c.f24392b);
                hd hdVar = this.f24136b;
                hdVar.f24150b -= min;
            }
            this.f24136b.f24157i.a_();
            try {
                hc a = this.f24136b.f24152d;
                int b = this.f24136b.f24151c;
                boolean z2 = z && min == this.f24137c.f24392b;
                a.m20882a(b, z2, this.f24137c, min);
            } finally {
                this.f24136b.f24157i.m20900b();
            }
        }

        public final void flush() throws IOException {
            if (f24135a || !Thread.holdsLock(this.f24136b)) {
                synchronized (this.f24136b) {
                    hd.m20910h(this.f24136b);
                }
                while (this.f24137c.f24392b > 0) {
                    m20886a(false);
                    this.f24136b.f24152d.m20884b();
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public final je m20890a() {
            return this.f24136b.f24157i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() throws java.io.IOException {
            /*
            r6 = this;
            r4 = 0;
            r2 = 1;
            r0 = f24135a;
            if (r0 != 0) goto L_0x0015;
        L_0x0007:
            r0 = r6.f24136b;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0015;
        L_0x000f:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0015:
            r1 = r6.f24136b;
            monitor-enter(r1);
            r0 = r6.f24138d;	 Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001e;
        L_0x001c:
            monitor-exit(r1);	 Catch:{ all -> 0x003b }
        L_0x001d:
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x003b }
            r0 = r6.f24136b;
            r0 = r0.f24155g;
            r0 = r0.f24139e;
            if (r0 != 0) goto L_0x004e;
        L_0x0027:
            r0 = r6.f24137c;
            r0 = r0.f24392b;
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x003e;
        L_0x002f:
            r0 = r6.f24137c;
            r0 = r0.f24392b;
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x004e;
        L_0x0037:
            r6.m20886a(r2);
            goto L_0x002f;
        L_0x003b:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003b }
            throw r0;
        L_0x003e:
            r0 = r6.f24136b;
            r0 = r0.f24152d;
            r1 = r6.f24136b;
            r1 = r1.f24151c;
            r3 = 0;
            r0.m20882a(r1, r2, r3, r4);
        L_0x004e:
            r1 = r6.f24136b;
            monitor-enter(r1);
            r0 = 1;
            r6.f24138d = r0;	 Catch:{ all -> 0x0064 }
            monitor-exit(r1);	 Catch:{ all -> 0x0064 }
            r0 = r6.f24136b;
            r0 = r0.f24152d;
            r0.m20884b();
            r0 = r6.f24136b;
            com.indooratlas.android.sdk._internal.hd.m20908f(r0);
            goto L_0x001d;
        L_0x0064:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0064 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.hd.a.close():void");
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hd$b */
    final class C5952b implements jd {
        /* renamed from: a */
        static final /* synthetic */ boolean f24140a = (!hd.class.desiredAssertionStatus());
        /* renamed from: b */
        final /* synthetic */ hd f24141b;
        /* renamed from: c */
        private final in f24142c;
        /* renamed from: d */
        private final in f24143d;
        /* renamed from: e */
        private final long f24144e;
        /* renamed from: f */
        private boolean f24145f;
        /* renamed from: g */
        private boolean f24146g;

        private C5952b(hd hdVar, long j) {
            this.f24141b = hdVar;
            this.f24142c = new in();
            this.f24143d = new in();
            this.f24144e = j;
        }

        /* renamed from: a */
        public final long m20895a(in inVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (this.f24141b) {
                m20893b();
                if (this.f24145f) {
                    throw new IOException("stream closed");
                } else if (this.f24141b.f24159l != null) {
                    throw new IOException("stream was reset: " + this.f24141b.f24159l);
                } else if (this.f24143d.f24392b == 0) {
                    j2 = -1;
                } else {
                    j2 = this.f24143d.a(inVar, Math.min(j, this.f24143d.f24392b));
                    hd hdVar = this.f24141b;
                    hdVar.f24149a += j2;
                    if (this.f24141b.f24149a >= ((long) (this.f24141b.f24152d.f24116e.m20984b() / 2))) {
                        this.f24141b.f24152d.m20880a(this.f24141b.f24151c, this.f24141b.f24149a);
                        this.f24141b.f24149a = 0;
                    }
                    synchronized (this.f24141b.f24152d) {
                        hc a = this.f24141b.f24152d;
                        a.f24114c += j2;
                        if (this.f24141b.f24152d.f24114c >= ((long) (this.f24141b.f24152d.f24116e.m20984b() / 2))) {
                            this.f24141b.f24152d.m20880a(0, this.f24141b.f24152d.f24114c);
                            this.f24141b.f24152d.f24114c = 0;
                        }
                    }
                }
            }
            return j2;
        }

        /* renamed from: b */
        private void m20893b() throws IOException {
            this.f24141b.f24156h.a_();
            while (this.f24143d.f24392b == 0 && !this.f24146g && !this.f24145f && this.f24141b.f24159l == null) {
                try {
                    this.f24141b.m20907f();
                } catch (Throwable th) {
                    this.f24141b.f24156h.m20900b();
                }
            }
            this.f24141b.f24156h.m20900b();
        }

        /* renamed from: a */
        final void m20897a(ip ipVar, long j) throws IOException {
            if (f24140a || !Thread.holdsLock(this.f24141b)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (this.f24141b) {
                        z = this.f24146g;
                        obj = this.f24143d.f24392b + j > this.f24144e ? 1 : null;
                    }
                    if (obj != null) {
                        ipVar.f(j);
                        this.f24141b.m20914b(gz.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        ipVar.f(j);
                        return;
                    } else {
                        long a = ipVar.a(this.f24142c, j);
                        if (a == -1) {
                            throw new EOFException();
                        }
                        j -= a;
                        synchronized (this.f24141b) {
                            if (this.f24143d.f24392b == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            this.f24143d.a(this.f24142c);
                            if (obj != null) {
                                this.f24141b.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public final je m20896a() {
            return this.f24141b.f24156h;
        }

        public final void close() throws IOException {
            synchronized (this.f24141b) {
                this.f24145f = true;
                this.f24143d.o();
                this.f24141b.notifyAll();
            }
            hd.m20908f(this.f24141b);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.hd$c */
    class C5953c extends il {
        /* renamed from: a */
        final /* synthetic */ hd f24147a;

        C5953c(hd hdVar) {
            this.f24147a = hdVar;
        }

        /* renamed from: a */
        protected final void m20899a() {
            this.f24147a.m20914b(gz.CANCEL);
        }

        /* renamed from: a */
        protected final IOException m20898a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public final void m20900b() throws IOException {
            if (b_()) {
                throw m20898a(null);
            }
        }
    }

    hd(int i, hc hcVar, boolean z, boolean z2, List<he> list) {
        if (hcVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f24151c = i;
            this.f24152d = hcVar;
            this.f24150b = (long) hcVar.f24117f.m20984b();
            this.f24154f = new C5952b((long) hcVar.f24116e.m20984b());
            this.f24155g = new C5951a(this);
            this.f24154f.f24146g = z2;
            this.f24155g.f24139e = z;
            this.f24158k = list;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m20913a() {
        boolean z = false;
        synchronized (this) {
            if (this.f24159l == null) {
                if (!(this.f24154f.f24146g || this.f24154f.f24145f) || (!(this.f24155g.f24139e || this.f24155g.f24138d) || this.f24153e == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final boolean m20915b() {
        boolean z;
        if ((this.f24151c & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        return this.f24152d.f24113b == z;
    }

    /* renamed from: c */
    public final synchronized List<he> m20916c() throws IOException {
        this.f24156h.a_();
        while (this.f24153e == null && this.f24159l == null) {
            try {
                m20907f();
            } catch (Throwable th) {
                this.f24156h.m20900b();
            }
        }
        this.f24156h.m20900b();
        if (this.f24153e != null) {
        } else {
            throw new IOException("stream was reset: " + this.f24159l);
        }
        return this.f24153e;
    }

    /* renamed from: d */
    public final jc m20918d() {
        synchronized (this) {
            if (this.f24153e != null || m20915b()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f24155g;
    }

    /* renamed from: a */
    public final void m20912a(gz gzVar) throws IOException {
        if (m20905d(gzVar)) {
            this.f24152d.m20885b(this.f24151c, gzVar);
        }
    }

    /* renamed from: b */
    public final void m20914b(gz gzVar) {
        if (m20905d(gzVar)) {
            this.f24152d.m20881a(this.f24151c, gzVar);
        }
    }

    /* renamed from: d */
    private boolean m20905d(gz gzVar) {
        if (f24148j || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f24159l != null) {
                    return false;
                } else if (this.f24154f.f24146g && this.f24155g.f24139e) {
                    return false;
                } else {
                    this.f24159l = gzVar;
                    notifyAll();
                    this.f24152d.m20883b(this.f24151c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    final void m20919e() {
        if (f24148j || !Thread.holdsLock(this)) {
            boolean a;
            synchronized (this) {
                this.f24154f.f24146g = true;
                a = m20913a();
                notifyAll();
            }
            if (!a) {
                this.f24152d.m20883b(this.f24151c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    final synchronized void m20917c(gz gzVar) {
        if (this.f24159l == null) {
            this.f24159l = gzVar;
            notifyAll();
        }
    }

    /* renamed from: a */
    final void m20911a(long j) {
        this.f24150b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: f */
    private void m20907f() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m20908f(hd hdVar) throws IOException {
        if (f24148j || !Thread.holdsLock(hdVar)) {
            Object obj;
            boolean a;
            synchronized (hdVar) {
                obj = (!hdVar.f24154f.f24146g && hdVar.f24154f.f24145f && (hdVar.f24155g.f24139e || hdVar.f24155g.f24138d)) ? 1 : null;
                a = hdVar.m20913a();
            }
            if (obj != null) {
                hdVar.m20912a(gz.CANCEL);
                return;
            } else if (!a) {
                hdVar.f24152d.m20883b(hdVar.f24151c);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    static /* synthetic */ void m20910h(hd hdVar) throws IOException {
        if (hdVar.f24155g.f24138d) {
            throw new IOException("stream closed");
        } else if (hdVar.f24155g.f24139e) {
            throw new IOException("stream finished");
        } else if (hdVar.f24159l != null) {
            throw new IOException("stream was reset: " + hdVar.f24159l);
        }
    }
}
