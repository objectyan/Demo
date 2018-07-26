package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.baidu.sapi2.utils.C4923f;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@SuppressLint({"InlinedApi"})
/* compiled from: CryptAES */
/* renamed from: com.baidu.ufosdk.util.m */
public final class C5220m {
    /* renamed from: a */
    private static String m17771a(String str, boolean z) {
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char toHexString : toCharArray) {
            stringBuffer.append(Integer.toHexString(toHexString));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m17769a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C5220m.m17771a("W", false));
        stringBuffer.append(C5220m.m17771a("9", true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(C5220m.m17771a(RoutePlanDataStruct.KEY_Y, true));
        stringBuffer.append("abe");
        stringBuffer.append(C5220m.m17771a("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m17772b() {
        Object stringBuilder = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        stringBuilder.append(stringBuilder);
        return stringBuilder.toString();
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public static String m17770a(String str) {
        byte[] bArr = null;
        try {
            Key d = C5220m.m17775d(C5220m.m17769a());
            Cipher instance = Cipher.getInstance(C4923f.f20621z);
            int blockSize = instance.getBlockSize();
            Object bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            Object obj = new byte[length];
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            instance.init(1, d, new IvParameterSpec(C5220m.m17772b().getBytes()));
            bArr = instance.doFinal(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeToString(bArr, 0));
    }

    /* renamed from: b */
    public static String m17773b(String str) {
        try {
            Key d = C5220m.m17775d(C5220m.m17769a());
            Cipher instance = Cipher.getInstance(C4923f.f20621z);
            instance.init(2, d, new IvParameterSpec(C5220m.m17772b().getBytes()));
            return new String(instance.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static Key m17775d(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), C4923f.f20618w);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /* renamed from: c */
    public static String m17774c(String str) {
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            instance = null;
        }
        if (instance == null) {
            return "";
        }
        instance.reset();
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString(b & 255));
        }
        return stringBuilder.toString();
    }
}
