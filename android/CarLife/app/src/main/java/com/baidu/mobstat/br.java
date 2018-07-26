package com.baidu.mobstat;

import android.content.Context;
import java.util.Map;

class br implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f19490a;
    /* renamed from: b */
    final /* synthetic */ Context f19491b;
    /* renamed from: c */
    final /* synthetic */ String f19492c;
    /* renamed from: d */
    final /* synthetic */ String f19493d;
    /* renamed from: e */
    final /* synthetic */ ExtraInfo f19494e;
    /* renamed from: f */
    final /* synthetic */ Map f19495f;
    /* renamed from: g */
    final /* synthetic */ bm f19496g;

    br(bm bmVar, long j, Context context, String str, String str2, ExtraInfo extraInfo, Map map) {
        this.f19496g = bmVar;
        this.f19490a = j;
        this.f19491b = context;
        this.f19492c = str;
        this.f19493d = str2;
        this.f19494e = extraInfo;
        this.f19495f = map;
    }

    public void run() {
        bv.m15511a().m15521d();
        if (this.f19490a <= 0) {
            db.m15657a("EventStat: Wrong Case, Duration must be positive");
        } else {
            this.f19496g.m15497a(this.f19491b, this.f19492c, this.f19493d, 1, System.currentTimeMillis(), this.f19490a, this.f19494e, this.f19495f);
        }
    }
}
