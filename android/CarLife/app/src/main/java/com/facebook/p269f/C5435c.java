package com.facebook.p269f;

import com.facebook.common.internal.C5341b;
import com.facebook.common.internal.C5342c;
import com.facebook.common.internal.C5348i;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.p263n.C5374b;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ImageFormatChecker */
/* renamed from: com.facebook.f.c */
public class C5435c {
    /* renamed from: a */
    private static final int f22197a = 20;
    /* renamed from: b */
    private static final int f22198b = 21;
    /* renamed from: c */
    private static final byte[] f22199c = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    /* renamed from: d */
    private static final byte[] f22200d = new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71, (byte) 13, (byte) 10, (byte) 26, (byte) 10};
    /* renamed from: e */
    private static final byte[] f22201e = C5435c.m18680b("GIF87a");
    /* renamed from: f */
    private static final byte[] f22202f = C5435c.m18680b("GIF89a");
    /* renamed from: g */
    private static final int f22203g = 6;
    /* renamed from: h */
    private static final byte[] f22204h = C5435c.m18680b("BM");
    /* renamed from: i */
    private static final int f22205i = C5348i.m18289a(21, 20, f22199c.length, f22200d.length, 6, f22204h.length);

    private C5435c() {
    }

    /* renamed from: a */
    private static C5434b m18676a(byte[] imageHeaderBytes, int headerSize) {
        C5350k.m18310a((Object) imageHeaderBytes);
        if (C5374b.m18409c(imageHeaderBytes, 0, headerSize)) {
            return C5435c.m18679b(imageHeaderBytes, headerSize);
        }
        if (C5435c.m18681c(imageHeaderBytes, headerSize)) {
            return C5434b.JPEG;
        }
        if (C5435c.m18682d(imageHeaderBytes, headerSize)) {
            return C5434b.PNG;
        }
        if (C5435c.m18683e(imageHeaderBytes, headerSize)) {
            return C5434b.GIF;
        }
        if (C5435c.m18684f(imageHeaderBytes, headerSize)) {
            return C5434b.BMP;
        }
        return C5434b.UNKNOWN;
    }

    /* renamed from: a */
    private static int m18673a(InputStream is, byte[] imageHeaderBytes) throws IOException {
        C5350k.m18310a((Object) is);
        C5350k.m18310a((Object) imageHeaderBytes);
        C5350k.m18315a(imageHeaderBytes.length >= f22205i);
        if (!is.markSupported()) {
            return C5341b.m18268a(is, imageHeaderBytes, 0, f22205i);
        }
        try {
            is.mark(f22205i);
            int a = C5341b.m18268a(is, imageHeaderBytes, 0, f22205i);
            return a;
        } finally {
            is.reset();
        }
    }

    /* renamed from: a */
    public static C5434b m18674a(InputStream is) throws IOException {
        C5350k.m18310a((Object) is);
        byte[] imageHeaderBytes = new byte[f22205i];
        return C5435c.m18676a(imageHeaderBytes, C5435c.m18673a(is, imageHeaderBytes));
    }

    /* renamed from: b */
    public static C5434b m18678b(InputStream is) {
        try {
            return C5435c.m18674a(is);
        } catch (IOException ioe) {
            throw C5354o.m18340b(ioe);
        }
    }

    /* renamed from: a */
    public static C5434b m18675a(String filename) {
        C5434b a;
        Throwable th;
        InputStream fileInputStream = null;
        try {
            InputStream fileInputStream2 = new FileInputStream(filename);
            try {
                a = C5435c.m18674a(fileInputStream2);
                C5342c.m18274a(fileInputStream2);
                fileInputStream = fileInputStream2;
            } catch (IOException e) {
                fileInputStream = fileInputStream2;
                try {
                    a = C5434b.UNKNOWN;
                    C5342c.m18274a(fileInputStream);
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    C5342c.m18274a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                C5342c.m18274a(fileInputStream);
                throw th;
            }
        } catch (IOException e2) {
            a = C5434b.UNKNOWN;
            C5342c.m18274a(fileInputStream);
            return a;
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m18677a(byte[] byteArray, int offset, byte[] pattern) {
        C5350k.m18310a((Object) byteArray);
        C5350k.m18310a((Object) pattern);
        C5350k.m18315a(offset >= 0);
        if (pattern.length + offset > byteArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length; i++) {
            if (byteArray[i + offset] != pattern[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static byte[] m18680b(String value) {
        C5350k.m18310a((Object) value);
        try {
            return value.getBytes("ASCII");
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("ASCII not found!", uee);
        }
    }

    /* renamed from: b */
    private static C5434b m18679b(byte[] imageHeaderBytes, int headerSize) {
        C5350k.m18315a(C5374b.m18409c(imageHeaderBytes, 0, headerSize));
        if (C5374b.m18406b(imageHeaderBytes, 0)) {
            return C5434b.WEBP_SIMPLE;
        }
        if (C5374b.m18408c(imageHeaderBytes, 0)) {
            return C5434b.WEBP_LOSSLESS;
        }
        if (!C5374b.m18407b(imageHeaderBytes, 0, headerSize)) {
            return C5434b.UNKNOWN;
        }
        if (C5374b.m18402a(imageHeaderBytes, 0)) {
            return C5434b.WEBP_ANIMATED;
        }
        if (C5374b.m18410d(imageHeaderBytes, 0)) {
            return C5434b.WEBP_EXTENDED_WITH_ALPHA;
        }
        return C5434b.WEBP_EXTENDED;
    }

    /* renamed from: c */
    private static boolean m18681c(byte[] imageHeaderBytes, int headerSize) {
        return headerSize >= f22199c.length && C5435c.m18677a(imageHeaderBytes, 0, f22199c);
    }

    /* renamed from: d */
    private static boolean m18682d(byte[] imageHeaderBytes, int headerSize) {
        return headerSize >= f22200d.length && C5435c.m18677a(imageHeaderBytes, 0, f22200d);
    }

    /* renamed from: e */
    private static boolean m18683e(byte[] imageHeaderBytes, int headerSize) {
        if (headerSize < 6) {
            return false;
        }
        if (C5435c.m18677a(imageHeaderBytes, 0, f22201e) || C5435c.m18677a(imageHeaderBytes, 0, f22202f)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private static boolean m18684f(byte[] imageHeaderBytes, int headerSize) {
        if (headerSize < f22204h.length) {
            return false;
        }
        return C5435c.m18677a(imageHeaderBytes, 0, f22204h);
    }
}
