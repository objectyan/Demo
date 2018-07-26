package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p291b.C6144m;

final class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24968a;
    /* renamed from: b */
    final /* synthetic */ C6161k f24969b;

    ba(Context context, C6161k c6161k) {
        this.f24968a = context;
        this.f24969b = c6161k;
    }

    public final void run() {
        if (this.f24968a == null) {
            C6160j.f25104q.m21831g("The Context of StatService.onPause() can not be null!");
        } else {
            C6160j.m22117b(this.f24968a, C6144m.m21886h(this.f24968a), this.f24969b);
        }
    }
}
