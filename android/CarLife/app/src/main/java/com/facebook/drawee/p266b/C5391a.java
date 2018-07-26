package com.facebook.drawee.p266b;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.C5350k;
import java.util.HashSet;
import java.util.Set;

/* compiled from: DeferredReleaser */
/* renamed from: com.facebook.drawee.b.a */
public class C5391a {
    /* renamed from: a */
    private static C5391a f22000a = null;
    /* renamed from: b */
    private final Set<C5390a> f22001b = new HashSet();
    /* renamed from: c */
    private final Handler f22002c = new Handler(Looper.getMainLooper());
    /* renamed from: d */
    private final Runnable f22003d = new C53891(this);

    /* compiled from: DeferredReleaser */
    /* renamed from: com.facebook.drawee.b.a$1 */
    class C53891 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5391a f21999a;

        C53891(C5391a this$0) {
            this.f21999a = this$0;
        }

        public void run() {
            C5391a.m18440c();
            for (C5390a releasable : this.f21999a.f22001b) {
                releasable.m18436f();
            }
            this.f21999a.f22001b.clear();
        }
    }

    /* compiled from: DeferredReleaser */
    /* renamed from: com.facebook.drawee.b.a$a */
    public interface C5390a {
        /* renamed from: f */
        void m18436f();
    }

    /* renamed from: a */
    public static synchronized C5391a m18437a() {
        C5391a c5391a;
        synchronized (C5391a.class) {
            if (f22000a == null) {
                f22000a = new C5391a();
            }
            c5391a = f22000a;
        }
        return c5391a;
    }

    /* renamed from: a */
    public void m18441a(C5390a releasable) {
        C5391a.m18440c();
        if (this.f22001b.add(releasable) && this.f22001b.size() == 1) {
            this.f22002c.post(this.f22003d);
        }
    }

    /* renamed from: b */
    public void m18442b(C5390a releasable) {
        C5391a.m18440c();
        this.f22001b.remove(releasable);
    }

    /* renamed from: c */
    private static void m18440c() {
        C5350k.m18321b(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
