package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.C5656a;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk implements Closeable {
    /* renamed from: a */
    private static final String f22721a = "NativeMemoryChunk";
    /* renamed from: b */
    private final long f22722b;
    /* renamed from: c */
    private final int f22723c;
    /* renamed from: d */
    private boolean f22724d;

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    static {
        C5656a.m19641a();
    }

    public NativeMemoryChunk(int size) {
        boolean z;
        if (size > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        this.f22723c = size;
        this.f22722b = nativeAllocate(this.f22723c);
        this.f22724d = false;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f22723c = 0;
        this.f22722b = 0;
        this.f22724d = true;
    }

    public synchronized void close() {
        if (!this.f22724d) {
            this.f22724d = true;
            nativeFree(this.f22722b);
        }
    }

    /* renamed from: a */
    public synchronized boolean m19449a() {
        return this.f22724d;
    }

    /* renamed from: b */
    public int m19450b() {
        return this.f22723c;
    }

    /* renamed from: a */
    public synchronized int m19447a(int nativeMemoryOffset, byte[] byteArray, int byteArrayOffset, int count) {
        int actualCount;
        C5350k.m18310a((Object) byteArray);
        C5350k.m18321b(!m19449a());
        actualCount = m19443a(nativeMemoryOffset, count);
        m19444a(nativeMemoryOffset, byteArray.length, byteArrayOffset, actualCount);
        nativeCopyFromByteArray(this.f22722b + ((long) nativeMemoryOffset), byteArray, byteArrayOffset, actualCount);
        return actualCount;
    }

    /* renamed from: b */
    public synchronized int m19451b(int nativeMemoryOffset, byte[] byteArray, int byteArrayOffset, int count) {
        int actualCount;
        C5350k.m18310a((Object) byteArray);
        C5350k.m18321b(!m19449a());
        actualCount = m19443a(nativeMemoryOffset, count);
        m19444a(nativeMemoryOffset, byteArray.length, byteArrayOffset, actualCount);
        nativeCopyToByteArray(this.f22722b + ((long) nativeMemoryOffset), byteArray, byteArrayOffset, actualCount);
        return actualCount;
    }

    /* renamed from: a */
    public synchronized byte m19446a(int offset) {
        byte nativeReadByte;
        boolean z = true;
        synchronized (this) {
            boolean z2;
            if (m19449a()) {
                z2 = false;
            } else {
                z2 = true;
            }
            C5350k.m18321b(z2);
            if (offset >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            C5350k.m18315a(z2);
            if (offset >= this.f22723c) {
                z = false;
            }
            C5350k.m18315a(z);
            nativeReadByte = nativeReadByte(this.f22722b + ((long) offset));
        }
        return nativeReadByte;
    }

    /* renamed from: a */
    public void m19448a(int offset, NativeMemoryChunk other, int otherOffset, int count) {
        C5350k.m18310a((Object) other);
        if (other.f22722b == this.f22722b) {
            Log.w(f22721a, "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(other)) + " which share the same address " + Long.toHexString(this.f22722b));
            C5350k.m18315a(false);
        }
        if (other.f22722b < this.f22722b) {
            synchronized (other) {
                synchronized (this) {
                    m19445b(offset, other, otherOffset, count);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (other) {
                m19445b(offset, other, otherOffset, count);
            }
        }
    }

    /* renamed from: c */
    public long m19452c() {
        return this.f22722b;
    }

    /* renamed from: b */
    private void m19445b(int offset, NativeMemoryChunk other, int otherOffset, int count) {
        boolean z;
        boolean z2 = true;
        if (m19449a()) {
            z = false;
        } else {
            z = true;
        }
        C5350k.m18321b(z);
        if (other.m19449a()) {
            z2 = false;
        }
        C5350k.m18321b(z2);
        m19444a(offset, other.f22723c, otherOffset, count);
        nativeMemcpy(other.f22722b + ((long) otherOffset), this.f22722b + ((long) offset), count);
    }

    protected void finalize() throws Throwable {
        if (!m19449a()) {
            Log.w(f22721a, "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.f22722b));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: a */
    private int m19443a(int offset, int count) {
        return Math.min(Math.max(0, this.f22723c - offset), count);
    }

    /* renamed from: a */
    private void m19444a(int myOffset, int otherLength, int otherOffset, int count) {
        boolean z;
        boolean z2 = true;
        C5350k.m18315a(count >= 0);
        if (myOffset >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (otherOffset >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (myOffset + count <= this.f22723c) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (otherOffset + count > otherLength) {
            z2 = false;
        }
        C5350k.m18315a(z2);
    }
}
