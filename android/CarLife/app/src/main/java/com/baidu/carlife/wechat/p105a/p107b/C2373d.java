package com.baidu.carlife.wechat.p105a.p107b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHA1Util */
/* renamed from: com.baidu.carlife.wechat.a.b.d */
public final class C2373d {
    private C2373d() {
    }

    /* renamed from: a */
    public static String m9039a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return C2373d.m9040a(MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8")));
    }

    /* renamed from: a */
    public static String m9040a(byte[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : input) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(hexString);
        }
        return stringBuilder.toString();
    }
}
