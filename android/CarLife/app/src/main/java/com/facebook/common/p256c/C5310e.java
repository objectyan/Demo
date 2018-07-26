package com.facebook.common.p256c;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: HandlerExecutorServiceImpl */
/* renamed from: com.facebook.common.c.e */
public class C5310e extends AbstractExecutorService implements C5309d {
    /* renamed from: a */
    private final Handler f21883a;

    protected /* synthetic */ RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return m18098a(runnable, obj);
    }

    protected /* synthetic */ RunnableFuture newTaskFor(Callable callable) {
        return m18099a(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return m18100a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return m18102b(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return m18103b(callable);
    }

    public C5310e(Handler handler) {
        this.f21883a = handler;
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

    public void execute(Runnable command) {
        this.f21883a.post(command);
    }

    /* renamed from: a */
    protected <T> C5311f<T> m18098a(Runnable runnable, T value) {
        return new C5311f(this.f21883a, runnable, value);
    }

    /* renamed from: a */
    protected <T> C5311f<T> m18099a(Callable<T> callable) {
        return new C5311f(this.f21883a, callable);
    }

    /* renamed from: a */
    public ScheduledFuture<?> m18100a(Runnable task) {
        return m18102b(task, (Void) null);
    }

    /* renamed from: b */
    public <T> ScheduledFuture<T> m18102b(Runnable task, @Nullable T result) {
        if (task == null) {
            throw new NullPointerException();
        }
        C5311f<T> future = m18098a(task, result);
        execute(future);
        return future;
    }

    /* renamed from: b */
    public <T> ScheduledFuture<T> m18103b(Callable<T> task) {
        if (task == null) {
            throw new NullPointerException();
        }
        C5311f<T> future = m18099a((Callable) task);
        execute(future);
        return future;
    }

    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        C5311f<?> future = m18098a(command, null);
        this.f21883a.postDelayed(future, unit.toMillis(delay));
        return future;
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        C5311f<V> future = m18099a((Callable) callable);
        this.f21883a.postDelayed(future, unit.toMillis(delay));
        return future;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo3996a() {
        this.f21883a.getLooper().quit();
    }

    /* renamed from: b */
    public boolean mo3997b() {
        return Thread.currentThread() == this.f21883a.getLooper().getThread();
    }
}
