package com.facebook.imagepipeline.p275c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.p140h.C2921a;

/* compiled from: PlatformBitmapFactory */
/* renamed from: com.facebook.imagepipeline.c.e */
public abstract class C5456e {
    /* renamed from: a */
    public abstract C2921a<Bitmap> mo4056a(int i, int i2, Config config);

    /* renamed from: a */
    public C2921a<Bitmap> m18733a(int width, int height) {
        return mo4056a(width, height, Config.ARGB_8888);
    }
}
