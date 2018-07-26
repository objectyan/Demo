package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C5329c;
import com.facebook.common.p257e.C5320a;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: PooledByteArrayBufferedInputStream */
/* renamed from: com.facebook.imagepipeline.memory.x */
public class C5654x extends InputStream {
    /* renamed from: a */
    private static final String f22823a = "PooledByteInputStream";
    /* renamed from: b */
    private final InputStream f22824b;
    /* renamed from: c */
    private final byte[] f22825c;
    /* renamed from: d */
    private final C5329c<byte[]> f22826d;
    /* renamed from: e */
    private int f22827e = 0;
    /* renamed from: f */
    private int f22828f = 0;
    /* renamed from: g */
    private boolean f22829g = false;

    public C5654x(InputStream inputStream, byte[] byteArray, C5329c<byte[]> resourceReleaser) {
        this.f22824b = (InputStream) C5350k.m18310a((Object) inputStream);
        this.f22825c = (byte[]) C5350k.m18310a((Object) byteArray);
        this.f22826d = (C5329c) C5350k.m18310a((Object) resourceReleaser);
    }

    public int read() throws IOException {
        C5350k.m18321b(this.f22828f <= this.f22827e);
        m19633b();
        if (!m19632a()) {
            return -1;
        }
        byte[] bArr = this.f22825c;
        int i = this.f22828f;
        this.f22828f = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] buffer, int offset, int length) throws IOException {
        C5350k.m18321b(this.f22828f <= this.f22827e);
        m19633b();
        if (!m19632a()) {
            return -1;
        }
        int bytesToRead = Math.min(this.f22827e - this.f22828f, length);
        System.arraycopy(this.f22825c, this.f22828f, buffer, offset, bytesToRead);
        this.f22828f += bytesToRead;
        return bytesToRead;
    }

    public int available() throws IOException {
        C5350k.m18321b(this.f22828f <= this.f22827e);
        m19633b();
        return (this.f22827e - this.f22828f) + this.f22824b.available();
    }

    public void close() throws IOException {
        if (!this.f22829g) {
            this.f22829g = true;
            this.f22826d.mo4017a(this.f22825c);
            super.close();
        }
    }

    public long skip(long byteCount) throws IOException {
        C5350k.m18321b(this.f22828f <= this.f22827e);
        m19633b();
        int bytesLeftInBuffer = this.f22827e - this.f22828f;
        if (((long) bytesLeftInBuffer) >= byteCount) {
            this.f22828f = (int) (((long) this.f22828f) + byteCount);
            return byteCount;
        }
        this.f22828f = this.f22827e;
        return ((long) bytesLeftInBuffer) + this.f22824b.skip(byteCount - ((long) bytesLeftInBuffer));
    }

    /* renamed from: a */
    private boolean m19632a() throws IOException {
        if (this.f22828f < this.f22827e) {
            return true;
        }
        int readData = this.f22824b.read(this.f22825c);
        if (readData <= 0) {
            return false;
        }
        this.f22827e = readData;
        this.f22828f = 0;
        return true;
    }

    /* renamed from: b */
    private void m19633b() throws IOException {
        if (this.f22829g) {
            throw new IOException("stream already closed");
        }
    }

    protected void finalize() throws Throwable {
        if (!this.f22829g) {
            C5320a.m18184e(f22823a, "Finalized without closing");
            close();
        }
        super.finalize();
    }
}
