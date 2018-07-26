package com.indooratlas.android.sdk._internal;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class fj implements fh {
    fj() {
    }

    /* renamed from: a */
    public final String mo4676a(String str, String str2) {
        try {
            byte[] bytes = str2.trim().getBytes("UTF-8");
            Key secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return new String(jh.a(instance.doFinal(bytes)));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public final String mo4677a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return new String(jh.a(instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
