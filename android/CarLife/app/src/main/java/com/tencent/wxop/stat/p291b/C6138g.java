package com.tencent.wxop.stat.p291b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.wxop.stat.b.g */
public class C6138g {
    /* renamed from: a */
    ExecutorService f24921a;

    public C6138g() {
        this.f24921a = null;
        this.f24921a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void m21844a(Runnable runnable) {
        this.f24921a.execute(runnable);
    }
}
