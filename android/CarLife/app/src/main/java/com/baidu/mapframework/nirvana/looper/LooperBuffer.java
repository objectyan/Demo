package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.LinkedList;

public class LooperBuffer {
    /* renamed from: a */
    private static final String f19196a = LooperBuffer.class.getSimpleName();
    /* renamed from: b */
    private static final long f19197b = 16;
    /* renamed from: c */
    private static final long f19198c = 800;
    /* renamed from: d */
    private static final long f19199d = 100;
    /* renamed from: e */
    private final boolean f19200e;
    /* renamed from: f */
    private volatile boolean f19201f;
    /* renamed from: g */
    private final LinkedList<Runnable> f19202g;
    /* renamed from: h */
    private volatile int f19203h = 0;
    /* renamed from: i */
    private Handler f19204i = new Handler(Looper.getMainLooper());
    /* renamed from: j */
    private long f19205j = 0;

    /* renamed from: com.baidu.mapframework.nirvana.looper.LooperBuffer$1 */
    class C35521 extends LooperTask {
        /* renamed from: a */
        final /* synthetic */ LooperBuffer f19194a;

        C35521(LooperBuffer this$0) {
            this.f19194a = this$0;
        }

        public void run() {
            this.f19194a.f19203h = this.f19194a.f19203h - 1;
        }
    }

    /* renamed from: com.baidu.mapframework.nirvana.looper.LooperBuffer$2 */
    class C35532 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LooperBuffer f19195a;

        C35532(LooperBuffer this$0) {
            this.f19195a = this$0;
        }

        public void run() {
            if (!this.f19195a.m15203d()) {
                this.f19195a.m15201c();
            }
        }
    }

    public LooperBuffer(boolean enable) {
        this.f19200e = enable;
        this.f19201f = false;
        this.f19202g = new LinkedList();
    }

    public void run(Runnable runnable) {
        if (this.f19200e) {
            m15198a(runnable);
            if (!this.f19201f) {
                m15197a();
                return;
            }
            return;
        }
        runnable.run();
    }

    /* renamed from: a */
    private void m15198a(Runnable runnable) {
        synchronized (this.f19202g) {
            this.f19202g.addLast(runnable);
        }
    }

    /* renamed from: a */
    private void m15197a() {
        synchronized (this.f19202g) {
            long start = System.currentTimeMillis();
            while (!this.f19202g.isEmpty() && System.currentTimeMillis() - start < 16) {
                ((Runnable) this.f19202g.removeFirst()).run();
            }
        }
        if (!this.f19202g.isEmpty()) {
            m15199b();
        }
    }

    public synchronized void startAnim() {
        this.f19201f = true;
        m15201c();
    }

    public synchronized void stopAnim() {
        this.f19201f = false;
        m15204e();
        m15199b();
    }

    /* renamed from: b */
    private void m15199b() {
        if (this.f19203h < 3) {
            this.f19203h++;
            LooperManager.executeTask(Module.BASE_FRAMEWORK_MODULE, new C35521(this), ScheduleConfig.forData());
        }
    }

    /* renamed from: c */
    private synchronized void m15201c() {
        if (this.f19205j == 0) {
            this.f19205j = System.currentTimeMillis();
        }
        this.f19204i.postDelayed(new C35532(this), 100);
    }

    /* renamed from: d */
    private synchronized boolean m15203d() {
        boolean z;
        if (!this.f19201f || this.f19205j == 0) {
            z = true;
        } else {
            if (System.currentTimeMillis() - this.f19205j > f19198c) {
                stopAnim();
            }
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    private synchronized void m15204e() {
        this.f19205j = 0;
    }
}
