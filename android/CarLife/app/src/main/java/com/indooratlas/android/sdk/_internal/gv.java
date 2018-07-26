package com.indooratlas.android.sdk._internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class gv<T> {
    /* renamed from: a */
    private final Class<?> f24019a;
    /* renamed from: b */
    private final String f24020b;
    /* renamed from: c */
    private final Class[] f24021c;

    public gv(Class<?> cls, String str, Class... clsArr) {
        this.f24019a = cls;
        this.f24020b = str;
        this.f24021c = clsArr;
    }

    /* renamed from: a */
    public final boolean m20759a(T t) {
        return m20754a(t.getClass()) != null;
    }

    /* renamed from: c */
    private Object m20756c(T t, Object... objArr) throws InvocationTargetException {
        Object obj = null;
        Method a = m20754a(t.getClass());
        if (a != null) {
            try {
                obj = a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
            }
        }
        return obj;
    }

    /* renamed from: a */
    public final Object m20758a(T t, Object... objArr) {
        try {
            return m20756c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: d */
    private Object m20757d(T t, Object... objArr) throws InvocationTargetException {
        Object a = m20754a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.f24020b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: b */
    public final Object m20760b(T t, Object... objArr) {
        try {
            return m20757d(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m20754a(Class<?> cls) {
        if (this.f24020b == null) {
            return null;
        }
        Method a = m20755a(cls, this.f24020b, this.f24021c);
        if (a == null || this.f24019a == null || this.f24019a.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m20755a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}
