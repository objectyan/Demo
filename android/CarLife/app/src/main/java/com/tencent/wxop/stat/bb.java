package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p291b.C6144m;

final class bb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24970a;

    bb(Context context) {
        this.f24970a = context;
    }

    public final void run() {
        if (this.f24970a == null) {
            C6160j.f25104q.m21831g("The Context of StatService.onStop() can not be null!");
            return;
        }
        C6160j.m22143i(this.f24970a);
        if (!C6160j.m22109a()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (C6144m.m21857B(this.f24970a)) {
                if (C6156f.m21997b()) {
                    C6160j.f25104q.m21825b((Object) "onStop isBackgroundRunning flushDataToDB");
                }
                C6160j.m22094a(this.f24970a, -1);
            }
        }
    }
}
