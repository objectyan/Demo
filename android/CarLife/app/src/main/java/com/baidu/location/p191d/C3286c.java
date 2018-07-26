package com.baidu.location.p191d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.wifi.ScanResult;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3385d;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3213a;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.navi.driveanalysis.CommonConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.c */
public class C3286c {
    /* renamed from: a */
    private static C3286c f17800a = null;
    /* renamed from: b */
    private static Object f17801b = new Object();
    /* renamed from: A */
    private C3284a f17802A;
    /* renamed from: B */
    private C3285b f17803B;
    /* renamed from: C */
    private BDLocation f17804C;
    /* renamed from: D */
    private BDLocation f17805D;
    /* renamed from: E */
    private C3362a f17806E;
    /* renamed from: F */
    private C3372e f17807F;
    /* renamed from: G */
    private int f17808G;
    /* renamed from: H */
    private int f17809H;
    /* renamed from: c */
    private SharedPreferences f17810c;
    /* renamed from: d */
    private int f17811d;
    /* renamed from: e */
    private int f17812e;
    /* renamed from: f */
    private float f17813f;
    /* renamed from: g */
    private long f17814g;
    /* renamed from: h */
    private long f17815h;
    /* renamed from: i */
    private int f17816i;
    /* renamed from: j */
    private long f17817j;
    /* renamed from: k */
    private boolean f17818k;
    /* renamed from: l */
    private int f17819l;
    /* renamed from: m */
    private float f17820m;
    /* renamed from: n */
    private float f17821n;
    /* renamed from: o */
    private float f17822o;
    /* renamed from: p */
    private float f17823p;
    /* renamed from: q */
    private float f17824q;
    /* renamed from: r */
    private float f17825r;
    /* renamed from: s */
    private float f17826s;
    /* renamed from: t */
    private float f17827t;
    /* renamed from: u */
    private float f17828u;
    /* renamed from: v */
    private float f17829v;
    /* renamed from: w */
    private float f17830w;
    /* renamed from: x */
    private double f17831x;
    /* renamed from: y */
    private boolean f17832y;
    /* renamed from: z */
    private boolean f17833z;

    /* renamed from: com.baidu.location.d.c$a */
    class C3284a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3286c f17797a;

        C3284a(C3286c c3286c) {
            this.f17797a = c3286c;
        }

        /* renamed from: a */
        public void mo2494a() {
            if (this.k == null) {
                this.k = new HashMap();
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.k.put("qt", "gps_vd");
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                this.f17797a.f17814g = System.currentTimeMillis();
                this.f17797a.f17815h = System.currentTimeMillis();
                try {
                    Editor edit = this.f17797a.f17810c.edit();
                    edit.putLong("tt", this.f17797a.f17814g);
                    edit.putLong("temp_tt", this.f17797a.f17815h);
                    edit.putInt("coef_req_time", 0);
                    edit.commit();
                } catch (Exception e) {
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("gps_vd")) {
                        jSONObject = jSONObject.getJSONObject("gps_vd");
                        this.f17797a.f17811d = jSONObject.getInt("enable");
                        if (this.f17797a.f17811d != 0) {
                            this.f17797a.f17812e = jSONObject.getInt(CommonConstants.RADIUS);
                            this.f17797a.f17813f = (float) jSONObject.getDouble("speed");
                        }
                        if (jSONObject.has("gps_rec")) {
                            JSONObject jSONObject2;
                            JSONObject jSONObject3 = jSONObject.getJSONObject("gps_rec");
                            this.f17797a.f17819l = jSONObject3.getInt("gcs");
                            if (jSONObject3.has("imc")) {
                                jSONObject2 = jSONObject3.getJSONObject("imc");
                                this.f17797a.f17820m = (float) jSONObject2.getDouble("intercept");
                                this.f17797a.f17821n = (float) jSONObject2.getDouble("lln");
                                this.f17797a.f17822o = (float) jSONObject2.getDouble("wftop");
                                this.f17797a.f17823p = (float) jSONObject2.getDouble("wfave");
                            }
                            if (jSONObject3.has("omc")) {
                                this.f17797a.f17824q = (float) jSONObject3.getJSONObject("omc").getDouble("snr");
                            }
                            if (jSONObject3.has("inc")) {
                                jSONObject3 = jSONObject3.getJSONObject("inc");
                                jSONObject2 = jSONObject3.getJSONObject("lln");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("wftop");
                                jSONObject3 = jSONObject3.getJSONObject("wfave");
                                this.f17797a.f17825r = (float) jSONObject2.getDouble("mean");
                                this.f17797a.f17826s = (float) jSONObject2.getDouble("sigma");
                                this.f17797a.f17827t = (float) jSONObject4.getDouble("mean");
                                this.f17797a.f17828u = (float) jSONObject4.getDouble("sigma");
                                this.f17797a.f17829v = (float) jSONObject3.getDouble("mean");
                                this.f17797a.f17830w = (float) jSONObject3.getDouble("sigma");
                            }
                        }
                        try {
                            Editor edit2 = this.f17797a.f17810c.edit();
                            edit2.putInt("enable", this.f17797a.f17811d);
                            edit2.putInt(CommonConstants.RADIUS, this.f17797a.f17812e);
                            edit2.putFloat("speed", this.f17797a.f17813f);
                            if (jSONObject.has("gps_rec")) {
                                edit2.putInt("gcs", this.f17797a.f17819l);
                                edit2.putFloat("imc_intercept", this.f17797a.f17820m);
                                edit2.putFloat("imc_lln", this.f17797a.f17821n);
                                edit2.putFloat("imc_wftop", this.f17797a.f17822o);
                                edit2.putFloat("imc_wfave", this.f17797a.f17823p);
                                edit2.putFloat("omc_snr", this.f17797a.f17824q);
                                edit2.putFloat("inc_lln_mean", this.f17797a.f17825r);
                                edit2.putFloat("inc_lln_sigma", this.f17797a.f17826s);
                                edit2.putFloat("inc_wftop_mean", this.f17797a.f17827t);
                                edit2.putFloat("inc_wftop_sigma", this.f17797a.f17828u);
                                edit2.putFloat("inc_wfave_mean", this.f17797a.f17829v);
                                edit2.putFloat("inc_wfave_sigma", this.f17797a.f17830w);
                            }
                            edit2.commit();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                }
            }
            this.f17797a.f17833z = false;
        }

        /* renamed from: b */
        public void mo2500b() {
            this.f17797a.f17833z = true;
            m13299c("https://loc.map.baidu.com/cfgs/loc/gps");
        }
    }

    /* renamed from: com.baidu.location.d.c$b */
    class C3285b extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3286c f17798a;
        /* renamed from: b */
        private String f17799b;

        C3285b(C3286c c3286c) {
            this.f17798a = c3286c;
            this.f17799b = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            String encodeTp4 = Jni.encodeTp4(this.f17799b);
            this.f17799b = null;
            this.k.put("bloc", encodeTp4);
        }

        /* renamed from: a */
        public void m13737a(String str) {
            this.f17799b = str;
            m13299c(C3391g.f18379f);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                this.f17798a.m13748a(this.f17798a.f17804C);
            } else {
                try {
                    BDLocation bDLocation = new BDLocation(this.j);
                    if (bDLocation.getGpsCheckStatus() == 0) {
                        this.f17798a.f17832y = false;
                    } else {
                        this.f17798a.f17832y = true;
                        this.f17798a.f17805D = bDLocation;
                        this.f17798a.m13748a(bDLocation);
                    }
                } catch (Exception e) {
                    this.f17798a.f17832y = false;
                    this.f17798a.m13748a(this.f17798a.f17804C);
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    public C3286c() {
        this.f17810c = null;
        this.f17811d = 1;
        this.f17812e = 50;
        this.f17813f = 0.5f;
        this.f17814g = 0;
        this.f17815h = 0;
        this.f17816i = 0;
        this.f17817j = 0;
        this.f17818k = false;
        this.f17819l = 0;
        this.f17820m = -0.18181887f;
        this.f17821n = -0.90904963f;
        this.f17822o = -0.55321634f;
        this.f17823p = -0.05259979f;
        this.f17824q = 24.0f;
        this.f17825r = 8.61f;
        this.f17826s = 4.25f;
        this.f17827t = 60.39f;
        this.f17828u = 15.6f;
        this.f17829v = 68.07f;
        this.f17830w = 11.61f;
        this.f17831x = -1.0d;
        this.f17832y = false;
        this.f17833z = false;
        this.f17802A = null;
        this.f17803B = null;
        this.f17804C = null;
        this.f17805D = null;
        this.f17806E = null;
        this.f17807F = null;
        this.f17808G = 0;
        this.f17809H = 0;
        this.f17802A = new C3284a(this);
        this.f17803B = new C3285b(this);
        if (this.f17810c == null) {
            this.f17810c = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePregck", 0);
        }
        if (this.f17810c != null) {
            try {
                this.f17811d = this.f17810c.getInt("enable", 1);
                this.f17812e = this.f17810c.getInt(CommonConstants.RADIUS, 50);
                this.f17813f = this.f17810c.getFloat("speed", 0.5f);
                this.f17819l = this.f17810c.getInt("gcs", 0);
                this.f17820m = this.f17810c.getFloat("imc_intercept", this.f17820m);
                this.f17821n = this.f17810c.getFloat("imc_lln", this.f17821n);
                this.f17822o = this.f17810c.getFloat("imc_wftop", this.f17822o);
                this.f17823p = this.f17810c.getFloat("imc_wfave", this.f17823p);
                this.f17824q = this.f17810c.getFloat("omc_snr", this.f17824q);
                this.f17825r = this.f17810c.getFloat("inc_lln_mean", this.f17825r);
                this.f17826s = this.f17810c.getFloat("inc_lln_sigma", this.f17826s);
                this.f17827t = this.f17810c.getFloat("inc_wftop_mean", this.f17827t);
                this.f17828u = this.f17810c.getFloat("inc_wftop_sigma", this.f17828u);
                this.f17829v = this.f17810c.getFloat("inc_wfave_mean", this.f17829v);
                this.f17830w = this.f17810c.getFloat("inc_wfave_sigma", this.f17830w);
                this.f17814g = this.f17810c.getLong("tt", 0);
                this.f17815h = this.f17810c.getLong("temp_tt", 0);
                this.f17816i = this.f17810c.getInt("coef_req_time", 0);
            } catch (Exception e) {
                this.f17811d = 1;
                this.f17812e = 50;
                this.f17813f = 0.5f;
                this.f17819l = 0;
                this.f17820m = -0.18181887f;
                this.f17821n = -0.90904963f;
                this.f17822o = -0.55321634f;
                this.f17823p = -0.05259979f;
                this.f17824q = 24.0f;
                this.f17825r = 8.61f;
                this.f17826s = 4.25f;
                this.f17827t = 60.39f;
                this.f17828u = 15.6f;
                this.f17829v = 68.07f;
                this.f17830w = 11.61f;
                this.f17814g = System.currentTimeMillis();
                this.f17815h = System.currentTimeMillis();
                this.f17816i = 0;
            }
        }
    }

    /* renamed from: a */
    public static C3286c m13744a() {
        C3286c c3286c;
        synchronized (f17801b) {
            if (f17800a == null) {
                f17800a = new C3286c();
            }
            c3286c = f17800a;
        }
        return c3286c;
    }

    /* renamed from: a */
    private String m13745a(Location location, int i) {
        if (location == null) {
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : 10.0f);
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr = new double[2];
        Object obj = 1;
        if (C3385d.m14425a().m14427a(location.getLongitude(), location.getLatitude())) {
            dArr = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = location.getLongitude();
                dArr[1] = location.getLatitude();
            }
        } else {
            obj = null;
            dArr[0] = location.getLongitude();
            dArr[1] = location.getLatitude();
        }
        String format = String.format(Locale.CHINA, str, new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(location.getBearing()), Float.valueOf(speed), Integer.valueOf(i)});
        if (obj == null) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!location.hasAltitude()) {
            return format + "}}";
        }
        return format + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[]{Double.valueOf(location.getAltitude())});
    }

    /* renamed from: a */
    private ArrayList<Double> m13746a(ArrayList<Double> arrayList) {
        ArrayList<Double> arrayList2 = new ArrayList();
        arrayList2.add(Double.valueOf((((Double) arrayList.get(0)).doubleValue() - ((double) this.f17825r)) / ((double) this.f17826s)));
        arrayList2.add(Double.valueOf((((Double) arrayList.get(1)).doubleValue() - ((double) this.f17827t)) / ((double) this.f17828u)));
        arrayList2.add(Double.valueOf((((Double) arrayList.get(2)).doubleValue() - ((double) this.f17829v)) / ((double) this.f17830w)));
        return arrayList2;
    }

    /* renamed from: a */
    private void m13747a(int i, int i2, double d) {
        boolean a = m13754a(this.f17807F);
        boolean a2 = m13753a(this.f17806E);
        if ((a || a2 || i != this.f17809H || System.currentTimeMillis() - this.f17817j >= 15000) && System.currentTimeMillis() - this.f17817j >= 3000) {
            String m;
            this.f17809H = i;
            this.f17817j = System.currentTimeMillis();
            this.f17806E = C3364b.m14262a().m14280f();
            this.f17807F = C3376f.m14355a().m14381q();
            StringBuffer stringBuffer = new StringBuffer(1024);
            if (this.f17806E != null && this.f17806E.m14248b()) {
                stringBuffer.append(this.f17806E.m14255i());
            }
            if (this.f17807F == null || this.f17807F.m14330a() <= 1) {
                m = C3376f.m14355a().m14377m();
                if (m != null) {
                    stringBuffer.append(m);
                }
            } else {
                stringBuffer.append(this.f17807F.m14331a(15));
            }
            m = C3371d.m14289a().m14320h();
            if (m != null) {
                stringBuffer.append(m);
            }
            stringBuffer.append(C3381b.m14398a().m14399a(false));
            stringBuffer.append(C3181a.m13265a().m13283f());
            stringBuffer.append("&gad=" + i2);
            double[] a3 = C3213a.m13466a().m13470a(this.f17804C.getLongitude(), this.f17804C.getLatitude());
            stringBuffer.append("&gchm=" + String.format("%.2f", new Object[]{Double.valueOf(a3[0])}));
            stringBuffer.append("&gchs=" + a3[1]);
            stringBuffer.append("&gsnr=" + String.format("%.2f", new Object[]{Double.valueOf(d)}));
            stringBuffer.append("&coor=gcj02");
            this.f17803B.m13737a(stringBuffer.toString());
        }
    }

    /* renamed from: a */
    private void m13748a(BDLocation bDLocation) {
        if (bDLocation != null) {
            C3181a.m13265a().m13277c(bDLocation);
        }
    }

    /* renamed from: a */
    private boolean m13749a(double d, ArrayList<Double> arrayList) {
        int i = 0;
        arrayList.add(Double.valueOf(d));
        if (this.f17807F.f18275a == null || this.f17807F.f18275a.size() < 3) {
            return false;
        }
        arrayList.add(Double.valueOf(-((double) ((ScanResult) this.f17807F.f18275a.get(0)).level)));
        double d2 = 0.0d;
        while (i < 3) {
            d2 += -((double) ((ScanResult) this.f17807F.f18275a.get(i)).level);
            i++;
        }
        arrayList.add(Double.valueOf(d2 / 3.0d));
        return true;
    }

    /* renamed from: a */
    private boolean m13750a(int i) {
        boolean z = false;
        if (i != this.f17808G) {
            return true;
        }
        C3372e q = C3376f.m14355a().m14381q();
        if (q.f18275a.size() >= 3 && this.f17807F.f18275a.size() >= 3) {
            int i2 = 0;
            while (i2 < 3 && ((ScanResult) q.f18275a.get(i2)).level == ((ScanResult) this.f17807F.f18275a.get(i2)).level) {
                i2++;
            }
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m13751a(Location location, double d, ArrayList<Double> arrayList) {
        if (location == null) {
            return false;
        }
        double[] a = C3213a.m13466a().m13470a(location.getLongitude(), location.getLatitude());
        double d2 = a[0];
        C3213a.m13466a();
        if (d2 == 10000.0d) {
            return false;
        }
        d2 = a[1];
        C3213a.m13466a();
        if (d2 == 10000.0d) {
            return false;
        }
        arrayList.add(Double.valueOf(a[0]));
        arrayList.add(Double.valueOf(a[1]));
        arrayList.add(Double.valueOf(location.getAltitude()));
        arrayList.add(Double.valueOf(d));
        return true;
    }

    /* renamed from: a */
    private boolean m13753a(C3362a c3362a) {
        C3362a f = C3364b.m14262a().m14280f();
        return f == c3362a ? false : f == null || c3362a == null || !c3362a.m14247a(f);
    }

    /* renamed from: a */
    private boolean m13754a(C3372e c3372e) {
        C3372e q = C3376f.m14355a().m14381q();
        return c3372e == q ? false : q == null || c3372e == null || !c3372e.m14340c(q);
    }

    /* renamed from: b */
    private double m13755b(ArrayList<Double> arrayList) {
        return 1.0d / (Math.pow(2.718281828459045d, -((((Double) arrayList.get(2)).doubleValue() * ((double) this.f17823p)) + ((((double) this.f17820m) + (((Double) arrayList.get(0)).doubleValue() * ((double) this.f17821n))) + (((Double) arrayList.get(1)).doubleValue() * ((double) this.f17822o))))) + 1.0d);
    }

    /* renamed from: c */
    private boolean m13765c(ArrayList<Double> arrayList) {
        return (((Double) arrayList.get(2)).doubleValue() >= ((Double) arrayList.get(0)).doubleValue() - (((Double) arrayList.get(1)).doubleValue() * 2.0d) && ((Double) arrayList.get(2)).doubleValue() <= ((Double) arrayList.get(0)).doubleValue() + (((Double) arrayList.get(1)).doubleValue() * 2.0d)) || ((Double) arrayList.get(3)).doubleValue() >= ((double) this.f17824q);
    }

    /* renamed from: d */
    private boolean m13768d(ArrayList<Long> arrayList) {
        boolean z = false;
        if (arrayList.size() < 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (((Long) arrayList.get(i)).longValue() > 15) {
                z = true;
                break;
            }
        }
        if (!z) {
            Collections.sort(arrayList);
            if (((Long) arrayList.get(arrayList.size() / 2)).longValue() > 15) {
                return true;
            }
        }
        return z;
    }

    /* renamed from: e */
    private boolean m13771e(ArrayList<Long> arrayList) {
        if (arrayList.size() < 3) {
            return false;
        }
        Long valueOf = Long.valueOf(Long.MIN_VALUE);
        int i = 0;
        while (i < 3) {
            Long l = valueOf.longValue() < ((Long) arrayList.get(i)).longValue() ? (Long) arrayList.get(i) : valueOf;
            i++;
            valueOf = l;
        }
        return valueOf.longValue() > 20;
    }

    /* renamed from: a */
    public void m13793a(Location location, int i, double d) {
        if (location != null && i >= 3) {
            this.f17804C = new BDLocation(m13745a(location, i));
            long currentTimeMillis = System.currentTimeMillis() - this.f17814g;
            long currentTimeMillis2 = System.currentTimeMillis() - this.f17815h;
            if (currentTimeMillis > 86400000 || currentTimeMillis < 0) {
                Editor edit;
                if (this.f17816i >= 10) {
                    this.f17814g = System.currentTimeMillis();
                    this.f17815h = System.currentTimeMillis();
                    try {
                        edit = this.f17810c.edit();
                        edit.putLong("tt", this.f17814g);
                        edit.putLong("temp_tt", this.f17815h);
                        edit.putInt("coef_req_time", 0);
                        edit.commit();
                    } catch (Exception e) {
                    }
                } else if (this.f17833z || currentTimeMillis2 < 600000) {
                    m13748a(this.f17804C);
                    return;
                } else {
                    this.f17816i++;
                    this.f17815h = System.currentTimeMillis();
                    try {
                        edit = this.f17810c.edit();
                        edit.putInt("coef_req_time", this.f17816i);
                        edit.putLong("temp_tt", this.f17815h);
                        edit.commit();
                    } catch (Exception e2) {
                    }
                    this.f17802A.mo2500b();
                }
            }
            this.f17806E = C3364b.m14262a().m14280f();
            this.f17807F = C3376f.m14355a().m14381q();
            try {
                this.f17831x = (double) this.f17804C.getSpeed();
                if (this.f17831x > 10.0d) {
                    this.f17832y = false;
                    m13748a(this.f17804C);
                } else if (this.f17819l == 0 || !this.f17818k) {
                    m13748a(this.f17804C);
                } else if (m13750a(i)) {
                    if (m13768d(this.f17807F.m14347g())) {
                        C3376f.m14355a().m14371f();
                        if (!this.f17832y || m13771e(this.f17807F.m14347g())) {
                            this.f17832y = false;
                            m13748a(this.f17804C);
                            return;
                        }
                        m13748a(this.f17805D);
                    } else if (C3371d.m14289a().m14325m()) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (!m13749a((double) i, arrayList)) {
                            this.f17832y = false;
                            m13748a(this.f17804C);
                        } else if (m13755b(m13746a(arrayList)) >= 0.5d) {
                            if (this.f17819l == 3 || this.f17819l == 1) {
                                m13747a(1, 2, d);
                                if (this.f17832y) {
                                    m13748a(this.f17805D);
                                    return;
                                } else {
                                    m13748a(this.f17804C);
                                    return;
                                }
                            }
                            m13748a(this.f17804C);
                        } else if (!m13751a(location, d, arrayList2) || (this.f17819l != 3 && this.f17819l != 2)) {
                            this.f17832y = false;
                            m13748a(this.f17804C);
                        } else if (m13765c(arrayList2)) {
                            this.f17832y = false;
                            m13748a(this.f17804C);
                        } else {
                            m13747a(2, 3, d);
                            if (this.f17832y) {
                                m13748a(this.f17805D);
                            } else {
                                m13748a(this.f17804C);
                            }
                        }
                    } else {
                        m13748a(this.f17804C);
                    }
                } else if (this.f17832y) {
                    m13748a(this.f17805D);
                } else {
                    m13748a(this.f17804C);
                }
            } catch (Exception e3) {
                m13748a(this.f17804C);
            }
        } else if (C3391g.f18385l) {
            m13748a(new BDLocation(m13745a(location, i)));
        }
    }

    /* renamed from: a */
    public void m13794a(boolean z) {
        this.f17818k = z;
    }
}
