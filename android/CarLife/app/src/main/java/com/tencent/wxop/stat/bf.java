package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6123d;

final class bf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Throwable f24977a;
    /* renamed from: b */
    final /* synthetic */ Context f24978b;
    /* renamed from: c */
    final /* synthetic */ C6161k f24979c;

    bf(Throwable th, Context context, C6161k c6161k) {
        this.f24977a = th;
        this.f24978b = context;
        this.f24979c = c6161k;
    }

    public final void run() {
        if (this.f24977a == null) {
            C6160j.f25104q.m21831g("The Throwable error message of StatService.reportException() can not be null!");
        } else {
            new ac(new C6123d(this.f24978b, C6160j.m22090a(this.f24978b, false, this.f24979c), 1, this.f24977a, this.f24979c)).m21751a();
        }
    }
}
