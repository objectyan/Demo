package com.baidu.location.p194f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.location.C3377f;
import com.baidu.location.indoor.C3439d;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p187a.C3208k;
import com.baidu.location.p187a.C3211m;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p190c.C3248c;
import com.baidu.location.p191d.C3296e;
import com.baidu.location.p191d.p192a.C3268e;
import com.baidu.location.wifihistory.SClient;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.baidu.location.f.f */
public class C3376f {
    /* renamed from: a */
    public static long f18284a = 0;
    /* renamed from: b */
    private static C3376f f18285b = null;
    /* renamed from: c */
    private WifiManager f18286c = null;
    /* renamed from: d */
    private C3375a f18287d = null;
    /* renamed from: e */
    private C3372e f18288e = null;
    /* renamed from: f */
    private long f18289f = 0;
    /* renamed from: g */
    private long f18290g = 0;
    /* renamed from: h */
    private boolean f18291h = false;
    /* renamed from: i */
    private Handler f18292i = new Handler();
    /* renamed from: j */
    private long f18293j = 0;
    /* renamed from: k */
    private long f18294k = 0;

    /* renamed from: com.baidu.location.f.f$a */
    private class C3375a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3376f f18281a;
        /* renamed from: b */
        private long f18282b;
        /* renamed from: c */
        private boolean f18283c;

        /* renamed from: com.baidu.location.f.f$a$1 */
        class C33741 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3375a f18280a;

            C33741(C3375a c3375a) {
                this.f18280a = c3375a;
            }

            public void run() {
                WifiInfo wifiInfo = null;
                if (this.f18280a.f18281a.f18286c != null) {
                    WifiInfo wifiInfo2;
                    try {
                        this.f18280a.f18281a.f18286c.getConnectionInfo();
                        wifiInfo2 = wifiInfo;
                    } catch (Throwable th) {
                        wifiInfo2 = wifiInfo;
                    }
                    if (wifiInfo != null && wifiInfo.getBSSID() != null) {
                        try {
                            C3296e.m13839a().m13843b(wifiInfo2.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        private C3375a(C3376f c3376f) {
            this.f18281a = c3376f;
            this.f18282b = 0;
            this.f18283c = false;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                String action = intent.getAction();
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    C3376f.f18284a = System.currentTimeMillis() / 1000;
                    this.f18281a.m14364v();
                    C3248c.m13596a().m13608d();
                    C3200h.m13362c().m13391j();
                    if (C3439d.m14680a().m14744f()) {
                        C3439d.m14680a().f18608c.obtainMessage(41).sendToTarget();
                    }
                    this.f18281a.m14383s();
                    if (System.currentTimeMillis() - C3208k.m13433b() <= Config.BPLUS_DELAY_TIME) {
                        C3211m.m13444a(C3208k.m13434c(), this.f18281a.m14380p(), C3208k.m13435d(), C3208k.m13428a());
                    }
                } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(State.CONNECTED) && System.currentTimeMillis() - this.f18282b >= Config.BPLUS_DELAY_TIME) {
                    this.f18282b = System.currentTimeMillis();
                    if (this.f18283c) {
                        C3248c.m13596a().m13609e();
                        if (C3181a.m13265a().m13278c()) {
                            C3243b.m13581a().m13593b();
                        }
                        if (!C3181a.m13265a().m13278c() && this.f18281a.f18286c != null) {
                            this.f18281a.f18292i.postDelayed(new C33741(this), 1000);
                            return;
                        }
                        return;
                    }
                    this.f18283c = true;
                }
            }
        }
    }

    private C3376f() {
    }

    /* renamed from: a */
    public static synchronized C3376f m14355a() {
        C3376f c3376f;
        synchronized (C3376f.class) {
            if (f18285b == null) {
                f18285b = new C3376f();
            }
            c3376f = f18285b;
        }
        return c3376f;
    }

    /* renamed from: a */
    public static boolean m14357a(C3372e c3372e, C3372e c3372e2) {
        return C3376f.m14358a(c3372e, c3372e2, 0.7f);
    }

    /* renamed from: a */
    public static boolean m14358a(C3372e c3372e, C3372e c3372e2, float f) {
        if (c3372e == null || c3372e2 == null) {
            return false;
        }
        List list = c3372e.f18275a;
        List list2 = c3372e2.f18275a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        List linkedList = new LinkedList();
        int size = list.size();
        int size2 = list2.size();
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3;
            long j2;
            String str = ((ScanResult) list.get(i2)).BSSID;
            if (str == null) {
                long j3 = j;
                i3 = i;
                j2 = j3;
            } else {
                int i4;
                int i5 = 0;
                while (i5 < size2) {
                    if (str.equals(((ScanResult) list2.get(i5)).BSSID)) {
                        i4 = i + 1;
                        j += (long) ((((ScanResult) list.get(i2)).level - ((ScanResult) list2.get(i5)).level) * (((ScanResult) list.get(i2)).level - ((ScanResult) list2.get(i5)).level));
                        break;
                    }
                    i5++;
                }
                i4 = i;
                if (i5 == size2) {
                    linkedList.add(list.get(i2));
                    j2 = ((long) ((((ScanResult) list.get(i2)).level + 100) * (((ScanResult) list.get(i2)).level + 100))) + j;
                    i3 = i4;
                } else {
                    j2 = j;
                    i3 = i4;
                }
            }
            i2++;
            i = i3;
            j = j2;
        }
        double sqrt = Math.sqrt((double) j) / ((double) size);
        return ((float) i) >= ((float) size) * f;
    }

    /* renamed from: a */
    public static boolean m14359a(List<ScanResult> list, List<ScanResult> list2, float f) {
        if (list == null || list2 == null) {
            return false;
        }
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = (float) (size + size2);
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str == null) {
                i3 = i2;
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i3 = i2 + 1;
                        break;
                    }
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return ((float) (i2 * 2)) >= f2 * f;
    }

    /* renamed from: b */
    private String m14361b(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    /* renamed from: j */
    public static boolean m14363j() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C3377f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: v */
    private void m14364v() {
        if (this.f18286c != null) {
            try {
                List scanResults = this.f18286c.getScanResults();
                if (scanResults != null) {
                    C3372e c3372e = new C3372e(scanResults, System.currentTimeMillis());
                    if (this.f18288e == null || !c3372e.m14334a(this.f18288e)) {
                        this.f18288e = c3372e;
                        SClient.getInstance().updateWifiHistory(this.f18288e.f18275a);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void m14365a(int i) {
        this.f18293j += (long) i;
        if (this.f18293j > 9000) {
            this.f18293j = 9000;
        }
    }

    /* renamed from: a */
    public boolean m14366a(long j) {
        try {
            if ((!this.f18286c.isWifiEnabled() && (VERSION.SDK_INT <= 17 || !this.f18286c.isScanAlwaysAvailable())) || C3376f.m14363j()) {
                return false;
            }
            C3372e c3372e = new C3372e(this.f18286c.getScanResults(), 0);
            return c3372e != null && c3372e.m14333a(j);
        } catch (NoSuchMethodError e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: b */
    public void m14367b() {
        this.f18293j = 0;
    }

    /* renamed from: c */
    public synchronized void m14368c() {
        if (!this.f18291h) {
            if (C3377f.isServing) {
                this.f18286c = (WifiManager) C3377f.getServiceContext().getApplicationContext().getSystemService(C1981b.f6365e);
                this.f18287d = new C3375a();
                try {
                    C3377f.getServiceContext().registerReceiver(this.f18287d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    C3377f.getServiceContext().registerReceiver(this.f18287d, new IntentFilter("android.net.wifi.STATE_CHANGE"));
                } catch (Exception e) {
                }
                this.f18291h = true;
            }
        }
    }

    /* renamed from: d */
    public List<WifiConfiguration> m14369d() {
        List<WifiConfiguration> list = null;
        try {
            if (this.f18286c != null) {
                list = this.f18286c.getConfiguredNetworks();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /* renamed from: e */
    public synchronized void m14370e() {
        if (this.f18291h) {
            try {
                C3377f.getServiceContext().unregisterReceiver(this.f18287d);
                f18284a = 0;
            } catch (Exception e) {
            }
            this.f18287d = null;
            this.f18286c = null;
            this.f18291h = false;
        }
    }

    /* renamed from: f */
    public boolean m14371f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f18290g > 0 && currentTimeMillis - this.f18290g <= Config.BPLUS_DELAY_TIME) {
            return false;
        }
        this.f18290g = currentTimeMillis;
        m14367b();
        return m14372g();
    }

    /* renamed from: g */
    public boolean m14372g() {
        if (this.f18286c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f18289f > 0) {
            if (currentTimeMillis - this.f18289f <= this.f18293j + Config.BPLUS_DELAY_TIME || currentTimeMillis - (f18284a * 1000) <= this.f18293j + Config.BPLUS_DELAY_TIME) {
                return false;
            }
            if (C3376f.m14363j() && currentTimeMillis - this.f18289f <= BNOffScreenParams.MIN_ENTER_INTERVAL + this.f18293j) {
                return false;
            }
        }
        return m14374i();
    }

    /* renamed from: h */
    public String m14373h() {
        String str = "";
        if (this.f18286c == null) {
            return str;
        }
        try {
            return (this.f18286c.isWifiEnabled() || (VERSION.SDK_INT > 17 && this.f18286c.isScanAlwaysAvailable())) ? "&wifio=1" : str;
        } catch (NoSuchMethodError e) {
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    /* renamed from: i */
    public boolean m14374i() {
        long currentTimeMillis = System.currentTimeMillis() - this.f18294k;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 2000) {
            return false;
        }
        this.f18294k = System.currentTimeMillis();
        try {
            if (!this.f18286c.isWifiEnabled() && (VERSION.SDK_INT <= 17 || !this.f18286c.isScanAlwaysAvailable())) {
                return false;
            }
            this.f18286c.startScan();
            this.f18289f = System.currentTimeMillis();
            return true;
        } catch (NoSuchMethodError e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: k */
    public boolean m14375k() {
        try {
            if ((!this.f18286c.isWifiEnabled() && (VERSION.SDK_INT <= 17 || !this.f18286c.isScanAlwaysAvailable())) || C3376f.m14363j()) {
                return false;
            }
            C3372e c3372e = new C3372e(this.f18286c.getScanResults(), 0);
            return c3372e != null && c3372e.m14345e();
        } catch (NoSuchMethodError e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: l */
    public WifiInfo m14376l() {
        if (this.f18286c == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.f18286c.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null || connectionInfo.getRssi() <= -100) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                bssid = bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return null;
                }
            }
            return connectionInfo;
        } catch (Exception e) {
            return null;
        } catch (Error e2) {
            return null;
        }
    }

    /* renamed from: m */
    public String m14377m() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo l = C3376f.m14355a().m14376l();
        if (l == null || l.getBSSID() == null) {
            return null;
        }
        String replace = l.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
        int rssi = l.getRssi();
        String n = C3376f.m14355a().m14378n();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (replace == null || rssi >= 100) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(replace);
        stringBuffer.append(";");
        stringBuffer.append("" + rssi + ";");
        String ssid = l.getSSID();
        if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
            ssid = ssid.replace("&", JNISearchConst.LAYER_ID_DIVIDER);
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (n != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(n);
        }
        return stringBuffer.toString();
    }

    /* renamed from: n */
    public String m14378n() {
        if (this.f18286c == null) {
            return null;
        }
        DhcpInfo dhcpInfo = this.f18286c.getDhcpInfo();
        return dhcpInfo != null ? m14361b((long) dhcpInfo.gateway) : null;
    }

    /* renamed from: o */
    public boolean m14379o() {
        boolean z = false;
        if (this.f18286c != null) {
            try {
                z = this.f18286c.isScanAlwaysAvailable();
            } catch (NoSuchMethodError e) {
            }
        }
        return z;
    }

    /* renamed from: p */
    public C3372e m14380p() {
        return (this.f18288e == null || !this.f18288e.m14352l()) ? m14382r() : this.f18288e;
    }

    /* renamed from: q */
    public C3372e m14381q() {
        return (this.f18288e == null || !this.f18288e.m14353m()) ? m14382r() : this.f18288e;
    }

    /* renamed from: r */
    public C3372e m14382r() {
        if (this.f18286c != null) {
            try {
                return new C3372e(this.f18286c.getScanResults(), this.f18289f);
            } catch (Exception e) {
            }
        }
        return new C3372e(null, 0);
    }

    /* renamed from: s */
    public void m14383s() {
        if (C3268e.m13681a().f17736a) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append("W");
            stringBuffer.append("\t");
            stringBuffer.append(m14381q().m14331a(52));
            stringBuffer.append("\n");
            C3268e.m13681a().m13685a(stringBuffer);
            m14374i();
        }
    }

    /* renamed from: t */
    public boolean m14384t() {
        try {
            return this.f18286c.isWifiEnabled() || (VERSION.SDK_INT > 17 && this.f18286c.isScanAlwaysAvailable());
        } catch (NoSuchMethodError e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: u */
    public String m14385u() {
        String str = null;
        try {
            WifiInfo connectionInfo = this.f18286c.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return str;
    }
}
