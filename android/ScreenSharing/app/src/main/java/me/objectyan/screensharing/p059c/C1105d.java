package com.baidu.carlife.p059c;

/* compiled from: BaseTask */
/* renamed from: com.baidu.carlife.c.d */
public abstract class C1105d<T, R> {
    /* renamed from: a */
    private C1091a<R> f2880a;

    /* compiled from: BaseTask */
    /* renamed from: com.baidu.carlife.c.d$a */
    public interface C1091a<R> {
        /* renamed from: a */
        void mo1408a();

        /* renamed from: a */
        void mo1409a(R r);

        /* renamed from: b */
        void mo1410b();
    }

    /* renamed from: a */
    public abstract void mo1417a(T t);

    /* renamed from: a */
    public C1091a<R> m3729a() {
        return this.f2880a;
    }

    /* renamed from: a */
    public void m3730a(C1091a<R> taskCallback) {
        this.f2880a = taskCallback;
    }
}
