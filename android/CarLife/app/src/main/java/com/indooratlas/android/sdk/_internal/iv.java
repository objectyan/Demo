package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class iv implements jd {
    /* renamed from: a */
    private int f24408a = 0;
    /* renamed from: b */
    private final ip f24409b;
    /* renamed from: c */
    private final Inflater f24410c;
    /* renamed from: d */
    private final iw f24411d;
    /* renamed from: e */
    private final CRC32 f24412e = new CRC32();

    public iv(jd jdVar) {
        if (jdVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f24410c = new Inflater(true);
        this.f24409b = ix.m21259a(jdVar);
        this.f24411d = new iw(this.f24409b, this.f24410c);
    }

    /* renamed from: a */
    public final long mo4730a(in inVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f24408a == 0) {
                Object obj;
                long a;
                this.f24409b.mo4740a(10);
                byte b = this.f24409b.mo4741b().m21189b(3);
                if (((b >> 1) & 1) == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    m21245a(this.f24409b.mo4741b(), 0, 10);
                }
                m21246a("ID1ID2", 8075, this.f24409b.mo4751f());
                this.f24409b.mo4752f(8);
                if (((b >> 2) & 1) == 1) {
                    this.f24409b.mo4740a(2);
                    if (obj != null) {
                        m21245a(this.f24409b.mo4741b(), 0, 2);
                    }
                    short h = this.f24409b.mo4741b().mo4756h();
                    this.f24409b.mo4740a((long) h);
                    if (obj != null) {
                        m21245a(this.f24409b.mo4741b(), 0, (long) h);
                    }
                    this.f24409b.mo4752f((long) h);
                }
                if (((b >> 3) & 1) == 1) {
                    a = this.f24409b.mo4738a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        m21245a(this.f24409b.mo4741b(), 0, 1 + a);
                    }
                    this.f24409b.mo4752f(1 + a);
                }
                if (((b >> 4) & 1) == 1) {
                    a = this.f24409b.mo4738a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        m21245a(this.f24409b.mo4741b(), 0, 1 + a);
                    }
                    this.f24409b.mo4752f(1 + a);
                }
                if (obj != null) {
                    m21246a("FHCRC", this.f24409b.mo4756h(), (short) ((int) this.f24412e.getValue()));
                    this.f24412e.reset();
                }
                this.f24408a = 1;
            }
            if (this.f24408a == 1) {
                long j2 = inVar.f24392b;
                long a2 = this.f24411d.mo4730a(inVar, j);
                if (a2 != -1) {
                    m21245a(inVar, j2, a2);
                    return a2;
                }
                this.f24408a = 2;
            }
            if (this.f24408a == 2) {
                m21246a("CRC", this.f24409b.mo4757i(), (int) this.f24412e.getValue());
                m21246a("ISIZE", this.f24409b.mo4757i(), this.f24410c.getTotalOut());
                this.f24408a = 3;
                if (!this.f24409b.mo4748d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public final je mo4731a() {
        return this.f24409b.mo4731a();
    }

    public final void close() throws IOException {
        this.f24411d.close();
    }

    /* renamed from: a */
    private void m21245a(in inVar, long j, long j2) {
        ja jaVar = inVar.f24391a;
        while (j >= ((long) (jaVar.f24431c - jaVar.f24430b))) {
            j -= (long) (jaVar.f24431c - jaVar.f24430b);
            jaVar = jaVar.f24434f;
        }
        while (j2 > 0) {
            int i = (int) (((long) jaVar.f24430b) + j);
            int min = (int) Math.min((long) (jaVar.f24431c - i), j2);
            this.f24412e.update(jaVar.f24429a, i, min);
            j2 -= (long) min;
            jaVar = jaVar.f24434f;
            j = 0;
        }
    }

    /* renamed from: a */
    private static void m21246a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
