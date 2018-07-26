package com.indooratlas.android.sdk._internal;

import java.lang.reflect.Field;

public final class eh {
    /* renamed from: a */
    public static String m20416a(Class cls, Object obj) {
        Field[] declaredFields = cls.getDeclaredFields();
        try {
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                try {
                    Object obj2 = field.get(null);
                    if ((obj == null && obj2 == null) || obj.equals(obj2)) {
                        return field.getName();
                    }
                    i++;
                } catch (NullPointerException e) {
                }
            }
        } catch (IllegalAccessException e2) {
        }
        return String.valueOf(obj);
    }
}
