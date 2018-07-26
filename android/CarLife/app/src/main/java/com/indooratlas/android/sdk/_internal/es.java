package com.indooratlas.android.sdk._internal;

public final class es {

    /* renamed from: com.indooratlas.android.sdk._internal.es$a */
    static class C5870a {
        /* renamed from: a */
        final int f23534a;
        /* renamed from: b */
        final int f23535b;
        /* renamed from: c */
        final int f23536c;
        /* renamed from: d */
        final int f23537d;
        /* renamed from: e */
        final int f23538e;
        /* renamed from: f */
        public final int f23539f;

        C5870a(er erVar, int i) {
            this.f23538e = i;
            et a = et.m20429a(erVar.f23531b, erVar.f23530a, i);
            et a2 = et.m20429a(erVar.f23533d, erVar.f23532c, i);
            this.f23539f = 1 << i;
            int i2 = a.f23541a;
            int i3 = a2.f23541a;
            int i4 = a.f23541a;
            int i5 = this.f23539f;
            i3 -= i4;
            if (i3 < (-i5) / 2) {
                i3 = (int) (((long) i3) + (Math.round(((double) (-i3)) / ((double) i5)) * ((long) i5)));
            }
            if (i3 > i5 / 2) {
                i3 = (int) (((long) i3) - (Math.round(((double) i3) / ((double) i5)) * ((long) i5)));
            }
            i3 += i4;
            this.f23534a = Math.min(i2, i3);
            this.f23535b = Math.max(i2, i3);
            this.f23536c = Math.min(a.f23542b, a2.f23542b);
            this.f23537d = Math.max(a.f23542b, a2.f23542b);
        }
    }
}
