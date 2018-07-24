package com.baidu.carlife.p100n;

import com.baidu.carlife.core.CommonParams;

/* compiled from: CarlifeMessageParser */
/* renamed from: com.baidu.carlife.n.a */
public class C1945a {
    /* renamed from: a */
    private static final int f6177a = 8;
    /* renamed from: b */
    private byte[] f6178b = new byte[8];

    /* compiled from: CarlifeMessageParser */
    /* renamed from: com.baidu.carlife.n.a$a */
    public enum C1944a {
        TRANSFER_START,
        TRANSFER_SEND,
        TRANSFER_END
    }

    /* renamed from: a */
    public int m7403a() {
        return 8;
    }

    /* renamed from: b */
    public byte[] m7404b() {
        return this.f6178b;
    }

    /* renamed from: c */
    public int m7405c() {
        return (((this.f6178b[0] & 255) << 8) & 65280) | ((this.f6178b[1] & 255) & 255);
    }

    /* renamed from: d */
    public C1944a m7406d() {
        switch ((((((this.f6178b[4] & 255) << 24) & -16777216) | (((this.f6178b[5] & 255) << 16) & 16711680)) | (((this.f6178b[6] & 255) << 8) & 65280)) | ((this.f6178b[7] & 255) & 255)) {
            case CommonParams.bP /*458759*/:
                return C1944a.TRANSFER_START;
            case CommonParams.bQ /*458760*/:
                return C1944a.TRANSFER_SEND;
            case CommonParams.bR /*458761*/:
                return C1944a.TRANSFER_END;
            default:
                throw new IllegalStateException("unsupport message type");
        }
    }
}
