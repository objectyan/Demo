package com.tencent.wxop.stat;

import java.util.List;

class ah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f24824a;
    /* renamed from: b */
    final /* synthetic */ int f24825b;
    /* renamed from: c */
    final /* synthetic */ boolean f24826c;
    /* renamed from: d */
    final /* synthetic */ boolean f24827d;
    /* renamed from: e */
    final /* synthetic */ ag f24828e;

    ah(ag agVar, List list, int i, boolean z, boolean z2) {
        this.f24828e = agVar;
        this.f24824a = list;
        this.f24825b = i;
        this.f24826c = z;
        this.f24827d = z2;
    }

    public void run() {
        this.f24828e.m21770a(this.f24824a, this.f24825b, this.f24826c);
        if (this.f24827d) {
            this.f24824a.clear();
        }
    }
}
