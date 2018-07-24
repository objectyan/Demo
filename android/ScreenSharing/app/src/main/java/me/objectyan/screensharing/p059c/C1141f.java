package com.baidu.carlife.p059c;

import com.baidu.carlife.p059c.C1105d.C1091a;

/* compiled from: TaskExecutor */
/* renamed from: com.baidu.carlife.c.f */
public class C1141f {
    /* renamed from: a */
    private C1149g f2932a;

    /* compiled from: TaskExecutor */
    /* renamed from: com.baidu.carlife.c.f$a */
    private static final class C1137a {
        /* renamed from: a */
        private static final C1141f f2929a = new C1141f();

        private C1137a() {
        }
    }

    /* compiled from: TaskExecutor */
    /* renamed from: com.baidu.carlife.c.f$b */
    private static final class C1138b<R> implements C1091a<R> {
        /* renamed from: a */
        private C1091a f2930a;
        /* renamed from: b */
        private C1141f f2931b;

        public C1138b(C1091a<R> taskCallback, C1141f taskExecutor) {
            this.f2930a = taskCallback;
            this.f2931b = taskExecutor;
        }

        /* renamed from: a */
        public void mo1409a(R output) {
            this.f2931b.m3842a(output, this.f2930a);
        }

        /* renamed from: a */
        public void mo1408a() {
            this.f2931b.m3840a(this.f2930a);
        }

        /* renamed from: b */
        public void mo1410b() {
            this.f2931b.m3843b(this.f2930a);
        }
    }

    /* renamed from: a */
    public static C1141f m3839a() {
        return C1137a.f2929a;
    }

    private C1141f() {
        this.f2932a = C1149g.m3852a();
    }

    /* renamed from: a */
    public <T, R> void m3841a(final C1105d<T, R> baseTask, final T input, C1091a<R> taskCallback) {
        baseTask.m3730a(new C1138b(taskCallback, this));
        this.f2932a.m3855a(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1141f f2928c;

            public void run() {
                baseTask.mo1417a(input);
            }
        });
    }

    /* renamed from: a */
    public <R> void m3842a(R output, C1091a<R> taskCallback) {
        this.f2932a.m3854a(output, taskCallback);
    }

    /* renamed from: a */
    public <R> void m3840a(C1091a<R> taskCallback) {
        this.f2932a.m3853a((C1091a) taskCallback);
    }

    /* renamed from: b */
    public <R> void m3843b(C1091a<R> taskCallback) {
        this.f2932a.m3856b(taskCallback);
    }
}
