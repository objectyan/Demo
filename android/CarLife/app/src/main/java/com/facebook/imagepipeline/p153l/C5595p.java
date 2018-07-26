package com.facebook.imagepipeline.p153l;

import android.util.Pair;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: EncodedCacheKeyMultiplexProducer */
/* renamed from: com.facebook.imagepipeline.l.p */
public class C5595p extends ac<Pair<C5247d, c$b>, C2952d> {
    /* renamed from: b */
    private final C5477f f22653b;

    /* renamed from: b */
    protected /* synthetic */ Object mo4138b(aj ajVar) {
        return m19379a(ajVar);
    }

    public C5595p(C5477f cacheKeyFactory, ai inputProducer) {
        super(inputProducer);
        this.f22653b = cacheKeyFactory;
    }

    /* renamed from: a */
    protected Pair<C5247d, c$b> m19379a(aj producerContext) {
        return Pair.create(this.f22653b.mo4064c(producerContext.m19210a(), producerContext.m19214d()), producerContext.m19215e());
    }

    /* renamed from: a */
    public C2952d m19380a(C2952d encodedImage) {
        return C2952d.a(encodedImage);
    }
}
