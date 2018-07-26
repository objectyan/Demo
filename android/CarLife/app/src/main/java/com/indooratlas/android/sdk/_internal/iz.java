package com.indooratlas.android.sdk._internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;

final class iz implements ip {
    /* renamed from: a */
    public final in f24426a;
    /* renamed from: b */
    public final jd f24427b;
    /* renamed from: c */
    private boolean f24428c;

    private iz(jd jdVar, in inVar) {
        if (jdVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f24426a = inVar;
        this.f24427b = jdVar;
    }

    public iz(jd jdVar) {
        this(jdVar, new in());
    }

    /* renamed from: b */
    public final in mo4741b() {
        return this.f24426a;
    }

    /* renamed from: a */
    public final long mo4730a(in inVar, long j) throws IOException {
        if (inVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f24428c) {
            throw new IllegalStateException("closed");
        } else if (this.f24426a.f24392b == 0 && this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
            return -1;
        } else {
            return this.f24426a.mo4730a(inVar, Math.min(j, this.f24426a.f24392b));
        }
    }

    /* renamed from: d */
    public final boolean mo4748d() throws IOException {
        if (!this.f24428c) {
            return this.f24426a.mo4748d() && this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: a */
    public final void mo4740a(long j) throws IOException {
        if (!m21279b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    private boolean m21279b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f24428c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f24426a.f24392b < j) {
                if (this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: e */
    public final byte mo4749e() throws IOException {
        mo4740a(1);
        return this.f24426a.mo4749e();
    }

    /* renamed from: c */
    public final iq mo4747c(long j) throws IOException {
        mo4740a(j);
        return this.f24426a.mo4747c(j);
    }

    /* renamed from: n */
    public final byte[] mo4764n() throws IOException {
        this.f24426a.mo4739a(this.f24427b);
        return this.f24426a.mo4764n();
    }

    /* renamed from: e */
    public final byte[] mo4750e(long j) throws IOException {
        mo4740a(j);
        return this.f24426a.mo4750e(j);
    }

    /* renamed from: m */
    public final String mo4763m() throws IOException {
        long a = mo4738a((byte) 10);
        if (a != -1) {
            return this.f24426a.m21200d(a);
        }
        in inVar = new in();
        this.f24426a.m21181a(inVar, 0, Math.min(32, this.f24426a.f24392b));
        throw new EOFException("\\n not found: size=" + this.f24426a.f24392b + " content=" + inVar.m21220k().m21230b() + "...");
    }

    /* renamed from: f */
    public final short mo4751f() throws IOException {
        mo4740a(2);
        return this.f24426a.mo4751f();
    }

    /* renamed from: h */
    public final short mo4756h() throws IOException {
        mo4740a(2);
        return jf.m21313a(this.f24426a.mo4751f());
    }

    /* renamed from: g */
    public final int mo4753g() throws IOException {
        mo4740a(4);
        return this.f24426a.mo4753g();
    }

    /* renamed from: i */
    public final int mo4757i() throws IOException {
        mo4740a(4);
        return jf.m21312a(this.f24426a.mo4753g());
    }

    /* renamed from: j */
    public final long mo4760j() throws IOException {
        mo4740a(1);
        for (int i = 0; m21279b((long) (i + 1)); i++) {
            byte b = this.f24426a.m21189b((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && ((b < (byte) 97 || b > (byte) 102) && (b < (byte) 65 || b > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.f24426a.mo4760j();
            }
        }
        return this.f24426a.mo4760j();
    }

    /* renamed from: f */
    public final void mo4752f(long j) throws IOException {
        if (this.f24428c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f24426a.f24392b == 0 && this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f24426a.f24392b);
            this.f24426a.mo4752f(min);
            j -= min;
        }
    }

    /* renamed from: a */
    public final long mo4738a(byte b) throws IOException {
        long j = 0;
        if (this.f24428c) {
            throw new IllegalStateException("closed");
        }
        while (0 >= this.f24426a.f24392b) {
            if (this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
        }
        do {
            j = this.f24426a.m21177a(b, j);
            if (j != -1) {
                return j;
            }
            j = this.f24426a.f24392b;
        } while (this.f24427b.mo4730a(this.f24426a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
        return -1;
    }

    public final void close() throws IOException {
        if (!this.f24428c) {
            this.f24428c = true;
            this.f24427b.close();
            this.f24426a.m21224o();
        }
    }

    /* renamed from: a */
    public final je mo4731a() {
        return this.f24427b.mo4731a();
    }

    public final String toString() {
        return "buffer(" + this.f24427b + ")";
    }
}
