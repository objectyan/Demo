package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class gr implements Closeable, Flushable {
    /* renamed from: a */
    static final Pattern f24005a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: b */
    static final /* synthetic */ boolean f24006b = (!gr.class.desiredAssertionStatus());
    /* renamed from: n */
    private static final jc f24007n = new C59281();
    /* renamed from: c */
    private final ih f24008c;
    /* renamed from: d */
    private long f24009d;
    /* renamed from: e */
    private final int f24010e;
    /* renamed from: f */
    private long f24011f;
    /* renamed from: g */
    private io f24012g;
    /* renamed from: h */
    private final LinkedHashMap<String, C5930b> f24013h;
    /* renamed from: i */
    private int f24014i;
    /* renamed from: j */
    private boolean f24015j;
    /* renamed from: k */
    private boolean f24016k;
    /* renamed from: l */
    private final Executor f24017l;
    /* renamed from: m */
    private final Runnable f24018m;

    /* renamed from: com.indooratlas.android.sdk._internal.gr$1 */
    static class C59281 implements jc {
        C59281() {
        }

        public final void a_(in inVar, long j) throws IOException {
            inVar.f(j);
        }

        public final void flush() throws IOException {
        }

        /* renamed from: a */
        public final je m20745a() {
            return je.f24380b;
        }

        public final void close() throws IOException {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gr$a */
    public final class C5929a {
        /* renamed from: a */
        final C5930b f23996a;
        /* renamed from: b */
        boolean f23997b;
        /* renamed from: c */
        final /* synthetic */ gr f23998c;
    }

    /* renamed from: com.indooratlas.android.sdk._internal.gr$b */
    final class C5930b {
        /* renamed from: a */
        final String f23999a;
        /* renamed from: b */
        final long[] f24000b;
        /* renamed from: c */
        final File[] f24001c;
        /* renamed from: d */
        final File[] f24002d;
        /* renamed from: e */
        boolean f24003e;
        /* renamed from: f */
        C5929a f24004f;

        /* renamed from: a */
        final void m20746a(io ioVar) throws IOException {
            for (long j : this.f24000b) {
                ioVar.j(32).j(j);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m20747a(C5929a c5929a) throws IOException {
        C5930b c5930b = c5929a.f23996a;
        if (c5930b.f24004f != c5929a) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < this.f24010e; i++) {
            this.f24008c.a(c5930b.f24002d[i]);
        }
        this.f24014i++;
        c5930b.f24004f = null;
        if ((c5930b.f24003e | 0) != 0) {
            c5930b.f24003e = true;
            this.f24012g.b("CLEAN").j(32);
            this.f24012g.b(c5930b.f23999a);
            c5930b.m20746a(this.f24012g);
            this.f24012g.j(10);
        } else {
            this.f24013h.remove(c5930b.f23999a);
            this.f24012g.b("REMOVE").j(32);
            this.f24012g.b(c5930b.f23999a);
            this.f24012g.j(10);
        }
        this.f24012g.flush();
        if (this.f24011f > this.f24009d || m20748a()) {
            this.f24017l.execute(this.f24018m);
        }
    }

    /* renamed from: a */
    private boolean m20748a() {
        return this.f24014i >= 2000 && this.f24014i >= this.f24013h.size();
    }

    /* renamed from: b */
    private synchronized boolean m20749b() {
        return this.f24016k;
    }

    /* renamed from: c */
    private synchronized void m20750c() {
        if (m20749b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.f24015j) {
            m20750c();
            m20751d();
            this.f24012g.flush();
        }
    }

    public final synchronized void close() throws IOException {
        if (!this.f24015j || this.f24016k) {
            this.f24016k = true;
        } else {
            for (C5930b c5930b : (C5930b[]) this.f24013h.values().toArray(new C5930b[this.f24013h.size()])) {
                if (c5930b.f24004f != null) {
                    C5929a c5929a = c5930b.f24004f;
                    synchronized (c5929a.f23998c) {
                        c5929a.f23998c.m20747a(c5929a);
                    }
                }
            }
            m20751d();
            this.f24012g.close();
            this.f24012g = null;
            this.f24016k = true;
        }
    }

    /* renamed from: d */
    private void m20751d() throws IOException {
        while (this.f24011f > this.f24009d) {
            C5930b c5930b = (C5930b) this.f24013h.values().iterator().next();
            if (c5930b.f24004f != null) {
                c5930b.f24004f.f23997b = true;
            }
            for (int i = 0; i < this.f24010e; i++) {
                this.f24008c.a(c5930b.f24001c[i]);
                this.f24011f -= c5930b.f24000b[i];
                c5930b.f24000b[i] = 0;
            }
            this.f24014i++;
            this.f24012g.b("REMOVE").j(32).b(c5930b.f23999a).j(10);
            this.f24013h.remove(c5930b.f23999a);
            if (m20748a()) {
                this.f24017l.execute(this.f24018m);
            }
        }
    }
}
