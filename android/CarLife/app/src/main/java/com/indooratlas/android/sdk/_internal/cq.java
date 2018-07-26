package com.indooratlas.android.sdk._internal;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.indooratlas.android.sdk._internal.ff.C5900f;
import com.indooratlas.android.sdk._internal.ff.C5901g;
import java.util.Collection;
import java.util.HashMap;

public final class cq {
    /* renamed from: a */
    public HashMap<Long, C5900f> f23346a = new HashMap();
    /* renamed from: b */
    public HashMap<Long, C5900f> f23347b = new HashMap();
    /* renamed from: c */
    public cr f23348c;
    /* renamed from: d */
    public long f23349d;
    /* renamed from: e */
    public long f23350e;

    public cq(cr crVar) {
        this.f23348c = crVar;
    }

    /* renamed from: a */
    public final boolean m20243a(@NonNull HashMap<Long, C5900f> hashMap, @NonNull dx dxVar) {
        long j;
        if (VERSION.SDK_INT >= 17) {
            j = dxVar.f23487j;
        } else {
            j = SystemClock.elapsedRealtime() * 1000;
        }
        long a = cv.m20272a(dxVar.f23478a);
        if (a == -1) {
            new Object[1][0] = dxVar.f23478a;
            return false;
        }
        int abs = Math.abs(dxVar.f23485h);
        Object[] objArr = new Object[]{Long.valueOf(j), Long.valueOf(r10), Long.valueOf(j - (this.f23350e * 1000))};
        int i = (int) ((j - (this.f23350e * 1000)) / 1000);
        C5900f c5900f = (C5900f) hashMap.get(Long.valueOf(a));
        if (c5900f == null) {
            c5900f = new C5900f();
            c5900f.f23657b = a;
            c5900f.f23659e = new int[]{abs};
            c5900f.f23658d = new int[]{i};
            hashMap.put(Long.valueOf(a), c5900f);
        } else {
            c5900f.f23659e = ec.m20398a(c5900f.f23659e, abs);
            c5900f.f23658d = ec.m20398a(c5900f.f23658d, i);
        }
        return true;
    }

    /* renamed from: a */
    public static C5901g m20242a(HashMap<Long, C5900f> hashMap) {
        Collection values = hashMap.values();
        C5900f[] c5900fArr = (C5900f[]) values.toArray(new C5900f[values.size()]);
        C5901g c5901g = new C5901g();
        c5901g.f23660b = c5900fArr;
        return c5901g;
    }
}
