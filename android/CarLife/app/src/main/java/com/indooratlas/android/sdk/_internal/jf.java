package com.indooratlas.android.sdk._internal;

import java.nio.charset.Charset;

final class jf {
    /* renamed from: a */
    public static final Charset f24438a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static void m21314a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static short m21313a(short s) {
        int i = 65535 & s;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* renamed from: a */
    public static int m21312a(int i) {
        return ((((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8)) | ((65280 & i) << 8)) | ((i & 255) << 24);
    }

    /* renamed from: a */
    public static boolean m21316a(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2 + 0] != bArr2[i2 + 0]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m21315a(Throwable th) {
        throw th;
    }
}
