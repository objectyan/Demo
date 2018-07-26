package com.baidu.location.p187a;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p191d.C3280a;
import com.baidu.location.p191d.C3299f;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.baidu.location.a.f */
public abstract class C3195f {
    /* renamed from: c */
    public static String f17359c = null;
    /* renamed from: a */
    public C3372e f17360a = null;
    /* renamed from: b */
    public C3362a f17361b = null;
    /* renamed from: d */
    final Handler f17362d = new C3193a(this);
    /* renamed from: e */
    private boolean f17363e = true;
    /* renamed from: f */
    private boolean f17364f = true;
    /* renamed from: g */
    private boolean f17365g = false;
    /* renamed from: h */
    private String f17366h = null;
    /* renamed from: i */
    private String f17367i = null;

    /* renamed from: com.baidu.location.a.f$a */
    public class C3193a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3195f f17355a;

        public C3193a(C3195f c3195f) {
            this.f17355a = c3195f;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 21:
                        this.f17355a.mo2498a(message);
                        return;
                    case 62:
                    case 63:
                        this.f17355a.mo2497a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.a.f$b */
    class C3194b extends C3186e {
        /* renamed from: a */
        String f17356a;
        /* renamed from: b */
        String f17357b;
        /* renamed from: c */
        final /* synthetic */ C3195f f17358c;

        public C3194b(C3195f c3195f) {
            this.f17358c = c3195f;
            this.f17356a = null;
            this.f17357b = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            String encodeTp4 = Jni.encodeTp4(this.f17357b);
            this.f17357b = null;
            if (this.f17356a == null) {
                this.f17356a = C3211m.m13451b();
            }
            this.k.put("bloc", encodeTp4);
            if (this.f17356a != null) {
                this.k.put(OfflineMapKey.OFFLINE_UPDATE, this.f17356a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        /* renamed from: a */
        public void m13344a(String str) {
            this.f17357b = str;
            m13299c(C3391g.f18379f);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            BDLocation bDLocation;
            Message obtainMessage;
            if (!z || this.j == null) {
                obtainMessage = this.f17358c.f17362d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    C3195f.f17359c = str;
                    C3299f.m13848a().m13868a("receive net result = " + str);
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            C3192e.m13329a().m13337a(str);
                        }
                        bDLocation.setOperators(C3364b.m14262a().m14282h());
                        if (C3202i.m13395a().m13408g()) {
                            bDLocation.setDirection(C3202i.m13395a().m13410i());
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.f17356a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = this.f17358c.f17362d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                        obtainMessage.sendToTarget();
                    } else {
                        Message obtainMessage2 = this.f17358c.f17362d.obtainMessage(21);
                        obtainMessage2.obj = bDLocation;
                        obtainMessage2.sendToTarget();
                    }
                } catch (Exception e2) {
                    obtainMessage = this.f17358c.f17362d.obtainMessage(63);
                    obtainMessage.obj = "HttpStatus error";
                    obtainMessage.sendToTarget();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    /* renamed from: a */
    public String m13346a(String str) {
        if (this.f17361b == null || !this.f17361b.m14246a()) {
            this.f17361b = C3364b.m14262a().m14280f();
        }
        if (this.f17360a == null || !this.f17360a.m14352l()) {
            this.f17360a = C3376f.m14355a().m14381q();
        }
        Location k = C3371d.m14289a().m14325m() ? C3371d.m14289a().m14323k() : null;
        if ((this.f17361b == null || this.f17361b.m14250d() || this.f17361b.m14249c()) && ((this.f17360a == null || this.f17360a.m14330a() == 0) && k == null)) {
            return null;
        }
        String str2;
        String b = m13349b();
        if (C3192e.m13329a().m13341d() == -2) {
            b = b + "&imo=1";
        }
        int c = C3391g.m14444c(C3377f.getServiceContext());
        if (c >= 0) {
            b = b + "&lmd=" + c;
        }
        if (this.f17360a == null || this.f17360a.m14330a() == 0) {
            String m = C3376f.m14355a().m14377m();
            if (m != null) {
                str2 = m + b;
                if (this.f17364f) {
                    return C3391g.m14433a(this.f17361b, this.f17360a, k, str2, 0);
                }
                this.f17364f = false;
                return C3391g.m14434a(this.f17361b, this.f17360a, k, str2, 0, true);
            }
        }
        str2 = b;
        if (this.f17364f) {
            return C3391g.m14433a(this.f17361b, this.f17360a, k, str2, 0);
        }
        this.f17364f = false;
        return C3391g.m14434a(this.f17361b, this.f17360a, k, str2, 0, true);
    }

    /* renamed from: a */
    public abstract void mo2497a();

    /* renamed from: a */
    public abstract void mo2498a(Message message);

    /* renamed from: b */
    public String m13349b() {
        String str;
        String f = C3181a.m13265a().m13283f();
        if (C3376f.m14363j()) {
            str = "&cn=32";
        } else {
            str = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(C3364b.m14262a().m14279e())});
        }
        String u;
        if (this.f17363e) {
            this.f17363e = false;
            C3301g.m13879a().m13886b().m13965a(true);
            u = C3376f.m14355a().m14385u();
            if (!(TextUtils.isEmpty(u) || u.equals(Config.DEF_MAC_ID))) {
                u = u.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                str = String.format(Locale.CHINA, "%s&mac=%s", new Object[]{str, u});
            }
            str = String.format(Locale.CHINA, "%s&btag=%s", new Object[]{str, C3280a.m13723a().m13724b()});
            if (VERSION.SDK_INT > 17) {
                if (C3376f.m14355a().m14379o()) {
                    str = String.format(Locale.CHINA, "%s&wfal=1", new Object[]{str});
                } else {
                    str = String.format(Locale.CHINA, "%s&wfal=0", new Object[]{str});
                }
            }
            if (!C3391g.f18380g.equals("all")) {
                str = str + "&addr=allj";
            }
        } else if (!this.f17365g) {
            u = C3211m.m13458h();
            if (u != null) {
                str = str + u;
            }
            this.f17365g = true;
        }
        return str + f;
    }
}
