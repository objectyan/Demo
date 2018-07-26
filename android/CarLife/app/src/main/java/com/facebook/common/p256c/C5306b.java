package com.facebook.common.p256c;

import com.facebook.common.p257e.C5320a;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ConstrainedExecutorService */
/* renamed from: com.facebook.common.c.b */
public class C5306b extends AbstractExecutorService {
    /* renamed from: a */
    private static final Class<?> f21875a = C5306b.class;
    /* renamed from: b */
    private final String f21876b;
    /* renamed from: c */
    private final Executor f21877c;
    /* renamed from: d */
    private volatile int f21878d;
    /* renamed from: e */
    private final BlockingQueue<Runnable> f21879e;
    /* renamed from: f */
    private final C5305a f21880f;
    /* renamed from: g */
    private final AtomicInteger f21881g;
    /* renamed from: h */
    private final AtomicInteger f21882h;

    /* compiled from: ConstrainedExecutorService */
    /* renamed from: com.facebook.common.c.b$a */
    private class C5305a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5306b f21874a;

        private C5305a(C5306b c5306b) {
            this.f21874a = c5306b;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r2 = r7.f21874a;	 Catch:{ all -> 0x003e }
            r2 = r2.f21879e;	 Catch:{ all -> 0x003e }
            r0 = r2.poll();	 Catch:{ all -> 0x003e }
            r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x002d;
        L_0x000e:
            r0.run();	 Catch:{ all -> 0x003e }
        L_0x0011:
            r2 = r7.f21874a;
            r2 = r2.f21881g;
            r1 = r2.decrementAndGet();
            r2 = r7.f21874a;
            r2 = r2.f21879e;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x005b;
        L_0x0027:
            r2 = r7.f21874a;
            r2.m18093c();
        L_0x002c:
            return;
        L_0x002d:
            r2 = com.facebook.common.p256c.C5306b.f21875a;	 Catch:{ all -> 0x003e }
            r3 = "%s: Worker has nothing to run";
            r4 = r7.f21874a;	 Catch:{ all -> 0x003e }
            r4 = r4.f21876b;	 Catch:{ all -> 0x003e }
            com.facebook.common.p257e.C5320a.m18123a(r2, r3, r4);	 Catch:{ all -> 0x003e }
            goto L_0x0011;
        L_0x003e:
            r2 = move-exception;
            r3 = r7.f21874a;
            r3 = r3.f21881g;
            r1 = r3.decrementAndGet();
            r3 = r7.f21874a;
            r3 = r3.f21879e;
            r3 = r3.isEmpty();
            if (r3 != 0) goto L_0x0070;
        L_0x0055:
            r3 = r7.f21874a;
            r3.m18093c();
        L_0x005a:
            throw r2;
        L_0x005b:
            r2 = com.facebook.common.p256c.C5306b.f21875a;
            r3 = "%s: worker finished; %d workers left";
            r4 = r7.f21874a;
            r4 = r4.f21876b;
            r5 = java.lang.Integer.valueOf(r1);
            com.facebook.common.p257e.C5320a.m18124a(r2, r3, r4, r5);
            goto L_0x002c;
        L_0x0070:
            r3 = com.facebook.common.p256c.C5306b.f21875a;
            r4 = "%s: worker finished; %d workers left";
            r5 = r7.f21874a;
            r5 = r5.f21876b;
            r6 = java.lang.Integer.valueOf(r1);
            com.facebook.common.p257e.C5320a.m18124a(r3, r4, r5, r6);
            goto L_0x005a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.c.b.a.run():void");
        }
    }

    public C5306b(String name, int maxConcurrency, Executor executor, BlockingQueue<Runnable> workQueue) {
        if (maxConcurrency <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f21876b = name;
        this.f21877c = executor;
        this.f21878d = maxConcurrency;
        this.f21879e = workQueue;
        this.f21880f = new C5305a();
        this.f21881g = new AtomicInteger(0);
        this.f21882h = new AtomicInteger(0);
    }

    /* renamed from: a */
    public static C5306b m18088a(String name, int maxConcurrency, int queueSize, Executor executor) {
        return new C5306b(name, maxConcurrency, executor, new LinkedBlockingQueue(queueSize));
    }

    /* renamed from: a */
    public boolean m18095a() {
        return this.f21879e.isEmpty() && this.f21881g.get() == 0;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.f21879e.offer(runnable)) {
            int queueSize = this.f21879e.size();
            int maxSize = this.f21882h.get();
            if (queueSize > maxSize && this.f21882h.compareAndSet(maxSize, queueSize)) {
                C5320a.m18124a(f21875a, "%s: max pending work in queue = %d", this.f21876b, Integer.valueOf(queueSize));
            }
            m18093c();
        } else {
            throw new RejectedExecutionException(this.f21876b + " queue is full, size=" + this.f21879e.size());
        }
    }

    /* renamed from: c */
    private void m18093c() {
        int currentCount = this.f21881g.get();
        while (currentCount < this.f21878d) {
            int updatedCount = currentCount + 1;
            if (this.f21881g.compareAndSet(currentCount, updatedCount)) {
                C5320a.m18125a(f21875a, "%s: starting worker %d of %d", this.f21876b, Integer.valueOf(updatedCount), Integer.valueOf(this.f21878d));
                this.f21877c.execute(this.f21880f);
                return;
            }
            C5320a.m18123a(f21875a, "%s: race in startWorkerIfNeeded; retrying", this.f21876b);
            currentCount = this.f21881g.get();
        }
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }
}
