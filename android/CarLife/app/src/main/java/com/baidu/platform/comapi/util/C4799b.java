package com.baidu.platform.comapi.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Base64 */
/* renamed from: com.baidu.platform.comapi.util.b */
public class C4799b {
    /* renamed from: a */
    static final String[] f19907a = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

    /* renamed from: a */
    public static String m15938a(byte[] data) {
        return C4799b.m15939a(data, 0, data.length, null).toString();
    }

    /* renamed from: a */
    public static StringBuffer m15939a(byte[] data, int start, int len, StringBuffer buf) {
        char[] charT = f19907a[0].toCharArray();
        if (buf == null) {
            buf = new StringBuffer((data.length * 3) / 2);
        }
        int end = len - 3;
        int i = start;
        while (i <= end) {
            int d = (((data[i] & 255) << 16) | ((data[i + 1] & 255) << 8)) | (data[i + 2] & 255);
            buf.append(charT[(d >> 18) & 63]);
            buf.append(charT[(d >> 12) & 63]);
            buf.append(charT[(d >> 6) & 63]);
            buf.append(charT[d & 63]);
            i += 3;
        }
        if (i == (start + len) - 2) {
            d = ((data[i] & 255) << 16) | ((data[i + 1] & 255) << 8);
            buf.append(charT[(d >> 18) & 63]);
            buf.append(charT[(d >> 12) & 63]);
            buf.append(charT[(d >> 6) & 63]);
        } else if (i == (start + len) - 1) {
            d = (data[i] & 255) << 16;
            buf.append(charT[(d >> 18) & 63]);
            buf.append(charT[(d >> 12) & 63]);
        }
        return buf;
    }

    /* renamed from: a */
    public static int m15937a(char c, int key) {
        char[] charT = f19907a[key].toCharArray();
        if (c == '=') {
            return 0;
        }
        for (int i = 0; i < 64; i++) {
            if (charT[i] == c) {
                return i;
            }
        }
        throw new RuntimeException("unexpected code: " + c);
    }

    /* renamed from: a */
    public static byte[] m15941a(String s) {
        byte[] temp = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        if (s == null) {
            return null;
        }
        try {
            C4799b.m15940a(s, bos);
            temp = bos.toByteArray();
            bos.close();
            try {
                bos.close();
            } catch (IOException e) {
            }
        } catch (Exception e2) {
            try {
                bos.close();
            } catch (IOException e3) {
            }
        } catch (Throwable th) {
            try {
                bos.close();
            } catch (IOException e4) {
            }
            throw th;
        }
        return temp;
    }

    /* renamed from: a */
    public static void m15940a(String s, ByteArrayOutputStream bos) {
        int i = 0;
        int len = s.length();
        int nAddNum = s.length() % 4;
        if (nAddNum > 0) {
            nAddNum = 4 - nAddNum;
        }
        while (nAddNum > 0) {
            s = s + '=';
            nAddNum--;
        }
        while (true) {
            if (i < len && s.charAt(i) <= ' ') {
                i++;
            } else if (i != len) {
                int tri = (((C4799b.m15937a(s.charAt(i), 0) << 18) + (C4799b.m15937a(s.charAt(i + 1), 0) << 12)) + (C4799b.m15937a(s.charAt(i + 2), 0) << 6)) + C4799b.m15937a(s.charAt(i + 3), 0);
                bos.write((tri >> 16) & 255);
                if (s.charAt(i + 2) != '=') {
                    bos.write((tri >> 8) & 255);
                    if (s.charAt(i + 3) != '=') {
                        bos.write(tri & 255);
                        i += 4;
                    } else {
                        return;
                    }
                }
                return;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public static boolean m15942b(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '-') {
                if (s.charAt(i) > 'z') {
                    return true;
                }
                if (((s.charAt(i) < 'a' ? 1 : 0) & (s.charAt(i) > 'Z' ? 1 : 0)) != 0) {
                    return true;
                }
                if (((s.charAt(i) < 'A' ? 1 : 0) & (s.charAt(i) > '9' ? 1 : 0)) != 0 || s.charAt(i) < '0') {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
