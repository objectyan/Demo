package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6123d;

final class bd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24972a;
    /* renamed from: b */
    final /* synthetic */ Context f24973b;
    /* renamed from: c */
    final /* synthetic */ C6161k f24974c;

    bd(String str, Context context, C6161k c6161k) {
        this.f24972a = str;
        this.f24973b = context;
        this.f24974c = c6161k;
    }

    public final void run() {
        try {
            if (C6160j.m22111a(this.f24972a)) {
                C6160j.f25104q.m21831g("Error message in StatService.reportError() is empty.");
            } else {
                new ac(new C6123d(this.f24973b, C6160j.m22090a(this.f24973b, false, this.f24974c), this.f24972a, 0, C6156f.m22048x(), null, this.f24974c)).m21751a();
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24973b, th);
        }
    }
}
