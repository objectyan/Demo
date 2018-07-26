package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6123d;
import com.tencent.wxop.stat.p290a.C6127i;

final class be implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24975a;
    /* renamed from: b */
    final /* synthetic */ Throwable f24976b;

    be(Context context, Throwable th) {
        this.f24975a = context;
        this.f24976b = th;
    }

    public final void run() {
        try {
            if (C6156f.m22003c()) {
                new ac(new C6123d(this.f24975a, C6160j.m22090a(this.f24975a, false, null), 99, this.f24976b, C6127i.f24789a)).m21751a();
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21832h("reportSdkSelfException error: " + th);
        }
    }
}
