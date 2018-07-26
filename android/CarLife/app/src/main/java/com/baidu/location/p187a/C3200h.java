package com.baidu.location.p187a;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.indoor.C3439d;
import com.baidu.location.indoor.p196a.C3398a;
import com.baidu.location.p187a.C3195f.C3193a;
import com.baidu.location.p187a.C3195f.C3194b;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3216b;
import com.baidu.location.p190c.C3232a;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p191d.C3294d;
import com.baidu.location.p191d.C3296e;
import com.baidu.location.p191d.C3299f;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p191d.C3314j;
import com.baidu.location.p191d.C3314j.C3310b;
import com.baidu.location.p191d.C3316k;
import com.baidu.location.p191d.C3320m;
import com.baidu.location.p191d.p192a.C3274f;
import com.baidu.location.p193e.C3335a;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p193e.C3349d.C3346a;
import com.baidu.location.p193e.C3349d.C3347b;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3365c;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.common.HttpsClient;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.a.h */
public class C3200h extends C3195f {
    /* renamed from: h */
    public static boolean f17376h = false;
    /* renamed from: i */
    private static C3200h f17377i = null;
    /* renamed from: A */
    private double f17378A;
    /* renamed from: B */
    private boolean f17379B;
    /* renamed from: C */
    private long f17380C;
    /* renamed from: D */
    private long f17381D;
    /* renamed from: E */
    private C3198a f17382E;
    /* renamed from: F */
    private boolean f17383F;
    /* renamed from: G */
    private boolean f17384G;
    /* renamed from: H */
    private boolean f17385H;
    /* renamed from: I */
    private boolean f17386I;
    /* renamed from: J */
    private boolean f17387J;
    /* renamed from: K */
    private C3199b f17388K;
    /* renamed from: L */
    private boolean f17389L;
    /* renamed from: M */
    private int f17390M;
    /* renamed from: N */
    private long f17391N;
    /* renamed from: O */
    private boolean f17392O;
    /* renamed from: e */
    final int f17393e;
    /* renamed from: f */
    public C3194b f17394f;
    /* renamed from: g */
    public final Handler f17395g;
    /* renamed from: j */
    private boolean f17396j;
    /* renamed from: k */
    private String f17397k;
    /* renamed from: l */
    private BDLocation f17398l;
    /* renamed from: m */
    private BDLocation f17399m;
    /* renamed from: n */
    private C3372e f17400n;
    /* renamed from: o */
    private C3362a f17401o;
    /* renamed from: p */
    private C3372e f17402p;
    /* renamed from: q */
    private C3362a f17403q;
    /* renamed from: r */
    private boolean f17404r;
    /* renamed from: s */
    private volatile boolean f17405s;
    /* renamed from: t */
    private boolean f17406t;
    /* renamed from: u */
    private long f17407u;
    /* renamed from: v */
    private long f17408v;
    /* renamed from: w */
    private Address f17409w;
    /* renamed from: x */
    private String f17410x;
    /* renamed from: y */
    private List<Poi> f17411y;
    /* renamed from: z */
    private double f17412z;

    /* renamed from: com.baidu.location.a.h$a */
    private class C3198a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3200h f17374a;

        private C3198a(C3200h c3200h) {
            this.f17374a = c3200h;
        }

        public void run() {
            if (this.f17374a.f17383F) {
                this.f17374a.f17383F = false;
                if (!this.f17374a.f17384G && !C3371d.m14289a().m14325m()) {
                    this.f17374a.m13380a(false, false);
                }
            }
        }
    }

    /* renamed from: com.baidu.location.a.h$b */
    private class C3199b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3200h f17375a;

        private C3199b(C3200h c3200h) {
            this.f17375a = c3200h;
        }

        public void run() {
            if (this.f17375a.f17389L) {
                this.f17375a.f17389L = false;
            }
            if (this.f17375a.f17406t) {
                this.f17375a.f17406t = false;
                if (this.f17375a.m13358a(this.f17375a.f17400n)) {
                    C3376f.m14355a().m14367b();
                } else {
                    C3376f.m14355a().m14365a(1000);
                }
                this.f17375a.m13372h(null);
            }
        }
    }

    private C3200h() {
        this.f17393e = 1000;
        this.f17396j = true;
        this.f17394f = null;
        this.f17397k = null;
        this.f17398l = null;
        this.f17399m = null;
        this.f17400n = null;
        this.f17401o = null;
        this.f17402p = null;
        this.f17403q = null;
        this.f17404r = true;
        this.f17405s = false;
        this.f17406t = false;
        this.f17407u = 0;
        this.f17408v = 0;
        this.f17409w = null;
        this.f17410x = null;
        this.f17411y = null;
        this.f17379B = false;
        this.f17380C = 0;
        this.f17381D = 0;
        this.f17382E = null;
        this.f17383F = false;
        this.f17384G = false;
        this.f17385H = true;
        this.f17395g = new C3193a(this);
        this.f17386I = false;
        this.f17387J = false;
        this.f17388K = null;
        this.f17389L = false;
        this.f17390M = 0;
        this.f17391N = 0;
        this.f17392O = true;
        this.f17394f = new C3194b(this);
    }

    /* renamed from: a */
    private boolean m13357a(C3362a c3362a) {
        this.b = C3364b.m14262a().m14280f();
        return this.b == c3362a ? false : this.b == null || c3362a == null || !c3362a.m14247a(this.b);
    }

    /* renamed from: a */
    private boolean m13358a(C3372e c3372e) {
        this.a = C3376f.m14355a().m14381q();
        return c3372e == this.a ? false : this.a == null || c3372e == null || !c3372e.m14340c(this.a);
    }

    /* renamed from: b */
    private boolean m13361b(C3362a c3362a) {
        return c3362a == null ? false : this.f17403q == null || !c3362a.m14247a(this.f17403q);
    }

    /* renamed from: c */
    public static synchronized C3200h m13362c() {
        C3200h c3200h;
        synchronized (C3200h.class) {
            if (f17377i == null) {
                f17377i = new C3200h();
            }
            c3200h = f17377i;
        }
        return c3200h;
    }

    /* renamed from: c */
    private void m13364c(Message message) {
        C3299f.m13848a().m13868a("request location!");
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            C3316k.m13946a().m13951b();
        }
        if (!C3439d.m14680a().m14745g()) {
            int d = C3181a.m13265a().m13280d(message);
            C3202i.m13395a().m13405d();
            switch (d) {
                case 1:
                    m13366d(message);
                    return;
                case 2:
                    m13371g(message);
                    return;
                case 3:
                    if (C3371d.m14289a().m14325m()) {
                        m13368e(message);
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[]{Integer.valueOf(d)}));
            }
        }
    }

    /* renamed from: d */
    private void m13366d(Message message) {
        if (C3371d.m14289a().m14325m()) {
            C3299f.m13848a().m13868a("gps is valid");
            m13371g(message);
            C3202i.m13395a().m13401b();
            C3314j.m13917b().m13934a(C3310b.GPS);
            return;
        }
        m13371g(message);
        C3202i.m13395a().m13401b();
    }

    /* renamed from: e */
    private void m13368e(Message message) {
        BDLocation bDLocation = new BDLocation(C3371d.m14289a().m14322j());
        if (C3391g.f18380g.equals("all") || C3391g.f18381h || C3391g.f18382i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f17378A, this.f17412z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.f17409w != null) {
                    bDLocation.setAddr(this.f17409w);
                }
                if (this.f17410x != null) {
                    bDLocation.setLocationDescribe(this.f17410x);
                }
                if (this.f17411y != null) {
                    bDLocation.setPoiList(this.f17411y);
                }
            } else {
                this.f17379B = true;
                m13371g(null);
            }
        }
        this.f17398l = bDLocation;
        this.f17399m = null;
        C3181a.m13265a().m13272a(bDLocation);
    }

    /* renamed from: f */
    private void m13370f(Message message) {
        if (C3376f.m14355a().m14372g()) {
            this.f17406t = true;
            if (this.f17388K == null) {
                this.f17388K = new C3199b();
            }
            if (this.f17389L && this.f17388K != null) {
                this.f17395g.removeCallbacks(this.f17388K);
            }
            this.f17395g.postDelayed(this.f17388K, 3500);
            this.f17389L = true;
            return;
        }
        m13372h(message);
    }

    /* renamed from: g */
    private void m13371g(Message message) {
        this.f17390M = 0;
        if (this.f17404r) {
            this.f17390M = 1;
            this.f17381D = SystemClock.uptimeMillis();
            if (C3376f.m14355a().m14375k()) {
                m13370f(message);
                return;
            } else {
                m13372h(message);
                return;
            }
        }
        if (C3371d.m14289a().m14316d()) {
            this.f17390M = 2;
        }
        if (this.f17390M != 2) {
            m13370f(message);
        } else if (C3376f.m14355a().m14366a(60000)) {
            m13370f(message);
        } else {
            m13372h(message);
        }
        this.f17381D = SystemClock.uptimeMillis();
    }

    /* renamed from: h */
    private void m13372h(Message message) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.f17407u;
        if (this.f17405s && currentTimeMillis <= 12000) {
            return;
        }
        if (System.currentTimeMillis() - this.f17407u <= 0 || System.currentTimeMillis() - this.f17407u >= 1000) {
            if (this.f17381D > 0) {
                C3301g.m13879a().m13886b().m13963a(this.f17381D);
            } else {
                C3301g.m13879a().m13886b().m13963a(SystemClock.uptimeMillis());
            }
            this.f17405s = true;
            this.f17396j = m13357a(this.f17401o);
            boolean a = m13358a(this.f17400n);
            if (!this.f17404r) {
                int g = C3314j.m13917b().m13942g();
                if (C3314j.m13917b().m13939d() && System.currentTimeMillis() - this.f17407u >= ((long) (g * 1000))) {
                    if (C3314j.m13917b().m13936a(C3376f.m14355a().m14380p().f18275a)) {
                        this.f17379B = true;
                    } else {
                        this.f17407u = System.currentTimeMillis();
                    }
                }
            }
            if (!(a || this.f17396j || this.f17398l == null || this.f17379B)) {
                if (this.f17399m != null && System.currentTimeMillis() - this.f17408v > HttpsClient.CONN_MGR_TIMEOUT) {
                    this.f17398l = this.f17399m;
                    this.f17399m = null;
                }
                if (C3202i.m13395a().m13408g()) {
                    this.f17398l.setDirection(C3202i.m13395a().m13410i());
                }
                if (this.f17398l.getLocType() == 62) {
                    currentTimeMillis = System.currentTimeMillis() - this.f17391N;
                    if (currentTimeMillis > 0) {
                        j = currentTimeMillis;
                    }
                }
                if (this.f17398l.getLocType() == 61 || this.f17398l.getLocType() == 161 || (this.f17398l.getLocType() == 62 && r0 < 15000)) {
                    C3181a.m13265a().m13272a(this.f17398l);
                    m13375o();
                    return;
                }
            }
            this.f17407u = System.currentTimeMillis();
            String a2 = m13346a(null);
            this.f17387J = false;
            if (a2 == null) {
                this.f17387J = true;
                this.f17391N = System.currentTimeMillis();
                String[] n = m13374n();
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f17380C > 60000) {
                    this.f17380C = currentTimeMillis;
                    C3301g.m13879a().m13885a("Criteria" + n[0]);
                }
                String m = C3376f.m14355a().m14377m();
                a2 = m != null ? m + m13349b() + n[0] : "" + m13349b() + n[0];
                if (!(this.b == null || this.b.m14255i() == null)) {
                    a2 = this.b.m14255i() + a2;
                }
                m = C3381b.m14398a().m14399a(true);
                if (m != null) {
                    a2 = a2 + m;
                }
            }
            if (this.f17390M > 0) {
                a2 = a2 + "&mft=" + this.f17390M;
            }
            if (this.f17397k != null) {
                a2 = a2 + this.f17397k;
                this.f17397k = null;
            }
            C3301g.m13879a().m13886b().m13967b(SystemClock.uptimeMillis());
            C3299f.m13848a().m13868a("netreqstr = " + a2);
            this.f17394f.m13344a(a2);
            this.f17401o = this.b;
            this.f17400n = this.a;
            if (!(this.f17404r || C3371d.m14289a().m14325m())) {
                m13373m();
            }
            if (C3349d.m14171a().m14191i()) {
                if (this.f17382E == null) {
                    this.f17382E = new C3198a();
                }
                this.f17395g.postDelayed(this.f17382E, C3349d.m14171a().m14180a(C3365c.m14283a(C3364b.m14262a().m14279e())));
                this.f17383F = true;
            }
            if (this.f17404r) {
                this.f17404r = false;
                C3216b.m13475a().m13482b();
            }
            if (this.f17390M > 0) {
                if (this.f17390M == 2) {
                    C3376f.m14355a().m14372g();
                }
                this.f17390M = 0;
                return;
            }
            return;
        }
        if (this.f17398l != null) {
            C3181a.m13265a().m13272a(this.f17398l);
        }
        m13375o();
    }

    /* renamed from: m */
    private boolean m13373m() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        C3362a f = C3364b.m14262a().m14280f();
        C3372e p = C3376f.m14355a().m14380p();
        long f2 = (p == null || p.m14330a() <= 0) ? 0 : p.m14346f();
        boolean z = f != null && f.m14251e() && (p == null || p.m14330a() == 0);
        if (C3349d.m14171a().m14186d() && C3349d.m14171a().m14189g() && f2 < 60 && (z || (0.0d < random && random < C3349d.m14171a().m14198p()))) {
            BDLocation a = C3349d.m14171a().m14182a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), null, C3347b.IS_MIX_MODE, C3346a.NEED_TO_LOG);
            z = (C3391g.f18380g.equals("all") && a.getAddrStr() == null) ? false : true;
            if (C3391g.f18381h && a.getLocationDescribe() == null) {
                z = false;
            }
            if (C3391g.f18382i && a.getPoiList() == null) {
                z = false;
            }
            if (z) {
                bDLocation = a;
            }
        }
        if (bDLocation == null || bDLocation.getLocType() != 66 || !this.f17405s) {
            return false;
        }
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        bDLocation2.setLocType(161);
        if (!this.f17405s) {
            return false;
        }
        C3320m c3320m = new C3320m();
        c3320m.m13963a(this.f17381D);
        c3320m.m13967b(uptimeMillis);
        c3320m.m13970c(uptimeMillis);
        c3320m.m13972d(SystemClock.uptimeMillis());
        c3320m.m13964a("ofs");
        if (this.f17401o != null) {
            c3320m.m13968b(this.f17401o.m14255i());
            c3320m.m13968b("&offtag=1");
        }
        C3301g.m13879a().m13884a(c3320m);
        this.f17384G = true;
        C3181a.m13265a().m13272a(bDLocation2);
        this.f17398l = bDLocation2;
        return true;
    }

    /* renamed from: n */
    private String[] m13374n() {
        int c;
        int i;
        String[] strArr = new String[]{"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int b = C3391g.m14439b(C3377f.getServiceContext());
        if (b == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(b);
        String d = C3391g.m14447d(C3377f.getServiceContext());
        if (d.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(d);
        if (VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            c = C3391g.m14444c(C3377f.getServiceContext());
            if (c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                i = 1;
            } else {
                i = 0;
            }
            stringBuffer.append(c);
        } else {
            i = 0;
        }
        if (VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            c = C3391g.m14444c(C3377f.getServiceContext());
            if (c >= 0) {
                stringBuffer.append(c);
            }
        }
        String g = C3364b.m14262a().m14281g();
        String h = C3376f.m14355a().m14373h();
        stringBuffer.append(h);
        stringBuffer.append(g);
        stringBuffer.append(C3391g.m14449e(C3377f.getServiceContext()));
        if (b == 1) {
            C3182b.m13285a().m13286a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("0|0|")) {
            C3182b.m13285a().m13286a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (i != 0) {
            C3182b.m13285a().m13286a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g == null || h == null || !g.equals("&sim=1") || h.equals("&wifio=1")) {
            C3182b.m13285a().m13286a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            C3182b.m13285a().m13286a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    /* renamed from: o */
    private void m13375o() {
        this.f17405s = false;
        this.f17384G = false;
        this.f17385H = false;
        this.f17379B = false;
        m13376p();
        if (this.f17392O) {
            this.f17392O = false;
            if (!C3371d.m14289a().m14325m() && C3376f.m14355a().m14377m() == null) {
                C3376f.m14355a().m14372g();
            }
        }
    }

    /* renamed from: p */
    private void m13376p() {
        if (this.f17398l != null) {
            C3211m.m13441a().m13461e();
            C3232a.m13554b().m13561b(false);
        }
    }

    /* renamed from: a */
    public Address m13377a(BDLocation bDLocation) {
        if (C3391g.f18380g.equals("all") || C3391g.f18381h || C3391g.f18382i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f17378A, this.f17412z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.f17410x = null;
                this.f17411y = null;
                this.f17379B = true;
                m13371g(null);
            } else if (this.f17409w != null) {
                return this.f17409w;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo2497a() {
        boolean z = true;
        if (this.f17382E != null && this.f17383F) {
            this.f17383F = false;
            this.f17395g.removeCallbacks(this.f17382E);
        }
        if (C3371d.m14289a().m14325m()) {
            BDLocation bDLocation = new BDLocation(C3371d.m14289a().m14322j());
            if (C3391g.f18380g.equals("all") || C3391g.f18381h || C3391g.f18382i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f17378A, this.f17412z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.f17409w != null) {
                        bDLocation.setAddr(this.f17409w);
                    }
                    if (this.f17410x != null) {
                        bDLocation.setLocationDescribe(this.f17410x);
                    }
                    if (this.f17411y != null) {
                        bDLocation.setPoiList(this.f17411y);
                    }
                }
            }
            C3181a.m13265a().m13272a(bDLocation);
            m13375o();
        } else if (this.f17384G) {
            m13375o();
        } else {
            BDLocation a;
            C3301g.m13879a().m13886b().m13970c(SystemClock.uptimeMillis());
            if (C3349d.m14171a().m14186d() && C3349d.m14171a().m14188f()) {
                a = C3349d.m14171a().m14182a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), null, C3347b.IS_NOT_MIX_MODE, C3346a.NEED_TO_LOG);
                if (a != null && a.getLocType() == 66) {
                    C3181a.m13265a().m13272a(a);
                }
            } else {
                a = null;
            }
            if (a == null || a.getLocType() == 67) {
                if (this.f17396j || this.f17398l == null) {
                    BDLocation a2;
                    if (C3335a.m14038a().f18053a) {
                        a2 = C3335a.m14038a().m14056a(false);
                    } else if (a == null) {
                        a2 = new BDLocation();
                        a2.setLocType(67);
                    } else {
                        a2 = a;
                    }
                    if (a2 == null || a2.getLocType() == 67) {
                        a = C3243b.m13581a().m13589a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), true, null);
                        if (a != null && a.getLocType() == 66) {
                            a2 = a;
                        }
                    }
                    if (a2 != null) {
                        C3181a.m13265a().m13272a(a2);
                        if (a2.getLocType() == 67 && !this.f17387J) {
                            C3182b.m13285a().m13286a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z2 = (C3391g.f18380g.equals("all") && a2.getAddrStr() == null) ? false : true;
                        if (C3391g.f18381h && a2.getLocationDescribe() == null) {
                            z2 = false;
                        }
                        if (C3391g.f18382i && a2.getPoiList() == null) {
                            z2 = false;
                        }
                        if (!z2) {
                            a2.setLocType(67);
                        }
                        a = a2;
                    } else {
                        a = a2;
                    }
                } else {
                    C3181a.m13265a().m13272a(this.f17398l);
                }
            }
            C3301g.m13879a().m13886b().m13972d(SystemClock.uptimeMillis());
            if (C3391g.f18380g.equals("all") && a != null && a.getAddrStr() == null) {
                z = false;
            }
            if (!(a == null || r6)) {
                a.setLocType(67);
            }
            if (a == null || a.getLocType() != 66) {
                this.f17398l = null;
                C3301g.m13879a().m13886b().m13964a("off");
                if (this.f17401o != null) {
                    C3301g.m13879a().m13886b().m13968b(this.f17401o.m14255i());
                }
                C3301g.m13879a().m13888d();
            } else {
                this.f17398l = a;
                C3301g.m13879a().m13886b().m13964a("ofs");
                if (this.f17401o != null) {
                    C3301g.m13879a().m13886b().m13968b(this.f17401o.m14255i());
                }
                C3301g.m13879a().m13888d();
            }
            this.f17399m = null;
            m13375o();
        }
    }

    /* renamed from: a */
    public void mo2498a(Message message) {
        if (this.f17382E != null && this.f17383F) {
            this.f17383F = false;
            this.f17395g.removeCallbacks(this.f17382E);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.f17387J) {
            bDLocation.setLocType(62);
        }
        m13382b(bDLocation);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m13380a(boolean r10, boolean r11) {
        /*
        r9 = this;
        r7 = 1;
        r3 = 0;
        r8 = 66;
        r6 = 0;
        r0 = com.baidu.location.p193e.C3349d.m14171a();
        r0 = r0.m14186d();
        if (r0 == 0) goto L_0x00b7;
    L_0x000f:
        r0 = com.baidu.location.p193e.C3349d.m14171a();
        r0 = r0.m14190h();
        if (r0 == 0) goto L_0x00b7;
    L_0x0019:
        r0 = com.baidu.location.p193e.C3349d.m14171a();
        r1 = com.baidu.location.p194f.C3364b.m14262a();
        r1 = r1.m14280f();
        r2 = com.baidu.location.p194f.C3376f.m14355a();
        r2 = r2.m14380p();
        r4 = com.baidu.location.p193e.C3349d.C3347b.IS_NOT_MIX_MODE;
        r5 = com.baidu.location.p193e.C3349d.C3346a.NEED_TO_LOG;
        r0 = r0.m14182a(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x003f;
    L_0x0037:
        r1 = r0.getLocType();
        r2 = 67;
        if (r1 != r2) goto L_0x0051;
    L_0x003f:
        if (r10 == 0) goto L_0x0051;
    L_0x0041:
        r1 = com.baidu.location.p193e.C3335a.m14038a();
        r1 = r1.f18053a;
        if (r1 == 0) goto L_0x0051;
    L_0x0049:
        r0 = com.baidu.location.p193e.C3335a.m14038a();
        r0 = r0.m14056a(r6);
    L_0x0051:
        if (r11 == 0) goto L_0x00cc;
    L_0x0053:
        if (r0 == 0) goto L_0x005b;
    L_0x0055:
        r1 = r0.getLocType();
        if (r1 == r8) goto L_0x00cc;
    L_0x005b:
        r1 = com.baidu.location.p190c.C3243b.m13581a();
        r2 = com.baidu.location.p194f.C3364b.m14262a();
        r2 = r2.m14280f();
        r4 = com.baidu.location.p194f.C3376f.m14355a();
        r4 = r4.m14380p();
        r1 = r1.m13589a(r2, r4, r7, r3);
        if (r1 == 0) goto L_0x00cc;
    L_0x0075:
        r2 = r1.getLocType();
        if (r2 != r8) goto L_0x00cc;
    L_0x007b:
        if (r1 == 0) goto L_0x00b6;
    L_0x007d:
        r0 = r1.getLocType();
        if (r0 != r8) goto L_0x00b6;
    L_0x0083:
        r0 = com.baidu.location.p188h.C3391g.f18380g;
        r2 = "all";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x00ca;
    L_0x008e:
        r0 = r1.getAddrStr();
        if (r0 != 0) goto L_0x00ca;
    L_0x0094:
        r0 = r6;
    L_0x0095:
        r2 = com.baidu.location.p188h.C3391g.f18381h;
        if (r2 == 0) goto L_0x00a0;
    L_0x0099:
        r2 = r1.getLocationDescribe();
        if (r2 != 0) goto L_0x00a0;
    L_0x009f:
        r0 = r6;
    L_0x00a0:
        r2 = com.baidu.location.p188h.C3391g.f18382i;
        if (r2 == 0) goto L_0x00ab;
    L_0x00a4:
        r2 = r1.getPoiList();
        if (r2 != 0) goto L_0x00ab;
    L_0x00aa:
        r0 = r6;
    L_0x00ab:
        if (r0 != 0) goto L_0x00af;
    L_0x00ad:
        if (r11 == 0) goto L_0x00b6;
    L_0x00af:
        r0 = com.baidu.location.p187a.C3181a.m13265a();
        r0.m13272a(r1);
    L_0x00b6:
        return;
    L_0x00b7:
        if (r10 == 0) goto L_0x00ce;
    L_0x00b9:
        r0 = com.baidu.location.p193e.C3335a.m14038a();
        r0 = r0.f18053a;
        if (r0 == 0) goto L_0x00ce;
    L_0x00c1:
        r0 = com.baidu.location.p193e.C3335a.m14038a();
        r0 = r0.m14056a(r6);
        goto L_0x0051;
    L_0x00ca:
        r0 = r7;
        goto L_0x0095;
    L_0x00cc:
        r1 = r0;
        goto L_0x007b;
    L_0x00ce:
        r0 = r3;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.h.a(boolean, boolean):void");
    }

    /* renamed from: b */
    public void m13381b(Message message) {
        if (this.f17386I) {
            m13364c(message);
        }
    }

    /* renamed from: b */
    public void m13382b(BDLocation bDLocation) {
        String str = null;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            C3294d.m13799a().m13831a(bDLocation);
        }
        if (bDLocation.hasAddr()) {
            this.f17409w = bDLocation.getAddress();
            this.f17412z = bDLocation.getLongitude();
            this.f17378A = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.f17410x = bDLocation.getLocationDescribe();
            this.f17412z = bDLocation.getLongitude();
            this.f17378A = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.f17411y = bDLocation.getPoiList();
            this.f17412z = bDLocation.getLongitude();
            this.f17378A = bDLocation.getLatitude();
        }
        if (C3371d.m14289a().m14325m()) {
            int i = 1;
        } else {
            boolean z = false;
        }
        float[] fArr;
        if (i != 0) {
            BDLocation bDLocation3 = new BDLocation(C3371d.m14289a().m14322j());
            if (C3391g.f18380g.equals("all") || C3391g.f18381h || C3391g.f18382i) {
                fArr = new float[2];
                Location.distanceBetween(this.f17378A, this.f17412z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.f17409w != null) {
                        bDLocation3.setAddr(this.f17409w);
                    }
                    if (this.f17410x != null) {
                        bDLocation3.setLocationDescribe(this.f17410x);
                    }
                    if (this.f17411y != null) {
                        bDLocation3.setPoiList(this.f17411y);
                    }
                }
            }
            C3181a.m13265a().m13272a(bDLocation3);
            m13375o();
        } else if (this.f17384G) {
            fArr = new float[2];
            if (this.f17398l != null) {
                Location.distanceBetween(this.f17398l.getLatitude(), this.f17398l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            }
            if (fArr[0] > 10.0f) {
                this.f17398l = bDLocation;
                if (!this.f17385H) {
                    this.f17385H = false;
                    C3181a.m13265a().m13272a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.f17398l = bDLocation;
                C3181a.m13265a().m13272a(bDLocation);
            }
            m13375o();
        } else {
            String h;
            C3301g.m13879a().m13886b().m13970c(SystemClock.uptimeMillis());
            if (bDLocation.getLocType() == 167) {
                C3182b.m13285a().m13286a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (VERSION.SDK_INT >= 19) {
                    i = C3391g.m14444c(C3377f.getServiceContext());
                    if (i == 0 || i == 2) {
                        i = 1;
                        if (i == 0) {
                            C3182b.m13285a().m13286a(161, 1, "NetWork location successful, open gps will be better!");
                        } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl")) {
                            h = C3376f.m14355a().m14373h();
                            if (!(h == null || h.equals("&wifio=1"))) {
                                C3182b.m13285a().m13286a(161, 2, "NetWork location successful, open wifi will be better!");
                            }
                        }
                    }
                }
                z = false;
                if (i == 0) {
                    h = C3376f.m14355a().m14373h();
                    C3182b.m13285a().m13286a(161, 2, "NetWork location successful, open wifi will be better!");
                } else {
                    C3182b.m13285a().m13286a(161, 1, "NetWork location successful, open gps will be better!");
                }
            }
            this.f17399m = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.f17398l != null && this.f17398l.getLocType() == 161 && "wf".equals(this.f17398l.getNetworkLocationType()) && System.currentTimeMillis() - this.f17408v < HttpsClient.CONN_MGR_TIMEOUT) {
                this.f17399m = bDLocation;
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                C3181a.m13265a().m13272a(this.f17398l);
            } else {
                C3181a.m13265a().m13272a(bDLocation);
                this.f17408v = System.currentTimeMillis();
                C3301g.m13879a().m13886b().m13972d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    C3301g.m13879a().m13886b().m13964a("ons");
                    if (this.f17401o != null) {
                        C3301g.m13879a().m13886b().m13968b(this.f17401o.m14255i());
                    }
                    if (Math.random() > 0.5d) {
                        C3301g.m13879a().m13888d();
                    }
                } else {
                    C3301g.m13879a().m13886b().m13964a("onf");
                    if (this.f17401o != null) {
                        C3301g.m13879a().m13886b().m13968b(this.f17401o.m14255i());
                    }
                    C3301g.m13879a().m13888d();
                }
            }
            if (!C3391g.m14438a(bDLocation)) {
                this.f17398l = null;
            } else if (i == 0) {
                this.f17398l = bDLocation;
            }
            i = C3391g.m14428a(c, "ssid\":\"", "\"");
            if (i == Integer.MIN_VALUE || this.f17400n == null) {
                this.f17397k = null;
            } else {
                this.f17397k = this.f17400n.m14344e(i);
                if (!TextUtils.isEmpty(this.f17397k)) {
                    h = C3381b.m14398a().m14405d();
                    C3301g.m13882b(Jni.encode(String.format(Locale.CHINA, "&uptype=ssid%s%s&time=%d", new Object[]{h, this.f17397k, Long.valueOf(System.currentTimeMillis() / 1000)})));
                }
            }
            if (C3349d.m14171a().m14186d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && m13361b(this.f17401o)) {
                C3349d.m14171a().m14182a(this.f17401o, null, bDLocation2, C3347b.IS_NOT_MIX_MODE, C3346a.NO_NEED_TO_LOG);
                this.f17403q = this.f17401o;
            }
            if (C3349d.m14171a().m14186d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                C3349d.m14171a().m14182a(null, this.f17400n, bDLocation2, C3347b.IS_NOT_MIX_MODE, C3346a.NO_NEED_TO_LOG);
                this.f17402p = this.f17400n;
            }
            if (this.f17401o != null) {
                C3335a.m14038a().m14057a(c, this.f17401o, this.f17400n, bDLocation2);
            }
            if (C3376f.m14363j()) {
                C3349d.m14171a().m14192j();
                C3349d.m14171a().m14196n();
                WifiInfo l = C3376f.m14355a().m14376l();
                if (!(l == null || l.getBSSID() == null)) {
                    str = l.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                }
                if (str != null) {
                    C3296e.m13839a().m13842a(str);
                }
                if (!TextUtils.isEmpty(bDLocation.getCityCode())) {
                    C3274f.m13695a().m13702c(bDLocation.getCityCode());
                    C3398a.m14465b().m14474a(bDLocation.getCityCode());
                    C3243b.m13581a().m13592a(bDLocation.getCityCode());
                }
            }
            m13375o();
        }
    }

    /* renamed from: c */
    public void m13383c(BDLocation bDLocation) {
        m13392k();
        this.f17398l = bDLocation;
        this.f17398l.setIndoorLocMode(false);
    }

    /* renamed from: d */
    public void m13384d() {
        this.f17404r = true;
        this.f17405s = false;
        this.f17386I = true;
    }

    /* renamed from: d */
    public void m13385d(BDLocation bDLocation) {
        this.f17398l = new BDLocation(bDLocation);
    }

    /* renamed from: e */
    public void m13386e() {
        this.f17405s = false;
        this.f17406t = false;
        this.f17384G = false;
        this.f17385H = true;
        m13392k();
        this.f17386I = false;
    }

    /* renamed from: f */
    public String m13387f() {
        return this.f17410x;
    }

    /* renamed from: g */
    public List<Poi> m13388g() {
        return this.f17411y;
    }

    /* renamed from: h */
    public void m13389h() {
        this.f17379B = true;
        m13371g(null);
    }

    /* renamed from: i */
    public boolean m13390i() {
        return this.f17396j;
    }

    /* renamed from: j */
    public void m13391j() {
        if (this.f17406t) {
            if (m13358a(this.f17400n)) {
                C3376f.m14355a().m14367b();
            } else {
                C3376f.m14355a().m14365a(1000);
            }
            m13372h(null);
            this.f17406t = false;
            return;
        }
        C3216b.m13475a().m13484d();
    }

    /* renamed from: k */
    public void m13392k() {
        this.f17398l = null;
    }

    /* renamed from: l */
    public BDLocation m13393l() {
        return this.f17398l;
    }
}
