package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.C3480g;
import com.baidu.mapframework.nirvana.C3534b;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.C3560n;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

public class LooperManager {
    /* renamed from: a */
    private static final Handler f19210a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private static final IdleRunner f19211b = new IdleRunner(f19210a);

    public static void executeTask(@NotNull Module module, @NotNull LooperTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            C3541e.m15174b().m15142a(C3533c.LOOPER, task, module, config);
            final Runnable runnable = m15206a(task, config);
            task.setOnCancel(new Runnable() {
                public void run() {
                    LooperManager.f19210a.removeCallbacks(runnable);
                }
            });
            f19210a.postDelayed(runnable, task.getDelay());
        }
    }

    public static void executeTaskWhenIdle(@NotNull Module module, @NotNull DiscreteLooperTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config)) {
            task.appendDescription("executeTaskWhenIdle");
            C3541e.m15174b().m15142a(C3533c.LOOPER, task, module, config);
            f19211b.m15195a(m15206a(task, config));
        }
    }

    public static DiscreteQueueToken createDiscreteQueue(Module module) {
        return new DiscreteQueueToken(new DiscreteRunner(f19210a));
    }

    public static void destroyDiscreteQueue(DiscreteQueueToken token) {
        token.m15190a().m15191a();
    }

    public static void executeTaskDiscreted(@NotNull Module module, @NotNull DiscreteQueueToken token, @NotNull DiscreteLooperTask task, @NotNull ScheduleConfig config) {
        if (C3560n.m15213a(module, (C3480g) task, config) && token != null) {
            task.appendDescription("executeTaskDiscreted");
            task.appendDescription("DiscreteQueueToken " + token.hashCode());
            C3541e.m15174b().m15142a(C3533c.LOOPER, task, module, config);
            token.m15190a().m15192a(m15206a(task, config));
        }
    }

    /* renamed from: a */
    private static Runnable m15206a(final BaseLooperTask task, final ScheduleConfig config) {
        return new Runnable() {

            /* renamed from: com.baidu.mapframework.nirvana.looper.LooperManager$2$1 */
            class C35551 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C35562 f19207a;

                C35551(C35562 this$0) {
                    this.f19207a = this$0;
                }

                public void run() {
                    C3541e.m15174b().m15143a(task);
                    try {
                        if (!task.isCancel() && config.isLifecycleActive()) {
                            task.run();
                        }
                    } catch (Exception e) {
                        C3534b callback = task.getExceptionCallback();
                        if (callback != null) {
                            callback.m15158a(e);
                        } else {
                            C3541e.m15171a("LooperManager", e);
                        }
                    }
                    C3541e.m15174b().m15146b(task);
                }
            }

            public void run() {
                C3541e.m15175c().run(new C35551(this));
            }
        };
    }
}
