package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: ByteStreams */
/* renamed from: com.facebook.common.internal.b */
public final class C5341b {
    /* renamed from: a */
    private static final int f21916a = 4096;

    /* compiled from: ByteStreams */
    /* renamed from: com.facebook.common.internal.b$a */
    private static final class C5340a extends ByteArrayOutputStream {
        private C5340a() {
        }

        /* renamed from: a */
        void m18267a(byte[] b, int off) {
            System.arraycopy(this.buf, 0, b, off, this.count);
        }
    }

    private C5341b() {
    }

    /* renamed from: a */
    public static long m18269a(InputStream from, OutputStream to) throws IOException {
        C5350k.m18310a((Object) from);
        C5350k.m18310a((Object) to);
        byte[] buf = new byte[4096];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            to.write(buf, 0, r);
            total += (long) r;
        }
    }

    /* renamed from: a */
    public static int m18268a(InputStream in, byte[] b, int off, int len) throws IOException {
        C5350k.m18310a((Object) in);
        C5350k.m18310a((Object) b);
        if (len < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int total = 0;
        while (total < len) {
            int result = in.read(b, off + total, len - total);
            if (result == -1) {
                break;
            }
            total += result;
        }
        return total;
    }

    /* renamed from: a */
    public static byte[] m18270a(InputStream in) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        C5341b.m18269a(in, out);
        return out.toByteArray();
    }

    /* renamed from: a */
    public static byte[] m18271a(InputStream in, int expectedSize) throws IOException {
        byte[] bytes = new byte[expectedSize];
        int remaining = expectedSize;
        while (remaining > 0) {
            int off = expectedSize - remaining;
            int read = in.read(bytes, off, remaining);
            if (read == -1) {
                return Arrays.copyOf(bytes, off);
            }
            remaining -= read;
        }
        int b = in.read();
        if (b == -1) {
            return bytes;
        }
        OutputStream out = new C5340a();
        out.write(b);
        C5341b.m18269a(in, out);
        byte[] result = new byte[(bytes.length + out.size())];
        System.arraycopy(bytes, 0, result, 0, bytes.length);
        out.m18267a(result, bytes.length);
        return result;
    }

    /* renamed from: b */
    public static void m18272b(InputStream in, byte[] b, int off, int len) throws IOException {
        int read = C5341b.m18268a(in, b, off, len);
        if (read != len) {
            throw new EOFException("reached end of stream after reading " + read + " bytes; " + len + " bytes expected");
        }
    }
}
