package com.baidu.android.pushservice.p032k;

import java.security.MessageDigest;

/* renamed from: com.baidu.android.pushservice.k.h */
public final class C0592h {
    /* renamed from: a */
    public static byte[] m2675a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
