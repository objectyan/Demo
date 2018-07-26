package com.facebook.common.p256c;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StatefulRunnable */
/* renamed from: com.facebook.common.c.h */
public abstract class C5312h<T> implements Runnable {
    /* renamed from: a */
    protected static final int f21886a = 0;
    /* renamed from: b */
    protected static final int f21887b = 1;
    /* renamed from: c */
    protected static final int f21888c = 2;
    /* renamed from: d */
    protected static final int f21889d = 3;
    /* renamed from: e */
    protected static final int f21890e = 4;
    /* renamed from: f */
    protected final AtomicInteger f21891f = new AtomicInteger(0);

    /* renamed from: c */
    protected abstract T mo4129c() throws Exception;

    public final void run() {
        if (this.f21891f.compareAndSet(0, 1)) {
            try {
                Object result = mo4129c();
                this.f21891f.set(3);
                try {
                    mo4126a(result);
                } finally {
                    mo4128b(result);
                }
            } catch (Exception e) {
                this.f21891f.set(4);
                mo4125a(e);
            }
        }
    }

    /* renamed from: a */
    public void m18106a() {
        if (this.f21891f.compareAndSet(0, 2)) {
            mo4127b();
        }
    }

    /* renamed from: a */
    protected void mo4126a(T t) {
    }

    /* renamed from: a */
    protected void mo4125a(Exception e) {
    }

    /* renamed from: b */
    protected void mo4127b() {
    }

    /* renamed from: b */
    protected void mo4128b(T t) {
    }
}
