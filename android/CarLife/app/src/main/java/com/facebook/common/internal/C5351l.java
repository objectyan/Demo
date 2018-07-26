package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Sets */
/* renamed from: com.facebook.common.internal.l */
public final class C5351l {
    private C5351l() {
    }

    /* renamed from: a */
    public static <E> HashSet<E> m18326a() {
        return new HashSet();
    }

    /* renamed from: a */
    public static <E> HashSet<E> m18330a(E... elements) {
        HashSet<E> set = C5351l.m18327a(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    /* renamed from: a */
    public static <E> HashSet<E> m18327a(int capacity) {
        return new HashSet(capacity);
    }

    /* renamed from: a */
    public static <E> HashSet<E> m18328a(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new HashSet((Collection) elements);
        }
        return C5351l.m18329a(elements.iterator());
    }

    /* renamed from: a */
    public static <E> HashSet<E> m18329a(Iterator<? extends E> elements) {
        HashSet<E> set = C5351l.m18326a();
        while (elements.hasNext()) {
            set.add(elements.next());
        }
        return set;
    }

    /* renamed from: b */
    public static <E> Set<E> m18332b() {
        return C5351l.m18331a(new IdentityHashMap());
    }

    /* renamed from: a */
    public static <E> Set<E> m18331a(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    /* renamed from: c */
    public static <E> CopyOnWriteArraySet<E> m18333c() {
        return new CopyOnWriteArraySet();
    }

    /* renamed from: d */
    public static <E> LinkedHashSet<E> m18334d() {
        return new LinkedHashSet();
    }
}
