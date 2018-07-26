package com.facebook.common.p140h;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p257e.C5320a;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
/* compiled from: SharedReference */
/* renamed from: com.facebook.common.h.d */
public class C5331d<T> {
    @GuardedBy("itself")
    /* renamed from: a */
    private static final Map<Object, Integer> f21911a = new IdentityHashMap();
    @GuardedBy("this")
    /* renamed from: b */
    private T f21912b;
    @GuardedBy("this")
    /* renamed from: c */
    private int f21913c = 1;
    /* renamed from: d */
    private final C5329c<T> f21914d;

    /* compiled from: SharedReference */
    /* renamed from: com.facebook.common.h.d$a */
    public static class C5330a extends RuntimeException {
        public C5330a() {
            super("Null shared reference");
        }
    }

    public C5331d(T value, C5329c<T> resourceReleaser) {
        this.f21912b = C5350k.m18310a((Object) value);
        this.f21914d = (C5329c) C5350k.m18310a((Object) resourceReleaser);
        C5331d.m18249a((Object) value);
    }

    /* renamed from: a */
    private static void m18249a(Object value) {
        synchronized (f21911a) {
            Integer count = (Integer) f21911a.get(value);
            if (count == null) {
                f21911a.put(value, Integer.valueOf(1));
            } else {
                f21911a.put(value, Integer.valueOf(count.intValue() + 1));
            }
        }
    }

    /* renamed from: b */
    private static void m18251b(Object value) {
        synchronized (f21911a) {
            Integer count = (Integer) f21911a.get(value);
            if (count == null) {
                C5320a.m18194f("SharedReference", "No entry in sLiveObjects for value of type %s", value.getClass());
            } else if (count.intValue() == 1) {
                f21911a.remove(value);
            } else {
                f21911a.put(value, Integer.valueOf(count.intValue() - 1));
            }
        }
    }

    /* renamed from: a */
    public synchronized T m18254a() {
        return this.f21912b;
    }

    /* renamed from: b */
    public synchronized boolean m18255b() {
        return this.f21913c > 0;
    }

    /* renamed from: a */
    public static boolean m18250a(C5331d<?> ref) {
        return ref != null && ref.m18255b();
    }

    /* renamed from: c */
    public synchronized void m18256c() {
        m18253g();
        this.f21913c++;
    }

    /* renamed from: d */
    public void m18257d() {
        if (m18252f() == 0) {
            T deleted;
            synchronized (this) {
                deleted = this.f21912b;
                this.f21912b = null;
            }
            this.f21914d.mo4017a(deleted);
            C5331d.m18251b(deleted);
        }
    }

    /* renamed from: f */
    private synchronized int m18252f() {
        m18253g();
        C5350k.m18315a(this.f21913c > 0);
        this.f21913c--;
        return this.f21913c;
    }

    /* renamed from: g */
    private void m18253g() {
        if (!C5331d.m18250a(this)) {
            throw new C5330a();
        }
    }

    /* renamed from: e */
    public synchronized int m18258e() {
        return this.f21913c;
    }
}
