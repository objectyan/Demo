package com.facebook.common.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Throwables */
/* renamed from: com.facebook.common.internal.o */
public final class C5354o {
    private C5354o() {
    }

    /* renamed from: a */
    public static <X extends Throwable> void m18338a(@Nullable Throwable throwable, Class<X> declaredType) throws Throwable {
        if (throwable != null && declaredType.isInstance(throwable)) {
            throw ((Throwable) declaredType.cast(throwable));
        }
    }

    /* renamed from: a */
    public static void m18337a(@Nullable Throwable throwable) {
        C5354o.m18338a(throwable, Error.class);
        C5354o.m18338a(throwable, RuntimeException.class);
    }

    /* renamed from: b */
    public static <X extends Throwable> void m18341b(@Nullable Throwable throwable, Class<X> declaredType) throws Throwable {
        C5354o.m18338a(throwable, declaredType);
        C5354o.m18337a(throwable);
    }

    /* renamed from: a */
    public static <X1 extends Throwable, X2 extends Throwable> void m18339a(@Nullable Throwable throwable, Class<X1> declaredType1, Class<X2> declaredType2) throws Throwable, Throwable {
        C5350k.m18310a((Object) declaredType2);
        C5354o.m18338a(throwable, declaredType1);
        C5354o.m18341b(throwable, declaredType2);
    }

    /* renamed from: b */
    public static RuntimeException m18340b(Throwable throwable) {
        C5354o.m18337a((Throwable) C5350k.m18310a((Object) throwable));
        throw new RuntimeException(throwable);
    }

    /* renamed from: c */
    public static Throwable m18342c(Throwable throwable) {
        while (true) {
            Throwable cause = throwable.getCause();
            if (cause == null) {
                return throwable;
            }
            throwable = cause;
        }
    }

    /* renamed from: d */
    public static List<Throwable> m18343d(Throwable throwable) {
        C5350k.m18310a((Object) throwable);
        List<Throwable> causes = new ArrayList(4);
        while (throwable != null) {
            causes.add(throwable);
            throwable = throwable.getCause();
        }
        return Collections.unmodifiableList(causes);
    }

    /* renamed from: e */
    public static String m18344e(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
