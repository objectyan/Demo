package com.facebook.common.p141m;

/* compiled from: Hex */
/* renamed from: com.facebook.common.m.c */
public class C5367c {
    /* renamed from: a */
    private static final char[] f21951a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private static final char[] f21952b = new char[256];
    /* renamed from: c */
    private static final char[] f21953c = new char[256];
    /* renamed from: d */
    private static final byte[] f21954d = new byte[103];

    static {
        int i;
        byte i2;
        for (i = 0; i < 256; i++) {
            f21952b[i] = f21951a[(i >> 4) & 15];
            f21953c[i] = f21951a[i & 15];
        }
        for (i = 0; i <= 70; i++) {
            f21954d[i] = (byte) -1;
        }
        for (i2 = (byte) 0; i2 < (byte) 10; i2 = (byte) (i2 + 1)) {
            f21954d[i2 + 48] = i2;
        }
        for (i2 = (byte) 0; i2 < (byte) 6; i2 = (byte) (i2 + 1)) {
            f21954d[i2 + 65] = (byte) (i2 + 10);
            f21954d[i2 + 97] = (byte) (i2 + 10);
        }
    }

    /* renamed from: a */
    public static String m18376a(int value) {
        if (value <= 255 && value >= 0) {
            return String.valueOf(f21952b[value]) + String.valueOf(f21953c[value]);
        }
        throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }

    /* renamed from: a */
    public static String m18377a(byte[] array, boolean zeroTerminated) {
        char[] cArray = new char[(array.length * 2)];
        int j = 0;
        for (byte b : array) {
            int index = b & 255;
            if (index == 0 && zeroTerminated) {
                break;
            }
            int i = j + 1;
            cArray[j] = f21952b[index];
            j = i + 1;
            cArray[i] = f21953c[index];
        }
        return new String(cArray, 0, j);
    }

    /* renamed from: a */
    public static byte[] m18378a(String hexString) {
        int length = hexString.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        boolean badHex = false;
        byte[] out = new byte[(length >> 1)];
        int i = 0;
        int j = 0;
        while (j < length) {
            int j2 = j + 1;
            int c1 = hexString.charAt(j);
            if (c1 > 102) {
                badHex = true;
                break;
            }
            byte d1 = f21954d[c1];
            if (d1 == (byte) -1) {
                badHex = true;
                break;
            }
            j = j2 + 1;
            int c2 = hexString.charAt(j2);
            if (c2 > 102) {
                badHex = true;
                j2 = j;
                break;
            }
            byte d2 = f21954d[c2];
            if (d2 == (byte) -1) {
                badHex = true;
                j2 = j;
                break;
            }
            out[i] = (byte) ((d1 << 4) | d2);
            i++;
        }
        if (!badHex) {
            return out;
        }
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + hexString);
    }

    /* renamed from: b */
    public static byte[] m18379b(String s) {
        return C5367c.m18378a(s.replaceAll(" ", ""));
    }
}
