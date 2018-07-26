package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class iw implements jd {
    /* renamed from: a */
    private final ip f24413a;
    /* renamed from: b */
    private final Inflater f24414b;
    /* renamed from: c */
    private int f24415c;
    /* renamed from: d */
    private boolean f24416d;

    public iw(jd jdVar, Inflater inflater) {
        this(ix.m21259a(jdVar), inflater);
    }

    iw(ip ipVar, Inflater inflater) {
        if (ipVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f24413a = ipVar;
            this.f24414b = inflater;
        }
    }

    /* renamed from: a */
    public final long mo4730a(in inVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f24416d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean b;
            do {
                b = m21252b();
                try {
                    ja f = inVar.m21205f(1);
                    int inflate = this.f24414b.inflate(f.f24429a, f.f24431c, 2048 - f.f24431c);
                    if (inflate > 0) {
                        f.f24431c += inflate;
                        inVar.f24392b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f24414b.finished() || this.f24414b.needsDictionary()) {
                        m21249c();
                        if (f.f24430b == f.f24431c) {
                            inVar.f24391a = f.m21304a();
                            jb.m21308a(f);
                        }
                        return -1;
                    }
                } catch (Throwable e) {
                    throw new IOException(e);
                }
            } while (!b);
            throw new EOFException("source exhausted prematurely");
        }
    }

    /* renamed from: b */
    public final boolean m21252b() throws IOException {
        if (!this.f24414b.needsInput()) {
            return false;
        }
        m21249c();
        if (this.f24414b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f24413a.mo4748d()) {
            return true;
        } else {
            ja jaVar = this.f24413a.mo4741b().f24391a;
            this.f24415c = jaVar.f24431c - jaVar.f24430b;
            this.f24414b.setInput(jaVar.f24429a, jaVar.f24430b, this.f24415c);
            return false;
        }
    }

    /* renamed from: c */
    private void m21249c() throws IOException {
        if (this.f24415c != 0) {
            int remaining = this.f24415c - this.f24414b.getRemaining();
            this.f24415c -= remaining;
            this.f24413a.mo4752f((long) remaining);
        }
    }

    /* renamed from: a */
    public final je mo4731a() {
        return this.f24413a.mo4731a();
    }

    public final void close() throws IOException {
        if (!this.f24416d) {
            this.f24414b.end();
            this.f24416d = true;
            this.f24413a.close();
        }
    }
}
