package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.x */
final class C6174x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C6154d f25146a;
    /* renamed from: b */
    final /* synthetic */ Context f25147b;
    /* renamed from: c */
    final /* synthetic */ C6161k f25148c;

    C6174x(C6154d c6154d, Context context, C6161k c6161k) {
        this.f25146a = c6154d;
        this.f25147b = context;
        this.f25148c = c6161k;
    }

    public final void run() {
        if (this.f25146a == null || this.f25146a.m21945b().trim().length() == 0) {
            C6160j.f25104q.m21830f("account is null or empty.");
            return;
        }
        C6156f.m22007d(this.f25147b, this.f25146a.m21945b());
        C6160j.m22123c(this.f25147b, this.f25146a, this.f25148c);
    }
}
