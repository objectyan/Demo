package com.baidu.android.pushservice.p022i;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.baidu.android.pushservice.i.a */
public class C0556a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.i.a$a */
    protected class C0555a<V> extends FutureTask<V> implements Comparable<C0555a<V>> {
        /* renamed from: a */
        final /* synthetic */ C0556a f1840a;
        /* renamed from: b */
        private Object f1841b;

        public C0555a(C0556a c0556a, Runnable runnable, V v) {
            this.f1840a = c0556a;
            super(runnable, v);
            this.f1841b = runnable;
        }

        public C0555a(C0556a c0556a, Callable<V> callable) {
            this.f1840a = c0556a;
            super(callable);
            this.f1841b = callable;
        }

        /* renamed from: a */
        public int m2386a(C0555a<V> c0555a) {
            return this == c0555a ? 0 : c0555a == null ? -1 : (this.f1841b == null || c0555a.f1841b == null || !(this.f1841b instanceof C0420c) || !(c0555a.f1841b instanceof C0420c)) ? 0 : ((C0420c) c0555a.f1841b).m1795d() - ((C0420c) this.f1841b).m1795d();
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m2386a((C0555a) obj);
        }
    }

    public C0556a(int i, int i2, long j, TimeUnit timeUnit, C0557b<Runnable> c0557b) {
        super(i, i2, j, timeUnit, c0557b);
    }

    public synchronized void execute(Runnable runnable) {
        if (getQueue().size() >= 19) {
            if (getPoolSize() >= getMaximumPoolSize()) {
                getQueue().clear();
            } else {
                Runnable runnable2 = (Runnable) getQueue().poll();
                getQueue().offer(runnable);
                runnable = runnable2;
            }
        }
        super.execute(runnable);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0555a(this, runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0555a(this, callable);
    }
}
