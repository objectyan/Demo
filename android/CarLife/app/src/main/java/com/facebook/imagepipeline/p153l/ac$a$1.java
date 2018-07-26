package com.facebook.imagepipeline.p153l;

import android.util.Pair;
import java.util.List;

/* compiled from: MultiplexProducer */
/* renamed from: com.facebook.imagepipeline.l.ac$a$1 */
class ac$a$1 extends C5450e {
    /* renamed from: a */
    final /* synthetic */ Pair f22493a;
    /* renamed from: b */
    final /* synthetic */ ac$a f22494b;

    ac$a$1(ac$a this$1, Pair pair) {
        this.f22494b = this$1;
        this.f22493a = pair;
    }

    /* renamed from: a */
    public void mo4052a() {
        C2954d contextToCancel = null;
        List<ak> isPrefetchCallbacks = null;
        List<ak> priorityCallbacks = null;
        List<ak> isIntermediateResultExpectedCallbacks = null;
        synchronized (this.f22494b) {
            boolean pairWasRemoved = ac$a.b(this.f22494b).remove(this.f22493a);
            if (pairWasRemoved) {
                if (ac$a.b(this.f22494b).isEmpty()) {
                    contextToCancel = ac$a.c(this.f22494b);
                } else {
                    isPrefetchCallbacks = ac$a.d(this.f22494b);
                    priorityCallbacks = ac$a.e(this.f22494b);
                    isIntermediateResultExpectedCallbacks = ac$a.f(this.f22494b);
                }
            }
        }
        C2954d.b(isPrefetchCallbacks);
        C2954d.d(priorityCallbacks);
        C2954d.c(isIntermediateResultExpectedCallbacks);
        if (contextToCancel != null) {
            contextToCancel.j();
        }
        if (pairWasRemoved) {
            ((C5517j) this.f22493a.first).mo4085b();
        }
    }

    /* renamed from: b */
    public void mo4053b() {
        C2954d.b(ac$a.d(this.f22494b));
    }

    /* renamed from: c */
    public void mo4054c() {
        C2954d.c(ac$a.f(this.f22494b));
    }

    /* renamed from: d */
    public void mo4055d() {
        C2954d.d(ac$a.e(this.f22494b));
    }
}
