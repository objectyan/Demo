package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p291b.C6144m;

/* renamed from: com.tencent.wxop.stat.v */
final class C6172v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25141a;
    /* renamed from: b */
    final /* synthetic */ C6161k f25142b;

    C6172v(Context context, C6161k c6161k) {
        this.f25141a = context;
        this.f25142b = c6161k;
    }

    public final void run() {
        if (this.f25141a == null) {
            C6160j.f25104q.m21831g("The Context of StatService.onResume() can not be null!");
        } else {
            C6160j.m22100a(this.f25141a, C6144m.m21886h(this.f25141a), this.f25142b);
        }
    }
}
