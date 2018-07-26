package com.facebook.imagepipeline.p275c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p279k.C5543e;
import com.facebook.p269f.C5434b;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
/* compiled from: HoneycombBitmapFactory */
/* renamed from: com.facebook.imagepipeline.c.d */
public class C5460d extends C5456e {
    /* renamed from: a */
    private final C5458b f22269a;
    /* renamed from: b */
    private final C5543e f22270b;

    public C5460d(C5458b jpegGenerator, C5543e purgeableDecoder) {
        this.f22269a = jpegGenerator;
        this.f22270b = purgeableDecoder;
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4056a(int width, int height, Config bitmapConfig) {
        C2952d encodedImage;
        C2921a<C5640y> jpgRef = this.f22269a.m18736a((short) width, (short) height);
        try {
            encodedImage = new C2952d(jpgRef);
            encodedImage.a(C5434b.JPEG);
            C2921a<Bitmap> bitmapRef = this.f22270b.mo4118a(encodedImage, bitmapConfig, ((C5640y) jpgRef.a()).mo4155a());
            ((Bitmap) bitmapRef.a()).eraseColor(0);
            C2952d.d(encodedImage);
            jpgRef.close();
            return bitmapRef;
        } catch (Throwable th) {
            jpgRef.close();
        }
    }
}
