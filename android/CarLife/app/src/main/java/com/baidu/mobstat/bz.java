package com.baidu.mobstat;

import android.content.Context;

class bz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19546a;
    /* renamed from: b */
    final /* synthetic */ by f19547b;

    bz(by byVar, Context context) {
        this.f19547b = byVar;
        this.f19546a = context;
    }

    public void run() {
        if (this.f19547b.f19544f != null) {
            this.f19547b.f19544f.cancel();
            this.f19547b.f19544f = null;
        }
        this.f19547b.f19543e = SendStrategyEnum.values()[bj.m15464a().m15469b(this.f19546a)];
        this.f19547b.f19542d = bj.m15464a().m15473c(this.f19546a);
        this.f19547b.f19540b = bj.m15464a().m15478d(this.f19546a);
        if (this.f19547b.f19543e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.f19547b.m15544b(this.f19546a);
        } else if (this.f19547b.f19543e.equals(SendStrategyEnum.ONCE_A_DAY)) {
            this.f19547b.m15544b(this.f19546a);
        }
        this.f19547b.f19545g.postDelayed(new ca(this), (long) (this.f19547b.f19541c * 1000));
    }
}
