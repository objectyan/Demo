package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor.C6019a;

final class dz extends AbstractWifiScanSensor {
    /* renamed from: f */
    long f23490f;
    /* renamed from: g */
    private C6019a f23491g = new C6019a(this);
    /* renamed from: h */
    private long f23492h;
    /* renamed from: i */
    private Runnable f23493i = new C58611(this);

    /* renamed from: com.indooratlas.android.sdk._internal.dz$1 */
    class C58611 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ dz f23489a;

        C58611(dz dzVar) {
            this.f23489a = dzVar;
        }

        public final void run() {
            this.f23489a.m20376b();
        }
    }

    dz(eb ebVar, WifiManager wifiManager) {
        super(-100, wifiManager, ebVar);
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        if (!"android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
            str = cz.f23362a;
            new Object[1][0] = intent.getAction();
        } else if (this.c) {
            a(this.b.getScanResults());
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f23492h) - this.f23490f;
            if (elapsedRealtime > 0) {
                m20376b();
                return;
            }
            String str2 = cz.f23362a;
            new Object[1][0] = Long.valueOf(-elapsedRealtime);
            this.e.postDelayed(this.f23493i, -elapsedRealtime);
        } else {
            str = cz.f23362a;
        }
    }

    /* renamed from: a */
    final boolean m20378a(long j) {
        if (j < 200 || j < 0) {
            this.f23490f = 200;
            String str = cz.f23362a;
        } else {
            this.f23490f = j;
        }
        boolean a = super.a(j);
        m20376b();
        return a;
    }

    /* renamed from: a */
    final boolean m20377a() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f23493i);
        }
        return super.a();
    }

    /* renamed from: b */
    private void m20376b() {
        if (this.c) {
            String str = cz.f23362a;
            this.b.startScan();
            this.f23492h = SystemClock.elapsedRealtime();
            C6019a c6019a = this.f23491g;
            c6019a.f24636f++;
            return;
        }
        str = cz.f23362a;
    }
}
