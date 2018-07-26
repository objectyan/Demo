package com.facebook.imagepipeline.p151g;

import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.ao;
import com.facebook.imagepipeline.p278j.C5539c;
import com.facebook.p138c.C2918d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: CloseableProducerToDataSourceAdapter */
/* renamed from: com.facebook.imagepipeline.g.d */
public class C2949d<T> extends C5520a<C2921a<T>> {
    /* renamed from: b */
    protected /* synthetic */ void m11754b(Object obj, boolean z) {
        m11752a((C2921a) obj, z);
    }

    @Nullable
    /* renamed from: d */
    public /* synthetic */ Object m11755d() {
        return m11756j();
    }

    /* renamed from: a */
    public static <T> C2918d<C2921a<T>> m11750a(ai<C2921a<T>> producer, ao settableProducerContext, C5539c listener) {
        return new C2949d(producer, settableProducerContext, listener);
    }

    private C2949d(ai<C2921a<T>> producer, ao settableProducerContext, C5539c listener) {
        super(producer, settableProducerContext, listener);
    }

    @Nullable
    /* renamed from: j */
    public C2921a<T> m11756j() {
        return C2921a.m11258b((C2921a) super.d());
    }

    /* renamed from: a */
    protected void m11751a(C2921a<T> result) {
        C2921a.m11259c(result);
    }

    /* renamed from: a */
    protected void m11752a(C2921a<T> result, boolean isLast) {
        super.b(C2921a.m11258b(result), isLast);
    }
}
