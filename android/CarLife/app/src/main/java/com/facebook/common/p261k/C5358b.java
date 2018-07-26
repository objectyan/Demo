package com.facebook.common.p261k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TailAppendingInputStream */
/* renamed from: com.facebook.common.k.b */
public class C5358b extends FilterInputStream {
    /* renamed from: a */
    private final byte[] f21941a;
    /* renamed from: b */
    private int f21942b;
    /* renamed from: c */
    private int f21943c;

    public C5358b(InputStream inputStream, byte[] tail) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        } else if (tail == null) {
            throw new NullPointerException();
        } else {
            this.f21941a = tail;
        }
    }

    public int read() throws IOException {
        int readResult = this.in.read();
        return readResult != -1 ? readResult : m18354a();
    }

    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    public int read(byte[] buffer, int offset, int count) throws IOException {
        int readResult = this.in.read(buffer, offset, count);
        if (readResult != -1) {
            return readResult;
        }
        if (count == 0) {
            return 0;
        }
        int bytesRead = 0;
        while (bytesRead < count) {
            int nextByte = m18354a();
            if (nextByte == -1) {
                break;
            }
            buffer[offset + bytesRead] = (byte) nextByte;
            bytesRead++;
        }
        if (bytesRead <= 0) {
            bytesRead = -1;
        }
        return bytesRead;
    }

    public void reset() throws IOException {
        if (this.in.markSupported()) {
            this.in.reset();
            this.f21942b = this.f21943c;
            return;
        }
        throw new IOException("mark is not supported");
    }

    public void mark(int readLimit) {
        if (this.in.markSupported()) {
            super.mark(readLimit);
            this.f21943c = this.f21942b;
        }
    }

    /* renamed from: a */
    private int m18354a() {
        if (this.f21942b >= this.f21941a.length) {
            return -1;
        }
        byte[] bArr = this.f21941a;
        int i = this.f21942b;
        this.f21942b = i + 1;
        return bArr[i] & 255;
    }
}
