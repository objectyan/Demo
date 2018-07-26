package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.z */
final class C6176z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25152a;
    /* renamed from: b */
    final /* synthetic */ C6161k f25153b;

    C6176z(Context context, C6161k c6161k) {
        this.f25152a = context;
        this.f25153b = c6161k;
    }

    public final void run() {
        try {
            C6160j.m22090a(this.f25152a, false, this.f25153b);
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
        }
    }
}
