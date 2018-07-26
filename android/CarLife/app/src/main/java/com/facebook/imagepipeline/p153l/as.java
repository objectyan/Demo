package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5350k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* compiled from: ThreadHandoffProducerQueue */
/* renamed from: com.facebook.imagepipeline.l.as */
public class as {
    /* renamed from: a */
    private boolean f22553a = false;
    /* renamed from: b */
    private final Deque<Runnable> f22554b;
    /* renamed from: c */
    private final Executor f22555c;

    public as(Executor executor) {
        this.f22555c = (Executor) C5350k.m18310a((Object) executor);
        this.f22554b = new ArrayDeque();
    }

    /* renamed from: a */
    public synchronized void m19260a(Runnable runnable) {
        if (this.f22553a) {
            this.f22554b.add(runnable);
        } else {
            this.f22555c.execute(runnable);
        }
    }

    /* renamed from: a */
    public synchronized void m19259a() {
        this.f22553a = true;
    }

    /* renamed from: b */
    public synchronized void m19261b() {
        this.f22553a = false;
        m19258d();
    }

    /* renamed from: d */
    private void m19258d() {
        while (!this.f22554b.isEmpty()) {
            this.f22555c.execute((Runnable) this.f22554b.pop());
        }
        this.f22554b.clear();
    }

    /* renamed from: b */
    public synchronized void m19262b(Runnable runnable) {
        this.f22554b.remove(runnable);
    }

    /* renamed from: c */
    public synchronized boolean m19263c() {
        return this.f22553a;
    }
}
