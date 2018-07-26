package com.baidu.android.pushservice.p032k;

import android.annotation.SuppressLint;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.carlife.core.connect.p070a.C1204d;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.baidu.android.pushservice.k.g */
public final class C0591g {
    /* renamed from: a */
    public static boolean m2671a(byte[] bArr, String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(C0582b.m2630a(str2.getBytes())));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(bArr);
            return instance.verify(C0582b.m2630a(str.getBytes()));
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    /* renamed from: a */
    public static byte[] m2672a(byte[] bArr, String str) throws Exception {
        Key generatePrivate = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(C0582b.m2630a(str.getBytes())));
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(2, generatePrivate);
        return instance.doFinal(bArr);
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    /* renamed from: b */
    public static byte[] m2673b(byte[] bArr, String str) throws Exception {
        Key generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(C0582b.m2630a(str.getBytes())));
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    @SuppressLint({"InlinedApi", "OldTargetApi"})
    /* renamed from: c */
    public static byte[] m2674c(byte[] bArr, String str) throws Exception {
        Key generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(C0582b.m2630a(str.getBytes())));
        Cipher instance = Cipher.getInstance(C1204d.f3244d);
        instance.init(1, generatePublic);
        int length = bArr.length;
        Object obj = new byte[((((length + MessageType.BNMessageTypeCarFreeStatus) - 1) / MessageType.BNMessageTypeCarFreeStatus) * 128)];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3 = length - i2;
            if (MessageType.BNMessageTypeCarFreeStatus < i3) {
                i3 = MessageType.BNMessageTypeCarFreeStatus;
            }
            Object obj2 = new byte[i3];
            System.arraycopy(bArr, i2, obj2, 0, i3);
            i2 += i3;
            System.arraycopy(instance.doFinal(obj2), 0, obj, i, 128);
            i += 128;
        }
        return obj;
    }
}
