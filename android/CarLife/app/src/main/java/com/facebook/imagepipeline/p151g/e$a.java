package com.facebook.imagepipeline.p151g;

import com.facebook.common.p140h.C2921a;
import com.facebook.p138c.C2918d;
import com.facebook.p138c.C5287f;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: ListDataSource */
/* renamed from: com.facebook.imagepipeline.g.e$a */
class e$a implements C5287f<C2921a<T>> {
    @GuardedBy("InternalDataSubscriber.this")
    /* renamed from: a */
    boolean f22430a;
    /* renamed from: b */
    final /* synthetic */ C2950e f22431b;

    private e$a(C2950e c2950e) {
        this.f22431b = c2950e;
        this.f22430a = false;
    }

    /* renamed from: a */
    private synchronized boolean m19019a() {
        boolean z = true;
        synchronized (this) {
            if (this.f22430a) {
                z = false;
            } else {
                this.f22430a = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public void mo3984b(C2918d<C2921a<T>> dataSource) {
        C2950e.a(this.f22431b, dataSource);
    }

    /* renamed from: c */
    public void mo3985c(C2918d<C2921a<T>> c2918d) {
        C2950e.a(this.f22431b);
    }

    public void a_(C2918d<C2921a<T>> dataSource) {
        if (dataSource.b() && m19019a()) {
            C2950e.b(this.f22431b);
        }
    }

    /* renamed from: d */
    public void mo3986d(C2918d<C2921a<T>> c2918d) {
        C2950e.c(this.f22431b);
    }
}
