package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: PooledByteBufferInputStream */
public class aa extends InputStream {
    @VisibleForTesting
    /* renamed from: a */
    final C5640y f22737a;
    @VisibleForTesting
    /* renamed from: b */
    int f22738b;
    @VisibleForTesting
    /* renamed from: c */
    int f22739c;

    public aa(C5640y pooledByteBuffer) {
        boolean z;
        if (pooledByteBuffer.mo4158c()) {
            z = false;
        } else {
            z = true;
        }
        C5350k.m18315a(z);
        this.f22737a = (C5640y) C5350k.m18310a((Object) pooledByteBuffer);
        this.f22738b = 0;
        this.f22739c = 0;
    }

    public int available() {
        return this.f22737a.mo4155a() - this.f22738b;
    }

    public void mark(int readlimit) {
        this.f22739c = this.f22738b;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        C5640y c5640y = this.f22737a;
        int i = this.f22738b;
        this.f22738b = i + 1;
        return c5640y.mo4154a(i) & 255;
    }

    public int read(byte[] buffer) {
        return read(buffer, 0, buffer.length);
    }

    public int read(byte[] buffer, int offset, int length) {
        if (offset < 0 || length < 0 || offset + length > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + buffer.length + "; regionStart=" + offset + "; regionLength=" + length);
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (length <= 0) {
            return 0;
        }
        int numToRead = Math.min(available, length);
        this.f22737a.mo4156a(this.f22738b, buffer, offset, numToRead);
        this.f22738b += numToRead;
        return numToRead;
    }

    public void reset() {
        this.f22738b = this.f22739c;
    }

    public long skip(long byteCount) {
        C5350k.m18315a(byteCount >= 0);
        int skipped = Math.min((int) byteCount, available());
        this.f22738b += skipped;
        return (long) skipped;
    }
}
