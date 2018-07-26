package com.baidu.android.pushservice.p022i;

import java.util.concurrent.TimeUnit;

/* renamed from: com.baidu.android.pushservice.i.d */
public class C0559d {
    /* renamed from: a */
    private static C0556a f1843a;
    /* renamed from: b */
    private static C0559d f1844b;

    /* renamed from: com.baidu.android.pushservice.i.d$1 */
    class C05581 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C0559d f1842a;

        C05581(C0559d c0559d) {
            this.f1842a = c0559d;
        }

        public void run() {
            this.f1842a.m2389b();
        }
    }

    public C0559d() {
        Runtime.getRuntime().addShutdownHook(new C05581(this));
        f1843a = new C0556a(3, 100, 1, TimeUnit.MINUTES, new C0557b());
    }

    /* renamed from: a */
    public static C0559d m2387a() {
        if (f1844b == null || f1843a == null || f1843a.isShutdown() || f1843a.isTerminated()) {
            f1844b = new C0559d();
        }
        return f1844b;
    }

    /* renamed from: a */
    public boolean m2388a(C0420c c0420c) {
        try {
            f1843a.submit(c0420c);
            return true;
        } catch (Exception e) {
            if (f1843a == null || f1843a.getCorePoolSize() == 0 || f1843a.getPoolSize() == 0) {
                f1843a = new C0556a(3, 100, 1, TimeUnit.MINUTES, new C0557b());
            }
            return false;
        }
    }

    /* renamed from: b */
    public void m2389b() {
        if (f1843a != null) {
            try {
                f1843a.getQueue().clear();
                f1843a.shutdown();
            } catch (Exception e) {
            }
        }
    }
}
