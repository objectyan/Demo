package com.indooratlas.android.sdk._internal;

import android.util.SparseArray;
import com.indooratlas.android.sdk._internal.dt.C5853a;
import com.indooratlas.android.sdk._internal.dt.C5855c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class du extends ds {
    /* renamed from: a */
    dt f23464a;
    /* renamed from: b */
    private boolean f23465b;
    /* renamed from: d */
    private int[] f23466d;
    /* renamed from: e */
    private SparseArray<C5857b> f23467e;
    /* renamed from: f */
    private int f23468f;
    /* renamed from: g */
    private int f23469g;

    /* renamed from: com.indooratlas.android.sdk._internal.du$a */
    static class C5856a {
        /* renamed from: a */
        long f23457a;
        /* renamed from: b */
        long f23458b;
        /* renamed from: c */
        HashSet<C5857b> f23459c = new HashSet();

        C5856a() {
        }

        public final String toString() {
            return "MatchGroup{minTimestamp=" + this.f23457a + ", maxTimestamp=" + this.f23458b + ", samples=" + this.f23459c + '}';
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.du$b */
    static class C5857b {
        /* renamed from: a */
        int f23460a;
        /* renamed from: b */
        long f23461b;
        /* renamed from: c */
        long f23462c;
        /* renamed from: d */
        long f23463d = ej.m20419a();

        C5857b(int i, long j) {
            this.f23460a = i;
            this.f23461b = j;
        }

        public final String toString() {
            return "TimestampSample{sensorType=" + this.f23460a + ", firstTimestamp=" + this.f23461b + ", lastTimestamp=" + this.f23462c + ", lastSeen=" + this.f23463d + '}';
        }
    }

    public du(cw[] cwVarArr) {
        this.f23466d = new int[cwVarArr.length];
        for (int i = 0; i < cwVarArr.length; i++) {
            this.f23466d[i] = cwVarArr[i].mo4658a();
        }
        this.f23469g = this.f23466d.length;
        this.f23467e = new SparseArray(this.f23469g);
    }

    /* renamed from: a */
    public final void mo4616a(cx cxVar, dd ddVar) {
        int i;
        eg.m20413a((Object) cxVar, "event must not be null", new Object[0]);
        int a = cxVar.f23358a.mo4658a();
        int[] iArr = this.f23466d;
        int length = iArr != null ? iArr.length : -1;
        if (length > 0) {
            i = 0;
            while (i < length) {
                if (iArr[i] == a) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        if (i == -1) {
            ddVar.m20302b(cxVar);
            return;
        }
        if (!this.f23465b) {
            C5857b c5857b = (C5857b) this.f23467e.get(a);
            if (c5857b == null) {
                this.f23467e.put(a, new C5857b(a, cxVar.f23359b));
                this.f23468f++;
            } else {
                c5857b.f23463d = ej.m20419a();
                c5857b.f23462c = cxVar.f23359b;
            }
            if (this.f23468f == this.f23469g) {
                this.f23465b = true;
                SparseArray sparseArray = this.f23467e;
                ArrayList arrayList = new ArrayList();
                int size = sparseArray.size();
                for (length = 0; length < size; length++) {
                    m20360a(arrayList, (C5857b) sparseArray.valueAt(length));
                }
                i = arrayList.size();
                String str = cz.f23362a;
                new Object[1][0] = arrayList;
                String str2;
                if (i == 1) {
                    str2 = cz.f23362a;
                    this.f23096c = false;
                } else if (i == 2) {
                    C5856a c5856a = (C5856a) arrayList.get(0);
                    C5856a c5856a2 = (C5856a) arrayList.get(1);
                    int size2 = c5856a.f23459c.size();
                    int size3 = c5856a2.f23459c.size();
                    if (size2 <= 1 || size3 <= 1) {
                        if (size2 < size3) {
                            C5856a c5856a3 = c5856a;
                            c5856a = c5856a2;
                            c5856a2 = c5856a3;
                        }
                        c5857b = (C5857b) c5856a.f23459c.iterator().next();
                        this.f23464a = new C5855c(c5857b.f23460a, ((C5857b) c5856a2.f23459c.iterator().next()).f23460a, c5857b.f23462c, c5857b.f23463d);
                        str = cz.f23362a;
                        Object[] objArr = new Object[]{r8, c5857b};
                    } else {
                        str2 = cz.f23362a;
                        this.f23464a = new C5853a();
                    }
                } else {
                    this.f23464a = new C5853a();
                    str = cz.f23362a;
                    new Object[1][0] = Integer.valueOf(i);
                }
            } else {
                return;
            }
        }
        if (this.f23465b && this.f23464a != null) {
            cxVar.f23359b = this.f23464a.mo4668a(a, cxVar.f23359b);
        }
        super.mo4616a(cxVar, ddVar);
    }

    /* renamed from: a */
    private static void m20360a(ArrayList<C5856a> arrayList, C5857b c5857b) {
        C5856a c5856a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c5856a = (C5856a) it.next();
            long j = c5856a.f23457a + 2000000000;
            if (c5857b.f23461b >= c5856a.f23458b - 2000000000 && c5857b.f23461b <= j) {
                c5856a.f23457a = Math.min(c5856a.f23457a, c5857b.f23461b);
                c5856a.f23458b = Math.max(c5856a.f23458b, c5857b.f23461b);
                break;
            }
        }
        c5856a = null;
        if (c5856a == null) {
            c5856a = new C5856a();
            c5856a.f23457a = c5857b.f23461b;
            c5856a.f23458b = c5857b.f23461b;
            arrayList.add(c5856a);
        }
        c5856a.f23459c.add(c5857b);
    }
}
