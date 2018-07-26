package com.baidu.location.indoor;

import android.hardware.SensorManager;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.indoor.C3422c.C3421a;
import com.baidu.location.indoor.C3447h.C3426a;
import com.baidu.location.indoor.C3450i.C3424a;
import com.baidu.location.indoor.mapversion.p198b.C3456a;
import com.baidu.location.indoor.mapversion.p198b.C3456a.C3428c;
import com.baidu.location.indoor.mapversion.p199a.C3451a;
import com.baidu.location.indoor.p196a.C3398a;
import com.baidu.location.indoor.p196a.C3400b;
import com.baidu.location.indoor.p197b.C3414b;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3202i;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.baidu.location.indoor.d */
public class C3439d {
    /* renamed from: j */
    private static C3439d f18579j;
    /* renamed from: A */
    private C3443f f18580A;
    /* renamed from: B */
    private String f18581B;
    /* renamed from: C */
    private String f18582C;
    /* renamed from: D */
    private String f18583D;
    /* renamed from: E */
    private int f18584E;
    /* renamed from: F */
    private boolean f18585F;
    /* renamed from: G */
    private int f18586G;
    /* renamed from: H */
    private C3418b<String> f18587H;
    /* renamed from: I */
    private int f18588I;
    /* renamed from: J */
    private C3418b<String> f18589J;
    /* renamed from: K */
    private double f18590K;
    /* renamed from: L */
    private double f18591L;
    /* renamed from: M */
    private double f18592M;
    /* renamed from: N */
    private double f18593N;
    /* renamed from: O */
    private boolean f18594O;
    /* renamed from: P */
    private boolean f18595P;
    /* renamed from: Q */
    private List<C3436g> f18596Q;
    /* renamed from: R */
    private int f18597R;
    /* renamed from: S */
    private int f18598S;
    /* renamed from: T */
    private int f18599T;
    /* renamed from: U */
    private C3406a f18600U;
    /* renamed from: V */
    private String f18601V;
    /* renamed from: W */
    private C3422c f18602W;
    /* renamed from: X */
    private C3450i f18603X;
    /* renamed from: Y */
    private C3424a f18604Y;
    /* renamed from: Z */
    private boolean f18605Z;
    /* renamed from: a */
    boolean f18606a;
    private int aa;
    private BDLocation ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private List<Float> af;
    /* renamed from: b */
    boolean f18607b;
    /* renamed from: c */
    public C3434e f18608c;
    /* renamed from: d */
    public SimpleDateFormat f18609d;
    /* renamed from: e */
    private final int f18610e;
    /* renamed from: f */
    private boolean f18611f;
    /* renamed from: g */
    private BDLocationListener f18612g;
    /* renamed from: h */
    private BDLocationListener f18613h;
    /* renamed from: i */
    private int f18614i;
    /* renamed from: k */
    private long f18615k;
    /* renamed from: l */
    private volatile boolean f18616l;
    /* renamed from: m */
    private C3447h f18617m;
    /* renamed from: n */
    private C3435f f18618n;
    /* renamed from: o */
    private C3438h f18619o;
    /* renamed from: p */
    private long f18620p;
    /* renamed from: q */
    private boolean f18621q;
    /* renamed from: r */
    private boolean f18622r;
    /* renamed from: s */
    private long f18623s;
    /* renamed from: t */
    private int f18624t;
    /* renamed from: u */
    private int f18625u;
    /* renamed from: v */
    private C3426a f18626v;
    /* renamed from: w */
    private int f18627w;
    /* renamed from: x */
    private int f18628x;
    /* renamed from: y */
    private String f18629y;
    /* renamed from: z */
    private String f18630z;

    /* renamed from: com.baidu.location.indoor.d$1 */
    class C34231 extends BDLocationListener {
        /* renamed from: a */
        final /* synthetic */ C3439d f18527a;

        C34231(C3439d c3439d) {
            this.f18527a = c3439d;
        }

        public void onReceiveLocation(BDLocation bDLocation) {
            if (!(bDLocation == null || this.f18527a.ab == null)) {
                if (bDLocation.getAddrStr() == null && this.f18527a.ab.getAddrStr() != null) {
                    bDLocation.setAddr(this.f18527a.ab.getAddress());
                    bDLocation.setAddrStr(this.f18527a.ab.getAddrStr());
                }
                if (bDLocation.getPoiList() == null && this.f18527a.ab.getPoiList() != null) {
                    bDLocation.setPoiList(this.f18527a.ab.getPoiList());
                }
                if (bDLocation.getLocationDescribe() == null && this.f18527a.ab.getLocationDescribe() != null) {
                    bDLocation.setLocationDescribe(this.f18527a.ab.getLocationDescribe());
                }
            }
            if (this.f18527a.f18617m.m14792c() == 1) {
                if (bDLocation != null && !C3371d.m14289a().m14325m()) {
                    bDLocation.setUserIndoorState(1);
                    bDLocation.setIndoorNetworkState(this.f18527a.aa);
                    C3181a.m13265a().m13272a(bDLocation);
                } else if (bDLocation != null && C3371d.m14289a().m14325m() && this.f18527a.ac) {
                    bDLocation.setUserIndoorState(1);
                    bDLocation.setIndoorNetworkState(this.f18527a.aa);
                    C3181a.m13265a().m13272a(bDLocation);
                }
            }
            if (bDLocation != null && bDLocation.getNetworkLocationType().equals("ml")) {
                Message obtainMessage = this.f18527a.f18608c.obtainMessage(801);
                obtainMessage.obj = bDLocation;
                obtainMessage.sendToTarget();
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.d$2 */
    class C34252 implements C3424a {
        /* renamed from: a */
        final /* synthetic */ C3439d f18528a;

        C34252(C3439d c3439d) {
            this.f18528a = c3439d;
        }

        /* renamed from: a */
        public void mo2518a(BDLocation bDLocation) {
            this.f18528a.m14687a(bDLocation, 29);
        }
    }

    /* renamed from: com.baidu.location.indoor.d$3 */
    class C34273 implements C3426a {
        /* renamed from: a */
        final /* synthetic */ C3439d f18529a;

        C34273(C3439d c3439d) {
            this.f18529a = c3439d;
        }

        /* renamed from: a */
        public synchronized void mo2519a(double d, double d2) {
            this.f18529a.f18606a = true;
            this.f18529a.f18607b = true;
            this.f18529a.f18592M = 0.4d;
            if (this.f18529a.f18590K > 0.1d || this.f18529a.f18591L > 0.1d) {
                Object obj = null;
                double[] dArr = null;
                if (this.f18529a.ad && this.f18529a.ae) {
                    double[] a = C3451a.m14819a(this.f18529a.f18629y, d, d2);
                    Object obj2 = a != null ? 1 : null;
                    double[] dArr2;
                    if (a != null) {
                        dArr2 = a;
                        obj = obj2;
                        dArr = dArr2;
                    } else {
                        dArr2 = a;
                        obj = obj2;
                        dArr = dArr2;
                    }
                }
                double[] a2 = (this.f18529a.ad && this.f18529a.ae && obj != null) ? dArr : this.f18529a.m14693a(this.f18529a.f18591L, this.f18529a.f18590K, d, d2);
                this.f18529a.af.add(Float.valueOf((float) d2));
                this.f18529a.f18593N = d2;
                try {
                    double f = this.f18529a.f18591L;
                    double e = this.f18529a.f18590K;
                    if (this.f18529a.ab != null) {
                        f = this.f18529a.ab.getLatitude();
                        e = this.f18529a.ab.getLongitude();
                    }
                    if (a2[0] >= 1.0d && a2[1] >= 1.0d && C3444g.m14759a(a2[0], a2[1], r8, r10) <= 10000.0d) {
                        BDLocation bDLocation = new BDLocation();
                        bDLocation.setLocType(161);
                        bDLocation.setLatitude(a2[0]);
                        bDLocation.setLongitude(a2[1]);
                        bDLocation.setRadius(15.0f);
                        bDLocation.setDirection((float) d2);
                        bDLocation.setTime(this.f18529a.f18609d.format(new Date()));
                        this.f18529a.f18591L = a2[0];
                        this.f18529a.f18590K = a2[1];
                        if (this.f18529a.f18629y != null) {
                            bDLocation.setFloor(this.f18529a.f18629y);
                        }
                        if (this.f18529a.f18630z != null) {
                            bDLocation.setBuildingID(this.f18529a.f18630z);
                        }
                        if (this.f18529a.f18581B != null) {
                            bDLocation.setBuildingName(this.f18529a.f18581B);
                        }
                        bDLocation.setParkAvailable(this.f18529a.f18584E);
                        if (this.f18529a.f18583D != null) {
                            bDLocation.setNetworkLocationType(this.f18529a.f18583D);
                        } else {
                            bDLocation.setNetworkLocationType("wf");
                        }
                        if (this.f18529a.f18622r) {
                            bDLocation.setIndoorLocMode(true);
                            this.f18529a.f18627w = this.f18529a.f18627w + 1;
                            if (this.f18529a.f18596Q.size() > 50) {
                                this.f18529a.f18596Q.clear();
                            }
                            this.f18529a.f18596Q.add(new C3436g(this.f18529a, this.f18529a.f18617m.m14793d(), d, d2));
                            if (this.f18529a.f18627w < 60 && this.f18529a.f18617m.m14793d() % 3 == 0) {
                                bDLocation.setNetworkLocationType("dr");
                                this.f18529a.m14687a(bDLocation, 21);
                                BDLocation bDLocation2 = new BDLocation(bDLocation);
                                if (C3414b.m14575a().m14588a(bDLocation2)) {
                                    this.f18529a.m14687a(bDLocation2, 21);
                                } else {
                                    if (null != null) {
                                        bDLocation2.setNetworkLocationType(null);
                                    } else {
                                        bDLocation2.setNetworkLocationType("dr2");
                                    }
                                    if (this.f18529a.f18603X == null || !this.f18529a.f18603X.m14815c()) {
                                        this.f18529a.m14687a(bDLocation2, 21);
                                    } else if (((long) this.f18529a.f18599T) > 2) {
                                        this.f18529a.f18603X.m14812a(bDLocation2);
                                    } else {
                                        this.f18529a.m14687a(bDLocation2, 29);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.d$a */
    class C3430a {
        /* renamed from: a */
        final /* synthetic */ C3439d f18533a;
        /* renamed from: b */
        private HashMap<String, Integer> f18534b = new HashMap();
        /* renamed from: c */
        private double f18535c = 0.0d;

        public C3430a(C3439d c3439d, C3372e c3372e) {
            this.f18533a = c3439d;
            if (c3372e.f18275a != null) {
                for (ScanResult scanResult : c3372e.f18275a) {
                    int abs = Math.abs(scanResult.level);
                    this.f18534b.put(scanResult.BSSID, Integer.valueOf(abs));
                    this.f18535c = ((double) ((100 - abs) * (100 - abs))) + this.f18535c;
                }
                this.f18535c = Math.sqrt(this.f18535c + 1.0d);
            }
        }

        /* renamed from: a */
        double m14616a(C3430a c3430a) {
            double d = 0.0d;
            for (String str : this.f18534b.keySet()) {
                int intValue = ((Integer) this.f18534b.get(str)).intValue();
                Integer num = (Integer) c3430a.m14617a().get(str);
                if (num != null) {
                    d = ((double) ((100 - num.intValue()) * (100 - intValue))) + d;
                }
            }
            return d / (this.f18535c * c3430a.m14618b());
        }

        /* renamed from: a */
        public HashMap<String, Integer> m14617a() {
            return this.f18534b;
        }

        /* renamed from: b */
        public double m14618b() {
            return this.f18535c;
        }
    }

    /* renamed from: com.baidu.location.indoor.d$b */
    class C3431b {
        /* renamed from: a */
        double f18536a;
        /* renamed from: b */
        double f18537b;
        /* renamed from: c */
        long f18538c;
        /* renamed from: d */
        int f18539d;
        /* renamed from: e */
        List<Float> f18540e;
        /* renamed from: f */
        boolean f18541f;
        /* renamed from: g */
        String f18542g;
        /* renamed from: h */
        String f18543h;
        /* renamed from: i */
        String f18544i;
        /* renamed from: j */
        boolean f18545j = false;
        /* renamed from: k */
        final /* synthetic */ C3439d f18546k;

        public C3431b(C3439d c3439d, double d, double d2, long j, int i, List<Float> list, String str, String str2, String str3) {
            this.f18546k = c3439d;
            this.f18536a = d;
            this.f18537b = d2;
            this.f18538c = j;
            this.f18539d = i;
            this.f18541f = false;
            this.f18540e = new ArrayList(list);
            this.f18542g = str;
            this.f18543h = str2;
            this.f18544i = str3;
        }

        /* renamed from: a */
        public double m14619a() {
            return this.f18536a;
        }

        /* renamed from: a */
        public int m14620a(C3431b c3431b) {
            return Math.abs(this.f18539d - c3431b.m14626c());
        }

        /* renamed from: a */
        public void m14621a(double d) {
            this.f18536a = d;
        }

        /* renamed from: a */
        public void m14622a(boolean z) {
            this.f18541f = z;
        }

        /* renamed from: b */
        public double m14623b() {
            return this.f18537b;
        }

        /* renamed from: b */
        public float m14624b(C3431b c3431b) {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f18537b, this.f18536a, c3431b.f18537b, c3431b.f18536a, fArr);
            return fArr[0];
        }

        /* renamed from: b */
        public void m14625b(double d) {
            this.f18537b = d;
        }

        /* renamed from: c */
        public int m14626c() {
            return this.f18539d;
        }

        /* renamed from: c */
        public boolean m14627c(C3431b c3431b) {
            int a = m14620a(c3431b);
            return a != 0 && ((double) (m14624b(c3431b) / ((float) a))) <= 1.0d + (0.5d * Math.pow(1.2d, (double) (1 - a)));
        }

        /* renamed from: d */
        public boolean m14628d() {
            return this.f18541f;
        }

        /* renamed from: e */
        public Double m14629e() {
            return this.f18542g == null ? null : Double.valueOf(Double.parseDouble(this.f18542g));
        }

        /* renamed from: f */
        public Double m14630f() {
            return this.f18543h == null ? null : Double.valueOf(Double.parseDouble(this.f18543h));
        }

        /* renamed from: g */
        public Double m14631g() {
            return this.f18544i == null ? null : Double.valueOf(Double.parseDouble(this.f18544i));
        }
    }

    /* renamed from: com.baidu.location.indoor.d$c */
    class C3432c {
        /* renamed from: a */
        final /* synthetic */ C3439d f18547a;
        /* renamed from: b */
        private C3431b[] f18548b;
        /* renamed from: c */
        private int f18549c;
        /* renamed from: d */
        private int f18550d;

        public C3432c(C3439d c3439d) {
            this(c3439d, 5);
        }

        public C3432c(C3439d c3439d, int i) {
            this.f18547a = c3439d;
            this.f18548b = new C3431b[(i + 1)];
            this.f18549c = 0;
            this.f18550d = 0;
        }

        /* renamed from: a */
        public C3431b m14632a() {
            return this.f18548b[((this.f18550d - 1) + this.f18548b.length) % this.f18548b.length];
        }

        /* renamed from: a */
        public C3431b m14633a(int i) {
            return this.f18548b[(((this.f18550d - 1) - i) + this.f18548b.length) % this.f18548b.length];
        }

        /* renamed from: a */
        public void m14634a(C3431b c3431b) {
            if (this.f18549c != this.f18550d) {
                C3431b a = m14632a();
                if (a.m14626c() == c3431b.m14626c()) {
                    a.m14621a((a.m14619a() + c3431b.m14619a()) / 2.0d);
                    a.m14625b((a.m14623b() + c3431b.m14623b()) / 2.0d);
                    return;
                }
            }
            if (m14635b()) {
                m14639d();
            }
            m14636b(c3431b);
        }

        /* renamed from: b */
        public boolean m14635b() {
            return (this.f18550d + 1) % this.f18548b.length == this.f18549c;
        }

        /* renamed from: b */
        public boolean m14636b(C3431b c3431b) {
            if (m14635b()) {
                return false;
            }
            this.f18548b[this.f18550d] = c3431b;
            this.f18550d = (this.f18550d + 1) % this.f18548b.length;
            return true;
        }

        /* renamed from: c */
        public boolean m14637c() {
            return this.f18550d == this.f18549c;
        }

        /* renamed from: c */
        public boolean m14638c(C3431b c3431b) {
            if (this.f18547a.ad && this.f18547a.ae) {
                return true;
            }
            if (m14637c()) {
                return true;
            }
            if (c3431b.m14627c(m14632a())) {
                return true;
            }
            if (m14632a().m14628d()) {
                return false;
            }
            for (int i = 0; i < m14640e(); i++) {
                C3431b a = m14633a(i);
                if (a.m14628d() && a.m14627c(c3431b)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        public boolean m14639d() {
            if (this.f18549c == this.f18550d) {
                return false;
            }
            this.f18549c = (this.f18549c + 1) % this.f18548b.length;
            return true;
        }

        /* renamed from: e */
        public int m14640e() {
            return ((this.f18550d - this.f18549c) + this.f18548b.length) % this.f18548b.length;
        }

        public String toString() {
            int i;
            int i2 = 0;
            String str = "";
            for (i = 0; i < m14640e(); i++) {
                str = str + this.f18548b[(this.f18549c + i) % this.f18548b.length].f18536a + ",";
            }
            str = str + "  ";
            for (i = 0; i < m14640e(); i++) {
                str = str + this.f18548b[(this.f18549c + i) % this.f18548b.length].f18537b + ",";
            }
            String str2 = str + "  ";
            while (i2 < m14640e()) {
                str2 = str2 + this.f18548b[(this.f18549c + i2) % this.f18548b.length].f18539d + ",";
                i2++;
            }
            return str2 + "  ";
        }
    }

    /* renamed from: com.baidu.location.indoor.d$d */
    class C3433d {
        /* renamed from: a */
        final /* synthetic */ C3439d f18551a;
        /* renamed from: b */
        private C3431b[] f18552b;
        /* renamed from: c */
        private int f18553c;
        /* renamed from: d */
        private int f18554d;

        public C3433d(C3439d c3439d) {
            this(c3439d, 5);
        }

        public C3433d(C3439d c3439d, int i) {
            this.f18551a = c3439d;
            this.f18552b = new C3431b[(i + 1)];
            this.f18553c = 0;
            this.f18554d = 0;
        }

        /* renamed from: a */
        public C3431b m14641a() {
            return this.f18552b[((this.f18554d - 1) + this.f18552b.length) % this.f18552b.length];
        }

        /* renamed from: a */
        public boolean m14642a(C3431b c3431b) {
            if (c3431b.m14631g() == null || c3431b.m14630f() == null) {
                return false;
            }
            double doubleValue = c3431b.m14631g().doubleValue();
            if (c3431b.m14630f().doubleValue() > 1.0d && doubleValue > 8.0d) {
                return false;
            }
            if (m14647d()) {
                return true;
            }
            C3431b a = m14641a();
            double doubleValue2 = a.m14629e().doubleValue();
            double doubleValue3 = c3431b.m14629e().doubleValue();
            doubleValue = C3444g.m14760a(a.f18540e);
            double a2 = C3444g.m14760a(c3431b.f18540e);
            doubleValue2 = C3444g.m14758a(doubleValue2, doubleValue3);
            doubleValue = C3444g.m14761b(doubleValue, a2);
            doubleValue3 = Math.abs(Math.abs(doubleValue2) - Math.abs(doubleValue));
            if (Math.abs(doubleValue) <= 15.0d) {
                return Math.abs(doubleValue2) <= Math.abs(doubleValue) * 2.0d && doubleValue3 <= 20.0d;
            } else {
                this.f18551a.f18619o.f18575t.m14650g();
                return false;
            }
        }

        /* renamed from: b */
        public float m14643b() {
            if (m14649f() < 4) {
                return 0.0f;
            }
            List arrayList = new ArrayList();
            for (int i = 2; i <= m14649f(); i++) {
                C3431b c3431b = this.f18552b[(((this.f18554d - i) + 1) + this.f18552b.length) % this.f18552b.length];
                C3431b c3431b2 = this.f18552b[((this.f18554d - i) + this.f18552b.length) % this.f18552b.length];
                double b = C3444g.m14762b(c3431b2.f18537b, c3431b2.f18536a, c3431b.f18537b, c3431b.f18536a);
                double toDegrees = 90.0d - Math.toDegrees(Math.atan(c3431b.m14629e().doubleValue()));
                if (Math.abs(C3444g.m14761b(toDegrees, b)) >= Math.abs(C3444g.m14761b(toDegrees + 180.0d, b))) {
                    toDegrees += 180.0d;
                }
                arrayList.add(Float.valueOf((float) C3444g.m14761b(C3444g.m14760a(c3431b.f18540e), toDegrees)));
            }
            return (float) C3444g.m14760a(arrayList);
        }

        /* renamed from: b */
        public boolean m14644b(C3431b c3431b) {
            if (m14645c()) {
                m14648e();
            }
            return m14646c(c3431b);
        }

        /* renamed from: c */
        public boolean m14645c() {
            return (this.f18554d + 1) % this.f18552b.length == this.f18553c;
        }

        /* renamed from: c */
        public boolean m14646c(C3431b c3431b) {
            if (m14645c()) {
                return false;
            }
            this.f18552b[this.f18554d] = c3431b;
            this.f18554d = (this.f18554d + 1) % this.f18552b.length;
            return true;
        }

        /* renamed from: d */
        public boolean m14647d() {
            return this.f18554d == this.f18553c;
        }

        /* renamed from: e */
        public boolean m14648e() {
            if (this.f18553c == this.f18554d) {
                return false;
            }
            this.f18553c = (this.f18553c + 1) % this.f18552b.length;
            return true;
        }

        /* renamed from: f */
        public int m14649f() {
            return ((this.f18554d - this.f18553c) + this.f18552b.length) % this.f18552b.length;
        }

        /* renamed from: g */
        public void m14650g() {
            this.f18554d = 0;
            this.f18553c = 0;
        }

        public String toString() {
            int i;
            int i2 = 0;
            String str = "";
            for (i = 0; i < m14649f(); i++) {
                str = str + this.f18552b[(this.f18553c + i) % this.f18552b.length].f18536a + ",";
            }
            str = str + "  ";
            for (i = 0; i < m14649f(); i++) {
                str = str + this.f18552b[(this.f18553c + i) % this.f18552b.length].f18537b + ",";
            }
            String str2 = str + "  ";
            while (i2 < m14649f()) {
                str2 = str2 + this.f18552b[(this.f18553c + i2) % this.f18552b.length].f18539d + ",";
                i2++;
            }
            return str2 + "  ";
        }
    }

    /* renamed from: com.baidu.location.indoor.d$e */
    public class C3434e extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3439d f18555a;

        public C3434e(C3439d c3439d) {
            this.f18555a = c3439d;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 21:
                        this.f18555a.m14685a(message);
                        return;
                    case 28:
                        this.f18555a.m14700b(message);
                        return;
                    case 41:
                        this.f18555a.m14723m();
                        return;
                    case 801:
                        this.f18555a.m14686a((BDLocation) message.obj);
                        return;
                    default:
                        super.dispatchMessage(message);
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.d$f */
    class C3435f extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3439d f18556a;
        /* renamed from: b */
        private volatile boolean f18557b = true;
        /* renamed from: c */
        private long f18558c = 0;

        C3435f(C3439d c3439d) {
            this.f18556a = c3439d;
        }

        public void run() {
            while (this.f18557b) {
                if ((((this.f18556a.f18616l && System.currentTimeMillis() - this.f18558c > this.f18556a.f18615k) || System.currentTimeMillis() - this.f18558c > BNOffScreenParams.MIN_ENTER_INTERVAL) && this.f18556a.f18617m.m14792c() == 1) || System.currentTimeMillis() - this.f18558c > 17500) {
                    C3376f.m14355a().m14374i();
                    this.f18556a.f18617m.m14794e();
                    this.f18558c = System.currentTimeMillis();
                    this.f18556a.f18616l = false;
                } else if (this.f18556a.f18617m.m14792c() != 1) {
                    C3181a.m13265a().m13281d();
                }
                if (System.currentTimeMillis() - this.f18556a.f18620p > 22000) {
                    this.f18556a.f18608c.sendEmptyMessage(41);
                }
                if (System.currentTimeMillis() - this.f18556a.f18623s > 60000) {
                    C3439d.m14680a().m14742d();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    this.f18557b = false;
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.d$g */
    private class C3436g {
        /* renamed from: a */
        public int f18559a;
        /* renamed from: b */
        public double f18560b;
        /* renamed from: c */
        public double f18561c;
        /* renamed from: d */
        public int f18562d = 1;
        /* renamed from: e */
        final /* synthetic */ C3439d f18563e;

        public C3436g(C3439d c3439d, int i, double d, double d2) {
            this.f18563e = c3439d;
            this.f18559a = i;
            this.f18560b = d;
            this.f18561c = d2;
        }

        public String toString() {
            return String.format("%d:%.2f", new Object[]{Integer.valueOf(this.f18562d), Double.valueOf(this.f18561c)});
        }
    }

    /* renamed from: com.baidu.location.indoor.d$h */
    class C3438h extends C3186e {
        /* renamed from: a */
        public float f18565a;
        /* renamed from: b */
        final /* synthetic */ C3439d f18566b;
        /* renamed from: c */
        private boolean f18567c;
        /* renamed from: d */
        private boolean f18568d;
        /* renamed from: e */
        private String f18569e;
        /* renamed from: f */
        private String f18570f;
        /* renamed from: p */
        private List<Float> f18571p;
        /* renamed from: q */
        private C3430a f18572q;
        /* renamed from: r */
        private C3432c f18573r;
        /* renamed from: s */
        private C3433d f18574s;
        /* renamed from: t */
        private C3433d f18575t;
        /* renamed from: u */
        private int f18576u;
        /* renamed from: v */
        private long f18577v;
        /* renamed from: w */
        private long f18578w;

        /* renamed from: com.baidu.location.indoor.d$h$1 */
        class C34371 implements C3421a {
            /* renamed from: a */
            final /* synthetic */ C3438h f18564a;

            C34371(C3438h c3438h) {
                this.f18564a = c3438h;
            }

            /* renamed from: a */
            public void mo2521a(boolean z, String str, String str2, String str3) {
                if (z) {
                    this.f18564a.f18566b.f18601V = "&ibuuid=" + str + "&ibname=" + str2 + "&ibfls=" + str3;
                }
            }
        }

        public C3438h(C3439d c3439d) {
            this.f18566b = c3439d;
            this.f18567c = false;
            this.f18568d = false;
            this.f18569e = null;
            this.f18570f = null;
            this.f18571p = new ArrayList();
            this.f18572q = null;
            this.f18573r = null;
            this.f18574s = null;
            this.f18575t = null;
            this.f18565a = 0.0f;
            this.f18576u = -1;
            this.f18577v = 0;
            this.f18578w = 0;
            this.k = new HashMap();
            this.f18573r = new C3432c(c3439d);
            this.f18574s = new C3433d(c3439d);
            this.f18575t = new C3433d(c3439d, 6);
        }

        /* renamed from: a */
        private boolean m14654a(C3372e c3372e, double d) {
            C3430a c3430a = new C3430a(this.f18566b, c3372e);
            if (this.f18572q != null && c3430a.m14616a(this.f18572q) > d) {
                return false;
            }
            this.f18572q = c3430a;
            return true;
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            if (this.f18566b.f18630z == null || this.f18566b.f18580A == null || !this.f18566b.f18630z.equals(this.f18566b.f18580A.m14756a())) {
                this.f18569e = "&nd_idf=1&indoor_polygon=1" + this.f18569e;
            }
            this.i = 1;
            String encodeTp4 = Jni.encodeTp4(this.f18569e);
            this.f18569e = null;
            this.k.put("bloc", encodeTp4);
            this.f18577v = System.currentTimeMillis();
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                this.f18566b.f18624t = this.f18566b.f18624t + 1;
                this.f18566b.aa = 0;
                this.f18566b.f18605Z = true;
                this.f18567c = false;
                if (this.f18566b.f18624t > 40) {
                    this.f18566b.m14742d();
                } else {
                    return;
                }
            }
            try {
                String str = this.j;
                if (this.f18566b.f18621q) {
                    BDLocation bDLocation = new BDLocation(str);
                    if (!(bDLocation == null || bDLocation.getLocType() != 161 || bDLocation.getBuildingID() == null)) {
                        this.f18566b.ab = new BDLocation(bDLocation);
                    }
                    this.f18566b.f18605Z = false;
                    str = bDLocation.getIndoorLocationSurpportBuidlingName();
                    if (str == null) {
                        Log.w(C3380a.f18302a, "inbldg is null");
                    } else if (!this.f18566b.f18600U.m14522a(str)) {
                        this.f18566b.f18600U.m14523a(str, null);
                    }
                    if (this.f18566b.f18602W != null) {
                        this.f18566b.f18602W.m14608a(new C34371(this));
                    }
                    C3202i.m13395a().m13404c(true);
                    C3202i.m13395a().m13405d();
                    if (this.f18566b.f18617m.m14793d() == -1) {
                        this.f18566b.f18607b = false;
                    }
                    if (bDLocation.getBuildingName() != null) {
                        this.f18566b.f18582C = bDLocation.getBuildingName();
                    }
                    if (bDLocation.getFloor() != null) {
                        this.f18566b.f18623s = System.currentTimeMillis();
                        this.f18578w = System.currentTimeMillis();
                        int i = (int) (this.f18578w - this.f18577v);
                        if (i > 10000) {
                            this.f18566b.aa = 0;
                        } else if (i < 3000) {
                            this.f18566b.aa = 2;
                        } else {
                            this.f18566b.aa = 1;
                        }
                        if (bDLocation.getFloor().contains("-a")) {
                            this.f18566b.f18594O = true;
                            bDLocation.setFloor(bDLocation.getFloor().split("-")[0]);
                        } else {
                            this.f18566b.f18594O = false;
                        }
                        this.f18566b.f18587H.add(bDLocation.getFloor());
                    }
                    if (this.f18566b.f18606a && this.f18566b.f18607b) {
                        C3431b c3431b = new C3431b(this.f18566b, bDLocation.getLongitude(), bDLocation.getLatitude(), System.currentTimeMillis(), this.f18566b.f18617m.m14793d(), this.f18571p, bDLocation.getRetFields("gradient"), bDLocation.getRetFields("mean_error"), bDLocation.getRetFields("confidence"));
                        if (this.f18573r.m14638c(c3431b)) {
                            c3431b.m14622a(true);
                            Message obtainMessage = this.f18566b.f18608c.obtainMessage(21);
                            obtainMessage.obj = bDLocation;
                            obtainMessage.sendToTarget();
                        } else {
                            this.f18566b.m14726o();
                        }
                        if (bDLocation.getFloor() != null) {
                            this.f18573r.m14634a(c3431b);
                        }
                    } else {
                        Message obtainMessage2 = this.f18566b.f18608c.obtainMessage(21);
                        obtainMessage2.obj = bDLocation;
                        obtainMessage2.sendToTarget();
                    }
                } else {
                    this.f18567c = false;
                    return;
                }
            } catch (Exception e) {
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f18567c = false;
        }

        /* renamed from: b */
        public void mo2500b() {
            if (this.f18567c) {
                this.f18568d = true;
                return;
            }
            StringBuffer stringBuffer = new StringBuffer(1024);
            String i = C3364b.m14262a().m14280f().m14255i();
            String i2 = C3371d.m14289a().m14321i();
            this.f18566b.f18592M = 0.5d;
            C3372e r = C3376f.m14355a().m14382r();
            String a = this.f18566b.m14682a(r);
            String a2 = a == null ? r.m14331a(32) : a;
            if (a2 != null && a2.length() >= 10) {
                if (this.f18570f == null || !this.f18570f.equals(a2)) {
                    this.f18570f = a2;
                    int d = this.f18566b.f18617m.m14793d();
                    int i3 = (this.f18576u < 0 || d - this.f18576u > this.f18566b.f18614i) ? true : 0;
                    if (this.f18566b.f18606a && this.f18566b.f18607b) {
                        if (this.f18566b.f18622r && !m14654a(r, 0.8d) && i3 == 0) {
                            return;
                        }
                    } else if (this.f18566b.f18606a && this.f18566b.f18622r && !m14654a(r, 0.7d) && i3 == 0) {
                        return;
                    }
                    this.f18576u = d;
                    this.f18567c = true;
                    stringBuffer.append(i);
                    if (i2 != null) {
                        stringBuffer.append(i2);
                    }
                    stringBuffer.append("&coor=gcj02");
                    stringBuffer.append("&lt=1");
                    stringBuffer.append(a2);
                    if (this.f18566b.f18611f && C3400b.m14479a(this.f18566b.f18612g) != null) {
                        BDLocation a3 = C3400b.m14479a(this.f18566b.f18612g).m14481a();
                        if (a3 != null) {
                            stringBuffer.append(String.format("&mag_x=%.6f", new Object[]{Double.valueOf(a3.getLongitude())}));
                            stringBuffer.append(String.format("&mag_y=%.6f", new Object[]{Double.valueOf(a3.getLatitude())}));
                            stringBuffer.append(String.format("&mag_r=%.1f", new Object[]{Float.valueOf(a3.getRadius())}));
                            stringBuffer.append("&mag_t=" + a3.getTime());
                        }
                    }
                    i3 = this.f18566b.f18596Q.size();
                    stringBuffer.append(this.f18566b.m14681a(i3));
                    this.f18566b.f18597R = i3;
                    this.f18566b.f18598S = this.f18566b.f18598S + 1;
                    stringBuffer.append("&drsi=" + this.f18566b.f18598S);
                    stringBuffer.append("&idpfv=1");
                    this.f18566b.f18599T = this.f18566b.f18599T + 1;
                    if (this.f18566b.f18601V != null) {
                        stringBuffer.append(this.f18566b.f18601V);
                        this.f18566b.f18601V = null;
                    }
                    stringBuffer.append(C3381b.m14398a().m14399a(true));
                    this.f18569e = stringBuffer.toString();
                    m13299c(C3391g.f18379f);
                }
            }
        }

        /* renamed from: c */
        public synchronized void mo2499c() {
            if (!this.f18567c) {
                if (this.f18568d) {
                    this.f18568d = false;
                    mo2500b();
                }
            }
        }
    }

    private C3439d() {
        this.f18610e = 32;
        this.f18606a = false;
        this.f18607b = false;
        this.f18614i = 5;
        this.f18615k = 3000;
        this.f18616l = true;
        this.f18608c = null;
        this.f18617m = null;
        this.f18618n = null;
        this.f18619o = null;
        this.f18620p = 0;
        this.f18621q = false;
        this.f18622r = false;
        this.f18623s = 0;
        this.f18624t = 0;
        this.f18625u = 0;
        this.f18627w = 0;
        this.f18628x = 0;
        this.f18629y = null;
        this.f18630z = null;
        this.f18580A = null;
        this.f18581B = null;
        this.f18582C = null;
        this.f18583D = null;
        this.f18584E = 0;
        this.f18585F = true;
        this.f18586G = 7;
        this.f18587H = null;
        this.f18588I = 20;
        this.f18589J = null;
        this.f18590K = 0.0d;
        this.f18591L = 0.0d;
        this.f18592M = 0.4d;
        this.f18593N = 0.0d;
        this.f18594O = false;
        this.f18595P = true;
        this.f18596Q = Collections.synchronizedList(new ArrayList());
        this.f18597R = -1;
        this.f18598S = 0;
        this.f18599T = 0;
        this.f18601V = null;
        this.f18602W = null;
        this.f18605Z = false;
        this.f18609d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.aa = 2;
        this.ab = null;
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.af = Collections.synchronizedList(new ArrayList());
        this.f18611f = false;
        this.f18612g = new C34231(this);
        this.f18608c = new C3434e(this);
        try {
            C3456a.m14830a(C3377f.getServiceContext());
        } catch (Exception e) {
        }
        this.f18603X = new C3450i();
        this.f18603X.m14811a(800);
        this.f18604Y = new C34252(this);
        this.f18626v = new C34273(this);
        this.f18617m = new C3447h(C3377f.getServiceContext(), this.f18626v);
        this.f18619o = new C3438h(this);
        this.f18587H = new C3418b(this.f18586G);
        this.f18589J = new C3418b(this.f18588I);
        this.f18600U = new C3406a(C3377f.getServiceContext());
    }

    /* renamed from: a */
    public static synchronized C3439d m14680a() {
        C3439d c3439d;
        synchronized (C3439d.class) {
            if (f18579j == null) {
                f18579j = new C3439d();
            }
            c3439d = f18579j;
        }
        return c3439d;
    }

    /* renamed from: a */
    private String m14681a(int i) {
        if (this.f18596Q.size() == 0) {
            return "&dr=0:0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&dr=");
        ((C3436g) this.f18596Q.get(0)).f18562d = 1;
        stringBuilder.append(((C3436g) this.f18596Q.get(0)).toString());
        int i2 = 1;
        int i3 = ((C3436g) this.f18596Q.get(0)).f18559a;
        while (i2 < this.f18596Q.size() && i2 <= i) {
            ((C3436g) this.f18596Q.get(i2)).f18562d = ((C3436g) this.f18596Q.get(i2)).f18559a - i3;
            stringBuilder.append(";");
            stringBuilder.append(((C3436g) this.f18596Q.get(i2)).toString());
            int i4 = ((C3436g) this.f18596Q.get(i2)).f18559a;
            i2++;
            i3 = i4;
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private String m14682a(C3372e c3372e) {
        int a = c3372e.m14330a();
        if (a <= 32) {
            return c3372e.m14331a(32) + "&aprk=0";
        }
        String toLowerCase;
        String str = "";
        List arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (int i = 0; i < a; i++) {
            toLowerCase = ((ScanResult) c3372e.f18275a.get(i)).BSSID.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "").toLowerCase();
            if (this.f18600U == null || !this.f18600U.m14525b(toLowerCase)) {
                arrayList2.add(c3372e.f18275a.get(i));
            } else {
                arrayList.add(c3372e.f18275a.get(i));
            }
        }
        toLowerCase = arrayList.size() > 0 ? "&aprk=3" : str;
        if (toLowerCase.equals("")) {
            toLowerCase = this.f18600U.mo2500b() ? "&aprk=2" : "&aprk=1";
        }
        arrayList.addAll(arrayList2);
        c3372e.f18275a = arrayList;
        return c3372e.m14331a(32) + toLowerCase;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m14685a(android.os.Message r15) {
        /*
        r14 = this;
        r0 = r14.f18621q;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r15.obj;
        r13 = r0;
        r13 = (com.baidu.location.BDLocation) r13;
        r0 = r13.getLocType();
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        if (r0 != r1) goto L_0x0277;
    L_0x0012:
        r14.m14726o();
        r0 = r13.getIndoorSurpportPolygon();
        if (r0 == 0) goto L_0x0084;
    L_0x001b:
        r0 = r13.getIndoorLocationSurpportBuidlingID();
        if (r0 == 0) goto L_0x0084;
    L_0x0021:
        r0 = r14.f18580A;
        if (r0 == 0) goto L_0x0035;
    L_0x0025:
        r0 = r14.f18580A;
        r0 = r0.m14756a();
        r1 = r13.getBuildingID();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0084;
    L_0x0035:
        r0 = r13.getIndoorSurpportPolygon();
        r1 = "\\|";
        r1 = r0.split(r1);
        r0 = r1.length;
        r2 = new android.location.Location[r0];
        r0 = 0;
    L_0x0044:
        r3 = r1.length;
        if (r0 >= r3) goto L_0x0079;
    L_0x0047:
        r3 = r1[r0];
        r4 = ",";
        r3 = r3.split(r4);
        r4 = new android.location.Location;
        r5 = "gps";
        r4.<init>(r5);
        r5 = 1;
        r5 = r3[r5];
        r5 = java.lang.Double.valueOf(r5);
        r6 = r5.doubleValue();
        r4.setLatitude(r6);
        r5 = 0;
        r3 = r3[r5];
        r3 = java.lang.Double.valueOf(r3);
        r6 = r3.doubleValue();
        r4.setLongitude(r6);
        r2[r0] = r4;
        r0 = r0 + 1;
        goto L_0x0044;
    L_0x0079:
        r0 = new com.baidu.location.indoor.f;
        r1 = r13.getIndoorLocationSurpportBuidlingID();
        r0.<init>(r1, r2);
        r14.f18580A = r0;
    L_0x0084:
        r0 = 0;
        r14.f18624t = r0;
        r0 = r13.getBuildingID();
        if (r0 != 0) goto L_0x016b;
    L_0x008d:
        r0 = 0;
        r14.f18622r = r0;
        r0 = r14.f18625u;
        r0 = r0 + 1;
        r14.f18625u = r0;
        r0 = r14.f18625u;
        r1 = 3;
        if (r0 <= r1) goto L_0x009e;
    L_0x009b:
        r14.m14742d();
    L_0x009e:
        r0 = r13.getNetworkLocationType();
        if (r0 == 0) goto L_0x00b8;
    L_0x00a4:
        r0 = r13.getNetworkLocationType();
        r1 = "ble";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00b8;
    L_0x00b1:
        r0 = com.baidu.location.p187a.C3200h.m13362c();
        r0.m13383c(r13);
    L_0x00b8:
        r0 = r14.f18622r;
        if (r0 == 0) goto L_0x0164;
    L_0x00bc:
        r0 = r13.getTime();
        if (r0 != 0) goto L_0x00d0;
    L_0x00c2:
        r0 = new java.util.Date;
        r0.<init>();
        r1 = r14.f18609d;
        r0 = r1.format(r0);
        r13.setTime(r0);
    L_0x00d0:
        r0 = 21;
        r14.m14687a(r13, r0);
        r0 = r13.getNetworkLocationType();
        r1 = "wf";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0150;
    L_0x00e2:
        r0 = new com.baidu.location.indoor.d$b;
        r2 = r13.getLongitude();
        r4 = r13.getLatitude();
        r6 = java.lang.System.currentTimeMillis();
        r1 = r14.f18617m;
        r8 = r1.m14793d();
        r9 = r14.af;
        r1 = "gradient";
        r10 = r13.getRetFields(r1);
        r1 = "mean_error";
        r11 = r13.getRetFields(r1);
        r1 = "confidence";
        r12 = r13.getRetFields(r1);
        r1 = r14;
        r0.<init>(r1, r2, r4, r6, r8, r9, r10, r11, r12);
        r1 = r14.af;
        r1.clear();
        r1 = r0.f18540e;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x014a;
    L_0x011e:
        r1 = r14.f18619o;
        r1 = r1.f18574s;
        r1 = r1.m14642a(r0);
        if (r1 == 0) goto L_0x0133;
    L_0x012a:
        r1 = r14.f18619o;
        r1 = r1.f18575t;
        r1.m14644b(r0);
    L_0x0133:
        r1 = r14.f18619o;
        r2 = r14.f18619o;
        r2 = r2.f18575t;
        r2 = r2.m14643b();
        r1.f18565a = r2;
        r1 = r14.f18619o;
        r1 = r1.f18574s;
        r1.m14644b(r0);
    L_0x014a:
        r0 = r14.f18593N;
        r0 = (float) r0;
        r13.setDirection(r0);
    L_0x0150:
        r0 = new com.baidu.location.BDLocation;
        r0.<init>(r13);
        r1 = com.baidu.location.indoor.p197b.C3414b.m14575a();
        r1 = r1.m14588a(r0);
        if (r1 == 0) goto L_0x029e;
    L_0x015f:
        r1 = 21;
        r14.m14687a(r0, r1);
    L_0x0164:
        r0 = r14.f18619o;
        r0.mo2499c();
        goto L_0x0004;
    L_0x016b:
        r0 = 0;
        r14.f18627w = r0;
        r0 = 0;
        r14.f18625u = r0;
        r0 = 1;
        r14.f18622r = r0;
        r0 = 1;
        r13.setIndoorLocMode(r0);
        r0 = r14.f18590K;
        r2 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x018e;
    L_0x0183:
        r0 = r14.f18591L;
        r2 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x019a;
    L_0x018e:
        r0 = r13.getLatitude();
        r14.f18591L = r0;
        r0 = r13.getLongitude();
        r14.f18590K = r0;
    L_0x019a:
        r0 = r14.f18629y;
        if (r0 != 0) goto L_0x01a4;
    L_0x019e:
        r0 = r13.getFloor();
        r14.f18629y = r0;
    L_0x01a4:
        r0 = r13.getBuildingName();
        r1 = r13.getFloor();
        r14.m14691a(r0, r1);
        r0 = r13.getBuildingID();
        r14.f18630z = r0;
        r0 = r13.getBuildingName();
        r14.f18581B = r0;
        r0 = r13.getNetworkLocationType();
        r14.f18583D = r0;
        r0 = r14.f18583D;
        r1 = "ble";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x01e0;
    L_0x01cc:
        r0 = r14.f18595P;
        r1 = 1;
        if (r0 != r1) goto L_0x01e0;
    L_0x01d1:
        r0 = r13.getLatitude();
        r14.f18591L = r0;
        r0 = r13.getLongitude();
        r14.f18590K = r0;
        r0 = 0;
        r14.f18595P = r0;
    L_0x01e0:
        r0 = r13.isParkAvailable();
        r14.f18584E = r0;
        r0 = r13.getFloor();
        r1 = r14.m14724n();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0004;
    L_0x01f4:
        r0 = r13.getFloor();
        r1 = r14.f18629y;
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 != 0) goto L_0x0211;
    L_0x0200:
        r0 = r14.ad;
        if (r0 == 0) goto L_0x0211;
    L_0x0204:
        com.baidu.location.indoor.mapversion.p199a.C3451a.m14820b();
        r0 = r13.getFloor();
        r0 = com.baidu.location.indoor.mapversion.p199a.C3451a.m14818a(r0);
        r14.ae = r0;
    L_0x0211:
        r0 = r13.getFloor();
        r14.f18629y = r0;
        if (r1 != 0) goto L_0x021c;
    L_0x0219:
        r14.m14719k();
    L_0x021c:
        r0 = 0;
        r2 = r14.ad;
        if (r2 == 0) goto L_0x0227;
    L_0x0221:
        r0 = com.baidu.location.indoor.mapversion.p199a.C3451a.m14817a(r13);
        if (r0 == 0) goto L_0x0227;
    L_0x0227:
        r2 = r14.ad;
        if (r2 == 0) goto L_0x022d;
    L_0x022b:
        if (r0 != 0) goto L_0x0269;
    L_0x022d:
        r0 = r14.f18594O;
        if (r0 != 0) goto L_0x0269;
    L_0x0231:
        if (r1 == 0) goto L_0x0269;
    L_0x0233:
        r0 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r14.f18590K;
        r4 = (double) r0;
        r2 = r2 * r4;
        r4 = r14.f18592M;
        r2 = r2 * r4;
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r6 = r14.f18592M;
        r4 = r4 - r6;
        r6 = r13.getLongitude();
        r8 = (double) r0;
        r6 = r6 * r8;
        r4 = r4 * r6;
        r2 = r2 + r4;
        r4 = r14.f18591L;
        r6 = (double) r0;
        r4 = r4 * r6;
        r6 = r14.f18592M;
        r4 = r4 * r6;
        r6 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r8 = r14.f18592M;
        r6 = r6 - r8;
        r8 = r13.getLatitude();
        r10 = (double) r0;
        r8 = r8 * r10;
        r6 = r6 * r8;
        r4 = r4 + r6;
        r6 = (double) r0;
        r4 = r4 / r6;
        r13.setLatitude(r4);
        r0 = (double) r0;
        r0 = r2 / r0;
        r13.setLongitude(r0);
    L_0x0269:
        r0 = r13.getLatitude();
        r14.f18591L = r0;
        r0 = r13.getLongitude();
        r14.f18590K = r0;
        goto L_0x009e;
    L_0x0277:
        r0 = r13.getLocType();
        r1 = 63;
        if (r0 != r1) goto L_0x0296;
    L_0x027f:
        r0 = r14.f18624t;
        r0 = r0 + 1;
        r14.f18624t = r0;
        r0 = 0;
        r14.f18622r = r0;
        r0 = 1;
        r14.f18605Z = r0;
        r0 = r14.f18624t;
        r1 = 10;
        if (r0 <= r1) goto L_0x0004;
    L_0x0291:
        r14.m14742d();
        goto L_0x00b8;
    L_0x0296:
        r0 = 0;
        r14.f18624t = r0;
        r0 = 0;
        r14.f18622r = r0;
        goto L_0x00b8;
    L_0x029e:
        r1 = r0.getNetworkLocationType();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r2 = "2";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.setNetworkLocationType(r1);
        r1 = r14.f18603X;
        if (r1 == 0) goto L_0x02dc;
    L_0x02bd:
        r1 = r14.f18603X;
        r1 = r1.m14815c();
        if (r1 == 0) goto L_0x02dc;
    L_0x02c5:
        r1 = r14.f18599T;
        r2 = (long) r1;
        r4 = 2;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x02d5;
    L_0x02ce:
        r1 = r14.f18603X;
        r1.m14812a(r0);
        goto L_0x0164;
    L_0x02d5:
        r1 = 29;
        r14.m14687a(r0, r1);
        goto L_0x0164;
    L_0x02dc:
        r1 = 21;
        r14.m14687a(r0, r1);
        goto L_0x0164;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.d.a(android.os.Message):void");
    }

    /* renamed from: a */
    private void m14686a(BDLocation bDLocation) {
        C3442e.m14748a().m14753a(bDLocation, this.f18582C);
    }

    /* renamed from: a */
    private void m14687a(BDLocation bDLocation, int i) {
        if (this.ab != null) {
            if (bDLocation.getAddrStr() == null && this.ab.getAddrStr() != null) {
                bDLocation.setAddr(this.ab.getAddress());
                bDLocation.setAddrStr(this.ab.getAddrStr());
            }
            if (bDLocation.getPoiList() == null && this.ab.getPoiList() != null) {
                bDLocation.setPoiList(this.ab.getPoiList());
            }
            if (bDLocation.getLocationDescribe() == null && this.ab.getLocationDescribe() != null) {
                bDLocation.setLocationDescribe(this.ab.getLocationDescribe());
            }
        }
        if (this.f18611f && this.f18613h != null) {
            bDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
            if (bDLocation.getNetworkLocationType().contains("2")) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                bDLocation.setNetworkLocationType(networkLocationType.substring(0, networkLocationType.length() - 1));
                this.f18613h.onReceiveLocation(bDLocation);
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            Message obtainMessage = this.f18608c.obtainMessage(801);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        } else if (!C3371d.m14289a().m14325m()) {
            if (this.f18603X == null || !this.f18603X.m14815c() || i == 29) {
                bDLocation.setIndoorNetworkState(this.aa);
                bDLocation.setUserIndoorState(1);
                C3181a.m13265a().m13272a(bDLocation);
            }
        }
    }

    /* renamed from: a */
    private void m14691a(final String str, final String str2) {
        if (this.f18581B == null || !this.f18581B.equals(str) || !this.ad) {
            C3456a a = C3456a.m14829a();
            a.m14849a("gcj02");
            a.m14850a(str, new C3428c(this) {
                /* renamed from: c */
                final /* synthetic */ C3439d f18532c;

                /* renamed from: a */
                public void mo2520a(boolean z, String str) {
                    this.f18532c.ad = z;
                    if (z) {
                        this.f18532c.ae = C3451a.m14818a(str2);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private double[] m14693a(double d, double d2, double d3, double d4) {
        double[] dArr = new double[2];
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        double toRadians3 = Math.toRadians(d4);
        double asin = Math.asin((Math.sin(toRadians) * Math.cos(d3 / 6378137.0d)) + ((Math.cos(toRadians) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians3)));
        toRadians = Math.atan2((Math.sin(toRadians3) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians), Math.cos(d3 / 6378137.0d) - (Math.sin(toRadians) * Math.sin(asin))) + toRadians2;
        dArr[0] = Math.toDegrees(asin);
        dArr[1] = Math.toDegrees(toRadians);
        return dArr;
    }

    /* renamed from: b */
    private void m14700b(Message message) {
        BDLocation bDLocation = (BDLocation) message.obj;
        if (this.f18590K < 0.1d || this.f18591L < 0.1d) {
            this.f18591L = bDLocation.getLatitude();
            this.f18590K = bDLocation.getLongitude();
        }
        this.f18587H.add(bDLocation.getFloor());
        this.f18629y = m14724n();
        bDLocation.setFloor(this.f18629y);
        double longitude = ((this.f18590K * ((double) 1000000)) * this.f18592M) + ((1.0d - this.f18592M) * (bDLocation.getLongitude() * ((double) 1000000)));
        bDLocation.setLatitude((((this.f18591L * ((double) 1000000)) * this.f18592M) + ((1.0d - this.f18592M) * (bDLocation.getLatitude() * ((double) 1000000)))) / ((double) 1000000));
        bDLocation.setLongitude(longitude / ((double) 1000000));
        bDLocation.setTime(this.f18609d.format(new Date()));
        this.f18591L = bDLocation.getLatitude();
        this.f18590K = bDLocation.getLongitude();
        m14687a(bDLocation, 21);
    }

    /* renamed from: j */
    private boolean m14717j() {
        SensorManager sensorManager = (SensorManager) C3377f.getServiceContext().getSystemService("sensor");
        if (sensorManager.getDefaultSensor(4) == null || sensorManager.getDefaultSensor(1) == null || sensorManager.getDefaultSensor(2) == null) {
            return false;
        }
        try {
            getClass().getClassLoader().loadClass("com.indooratlas.android.sdk.IALocationManager");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* renamed from: k */
    private void m14719k() {
        this.f18603X.m14814b();
        this.f18599T = 0;
        this.f18619o.f18574s.m14650g();
        this.f18619o.f18575t.m14650g();
        this.f18619o.f18565a = 0.0f;
        this.f18619o.f18571p.clear();
        this.af.clear();
        this.f18596Q.clear();
    }

    /* renamed from: l */
    private void m14721l() {
        this.f18587H.clear();
        this.f18589J.clear();
        this.f18623s = 0;
        this.f18624t = 0;
        this.f18584E = 0;
        this.f18628x = 0;
        this.f18629y = null;
        this.f18605Z = false;
        this.f18630z = null;
        this.f18581B = null;
        this.f18582C = null;
        this.f18583D = null;
        this.f18585F = true;
        this.f18592M = 0.4d;
        this.f18590K = 0.0d;
        this.f18591L = 0.0d;
        this.f18627w = 0;
        this.f18625u = 0;
        this.f18594O = false;
        this.f18598S = 0;
        if (this.ad) {
            C3451a.m14820b();
            C3456a.m14829a().m14852b();
        }
        this.ae = false;
        this.ad = false;
        C3202i.m13395a().m13404c(false);
        if (this.f18602W != null) {
            this.f18602W.m14609b();
        }
    }

    /* renamed from: m */
    private void m14723m() {
        if (this.f18621q) {
            this.f18616l = true;
            this.f18619o.mo2500b();
            this.f18620p = System.currentTimeMillis();
        }
    }

    /* renamed from: n */
    private String m14724n() {
        Map hashMap = new HashMap();
        int size = this.f18587H.size();
        String str = null;
        int i = -1;
        int i2 = 0;
        String str2 = "";
        while (i2 < size) {
            try {
                String str3;
                str3 = (String) this.f18587H.get(i2);
                str2 = str2 + str3 + "|";
                if (hashMap.containsKey(str3)) {
                    hashMap.put(str3, Integer.valueOf(((Integer) hashMap.get(str3)).intValue() + 1));
                } else {
                    hashMap.put(str3, Integer.valueOf(1));
                }
                i2++;
            } catch (Exception e) {
                return this.f18629y;
            }
        }
        for (String str4 : hashMap.keySet()) {
            int intValue;
            if (((Integer) hashMap.get(str4)).intValue() > i) {
                str3 = str4;
                intValue = ((Integer) hashMap.get(str4)).intValue();
            } else {
                intValue = i;
                str3 = str;
            }
            i = intValue;
            str = str3;
        }
        return (size != this.f18586G || this.f18629y.equals(str)) ? str == null ? this.f18629y : (size < 3 || size > this.f18586G || !((String) this.f18587H.get(size - 3)).equals(this.f18587H.get(size - 1)) || !((String) this.f18587H.get(size - 2)).equals(this.f18587H.get(size - 1)) || ((String) this.f18587H.get(size - 1)).equals(str)) ? str : (String) this.f18587H.get(size - 1) : (((String) this.f18587H.get(size + -3)).equals(str) && ((String) this.f18587H.get(size - 2)).equals(str) && ((String) this.f18587H.get(size - 1)).equals(str)) ? str : this.f18629y;
    }

    /* renamed from: o */
    private void m14726o() {
        for (int i = this.f18597R; i >= 0 && this.f18596Q.size() > 0; i--) {
            this.f18596Q.remove(0);
        }
        this.f18597R = -1;
    }

    /* renamed from: a */
    public boolean m14739a(Location location) {
        if (location == null || this.f18580A == null || !this.f18580A.m14757a(location.getLatitude(), location.getLongitude())) {
            this.ac = false;
        } else {
            this.ac = true;
        }
        return this.ac;
    }

    /* renamed from: b */
    public synchronized void m14740b() {
        if (this.f18621q) {
            this.f18587H.clear();
        }
    }

    /* renamed from: c */
    public synchronized void m14741c() {
        if (!this.f18621q) {
            this.f18623s = System.currentTimeMillis();
            this.f18617m.m14790a();
            this.f18618n = new C3435f(this);
            this.f18618n.start();
            this.f18622r = false;
            this.f18621q = true;
            if (m14717j() && C3398a.m14465b().mo2499c()) {
                this.f18611f = true;
                this.f18613h = C3400b.m14479a(this.f18612g).m14483b();
            }
            this.f18603X.m14813a(this.f18604Y);
            this.f18602W = C3422c.m14598a(C3377f.getServiceContext());
            this.f18598S = 0;
            C3202i.m13395a().m13404c(true);
            C3202i.m13395a().m13405d();
        }
    }

    /* renamed from: d */
    public synchronized void m14742d() {
        if (this.f18621q) {
            this.f18617m.m14791b();
            if (this.f18603X != null && this.f18603X.m14815c()) {
                this.f18603X.m14810a();
            }
            if (this.f18600U != null) {
                this.f18600U.mo2499c();
            }
            if (this.f18611f && C3400b.m14479a(this.f18612g) != null) {
                C3400b.m14479a(this.f18612g).m14485d();
            }
            if (this.f18618n != null) {
                this.f18618n.f18557b = false;
                this.f18618n.interrupt();
                this.f18618n = null;
            }
            m14721l();
            this.f18622r = false;
            this.f18621q = false;
            C3181a.m13265a().m13282e();
            C3442e.m14748a().m14754b();
        }
    }

    /* renamed from: e */
    public synchronized void m14743e() {
        if (this.f18611f && C3400b.m14479a(this.f18612g) != null) {
            C3400b.m14479a(this.f18612g).m14484c();
        }
    }

    /* renamed from: f */
    public boolean m14744f() {
        return this.f18621q;
    }

    /* renamed from: g */
    public boolean m14745g() {
        return this.f18621q && this.f18622r;
    }

    /* renamed from: h */
    public String m14746h() {
        return this.f18629y;
    }

    /* renamed from: i */
    public String m14747i() {
        return this.f18630z;
    }
}
