package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.p115a.C2505a;

/* compiled from: VrConfig */
/* renamed from: com.baidu.che.codriver.vr.n */
public final class C2840n {
    /* renamed from: a */
    private static boolean f9226a = false;
    /* renamed from: b */
    private static C2839a f9227b = C2839a.ONLINE;
    /* renamed from: c */
    private static boolean f9228c = false;
    /* renamed from: d */
    private static String f9229d = "123456";
    /* renamed from: e */
    private static String f9230e = "123456";
    /* renamed from: f */
    private static final String f9231f = "http://api.codriver.baidu.com/codriverapi";
    /* renamed from: g */
    private static final String f9232g = "http://sandbox.codriverapi.baidu.com/codriverapi";
    /* renamed from: h */
    private static String f9233h = "http://10.52.185.183:8080/codriverapi";
    /* renamed from: i */
    private static String f9234i = f9231f;
    /* renamed from: j */
    private static final String f9235j = "/robokit";
    /* renamed from: k */
    private static final String f9236k = "123456";
    /* renamed from: l */
    private static final String f9237l = C2505a.m9513c();
    /* renamed from: m */
    private static final String f9238m = "123456";
    /* renamed from: n */
    private static final String f9239n = C2505a.m9514d();

    /* compiled from: VrConfig */
    /* renamed from: com.baidu.che.codriver.vr.n$a */
    public enum C2839a {
        ONLINE,
        DEBUG,
        SANDBOX
    }

    /* renamed from: a */
    public static final void m10671a(boolean debug) {
        f9226a = debug;
    }

    /* renamed from: a */
    public static final boolean m10672a() {
        return f9226a;
    }

    /* renamed from: b */
    public static final void m10674b(boolean debug) {
        f9228c = debug;
    }

    /* renamed from: b */
    public static final boolean m10675b() {
        return f9228c;
    }

    /* renamed from: c */
    public static String m10676c() {
        switch (f9227b) {
            case ONLINE:
                f9234i = f9231f;
                break;
            case DEBUG:
                f9234i = f9233h;
                break;
            case SANDBOX:
                f9234i = f9232g;
                break;
            default:
                f9234i = f9231f;
                break;
        }
        return f9234i;
    }

    /* renamed from: a */
    public static void m10670a(String host) {
        f9233h = host;
    }

    /* renamed from: a */
    public static void m10669a(C2839a type) {
        f9227b = type;
    }

    /* renamed from: d */
    public static String m10678d() {
        return C2840n.m10676c() + f9235j;
    }

    /* renamed from: e */
    public static String m10679e() {
        if (C2840n.m10676c().equals(f9233h) || C2840n.m10676c().equals(f9232g)) {
            return f9229d;
        }
        return f9237l;
    }

    /* renamed from: f */
    public static String m10680f() {
        if (C2840n.m10676c().equals(f9233h) || C2840n.m10676c().equals(f9232g)) {
            return f9230e;
        }
        return f9239n;
    }

    /* renamed from: b */
    public static void m10673b(String keySignPrefix) {
        f9229d = keySignPrefix;
    }

    /* renamed from: c */
    public static void m10677c(String keySignPostfix) {
        f9230e = keySignPostfix;
    }
}
