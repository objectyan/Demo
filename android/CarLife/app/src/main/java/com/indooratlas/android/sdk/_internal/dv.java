package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;

public final class dv {
    @NonNull
    /* renamed from: a */
    final cy f23474a;
    @NonNull
    /* renamed from: b */
    final cw f23475b;
    @NonNull
    /* renamed from: c */
    final da f23476c;

    /* renamed from: com.indooratlas.android.sdk._internal.dv$2 */
    class C58592 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ dv f23472a;

        C58592(dv dvVar) {
            this.f23472a = dvVar;
        }

        public final void run() {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.dv$3 */
    class C58603 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ dv f23473a;

        C58603(dv dvVar) {
            this.f23473a = dvVar;
        }

        public final void run() {
        }
    }

    public dv(@NonNull cy cyVar, @NonNull cw cwVar, @NonNull da daVar) {
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        eg.m20413a((Object) cwVar, "listener cannot be null", new Object[0]);
        eg.m20413a((Object) daVar, "listener cannot be null", new Object[0]);
        this.f23474a = cyVar;
        this.f23475b = cwVar;
        this.f23476c = daVar;
    }

    /* renamed from: a */
    public final void m20363a(final cx cxVar) {
        eg.m20413a((Object) cxVar, "event must not be null", new Object[0]);
        if (this.f23476c.f23372a != null) {
            String str = cz.f23362a;
            Object[] objArr = new Object[]{cxVar, this.f23476c.f23372a};
            this.f23476c.f23372a.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ dv f23471b;

                public final void run() {
                    this.f23471b.f23474a.mo4657a(cxVar);
                }
            });
            return;
        }
        str = cz.f23362a;
        new Object[1][0] = cxVar;
        this.f23474a.mo4657a(cxVar);
    }

    /* renamed from: a */
    public final void m20362a() {
        if (this.f23476c.f23372a != null) {
            this.f23476c.f23372a.post(new C58592(this));
        }
    }

    /* renamed from: b */
    public final void m20364b() {
        if (this.f23476c.f23372a != null) {
            this.f23476c.f23372a.post(new C58603(this));
        }
    }
}
