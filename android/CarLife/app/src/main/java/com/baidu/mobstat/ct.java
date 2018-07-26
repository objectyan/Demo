package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ct {
    /* renamed from: a */
    public static byte[] m15622a(int i, byte[] bArr) {
        int i2 = i - 1;
        if (i2 < 0 || cw.f19627a.length <= i2) {
            return new byte[0];
        }
        Key secretKeySpec = new SecretKeySpec(cw.f19627a[i2].getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m15623b(int i, byte[] bArr) {
        int i2 = i - 1;
        if (i2 < 0 || cw.f19627a.length <= i2) {
            return new byte[0];
        }
        Key secretKeySpec = new SecretKeySpec(cw.f19627a[i2].getBytes(), C4923f.f20618w);
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr);
    }

    /* renamed from: c */
    public static String m15624c(int i, byte[] bArr) {
        try {
            return cv.m15642b(m15622a(i, bArr));
        } catch (Throwable e) {
            db.m15659a(e);
            return "";
        }
    }

    /* renamed from: d */
    public static String m15625d(int i, byte[] bArr) {
        Object c = m15624c(i, bArr);
        return TextUtils.isEmpty(c) ? "" : c + "|" + i;
    }
}
