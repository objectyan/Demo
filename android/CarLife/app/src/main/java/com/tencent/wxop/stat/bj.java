package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6122c;

final class bj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24986a;
    /* renamed from: b */
    final /* synthetic */ C6122c f24987b;
    /* renamed from: c */
    final /* synthetic */ Context f24988c;

    bj(String str, C6122c c6122c, Context context) {
        this.f24986a = str;
        this.f24987b = c6122c;
        this.f24988c = context;
    }

    public final void run() {
        try {
            if (C6160j.m22111a(this.f24986a)) {
                C6160j.f25104q.m21831g("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (C6156f.m21997b()) {
                C6160j.f25104q.m21825b("add begin key:" + this.f24987b.toString());
            }
            if (C6160j.f25092e.containsKey(this.f24987b)) {
                C6160j.f25104q.m21831g("Duplicate CustomEvent key: " + this.f24987b.toString() + ", trackCustomBeginEvent() repeated?");
            } else if (C6160j.f25092e.size() <= C6156f.m22036n()) {
                C6160j.f25092e.put(this.f24987b, Long.valueOf(System.currentTimeMillis()));
            } else {
                C6160j.f25104q.m21831g("The number of timedEvent exceeds the maximum value " + Integer.toString(C6156f.m22036n()));
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24988c, th);
        }
    }
}
