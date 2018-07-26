package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.C3480g;
import com.baidu.mapframework.nirvana.C3534b;
import com.baidu.mapframework.nirvana.C3540d;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class ConcurrentManager {
    /* renamed from: a */
    private static final ExecutorService f19144a = C3540d.m15165a();
    /* renamed from: b */
    private static final ExecutorService f19145b = C3540d.m15168b("ConcurrentManager.UI.worker");
    /* renamed from: c */
    private static final int f19146c = 1;
    /* renamed from: d */
    private static final ScheduledThreadPoolExecutor f19147d = C3540d.m15169b("ConcurrentManager.SCHEDULE.worker", 1);

    /* renamed from: com.baidu.mapframework.nirvana.concurrent.ConcurrentManager$1 */
    static class C35361 implements Callable<T> {
        C35361() {
        }

        public T call() throws Exception {
            return null;
        }
    }

    public static QueueToken obtainTaskQueue(Module module) {
        return new QueueToken(new ConcurrentQueueRunner(f19144a));
    }

    public static void executeTask(@NotNull Module module, @NotNull ConcurrentTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            C3541e.m15174b().m15142a(C3533c.CONCURRENT, task, module, config);
            Runnable runnable = m15160a(task, task.getExceptionCallback(), config);
            if (task.getQueueToken() != null) {
                task.getQueueToken().m15163a().m15162a(runnable);
            } else if (m15161a(config)) {
                f19145b.execute(runnable);
            } else {
                f19144a.execute(runnable);
            }
        }
    }

    public static <T> FutureTask submitTask(@NotNull Module module, @NotNull ConcurrentCallable<T> callable, @NotNull ScheduleConfig config) {
        if (!C3560n.m15213a(module, (C3480g) callable, config)) {
            return new FutureTask(new C35361());
        }
        FutureTask futureTask = new FutureTask(callable);
        C3541e.m15174b().m15142a(C3533c.CONCURRENT, futureTask, module, config);
        Runnable runnable = m15160a(futureTask, callable.getExceptionCallback(), config);
        if (callable.getQueueToken() != null) {
            callable.getQueueToken().m15163a().m15162a(runnable);
            return futureTask;
        } else if (m15161a(config)) {
            f19145b.execute(runnable);
            return futureTask;
        } else {
            f19144a.execute(runnable);
            return futureTask;
        }
    }

    public static void scheduleTask(@NotNull Module module, @NotNull ScheduleTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            C3541e.m15174b().m15142a(C3533c.CONCURRENT, task, module, config);
            f19147d.schedule(m15160a(task, task.getExceptionCallback(), config), task.getDelay(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private static Runnable m15160a(@NotNull final Runnable runnable, final C3534b callback, final ScheduleConfig config) {
        return new Runnable() {
            public void run() {
                C3541e.m15174b().m15143a(runnable);
                try {
                    if (config.isLifecycleActive()) {
                        runnable.run();
                    }
                } catch (Exception e) {
                    if (callback != null) {
                        callback.m15158a(e);
                    } else {
                        C3541e.m15171a("ConcurrentManager", e);
                    }
                }
                C3541e.m15174b().m15146b(runnable);
            }
        };
    }

    /* renamed from: a */
    private static boolean m15161a(ScheduleConfig config) {
        try {
            return config.getType() instanceof UITaskType;
        } catch (Exception e) {
            return false;
        }
    }
}
