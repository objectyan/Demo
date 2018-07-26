package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6121b;
import com.tencent.wxop.stat.p290a.C6122c;

/* renamed from: com.tencent.wxop.stat.o */
final class C6165o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25125a;
    /* renamed from: b */
    final /* synthetic */ C6161k f25126b;
    /* renamed from: c */
    final /* synthetic */ C6122c f25127c;
    /* renamed from: d */
    final /* synthetic */ int f25128d;

    C6165o(Context context, C6161k c6161k, C6122c c6122c, int i) {
        this.f25125a = context;
        this.f25126b = c6161k;
        this.f25127c = c6122c;
        this.f25128d = i;
    }

    public final void run() {
        try {
            C6119e c6121b = new C6121b(this.f25125a, C6160j.m22090a(this.f25125a, false, this.f25126b), this.f25127c.f24767a, this.f25126b);
            c6121b.m21724b().f24769c = this.f25127c.f24769c;
            Long valueOf = Long.valueOf((long) this.f25128d);
            c6121b.m21722a(Long.valueOf(valueOf.longValue() <= 0 ? 1 : valueOf.longValue()).longValue());
            new ac(c6121b).m21751a();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25125a, th);
        }
    }
}
