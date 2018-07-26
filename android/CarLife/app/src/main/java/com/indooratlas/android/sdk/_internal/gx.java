package com.indooratlas.android.sdk._internal;

import java.util.LinkedHashSet;
import java.util.Set;

public final class gx {
    /* renamed from: a */
    private final Set<go> f24037a = new LinkedHashSet();

    /* renamed from: a */
    public final synchronized void m20776a(go goVar) {
        this.f24037a.add(goVar);
    }

    /* renamed from: b */
    public final synchronized void m20777b(go goVar) {
        this.f24037a.remove(goVar);
    }

    /* renamed from: c */
    public final synchronized boolean m20778c(go goVar) {
        return this.f24037a.contains(goVar);
    }
}
