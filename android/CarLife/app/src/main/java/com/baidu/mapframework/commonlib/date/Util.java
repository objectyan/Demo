package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.Array;
import java.util.logging.Logger;

final class Util {
    /* renamed from: a */
    private static final String f19045a = "'";

    Util() {
    }

    /* renamed from: a */
    static boolean m15096a(String aText) {
        return aText != null && aText.trim().length() > 0;
    }

    /* renamed from: a */
    static String m15093a(Object aObject) {
        return f19045a + String.valueOf(aObject) + f19045a;
    }

    /* renamed from: b */
    static String m15097b(Object aArray) {
        String START_CHAR = "[";
        String END_CHAR = "]";
        String SEPARATOR = ", ";
        String NULL = "null";
        if (aArray == null) {
            return "null";
        }
        m15099d(aArray);
        StringBuilder result = new StringBuilder("[");
        int length = Array.getLength(aArray);
        for (int idx = 0; idx < length; idx++) {
            Object item = Array.get(aArray, idx);
            if (m15098c(item)) {
                result.append(m15097b(item));
            } else {
                result.append(item);
            }
            if (!m15095a(idx, length)) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    /* renamed from: a */
    static Logger m15094a(Class<?> aClass) {
        return Logger.getLogger(aClass.getPackage().getName());
    }

    /* renamed from: c */
    private static boolean m15098c(Object aItem) {
        return aItem != null && aItem.getClass().isArray();
    }

    /* renamed from: d */
    private static void m15099d(Object aArray) {
        if (!aArray.getClass().isArray()) {
            throw new IllegalArgumentException("Object is not an array.");
        }
    }

    /* renamed from: a */
    private static boolean m15095a(int aIdx, int aLength) {
        return aIdx == aLength + -1;
    }
}
