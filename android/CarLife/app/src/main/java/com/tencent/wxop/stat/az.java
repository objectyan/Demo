package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p291b.C6144m;

final class az implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24872a;

    az(Context context) {
        this.f24872a = context;
    }

    public final void run() {
        C6162l.m22161a(C6160j.f25107t).m22175h();
        C6144m.m21861a(this.f24872a, true);
        ag.m21760a(this.f24872a);
        aw.m21813b(this.f24872a);
        C6160j.f25105r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new aa());
        if (C6156f.m21971a() == C6158h.APP_LAUNCH) {
            C6160j.m22094a(this.f24872a, -1);
        }
        if (C6156f.m21997b()) {
            C6160j.f25104q.m21834j("Init MTA StatService success.");
        }
    }
}
