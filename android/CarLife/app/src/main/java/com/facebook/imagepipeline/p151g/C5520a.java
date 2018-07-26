package com.facebook.imagepipeline.p151g;

import com.facebook.common.internal.C5350k;
import com.facebook.imagepipeline.p153l.C5517j;
import com.facebook.imagepipeline.p153l.C5518b;
import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.ao;
import com.facebook.imagepipeline.p278j.C5539c;
import com.facebook.p138c.C2919a;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: AbstractProducerToDataSourceAdapter */
/* renamed from: com.facebook.imagepipeline.g.a */
public abstract class C5520a<T> extends C2919a<T> {
    /* renamed from: a */
    private final ao f22428a;
    /* renamed from: b */
    private final C5539c f22429b;

    /* compiled from: AbstractProducerToDataSourceAdapter */
    /* renamed from: com.facebook.imagepipeline.g.a$1 */
    class C55191 extends C5518b<T> {
        /* renamed from: a */
        final /* synthetic */ C5520a f22427a;

        C55191(C5520a this$0) {
            this.f22427a = this$0;
        }

        /* renamed from: a */
        protected void mo4091a(@Nullable T newResult, boolean isLast) {
            this.f22427a.m19013b(newResult, isLast);
        }

        /* renamed from: a */
        protected void mo4092a(Throwable throwable) {
            this.f22427a.m19010b(throwable);
        }

        /* renamed from: a */
        protected void mo4089a() {
            this.f22427a.m19012k();
        }

        /* renamed from: a */
        protected void mo4090a(float progress) {
            this.f22427a.a(progress);
        }
    }

    protected C5520a(ai<T> producer, ao settableProducerContext, C5539c requestListener) {
        this.f22428a = settableProducerContext;
        this.f22429b = requestListener;
        this.f22429b.mo4107a(settableProducerContext.a(), this.f22428a.d(), this.f22428a.b(), this.f22428a.f());
        producer.mo4122a(m19011j(), settableProducerContext);
    }

    /* renamed from: j */
    private C5517j<T> m19011j() {
        return new C55191(this);
    }

    /* renamed from: b */
    protected void m19013b(@Nullable T result, boolean isLast) {
        if (super.a(result, isLast) && isLast) {
            this.f22429b.mo4109a(this.f22428a.a(), this.f22428a.b(), this.f22428a.f());
        }
    }

    /* renamed from: b */
    private void m19010b(Throwable throwable) {
        if (super.a(throwable)) {
            this.f22429b.mo4108a(this.f22428a.a(), this.f22428a.b(), throwable, this.f22428a.f());
        }
    }

    /* renamed from: k */
    private synchronized void m19012k() {
        C5350k.m18321b(a());
    }

    /* renamed from: h */
    public boolean m19014h() {
        if (!super.h()) {
            return false;
        }
        if (!super.b()) {
            this.f22429b.mo4110a(this.f22428a.b());
            this.f22428a.j();
        }
        return true;
    }
}
