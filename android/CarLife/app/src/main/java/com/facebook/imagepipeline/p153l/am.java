package com.facebook.imagepipeline.p153l;

import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p152i.C2952d;

/* compiled from: RemoveImageTransformMetaDataProducer */
/* renamed from: com.facebook.imagepipeline.l.am */
public class am implements ai<C2921a<C5640y>> {
    /* renamed from: a */
    private final ai<C2952d> f22520a;

    /* compiled from: RemoveImageTransformMetaDataProducer */
    /* renamed from: com.facebook.imagepipeline.l.am$a */
    private class C5560a extends C5549m<C2952d, C2921a<C5640y>> {
        /* renamed from: a */
        final /* synthetic */ am f22519a;

        private C5560a(am amVar, C5517j<C2921a<C5640y>> consumer) {
            this.f22519a = amVar;
            super(consumer);
        }

        /* renamed from: a */
        protected void m19219a(C2952d newResult, boolean isLast) {
            C2921a<C5640y> ret = null;
            try {
                if (C2952d.e(newResult)) {
                    ret = newResult.c();
                }
                m19142d().mo4087b(ret, isLast);
            } finally {
                C2921a.c(ret);
            }
        }
    }

    public am(ai<C2952d> inputProducer) {
        this.f22520a = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5640y>> consumer, aj context) {
        this.f22520a.mo4122a(new C5560a(consumer), context);
    }
}
