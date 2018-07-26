package com.facebook.imagepipeline.memory;

/* compiled from: NoOpPoolStatsTracker */
/* renamed from: com.facebook.imagepipeline.memory.q */
public class C5647q implements C5646w {
    /* renamed from: h */
    private static C5647q f22790h = null;

    private C5647q() {
    }

    /* renamed from: a */
    public static synchronized C5647q m19588a() {
        C5647q c5647q;
        synchronized (C5647q.class) {
            if (f22790h == null) {
                f22790h = new C5647q();
            }
            c5647q = f22790h;
        }
        return c5647q;
    }

    /* renamed from: a */
    public void mo4170a(C5624a basePool) {
    }

    /* renamed from: a */
    public void mo4169a(int bucketedSize) {
    }

    /* renamed from: b */
    public void mo4171b() {
    }

    /* renamed from: c */
    public void mo4173c() {
    }

    /* renamed from: b */
    public void mo4172b(int size) {
    }

    /* renamed from: c */
    public void mo4174c(int sizeInBytes) {
    }

    /* renamed from: d */
    public void mo4175d(int sizeInBytes) {
    }
}
