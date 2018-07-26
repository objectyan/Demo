package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;

class cb extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ Context f19549a;
    /* renamed from: b */
    final /* synthetic */ by f19550b;

    cb(by byVar, Context context) {
        this.f19550b = byVar;
        this.f19549a = context;
    }

    public void run() {
        if (!DataCore.instance().isPartEmpty()) {
            this.f19550b.m15536c(this.f19549a);
        }
    }
}
