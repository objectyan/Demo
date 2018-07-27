package com.baidu.carlife.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: MD5Util */
/* renamed from: com.baidu.carlife.util.k */
public class C2180k {
    /* renamed from: a */
    private static final char[] f6972a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m8280a(String str) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes(Charset.forName("UTF-8")));
            md5Str = C2180k.m8281a(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    /* renamed from: a */
    public static String m8281a(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        int index = 0;
        for (byte b : bytes) {
            int i = index + 1;
            hexChars[index] = f6972a[(b >>> 4) & 15];
            index = i + 1;
            hexChars[i] = f6972a[b & 15];
        }
        return new String(hexChars);
    }
}
