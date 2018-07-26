package com.baidu.carlife.p059c.p067g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: Workers */
/* renamed from: com.baidu.carlife.c.g.b */
public class C1148b {
    /* renamed from: a */
    private static final int f2941a = 4;
    /* renamed from: b */
    private Executor f2942b;
    /* renamed from: c */
    private Executor f2943c;
    /* renamed from: d */
    private Handler f2944d;

    /* compiled from: Workers */
    /* renamed from: com.baidu.carlife.c.g.b$a */
    private static final class C1147a {
        /* renamed from: a */
        private static final C1148b f2940a = new C1148b();

        private C1147a() {
        }
    }

    /* renamed from: a */
    public static C1148b m3848a() {
        return C1147a.f2940a;
    }

    private C1148b() {
        this.f2942b = Executors.newSingleThreadExecutor();
        this.f2943c = Executors.newFixedThreadPool(4);
        this.f2944d = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public void m3849a(Runnable command) {
        this.f2944d.post(command);
    }

    /* renamed from: b */
    public void m3850b(Runnable command) {
        this.f2942b.execute(command);
    }

    /* renamed from: c */
    public void m3851c(Runnable command) {
        this.f2943c.execute(command);
    }
}
