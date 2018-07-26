package com.baidu.che.codriver.util;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ExecutorHolder */
/* renamed from: com.baidu.che.codriver.util.e */
public class C2721e {
    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f8917a = null;
    /* renamed from: b */
    private static Object f8918b = new Object();
    /* renamed from: c */
    private static C2720b f8919c = null;
    /* renamed from: d */
    private static Object f8920d = new Object();
    /* renamed from: e */
    private static final int f8921e = 5;

    /* compiled from: ExecutorHolder */
    /* renamed from: com.baidu.che.codriver.util.e$a */
    static class C2718a implements ThreadFactory {
        /* renamed from: a */
        private static final AtomicInteger f8909a = new AtomicInteger(1);
        /* renamed from: b */
        private final ThreadGroup f8910b;
        /* renamed from: c */
        private final AtomicInteger f8911c = new AtomicInteger(1);
        /* renamed from: d */
        private final String f8912d;

        C2718a() {
            SecurityManager s = System.getSecurityManager();
            this.f8910b = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f8912d = "pool-" + f8909a.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.f8910b, r, this.f8912d + this.f8911c.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            t.setPriority(1);
            return t;
        }
    }

    /* compiled from: ExecutorHolder */
    /* renamed from: com.baidu.che.codriver.util.e$b */
    public static class C2720b implements Executor {
        /* renamed from: a */
        private final LinkedList<Runnable> f8915a = new LinkedList();
        /* renamed from: b */
        private Runnable f8916b;

        public synchronized void execute(final Runnable r) {
            this.f8915a.add(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2720b f8914b;

                public void run() {
                    try {
                        r.run();
                    } finally {
                        this.f8914b.m10183a();
                    }
                }
            });
            if (this.f8916b == null) {
                m10183a();
            }
        }

        /* renamed from: a */
        protected synchronized void m10183a() {
            this.f8916b = (Runnable) this.f8915a.poll();
            if (this.f8916b != null) {
                C2721e.m10184a().execute(this.f8916b);
            }
        }
    }

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m10184a() {
        if (f8917a == null) {
            synchronized (f8918b) {
                if (f8917a == null) {
                    f8917a = new ScheduledThreadPoolExecutor(5, new C2718a());
                }
            }
        }
        return f8917a;
    }

    /* renamed from: b */
    public static C2720b m10185b() {
        if (f8919c == null) {
            synchronized (f8920d) {
                if (f8919c == null) {
                    f8919c = new C2720b();
                }
            }
        }
        return f8919c;
    }
}
