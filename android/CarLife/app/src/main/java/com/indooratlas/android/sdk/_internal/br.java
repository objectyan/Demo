package com.indooratlas.android.sdk._internal;

import java.util.Arrays;

public interface br {

    /* renamed from: com.indooratlas.android.sdk._internal.br$a */
    public static class C5827a {
        /* renamed from: a */
        private int f23242a = 0;
        /* renamed from: b */
        private br[] f23243b = new br[0];

        /* renamed from: a */
        public final void m20134a(br brVar) {
            br[] brVarArr = this.f23243b;
            if (brVarArr == null) {
                throw new IllegalArgumentException("array cannot be null");
            }
            int length = brVarArr.length;
            Object[] copyOf = Arrays.copyOf(brVarArr, length + 1);
            copyOf[length] = brVar;
            this.f23243b = (br[]) copyOf;
        }

        /* renamed from: a */
        final void m20133a() {
            this.f23242a = 0;
            if (this.f23242a < this.f23243b.length) {
                this.f23242a++;
            }
        }
    }
}
