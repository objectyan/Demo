package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;

/* renamed from: com.baidu.location.indoor.i */
public class C3450i {
    /* renamed from: a */
    private C3424a f18686a;
    /* renamed from: b */
    private long f18687b = 450;
    /* renamed from: c */
    private BDLocation f18688c;
    /* renamed from: d */
    private C3449b f18689d = null;
    /* renamed from: e */
    private C3449b f18690e = null;
    /* renamed from: f */
    private C3449b f18691f = new C3449b(this);
    /* renamed from: g */
    private C3449b f18692g = new C3449b(this);
    /* renamed from: h */
    private C3449b f18693h = new C3449b(this);
    /* renamed from: i */
    private C3449b f18694i = new C3449b(this);
    /* renamed from: j */
    private long f18695j = -1;
    /* renamed from: k */
    private boolean f18696k = false;
    /* renamed from: l */
    private Handler f18697l = new Handler();
    /* renamed from: m */
    private Runnable f18698m = new C34481(this);

    /* renamed from: com.baidu.location.indoor.i$a */
    public interface C3424a {
        /* renamed from: a */
        void mo2518a(BDLocation bDLocation);
    }

    /* renamed from: com.baidu.location.indoor.i$1 */
    class C34481 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3450i f18682a;

        C34481(C3450i c3450i) {
            this.f18682a = c3450i;
        }

        public void run() {
            C3449b a = this.f18682a.m14800a(this.f18682a.f18690e);
            if (!(a == null || this.f18682a.f18686a == null)) {
                this.f18682a.f18690e = this.f18682a.f18690e.m14797b(a);
                long currentTimeMillis = System.currentTimeMillis();
                if (!a.m14798b(2.0E-6d) && currentTimeMillis - this.f18682a.f18695j > this.f18682a.f18687b) {
                    BDLocation bDLocation = new BDLocation(this.f18682a.f18688c);
                    bDLocation.setLatitude(this.f18682a.f18690e.f18683a);
                    bDLocation.setLongitude(this.f18682a.f18690e.f18684b);
                    this.f18682a.f18686a.mo2518a(bDLocation);
                    this.f18682a.f18695j = currentTimeMillis;
                }
            }
            this.f18682a.f18697l.postDelayed(this.f18682a.f18698m, 450);
        }
    }

    /* renamed from: com.baidu.location.indoor.i$b */
    private class C3449b {
        /* renamed from: a */
        public double f18683a;
        /* renamed from: b */
        public double f18684b;
        /* renamed from: c */
        final /* synthetic */ C3450i f18685c;

        public C3449b(C3450i c3450i) {
            this.f18685c = c3450i;
            this.f18683a = 0.0d;
            this.f18684b = 0.0d;
        }

        public C3449b(C3450i c3450i, double d, double d2) {
            this.f18685c = c3450i;
            this.f18683a = d;
            this.f18684b = d2;
        }

        public C3449b(C3450i c3450i, C3449b c3449b) {
            this.f18685c = c3450i;
            this.f18683a = c3449b.f18683a;
            this.f18684b = c3449b.f18684b;
        }

        /* renamed from: a */
        public C3449b m14795a(double d) {
            return new C3449b(this.f18685c, this.f18683a * d, this.f18684b * d);
        }

        /* renamed from: a */
        public C3449b m14796a(C3449b c3449b) {
            return new C3449b(this.f18685c, this.f18683a - c3449b.f18683a, this.f18684b - c3449b.f18684b);
        }

        /* renamed from: b */
        public C3449b m14797b(C3449b c3449b) {
            return new C3449b(this.f18685c, this.f18683a + c3449b.f18683a, this.f18684b + c3449b.f18684b);
        }

        /* renamed from: b */
        public boolean m14798b(double d) {
            double abs = Math.abs(this.f18683a);
            double abs2 = Math.abs(this.f18684b);
            return abs > 0.0d && abs < d && abs2 > 0.0d && abs2 < d;
        }
    }

    /* renamed from: a */
    private C3449b m14800a(C3449b c3449b) {
        if (this.f18689d == null || c3449b == null) {
            return null;
        }
        C3449b a = this.f18689d.m14796a(c3449b);
        this.f18694i = this.f18694i.m14797b(a);
        C3449b a2 = this.f18693h.m14796a(this.f18691f);
        this.f18691f = new C3449b(this, this.f18693h);
        this.f18693h = new C3449b(this, a);
        a = a.m14795a(0.2d);
        C3449b a3 = this.f18694i.m14795a(0.01d);
        return a.m14797b(a3).m14797b(a2.m14795a(-0.02d));
    }

    /* renamed from: a */
    public void m14810a() {
        if (this.f18696k) {
            this.f18696k = false;
            this.f18697l.removeCallbacks(this.f18698m);
            m14814b();
        }
    }

    /* renamed from: a */
    public void m14811a(long j) {
        this.f18687b = j;
    }

    /* renamed from: a */
    public synchronized void m14812a(BDLocation bDLocation) {
        double latitude = bDLocation.getLatitude();
        double longitude = bDLocation.getLongitude();
        this.f18688c = bDLocation;
        this.f18689d = new C3449b(this, latitude, longitude);
        if (this.f18690e == null) {
            this.f18690e = new C3449b(this, latitude, longitude);
        }
    }

    /* renamed from: a */
    public void m14813a(C3424a c3424a) {
        if (!this.f18696k) {
            this.f18696k = true;
            this.f18686a = c3424a;
            this.f18697l.postDelayed(this.f18698m, 450);
        }
    }

    /* renamed from: b */
    public void m14814b() {
        this.f18695j = -1;
        this.f18690e = null;
        this.f18689d = null;
        this.f18691f = new C3449b(this);
        this.f18692g = new C3449b(this);
        this.f18693h = new C3449b(this);
        this.f18694i = new C3449b(this);
    }

    /* renamed from: c */
    public boolean m14815c() {
        return this.f18696k;
    }
}
