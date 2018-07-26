package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.indooratlas.android.sdk._internal.de.C5847a;
import com.indooratlas.android.sdk._internal.ea.C5863a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class eb implements db {
    /* renamed from: a */
    public static final String f23502a = (eb.class.getSimpleName() + ".scanCacheSize");
    /* renamed from: b */
    public static final String f23503b = (eb.class.getSimpleName() + ".getLatestScanResults");
    /* renamed from: g */
    private static cw f23504g = new C5847a().m20303a(-100).m20304a();
    /* renamed from: h */
    private static cw f23505h = new C5847a().m20303a(-101).m20304a();
    /* renamed from: c */
    dz f23506c;
    /* renamed from: d */
    dy f23507d;
    /* renamed from: e */
    public final dw f23508e;
    /* renamed from: f */
    public Context f23509f;
    /* renamed from: i */
    private ea f23510i;
    /* renamed from: j */
    private WifiManager f23511j;

    private eb(Context context, @NonNull WifiManager wifiManager, @NonNull ea eaVar) {
        this.f23508e = new dw();
        this.f23509f = context;
        this.f23510i = eaVar;
        this.f23511j = wifiManager;
    }

    /* renamed from: a */
    public final cw mo4660a(int i) {
        switch (i) {
            case -101:
                return f23505h;
            case -100:
                return f23504g;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final List<cw> mo4661a() {
        List arrayList = new ArrayList(1);
        arrayList.add(f23504g);
        arrayList.add(f23505h);
        return arrayList;
    }

    /* renamed from: a */
    public final void mo4665a(cy cyVar, cw cwVar, da daVar) {
        m20388a(true, cyVar, cwVar, daVar);
    }

    /* renamed from: a */
    public final void mo4663a(cy cyVar) {
        m20388a(false, cyVar, null, null);
    }

    /* renamed from: a */
    public final void mo4664a(cy cyVar, cw cwVar) {
        m20388a(false, cyVar, cwVar, null);
    }

    /* renamed from: a */
    private void m20388a(boolean z, cy cyVar, cw cwVar, da daVar) {
        ArrayList arrayList = null;
        synchronized (this.f23508e) {
            dv a;
            int a2 = this.f23508e.m20367a(f23504g);
            int a3 = this.f23508e.m20367a(f23505h);
            if (z) {
                a = this.f23508e.m20368a(cyVar, cwVar, daVar);
            } else if (cwVar == null) {
                a = null;
                arrayList = this.f23508e.m20369a(cyVar);
            } else {
                a = null;
                arrayList = this.f23508e.m20370a(cyVar, cwVar);
            }
            int a4 = this.f23508e.m20367a(f23504g);
            int a5 = this.f23508e.m20367a(f23505h);
            if (a != null) {
                a.m20362a();
                Bundle bundle = daVar.f23373b;
                if (bundle != null && bundle.getBoolean(f23503b, false)) {
                    a.m20363a(m20390a(cwVar.mo4658a(), this.f23511j.getScanResults()));
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((dv) it.next()).m20364b();
                }
            }
            if (a4 > 0 && a4 != a2) {
                int a6 = this.f23508e.m20366a(-100);
                if (this.f23506c == null) {
                    this.f23506c = new dz(this, this.f23511j);
                }
                this.f23506c.a((long) (a6 / 1000));
            }
            if (a5 > 0 && a3 == 0) {
                if (this.f23507d == null) {
                    this.f23507d = new dy(this, this.f23511j);
                }
                this.f23507d.a(0);
            }
            if (a4 == 0 && a2 > 0) {
                this.f23506c.m20377a();
            }
            if (a5 == 0 && a3 > 0) {
                this.f23507d.a();
            }
        }
    }

    /* renamed from: a */
    public final List<cx> mo4662a(cw cwVar) {
        return null;
    }

    /* renamed from: a */
    public final cx m20390a(int i, List<ScanResult> list) {
        List list2;
        if (list.isEmpty()) {
            list2 = list;
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            for (ScanResult scanResult : list) {
                if (VERSION.SDK_INT < 17 || this.f23510i.mo4669a(scanResult) > 0) {
                    arrayList.add(scanResult);
                }
            }
            Object obj = arrayList;
        }
        cx cxVar = new cx();
        cxVar.f23361d = SystemClock.elapsedRealtime();
        if (i == -100) {
            cxVar.f23358a = f23504g;
        } else if (i == -101) {
            cxVar.f23358a = f23505h;
        } else {
            throw new IllegalArgumentException("Unknown sensor integer type: " + i);
        }
        cxVar.f23360c = dx.m20374a(list2);
        if (VERSION.SDK_INT < 17 || list.isEmpty()) {
            cxVar.f23359b = SystemClock.elapsedRealtime() * 1000;
        } else {
            cxVar.f23359b = ((ScanResult) list.get(0)).timestamp;
        }
        return cxVar;
    }

    public eb(Context context) {
        this(context, (WifiManager) context.getSystemService(C1981b.f6365e), new C5863a());
    }
}
