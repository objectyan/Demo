package com.baidu.carlife;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public class ScreenListener {
    /* renamed from: a */
    private Context f2425a;
    /* renamed from: b */
    private ScreenBroadcastReceiver f2426b = new ScreenBroadcastReceiver();
    /* renamed from: c */
    private C0922a f2427c;

    /* renamed from: com.baidu.carlife.ScreenListener$a */
    public interface C0922a {
        /* renamed from: a */
        void mo1340a();

        /* renamed from: b */
        void mo1341b();

        /* renamed from: c */
        void mo1342c();
    }

    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ ScreenListener f2423a;
        /* renamed from: b */
        private String f2424b;

        private ScreenBroadcastReceiver(ScreenListener screenListener) {
            this.f2423a = screenListener;
            this.f2424b = null;
        }

        public void onReceive(Context context, Intent intent) {
            this.f2424b = intent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(this.f2424b)) {
                this.f2423a.f2427c.mo1340a();
            } else if ("android.intent.action.SCREEN_OFF".equals(this.f2424b)) {
                this.f2423a.f2427c.mo1341b();
            } else if ("android.intent.action.USER_PRESENT".equals(this.f2424b)) {
                this.f2423a.f2427c.mo1342c();
            }
        }
    }

    public ScreenListener(Context context) {
        this.f2425a = context;
    }

    /* renamed from: a */
    public void m3154a(C0922a listener) {
        this.f2427c = listener;
        m3152d();
    }

    /* renamed from: a */
    public void m3153a() {
        this.f2427c = null;
        m3156c();
    }

    /* renamed from: b */
    public void m3155b() {
        if (((PowerManager) this.f2425a.getSystemService("power")).isScreenOn()) {
            if (this.f2427c != null) {
                this.f2427c.mo1340a();
            }
        } else if (this.f2427c != null) {
            this.f2427c.mo1341b();
        }
    }

    /* renamed from: c */
    public void m3156c() {
        this.f2425a.unregisterReceiver(this.f2426b);
    }

    /* renamed from: d */
    private void m3152d() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.USER_PRESENT");
        this.f2425a.registerReceiver(this.f2426b, filter);
    }
}
