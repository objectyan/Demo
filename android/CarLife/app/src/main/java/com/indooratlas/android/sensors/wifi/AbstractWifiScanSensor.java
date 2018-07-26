package com.indooratlas.android.sensors.wifi;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.indooratlas.android.sdk._internal.cz;
import com.indooratlas.android.sdk._internal.eb;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWifiScanSensor extends BroadcastReceiver {
    /* renamed from: a */
    protected final eb f24641a;
    /* renamed from: b */
    public final WifiManager f24642b;
    /* renamed from: c */
    public volatile boolean f24643c;
    /* renamed from: d */
    protected final int f24644d;
    /* renamed from: e */
    public Handler f24645e = new Handler();

    /* renamed from: com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor$a */
    public final class C6019a {
        /* renamed from: a */
        public int f24631a;
        /* renamed from: b */
        public long f24632b;
        /* renamed from: c */
        public long f24633c;
        /* renamed from: d */
        public long f24634d;
        /* renamed from: e */
        public float f24635e;
        /* renamed from: f */
        public int f24636f;
        /* renamed from: g */
        public long f24637g;
        /* renamed from: h */
        public int f24638h;
        /* renamed from: i */
        public int f24639i;
        /* renamed from: j */
        final /* synthetic */ AbstractWifiScanSensor f24640j;

        public C6019a(AbstractWifiScanSensor abstractWifiScanSensor) {
            this.f24640j = abstractWifiScanSensor;
        }

        public final String toString() {
            return "ScanStats{timesReceived=" + this.f24631a + ", startTime=" + this.f24632b + ", minInterval=" + this.f24633c + ", maxInterval=" + this.f24634d + ", averageFrequency=" + this.f24635e + ", timesScanned=" + this.f24636f + ", lastReceivedMillis=" + this.f24637g + ", maxResults=" + this.f24638h + ", minResults=" + this.f24639i + '}';
        }
    }

    public AbstractWifiScanSensor(int sensorType, WifiManager wifiManager, eb provider) {
        this.f24644d = sensorType;
        this.f24642b = wifiManager;
        this.f24641a = provider;
    }

    /* renamed from: a */
    public final void m21566a(List<ScanResult> list) {
        if (this.f24643c) {
            List arrayList;
            if (list == null) {
                arrayList = new ArrayList(0);
            } else {
                List<ScanResult> list2 = list;
            }
            String str = cz.f23362a;
            new Object[1][0] = list;
            eb ebVar = this.f24641a;
            int i = this.f24644d;
            ebVar.f23508e.a(i, ebVar.a(i, arrayList));
        }
    }

    /* renamed from: a */
    public boolean m21568a(long j) {
        if (this.f24643c) {
            String str = cz.f23362a;
            return false;
        }
        this.f24643c = true;
        String str2 = cz.f23362a;
        Object[] objArr = new Object[]{Integer.valueOf(this.f24644d), this};
        this.f24641a.f23509f.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        return true;
    }

    /* renamed from: a */
    public boolean m21567a() {
        if (this.f24643c) {
            this.f24643c = false;
            String str = cz.f23362a;
            Object[] objArr = new Object[]{Integer.valueOf(this.f24644d), this};
            this.f24641a.f23509f.unregisterReceiver(this);
            return true;
        }
        str = cz.f23362a;
        new Object[1][0] = getClass().getSimpleName();
        return false;
    }
}
