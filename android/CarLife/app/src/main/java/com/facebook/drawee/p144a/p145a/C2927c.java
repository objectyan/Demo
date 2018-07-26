package com.facebook.drawee.p144a.p145a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p257e.C5320a;
import com.facebook.drawee.p143c.C2926a;
import com.facebook.drawee.p146d.C5408j;
import com.facebook.drawee.p266b.C5391a;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p152i.C5533e;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5536c;
import com.facebook.imagepipeline.p271a.p272a.C5442a;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p138c.C2918d;
import com.facebook.p264d.p265a.C5375a;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: PipelineDraweeController */
/* renamed from: com.facebook.drawee.a.a.c */
public class C2927c extends C2926a<C2921a<C5534b>, C5533e> {
    /* renamed from: a */
    private static final Class<?> f12914a = C2927c.class;
    /* renamed from: e */
    private static c$a f12915e;
    /* renamed from: b */
    private final Resources f12916b;
    /* renamed from: c */
    private final C5442a f12917c;
    @Nullable
    /* renamed from: d */
    private C2944p<C5247d, C5534b> f12918d;
    /* renamed from: f */
    private C5247d f12919f;
    /* renamed from: g */
    private C5273m<C2918d<C2921a<C5534b>>> f12920g;

    /* renamed from: a */
    protected /* synthetic */ void mo2030a(@Nullable Object obj) {
        m11354d((C2921a) obj);
    }

    /* renamed from: b */
    protected /* synthetic */ int mo2031b(@Nullable Object obj) {
        return m11350c((C2921a) obj);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2034c(Object obj) {
        return m11349b((C2921a) obj);
    }

    /* renamed from: d */
    protected /* synthetic */ Drawable mo2035d(Object obj) {
        return m11343a((C2921a) obj);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2036e() {
        return mo2033c();
    }

    public C2927c(Resources resources, C5391a deferredReleaser, C5442a animatedDrawableFactory, Executor uiThreadExecutor, C2944p<C5247d, C5534b> memoryCache, C5273m<C2918d<C2921a<C5534b>>> dataSourceSupplier, String id, C5247d cacheKey, Object callerContext) {
        super(deferredReleaser, uiThreadExecutor, id, callerContext);
        this.f12916b = resources;
        this.f12917c = animatedDrawableFactory;
        this.f12918d = memoryCache;
        this.f12919f = cacheKey;
        m11340a((C5273m) dataSourceSupplier);
    }

    /* renamed from: a */
    public void m11345a(C5273m<C2918d<C2921a<C5534b>>> dataSourceSupplier, String id, C5247d cacheKey, Object callerContext) {
        super.m11314a(id, callerContext);
        m11340a((C5273m) dataSourceSupplier);
        this.f12919f = cacheKey;
    }

    /* renamed from: a */
    private void m11340a(C5273m<C2918d<C2921a<C5534b>>> dataSourceSupplier) {
        this.f12920g = dataSourceSupplier;
    }

    /* renamed from: a */
    protected Resources mo2028a() {
        return this.f12916b;
    }

    /* renamed from: b */
    protected C2918d<C2921a<C5534b>> mo2032b() {
        if (C5320a.a(2)) {
            C5320a.a(f12914a, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return (C2918d) this.f12920g.b();
    }

    /* renamed from: a */
    protected Drawable m11343a(C2921a<C5534b> image) {
        C5350k.b(C2921a.m11257a((C2921a) image));
        C5534b closeableImage = (C5534b) image.m11260a();
        if (closeableImage instanceof C5536c) {
            C5536c closeableStaticBitmap = (C5536c) closeableImage;
            Drawable bitmapDrawable = new BitmapDrawable(this.f12916b, closeableStaticBitmap.a());
            if (closeableStaticBitmap.i() == 0 || closeableStaticBitmap.i() == -1) {
                return bitmapDrawable;
            }
            return new C5408j(bitmapDrawable, closeableStaticBitmap.i());
        } else if (this.f12917c != null) {
            return this.f12917c.a(closeableImage);
        } else {
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        }
    }

    /* renamed from: b */
    protected C5533e m11349b(C2921a<C5534b> image) {
        C5350k.b(C2921a.m11257a((C2921a) image));
        return (C5533e) image.m11260a();
    }

    /* renamed from: c */
    protected int m11350c(@Nullable C2921a<C5534b> image) {
        return image != null ? image.m11265f() : 0;
    }

    /* renamed from: d */
    protected void m11354d(@Nullable C2921a<C5534b> image) {
        C2921a.m11259c(image);
    }

    /* renamed from: a */
    protected void mo2029a(@Nullable Drawable drawable) {
        if (drawable instanceof C5375a) {
            ((C5375a) drawable).a();
        }
    }

    /* renamed from: c */
    protected C2921a<C5534b> mo2033c() {
        if (!c$a.a(C2927c.m11341d())) {
            return null;
        }
        if (this.f12918d == null || this.f12919f == null) {
            return null;
        }
        C2921a<C5534b> closeableImage = this.f12918d.mo2039a(this.f12919f);
        if (closeableImage == null || ((C5534b) closeableImage.m11260a()).d().c()) {
            return closeableImage;
        }
        closeableImage.close();
        return null;
    }

    public String toString() {
        return C2923j.m11271a((Object) this).a("super", super.toString()).a("dataSourceSupplier", this.f12920g).toString();
    }

    /* renamed from: d */
    protected static c$a m11341d() {
        if (f12915e == null) {
            f12915e = new c$a();
        }
        return f12915e;
    }
}
