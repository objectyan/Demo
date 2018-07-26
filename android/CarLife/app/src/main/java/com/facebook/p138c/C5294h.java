package com.facebook.p138c;

import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: IncreasingQualityDataSourceSupplier */
/* renamed from: com.facebook.c.h */
public class C5294h<T> implements C5273m<C2918d<T>> {
    /* renamed from: a */
    private final List<C5273m<C2918d<T>>> f21870a;

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18053a();
    }

    private C5294h(List<C5273m<C2918d<T>>> dataSourceSuppliers) {
        C5350k.m18316a(!dataSourceSuppliers.isEmpty(), (Object) "List of suppliers is empty!");
        this.f21870a = dataSourceSuppliers;
    }

    /* renamed from: a */
    public static <T> C5294h<T> m18051a(List<C5273m<C2918d<T>>> dataSourceSuppliers) {
        return new C5294h(dataSourceSuppliers);
    }

    /* renamed from: a */
    public C2918d<T> m18053a() {
        return new h$a(this);
    }

    public int hashCode() {
        return this.f21870a.hashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof C5294h)) {
            return false;
        }
        return C2923j.a(this.f21870a, ((C5294h) other).f21870a);
    }

    public String toString() {
        return C2923j.a(this).m18305a("list", this.f21870a).toString();
    }
}
