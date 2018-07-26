package com.facebook.common.p258g;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: MemoryUiTrimmableRegistry */
/* renamed from: com.facebook.common.g.e */
public class C5327e {
    /* renamed from: a */
    private static final Set<C5326d> f21909a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public static void m18242a(C5326d uiTrimmable) {
        f21909a.add(uiTrimmable);
    }

    /* renamed from: a */
    public static Iterable<C5326d> m18241a() {
        return f21909a;
    }
}
