package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class ir implements jc {
    /* renamed from: a */
    private final io f24398a;
    /* renamed from: b */
    private final Deflater f24399b;
    /* renamed from: c */
    private boolean f24400c;

    public ir(jc jcVar, Deflater deflater) {
        this(ix.m21258a(jcVar), deflater);
    }

    ir(io ioVar, Deflater deflater) {
        if (ioVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f24398a = ioVar;
            this.f24399b = deflater;
        }
    }

    public final void a_(in inVar, long j) throws IOException {
        jf.m21314a(inVar.f24392b, 0, j);
        while (j > 0) {
            ja jaVar = inVar.f24391a;
            int min = (int) Math.min(j, (long) (jaVar.f24431c - jaVar.f24430b));
            this.f24399b.setInput(jaVar.f24429a, jaVar.f24430b, min);
            m21233a(false);
            inVar.f24392b -= (long) min;
            jaVar.f24430b += min;
            if (jaVar.f24430b == jaVar.f24431c) {
                inVar.f24391a = jaVar.m21304a();
                jb.m21308a(jaVar);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m21233a(boolean z) throws IOException {
        in b = this.f24398a.mo4741b();
        while (true) {
            int deflate;
            ja f = b.m21205f(1);
            if (z) {
                deflate = this.f24399b.deflate(f.f24429a, f.f24431c, 2048 - f.f24431c, 2);
            } else {
                deflate = this.f24399b.deflate(f.f24429a, f.f24431c, 2048 - f.f24431c);
            }
            if (deflate > 0) {
                f.f24431c += deflate;
                b.f24392b += (long) deflate;
                this.f24398a.mo4765p();
            } else if (this.f24399b.needsInput()) {
                break;
            }
        }
        if (f.f24430b == f.f24431c) {
            b.f24391a = f.m21304a();
            jb.m21308a(f);
        }
    }

    public final void flush() throws IOException {
        m21233a(true);
        this.f24398a.flush();
    }

    /* renamed from: b */
    final void m21235b() throws IOException {
        this.f24399b.finish();
        m21233a(false);
    }

    public final void close() throws IOException {
        if (!this.f24400c) {
            Throwable th;
            Throwable th2 = null;
            try {
                m21235b();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f24399b.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.f24398a.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.f24400c = true;
            if (th != null) {
                jf.m21315a(th);
            }
        }
    }

    /* renamed from: a */
    public final je mo4733a() {
        return this.f24398a.mo4733a();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f24398a + ")";
    }
}
