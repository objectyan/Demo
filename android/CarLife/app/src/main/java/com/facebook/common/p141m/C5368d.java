package com.facebook.common.p141m;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SecureHashUtil */
/* renamed from: com.facebook.common.m.d */
public class C5368d {
    /* renamed from: a */
    static final byte[] f21955a = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};

    /* renamed from: a */
    public static String m18380a(String text) {
        try {
            return C5368d.m18381a(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static String m18381a(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(bytes, 0, bytes.length);
            return C5368d.m18385d(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: b */
    public static String m18383b(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(bytes, 0, bytes.length);
            return Base64.encodeToString(md.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public static String m18382b(String text) {
        try {
            return C5368d.m18384c(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public static String m18384c(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes, 0, bytes.length);
            return C5368d.m18385d(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: d */
    public static String m18385d(byte[] raw) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(raw.length);
        for (byte b : raw) {
            int v = b & 255;
            sb.append((char) f21955a[v >>> 4]);
            sb.append((char) f21955a[v & 15]);
        }
        return sb.toString();
    }
}
