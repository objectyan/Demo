package com.facebook.common.p256c;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* compiled from: ScheduledFutureImpl */
/* renamed from: com.facebook.common.c.f */
public class C5311f<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    /* renamed from: a */
    private final Handler f21884a;
    /* renamed from: b */
    private final FutureTask<V> f21885b;

    public /* synthetic */ int compareTo(Object obj) {
        return m18105a((Delayed) obj);
    }

    public C5311f(Handler handler, Callable<V> callable) {
        this.f21884a = handler;
        this.f21885b = new FutureTask(callable);
    }

    public C5311f(Handler handler, Runnable runnable, @Nullable V result) {
        this.f21884a = handler;
        this.f21885b = new FutureTask(runnable, result);
    }

    public long getDelay(TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public int m18105a(Delayed other) {
        throw new UnsupportedOperationException();
    }

    public void run() {
        this.f21885b.run();
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.f21885b.cancel(mayInterruptIfRunning);
    }

    public boolean isCancelled() {
        return this.f21885b.isCancelled();
    }

    public boolean isDone() {
        return this.f21885b.isDone();
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.f21885b.get();
    }

    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f21885b.get(timeout, unit);
    }
}
