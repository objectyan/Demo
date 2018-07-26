package com.facebook.common.p263n;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* compiled from: WebpSupportStatus */
/* renamed from: com.facebook.common.n.b */
public class C5374b {
    /* renamed from: a */
    public static final boolean f21961a;
    /* renamed from: b */
    public static final boolean f21962b;
    /* renamed from: c */
    public static final boolean f21963c = C5374b.m18401a();
    /* renamed from: d */
    public static C5373a f21964d = null;
    /* renamed from: e */
    public static boolean f21965e = false;
    /* renamed from: f */
    private static final String f21966f = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    /* renamed from: g */
    private static final int f21967g = 20;
    /* renamed from: h */
    private static final int f21968h = 21;
    /* renamed from: i */
    private static final byte[] f21969i = C5374b.m18405a("RIFF");
    /* renamed from: j */
    private static final byte[] f21970j = C5374b.m18405a("WEBP");
    /* renamed from: k */
    private static final byte[] f21971k = C5374b.m18405a("VP8 ");
    /* renamed from: l */
    private static final byte[] f21972l = C5374b.m18405a("VP8L");
    /* renamed from: m */
    private static final byte[] f21973m = C5374b.m18405a("VP8X");

    static {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT <= 17) {
            z = true;
        } else {
            z = false;
        }
        f21961a = z;
        if (VERSION.SDK_INT < 14) {
            z2 = false;
        }
        f21962b = z2;
        f21964d = null;
        f21965e = false;
        try {
            f21964d = (C5373a) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
            f21965e = true;
        } catch (Throwable th) {
            f21965e = false;
        }
    }

    /* renamed from: a */
    private static byte[] m18405a(String value) {
        try {
            return value.getBytes("ASCII");
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("ASCII not found!", uee);
        }
    }

    /* renamed from: a */
    private static boolean m18401a() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (VERSION.SDK_INT == 17) {
            byte[] decodedBytes = Base64.decode(f21966f, 0);
            Options opts = new Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length, opts);
            if (!(opts.outHeight == 1 && opts.outWidth == 1)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m18403a(byte[] imageHeaderBytes, int offset, int headerSize) {
        if (C5374b.m18406b(imageHeaderBytes, offset)) {
            return f21962b;
        }
        if (C5374b.m18408c(imageHeaderBytes, offset)) {
            return f21963c;
        }
        if (!C5374b.m18407b(imageHeaderBytes, offset, headerSize) || C5374b.m18402a(imageHeaderBytes, offset)) {
            return false;
        }
        return f21963c;
    }

    /* renamed from: a */
    public static boolean m18402a(byte[] imageHeaderBytes, int offset) {
        boolean isVp8x = C5374b.m18404a(imageHeaderBytes, offset + 12, f21973m);
        boolean hasAnimationBit;
        if ((imageHeaderBytes[offset + 20] & 2) == 2) {
            hasAnimationBit = true;
        } else {
            hasAnimationBit = false;
        }
        if (isVp8x && hasAnimationBit) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m18406b(byte[] imageHeaderBytes, int offset) {
        return C5374b.m18404a(imageHeaderBytes, offset + 12, f21971k);
    }

    /* renamed from: c */
    public static boolean m18408c(byte[] imageHeaderBytes, int offset) {
        return C5374b.m18404a(imageHeaderBytes, offset + 12, f21972l);
    }

    /* renamed from: b */
    public static boolean m18407b(byte[] imageHeaderBytes, int offset, int headerSize) {
        return headerSize >= 21 && C5374b.m18404a(imageHeaderBytes, offset + 12, f21973m);
    }

    /* renamed from: d */
    public static boolean m18410d(byte[] imageHeaderBytes, int offset) {
        boolean isVp8x = C5374b.m18404a(imageHeaderBytes, offset + 12, f21973m);
        boolean hasAlphaBit;
        if ((imageHeaderBytes[offset + 20] & 16) == 16) {
            hasAlphaBit = true;
        } else {
            hasAlphaBit = false;
        }
        if (isVp8x && hasAlphaBit) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m18409c(byte[] imageHeaderBytes, int offset, int headerSize) {
        return headerSize >= 20 && C5374b.m18404a(imageHeaderBytes, offset, f21969i) && C5374b.m18404a(imageHeaderBytes, offset + 8, f21970j);
    }

    /* renamed from: a */
    private static boolean m18404a(byte[] byteArray, int offset, byte[] pattern) {
        if (pattern == null || byteArray == null || pattern.length + offset > byteArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length; i++) {
            if (byteArray[i + offset] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}
