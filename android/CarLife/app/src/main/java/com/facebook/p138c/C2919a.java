package com.facebook.p138c;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: AbstractDataSource */
/* renamed from: com.facebook.c.a */
public abstract class C2919a<T> implements C2918d<T> {
    @GuardedBy("this")
    /* renamed from: a */
    private a$a f12866a = a$a.f21861a;
    @GuardedBy("this")
    /* renamed from: b */
    private boolean f12867b = false;
    @GuardedBy("this")
    @Nullable
    /* renamed from: c */
    private T f12868c = null;
    @GuardedBy("this")
    /* renamed from: d */
    private Throwable f12869d = null;
    @GuardedBy("this")
    /* renamed from: e */
    private float f12870e = 0.0f;
    /* renamed from: f */
    private final ConcurrentLinkedQueue<Pair<C5287f<T>, Executor>> f12871f = new ConcurrentLinkedQueue();

    protected C2919a() {
    }

    /* renamed from: a */
    public synchronized boolean mo2012a() {
        return this.f12867b;
    }

    /* renamed from: b */
    public synchronized boolean mo2013b() {
        return this.f12866a != a$a.f21861a;
    }

    /* renamed from: c */
    public synchronized boolean mo2014c() {
        return this.f12868c != null;
    }

    @Nullable
    /* renamed from: d */
    public synchronized T mo2015d() {
        return this.f12868c;
    }

    /* renamed from: e */
    public synchronized boolean mo2016e() {
        return this.f12866a == a$a.f21863c;
    }

    @Nullable
    /* renamed from: f */
    public synchronized Throwable mo2017f() {
        return this.f12869d;
    }

    /* renamed from: g */
    public synchronized float mo2018g() {
        return this.f12870e;
    }

    /* renamed from: h */
    public boolean mo2019h() {
        boolean z = true;
        synchronized (this) {
            if (this.f12867b) {
                z = false;
            } else {
                this.f12867b = true;
                Object resultToClose = this.f12868c;
                this.f12868c = null;
                if (resultToClose != null) {
                    mo2043a(resultToClose);
                }
                if (!mo2013b()) {
                    mo2042j();
                }
                synchronized (this) {
                    this.f12871f.clear();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    protected void mo2043a(@Nullable T t) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo2011a(com.facebook.p138c.C5287f<T> r4, java.util.concurrent.Executor r5) {
        /*
        r3 = this;
        com.facebook.common.internal.C5350k.a(r4);
        com.facebook.common.internal.C5350k.a(r5);
        monitor-enter(r3);
        r1 = r3.f12867b;	 Catch:{ all -> 0x0040 }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r3);	 Catch:{ all -> 0x0040 }
    L_0x000c:
        return;
    L_0x000d:
        r1 = r3.f12866a;	 Catch:{ all -> 0x0040 }
        r2 = com.facebook.p138c.a$a.f21861a;	 Catch:{ all -> 0x0040 }
        if (r1 != r2) goto L_0x001c;
    L_0x0013:
        r1 = r3.f12871f;	 Catch:{ all -> 0x0040 }
        r2 = android.util.Pair.create(r4, r5);	 Catch:{ all -> 0x0040 }
        r1.add(r2);	 Catch:{ all -> 0x0040 }
    L_0x001c:
        r1 = r3.mo2014c();	 Catch:{ all -> 0x0040 }
        if (r1 != 0) goto L_0x002e;
    L_0x0022:
        r1 = r3.mo2013b();	 Catch:{ all -> 0x0040 }
        if (r1 != 0) goto L_0x002e;
    L_0x0028:
        r1 = r3.mo2046k();	 Catch:{ all -> 0x0040 }
        if (r1 == 0) goto L_0x003e;
    L_0x002e:
        r0 = 1;
    L_0x002f:
        monitor-exit(r3);	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x000c;
    L_0x0032:
        r1 = r3.mo2016e();
        r2 = r3.mo2046k();
        r3.m11201a(r4, r5, r1, r2);
        goto L_0x000c;
    L_0x003e:
        r0 = 0;
        goto L_0x002f;
    L_0x0040:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0040 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.c.a.a(com.facebook.c.f, java.util.concurrent.Executor):void");
    }

    /* renamed from: j */
    private void mo2042j() {
        boolean isFailure = mo2016e();
        boolean isCancellation = mo2046k();
        Iterator it = this.f12871f.iterator();
        while (it.hasNext()) {
            Pair<C5287f<T>, Executor> pair = (Pair) it.next();
            m11201a((C5287f) pair.first, (Executor) pair.second, isFailure, isCancellation);
        }
    }

    /* renamed from: a */
    private void m11201a(C5287f<T> dataSubscriber, Executor executor, boolean isFailure, boolean isCancellation) {
        executor.execute(new a$1(this, isFailure, dataSubscriber, isCancellation));
    }

    /* renamed from: k */
    private synchronized boolean mo2046k() {
        boolean z;
        z = mo2012a() && !mo2013b();
        return z;
    }

    /* renamed from: a */
    protected boolean m11211a(@Nullable T value, boolean isLast) {
        boolean result = m11203b(value, isLast);
        if (result) {
            mo2042j();
        }
        return result;
    }

    /* renamed from: a */
    protected boolean m11212a(Throwable throwable) {
        boolean result = mo2045b(throwable);
        if (result) {
            mo2042j();
        }
        return result;
    }

    /* renamed from: a */
    protected boolean mo2044a(float progress) {
        boolean result = m11202b(progress);
        if (result) {
            m11220i();
        }
        return result;
    }

    /* renamed from: b */
    private boolean m11203b(@Nullable T value, boolean isLast) {
        Object obj = null;
        try {
            boolean z;
            synchronized (this) {
                if (this.f12867b || this.f12866a != a$a.f21861a) {
                    obj = value;
                    z = false;
                } else {
                    if (isLast) {
                        this.f12866a = a$a.f21862b;
                        this.f12870e = 1.0f;
                    }
                    if (this.f12868c != value) {
                        obj = this.f12868c;
                        this.f12868c = value;
                    }
                    z = true;
                    if (obj != null) {
                        mo2043a(obj);
                    }
                }
            }
            return z;
        } finally {
            if (obj != null) {
                mo2043a(obj);
            }
        }
    }

    /* renamed from: b */
    private synchronized boolean mo2045b(Throwable throwable) {
        boolean z;
        if (this.f12867b || this.f12866a != a$a.f21861a) {
            z = false;
        } else {
            this.f12866a = a$a.f21863c;
            this.f12869d = throwable;
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private synchronized boolean m11202b(float progress) {
        boolean z = false;
        synchronized (this) {
            if (!this.f12867b && this.f12866a == a$a.f21861a) {
                if (progress >= this.f12870e) {
                    this.f12870e = progress;
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: i */
    protected void m11220i() {
        Iterator it = this.f12871f.iterator();
        while (it.hasNext()) {
            Pair<C5287f<T>, Executor> pair = (Pair) it.next();
            pair.second.execute(new a$2(this, pair.first));
        }
    }
}
