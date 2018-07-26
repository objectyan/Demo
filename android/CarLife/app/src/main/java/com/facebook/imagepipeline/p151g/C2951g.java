package com.facebook.imagepipeline.p151g;

import com.facebook.common.p140h.C2921a;
import com.facebook.p138c.C2919a;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: SettableDataSource */
/* renamed from: com.facebook.imagepipeline.g.g */
public final class C2951g<T> extends C2919a<C2921a<T>> {
    /* renamed from: a */
    protected /* synthetic */ void mo2043a(@Nullable Object obj) {
        m11775b((C2921a) obj);
    }

    @Nullable
    /* renamed from: d */
    public /* synthetic */ Object mo2015d() {
        return mo2046k();
    }

    /* renamed from: j */
    public static <V> C2951g<V> m11771j() {
        return new C2951g();
    }

    private C2951g() {
    }

    /* renamed from: a */
    public boolean m11774a(@Nullable C2921a<T> valueRef) {
        return super.m11211a(C2921a.m11258b(valueRef), true);
    }

    /* renamed from: b */
    public boolean mo2045b(Throwable throwable) {
        return super.m11212a(throwable);
    }

    /* renamed from: a */
    public boolean mo2044a(float progress) {
        return super.mo2044a(progress);
    }

    @Nullable
    /* renamed from: k */
    public C2921a<T> mo2046k() {
        return C2921a.m11258b((C2921a) super.mo2015d());
    }

    /* renamed from: b */
    protected void m11775b(@Nullable C2921a<T> result) {
        C2921a.m11259c(result);
    }
}
