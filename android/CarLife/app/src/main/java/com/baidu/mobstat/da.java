package com.baidu.mobstat;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class da {
    /* renamed from: a */
    public static boolean m15654a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return true;
                }
                outputStream.write(bArr, 0, read);
            } catch (Throwable e) {
                db.m15662b(e);
                return false;
            }
        }
    }

    /* renamed from: a */
    public static void m15653a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                db.m15662b(th);
            }
        }
    }
}
