package com.facebook.imagepipeline.p279k;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5638k;
import com.facebook.imagepipeline.memory.C5640y;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(19)
@ThreadSafe
/* compiled from: KitKatPurgeableDecoder */
/* renamed from: com.facebook.imagepipeline.k.d */
public class C5547d extends C5545b {
    /* renamed from: b */
    private final C5638k f22474b;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C2921a mo4121a(Bitmap bitmap) {
        return super.mo4121a(bitmap);
    }

    public C5547d(C5638k flexByteArrayPool) {
        this.f22474b = flexByteArrayPool;
    }

    /* renamed from: a */
    protected Bitmap mo4120a(C2921a<C5640y> bytesRef, Options options) {
        C5640y pooledByteBuffer = (C5640y) bytesRef.a();
        int length = pooledByteBuffer.mo4155a();
        C2921a<byte[]> encodedBytesArrayRef = this.f22474b.m19531a(length);
        try {
            byte[] encodedBytesArray = (byte[]) encodedBytesArrayRef.a();
            pooledByteBuffer.mo4156a(0, encodedBytesArray, 0, length);
            Bitmap bitmap = (Bitmap) C5350k.m18311a(BitmapFactory.decodeByteArray(encodedBytesArray, 0, length, options), (Object) "BitmapFactory returned null");
            return bitmap;
        } finally {
            C2921a.c(encodedBytesArrayRef);
        }
    }

    /* renamed from: a */
    protected Bitmap mo4119a(C2921a<C5640y> bytesRef, int length, Options options) {
        boolean z = false;
        byte[] suffix = C5545b.m19118a((C2921a) bytesRef, length) ? null : a;
        C5640y pooledByteBuffer = (C5640y) bytesRef.a();
        if (length <= pooledByteBuffer.mo4155a()) {
            z = true;
        }
        C5350k.m18315a(z);
        C2921a<byte[]> encodedBytesArrayRef = this.f22474b.m19531a(length + 2);
        try {
            byte[] encodedBytesArray = (byte[]) encodedBytesArrayRef.a();
            pooledByteBuffer.mo4156a(0, encodedBytesArray, 0, length);
            if (suffix != null) {
                C5547d.m19133a(encodedBytesArray, length);
                length += 2;
            }
            Bitmap bitmap = (Bitmap) C5350k.m18311a(BitmapFactory.decodeByteArray(encodedBytesArray, 0, length, options), (Object) "BitmapFactory returned null");
            return bitmap;
        } finally {
            C2921a.c(encodedBytesArrayRef);
        }
    }

    /* renamed from: a */
    private static void m19133a(byte[] imageBytes, int offset) {
        imageBytes[offset] = (byte) -1;
        imageBytes[offset + 1] = (byte) -39;
    }
}
