package com.baidu.location.p190c;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.c.c */
public class C3248c {
    /* renamed from: n */
    private static volatile C3248c f17649n = null;
    /* renamed from: a */
    C3246b f17650a = null;
    /* renamed from: b */
    long f17651b = 0;
    /* renamed from: c */
    private Context f17652c = null;
    /* renamed from: d */
    private Handler f17653d = null;
    /* renamed from: e */
    private final int f17654e = 1;
    /* renamed from: f */
    private boolean f17655f = false;
    /* renamed from: g */
    private long f17656g = 180000;
    /* renamed from: h */
    private long f17657h = 60000;
    /* renamed from: i */
    private long f17658i = 0;
    /* renamed from: j */
    private String f17659j = "";
    /* renamed from: k */
    private boolean f17660k = false;
    /* renamed from: l */
    private C3372e f17661l = null;
    /* renamed from: m */
    private C3362a f17662m = null;
    /* renamed from: o */
    private List<C3247c> f17663o = null;
    /* renamed from: p */
    private long f17664p = 4000;
    /* renamed from: q */
    private boolean f17665q = false;
    /* renamed from: r */
    private C3245a f17666r = new C3245a();

    /* renamed from: com.baidu.location.c.c$1 */
    class C32441 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3248c f17639a;

        C32441(C3248c c3248c) {
            this.f17639a = c3248c;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 1:
                        try {
                            this.f17639a.m13610f();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.c.c$a */
    private class C3245a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3248c f17640a;

        private C3245a(C3248c c3248c) {
            this.f17640a = c3248c;
        }

        public void run() {
            if (this.f17640a.f17655f && C3376f.m14363j()) {
                this.f17640a.f17665q = true;
                this.f17640a.m13608d();
                if (this.f17640a.f17653d != null) {
                    this.f17640a.f17653d.postDelayed(this, this.f17640a.f17656g + this.f17640a.f17664p);
                    return;
                }
                return;
            }
            this.f17640a.f17665q = false;
        }
    }

    /* renamed from: com.baidu.location.c.c$b */
    class C3246b extends BroadcastReceiver {
        /* renamed from: a */
        boolean f17641a = false;
        /* renamed from: b */
        long f17642b = 0;
        /* renamed from: c */
        final /* synthetic */ C3248c f17643c;

        public C3246b(C3248c c3248c) {
            this.f17643c = c3248c;
            m13594a(C3377f.getServiceContext());
        }

        /* renamed from: a */
        public void m13594a(Context context) {
            if (!this.f17641a) {
                this.f17641a = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                context.registerReceiver(this, intentFilter);
            }
        }

        /* renamed from: b */
        public void m13595b(Context context) {
            if (this.f17641a) {
                context.unregisterReceiver(this);
                this.f17641a = false;
            }
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT") && System.currentTimeMillis() - this.f17642b > 1000 && this.f17643c.f17653d != null) {
                this.f17642b = System.currentTimeMillis();
                this.f17643c.f17653d.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }

    /* renamed from: com.baidu.location.c.c$c */
    private class C3247c {
        /* renamed from: a */
        public long f17644a = 0;
        /* renamed from: b */
        public long f17645b = 0;
        /* renamed from: c */
        public int f17646c = 0;
        /* renamed from: d */
        public int f17647d = 0;
        /* renamed from: e */
        final /* synthetic */ C3248c f17648e;

        C3247c(C3248c c3248c, long j, long j2, int i, int i2) {
            this.f17648e = c3248c;
            this.f17644a = j2;
            this.f17645b = j;
            this.f17647d = i2;
            this.f17646c = i;
        }
    }

    public C3248c(Context context) {
        this.f17652c = context;
        m13602h();
    }

    /* renamed from: a */
    public static C3248c m13596a() {
        if (f17649n == null) {
            synchronized (C3248c.class) {
                if (f17649n == null) {
                    f17649n = new C3248c(C3377f.getServiceContext());
                }
            }
        }
        return f17649n;
    }

    /* renamed from: h */
    private void m13602h() {
        String c = C3232a.m13554b().mo2499c();
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                if (jSONObject.has("min")) {
                    this.f17657h = (long) ((jSONObject.getInt("min") * 60) * 1000);
                }
                if (jSONObject.has("max")) {
                    this.f17656g = (long) ((jSONObject.getInt("max") * 60) * 1000);
                }
                if (jSONObject.has(C2546c.al)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(C2546c.al);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("t1") && jSONObject.has("t2") && jSONObject.has("min") && jSONObject.has("max")) {
                            if (this.f17663o == null) {
                                this.f17663o = new ArrayList();
                            }
                            this.f17663o.add(new C3247c(this, (long) jSONObject.getInt("min"), (long) jSONObject.getInt("max"), jSONObject.getInt("t1"), jSONObject.getInt("t2")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    private int m13603i() {
        Time time = new Time();
        time.setToNow();
        return time.hour;
    }

    /* renamed from: j */
    private void m13604j() {
        String str = "trfk.dat";
        if (str != null) {
            try {
                File file = new File(C3391g.m14455k() + File.separator + str);
                if (file == null) {
                    return;
                }
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: k */
    private boolean m13605k() {
        try {
            File file = new File(C3391g.m14455k() + File.separator + "trfk2.dat");
            if (file == null || !file.exists()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
            return currentTimeMillis >= 600000 || currentTimeMillis <= 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: b */
    public void m13606b() {
        if (!this.f17655f) {
            this.f17651b = 0;
            try {
                this.f17650a = new C3246b(this);
            } catch (Exception e) {
                this.f17650a = null;
            }
            this.f17653d = new C32441(this);
            this.f17655f = true;
            m13609e();
        }
    }

    /* renamed from: c */
    public synchronized void m13607c() {
        if (this.f17655f) {
            this.f17655f = false;
            if (this.f17650a != null) {
                this.f17650a.m13595b(this.f17652c);
            }
            if (this.f17653d != null) {
                this.f17653d.removeMessages(1);
            }
            this.f17661l = null;
            this.f17651b = 0;
            this.f17658i = 0;
            this.f17659j = "";
            this.f17660k = false;
        }
    }

    /* renamed from: d */
    public synchronized void m13608d() {
        if (this.f17653d != null) {
            this.f17653d.sendEmptyMessageDelayed(1, 2000 + this.f17664p);
        }
    }

    /* renamed from: e */
    public void m13609e() {
        if (C3376f.m14363j() && this.f17653d != null && !this.f17665q) {
            this.f17653d.postDelayed(this.f17666r, Config.BPLUS_DELAY_TIME + this.f17664p);
        }
    }

    /* renamed from: f */
    void m13610f() {
        if (this.f17655f) {
            long currentTimeMillis;
            long j = 0;
            if (this.f17663o != null && this.f17663o.size() > 0) {
                int i = m13603i();
                for (C3247c c3247c : this.f17663o) {
                    if (i >= c3247c.f17646c && i < c3247c.f17647d) {
                        this.f17657h = (c3247c.f17645b * 60) * 1000;
                        this.f17656g = (c3247c.f17644a * 60) * 1000;
                    }
                }
            }
            if (this.f17658i != 0) {
                currentTimeMillis = System.currentTimeMillis() - this.f17658i;
                if (currentTimeMillis > this.f17657h) {
                    j = currentTimeMillis;
                } else {
                    return;
                }
            }
            this.f17658i = System.currentTimeMillis();
            if (C3391g.m14457m() != null) {
                C3362a f = C3364b.m14262a().m14280f();
                if (f != null && f.m14251e()) {
                    C3372e q = C3376f.m14355a().m14381q();
                    if (q == null) {
                        return;
                    }
                    if (q.f18275a == null || q.f18275a.size() >= 1) {
                        String str;
                        Object obj = null;
                        if (this.f17651b == 0) {
                            obj = 1;
                        }
                        if (this.f17661l == null) {
                            this.f17661l = new C3372e(q);
                        }
                        if (this.f17662m == null) {
                            this.f17662m = new C3362a(f);
                        }
                        boolean d = this.f17661l.m14343d(q);
                        boolean a = this.f17662m.m14247a(f);
                        if (this.f17661l != null) {
                            this.f17661l = null;
                            this.f17661l = new C3372e(q);
                        }
                        if (this.f17662m != null) {
                            this.f17662m = null;
                            this.f17662m = new C3362a(f);
                        }
                        StringBuffer stringBuffer = new StringBuffer(200);
                        if (obj != null) {
                            stringBuffer.append("s");
                        }
                        stringBuffer.append("v");
                        stringBuffer.append(7);
                        int currentTimeMillis2 = (int) (System.currentTimeMillis() >> 15);
                        stringBuffer.append("t");
                        stringBuffer.append(currentTimeMillis2);
                        if (f.m14248b()) {
                            if (f.f18202c == 460) {
                                stringBuffer.append("x,");
                            } else {
                                stringBuffer.append("x");
                                stringBuffer.append(f.f18202c);
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(f.f18203d);
                            stringBuffer.append(",");
                            stringBuffer.append(f.f18200a);
                            stringBuffer.append(",");
                            stringBuffer.append(f.f18201b);
                        }
                        WifiInfo l = C3376f.m14355a().m14376l();
                        String replace = l != null ? l.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, "") : null;
                        int i2 = 0;
                        Object obj2 = null;
                        String str2 = null;
                        if (!(q == null || q.f18275a == null)) {
                            int i3;
                            int i4 = 0;
                            while (i4 < q.f18275a.size()) {
                                Object obj3;
                                String replace2 = ((ScanResult) q.f18275a.get(i4)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                                currentTimeMillis2 = ((ScanResult) q.f18275a.get(i4)).level;
                                int i5 = currentTimeMillis2 < 0 ? -currentTimeMillis2 : currentTimeMillis2;
                                String str3;
                                if (i2 >= 15) {
                                    obj = obj2;
                                    i3 = i2;
                                    if (i3 > 15) {
                                        break;
                                    }
                                    str3 = str2;
                                    obj3 = obj;
                                    str = str3;
                                } else if (i4 < 2 || obj2 != null || replace == null || replace.equals(replace2)) {
                                    if (i4 == 0) {
                                        stringBuffer.append(Config.DEVICE_WIDTH);
                                    } else {
                                        stringBuffer.append(",");
                                    }
                                    stringBuffer.append(replace2);
                                    if (replace != null && replace.equals(replace2)) {
                                        obj = ((ScanResult) q.f18275a.get(i4)).capabilities;
                                        if (TextUtils.isEmpty(obj)) {
                                            stringBuffer.append("j");
                                        } else {
                                            str = obj.toUpperCase(Locale.CHINA);
                                            if (str.contains("WEP") || str.contains("WPA")) {
                                                stringBuffer.append("l");
                                            } else {
                                                stringBuffer.append("j");
                                            }
                                        }
                                        obj2 = 1;
                                    }
                                    stringBuffer.append(";" + i5);
                                    obj = obj2;
                                    i3 = i2 + 1;
                                    if (i3 > 15) {
                                        break;
                                    }
                                    str3 = str2;
                                    obj3 = obj;
                                    str = str3;
                                } else if (str2 == null) {
                                    str = "," + replace2 + ";" + i5;
                                    obj3 = obj2;
                                    i3 = i2;
                                } else {
                                    str = str2;
                                    obj3 = obj2;
                                    i3 = i2;
                                }
                                i4++;
                                i2 = i3;
                                obj2 = obj3;
                                str2 = str;
                            }
                            i3 = i2;
                            if (i3 < 15 && str2 != null) {
                                stringBuffer.append(str2);
                            }
                        }
                        try {
                            str = m13611g() ? "y2" : "y1";
                        } catch (Exception e) {
                            str = "y";
                        }
                        if (C3218c.m13487a().m13493d() != null) {
                            str = str + C3218c.m13487a().m13493d();
                        }
                        stringBuffer.append(str);
                        if (this.f17660k) {
                            if (j > 0) {
                                this.f17659j = "r" + (j / 60000);
                                stringBuffer.append(this.f17659j);
                                this.f17659j = "";
                            }
                            this.f17660k = false;
                        }
                        m13604j();
                        obj = 1;
                        if (!m13605k()) {
                            obj = null;
                        }
                        if (!(obj == null || C3371d.m14289a().m14325m())) {
                            currentTimeMillis = System.currentTimeMillis() - this.f17651b;
                            if ((a || d) && currentTimeMillis >= this.f17656g - Config.BPLUS_DELAY_TIME) {
                                C3232a.m13554b().m13559a(Jni.encodeOfflineLocationUpdateRequest(stringBuffer.toString()));
                                this.f17651b = System.currentTimeMillis();
                            }
                        }
                        C3211m.m13441a().m13459c();
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public boolean m13611g() {
        return ((KeyguardManager) this.f17652c.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
}
