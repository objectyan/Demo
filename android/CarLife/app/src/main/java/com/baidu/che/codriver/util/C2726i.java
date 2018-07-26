package com.baidu.che.codriver.util;

import java.security.MessageDigest;

/* compiled from: MD5Util */
/* renamed from: com.baidu.che.codriver.util.i */
public class C2726i {
    /* renamed from: a */
    private static final char[] f8939a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m10216a(String str) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            md5Str = C2726i.m10217a(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str.toLowerCase();
    }

    /* renamed from: a */
    public static String m10217a(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        int index = 0;
        for (byte b : bytes) {
            int i = index + 1;
            hexChars[index] = f8939a[(b >>> 4) & 15];
            index = i + 1;
            hexChars[i] = f8939a[b & 15];
        }
        return new String(hexChars);
    }
}
