package com.baidu.carlife.p059c.p064d;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
/* renamed from: com.baidu.carlife.c.d.e */
public class C1124e<K, V> implements Iterable<Entry<K, V>> {
    /* renamed from: a */
    private C1122c<K, V> f2909a;
    /* renamed from: b */
    private C1122c<K, V> f2910b;
    /* renamed from: c */
    private WeakHashMap<C1118f<K, V>, Boolean> f2911c = new WeakHashMap();
    /* renamed from: d */
    private int f2912d = 0;

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$f */
    interface C1118f<K, V> {
        void a_(@NonNull C1122c<K, V> c1122c);
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$e */
    private static abstract class C1119e<K, V> implements C1118f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: a */
        C1122c<K, V> f2900a;
        /* renamed from: b */
        C1122c<K, V> f2901b;

        /* renamed from: a */
        abstract C1122c<K, V> mo1421a(C1122c<K, V> c1122c);

        /* renamed from: b */
        abstract C1122c<K, V> mo1422b(C1122c<K, V> c1122c);

        public /* synthetic */ Object next() {
            return m3772a();
        }

        C1119e(C1122c<K, V> start, C1122c<K, V> expectedEnd) {
            this.f2900a = expectedEnd;
            this.f2901b = start;
        }

        public boolean hasNext() {
            return this.f2901b != null;
        }

        public void a_(@NonNull C1122c<K, V> entry) {
            if (this.f2900a == entry && entry == this.f2901b) {
                this.f2901b = null;
                this.f2900a = null;
            }
            if (this.f2900a == entry) {
                this.f2900a = mo1422b(this.f2900a);
            }
            if (this.f2901b == entry) {
                this.f2901b = m3770b();
            }
        }

        /* renamed from: b */
        private C1122c<K, V> m3770b() {
            if (this.f2901b == this.f2900a || this.f2900a == null) {
                return null;
            }
            return mo1421a(this.f2901b);
        }

        /* renamed from: a */
        public Entry<K, V> m3772a() {
            Entry<K, V> result = this.f2901b;
            this.f2901b = m3770b();
            return result;
        }

        public void remove() {
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$a */
    static class C1120a<K, V> extends C1119e<K, V> {
        C1120a(C1122c<K, V> start, C1122c<K, V> expectedEnd) {
            super(start, expectedEnd);
        }

        /* renamed from: a */
        C1122c<K, V> mo1421a(C1122c<K, V> entry) {
            return entry.f2904c;
        }

        /* renamed from: b */
        C1122c<K, V> mo1422b(C1122c<K, V> entry) {
            return entry.f2905d;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$b */
    private static class C1121b<K, V> extends C1119e<K, V> {
        C1121b(C1122c<K, V> start, C1122c<K, V> expectedEnd) {
            super(start, expectedEnd);
        }

        /* renamed from: a */
        C1122c<K, V> mo1421a(C1122c<K, V> entry) {
            return entry.f2905d;
        }

        /* renamed from: b */
        C1122c<K, V> mo1422b(C1122c<K, V> entry) {
            return entry.f2904c;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$c */
    static class C1122c<K, V> implements Entry<K, V> {
        @NonNull
        /* renamed from: a */
        final K f2902a;
        @NonNull
        /* renamed from: b */
        final V f2903b;
        /* renamed from: c */
        C1122c<K, V> f2904c;
        /* renamed from: d */
        C1122c<K, V> f2905d;

        C1122c(@NonNull K key, @NonNull V value) {
            this.f2902a = key;
            this.f2903b = value;
        }

        @NonNull
        public K getKey() {
            return this.f2902a;
        }

        @NonNull
        public V getValue() {
            return this.f2903b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2902a + "=" + this.f2903b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1122c)) {
                return false;
            }
            C1122c entry = (C1122c) obj;
            if (this.f2902a.equals(entry.f2902a) && this.f2903b.equals(entry.f2903b)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: com.baidu.carlife.c.d.e$d */
    private class C1123d implements C1118f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C1124e f2906a;
        /* renamed from: b */
        private C1122c<K, V> f2907b;
        /* renamed from: c */
        private boolean f2908c;

        private C1123d(C1124e c1124e) {
            this.f2906a = c1124e;
            this.f2908c = true;
        }

        public /* synthetic */ Object next() {
            return m3778a();
        }

        public void a_(@NonNull C1122c<K, V> entry) {
            if (entry == this.f2907b) {
                this.f2907b = this.f2907b.f2905d;
                this.f2908c = this.f2907b == null;
            }
        }

        public boolean hasNext() {
            if (this.f2908c) {
                if (this.f2906a.f2909a != null) {
                    return true;
                }
                return false;
            } else if (this.f2907b == null || this.f2907b.f2904c == null) {
                return false;
            } else {
                return true;
            }
        }

        /* renamed from: a */
        public Entry<K, V> m3778a() {
            if (this.f2908c) {
                this.f2908c = false;
                this.f2907b = this.f2906a.f2909a;
            } else {
                this.f2907b = this.f2907b != null ? this.f2907b.f2904c : null;
            }
            return this.f2907b;
        }

        public void remove() {
        }
    }

    /* renamed from: a */
    protected C1122c<K, V> m3781a(K k) {
        C1122c<K, V> currentNode = this.f2909a;
        while (currentNode != null && !currentNode.f2902a.equals(k)) {
            currentNode = currentNode.f2904c;
        }
        return currentNode;
    }

    /* renamed from: a */
    public V m3782a(@NonNull K key, @NonNull V v) {
        C1122c<K, V> entry = m3781a((Object) key);
        if (entry != null) {
            return entry.f2903b;
        }
        m3783b(key, v);
        return null;
    }

    /* renamed from: b */
    protected C1122c<K, V> m3783b(@NonNull K key, @NonNull V v) {
        C1122c<K, V> newEntry = new C1122c(key, v);
        this.f2912d++;
        if (this.f2910b == null) {
            this.f2909a = newEntry;
            this.f2910b = this.f2909a;
        } else {
            this.f2910b.f2904c = newEntry;
            newEntry.f2905d = this.f2910b;
            this.f2910b = newEntry;
        }
        return newEntry;
    }

    /* renamed from: b */
    public V m3784b(@NonNull K key) {
        C1122c<K, V> toRemove = m3781a((Object) key);
        if (toRemove == null) {
            return null;
        }
        this.f2912d--;
        if (!this.f2911c.isEmpty()) {
            for (C1118f<K, V> iter : this.f2911c.keySet()) {
                iter.a_(toRemove);
            }
        }
        if (toRemove.f2905d != null) {
            toRemove.f2905d.f2904c = toRemove.f2904c;
        } else {
            this.f2909a = toRemove.f2904c;
        }
        if (toRemove.f2904c != null) {
            toRemove.f2904c.f2905d = toRemove.f2905d;
        } else {
            this.f2910b = toRemove.f2905d;
        }
        toRemove.f2904c = null;
        toRemove.f2905d = null;
        return toRemove.f2903b;
    }

    /* renamed from: a */
    public int m3780a() {
        return this.f2912d;
    }

    @NonNull
    public Iterator<Entry<K, V>> iterator() {
        C1119e<K, V> iterator = new C1120a(this.f2909a, this.f2910b);
        this.f2911c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    /* renamed from: b */
    public Iterator<Entry<K, V>> m3785b() {
        C1121b<K, V> iterator = new C1121b(this.f2910b, this.f2909a);
        this.f2911c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    /* renamed from: c */
    public C1123d m3786c() {
        C1123d iterator = new C1123d();
        this.f2911c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    /* renamed from: d */
    public Entry<K, V> m3787d() {
        return this.f2909a;
    }

    /* renamed from: e */
    public Entry<K, V> m3788e() {
        return this.f2910b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1124e)) {
            return false;
        }
        C1124e map = (C1124e) obj;
        if (m3780a() != map.m3780a()) {
            return false;
        }
        Iterator<Entry<K, V>> iterator1 = iterator();
        Iterator iterator2 = map.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Entry<K, V> next1 = (Entry) iterator1.next();
            Object next2 = iterator2.next();
            if (next1 == null && next2 != null) {
                return false;
            }
            if (next1 != null && !next1.equals(next2)) {
                return false;
            }
        }
        if (iterator1.hasNext() || iterator2.hasNext()) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Iterator<Entry<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            builder.append(((Entry) iterator.next()).toString());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
