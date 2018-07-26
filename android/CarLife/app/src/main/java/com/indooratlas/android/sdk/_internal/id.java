package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.reflect.Method;

public final class id extends Exception {
    /* renamed from: a */
    public static final Method f24333a;
    /* renamed from: b */
    public IOException f24334b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            declaredMethod = null;
        }
        f24333a = declaredMethod;
    }

    public id(IOException iOException) {
        super(iOException);
        this.f24334b = iOException;
    }
}
