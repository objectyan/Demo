package com.facebook.imagepipeline.p279k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5627b;
import com.facebook.imagepipeline.memory.C5628c;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p276e.C5496e;

/* compiled from: DalvikPurgeableDecoder */
/* renamed from: com.facebook.imagepipeline.k.b */
abstract class C5545b implements C5543e {
    /* renamed from: a */
    protected static final byte[] f22470a = new byte[]{(byte) -1, (byte) -39};
    /* renamed from: b */
    private final C5627b f22471b = C5628c.m19499a();

    /* renamed from: a */
    abstract Bitmap mo4119a(C2921a<C5640y> c2921a, int i, Options options);

    /* renamed from: a */
    abstract Bitmap mo4120a(C2921a<C5640y> c2921a, Options options);

    C5545b() {
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4117a(C2952d encodedImage, Config bitmapConfig) {
        Options options = C5545b.m19117a(encodedImage.i(), bitmapConfig);
        C2921a bytesRef = encodedImage.c();
        C5350k.m18310a((Object) bytesRef);
        try {
            C2921a<Bitmap> a = mo4121a(mo4120a(bytesRef, options));
            return a;
        } finally {
            C2921a.c(bytesRef);
        }
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4118a(C2952d encodedImage, Config bitmapConfig, int length) {
        Options options = C5545b.m19117a(encodedImage.i(), bitmapConfig);
        C2921a bytesRef = encodedImage.c();
        C5350k.m18310a((Object) bytesRef);
        try {
            C2921a<Bitmap> a = mo4121a(mo4119a(bytesRef, length, options));
            return a;
        } finally {
            C2921a.c(bytesRef);
        }
    }

    /* renamed from: a */
    private static Options m19117a(int sampleSize, Config bitmapConfig) {
        Options options = new Options();
        options.inDither = true;
        options.inPreferredConfig = bitmapConfig;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = sampleSize;
        if (VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }

    /* renamed from: a */
    protected static boolean m19118a(C2921a<C5640y> bytesRef, int length) {
        C5640y buffer = (C5640y) bytesRef.a();
        return length >= 2 && buffer.mo4154a(length - 2) == (byte) -1 && buffer.mo4154a(length - 1) == (byte) -39;
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4121a(Bitmap bitmap) {
        try {
            Bitmaps.m19635a(bitmap);
            if (this.f22471b.m19495a(bitmap)) {
                return C2921a.a(bitmap, this.f22471b.m19498c());
            }
            bitmap.recycle();
            throw new C5496e();
        } catch (Exception e) {
            bitmap.recycle();
            throw C5354o.m18340b(e);
        }
    }
}
