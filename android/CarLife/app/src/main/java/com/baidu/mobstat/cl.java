package com.baidu.mobstat;

import android.content.Context;

class cl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19590a;
    /* renamed from: b */
    final /* synthetic */ ch f19591b;

    cl(ch chVar, Context context) {
        this.f19591b = chVar;
        this.f19590a = context;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f19591b.f19575f > 0 && currentTimeMillis - this.f19591b.f19575f > ((long) this.f19591b.m15601c())) {
            this.f19591b.m15572a(this.f19590a, false);
        }
    }
}
