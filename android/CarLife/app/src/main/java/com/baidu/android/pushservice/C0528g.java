package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.p033a.C0600d;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0562b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.baidumaps.common.network.NetworkListener;
import java.io.IOException;

@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* renamed from: com.baidu.android.pushservice.g */
public class C0528g {
    /* renamed from: a */
    public static C0512e f1705a;
    /* renamed from: b */
    private static String f1706b = "PushSDK";
    /* renamed from: c */
    private static C0528g f1707c = null;
    /* renamed from: d */
    private static int f1708d = 180000;
    /* renamed from: e */
    private static int f1709e = 1800000;
    /* renamed from: g */
    private static final Object f1710g = new Object();
    /* renamed from: h */
    private static LocalServerSocket f1711h;
    /* renamed from: j */
    private static Object f1712j = new Object();
    /* renamed from: f */
    private int f1713f;
    /* renamed from: i */
    private Boolean f1714i = Boolean.valueOf(false);
    /* renamed from: k */
    private Context f1715k;
    /* renamed from: l */
    private Handler f1716l;
    /* renamed from: m */
    private boolean f1717m;
    /* renamed from: n */
    private PushServiceReceiver f1718n;
    /* renamed from: o */
    private RegistrationReceiver f1719o;
    /* renamed from: p */
    private boolean f1720p;
    /* renamed from: q */
    private Runnable f1721q = new C05242(this);
    /* renamed from: r */
    private Runnable f1722r = new C05253(this);
    /* renamed from: s */
    private Runnable f1723s = new C05264(this);

    /* renamed from: com.baidu.android.pushservice.g$2 */
    class C05242 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0528g f1702a;

        C05242(C0528g c0528g) {
            this.f1702a = c0528g;
        }

        public void run() {
            this.f1702a.m2245a(new Intent());
        }
    }

    /* renamed from: com.baidu.android.pushservice.g$3 */
    class C05253 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0528g f1703a;

        C05253(C0528g c0528g) {
            this.f1703a = c0528g;
        }

        public void run() {
            this.f1703a.m2247d();
        }
    }

    /* renamed from: com.baidu.android.pushservice.g$4 */
    class C05264 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0528g f1704a;

        C05264(C0528g c0528g) {
            this.f1704a = c0528g;
        }

        public void run() {
            synchronized (C0528g.f1710g) {
                if (C0528g.f1705a != null) {
                    C0528g.f1705a.m2149b();
                }
            }
        }
    }

    private C0528g(Context context) {
        this.f1716l = new Handler(context.getMainLooper());
        this.f1715k = context.getApplicationContext();
        this.f1713f = f1708d;
        C0578p.m2573g(this.f1715k.getApplicationContext());
    }

    /* renamed from: a */
    public static synchronized C0528g m2222a(Context context) {
        C0528g c0528g;
        synchronized (C0528g.class) {
            if (f1707c == null) {
                f1707c = new C0528g(context);
            }
            c0528g = f1707c;
        }
        return c0528g;
    }

    /* renamed from: b */
    public static void m2223b() {
        if (f1707c != null) {
            f1707c.m2232j();
        }
        C0559d.m2387a().m2389b();
    }

    /* renamed from: b */
    private boolean m2225b(Context context) {
        String v = C0578p.m2603v(context);
        String packageName = context.getPackageName();
        if (packageName.equals(v)) {
            C0527a.m2216a(f1706b, "Try use current push service, package name is: " + packageName, this.f1715k);
            return false;
        }
        C0527a.m2216a(f1706b, "Current push service : " + packageName + " should stop!!!" + " highest priority service is: " + v, this.f1715k);
        return true;
    }

    /* renamed from: h */
    private void m2230h() {
        if (this.f1718n == null) {
            this.f1718n = new PushServiceReceiver();
            this.f1715k.getApplicationContext().registerReceiver(this.f1718n, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f1715k.getApplicationContext().registerReceiver(this.f1718n, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f1715k.getApplicationContext().registerReceiver(this.f1718n, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f1715k.getApplicationContext().registerReceiver(this.f1718n, new IntentFilter(NetworkListener.f2257d));
        }
        if (this.f1719o == null) {
            this.f1719o = new RegistrationReceiver();
            this.f1715k.getApplicationContext().registerReceiver(this.f1719o, new IntentFilter("android.intent.action.PACKAGE_REMOVED"));
        }
    }

    /* renamed from: i */
    private void m2231i() {
        if (this.f1719o != null) {
            this.f1715k.getApplicationContext().unregisterReceiver(this.f1719o);
        }
        if (this.f1718n != null) {
            this.f1715k.getApplicationContext().unregisterReceiver(this.f1718n);
        }
    }

    /* renamed from: j */
    private void m2232j() {
        C0527a.m2216a(f1706b, "destroy", this.f1715k);
        synchronized (f1712j) {
            try {
                if (f1711h != null) {
                    f1711h.close();
                    f1711h = null;
                }
            } catch (IOException e) {
            }
            if (f1705a != null) {
                synchronized (f1710g) {
                    f1705a.m2150c();
                    f1705a = null;
                }
            }
            try {
                C0463a.m1999a();
            } catch (Exception e2) {
            }
            if (this.f1717m) {
                m2231i();
            }
            f1707c = null;
        }
    }

    /* renamed from: k */
    private void m2233k() {
        synchronized (f1710g) {
            f1705a = C0512e.m2120a(this.f1715k);
        }
    }

    /* renamed from: l */
    private void m2234l() {
        m2235m();
        long currentTimeMillis = ((long) this.f1713f) + System.currentTimeMillis();
        int i = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
            currentTimeMillis += ((long) (Math.random() * ((double) (this.f1713f - 20000)))) + 15000;
        }
        try {
            ((AlarmManager) this.f1715k.getSystemService("alarm")).setRepeating(0, currentTimeMillis, (long) this.f1713f, m2242t());
        } catch (Exception e) {
        }
    }

    /* renamed from: m */
    private void m2235m() {
        try {
            ((AlarmManager) this.f1715k.getSystemService("alarm")).cancel(m2242t());
        } catch (Exception e) {
        }
    }

    /* renamed from: n */
    private void m2236n() {
        C0559d.m2387a().m2388a(new C0420c(this, "tryConnect", (short) 98) {
            /* renamed from: a */
            final /* synthetic */ C0528g f1701a;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public void mo1272a() {
                /*
                r5 = this;
                r0 = com.baidu.android.pushservice.C0528g.f1707c;
                if (r0 != 0) goto L_0x0007;
            L_0x0006:
                return;
            L_0x0007:
                r1 = com.baidu.android.pushservice.C0528g.f1707c;
                monitor-enter(r1);
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0 = r0.f1715k;	 Catch:{ all -> 0x004d }
                r0 = com.baidu.android.pushservice.p031j.C0572k.m2461e(r0);	 Catch:{ all -> 0x004d }
                r2 = com.baidu.android.pushservice.C0528g.f1706b;	 Catch:{ all -> 0x004d }
                r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004d }
                r3.<init>();	 Catch:{ all -> 0x004d }
                r4 = "tryConnect networkConnected :";
                r3 = r3.append(r4);	 Catch:{ all -> 0x004d }
                r3 = r3.append(r0);	 Catch:{ all -> 0x004d }
                r3 = r3.toString();	 Catch:{ all -> 0x004d }
                r4 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r4 = r4.f1715k;	 Catch:{ all -> 0x004d }
                com.baidu.android.pushservice.p028g.C0527a.m2216a(r2, r3, r4);	 Catch:{ all -> 0x004d }
                if (r0 != 0) goto L_0x0050;
            L_0x0039:
                r0 = com.baidu.android.pushservice.C0430a.m1857b();	 Catch:{ all -> 0x004d }
                if (r0 <= 0) goto L_0x004b;
            L_0x003f:
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0 = r0.f1715k;	 Catch:{ all -> 0x004d }
                r2 = "039912";
                com.baidu.android.pushservice.p029h.C0553q.m2360a(r0, r2);	 Catch:{ all -> 0x004d }
            L_0x004b:
                monitor-exit(r1);	 Catch:{ all -> 0x004d }
                goto L_0x0006;
            L_0x004d:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x004d }
                throw r0;
            L_0x0050:
                r0 = com.baidu.android.pushservice.C0430a.m1857b();	 Catch:{ all -> 0x004d }
                if (r0 <= 0) goto L_0x0062;
            L_0x0056:
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0 = r0.f1715k;	 Catch:{ all -> 0x004d }
                r2 = "039914";
                com.baidu.android.pushservice.p029h.C0553q.m2360a(r0, r2);	 Catch:{ all -> 0x004d }
            L_0x0062:
                r0 = com.baidu.android.pushservice.C0528g.f1705a;	 Catch:{ all -> 0x004d }
                if (r0 == 0) goto L_0x0093;
            L_0x0066:
                r0 = com.baidu.android.pushservice.C0528g.f1705a;	 Catch:{ all -> 0x004d }
                r0 = r0.m2148a();	 Catch:{ all -> 0x004d }
                if (r0 != 0) goto L_0x0093;
            L_0x006e:
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0 = r0.f1715k;	 Catch:{ all -> 0x004d }
                r0 = com.baidu.android.pushservice.C0580j.m2614a(r0);	 Catch:{ all -> 0x004d }
                r0 = r0.m2619c();	 Catch:{ all -> 0x004d }
                if (r0 != 0) goto L_0x0096;
            L_0x007e:
                r0 = com.baidu.android.pushservice.C0528g.f1706b;	 Catch:{ all -> 0x004d }
                r2 = "Channel token is not available, start NETWORK REGISTER SERVICE .";
                r3 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r3 = r3.f1715k;	 Catch:{ all -> 0x004d }
                com.baidu.android.pushservice.p028g.C0527a.m2220d(r0, r2, r3);	 Catch:{ all -> 0x004d }
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0.m2239q();	 Catch:{ all -> 0x004d }
            L_0x0093:
                monitor-exit(r1);	 Catch:{ all -> 0x004d }
                goto L_0x0006;
            L_0x0096:
                r0 = r5.f1701a;	 Catch:{ all -> 0x004d }
                r0.m2240r();	 Catch:{ all -> 0x004d }
                goto L_0x0093;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.g.1.a():void");
            }
        });
    }

    /* renamed from: o */
    private boolean m2237o() {
        if (f1711h == null) {
            try {
                C0472c.m2031b(this.f1715k, null);
                f1711h = new LocalServerSocket(C0578p.m2590p(this.f1715k));
                m2241s();
            } catch (Exception e) {
                C0527a.m2216a(f1706b, "--- Socket Adress (" + C0578p.m2590p(this.f1715k) + ") in use --- @ " + this.f1715k.getPackageName(), this.f1715k);
                C0577o.m2487b(this.f1715k);
                return false;
            }
        }
        C0472c.m2031b(this.f1715k, this.f1715k.getPackageName());
        return true;
    }

    /* renamed from: p */
    private boolean m2238p() {
        C0600d.m2684a(this.f1715k);
        boolean a = C0572k.m2457a(this.f1715k);
        C0527a.m2216a(f1706b, "heartbeat networkConnected :" + a, this.f1715k);
        CharSequence v = C0578p.m2603v(this.f1715k);
        if (C0578p.m2557c(this.f1715k) || !(TextUtils.isEmpty(v) || this.f1715k.getPackageName().equals(v))) {
            m2235m();
            return false;
        } else if (a) {
            if (C0430a.m1857b() > 0) {
                C0553q.m2360a(this.f1715k, "039914");
            }
            if (f1705a == null) {
                return true;
            }
            if (f1705a.m2148a()) {
                f1705a.m2151d();
                if (!this.f1720p) {
                    this.f1720p = true;
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
                    m2246c().m2415a(intent);
                }
            } else if (C0580j.m2614a(this.f1715k).m2619c()) {
                m2240r();
            } else {
                C0527a.m2219c(f1706b, "Channel token is not available, start NETWORK REGISTER SERVICE .", this.f1715k);
                m2239q();
            }
            C0578p.m2546b("heartbeat PushConnection isConnected " + f1705a.m2148a() + " at Time " + System.currentTimeMillis(), this.f1715k.getApplicationContext());
            return true;
        } else {
            if (f1705a != null) {
                f1705a.m2147a(true);
            }
            if (C0430a.m1857b() <= 0) {
                return true;
            }
            C0553q.m2360a(this.f1715k, "039912");
            return true;
        }
    }

    /* renamed from: q */
    private void m2239q() {
        this.f1716l.removeCallbacks(this.f1722r);
        this.f1716l.postDelayed(this.f1722r, 500);
    }

    /* renamed from: r */
    private void m2240r() {
        if (f1711h != null || m2237o()) {
            this.f1716l.removeCallbacks(this.f1723s);
            this.f1716l.postDelayed(this.f1723s, 1000);
        }
    }

    /* renamed from: s */
    private void m2241s() {
        if (C0578p.m2502F(this.f1715k)) {
            Object a = C0562b.m2419a(this.f1715k, "com.baidu.push.cur_pkg");
            if (!TextUtils.isEmpty(a) && a.equals(this.f1715k.getPackageName())) {
                C0562b.m2422a(this.f1715k, "com.baidu.push.cur_pkg", null);
                return;
            }
            return;
        }
        C0562b.m2421a(this.f1715k, "com.baidu.push.cur_prio", C0430a.m1854a());
        C0562b.m2422a(this.f1715k, "com.baidu.push.cur_pkg", this.f1715k.getPackageName());
    }

    /* renamed from: t */
    private PendingIntent m2242t() {
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setFlags(32);
        intent.setClass(this.f1715k, PushService.class);
        return PendingIntent.getService(this.f1715k.getApplicationContext(), 0, intent, 134217728);
    }

    /* renamed from: a */
    public void m2243a(int i) {
        C0527a.m2216a(f1706b, "heartbeat set : " + i + " secs", this.f1715k);
        if (i > 0) {
            this.f1713f = i * 1000;
        }
        m2234l();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m2244a() {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = f1706b;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Create PushSDK from : ";
        r3 = r3.append(r4);
        r4 = r6.f1715k;
        r4 = r4.getPackageName();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = r6.f1715k;
        com.baidu.android.pushservice.p028g.C0527a.m2216a(r2, r3, r4);
        r6.m2235m();
        r2 = java.lang.Boolean.valueOf(r1);
        r6.f1714i = r2;
        r2 = r6.f1715k;
        r2 = r2.getApplicationContext();
        r2 = com.baidu.android.pushservice.p031j.C0578p.m2557c(r2);
        if (r2 != 0) goto L_0x0040;
    L_0x0038:
        r2 = r6.f1715k;
        r2 = r6.m2225b(r2);
        if (r2 == 0) goto L_0x004b;
    L_0x0040:
        r1 = f1706b;
        r2 = "onCreate shouldStopSelf";
        r3 = r6.f1715k;
        com.baidu.android.pushservice.p028g.C0527a.m2216a(r1, r2, r3);
    L_0x004a:
        return r0;
    L_0x004b:
        r2 = f1712j;
        monitor-enter(r2);
        r3 = com.baidu.android.pushservice.jni.PushSocket.f1876a;	 Catch:{ all -> 0x0054 }
        if (r3 != 0) goto L_0x0057;
    L_0x0052:
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        goto L_0x004a;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r3 = r6.m2237o();	 Catch:{ all -> 0x0054 }
        if (r3 != 0) goto L_0x0076;
    L_0x005d:
        r3 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        com.baidu.android.pushservice.p031j.C0578p.m2600u(r3);	 Catch:{ all -> 0x0054 }
        r3 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        r3 = com.baidu.android.pushservice.p031j.C0578p.m2603v(r3);	 Catch:{ all -> 0x0054 }
        r4 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        r4 = r4.getPackageName();	 Catch:{ all -> 0x0054 }
        r3 = r4.equals(r3);	 Catch:{ all -> 0x0054 }
        if (r3 != 0) goto L_0x0076;
    L_0x0074:
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        goto L_0x004a;
    L_0x0076:
        r0 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2503G(r0);	 Catch:{ all -> 0x0054 }
        r6.f1717m = r0;	 Catch:{ all -> 0x0054 }
        r0 = r6.f1717m;	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0085;
    L_0x0082:
        r6.m2230h();	 Catch:{ all -> 0x0054 }
    L_0x0085:
        r0 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        com.baidu.android.pushservice.C0554h.m2377b(r0);	 Catch:{ all -> 0x0054 }
        r0 = new com.baidu.android.pushservice.b;	 Catch:{ all -> 0x0054 }
        r3 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        r3 = r3.getApplicationContext();	 Catch:{ all -> 0x0054 }
        r0.<init>(r3);	 Catch:{ all -> 0x0054 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0054 }
        r6.m2233k();	 Catch:{ all -> 0x0054 }
        r0 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        com.baidu.android.pushservice.C0560i.m2390a(r0);	 Catch:{ all -> 0x0054 }
        r0 = r6.f1715k;	 Catch:{ all -> 0x0054 }
        com.baidu.android.pushservice.PushSettings.m1836l(r0);	 Catch:{ all -> 0x0054 }
        r0 = f1711h;	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x00b5;
    L_0x00a9:
        r0 = r6.f1716l;	 Catch:{ all -> 0x0054 }
        r3 = r6.f1721q;	 Catch:{ all -> 0x0054 }
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.postDelayed(r3, r4);	 Catch:{ all -> 0x0054 }
        r6.m2236n();	 Catch:{ all -> 0x0054 }
    L_0x00b5:
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        r0 = r1;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.g.a():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m2245a(android.content.Intent r9) {
        /*
        r8 = this;
        r1 = 0;
        r0 = 1;
        r2 = f1706b;
        r3 = "PushSDK handleOnStart go";
        r4 = r8.f1715k;
        com.baidu.android.pushservice.p028g.C0527a.m2216a(r2, r3, r4);
        if (r9 != 0) goto L_0x001d;
    L_0x000e:
        r9 = new android.content.Intent;
        r9.<init>();
        r2 = f1706b;
        r3 = "--- handleOnStart by null intent!";
        r4 = r8.f1715k;
        com.baidu.android.pushservice.p028g.C0527a.m2219c(r2, r3, r4);
    L_0x001d:
        r2 = r8.f1714i;
        r2 = r2.booleanValue();
        if (r2 != 0) goto L_0x0028;
    L_0x0025:
        r8.m2244a();
    L_0x0028:
        r4 = f1712j;
        monitor-enter(r4);
        r2 = r8.f1716l;	 Catch:{ all -> 0x004f }
        r3 = r8.f1721q;	 Catch:{ all -> 0x004f }
        r2.removeCallbacks(r3);	 Catch:{ all -> 0x004f }
        r2 = f1711h;	 Catch:{ all -> 0x004f }
        if (r2 != 0) goto L_0x0052;
    L_0x0036:
        r1 = "com.baidu.android.pushservice.action.METHOD";
        r2 = r9.getAction();	 Catch:{ all -> 0x004f }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004f }
        if (r1 == 0) goto L_0x004d;
    L_0x0043:
        r0 = r8.m2246c();	 Catch:{ all -> 0x004f }
        r0 = r0.m2415a(r9);	 Catch:{ all -> 0x004f }
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
    L_0x004c:
        return r0;
    L_0x004d:
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        goto L_0x004c;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        throw r0;
    L_0x0052:
        r2 = "AlarmAlert";
        r2 = r9.getStringExtra(r2);	 Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x0061;
    L_0x005b:
        r0 = r8.m2238p();	 Catch:{ all -> 0x004f }
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        goto L_0x004c;
    L_0x0061:
        r2 = "pushservice_restart_v2";
        r3 = "method";
        r3 = r9.getStringExtra(r3);	 Catch:{ all -> 0x004f }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x004f }
        if (r2 != 0) goto L_0x0081;
    L_0x0071:
        r2 = "pushservice_restart_v3";
        r3 = "method";
        r3 = r9.getStringExtra(r3);	 Catch:{ all -> 0x004f }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x00da;
    L_0x0081:
        r2 = f1711h;	 Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x00da;
    L_0x0085:
        r2 = r8.f1715k;	 Catch:{ all -> 0x004f }
        r2 = com.baidu.android.pushservice.p031j.C0578p.m2502F(r2);	 Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x00cc;
    L_0x008d:
        r2 = "priority3";
        r6 = 0;
        r2 = r9.getLongExtra(r2, r6);	 Catch:{ all -> 0x004f }
    L_0x0096:
        r5 = r8.f1715k;	 Catch:{ all -> 0x004f }
        r5 = com.baidu.android.pushservice.p024c.C0448d.m1932a(r5);	 Catch:{ all -> 0x004f }
        r5.m1955e();	 Catch:{ all -> 0x004f }
        r5 = r8.f1715k;	 Catch:{ all -> 0x004f }
        r6 = com.baidu.android.pushservice.p031j.C0578p.m2574h(r5);	 Catch:{ all -> 0x004f }
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x00d6;
    L_0x00a9:
        r2 = r8.f1715k;	 Catch:{ all -> 0x004f }
        r2 = com.baidu.android.pushservice.p024c.C0448d.m1932a(r2);	 Catch:{ all -> 0x004f }
        r2 = r2.m1952b();	 Catch:{ all -> 0x004f }
        r3 = 3;
        if (r2 == r3) goto L_0x00d6;
    L_0x00b6:
        r3 = r0;
    L_0x00b7:
        r2 = r8.f1715k;	 Catch:{ all -> 0x004f }
        r2 = com.baidu.android.pushservice.p024c.C0448d.m1932a(r2);	 Catch:{ all -> 0x004f }
        r2 = r2.m1952b();	 Catch:{ all -> 0x004f }
        r5 = 4;
        if (r2 != r5) goto L_0x00d8;
    L_0x00c4:
        r2 = r0;
    L_0x00c5:
        if (r3 != 0) goto L_0x00c9;
    L_0x00c7:
        if (r2 == 0) goto L_0x00f1;
    L_0x00c9:
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        r0 = r1;
        goto L_0x004c;
    L_0x00cc:
        r2 = "priority2";
        r6 = 0;
        r2 = r9.getLongExtra(r2, r6);	 Catch:{ all -> 0x004f }
        goto L_0x0096;
    L_0x00d6:
        r3 = r1;
        goto L_0x00b7;
    L_0x00d8:
        r2 = r1;
        goto L_0x00c5;
    L_0x00da:
        r1 = r8.m2246c();	 Catch:{ all -> 0x004f }
        r1 = r1.m2415a(r9);	 Catch:{ all -> 0x004f }
        if (r1 == 0) goto L_0x00f1;
    L_0x00e4:
        r1 = f1706b;	 Catch:{ all -> 0x004f }
        r2 = "-- handleOnStart -- intent handled  by mRegistrationService ";
        r3 = r8.f1715k;	 Catch:{ all -> 0x004f }
        com.baidu.android.pushservice.p028g.C0527a.m2219c(r1, r2, r3);	 Catch:{ all -> 0x004f }
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        goto L_0x004c;
    L_0x00f1:
        r8.m2236n();	 Catch:{ all -> 0x004f }
        monitor-exit(r4);	 Catch:{ all -> 0x004f }
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.g.a(android.content.Intent):boolean");
    }

    /* renamed from: c */
    public C0560i m2246c() {
        return C0560i.m2390a(this.f1715k);
    }

    /* renamed from: d */
    void m2247d() {
        C0527a.m2216a(f1706b, ">> sendRequestTokenIntent", this.f1715k);
        C0577o.m2488b(this.f1715k, new Intent("com.baidu.pushservice.action.TOKEN"));
    }
}
