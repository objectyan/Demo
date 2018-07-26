package com.tencent.wxop.stat;

class an implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f24844a;
    /* renamed from: b */
    final /* synthetic */ ag f24845b;

    an(ag agVar, int i) {
        this.f24845b = agVar;
        this.f24844a = i;
    }

    public void run() {
        this.f24845b.m21775b(this.f24844a, true);
        this.f24845b.m21775b(this.f24844a, false);
    }
}
