package com.baidu.location.p189b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.location.C3377f;
import com.baidu.location.p191d.C3283b;

/* renamed from: com.baidu.location.b.c */
public class C3218c {
    /* renamed from: d */
    private static C3218c f17505d = null;
    /* renamed from: a */
    private boolean f17506a = false;
    /* renamed from: b */
    private String f17507b = null;
    /* renamed from: c */
    private C3217a f17508c = null;
    /* renamed from: e */
    private int f17509e = -1;

    /* renamed from: com.baidu.location.b.c$a */
    public class C3217a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3218c f17504a;

        public C3217a(C3218c c3218c) {
            this.f17504a = c3218c;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    this.f17504a.f17506a = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        this.f17504a.f17509e = -1;
                    } else {
                        this.f17504a.f17509e = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            this.f17504a.f17507b = "4";
                            break;
                        case 3:
                        case 4:
                            this.f17504a.f17507b = "3";
                            break;
                        default:
                            this.f17504a.f17507b = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            this.f17504a.f17507b = C2578b.f8568g;
                            this.f17504a.f17506a = true;
                            break;
                        case 2:
                            this.f17504a.f17507b = "5";
                            this.f17504a.f17506a = true;
                            break;
                    }
                    if (this.f17504a.f17506a) {
                        C3283b.m13725a().m13731b();
                    } else {
                        C3283b.m13725a().m13732c();
                    }
                }
            } catch (Exception e) {
                this.f17504a.f17507b = null;
            }
        }
    }

    private C3218c() {
    }

    /* renamed from: a */
    public static synchronized C3218c m13487a() {
        C3218c c3218c;
        synchronized (C3218c.class) {
            if (f17505d == null) {
                f17505d = new C3218c();
            }
            c3218c = f17505d;
        }
        return c3218c;
    }

    /* renamed from: b */
    public void m13491b() {
        this.f17508c = new C3217a(this);
        C3377f.getServiceContext().registerReceiver(this.f17508c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* renamed from: c */
    public void m13492c() {
        if (this.f17508c != null) {
            try {
                C3377f.getServiceContext().unregisterReceiver(this.f17508c);
            } catch (Exception e) {
            }
        }
        this.f17508c = null;
    }

    /* renamed from: d */
    public String m13493d() {
        return this.f17507b;
    }

    /* renamed from: e */
    public boolean m13494e() {
        return this.f17506a;
    }

    /* renamed from: f */
    public int m13495f() {
        return this.f17509e;
    }
}
