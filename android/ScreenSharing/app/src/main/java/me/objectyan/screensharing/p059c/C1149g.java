package com.baidu.carlife.p059c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.p059c.C1105d.C1091a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TaskScheduler */
/* renamed from: com.baidu.carlife.c.g */
public class C1149g {
    /* renamed from: a */
    private static final int f2945a = 5;
    /* renamed from: b */
    private static final int f2946b = 10;
    /* renamed from: c */
    private static final int f2947c = 60;
    /* renamed from: d */
    private Handler f2948d = new Handler(Looper.getMainLooper());
    /* renamed from: e */
    private ThreadPoolExecutor f2949e = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(5));

    /* renamed from: a */
    public static C1149g m3852a() {
        return new C1149g();
    }

    private C1149g() {
    }

    /* renamed from: a */
    public <R> void m3854a(final R output, final C1091a<R> taskCallback) {
        this.f2948d.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1149g f2935c;

            public void run() {
                taskCallback.mo1409a(output);
            }
        });
    }

    /* renamed from: a */
    public <R> void m3853a(final C1091a<R> taskCallback) {
        this.f2948d.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1149g f2937b;

            public void run() {
                taskCallback.mo1408a();
            }
        });
    }

    /* renamed from: b */
    public <R> void m3856b(final C1091a<R> taskCallback) {
        this.f2948d.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1149g f2939b;

            public void run() {
                taskCallback.mo1410b();
            }
        });
    }

    /* renamed from: a */
    public void m3855a(Runnable runnable) {
        this.f2949e.submit(runnable);
    }
}
