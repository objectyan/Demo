package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Files */
/* renamed from: com.facebook.common.internal.e */
public class C5344e {
    private C5344e() {
    }

    /* renamed from: a */
    static byte[] m18278a(InputStream in, long expectedSize) throws IOException {
        if (expectedSize > 2147483647L) {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + expectedSize + " bytes");
        } else if (expectedSize == 0) {
            return C5341b.m18270a(in);
        } else {
            return C5341b.m18271a(in, (int) expectedSize);
        }
    }

    /* renamed from: a */
    public static byte[] m18277a(File file) throws IOException {
        Throwable th;
        FileInputStream in = null;
        try {
            FileInputStream in2 = new FileInputStream(file);
            try {
                byte[] a = C5344e.m18278a(in2, in2.getChannel().size());
                if (in2 != null) {
                    in2.close();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                in = in2;
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (in != null) {
                in.close();
            }
            throw th;
        }
    }
}
