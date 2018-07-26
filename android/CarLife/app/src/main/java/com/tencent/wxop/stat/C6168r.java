package com.tencent.wxop.stat;

import android.content.Context;
import java.util.Map;

/* renamed from: com.tencent.wxop.stat.r */
final class C6168r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25132a;
    /* renamed from: b */
    final /* synthetic */ Map f25133b;
    /* renamed from: c */
    final /* synthetic */ C6161k f25134c;

    C6168r(Context context, Map map, C6161k c6161k) {
        this.f25132a = context;
        this.f25133b = map;
        this.f25134c = c6161k;
    }

    public final void run() {
        try {
            new Thread(new ab(this.f25132a, this.f25133b, this.f25134c), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25132a, th);
        }
    }
}
