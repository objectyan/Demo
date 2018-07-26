package com.baidu.mobstat;

import android.content.Context;

public class au {
    /* renamed from: a */
    private static C3587l f19402a;

    /* renamed from: a */
    public static synchronized C3587l m15354a(Context context) {
        C3587l awVar;
        Throwable th;
        synchronized (au.class) {
            bd.m15428a("getBPStretegyController begin");
            C3587l c3587l = f19402a;
            if (c3587l == null) {
                try {
                    Class a = ax.m15377a(context, "com.baidu.bottom.remote.BPStretegyController2");
                    if (a != null) {
                        awVar = new aw(a.newInstance());
                        try {
                            bd.m15428a("Get BPStretegyController load remote class v2");
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c3587l = awVar;
                            th = th2;
                            bd.m15429a(th);
                            awVar = c3587l;
                            if (awVar == null) {
                                awVar = new av();
                                bd.m15428a("Get BPStretegyController load local class");
                            }
                            f19402a = awVar;
                            ax.m15379a(context, awVar);
                            bd.m15428a("getBPStretegyController end");
                            return awVar;
                        }
                        if (awVar == null) {
                            awVar = new av();
                            bd.m15428a("Get BPStretegyController load local class");
                        }
                        f19402a = awVar;
                        ax.m15379a(context, awVar);
                        bd.m15428a("getBPStretegyController end");
                    }
                } catch (Exception e2) {
                    th = e2;
                    bd.m15429a(th);
                    awVar = c3587l;
                    if (awVar == null) {
                        awVar = new av();
                        bd.m15428a("Get BPStretegyController load local class");
                    }
                    f19402a = awVar;
                    ax.m15379a(context, awVar);
                    bd.m15428a("getBPStretegyController end");
                    return awVar;
                }
            }
            awVar = c3587l;
            if (awVar == null) {
                awVar = new av();
                bd.m15428a("Get BPStretegyController load local class");
            }
            f19402a = awVar;
            ax.m15379a(context, awVar);
            bd.m15428a("getBPStretegyController end");
        }
        return awVar;
    }

    /* renamed from: a */
    public static synchronized void m15355a() {
        synchronized (au.class) {
            f19402a = null;
        }
    }
}
