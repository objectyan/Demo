package com.baidu.che.codriver.util;

import com.baidu.sapi2.utils.C4923f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryptUtil */
/* renamed from: com.baidu.che.codriver.util.d */
public class C2717d {
    /* renamed from: a */
    private static final char[] f8905a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private static String f8906b = C4923f.f20618w;
    /* renamed from: c */
    private static String f8907c = C4923f.f20617v;
    /* renamed from: d */
    private static final String f8908d = "0123456789abcdef";

    /* renamed from: a */
    public static String m10177a(String str) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            md5Str = C2717d.m10178a(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str.toLowerCase();
    }

    /* renamed from: a */
    public static String m10178a(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        int index = 0;
        for (byte b : bytes) {
            int i = index + 1;
            hexChars[index] = f8905a[(b >>> 4) & 15];
            index = i + 1;
            hexChars[i] = f8905a[b & 15];
        }
        return new String(hexChars);
    }

    /* renamed from: b */
    public static String m10180b(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString("UTF-8");
    }

    /* renamed from: b */
    private static String m10181b(byte[] buf) {
        String HEX = "0123456789ABCDEF";
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            result.append("0123456789ABCDEF".charAt((buf[i] >> 4) & 15)).append("0123456789ABCDEF".charAt(buf[i] & 15));
        }
        return result.toString();
    }

    /* renamed from: a */
    public static byte[] m10179a(byte[] userData, byte[] key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, f8906b);
        Cipher cipher = Cipher.getInstance(f8907c);
        cipher.init(1, skeySpec, new IvParameterSpec(f8908d.getBytes()));
        return cipher.doFinal(userData);
    }

    /* renamed from: b */
    public static byte[] m10182b(byte[] userData, byte[] key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, f8906b);
        Cipher cipher = Cipher.getInstance(f8907c);
        cipher.init(2, skeySpec, new IvParameterSpec(f8908d.getBytes()));
        return cipher.doFinal(userData);
    }
}
