package com.facebook.imagepipeline.p153l;

import com.facebook.imagepipeline.p152i.C2952d;

/* compiled from: AddImageTransformMetaDataProducer */
/* renamed from: com.facebook.imagepipeline.l.a */
public class C5551a implements ai<C2952d> {
    /* renamed from: a */
    private final ai<C2952d> f22476a;

    /* compiled from: AddImageTransformMetaDataProducer */
    /* renamed from: com.facebook.imagepipeline.l.a$a */
    private static class C5550a extends C5549m<C2952d, C2952d> {
        private C5550a(C5517j<C2952d> consumer) {
            super(consumer);
        }

        /* renamed from: a */
        protected void m19143a(C2952d newResult, boolean isLast) {
            if (newResult == null) {
                m19142d().mo4087b(null, isLast);
                return;
            }
            if (!C2952d.c(newResult)) {
                newResult.k();
            }
            m19142d().mo4087b(newResult, isLast);
        }
    }

    public C5551a(ai<C2952d> inputProducer) {
        this.f22476a = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj context) {
        this.f22476a.mo4122a(new C5550a(consumer), context);
    }
}
