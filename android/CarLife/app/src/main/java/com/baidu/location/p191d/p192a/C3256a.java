package com.baidu.location.p191d.p192a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.format.Time;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3382c;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p191d.p192a.C3274f.C3270a;
import com.baidu.location.p191d.p192a.C3274f.C3272c;
import com.baidu.location.p191d.p192a.C3277g.C3254a;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.baidu.location.d.a.a */
public class C3256a {
    /* renamed from: a */
    public static boolean f17674a = true;
    /* renamed from: b */
    boolean f17675b;
    /* renamed from: c */
    Runnable f17676c;
    /* renamed from: d */
    private Context f17677d;
    /* renamed from: e */
    private Handler f17678e;
    /* renamed from: f */
    private AlarmManager f17679f;
    /* renamed from: g */
    private C3251a f17680g;
    /* renamed from: h */
    private PendingIntent f17681h;
    /* renamed from: i */
    private final long f17682i;
    /* renamed from: j */
    private long f17683j;
    /* renamed from: k */
    private WakeLock f17684k;
    /* renamed from: l */
    private C3270a f17685l;
    /* renamed from: m */
    private C3270a f17686m;

    /* renamed from: com.baidu.location.d.a.a$1 */
    class C32491 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3256a f17667a;

        C32491(C3256a c3256a) {
            this.f17667a = c3256a;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 1:
                        try {
                            this.f17667a.m13629h();
                            return;
                        } catch (Exception e) {
                            return;
                        } finally {
                            this.f17667a.m13628g();
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.a$2 */
    class C32502 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3256a f17668a;

        C32502(C3256a c3256a) {
            this.f17668a = c3256a;
        }

        public void run() {
            C3277g.m13705a().m13716b();
            C3268e.m13681a().m13686b();
            this.f17668a.m13636c();
        }
    }

    /* renamed from: com.baidu.location.d.a.a$a */
    private class C3251a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3256a f17669a;

        private C3251a(C3256a c3256a) {
            this.f17669a = c3256a;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.baidu.location.sen7.3.2")) {
                this.f17669a.f17678e.sendEmptyMessage(1);
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.a$b */
    private static class C3252b {
        /* renamed from: a */
        public static final C3256a f17670a = new C3256a();
    }

    /* renamed from: com.baidu.location.d.a.a$c */
    private class C3253c extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3256a f17671a;
        /* renamed from: b */
        private String f17672b;

        public C3253c(C3256a c3256a, String str) {
            this.f17671a = c3256a;
            this.f17672b = str;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            this.k.put("xlsm", this.f17672b);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null && this.j.contains("161")) {
                this.f17671a.m13632k();
            }
        }

        /* renamed from: b */
        public void mo2500b() {
            m13301i();
        }
    }

    /* renamed from: com.baidu.location.d.a.a$d */
    class C3255d implements C3254a {
        /* renamed from: a */
        final /* synthetic */ C3256a f17673a;

        C3255d(C3256a c3256a) {
            this.f17673a = c3256a;
        }

        /* renamed from: a */
        public void mo2501a(int i) {
            this.f17673a.f17678e.removeCallbacks(this.f17673a.f17676c);
            if (i == 0) {
                C3277g.m13705a().m13716b();
                C3268e.m13681a().m13686b();
                this.f17673a.m13636c();
            }
            if (i == 1) {
                this.f17673a.f17683j = 3600000;
                C3382c.m14410a().m14416c((long) C3256a.m13625e());
                C3274f.m13695a().m13699a(C3391g.m14445c());
                C3268e.m13681a().m13684a((long) ((this.f17673a.f17686m.f17754d * 60) * 1000));
            }
        }
    }

    private C3256a() {
        this.f17677d = null;
        this.f17678e = null;
        this.f17679f = null;
        this.f17680g = null;
        this.f17681h = null;
        this.f17682i = 600000;
        this.f17683j = 600000;
        this.f17684k = null;
        this.f17685l = null;
        this.f17686m = null;
        this.f17675b = false;
        this.f17676c = new C32502(this);
        this.f17677d = C3377f.getServiceContext();
        try {
            this.f17684k = ((PowerManager) this.f17677d.getSystemService("power")).newWakeLock(1, "LbsLocWackLock");
            this.f17684k.setReferenceCounted(false);
        } catch (Exception e) {
        }
        C3277g.m13705a().m13715a(new C3255d(this));
        if (C3274f.m13695a().m13701b() == null || !C3274f.m13695a().m13701b().f17760a.containsKey("level0")) {
            C3274f a = C3274f.m13695a();
            a.getClass();
            this.f17685l = new C3270a(a, true);
        } else {
            this.f17685l = (C3270a) C3274f.m13695a().m13701b().f17760a.get("level0");
        }
        if (this.f17685l != null) {
            this.f17685l.m13688a();
        }
        this.f17678e = new C32491(this);
    }

    /* renamed from: a */
    public static C3256a m13618a() {
        return C3252b.f17670a;
    }

    /* renamed from: a */
    private String m13619a(C3362a c3362a, C3372e c3372e, Location location, String str) {
        return Jni.encodeTp4(C3391g.m14432a(c3362a, c3372e, location, str));
    }

    /* renamed from: a */
    private void m13621a(String str) {
        if (((long) C3256a.m13625e()) != C3382c.m14410a().m14421f()) {
            new C3253c(this, str).mo2500b();
            C3382c.m14410a().m14422f((long) C3256a.m13625e());
        }
    }

    /* renamed from: e */
    public static int m13625e() {
        Time time = new Time();
        time.setToNow();
        return time.yearDay;
    }

    /* renamed from: f */
    public static int m13627f() {
        Time time = new Time();
        time.setToNow();
        return time.hour;
    }

    /* renamed from: g */
    private void m13628g() {
        if (f17674a) {
            this.f17679f.set(0, System.currentTimeMillis() + this.f17683j, this.f17681h);
        }
    }

    /* renamed from: h */
    private void m13629h() {
        if (f17674a) {
            String h = C3364b.m14262a().m14280f().m14254h();
            if (C3274f.m13695a().m13701b() == null || !C3274f.m13695a().m13701b().f17762c.containsKey(h)) {
                this.f17686m = this.f17685l;
            } else {
                this.f17686m = (C3270a) C3274f.m13695a().m13701b().f17760a.get((String) C3274f.m13695a().m13701b().f17762c.get(h));
                if (this.f17686m == null) {
                    this.f17686m = this.f17685l;
                }
            }
            int f = C3256a.m13627f();
            Object obj = null;
            for (C3272c c3272c : this.f17686m.f17752b) {
                Object obj2 = (f > c3272c.f17765b || f < c3272c.f17764a) ? obj : 1;
                obj = obj2;
            }
            if (obj == null) {
                this.f17683j = 3600000;
            } else if (C3274f.m13695a().m13700b(C3391g.m14445c()) < this.f17686m.f17753c) {
                this.f17683j = (long) ((this.f17686m.f17756f * 60) * 1000);
                m13630i();
            } else {
                this.f17683j = 3600000;
            }
        }
    }

    /* renamed from: i */
    private void m13630i() {
        if (((double) C3218c.m13487a().m13495f()) <= this.f17686m.f17757g * 100.0d && ((double) C3218c.m13487a().m13495f()) >= this.f17686m.f17758h * 100.0d && C3376f.m14355a().m14384t()) {
            if (m13634m()) {
                m13632k();
            } else if (this.f17686m.f17751a != this.f17685l.f17751a) {
                m13632k();
            } else {
                m13631j();
            }
        }
    }

    /* renamed from: j */
    private void m13631j() {
        if (((long) C3256a.m13625e()) != C3382c.m14410a().m14421f()) {
            String str;
            String f = C3181a.m13265a().m13283f();
            if (C3376f.m14363j()) {
                str = "&cn=32";
            } else {
                str = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(C3364b.m14262a().m14279e())});
            }
            m13621a(m13619a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), null, str + f));
        }
    }

    /* renamed from: k */
    private void m13632k() {
        if (C3274f.m13695a().m13700b(C3391g.m14445c()) < this.f17686m.f17753c) {
            m13633l();
        }
    }

    /* renamed from: l */
    private void m13633l() {
        try {
            this.f17684k.acquire();
        } catch (Exception e) {
        }
        this.f17675b = true;
        this.f17678e.postDelayed(this.f17676c, 4500);
        C3277g.m13705a().m13714a((this.f17686m.f17755e + 1) * 30);
    }

    /* renamed from: m */
    private boolean m13634m() {
        C3372e q = C3376f.m14355a().m14381q();
        if (q == null || q.f18275a == null || q.f18275a.size() == 0 || ((ScanResult) q.f18275a.get(0)).level < -70) {
            return false;
        }
        boolean a;
        try {
            a = C3279h.m13722a(q.f18275a);
        } catch (Exception e) {
            a = false;
        }
        return a;
    }

    /* renamed from: b */
    public void m13635b() {
        this.f17680g = new C3251a();
        this.f17679f = (AlarmManager) this.f17677d.getSystemService("alarm");
        this.f17677d.registerReceiver(this.f17680g, new IntentFilter("com.baidu.location.sen7.3.2"));
        this.f17681h = PendingIntent.getBroadcast(this.f17677d, 0, new Intent("com.baidu.location.sen7.3.2"), 134217728);
        this.f17679f.set(0, System.currentTimeMillis() + 2000, this.f17681h);
    }

    /* renamed from: c */
    public void m13636c() {
        try {
            if (this.f17684k != null && this.f17684k.isHeld()) {
                this.f17684k.release();
            }
        } catch (Exception e) {
        }
        this.f17675b = false;
    }

    /* renamed from: d */
    public void m13637d() {
        C3277g.m13705a().m13716b();
        C3268e.m13681a().m13686b();
        m13636c();
    }
}
