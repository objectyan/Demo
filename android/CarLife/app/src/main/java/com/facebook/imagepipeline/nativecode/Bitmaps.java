package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.p148h.C2940a;
import java.nio.ByteBuffer;

@DoNotStrip
public class Bitmaps {
    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);

    @DoNotStrip
    private static native ByteBuffer nativeGetByteBuffer(Bitmap bitmap, long j, long j2);

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @DoNotStrip
    private static native void nativeReleaseByteBuffer(Bitmap bitmap);

    static {
        C5656a.m19641a();
    }

    /* renamed from: a */
    public static void m19635a(Bitmap bitmap) {
        C5350k.m18310a((Object) bitmap);
        nativePinBitmap(bitmap);
    }

    /* renamed from: a */
    public static ByteBuffer m19634a(Bitmap bitmap, long start, long size) {
        C5350k.m18310a((Object) bitmap);
        return nativeGetByteBuffer(bitmap, start, size);
    }

    /* renamed from: b */
    public static void m19638b(Bitmap bitmap) {
        C5350k.m18310a((Object) bitmap);
        nativeReleaseByteBuffer(bitmap);
    }

    /* renamed from: a */
    public static void m19637a(Bitmap dest, Bitmap src) {
        boolean z;
        boolean z2 = true;
        C5350k.m18315a(src.getConfig() == dest.getConfig());
        C5350k.m18315a(dest.isMutable());
        if (dest.getWidth() == src.getWidth()) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (dest.getHeight() != src.getHeight()) {
            z2 = false;
        }
        C5350k.m18315a(z2);
        nativeCopyBitmap(dest, dest.getRowBytes(), src, src.getRowBytes(), dest.getHeight());
    }

    @TargetApi(19)
    /* renamed from: a */
    public static void m19636a(Bitmap bitmap, int width, int height, Config bitmapConfig) {
        C5350k.m18315a(bitmap.getAllocationByteCount() >= (width * height) * C2940a.a(bitmapConfig));
        bitmap.reconfigure(width, height, bitmapConfig);
    }
}
