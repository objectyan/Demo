package com.baidu.carlife.core.connect.p070a;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: RSAManager */
/* renamed from: com.baidu.carlife.core.connect.a.f */
public class C1209f {
    /* renamed from: a */
    public PublicKey m4139a(String key) {
        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(key, 2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    /* renamed from: a */
    public String m4138a(String data, PublicKey publicKey) {
        String rstStr = null;
        try {
            Cipher cipher = Cipher.getInstance(C1204d.f3244d);
            cipher.init(1, publicKey);
            cipher.update(data.getBytes("UTF-8"));
            rstStr = Base64.encodeToString(cipher.doFinal(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rstStr;
    }
}
