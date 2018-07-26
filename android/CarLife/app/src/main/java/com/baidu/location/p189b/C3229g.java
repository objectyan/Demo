package com.baidu.location.p189b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.location.C3377f;
import com.baidu.location.indoor.C3406a;
import com.baidu.location.p187a.C3192e;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p193e.C3349d;

/* renamed from: com.baidu.location.b.g */
public class C3229g {
    /* renamed from: b */
    private static C3229g f17548b = null;
    /* renamed from: a */
    final Handler f17549a = new Handler();
    /* renamed from: c */
    private C3227a f17550c = null;
    /* renamed from: d */
    private boolean f17551d = false;
    /* renamed from: e */
    private boolean f17552e = false;
    /* renamed from: f */
    private boolean f17553f = false;
    /* renamed from: g */
    private boolean f17554g = true;
    /* renamed from: h */
    private boolean f17555h = false;
    /* renamed from: i */
    private C3228b f17556i = new C3228b();

    /* renamed from: com.baidu.location.b.g$a */
    private class C3227a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3229g f17546a;

        private C3227a(C3229g c3229g) {
            this.f17546a = c3229g;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && this.f17546a.f17549a != null) {
                this.f17546a.m13541f();
            }
        }
    }

    /* renamed from: com.baidu.location.b.g$b */
    private class C3228b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3229g f17547a;

        private C3228b(C3229g c3229g) {
            this.f17547a = c3229g;
        }

        public void run() {
            int d = C3192e.m13329a().m13341d();
            if (this.f17547a.f17551d && C3218c.m13487a().m13494e() && C3349d.m14171a().m14186d() && d != 1) {
                this.f17547a.m13542g();
            }
            if (this.f17547a.f17551d && C3218c.m13487a().m13494e()) {
                C3225f.m13526a().m13534c();
            }
            if (this.f17547a.f17551d && C3218c.m13487a().m13494e() && d != 1) {
                C3301g.m13879a().m13890f();
                new C3406a(C3377f.getServiceContext()).m14527d();
            }
            if (this.f17547a.f17551d && this.f17547a.f17554g) {
                if (d != 1) {
                    C3211m.m13441a().m13461e();
                    C3211m.m13441a().m13459c();
                    C3243b.m13581a().m13593b();
                }
                this.f17547a.f17549a.postDelayed(this, (long) C3391g.f18363P);
                this.f17547a.f17553f = true;
                return;
            }
            this.f17547a.f17553f = false;
        }
    }

    private C3229g() {
    }

    /* renamed from: a */
    public static synchronized C3229g m13535a() {
        C3229g c3229g;
        synchronized (C3229g.class) {
            if (f17548b == null) {
                f17548b = new C3229g();
            }
            c3229g = f17548b;
        }
        return c3229g;
    }

    /* renamed from: f */
    private void m13541f() {
        State state;
        State state2 = State.UNKNOWN;
        try {
            state = ((ConnectivityManager) C3377f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (State.CONNECTED != state) {
            this.f17551d = false;
        } else if (!this.f17551d) {
            this.f17551d = true;
            this.f17549a.postDelayed(this.f17556i, (long) C3391g.f18363P);
            this.f17553f = true;
        }
    }

    /* renamed from: g */
    private void m13542g() {
        C3349d.m14171a().m14196n();
        C3349d.m14171a().m14192j();
    }

    /* renamed from: b */
    public synchronized void m13543b() {
        if (C3377f.isServing) {
            if (!this.f17555h) {
                try {
                    this.f17550c = new C3227a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NetworkListener.f2257d);
                    C3377f.getServiceContext().registerReceiver(this.f17550c, intentFilter);
                    this.f17552e = true;
                    m13541f();
                } catch (Exception e) {
                }
                this.f17554g = true;
                this.f17555h = true;
            }
        }
    }

    /* renamed from: c */
    public synchronized void m13544c() {
        if (this.f17555h) {
            try {
                C3377f.getServiceContext().unregisterReceiver(this.f17550c);
            } catch (Exception e) {
            }
            this.f17554g = false;
            this.f17555h = false;
            this.f17553f = false;
            this.f17550c = null;
        }
    }

    /* renamed from: d */
    public void m13545d() {
        if (this.f17555h) {
            this.f17554g = true;
            if (!this.f17553f && this.f17554g) {
                this.f17549a.postDelayed(this.f17556i, (long) C3391g.f18363P);
                this.f17553f = true;
            }
        }
    }

    /* renamed from: e */
    public void m13546e() {
        this.f17554g = false;
    }
}
