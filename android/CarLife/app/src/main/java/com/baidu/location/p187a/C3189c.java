package com.baidu.location.p187a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3391g;
import com.baidu.mobstat.Config;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.a.c */
public class C3189c {
    /* renamed from: g */
    private static Method f17306g = null;
    /* renamed from: h */
    private static Method f17307h = null;
    /* renamed from: i */
    private static Method f17308i = null;
    /* renamed from: j */
    private static Method f17309j = null;
    /* renamed from: k */
    private static Method f17310k = null;
    /* renamed from: l */
    private static Class<?> f17311l = null;
    /* renamed from: a */
    String f17312a = null;
    /* renamed from: b */
    String f17313b = null;
    /* renamed from: c */
    C3187c f17314c = new C3187c(this);
    /* renamed from: d */
    private Context f17315d = null;
    /* renamed from: e */
    private TelephonyManager f17316e = null;
    /* renamed from: f */
    private C3184a f17317f = new C3184a();
    /* renamed from: m */
    private WifiManager f17318m = null;
    /* renamed from: n */
    private C3188d f17319n = null;
    /* renamed from: o */
    private String f17320o = null;
    /* renamed from: p */
    private LocationClientOption f17321p;
    /* renamed from: q */
    private C3185b f17322q;
    /* renamed from: r */
    private String f17323r = null;
    /* renamed from: s */
    private String f17324s = null;
    /* renamed from: t */
    private String f17325t = null;

    /* renamed from: com.baidu.location.a.c$a */
    private class C3184a {
        /* renamed from: a */
        public int f17282a;
        /* renamed from: b */
        public int f17283b;
        /* renamed from: c */
        public int f17284c;
        /* renamed from: d */
        public int f17285d;
        /* renamed from: e */
        public int f17286e;
        /* renamed from: f */
        public int f17287f;
        /* renamed from: g */
        public char f17288g;
        /* renamed from: h */
        final /* synthetic */ C3189c f17289h;

        private C3184a(C3189c c3189c) {
            this.f17289h = c3189c;
            this.f17282a = -1;
            this.f17283b = -1;
            this.f17284c = -1;
            this.f17285d = -1;
            this.f17286e = Integer.MAX_VALUE;
            this.f17287f = Integer.MAX_VALUE;
            this.f17288g = '\u0000';
        }

        /* renamed from: b */
        private boolean m13289b() {
            return this.f17282a > -1 && this.f17283b > 0;
        }

        /* renamed from: a */
        public String m13290a() {
            if (!m13289b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(this.f17288g);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[]{Integer.valueOf(this.f17284c), Integer.valueOf(this.f17285d), Integer.valueOf(this.f17282a), Integer.valueOf(this.f17283b)}));
            if (this.f17286e < Integer.MAX_VALUE && this.f17287f < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) this.f17287f) / 14400.0d), Double.valueOf(((double) this.f17286e) / 14400.0d)}));
            }
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.baidu.location.a.c$b */
    public interface C3185b {
        /* renamed from: a */
        void m13291a(BDLocation bDLocation);
    }

    /* renamed from: com.baidu.location.a.c$c */
    class C3187c extends C3186e {
        /* renamed from: a */
        String f17301a;
        /* renamed from: b */
        final /* synthetic */ C3189c f17302b;

        C3187c(C3189c c3189c) {
            this.f17302b = c3189c;
            this.f17301a = null;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            String encodeTp4 = Jni.encodeTp4(this.f17301a);
            this.f17301a = null;
            this.k.put("bloc", encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                try {
                    BDLocation bDLocation;
                    try {
                        bDLocation = new BDLocation(this.j);
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation != null) {
                        if (bDLocation.getLocType() == 161) {
                            bDLocation.setCoorType(this.f17302b.f17321p.coorType);
                            bDLocation.setLocationID(Jni.en1(this.f17302b.f17312a + ";" + this.f17302b.f17313b + ";" + bDLocation.getTime()));
                            this.f17302b.f17322q.m13291a(bDLocation);
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    /* renamed from: com.baidu.location.a.c$d */
    protected class C3188d {
        /* renamed from: a */
        public List<ScanResult> f17303a = null;
        /* renamed from: b */
        final /* synthetic */ C3189c f17304b;
        /* renamed from: c */
        private long f17305c = 0;

        public C3188d(C3189c c3189c, List<ScanResult> list) {
            this.f17304b = c3189c;
            this.f17303a = list;
            this.f17305c = System.currentTimeMillis();
            m13306c();
        }

        /* renamed from: b */
        private String m13305b() {
            WifiInfo connectionInfo = this.f17304b.f17318m.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "") : null;
                return (replace == null || replace.length() == 12) ? new String(replace) : null;
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: c */
        private void m13306c() {
            if (m13307a() >= 1) {
                Object obj = 1;
                for (int size = this.f17303a.size() - 1; size >= 1 && r2 != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.f17303a.get(i)).level < ((ScanResult) this.f17303a.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.f17303a.get(i + 1);
                            this.f17303a.set(i + 1, this.f17303a.get(i));
                            this.f17303a.set(i, scanResult);
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                }
            }
        }

        /* renamed from: a */
        public int m13307a() {
            return this.f17303a == null ? 0 : this.f17303a.size();
        }

        /* renamed from: a */
        public String m13308a(int i) {
            if (m13307a() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.f17303a.size();
            Object obj = 1;
            int i2 = 0;
            String b = m13305b();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                int i6;
                if (((ScanResult) this.f17303a.get(i5)).level == 0) {
                    i6 = i2;
                } else {
                    i3++;
                    if (obj != null) {
                        stringBuffer.append("&wf=");
                        obj = null;
                    } else {
                        stringBuffer.append("|");
                    }
                    String replace = ((ScanResult) this.f17303a.get(i5)).BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                    stringBuffer.append(replace);
                    if (b != null && replace.equals(b)) {
                        i4 = i3;
                    }
                    i6 = ((ScanResult) this.f17303a.get(i5)).level;
                    if (i6 < 0) {
                        i6 = -i6;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i6)}));
                    i6 = i2 + 1;
                    if (i6 > i) {
                        break;
                    }
                }
                i5++;
                i2 = i6;
            }
            if (i4 > 0) {
                stringBuffer.append("&wf_n=");
                stringBuffer.append(i4);
            }
            return obj != null ? null : stringBuffer.toString();
        }
    }

    public C3189c(Context context) {
        this.f17315d = context.getApplicationContext();
        try {
            this.f17316e = (TelephonyManager) this.f17315d.getSystemService("phone");
        } catch (Exception e) {
        }
        this.f17318m = (WifiManager) this.f17315d.getApplicationContext().getSystemService(C1981b.f6365e);
    }

    /* renamed from: a */
    private String m13310a(int i) {
        String a;
        String a2;
        if (i < 3) {
            i = 3;
        }
        try {
            m13311a(this.f17316e.getCellLocation());
            a = this.f17317f.m13290a();
        } catch (Exception e) {
            a = null;
        }
        try {
            this.f17319n = null;
            this.f17319n = new C3188d(this, this.f17318m.getScanResults());
            a2 = this.f17319n.m13308a(i);
        } catch (Exception e2) {
            a2 = null;
        }
        if (a == null && a2 == null) {
            this.f17323r = null;
            return null;
        }
        if (a2 != null) {
            a = a + a2;
        }
        if (a == null) {
            return null;
        }
        this.f17323r = a;
        if (this.f17320o != null) {
            this.f17323r += this.f17320o;
        }
        return a + this.f17320o;
    }

    /* renamed from: a */
    private void m13311a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.f17316e != null) {
            C3184a c3184a = new C3184a();
            String networkOperator = this.f17316e.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.f17317f.f17284c;
                        }
                        c3184a.f17284c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] toCharArray = substring.toCharArray();
                        while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                            i++;
                        }
                    }
                    i = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (i < 0) {
                        i = this.f17317f.f17285d;
                    }
                    c3184a.f17285d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c3184a.f17282a = ((GsmCellLocation) cellLocation).getLac();
                c3184a.f17283b = ((GsmCellLocation) cellLocation).getCid();
                c3184a.f17288g = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c3184a.f17288g = 'c';
                if (f17311l == null) {
                    try {
                        f17311l = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        f17306g = f17311l.getMethod("getBaseStationId", new Class[0]);
                        f17307h = f17311l.getMethod("getNetworkId", new Class[0]);
                        f17308i = f17311l.getMethod("getSystemId", new Class[0]);
                        f17309j = f17311l.getMethod("getBaseStationLatitude", new Class[0]);
                        f17310k = f17311l.getMethod("getBaseStationLongitude", new Class[0]);
                    } catch (Exception e2) {
                        f17311l = null;
                        return;
                    }
                }
                if (f17311l != null && f17311l.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) f17308i.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.f17317f.f17285d;
                        }
                        c3184a.f17285d = i;
                        c3184a.f17283b = ((Integer) f17306g.invoke(cellLocation, new Object[0])).intValue();
                        c3184a.f17282a = ((Integer) f17307h.invoke(cellLocation, new Object[0])).intValue();
                        Object invoke = f17309j.invoke(cellLocation, new Object[0]);
                        if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                            c3184a.f17286e = ((Integer) invoke).intValue();
                        }
                        invoke = f17310k.invoke(cellLocation, new Object[0]);
                        if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                            c3184a.f17287f = ((Integer) invoke).intValue();
                        }
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (c3184a.m13289b()) {
                this.f17317f = c3184a;
            } else {
                this.f17317f = null;
            }
        }
    }

    /* renamed from: a */
    public String m13314a() {
        try {
            return m13310a(15);
        } catch (Exception e) {
            return null;
        }
    }
}
