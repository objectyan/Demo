package com.facebook.imagepipeline.p154m;

import android.graphics.Bitmap;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.p275c.C5456e;
import com.facebook.p135b.p136a.C5247d;
import javax.annotation.Nullable;

/* compiled from: BasePostprocessor */
/* renamed from: com.facebook.imagepipeline.m.a */
public abstract class C2958a implements C2957e {
    /* renamed from: a */
    public String mo2051a() {
        return "Unknown postprocessor";
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo2050a(Bitmap sourceBitmap, C5456e bitmapFactory) {
        C2921a<Bitmap> destBitmapRef = bitmapFactory.a(sourceBitmap.getWidth(), sourceBitmap.getHeight(), sourceBitmap.getConfig());
        try {
            m11914a((Bitmap) destBitmapRef.m11260a(), sourceBitmap);
            C2921a<Bitmap> b = C2921a.m11258b(destBitmapRef);
            return b;
        } finally {
            C2921a.m11259c(destBitmapRef);
        }
    }

    /* renamed from: a */
    public void m11914a(Bitmap destBitmap, Bitmap sourceBitmap) {
        Bitmaps.a(destBitmap, sourceBitmap);
        m11913a(destBitmap);
    }

    /* renamed from: a */
    public void m11913a(Bitmap bitmap) {
    }

    @Nullable
    /* renamed from: b */
    public C5247d mo2052b() {
        return null;
    }
}
