package com.baidu.location.p191d;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import java.util.HashMap;

/* renamed from: com.baidu.location.d.h */
public class C3303h {
    /* renamed from: a */
    private static C3303h f17922a;
    /* renamed from: b */
    private C3372e f17923b = null;
    /* renamed from: c */
    private C3362a f17924c = null;
    /* renamed from: d */
    private long f17925d = 0;
    /* renamed from: e */
    private BDLocation f17926e = null;
    /* renamed from: f */
    private long f17927f = 0;
    /* renamed from: g */
    private int f17928g = 0;
    /* renamed from: h */
    private boolean f17929h = false;

    /* renamed from: com.baidu.location.d.h$a */
    class C3302a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3303h f17920a;
        /* renamed from: b */
        private String f17921b;

        C3302a(C3303h c3303h) {
            this.f17920a = c3303h;
            this.f17921b = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.i = 1;
            this.h = C3391g.m14448e();
            String encodeTp4 = Jni.encodeTp4(this.f17921b);
            this.f17921b = null;
            this.k.put("bloc", encodeTp4);
        }

        /* renamed from: a */
        public void m13892a(String str) {
            this.f17921b = str;
            m13299c(C3391g.f18379f);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                try {
                    this.f17920a.m13895a(new BDLocation(this.j));
                } catch (Exception e) {
                    this.f17920a.m13895a(null);
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f17920a.f17929h = false;
        }
    }

    private C3303h() {
    }

    /* renamed from: a */
    public static synchronized C3303h m13894a() {
        C3303h c3303h;
        synchronized (C3303h.class) {
            if (f17922a == null) {
                f17922a = new C3303h();
            }
            c3303h = f17922a;
        }
        return c3303h;
    }

    /* renamed from: a */
    private void m13895a(BDLocation bDLocation) {
        this.f17926e = bDLocation;
        Bundle bundle = new Bundle();
        if (bDLocation != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("wf")) {
            bundle.putParcelable("navimodelocation", bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            C3181a.m13265a().m13270a(bundle, 404);
        }
    }

    /* renamed from: a */
    private boolean m13898a(C3362a c3362a) {
        C3362a f = C3364b.m14262a().m14280f();
        return f == c3362a ? false : f == null || c3362a == null || !c3362a.m14247a(f);
    }

    /* renamed from: a */
    private boolean m13899a(C3372e c3372e) {
        C3372e q = C3376f.m14355a().m14381q();
        return c3372e == q ? false : q == null || c3372e == null || !c3372e.m14340c(q);
    }

    /* renamed from: b */
    private void m13900b(int i) {
        if (System.currentTimeMillis() - this.f17925d < 1000 && this.f17926e != null) {
            m13895a(this.f17926e);
        } else if (!this.f17929h) {
            this.f17925d = System.currentTimeMillis();
            boolean a = m13899a(this.f17923b);
            boolean a2 = m13898a(this.f17924c);
            if (a || a2 || this.f17926e == null) {
                this.f17924c = C3364b.m14262a().m14280f();
                this.f17923b = C3376f.m14355a().m14381q();
                StringBuffer stringBuffer = new StringBuffer(1024);
                if (this.f17924c != null && this.f17924c.m14248b()) {
                    stringBuffer.append(this.f17924c.m14255i());
                }
                if (this.f17923b != null && this.f17923b.m14330a() > 1) {
                    stringBuffer.append(this.f17923b.m14331a(15));
                }
                stringBuffer.append("&nase=" + i);
                stringBuffer.append("&coor=bd09");
                stringBuffer.append(C3381b.m14398a().m14399a(false));
                stringBuffer.append(C3181a.m13265a().m13283f());
                new C3302a(this).m13892a(stringBuffer.toString());
                this.f17929h = true;
                return;
            }
            m13895a(this.f17926e);
        }
    }

    /* renamed from: a */
    public void m13901a(int i) {
        this.f17928g = i;
        m13900b(i);
    }

    /* renamed from: b */
    public void m13902b() {
        if (this.f17928g != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f17927f;
            if (currentTimeMillis > 0 && currentTimeMillis >= 3000) {
                this.f17927f = System.currentTimeMillis();
                String h = C3376f.m14355a().m14373h();
                if (h != null && h.equals("&wifio=1")) {
                    m13900b(this.f17928g);
                }
            }
        }
    }

    /* renamed from: c */
    public void m13903c() {
        this.f17923b = null;
        this.f17924c = null;
        this.f17925d = 0;
        this.f17926e = null;
        this.f17927f = 0;
        this.f17928g = 0;
        this.f17929h = false;
    }
}
