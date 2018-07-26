package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ImmutableSet */
/* renamed from: com.facebook.common.internal.h */
public class C5347h<E> extends HashSet<E> {
    private C5347h(Set<E> set) {
        super(set);
    }

    /* renamed from: a */
    public static <E> C5347h<E> m18287a(Set<E> set) {
        return new C5347h(set);
    }

    /* renamed from: a */
    public static <E> C5347h<E> m18288a(E... elements) {
        HashSet<E> set = new HashSet();
        Collections.addAll(set, elements);
        return new C5347h(set);
    }
}
