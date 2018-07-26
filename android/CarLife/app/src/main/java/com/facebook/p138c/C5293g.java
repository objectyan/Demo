package com.facebook.p138c;

import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: FirstAvailableDataSourceSupplier */
/* renamed from: com.facebook.c.g */
public class C5293g<T> implements C5273m<C2918d<T>> {
    /* renamed from: a */
    private final List<C5273m<C2918d<T>>> f21867a;

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18046a();
    }

    private C5293g(List<C5273m<C2918d<T>>> dataSourceSuppliers) {
        C5350k.m18316a(!dataSourceSuppliers.isEmpty(), (Object) "List of suppliers is empty!");
        this.f21867a = dataSourceSuppliers;
    }

    /* renamed from: a */
    public static <T> C5293g<T> m18044a(List<C5273m<C2918d<T>>> dataSourceSuppliers) {
        return new C5293g(dataSourceSuppliers);
    }

    /* renamed from: a */
    public C2918d<T> m18046a() {
        return new g$a(this);
    }

    public int hashCode() {
        return this.f21867a.hashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof C5293g)) {
            return false;
        }
        return C2923j.a(this.f21867a, ((C5293g) other).f21867a);
    }

    public String toString() {
        return C2923j.a(this).m18305a("list", this.f21867a).toString();
    }
}
