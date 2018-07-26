package com.facebook.imagepipeline.p153l;

import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;

/* compiled from: BranchOnSeparateImagesProducer */
/* renamed from: com.facebook.imagepipeline.l.i */
public class C5581i implements ai<C2952d> {
    /* renamed from: a */
    private final ai<C2952d> f22595a;
    /* renamed from: b */
    private final ai<C2952d> f22596b;

    /* compiled from: BranchOnSeparateImagesProducer */
    /* renamed from: com.facebook.imagepipeline.l.i$a */
    private class C5580a extends C5549m<C2952d, C2952d> {
        /* renamed from: a */
        final /* synthetic */ C5581i f22593a;
        /* renamed from: b */
        private aj f22594b;

        private C5580a(C5581i c5581i, C5517j<C2952d> consumer, aj producerContext) {
            this.f22593a = c5581i;
            super(consumer);
            this.f22594b = producerContext;
        }

        /* renamed from: a */
        protected void m19314a(C2952d newResult, boolean isLast) {
            C2959c request = this.f22594b.m19210a();
            boolean isGoodEnough = aw.m19283a(newResult, request.e());
            if (newResult != null && (isGoodEnough || request.i())) {
                C5517j d = m19142d();
                boolean z = isLast && isGoodEnough;
                d.mo4087b(newResult, z);
            }
            if (isLast && !isGoodEnough) {
                C2952d.d(newResult);
                this.f22593a.f22596b.mo4122a(m19142d(), this.f22594b);
            }
        }

        /* renamed from: a */
        protected void mo4092a(Throwable t) {
            this.f22593a.f22596b.mo4122a(m19142d(), this.f22594b);
        }
    }

    public C5581i(ai<C2952d> inputProducer1, ai<C2952d> inputProducer2) {
        this.f22595a = inputProducer1;
        this.f22596b = inputProducer2;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj context) {
        this.f22595a.mo4122a(new C5580a(consumer, context), context);
    }
}
