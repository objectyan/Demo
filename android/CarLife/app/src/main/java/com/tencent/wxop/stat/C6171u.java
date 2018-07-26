package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.u */
final class C6171u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25139a;
    /* renamed from: b */
    final /* synthetic */ C6161k f25140b;

    C6171u(Context context, C6161k c6161k) {
        this.f25139a = context;
        this.f25140b = c6161k;
    }

    public final void run() {
        try {
            C6160j.m22121c();
            C6160j.m22090a(this.f25139a, true, this.f25140b);
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25139a, th);
        }
    }
}
