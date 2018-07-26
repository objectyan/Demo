package com.facebook.imagepipeline.p153l;

/* compiled from: DelegatingConsumer */
/* renamed from: com.facebook.imagepipeline.l.m */
public abstract class C5549m<I, O> extends C5518b<I> {
    /* renamed from: a */
    private final C5517j<O> f22475a;

    public C5549m(C5517j<O> consumer) {
        this.f22475a = consumer;
    }

    /* renamed from: d */
    public C5517j<O> m19142d() {
        return this.f22475a;
    }

    /* renamed from: a */
    protected void mo4092a(Throwable t) {
        this.f22475a.mo4088b(t);
    }

    /* renamed from: a */
    protected void mo4089a() {
        this.f22475a.mo4085b();
    }

    /* renamed from: a */
    protected void mo4090a(float progress) {
        this.f22475a.mo4086b(progress);
    }
}
