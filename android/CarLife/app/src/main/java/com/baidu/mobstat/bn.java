package com.baidu.mobstat;

import android.content.Context;

class bn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19461a;
    /* renamed from: b */
    final /* synthetic */ String f19462b;
    /* renamed from: c */
    final /* synthetic */ String f19463c;
    /* renamed from: d */
    final /* synthetic */ int f19464d;
    /* renamed from: e */
    final /* synthetic */ long f19465e;
    /* renamed from: f */
    final /* synthetic */ String f19466f;
    /* renamed from: g */
    final /* synthetic */ String f19467g;
    /* renamed from: h */
    final /* synthetic */ int f19468h;
    /* renamed from: i */
    final /* synthetic */ boolean f19469i;
    /* renamed from: j */
    final /* synthetic */ bm f19470j;

    bn(bm bmVar, Context context, String str, String str2, int i, long j, String str3, String str4, int i2, boolean z) {
        this.f19470j = bmVar;
        this.f19461a = context;
        this.f19462b = str;
        this.f19463c = str2;
        this.f19464d = i;
        this.f19465e = j;
        this.f19466f = str3;
        this.f19467g = str4;
        this.f19468h = i2;
        this.f19469i = z;
    }

    public void run() {
        bv.m15511a().m15521d();
        this.f19470j.m15498a(this.f19461a, this.f19462b, this.f19463c, this.f19464d, this.f19465e, 0, this.f19466f, this.f19467g, this.f19468h, this.f19469i);
    }
}
