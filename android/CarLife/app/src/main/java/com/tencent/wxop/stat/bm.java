package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6122c;

final class bm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24996a;
    /* renamed from: b */
    final /* synthetic */ C6122c f24997b;
    /* renamed from: c */
    final /* synthetic */ Context f24998c;

    bm(String str, C6122c c6122c, Context context) {
        this.f24996a = str;
        this.f24997b = c6122c;
        this.f24998c = context;
    }

    public final void run() {
        try {
            if (C6160j.m22111a(this.f24996a)) {
                C6160j.f25104q.m21831g("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (C6156f.m21997b()) {
                C6160j.f25104q.m21825b("add begin key:" + this.f24997b);
            }
            if (C6160j.f25092e.containsKey(this.f24997b)) {
                C6160j.f25104q.m21829e("Duplicate CustomEvent key: " + this.f24997b.toString() + ", trackCustomBeginKVEvent() repeated?");
            } else if (C6160j.f25092e.size() <= C6156f.m22036n()) {
                C6160j.f25092e.put(this.f24997b, Long.valueOf(System.currentTimeMillis()));
            } else {
                C6160j.f25104q.m21831g("The number of timedEvent exceeds the maximum value " + Integer.toString(C6156f.m22036n()));
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24998c, th);
        }
    }
}
