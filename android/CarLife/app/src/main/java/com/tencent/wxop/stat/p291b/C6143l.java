package com.tencent.wxop.stat.p291b;

/* renamed from: com.tencent.wxop.stat.b.l */
class C6143l extends C6141j {
    /* renamed from: g */
    static final /* synthetic */ boolean f24930g = (!C6140i.class.desiredAssertionStatus());
    /* renamed from: h */
    private static final byte[] f24931h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    /* renamed from: i */
    private static final byte[] f24932i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    /* renamed from: c */
    int f24933c;
    /* renamed from: d */
    public final boolean f24934d;
    /* renamed from: e */
    public final boolean f24935e;
    /* renamed from: f */
    public final boolean f24936f;
    /* renamed from: j */
    private final byte[] f24937j;
    /* renamed from: k */
    private int f24938k;
    /* renamed from: l */
    private final byte[] f24939l;

    public C6143l(int i, byte[] bArr) {
        boolean z = true;
        this.a = bArr;
        this.f24934d = (i & 1) == 0;
        this.f24935e = (i & 2) == 0;
        if ((i & 4) == 0) {
            z = false;
        }
        this.f24936f = z;
        this.f24939l = (i & 8) == 0 ? f24931h : f24932i;
        this.f24937j = new byte[2];
        this.f24933c = 0;
        this.f24938k = this.f24935e ? 19 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m21855a(byte[] r11, int r12, int r13, boolean r14) {
        /*
        r10 = this;
        r6 = r10.f24939l;
        r7 = r10.a;
        r4 = 0;
        r2 = r10.f24938k;
        r8 = r13 + r12;
        r0 = -1;
        r1 = r10.f24933c;
        switch(r1) {
            case 0: goto L_0x00a9;
            case 1: goto L_0x00ad;
            case 2: goto L_0x00d1;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = r0;
        r1 = r12;
    L_0x0011:
        r0 = -1;
        if (r3 == r0) goto L_0x0248;
    L_0x0014:
        r0 = 0;
        r4 = r3 >> 18;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r0 = 1;
        r4 = r3 >> 12;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r0 = 2;
        r4 = r3 >> 6;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r4 = 3;
        r0 = 4;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r4] = r3;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x0244;
    L_0x003b:
        r2 = r10.f24936f;
        if (r2 == 0) goto L_0x0045;
    L_0x003f:
        r2 = 4;
        r0 = 5;
        r3 = 13;
        r7[r2] = r3;
    L_0x0045:
        r4 = r0 + 1;
        r2 = 10;
        r7[r0] = r2;
        r0 = 19;
        r5 = r0;
    L_0x004e:
        r0 = r1 + 3;
        if (r0 > r8) goto L_0x00f5;
    L_0x0052:
        r0 = r11[r1];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r2 = r1 + 1;
        r2 = r11[r2];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r0 = r0 | r2;
        r2 = r1 + 2;
        r2 = r11[r2];
        r2 = r2 & 255;
        r0 = r0 | r2;
        r2 = r0 >> 18;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r4] = r2;
        r2 = r4 + 1;
        r3 = r0 >> 12;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r2] = r3;
        r2 = r4 + 2;
        r3 = r0 >> 6;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r2] = r3;
        r2 = r4 + 3;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r2] = r0;
        r2 = r1 + 3;
        r1 = r4 + 4;
        r0 = r5 + -1;
        if (r0 != 0) goto L_0x023f;
    L_0x0094:
        r0 = r10.f24936f;
        if (r0 == 0) goto L_0x023c;
    L_0x0098:
        r0 = r1 + 1;
        r3 = 13;
        r7[r1] = r3;
    L_0x009e:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        r0 = 19;
        r1 = r2;
        r5 = r0;
        goto L_0x004e;
    L_0x00a9:
        r3 = r0;
        r1 = r12;
        goto L_0x0011;
    L_0x00ad:
        r1 = r12 + 2;
        if (r1 > r8) goto L_0x000f;
    L_0x00b1:
        r0 = r10.f24937j;
        r1 = 0;
        r0 = r0[r1];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r12 + 1;
        r3 = r11[r12];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r0 = r0 | r3;
        r12 = r1 + 1;
        r1 = r11[r1];
        r1 = r1 & 255;
        r0 = r0 | r1;
        r1 = 0;
        r10.f24933c = r1;
        r3 = r0;
        r1 = r12;
        goto L_0x0011;
    L_0x00d1:
        r1 = r12 + 1;
        if (r1 > r8) goto L_0x000f;
    L_0x00d5:
        r0 = r10.f24937j;
        r1 = 0;
        r0 = r0[r1];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r10.f24937j;
        r3 = 1;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r0 = r0 | r1;
        r1 = r12 + 1;
        r3 = r11[r12];
        r3 = r3 & 255;
        r0 = r0 | r3;
        r3 = 0;
        r10.f24933c = r3;
        r3 = r0;
        goto L_0x0011;
    L_0x00f5:
        if (r14 == 0) goto L_0x0202;
    L_0x00f7:
        r0 = r10.f24933c;
        r0 = r1 - r0;
        r2 = r8 + -1;
        if (r0 != r2) goto L_0x0161;
    L_0x00ff:
        r3 = 0;
        r0 = r10.f24933c;
        if (r0 <= 0) goto L_0x015a;
    L_0x0104:
        r0 = r10.f24937j;
        r3 = 0;
        r2 = 1;
        r0 = r0[r3];
    L_0x010a:
        r0 = r0 & 255;
        r3 = r0 << 4;
        r0 = r10.f24933c;
        r0 = r0 - r2;
        r10.f24933c = r0;
        r2 = r4 + 1;
        r0 = r3 >> 6;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r4] = r0;
        r0 = r2 + 1;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r2] = r3;
        r2 = r10.f24934d;
        if (r2 == 0) goto L_0x0135;
    L_0x0129:
        r2 = r0 + 1;
        r3 = 61;
        r7[r0] = r3;
        r0 = r2 + 1;
        r3 = 61;
        r7[r2] = r3;
    L_0x0135:
        r2 = r10.f24935e;
        if (r2 == 0) goto L_0x014b;
    L_0x0139:
        r2 = r10.f24936f;
        if (r2 == 0) goto L_0x0144;
    L_0x013d:
        r2 = r0 + 1;
        r3 = 13;
        r7[r0] = r3;
        r0 = r2;
    L_0x0144:
        r2 = r0 + 1;
        r3 = 10;
        r7[r0] = r3;
        r0 = r2;
    L_0x014b:
        r4 = r0;
    L_0x014c:
        r0 = f24930g;
        if (r0 != 0) goto L_0x01f6;
    L_0x0150:
        r0 = r10.f24933c;
        if (r0 == 0) goto L_0x01f6;
    L_0x0154:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x015a:
        r2 = r1 + 1;
        r0 = r11[r1];
        r1 = r2;
        r2 = r3;
        goto L_0x010a;
    L_0x0161:
        r0 = r10.f24933c;
        r0 = r1 - r0;
        r2 = r8 + -2;
        if (r0 != r2) goto L_0x01da;
    L_0x0169:
        r3 = 0;
        r0 = r10.f24933c;
        r2 = 1;
        if (r0 <= r2) goto L_0x01cd;
    L_0x016f:
        r0 = r10.f24937j;
        r3 = 0;
        r2 = 1;
        r0 = r0[r3];
    L_0x0175:
        r0 = r0 & 255;
        r9 = r0 << 10;
        r0 = r10.f24933c;
        if (r0 <= 0) goto L_0x01d4;
    L_0x017d:
        r0 = r10.f24937j;
        r3 = r2 + 1;
        r0 = r0[r2];
        r2 = r3;
    L_0x0184:
        r0 = r0 & 255;
        r0 = r0 << 2;
        r0 = r0 | r9;
        r3 = r10.f24933c;
        r2 = r3 - r2;
        r10.f24933c = r2;
        r2 = r4 + 1;
        r3 = r0 >> 12;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r4] = r3;
        r3 = r2 + 1;
        r4 = r0 >> 6;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r2] = r4;
        r2 = r3 + 1;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r3] = r0;
        r0 = r10.f24934d;
        if (r0 == 0) goto L_0x0239;
    L_0x01af:
        r0 = r2 + 1;
        r3 = 61;
        r7[r2] = r3;
    L_0x01b5:
        r2 = r10.f24935e;
        if (r2 == 0) goto L_0x01cb;
    L_0x01b9:
        r2 = r10.f24936f;
        if (r2 == 0) goto L_0x01c4;
    L_0x01bd:
        r2 = r0 + 1;
        r3 = 13;
        r7[r0] = r3;
        r0 = r2;
    L_0x01c4:
        r2 = r0 + 1;
        r3 = 10;
        r7[r0] = r3;
        r0 = r2;
    L_0x01cb:
        r4 = r0;
        goto L_0x014c;
    L_0x01cd:
        r2 = r1 + 1;
        r0 = r11[r1];
        r1 = r2;
        r2 = r3;
        goto L_0x0175;
    L_0x01d4:
        r3 = r1 + 1;
        r0 = r11[r1];
        r1 = r3;
        goto L_0x0184;
    L_0x01da:
        r0 = r10.f24935e;
        if (r0 == 0) goto L_0x014c;
    L_0x01de:
        if (r4 <= 0) goto L_0x014c;
    L_0x01e0:
        r0 = 19;
        if (r5 == r0) goto L_0x014c;
    L_0x01e4:
        r0 = r10.f24936f;
        if (r0 == 0) goto L_0x0237;
    L_0x01e8:
        r0 = r4 + 1;
        r2 = 13;
        r7[r4] = r2;
    L_0x01ee:
        r4 = r0 + 1;
        r2 = 10;
        r7[r0] = r2;
        goto L_0x014c;
    L_0x01f6:
        r0 = f24930g;
        if (r0 != 0) goto L_0x0212;
    L_0x01fa:
        if (r1 == r8) goto L_0x0212;
    L_0x01fc:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0202:
        r0 = r8 + -1;
        if (r1 != r0) goto L_0x0218;
    L_0x0206:
        r0 = r10.f24937j;
        r2 = r10.f24933c;
        r3 = r2 + 1;
        r10.f24933c = r3;
        r1 = r11[r1];
        r0[r2] = r1;
    L_0x0212:
        r10.b = r4;
        r10.f24938k = r5;
        r0 = 1;
        return r0;
    L_0x0218:
        r0 = r8 + -2;
        if (r1 != r0) goto L_0x0212;
    L_0x021c:
        r0 = r10.f24937j;
        r2 = r10.f24933c;
        r3 = r2 + 1;
        r10.f24933c = r3;
        r3 = r11[r1];
        r0[r2] = r3;
        r0 = r10.f24937j;
        r2 = r10.f24933c;
        r3 = r2 + 1;
        r10.f24933c = r3;
        r1 = r1 + 1;
        r1 = r11[r1];
        r0[r2] = r1;
        goto L_0x0212;
    L_0x0237:
        r0 = r4;
        goto L_0x01ee;
    L_0x0239:
        r0 = r2;
        goto L_0x01b5;
    L_0x023c:
        r0 = r1;
        goto L_0x009e;
    L_0x023f:
        r5 = r0;
        r4 = r1;
        r1 = r2;
        goto L_0x004e;
    L_0x0244:
        r5 = r2;
        r4 = r0;
        goto L_0x004e;
    L_0x0248:
        r5 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.l.a(byte[], int, int, boolean):boolean");
    }
}
