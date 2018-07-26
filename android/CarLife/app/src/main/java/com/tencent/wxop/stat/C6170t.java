package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6119e;
import com.tencent.wxop.stat.p290a.C6129k;

/* renamed from: com.tencent.wxop.stat.t */
final class C6170t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f25136a;
    /* renamed from: b */
    final /* synthetic */ String f25137b;
    /* renamed from: c */
    final /* synthetic */ C6161k f25138c;

    C6170t(Context context, String str, C6161k c6161k) {
        this.f25136a = context;
        this.f25137b = str;
        this.f25138c = c6161k;
    }

    public final void run() {
        try {
            Long l;
            C6160j.m22143i(this.f25136a);
            synchronized (C6160j.f25102o) {
                l = (Long) C6160j.f25102o.remove(this.f25137b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String k = C6160j.f25101n;
                if (k != null && k.equals(this.f25137b)) {
                    k = "-";
                }
                C6119e c6129k = new C6129k(this.f25136a, k, this.f25137b, C6160j.m22090a(this.f25136a, false, this.f25138c), valueOf, this.f25138c);
                if (!this.f25137b.equals(C6160j.f25100m)) {
                    C6160j.f25104q.m21829e("Invalid invocation since previous onResume on diff page.");
                }
                new ac(c6129k).m21751a();
                C6160j.f25101n = this.f25137b;
                return;
            }
            C6160j.f25104q.m21832h("Starttime for PageID:" + this.f25137b + " not found, lost onResume()?");
        } catch (Throwable th) {
            C6160j.f25104q.m21826b(th);
            C6160j.m22104a(this.f25136a, th);
        }
    }
}
