package com.baidu.platform.comapi.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtil */
/* renamed from: com.baidu.platform.comapi.util.a */
public class C4794a {
    /* renamed from: a */
    private static final String f19878a = "AES/ECB/PKCS5Padding";
    /* renamed from: b */
    private static final String f19879b = "AES";

    /* renamed from: a */
    public static byte[] m15887a(String secretKey, byte[] data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(f19878a);
        cipher.init(1, key);
        return cipher.doFinal(data);
    }

    /* renamed from: b */
    public static byte[] m15888b(String secretKey, byte[] data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, key);
        return cipher.doFinal(data);
    }
}
