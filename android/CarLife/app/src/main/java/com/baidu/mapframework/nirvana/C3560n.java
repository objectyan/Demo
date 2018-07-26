package com.baidu.mapframework.nirvana;

import android.util.Log;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utils */
/* renamed from: com.baidu.mapframework.nirvana.n */
public class C3560n {
    /* renamed from: a */
    private static final String f19221a = "NIRVANA";

    /* renamed from: a */
    public static void m15209a(@NotNull String tag, @NotNull String msg) {
        if (C3541e.m15173a()) {
            Log.i(tag, msg);
        }
    }

    /* renamed from: a */
    public static void m15208a(@NotNull String msg) {
        if (C3541e.m15173a()) {
            Log.d(f19221a, msg);
        }
    }

    /* renamed from: b */
    public static void m15214b(@NotNull String tag, @NotNull String msg) {
        if (C3541e.m15173a()) {
            Log.d(tag, msg);
        }
    }

    /* renamed from: a */
    public static void m15211a(@NotNull String msg, @NotNull Throwable e) {
        Log.e(f19221a, msg, e);
    }

    /* renamed from: c */
    public static void m15215c(@NotNull String tag, @NotNull String msg) {
        Log.e(tag, msg);
    }

    /* renamed from: a */
    public static void m15210a(@NotNull String tag, @NotNull String msg, @NotNull Throwable e) {
        Log.e(tag, msg, e);
    }

    /* renamed from: a */
    public static void m15212a(boolean expression, String failedMessage) {
        if (C3541e.m15173a() && !expression) {
            throw new AssertionError(failedMessage);
        }
    }

    /* renamed from: a */
    public static boolean m15213a(Module module, C3480g task, ScheduleConfig config) {
        boolean z;
        C3560n.m15212a(module != null, "executeTask module 不能为空");
        if (task != null) {
            z = true;
        } else {
            z = false;
        }
        C3560n.m15212a(z, "executeTask task 不能为空");
        if (config != null) {
            z = true;
        } else {
            z = false;
        }
        C3560n.m15212a(z, "executeTask config 不能为空");
        if (module != null && task != null && config != null) {
            return true;
        }
        C3560n.m15211a("executeTask param error", new Throwable());
        return false;
    }
}
