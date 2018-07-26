package com.facebook.common.p256c;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: CallerThreadExecutor */
/* renamed from: com.facebook.common.c.a */
public class C5303a extends AbstractExecutorService {
    /* renamed from: a */
    private static final C5303a f21873a = new C5303a();

    /* renamed from: a */
    public static C5303a m18087a() {
        return f21873a;
    }

    private C5303a() {
    }

    public void execute(Runnable command) {
        command.run();
    }

    public boolean isShutdown() {
        return false;
    }

    public void shutdown() {
    }

    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return true;
    }
}
