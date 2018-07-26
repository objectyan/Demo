package com.baidu.platform.comapi.util;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;

/* compiled from: Profiler */
/* renamed from: com.baidu.platform.comapi.util.k */
public class C4829k {
    /* renamed from: a */
    private String f19978a;
    /* renamed from: b */
    private long f19979b;
    /* renamed from: c */
    private long f19980c;
    /* renamed from: d */
    private String f19981d;
    /* renamed from: e */
    private String f19982e;
    /* renamed from: f */
    private String f19983f;
    /* renamed from: g */
    private int f19984g;

    public C4829k(String tag) {
        this.f19978a = tag;
        this.f19984g = Process.myPid();
    }

    public C4829k() {
        this("Profiler");
    }

    /* renamed from: a */
    public static void m16016a(String tag, Runnable runnable) {
        C4829k.m16015a(tag, 3, runnable);
    }

    /* renamed from: a */
    public static void m16014a(Runnable runnable) {
        C4829k.m16015a("Profiler", 3, runnable);
    }

    /* renamed from: a */
    private static void m16015a(String tag, int trace, Runnable runnable) {
        C4829k profiler = new C4829k(tag);
        profiler.m16021a(trace);
        runnable.run();
        profiler.m16022b();
    }

    /* renamed from: a */
    public C4829k m16021a(int trace) {
        StackTraceElement element = new Throwable().getStackTrace()[trace];
        this.f19981d = element.getClassName();
        int index = this.f19981d.lastIndexOf(46);
        if (index != -1) {
            this.f19981d = this.f19981d.substring(index + 1);
        }
        this.f19982e = element.getMethodName();
        this.f19983f = element.getFileName();
        return m16018c();
    }

    /* renamed from: a */
    public C4829k m16020a() {
        return m16021a(1);
    }

    /* renamed from: c */
    private C4829k m16018c() {
        if (this.f19979b == 0) {
            this.f19979b = SystemClock.uptimeMillis();
        } else {
            this.f19980c = SystemClock.uptimeMillis() - this.f19979b;
            this.f19979b = 0;
        }
        return this;
    }

    /* renamed from: b */
    public C4829k m16022b() {
        m16018c();
        return m16019d();
    }

    /* renamed from: d */
    private C4829k m16019d() {
        if (this.f19979b == 0) {
            StringBuilder dump = new StringBuilder();
            dump.append(String.format("[%5d ms]", new Object[]{Long.valueOf(this.f19980c)})).append(" ");
            m16017a(dump);
            C2911f.b(this.f19978a, dump.toString());
        }
        return this;
    }

    /* renamed from: a */
    private void m16017a(StringBuilder dump) {
        dump.append("[").append(this.f19982e).append("() <- ").append(this.f19981d).append("] ");
        dump.append("[").append(Looper.myLooper() == Looper.getMainLooper() ? "on UI thread" : "not on UI thread").append("] ");
        dump.append(" <").append(this.f19983f).append("> ");
    }
}
