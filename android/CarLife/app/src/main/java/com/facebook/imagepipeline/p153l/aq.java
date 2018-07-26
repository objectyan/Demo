package com.facebook.imagepipeline.p153l;

/* compiled from: SwallowResultProducer */
/* renamed from: com.facebook.imagepipeline.l.aq */
public class aq<T> implements ai<Void> {
    /* renamed from: a */
    private final ai<T> f22542a;

    public aq(ai<T> inputProducer) {
        this.f22542a = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<Void> consumer, aj producerContext) {
        this.f22542a.mo4122a(new C5549m<T, Void>(this, consumer) {
            /* renamed from: a */
            final /* synthetic */ aq f22541a;

            /* renamed from: a */
            protected void mo4091a(T t, boolean isLast) {
                if (isLast) {
                    m19142d().mo4087b(null, isLast);
                }
            }
        }, producerContext);
    }
}
