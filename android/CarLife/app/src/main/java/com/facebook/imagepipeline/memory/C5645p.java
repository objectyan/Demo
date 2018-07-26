package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: NativePooledByteBufferOutputStream */
/* renamed from: com.facebook.imagepipeline.memory.p */
public class C5645p extends ab {
    /* renamed from: a */
    private final C5639m f22780a;
    /* renamed from: b */
    private C2921a<NativeMemoryChunk> f22781b;
    /* renamed from: c */
    private int f22782c;

    /* compiled from: NativePooledByteBufferOutputStream */
    /* renamed from: com.facebook.imagepipeline.memory.p$a */
    public static class C5644a extends RuntimeException {
        public C5644a() {
            super("OutputStream no longer valid");
        }
    }

    /* renamed from: c */
    public /* synthetic */ C5640y mo4167c() {
        return m19577a();
    }

    public C5645p(C5639m pool) {
        this(pool, pool.mo4152g());
    }

    public C5645p(C5639m pool, int initialCapacity) {
        boolean z;
        if (initialCapacity > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        this.f22780a = (C5639m) C5350k.m18310a((Object) pool);
        this.f22782c = 0;
        this.f22781b = C2921a.a(this.f22780a.mo4144a(initialCapacity), this.f22780a);
    }

    /* renamed from: a */
    public C5641n m19577a() {
        m19576d();
        return new C5641n(this.f22781b, this.f22782c);
    }

    /* renamed from: b */
    public int mo4166b() {
        return this.f22782c;
    }

    public void write(int oneByte) throws IOException {
        write(new byte[]{(byte) oneByte});
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        if (offset < 0 || count < 0 || offset + count > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + buffer.length + "; regionStart=" + offset + "; regionLength=" + count);
        }
        m19576d();
        m19578a(this.f22782c + count);
        ((NativeMemoryChunk) this.f22781b.a()).m19447a(this.f22782c, buffer, offset, count);
        this.f22782c += count;
    }

    public void close() {
        C2921a.c(this.f22781b);
        this.f22781b = null;
        this.f22782c = -1;
        super.close();
    }

    @VisibleForTesting
    /* renamed from: a */
    void m19578a(int newLength) {
        m19576d();
        if (newLength > ((NativeMemoryChunk) this.f22781b.a()).m19450b()) {
            NativeMemoryChunk newbuf = (NativeMemoryChunk) this.f22780a.mo4144a(newLength);
            ((NativeMemoryChunk) this.f22781b.a()).m19448a(0, newbuf, 0, this.f22782c);
            this.f22781b.close();
            this.f22781b = C2921a.a(newbuf, this.f22780a);
        }
    }

    /* renamed from: d */
    private void m19576d() {
        if (!C2921a.a(this.f22781b)) {
            throw new C5644a();
        }
    }
}
