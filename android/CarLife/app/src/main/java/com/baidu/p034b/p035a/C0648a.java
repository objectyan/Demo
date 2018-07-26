package com.baidu.p034b.p035a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.baidu.b.a.a */
public class C0648a {
    /* renamed from: e */
    private static Method f2060e = null;
    /* renamed from: f */
    private static Method f2061f = null;
    /* renamed from: g */
    private static Method f2062g = null;
    /* renamed from: h */
    private static Class<?> f2063h = null;
    /* renamed from: r */
    private static char[] f2064r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    /* renamed from: a */
    private final long f2065a = Config.BPLUS_DELAY_TIME;
    /* renamed from: b */
    private Context f2066b = null;
    /* renamed from: c */
    private TelephonyManager f2067c = null;
    /* renamed from: d */
    private C0647b f2068d = new C0647b();
    /* renamed from: i */
    private WifiManager f2069i = null;
    /* renamed from: j */
    private C0646a f2070j = null;
    /* renamed from: k */
    private Object f2071k = null;
    /* renamed from: l */
    private Method f2072l = null;
    /* renamed from: m */
    private boolean f2073m = true;
    /* renamed from: n */
    private long f2074n = 0;
    /* renamed from: o */
    private String f2075o = null;
    /* renamed from: p */
    private int f2076p = 0;
    /* renamed from: q */
    private String f2077q = null;

    /* renamed from: com.baidu.b.a.a$a */
    protected class C0646a {
        /* renamed from: a */
        public List<ScanResult> f2051a = null;
        /* renamed from: b */
        final /* synthetic */ C0648a f2052b;
        /* renamed from: c */
        private long f2053c = 0;

        public C0646a(C0648a c0648a, List<ScanResult> list) {
            this.f2052b = c0648a;
            this.f2051a = list;
            this.f2053c = System.currentTimeMillis();
            m2811b();
        }

        /* renamed from: b */
        private void m2811b() {
            if (m2813a() >= 1) {
                Object obj = 1;
                for (int size = this.f2051a.size() - 1; size >= 1 && r2 != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.f2051a.get(i)).level < ((ScanResult) this.f2051a.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.f2051a.get(i + 1);
                            this.f2051a.set(i + 1, this.f2051a.get(i));
                            this.f2051a.set(i, scanResult);
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

        /* renamed from: c */
        private boolean m2812c() {
            long currentTimeMillis = System.currentTimeMillis() - this.f2053c;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        /* renamed from: a */
        public int m2813a() {
            return this.f2051a == null ? 0 : this.f2051a.size();
        }

        /* renamed from: a */
        public String m2814a(int i) {
            if (m2813a() < 1) {
                return null;
            }
            Object obj;
            Object obj2;
            boolean a = this.f2052b.m2825c();
            if (a) {
                i--;
                obj = null;
            } else {
                int i2 = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.f2051a.size();
            int i3 = 0;
            int i4 = 0;
            Object obj3 = 1;
            Object obj4 = obj;
            while (i3 < size) {
                if (((ScanResult) this.f2051a.get(i3)).level == 0) {
                    i2 = i4;
                    obj2 = obj3;
                    obj3 = obj4;
                } else {
                    String str = ((ScanResult) this.f2051a.get(i3)).BSSID;
                    i2 = ((ScanResult) this.f2051a.get(i3)).level;
                    str = str.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                    if (this.f2052b.f2075o == null || !str.equals(this.f2052b.f2075o)) {
                        if (i4 < i) {
                            stringBuffer.append("h");
                            stringBuffer.append(str);
                            stringBuffer.append(Config.MODEL);
                            stringBuffer.append(StrictMath.abs(i2));
                            i2 = i4 + 1;
                            obj2 = null;
                        } else {
                            i2 = i4;
                            obj2 = obj3;
                        }
                        if (i2 > i && obj4 != null) {
                            break;
                        }
                        obj3 = obj4;
                    } else {
                        this.f2052b.f2076p = StrictMath.abs(i2);
                        i2 = i4;
                        obj2 = obj3;
                        int i5 = 1;
                    }
                }
                i3++;
                obj4 = obj3;
                obj3 = obj2;
                i4 = i2;
            }
            obj2 = obj3;
            String str2 = a ? "h" + this.f2052b.f2075o + "km" + this.f2052b.f2076p : null;
            return obj2 == null ? str2 + stringBuffer.toString() : str2;
        }
    }

    /* renamed from: com.baidu.b.a.a$b */
    private class C0647b {
        /* renamed from: a */
        public int f2054a;
        /* renamed from: b */
        public int f2055b;
        /* renamed from: c */
        public int f2056c;
        /* renamed from: d */
        public int f2057d;
        /* renamed from: e */
        public char f2058e;
        /* renamed from: f */
        final /* synthetic */ C0648a f2059f;

        private C0647b(C0648a c0648a) {
            this.f2059f = c0648a;
            this.f2054a = -1;
            this.f2055b = -1;
            this.f2056c = -1;
            this.f2057d = -1;
            this.f2058e = '\u0000';
        }

        /* renamed from: a */
        private boolean m2815a() {
            return this.f2054a > -1 && this.f2055b > 0;
        }

        public String toString() {
            if (!m2815a()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.f2058e);
            stringBuffer.append("h");
            if (this.f2056c != 460) {
                stringBuffer.append(this.f2056c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[]{Integer.valueOf(this.f2057d), Integer.valueOf(this.f2054a), Integer.valueOf(this.f2055b)}));
            return stringBuffer.toString();
        }
    }

    public C0648a(Context context) {
        String deviceId;
        this.f2066b = context.getApplicationContext();
        String packageName = this.f2066b.getPackageName();
        try {
            this.f2067c = (TelephonyManager) this.f2066b.getSystemService("phone");
            deviceId = this.f2067c.getDeviceId();
        } catch (Exception e) {
            deviceId = null;
        }
        this.f2077q = "&" + packageName + "&" + deviceId;
        this.f2069i = (WifiManager) this.f2066b.getSystemService(C1981b.f6365e);
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.f2071k = declaredField.get(this.f2069i);
                this.f2072l = this.f2071k.getClass().getDeclaredMethod("startScan", new Class[]{Boolean.TYPE});
                if (this.f2072l != null) {
                    this.f2072l.setAccessible(true);
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    private static String m2818a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr[i2] = nextInt;
        i2 = i + 1;
        bArr[i] = nextInt2;
        return C0648a.m2819a(bArr);
    }

    /* renamed from: a */
    private static String m2819a(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            Object obj;
            Object obj2;
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            if (i2 + 2 < bArr.length) {
                i3 |= bArr[i2 + 2] & 255;
                obj2 = 1;
            } else {
                obj2 = null;
            }
            cArr[i + 3] = f2064r[obj2 != null ? 63 - (i3 & 63) : 64];
            int i4 = i3 >> 6;
            cArr[i + 2] = f2064r[obj != null ? 63 - (i4 & 63) : 64];
            i3 = i4 >> 6;
            cArr[i + 1] = f2064r[63 - (i3 & 63)];
            cArr[i + 0] = f2064r[63 - ((i3 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private void m2820a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.f2067c != null) {
            C0647b c0647b = new C0647b();
            String networkOperator = this.f2067c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.f2068d.f2056c;
                        }
                        c0647b.f2056c = intValue;
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
                        i = this.f2068d.f2057d;
                    }
                    c0647b.f2057d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c0647b.f2054a = ((GsmCellLocation) cellLocation).getLac();
                c0647b.f2055b = ((GsmCellLocation) cellLocation).getCid();
                c0647b.f2058e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c0647b.f2058e = 'w';
                if (f2063h == null) {
                    try {
                        f2063h = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        f2060e = f2063h.getMethod("getBaseStationId", new Class[0]);
                        f2061f = f2063h.getMethod("getNetworkId", new Class[0]);
                        f2062g = f2063h.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e2) {
                        f2063h = null;
                        return;
                    }
                }
                if (f2063h != null && f2063h.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) f2062g.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.f2068d.f2057d;
                        }
                        c0647b.f2057d = i;
                        c0647b.f2055b = ((Integer) f2060e.invoke(cellLocation, new Object[0])).intValue();
                        c0647b.f2054a = ((Integer) f2061f.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (c0647b.m2815a()) {
                this.f2068d = c0647b;
            }
        }
    }

    /* renamed from: b */
    private String m2822b(int i) {
        String c0647b;
        String a;
        if (i < 3) {
            i = 3;
        }
        try {
            m2820a(this.f2067c.getCellLocation());
            c0647b = this.f2068d.toString();
        } catch (Exception e) {
            c0647b = null;
        }
        if (c0647b == null) {
            c0647b = "Z";
        }
        try {
            if (this.f2070j == null || this.f2070j.m2812c()) {
                this.f2070j = new C0646a(this, this.f2069i.getScanResults());
            }
            a = this.f2070j.m2814a(i);
        } catch (Exception e2) {
            a = null;
        }
        if (a != null) {
            c0647b = c0647b + a;
        }
        return c0647b.equals("Z") ? null : C0648a.m2818a(c0647b + "t" + System.currentTimeMillis() + this.f2077q);
    }

    /* renamed from: c */
    private boolean m2825c() {
        String str = null;
        this.f2075o = null;
        this.f2076p = 0;
        WifiInfo connectionInfo = this.f2069i.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                str = bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
            }
            if (str.length() != 12) {
                return false;
            }
            this.f2075o = new String(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public String m2826a() {
        try {
            return m2822b(3);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public String m2827a(int i) {
        try {
            return m2822b(i);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public boolean m2828b() {
        if (this.f2069i == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f2074n;
        if (currentTimeMillis <= Config.BPLUS_DELAY_TIME && currentTimeMillis >= 0) {
            return false;
        }
        if (this.f2069i.isWifiEnabled()) {
            if (this.f2072l == null || this.f2071k == null) {
                this.f2069i.startScan();
            } else {
                try {
                    this.f2072l.invoke(this.f2071k, new Object[]{Boolean.valueOf(this.f2073m)});
                } catch (Exception e) {
                    this.f2069i.startScan();
                }
            }
            this.f2074n = System.currentTimeMillis();
            return true;
        }
        this.f2074n = 0;
        return false;
    }
}
