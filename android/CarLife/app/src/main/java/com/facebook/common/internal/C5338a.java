package com.facebook.common.internal;

import com.android.internal.util.Predicate;

/* compiled from: AndroidPredicates */
/* renamed from: com.facebook.common.internal.a */
public class C5338a {

    /* compiled from: AndroidPredicates */
    /* renamed from: com.facebook.common.internal.a$1 */
    static class C53361 implements Predicate<T> {
        C53361() {
        }

        public boolean apply(T t) {
            return true;
        }
    }

    /* compiled from: AndroidPredicates */
    /* renamed from: com.facebook.common.internal.a$2 */
    static class C53372 implements Predicate<T> {
        C53372() {
        }

        public boolean apply(T t) {
            return false;
        }
    }

    private C5338a() {
    }

    /* renamed from: a */
    public static <T> Predicate<T> m18265a() {
        return new C53361();
    }

    /* renamed from: b */
    public static <T> Predicate<T> m18266b() {
        return new C53372();
    }
}
