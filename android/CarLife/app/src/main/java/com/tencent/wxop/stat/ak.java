package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p290a.C6119e;

class ak implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C6119e f24834a;
    /* renamed from: b */
    final /* synthetic */ av f24835b;
    /* renamed from: c */
    final /* synthetic */ boolean f24836c;
    /* renamed from: d */
    final /* synthetic */ boolean f24837d;
    /* renamed from: e */
    final /* synthetic */ ag f24838e;

    ak(ag agVar, C6119e c6119e, av avVar, boolean z, boolean z2) {
        this.f24838e = agVar;
        this.f24834a = c6119e;
        this.f24835b = avVar;
        this.f24836c = z;
        this.f24837d = z2;
    }

    public void run() {
        this.f24838e.m21776b(this.f24834a, this.f24835b, this.f24836c, this.f24837d);
    }
}
