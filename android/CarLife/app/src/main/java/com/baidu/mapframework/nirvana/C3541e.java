package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.nirvana.looper.LooperBuffer;
import com.baidu.mapframework.nirvana.p205b.C3530a;
import com.baidu.mapframework.nirvana.schedule.LifecycleManager;

/* compiled from: NirvanaFramework */
/* renamed from: com.baidu.mapframework.nirvana.e */
public class C3541e {
    /* renamed from: a */
    private static boolean f19159a = false;
    /* renamed from: b */
    private static C3535c f19160b;
    /* renamed from: c */
    private static C3530a f19161c = new C3530a(false);
    /* renamed from: d */
    private static LooperBuffer f19162d = new LooperBuffer(true);
    /* renamed from: e */
    private static LifecycleManager f19163e = new LifecycleManager();

    /* renamed from: a */
    public static void m15172a(boolean debug) {
        f19159a = debug;
    }

    /* renamed from: a */
    public static boolean m15173a() {
        return f19159a;
    }

    /* renamed from: b */
    public static C3530a m15174b() {
        return f19161c;
    }

    /* renamed from: c */
    public static LooperBuffer m15175c() {
        return f19162d;
    }

    /* renamed from: d */
    public static LifecycleManager m15176d() {
        return f19163e;
    }

    /* renamed from: a */
    public static void m15170a(C3535c handler) {
        f19160b = handler;
    }

    /* renamed from: a */
    public static void m15171a(String description, Exception e) {
        if (f19160b != null) {
            f19160b.m15159a(description, e);
        }
    }
}
