package com.baidu.carlife.p059c.p067g;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.p059c.p064d.C1115c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Util */
/* renamed from: com.baidu.carlife.c.g.a */
public class C1145a {
    /* renamed from: a */
    public static <T> T m3846a(T object, String errorMessage) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException(errorMessage);
    }

    /* renamed from: a */
    public static <T> C1115c<T> m3845a(@NotNull T value) {
        C1115c<T> result = new C1115c();
        result.mo1419b(value);
        return result;
    }

    /* renamed from: a */
    public static C1115c<String> m3844a(int resId) {
        C1115c<String> result = new C1115c();
        result.mo1419b(AppContext.m3876a().getString(resId));
        return result;
    }
}
