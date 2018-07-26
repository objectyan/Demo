package com.tencent.wxop.stat.p291b;

import android.util.Base64;

/* renamed from: com.tencent.wxop.stat.b.h */
public class C6139h {
    /* renamed from: a */
    static byte[] m21845a() {
        return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
    }

    /* renamed from: a */
    public static byte[] m21846a(byte[] bArr) {
        return C6139h.m21847a(bArr, C6139h.m21845a());
    }

    /* renamed from: a */
    static byte[] m21847a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < 256; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & 255;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & 255;
            length = (length + iArr[i2]) & 255;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    /* renamed from: b */
    public static byte[] m21848b(byte[] bArr) {
        return C6139h.m21849b(bArr, C6139h.m21845a());
    }

    /* renamed from: b */
    static byte[] m21849b(byte[] bArr, byte[] bArr2) {
        return C6139h.m21847a(bArr, bArr2);
    }
}
