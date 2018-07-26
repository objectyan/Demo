package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.location.LocationManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.indooratlas.android.sdk._internal.de.C5847a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dr implements db {
    /* renamed from: a */
    final dw f23442a = new dw();
    /* renamed from: b */
    private final cw f23443b = new C5847a().m20303a(-300).m20304a();
    /* renamed from: c */
    private final cw f23444c = new C5847a().m20303a(-301).m20304a();
    /* renamed from: d */
    private final cw f23445d = new C5847a().m20303a(-302).m20304a();
    /* renamed from: e */
    private final dp f23446e;
    /* renamed from: f */
    private final dp f23447f;
    /* renamed from: g */
    private final dp f23448g;

    public dr(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        this.f23446e = new dp(locationManager, "gps", this.f23443b, this);
        this.f23447f = new dp(locationManager, C1981b.f6367g, this.f23444c, this);
        this.f23448g = new dp(locationManager, "passive", this.f23445d, this);
    }

    /* renamed from: a */
    public final cw mo4660a(int i) {
        if (i == this.f23443b.mo4658a()) {
            return this.f23443b;
        }
        if (i == this.f23444c.mo4658a()) {
            return this.f23444c;
        }
        if (i == this.f23445d.mo4658a()) {
            return this.f23445d;
        }
        return null;
    }

    /* renamed from: a */
    public final List<cw> mo4661a() {
        List arrayList = new ArrayList();
        arrayList.add(this.f23443b);
        arrayList.add(this.f23444c);
        arrayList.add(this.f23445d);
        return arrayList;
    }

    /* renamed from: a */
    public final void mo4665a(cy cyVar, cw cwVar, da daVar) {
        m20350a(true, cyVar, cwVar, daVar);
    }

    /* renamed from: a */
    public final void mo4663a(cy cyVar) {
        m20350a(false, cyVar, null, null);
    }

    /* renamed from: a */
    public final void mo4664a(cy cyVar, cw cwVar) {
        m20350a(false, cyVar, cwVar, null);
    }

    /* renamed from: a */
    private void m20350a(boolean z, cy cyVar, cw cwVar, da daVar) {
        ArrayList arrayList = null;
        synchronized (this.f23442a) {
            dv a;
            int a2 = this.f23442a.m20367a(this.f23443b);
            int a3 = this.f23442a.m20367a(this.f23444c);
            int a4 = this.f23442a.m20367a(this.f23445d);
            if (z) {
                a = this.f23442a.m20368a(cyVar, cwVar, daVar);
            } else if (cwVar == null) {
                a = null;
                arrayList = this.f23442a.m20369a(cyVar);
            } else {
                a = null;
                arrayList = this.f23442a.m20370a(cyVar, cwVar);
            }
            if (a != null) {
                a.m20362a();
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((dv) it.next()).m20364b();
                }
            }
            int a5 = this.f23442a.m20367a(this.f23443b);
            int a6 = this.f23442a.m20367a(this.f23444c);
            int a7 = this.f23442a.m20367a(this.f23445d);
            int b = this.f23442a.m20373b(this.f23443b);
            int b2 = this.f23442a.m20373b(this.f23444c);
            this.f23446e.m20348a(a2, a5, b / 1000);
            this.f23447f.m20348a(a3, a6, b2 / 1000);
            this.f23448g.m20348a(a4, a7, 0);
        }
    }

    /* renamed from: a */
    public final List<cx> mo4662a(cw cwVar) {
        List arrayList = new ArrayList();
        Object obj = null;
        if (cwVar.mo4658a() == -300) {
            obj = this.f23446e.m20347a();
        } else if (cwVar.mo4658a() == -301) {
            obj = this.f23447f.m20347a();
        } else if (cwVar.mo4658a() == -302) {
            obj = this.f23448g.m20347a();
        }
        if (obj != null) {
            arrayList.add(obj);
        }
        return arrayList;
    }
}
