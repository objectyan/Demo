package com.facebook.imagepipeline.p149d;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: CountingLruMap */
/* renamed from: com.facebook.imagepipeline.d.g */
public class C2942g<K, V> {
    /* renamed from: a */
    private final C5462v<V> f13045a;
    @GuardedBy("this")
    /* renamed from: b */
    private final LinkedHashMap<K, V> f13046b = new LinkedHashMap();
    @GuardedBy("this")
    /* renamed from: c */
    private int f13047c = 0;

    public C2942g(C5462v<V> valueDescriptor) {
        this.f13045a = valueDescriptor;
    }

    @VisibleForTesting
    /* renamed from: a */
    synchronized ArrayList<K> m11602a() {
        return new ArrayList(this.f13046b.keySet());
    }

    @VisibleForTesting
    /* renamed from: b */
    synchronized ArrayList<V> m11606b() {
        return new ArrayList(this.f13046b.values());
    }

    /* renamed from: c */
    public synchronized int m11608c() {
        return this.f13046b.size();
    }

    /* renamed from: d */
    public synchronized int m11610d() {
        return this.f13047c;
    }

    @Nullable
    /* renamed from: e */
    public synchronized K m11611e() {
        return this.f13046b.isEmpty() ? null : this.f13046b.keySet().iterator().next();
    }

    /* renamed from: a */
    public synchronized ArrayList<Entry<K, V>> m11603a(@Nullable Predicate<K> predicate) {
        ArrayList<Entry<K, V>> matchingEntries;
        matchingEntries = new ArrayList();
        for (Entry<K, V> entry : this.f13046b.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                matchingEntries.add(entry);
            }
        }
        return matchingEntries;
    }

    /* renamed from: a */
    public synchronized boolean m11604a(K key) {
        return this.f13046b.containsKey(key);
    }

    @Nullable
    /* renamed from: b */
    public synchronized V m11605b(K key) {
        return this.f13046b.get(key);
    }

    @Nullable
    /* renamed from: a */
    public synchronized V m11601a(K key, V value) {
        V oldValue;
        oldValue = this.f13046b.remove(key);
        this.f13047c -= m11600d(oldValue);
        this.f13046b.put(key, value);
        this.f13047c += m11600d(value);
        return oldValue;
    }

    @Nullable
    /* renamed from: c */
    public synchronized V m11609c(K key) {
        V oldValue;
        oldValue = this.f13046b.remove(key);
        this.f13047c -= m11600d(oldValue);
        return oldValue;
    }

    /* renamed from: b */
    public synchronized ArrayList<V> m11607b(@Nullable Predicate<K> predicate) {
        ArrayList<V> oldValues;
        oldValues = new ArrayList();
        Iterator<Entry<K, V>> iterator = this.f13046b.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = (Entry) iterator.next();
            if (predicate == null || predicate.apply(entry.getKey())) {
                oldValues.add(entry.getValue());
                this.f13047c -= m11600d(entry.getValue());
                iterator.remove();
            }
        }
        return oldValues;
    }

    /* renamed from: f */
    public synchronized ArrayList<V> m11612f() {
        ArrayList<V> oldValues;
        oldValues = new ArrayList(this.f13046b.values());
        this.f13046b.clear();
        this.f13047c = 0;
        return oldValues;
    }

    /* renamed from: d */
    private int m11600d(V value) {
        return value == null ? 0 : this.f13045a.a(value);
    }
}
