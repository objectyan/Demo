package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class je {
    /* renamed from: b */
    public static final je f24380b = new C59881();
    /* renamed from: a */
    private boolean f24381a;
    /* renamed from: c */
    private long f24382c;
    /* renamed from: d */
    private long f24383d;

    /* renamed from: com.indooratlas.android.sdk._internal.je$1 */
    static class C59881 extends je {
        C59881() {
        }

        /* renamed from: a */
        public final je mo4767a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: a */
        public final je mo4766a(long j) {
            return this;
        }

        /* renamed from: f */
        public final void mo4773f() throws IOException {
        }
    }

    /* renamed from: a */
    public je mo4767a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f24383d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long c_() {
        return this.f24383d;
    }

    public boolean d_() {
        return this.f24381a;
    }

    /* renamed from: c */
    public long mo4768c() {
        if (this.f24381a) {
            return this.f24382c;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: a */
    public je mo4766a(long j) {
        this.f24381a = true;
        this.f24382c = j;
        return this;
    }

    /* renamed from: d */
    public je mo4770d() {
        this.f24383d = 0;
        return this;
    }

    public je e_() {
        this.f24381a = false;
        return this;
    }

    /* renamed from: f */
    public void mo4773f() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f24381a && this.f24382c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
