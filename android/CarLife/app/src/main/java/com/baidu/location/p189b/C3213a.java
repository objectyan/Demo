package com.baidu.location.p189b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3391g;
import com.baidu.mobstat.Config;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.a */
public class C3213a {
    /* renamed from: b */
    private static Object f17486b = new Object();
    /* renamed from: c */
    private static C3213a f17487c = null;
    /* renamed from: d */
    private static final String f17488d = (C3391g.m14456l() + "/gal.db");
    /* renamed from: a */
    C3212a f17489a = null;
    /* renamed from: e */
    private SQLiteDatabase f17490e = null;
    /* renamed from: f */
    private boolean f17491f = false;
    /* renamed from: g */
    private String f17492g = null;
    /* renamed from: h */
    private double f17493h = Double.MAX_VALUE;
    /* renamed from: i */
    private double f17494i = Double.MAX_VALUE;

    /* renamed from: com.baidu.location.b.a$a */
    class C3212a extends C3186e {
        /* renamed from: a */
        int f17480a;
        /* renamed from: b */
        int f17481b;
        /* renamed from: c */
        int f17482c;
        /* renamed from: d */
        int f17483d;
        /* renamed from: e */
        double f17484e;
        /* renamed from: f */
        final /* synthetic */ C3213a f17485f;

        C3212a(C3213a c3213a) {
            this.f17485f = c3213a;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = "http://loc.map.baidu.com/gpsz";
            this.k.put("gpsz", Jni.encode(String.format(Locale.CHINESE, "&x=%d&y=%d&sdk=%f", new Object[]{Integer.valueOf(this.f17480a), Integer.valueOf(this.f17481b), Double.valueOf(this.f17484e)})));
        }

        /* renamed from: a */
        public void m13463a(double d, double d2, double d3) {
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
            this.f17480a = (int) Math.floor(coorEncrypt[0] * 100.0d);
            this.f17481b = (int) Math.floor(coorEncrypt[1] * 100.0d);
            this.f17482c = (int) Math.floor(d * 100.0d);
            this.f17483d = (int) Math.floor(d2 * 100.0d);
            this.f17484e = d3;
            this.f17485f.f17491f = true;
            m13301i();
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                JSONObject jSONObject = new JSONObject(this.j);
                if (jSONObject != null && jSONObject.has("height")) {
                    String string = jSONObject.getString("height");
                    if (string.contains(",")) {
                        String[] split = string.trim().split(",");
                        int length = split.length;
                        int sqrt = (int) Math.sqrt((double) length);
                        if (sqrt * sqrt == length) {
                            int i = this.f17482c - ((sqrt - 1) / 2);
                            int i2 = this.f17483d - ((sqrt - 1) / 2);
                            for (int i3 = 0; i3 < sqrt; i3++) {
                                for (length = 0; length < sqrt; length++) {
                                    ContentValues contentValues = new ContentValues();
                                    if (split[(i3 * sqrt) + length].contains("E")) {
                                        contentValues.put("aldata", Double.valueOf(10000.0d));
                                        contentValues.put("sigma", Double.valueOf(10000.0d));
                                    } else if (split[(i3 * sqrt) + length].contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
                                        try {
                                            String[] split2 = split[(i3 * sqrt) + length].split(Config.TRACE_TODAY_VISIT_SPLIT);
                                            if (split2.length == 2) {
                                                contentValues.put("aldata", Double.valueOf(split2[0]));
                                                contentValues.put("sigma", split2[1]);
                                            } else {
                                                contentValues.put("aldata", Double.valueOf(10000.0d));
                                                contentValues.put("sigma", Double.valueOf(10000.0d));
                                            }
                                        } catch (Exception e) {
                                        }
                                    } else {
                                        contentValues.put("aldata", Double.valueOf(split[(i3 * sqrt) + length]));
                                        contentValues.put("sigma", Double.valueOf(10000.0d));
                                    }
                                    contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                    int i4 = i + length;
                                    int i5 = i2 + i3;
                                    String format = String.format(Locale.CHINESE, "%d,%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                                    try {
                                        if (this.f17485f.f17490e.update("galdata_new", contentValues, "id = \"" + format + "\"", null) <= 0) {
                                            contentValues.put("id", format);
                                            this.f17485f.f17490e.insert("galdata_new", null, contentValues);
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f17485f.f17491f = false;
        }
    }

    /* renamed from: a */
    public static C3213a m13466a() {
        C3213a c3213a;
        synchronized (f17486b) {
            if (f17487c == null) {
                f17487c = new C3213a();
            }
            c3213a = f17487c;
        }
        return c3213a;
    }

    /* renamed from: a */
    private void m13467a(double d, double d2, double d3) {
        if (this.f17489a == null) {
            this.f17489a = new C3212a(this);
        }
        this.f17489a.m13463a(d, d2, d3);
    }

    /* renamed from: a */
    public int m13469a(BDLocation bDLocation) {
        float radius;
        double altitude;
        if (bDLocation != null) {
            radius = bDLocation.getRadius();
            altitude = bDLocation.getAltitude();
        } else {
            altitude = 0.0d;
            radius = 0.0f;
        }
        if (this.f17490e != null && radius > 0.0f && altitude > 0.0d) {
            double b = m13471b(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (b != Double.MAX_VALUE) {
                altitude = Jni.getGpsSwiftRadius(radius, altitude, b);
                return altitude > 50.0d ? 3 : altitude > 20.0d ? 2 : 1;
            }
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public double[] m13470a(double r16, double r18) {
        /*
        r15 = this;
        r10 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r8 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r0 = 2;
        r12 = new double[r0];
        r0 = r15.f17490e;
        if (r0 == 0) goto L_0x013c;
    L_0x0011:
        r0 = 0;
        r1 = java.util.Locale.CHINESE;
        r2 = "%d,%d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r6 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r6 = r6 * r16;
        r6 = java.lang.Math.floor(r6);
        r5 = (int) r6;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r6 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r6 = r6 * r18;
        r6 = java.lang.Math.floor(r6);
        r5 = (int) r6;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r13 = java.lang.String.format(r1, r2, r3);
        r1 = r15.f17492g;
        if (r1 == 0) goto L_0x0071;
    L_0x0042:
        r1 = r15.f17492g;
        r1 = r1.equals(r13);
        if (r1 == 0) goto L_0x0071;
    L_0x004a:
        r4 = r15.f17493h;
        r2 = r15.f17494i;
    L_0x004e:
        r0 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0121;
    L_0x0057:
        r0 = 0;
        r4 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r12[r0] = r4;
    L_0x005f:
        r0 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0126;
    L_0x0068:
        r0 = 1;
        r2 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r12[r0] = r2;
    L_0x0070:
        return r12;
    L_0x0071:
        r1 = r15.f17490e;	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r2.<init>();	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r3 = "select * from galdata_new where id = \"";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r2 = r2.append(r13);	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r3 = "\";";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        r3 = 0;
        r0 = r1.rawQuery(r2, r3);	 Catch:{ Exception -> 0x010a, all -> 0x0117 }
        if (r0 == 0) goto L_0x00f6;
    L_0x0095:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        if (r1 == 0) goto L_0x00f6;
    L_0x009b:
        r1 = 1;
        r4 = r0.getDouble(r1);	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r1 = 2;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0132, all -> 0x012d }
        r1 = 3;
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x0135, all -> 0x012d }
        r6 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 != 0) goto L_0x0139;
    L_0x00b3:
        r10 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x00b8:
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x0137;
    L_0x00be:
        r8 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x00c3:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r4 = (long) r1;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r2 = r2 - r4;
        r1 = r15.f17491f;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        if (r1 != 0) goto L_0x00e4;
    L_0x00d0:
        r4 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x00e4;
    L_0x00d7:
        r6 = 4619927605938749440; // 0x401d47ae20000000 float:1.0842022E-19 double:7.320000171661377;
        r1 = r15;
        r2 = r16;
        r4 = r18;
        r1.m13467a(r2, r4, r6);	 Catch:{ Exception -> 0x010a, all -> 0x012d }
    L_0x00e4:
        r15.f17492g = r13;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r15.f17493h = r10;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r15.f17494i = r8;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        r2 = r8;
        r4 = r10;
    L_0x00ec:
        if (r0 == 0) goto L_0x004e;
    L_0x00ee:
        r0.close();	 Catch:{ Exception -> 0x00f3 }
        goto L_0x004e;
    L_0x00f3:
        r0 = move-exception;
        goto L_0x004e;
    L_0x00f6:
        r1 = r15.f17491f;	 Catch:{ Exception -> 0x010a, all -> 0x012d }
        if (r1 != 0) goto L_0x0107;
    L_0x00fa:
        r6 = 4619927605938749440; // 0x401d47ae20000000 float:1.0842022E-19 double:7.320000171661377;
        r1 = r15;
        r2 = r16;
        r4 = r18;
        r1.m13467a(r2, r4, r6);	 Catch:{ Exception -> 0x010a, all -> 0x012d }
    L_0x0107:
        r2 = r8;
        r4 = r10;
        goto L_0x00ec;
    L_0x010a:
        r1 = move-exception;
        r2 = r8;
        r4 = r10;
    L_0x010d:
        if (r0 == 0) goto L_0x004e;
    L_0x010f:
        r0.close();	 Catch:{ Exception -> 0x0114 }
        goto L_0x004e;
    L_0x0114:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0117:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x011b:
        if (r1 == 0) goto L_0x0120;
    L_0x011d:
        r1.close();	 Catch:{ Exception -> 0x012b }
    L_0x0120:
        throw r0;
    L_0x0121:
        r0 = 0;
        r12[r0] = r4;
        goto L_0x005f;
    L_0x0126:
        r0 = 1;
        r12[r0] = r2;
        goto L_0x0070;
    L_0x012b:
        r1 = move-exception;
        goto L_0x0120;
    L_0x012d:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
        goto L_0x011b;
    L_0x0132:
        r1 = move-exception;
        r2 = r8;
        goto L_0x010d;
    L_0x0135:
        r1 = move-exception;
        goto L_0x010d;
    L_0x0137:
        r8 = r2;
        goto L_0x00c3;
    L_0x0139:
        r10 = r4;
        goto L_0x00b8;
    L_0x013c:
        r2 = r8;
        r4 = r10;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.a.a(double, double):double[]");
    }

    /* renamed from: b */
    public double m13471b(double d, double d2) {
        double d3;
        Cursor cursor;
        Throwable th;
        if (this.f17490e == null) {
            return Double.MAX_VALUE;
        }
        String format = String.format(Locale.CHINESE, "%d,%d", new Object[]{Integer.valueOf((int) Math.floor(100.0d * d)), Integer.valueOf((int) Math.floor(100.0d * d2))});
        if (this.f17492g != null && this.f17492g.equals(format)) {
            return this.f17493h;
        }
        Cursor rawQuery;
        try {
            rawQuery = this.f17490e.rawQuery("select * from galdata_new where id = \"" + format + "\";", null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        double d4 = rawQuery.getDouble(1);
                        int i = rawQuery.getInt(3);
                        if (d4 == 10000.0d) {
                            d4 = Double.MAX_VALUE;
                        }
                        long currentTimeMillis = (System.currentTimeMillis() / 1000) - ((long) i);
                        if (!this.f17491f && currentTimeMillis > 604800) {
                            m13467a(d, d2, 7.320000171661377d);
                        }
                        this.f17492g = format;
                        this.f17493h = d4;
                        d3 = d4;
                        if (rawQuery != null) {
                            return d3;
                        }
                        try {
                            rawQuery.close();
                            return d3;
                        } catch (Exception e) {
                            return d3;
                        }
                    }
                } catch (Exception e2) {
                    cursor = rawQuery;
                    d3 = Double.MAX_VALUE;
                    if (cursor != null) {
                        return d3;
                    }
                    try {
                        cursor.close();
                        return d3;
                    } catch (Exception e3) {
                        return d3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            if (!this.f17491f) {
                m13467a(d, d2, 7.320000171661377d);
            }
            d3 = Double.MAX_VALUE;
            if (rawQuery != null) {
                return d3;
            }
            rawQuery.close();
            return d3;
        } catch (Exception e5) {
            cursor = null;
            d3 = Double.MAX_VALUE;
            if (cursor != null) {
                return d3;
            }
            cursor.close();
            return d3;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public void m13472b() {
        try {
            File file = new File(f17488d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f17490e = SQLiteDatabase.openOrCreateDatabase(file, null);
                Cursor rawQuery = this.f17490e.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    if (rawQuery.getInt(0) == 0) {
                        this.f17490e.execSQL("CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    } else {
                        this.f17490e.execSQL("DROP TABLE galdata");
                        this.f17490e.execSQL("CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    }
                }
                this.f17490e.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception e) {
            this.f17490e = null;
        }
    }

    /* renamed from: c */
    public void m13473c() {
        if (this.f17490e != null) {
            try {
                this.f17490e.close();
            } catch (Exception e) {
            } finally {
                this.f17490e = null;
            }
        }
    }
}
