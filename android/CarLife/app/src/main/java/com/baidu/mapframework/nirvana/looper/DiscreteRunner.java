package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import com.baidu.mapframework.nirvana.C3547k;
import com.baidu.mapframework.nirvana.C3547k.C3538a;

public class DiscreteRunner {
    /* renamed from: b */
    private static final int f19186b = 16;
    /* renamed from: a */
    private final C3547k f19187a;

    DiscreteRunner(final Handler handler) {
        this.f19187a = new C3547k(new C3538a(this) {
            /* renamed from: b */
            final /* synthetic */ DiscreteRunner f19185b;

            public void execute(Runnable runnable) {
                handler.postDelayed(runnable, 16);
            }
        });
    }

    /* renamed from: a */
    void m15192a(Runnable runnable) {
        this.f19187a.m15189a(runnable);
    }

    /* renamed from: a */
    void m15191a() {
        this.f19187a.m15188a();
    }
}
