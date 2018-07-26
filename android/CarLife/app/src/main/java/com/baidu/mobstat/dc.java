package com.baidu.mobstat;

import com.baidu.android.common.security.RSAUtil;
import com.baidu.carlife.core.connect.p070a.C1204d;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class dc {
    /* renamed from: a */
    public static String m15666a(byte[] bArr) {
        try {
            return cv.m15642b(m15669a(false, cw.m15643a(), bArr));
        } catch (Throwable e) {
            db.m15662b(e);
            return "";
        }
    }

    /* renamed from: a */
    public static byte[] m15669a(boolean z, byte[] bArr, byte[] bArr2) {
        RSAKey a = m15667a(z, bArr);
        return m15668a(1, (Key) a, ((a.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    /* renamed from: b */
    public static byte[] m15670b(boolean z, byte[] bArr, byte[] bArr2) {
        RSAKey a = m15667a(z, bArr);
        return m15668a(2, (Key) a, (a.getModulus().bitLength() + 1) / 8, bArr2);
    }

    /* renamed from: a */
    private static RSAKey m15667a(boolean z, byte[] bArr) {
        KeyFactory instance = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        if (z) {
            return (RSAPrivateKey) instance.generatePrivate(new PKCS8EncodedKeySpec(bArr));
        }
        return (RSAPublicKey) instance.generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    private static byte[] m15668a(int i, Key key, int i2, byte[] bArr) {
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(i, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        while (i3 < bArr.length) {
            int length = bArr.length - i3;
            if (length > i2) {
                length = i2;
            }
            byteArrayOutputStream.write(instance.doFinal(bArr, i3, length));
            i3 += i2;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
