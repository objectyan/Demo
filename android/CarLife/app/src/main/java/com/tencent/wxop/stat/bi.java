package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6121b;
import com.tencent.wxop.stat.p290a.C6122c;

final class bi implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24983a;
    /* renamed from: b */
    final /* synthetic */ C6161k f24984b;
    /* renamed from: c */
    final /* synthetic */ C6122c f24985c;

    bi(Context context, C6161k c6161k, C6122c c6122c) {
        this.f24983a = context;
        this.f24984b = c6161k;
        this.f24985c = c6122c;
    }

    public final void run() {
        try {
            C6119e c6121b = new C6121b(this.f24983a, C6160j.m22090a(this.f24983a, false, this.f24984b), this.f24985c.f24767a, this.f24984b);
            c6121b.m21724b().f24769c = this.f24985c.f24769c;
            new ac(c6121b).m21751a();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24983a, th);
        }
    }
}
