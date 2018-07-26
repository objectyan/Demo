package com.baidu.location.p191d;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p193e.C3349d.C3346a;
import com.baidu.location.p193e.C3349d.C3347b;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.platform.comapi.UIMsg;
import java.util.HashMap;

/* renamed from: com.baidu.location.d.k */
public class C3316k {
    /* renamed from: a */
    private static C3316k f17976a;
    /* renamed from: b */
    private C3372e f17977b = null;
    /* renamed from: c */
    private C3362a f17978c = null;
    /* renamed from: d */
    private long f17979d = 0;
    /* renamed from: e */
    private final long f17980e = 1000;
    /* renamed from: f */
    private String f17981f = null;

    /* renamed from: com.baidu.location.d.k$a */
    class C3315a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3316k f17974a;
        /* renamed from: b */
        private String f17975b;

        C3315a(C3316k c3316k) {
            this.f17974a = c3316k;
            this.f17975b = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.i = 1;
            this.h = C3391g.m14448e();
            String encodeTp4 = Jni.encodeTp4(this.f17975b);
            this.f17975b = null;
            this.k.put("bloc", encodeTp4);
        }

        /* renamed from: a */
        public void m13944a(String str) {
            this.f17975b = str;
            m13299c(C3391g.f18379f);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                boolean z2 = C3391g.f18381h;
                C3391g.f18381h = true;
                if (C3349d.m14171a().m14186d() && C3349d.m14171a().m14188f()) {
                    BDLocation a = C3349d.m14171a().m14182a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), null, C3347b.IS_NOT_MIX_MODE, C3346a.NEED_TO_LOG);
                    if (a == null || a.getLocType() == 67) {
                        this.f17974a.m13948a(null);
                    } else {
                        this.f17974a.m13948a(a.getLocationDescribe());
                    }
                } else {
                    this.f17974a.m13948a(null);
                }
                if (!z2) {
                    C3391g.f18381h = false;
                }
            } else {
                try {
                    this.f17974a.m13948a(new BDLocation(this.j).getLocationDescribe());
                } catch (Exception e) {
                    this.f17974a.m13948a(null);
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private C3316k() {
    }

    /* renamed from: a */
    public static synchronized C3316k m13946a() {
        C3316k c3316k;
        synchronized (C3316k.class) {
            if (f17976a == null) {
                f17976a = new C3316k();
            }
            c3316k = f17976a;
        }
        return c3316k;
    }

    /* renamed from: a */
    private void m13948a(String str) {
        this.f17981f = str;
        Bundle bundle = new Bundle();
        if (str == null || str.equals("")) {
            bundle.putByteArray("locationtag", null);
        } else {
            bundle.putByteArray("locationtag", str.getBytes());
        }
        C3181a.m13265a().m13270a(bundle, (int) UIMsg.MSG_MAP_PANO_ROUTE_DATA);
    }

    /* renamed from: a */
    private boolean m13949a(C3362a c3362a) {
        C3362a f = C3364b.m14262a().m14280f();
        return f == c3362a ? false : f == null || c3362a == null || !c3362a.m14247a(f);
    }

    /* renamed from: a */
    private boolean m13950a(C3372e c3372e) {
        C3372e q = C3376f.m14355a().m14381q();
        return c3372e == q ? false : q == null || c3372e == null || !c3372e.m14340c(q);
    }

    /* renamed from: b */
    public void m13951b() {
        if (System.currentTimeMillis() - this.f17979d >= 1000 || this.f17981f == null) {
            this.f17979d = System.currentTimeMillis();
            boolean a = m13950a(this.f17977b);
            boolean a2 = m13949a(this.f17978c);
            if (a || a2 || this.f17981f == null) {
                String m;
                this.f17978c = C3364b.m14262a().m14280f();
                this.f17977b = C3376f.m14355a().m14381q();
                StringBuffer stringBuffer = new StringBuffer(1024);
                if (this.f17978c != null && this.f17978c.m14248b()) {
                    stringBuffer.append(this.f17978c.m14255i());
                }
                if (this.f17977b == null || this.f17977b.m14330a() <= 1) {
                    m = C3376f.m14355a().m14377m();
                    if (m != null) {
                        stringBuffer.append(m);
                    }
                } else {
                    stringBuffer.append(this.f17977b.m14331a(15));
                }
                m = C3371d.m14289a().m14320h();
                if (m != null) {
                    stringBuffer.append(m);
                }
                stringBuffer.append("&sema=aptag");
                stringBuffer.append(C3381b.m14398a().m14399a(false));
                stringBuffer.append(C3181a.m13265a().m13283f());
                new C3315a(this).m13944a(stringBuffer.toString());
                return;
            }
            m13948a(this.f17981f);
            return;
        }
        m13948a(this.f17981f);
    }
}
