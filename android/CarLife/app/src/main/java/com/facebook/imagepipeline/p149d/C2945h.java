package com.facebook.imagepipeline.p149d;

import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p258g.C5323a;
import com.facebook.common.p258g.C5324b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: CountingMemoryCache */
/* renamed from: com.facebook.imagepipeline.d.h */
public class C2945h<K, V> implements C5324b, C2944p<K, V> {
    @VisibleForTesting
    /* renamed from: a */
    static final long f13053a = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: b */
    final C2942g<K, C2943b<K, V>> f13054b;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: c */
    final C2942g<K, C2943b<K, V>> f13055c;
    @GuardedBy("this")
    /* renamed from: d */
    protected C5487q f13056d = ((C5487q) this.f13059g.b());
    /* renamed from: e */
    private final C5462v<V> f13057e;
    /* renamed from: f */
    private final h$a f13058f;
    /* renamed from: g */
    private final C5273m<C5487q> f13059g;
    @GuardedBy("this")
    /* renamed from: h */
    private long f13060h = SystemClock.uptimeMillis();

    @VisibleForTesting
    /* compiled from: CountingMemoryCache */
    /* renamed from: com.facebook.imagepipeline.d.h$b */
    static class C2943b<K, V> {
        /* renamed from: a */
        public final K f13048a;
        /* renamed from: b */
        public final C2921a<V> f13049b;
        /* renamed from: c */
        public int f13050c = 0;
        /* renamed from: d */
        public boolean f13051d = false;
        @Nullable
        /* renamed from: e */
        public final h$c<K> f13052e;

        private C2943b(K key, C2921a<V> valueRef, @Nullable h$c<K> observer) {
            this.f13048a = C5350k.a(key);
            this.f13049b = (C2921a) C5350k.a(C2921a.m11258b(valueRef));
            this.f13052e = observer;
        }

        @VisibleForTesting
        /* renamed from: a */
        static <K, V> C2943b<K, V> m11613a(K key, C2921a<V> valueRef, @Nullable h$c<K> observer) {
            return new C2943b(key, valueRef, observer);
        }
    }

    public C2945h(C5462v<V> valueDescriptor, h$a cacheTrimStrategy, C5273m<C5487q> memoryCacheParamsSupplier) {
        this.f13057e = valueDescriptor;
        this.f13054b = new C2942g(m11619a((C5462v) valueDescriptor));
        this.f13055c = new C2942g(m11619a((C5462v) valueDescriptor));
        this.f13058f = cacheTrimStrategy;
        this.f13059g = memoryCacheParamsSupplier;
    }

    /* renamed from: a */
    private C5462v<C2943b<K, V>> m11619a(C5462v<V> evictableValueDescriptor) {
        return new h$1(this, evictableValueDescriptor);
    }

    /* renamed from: a */
    public C2921a<V> mo2040a(K key, C2921a<V> valueRef) {
        return m11639a(key, valueRef, null);
    }

    /* renamed from: a */
    public C2921a<V> m11639a(K key, C2921a<V> valueRef, h$c<K> observer) {
        C2943b<K, V> oldExclusive;
        C5350k.a(key);
        C5350k.a(valueRef);
        m11632h();
        C2921a<V> oldRefToClose = null;
        C2921a<V> clientRef = null;
        synchronized (this) {
            oldExclusive = (C2943b) this.f13054b.m11609c(key);
            C2943b<K, V> oldEntry = (C2943b) this.f13055c.m11609c(key);
            if (oldEntry != null) {
                m11630f(oldEntry);
                oldRefToClose = m11634i(oldEntry);
            }
            if (m11627c(valueRef.m11260a())) {
                C2943b newEntry = C2943b.m11613a(key, valueRef, observer);
                this.f13055c.m11601a(key, newEntry);
                clientRef = m11618a(newEntry);
            }
        }
        C2921a.m11259c(oldRefToClose);
        C2945h.m11628d(oldExclusive);
        m11635i();
        return clientRef;
    }

    /* renamed from: c */
    private synchronized boolean m11627c(V value) {
        boolean z;
        int newValueSize = this.f13057e.a(value);
        z = newValueSize <= this.f13056d.f22315e && m11646d() <= this.f13056d.f22312b - 1 && m11647e() <= this.f13056d.f22311a - newValueSize;
        return z;
    }

    @Nullable
    /* renamed from: a */
    public C2921a<V> mo2039a(K key) {
        C2943b<K, V> oldExclusive;
        C5350k.a(key);
        C2921a<V> clientRef = null;
        synchronized (this) {
            oldExclusive = (C2943b) this.f13054b.m11609c(key);
            C2943b entry = (C2943b) this.f13055c.m11605b((Object) key);
            if (entry != null) {
                clientRef = m11618a(entry);
            }
        }
        C2945h.m11628d(oldExclusive);
        m11632h();
        m11635i();
        return clientRef;
    }

    /* renamed from: a */
    private synchronized C2921a<V> m11618a(C2943b<K, V> entry) {
        m11631g(entry);
        return C2921a.m11254a(entry.f13049b.m11260a(), new h$2(this, entry));
    }

    /* renamed from: b */
    private void m11623b(C2943b<K, V> entry) {
        C2921a<V> oldRefToClose;
        C5350k.a(entry);
        synchronized (this) {
            m11633h(entry);
            boolean isExclusiveAdded = m11626c((C2943b) entry);
            oldRefToClose = m11634i(entry);
        }
        C2921a.m11259c(oldRefToClose);
        if (!isExclusiveAdded) {
            entry = null;
        }
        C2945h.m11629e(entry);
        m11632h();
        m11635i();
    }

    /* renamed from: c */
    private synchronized boolean m11626c(C2943b<K, V> entry) {
        boolean z;
        if (entry.f13051d || entry.f13050c != 0) {
            z = false;
        } else {
            this.f13054b.m11601a(entry.f13048a, entry);
            z = true;
        }
        return z;
    }

    @Nullable
    /* renamed from: b */
    public C2921a<V> m11643b(K key) {
        C5350k.a(key);
        C2921a<V> clientRef = null;
        boolean removed = false;
        synchronized (this) {
            C2943b<K, V> oldExclusive = (C2943b) this.f13054b.m11609c(key);
            if (oldExclusive != null) {
                C2943b<K, V> entry = (C2943b) this.f13055c.m11609c(key);
                C5350k.a(entry);
                C5350k.b(entry.f13050c == 0);
                clientRef = entry.f13049b;
                removed = true;
            }
        }
        if (removed) {
            C2945h.m11628d(oldExclusive);
        }
        return clientRef;
    }

    /* renamed from: a */
    public int mo2038a(Predicate<K> predicate) {
        ArrayList oldExclusives;
        ArrayList oldEntries;
        synchronized (this) {
            oldExclusives = this.f13054b.m11607b((Predicate) predicate);
            oldEntries = this.f13055c.m11607b((Predicate) predicate);
            m11625c(oldEntries);
        }
        m11622a(oldEntries);
        m11624b(oldExclusives);
        m11632h();
        m11635i();
        return oldEntries.size();
    }

    /* renamed from: a */
    public void m11640a() {
        ArrayList oldExclusives;
        ArrayList oldEntries;
        synchronized (this) {
            oldExclusives = this.f13054b.m11612f();
            oldEntries = this.f13055c.m11612f();
            m11625c(oldEntries);
        }
        m11622a(oldEntries);
        m11624b(oldExclusives);
        m11632h();
    }

    /* renamed from: b */
    public synchronized boolean mo2041b(Predicate<K> predicate) {
        return !this.f13055c.m11603a((Predicate) predicate).isEmpty();
    }

    /* renamed from: a */
    public void m11641a(C5323a trimType) {
        ArrayList oldEntries;
        double trimRatio = this.f13058f.a(trimType);
        synchronized (this) {
            oldEntries = m11620a(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.f13055c.m11610d()) * (1.0d - trimRatio))) - m11647e()));
            m11625c(oldEntries);
        }
        m11622a(oldEntries);
        m11624b(oldEntries);
        m11632h();
        m11635i();
    }

    /* renamed from: h */
    private synchronized void m11632h() {
        if (this.f13060h + f13053a <= SystemClock.uptimeMillis()) {
            this.f13060h = SystemClock.uptimeMillis();
            this.f13056d = (C5487q) this.f13059g.b();
        }
    }

    /* renamed from: i */
    private void m11635i() {
        ArrayList oldEntries;
        synchronized (this) {
            oldEntries = m11620a(Math.min(this.f13056d.f22314d, this.f13056d.f22312b - m11646d()), Math.min(this.f13056d.f22313c, this.f13056d.f22311a - m11647e()));
            m11625c(oldEntries);
        }
        m11622a(oldEntries);
        m11624b(oldEntries);
    }

    @Nullable
    /* renamed from: a */
    private synchronized ArrayList<C2943b<K, V>> m11620a(int count, int size) {
        ArrayList<C2943b<K, V>> oldEntries;
        count = Math.max(count, 0);
        size = Math.max(size, 0);
        if (this.f13054b.m11608c() > count || this.f13054b.m11610d() > size) {
            oldEntries = new ArrayList();
            while (true) {
                if (this.f13054b.m11608c() <= count && this.f13054b.m11610d() <= size) {
                    break;
                }
                K key = this.f13054b.m11611e();
                this.f13054b.m11609c(key);
                oldEntries.add(this.f13055c.m11609c(key));
            }
        } else {
            oldEntries = null;
        }
        return oldEntries;
    }

    /* renamed from: a */
    private void m11622a(@Nullable ArrayList<C2943b<K, V>> oldEntries) {
        if (oldEntries != null) {
            Iterator it = oldEntries.iterator();
            while (it.hasNext()) {
                C2921a.m11259c(m11634i((C2943b) it.next()));
            }
        }
    }

    /* renamed from: b */
    private void m11624b(@Nullable ArrayList<C2943b<K, V>> entries) {
        if (entries != null) {
            Iterator it = entries.iterator();
            while (it.hasNext()) {
                C2945h.m11628d((C2943b) it.next());
            }
        }
    }

    /* renamed from: d */
    private static <K, V> void m11628d(@Nullable C2943b<K, V> entry) {
        if (entry != null && entry.f13052e != null) {
            entry.f13052e.a(entry.f13048a, false);
        }
    }

    /* renamed from: e */
    private static <K, V> void m11629e(@Nullable C2943b<K, V> entry) {
        if (entry != null && entry.f13052e != null) {
            entry.f13052e.a(entry.f13048a, true);
        }
    }

    /* renamed from: c */
    private synchronized void m11625c(@Nullable ArrayList<C2943b<K, V>> oldEntries) {
        if (oldEntries != null) {
            Iterator it = oldEntries.iterator();
            while (it.hasNext()) {
                m11630f((C2943b) it.next());
            }
        }
    }

    /* renamed from: f */
    private synchronized void m11630f(C2943b<K, V> entry) {
        boolean z = true;
        synchronized (this) {
            C5350k.a(entry);
            if (entry.f13051d) {
                z = false;
            }
            C5350k.b(z);
            entry.f13051d = true;
        }
    }

    /* renamed from: g */
    private synchronized void m11631g(C2943b<K, V> entry) {
        C5350k.a(entry);
        C5350k.b(!entry.f13051d);
        entry.f13050c++;
    }

    /* renamed from: h */
    private synchronized void m11633h(C2943b<K, V> entry) {
        C5350k.a(entry);
        C5350k.b(entry.f13050c > 0);
        entry.f13050c--;
    }

    @Nullable
    /* renamed from: i */
    private synchronized C2921a<V> m11634i(C2943b<K, V> entry) {
        C2921a<V> c2921a;
        C5350k.a(entry);
        c2921a = (entry.f13051d && entry.f13050c == 0) ? entry.f13049b : null;
        return c2921a;
    }

    /* renamed from: b */
    public synchronized int m11642b() {
        return this.f13055c.m11608c();
    }

    /* renamed from: c */
    public synchronized int m11645c() {
        return this.f13055c.m11610d();
    }

    /* renamed from: d */
    public synchronized int m11646d() {
        return this.f13055c.m11608c() - this.f13054b.m11608c();
    }

    /* renamed from: e */
    public synchronized int m11647e() {
        return this.f13055c.m11610d() - this.f13054b.m11610d();
    }

    /* renamed from: f */
    public synchronized int m11648f() {
        return this.f13054b.m11608c();
    }

    /* renamed from: g */
    public synchronized int m11649g() {
        return this.f13054b.m11610d();
    }
}
