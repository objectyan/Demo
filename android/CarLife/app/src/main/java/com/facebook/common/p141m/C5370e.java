package com.facebook.common.p141m;

import com.facebook.common.internal.C5341b;
import com.facebook.common.internal.C5350k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamUtil */
/* renamed from: com.facebook.common.m.e */
public class C5370e {
    /* renamed from: a */
    public static byte[] m18387a(InputStream is) throws IOException {
        return C5370e.m18388a(is, is.available());
    }

    /* renamed from: a */
    public static byte[] m18388a(InputStream inputStream, int hint) throws IOException {
        OutputStream byteOutput = new ByteArrayOutputStream(hint) {
            public byte[] toByteArray() {
                if (this.count == this.buf.length) {
                    return this.buf;
                }
                return super.toByteArray();
            }
        };
        C5341b.m18269a(inputStream, byteOutput);
        return byteOutput.toByteArray();
    }

    /* renamed from: a */
    public static long m18386a(InputStream inputStream, long bytesCount) throws IOException {
        C5350k.m18310a((Object) inputStream);
        C5350k.m18315a(bytesCount >= 0);
        long toSkip = bytesCount;
        while (toSkip > 0) {
            long skipped = inputStream.skip(toSkip);
            if (skipped > 0) {
                toSkip -= skipped;
            } else if (inputStream.read() == -1) {
                return bytesCount - toSkip;
            } else {
                toSkip--;
            }
        }
        return bytesCount;
    }
}
