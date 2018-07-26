package com.baidu.mobstat;

class bx extends Thread {
    /* renamed from: a */
    final /* synthetic */ bv f19537a;
    /* renamed from: b */
    private boolean f19538b;

    public bx(bv bvVar, boolean z) {
        this.f19537a = bvVar;
        this.f19538b = z;
    }

    public void run() {
        this.f19537a.m15517a(this.f19537a.f19529b, true, this.f19538b);
        by.m15524a().m15541a(this.f19537a.f19529b);
    }
}
