package com.baidu.android.pushservice.p032k;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.android.pushservice.k.f */
public class C0590f {
    /* renamed from: a */
    private static int m2667a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: a */
    public static String m2668a(byte[] bArr, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (z) {
                toHexString = toHexString.toUpperCase();
            }
            if (toHexString.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(toHexString).append(str);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m2669a(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return C0590f.m2668a(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m2670a(String str) {
        byte[] bArr = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                String toUpperCase = str.toUpperCase();
                int length = toUpperCase.length() / 2;
                bArr = new byte[length];
                char[] toCharArray = toUpperCase.toCharArray();
                if (toCharArray != null) {
                    int i = 0;
                    while (i < length) {
                        int i2 = i * 2;
                        if (i2 >= 0 && i2 + 1 < toCharArray.length && i >= 0 && i < length) {
                            bArr[i] = (byte) (C0590f.m2667a(toCharArray[i2 + 1]) | (C0590f.m2667a(toCharArray[i2]) << 4));
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
        }
        return bArr;
    }
}
