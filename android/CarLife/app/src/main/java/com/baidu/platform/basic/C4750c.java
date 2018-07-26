package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.C2911f;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BMThreadPoolExecutor */
/* renamed from: com.baidu.platform.basic.c */
public class C4750c extends ThreadPoolExecutor {
    /* renamed from: a */
    public static final String f19756a = "BMThreadPoolExecutor";
    /* renamed from: b */
    private final ThreadLocal<Long> f19757b = new ThreadLocal();
    /* renamed from: c */
    private final AtomicLong f19758c = new AtomicLong();
    /* renamed from: d */
    private final AtomicLong f19759d = new AtomicLong();

    public C4750c(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        C2911f.c(f19756a, String.format("Thread %s : start %s", new Object[]{t, r}));
        this.f19757b.set(Long.valueOf(System.nanoTime()));
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long taskTime = System.nanoTime() - ((Long) this.f19757b.get()).longValue();
            this.f19758c.incrementAndGet();
            this.f19759d.addAndGet(taskTime);
            C2911f.c(f19756a, String.format(Locale.getDefault(), "Thread %s : end %s,time=%dns", new Object[]{Thread.currentThread(), r, Long.valueOf(taskTime)}));
        } finally {
            super.afterExecute(r, t);
        }
    }

    protected void terminated() {
        try {
            if (!(this.f19758c == null || this.f19758c.get() == 0)) {
                C2911f.c(f19756a, String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[]{Long.valueOf(this.f19759d.get()), Long.valueOf(this.f19759d.get() / this.f19758c.get())}));
            }
            super.terminated();
        } catch (Throwable th) {
            super.terminated();
        }
    }
}
