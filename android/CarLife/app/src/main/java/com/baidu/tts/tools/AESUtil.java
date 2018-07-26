package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESUtil {
    @SuppressLint({"TrulyRandom"})
    public static byte[] encrypt(String paramString1, String paramString2, byte[] paramArrayOfByte) throws Exception {
        Key secretKeySpec = new SecretKeySpec(paramString2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(1, secretKeySpec, new IvParameterSpec(paramString1.getBytes()));
        return instance.doFinal(paramArrayOfByte);
    }

    public static byte[] decrypt(String paramString1, String paramString2, byte[] paramArrayOfByte) throws Exception {
        Key secretKeySpec = new SecretKeySpec(paramString2.getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance(C4923f.f20617v);
        instance.init(2, secretKeySpec, new IvParameterSpec(paramString1.getBytes()));
        return instance.doFinal(paramArrayOfByte);
    }
}
