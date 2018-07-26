package com.facebook.imagepipeline.p153l;

import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.C5615f;
import com.facebook.imagepipeline.p154m.C5617g;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: PostprocessorProducer */
/* renamed from: com.facebook.imagepipeline.l.ah$b */
class ah$b extends C5549m<C2921a<C5534b>, C2921a<C5534b>> implements C5617g {
    /* renamed from: a */
    final /* synthetic */ ah f13163a;
    @GuardedBy("RepeatedPostprocessorConsumer.this")
    /* renamed from: b */
    private boolean f13164b;
    @GuardedBy("RepeatedPostprocessorConsumer.this")
    @Nullable
    /* renamed from: c */
    private C2921a<C5534b> f13165c;

    private ah$b(ah this$0, ah$a postprocessorConsumer, C5615f repeatedPostprocessor, aj context) {
        this.f13163a = this$0;
        super(postprocessorConsumer);
        this.f13164b = false;
        this.f13165c = null;
        repeatedPostprocessor.a(this);
        context.a(new ah$b$1(this, this$0));
    }

    /* renamed from: a */
    protected void m11870a(C2921a<C5534b> newResult, boolean isLast) {
        if (isLast) {
            m11865a((C2921a) newResult);
            m11867e();
        }
    }

    /* renamed from: a */
    protected void m11872a(Throwable throwable) {
        if (m11868f()) {
            d().b(throwable);
        }
    }

    /* renamed from: a */
    protected void m11869a() {
        if (m11868f()) {
            d().b();
        }
    }

    /* renamed from: c */
    public synchronized void m11873c() {
        m11867e();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private void m11867e() {
        /*
        r3 = this;
        monitor-enter(r3);
        r1 = r3.f13164b;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
    L_0x0006:
        return;
    L_0x0007:
        r1 = r3.f13165c;	 Catch:{ all -> 0x001a }
        r0 = com.facebook.common.p140h.C2921a.m11258b(r1);	 Catch:{ all -> 0x001a }
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        r1 = r3.d();	 Catch:{ all -> 0x001d }
        r2 = 0;
        r1.b(r0, r2);	 Catch:{ all -> 0x001d }
        com.facebook.common.p140h.C2921a.m11259c(r0);
        goto L_0x0006;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        throw r1;
    L_0x001d:
        r1 = move-exception;
        com.facebook.common.p140h.C2921a.m11259c(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ah$b.e():void");
    }

    /* renamed from: a */
    private void m11865a(C2921a<C5534b> sourceImageRef) {
        synchronized (this) {
            if (this.f13164b) {
                return;
            }
            C2921a<C5534b> oldSourceImageRef = this.f13165c;
            this.f13165c = C2921a.m11258b(sourceImageRef);
            C2921a.m11259c(oldSourceImageRef);
        }
    }

    /* renamed from: f */
    private boolean m11868f() {
        boolean z = true;
        synchronized (this) {
            if (this.f13164b) {
                z = false;
            } else {
                C2921a<C5534b> oldSourceImageRef = this.f13165c;
                this.f13165c = null;
                this.f13164b = true;
                C2921a.m11259c(oldSourceImageRef);
            }
        }
        return z;
    }
}
