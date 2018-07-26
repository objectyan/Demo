package com.facebook.imagepipeline.p153l;

import android.graphics.Bitmap;
import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5536c;
import com.facebook.imagepipeline.p154m.C2957e;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: PostprocessorProducer */
/* renamed from: com.facebook.imagepipeline.l.ah$a */
class ah$a extends C5549m<C2921a<C5534b>, C2921a<C5534b>> {
    /* renamed from: a */
    final /* synthetic */ ah f13154a;
    /* renamed from: b */
    private final al f13155b;
    /* renamed from: c */
    private final String f13156c;
    /* renamed from: d */
    private final C2957e f13157d;
    @GuardedBy("PostprocessorConsumer.this")
    /* renamed from: e */
    private boolean f13158e;
    @GuardedBy("PostprocessorConsumer.this")
    @Nullable
    /* renamed from: f */
    private C2921a<C5534b> f13159f = null;
    @GuardedBy("PostprocessorConsumer.this")
    /* renamed from: g */
    private boolean f13160g = false;
    @GuardedBy("PostprocessorConsumer.this")
    /* renamed from: h */
    private boolean f13161h = false;
    @GuardedBy("PostprocessorConsumer.this")
    /* renamed from: i */
    private boolean f13162i = false;

    public ah$a(ah ahVar, C5517j<C2921a<C5534b>> consumer, al listener, String requestId, C2957e postprocessor, aj producerContext) {
        this.f13154a = ahVar;
        super(consumer);
        this.f13155b = listener;
        this.f13156c = requestId;
        this.f13157d = postprocessor;
        producerContext.a(new ah$a$1(this, ahVar));
    }

    /* renamed from: a */
    protected void m11862a(C2921a<C5534b> newResult, boolean isLast) {
        if (C2921a.m11257a((C2921a) newResult)) {
            m11849b(newResult, isLast);
        } else if (isLast) {
            m11854d(null, true);
        }
    }

    /* renamed from: a */
    protected void m11864a(Throwable t) {
        m11852c(t);
    }

    /* renamed from: a */
    protected void m11861a() {
        m11858g();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m11849b(@javax.annotation.Nullable com.facebook.common.p140h.C2921a<com.facebook.imagepipeline.p152i.C5534b> r4, boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r2 = r3.f13158e;	 Catch:{ all -> 0x0022 }
        if (r2 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = r3.f13159f;	 Catch:{ all -> 0x0022 }
        r2 = com.facebook.common.p140h.C2921a.m11258b(r4);	 Catch:{ all -> 0x0022 }
        r3.f13159f = r2;	 Catch:{ all -> 0x0022 }
        r3.f13160g = r5;	 Catch:{ all -> 0x0022 }
        r2 = 1;
        r3.f13161h = r2;	 Catch:{ all -> 0x0022 }
        r1 = r3.m11857f();	 Catch:{ all -> 0x0022 }
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        com.facebook.common.p140h.C2921a.m11259c(r0);
        if (r1 == 0) goto L_0x0006;
    L_0x001e:
        r3.m11850c();
        goto L_0x0006;
    L_0x0022:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ah$a.b(com.facebook.common.h.a, boolean):void");
    }

    /* renamed from: c */
    private void m11850c() {
        ah.a(this.f13154a).execute(new ah$a$2(this));
    }

    /* renamed from: e */
    private void m11856e() {
        synchronized (this) {
            this.f13162i = false;
            boolean shouldExecuteAgain = m11857f();
        }
        if (shouldExecuteAgain) {
            m11850c();
        }
    }

    /* renamed from: f */
    private synchronized boolean m11857f() {
        boolean z = true;
        synchronized (this) {
            if (this.f13158e || !this.f13161h || this.f13162i || !C2921a.m11257a(this.f13159f)) {
                z = false;
            } else {
                this.f13162i = true;
            }
        }
        return z;
    }

    /* renamed from: c */
    private void m11851c(C2921a<C5534b> sourceImageRef, boolean isLast) {
        C5350k.a(C2921a.m11257a((C2921a) sourceImageRef));
        if (m11845a((C5534b) sourceImageRef.m11260a())) {
            this.f13155b.a(this.f13156c, "PostprocessorProducer");
            C2921a<C5534b> destImageRef = null;
            try {
                destImageRef = m11847b((C5534b) sourceImageRef.m11260a());
                this.f13155b.a(this.f13156c, "PostprocessorProducer", m11842a(this.f13155b, this.f13156c, this.f13157d));
                m11854d(destImageRef, isLast);
            } catch (Throwable e) {
                this.f13155b.a(this.f13156c, "PostprocessorProducer", e, m11842a(this.f13155b, this.f13156c, this.f13157d));
                m11852c(e);
            } finally {
                C2921a.m11259c(destImageRef);
            }
        } else {
            m11854d(sourceImageRef, isLast);
        }
    }

    /* renamed from: a */
    private Map<String, String> m11842a(al listener, String requestId, C2957e postprocessor) {
        if (listener.b(requestId)) {
            return C5346g.a("Postprocessor", postprocessor.mo2051a());
        }
        return null;
    }

    /* renamed from: a */
    private boolean m11845a(C5534b sourceImage) {
        return sourceImage instanceof C5536c;
    }

    /* renamed from: b */
    private C2921a<C5534b> m11847b(C5534b sourceImage) {
        C5536c staticBitmap = (C5536c) sourceImage;
        C2921a<Bitmap> bitmapRef = this.f13157d.mo2050a(staticBitmap.a(), ah.b(this.f13154a));
        try {
            C2921a<C5534b> a = C2921a.m11253a(new C5536c(bitmapRef, sourceImage.d(), staticBitmap.i()));
            return a;
        } finally {
            C2921a.m11259c(bitmapRef);
        }
    }

    /* renamed from: d */
    private void m11854d(C2921a<C5534b> newRef, boolean isLast) {
        if ((!isLast && !m11859h()) || (isLast && m11860i())) {
            d().b(newRef, isLast);
        }
    }

    /* renamed from: c */
    private void m11852c(Throwable throwable) {
        if (m11860i()) {
            d().b(throwable);
        }
    }

    /* renamed from: g */
    private void m11858g() {
        if (m11860i()) {
            d().b();
        }
    }

    /* renamed from: h */
    private synchronized boolean m11859h() {
        return this.f13158e;
    }

    /* renamed from: i */
    private boolean m11860i() {
        boolean z = true;
        synchronized (this) {
            if (this.f13158e) {
                z = false;
            } else {
                C2921a<C5534b> oldSourceImageRef = this.f13159f;
                this.f13159f = null;
                this.f13158e = true;
                C2921a.m11259c(oldSourceImageRef);
            }
        }
        return z;
    }
}
