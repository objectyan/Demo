package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: ThreadHandoffProducer */
/* renamed from: com.facebook.imagepipeline.l.ar */
public class ar<T> implements ai<T> {
    @VisibleForTesting
    /* renamed from: a */
    protected static final String f22550a = "BackgroundThreadHandoffProducer";
    /* renamed from: b */
    private final ai<T> f22551b;
    /* renamed from: c */
    private final as f22552c;

    public ar(ai<T> inputProducer, as inputThreadHandoffProducerQueue) {
        this.f22551b = (ai) C5350k.m18310a((Object) inputProducer);
        this.f22552c = inputThreadHandoffProducerQueue;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<T> consumer, aj context) {
        al producerListener = context.m19213c();
        String requestId = context.m19212b();
        final al alVar = producerListener;
        final String str = requestId;
        final C5517j<T> c5517j = consumer;
        final aj ajVar = context;
        final ap<T> statefulRunnable = new ap<T>(this, consumer, producerListener, f22550a, requestId) {
            /* renamed from: k */
            final /* synthetic */ ar f22547k;

            /* renamed from: a */
            protected void mo4126a(T t) {
                alVar.mo4114a(str, ar.f22550a, null);
                this.f22547k.f22551b.mo4122a(c5517j, ajVar);
            }

            /* renamed from: b */
            protected void mo4128b(T t) {
            }

            /* renamed from: c */
            protected T mo4129c() throws Exception {
                return null;
            }
        };
        context.m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ ar f22549b;

            /* renamed from: a */
            public void mo4052a() {
                statefulRunnable.m18106a();
                this.f22549b.f22552c.m19262b(statefulRunnable);
            }
        });
        this.f22552c.m19260a(statefulRunnable);
    }
}
