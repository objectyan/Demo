package com.baidu.tts.tools;

import java.security.MessageDigest;

public class SHA1Util {
    private SHA1Util() {
    }

    public static byte[] sha1(byte[] var0) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(var0);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
