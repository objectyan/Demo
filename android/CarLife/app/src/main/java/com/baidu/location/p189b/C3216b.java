package com.baidu.location.p189b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.C3377f;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3371d;

/* renamed from: com.baidu.location.b.b */
public class C3216b {
    /* renamed from: a */
    private static C3216b f17497a = null;
    /* renamed from: b */
    private boolean f17498b = false;
    /* renamed from: c */
    private Handler f17499c = null;
    /* renamed from: d */
    private AlarmManager f17500d = null;
    /* renamed from: e */
    private C3215a f17501e = null;
    /* renamed from: f */
    private PendingIntent f17502f = null;
    /* renamed from: g */
    private long f17503g = 0;

    /* renamed from: com.baidu.location.b.b$1 */
    class C32141 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3216b f17495a;

        C32141(C3216b c3216b) {
            this.f17495a = c3216b;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        this.f17495a.m13480f();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 2:
                    try {
                        this.f17495a.m13481g();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.b.b$a */
    private class C3215a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3216b f17496a;

        private C3215a(C3216b c3216b) {
            this.f17496a = c3216b;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f17496a.f17498b && intent.getAction().equals("com.baidu.location.autonotifyloc_7.3.2") && this.f17496a.f17499c != null) {
                this.f17496a.f17502f = null;
                this.f17496a.f17499c.sendEmptyMessage(1);
            }
        }
    }

    private C3216b() {
    }

    /* renamed from: a */
    public static synchronized C3216b m13475a() {
        C3216b c3216b;
        synchronized (C3216b.class) {
            if (f17497a == null) {
                f17497a = new C3216b();
            }
            c3216b = f17497a;
        }
        return c3216b;
    }

    /* renamed from: f */
    private void m13480f() {
        if (System.currentTimeMillis() - this.f17503g >= 1000) {
            if (this.f17502f != null) {
                this.f17500d.cancel(this.f17502f);
                this.f17502f = null;
            }
            if (this.f17502f == null) {
                this.f17502f = PendingIntent.getBroadcast(C3377f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.3.2"), 134217728);
                this.f17500d.set(0, System.currentTimeMillis() + ((long) C3391g.f18369V), this.f17502f);
            }
            Message message = new Message();
            message.what = 22;
            if (System.currentTimeMillis() - this.f17503g >= ((long) C3391g.f18370W)) {
                this.f17503g = System.currentTimeMillis();
                if (!C3371d.m14289a().m14325m()) {
                    C3200h.m13362c().m13381b(message);
                }
            }
        }
    }

    /* renamed from: g */
    private void m13481g() {
        if (this.f17498b) {
            try {
                if (this.f17502f != null) {
                    this.f17500d.cancel(this.f17502f);
                    this.f17502f = null;
                }
                C3377f.getServiceContext().unregisterReceiver(this.f17501e);
            } catch (Exception e) {
            }
            this.f17500d = null;
            this.f17501e = null;
            this.f17499c = null;
            this.f17498b = false;
        }
    }

    /* renamed from: b */
    public void m13482b() {
        if (!this.f17498b && C3391g.f18369V >= 10000) {
            if (this.f17499c == null) {
                this.f17499c = new C32141(this);
            }
            this.f17500d = (AlarmManager) C3377f.getServiceContext().getSystemService("alarm");
            this.f17501e = new C3215a();
            C3377f.getServiceContext().registerReceiver(this.f17501e, new IntentFilter("com.baidu.location.autonotifyloc_7.3.2"), "android.permission.ACCESS_FINE_LOCATION", null);
            this.f17502f = PendingIntent.getBroadcast(C3377f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.3.2"), 134217728);
            this.f17500d.set(0, System.currentTimeMillis() + ((long) C3391g.f18369V), this.f17502f);
            this.f17498b = true;
            this.f17503g = System.currentTimeMillis();
        }
    }

    /* renamed from: c */
    public void m13483c() {
        if (this.f17498b && this.f17499c != null) {
            this.f17499c.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void m13484d() {
        if (this.f17498b && this.f17499c != null) {
            this.f17499c.sendEmptyMessage(1);
        }
    }

    /* renamed from: e */
    public void m13485e() {
        if (this.f17498b && this.f17499c != null) {
            this.f17499c.sendEmptyMessage(1);
        }
    }
}
