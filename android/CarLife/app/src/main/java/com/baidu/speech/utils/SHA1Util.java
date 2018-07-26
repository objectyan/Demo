package com.baidu.speech.utils;

import java.security.MessageDigest;

public final class SHA1Util {
    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
