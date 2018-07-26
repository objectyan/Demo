package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.C2957e;
import com.facebook.imagepipeline.p154m.C5615f;
import com.facebook.imagepipeline.p275c.C5456e;
import java.util.concurrent.Executor;

/* compiled from: PostprocessorProducer */
/* renamed from: com.facebook.imagepipeline.l.ah */
public class ah implements ai<C2921a<C5534b>> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22514a = "PostprocessorProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22515b = "Postprocessor";
    /* renamed from: c */
    private final ai<C2921a<C5534b>> f22516c;
    /* renamed from: d */
    private final C5456e f22517d;
    /* renamed from: e */
    private final Executor f22518e;

    /* compiled from: PostprocessorProducer */
    /* renamed from: com.facebook.imagepipeline.l.ah$c */
    class C5558c extends C5549m<C2921a<C5534b>, C2921a<C5534b>> {
        /* renamed from: a */
        final /* synthetic */ ah f22513a;

        private C5558c(ah this$0, ah$a postprocessorConsumer) {
            this.f22513a = this$0;
            super(postprocessorConsumer);
        }

        /* renamed from: a */
        protected void m19205a(C2921a<C5534b> newResult, boolean isLast) {
            if (isLast) {
                m19142d().mo4087b(newResult, isLast);
            }
        }
    }

    public ah(ai<C2921a<C5534b>> inputProducer, C5456e platformBitmapFactory, Executor executor) {
        this.f22516c = (ai) C5350k.m18310a((Object) inputProducer);
        this.f22517d = platformBitmapFactory;
        this.f22518e = (Executor) C5350k.m18310a((Object) executor);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5534b>> consumer, aj context) {
        C5517j<C2921a<C5534b>> postprocessorConsumer;
        al listener = context.m19213c();
        C2957e postprocessor = context.m19210a().n();
        ah$a basePostprocessorConsumer = new ah$a(this, consumer, listener, context.m19212b(), postprocessor, context);
        if (postprocessor instanceof C5615f) {
            postprocessorConsumer = new ah$b(this, basePostprocessorConsumer, (C5615f) postprocessor, context, null);
        } else {
            postprocessorConsumer = new C5558c(basePostprocessorConsumer);
        }
        this.f22516c.mo4122a(postprocessorConsumer, context);
    }
}
