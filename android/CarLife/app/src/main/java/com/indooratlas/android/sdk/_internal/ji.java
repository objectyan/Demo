package com.indooratlas.android.sdk._internal;

import java.util.Arrays;

public abstract class ji {
    /* renamed from: a */
    private final int f24445a = 3;
    /* renamed from: b */
    protected final byte f24446b = (byte) 61;
    /* renamed from: c */
    protected final int f24447c = 0;
    /* renamed from: d */
    private final int f24448d = 4;
    /* renamed from: e */
    private final int f24449e;

    /* renamed from: com.indooratlas.android.sdk._internal.ji$a */
    static class C5989a {
        /* renamed from: a */
        int f24459a;
        /* renamed from: b */
        long f24460b;
        /* renamed from: c */
        byte[] f24461c;
        /* renamed from: d */
        int f24462d;
        /* renamed from: e */
        int f24463e;
        /* renamed from: f */
        boolean f24464f;
        /* renamed from: g */
        int f24465g;
        /* renamed from: h */
        int f24466h;

        C5989a() {
        }

        public final String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{getClass().getSimpleName(), Arrays.toString(this.f24461c), Integer.valueOf(this.f24465g), Boolean.valueOf(this.f24464f), Integer.valueOf(this.f24459a), Long.valueOf(this.f24460b), Integer.valueOf(this.f24466h), Integer.valueOf(this.f24462d), Integer.valueOf(this.f24463e)});
        }
    }

    /* renamed from: a */
    abstract void mo4776a(byte[] bArr, int i, int i2, C5989a c5989a);

    /* renamed from: a */
    protected abstract boolean mo4777a(byte b);

    protected ji(int i) {
        this.f24449e = i;
    }

    /* renamed from: a */
    protected static byte[] m21317a(int i, C5989a c5989a) {
        if (c5989a.f24461c != null && c5989a.f24461c.length >= c5989a.f24462d + i) {
            return c5989a.f24461c;
        }
        if (c5989a.f24461c == null) {
            c5989a.f24461c = new byte[8192];
            c5989a.f24462d = 0;
            c5989a.f24463e = 0;
        } else {
            Object obj = new byte[(c5989a.f24461c.length * 2)];
            System.arraycopy(c5989a.f24461c, 0, obj, 0, c5989a.f24461c.length);
            c5989a.f24461c = obj;
        }
        return c5989a.f24461c;
    }

    /* renamed from: b */
    protected final boolean m21320b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if ((byte) 61 == b || mo4777a(b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final long m21321c(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f24445a) - 1) / this.f24445a)) * ((long) this.f24448d);
        if (this.f24447c > 0) {
            return length + ((((((long) this.f24447c) + length) - 1) / ((long) this.f24447c)) * ((long) this.f24449e));
        }
        return length;
    }
}
