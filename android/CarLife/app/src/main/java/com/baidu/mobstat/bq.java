package com.baidu.mobstat;

import android.content.Context;
import java.util.Map;

class bq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f19483a;
    /* renamed from: b */
    final /* synthetic */ String f19484b;
    /* renamed from: c */
    final /* synthetic */ long f19485c;
    /* renamed from: d */
    final /* synthetic */ Context f19486d;
    /* renamed from: e */
    final /* synthetic */ ExtraInfo f19487e;
    /* renamed from: f */
    final /* synthetic */ Map f19488f;
    /* renamed from: g */
    final /* synthetic */ bm f19489g;

    bq(bm bmVar, String str, String str2, long j, Context context, ExtraInfo extraInfo, Map map) {
        this.f19489g = bmVar;
        this.f19483a = str;
        this.f19484b = str2;
        this.f19485c = j;
        this.f19486d = context;
        this.f19487e = extraInfo;
        this.f19488f = map;
    }

    public void run() {
        bv.m15511a().m15521d();
        String a = this.f19489g.m15496a(this.f19483a, this.f19484b);
        bs bsVar = (bs) this.f19489g.f19460a.get(a);
        if (bsVar == null) {
            db.m15661b("EventStat: event_id[" + this.f19483a + "] with label[" + this.f19484b + "] is not started or alread done.");
        } else if (this.f19483a.equals(bsVar.f19497a) && this.f19484b.equals(bsVar.f19498b)) {
            this.f19489g.f19460a.remove(a);
            long j = this.f19485c - bsVar.f19499c;
            if (j <= 0) {
                db.m15657a("EventStat: Wrong Case, Duration must be positive");
            } else {
                this.f19489g.m15497a(this.f19486d, this.f19483a, this.f19484b, 1, bsVar.f19499c, j, this.f19487e, this.f19488f);
            }
        } else {
            db.m15657a("EventStat: Wrong Case, eventId/label pair not match");
        }
    }
}
