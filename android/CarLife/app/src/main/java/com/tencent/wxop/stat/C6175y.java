package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6125g;

/* renamed from: com.tencent.wxop.stat.y */
final class C6175y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C6157g f25149a;
    /* renamed from: b */
    final /* synthetic */ Context f25150b;
    /* renamed from: c */
    final /* synthetic */ C6161k f25151c;

    C6175y(C6157g c6157g, Context context, C6161k c6161k) {
        this.f25149a = c6157g;
        this.f25150b = context;
        this.f25151c = c6161k;
    }

    public final void run() {
        if (this.f25149a == null) {
            C6160j.f25104q.m21831g("The gameUser of StatService.reportGameUser() can not be null!");
        } else if (this.f25149a.m22053b() == null || this.f25149a.m22053b().length() == 0) {
            C6160j.f25104q.m21831g("The account of gameUser on StatService.reportGameUser() can not be null or empty!");
        } else {
            try {
                new ac(new C6125g(this.f25150b, C6160j.m22090a(this.f25150b, false, this.f25151c), this.f25149a, this.f25151c)).m21751a();
            } catch (Throwable th) {
                C6160j.f25104q.m21826b(th);
                C6160j.m22104a(this.f25150b, th);
            }
        }
    }
}
