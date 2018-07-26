package com.facebook.drawee.p144a.p145a;

import android.content.Context;
import com.facebook.common.internal.C5273m;
import com.facebook.common.p256c.C5313i;
import com.facebook.drawee.p143c.C5396d;
import com.facebook.drawee.p266b.C5391a;
import com.facebook.imagepipeline.p150f.C2948j;
import com.facebook.imagepipeline.p150f.C5509g;
import com.facebook.imagepipeline.p271a.p272a.C5442a;
import com.facebook.imagepipeline.p271a.p272a.C5443b;
import java.util.Set;

/* compiled from: PipelineDraweeControllerBuilderSupplier */
/* renamed from: com.facebook.drawee.a.a.e */
public class C5379e implements C5273m<C5378d> {
    /* renamed from: a */
    private final Context f21984a;
    /* renamed from: b */
    private final C5509g f21985b;
    /* renamed from: c */
    private final C5380f f21986c;
    /* renamed from: d */
    private final Set<C5396d> f21987d;

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18433a();
    }

    public C5379e(Context context) {
        this(context, C2948j.a());
    }

    public C5379e(Context context, C2948j imagePipelineFactory) {
        this(context, imagePipelineFactory, null);
    }

    public C5379e(Context context, C2948j imagePipelineFactory, Set<C5396d> boundControllerListeners) {
        this.f21984a = context;
        this.f21985b = imagePipelineFactory.j();
        C5443b animatedFactory = imagePipelineFactory.c();
        C5442a animatedDrawableFactory = null;
        if (animatedFactory != null) {
            animatedDrawableFactory = animatedFactory.m18698a(context);
        }
        this.f21986c = new C5380f(context.getResources(), C5391a.m18437a(), animatedDrawableFactory, C5313i.m18112c(), this.f21985b.m18911d());
        this.f21987d = boundControllerListeners;
    }

    /* renamed from: a */
    public C5378d m18433a() {
        return new C5378d(this.f21984a, this.f21986c, this.f21985b, this.f21987d);
    }
}
