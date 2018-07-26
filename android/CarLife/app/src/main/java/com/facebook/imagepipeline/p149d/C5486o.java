package com.facebook.imagepipeline.p149d;

import com.android.internal.util.Predicate;
import com.facebook.common.p140h.C2921a;

/* compiled from: InstrumentedMemoryCache */
/* renamed from: com.facebook.imagepipeline.d.o */
public class C5486o<K, V> implements C2944p<K, V> {
    /* renamed from: a */
    private final C2944p<K, V> f22309a;
    /* renamed from: b */
    private final C5465r f22310b;

    public C5486o(C2944p<K, V> delegate, C5465r tracker) {
        this.f22309a = delegate;
        this.f22310b = tracker;
    }

    /* renamed from: a */
    public C2921a<V> m18820a(K key) {
        C2921a<V> result = this.f22309a.a(key);
        if (result == null) {
            this.f22310b.mo4059b();
        } else {
            this.f22310b.mo4058a();
        }
        return result;
    }

    /* renamed from: a */
    public C2921a<V> m18821a(K key, C2921a<V> value) {
        this.f22310b.mo4060c();
        return this.f22309a.a(key, value);
    }

    /* renamed from: a */
    public int m18819a(Predicate<K> predicate) {
        return this.f22309a.a(predicate);
    }

    /* renamed from: b */
    public boolean m18822b(Predicate<K> predicate) {
        return this.f22309a.b(predicate);
    }
}
