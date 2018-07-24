package com.baidu.carlife.p059c.p064d;

import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.carlife.p059c.p067g.C1148b;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LiveData */
/* renamed from: com.baidu.carlife.c.d.b */
public abstract class C1114b<T> {
    /* renamed from: a */
    static final int f2890a = -1;
    /* renamed from: c */
    private static final Object f2891c = new Object();
    /* renamed from: b */
    private final Object f2892b = new Object();
    /* renamed from: d */
    private C1124e<C1116d<T>, C1113a> f2893d = new C1124e();
    /* renamed from: e */
    private volatile Object f2894e = f2891c;
    /* renamed from: f */
    private volatile Object f2895f = f2891c;
    /* renamed from: g */
    private int f2896g = -1;
    /* renamed from: h */
    private boolean f2897h;
    /* renamed from: i */
    private boolean f2898i;
    /* renamed from: j */
    private final Runnable f2899j = new C11111(this);

    /* compiled from: LiveData */
    /* renamed from: com.baidu.carlife.c.d.b$1 */
    class C11111 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1114b f2885a;

        C11111(C1114b this$0) {
            this.f2885a = this$0;
        }

        public void run() {
            Object newValue;
            synchronized (this.f2885a.f2892b) {
                newValue = this.f2885a.f2895f;
                this.f2885a.f2895f = C1114b.f2891c;
            }
            this.f2885a.mo1419b(newValue);
        }
    }

    /* compiled from: LiveData */
    /* renamed from: com.baidu.carlife.c.d.b$2 */
    class C11122 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1114b f2886a;

        C11122(C1114b this$0) {
            this.f2886a = this$0;
        }

        public void run() {
            this.f2886a.m3757b(null);
        }
    }

    /* compiled from: LiveData */
    /* renamed from: com.baidu.carlife.c.d.b$a */
    private final class C1113a {
        /* renamed from: a */
        public int f2887a = -1;
        /* renamed from: b */
        public final C1116d<T> f2888b;
        /* renamed from: c */
        final /* synthetic */ C1114b f2889c;

        C1113a(C1114b c1114b, C1116d<T> observer) {
            this.f2889c = c1114b;
            this.f2888b = observer;
        }
    }

    /* renamed from: a */
    private void m3753a(C1113a observer) {
        if (observer.f2887a < this.f2896g) {
            observer.f2887a = this.f2896g;
            observer.f2888b.mo1601a(this.f2894e);
        }
    }

    /* renamed from: b */
    private void m3757b(@Nullable C1113a initiator) {
        if (this.f2897h) {
            this.f2898i = true;
            return;
        }
        this.f2897h = true;
        do {
            this.f2898i = false;
            if (initiator == null) {
                Iterator<Entry<C1116d<T>, C1113a>> iterator = this.f2893d.m3786c();
                while (iterator.hasNext()) {
                    m3753a((C1113a) ((Entry) iterator.next()).getValue());
                    if (this.f2898i) {
                        break;
                    }
                }
            }
            m3753a((C1113a) initiator);
            initiator = null;
        } while (this.f2898i);
        this.f2897h = false;
    }

    @MainThread
    /* renamed from: a */
    public void m3760a(@NonNull C1116d<T> observer) {
        this.f2893d.m3782a(observer, new C1113a(this, observer));
    }

    @MainThread
    /* renamed from: b */
    public void m3763b(@NonNull C1116d<T> observer) {
        m3755a("removeObserver");
        this.f2893d.m3784b(observer);
    }

    @MainThread
    /* renamed from: a */
    public void m3759a() {
        m3755a("removeObservers");
        Iterator it = this.f2893d.iterator();
        while (it.hasNext()) {
            m3763b((C1116d) ((Entry) it.next()).getKey());
        }
    }

    /* renamed from: a */
    protected void mo1418a(T value) {
        synchronized (this.f2892b) {
            boolean postTask = this.f2895f == f2891c;
            this.f2895f = value;
        }
        if (postTask) {
            C1148b.m3848a().m3849a(this.f2899j);
        }
    }

    /* renamed from: b */
    protected void mo1419b(T value) {
        this.f2896g++;
        this.f2894e = value;
        C1148b.m3848a().m3849a(new C11122(this));
    }

    @Nullable
    /* renamed from: b */
    public T m3762b() {
        Object data = this.f2894e;
        return data != f2891c ? data : null;
    }

    /* renamed from: c */
    int m3765c() {
        return this.f2896g;
    }

    /* renamed from: a */
    private void m3755a(String methodName) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Cannot invoke " + methodName + " on a background thread");
        }
    }

    /* renamed from: d */
    public boolean m3766d() {
        return this.f2893d.m3780a() > 0;
    }
}
