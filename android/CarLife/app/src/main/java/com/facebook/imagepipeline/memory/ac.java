package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PooledByteStreams */
public class ac {
    /* renamed from: a */
    private static final int f22740a = 16384;
    /* renamed from: b */
    private final int f22741b;
    /* renamed from: c */
    private final C5630f f22742c;

    public ac(C5630f byteArrayPool) {
        this(byteArrayPool, 16384);
    }

    @VisibleForTesting
    ac(C5630f byteArrayPool, int tempBufSize) {
        C5350k.m18315a(tempBufSize > 0);
        this.f22741b = tempBufSize;
        this.f22742c = byteArrayPool;
    }

    /* renamed from: a */
    public long m19482a(InputStream from, OutputStream to) throws IOException {
        long count = 0;
        byte[] tmp = (byte[]) this.f22742c.mo4144a(this.f22741b);
        while (true) {
            int read = from.read(tmp, 0, this.f22741b);
            if (read == -1) {
                break;
            }
            try {
                to.write(tmp, 0, read);
                count += (long) read;
            } finally {
                this.f22742c.mo4017a((Object) tmp);
            }
        }
        return count;
    }

    /* renamed from: a */
    public long m19483a(InputStream from, OutputStream to, long bytesToCopy) throws IOException {
        boolean z = false;
        if (bytesToCopy > 0) {
            z = true;
        }
        C5350k.m18321b(z);
        long copied = 0;
        byte[] tmp = (byte[]) this.f22742c.mo4144a(this.f22741b);
        while (copied < bytesToCopy) {
            int read = from.read(tmp, 0, (int) Math.min((long) this.f22741b, bytesToCopy - copied));
            if (read == -1) {
                break;
            }
            try {
                to.write(tmp, 0, read);
                copied += (long) read;
            } finally {
                this.f22742c.mo4017a((Object) tmp);
            }
        }
        this.f22742c.mo4017a((Object) tmp);
        return copied;
    }
}
