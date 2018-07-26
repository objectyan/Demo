package com.baidu.mobstat;

class ci implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f19584a;
    /* renamed from: b */
    final /* synthetic */ ch f19585b;

    ci(ch chVar, long j) {
        this.f19585b = chVar;
        this.f19584a = j;
    }

    public void run() {
        this.f19585b.m15585a(this.f19584a);
    }
}
