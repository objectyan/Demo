package com.baidu.carlife.core.connect.config;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESManager */
/* renamed from: com.baidu.carlife.core.connect.a.b */
public class AESManager {
    /* renamed from: a */
    private Cipher f3232a;
    /* renamed from: b */
    private Cipher f3233b;

    public AESManager() {
        m4111a();
    }

    /* renamed from: a */
    private void m4111a() {
        SecretKey sk = new SecretKeySpec(EncryptConfig.m4118a().m4119b().getBytes(), "AES");
        try {
            this.f3232a = Cipher.getInstance("AES");
            this.f3233b = Cipher.getInstance("AES");
            this.f3232a.init(1, sk);
            this.f3233b.init(2, sk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public byte[] m4112a(byte[] rawData, int len) {
        if (this.f3232a == null) {
            return null;
        }
        byte[] encryptData = null;
        try {
            return this.f3232a.doFinal(rawData, 0, len);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return encryptData;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return encryptData;
        }
    }

    /* renamed from: b */
    public byte[] m4113b(byte[] encryptData, int len) {
        if (this.f3233b == null) {
            return null;
        }
        byte[] decryptData = null;
        try {
            return this.f3233b.doFinal(encryptData, 0, len);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return decryptData;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return decryptData;
        }
    }
}
