package com.facebook.imagepipeline.p153l;

import com.facebook.common.p256c.C5312h;
import java.util.Map;

/* compiled from: StatefulProducerRunnable */
/* renamed from: com.facebook.imagepipeline.l.ap */
public abstract class ap<T> extends C5312h<T> {
    /* renamed from: g */
    private final C5517j<T> f22482g;
    /* renamed from: h */
    private final al f22483h;
    /* renamed from: i */
    private final String f22484i;
    /* renamed from: j */
    private final String f22485j;

    /* renamed from: b */
    protected abstract void mo4128b(T t);

    public ap(C5517j<T> consumer, al producerListener, String producerName, String requestId) {
        this.f22482g = consumer;
        this.f22483h = producerListener;
        this.f22484i = producerName;
        this.f22485j = requestId;
        this.f22483h.mo4111a(this.f22485j, this.f22484i);
    }

    /* renamed from: a */
    protected void mo4126a(T result) {
        this.f22483h.mo4114a(this.f22485j, this.f22484i, this.f22483h.mo4116b(this.f22485j) ? mo4130c(result) : null);
        this.f22482g.mo4087b(result, true);
    }

    /* renamed from: a */
    protected void mo4125a(Exception e) {
        this.f22483h.mo4113a(this.f22485j, this.f22484i, e, this.f22483h.mo4116b(this.f22485j) ? m19159b(e) : null);
        this.f22482g.mo4088b((Throwable) e);
    }

    /* renamed from: b */
    protected void mo4127b() {
        this.f22483h.mo4115b(this.f22485j, this.f22484i, this.f22483h.mo4116b(this.f22485j) ? m19163e() : null);
        this.f22482g.mo4085b();
    }

    /* renamed from: c */
    protected Map<String, String> mo4130c(T t) {
        return null;
    }

    /* renamed from: b */
    protected Map<String, String> m19159b(Exception exception) {
        return null;
    }

    /* renamed from: e */
    protected Map<String, String> m19163e() {
        return null;
    }
}
