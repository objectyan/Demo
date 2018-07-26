package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.s */
public final class C6007s {
    /* renamed from: a */
    public static final int[] f24576a = new int[0];
    /* renamed from: b */
    public static final long[] f24577b = new long[0];
    /* renamed from: c */
    public static final float[] f24578c = new float[0];
    /* renamed from: d */
    public static final double[] f24579d = new double[0];
    /* renamed from: e */
    public static final boolean[] f24580e = new boolean[0];
    /* renamed from: f */
    public static final String[] f24581f = new String[0];
    /* renamed from: g */
    public static final byte[][] f24582g = new byte[0][];
    /* renamed from: h */
    public static final byte[] f24583h = new byte[0];

    /* renamed from: a */
    static int m21526a(int i) {
        return i & 7;
    }

    /* renamed from: b */
    public static int m21529b(int i) {
        return i >>> 3;
    }

    /* renamed from: a */
    static int m21527a(int i, int i2) {
        return (i << 3) | i2;
    }

    /* renamed from: a */
    public static final int m21528a(C5757a c5757a, int i) throws IOException {
        int i2 = 1;
        int k = c5757a.k();
        c5757a.b(i);
        while (c5757a.a() == i) {
            c5757a.b(i);
            i2++;
        }
        c5757a.e(k);
        return i2;
    }
}
