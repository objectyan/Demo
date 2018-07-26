package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5350k;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p276e.C5495d;

/* compiled from: ThumbnailBranchProducer */
/* renamed from: com.facebook.imagepipeline.l.au */
public class au implements ai<C2952d> {
    /* renamed from: a */
    private final av<C2952d>[] f22569a;

    /* compiled from: ThumbnailBranchProducer */
    /* renamed from: com.facebook.imagepipeline.l.au$a */
    private class C5571a extends C5549m<C2952d, C2952d> {
        /* renamed from: a */
        final /* synthetic */ au f22565a;
        /* renamed from: b */
        private final aj f22566b;
        /* renamed from: c */
        private final int f22567c;
        /* renamed from: d */
        private final C5495d f22568d = this.f22566b.m19210a().e();

        public C5571a(au auVar, C5517j<C2952d> consumer, aj producerContext, int producerIndex) {
            this.f22565a = auVar;
            super(consumer);
            this.f22566b = producerContext;
            this.f22567c = producerIndex;
        }

        /* renamed from: a */
        protected void m19273a(C2952d newResult, boolean isLast) {
            if (newResult != null && (!isLast || aw.m19283a(newResult, this.f22568d))) {
                m19142d().mo4087b(newResult, isLast);
            } else if (isLast) {
                C2952d.d(newResult);
                if (!this.f22565a.m19277a(this.f22567c + 1, m19142d(), this.f22566b)) {
                    m19142d().mo4087b(null, true);
                }
            }
        }

        /* renamed from: a */
        protected void mo4092a(Throwable t) {
            if (!this.f22565a.m19277a(this.f22567c + 1, m19142d(), this.f22566b)) {
                m19142d().mo4088b(t);
            }
        }
    }

    public au(av<C2952d>... thumbnailProducers) {
        this.f22569a = (av[]) C5350k.m18310a((Object) thumbnailProducers);
        C5350k.m18308a(0, this.f22569a.length);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj context) {
        if (context.m19210a().e() == null) {
            consumer.mo4087b(null, true);
        } else if (!m19277a(0, consumer, context)) {
            consumer.mo4087b(null, true);
        }
    }

    /* renamed from: a */
    private boolean m19277a(int startIndex, C5517j<C2952d> consumer, aj context) {
        int producerIndex = m19276a(startIndex, context.m19210a().e());
        if (producerIndex == -1) {
            return false;
        }
        this.f22569a[producerIndex].mo4122a(new C5571a(this, consumer, context, producerIndex), context);
        return true;
    }

    /* renamed from: a */
    private int m19276a(int startIndex, C5495d resizeOptions) {
        for (int i = startIndex; i < this.f22569a.length; i++) {
            if (this.f22569a[i].mo4142a(resizeOptions)) {
                return i;
            }
        }
        return -1;
    }
}
