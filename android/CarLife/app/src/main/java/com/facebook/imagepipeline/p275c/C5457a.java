package com.facebook.imagepipeline.p275c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5629d;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.p148h.C2940a;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: ArtBitmapFactory */
/* renamed from: com.facebook.imagepipeline.c.a */
public class C5457a extends C5456e {
    /* renamed from: a */
    private final C5629d f22265a;

    public C5457a(C5629d bitmapPool) {
        this.f22265a = bitmapPool;
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4056a(int width, int height, Config bitmapConfig) {
        Bitmap bitmap = (Bitmap) this.f22265a.mo4144a(C2940a.a(width, height, bitmapConfig));
        Bitmaps.m19636a(bitmap, width, height, bitmapConfig);
        return C2921a.a(bitmap, this.f22265a);
    }
}
