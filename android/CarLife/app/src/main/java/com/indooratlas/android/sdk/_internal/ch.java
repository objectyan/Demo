package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;
import com.indooratlas.android.sdk._internal.ff.C5902h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ch extends ds {
    /* renamed from: b */
    protected final cq f23097b;

    public ch(bf bfVar) {
        this.f23097b = new cq(bfVar.f23177v);
    }

    /* renamed from: a */
    public final void mo4616a(cx cxVar, dd ddVar) {
        int i;
        if (cxVar.f23358a == null || !(cxVar.f23358a.mo4658a() == -100 || cxVar.f23358a.mo4658a() == -101)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            List list = (List) cxVar.f23360c;
            cq cqVar = this.f23097b;
            if (list != null) {
                Object[] objArr = new Object[]{Integer.valueOf(list.size()), Long.valueOf(cqVar.f23349d), Long.valueOf(cqVar.f23350e)};
                cqVar.f23349d = cqVar.f23348c.mo4654a();
                cqVar.f23350e = SystemClock.elapsedRealtime();
                if (!list.isEmpty()) {
                    List<dx> arrayList = new ArrayList(list);
                    Collections.sort(arrayList, cu.f23357a);
                    for (dx dxVar : arrayList) {
                        if (dxVar.f23485h != 0) {
                            int i2;
                            int i3 = dxVar.f23484g;
                            if (i3 < 2412 || i3 > 2484) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            if (i2 == 0) {
                                if (i3 < 5170 || i3 > 5825) {
                                    i2 = 0;
                                } else {
                                    i2 = 1;
                                }
                                if (i2 == 0) {
                                    objArr = new Object[]{Integer.valueOf(i3), dxVar};
                                } else if (cqVar.m20243a(cqVar.f23346a, dxVar)) {
                                }
                            } else if (cqVar.m20243a(cqVar.f23347b, dxVar)) {
                            }
                        }
                    }
                }
            }
            cq cqVar2 = this.f23097b;
            C5902h c5902h = new C5902h();
            c5902h.f23661b = cqVar2.f23349d;
            c5902h.f23662d = cq.m20242a(cqVar2.f23347b);
            c5902h.f23663e = cq.m20242a(cqVar2.f23346a);
            cqVar2 = this.f23097b;
            cqVar2.f23347b.clear();
            cqVar2.f23346a.clear();
            mo4618a(c5902h);
        }
        super.mo4616a(cxVar, ddVar);
    }

    /* renamed from: a */
    public void mo4618a(C5902h c5902h) {
    }
}
