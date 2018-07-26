package com.baidu.mapframework.nirvana;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: NirvanaScheduledThreadPoolExecutor */
/* renamed from: com.baidu.mapframework.nirvana.f */
public class C3542f extends ScheduledThreadPoolExecutor {
    /* renamed from: a */
    public static final String f19164a = "NirvanaScheduledThreadPool";
    /* renamed from: b */
    private final ThreadLocal<Long> f19165b = new ThreadLocal();
    /* renamed from: c */
    private final AtomicLong f19166c = new AtomicLong();
    /* renamed from: d */
    private final AtomicLong f19167d = new AtomicLong();

    public C3542f(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        this.f19165b.set(Long.valueOf(System.nanoTime()));
        C3560n.m15209a(f19164a, String.format("Thread %s : start task %s at: %s", new Object[]{t, r, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(((Long) this.f19165b.get()).longValue()))}) + "");
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long taskTime = System.nanoTime() - ((Long) this.f19165b.get()).longValue();
            this.f19166c.incrementAndGet();
            this.f19167d.addAndGet(taskTime);
            C3560n.m15209a(f19164a, String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", new Object[]{Thread.currentThread(), r, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(taskTime)), Long.valueOf(this.f19166c.get())}));
        } finally {
            super.afterExecute(r, t);
        }
    }

    protected void terminated() {
        try {
            if (this.f19166c.get() != 0) {
                C3560n.m15209a(f19164a, String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[]{Long.valueOf(this.f19167d.get()), Long.valueOf(this.f19167d.get() / this.f19166c.get())}));
            }
            super.terminated();
        } catch (Throwable th) {
            super.terminated();
        }
    }
}
