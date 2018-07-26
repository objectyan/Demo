package com.baidu.location.p191d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.n */
public class C3330n {
    /* renamed from: j */
    private static final Charset f18026j = Charset.forName("UTF-8");
    /* renamed from: a */
    public Handler f18027a;
    /* renamed from: b */
    private Context f18028b;
    /* renamed from: c */
    private final long f18029c;
    /* renamed from: d */
    private long f18030d;
    /* renamed from: e */
    private C3329h f18031e;
    /* renamed from: f */
    private C3324c f18032f;
    /* renamed from: g */
    private boolean f18033g;
    /* renamed from: h */
    private HandlerThread f18034h;
    /* renamed from: i */
    private Looper f18035i;
    /* renamed from: k */
    private LocationManager f18036k;
    /* renamed from: l */
    private C3325d f18037l;
    /* renamed from: m */
    private long f18038m;
    /* renamed from: n */
    private long f18039n;
    /* renamed from: o */
    private boolean f18040o;
    /* renamed from: p */
    private long f18041p;
    /* renamed from: q */
    private boolean f18042q;
    /* renamed from: r */
    private C3326e f18043r;

    /* renamed from: com.baidu.location.d.n$a */
    private class C3322a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3330n f18008a;
        /* renamed from: b */
        private String f18009b = null;
        /* renamed from: c */
        private String f18010c = null;
        /* renamed from: d */
        private String f18011d = null;
        /* renamed from: e */
        private String f18012e = null;

        public C3322a(C3330n c3330n, String str, String str2) {
            this.f18008a = c3330n;
            this.f18009b = C3330n.m14021b(str);
            this.f18010c = str2;
            this.f18011d = C3330n.m14021b(C3381b.m14398a().f18316a);
            this.f18012e = C3330n.m14021b(C3381b.m14398a().f18317b);
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = "http://itsdata.map.baidu.com/gps-wifi-collect/data_collect.php";
            this.k.put("type", C3330n.m14021b(this.f18010c));
            this.k.put("im", this.f18011d);
            this.k.put("cu", this.f18012e);
            if (this.f18010c.contains("gps")) {
                this.k.put("gps", this.f18009b);
            }
            if (this.f18010c.contains(C1981b.f6365e)) {
                this.k.put("wfh", this.f18009b);
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
        }

        /* renamed from: b */
        public void mo2500b() {
            m13301i();
        }
    }

    /* renamed from: com.baidu.location.d.n$b */
    private class C3323b extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3330n f18013a;
        /* renamed from: b */
        private String f18014b = null;
        /* renamed from: c */
        private String f18015c = null;
        /* renamed from: d */
        private String f18016d = null;
        /* renamed from: e */
        private String f18017e = null;

        public C3323b(C3330n c3330n, double d, double d2) {
            this.f18013a = c3330n;
            double d3 = ((double) ((int) (d2 * 1000000.0d))) / 1000000.0d;
            this.f18014b = String.valueOf(((double) ((int) (d * 1000000.0d))) / 1000000.0d);
            this.f18015c = String.valueOf(d3);
            this.f18016d = "1";
            this.f18017e = C3381b.m14398a().f18317b;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = "https://loc.map.baidu.com/cfgs/loc/gps";
            this.k.put("qt", "gps_pc");
            this.k.put("cuid", this.f18017e);
            this.k.put("suit", this.f18016d);
            this.k.put("x", this.f18015c);
            this.k.put("y", this.f18014b);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("gps_pc")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("gps_pc");
                        if (jSONObject2.has("enable")) {
                            if (jSONObject2.getInt("enable") == 0) {
                                this.f18013a.f18040o = false;
                            } else {
                                this.f18013a.f18040o = true;
                            }
                        }
                        if (jSONObject2.has("collect_freq_sec")) {
                            this.f18013a.f18038m = jSONObject2.getLong("collect_freq_sec");
                        }
                        if (jSONObject2.has("pingback_freq_sec")) {
                            this.f18013a.f18039n = jSONObject2.getLong("pingback_freq_sec") * 1000;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: b */
        public void mo2500b() {
            m13299c("https://loc.map.baidu.com/cfgs/loc/gps");
        }
    }

    /* renamed from: com.baidu.location.d.n$c */
    private class C3324c {
        /* renamed from: a */
        final /* synthetic */ C3330n f18018a;
        /* renamed from: b */
        private final ArrayDeque<Location> f18019b;

        private C3324c(C3330n c3330n) {
            this.f18018a = c3330n;
            this.f18019b = new ArrayDeque();
        }

        /* renamed from: a */
        private long m13981a() {
            return this.f18019b.size() == 0 ? 0 : ((Location) this.f18019b.getLast()).getTime();
        }

        /* renamed from: a */
        private void m13983a(Location location) {
            if (this.f18019b.size() >= 20) {
                this.f18019b.removeFirst();
            }
            this.f18019b.addLast(location);
        }

        /* renamed from: b */
        private void m13985b() {
            this.f18019b.clear();
        }

        /* renamed from: c */
        private boolean m13987c() {
            return this.f18019b.size() == 0;
        }

        /* renamed from: d */
        private boolean m13989d() {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = this.f18019b.iterator();
            while (it.hasNext()) {
                if (Math.abs(((Location) it.next()).getTime() - currentTimeMillis) < 300000) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: e */
        private int m13991e() {
            return this.f18019b.size();
        }

        /* renamed from: f */
        private String m13994f() {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = this.f18019b.iterator();
            String str = null;
            long j = 0;
            Object obj = 1;
            while (it.hasNext()) {
                Location location = (Location) it.next();
                if (Math.abs(location.getTime() - currentTimeMillis) <= 300000) {
                    String str2;
                    long time;
                    Object obj2;
                    String str3;
                    double longitude = ((double) ((int) (location.getLongitude() * 1000000.0d))) / 1000000.0d;
                    double latitude = ((double) ((int) (location.getLatitude() * 1000000.0d))) / 1000000.0d;
                    String a = this.f18018a.m14009a(location.getSpeed());
                    String a2 = this.f18018a.m14009a(location.getBearing());
                    if (obj != null) {
                        str2 = String.valueOf(longitude) + "|" + String.valueOf(latitude) + "|" + a + "|" + a2 + "|" + String.valueOf(location.getTime() / 1000);
                        time = location.getTime() / 1000;
                    } else {
                        str2 = String.valueOf(longitude) + "|" + String.valueOf(latitude) + "|" + a + "|" + a2 + "|" + String.valueOf((location.getTime() / 1000) - j);
                        time = location.getTime() / 1000;
                    }
                    if (obj != null) {
                        obj2 = null;
                        str3 = str2;
                    } else {
                        Object obj3 = obj;
                        str3 = str + ";" + str2;
                        obj2 = obj3;
                    }
                    j = time;
                    str = str3;
                    obj = obj2;
                }
            }
            return str;
        }
    }

    /* renamed from: com.baidu.location.d.n$d */
    private class C3325d implements LocationListener {
        /* renamed from: a */
        final /* synthetic */ C3330n f18020a;

        private C3325d(C3330n c3330n) {
            this.f18020a = c3330n;
        }

        public void onLocationChanged(Location location) {
            if (this.f18020a.f18033g && location != null && location.getProvider().contains("gps")) {
                Message obtainMessage = this.f18020a.f18027a.obtainMessage(51);
                Bundle bundle = new Bundle();
                bundle.putParcelable("traffic_gps", location);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: com.baidu.location.d.n$e */
    private class C3326e implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3330n f18021a;

        private C3326e(C3330n c3330n) {
            this.f18021a = c3330n;
        }

        public void run() {
            if (this.f18021a.f18027a != null && this.f18021a.f18042q) {
                this.f18021a.f18042q = false;
                try {
                    this.f18021a.f18027a.sendEmptyMessage(0);
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.n$f */
    private static class C3327f {
        /* renamed from: a */
        public static final C3330n f18022a = new C3330n();
    }

    /* renamed from: com.baidu.location.d.n$g */
    private class C3328g extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3330n f18023a;

        public C3328g(C3330n c3330n, Looper looper) {
            this.f18023a = c3330n;
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (C3377f.isServing) {
                String a;
                switch (message.what) {
                    case 0:
                        try {
                            this.f18023a.m14026d();
                            return;
                        } catch (Exception e) {
                            return;
                        } finally {
                            this.f18023a.m14028e();
                        }
                    case 1:
                        if (this.f18023a.f18040o && !this.f18023a.m14019a(C3381b.f18311d, C3377f.getServiceContext())) {
                            a = this.f18023a.f18032f.m13994f();
                            if (a != null) {
                                new C3322a(this.f18023a, a, "collect_gps").mo2500b();
                                this.f18023a.f18032f.m13985b();
                                return;
                            }
                            return;
                        }
                        return;
                    case 41:
                        this.f18023a.m14015a(new C3372e(C3376f.m14355a().m14380p()));
                        if (this.f18023a.m14019a(C3381b.f18311d, C3377f.getServiceContext()) || !this.f18023a.f18031e.m14004d() || !C3218c.m13487a().m13494e()) {
                            return;
                        }
                        if (this.f18023a.f18032f.m13987c() || this.f18023a.f18032f.m13989d()) {
                            a = this.f18023a.f18031e.m14006e();
                            if (a != null) {
                                new C3322a(this.f18023a, a, "collect_wifi").mo2500b();
                                this.f18023a.f18031e.m14001c();
                                return;
                            }
                            return;
                        }
                        return;
                    case 51:
                        Location location = (Location) message.getData().getParcelable("traffic_gps");
                        if (Math.abs(System.currentTimeMillis() - this.f18023a.f18041p) / 3600000 > 12) {
                            new C3323b(this.f18023a, location.getLatitude(), location.getLongitude()).mo2500b();
                            this.f18023a.f18041p = System.currentTimeMillis();
                        }
                        if (this.f18023a.f18040o) {
                            this.f18023a.m14012a(location);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.n$h */
    private class C3329h {
        /* renamed from: a */
        final /* synthetic */ C3330n f18024a;
        /* renamed from: b */
        private final ArrayDeque<C3372e> f18025b;

        private C3329h(C3330n c3330n) {
            this.f18024a = c3330n;
            this.f18025b = new ArrayDeque();
        }

        /* renamed from: a */
        private long m13995a() {
            return this.f18025b.size() == 0 ? 0 : ((C3372e) this.f18025b.getLast()).m14348h();
        }

        /* renamed from: a */
        private void m13997a(C3372e c3372e) {
            if (this.f18025b.size() >= 10) {
                this.f18025b.removeFirst();
            }
            this.f18025b.addLast(c3372e);
        }

        /* renamed from: b */
        private C3372e m13999b() {
            return this.f18025b.size() == 0 ? null : (C3372e) this.f18025b.getLast();
        }

        /* renamed from: c */
        private void m14001c() {
            this.f18025b.clear();
        }

        /* renamed from: d */
        private boolean m14004d() {
            return this.f18025b.size() == 10;
        }

        /* renamed from: e */
        private String m14006e() {
            Object obj = 1;
            Iterator it = this.f18025b.iterator();
            String str = null;
            while (it.hasNext()) {
                String d;
                Object obj2;
                C3372e c3372e = (C3372e) it.next();
                if (obj != null) {
                    d = c3372e.m14342d(5);
                    obj2 = null;
                } else {
                    Object obj3 = obj;
                    d = str + "@" + c3372e.m14342d(5);
                    obj2 = obj3;
                }
                str = d;
                obj = obj2;
            }
            return str;
        }
    }

    private C3330n() {
        this.f18028b = null;
        this.f18029c = 300000;
        this.f18030d = 300000;
        this.f18031e = null;
        this.f18032f = null;
        this.f18033g = false;
        this.f18034h = null;
        this.f18027a = null;
        this.f18035i = null;
        this.f18036k = null;
        this.f18037l = null;
        this.f18038m = 15;
        this.f18039n = 300000;
        this.f18040o = false;
        this.f18041p = 0;
        this.f18042q = false;
        this.f18043r = null;
        Log.i("TrafficCollectMan", "TrafficCollectMan object create");
        this.f18031e = new C3329h();
        this.f18032f = new C3324c();
        this.f18028b = C3377f.getServiceContext();
        this.f18034h = new HandlerThread("TrafficCollectHandlerThread", 10);
        this.f18034h.start();
        this.f18035i = this.f18034h.getLooper();
        this.f18027a = new C3328g(this, this.f18035i);
    }

    /* renamed from: a */
    public static C3330n m14008a() {
        return C3327f.f18022a;
    }

    /* renamed from: a */
    private String m14009a(float f) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format((double) f);
    }

    /* renamed from: a */
    private void m14012a(Location location) {
        if (this.f18032f.m13991e() == 0) {
            this.f18032f.m13983a(location);
        } else if (Math.abs(location.getTime() - this.f18032f.m13981a()) >= this.f18038m * 1000) {
            this.f18032f.m13983a(location);
        }
    }

    /* renamed from: a */
    private void m14015a(C3372e c3372e) {
        if (c3372e != null && c3372e.m14330a() >= 1) {
            C3372e d = this.f18031e.m13999b();
            if (!c3372e.m14340c(d)) {
                if (d == null) {
                    this.f18031e.m13997a(c3372e);
                    return;
                }
                long h = c3372e.m14348h();
                long e = this.f18031e.m13995a();
                if (h - e >= 60000) {
                    if (h - e >= 600000) {
                        this.f18031e.m14001c();
                    }
                    this.f18031e.m13997a(c3372e);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m14019a(String str, Context context) {
        boolean z = false;
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    boolean z2;
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z2 = true;
                            z = z2;
                        }
                    }
                    z2 = z;
                    z = z2;
                }
            }
        } catch (Exception e) {
        }
        return z;
    }

    /* renamed from: b */
    private static String m14021b(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57};
        byte[] bytes = str.getBytes(f18026j);
        byte b = bArr[(byte) new Random().nextInt(10)];
        byte b2 = bArr[(byte) new Random().nextInt(10)];
        byte[] bArr2 = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (bytes[i] ^ b);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr2[i2] = b;
        i2 = i + 1;
        bArr2[i] = b2;
        return new String(bArr2);
    }

    /* renamed from: d */
    private void m14026d() {
        this.f18030d = this.f18039n;
        this.f18027a.obtainMessage(1).sendToTarget();
    }

    /* renamed from: e */
    private void m14028e() {
        try {
            if (this.f18027a != null && this.f18043r != null) {
                this.f18027a.postDelayed(this.f18043r, this.f18030d);
                this.f18042q = true;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public void m14033b() {
        if (this.f18043r == null) {
            this.f18043r = new C3326e();
        }
        this.f18027a.postDelayed(this.f18043r, 1000);
        this.f18042q = true;
        this.f18033g = true;
        this.f18028b = C3377f.getServiceContext();
        try {
            this.f18036k = (LocationManager) this.f18028b.getSystemService("location");
            this.f18037l = new C3325d();
            this.f18036k.requestLocationUpdates("passive", Config.BPLUS_DELAY_TIME, 0.0f, this.f18037l);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public void m14034c() {
        if (this.f18042q && this.f18027a != null) {
            try {
                this.f18027a.removeCallbacks(this.f18043r);
            } catch (Exception e) {
            }
            this.f18042q = false;
        }
        this.f18033g = false;
        this.f18040o = false;
        try {
            this.f18036k.removeUpdates(this.f18037l);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f18036k = null;
    }
}
