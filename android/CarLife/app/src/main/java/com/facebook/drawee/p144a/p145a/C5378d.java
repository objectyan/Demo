package com.facebook.drawee.p144a.p145a;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.p140h.C2921a;
import com.facebook.drawee.p142g.C2925a;
import com.facebook.drawee.p142g.C5424d;
import com.facebook.drawee.p143c.C2926a;
import com.facebook.drawee.p143c.C2928b;
import com.facebook.drawee.p143c.C5396d;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p150f.C5509g;
import com.facebook.imagepipeline.p152i.C5533e;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p138c.C2918d;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: PipelineDraweeControllerBuilder */
/* renamed from: com.facebook.drawee.a.a.d */
public class C5378d extends C2928b<C5378d, C2959c, C2921a<C5534b>, C5533e> {
    /* renamed from: a */
    private final C5509g f21982a;
    /* renamed from: b */
    private final C5380f f21983b;

    /* renamed from: b */
    public /* synthetic */ C5424d m18429b(Uri uri) {
        return m18426a(uri);
    }

    /* renamed from: b */
    public /* synthetic */ C5424d m18430b(@Nullable String str) {
        return m18427a(str);
    }

    /* renamed from: c */
    protected /* synthetic */ C2928b m18431c() {
        return m18428b();
    }

    /* renamed from: d */
    protected /* synthetic */ C2926a m18432d() {
        return m18425a();
    }

    public C5378d(Context context, C5380f pipelineDraweeControllerFactory, C5509g imagePipeline, Set<C5396d> boundControllerListeners) {
        super(context, boundControllerListeners);
        this.f21982a = imagePipeline;
        this.f21983b = pipelineDraweeControllerFactory;
    }

    /* renamed from: a */
    public C5378d m18426a(Uri uri) {
        return (C5378d) super.b(C2959c.a(uri));
    }

    /* renamed from: a */
    public C5378d m18427a(@Nullable String uriString) {
        return (C5378d) super.b(C2959c.a(uriString));
    }

    /* renamed from: a */
    protected C2927c m18425a() {
        C2925a oldController = p();
        if (!(oldController instanceof C2927c)) {
            return this.f21983b.m18435a(u(), C5378d.t(), m18422x(), f());
        }
        C2927c controller = (C2927c) oldController;
        controller.a(u(), C5378d.t(), m18422x(), f());
        return controller;
    }

    /* renamed from: x */
    private C5247d m18422x() {
        C2959c imageRequest = (C2959c) g();
        C5477f cacheKeyFactory = this.f21982a.m18920h();
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.n() != null) {
            return cacheKeyFactory.mo4063b(imageRequest, f());
        }
        return cacheKeyFactory.mo4062a(imageRequest, f());
    }

    /* renamed from: a */
    protected C2918d<C2921a<C5534b>> m18423a(C2959c imageRequest, Object callerContext, boolean bitmapCacheOnly) {
        if (bitmapCacheOnly) {
            return this.f21982a.m18901b(imageRequest, callerContext);
        }
        return this.f21982a.m18905c(imageRequest, callerContext);
    }

    /* renamed from: b */
    protected C5378d m18428b() {
        return this;
    }
}
