package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.Array;

final class ModelUtil {
    /* renamed from: a */
    static final int f19028a = 23;
    /* renamed from: b */
    private static final int f19029b = 37;

    enum NullsGo {
        FIRST,
        LAST
    }

    private ModelUtil() {
    }

    /* renamed from: a */
    static String m15071a(Object aObject) {
        return ToStringUtil.m15082a(aObject);
    }

    /* renamed from: a */
    static String m15072a(Object aObject, Class aSpecialClass, String aMethodName) {
        return ToStringUtil.m15083a(aObject, aSpecialClass, aMethodName);
    }

    /* renamed from: a */
    static final int m15069a(Object... aFields) {
        int result = 23;
        for (Object field : aFields) {
            result = m15066a(result, field);
        }
        return result;
    }

    /* renamed from: a */
    static int m15067a(int aSeed, boolean aBoolean) {
        return (aBoolean ? 1 : 0) + m15060a(aSeed);
    }

    /* renamed from: a */
    static int m15061a(int aSeed, char aChar) {
        return m15060a(aSeed) + aChar;
    }

    /* renamed from: a */
    static int m15064a(int aSeed, int aInt) {
        return m15060a(aSeed) + aInt;
    }

    /* renamed from: a */
    static int m15065a(int aSeed, long aLong) {
        return m15060a(aSeed) + ((int) ((aLong >>> 32) ^ aLong));
    }

    /* renamed from: a */
    static int m15063a(int aSeed, float aFloat) {
        return m15064a(aSeed, Float.floatToIntBits(aFloat));
    }

    /* renamed from: a */
    static int m15062a(int aSeed, double aDouble) {
        return m15065a(aSeed, Double.doubleToLongBits(aDouble));
    }

    /* renamed from: a */
    static int m15066a(int aSeed, Object aObject) {
        int result = aSeed;
        if (aObject == null) {
            return m15064a(result, 0);
        }
        if (!m15079b(aObject)) {
            return m15064a(result, aObject.hashCode());
        }
        int length = Array.getLength(aObject);
        for (int idx = 0; idx < length; idx++) {
            result = m15066a(result, Array.get(aObject, idx));
        }
        return result;
    }

    /* renamed from: a */
    static Boolean m15070a(Object aThis, Object aThat) {
        if (aThis == aThat) {
            return Boolean.TRUE;
        }
        if (aThis.getClass().isInstance(aThat)) {
            return null;
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    static boolean m15078a(Object[] aThisSignificantFields, Object[] aThatSignificantFields) {
        if (aThisSignificantFields.length != aThatSignificantFields.length) {
            throw new IllegalArgumentException("Array lengths do not match. 'This' length is " + aThisSignificantFields.length + ", while 'That' length is " + aThatSignificantFields.length + ".");
        }
        for (int idx = 0; idx < aThisSignificantFields.length; idx++) {
            if (!m15080b(aThisSignificantFields[idx], aThatSignificantFields[idx])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static boolean m15077a(boolean aThis, boolean aThat) {
        return aThis == aThat;
    }

    /* renamed from: a */
    static boolean m15073a(char aThis, char aThat) {
        return aThis == aThat;
    }

    /* renamed from: a */
    static boolean m15076a(long aThis, long aThat) {
        return aThis == aThat;
    }

    /* renamed from: a */
    static boolean m15075a(float aThis, float aThat) {
        return Float.floatToIntBits(aThis) == Float.floatToIntBits(aThat);
    }

    /* renamed from: a */
    static boolean m15074a(double aThis, double aThat) {
        return Double.doubleToLongBits(aThis) == Double.doubleToLongBits(aThat);
    }

    /* renamed from: b */
    static boolean m15080b(Object aThis, Object aThat) {
        if (m15079b(aThis) || m15079b(aThat)) {
            throw new IllegalArgumentException("This method does not currently support arrays.");
        } else if (aThis == null) {
            return aThat == null;
        } else {
            return aThis.equals(aThat);
        }
    }

    /* renamed from: a */
    static <T extends Comparable<T>> int m15068a(T aThis, T aThat, NullsGo aNullsGo) {
        int result = 0;
        if (aThis != null && aThat != null) {
            return aThis.compareTo(aThat);
        }
        if (aThis == null && aThat != null) {
            result = -1;
        } else if (aThis != null && aThat == null) {
            result = 1;
        }
        if (NullsGo.LAST == aNullsGo) {
            return result * -1;
        }
        return result;
    }

    /* renamed from: a */
    private static int m15060a(int aSeed) {
        return aSeed * 37;
    }

    /* renamed from: b */
    private static boolean m15079b(Object aObject) {
        return aObject != null && aObject.getClass().isArray();
    }
}
