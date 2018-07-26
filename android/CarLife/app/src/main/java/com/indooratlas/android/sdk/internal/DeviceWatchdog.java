package com.indooratlas.android.sdk.internal;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.indooratlas.android.sdk._internal.be;
import com.indooratlas.android.sdk._internal.bf;
import com.indooratlas.android.sdk._internal.bf.C5818b;
import com.indooratlas.android.sdk._internal.ct;
import com.indooratlas.android.sdk._internal.cv;

public final class DeviceWatchdog {
    /* renamed from: a */
    public final DeviceStatusObserver f24592a = new DeviceStatusObserver(this);
    /* renamed from: b */
    public C6017a f24593b;
    /* renamed from: c */
    public DeviceWatchdog f24594c;
    /* renamed from: d */
    NetworkInfo f24595d;
    /* renamed from: e */
    boolean f24596e = false;
    /* renamed from: f */
    boolean f24597f = true;
    /* renamed from: g */
    public boolean f24598g = false;
    /* renamed from: h */
    boolean f24599h = false;
    /* renamed from: i */
    boolean f24600i = false;
    /* renamed from: j */
    public bf f24601j;
    /* renamed from: k */
    ConnectivityManager f24602k;
    /* renamed from: l */
    WifiManager f24603l;
    /* renamed from: m */
    private boolean f24604m = false;
    /* renamed from: n */
    private LocationManager f24605n;

    public class DeviceStatusObserver extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ DeviceWatchdog f24591a;

        public DeviceStatusObserver(DeviceWatchdog this$0) {
            this.f24591a = this$0;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
                this.f24591a.f24599h = intent.getBooleanExtra("state", false);
            }
            if (intent.getAction().equals(NetworkListener.f2258e)) {
                switch (intent.getIntExtra("wifi_state", 4)) {
                    case 0:
                    case 1:
                        this.f24591a.f24596e = false;
                        break;
                    case 2:
                    case 3:
                        this.f24591a.f24596e = true;
                        break;
                }
                this.f24591a.f24597f = cv.a(this.f24591a.f24603l);
            }
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                this.f24591a.f24597f = cv.a(this.f24591a.f24603l);
            }
            if (intent.getAction().equals(NetworkListener.f2257d)) {
                boolean z;
                int i;
                this.f24591a.f24595d = this.f24591a.f24602k.getActiveNetworkInfo();
                DeviceWatchdog deviceWatchdog = this.f24591a;
                if (this.f24591a.f24595d != null) {
                    z = true;
                } else {
                    z = false;
                }
                deviceWatchdog.f24598g = z;
                new Object[1][0] = this.f24591a.f24595d;
                C5818b c5818b = this.f24591a.f24601j.f23156a;
                if (this.f24591a.f24598g) {
                    i = 1019;
                } else {
                    i = 1020;
                }
                c5818b.b(i, this.f24591a.f24595d);
            }
            if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
                this.f24591a.m21561b();
            }
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10)) {
                    case 10:
                        this.f24591a.f24600i = false;
                        this.f24591a.f24601j.f23156a.b(1024);
                        break;
                    case 12:
                        this.f24591a.f24600i = be.f23085a.f23083i;
                        this.f24591a.f24601j.f23156a.b(C1253f.eZ);
                        break;
                }
            }
            if (this.f24591a.f24593b != null) {
                this.f24591a.f24593b.m21559a(this.f24591a.f24594c);
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk.internal.DeviceWatchdog$a */
    public interface C6017a {
        /* renamed from: a */
        void m21559a(DeviceWatchdog deviceWatchdog);
    }

    public DeviceWatchdog(bf sdkEngine) {
        boolean z = false;
        if (sdkEngine == null) {
            throw new NullPointerException("SDK Engine not initialised yet");
        }
        this.f24601j = sdkEngine;
        if (this.f24601j.f23174s != null) {
            this.f24602k = this.f24601j.f23174s;
        } else {
            this.f24602k = (ConnectivityManager) this.f24601j.f23170o.getSystemService("connectivity");
        }
        this.f24603l = (WifiManager) this.f24601j.f23170o.getSystemService(C1981b.f6365e);
        this.f24605n = (LocationManager) this.f24601j.f23170o.getSystemService("location");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetworkListener.f2258e);
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction(NetworkListener.f2257d);
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        if (be.f23085a.f23083i) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        }
        this.f24601j.f23170o.registerReceiver(this.f24592a, intentFilter);
        this.f24596e = this.f24603l.isWifiEnabled();
        this.f24597f = cv.a(this.f24603l);
        this.f24595d = this.f24602k.getActiveNetworkInfo();
        this.f24598g = this.f24595d != null;
        if (VERSION.SDK_INT < 17) {
            boolean z2;
            if (System.getInt(sdkEngine.f23170o.getContentResolver(), "airplane_mode_on", 0) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f24599h = z2;
        } else {
            this.f24599h = System.getInt(sdkEngine.f23170o.getContentResolver(), "airplane_mode_on", 0) != 0;
        }
        if (be.f23085a.f23083i) {
            if (ct.a(this.f24601j.f23170o, "android.permission.BLUETOOTH")) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                    z = true;
                }
            }
            this.f24600i = z;
        }
        m21561b();
        this.f24594c = this;
    }

    /* renamed from: b */
    final void m21561b() {
        this.f24604m = this.f24605n.isProviderEnabled(C1981b.f6367g);
    }

    /* renamed from: a */
    public final int m21560a() {
        if (this.f24598g) {
            this.f24597f = cv.a(this.f24603l);
            if (this.f24597f && !this.f24599h && (VERSION.SDK_INT < 23 || this.f24604m)) {
                return 2;
            }
        }
        return 10;
    }
}
