package com.baidu.mapframework.nirvana.looper;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.baidu.mapframework.nirvana.C3560n;
import java.util.LinkedList;

class IdleRunner {
    /* renamed from: a */
    private static final boolean f19189a = (VERSION.SDK_INT >= 23);
    /* renamed from: b */
    private final LinkedList<Runnable> f19190b = new LinkedList();
    /* renamed from: c */
    private final Handler f19191c;
    /* renamed from: d */
    private boolean f19192d;
    /* renamed from: e */
    private final IdleHandler f19193e = new C35511(this);

    /* renamed from: com.baidu.mapframework.nirvana.looper.IdleRunner$1 */
    class C35511 implements IdleHandler {
        /* renamed from: a */
        final /* synthetic */ IdleRunner f19188a;

        C35511(IdleRunner this$0) {
            this.f19188a = this$0;
        }

        public boolean queueIdle() {
            try {
                if (!this.f19188a.f19190b.isEmpty()) {
                    ((Runnable) this.f19188a.f19190b.removeFirst()).run();
                }
            } catch (Throwable e) {
                C3560n.m15211a("IdleRunner idleHandler exception", e);
            }
            synchronized (this.f19188a) {
                if (this.f19188a.f19190b.isEmpty()) {
                    this.f19188a.f19192d = false;
                    return false;
                }
                return true;
            }
        }
    }

    IdleRunner(Handler handler) {
        this.f19191c = handler;
        this.f19192d = false;
    }

    /* renamed from: a */
    void m15195a(Runnable runnable) {
        if (f19189a) {
            synchronized (this) {
                this.f19190b.addLast(runnable);
                if (!this.f19192d) {
                    this.f19192d = true;
                    Looper.getMainLooper().getQueue().addIdleHandler(this.f19193e);
                }
            }
            return;
        }
        this.f19191c.post(runnable);
    }
}
