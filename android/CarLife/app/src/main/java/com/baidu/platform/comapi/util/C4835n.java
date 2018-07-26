package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.basic.BMExecutorsManager;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UiThreadUtil */
/* renamed from: com.baidu.platform.comapi.util.n */
public class C4835n {
    @Nullable
    /* renamed from: a */
    private static Handler f19995a;
    /* renamed from: b */
    private static Map<Integer, LooperTask> f19996b = new HashMap();

    /* renamed from: a */
    public static boolean m16035a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: b */
    public static void m16036b() {
        if (!C4835n.m16035a()) {
            throw new RuntimeException("Expected to run on UI thread!");
        }
    }

    /* renamed from: c */
    public static void m16038c() {
        if (C4835n.m16035a()) {
            throw new RuntimeException("Expected to run on UI thread!");
        }
    }

    /* renamed from: a */
    public static void m16033a(final Runnable runnable) {
        LooperTask task = new LooperTask() {
            public void run() {
                runnable.run();
                C4835n.f19996b.remove(Integer.valueOf(runnable.hashCode()));
            }
        };
        f19996b.put(Integer.valueOf(runnable.hashCode()), task);
        LooperManager.executeTask(Module.UNFINISHED_MODULE, task, ScheduleConfig.forData());
    }

    /* renamed from: a */
    public static void m16034a(final Runnable runnable, long delayMillis) {
        LooperTask task = new LooperTask(delayMillis) {
            public void run() {
                runnable.run();
                C4835n.f19996b.remove(Integer.valueOf(runnable.hashCode()));
            }
        };
        f19996b.put(Integer.valueOf(runnable.hashCode()), task);
        LooperManager.executeTask(Module.UNFINISHED_MODULE, task, ScheduleConfig.forData());
    }

    /* renamed from: b */
    public static void m16037b(@NotNull final Runnable task) {
        ConcurrentManager.executeTask(Module.UNFINISHED_MODULE, new ConcurrentTask() {
            public void run() {
                task.run();
            }
        }, ScheduleConfig.forData());
    }

    /* renamed from: c */
    public static void m16039c(@NotNull Runnable task) throws InterruptedException, InvocationTargetException {
        try {
            BMExecutorsManager.CACHED_EXECUTOR_SERVICE.submit(task).get();
        } catch (ExecutionException e) {
            throw new InvocationTargetException(e);
        }
    }

    /* renamed from: d */
    public static void m16041d(Runnable runnable) {
        LooperTask task = (LooperTask) f19996b.remove(Integer.valueOf(runnable.hashCode()));
        if (task != null) {
            task.cancel();
        }
    }

    /* renamed from: d */
    public static void m16040d() {
        for (Integer intValue : f19996b.keySet()) {
            ((LooperTask) f19996b.remove(Integer.valueOf(intValue.intValue()))).cancel();
        }
    }
}
