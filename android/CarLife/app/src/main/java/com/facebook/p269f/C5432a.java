package com.facebook.p269f;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifFormatChecker */
/* renamed from: com.facebook.f.a */
public final class C5432a {
    /* renamed from: a */
    private static final int f22181a = 10;
    /* renamed from: b */
    private static final byte[] f22182b = new byte[]{(byte) 0, (byte) 33, (byte) -7, (byte) 4};
    /* renamed from: c */
    private static final byte[] f22183c = new byte[]{(byte) 0, (byte) 44};
    /* renamed from: d */
    private static final byte[] f22184d = new byte[]{(byte) 0, (byte) 33};

    private C5432a() {
    }

    /* renamed from: a */
    public static boolean m18669a(InputStream source) {
        byte[] buffer = new byte[10];
        try {
            source.read(buffer, 0, 10);
            int offset = 0;
            int frameHeaders = 0;
            while (source.read(buffer, offset, 1) > 0) {
                if (C5432a.m18670a(buffer, offset + 1, f22182b) && (C5432a.m18670a(buffer, offset + 9, f22183c) || C5432a.m18670a(buffer, offset + 9, f22184d))) {
                    frameHeaders++;
                    if (frameHeaders > 1) {
                        return true;
                    }
                }
                offset = (offset + 1) % buffer.length;
            }
            return false;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static boolean m18670a(byte[] byteArray, int offset, byte[] pattern) {
        C5350k.m18310a((Object) byteArray);
        C5350k.m18310a((Object) pattern);
        C5350k.m18315a(offset >= 0);
        if (pattern.length > byteArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length; i++) {
            if (byteArray[(i + offset) % byteArray.length] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}
