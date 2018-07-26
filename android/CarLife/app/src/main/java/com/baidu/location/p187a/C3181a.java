package com.baidu.location.p187a;

import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.indoor.C3439d;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3213a;
import com.baidu.location.p189b.C3229g;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p191d.C3286c;
import com.baidu.location.p191d.C3294d;
import com.baidu.location.p191d.C3299f;
import com.baidu.location.p191d.C3303h;
import com.baidu.location.p191d.C3314j;
import com.baidu.location.p191d.C3314j.C3310b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.LogFactory;

/* renamed from: com.baidu.location.a.a */
public class C3181a {
    /* renamed from: d */
    private static C3181a f17266d = null;
    /* renamed from: a */
    public boolean f17267a;
    /* renamed from: b */
    boolean f17268b;
    /* renamed from: c */
    int f17269c;
    /* renamed from: e */
    private ArrayList<C3179a> f17270e;
    /* renamed from: f */
    private boolean f17271f;
    /* renamed from: g */
    private BDLocation f17272g;
    /* renamed from: h */
    private BDLocation f17273h;
    /* renamed from: i */
    private BDLocation f17274i;
    /* renamed from: j */
    private BDLocation f17275j;
    /* renamed from: k */
    private boolean f17276k;
    /* renamed from: l */
    private boolean f17277l;
    /* renamed from: m */
    private C3180b f17278m;

    /* renamed from: com.baidu.location.a.a$a */
    private class C3179a {
        /* renamed from: a */
        public String f17258a = null;
        /* renamed from: b */
        public Messenger f17259b = null;
        /* renamed from: c */
        public LocationClientOption f17260c = new LocationClientOption();
        /* renamed from: d */
        public int f17261d = 0;
        /* renamed from: e */
        final /* synthetic */ C3181a f17262e;

        public C3179a(C3181a c3181a, Message message) {
            boolean z = true;
            this.f17262e = c3181a;
            this.f17259b = message.replyTo;
            this.f17258a = message.getData().getString("packName");
            this.f17260c.prodName = message.getData().getString("prodName");
            C3381b.m14398a().m14402a(this.f17260c.prodName, this.f17258a);
            this.f17260c.coorType = message.getData().getString("coorType");
            this.f17260c.addrType = message.getData().getString("addrType");
            this.f17260c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            boolean z2 = C3391g.f18385l || this.f17260c.enableSimulateGps;
            C3391g.f18385l = z2;
            if (!C3391g.f18380g.equals("all")) {
                C3391g.f18380g = this.f17260c.addrType;
            }
            this.f17260c.openGps = message.getData().getBoolean("openGPS");
            this.f17260c.scanSpan = message.getData().getInt("scanSpan");
            this.f17260c.timeOut = message.getData().getInt("timeOut");
            this.f17260c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY);
            this.f17260c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f17260c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f17260c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            z2 = C3391g.f18381h || message.getData().getBoolean("isneedaptag", false);
            C3391g.f18381h = z2;
            if (!(C3391g.f18382i || message.getData().getBoolean("isneedaptagd", false))) {
                z = false;
            }
            C3391g.f18382i = z;
            C3391g.f18364Q = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i < C3391g.ae) {
                C3391g.ae = i;
            }
            i = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i >= C3391g.f18369V) {
                C3391g.f18369V = i;
            }
            i = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i >= C3391g.f18371X) {
                C3391g.f18371X = i;
            }
            i = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i >= C3391g.f18370W) {
                C3391g.f18370W = i;
            }
            if (this.f17260c.scanSpan >= 1000) {
                C3229g.m13535a().m13543b();
            }
            if (this.f17260c.mIsNeedDeviceDirect || this.f17260c.isNeedAltitude) {
                C3202i.m13395a().m13400a(this.f17260c.mIsNeedDeviceDirect);
                C3202i.m13395a().m13402b(this.f17260c.isNeedAltitude);
                C3202i.m13395a().m13401b();
            }
            c3181a.f17268b |= this.f17260c.isNeedAltitude;
        }

        /* renamed from: a */
        private void m13255a(int i) {
            Message obtain = Message.obtain(null, i);
            try {
                if (this.f17259b != null) {
                    this.f17259b.send(obtain);
                }
                this.f17261d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f17261d++;
                }
            }
        }

        /* renamed from: a */
        private void m13256a(int i, Bundle bundle) {
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.f17259b != null) {
                    this.f17259b.send(obtain);
                }
                this.f17261d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f17261d++;
                }
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        private void m13257a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.f17259b != null) {
                    this.f17259b.send(obtain);
                }
                this.f17261d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f17261d++;
                }
            }
        }

        /* renamed from: a */
        public void m13260a() {
            m13255a(111);
        }

        /* renamed from: a */
        public void m13261a(BDLocation bDLocation) {
            m13262a(bDLocation, 21);
        }

        /* renamed from: a */
        public void m13262a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (C3439d.m14680a().m14744f()) {
                bDLocation2.setIndoorLocMode(true);
            }
            if (C3202i.m13395a().m13409h() && (bDLocation2.getLocType() == 161 || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(C3202i.m13395a().m13411j());
            }
            if (!(this.f17260c.coorType == null || this.f17260c.coorType.equals("gcj02"))) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                    double[] coorEncrypt;
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f17260c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType(this.f17260c.coorType);
                    } else if (!(bDLocation2.getCoorType() == null || !bDLocation2.getCoorType().equals("wgs84") || this.f17260c.coorType.equals("bd09ll"))) {
                        coorEncrypt = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        bDLocation2.setCoorType("wgs84mc");
                    }
                }
            }
            m13257a(i, "locStr", bDLocation2);
        }

        /* renamed from: b */
        public void m13263b() {
            if (!this.f17260c.location_change_notify) {
                return;
            }
            if (C3391g.f18375b) {
                m13255a(54);
            } else {
                m13255a(55);
            }
        }
    }

    /* renamed from: com.baidu.location.a.a$b */
    private class C3180b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3181a f17263a;
        /* renamed from: b */
        private int f17264b;
        /* renamed from: c */
        private boolean f17265c;

        public void run() {
            if (!this.f17265c) {
                this.f17264b++;
                this.f17263a.f17277l = false;
            }
        }
    }

    private C3181a() {
        this.f17270e = null;
        this.f17271f = false;
        this.f17267a = false;
        this.f17268b = false;
        this.f17272g = null;
        this.f17273h = null;
        this.f17274i = null;
        this.f17269c = 0;
        this.f17275j = null;
        this.f17276k = false;
        this.f17277l = false;
        this.f17278m = null;
        this.f17270e = new ArrayList();
    }

    /* renamed from: a */
    private C3179a m13264a(Messenger messenger) {
        if (this.f17270e == null) {
            return null;
        }
        Iterator it = this.f17270e.iterator();
        while (it.hasNext()) {
            C3179a c3179a = (C3179a) it.next();
            if (c3179a.f17259b.equals(messenger)) {
                return c3179a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C3181a m13265a() {
        if (f17266d == null) {
            f17266d = new C3181a();
        }
        return f17266d;
    }

    /* renamed from: a */
    private void m13266a(C3179a c3179a) {
        if (c3179a != null) {
            if (m13264a(c3179a.f17259b) != null) {
                c3179a.m13255a(14);
                return;
            }
            this.f17270e.add(c3179a);
            c3179a.m13255a(13);
        }
    }

    /* renamed from: h */
    private void m13268h() {
        m13269i();
        m13284g();
    }

    /* renamed from: i */
    private void m13269i() {
        boolean z = true;
        Iterator it = this.f17270e.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            C3179a c3179a = (C3179a) it.next();
            if (c3179a.f17260c.openGps) {
                z3 = true;
            }
            z2 = c3179a.f17260c.location_change_notify ? true : z2;
        }
        C3391g.f18374a = z2;
        if (this.f17271f != z3) {
            this.f17271f = z3;
            if (!C3294d.f17846f.equals("1") || this.f17267a || this.f17271f) {
                C3371d.m14289a().m14313a(this.f17271f);
                C3286c.m13744a().m13794a(true);
                return;
            }
            C3371d a = C3371d.m14289a();
            if (this.f17271f) {
                z = false;
            }
            a.m14313a(z);
            C3286c.m13744a().m13794a(false);
        }
    }

    /* renamed from: a */
    public void m13270a(Bundle bundle, int i) {
        Iterator it = this.f17270e.iterator();
        while (it.hasNext()) {
            try {
                C3179a c3179a = (C3179a) it.next();
                c3179a.m13256a(i, bundle);
                if (c3179a.f17261d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m13271a(Message message) {
        if (message != null && message.replyTo != null) {
            this.f17267a = true;
            C3376f.m14355a().m14367b();
            C3294d.m13799a().m13832b();
            m13266a(new C3179a(this, message));
            m13268h();
        }
    }

    /* renamed from: a */
    public void m13272a(BDLocation bDLocation) {
        m13276b(bDLocation);
    }

    /* renamed from: a */
    public void m13273a(String str) {
        m13277c(new BDLocation(str));
    }

    /* renamed from: b */
    public void m13274b() {
        this.f17270e.clear();
        this.f17272g = null;
        m13268h();
    }

    /* renamed from: b */
    public void m13275b(Message message) {
        C3179a a = m13264a(message.replyTo);
        if (a != null) {
            this.f17270e.remove(a);
        }
        C3229g.m13535a().m13544c();
        C3202i.m13395a().m13403c();
        m13268h();
    }

    /* renamed from: b */
    public void m13276b(BDLocation bDLocation) {
        if (bDLocation != null && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            C3314j.m13917b().m13933a(bDLocation.getLatitude(), bDLocation.getLongitude());
            C3243b.m13581a().m13591a(bDLocation);
        }
        if (C3439d.m14680a().m14745g() && bDLocation.getFloor() != null) {
            this.f17274i = null;
            this.f17274i = new BDLocation(bDLocation);
        }
        boolean z = C3200h.f17376h;
        if (z) {
            C3200h.f17376h = false;
        }
        if (C3391g.f18369V >= 10000 && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            if (this.f17272g != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(this.f17272g.getLatitude(), this.f17272g.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] > ((float) C3391g.f18371X) || z) {
                    this.f17272g = null;
                    this.f17272g = new BDLocation(bDLocation);
                } else {
                    return;
                }
            }
            this.f17272g = new BDLocation(bDLocation);
        }
        if (bDLocation != null) {
            C3299f.m13848a().m13870b("" + bDLocation.getLocType());
            C3299f.m13848a().m13868a("send location = " + bDLocation.getLocType() + " ; " + bDLocation.getLatitude() + " ; " + bDLocation.getLongitude() + " ; " + bDLocation.getRadius() + " ; " + bDLocation.getSpeed() + " ; " + bDLocation.getDirection());
        }
        Iterator it;
        if (bDLocation == null || bDLocation.getLocType() != 161 || C3196g.m13350a().m13352b()) {
            if (!bDLocation.hasAltitude() && this.f17268b && (bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
                double b = C3213a.m13466a().m13471b(bDLocation.getLongitude(), bDLocation.getLatitude());
                if (b != Double.MAX_VALUE) {
                    bDLocation.setAltitude(b);
                }
            }
            if (bDLocation.getLocType() == 61) {
                bDLocation.setGpsAccuracyStatus(C3213a.m13466a().m13469a(bDLocation));
            }
            it = this.f17270e.iterator();
            while (it.hasNext()) {
                try {
                    C3179a c3179a;
                    c3179a = (C3179a) it.next();
                    c3179a.m13261a(bDLocation);
                    if (c3179a.f17261d > 4) {
                        it.remove();
                    }
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        if (this.f17273h == null) {
            this.f17273h = new BDLocation();
            this.f17273h.setLocType(505);
        }
        it = this.f17270e.iterator();
        while (it.hasNext()) {
            try {
                c3179a = (C3179a) it.next();
                c3179a.m13261a(this.f17273h);
                if (c3179a.f17261d > 4) {
                    it.remove();
                }
            } catch (Exception e2) {
                return;
            }
        }
    }

    /* renamed from: c */
    public void m13277c(BDLocation bDLocation) {
        Address a = C3200h.m13362c().m13377a(bDLocation);
        String f = C3200h.m13362c().m13387f();
        List g = C3200h.m13362c().m13388g();
        if (a != null) {
            bDLocation.setAddr(a);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        if (C3439d.m14680a().m14745g() && C3439d.m14680a().m14746h() != null) {
            bDLocation.setFloor(C3439d.m14680a().m14746h());
            bDLocation.setIndoorLocMode(true);
            if (C3439d.m14680a().m14747i() != null) {
                bDLocation.setBuildingID(C3439d.m14680a().m14747i());
            }
        }
        C3303h.m13894a().m13902b();
        C3299f.m13848a().m13868a("gps notify!");
        C3200h.m13362c().m13385d(bDLocation);
        m13272a(bDLocation);
    }

    /* renamed from: c */
    public boolean m13278c() {
        return this.f17267a;
    }

    /* renamed from: c */
    public boolean m13279c(Message message) {
        boolean z = true;
        C3179a a = m13264a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.f17260c.scanSpan;
        a.f17260c.scanSpan = message.getData().getInt("scanSpan", a.f17260c.scanSpan);
        C3299f.m13848a().m13868a("change option = " + a.f17260c.scanSpan);
        if (a.f17260c.scanSpan < 1000) {
            C3229g.m13535a().m13546e();
            C3202i.m13395a().m13403c();
            this.f17267a = false;
            C3314j.m13917b().m13934a(C3310b.NET_BACK);
            C3303h.m13894a().m13903c();
            C3299f.m13848a().m13868a("scanspan < 1000");
            C3299f.m13848a().m13873d();
            C3294d.m13799a().m13833c();
            C3376f.m14355a().m14367b();
        } else {
            C3229g.m13535a().m13545d();
            C3314j.m13917b().m13934a(C3310b.NET_FRONT);
            C3200h.m13362c().m13380a(false, false);
            C3299f.m13848a().m13868a("request offline location!");
            C3299f.m13848a().m13868a("scanspan >= 1000");
            C3294d.m13799a().m13832b();
            this.f17267a = true;
        }
        if (a.f17260c.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else {
            if (a.f17260c.mIsNeedDeviceDirect || a.f17260c.isNeedAltitude) {
                C3202i.m13395a().m13400a(a.f17260c.mIsNeedDeviceDirect);
                C3202i.m13395a().m13402b(a.f17260c.isNeedAltitude);
                C3202i.m13395a().m13401b();
            }
            this.f17268b |= a.f17260c.isNeedAltitude;
        }
        a.f17260c.openGps = message.getData().getBoolean("openGPS", a.f17260c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.f17260c;
        if (string == null || string.equals("")) {
            string = a.f17260c.coorType;
        }
        locationClientOption.coorType = string;
        string = message.getData().getString("addrType");
        locationClientOption = a.f17260c;
        if (string == null || string.equals("")) {
            string = a.f17260c.addrType;
        }
        locationClientOption.addrType = string;
        if (!C3391g.f18380g.equals(a.f17260c.addrType)) {
            C3200h.m13362c().m13392k();
        }
        a.f17260c.timeOut = message.getData().getInt("timeOut", a.f17260c.timeOut);
        a.f17260c.location_change_notify = message.getData().getBoolean("location_change_notify", a.f17260c.location_change_notify);
        a.f17260c.priority = message.getData().getInt(LogFactory.PRIORITY_KEY, a.f17260c.priority);
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < C3391g.ae) {
            C3391g.ae = i2;
        }
        m13268h();
        return z;
    }

    /* renamed from: d */
    public int m13280d(Message message) {
        if (message == null || message.replyTo == null) {
            return 1;
        }
        C3179a a = m13264a(message.replyTo);
        return (a == null || a.f17260c == null) ? 1 : a.f17260c.priority;
    }

    /* renamed from: d */
    public void m13281d() {
        if (this.f17274i != null) {
            m13272a(this.f17274i);
        }
    }

    /* renamed from: e */
    public void m13282e() {
        Iterator it = this.f17270e.iterator();
        while (it.hasNext()) {
            ((C3179a) it.next()).m13260a();
        }
    }

    /* renamed from: f */
    public String m13283f() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f17270e.isEmpty()) {
            return "&prod=" + C3381b.f18312e + Config.TRACE_TODAY_VISIT_SPLIT + C3381b.f18311d;
        }
        C3179a c3179a = (C3179a) this.f17270e.get(0);
        if (c3179a.f17260c.prodName != null) {
            stringBuffer.append(c3179a.f17260c.prodName);
        }
        if (c3179a.f17258a != null) {
            stringBuffer.append(Config.TRACE_TODAY_VISIT_SPLIT);
            stringBuffer.append(c3179a.f17258a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        return (stringBuffer2 == null || stringBuffer2.equals("")) ? null : "&prod=" + stringBuffer2;
    }

    /* renamed from: g */
    public void m13284g() {
        Iterator it = this.f17270e.iterator();
        while (it.hasNext()) {
            ((C3179a) it.next()).m13263b();
        }
    }
}
