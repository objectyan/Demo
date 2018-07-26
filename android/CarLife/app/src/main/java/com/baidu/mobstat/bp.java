package com.baidu.mobstat;

class bp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f19479a;
    /* renamed from: b */
    final /* synthetic */ String f19480b;
    /* renamed from: c */
    final /* synthetic */ String f19481c;
    /* renamed from: d */
    final /* synthetic */ bm f19482d;

    bp(bm bmVar, long j, String str, String str2) {
        this.f19482d = bmVar;
        this.f19479a = j;
        this.f19480b = str;
        this.f19481c = str2;
    }

    public void run() {
        bv.m15511a().m15521d();
        bs bsVar = new bs();
        bsVar.f19499c = this.f19479a;
        bsVar.f19497a = this.f19480b;
        bsVar.f19498b = this.f19481c;
        String a = this.f19482d.m15496a(this.f19480b, this.f19481c);
        if (this.f19482d.f19460a.get(a) != null) {
            db.m15661b("EventStat: event_id[" + this.f19480b + "] with label[" + this.f19481c + "] is duplicated, older is removed");
        }
        this.f19482d.f19460a.put(a, bsVar);
        db.m15657a("put a keyword[" + a + "] into durationlist");
    }
}
