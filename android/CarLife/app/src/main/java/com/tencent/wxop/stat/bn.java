package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6121b;
import com.tencent.wxop.stat.p290a.C6122c;

final class bn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24999a;
    /* renamed from: b */
    final /* synthetic */ C6122c f25000b;
    /* renamed from: c */
    final /* synthetic */ Context f25001c;
    /* renamed from: d */
    final /* synthetic */ C6161k f25002d;

    bn(String str, C6122c c6122c, Context context, C6161k c6161k) {
        this.f24999a = str;
        this.f25000b = c6122c;
        this.f25001c = context;
        this.f25002d = c6161k;
    }

    public final void run() {
        try {
            if (C6160j.m22111a(this.f24999a)) {
                C6160j.f25104q.m21831g("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) C6160j.f25092e.remove(this.f25000b);
            if (l != null) {
                C6119e c6121b = new C6121b(this.f25001c, C6160j.m22090a(this.f25001c, false, this.f25002d), this.f25000b.f24767a, this.f25002d);
                c6121b.m21724b().f24769c = this.f25000b.f24769c;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c6121b.m21722a(Long.valueOf(l.longValue() <= 0 ? 1 : l.longValue()).longValue());
                new ac(c6121b).m21751a();
                return;
            }
            C6160j.f25104q.m21829e("No start time found for custom event: " + this.f25000b.toString() + ", lost trackCustomBeginKVEvent()?");
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25001c, th);
        }
    }
}
