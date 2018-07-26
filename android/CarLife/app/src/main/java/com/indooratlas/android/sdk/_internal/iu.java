package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class iu implements jc {
    /* renamed from: a */
    private final io f24403a;
    /* renamed from: b */
    private final Deflater f24404b;
    /* renamed from: c */
    private final ir f24405c;
    /* renamed from: d */
    private boolean f24406d;
    /* renamed from: e */
    private final CRC32 f24407e = new CRC32();

    public iu(jc jcVar) {
        if (jcVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f24404b = new Deflater(-1, true);
        this.f24403a = ix.m21258a(jcVar);
        this.f24405c = new ir(this.f24403a, this.f24404b);
        in b = this.f24403a.mo4741b();
        b.m21196c(8075);
        b.m21191b(8);
        b.m21191b(0);
        b.m21199d(0);
        b.m21191b(0);
        b.m21191b(0);
    }

    public final void a_(in inVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            m21243b(inVar, j);
            this.f24405c.a_(inVar, j);
        }
    }

    public final void flush() throws IOException {
        this.f24405c.flush();
    }

    /* renamed from: a */
    public final je mo4733a() {
        return this.f24403a.mo4733a();
    }

    public final void close() throws IOException {
        Throwable th;
        if (!this.f24406d) {
            Throwable th2 = null;
            try {
                this.f24405c.m21235b();
                this.f24403a.mo4754g((int) this.f24407e.getValue());
                this.f24403a.mo4754g(this.f24404b.getTotalIn());
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f24404b.end();
                th3 = th2;
            } catch (Throwable th4) {
                th3 = th4;
                if (th2 != null) {
                    th3 = th2;
                }
            }
            try {
                this.f24403a.close();
            } catch (Throwable th22) {
                if (th3 == null) {
                    th3 = th22;
                }
            }
            this.f24406d = true;
            if (th3 != null) {
                jf.m21315a(th3);
            }
        }
    }

    /* renamed from: b */
    private void m21243b(in inVar, long j) {
        ja jaVar = inVar.f24391a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (jaVar.f24431c - jaVar.f24430b));
            this.f24407e.update(jaVar.f24429a, jaVar.f24430b, min);
            j -= (long) min;
            jaVar = jaVar.f24434f;
        }
    }
}
