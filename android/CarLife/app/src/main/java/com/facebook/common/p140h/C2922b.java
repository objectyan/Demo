package com.facebook.common.p140h;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: OOMSoftReference */
/* renamed from: com.facebook.common.h.b */
public class C2922b<T> {
    /* renamed from: a */
    SoftReference<T> f12884a = null;
    /* renamed from: b */
    SoftReference<T> f12885b = null;
    /* renamed from: c */
    SoftReference<T> f12886c = null;

    /* renamed from: a */
    public void m11267a(@Nonnull T hardReference) {
        this.f12884a = new SoftReference(hardReference);
        this.f12885b = new SoftReference(hardReference);
        this.f12886c = new SoftReference(hardReference);
    }

    @Nullable
    /* renamed from: a */
    public T m11266a() {
        return this.f12884a == null ? null : this.f12884a.get();
    }

    /* renamed from: b */
    public void m11268b() {
        if (this.f12884a != null) {
            this.f12884a.clear();
            this.f12884a = null;
        }
        if (this.f12885b != null) {
            this.f12885b.clear();
            this.f12885b = null;
        }
        if (this.f12886c != null) {
            this.f12886c.clear();
            this.f12886c = null;
        }
    }
}
