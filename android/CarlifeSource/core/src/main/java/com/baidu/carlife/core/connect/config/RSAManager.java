package com.baidu.carlife.core.connect.config;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/* compiled from: RSAManager */
/* renamed from: com.baidu.carlife.core.connect.a.f */
public class RSAManager {
    /* renamed from: a */
    public PublicKey getPublicKey(String key) {
        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance("RSA").
                    generatePublic(new X509EncodedKeySpec(Base64.decode(key, Base64.NO_WRAP)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    /* renamed from: a */
    public String getRst(String data, PublicKey publicKey) {
        String rstStr = null;
        try {
            Cipher cipher = Cipher.getInstance(EncryptConfig.RSA_ECB_PKCS1_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipher.update(data.getBytes("UTF-8"));
            rstStr = Base64.encodeToString(cipher.doFinal(), Base64.NO_WRAP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rstStr;
    }
}
