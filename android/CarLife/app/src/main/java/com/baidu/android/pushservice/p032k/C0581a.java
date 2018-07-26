package com.baidu.android.pushservice.p032k;

import android.text.TextUtils;
import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.android.pushservice.k.a */
public final class C0581a {
    /* renamed from: a */
    public static byte[] m2627a(String str, String str2, byte[] bArr) throws Exception {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m2628b(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || bArr == null) {
            return null;
        }
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }
}
