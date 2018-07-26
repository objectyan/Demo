package com.indooratlas.android.sdk._internal;

import android.util.Pair;
import com.indooratlas.android.sdk.IALocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class cc {
    /* renamed from: a */
    public eo<String, C5834a> f23293a = new eo();
    /* renamed from: b */
    public IALocation f23294b = null;
    /* renamed from: c */
    private ArrayList<aw> f23295c = new ArrayList();
    /* renamed from: d */
    private long f23296d = -1;
    /* renamed from: e */
    private HashMap<aw, Long> f23297e = new HashMap();

    /* renamed from: com.indooratlas.android.sdk._internal.cc$a */
    public static class C5834a {
        /* renamed from: a */
        long f23291a;
        /* renamed from: b */
        aw f23292b;

        public C5834a(long j, aw awVar) {
            this.f23291a = j;
            this.f23292b = awVar;
        }
    }

    /* renamed from: a */
    public final void m20204a(String str) {
        this.f23293a.f23524a.m20427a((Object) str);
    }

    /* renamed from: a */
    public final ArrayList<ax> m20203a(long j, IALocation iALocation) {
        this.f23294b = iALocation;
        ArrayList<ax> arrayList = new ArrayList();
        ArrayList a = m20202a(j, iALocation.getLatitude(), iALocation.getLongitude(), iALocation.hasFloorLevel() ? Integer.valueOf(iALocation.getFloorLevel()) : null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            switch (((Integer) pair.first).intValue()) {
                case 1:
                    arrayList2.add(pair.second);
                    break;
                case 16:
                    arrayList3.add(pair.second);
                    break;
                case 256:
                    arrayList4.add(pair.second);
                    break;
                default:
                    break;
            }
        }
        arrayList.add(new ax(arrayList2, 1, iALocation));
        arrayList.add(new ax(arrayList3, 16, iALocation));
        arrayList.add(new ax(arrayList4, 256, iALocation));
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<Pair<Integer, aw>> m20202a(long j, double d, double d2, Integer num) {
        long j2;
        ArrayList<Pair<Integer, aw>> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f23297e);
        if (this.f23296d >= 0) {
            j2 = j - this.f23296d;
        } else {
            j2 = 0;
        }
        this.f23296d = j;
        this.f23297e.clear();
        eo eoVar = this.f23293a;
        for (C5834a c5834a : eoVar.f23524a.m20425a(new ep(d, d2, num))) {
            aw awVar = c5834a.f23292b;
            if (awVar.mo4652e() && j - c5834a.f23291a > awVar.mo4653f().longValue()) {
                this.f23293a.f23524a.m20427a(awVar.mo4647a());
            } else if (hashMap.containsKey(awVar)) {
                this.f23297e.put(awVar, Long.valueOf(((Long) hashMap.get(awVar)).longValue() + j2));
            } else {
                this.f23297e.put(awVar, Long.valueOf(0));
            }
        }
        for (aw awVar2 : this.f23297e.keySet()) {
            double longValue = (double) ((Long) this.f23297e.get(awVar2)).longValue();
            if (longValue == 0.0d && (awVar2.mo4649b() & 1) > 0) {
                arrayList.add(new Pair(Integer.valueOf(1), awVar2));
            } else if (awVar2.mo4651d() && longValue > ((double) awVar2.mo4650c().longValue()) && !this.f23295c.contains(awVar2) && (awVar2.mo4649b() & 256) > 0) {
                arrayList.add(new Pair(Integer.valueOf(256), awVar2));
                this.f23295c.add(awVar2);
            }
        }
        for (aw awVar22 : hashMap.keySet()) {
            if (!this.f23297e.containsKey(awVar22)) {
                if ((awVar22.mo4649b() & 16) > 0) {
                    arrayList.add(new Pair(Integer.valueOf(16), awVar22));
                }
                if (this.f23295c.contains(awVar22)) {
                    this.f23295c.remove(awVar22);
                }
            }
        }
        return arrayList;
    }
}
