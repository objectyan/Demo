package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.C4824h;
import com.baidu.platform.comapi.util.C4828j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class BMExecutorsManager {
    public static final ExecutorService APP_COMMON_EXECUTOR_SERVICE = new C4750c(CORE_NUM, CORE_NUM, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C4824h("APP_COMMON_TP"));
    public static final ExecutorService BACKGROUND_SINGLE_EXECUTOR_SERVICE = new C4750c(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C4828j("LowerPriorityMapAppSingleTP", 10));
    public static final ExecutorService CACHED_EXECUTOR_SERVICE = new C4750c(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new C4824h("MapAppCachedTP"));
    public static final int CORE_NUM = (Runtime.getRuntime().availableProcessors() > 1 ? Runtime.getRuntime().availableProcessors() - 1 : 1);
    public static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = new C4748a(CORE_NUM, new C4824h("MapAppScheduledTP"));
    public static final ExecutorService SINGLE_EXECUTOR_SERVICE = new C4750c(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C4824h("MapAppSingleTP"));

    private BMExecutorsManager() {
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new C4750c(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory) {
        return new C4748a(corePoolSize, threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new C4750c(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new C4750c(nThreads, nThreads, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService newAppCommonThreadPool(ThreadFactory threadFactory) {
        return new C4750c(CORE_NUM, CORE_NUM, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
    }
}
