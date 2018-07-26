package com.baidu.mapframework.nirvana;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: NirvanaExecutors */
/* renamed from: com.baidu.mapframework.nirvana.d */
public class C3540d {
    /* renamed from: a */
    private static final String f19153a = "DEFAULT";
    /* renamed from: b */
    private static final int f19154b = 60;
    /* renamed from: c */
    private static final int f19155c = Runtime.getRuntime().availableProcessors();
    /* renamed from: d */
    private static final int f19156d = Math.max(2, Math.min(f19155c - 1, 4));
    /* renamed from: e */
    private static final int f19157e = Math.min((f19155c * 2) + 1, 8);
    /* renamed from: f */
    private static ExecutorService f19158f = C3540d.m15166a(f19153a);

    /* renamed from: a */
    public static int m15164a(int maxSize) {
        return Math.min(f19157e, maxSize);
    }

    /* renamed from: a */
    public static ExecutorService m15165a() {
        return f19158f;
    }

    /* renamed from: a */
    public static ExecutorService m15166a(String threadFactoryName) {
        ThreadPoolExecutor executor = new C3545j(f19157e, f19157e, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C3544i(threadFactoryName));
        try {
            executor.setKeepAliveTime(60, TimeUnit.SECONDS);
            executor.allowCoreThreadTimeOut(true);
        } catch (Throwable e) {
            C3560n.m15211a("NirvanaExecutors newFixedThreadPool allowCoreThreadTimeOut", e);
        }
        return executor;
    }

    /* renamed from: a */
    public static ExecutorService m15167a(String threadFactoryName, int max) {
        return new C3545j(max, max, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C3544i(threadFactoryName));
    }

    /* renamed from: b */
    public static ScheduledThreadPoolExecutor m15169b(String threadFactoryName, int corePoolSize) {
        return new C3542f(corePoolSize, new C3544i(threadFactoryName));
    }

    /* renamed from: b */
    public static ExecutorService m15168b(String name) {
        return new C3545j(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new SynchronousQueue(), new C3544i(name));
    }
}
