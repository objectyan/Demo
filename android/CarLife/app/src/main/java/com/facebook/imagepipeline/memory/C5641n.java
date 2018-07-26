package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5640y.C5655a;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: NativePooledByteBuffer */
/* renamed from: com.facebook.imagepipeline.memory.n */
public class C5641n implements C5640y {
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: a */
    C2921a<NativeMemoryChunk> f22776a;
    /* renamed from: b */
    private final int f22777b;

    public C5641n(C2921a<NativeMemoryChunk> bufRef, int size) {
        C5350k.m18310a((Object) bufRef);
        boolean z = size >= 0 && size <= ((NativeMemoryChunk) bufRef.a()).m19450b();
        C5350k.m18315a(z);
        this.f22776a = bufRef.b();
        this.f22777b = size;
    }

    /* renamed from: a */
    public synchronized int mo4155a() {
        m19556d();
        return this.f22777b;
    }

    /* renamed from: a */
    public synchronized byte mo4154a(int offset) {
        byte a;
        boolean z = true;
        synchronized (this) {
            boolean z2;
            m19556d();
            if (offset >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            C5350k.m18315a(z2);
            if (offset >= this.f22777b) {
                z = false;
            }
            C5350k.m18315a(z);
            a = ((NativeMemoryChunk) this.f22776a.a()).m19446a(offset);
        }
        return a;
    }

    /* renamed from: a */
    public synchronized void mo4156a(int offset, byte[] buffer, int bufferOffset, int length) {
        m19556d();
        C5350k.m18315a(offset + length <= this.f22777b);
        ((NativeMemoryChunk) this.f22776a.a()).m19451b(offset, buffer, bufferOffset, length);
    }

    /* renamed from: b */
    public synchronized long mo4157b() {
        m19556d();
        return ((NativeMemoryChunk) this.f22776a.a()).m19452c();
    }

    /* renamed from: c */
    public synchronized boolean mo4158c() {
        return !C2921a.a(this.f22776a);
    }

    public synchronized void close() {
        C2921a.c(this.f22776a);
        this.f22776a = null;
    }

    /* renamed from: d */
    synchronized void m19556d() {
        if (mo4158c()) {
            throw new C5655a();
        }
    }
}
