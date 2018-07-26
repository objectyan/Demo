package com.tencent.wxop.stat;

import java.util.List;

class ay implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f24869a;
    /* renamed from: b */
    final /* synthetic */ av f24870b;
    /* renamed from: c */
    final /* synthetic */ aw f24871c;

    ay(aw awVar, List list, av avVar) {
        this.f24871c = awVar;
        this.f24869a = list;
        this.f24870b = avVar;
    }

    public void run() {
        this.f24871c.m21815a(this.f24869a, this.f24870b);
    }
}
