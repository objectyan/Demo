package com.facebook.imagepipeline.nativecode;

/* compiled from: WebpTranscoderFactory */
/* renamed from: com.facebook.imagepipeline.nativecode.c */
public class C5658c {
    /* renamed from: a */
    public static boolean f22837a;
    /* renamed from: b */
    private static C5657b f22838b;

    static {
        f22837a = false;
        try {
            f22838b = (C5657b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            f22837a = true;
        } catch (Throwable th) {
            f22837a = false;
        }
    }

    /* renamed from: a */
    public static C5657b m19645a() {
        return f22838b;
    }
}
