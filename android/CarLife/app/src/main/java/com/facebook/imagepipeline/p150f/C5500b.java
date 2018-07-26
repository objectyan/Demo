package com.facebook.imagepipeline.p150f;

import com.facebook.p135b.p137b.C5266d;
import com.facebook.p135b.p137b.C5274c;
import com.facebook.p135b.p137b.C5281j;
import com.facebook.p135b.p137b.C5282e;
import com.facebook.p135b.p137b.C5282e.C5279b;

/* compiled from: DiskStorageCacheFactory */
/* renamed from: com.facebook.imagepipeline.f.b */
public class C5500b implements C5499f {
    /* renamed from: a */
    private C5501c f22348a;

    public C5500b(C5501c diskStorageFactory) {
        this.f22348a = diskStorageFactory;
    }

    /* renamed from: a */
    public static C5282e m18876a(C5274c diskCacheConfig, C5266d diskStorage) {
        return new C5282e(diskStorage, diskCacheConfig.m17941g(), new C5279b(diskCacheConfig.m17940f(), diskCacheConfig.m17939e(), diskCacheConfig.m17938d()), diskCacheConfig.m17943i(), diskCacheConfig.m17942h(), diskCacheConfig.m17944j(), diskCacheConfig.m17945k());
    }

    /* renamed from: a */
    public C5281j mo4083a(C5274c diskCacheConfig) {
        return C5500b.m18876a(diskCacheConfig, this.f22348a.mo4084a(diskCacheConfig));
    }
}
