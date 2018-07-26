package com.tencent.wxop.stat.p291b;

/* renamed from: com.tencent.wxop.stat.b.k */
class C6142k extends C6141j {
    /* renamed from: c */
    private static final int[] f24925c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    /* renamed from: d */
    private static final int[] f24926d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    /* renamed from: e */
    private int f24927e;
    /* renamed from: f */
    private int f24928f;
    /* renamed from: g */
    private final int[] f24929g;

    public C6142k(int i, byte[] bArr) {
        this.a = bArr;
        this.f24929g = (i & 8) == 0 ? f24925c : f24926d;
        this.f24927e = 0;
        this.f24928f = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m21854a(byte[] r10, int r11, int r12, boolean r13) {
        /*
        r9 = this;
        r0 = r9.f24927e;
        r1 = 6;
        if (r0 != r1) goto L_0x0007;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        return r0;
    L_0x0007:
        r4 = r12 + r11;
        r2 = r9.f24927e;
        r1 = r9.f24928f;
        r0 = 0;
        r5 = r9.a;
        r6 = r9.f24929g;
        r3 = r2;
        r2 = r11;
    L_0x0014:
        if (r2 >= r4) goto L_0x0108;
    L_0x0016:
        if (r3 != 0) goto L_0x005d;
    L_0x0018:
        r7 = r2 + 4;
        if (r7 > r4) goto L_0x005b;
    L_0x001c:
        r1 = r10[r2];
        r1 = r1 & 255;
        r1 = r6[r1];
        r1 = r1 << 18;
        r7 = r2 + 1;
        r7 = r10[r7];
        r7 = r7 & 255;
        r7 = r6[r7];
        r7 = r7 << 12;
        r1 = r1 | r7;
        r7 = r2 + 2;
        r7 = r10[r7];
        r7 = r7 & 255;
        r7 = r6[r7];
        r7 = r7 << 6;
        r1 = r1 | r7;
        r7 = r2 + 3;
        r7 = r10[r7];
        r7 = r7 & 255;
        r7 = r6[r7];
        r1 = r1 | r7;
        if (r1 < 0) goto L_0x005b;
    L_0x0045:
        r7 = r0 + 2;
        r8 = (byte) r1;
        r5[r7] = r8;
        r7 = r0 + 1;
        r8 = r1 >> 8;
        r8 = (byte) r8;
        r5[r7] = r8;
        r7 = r1 >> 16;
        r7 = (byte) r7;
        r5[r0] = r7;
        r0 = r0 + 3;
        r2 = r2 + 4;
        goto L_0x0018;
    L_0x005b:
        if (r2 >= r4) goto L_0x0108;
    L_0x005d:
        r11 = r2 + 1;
        r2 = r10[r2];
        r2 = r2 & 255;
        r2 = r6[r2];
        switch(r3) {
            case 0: goto L_0x006a;
            case 1: goto L_0x007a;
            case 2: goto L_0x008d;
            case 3: goto L_0x00b1;
            case 4: goto L_0x00ed;
            case 5: goto L_0x00ff;
            default: goto L_0x0068;
        };
    L_0x0068:
        r2 = r11;
        goto L_0x0014;
    L_0x006a:
        if (r2 < 0) goto L_0x0072;
    L_0x006c:
        r1 = r3 + 1;
        r3 = r1;
        r1 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x0072:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x0075:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x007a:
        if (r2 < 0) goto L_0x0084;
    L_0x007c:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r3 + 1;
        r3 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x0084:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x0087:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x008d:
        if (r2 < 0) goto L_0x0098;
    L_0x008f:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r3 + 1;
        r3 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x0098:
        r7 = -2;
        if (r2 != r7) goto L_0x00a8;
    L_0x009b:
        r2 = r0 + 1;
        r3 = r1 >> 4;
        r3 = (byte) r3;
        r5[r0] = r3;
        r0 = 4;
        r3 = r0;
        r0 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x00a8:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x00ab:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00b1:
        if (r2 < 0) goto L_0x00ce;
    L_0x00b3:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r0 + 2;
        r3 = (byte) r1;
        r5[r2] = r3;
        r2 = r0 + 1;
        r3 = r1 >> 8;
        r3 = (byte) r3;
        r5[r2] = r3;
        r2 = r1 >> 16;
        r2 = (byte) r2;
        r5[r0] = r2;
        r0 = r0 + 3;
        r2 = 0;
        r3 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x00ce:
        r7 = -2;
        if (r2 != r7) goto L_0x00e4;
    L_0x00d1:
        r2 = r0 + 1;
        r3 = r1 >> 2;
        r3 = (byte) r3;
        r5[r2] = r3;
        r2 = r1 >> 10;
        r2 = (byte) r2;
        r5[r0] = r2;
        r0 = r0 + 2;
        r2 = 5;
        r3 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x00e4:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x00e7:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00ed:
        r7 = -2;
        if (r2 != r7) goto L_0x00f6;
    L_0x00f0:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r11;
        goto L_0x0014;
    L_0x00f6:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x00f9:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00ff:
        r7 = -1;
        if (r2 == r7) goto L_0x0068;
    L_0x0102:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x0108:
        r2 = r1;
        if (r13 != 0) goto L_0x0114;
    L_0x010b:
        r9.f24927e = r3;
        r9.f24928f = r2;
        r9.b = r0;
        r0 = 1;
        goto L_0x0006;
    L_0x0114:
        switch(r3) {
            case 0: goto L_0x0117;
            case 1: goto L_0x011e;
            case 2: goto L_0x0124;
            case 3: goto L_0x012d;
            case 4: goto L_0x013c;
            default: goto L_0x0117;
        };
    L_0x0117:
        r9.f24927e = r3;
        r9.b = r0;
        r0 = 1;
        goto L_0x0006;
    L_0x011e:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x0124:
        r1 = r0 + 1;
        r2 = r2 >> 4;
        r2 = (byte) r2;
        r5[r0] = r2;
        r0 = r1;
        goto L_0x0117;
    L_0x012d:
        r1 = r0 + 1;
        r4 = r2 >> 10;
        r4 = (byte) r4;
        r5[r0] = r4;
        r0 = r1 + 1;
        r2 = r2 >> 2;
        r2 = (byte) r2;
        r5[r1] = r2;
        goto L_0x0117;
    L_0x013c:
        r0 = 6;
        r9.f24927e = r0;
        r0 = 0;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.k.a(byte[], int, int, boolean):boolean");
    }
}
