package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.indooratlas.android.sdk._internal.de.C5847a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class dg implements db {
    /* renamed from: a */
    Handler f23386a;
    /* renamed from: b */
    df f23387b;
    /* renamed from: c */
    long f23388c;
    /* renamed from: d */
    final List<dh> f23389d = new ArrayList();
    /* renamed from: e */
    private final Context f23390e;
    /* renamed from: f */
    private cw f23391f;
    /* renamed from: g */
    private final dw f23392g = new dw();
    /* renamed from: h */
    private final Runnable f23393h = new C58481(this);

    /* renamed from: com.indooratlas.android.sdk._internal.dg$1 */
    class C58481 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ dg f23385a;

        C58481(dg dgVar) {
            this.f23385a = dgVar;
        }

        public final void run() {
            if (this.f23385a.m20319b().f23382a) {
                this.f23385a.m20320c();
                this.f23385a.m20312d();
            }
        }
    }

    public dg(@NonNull Context context) {
        this.f23390e = context;
        if (!this.f23390e.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || VERSION.SDK_INT < 18) {
            String str = cz.f23362a;
            new StringBuilder("Device doesn't have BLE support, Android version=").append(VERSION.SDK_INT);
            return;
        }
        this.f23391f = new C5847a().m20303a(SapiErrorCode.NETWORK_FAILED).m20304a();
        this.f23386a = new Handler();
    }

    /* renamed from: a */
    public final cw mo4660a(int i) {
        return i == SapiErrorCode.NETWORK_FAILED ? this.f23391f : null;
    }

    /* renamed from: a */
    public final List<cw> mo4661a() {
        List arrayList = new ArrayList(1);
        if (this.f23391f != null) {
            arrayList.add(this.f23391f);
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo4665a(cy cyVar, cw cwVar, da daVar) {
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        eg.m20413a((Object) cwVar, "sensor cannot be null", new Object[0]);
        eg.m20413a((Object) daVar, "params cannot be null", new Object[0]);
        m20311a(true, cyVar, cwVar, daVar);
    }

    /* renamed from: a */
    public final void mo4663a(cy cyVar) {
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        m20311a(false, cyVar, null, null);
    }

    /* renamed from: a */
    public final void mo4664a(cy cyVar, cw cwVar) {
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        eg.m20413a((Object) cwVar, "sensor cannot be null", new Object[0]);
        m20311a(false, cyVar, cwVar, null);
    }

    /* renamed from: a */
    private void m20311a(boolean z, cy cyVar, cw cwVar, da daVar) {
        ArrayList arrayList = null;
        if (this.f23391f != null) {
            synchronized (this.f23392g) {
                dv a;
                int a2 = this.f23392g.m20367a(this.f23391f);
                if (z) {
                    a = this.f23392g.m20368a(cyVar, cwVar, daVar);
                } else if (cwVar == null) {
                    a = null;
                    arrayList = this.f23392g.m20369a(cyVar);
                } else {
                    a = null;
                    arrayList = this.f23392g.m20370a(cyVar, cwVar);
                }
                int a3 = this.f23392g.m20367a(this.f23391f);
                if (a != null) {
                    a.m20362a();
                }
                if (a3 > 0 && a3 != a2) {
                    synchronized (this.f23389d) {
                        this.f23389d.clear();
                    }
                    m20319b().mo4666a();
                    m20312d();
                } else if (a3 == 0 && a2 > 0) {
                    m20319b().mo4667b();
                    synchronized (this.f23389d) {
                        this.f23389d.clear();
                    }
                    this.f23386a.removeCallbacks(this.f23393h);
                }
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((dv) it.next()).m20364b();
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m20312d() {
        long a = (long) (this.f23392g.m20366a((int) SapiErrorCode.NETWORK_FAILED) / 1000);
        if (a < 100) {
            a = 0;
        }
        this.f23388c = a;
        if (this.f23386a != null) {
            this.f23386a.removeCallbacks(this.f23393h);
            if (m20319b().f23382a && this.f23388c >= 100) {
                this.f23386a.postDelayed(this.f23393h, this.f23388c);
            }
        }
    }

    /* renamed from: a */
    public final List<cx> mo4662a(cw cwVar) {
        return null;
    }

    /* renamed from: b */
    final df m20319b() {
        if (this.f23387b == null) {
            if (VERSION.SDK_INT >= 21) {
                this.f23387b = new dj(aq.m19842a(this.f23390e), this);
            } else {
                this.f23387b = new dk(aq.m19842a(this.f23390e), this);
            }
        }
        return this.f23387b;
    }

    /* renamed from: c */
    final void m20320c() {
        cx cxVar = new cx();
        synchronized (this.f23389d) {
            if (this.f23389d.isEmpty()) {
                return;
            }
            List<dh> list = this.f23389d;
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (dh add : list) {
                copyOnWriteArrayList.add(add);
            }
            cxVar.f23360c = copyOnWriteArrayList;
            long j = ((dh) this.f23389d.get(0)).f23403j;
            this.f23389d.clear();
            cxVar.f23358a = this.f23391f;
            cxVar.f23361d = SystemClock.elapsedRealtime();
            cxVar.f23359b = j;
            this.f23392g.m20372a(cxVar);
        }
    }
}
