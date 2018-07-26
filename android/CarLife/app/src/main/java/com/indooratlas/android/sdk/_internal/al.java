package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gf.C5920a;
import java.io.IOException;

public final class al implements gf {
    /* renamed from: a */
    public final gm mo4589a(C5920a c5920a) throws IOException {
        gk a = c5920a.mo4689a();
        long nanoTime = System.nanoTime();
        String str = an.f22962d;
        Object[] objArr = new Object[5];
        objArr[0] = a.m20711b();
        objArr[1] = a.m20709a();
        objArr[2] = Long.valueOf(a.m20713d() != null ? a.m20713d().mo4588b() : -1);
        objArr[3] = c5920a.mo4691b();
        objArr[4] = a.m20712c();
        gm a2 = c5920a.mo4690a(a);
        if (a2 != null) {
            long nanoTime2 = System.nanoTime();
            String str2 = an.f22962d;
            Object[] objArr2 = new Object[]{a2.m20728a().m20711b(), a2.m20728a().m20709a(), Integer.valueOf(a2.m20730b()), Double.valueOf(((double) (nanoTime2 - nanoTime)) / 1000000.0d), a2.m20733e()};
        }
        return a2;
    }
}
