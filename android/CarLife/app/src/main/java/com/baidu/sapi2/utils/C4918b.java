package com.baidu.sapi2.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;

/* compiled from: RSA */
/* renamed from: com.baidu.sapi2.utils.b */
public class C4918b {
    /* renamed from: a */
    public static byte[] m16394a(String plain, String key) {
        byte[] bArr = null;
        if (!(plain == null || TextUtils.isEmpty(key))) {
            try {
                Cipher rsa = Cipher.getInstance("RSA/NONE/NoPadding");
                rsa.init(1, X509Certificate.getInstance(new ByteArrayInputStream(key.getBytes())).getPublicKey());
                bArr = rsa.doFinal(plain.getBytes("UTF-8"));
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
        return bArr;
    }
}
