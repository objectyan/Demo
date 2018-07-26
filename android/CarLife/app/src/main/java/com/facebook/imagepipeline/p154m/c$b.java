package com.facebook.imagepipeline.p154m;

/* compiled from: ImageRequest */
/* renamed from: com.facebook.imagepipeline.m.c$b */
public enum c$b {
    FULL_FETCH(1),
    DISK_CACHE(2),
    ENCODED_MEMORY_CACHE(3),
    BITMAP_MEMORY_CACHE(4);
    
    /* renamed from: e */
    private int f22720e;

    private c$b(int value) {
        this.f22720e = value;
    }

    /* renamed from: a */
    public int m19441a() {
        return this.f22720e;
    }

    /* renamed from: a */
    public static c$b m19440a(c$b requestLevel1, c$b requestLevel2) {
        return requestLevel1.m19441a() > requestLevel2.m19441a() ? requestLevel1 : requestLevel2;
    }
}
