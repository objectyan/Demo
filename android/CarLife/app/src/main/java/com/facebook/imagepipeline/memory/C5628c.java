package com.facebook.imagepipeline.memory;

/* compiled from: BitmapCounterProvider */
/* renamed from: com.facebook.imagepipeline.memory.c */
public class C5628c {
    /* renamed from: a */
    public static final int f22755a = C5628c.m19500b();
    /* renamed from: b */
    public static final int f22756b = 384;
    /* renamed from: c */
    private static final long f22757c = 1024;
    /* renamed from: d */
    private static final long f22758d = 1048576;
    /* renamed from: e */
    private static C5627b f22759e;

    /* renamed from: b */
    private static int m19500b() {
        int maxMemory = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) maxMemory) > 16777216) {
            return (maxMemory / 4) * 3;
        }
        return maxMemory / 2;
    }

    /* renamed from: a */
    public static C5627b m19499a() {
        if (f22759e == null) {
            f22759e = new C5627b(f22756b, f22755a);
        }
        return f22759e;
    }
}
