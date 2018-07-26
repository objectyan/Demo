package com.baidu.location.indoor.p196a;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

/* renamed from: com.baidu.location.indoor.a.b */
public class C3400b {
    /* renamed from: a */
    private static volatile C3400b f18418a;
    /* renamed from: b */
    private final C3404c f18419b = new C3404c(this);
    /* renamed from: c */
    private final BDLocationListener f18420c;
    /* renamed from: d */
    private final BDLocationListener f18421d;

    /* renamed from: com.baidu.location.indoor.a.b$1 */
    class C33991 extends BDLocationListener {
        /* renamed from: a */
        final /* synthetic */ C3400b f18417a;

        C33991(C3400b c3400b) {
            this.f18417a = c3400b;
        }

        public void onConnectHotSpotMessage(String str, int i) {
        }

        public void onReceiveLocation(BDLocation bDLocation) {
            this.f18417a.f18419b.m14505b(bDLocation);
        }
    }

    private C3400b(BDLocationListener bDLocationListener) {
        this.f18420c = bDLocationListener;
        this.f18421d = new C33991(this);
    }

    /* renamed from: a */
    public static C3400b m14479a(BDLocationListener bDLocationListener) {
        if (f18418a == null) {
            synchronized (C3400b.class) {
                if (f18418a == null) {
                    f18418a = new C3400b(bDLocationListener);
                }
            }
        }
        return f18418a;
    }

    /* renamed from: a */
    public BDLocation m14481a() {
        return this.f18419b.m14504b();
    }

    /* renamed from: a */
    void m14482a(BDLocation bDLocation) {
        this.f18420c.onReceiveLocation(bDLocation);
    }

    /* renamed from: b */
    public BDLocationListener m14483b() {
        return this.f18421d;
    }

    /* renamed from: c */
    public void m14484c() {
        this.f18419b.m14502a();
    }

    /* renamed from: d */
    public void m14485d() {
        this.f18419b.m14508e();
    }
}
