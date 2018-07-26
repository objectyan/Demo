package com.tencent.wxop.stat;

import java.util.List;

class ai implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f24829a;
    /* renamed from: b */
    final /* synthetic */ boolean f24830b;
    /* renamed from: c */
    final /* synthetic */ boolean f24831c;
    /* renamed from: d */
    final /* synthetic */ ag f24832d;

    ai(ag agVar, List list, boolean z, boolean z2) {
        this.f24832d = agVar;
        this.f24829a = list;
        this.f24830b = z;
        this.f24831c = z2;
    }

    public void run() {
        this.f24832d.m21771a(this.f24829a, this.f24830b);
        if (this.f24831c) {
            this.f24829a.clear();
        }
    }
}
