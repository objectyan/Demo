package com.baidu.mobstat;

import java.security.MessageDigest;

/* renamed from: com.baidu.mobstat.d */
public final class C3590d {
    /* renamed from: a */
    public static byte[] m15652a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
