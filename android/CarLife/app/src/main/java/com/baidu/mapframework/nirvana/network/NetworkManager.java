package com.baidu.mapframework.nirvana.network;

import com.baidu.mapframework.nirvana.C3480g;
import com.baidu.mapframework.nirvana.C3534b;
import com.baidu.mapframework.nirvana.C3540d;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;

public class NetworkManager {
    /* renamed from: a */
    private static final ExecutorService f19224a = C3540d.m15166a("NetworkManager");

    public static void executeTask(@NotNull Module module, @NotNull final NetworkTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            C3541e.m15174b().m15142a(C3533c.NETWORK, task, module, config);
            f19224a.execute(new Runnable() {
                public void run() {
                    C3541e.m15174b().m15143a(task);
                    try {
                        task.f19225a.run();
                    } catch (Throwable e) {
                        C3560n.m15211a("NetworkManager executeTask exception", e);
                        C3534b callback = task.getExceptionCallback();
                        if (callback != null) {
                            callback.m15158a(e);
                        } else {
                            C3541e.m15171a("NetworkManager", e);
                        }
                    }
                    C3541e.m15174b().m15146b(task);
                }
            });
        }
    }

    public static void excuteRunnable(@NotNull final Runnable runnable) {
        f19224a.execute(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable e) {
                    C3560n.m15211a("NetworkManager executeTask exception", e);
                }
            }
        });
    }

    public static ExecutorService getAppNetworkThreadPool() {
        return f19224a;
    }
}
