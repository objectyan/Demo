package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p258g.C5325c;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: BitmapPool */
/* renamed from: com.facebook.imagepipeline.memory.d */
public class C5629d extends C5624a<Bitmap> {
    /* renamed from: b */
    protected /* synthetic */ Object mo4146b(int i) {
        return m19510i(i);
    }

    /* renamed from: b */
    protected /* synthetic */ void mo4147b(Object obj) {
        m19501a((Bitmap) obj);
    }

    /* renamed from: c */
    protected /* synthetic */ int mo4149c(Object obj) {
        return m19502b((Bitmap) obj);
    }

    /* renamed from: d */
    protected /* synthetic */ boolean mo4151d(Object obj) {
        return m19507c((Bitmap) obj);
    }

    public C5629d(C5325c memoryTrimmableRegistry, C5653v poolParams, C5646w poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        m19462a();
    }

    /* renamed from: i */
    protected Bitmap m19510i(int size) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) size) / 2.0d), Config.RGB_565);
    }

    /* renamed from: a */
    protected void m19501a(Bitmap value) {
        C5350k.m18310a((Object) value);
        value.recycle();
    }

    /* renamed from: c */
    protected int mo4148c(int requestSize) {
        return requestSize;
    }

    /* renamed from: b */
    protected int m19502b(Bitmap value) {
        C5350k.m18310a((Object) value);
        return value.getAllocationByteCount();
    }

    /* renamed from: d */
    protected int mo4150d(int bucketedSize) {
        return bucketedSize;
    }

    /* renamed from: c */
    protected boolean m19507c(Bitmap value) {
        C5350k.m18310a((Object) value);
        return !value.isRecycled() && value.isMutable();
    }
}
