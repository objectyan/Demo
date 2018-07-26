package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.q */
final class C6167q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25131a;

    C6167q(Context context) {
        this.f25131a = context;
    }

    public final void run() {
        try {
            new Thread(new ab(this.f25131a, null, null), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25131a, th);
        }
    }
}
