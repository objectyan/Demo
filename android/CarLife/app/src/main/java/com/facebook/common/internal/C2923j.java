package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: Objects */
/* renamed from: com.facebook.common.internal.j */
public final class C2923j {
    private C2923j() {
    }

    @CheckReturnValue
    /* renamed from: a */
    public static boolean m11273a(@Nullable Object a, @Nullable Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* renamed from: a */
    public static int m11269a(@Nullable Object... objects) {
        return Arrays.hashCode(objects);
    }

    /* renamed from: a */
    public static j$a m11271a(Object self) {
        return new j$a(C2923j.m11275b(self.getClass()), null);
    }

    /* renamed from: a */
    public static j$a m11270a(Class<?> clazz) {
        return new j$a(C2923j.m11275b(clazz), null);
    }

    /* renamed from: a */
    public static j$a m11272a(String className) {
        return new j$a(className, null);
    }

    /* renamed from: b */
    private static String m11275b(Class<?> clazz) {
        String name = clazz.getName().replaceAll("\\$[0-9]+", "\\$");
        int start = name.lastIndexOf(36);
        if (start == -1) {
            start = name.lastIndexOf(46);
        }
        return name.substring(start + 1);
    }

    /* renamed from: b */
    public static <T> T m11274b(@Nullable T first, @Nullable T second) {
        return first != null ? first : C5350k.a(second);
    }
}
