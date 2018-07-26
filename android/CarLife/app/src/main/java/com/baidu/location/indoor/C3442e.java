package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.carlife.core.C1253f;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p191d.C3301g;
import com.baidu.navisdk.util.common.HttpsClient;
import java.util.Locale;

/* renamed from: com.baidu.location.indoor.e */
class C3442e {
    /* renamed from: a */
    private static volatile C3442e f18632a = null;
    /* renamed from: b */
    private StringBuffer f18633b = null;
    /* renamed from: c */
    private Handler f18634c = null;
    /* renamed from: d */
    private C3441a f18635d = null;
    /* renamed from: e */
    private boolean f18636e = false;

    /* renamed from: com.baidu.location.indoor.e$a */
    private class C3441a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3442e f18631a;

        private C3441a(C3442e c3442e) {
            this.f18631a = c3442e;
        }

        public void run() {
            if (this.f18631a.f18636e) {
                this.f18631a.m14752c();
                this.f18631a.f18636e = false;
            }
        }
    }

    /* renamed from: a */
    public static C3442e m14748a() {
        if (f18632a == null) {
            synchronized (C3442e.class) {
                if (f18632a == null) {
                    f18632a = new C3442e();
                }
            }
        }
        return f18632a;
    }

    /* renamed from: c */
    private synchronized void m14752c() {
        if (this.f18633b != null) {
            C3301g.m13880a(C3301g.f17908a, Jni.encode(this.f18633b.toString()));
            this.f18633b = null;
        }
    }

    /* renamed from: a */
    public void m14753a(BDLocation bDLocation, String str) {
        if (bDLocation == null) {
            return;
        }
        if (bDLocation == null || bDLocation.getBuildingID() != null) {
            if (this.f18634c == null) {
                this.f18634c = new Handler();
            }
            if (this.f18636e) {
                if (this.f18635d == null) {
                    this.f18635d = new C3441a();
                }
                this.f18634c.removeCallbacks(this.f18635d);
                this.f18636e = false;
            }
            if (this.f18633b == null) {
                this.f18633b = new StringBuffer();
                if (str != null) {
                    this.f18633b.append("&bldg=");
                    this.f18633b.append(str);
                }
                this.f18633b.append(C3381b.m14398a().m14399a(false));
                this.f18633b.append("&uptype=indoor");
                this.f18633b.append("&data=");
            }
            try {
                String format;
                if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("ml")) {
                    format = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|1", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Float.valueOf(bDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000), bDLocation.getFloor()});
                } else if (bDLocation.getNetworkLocationType().equals("dr")) {
                    format = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|2", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Float.valueOf(bDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000), bDLocation.getFloor()});
                } else {
                    format = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|0", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Float.valueOf(bDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000), bDLocation.getFloor()});
                }
                this.f18633b.append("" + format);
                this.f18633b.append(",");
                if (this.f18633b.length() > C1253f.eJ) {
                    m14752c();
                    return;
                }
                this.f18634c.postDelayed(this.f18635d, HttpsClient.CONN_MGR_TIMEOUT);
                this.f18636e = true;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    void m14754b() {
        if (this.f18636e && this.f18634c != null) {
            this.f18634c.removeCallbacks(this.f18635d);
            this.f18635d = null;
            this.f18636e = false;
        }
        m14752c();
    }
}
