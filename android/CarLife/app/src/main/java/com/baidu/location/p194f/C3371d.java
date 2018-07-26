package com.baidu.location.p194f;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GnssStatus.Callback;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.indoor.C3439d;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3190d;
import com.baidu.location.p187a.C3208k;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3385d;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3220d;
import com.baidu.location.p191d.C3286c;
import com.baidu.location.p191d.C3294d;
import com.baidu.location.p191d.C3301g;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.f.d */
public class C3371d {
    /* renamed from: c */
    private static C3371d f18244c = null;
    /* renamed from: m */
    private static int f18245m = 0;
    /* renamed from: n */
    private static int f18246n = 0;
    /* renamed from: u */
    private static String f18247u = null;
    /* renamed from: A */
    private int f18248A;
    /* renamed from: B */
    private int f18249B;
    /* renamed from: C */
    private HashMap<Integer, List<GpsSatellite>> f18250C;
    /* renamed from: D */
    private double f18251D = 100.0d;
    /* renamed from: E */
    private long f18252E = 0;
    /* renamed from: a */
    private final long f18253a = 1000;
    /* renamed from: b */
    private final long f18254b = 9000;
    /* renamed from: d */
    private Context f18255d;
    /* renamed from: e */
    private LocationManager f18256e = null;
    /* renamed from: f */
    private Location f18257f;
    /* renamed from: g */
    private C3369c f18258g = null;
    /* renamed from: h */
    private C3370d f18259h = null;
    /* renamed from: i */
    private GpsStatus f18260i;
    /* renamed from: j */
    private C3367a f18261j;
    /* renamed from: k */
    private boolean f18262k = false;
    /* renamed from: l */
    private C3368b f18263l = null;
    /* renamed from: o */
    private long f18264o = 0;
    /* renamed from: p */
    private boolean f18265p = false;
    /* renamed from: q */
    private boolean f18266q = false;
    /* renamed from: r */
    private String f18267r = null;
    /* renamed from: s */
    private boolean f18268s = false;
    /* renamed from: t */
    private long f18269t = 0;
    /* renamed from: v */
    private Handler f18270v = null;
    /* renamed from: w */
    private final int f18271w = 1;
    /* renamed from: x */
    private final int f18272x = 2;
    /* renamed from: y */
    private final int f18273y = 3;
    /* renamed from: z */
    private final int f18274z = 4;

    /* renamed from: com.baidu.location.f.d$1 */
    class C33661 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3371d f18229a;

        C33661(C3371d c3371d) {
            this.f18229a = c3371d;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 1:
                        this.f18229a.m14312e((Location) message.obj);
                        return;
                    case 3:
                        this.f18229a.m14296a("&og=1", (Location) message.obj);
                        return;
                    case 4:
                        this.f18229a.m14296a("&og=2", (Location) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.f.d$a */
    private class C3367a extends Callback {
        /* renamed from: a */
        final /* synthetic */ C3371d f18230a;

        private C3367a(C3371d c3371d) {
            this.f18230a = c3371d;
        }

        public void onFirstFix(int i) {
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int i = 0;
            if (this.f18230a.f18256e != null) {
                int satelliteCount = gnssStatus.getSatelliteCount();
                int i2 = 0;
                for (int i3 = 0; i3 < satelliteCount; i3++) {
                    if (gnssStatus.usedInFix(i3)) {
                        i2++;
                        if (gnssStatus.getConstellationType(i3) == 1) {
                            i++;
                        }
                    }
                }
                C3371d.f18245m = i2;
                C3371d.f18246n = i;
            }
        }

        public void onStarted() {
        }

        public void onStopped() {
            this.f18230a.m14310d(null);
            this.f18230a.m14305b(false);
            C3371d.f18245m = 0;
        }
    }

    /* renamed from: com.baidu.location.f.d$b */
    private class C3368b implements Listener {
        /* renamed from: a */
        long f18231a;
        /* renamed from: b */
        final /* synthetic */ C3371d f18232b;
        /* renamed from: c */
        private long f18233c;
        /* renamed from: d */
        private final int f18234d;
        /* renamed from: e */
        private boolean f18235e;
        /* renamed from: f */
        private List<String> f18236f;
        /* renamed from: g */
        private String f18237g;
        /* renamed from: h */
        private String f18238h;
        /* renamed from: i */
        private String f18239i;
        /* renamed from: j */
        private long f18240j;

        private C3368b(C3371d c3371d) {
            this.f18232b = c3371d;
            this.f18231a = 0;
            this.f18233c = 0;
            this.f18234d = 400;
            this.f18235e = false;
            this.f18236f = new ArrayList();
            this.f18237g = null;
            this.f18238h = null;
            this.f18239i = null;
            this.f18240j = 0;
        }

        public void onGpsStatusChanged(int i) {
            if (this.f18232b.f18256e != null) {
                switch (i) {
                    case 2:
                        this.f18232b.m14310d(null);
                        this.f18232b.m14305b(false);
                        C3371d.f18245m = 0;
                        return;
                    case 4:
                        if (this.f18232b.f18266q) {
                            try {
                                if (this.f18232b.f18260i == null) {
                                    this.f18232b.f18260i = this.f18232b.f18256e.getGpsStatus(null);
                                } else {
                                    this.f18232b.f18256e.getGpsStatus(this.f18232b.f18260i);
                                }
                                this.f18232b.f18248A = 0;
                                this.f18232b.f18249B = 0;
                                this.f18232b.f18250C = new HashMap();
                                int i2 = 0;
                                double d = 0.0d;
                                int i3 = false;
                                for (GpsSatellite gpsSatellite : this.f18232b.f18260i.getSatellites()) {
                                    if (gpsSatellite.usedInFix()) {
                                        i2++;
                                        d += (double) gpsSatellite.getSnr();
                                        if (gpsSatellite.getPrn() <= 65) {
                                            i3++;
                                        }
                                        if (gpsSatellite.getSnr() >= ((float) C3391g.f18354G)) {
                                            this.f18232b.f18249B = this.f18232b.f18249B + 1;
                                        }
                                    }
                                }
                                if (i3 > 0) {
                                    C3371d.f18246n = i3;
                                }
                                if (i2 > 0) {
                                    this.f18240j = System.currentTimeMillis();
                                    this.f18232b.f18251D = d / ((double) i2);
                                    C3371d.f18245m = i2;
                                    return;
                                } else if (System.currentTimeMillis() - this.f18240j > 100) {
                                    this.f18240j = System.currentTimeMillis();
                                    C3371d.f18245m = i2;
                                    return;
                                } else {
                                    return;
                                }
                            } catch (Exception e) {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.f.d$c */
    private class C3369c implements LocationListener {
        /* renamed from: a */
        final /* synthetic */ C3371d f18241a;

        private C3369c(C3371d c3371d) {
            this.f18241a = c3371d;
        }

        public void onLocationChanged(Location location) {
            this.f18241a.f18269t = System.currentTimeMillis();
            this.f18241a.m14305b(true);
            this.f18241a.m14310d(location);
            this.f18241a.f18265p = false;
        }

        public void onProviderDisabled(String str) {
            this.f18241a.m14310d(null);
            this.f18241a.m14305b(false);
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    this.f18241a.m14310d(null);
                    this.f18241a.m14305b(false);
                    return;
                case 1:
                    this.f18241a.f18264o = System.currentTimeMillis();
                    this.f18241a.f18265p = true;
                    this.f18241a.m14305b(false);
                    return;
                case 2:
                    this.f18241a.f18265p = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.f.d$d */
    private class C3370d implements LocationListener {
        /* renamed from: a */
        final /* synthetic */ C3371d f18242a;
        /* renamed from: b */
        private long f18243b;

        private C3370d(C3371d c3371d) {
            this.f18242a = c3371d;
            this.f18243b = 0;
        }

        public void onLocationChanged(Location location) {
            if (!this.f18242a.f18266q && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.f18243b >= BNOffScreenParams.MIN_ENTER_INTERVAL && C3211m.m13449a(location, false)) {
                this.f18243b = System.currentTimeMillis();
                this.f18242a.f18270v.sendMessage(this.f18242a.f18270v.obtainMessage(4, location));
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private C3371d() {
        if (VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.f18262k = true;
            } catch (ClassNotFoundException e) {
                this.f18262k = false;
            }
        }
    }

    /* renamed from: a */
    public static synchronized C3371d m14289a() {
        C3371d c3371d;
        synchronized (C3371d.class) {
            if (f18244c == null) {
                f18244c = new C3371d();
            }
            c3371d = f18244c;
        }
        return c3371d;
    }

    /* renamed from: a */
    public static String m14290a(Location location) {
        float f = -1.0f;
        if (location == null) {
            return null;
        }
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        if (location.hasBearing()) {
            f = location.getBearing();
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d", new Object[]{Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(f), Integer.valueOf(accuracy), Integer.valueOf(f18245m), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f18245m), Integer.valueOf(f18246n)});
    }

    /* renamed from: a */
    private void m14292a(double d, double d2, float f) {
        int i = 0;
        if (C3220d.m13499a().f17524f) {
            if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
                int i2 = (int) ((d - C3391g.f18392s) * 1000.0d);
                int i3 = (int) ((C3391g.f18393t - d2) * 1000.0d);
                if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                    String str = String.format(Locale.CHINA, "&ll=%.5f|%.5f", new Object[]{Double.valueOf(d), Double.valueOf(d2)}) + "&im=" + C3381b.m14398a().m14404c();
                    C3391g.f18390q = d;
                    C3391g.f18391r = d2;
                    C3220d.m13499a().m13514a(str);
                } else {
                    i2 += i3 * 50;
                    i3 = i2 >> 2;
                    i2 &= 3;
                    if (C3391g.f18396w) {
                        i = (C3391g.f18395v[i3] >> (i2 * 2)) & 3;
                    }
                }
            }
            if (C3391g.f18394u != i) {
                C3391g.f18394u = i;
            }
        }
    }

    /* renamed from: a */
    private void m14296a(String str, Location location) {
        if (location != null) {
            String str2 = str + C3181a.m13265a().m13283f();
            boolean f = C3376f.m14355a().m14371f();
            C3208k.m13431a(new C3362a(C3364b.m14262a().m14280f()));
            C3208k.m13429a(System.currentTimeMillis());
            C3208k.m13430a(new Location(location));
            C3208k.m13432a(str2);
            if (!f) {
                C3211m.m13444a(C3208k.m13434c(), null, C3208k.m13435d(), str2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m14297a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && ((C3391g.f18394u == 3 || !C3385d.m14425a().m14427a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > C3391g.f18358K ? distanceTo > C3391g.f18360M : speed > C3391g.f18357J ? distanceTo > C3391g.f18359L : distanceTo > 5.0f;
    }

    /* renamed from: b */
    public static String m14303b(Location location) {
        String a = C3371d.m14290a(location);
        return a != null ? a + "&g_tp=0" : a;
    }

    /* renamed from: b */
    private void m14305b(boolean z) {
        this.f18268s = z;
        if (!z || !m14325m()) {
        }
    }

    /* renamed from: c */
    public static String m14308c(Location location) {
        String a = C3371d.m14290a(location);
        return a != null ? a + f18247u : a;
    }

    /* renamed from: d */
    private void m14310d(Location location) {
        this.f18270v.sendMessage(this.f18270v.obtainMessage(1, location));
    }

    /* renamed from: e */
    private void m14312e(Location location) {
        if (location != null) {
            int i = f18245m;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt(UpdateLocationDataStruct.KEY_SATELLITES);
                } catch (Exception e) {
                }
            }
            if (i != 0 || C3391g.f18385l) {
                Location location2;
                if (C3301g.m13879a().m13887c().m13966b() == 0) {
                    C3301g.m13879a().m13887c().m13974f(System.currentTimeMillis());
                    C3301g.m13879a().m13889e();
                }
                this.f18257f = location;
                i = f18245m;
                if (this.f18257f == null) {
                    this.f18267r = null;
                    location2 = null;
                } else {
                    Location location3 = new Location(this.f18257f);
                    this.f18257f.setTime(System.currentTimeMillis());
                    float speed = (float) (((double) this.f18257f.getSpeed()) * 3.6d);
                    if (!this.f18257f.hasSpeed()) {
                        speed = -1.0f;
                    }
                    if (i == 0) {
                        try {
                            i = this.f18257f.getExtras().getInt(UpdateLocationDataStruct.KEY_SATELLITES);
                        } catch (Exception e2) {
                        }
                    }
                    this.f18267r = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[]{Double.valueOf(this.f18257f.getLongitude()), Double.valueOf(this.f18257f.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f18257f.getBearing()), Integer.valueOf(i), Long.valueOf(r2)});
                    m14292a(this.f18257f.getLongitude(), this.f18257f.getLatitude(), speed);
                    location2 = location3;
                }
                try {
                    C3190d.m13315a().m13323a(this.f18257f);
                } catch (Exception e3) {
                }
                if (location2 != null) {
                    try {
                        C3294d.m13799a().m13830a(location2, f18245m);
                    } catch (Exception e4) {
                    }
                }
                if (m14325m() && this.f18257f != null) {
                    if (!C3439d.m14680a().m14745g() || C3439d.m14680a().m14739a(this.f18257f)) {
                        if (C3439d.m14680a().m14745g()) {
                            C3181a.m13265a().m13273a(m14322j());
                        } else if (location2 != null) {
                            try {
                                C3286c.m13744a().m13793a(location2, f18246n, this.f18251D);
                            } catch (Exception e5) {
                            }
                        } else {
                            C3181a.m13265a().m13273a(m14322j());
                        }
                    } else if (location2 != null) {
                        try {
                            C3286c.m13744a().m13793a(location2, f18246n, this.f18251D);
                        } catch (Exception e6) {
                        }
                    } else {
                        C3181a.m13265a().m13273a(m14322j());
                    }
                    if (f18245m > 2 && C3211m.m13449a(this.f18257f, true)) {
                        boolean f = C3376f.m14355a().m14371f();
                        C3208k.m13431a(new C3362a(C3364b.m14262a().m14280f()));
                        C3208k.m13429a(System.currentTimeMillis());
                        C3208k.m13430a(new Location(this.f18257f));
                        C3208k.m13432a(C3181a.m13265a().m13283f());
                        if (!f) {
                            C3211m.m13444a(C3208k.m13434c(), null, C3208k.m13435d(), C3181a.m13265a().m13283f());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f18257f = null;
    }

    /* renamed from: a */
    public void m14313a(boolean z) {
        if (z) {
            m14315c();
        } else {
            m14317e();
        }
    }

    /* renamed from: b */
    public synchronized void m14314b() {
        if (C3377f.isServing) {
            this.f18255d = C3377f.getServiceContext();
            try {
                this.f18256e = (LocationManager) this.f18255d.getSystemService("location");
                if (this.f18262k) {
                    this.f18261j = new C3367a();
                    this.f18256e.registerGnssStatusCallback(this.f18261j);
                } else {
                    this.f18263l = new C3368b();
                    this.f18256e.addGpsStatusListener(this.f18263l);
                }
                this.f18259h = new C3370d();
                this.f18256e.requestLocationUpdates("passive", 9000, 0.0f, this.f18259h);
            } catch (Exception e) {
            }
            this.f18270v = new C33661(this);
        }
    }

    /* renamed from: c */
    public void m14315c() {
        Log.d(C3380a.f18302a, "start gps...");
        if (!this.f18266q) {
            try {
                this.f18258g = new C3369c();
                try {
                    this.f18256e.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                } catch (Exception e) {
                }
                this.f18256e.requestLocationUpdates("gps", 1000, 0.0f, this.f18258g);
                this.f18252E = System.currentTimeMillis();
                C3301g.m13879a().m13887c().m13973e(System.currentTimeMillis());
                this.f18266q = true;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: d */
    public boolean m14316d() {
        return Math.abs(System.currentTimeMillis() - this.f18252E) < 1700;
    }

    /* renamed from: e */
    public void m14317e() {
        if (this.f18266q) {
            if (this.f18256e != null) {
                try {
                    if (this.f18258g != null) {
                        this.f18256e.removeUpdates(this.f18258g);
                        C3301g.m13879a().m13887c().m13962a();
                    }
                } catch (Exception e) {
                }
            }
            C3391g.f18377d = 0;
            C3391g.f18394u = 0;
            this.f18258g = null;
            this.f18266q = false;
            m14305b(false);
        }
    }

    /* renamed from: f */
    public synchronized void m14318f() {
        m14317e();
        if (this.f18256e != null) {
            try {
                if (this.f18263l != null) {
                    this.f18256e.removeGpsStatusListener(this.f18263l);
                }
                if (this.f18262k && this.f18261j != null) {
                    this.f18256e.unregisterGnssStatusCallback(this.f18261j);
                }
                this.f18256e.removeUpdates(this.f18259h);
            } catch (Exception e) {
            }
            this.f18263l = null;
            this.f18256e = null;
        }
    }

    /* renamed from: g */
    public boolean m14319g() {
        return this.f18266q;
    }

    /* renamed from: h */
    public String m14320h() {
        return (!m14325m() || this.f18257f == null) ? null : C3371d.m14290a(this.f18257f);
    }

    /* renamed from: i */
    public String m14321i() {
        if (!m14325m() || this.f18257f == null) {
            return null;
        }
        String replaceAll = C3371d.m14290a(this.f18257f).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids=");
        return String.format("%s&idgps_tp=%s", new Object[]{replaceAll, this.f18257f.getProvider()});
    }

    /* renamed from: j */
    public String m14322j() {
        if (this.f18257f == null) {
            return null;
        }
        double[] dArr;
        int i;
        String str = "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.f18257f.hasAccuracy() ? this.f18257f.getAccuracy() : 10.0f);
        float speed = (float) (((double) this.f18257f.getSpeed()) * 3.6d);
        if (!this.f18257f.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr2 = new double[2];
        if (C3385d.m14425a().m14427a(this.f18257f.getLongitude(), this.f18257f.getLatitude())) {
            dArr2 = Jni.coorEncrypt(this.f18257f.getLongitude(), this.f18257f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr2[0] > 0.0d || dArr2[1] > 0.0d) {
                dArr = dArr2;
                i = 1;
            } else {
                dArr2[0] = this.f18257f.getLongitude();
                dArr2[1] = this.f18257f.getLatitude();
                dArr = dArr2;
                i = 1;
            }
        } else {
            dArr2[0] = this.f18257f.getLongitude();
            dArr2[1] = this.f18257f.getLatitude();
            dArr = dArr2;
            i = 0;
        }
        String format = String.format(Locale.CHINA, str, new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.f18257f.getBearing()), Float.valueOf(speed), Integer.valueOf(f18245m)});
        if (i == 0) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!this.f18257f.hasAltitude()) {
            return format + "}}";
        }
        return format + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[]{Double.valueOf(this.f18257f.getAltitude())});
    }

    /* renamed from: k */
    public Location m14323k() {
        return (this.f18257f != null && Math.abs(System.currentTimeMillis() - this.f18257f.getTime()) <= 60000) ? this.f18257f : null;
    }

    /* renamed from: l */
    public boolean m14324l() {
        try {
            return (this.f18257f == null || this.f18257f.getLatitude() == 0.0d || this.f18257f.getLongitude() == 0.0d || (f18245m <= 2 && this.f18257f.getExtras().getInt(UpdateLocationDataStruct.KEY_SATELLITES, 3) <= 2)) ? false : true;
        } catch (Exception e) {
            return (this.f18257f == null || this.f18257f.getLatitude() == 0.0d || this.f18257f.getLongitude() == 0.0d) ? false : true;
        }
    }

    /* renamed from: m */
    public boolean m14325m() {
        if (!m14324l() || System.currentTimeMillis() - this.f18269t > BNOffScreenParams.MIN_ENTER_INTERVAL) {
            return false;
        }
        return (!this.f18265p || System.currentTimeMillis() - this.f18264o >= 3000) ? this.f18268s : true;
    }
}
