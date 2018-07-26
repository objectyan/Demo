package com.indooratlas.android.sdk._internal;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class dx {
    /* renamed from: a */
    public String f23478a;
    /* renamed from: b */
    public String f23479b;
    /* renamed from: c */
    public String f23480c;
    /* renamed from: d */
    public int f23481d;
    /* renamed from: e */
    public int f23482e;
    /* renamed from: f */
    public int f23483f;
    /* renamed from: g */
    public int f23484g;
    /* renamed from: h */
    public int f23485h;
    /* renamed from: i */
    public CharSequence f23486i;
    /* renamed from: j */
    public long f23487j;
    /* renamed from: k */
    public CharSequence f23488k;

    private dx() {
    }

    /* renamed from: a */
    public static List<dx> m20374a(List<ScanResult> list) {
        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ScanResult scanResult : list) {
            dx dxVar = new dx();
            dxVar.f23478a = scanResult.BSSID;
            dxVar.f23479b = scanResult.SSID;
            dxVar.f23480c = scanResult.capabilities;
            dxVar.f23484g = scanResult.frequency;
            dxVar.f23485h = scanResult.level;
            if (VERSION.SDK_INT >= 17) {
                dxVar.f23487j = scanResult.timestamp;
            }
            if (VERSION.SDK_INT >= 23) {
                dxVar.f23481d = scanResult.centerFreq0;
                dxVar.f23482e = scanResult.centerFreq1;
                dxVar.f23483f = scanResult.channelWidth;
                dxVar.f23486i = scanResult.operatorFriendlyName;
                dxVar.f23488k = scanResult.venueName;
            }
            copyOnWriteArrayList.add(dxVar);
        }
        return copyOnWriteArrayList;
    }
}
