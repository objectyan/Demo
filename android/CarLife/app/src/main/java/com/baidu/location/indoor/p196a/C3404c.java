package com.baidu.location.indoor.p196a;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.mobstat.Config;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IARegion;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.indoor.a.c */
public final class C3404c {
    /* renamed from: a */
    private final C3400b f18427a;
    /* renamed from: b */
    private final C3403b f18428b = new C3403b(this, C3377f.getServiceContext().getMainLooper());
    /* renamed from: c */
    private String f18429c;
    /* renamed from: d */
    private String f18430d = null;
    /* renamed from: e */
    private String f18431e;
    /* renamed from: f */
    private IALocationManager f18432f;
    /* renamed from: g */
    private boolean f18433g = true;
    /* renamed from: h */
    private Boolean f18434h = null;
    /* renamed from: i */
    private boolean f18435i;
    /* renamed from: j */
    private String f18436j;
    /* renamed from: k */
    private String f18437k;
    /* renamed from: l */
    private String f18438l;
    /* renamed from: m */
    private String f18439m;
    /* renamed from: n */
    private String f18440n;
    /* renamed from: o */
    private HashMap<String, String> f18441o;
    /* renamed from: p */
    private HashMap<String, String> f18442p;
    /* renamed from: q */
    private HashMap<String, String> f18443q;
    /* renamed from: r */
    private final C3405d f18444r;
    /* renamed from: s */
    private final C3402a f18445s;
    /* renamed from: t */
    private final Queue<BDLocation> f18446t;
    /* renamed from: u */
    private final Queue<BDLocation> f18447u;

    /* renamed from: com.baidu.location.indoor.a.c$1 */
    class C34011 implements Comparator<BDLocation> {
        /* renamed from: a */
        final /* synthetic */ C3404c f18422a;

        C34011(C3404c c3404c) {
            this.f18422a = c3404c;
        }

        /* renamed from: a */
        public int m14486a(BDLocation bDLocation, BDLocation bDLocation2) {
            return bDLocation2.getTime().compareTo(bDLocation.getTime());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m14486a((BDLocation) obj, (BDLocation) obj2);
        }
    }

    /* renamed from: com.baidu.location.indoor.a.c$a */
    private class C3402a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3404c f18423a;
        /* renamed from: b */
        private final String f18424b;
        /* renamed from: c */
        private boolean f18425c;

        C3402a(C3404c c3404c) {
            this.f18423a = c3404c;
            this.f18424b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
            this.f18425c = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
            this.k.clear();
            this.k.put("bid", this.f18423a.f18429c);
            if (!TextUtils.isEmpty(this.f18423a.f18430d)) {
                this.k.put("bldg", this.f18423a.f18430d);
            }
            this.k.put("mb", Build.MODEL);
            this.k.put("msdk", "3.0");
            this.k.put("cuid", C3381b.m14398a().f18317b);
        }

        /* renamed from: a */
        protected void m14488a(String str) {
            if (!this.f18425c) {
                this.f18425c = true;
                m13301i();
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            int i;
            this.f18423a.f18434h = Boolean.valueOf(false);
            boolean z2;
            if (!z || this.j == null) {
                z2 = false;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.j.toString().getBytes())));
                    this.f18423a.f18436j = jSONObject.getString("apikey");
                    this.f18423a.f18437k = jSONObject.getString("secretkey");
                    this.f18423a.f18441o.clear();
                    this.f18423a.f18442p.clear();
                    this.f18423a.f18443q.clear();
                    JSONArray jSONArray = jSONObject.getJSONArray("buildinginfo");
                    for (i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        this.f18423a.f18443q.put(jSONObject2.getString("findex"), jSONObject2.getString("fplanid"));
                        if (jSONObject2.has("floorid")) {
                            this.f18423a.f18442p.put(jSONObject2.getString("findex"), jSONObject2.getString("floorid"));
                        }
                        if (jSONObject2.has("venueid")) {
                            this.f18423a.f18441o.put(jSONObject2.getString("findex"), jSONObject2.getString("venueid"));
                        }
                    }
                    this.f18423a.f18434h = Boolean.valueOf(true);
                    i = 1;
                } catch (Exception e) {
                    z2 = false;
                }
            }
            this.f18425c = false;
            if (i != 0) {
                Message message = new Message();
                message.what = 1;
                this.f18423a.f18428b.sendMessage(message);
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.a.c$b */
    private static class C3403b extends Handler {
        /* renamed from: a */
        private WeakReference<C3404c> f18426a;

        C3403b(C3404c c3404c, Looper looper) {
            super(looper);
            this.f18426a = new WeakReference(c3404c);
        }

        public void handleMessage(Message message) {
            C3404c c3404c;
            if (message.what == 1) {
                c3404c = (C3404c) this.f18426a.get();
                if (c3404c != null) {
                    c3404c.m14506c();
                }
            } else if (message.what == 2) {
                c3404c = (C3404c) this.f18426a.get();
                if (c3404c != null) {
                    c3404c.m14507d();
                }
            }
        }
    }

    C3404c(C3400b c3400b) {
        this.f18427a = c3400b;
        this.f18429c = null;
        this.f18431e = null;
        this.f18435i = false;
        this.f18436j = new String();
        this.f18437k = new String();
        this.f18438l = new String();
        this.f18439m = new String();
        this.f18441o = new HashMap();
        this.f18442p = new HashMap();
        this.f18443q = new HashMap();
        this.f18444r = new C3405d(this);
        this.f18445s = new C3402a(this);
        Comparator c34011 = new C34011(this);
        this.f18446t = new PriorityQueue(5, c34011);
        this.f18447u = new PriorityQueue(5, c34011);
    }

    /* renamed from: a */
    private double m14490a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double toRadians = Math.toRadians(d);
        Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d5 = Math.toRadians(d5);
        d6 = Math.toRadians(d6);
        d5 = (Math.sin(d5 / 2.0d) * ((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.sin(d5 / 2.0d))) + (Math.sin(d6 / 2.0d) * Math.sin(d6 / 2.0d));
        return (Math.atan2(Math.sqrt(d5), Math.sqrt(1.0d - d5)) * 2.0d) * 6378137.0d;
    }

    /* renamed from: h */
    private void m14500h() {
        Object obj = 1;
        if (this.f18434h == null) {
            this.f18445s.m14488a(this.f18429c);
        } else if (this.f18434h.booleanValue()) {
            if (this.f18435i) {
                if (!this.f18447u.isEmpty()) {
                    long time;
                    Object obj2;
                    BDLocation bDLocation = (BDLocation) this.f18446t.peek();
                    BDLocation bDLocation2 = (BDLocation) this.f18447u.peek();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    try {
                        time = simpleDateFormat.parse(bDLocation.getTime()).getTime() - simpleDateFormat.parse(bDLocation2.getTime()).getTime();
                    } catch (ParseException e) {
                        time = Config.BPLUS_DELAY_TIME;
                    }
                    if (time < Config.BPLUS_DELAY_TIME) {
                        if (m14490a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation2.getLatitude(), bDLocation2.getLongitude()) < 35.0d) {
                            obj2 = null;
                            obj = obj2;
                        }
                    }
                    int i = 1;
                    obj = obj2;
                }
            } else if (this.f18443q.containsKey(this.f18431e) && this.f18433g) {
                m14501i();
            }
        }
        if (obj != null) {
            this.f18427a.m14482a((BDLocation) this.f18446t.peek());
        } else {
            this.f18427a.m14482a((BDLocation) this.f18447u.peek());
        }
    }

    /* renamed from: i */
    private void m14501i() {
        this.f18440n = (String) this.f18443q.get(this.f18431e);
        if (this.f18442p.containsKey(this.f18431e)) {
            this.f18439m = (String) this.f18442p.get(this.f18431e);
        } else {
            this.f18439m = new String();
        }
        if (this.f18441o.containsKey(this.f18431e)) {
            this.f18438l = (String) this.f18441o.get(this.f18431e);
        } else {
            this.f18438l = new String();
        }
        try {
            if (this.f18432f == null) {
                Bundle bundle = new Bundle();
                bundle.putString(IALocationManager.EXTRA_API_KEY, this.f18436j);
                bundle.putString(IALocationManager.EXTRA_API_SECRET, this.f18437k);
                this.f18432f = IALocationManager.create(C3377f.getServiceContext(), bundle);
            }
            if (this.f18432f != null) {
                this.f18432f.requestLocationUpdates(IALocationRequest.create(), this.f18444r);
                this.f18432f.setLocation(IALocation.from(IARegion.venue(this.f18438l)));
                this.f18432f.registerRegionListener(this.f18444r);
                this.f18435i = true;
            }
        } catch (Exception e) {
            this.f18435i = false;
        }
    }

    /* renamed from: a */
    void m14502a() {
        this.f18433g = false;
        m14508e();
    }

    /* renamed from: a */
    void m14503a(BDLocation bDLocation) {
        if (bDLocation != null) {
            if (!(this.f18432f == null || this.f18432f.getExtraInfo() == null)) {
                String str = this.f18432f.getExtraInfo().traceId;
            }
            this.f18447u.add(bDLocation);
            m14500h();
        }
    }

    /* renamed from: b */
    public BDLocation m14504b() {
        return (BDLocation) this.f18447u.peek();
    }

    /* renamed from: b */
    void m14505b(BDLocation bDLocation) {
        if (bDLocation != null) {
            this.f18446t.add(bDLocation);
            if (this.f18429c == null || !(bDLocation.getBuildingID() == null || this.f18429c.equals(bDLocation.getBuildingID()))) {
                this.f18429c = bDLocation.getBuildingID();
                this.f18430d = bDLocation.getBuildingName();
                this.f18431e = null;
                if (this.f18435i) {
                    m14508e();
                }
                this.f18434h = null;
            }
            if (this.f18431e == null || !(bDLocation.getFloor() == null || this.f18431e.equals(bDLocation.getFloor()))) {
                this.f18431e = bDLocation.getFloor();
            }
            m14500h();
        }
    }

    /* renamed from: c */
    void m14506c() {
        if (!this.f18435i && this.f18434h != null && this.f18434h.booleanValue() && this.f18431e != null && this.f18443q.containsKey(this.f18431e) && this.f18433g) {
            m14501i();
        }
    }

    /* renamed from: d */
    void m14507d() {
        if (this.f18432f != null && this.f18435i) {
            this.f18447u.clear();
            this.f18432f.removeLocationUpdates(this.f18444r);
            this.f18432f.unregisterRegionListener(this.f18444r);
            this.f18432f.destroy();
            this.f18432f = null;
            this.f18435i = false;
            this.f18434h = null;
        }
    }

    /* renamed from: e */
    void m14508e() {
        try {
            Message message = new Message();
            message.what = 2;
            this.f18428b.sendMessage(message);
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    String m14509f() {
        return this.f18429c;
    }

    /* renamed from: g */
    String m14510g() {
        return this.f18431e;
    }
}
