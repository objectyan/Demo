package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;
import com.indooratlas.algorithm.ClientProcessingManager;
import com.indooratlas.android.sdk._internal.da.C5846a;
import java.util.Iterator;

public final class bn {
    /* renamed from: a */
    dd f23209a = new dd();
    /* renamed from: b */
    bf f23210b;
    /* renamed from: c */
    cz f23211c;
    /* renamed from: d */
    cw[] f23212d;
    /* renamed from: e */
    da[] f23213e;
    /* renamed from: f */
    cw f23214f;
    /* renamed from: g */
    cw f23215g;
    /* renamed from: h */
    cw f23216h;
    /* renamed from: i */
    ClientProcessingManager f23217i;
    /* renamed from: j */
    private long f23218j;
    /* renamed from: k */
    private long f23219k;

    bn(bf bfVar, cz czVar, ClientProcessingManager clientProcessingManager) {
        this.f23210b = bfVar;
        this.f23211c = czVar;
        this.f23217i = clientProcessingManager;
    }

    /* renamed from: a */
    public final void m20119a() {
        this.f23217i.startPositioning();
        m20124d();
        if (this.f23214f != null) {
            cz czVar = this.f23211c;
            cy cyVar = this.f23209a;
            cw cwVar = this.f23214f;
            C5846a c5846a = new C5846a();
            c5846a.f23369a = this.f23210b.f23156a.f23023b;
            String str = eb.f23503b;
            c5846a.m20292a();
            c5846a.f23370b.putBoolean(str, true);
            str = eb.f23502a;
            c5846a.m20292a();
            c5846a.f23370b.putInt(str, 500);
            czVar.m20287a(cyVar, cwVar, c5846a.m20293b());
        }
        m20117h();
        if (this.f23216h != null) {
            this.f23211c.m20287a(this.f23209a, this.f23216h, new C5846a().m20293b());
        }
    }

    /* renamed from: b */
    public final void m20122b() {
        m20125e();
        if (this.f23214f != null) {
            this.f23211c.m20286a(this.f23209a, this.f23214f);
        }
        m20127g();
        if (this.f23216h != null) {
            this.f23211c.m20286a(this.f23209a, this.f23216h);
        }
        this.f23217i.stopPositioning();
    }

    /* renamed from: a */
    public final void m20121a(boolean z) {
        if (this.f23215g != null) {
            if (z) {
                m20117h();
            } else {
                m20127g();
            }
        }
    }

    /* renamed from: c */
    public final void m20123c() {
        cz czVar = this.f23211c;
        cy cyVar = this.f23209a;
        synchronized (czVar.f23364b) {
            Iterator it = czVar.f23364b.iterator();
            while (it.hasNext()) {
                ((db) it.next()).mo4663a(cyVar);
            }
        }
    }

    /* renamed from: d */
    final void m20124d() {
        int length = this.f23212d.length;
        for (int i = 0; i < length; i++) {
            cw cwVar = this.f23212d[i];
            this.f23211c.m20287a(this.f23209a, cwVar, this.f23213e[i]);
            cwVar.mo4658a();
        }
    }

    /* renamed from: e */
    final void m20125e() {
        for (cw cwVar : this.f23212d) {
            this.f23211c.m20286a(this.f23209a, cwVar);
            cwVar.mo4658a();
        }
    }

    /* renamed from: a */
    public final void m20120a(long j) {
        if (this.f23215g != null) {
            this.f23219k = j;
            if (j > 0) {
                this.f23218j = SystemClock.elapsedRealtime();
                m20118i();
                return;
            }
            m20127g();
        }
    }

    /* renamed from: h */
    private void m20117h() {
        if (this.f23215g != null && this.f23219k > 0 && m20126f() > 0) {
            m20118i();
        }
    }

    /* renamed from: f */
    protected final long m20126f() {
        return this.f23219k - (SystemClock.elapsedRealtime() - this.f23218j);
    }

    /* renamed from: g */
    protected final void m20127g() {
        if (this.f23215g != null) {
            this.f23211c.m20286a(this.f23209a, this.f23215g);
        }
    }

    /* renamed from: i */
    private void m20118i() {
        if (this.f23215g != null) {
            long optLong = this.f23210b.f23165j.f23073b.optLong("bleScanMaxNotifyInterval", 1000);
            cz czVar = this.f23211c;
            cy cyVar = this.f23209a;
            cw cwVar = this.f23215g;
            C5846a c5846a = new C5846a();
            c5846a.f23369a = this.f23210b.f23156a.f23023b;
            c5846a.f23371c = (int) (optLong * 1000);
            czVar.m20287a(cyVar, cwVar, c5846a.m20293b());
        }
    }
}
