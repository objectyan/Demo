package com.facebook.imagepipeline.p152i;

import android.graphics.Bitmap;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p140h.C5329c;
import com.facebook.p148h.C2940a;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: CloseableStaticBitmap */
/* renamed from: com.facebook.imagepipeline.i.c */
public class C5536c extends C5535a {
    @GuardedBy("this")
    /* renamed from: a */
    private C2921a<Bitmap> f22453a;
    /* renamed from: b */
    private volatile Bitmap f22454b;
    /* renamed from: c */
    private final C5537g f22455c;
    /* renamed from: d */
    private final int f22456d;

    public C5536c(Bitmap bitmap, C5329c<Bitmap> resourceReleaser, C5537g qualityInfo, int rotationAngle) {
        this.f22454b = (Bitmap) C5350k.m18310a((Object) bitmap);
        this.f22453a = C2921a.a(this.f22454b, (C5329c) C5350k.m18310a((Object) resourceReleaser));
        this.f22455c = qualityInfo;
        this.f22456d = rotationAngle;
    }

    public C5536c(C2921a<Bitmap> bitmapReference, C5537g qualityInfo, int rotationAngle) {
        this.f22453a = (C2921a) C5350k.m18310a(bitmapReference.c());
        this.f22454b = (Bitmap) this.f22453a.a();
        this.f22455c = qualityInfo;
        this.f22456d = rotationAngle;
    }

    public void close() {
        C2921a<Bitmap> reference = m19052j();
        if (reference != null) {
            reference.close();
        }
    }

    /* renamed from: j */
    private synchronized C2921a<Bitmap> m19052j() {
        C2921a<Bitmap> reference;
        reference = this.f22453a;
        this.f22453a = null;
        this.f22454b = null;
        return reference;
    }

    /* renamed from: f */
    public synchronized C2921a<Bitmap> m19057f() {
        C5350k.m18311a(this.f22453a, (Object) "Cannot convert a closed static bitmap");
        return m19052j();
    }

    /* renamed from: c */
    public synchronized boolean mo4100c() {
        return this.f22453a == null;
    }

    /* renamed from: a */
    public Bitmap mo4098a() {
        return this.f22454b;
    }

    /* renamed from: b */
    public int mo4099b() {
        return C2940a.a(this.f22454b);
    }

    /* renamed from: g */
    public int mo4102g() {
        Bitmap bitmap = this.f22454b;
        return bitmap == null ? 0 : bitmap.getWidth();
    }

    /* renamed from: h */
    public int mo4103h() {
        Bitmap bitmap = this.f22454b;
        return bitmap == null ? 0 : bitmap.getHeight();
    }

    /* renamed from: i */
    public int m19060i() {
        return this.f22456d;
    }

    /* renamed from: d */
    public C5537g mo4097d() {
        return this.f22455c;
    }
}
