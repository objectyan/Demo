package com.facebook.imagepipeline.p153l;

import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.imagepipeline.p276e.C5494c;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: BaseProducerContext */
/* renamed from: com.facebook.imagepipeline.l.d */
public class C2954d implements aj {
    /* renamed from: a */
    private final C2959c f13166a;
    /* renamed from: b */
    private final String f13167b;
    /* renamed from: c */
    private final al f13168c;
    /* renamed from: d */
    private final Object f13169d;
    /* renamed from: e */
    private final c$b f13170e;
    @GuardedBy("this")
    /* renamed from: f */
    private boolean f13171f;
    @GuardedBy("this")
    /* renamed from: g */
    private C5494c f13172g;
    @GuardedBy("this")
    /* renamed from: h */
    private boolean f13173h;
    @GuardedBy("this")
    /* renamed from: i */
    private boolean f13174i = false;
    @GuardedBy("this")
    /* renamed from: j */
    private final List<ak> f13175j = new ArrayList();

    public C2954d(C2959c imageRequest, String id, al producerListener, Object callerContext, c$b lowestPermittedRequestLevel, boolean isPrefetch, boolean isIntermediateResultExpected, C5494c priority) {
        this.f13166a = imageRequest;
        this.f13167b = id;
        this.f13168c = producerListener;
        this.f13169d = callerContext;
        this.f13170e = lowestPermittedRequestLevel;
        this.f13171f = isPrefetch;
        this.f13172g = priority;
        this.f13173h = isIntermediateResultExpected;
    }

    /* renamed from: a */
    public C2959c m11881a() {
        return this.f13166a;
    }

    /* renamed from: b */
    public String m11885b() {
        return this.f13167b;
    }

    /* renamed from: c */
    public al m11887c() {
        return this.f13168c;
    }

    /* renamed from: d */
    public Object m11888d() {
        return this.f13169d;
    }

    /* renamed from: e */
    public c$b m11889e() {
        return this.f13170e;
    }

    /* renamed from: f */
    public synchronized boolean m11890f() {
        return this.f13171f;
    }

    /* renamed from: g */
    public synchronized C5494c m11891g() {
        return this.f13172g;
    }

    /* renamed from: h */
    public synchronized boolean m11892h() {
        return this.f13173h;
    }

    /* renamed from: i */
    public synchronized boolean m11893i() {
        return this.f13174i;
    }

    /* renamed from: a */
    public void m11884a(ak callbacks) {
        boolean cancelImmediately = false;
        synchronized (this) {
            this.f13175j.add(callbacks);
            if (this.f13174i) {
                cancelImmediately = true;
            }
        }
        if (cancelImmediately) {
            callbacks.a();
        }
    }

    /* renamed from: j */
    public void m11894j() {
        C2954d.m11877a(m11895k());
    }

    @Nullable
    /* renamed from: a */
    public synchronized List<ak> m11883a(boolean isPrefetch) {
        List<ak> list;
        if (isPrefetch == this.f13171f) {
            list = null;
        } else {
            this.f13171f = isPrefetch;
            list = new ArrayList(this.f13175j);
        }
        return list;
    }

    @Nullable
    /* renamed from: a */
    public synchronized List<ak> m11882a(C5494c priority) {
        List<ak> list;
        if (priority == this.f13172g) {
            list = null;
        } else {
            this.f13172g = priority;
            list = new ArrayList(this.f13175j);
        }
        return list;
    }

    @Nullable
    /* renamed from: b */
    public synchronized List<ak> m11886b(boolean isIntermediateResultExpected) {
        List<ak> list;
        if (isIntermediateResultExpected == this.f13173h) {
            list = null;
        } else {
            this.f13173h = isIntermediateResultExpected;
            list = new ArrayList(this.f13175j);
        }
        return list;
    }

    @Nullable
    /* renamed from: k */
    public synchronized List<ak> m11895k() {
        List<ak> list;
        if (this.f13174i) {
            list = null;
        } else {
            this.f13174i = true;
            list = new ArrayList(this.f13175j);
        }
        return list;
    }

    /* renamed from: a */
    public static void m11877a(@Nullable List<ak> callbacks) {
        if (callbacks != null) {
            for (ak callback : callbacks) {
                callback.a();
            }
        }
    }

    /* renamed from: b */
    public static void m11878b(@Nullable List<ak> callbacks) {
        if (callbacks != null) {
            for (ak callback : callbacks) {
                callback.b();
            }
        }
    }

    /* renamed from: c */
    public static void m11879c(@Nullable List<ak> callbacks) {
        if (callbacks != null) {
            for (ak callback : callbacks) {
                callback.c();
            }
        }
    }

    /* renamed from: d */
    public static void m11880d(@Nullable List<ak> callbacks) {
        if (callbacks != null) {
            for (ak callback : callbacks) {
                callback.d();
            }
        }
    }
}
