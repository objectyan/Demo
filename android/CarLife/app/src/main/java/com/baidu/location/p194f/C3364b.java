package com.baidu.location.p194f;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3216b;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.f.b */
public class C3364b {
    /* renamed from: a */
    public static int f18212a = 0;
    /* renamed from: b */
    public static int f18213b = 0;
    /* renamed from: c */
    private static C3364b f18214c = null;
    /* renamed from: k */
    private static Method f18215k = null;
    /* renamed from: l */
    private static Method f18216l = null;
    /* renamed from: m */
    private static Method f18217m = null;
    /* renamed from: n */
    private static Method f18218n = null;
    /* renamed from: o */
    private static Method f18219o = null;
    /* renamed from: p */
    private static Class<?> f18220p = null;
    /* renamed from: d */
    private TelephonyManager f18221d = null;
    /* renamed from: e */
    private Object f18222e = null;
    /* renamed from: f */
    private C3362a f18223f = new C3362a();
    /* renamed from: g */
    private C3362a f18224g = null;
    /* renamed from: h */
    private List<C3362a> f18225h = null;
    /* renamed from: i */
    private C3363a f18226i = null;
    /* renamed from: j */
    private boolean f18227j = false;
    /* renamed from: q */
    private boolean f18228q = false;

    /* renamed from: com.baidu.location.f.b$a */
    private class C3363a extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ C3364b f18211a;

        public C3363a(C3364b c3364b) {
            this.f18211a = c3364b;
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation != null) {
                try {
                    this.f18211a.m14269k();
                } catch (Exception e) {
                }
                C3216b.m13475a().m13485e();
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (this.f18211a.f18223f == null) {
                return;
            }
            if (this.f18211a.f18223f.f18208i == 'g') {
                this.f18211a.f18223f.f18207h = signalStrength.getGsmSignalStrength();
            } else if (this.f18211a.f18223f.f18208i == 'c') {
                this.f18211a.f18223f.f18207h = signalStrength.getCdmaDbm();
            }
        }
    }

    private C3364b() {
    }

    /* renamed from: a */
    private int m14257a(int i) {
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    /* renamed from: a */
    private CellLocation m14258a(List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i;
        CellLocation cdmaCellLocation;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        CellLocation cellLocation = null;
        int i2 = 0;
        CellLocation cellLocation2 = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj != null) {
                try {
                    Class loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    i = loadClass.isInstance(obj) ? 1 : loadClass2.isInstance(obj) ? 2 : loadClass3.isInstance(obj) ? 3 : loadClass4.isInstance(obj) ? 4 : 0;
                    if (i > 0) {
                        Object obj2 = null;
                        if (i == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Exception e) {
                                i2 = i;
                            }
                        } else if (i == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (i == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (i == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        obj = C3391g.m14430a(obj2, "getCellIdentity", new Object[0]);
                        if (obj == null) {
                            i2 = i;
                        } else if (i == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(C3391g.m14441b(obj, "getBasestationId", new Object[0]), C3391g.m14441b(obj, "getLatitude", new Object[0]), C3391g.m14441b(obj, "getLongitude", new Object[0]), C3391g.m14441b(obj, "getSystemId", new Object[0]), C3391g.m14441b(obj, "getNetworkId", new Object[0]));
                                cellLocation2 = cellLocation;
                                break;
                            } catch (Exception e2) {
                                cellLocation2 = cdmaCellLocation;
                                i2 = i;
                            }
                        } else if (i == 3) {
                            r3 = C3391g.m14441b(obj, "getTac", new Object[0]);
                            r2 = C3391g.m14441b(obj, "getCi", new Object[0]);
                            cdmaCellLocation = new GsmCellLocation();
                            try {
                                cdmaCellLocation.setLacAndCid(r3, r2);
                                r12 = cellLocation2;
                                cellLocation2 = cdmaCellLocation;
                                cdmaCellLocation = r12;
                                break;
                            } catch (Exception e3) {
                                cellLocation = cdmaCellLocation;
                                i2 = i;
                            }
                        } else {
                            r3 = C3391g.m14441b(obj, "getLac", new Object[0]);
                            r2 = C3391g.m14441b(obj, "getCid", new Object[0]);
                            cdmaCellLocation = new GsmCellLocation();
                            try {
                                cdmaCellLocation.setLacAndCid(r3, r2);
                                r12 = cellLocation2;
                                cellLocation2 = cdmaCellLocation;
                                cdmaCellLocation = r12;
                                break;
                            } catch (Exception e4) {
                                cellLocation = cdmaCellLocation;
                                i2 = i;
                            }
                        }
                    } else {
                        i2 = i;
                    }
                } catch (Exception e5) {
                }
            }
        }
        i = i2;
        cdmaCellLocation = cellLocation2;
        cellLocation2 = cellLocation;
        return i != 4 ? cellLocation2 : cdmaCellLocation;
    }

    /* renamed from: a */
    private C3362a m14259a(CellInfo cellInfo) {
        Object obj = null;
        int i = -1;
        int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C3362a c3362a = new C3362a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c3362a.f18202c = m14257a(cellIdentity.getMcc());
            c3362a.f18203d = m14257a(cellIdentity.getMnc());
            c3362a.f18200a = m14257a(cellIdentity.getLac());
            c3362a.f18201b = m14257a(cellIdentity.getCid());
            c3362a.f18208i = 'g';
            c3362a.f18207h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            obj = 1;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c3362a.f18204e = cellIdentity2.getLatitude();
            c3362a.f18205f = cellIdentity2.getLongitude();
            c3362a.f18203d = m14257a(cellIdentity2.getSystemId());
            c3362a.f18200a = m14257a(cellIdentity2.getNetworkId());
            c3362a.f18201b = m14257a(cellIdentity2.getBasestationId());
            c3362a.f18208i = 'c';
            c3362a.f18207h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            if (this.f18223f == null || this.f18223f.f18202c <= 0) {
                try {
                    String networkOperator = this.f18221d.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        r2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (r2 < 0) {
                            r2 = -1;
                        }
                        i = r2;
                    }
                } catch (Exception e) {
                }
                if (i > 0) {
                    c3362a.f18202c = i;
                }
            } else {
                c3362a.f18202c = this.f18223f.f18202c;
            }
            r2 = 1;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c3362a.f18202c = m14257a(cellIdentity3.getMcc());
            c3362a.f18203d = m14257a(cellIdentity3.getMnc());
            c3362a.f18200a = m14257a(cellIdentity3.getTac());
            c3362a.f18201b = m14257a(cellIdentity3.getCi());
            c3362a.f18208i = 'g';
            c3362a.f18207h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            r2 = 1;
        }
        if (intValue >= 18 && r2 == null) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c3362a.f18202c = m14257a(cellIdentity4.getMcc());
                    c3362a.f18203d = m14257a(cellIdentity4.getMnc());
                    c3362a.f18200a = m14257a(cellIdentity4.getLac());
                    c3362a.f18201b = m14257a(cellIdentity4.getCid());
                    c3362a.f18208i = 'g';
                    c3362a.f18207h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e2) {
            }
        }
        try {
            c3362a.f18206g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        } catch (Error e3) {
            c3362a.f18206g = System.currentTimeMillis();
        }
        return c3362a;
    }

    /* renamed from: a */
    private C3362a m14260a(CellLocation cellLocation) {
        return m14261a(cellLocation, false);
    }

    /* renamed from: a */
    private C3362a m14261a(CellLocation cellLocation, boolean z) {
        int i = 0;
        if (cellLocation == null || this.f18221d == null) {
            return null;
        }
        C3362a c3362a = new C3362a();
        if (z) {
            c3362a.m14252f();
        }
        c3362a.f18206g = System.currentTimeMillis();
        try {
            String networkOperator = this.f18221d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f18223f.f18202c;
                    }
                    c3362a.f18202c = intValue;
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
                    i = this.f18223f.f18203d;
                }
                c3362a.f18203d = i;
            }
            f18212a = this.f18221d.getSimState();
        } catch (Exception e) {
            f18213b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            c3362a.f18200a = ((GsmCellLocation) cellLocation).getLac();
            c3362a.f18201b = ((GsmCellLocation) cellLocation).getCid();
            c3362a.f18208i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c3362a.f18208i = 'c';
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 5) {
                return c3362a;
            }
            if (f18220p == null) {
                try {
                    f18220p = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f18215k = f18220p.getMethod("getBaseStationId", new Class[0]);
                    f18216l = f18220p.getMethod("getNetworkId", new Class[0]);
                    f18217m = f18220p.getMethod("getSystemId", new Class[0]);
                    f18218n = f18220p.getMethod("getBaseStationLatitude", new Class[0]);
                    f18219o = f18220p.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    f18220p = null;
                    f18213b = 2;
                    return c3362a;
                }
            }
            if (f18220p != null && f18220p.isInstance(cellLocation)) {
                try {
                    int intValue2 = ((Integer) f18217m.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.f18223f.f18203d;
                    }
                    c3362a.f18203d = intValue2;
                    c3362a.f18201b = ((Integer) f18215k.invoke(cellLocation, new Object[0])).intValue();
                    c3362a.f18200a = ((Integer) f18216l.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = f18218n.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        c3362a.f18204e = ((Integer) invoke).intValue();
                    }
                    invoke = f18219o.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        c3362a.f18205f = ((Integer) invoke).intValue();
                    }
                } catch (Exception e3) {
                    f18213b = 3;
                    return c3362a;
                }
            }
        }
        m14265c(c3362a);
        return c3362a;
    }

    /* renamed from: a */
    public static synchronized C3364b m14262a() {
        C3364b c3364b;
        synchronized (C3364b.class) {
            if (f18214c == null) {
                f18214c = new C3364b();
            }
            c3364b = f18214c;
        }
        return c3364b;
    }

    /* renamed from: c */
    private void m14265c(C3362a c3362a) {
        if (!c3362a.m14248b()) {
            return;
        }
        if (this.f18223f == null || !this.f18223f.m14247a(c3362a)) {
            this.f18223f = c3362a;
            if (c3362a.m14248b()) {
                int size = this.f18225h.size();
                C3362a c3362a2 = size == 0 ? null : (C3362a) this.f18225h.get(size - 1);
                if (c3362a2 == null || c3362a2.f18201b != this.f18223f.f18201b || c3362a2.f18200a != this.f18223f.f18200a) {
                    this.f18225h.add(this.f18223f);
                    if (this.f18225h.size() > 3) {
                        this.f18225h.remove(0);
                    }
                    m14268j();
                    this.f18228q = false;
                }
            } else if (this.f18225h != null) {
                this.f18225h.clear();
            }
        }
    }

    /* renamed from: d */
    private String m14266d(C3362a c3362a) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Integer.valueOf(VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.f18221d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    stringBuilder.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered()) {
                            C3362a a = m14259a(cellInfo);
                            if (!(a == null || a.f18200a == -1 || a.f18201b == -1)) {
                                if (c3362a.f18200a != a.f18200a) {
                                    stringBuilder.append(a.f18200a + "|" + a.f18201b + "|" + a.f18207h + ";");
                                } else {
                                    stringBuilder.append("|" + a.f18201b + "|" + a.f18207h + ";");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            } catch (NoSuchMethodError e2) {
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: i */
    private void m14267i() {
        String k = C3391g.m14455k();
        if (k != null) {
            File file = new File(k + File.separator + "lcvif.dat");
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    for (int i = 0; i < 3; i++) {
                        long readLong = randomAccessFile.readLong();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        int readInt5 = randomAccessFile.readInt();
                        char c = '\u0000';
                        if (readInt5 == 1) {
                            c = 'g';
                        }
                        if (readInt5 == 2) {
                            c = 'c';
                        }
                        if (readLong != 0) {
                            C3362a c3362a = new C3362a(readInt3, readInt4, readInt, readInt2, 0, c);
                            c3362a.f18206g = readLong;
                            if (c3362a.m14248b()) {
                                this.f18228q = true;
                                this.f18225h.add(c3362a);
                            }
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: j */
    private void m14268j() {
        int i = 0;
        if (this.f18225h != null || this.f18224g != null) {
            if (this.f18225h == null && this.f18224g != null) {
                this.f18225h = new LinkedList();
                this.f18225h.add(this.f18224g);
            }
            String k = C3391g.m14455k();
            if (k != null) {
                File file = new File(k + File.separator + "lcvif.dat");
                int size = this.f18225h.size();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeLong(((C3362a) this.f18225h.get(size - 1)).f18206g);
                    randomAccessFile.writeInt(size);
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(2);
                    }
                    while (i < size) {
                        randomAccessFile.writeLong(((C3362a) this.f18225h.get(i)).f18206g);
                        randomAccessFile.writeInt(((C3362a) this.f18225h.get(i)).f18202c);
                        randomAccessFile.writeInt(((C3362a) this.f18225h.get(i)).f18203d);
                        randomAccessFile.writeInt(((C3362a) this.f18225h.get(i)).f18200a);
                        randomAccessFile.writeInt(((C3362a) this.f18225h.get(i)).f18201b);
                        if (((C3362a) this.f18225h.get(i)).f18208i == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (((C3362a) this.f18225h.get(i)).f18208i == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                        i++;
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: k */
    private void m14269k() {
        C3362a c3362a = null;
        C3362a n = m14272n();
        if (n != null) {
            m14265c(n);
        }
        if (n == null || !n.m14248b()) {
            CellLocation cellLocation;
            try {
                cellLocation = this.f18221d.getCellLocation();
            } catch (Throwable th) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                c3362a = m14260a(cellLocation);
            }
            if (c3362a == null || !c3362a.m14248b()) {
                CellLocation l = m14270l();
                if (l != null) {
                    m14261a(l, true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private android.telephony.CellLocation m14270l() {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.f18222e;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r2 = r7.m14271m();	 Catch:{ Exception -> 0x0069 }
        r3 = r2.isInstance(r0);	 Catch:{ Exception -> 0x0069 }
        if (r3 == 0) goto L_0x0076;
    L_0x0010:
        r2 = r2.cast(r0);	 Catch:{ Exception -> 0x0069 }
        r3 = "getCellLocation";
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ NoSuchMethodException -> 0x005d, Exception -> 0x0060 }
        r0 = com.baidu.location.p188h.C3391g.m14430a(r2, r3, r0);	 Catch:{ NoSuchMethodException -> 0x005d, Exception -> 0x0060 }
    L_0x001e:
        if (r0 != 0) goto L_0x002f;
    L_0x0020:
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x0072, Exception -> 0x0070 }
        r5 = 0;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NoSuchMethodException -> 0x0072, Exception -> 0x0070 }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x0072, Exception -> 0x0070 }
        r0 = com.baidu.location.p188h.C3391g.m14430a(r2, r3, r4);	 Catch:{ NoSuchMethodException -> 0x0072, Exception -> 0x0070 }
    L_0x002f:
        if (r0 != 0) goto L_0x0043;
    L_0x0031:
        r3 = "getCellLocationGemini";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x006e, Exception -> 0x006c }
        r5 = 0;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NoSuchMethodException -> 0x006e, Exception -> 0x006c }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x006e, Exception -> 0x006c }
        r0 = com.baidu.location.p188h.C3391g.m14430a(r2, r3, r4);	 Catch:{ NoSuchMethodException -> 0x006e, Exception -> 0x006c }
    L_0x0043:
        if (r0 != 0) goto L_0x0057;
    L_0x0045:
        r0 = "getAllCellInfo";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x0066 }
        r0 = com.baidu.location.p188h.C3391g.m14430a(r2, r0, r3);	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x0066 }
        r0 = (java.util.List) r0;	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x0066 }
    L_0x0051:
        r0 = r7.m14258a(r0);	 Catch:{ Exception -> 0x0069 }
        if (r0 == 0) goto L_0x0057;
    L_0x0057:
        if (r0 == 0) goto L_0x0074;
    L_0x0059:
        r0 = (android.telephony.CellLocation) r0;	 Catch:{ Exception -> 0x0069 }
    L_0x005b:
        r1 = r0;
        goto L_0x0005;
    L_0x005d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x001e;
    L_0x0060:
        r0 = move-exception;
        r0 = r1;
        goto L_0x001e;
    L_0x0063:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0051;
    L_0x0066:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0051;
    L_0x0069:
        r0 = move-exception;
        r0 = r1;
        goto L_0x005b;
    L_0x006c:
        r3 = move-exception;
        goto L_0x0043;
    L_0x006e:
        r3 = move-exception;
        goto L_0x0043;
    L_0x0070:
        r3 = move-exception;
        goto L_0x002f;
    L_0x0072:
        r3 = move-exception;
        goto L_0x002f;
    L_0x0074:
        r0 = r1;
        goto L_0x005b;
    L_0x0076:
        r0 = r1;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.b.l():android.telephony.CellLocation");
    }

    /* renamed from: m */
    private Class<?> m14271m() {
        String str;
        Class<?> cls = null;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (m14273o()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = cls;
                break;
        }
        try {
            cls = systemClassLoader.loadClass(str);
        } catch (Exception e) {
        }
        return cls;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    private com.baidu.location.p194f.C3362a m14272n() {
        /*
        r6 = this;
        r2 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r1 = 17;
        if (r0 >= r1) goto L_0x0010;
    L_0x000f:
        return r2;
    L_0x0010:
        r0 = r6.f18221d;	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r0 = r0.getAllCellInfo();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r0 == 0) goto L_0x0054;
    L_0x0018:
        r1 = r0.size();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r1 <= 0) goto L_0x0054;
    L_0x001e:
        r4 = r0.iterator();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r1 = r2;
    L_0x0023:
        r0 = r4.hasNext();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r0 == 0) goto L_0x0055;
    L_0x0029:
        r0 = r4.next();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r0 = (android.telephony.CellInfo) r0;	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r3 = r0.isRegistered();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r3 == 0) goto L_0x005b;
    L_0x0035:
        r3 = 0;
        if (r1 == 0) goto L_0x0039;
    L_0x0038:
        r3 = 1;
    L_0x0039:
        r0 = r6.m14259a(r0);	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r0 == 0) goto L_0x0023;
    L_0x003f:
        r5 = r0.m14248b();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        if (r5 != 0) goto L_0x004a;
    L_0x0045:
        r0 = r2;
    L_0x0046:
        if (r1 != 0) goto L_0x005b;
    L_0x0048:
        r1 = r0;
        goto L_0x0023;
    L_0x004a:
        if (r3 == 0) goto L_0x0046;
    L_0x004c:
        r0 = r0.m14256j();	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r1.f18209j = r0;	 Catch:{ Exception -> 0x0059, NoSuchMethodError -> 0x0057 }
        r2 = r1;
        goto L_0x000f;
    L_0x0054:
        r1 = r2;
    L_0x0055:
        r2 = r1;
        goto L_0x000f;
    L_0x0057:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0059:
        r0 = move-exception;
        goto L_0x000f;
    L_0x005b:
        r0 = r1;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.b.n():com.baidu.location.f.a");
    }

    /* renamed from: o */
    private int m14273o() {
        int i = 0;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Exception e) {
        }
        if (i != 0) {
            return i;
        }
        try {
            Class.forName("android.telephony.TelephonyManager2");
            return 2;
        } catch (Exception e2) {
            return i;
        }
    }

    /* renamed from: a */
    public String m14274a(C3362a c3362a) {
        String str = "";
        try {
            str = m14266d(c3362a);
            if (str != null && !str.equals("") && !str.equals("&nc=")) {
                return str;
            }
            List<NeighboringCellInfo> neighboringCellInfo = this.f18221d.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                String str2 = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    str = (lac == -1 || neighboringCellInfo2.getCid() == -1) ? str2 : c3362a.f18200a != lac ? str2 + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";" : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";";
                    int i2 = i + 1;
                    if (i2 >= 8) {
                        break;
                    }
                    i = i2;
                    str2 = str;
                }
                str = str2;
            }
            return (str == null || !str.equals("&nc=")) ? str : null;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
    }

    /* renamed from: b */
    public String m14275b(C3362a c3362a) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(c3362a.f18208i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(c3362a.f18202c), Integer.valueOf(c3362a.f18203d), Integer.valueOf(c3362a.f18200a), Integer.valueOf(c3362a.f18201b), Integer.valueOf(c3362a.f18207h)}));
        if (c3362a.f18204e < Integer.MAX_VALUE && c3362a.f18205f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) c3362a.f18205f) / 14400.0d), Double.valueOf(((double) c3362a.f18204e) / 14400.0d)}));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(c3362a.f18206g);
        if (this.f18225h != null && this.f18225h.size() > 0) {
            int size = this.f18225h.size();
            stringBuffer.append("&clt=");
            for (int i = 0; i < size; i++) {
                C3362a c3362a2 = (C3362a) this.f18225h.get(i);
                if (c3362a2.f18202c != c3362a.f18202c) {
                    stringBuffer.append(c3362a2.f18202c);
                }
                stringBuffer.append("|");
                if (c3362a2.f18203d != c3362a.f18203d) {
                    stringBuffer.append(c3362a2.f18203d);
                }
                stringBuffer.append("|");
                if (c3362a2.f18200a != c3362a.f18200a) {
                    stringBuffer.append(c3362a2.f18200a);
                }
                stringBuffer.append("|");
                if (c3362a2.f18201b != c3362a.f18201b) {
                    stringBuffer.append(c3362a2.f18201b);
                }
                stringBuffer.append("|");
                stringBuffer.append((System.currentTimeMillis() - c3362a2.f18206g) / 1000);
                stringBuffer.append(";");
            }
        }
        if (f18212a > 100) {
            f18212a = 0;
        }
        stringBuffer.append("&cs=" + ((f18213b << 8) + f18212a));
        if (c3362a.f18209j != null) {
            stringBuffer.append(c3362a.f18209j);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized void m14276b() {
        /*
        r3 = this;
        r1 = 1;
        monitor-enter(r3);
        r0 = r3.f18227j;	 Catch:{ all -> 0x0048 }
        if (r0 != r1) goto L_0x0008;
    L_0x0006:
        monitor-exit(r3);
        return;
    L_0x0008:
        r0 = com.baidu.location.C3377f.isServing;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0006;
    L_0x000c:
        r0 = com.baidu.location.C3377f.getServiceContext();	 Catch:{ all -> 0x0048 }
        r1 = "phone";
        r0 = r0.getSystemService(r1);	 Catch:{ all -> 0x0048 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ all -> 0x0048 }
        r3.f18221d = r0;	 Catch:{ all -> 0x0048 }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x0048 }
        r0.<init>();	 Catch:{ all -> 0x0048 }
        r3.f18225h = r0;	 Catch:{ all -> 0x0048 }
        r0 = new com.baidu.location.f.b$a;	 Catch:{ all -> 0x0048 }
        r0.<init>(r3);	 Catch:{ all -> 0x0048 }
        r3.f18226i = r0;	 Catch:{ all -> 0x0048 }
        r3.m14267i();	 Catch:{ all -> 0x0048 }
        r0 = r3.f18221d;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0006;
    L_0x0030:
        r0 = r3.f18226i;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0006;
    L_0x0034:
        r0 = r3.f18221d;	 Catch:{ Exception -> 0x007a }
        r1 = r3.f18226i;	 Catch:{ Exception -> 0x007a }
        r2 = 272; // 0x110 float:3.81E-43 double:1.344E-321;
        r0.listen(r1, r2);	 Catch:{ Exception -> 0x007a }
    L_0x003d:
        r0 = r3.m14273o();	 Catch:{ Throwable -> 0x0059 }
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x004b;
            case 2: goto L_0x005e;
            default: goto L_0x0044;
        };
    L_0x0044:
        r0 = 1;
        r3.f18227j = r0;	 Catch:{ all -> 0x0048 }
        goto L_0x0006;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    L_0x004b:
        r0 = com.baidu.location.C3377f.getServiceContext();	 Catch:{ Throwable -> 0x0059 }
        r1 = "phone_msim";
        r0 = com.baidu.location.p188h.C3391g.m14429a(r0, r1);	 Catch:{ Throwable -> 0x0059 }
        r3.f18222e = r0;	 Catch:{ Throwable -> 0x0059 }
        goto L_0x0044;
    L_0x0059:
        r0 = move-exception;
        r0 = 0;
        r3.f18222e = r0;	 Catch:{ all -> 0x0048 }
        goto L_0x0044;
    L_0x005e:
        r0 = com.baidu.location.C3377f.getServiceContext();	 Catch:{ Throwable -> 0x0059 }
        r1 = "phone2";
        r0 = com.baidu.location.p188h.C3391g.m14429a(r0, r1);	 Catch:{ Throwable -> 0x0059 }
        r3.f18222e = r0;	 Catch:{ Throwable -> 0x0059 }
        goto L_0x0044;
    L_0x006c:
        r0 = com.baidu.location.C3377f.getServiceContext();	 Catch:{ Throwable -> 0x0059 }
        r1 = "phone2";
        r0 = com.baidu.location.p188h.C3391g.m14429a(r0, r1);	 Catch:{ Throwable -> 0x0059 }
        r3.f18222e = r0;	 Catch:{ Throwable -> 0x0059 }
        goto L_0x0044;
    L_0x007a:
        r0 = move-exception;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.b.b():void");
    }

    /* renamed from: c */
    public synchronized void m14277c() {
        if (this.f18227j) {
            if (!(this.f18226i == null || this.f18221d == null)) {
                this.f18221d.listen(this.f18226i, 0);
            }
            this.f18226i = null;
            this.f18221d = null;
            this.f18225h.clear();
            this.f18225h = null;
            m14268j();
            this.f18227j = false;
        }
    }

    /* renamed from: d */
    public boolean m14278d() {
        return this.f18228q;
    }

    /* renamed from: e */
    public int m14279e() {
        int i = 0;
        if (this.f18221d != null) {
            try {
                i = this.f18221d.getNetworkType();
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: f */
    public C3362a m14280f() {
        if (!((this.f18223f != null && this.f18223f.m14246a() && this.f18223f.m14248b()) || this.f18221d == null)) {
            try {
                m14269k();
            } catch (Exception e) {
            }
        }
        if (this.f18223f.m14251e()) {
            this.f18224g = null;
            this.f18224g = new C3362a(this.f18223f.f18200a, this.f18223f.f18201b, this.f18223f.f18202c, this.f18223f.f18203d, this.f18223f.f18207h, this.f18223f.f18208i);
        }
        if (this.f18223f.m14250d() && this.f18224g != null && this.f18223f.f18208i == 'g') {
            this.f18223f.f18203d = this.f18224g.f18203d;
            this.f18223f.f18202c = this.f18224g.f18202c;
        }
        return this.f18223f;
    }

    /* renamed from: g */
    public String m14281g() {
        int i = -1;
        try {
            if (this.f18221d != null) {
                i = this.f18221d.getSimState();
            }
        } catch (Exception e) {
        }
        return "&sim=" + i;
    }

    /* renamed from: h */
    public int m14282h() {
        String subscriberId;
        try {
            subscriberId = ((TelephonyManager) C3377f.getServiceContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            subscriberId = null;
        }
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }
}
