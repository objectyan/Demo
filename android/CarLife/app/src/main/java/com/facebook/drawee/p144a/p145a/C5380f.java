package com.facebook.drawee.p144a.p145a;

import android.content.res.Resources;
import com.facebook.common.internal.C5273m;
import com.facebook.common.p140h.C2921a;
import com.facebook.drawee.p266b.C5391a;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p271a.p272a.C5442a;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p138c.C2918d;
import java.util.concurrent.Executor;

/* compiled from: PipelineDraweeControllerFactory */
/* renamed from: com.facebook.drawee.a.a.f */
public class C5380f {
    /* renamed from: a */
    private Resources f21988a;
    /* renamed from: b */
    private C5391a f21989b;
    /* renamed from: c */
    private C5442a f21990c;
    /* renamed from: d */
    private Executor f21991d;
    /* renamed from: e */
    private C2944p<C5247d, C5534b> f21992e;

    public C5380f(Resources resources, C5391a deferredReleaser, C5442a animatedDrawableFactory, Executor uiThreadExecutor, C2944p<C5247d, C5534b> memoryCache) {
        this.f21988a = resources;
        this.f21989b = deferredReleaser;
        this.f21990c = animatedDrawableFactory;
        this.f21991d = uiThreadExecutor;
        this.f21992e = memoryCache;
    }

    /* renamed from: a */
    public C2927c m18435a(C5273m<C2918d<C2921a<C5534b>>> dataSourceSupplier, String id, C5247d cacheKey, Object callerContext) {
        return new C2927c(this.f21988a, this.f21989b, this.f21990c, this.f21991d, this.f21992e, dataSourceSupplier, id, cacheKey, callerContext);
    }
}
