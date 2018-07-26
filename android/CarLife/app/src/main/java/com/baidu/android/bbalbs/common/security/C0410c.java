package com.baidu.android.bbalbs.common.security;

import java.security.MessageDigest;

/* renamed from: com.baidu.android.bbalbs.common.security.c */
public final class C0410c {
    /* renamed from: a */
    public static byte[] m1727a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
