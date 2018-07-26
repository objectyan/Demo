package com.baidu.mobstat;

import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.mobstat.a */
public final class C3584a {
    /* renamed from: a */
    public static byte[] m15285a(String str, String str2, byte[] bArr) {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m15286b(String str, String str2, byte[] bArr) {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }
}
