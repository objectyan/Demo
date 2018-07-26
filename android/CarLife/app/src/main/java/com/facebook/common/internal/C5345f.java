package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ImmutableList */
/* renamed from: com.facebook.common.internal.f */
public class C5345f<E> extends ArrayList<E> {
    private C5345f(List<E> list) {
        super(list);
    }

    /* renamed from: a */
    public static <E> C5345f<E> m18279a(List<E> list) {
        return new C5345f(list);
    }
}
