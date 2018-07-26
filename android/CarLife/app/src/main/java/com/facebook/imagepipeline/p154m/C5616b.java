package com.facebook.imagepipeline.p154m;

/* compiled from: BaseRepeatedPostProcessor */
/* renamed from: com.facebook.imagepipeline.m.b */
public abstract class C5616b extends C2958a implements C5615f {
    /* renamed from: a */
    private C5617g f22711a;

    /* renamed from: a */
    public synchronized void mo4143a(C5617g runner) {
        this.f22711a = runner;
    }

    /* renamed from: d */
    private synchronized C5617g m19437d() {
        return this.f22711a;
    }

    /* renamed from: c */
    public void m19439c() {
        C5617g callback = m19437d();
        if (callback != null) {
            callback.m19442c();
        }
    }
}
