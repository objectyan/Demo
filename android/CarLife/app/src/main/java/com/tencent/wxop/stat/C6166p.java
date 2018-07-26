package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.p */
final class C6166p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25129a;
    /* renamed from: b */
    final /* synthetic */ int f25130b;

    C6166p(Context context, int i) {
        this.f25129a = context;
        this.f25130b = i;
    }

    public final void run() {
        try {
            C6160j.m22143i(this.f25129a);
            ag.m21760a(this.f25129a).m21788a(this.f25130b);
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25129a, th);
        }
    }
}
