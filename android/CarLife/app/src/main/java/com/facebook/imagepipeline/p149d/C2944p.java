package com.facebook.imagepipeline.p149d;

import com.android.internal.util.Predicate;
import com.facebook.common.p140h.C2921a;
import javax.annotation.Nullable;

/* compiled from: MemoryCache */
/* renamed from: com.facebook.imagepipeline.d.p */
public interface C2944p<K, V> {
    /* renamed from: a */
    int mo2038a(Predicate<K> predicate);

    @Nullable
    /* renamed from: a */
    C2921a<V> mo2039a(K k);

    @Nullable
    /* renamed from: a */
    C2921a<V> mo2040a(K k, C2921a<V> c2921a);

    /* renamed from: b */
    boolean mo2041b(Predicate<K> predicate);
}
