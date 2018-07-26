package com.facebook.common.p261k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: LimitedInputStream */
/* renamed from: com.facebook.common.k.a */
public class C5357a extends FilterInputStream {
    /* renamed from: a */
    private int f21939a;
    /* renamed from: b */
    private int f21940b;

    public C5357a(InputStream inputStream, int limit) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        } else {
            this.f21939a = limit;
            this.f21940b = -1;
        }
    }

    public int read() throws IOException {
        if (this.f21939a == 0) {
            return -1;
        }
        int readByte = this.in.read();
        if (readByte == -1) {
            return readByte;
        }
        this.f21939a--;
        return readByte;
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        if (this.f21939a == 0) {
            return -1;
        }
        int bytesRead = this.in.read(buffer, byteOffset, Math.min(byteCount, this.f21939a));
        if (bytesRead <= 0) {
            return bytesRead;
        }
        this.f21939a -= bytesRead;
        return bytesRead;
    }

    public long skip(long byteCount) throws IOException {
        long bytesSkipped = this.in.skip(Math.min(byteCount, (long) this.f21939a));
        this.f21939a = (int) (((long) this.f21939a) - bytesSkipped);
        return bytesSkipped;
    }

    public int available() throws IOException {
        return Math.min(this.in.available(), this.f21939a);
    }

    public void mark(int readLimit) {
        if (this.in.markSupported()) {
            this.in.mark(readLimit);
            this.f21940b = this.f21939a;
        }
    }

    public void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        } else if (this.f21940b == -1) {
            throw new IOException("mark not set");
        } else {
            this.in.reset();
            this.f21939a = this.f21940b;
        }
    }
}
