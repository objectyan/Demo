package com.facebook.p148h;

import com.baidu.platform.comapi.util.C4820d;
import com.facebook.common.p257e.C5320a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TiffUtil */
/* renamed from: com.facebook.h.d */
class C5441d {
    /* renamed from: a */
    public static final int f22227a = 1296891946;
    /* renamed from: b */
    public static final int f22228b = 1229531648;
    /* renamed from: c */
    public static final int f22229c = 274;
    /* renamed from: d */
    public static final int f22230d = 3;
    /* renamed from: e */
    private static final Class<?> f22231e = C5441d.class;

    /* compiled from: TiffUtil */
    /* renamed from: com.facebook.h.d$a */
    private static class C5440a {
        /* renamed from: a */
        boolean f22224a;
        /* renamed from: b */
        int f22225b;
        /* renamed from: c */
        int f22226c;

        private C5440a() {
        }
    }

    C5441d() {
    }

    /* renamed from: a */
    public static int m18692a(int orientation) {
        switch (orientation) {
            case 1:
                return 0;
            case 3:
                return C4820d.f19955a;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                C5320a.m18156c(f22231e, "Unsupported orientation");
                return 0;
        }
    }

    /* renamed from: a */
    public static int m18693a(InputStream is, int length) throws IOException {
        C5440a tiffHeader = new C5440a();
        length = C5441d.m18694a(is, length, tiffHeader);
        int toSkip = tiffHeader.f22226c - 8;
        if (length == 0 || toSkip > length) {
            return 0;
        }
        is.skip((long) toSkip);
        return C5441d.m18695a(is, C5441d.m18696a(is, length - toSkip, tiffHeader.f22224a, 274), tiffHeader.f22224a);
    }

    /* renamed from: a */
    private static int m18694a(InputStream is, int length, C5440a tiffHeader) throws IOException {
        if (length <= 8) {
            return 0;
        }
        tiffHeader.f22225b = C5438c.m18691a(is, 4, false);
        length -= 4;
        if (tiffHeader.f22225b == f22228b || tiffHeader.f22225b == f22227a) {
            tiffHeader.f22224a = tiffHeader.f22225b == f22228b;
            tiffHeader.f22226c = C5438c.m18691a(is, 4, tiffHeader.f22224a);
            length -= 4;
            if (tiffHeader.f22226c >= 8 && tiffHeader.f22226c - 8 <= length) {
                return length;
            }
            C5320a.m18180e(f22231e, "Invalid offset");
            return 0;
        }
        C5320a.m18180e(f22231e, "Invalid TIFF header");
        return 0;
    }

    /* renamed from: a */
    private static int m18696a(InputStream is, int length, boolean isLittleEndian, int tagToFind) throws IOException {
        if (length < 14) {
            return 0;
        }
        length -= 2;
        int numEntries = C5438c.m18691a(is, 2, isLittleEndian);
        while (true) {
            int numEntries2 = numEntries - 1;
            if (numEntries <= 0 || length < 12) {
                return 0;
            }
            length -= 2;
            if (C5438c.m18691a(is, 2, isLittleEndian) == tagToFind) {
                return length;
            }
            is.skip(10);
            length -= 10;
            numEntries = numEntries2;
        }
    }

    /* renamed from: a */
    private static int m18695a(InputStream is, int length, boolean isLittleEndian) throws IOException {
        if (length < 10 || C5438c.m18691a(is, 2, isLittleEndian) != 3 || C5438c.m18691a(is, 4, isLittleEndian) != 1) {
            return 0;
        }
        int value = C5438c.m18691a(is, 2, isLittleEndian);
        int padding = C5438c.m18691a(is, 2, isLittleEndian);
        return value;
    }
}
