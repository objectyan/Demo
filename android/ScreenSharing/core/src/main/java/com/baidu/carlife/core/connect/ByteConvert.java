package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;

/* compiled from: ByteConvert */
/* renamed from: com.baidu.carlife.core.connect.b */
public class ByteConvert implements KeepClass {
    /* renamed from: a */
    public static byte[] m4176a(long n) {
        return new byte[]{(byte) ((int) (n & 255)), (byte) ((int) ((n >> 8) & 255)), (byte) ((int) ((n >> 16) & 255)), (byte) ((int) ((n >> 24) & 255)), (byte) ((int) ((n >> 32) & 255)), (byte) ((int) ((n >> 40) & 255)), (byte) ((int) ((n >> 48) & 255)), (byte) ((int) ((n >> 56) & 255))};
    }

    /* renamed from: a */
    public static void m4173a(long n, byte[] array, int offset) {
        array[offset + 7] = (byte) ((int) (n & 255));
        array[offset + 6] = (byte) ((int) ((n >> 8) & 255));
        array[offset + 5] = (byte) ((int) ((n >> 16) & 255));
        array[offset + 4] = (byte) ((int) ((n >> 24) & 255));
        array[offset + 3] = (byte) ((int) ((n >> 32) & 255));
        array[offset + 2] = (byte) ((int) ((n >> 40) & 255));
        array[offset + 1] = (byte) ((int) ((n >> 48) & 255));
        array[offset + 0] = (byte) ((int) ((n >> 56) & 255));
    }

    /* renamed from: a */
    public static long m4170a(byte[] array) {
        return ((((((((((long) array[0]) & 255) << 56) | ((((long) array[1]) & 255) << 48)) | ((((long) array[2]) & 255) << 40)) | ((((long) array[3]) & 255) << 32)) | ((((long) array[4]) & 255) << 24)) | ((((long) array[5]) & 255) << 16)) | ((((long) array[6]) & 255) << 8)) | ((((long) array[7]) & 255) << 0);
    }

    /* renamed from: a */
    public static long m4171a(byte[] array, int offset) {
        return ((((((((((long) array[offset + 0]) & 255) << 56) | ((((long) array[offset + 1]) & 255) << 48)) | ((((long) array[offset + 2]) & 255) << 40)) | ((((long) array[offset + 3]) & 255) << 32)) | ((((long) array[offset + 4]) & 255) << 24)) | ((((long) array[offset + 5]) & 255) << 16)) | ((((long) array[offset + 6]) & 255) << 8)) | ((((long) array[offset + 7]) & 255) << 0);
    }

    /* renamed from: a */
    public static byte[] m4175a(int n) {
        return new byte[]{(byte) (n & 255), (byte) ((n >> 8) & 255), (byte) ((n >> 16) & 255), (byte) ((n >> 24) & 255)};
    }

    /* renamed from: a */
    public static void m4172a(int n, byte[] array, int offset) {
        array[offset + 3] = (byte) (n & 255);
        array[offset + 2] = (byte) ((n >> 8) & 255);
        array[offset + 1] = (byte) ((n >> 16) & 255);
        array[offset] = (byte) ((n >> 24) & 255);
    }

    /* renamed from: b */
    public static int m4178b(byte[] b) {
        return (((b[3] & 255) | ((b[2] & 255) << 8)) | ((b[1] & 255) << 16)) | ((b[0] & 255) << 24);
    }

    /* renamed from: b */
    public static int m4179b(byte[] b, int offset) {
        return (((b[offset + 3] & 255) | ((b[offset + 2] & 255) << 8)) | ((b[offset + 1] & 255) << 16)) | ((b[offset] & 255) << 24);
    }

    /* renamed from: b */
    public static byte[] m4183b(long n) {
        return new byte[]{(byte) ((int) (n & 255)), (byte) ((int) ((n >> 8) & 255)), (byte) ((int) ((n >> 16) & 255)), (byte) ((int) ((n >> 24) & 255))};
    }

    /* renamed from: b */
    public static void m4181b(long n, byte[] array, int offset) {
        array[offset + 3] = (byte) ((int) n);
        array[offset + 2] = (byte) ((int) ((n >> 8) & 255));
        array[offset + 1] = (byte) ((int) ((n >> 16) & 255));
        array[offset] = (byte) ((int) ((n >> 24) & 255));
    }

    /* renamed from: c */
    public static long m4184c(byte[] array) {
        return ((((long) (array[3] & 255)) | (((long) (array[2] & 255)) << 8)) | (((long) (array[1] & 255)) << 16)) | (((long) (array[0] & 255)) << 24);
    }

    /* renamed from: c */
    public static long m4185c(byte[] array, int offset) {
        return ((((long) (array[offset + 3] & 255)) | (((long) (array[offset + 2] & 255)) << 8)) | (((long) (array[offset + 1] & 255)) << 16)) | (((long) (array[offset] & 255)) << 24);
    }

    /* renamed from: a */
    public static byte[] m4177a(short n) {
        return new byte[]{(byte) (n & 255), (byte) ((n >> 8) & 255)};
    }

    /* renamed from: a */
    public static void m4174a(short n, byte[] array, int offset) {
        array[offset + 1] = (byte) (n & 255);
        array[offset] = (byte) ((n >> 8) & 255);
    }

    /* renamed from: d */
    public static short m4188d(byte[] b) {
        return (short) ((b[1] & 255) | ((b[0] & 255) << 8));
    }

    /* renamed from: d */
    public static short m4189d(byte[] b, int offset) {
        return (short) ((b[offset + 1] & 255) | ((b[offset] & 255) << 8));
    }

    /* renamed from: b */
    public static byte[] m4182b(int n) {
        return new byte[]{(byte) (n & 255), (byte) ((n >> 8) & 255)};
    }

    /* renamed from: b */
    public static void m4180b(int n, byte[] array, int offset) {
        array[offset + 1] = (byte) (n & 255);
        array[offset] = (byte) ((n >> 8) & 255);
    }

    /* renamed from: e */
    public static int m4190e(byte[] b) {
        return (b[1] & 255) | ((b[0] & 255) << 8);
    }

    /* renamed from: e */
    public static int m4191e(byte[] b, int offset) {
        return (b[offset + 1] & 255) | ((b[offset] & 255) << 8);
    }

    /* renamed from: c */
    public static byte[] m4187c(int n) {
        return new byte[]{(byte) (n & 255)};
    }

    /* renamed from: c */
    public static void m4186c(int n, byte[] array, int offset) {
        array[0] = (byte) (n & 255);
    }

    /* renamed from: f */
    public static int m4192f(byte[] array) {
        return array[0] & 255;
    }

    /* renamed from: f */
    public static int m4193f(byte[] array, int offset) {
        return array[offset] & 255;
    }
}
