package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.baidu.platform.comapi.dataengine.MapDataEngine;
import com.baidu.platform.comapi.p132b.C2905c;
import com.baidu.platform.comapi.p133d.C2908b;
import com.baidu.platform.comapi.p134f.C2910f;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.vi.VIContext;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: JNIInitializer */
/* renamed from: com.baidu.platform.comapi.c */
public class C2907c {
    /* renamed from: a */
    private static final AtomicBoolean f12695a = new AtomicBoolean(false);
    /* renamed from: b */
    private static final AtomicBoolean f12696b = new AtomicBoolean(false);
    /* renamed from: c */
    private static Context f12697c;
    /* renamed from: d */
    private static C2906b f12698d;

    /* renamed from: a */
    public static boolean m10971a() {
        return f12695a.get();
    }

    /* renamed from: b */
    public static boolean m10973b() {
        return f12696b.get();
    }

    /* renamed from: a */
    public static void m10970a(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f12697c == null) {
            f12697c = application;
        }
        VIContext.init(application);
    }

    /* renamed from: b */
    public static void m10972b(Application application) {
        if (application == null) {
            throw new RuntimeException();
        } else if (f12697c == null) {
            f12697c = application;
        }
    }

    /* renamed from: c */
    public static void m10974c() {
        while (true) {
            boolean now = f12695a.get();
            if (!now) {
                if (f12695a.compareAndSet(now, true)) {
                    f12698d = new C2906b();
                    if (!f12698d.m10966a(f12697c)) {
                        Process.killProcess(Process.myPid());
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m10975d() {
        while (true) {
            boolean now = f12696b.get();
            if (!now) {
                if (f12696b.compareAndSet(now, true)) {
                    C2908b.f12699a.m10986a();
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    public static void m10976e() {
        MapDataEngine.destroy();
        C2910f.m10993c();
        C2905c mLogStatistics = C2905c.m10957a();
        if (mLogStatistics != null) {
            mLogStatistics.m10962b();
        }
        SysOSAPIv2.getInstance().destroy();
        f12698d.m10969d();
    }

    /* renamed from: f */
    public static Context m10977f() {
        return f12697c;
    }
}
