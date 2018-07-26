package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.w */
final class C6173w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f25143a;
    /* renamed from: b */
    final /* synthetic */ Context f25144b;
    /* renamed from: c */
    final /* synthetic */ C6161k f25145c;

    C6173w(String str, Context context, C6161k c6161k) {
        this.f25143a = str;
        this.f25144b = context;
        this.f25145c = c6161k;
    }

    public final void run() {
        if (this.f25143a == null || this.f25143a.trim().length() == 0) {
            C6160j.f25104q.m21830f("qq num is null or empty.");
            return;
        }
        C6156f.f25055f = this.f25143a;
        C6160j.m22123c(this.f25144b, new C6154d(this.f25143a), this.f25145c);
    }
}
