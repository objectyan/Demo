package com.facebook.p138c;

import com.facebook.common.internal.C5273m;

/* compiled from: DataSources */
/* renamed from: com.facebook.c.e */
public class C5291e {
    private C5291e() {
    }

    /* renamed from: a */
    public static <T> C2918d<T> m18039a(Throwable failure) {
        C5295i<T> simpleDataSource = C5295i.m18055j();
        simpleDataSource.m18058a(failure);
        return simpleDataSource;
    }

    /* renamed from: a */
    public static <T> C2918d<T> m18038a(T result) {
        C5295i<T> simpleDataSource = C5295i.m18055j();
        simpleDataSource.m18059b(result);
        return simpleDataSource;
    }

    /* renamed from: b */
    public static <T> C5273m<C2918d<T>> m18040b(final Throwable failure) {
        return new C5273m<C2918d<T>>() {
            /* renamed from: b */
            public /* synthetic */ Object mo3969b() {
                return m18036a();
            }

            /* renamed from: a */
            public C2918d<T> m18036a() {
                return C5291e.m18039a(failure);
            }
        };
    }
}
