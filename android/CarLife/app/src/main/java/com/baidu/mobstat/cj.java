package com.baidu.mobstat;

import android.content.Context;

class cj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f19586a;
    /* renamed from: b */
    final /* synthetic */ Context f19587b;
    /* renamed from: c */
    final /* synthetic */ ch f19588c;

    cj(ch chVar, long j, Context context) {
        this.f19588c = chVar;
        this.f19586a = j;
        this.f19587b = context;
    }

    public void run() {
        this.f19588c.m15596b(this.f19586a);
        if (bv.m15511a().m15520c()) {
            this.f19588c.m15579c(this.f19587b);
        }
    }
}
