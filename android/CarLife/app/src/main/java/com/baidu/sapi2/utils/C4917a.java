package com.baidu.sapi2.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
/* renamed from: com.baidu.sapi2.utils.a */
public class C4917a {
    /* renamed from: a */
    private static final String f20533a = "UTF-8";
    /* renamed from: b */
    private static final String f20534b = "AES/CBC/NoPadding";
    /* renamed from: c */
    private static final String f20535c = "AES";
    /* renamed from: d */
    private String f20536d;
    /* renamed from: e */
    private String f20537e;
    /* renamed from: f */
    private String f20538f;

    public C4917a() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public C4917a(String algorithm, String algorithmMode) {
        this(algorithm, algorithmMode, "UTF-8");
    }

    public C4917a(String algorithm, String algorithmMode, String encoding) {
        this.f20536d = "UTF-8";
        this.f20537e = "AES/CBC/NoPadding";
        this.f20538f = "AES";
        this.f20538f = algorithm;
        this.f20537e = algorithmMode;
        this.f20536d = encoding;
    }

    /* renamed from: a */
    public byte[] m16392a(String text, String iv, String secretKey) throws Exception {
        if (text == null || text.length() == 0) {
            throw new Exception("Empty string");
        }
        byte[] encrypted = null;
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(this.f20536d));
            SecretKeySpec keyspec = new SecretKeySpec(secretKey.getBytes(), this.f20538f);
            Cipher cipher = Cipher.getInstance(this.f20537e);
            cipher.init(1, keyspec, ivspec);
            encrypted = cipher.doFinal(C4917a.m16391a(text).getBytes());
        } catch (NoSuchAlgorithmException e) {
            C4913L.m16374e(e);
        } catch (NoSuchPaddingException e2) {
            C4913L.m16374e(e2);
        }
        return encrypted;
    }

    /* renamed from: a */
    public byte[] m16393a(byte[] code, String iv, String secretKey) throws Exception {
        if (code == null || code.length == 0) {
            throw new Exception("Empty string");
        }
        byte[] decrypted = new byte[0];
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(this.f20536d));
            SecretKeySpec keyspec = new SecretKeySpec(secretKey.getBytes(), this.f20538f);
            Cipher cipher = Cipher.getInstance(this.f20537e);
            cipher.init(2, keyspec, ivspec);
            decrypted = cipher.doFinal(code);
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        return decrypted;
    }

    /* renamed from: a */
    private static String m16391a(String source) {
        int padLength = 16 - (source.length() % 16);
        for (int i = 0; i < padLength; i++) {
            source = source + ' ';
        }
        return source;
    }
}
