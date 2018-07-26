package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6126h;

/* renamed from: com.tencent.wxop.stat.m */
final class C6163m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25122a;
    /* renamed from: b */
    final /* synthetic */ C6161k f25123b;
    /* renamed from: c */
    final /* synthetic */ C6155e f25124c;

    C6163m(Context context, C6161k c6161k, C6155e c6155e) {
        this.f25122a = context;
        this.f25123b = c6161k;
        this.f25124c = c6155e;
    }

    public final void run() {
        try {
            new ac(new C6126h(this.f25122a, C6160j.m22090a(this.f25122a, false, this.f25123b), this.f25124c, this.f25123b)).m21751a();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25122a, th);
        }
    }
}
