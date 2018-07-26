package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.common.p202a.C3466l;
import com.baidu.mapframework.common.p202a.C3471f;
import com.baidu.mapframework.common.p202a.C3475j;
import com.baidu.mapframework.nirvana.C3559m.C3558a;
import com.baidu.mobstat.Config;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: NirvanaThreadPoolExecutor */
/* renamed from: com.baidu.mapframework.nirvana.j */
public class C3545j extends ThreadPoolExecutor {
    /* renamed from: a */
    public static final String f19173a = "NirvanaThreadPool";
    /* renamed from: e */
    private static final ConcurrentMap<String, C3559m> f19174e = new ConcurrentHashMap();
    /* renamed from: b */
    private final ThreadLocal<Long> f19175b = new ThreadLocal();
    /* renamed from: c */
    private final AtomicLong f19176c = new AtomicLong();
    /* renamed from: d */
    private final AtomicLong f19177d = new AtomicLong();

    public C3545j(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        this.f19175b.set(Long.valueOf(System.nanoTime()));
        C3560n.m15209a(f19173a, String.format("Thread %s : start task %s at: %s", new Object[]{t, r, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(((Long) this.f19175b.get()).longValue()))}) + "");
        if (((C3559m) f19174e.get(t.getName())) == null) {
            f19174e.put(t.getName(), new C3559m());
        }
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - ((Long) this.f19175b.get()).longValue();
            this.f19176c.incrementAndGet();
            this.f19177d.addAndGet(taskTime);
            C3560n.m15209a(f19173a, String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", new Object[]{Thread.currentThread(), r, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(taskTime)), Long.valueOf(this.f19176c.get())}));
            C3559m profile = (C3559m) f19174e.get(Thread.currentThread().getName());
            if (profile != null) {
                C3558a item = new C3558a();
                item.f19214a = r.toString();
                item.f19215b = ((Long) this.f19175b.get()).longValue();
                item.f19216c = endTime;
                profile.f19217a.add(item);
            }
            super.afterExecute(r, t);
        } catch (Throwable th) {
            super.afterExecute(r, t);
        }
    }

    protected void terminated() {
        try {
            if (this.f19176c.get() != 0) {
                C3560n.m15209a(f19173a, String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[]{Long.valueOf(this.f19177d.get()), Long.valueOf(this.f19177d.get() / this.f19176c.get())}));
            }
            super.terminated();
        } catch (Throwable th) {
            super.terminated();
        }
    }

    /* renamed from: a */
    public static void m15181a() {
        C3466l logger = C3475j.m14916a(C3471f.DEBUG, "Profile");
        for (Entry<String, C3559m> entry : f19174e.entrySet()) {
            logger.mo2526a(String.valueOf(entry.getKey()) + Config.TRACE_TODAY_VISIT_SPLIT + entry.getValue() + "\n");
        }
    }
}
