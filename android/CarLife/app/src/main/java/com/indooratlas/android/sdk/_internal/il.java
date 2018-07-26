package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InterruptedIOException;

public class il extends je {
    /* renamed from: a */
    private static il f24384a;
    /* renamed from: c */
    private boolean f24385c;
    /* renamed from: d */
    private il f24386d;
    /* renamed from: e */
    private long f24387e;

    /* renamed from: com.indooratlas.android.sdk._internal.il$1 */
    class C59811 implements jc {
        /* renamed from: a */
        final /* synthetic */ jc f24376a;
        /* renamed from: b */
        final /* synthetic */ il f24377b;

        C59811(il ilVar, jc jcVar) {
            this.f24377b = ilVar;
            this.f24376a = jcVar;
        }

        public final void a_(in inVar, long j) throws IOException {
            this.f24377b.a_();
            try {
                this.f24376a.a_(inVar, j);
                this.f24377b.m21139a(true);
            } catch (IOException e) {
                throw this.f24377b.m21140b(e);
            } catch (Throwable th) {
                this.f24377b.m21139a(false);
            }
        }

        public final void flush() throws IOException {
            this.f24377b.a_();
            try {
                this.f24376a.flush();
                this.f24377b.m21139a(true);
            } catch (IOException e) {
                throw this.f24377b.m21140b(e);
            } catch (Throwable th) {
                this.f24377b.m21139a(false);
            }
        }

        public final void close() throws IOException {
            this.f24377b.a_();
            try {
                this.f24376a.close();
                this.f24377b.m21139a(true);
            } catch (IOException e) {
                throw this.f24377b.m21140b(e);
            } catch (Throwable th) {
                this.f24377b.m21139a(false);
            }
        }

        /* renamed from: a */
        public final je mo4733a() {
            return this.f24377b;
        }

        public final String toString() {
            return "AsyncTimeout.sink(" + this.f24376a + ")";
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.il$2 */
    class C59822 implements jd {
        /* renamed from: a */
        final /* synthetic */ jd f24378a;
        /* renamed from: b */
        final /* synthetic */ il f24379b;

        C59822(il ilVar, jd jdVar) {
            this.f24379b = ilVar;
            this.f24378a = jdVar;
        }

        /* renamed from: a */
        public final long mo4730a(in inVar, long j) throws IOException {
            this.f24379b.a_();
            try {
                long a = this.f24378a.mo4730a(inVar, j);
                this.f24379b.m21139a(true);
                return a;
            } catch (IOException e) {
                throw this.f24379b.m21140b(e);
            } catch (Throwable th) {
                this.f24379b.m21139a(false);
            }
        }

        public final void close() throws IOException {
            try {
                this.f24378a.close();
                this.f24379b.m21139a(true);
            } catch (IOException e) {
                throw this.f24379b.m21140b(e);
            } catch (Throwable th) {
                this.f24379b.m21139a(false);
            }
        }

        /* renamed from: a */
        public final je mo4731a() {
            return this.f24379b;
        }

        public final String toString() {
            return "AsyncTimeout.source(" + this.f24378a + ")";
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.il$a */
    static final class C5983a extends Thread {
        public C5983a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public final void run() {
            while (true) {
                try {
                    il e = il.m21136g();
                    if (e != null) {
                        e.mo4775a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public final void a_() {
        if (this.f24385c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long c_ = c_();
        boolean d_ = d_();
        if (c_ != 0 || d_) {
            this.f24385c = true;
            m21133a(this, c_, d_);
        }
    }

    /* renamed from: a */
    private static synchronized void m21133a(il ilVar, long j, boolean z) {
        synchronized (il.class) {
            if (f24384a == null) {
                f24384a = new il();
                new C5983a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                ilVar.f24387e = Math.min(j, ilVar.mo4768c() - nanoTime) + nanoTime;
            } else if (j != 0) {
                ilVar.f24387e = nanoTime + j;
            } else if (z) {
                ilVar.f24387e = ilVar.mo4768c();
            } else {
                throw new AssertionError();
            }
            long j2 = ilVar.f24387e - nanoTime;
            il ilVar2 = f24384a;
            while (ilVar2.f24386d != null && j2 >= ilVar2.f24386d.f24387e - nanoTime) {
                ilVar2 = ilVar2.f24386d;
            }
            ilVar.f24386d = ilVar2.f24386d;
            ilVar2.f24386d = ilVar;
            if (ilVar2 == f24384a) {
                il.class.notify();
            }
        }
    }

    public final boolean b_() {
        if (!this.f24385c) {
            return false;
        }
        this.f24385c = false;
        return m21134a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m21134a(il ilVar) {
        boolean z;
        synchronized (il.class) {
            for (il ilVar2 = f24384a; ilVar2 != null; ilVar2 = ilVar2.f24386d) {
                if (ilVar2.f24386d == ilVar) {
                    ilVar2.f24386d = ilVar.f24386d;
                    ilVar.f24386d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo4775a() {
    }

    /* renamed from: a */
    final void m21139a(boolean z) throws IOException {
        if (b_() && z) {
            throw mo4774a(null);
        }
    }

    /* renamed from: b */
    final IOException m21140b(IOException iOException) throws IOException {
        return !b_() ? iOException : mo4774a(iOException);
    }

    /* renamed from: a */
    public IOException mo4774a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: g */
    private static synchronized il m21136g() throws InterruptedException {
        il ilVar = null;
        synchronized (il.class) {
            il ilVar2 = f24384a.f24386d;
            if (ilVar2 == null) {
                il.class.wait();
            } else {
                long nanoTime = ilVar2.f24387e - System.nanoTime();
                if (nanoTime > 0) {
                    long j = nanoTime / 1000000;
                    il.class.wait(j, (int) (nanoTime - (1000000 * j)));
                } else {
                    f24384a.f24386d = ilVar2.f24386d;
                    ilVar2.f24386d = null;
                    ilVar = ilVar2;
                }
            }
        }
        return ilVar;
    }
}
