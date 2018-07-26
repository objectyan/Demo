package com.facebook.drawee.p266b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: DraweeEventTracker */
/* renamed from: com.facebook.drawee.b.b */
public class C5393b {
    /* renamed from: b */
    private static final int f22031b = 20;
    /* renamed from: c */
    private static final C5393b f22032c = new C5393b();
    /* renamed from: d */
    private static boolean f22033d = true;
    /* renamed from: a */
    private final Queue<C5392a> f22034a = new ArrayBlockingQueue(20);

    /* compiled from: DraweeEventTracker */
    /* renamed from: com.facebook.drawee.b.b$a */
    public enum C5392a {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_HOLDER_TRIM,
        ON_HOLDER_UNTRIM,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    private C5393b() {
    }

    /* renamed from: a */
    public static C5393b m18443a() {
        return f22033d ? new C5393b() : f22032c;
    }

    /* renamed from: b */
    public static void m18444b() {
        f22033d = false;
    }

    /* renamed from: a */
    public void m18445a(C5392a event) {
        if (f22033d) {
            if (this.f22034a.size() + 1 > 20) {
                this.f22034a.poll();
            }
            this.f22034a.add(event);
        }
    }

    public String toString() {
        return this.f22034a.toString();
    }
}
