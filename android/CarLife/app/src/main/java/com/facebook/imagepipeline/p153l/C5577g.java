package com.facebook.imagepipeline.p153l;

import android.util.Pair;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: BitmapMemoryCacheKeyMultiplexProducer */
/* renamed from: com.facebook.imagepipeline.l.g */
public class C5577g extends ac<Pair<C5247d, c$b>, C2921a<C5534b>> {
    /* renamed from: b */
    private final C5477f f22590b;

    /* renamed from: b */
    protected /* synthetic */ Object mo4138b(aj ajVar) {
        return m19308a(ajVar);
    }

    public C5577g(C5477f cacheKeyFactory, ai inputProducer) {
        super(inputProducer);
        this.f22590b = cacheKeyFactory;
    }

    /* renamed from: a */
    protected Pair<C5247d, c$b> m19308a(aj producerContext) {
        return Pair.create(this.f22590b.mo4062a(producerContext.m19210a(), producerContext.m19214d()), producerContext.m19215e());
    }

    /* renamed from: a */
    public C2921a<C5534b> m19309a(C2921a<C5534b> closeableImage) {
        return C2921a.b(closeableImage);
    }
}
