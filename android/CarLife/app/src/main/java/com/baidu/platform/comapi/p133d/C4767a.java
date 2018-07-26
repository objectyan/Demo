package com.baidu.platform.comapi.p133d;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IOUtils */
/* renamed from: com.baidu.platform.comapi.d.a */
public class C4767a {
    /* renamed from: a */
    public static void m15839a(InputStream inputStream, OutputStream outputStream, byte[] buffer) throws IOException {
        if (inputStream == null || outputStream == null || buffer == null) {
            throw new IOException("copyStream : outputStream or inputStream is null");
        }
        try {
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            if (!(outputStream instanceof BufferedOutputStream)) {
                outputStream = new BufferedOutputStream(outputStream);
            }
            while (true) {
                int count = inputStream.read(buffer);
                if (count == -1) {
                    break;
                }
                outputStream.write(buffer, 0, count);
            }
            outputStream.flush();
        } finally {
            C4767a.m15838a(inputStream);
            C4767a.m15838a(outputStream);
        }
    }

    /* renamed from: a */
    public static void m15838a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }
}
