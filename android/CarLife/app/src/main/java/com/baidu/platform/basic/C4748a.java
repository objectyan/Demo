package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.C2911f;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BMScheduledThreadPoolExecutor */
/* renamed from: com.baidu.platform.basic.a */
public class C4748a extends ScheduledThreadPoolExecutor {
    /* renamed from: a */
    public static final String f19748a = "BMScheduledThreadPoolExecutor";
    /* renamed from: b */
    private final ThreadLocal<Long> f19749b = new ThreadLocal();
    /* renamed from: c */
    private final AtomicLong f19750c = new AtomicLong();
    /* renamed from: d */
    private final AtomicLong f19751d = new AtomicLong();

    public C4748a(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        try {
            C2911f.c(f19748a, String.format("Thread %s : start %s", new Object[]{r, t}));
        } catch (Exception e) {
        }
        this.f19749b.set(Long.valueOf(System.nanoTime()));
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long taskTime = System.nanoTime() - ((Long) this.f19749b.get()).longValue();
            this.f19750c.incrementAndGet();
            this.f19751d.addAndGet(taskTime);
            C2911f.c(f19748a, String.format(Locale.getDefault(), "Thread %s : end %s,time=%dns", new Object[]{t, r, Long.valueOf(taskTime)}));
        } catch (Exception e) {
        } finally {
            super.afterExecute(r, t);
        }
    }

    protected void terminated() {
        int avgTime = 0;
        try {
            if (this.f19750c.get() != 0) {
                avgTime = (int) (this.f19751d.get() / this.f19750c.get());
            }
            C2911f.c(f19748a, String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[]{Long.valueOf(this.f19751d.get()), Integer.valueOf(avgTime)}));
        } catch (Exception e) {
        } finally {
            super.terminated();
        }
    }
}
