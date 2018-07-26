package com.baidu.mobstat;

import android.content.Context;
import java.util.Map;

class bo implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19471a;
    /* renamed from: b */
    final /* synthetic */ String f19472b;
    /* renamed from: c */
    final /* synthetic */ String f19473c;
    /* renamed from: d */
    final /* synthetic */ int f19474d;
    /* renamed from: e */
    final /* synthetic */ long f19475e;
    /* renamed from: f */
    final /* synthetic */ ExtraInfo f19476f;
    /* renamed from: g */
    final /* synthetic */ Map f19477g;
    /* renamed from: h */
    final /* synthetic */ bm f19478h;

    bo(bm bmVar, Context context, String str, String str2, int i, long j, ExtraInfo extraInfo, Map map) {
        this.f19478h = bmVar;
        this.f19471a = context;
        this.f19472b = str;
        this.f19473c = str2;
        this.f19474d = i;
        this.f19475e = j;
        this.f19476f = extraInfo;
        this.f19477g = map;
    }

    public void run() {
        bv.m15511a().m15521d();
        this.f19478h.m15497a(this.f19471a, this.f19472b, this.f19473c, this.f19474d, this.f19475e, 0, this.f19476f, this.f19477g);
    }
}
