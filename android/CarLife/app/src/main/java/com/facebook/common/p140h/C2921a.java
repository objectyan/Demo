package com.facebook.common.p140h;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: CloseableReference */
/* renamed from: com.facebook.common.h.a */
public final class C2921a<T> implements Closeable, Cloneable {
    /* renamed from: a */
    private static Class<C2921a> f12880a = C2921a.class;
    /* renamed from: b */
    private static final C5329c<Closeable> f12881b = new a$1();
    @GuardedBy("this")
    /* renamed from: c */
    private boolean f12882c = false;
    /* renamed from: d */
    private final C5331d<T> f12883d;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m11261b();
    }

    private C2921a(C5331d<T> sharedReference) {
        this.f12883d = (C5331d) C5350k.a(sharedReference);
        sharedReference.c();
    }

    private C2921a(T t, C5329c<T> resourceReleaser) {
        this.f12883d = new C5331d(t, resourceReleaser);
    }

    @Nullable
    /* renamed from: a */
    public static <T extends Closeable> C2921a<T> m11253a(@Nullable T t) {
        if (t == null) {
            return null;
        }
        return new C2921a(t, f12881b);
    }

    @Nullable
    /* renamed from: a */
    public static <T> C2921a<T> m11254a(@Nullable T t, C5329c<T> resourceReleaser) {
        if (t == null) {
            return null;
        }
        return new C2921a(t, resourceReleaser);
    }

    public void close() {
        synchronized (this) {
            if (this.f12882c) {
                return;
            }
            this.f12882c = true;
            this.f12883d.d();
        }
    }

    /* renamed from: a */
    public synchronized T m11260a() {
        C5350k.b(!this.f12882c);
        return this.f12883d.a();
    }

    /* renamed from: b */
    public synchronized C2921a<T> m11261b() {
        C5350k.b(m11263d());
        return new C2921a(this.f12883d);
    }

    /* renamed from: c */
    public synchronized C2921a<T> m11262c() {
        return m11263d() ? new C2921a(this.f12883d) : null;
    }

    /* renamed from: d */
    public synchronized boolean m11263d() {
        return !this.f12882c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void finalize() throws java.lang.Throwable {
        /*
        r5 = this;
        monitor-enter(r5);	 Catch:{ all -> 0x0049 }
        r0 = r5.f12882c;	 Catch:{ all -> 0x0046 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        monitor-exit(r5);	 Catch:{ all -> 0x0046 }
        super.finalize();
    L_0x0009:
        return;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0046 }
        r0 = f12880a;	 Catch:{ all -> 0x0049 }
        r1 = "Finalized without closing: %x %x (type = %s)";
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0049 }
        r3 = 0;
        r4 = java.lang.System.identityHashCode(r5);	 Catch:{ all -> 0x0049 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0049 }
        r2[r3] = r4;	 Catch:{ all -> 0x0049 }
        r3 = 1;
        r4 = r5.f12883d;	 Catch:{ all -> 0x0049 }
        r4 = java.lang.System.identityHashCode(r4);	 Catch:{ all -> 0x0049 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0049 }
        r2[r3] = r4;	 Catch:{ all -> 0x0049 }
        r3 = 2;
        r4 = r5.f12883d;	 Catch:{ all -> 0x0049 }
        r4 = r4.a();	 Catch:{ all -> 0x0049 }
        r4 = r4.getClass();	 Catch:{ all -> 0x0049 }
        r4 = r4.getSimpleName();	 Catch:{ all -> 0x0049 }
        r2[r3] = r4;	 Catch:{ all -> 0x0049 }
        com.facebook.common.p257e.C5320a.d(r0, r1, r2);	 Catch:{ all -> 0x0049 }
        r5.close();	 Catch:{ all -> 0x0049 }
        super.finalize();
        goto L_0x0009;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0046 }
        throw r0;	 Catch:{ all -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        super.finalize();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.h.a.finalize():void");
    }

    @VisibleForTesting
    /* renamed from: e */
    public synchronized C5331d<T> m11264e() {
        return this.f12883d;
    }

    /* renamed from: f */
    public synchronized int m11265f() {
        return m11263d() ? System.identityHashCode(this.f12883d.a()) : 0;
    }

    /* renamed from: a */
    public static boolean m11257a(@Nullable C2921a<?> ref) {
        return ref != null && ref.m11263d();
    }

    @Nullable
    /* renamed from: b */
    public static <T> C2921a<T> m11258b(@Nullable C2921a<T> ref) {
        return ref != null ? ref.m11262c() : null;
    }

    /* renamed from: a */
    public static <T> List<C2921a<T>> m11255a(Collection<C2921a<T>> refs) {
        if (refs == null) {
            return null;
        }
        List<C2921a<T>> ret = new ArrayList(refs.size());
        for (C2921a<T> ref : refs) {
            ret.add(C2921a.m11258b(ref));
        }
        return ret;
    }

    /* renamed from: c */
    public static void m11259c(@Nullable C2921a<?> ref) {
        if (ref != null) {
            ref.close();
        }
    }

    /* renamed from: a */
    public static void m11256a(@Nullable Iterable<? extends C2921a<?>> references) {
        if (references != null) {
            for (C2921a<?> ref : references) {
                C2921a.m11259c(ref);
            }
        }
    }
}
