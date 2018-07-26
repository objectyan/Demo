package com.tencent.wxop.stat;

import android.content.Context;

final class bk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f24989a;
    /* renamed from: b */
    final /* synthetic */ Context f24990b;
    /* renamed from: c */
    final /* synthetic */ C6161k f24991c;

    bk(String str, Context context, C6161k c6161k) {
        this.f24989a = str;
        this.f24990b = context;
        this.f24991c = c6161k;
    }

    public final void run() {
        try {
            synchronized (C6160j.f25102o) {
                if (C6160j.f25102o.size() >= C6156f.m22036n()) {
                    C6160j.f25104q.m21831g("The number of page events exceeds the maximum value " + Integer.toString(C6156f.m22036n()));
                    return;
                }
                C6160j.f25100m = this.f24989a;
                if (C6160j.f25102o.containsKey(C6160j.f25100m)) {
                    C6160j.f25104q.m21832h("Duplicate PageID : " + C6160j.f25100m + ", onResume() repeated?");
                    return;
                }
                C6160j.f25102o.put(C6160j.f25100m, Long.valueOf(System.currentTimeMillis()));
                C6160j.m22090a(this.f24990b, true, this.f24991c);
            }
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24990b, th);
        }
    }
}
