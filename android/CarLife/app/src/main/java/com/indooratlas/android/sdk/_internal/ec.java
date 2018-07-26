package com.indooratlas.android.sdk._internal;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class ec {

    /* renamed from: com.indooratlas.android.sdk._internal.ec$b */
    public interface C5864b<T> {
        /* renamed from: a */
        boolean mo4670a(T t);
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ec$a */
    public static class C5865a implements C5864b {
        /* renamed from: a */
        private final Object f23512a;

        public C5865a(Object obj) {
            this.f23512a = obj;
        }

        /* renamed from: a */
        public final boolean mo4670a(Object obj) {
            return this.f23512a.equals(obj);
        }
    }

    /* renamed from: a */
    public static int[] m20398a(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[]{i};
        }
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        return copyOf;
    }
}
