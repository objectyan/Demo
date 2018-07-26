package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5351l;
import com.facebook.common.internal.C5354o;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p257e.C5320a;
import com.facebook.common.p258g.C5323a;
import com.facebook.common.p258g.C5325c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: BasePool */
/* renamed from: com.facebook.imagepipeline.memory.a */
public abstract class C5624a<V> implements C5623s<V> {
    /* renamed from: a */
    final C5325c f22728a;
    /* renamed from: b */
    final C5653v f22729b;
    @VisibleForTesting
    /* renamed from: c */
    final SparseArray<C2961e<V>> f22730c;
    @VisibleForTesting
    /* renamed from: d */
    final Set<V> f22731d;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: e */
    final C5618a f22732e;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: f */
    final C5618a f22733f;
    /* renamed from: g */
    private final Class<?> f22734g = getClass();
    /* renamed from: h */
    private boolean f22735h;
    /* renamed from: i */
    private final C5646w f22736i;

    @VisibleForTesting
    @NotThreadSafe
    /* compiled from: BasePool */
    /* renamed from: com.facebook.imagepipeline.memory.a$a */
    static class C5618a {
        /* renamed from: c */
        private static final String f22725c = "com.facebook.imagepipeline.memory.BasePool.Counter";
        /* renamed from: a */
        int f22726a;
        /* renamed from: b */
        int f22727b;

        C5618a() {
        }

        /* renamed from: a */
        public void m19454a(int numBytes) {
            this.f22726a++;
            this.f22727b += numBytes;
        }

        /* renamed from: b */
        public void m19455b(int numBytes) {
            if (this.f22727b < numBytes || this.f22726a <= 0) {
                C5320a.m18194f(f22725c, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(numBytes), Integer.valueOf(this.f22727b), Integer.valueOf(this.f22726a));
                return;
            }
            this.f22726a--;
            this.f22727b -= numBytes;
        }

        /* renamed from: a */
        public void m19453a() {
            this.f22726a = 0;
            this.f22727b = 0;
        }
    }

    /* compiled from: BasePool */
    /* renamed from: com.facebook.imagepipeline.memory.a$b */
    public static class C5619b extends RuntimeException {
        public C5619b(Object size) {
            super("Invalid size: " + size.toString());
        }
    }

    /* compiled from: BasePool */
    /* renamed from: com.facebook.imagepipeline.memory.a$c */
    public static class C5620c extends RuntimeException {
        public C5620c(Object value) {
            super("Invalid value: " + value.toString());
        }
    }

    /* compiled from: BasePool */
    /* renamed from: com.facebook.imagepipeline.memory.a$d */
    public static class C5621d extends RuntimeException {
        public C5621d(int hardCap, int usedBytes, int freeBytes, int allocSize) {
            super("Pool hard cap violation? Hard cap = " + hardCap + " Used size = " + usedBytes + " Free size = " + freeBytes + " Request size = " + allocSize);
        }
    }

    /* compiled from: BasePool */
    /* renamed from: com.facebook.imagepipeline.memory.a$e */
    public static class C5622e extends C5619b {
        public C5622e(Object size) {
            super(size);
        }
    }

    /* renamed from: b */
    protected abstract V mo4146b(int i);

    @VisibleForTesting
    /* renamed from: b */
    protected abstract void mo4147b(V v);

    /* renamed from: c */
    protected abstract int mo4148c(int i);

    /* renamed from: c */
    protected abstract int mo4149c(V v);

    /* renamed from: d */
    protected abstract int mo4150d(int i);

    public C5624a(C5325c memoryTrimmableRegistry, C5653v poolParams, C5646w poolStatsTracker) {
        this.f22728a = (C5325c) C5350k.m18310a((Object) memoryTrimmableRegistry);
        this.f22729b = (C5653v) C5350k.m18310a((Object) poolParams);
        this.f22736i = (C5646w) C5350k.m18310a((Object) poolStatsTracker);
        this.f22730c = new SparseArray();
        m19458a(new SparseIntArray(0));
        this.f22731d = C5351l.m18332b();
        this.f22733f = new C5618a();
        this.f22732e = new C5618a();
    }

    /* renamed from: a */
    protected void m19462a() {
        this.f22728a.mo4015a(this);
        this.f22736i.mo4170a(this);
    }

    /* renamed from: a */
    public V mo4144a(int size) {
        V value;
        mo4152g();
        int bucketedSize = mo4148c(size);
        synchronized (this) {
            int sizeInBytes;
            C2961e<V> bucket = m19476f(bucketedSize);
            if (bucket != null) {
                value = bucket.c();
                if (value != null) {
                    C5350k.m18321b(this.f22731d.add(value));
                    bucketedSize = mo4149c((Object) value);
                    sizeInBytes = mo4150d(bucketedSize);
                    this.f22732e.m19454a(sizeInBytes);
                    this.f22733f.m19455b(sizeInBytes);
                    this.f22736i.mo4169a(sizeInBytes);
                    m19460h();
                    if (C5320a.m18138a(2)) {
                        C5320a.m18124a(this.f22734g, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSize));
                    }
                }
            }
            sizeInBytes = mo4150d(bucketedSize);
            if (m19479h(sizeInBytes)) {
                this.f22732e.m19454a(sizeInBytes);
                if (bucket != null) {
                    bucket.e();
                }
                value = null;
                try {
                    value = mo4146b(bucketedSize);
                } catch (Throwable e) {
                    synchronized (this) {
                        this.f22732e.m19455b(sizeInBytes);
                        bucket = m19476f(bucketedSize);
                        if (bucket != null) {
                            bucket.f();
                        }
                        C5354o.m18337a(e);
                    }
                    return value;
                }
                synchronized (this) {
                    C5350k.m18321b(this.f22731d.add(value));
                    m19472d();
                    this.f22736i.mo4172b(sizeInBytes);
                    m19460h();
                    if (C5320a.m18138a(2)) {
                        C5320a.m18124a(this.f22734g, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSize));
                    }
                }
            } else {
                throw new C5621d(this.f22729b.f22817b, this.f22732e.f22727b, this.f22733f.f22727b, sizeInBytes);
            }
        }
        return value;
    }

    /* renamed from: a */
    public void mo4017a(V value) {
        C5350k.m18310a((Object) value);
        int bucketedSize = mo4149c((Object) value);
        int sizeInBytes = mo4150d(bucketedSize);
        synchronized (this) {
            C2961e<V> bucket = m19476f(bucketedSize);
            if (!this.f22731d.remove(value)) {
                C5320a.m18182e(this.f22734g, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSize));
                mo4147b((Object) value);
                this.f22736i.mo4174c(sizeInBytes);
            } else if (bucket == null || bucket.a() || m19475e() || !mo4151d((Object) value)) {
                if (bucket != null) {
                    bucket.f();
                }
                if (C5320a.m18138a(2)) {
                    C5320a.m18124a(this.f22734g, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSize));
                }
                mo4147b((Object) value);
                this.f22732e.m19455b(sizeInBytes);
                this.f22736i.mo4174c(sizeInBytes);
            } else {
                bucket.a(value);
                this.f22733f.m19454a(sizeInBytes);
                this.f22732e.m19455b(sizeInBytes);
                this.f22736i.mo4175d(sizeInBytes);
                if (C5320a.m18138a(2)) {
                    C5320a.m18124a(this.f22734g, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSize));
                }
            }
            m19460h();
        }
    }

    /* renamed from: a */
    public void mo4145a(C5323a memoryTrimType) {
        m19470c();
    }

    /* renamed from: b */
    protected void m19466b() {
    }

    /* renamed from: d */
    protected boolean mo4151d(V value) {
        C5350k.m18310a((Object) value);
        return true;
    }

    /* renamed from: g */
    private synchronized void mo4152g() {
        boolean z = !m19475e() || this.f22733f.f22727b == 0;
        C5350k.m18321b(z);
    }

    /* renamed from: a */
    private synchronized void m19458a(SparseIntArray inUseCounts) {
        C5350k.m18310a((Object) inUseCounts);
        this.f22730c.clear();
        SparseIntArray bucketSizes = this.f22729b.f22819d;
        if (bucketSizes != null) {
            for (int i = 0; i < bucketSizes.size(); i++) {
                int bucketSize = bucketSizes.keyAt(i);
                this.f22730c.put(bucketSize, new C2961e(mo4150d(bucketSize), bucketSizes.valueAt(i), inUseCounts.get(bucketSize, 0)));
            }
            this.f22735h = false;
        } else {
            this.f22735h = true;
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    void m19470c() {
        List<C2961e<V>> bucketsToTrim = new ArrayList(this.f22730c.size());
        SparseIntArray inUseCounts = new SparseIntArray();
        synchronized (this) {
            int i;
            for (i = 0; i < this.f22730c.size(); i++) {
                C2961e<V> bucket = (C2961e) this.f22730c.valueAt(i);
                if (bucket.b() > 0) {
                    bucketsToTrim.add(bucket);
                }
                inUseCounts.put(this.f22730c.keyAt(i), bucket.g());
            }
            m19458a(inUseCounts);
            this.f22733f.m19453a();
            m19460h();
        }
        m19466b();
        for (i = 0; i < bucketsToTrim.size(); i++) {
            bucket = (C2961e) bucketsToTrim.get(i);
            while (true) {
                Object item = bucket.d();
                if (item == null) {
                    break;
                }
                mo4147b(item);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: d */
    synchronized void m19472d() {
        if (m19475e()) {
            m19474e(this.f22729b.f22818c);
        }
    }

    @VisibleForTesting
    /* renamed from: e */
    synchronized void m19474e(int targetSize) {
        int bytesToFree = Math.min((this.f22732e.f22727b + this.f22733f.f22727b) - targetSize, this.f22733f.f22727b);
        if (bytesToFree > 0) {
            if (C5320a.m18138a(2)) {
                C5320a.m18125a(this.f22734g, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(targetSize), Integer.valueOf(this.f22732e.f22727b + this.f22733f.f22727b), Integer.valueOf(bytesToFree));
            }
            m19460h();
            for (int i = 0; i < this.f22730c.size() && bytesToFree > 0; i++) {
                C2961e<V> bucket = (C2961e) this.f22730c.valueAt(i);
                while (bytesToFree > 0) {
                    Object value = bucket.d();
                    if (value == null) {
                        break;
                    }
                    mo4147b(value);
                    bytesToFree -= bucket.f13210a;
                    this.f22733f.m19455b(bucket.f13210a);
                }
            }
            m19460h();
            if (C5320a.m18138a(2)) {
                C5320a.m18124a(this.f22734g, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(targetSize), Integer.valueOf(this.f22732e.f22727b + this.f22733f.f22727b));
            }
        }
    }

    @VisibleForTesting
    /* renamed from: f */
    synchronized C2961e<V> m19476f(int bucketedSize) {
        C2961e<V> newBucket;
        C2961e<V> bucket = (C2961e) this.f22730c.get(bucketedSize);
        if (bucket == null && this.f22735h) {
            if (C5320a.m18138a(2)) {
                C5320a.m18123a(this.f22734g, "creating new bucket %s", Integer.valueOf(bucketedSize));
            }
            newBucket = mo4153g(bucketedSize);
            this.f22730c.put(bucketedSize, newBucket);
        } else {
            newBucket = bucket;
        }
        return newBucket;
    }

    /* renamed from: g */
    C2961e<V> mo4153g(int bucketedSize) {
        return new C2961e(mo4150d(bucketedSize), Integer.MAX_VALUE, 0);
    }

    @VisibleForTesting
    /* renamed from: e */
    synchronized boolean m19475e() {
        boolean isMaxSizeSoftCapExceeded;
        isMaxSizeSoftCapExceeded = this.f22732e.f22727b + this.f22733f.f22727b > this.f22729b.f22818c;
        if (isMaxSizeSoftCapExceeded) {
            this.f22736i.mo4171b();
        }
        return isMaxSizeSoftCapExceeded;
    }

    @VisibleForTesting
    /* renamed from: h */
    synchronized boolean m19479h(int sizeInBytes) {
        boolean z = false;
        synchronized (this) {
            int hardCap = this.f22729b.f22817b;
            if (sizeInBytes > hardCap - this.f22732e.f22727b) {
                this.f22736i.mo4173c();
            } else {
                int softCap = this.f22729b.f22818c;
                if (sizeInBytes > softCap - (this.f22732e.f22727b + this.f22733f.f22727b)) {
                    m19474e(softCap - sizeInBytes);
                }
                if (sizeInBytes > hardCap - (this.f22732e.f22727b + this.f22733f.f22727b)) {
                    this.f22736i.mo4173c();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    /* renamed from: h */
    private void m19460h() {
        if (C5320a.m18138a(2)) {
            C5320a.m18126a(this.f22734g, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f22732e.f22726a), Integer.valueOf(this.f22732e.f22727b), Integer.valueOf(this.f22733f.f22726a), Integer.valueOf(this.f22733f.f22727b));
        }
    }

    /* renamed from: f */
    public synchronized Map<String, Integer> m19477f() {
        Map<String, Integer> stats;
        stats = new HashMap();
        for (int i = 0; i < this.f22730c.size(); i++) {
            stats.put(C5646w.f22783a + mo4150d(this.f22730c.keyAt(i)), Integer.valueOf(((C2961e) this.f22730c.valueAt(i)).g()));
        }
        stats.put(C5646w.f22788f, Integer.valueOf(this.f22729b.f22818c));
        stats.put(C5646w.f22789g, Integer.valueOf(this.f22729b.f22817b));
        stats.put(C5646w.f22784b, Integer.valueOf(this.f22732e.f22726a));
        stats.put(C5646w.f22785c, Integer.valueOf(this.f22732e.f22727b));
        stats.put(C5646w.f22786d, Integer.valueOf(this.f22733f.f22726a));
        stats.put(C5646w.f22787e, Integer.valueOf(this.f22733f.f22727b));
        return stats;
    }
}
