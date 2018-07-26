package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p291b.C6144m;
import java.util.TimerTask;

class as extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ ar f24856a;

    as(ar arVar) {
        this.f24856a = arVar;
    }

    public void run() {
        if (C6156f.m21997b()) {
            C6144m.m21872b().m21825b((Object) "TimerTask run");
        }
        C6160j.m22145j(this.f24856a.f24855c);
        cancel();
        this.f24856a.m21802a();
    }
}
