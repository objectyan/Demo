package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6121b;
import com.tencent.wxop.stat.p290a.C6122c;

final class bg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f24980a;
    /* renamed from: b */
    final /* synthetic */ C6161k f24981b;
    /* renamed from: c */
    final /* synthetic */ C6122c f24982c;

    bg(Context context, C6161k c6161k, C6122c c6122c) {
        this.f24980a = context;
        this.f24981b = c6161k;
        this.f24982c = c6122c;
    }

    public final void run() {
        try {
            C6119e c6121b = new C6121b(this.f24980a, C6160j.m22090a(this.f24980a, false, this.f24981b), this.f24982c.f24767a, this.f24981b);
            c6121b.m21724b().f24768b = this.f24982c.f24768b;
            new ac(c6121b).m21751a();
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f24980a, th);
        }
    }
}
