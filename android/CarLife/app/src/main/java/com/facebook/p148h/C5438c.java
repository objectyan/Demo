package com.facebook.p148h;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamProcessor */
/* renamed from: com.facebook.h.c */
class C5438c {
    C5438c() {
    }

    /* renamed from: a */
    public static int m18691a(InputStream is, int numBytes, boolean isLittleEndian) throws IOException {
        int value = 0;
        for (int i = 0; i < numBytes; i++) {
            int b = is.read();
            if (b == -1) {
                throw new IOException("no more bytes");
            }
            if (isLittleEndian) {
                value |= (b & 255) << (i * 8);
            } else {
                value = (value << 8) | (b & 255);
            }
        }
        return value;
    }
}
