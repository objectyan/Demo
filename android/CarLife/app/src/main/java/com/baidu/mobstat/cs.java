package com.baidu.mobstat;

import android.annotation.SuppressLint;
import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class cs {
    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public static byte[] m15619a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Key secretKeySpec = new SecretKeySpec(bArr, C4923f.f20618w);
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    /* renamed from: a */
    public static byte[] m15618a() {
        KeyGenerator instance = KeyGenerator.getInstance(C4923f.f20618w);
        instance.init(128, new SecureRandom());
        return instance.generateKey().getEncoded();
    }

    /* renamed from: b */
    public static byte[] m15621b() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    public static String m15617a(byte[] bArr) {
        try {
            return m15620b(m15618a(), m15621b(), bArr);
        } catch (Throwable e) {
            db.m15662b(e);
            return "";
        }
    }

    /* renamed from: b */
    public static String m15620b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return cv.m15642b(m15619a(bArr, bArr2, cx.m15644a(bArr3))) + "|" + dc.m15666a(bArr) + "|" + dc.m15666a(bArr2);
        } catch (Throwable e) {
            db.m15662b(e);
            return "";
        }
    }
}
