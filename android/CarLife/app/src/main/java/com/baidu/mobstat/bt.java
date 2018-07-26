package com.baidu.mobstat;

import android.content.Context;

class bt {
    /* renamed from: a */
    private static bt f19500a = new bt();
    /* renamed from: b */
    private boolean f19501b = false;

    /* renamed from: a */
    public static bt m15504a() {
        return f19500a;
    }

    private bt() {
    }

    /* renamed from: a */
    public void m15505a(Context context, boolean z) {
        db.m15657a("openExceptonAnalysis");
        if (!this.f19501b) {
            this.f19501b = true;
            bl.m15490a().m15494a(context);
            if (!z) {
                NativeCrashHandler.init(context);
            }
        }
    }
}
