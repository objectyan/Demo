package com.facebook.p138c;

import com.facebook.common.internal.C5350k;

/* compiled from: SimpleDataSource */
/* renamed from: com.facebook.c.i */
public class C5295i<T> extends C2919a<T> {
    private C5295i() {
    }

    /* renamed from: j */
    public static <T> C5295i<T> m18055j() {
        return new C5295i();
    }

    /* renamed from: a */
    public boolean m18057a(T value, boolean isLast) {
        return super.a(C5350k.m18310a((Object) value), isLast);
    }

    /* renamed from: b */
    public boolean m18059b(T value) {
        return super.a(C5350k.m18310a((Object) value), true);
    }

    /* renamed from: a */
    public boolean m18058a(Throwable throwable) {
        return super.a((Throwable) C5350k.m18310a((Object) throwable));
    }

    /* renamed from: a */
    public boolean m18056a(float progress) {
        return super.a(progress);
    }
}
