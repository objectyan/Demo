package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6121b;
import com.tencent.wxop.stat.p290a.C6122c;

final class bl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24992a;
    /* renamed from: b */
    final /* synthetic */ C6122c f24993b;
    /* renamed from: c */
    final /* synthetic */ Context f24994c;
    /* renamed from: d */
    final /* synthetic */ C6161k f24995d;

    bl(String str, C6122c c6122c, Context context, C6161k c6161k) {
        this.f24992a = str;
        this.f24993b = c6122c;
        this.f24994c = context;
        this.f24995d = c6161k;
    }

    public final void run() {
        try {
            if (C6160j.m22111a(this.f24992a)) {
                C6160j.f25104q.m21831g("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) C6160j.f25092e.remove(this.f24993b);
            if (l != null) {
                C6119e c6121b = new C6121b(this.f24994c, C6160j.m22090a(this.f24994c, false, this.f24995d), this.f24993b.f24767a, this.f24995d);
                c6121b.m21724b().f24768b = this.f24993b.f24768b;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c6121b.m21722a(Long.valueOf(l.longValue() == 0 ? 1 : l.longValue()).longValue());
                new ac(c6121b).m21751a();
                return;
            }
            C6160j.f25104q.m21831g("No start time found for custom event: " + this.f24993b.toString() + ", lost trackCustomBeginEvent()?");
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24994c, th);
        }
    }
}
