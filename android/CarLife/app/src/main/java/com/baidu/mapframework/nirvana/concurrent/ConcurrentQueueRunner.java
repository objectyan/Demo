package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.C3547k;
import com.baidu.mapframework.nirvana.C3547k.C3538a;
import java.util.concurrent.ExecutorService;

class ConcurrentQueueRunner {
    /* renamed from: a */
    private final C3547k f19150a;

    ConcurrentQueueRunner(final ExecutorService worker) {
        this.f19150a = new C3547k(new C3538a(this) {
            /* renamed from: b */
            final /* synthetic */ ConcurrentQueueRunner f19149b;

            public void execute(Runnable runnable) {
                worker.execute(runnable);
            }
        });
    }

    /* renamed from: a */
    void m15162a(Runnable runnable) {
        this.f19150a.m15189a(runnable);
    }
}
