package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.C0618d;
import com.baidu.android.pushservice.message.C0619e;
import com.baidu.android.pushservice.message.C0620f;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p026e.C0485a;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0543i;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.carlife.core.C1253f;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.platform.comapi.util.C4820d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.baidu.android.pushservice.e */
public final class C0512e {
    /* renamed from: c */
    private static int f1645c = -1;
    /* renamed from: e */
    private static Boolean f1646e = Boolean.valueOf(false);
    /* renamed from: n */
    private static volatile C0512e f1647n;
    /* renamed from: A */
    private final int f1648A = 30;
    /* renamed from: B */
    private String f1649B;
    /* renamed from: a */
    Handler f1650a = new Handler();
    /* renamed from: b */
    C0618d f1651b;
    /* renamed from: d */
    private boolean f1652d = false;
    /* renamed from: f */
    private boolean f1653f = false;
    /* renamed from: g */
    private HashMap<Long, C0485a> f1654g = new HashMap();
    /* renamed from: h */
    private C0482b f1655h;
    /* renamed from: i */
    private C0481a f1656i;
    /* renamed from: j */
    private boolean f1657j = false;
    /* renamed from: k */
    private int f1658k = 0;
    /* renamed from: l */
    private Context f1659l;
    /* renamed from: m */
    private boolean f1660m = true;
    /* renamed from: o */
    private boolean f1661o;
    /* renamed from: p */
    private String f1662p = C0554h.m2379c();
    /* renamed from: q */
    private int f1663q = 0;
    /* renamed from: r */
    private Thread f1664r;
    /* renamed from: s */
    private Runnable f1665s = new C04772(this);
    /* renamed from: t */
    private Runnable f1666t = new C04783(this);
    /* renamed from: u */
    private long f1667u = 0;
    /* renamed from: v */
    private int[] f1668v = new int[]{C4820d.f19955a, 300, 360, 420, 540, C1253f.eK, 900};
    /* renamed from: w */
    private int f1669w = 0;
    /* renamed from: x */
    private int f1670x = 0;
    /* renamed from: y */
    private final int f1671y = 3;
    /* renamed from: z */
    private int f1672z = 0;

    /* renamed from: com.baidu.android.pushservice.e$1 */
    class C04761 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0512e f1576a;

        C04761(C0512e c0512e) {
            this.f1576a = c0512e;
        }

        public void run() {
            try {
                C0512e.f1645c = PushSocket.createSocket(this.f1576a.f1662p, this.f1576a.f1663q);
            } catch (Exception e) {
            }
            if (C0430a.m1857b() > 0) {
                C0543i c0543i = new C0543i();
                c0543i.d = "039907";
                c0543i.e = System.currentTimeMillis();
                c0543i.f = C0532b.m2255b(this.f1576a.f1659l);
                if (C0512e.f1645c >= 0) {
                    c0543i.g = 0;
                } else {
                    c0543i.g = C0512e.f1645c;
                }
                C0553q.m2363b(this.f1576a.f1659l, c0543i);
            }
            if (C0512e.f1645c == -1 || C0512e.f1645c == -2) {
                int i = NaviFragmentManager.TYPE_CAR_DRV_SETTING;
                try {
                    i = PushSocket.getLastSocketError();
                } catch (Exception e2) {
                }
                C0527a.m2218b("PushConnection", "Create socket err, errno: " + i + "socketfd: " + C0512e.f1645c, this.f1576a.f1659l.getApplicationContext());
                if (C0554h.m2379c().equals(this.f1576a.f1662p)) {
                    this.f1576a.m2125a("030301", i);
                } else {
                    this.f1576a.m2125a("030303", 10002);
                }
                if (C0512e.f1645c == -2) {
                    String a = C0554h.m2371a(this.f1576a.f1659l, this.f1576a.f1660m);
                    this.f1576a.f1660m = false;
                    if (!TextUtils.isEmpty(a)) {
                        this.f1576a.f1662p = a;
                    }
                }
                if (C0512e.f1645c == -1 && i == 110) {
                    this.f1576a.f1663q = 80;
                }
                C0512e.f1646e = Boolean.valueOf(false);
                this.f1576a.m2141j();
                C0578p.m2546b("PushConnection Create socket err " + this.f1576a.f1659l.getPackageName() + " lastSocketError " + i + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1576a.f1659l.getApplicationContext());
                return;
            }
            C0527a.m2216a("PushConnection", "create Socket ok", this.f1576a.f1659l.getApplicationContext());
            C0578p.m2546b("create Socket ok socketfd" + C0512e.f1645c, this.f1576a.f1659l);
            this.f1576a.f1651b = new C0620f(this.f1576a.f1659l.getApplicationContext());
            this.f1576a.f1652d = true;
            if (this.f1576a.f1656i != null) {
                this.f1576a.f1656i.interrupt();
            }
            if (this.f1576a.f1655h != null) {
                this.f1576a.f1655h.interrupt();
            }
            this.f1576a.f1653f = false;
            this.f1576a.f1656i = new C0481a(this.f1576a);
            this.f1576a.f1656i.start();
            this.f1576a.f1655h = new C0482b(this.f1576a);
            this.f1576a.f1655h.start();
            this.f1576a.f1651b.mo1297a(C0512e.f1645c);
            if (!C0554h.m2379c().equals(this.f1576a.f1662p)) {
                this.f1576a.m2125a("030302", 0);
            }
            C0512e.f1646e = Boolean.valueOf(false);
            this.f1576a.f1660m = true;
            this.f1576a.f1662p = C0554h.m2379c();
            C0554h.m2380c(this.f1576a.f1659l);
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$2 */
    class C04772 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0512e f1577a;

        C04772(C0512e c0512e) {
            this.f1577a = c0512e;
        }

        public void run() {
            this.f1577a.m2139i();
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$3 */
    class C04783 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0512e f1578a;

        C04783(C0512e c0512e) {
            this.f1578a = c0512e;
        }

        public void run() {
            C0527a.m2219c("PushConnection", " -- Send Timeout --", this.f1578a.f1659l.getApplicationContext());
            if (this.f1578a.f1661o) {
                this.f1578a.f1661o = false;
            }
            this.f1578a.m2147a(false);
            this.f1578a.m2141j();
            C0578p.m2546b("PushConnection Send Timeout " + this.f1578a.f1659l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1578a.f1659l.getApplicationContext());
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$a */
    class C0481a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C0512e f1583a;

        C0481a(C0512e c0512e) {
            this.f1583a = c0512e;
            setName("PushService-PushConnection-readThread");
        }

        public void run() {
            while (!this.f1583a.f1653f) {
                byte[] a;
                try {
                    a = PushSocket.m2624a(this.f1583a.f1659l, C0512e.f1645c);
                } catch (Throwable e) {
                    Throwable th = e;
                    a = null;
                    if (C0430a.m1857b() > 0) {
                        C0553q.m2357a(this.f1583a.f1659l, "039908", PushSocket.getLastSocketError(), C0578p.m2521a(th));
                    }
                    C0527a.m2218b("PushConnection", "Get message exception", this.f1583a.f1659l.getApplicationContext());
                    C0553q.m2362a(this.f1583a.f1659l, th);
                }
                this.f1583a.f1650a.removeCallbacks(this.f1583a.f1666t);
                if (this.f1583a.f1661o) {
                    this.f1583a.f1661o = false;
                    this.f1583a.m2147a(true);
                }
                if (a == null || a.length == 0) {
                    int lastSocketError = PushSocket.getLastSocketError();
                    C0527a.m2216a("PushConnection", "Receive err,errno:" + lastSocketError, this.f1583a.f1659l.getApplicationContext());
                    this.f1583a.m2125a("039913", lastSocketError);
                    this.f1583a.m2141j();
                    C0578p.m2546b("PushConnection Receive err " + this.f1583a.f1659l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1583a.f1659l.getApplicationContext());
                } else {
                    try {
                        C0619e a2 = this.f1583a.f1651b.mo1296a(a, a.length);
                        if (a2 != null) {
                            try {
                                this.f1583a.f1651b.mo1299b(a2);
                            } catch (Throwable e2) {
                                C0527a.m2218b("PushConnection", "Handle message exception " + C0578p.m2521a(e2), this.f1583a.f1659l.getApplicationContext());
                                C0578p.m2546b("PushConnection Handle message exception " + this.f1583a.f1659l.getPackageName() + C0578p.m2521a(e2) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1583a.f1659l.getApplicationContext());
                                if (C0430a.m1857b() > 0) {
                                    C0553q.m2357a(this.f1583a.f1659l, "039910", PushSocket.getLastSocketError(), C0578p.m2521a(e2));
                                }
                                this.f1583a.m2141j();
                            }
                        }
                        this.f1583a.f1658k = 0;
                    } catch (Throwable e22) {
                        C0527a.m2219c("PushConnection", "Read message exception " + C0578p.m2521a(e22), this.f1583a.f1659l.getApplicationContext());
                        if (C0430a.m1857b() > 0) {
                            C0553q.m2357a(this.f1583a.f1659l, "039909", PushSocket.getLastSocketError(), C0578p.m2521a(e22));
                        }
                        this.f1583a.m2141j();
                        C0578p.m2546b("PushConnection Read message exception " + this.f1583a.f1659l.getPackageName() + C0578p.m2521a(e22) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1583a.f1659l.getApplicationContext());
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$b */
    class C0482b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C0512e f1584a;

        C0482b(C0512e c0512e) {
            this.f1584a = c0512e;
            setName("PushService-PushConnection-SendThread");
        }

        public void run() {
            while (!this.f1584a.f1653f) {
                C0619e c0619e = null;
                synchronized (this.f1584a.f1651b.m2714a()) {
                    if (this.f1584a.f1651b.m2714a().size() == 0) {
                        try {
                            this.f1584a.f1651b.m2714a().wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (this.f1584a.f1651b.m2714a().size() > 0) {
                        c0619e = (C0619e) this.f1584a.f1651b.m2714a().removeFirst();
                    }
                }
                if (!this.f1584a.f1653f) {
                    if (!(c0619e == null || c0619e.m2722a() == null)) {
                        int sendMsg;
                        if (c0619e.m2723b()) {
                            if (c0619e.m2724c()) {
                                this.f1584a.f1661o = true;
                            } else {
                                this.f1584a.f1661o = false;
                            }
                            this.f1584a.f1650a.removeCallbacks(this.f1584a.f1666t);
                            this.f1584a.f1650a.postDelayed(this.f1584a.f1666t, 60000);
                        }
                        try {
                            sendMsg = PushSocket.sendMsg(C0512e.f1645c, c0619e.m2722a(), c0619e.m2722a().length);
                        } catch (Exception e2) {
                            sendMsg = -1;
                        }
                        if (sendMsg == -1) {
                            this.f1584a.m2141j();
                            C0578p.m2546b("PushConnection sendMsg err " + this.f1584a.f1659l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + C0512e.f1645c + System.currentTimeMillis(), this.f1584a.f1659l.getApplicationContext());
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private C0512e(Context context) {
        this.f1659l = context;
        int g = m2154g();
        if (g >= 0 && g < this.f1668v.length) {
            this.f1669w = g;
        }
        m2146m();
        C0528g.m2222a(this.f1659l).m2243a(this.f1668v[this.f1669w]);
        this.f1649B = C0572k.m2460d(this.f1659l);
        this.f1663q = C0554h.m2369a(this.f1659l);
    }

    /* renamed from: a */
    public static C0512e m2120a(Context context) {
        if (f1647n == null) {
            f1647n = new C0512e(context);
        }
        return f1647n;
    }

    /* renamed from: a */
    private void m2125a(String str, int i) {
        final String str2 = str;
        final int i2 = i;
        C0559d.m2387a().m2388a(new C0420c(this, "insertAgentBehavior", (short) 95) {
            /* renamed from: c */
            final /* synthetic */ C0512e f1582c;

            /* renamed from: a */
            public void mo1272a() {
                try {
                    C0543i c0543i = new C0543i();
                    c0543i.d = str2;
                    c0543i.e = System.currentTimeMillis();
                    c0543i.f = C0532b.m2255b(this.f1582c.f1659l);
                    c0543i.g = i2;
                    if (str2.equals("030303")) {
                        c0543i.i = C0578p.m2604w(this.f1582c.f1659l);
                    } else if (str2.equals("030301")) {
                        c0543i.i = C0578p.m2606x(this.f1582c.f1659l);
                    }
                    C0553q.m2363b(this.f1582c.f1659l, c0543i);
                } catch (Exception e) {
                    C0527a.m2219c("PushConnection", "insertAgent exception", this.f1582c.f1659l.getApplicationContext());
                }
            }
        });
    }

    /* renamed from: i */
    private synchronized void m2139i() {
        if (this.f1652d || f1646e.booleanValue()) {
            C0527a.m2219c("PushConnection", "Connect return. mConnected:" + this.f1652d + " mConnectting:" + f1646e, this.f1659l.getApplicationContext());
        } else if (C0580j.m2614a(this.f1659l).m2619c()) {
            C0578p.m2546b("PushConnection connectImpl from " + this.f1659l.getPackageName() + " at Time " + System.currentTimeMillis(), this.f1659l);
            f1646e = Boolean.valueOf(true);
            f1645c = -1;
            Runnable c04761 = new C04761(this);
            if (this.f1664r != null) {
                this.f1664r.interrupt();
            }
            this.f1664r = new Thread(c04761);
            this.f1664r.setName("PushService-PushService-connect");
            this.f1664r.start();
        } else {
            C0527a.m2216a("PushConnection", "re-token", this.f1659l.getApplicationContext());
            C0528g.m2222a(this.f1659l).m2247d();
        }
    }

    /* renamed from: j */
    private void m2141j() {
        C0527a.m2219c("PushConnection", "disconnectedByPeer, mStoped == " + this.f1657j, this.f1659l.getApplicationContext());
        C0578p.m2546b("PushConnection destroy from " + this.f1659l.getPackageName() + " at Time " + System.currentTimeMillis(), this.f1659l);
        m2144k();
        if (!this.f1657j) {
            this.f1658k++;
            if (this.f1658k < 3) {
                this.f1650a.removeCallbacks(this.f1665s);
                int i = ((this.f1658k - 1) * 30) * 1000;
                if (this.f1658k == 1) {
                    i = 3000;
                }
                this.f1650a.postDelayed(this.f1665s, (long) i);
                C0527a.m2219c("PushConnection", "Schedule retry-- retry times: " + this.f1658k + " time delay: " + i, this.f1659l.getApplicationContext());
            }
        }
    }

    /* renamed from: k */
    private void m2144k() {
        C0527a.m2219c("PushConnection", "destroy", this.f1659l.getApplicationContext());
        if (this.f1650a != null) {
            this.f1650a.removeCallbacks(this.f1666t);
        }
        this.f1653f = true;
        this.f1652d = false;
        if (this.f1651b != null) {
            try {
                synchronized (this.f1651b.m2714a()) {
                    this.f1651b.m2714a().notifyAll();
                }
            } catch (Throwable e) {
                C0553q.m2362a(this.f1659l, e);
            }
        }
        PushSocket.m2622a(f1645c);
        if (this.f1651b != null) {
            this.f1651b.mo1298b();
        }
    }

    /* renamed from: l */
    private void m2145l() {
        Set<Long> keySet = this.f1654g.keySet();
        long currentTimeMillis = System.currentTimeMillis();
        C0560i c = C0528g.m2222a(this.f1659l).m2246c();
        if (c != null) {
            for (Long longValue : keySet) {
                long longValue2 = longValue.longValue();
                if (longValue2 < currentTimeMillis) {
                    c.m2416a((C0485a) this.f1654g.get(Long.valueOf(longValue2)));
                    this.f1654g.remove(Long.valueOf(longValue2));
                }
            }
        }
    }

    /* renamed from: m */
    private void m2146m() {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
        if (file.exists()) {
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && property.length() > 0) {
                        JSONArray jSONArray = new JSONArray(property);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.f1668v[i] = jSONArray.getInt(i);
                            this.f1669w = 0;
                            this.f1670x = 0;
                            this.f1672z = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.f1669w = Integer.parseInt(property2);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C0527a.m2218b("PushConnection", "error " + e2.getMessage(), this.f1659l.getApplicationContext());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C0527a.m2218b("PushConnection", "getTestConfig exception " + e.getMessage(), this.f1659l.getApplicationContext());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                C0527a.m2218b("PushConnection", "error " + e22.getMessage(), this.f1659l.getApplicationContext());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                C0527a.m2218b("PushConnection", "error " + e4.getMessage(), this.f1659l.getApplicationContext());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                C0527a.m2218b("PushConnection", "getTestConfig exception " + e.getMessage(), this.f1659l.getApplicationContext());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m2147a(boolean z) {
        Object d = C0572k.m2460d(this.f1659l);
        if (TextUtils.equals(this.f1649B, d)) {
            int e = m2152e();
            if (!z) {
                this.f1670x = 0;
                this.f1672z = 0;
                if (!C0572k.m2457a(this.f1659l)) {
                    this.f1669w++;
                } else if (this.f1669w > 0) {
                    this.f1669w--;
                    m2153f();
                }
            } else if (C0572k.m2457a(this.f1659l)) {
                m2153f();
                this.f1670x++;
                if (this.f1670x >= 3) {
                    this.f1670x = 0;
                    if (this.f1669w < this.f1668v.length - 1) {
                        this.f1670x = 0;
                        this.f1669w++;
                    }
                }
                if (this.f1672z >= 30) {
                    this.f1672z = 0;
                    C0543i c0543i = new C0543i();
                    c0543i.d = "030101";
                    c0543i.e = System.currentTimeMillis();
                    c0543i.f = C0532b.m2255b(this.f1659l);
                    c0543i.f1794a = m2152e();
                    C0553q.m2354a(this.f1659l, c0543i);
                }
            } else {
                this.f1669w++;
            }
            C0578p.m2546b("RTC stat change from " + e + " to " + m2152e(), this.f1659l);
        } else {
            this.f1669w = m2154g();
            this.f1670x = 0;
            C0578p.m2546b("RTC stat change " + m2152e() + " because of network changing", this.f1659l);
        }
        this.f1649B = d;
        C0528g.m2222a(this.f1659l).m2243a(m2152e());
    }

    /* renamed from: a */
    public boolean m2148a() {
        return this.f1652d;
    }

    /* renamed from: b */
    public void m2149b() {
        this.f1658k = 0;
        this.f1657j = false;
        m2139i();
    }

    /* renamed from: c */
    public void m2150c() {
        C0527a.m2219c("PushConnection", "---stop---", this.f1659l.getApplicationContext());
        C0578p.m2546b("PushConnection stop from " + this.f1659l.getPackageName() + " at Time " + System.currentTimeMillis(), this.f1659l);
        this.f1653f = true;
        this.f1657j = true;
        this.f1650a.removeCallbacks(this.f1665s);
        m2144k();
        f1647n = null;
    }

    /* renamed from: d */
    public void m2151d() {
        if (this.f1651b != null) {
            if (System.currentTimeMillis() - this.f1667u > 120000) {
                C0559d.m2387a().m2388a(new C0420c(this, "heartbeat", (short) 98) {
                    /* renamed from: a */
                    final /* synthetic */ C0512e f1579a;

                    /* renamed from: a */
                    public void mo1272a() {
                        long currentTimeMillis = System.currentTimeMillis();
                        int i = (int) ((currentTimeMillis / 60000) % 5);
                        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                        if (i == 0 && i2 < 15) {
                            try {
                                Thread.sleep((long) ((Math.random() * 60.0d) * 1000.0d));
                            } catch (InterruptedException e) {
                            }
                        }
                        this.f1579a.f1651b.mo1300c();
                        this.f1579a.f1667u = System.currentTimeMillis();
                        C0527a.m2219c("PushConnection", "sendHeartbeatMessage", this.f1579a.f1659l.getApplicationContext());
                    }
                });
            } else {
                C0527a.m2219c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.f1659l.getApplicationContext());
            }
        }
        m2145l();
    }

    /* renamed from: e */
    public int m2152e() {
        if (this.f1669w < 0) {
            this.f1669w = 0;
        } else if (this.f1669w >= this.f1668v.length) {
            this.f1669w = this.f1668v.length - 1;
        }
        return this.f1668v[this.f1669w];
    }

    /* renamed from: f */
    public void m2153f() {
        if (C0572k.m2458b(this.f1659l)) {
            C0574m.m2466a(this.f1659l, "com.baidu.pushservice.CUR_PERIOD_WIFI", this.f1669w);
        } else {
            C0574m.m2466a(this.f1659l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", this.f1669w);
        }
    }

    /* renamed from: g */
    public int m2154g() {
        return !C0572k.m2457a(this.f1659l) ? 0 : C0572k.m2458b(this.f1659l) ? C0574m.m2471b(this.f1659l, "com.baidu.pushservice.CUR_PERIOD_WIFI", 0) : C0574m.m2471b(this.f1659l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", 0);
    }
}
