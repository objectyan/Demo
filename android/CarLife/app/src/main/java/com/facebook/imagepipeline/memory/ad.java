package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p140h.C2922b;
import com.facebook.common.p140h.C5329c;
import com.facebook.common.p258g.C5323a;
import com.facebook.common.p258g.C5324b;
import com.facebook.common.p258g.C5325c;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: SharedByteArray */
public class ad implements C5324b {
    @VisibleForTesting
    /* renamed from: a */
    final int f22744a;
    @VisibleForTesting
    /* renamed from: b */
    final int f22745b;
    @VisibleForTesting
    /* renamed from: c */
    final C2922b<byte[]> f22746c;
    @VisibleForTesting
    /* renamed from: d */
    final Semaphore f22747d;
    /* renamed from: e */
    private final C5329c<byte[]> f22748e;

    /* compiled from: SharedByteArray */
    /* renamed from: com.facebook.imagepipeline.memory.ad$1 */
    class C56251 implements C5329c<byte[]> {
        /* renamed from: a */
        final /* synthetic */ ad f22743a;

        C56251(ad this$0) {
            this.f22743a = this$0;
        }

        /* renamed from: a */
        public void m19485a(byte[] unused) {
            this.f22743a.f22747d.release();
        }
    }

    public ad(C5325c memoryTrimmableRegistry, C5653v params) {
        boolean z = false;
        C5350k.m18310a((Object) memoryTrimmableRegistry);
        C5350k.m18315a(params.f22820e > 0);
        if (params.f22821f >= params.f22820e) {
            z = true;
        }
        C5350k.m18315a(z);
        this.f22745b = params.f22821f;
        this.f22744a = params.f22820e;
        this.f22746c = new C2922b();
        this.f22747d = new Semaphore(1);
        this.f22748e = new C56251(this);
        memoryTrimmableRegistry.mo4015a(this);
    }

    /* renamed from: a */
    public C2921a<byte[]> m19488a(int size) {
        boolean z;
        boolean z2 = true;
        if (size > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18316a(z, (Object) "Size must be greater than zero");
        if (size > this.f22745b) {
            z2 = false;
        }
        C5350k.m18316a(z2, (Object) "Requested size is too big");
        this.f22747d.acquireUninterruptibly();
        try {
            return C2921a.a(m19486c(size), this.f22748e);
        } catch (Throwable t) {
            this.f22747d.release();
            RuntimeException b = C5354o.m18340b(t);
        }
    }

    /* renamed from: c */
    private byte[] m19486c(int requestedSize) {
        int bucketedSize = m19490b(requestedSize);
        byte[] byteArray = (byte[]) this.f22746c.a();
        if (byteArray == null || byteArray.length < bucketedSize) {
            return m19487d(bucketedSize);
        }
        return byteArray;
    }

    /* renamed from: a */
    public void mo4145a(C5323a trimType) {
        if (this.f22747d.tryAcquire()) {
            try {
                this.f22746c.b();
            } finally {
                this.f22747d.release();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    int m19490b(int size) {
        return Integer.highestOneBit(Math.max(size, this.f22744a) - 1) * 2;
    }

    /* renamed from: d */
    private synchronized byte[] m19487d(int size) {
        byte[] byteArray;
        this.f22746c.b();
        byteArray = new byte[size];
        this.f22746c.a(byteArray);
        return byteArray;
    }
}
