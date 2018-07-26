package com.indooratlas.android.sdk._internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

final class iy implements io {
    /* renamed from: a */
    public final in f24423a;
    /* renamed from: b */
    public final jc f24424b;
    /* renamed from: c */
    private boolean f24425c;

    private iy(jc jcVar, in inVar) {
        if (jcVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f24423a = inVar;
        this.f24424b = jcVar;
    }

    public iy(jc jcVar) {
        this(jcVar, new in());
    }

    /* renamed from: b */
    public final in mo4741b() {
        return this.f24423a;
    }

    public final void a_(in inVar, long j) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.a_(inVar, j);
        mo4765p();
    }

    /* renamed from: b */
    public final io mo4742b(iq iqVar) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21182a(iqVar);
        return mo4765p();
    }

    /* renamed from: b */
    public final io mo4743b(String str) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21183a(str);
        return mo4765p();
    }

    /* renamed from: b */
    public final io mo4744b(byte[] bArr) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21185a(bArr);
        return mo4765p();
    }

    /* renamed from: b */
    public final io mo4745b(byte[] bArr, int i, int i2) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21186a(bArr, i, i2);
        return mo4765p();
    }

    /* renamed from: a */
    public final long mo4739a(jd jdVar) throws IOException {
        if (jdVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = jdVar.mo4730a(this.f24423a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (a == -1) {
                return j;
            }
            j += a;
            mo4765p();
        }
    }

    /* renamed from: j */
    public final io mo4761j(int i) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21191b(i);
        return mo4765p();
    }

    /* renamed from: i */
    public final io mo4758i(int i) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21196c(i);
        return mo4765p();
    }

    /* renamed from: h */
    public final io mo4755h(int i) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21199d(i);
        return mo4765p();
    }

    /* renamed from: g */
    public final io mo4754g(int i) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21203e(i);
        return mo4765p();
    }

    /* renamed from: j */
    public final io mo4762j(long j) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21209g(j);
        return mo4765p();
    }

    /* renamed from: i */
    public final io mo4759i(long j) throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        this.f24423a.m21211h(j);
        return mo4765p();
    }

    /* renamed from: p */
    public final io mo4765p() throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        in inVar = this.f24423a;
        long j = inVar.f24392b;
        if (j == 0) {
            j = 0;
        } else {
            ja jaVar = inVar.f24391a.f24435g;
            if (jaVar.f24431c < 2048 && jaVar.f24433e) {
                j -= (long) (jaVar.f24431c - jaVar.f24430b);
            }
        }
        if (j > 0) {
            this.f24424b.a_(this.f24423a, j);
        }
        return this;
    }

    /* renamed from: c */
    public final io mo4746c() throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        long j = this.f24423a.f24392b;
        if (j > 0) {
            this.f24424b.a_(this.f24423a, j);
        }
        return this;
    }

    public final void flush() throws IOException {
        if (this.f24425c) {
            throw new IllegalStateException("closed");
        }
        if (this.f24423a.f24392b > 0) {
            this.f24424b.a_(this.f24423a, this.f24423a.f24392b);
        }
        this.f24424b.flush();
    }

    public final void close() throws IOException {
        if (!this.f24425c) {
            Throwable th = null;
            try {
                if (this.f24423a.f24392b > 0) {
                    this.f24424b.a_(this.f24423a, this.f24423a.f24392b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f24424b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f24425c = true;
            if (th != null) {
                jf.m21315a(th);
            }
        }
    }

    /* renamed from: a */
    public final je mo4733a() {
        return this.f24424b.mo4733a();
    }

    public final String toString() {
        return "buffer(" + this.f24424b + ")";
    }
}
