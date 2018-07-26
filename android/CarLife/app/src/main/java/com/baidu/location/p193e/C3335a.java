package com.baidu.location.p193e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import com.baidu.navi.driveanalysis.CommonConstants;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.a */
public final class C3335a {
    /* renamed from: b */
    private static C3335a f18050b = null;
    /* renamed from: l */
    private static final String f18051l = (Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/");
    /* renamed from: m */
    private static final String f18052m = (Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata" + "/ls.db");
    /* renamed from: a */
    public boolean f18053a = false;
    /* renamed from: c */
    private String f18054c = null;
    /* renamed from: d */
    private boolean f18055d = false;
    /* renamed from: e */
    private boolean f18056e = false;
    /* renamed from: f */
    private double f18057f = 0.0d;
    /* renamed from: g */
    private double f18058g = 0.0d;
    /* renamed from: h */
    private double f18059h = 0.0d;
    /* renamed from: i */
    private double f18060i = 0.0d;
    /* renamed from: j */
    private double f18061j = 0.0d;
    /* renamed from: k */
    private volatile boolean f18062k = false;
    /* renamed from: n */
    private Handler f18063n = null;

    /* renamed from: com.baidu.location.e.a$1 */
    class C33311 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3335a f18044a;

        C33311(C3335a c3335a) {
            this.f18044a = c3335a;
        }

        public void run() {
            if (C3377f.isServing) {
                if (!this.f18044a.f18053a) {
                    this.f18044a.m14053d();
                }
                this.f18044a.m14054e();
            }
        }
    }

    /* renamed from: com.baidu.location.e.a$a */
    private class C3333a extends AsyncTask<Boolean, Void, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3335a f18048a;

        private C3333a(C3335a c3335a) {
            this.f18048a = c3335a;
        }

        /* renamed from: a */
        protected Boolean m14036a(Boolean... boolArr) {
            SQLiteDatabase sQLiteDatabase = null;
            if (boolArr.length != 4) {
                return Boolean.valueOf(false);
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(C3335a.f18052m, null);
            } catch (Exception e) {
            }
            if (sQLiteDatabase == null) {
                return Boolean.valueOf(false);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from wof where ac < " + (currentTimeMillis - 35));
                    } catch (Exception e2) {
                    }
                }
                if (boolArr[1].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from bdcltb09 where ac is NULL or ac < " + (currentTimeMillis - 130));
                    } catch (Exception e3) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception e4) {
            }
            return Boolean.valueOf(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m14036a((Boolean[]) objArr);
        }
    }

    /* renamed from: com.baidu.location.e.a$b */
    private class C3334b extends AsyncTask<Object, Void, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3335a f18049a;

        private C3334b(C3335a c3335a) {
            this.f18049a = c3335a;
        }

        /* renamed from: a */
        protected Boolean m14037a(Object... objArr) {
            SQLiteDatabase sQLiteDatabase = null;
            if (objArr.length != 4) {
                this.f18049a.f18062k = false;
                return Boolean.valueOf(false);
            }
            SQLiteDatabase openOrCreateDatabase;
            try {
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(C3335a.f18052m, null);
            } catch (Exception e) {
                openOrCreateDatabase = sQLiteDatabase;
            }
            if (openOrCreateDatabase == null) {
                this.f18049a.f18062k = false;
                return Boolean.valueOf(false);
            }
            try {
                openOrCreateDatabase.beginTransaction();
                this.f18049a.m14046a((String) objArr[0], (C3362a) objArr[1], openOrCreateDatabase);
                this.f18049a.m14044a((C3372e) objArr[2], (BDLocation) objArr[3], openOrCreateDatabase);
                openOrCreateDatabase.setTransactionSuccessful();
                openOrCreateDatabase.endTransaction();
                openOrCreateDatabase.close();
            } catch (Exception e2) {
            }
            this.f18049a.f18062k = false;
            return Boolean.valueOf(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m14037a(objArr);
        }
    }

    private C3335a() {
        m14053d();
    }

    /* renamed from: a */
    public static synchronized C3335a m14038a() {
        C3335a c3335a;
        synchronized (C3335a.class) {
            if (f18050b == null) {
                f18050b = new C3335a();
            }
            c3335a = f18050b;
        }
        return c3335a;
    }

    /* renamed from: a */
    private void m14044a(C3372e c3372e, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && c3372e.f18275a != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
                System.currentTimeMillis();
                int i = 0;
                for (ScanResult scanResult : c3372e.f18275a) {
                    if (scanResult.level != 0) {
                        int i2 = i + 1;
                        if (i2 <= 6) {
                            ContentValues contentValues = new ContentValues();
                            String encode2 = Jni.encode2(scanResult.BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
                            try {
                                int i3;
                                int i4;
                                double d;
                                Object obj;
                                double d2;
                                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + encode2 + "\";", null);
                                if (rawQuery == null || !rawQuery.moveToFirst()) {
                                    i3 = 0;
                                    i4 = 0;
                                    d = 0.0d;
                                    obj = null;
                                    d2 = 0.0d;
                                } else {
                                    double d3 = rawQuery.getDouble(1) - 113.2349d;
                                    double d4 = rawQuery.getDouble(2) - 432.1238d;
                                    int i5 = rawQuery.getInt(4);
                                    i3 = rawQuery.getInt(5);
                                    i4 = i5;
                                    d = d3;
                                    double d5 = d4;
                                    obj = 1;
                                    d2 = d5;
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                if (obj == null) {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put(BaiduNaviParams.KEY_TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", Integer.valueOf(1));
                                    contentValues.put("cc", Integer.valueOf(1));
                                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                    contentValues.put("id", encode2);
                                    sQLiteDatabase.insert("wof", null, contentValues);
                                } else if (i3 == 0) {
                                    i = i2;
                                } else {
                                    float[] fArr = new float[1];
                                    Location.distanceBetween(d2, d, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                                    if (fArr[0] > 1500.0f) {
                                        int i6 = i3 + 1;
                                        if (i6 <= 10 || i6 <= i4 * 3) {
                                            contentValues.put("cc", Integer.valueOf(i6));
                                        } else {
                                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                            contentValues.put(BaiduNaviParams.KEY_TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                            contentValues.put("bc", Integer.valueOf(1));
                                            contentValues.put("cc", Integer.valueOf(1));
                                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                        }
                                    } else {
                                        d2 = ((d2 * ((double) i4)) + bDLocation.getLatitude()) / ((double) (i4 + 1));
                                        ContentValues contentValues2 = contentValues;
                                        contentValues2.put("mktime", Double.valueOf((((d * ((double) i4)) + bDLocation.getLongitude()) / ((double) (i4 + 1))) + 113.2349d));
                                        contentValues.put(BaiduNaviParams.KEY_TIME, Double.valueOf(d2 + 432.1238d));
                                        contentValues.put("bc", Integer.valueOf(i4 + 1));
                                        contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                    }
                                    try {
                                        if (sQLiteDatabase.update("wof", contentValues, "id = \"" + encode2 + "\"", null) <= 0) {
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m14045a(java.lang.String r8, android.database.sqlite.SQLiteDatabase r9) {
        /*
        r7 = this;
        r0 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0003:
        r1 = r7.f18054c;
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r1 = 0;
        r7.f18055d = r1;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1.<init>();	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = "select * from bdcltb09 where id = \"";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = "\";";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = 0;
        r0 = r9.rawQuery(r1, r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r7.f18054c = r8;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        if (r1 == 0) goto L_0x0061;
    L_0x0037:
        r1 = 1;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4653148304163072062; // 0x40934dbaacd9e83e float:-6.193295E-12 double:1235.4323;
        r2 = r2 - r4;
        r7.f18058g = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 2;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4661478502002851840; // 0x40b0e60000000000 float:0.0 double:4326.0;
        r2 = r2 - r4;
        r7.f18057f = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 3;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4657424210545395263; // 0x40a27ea4b5dcc63f float:-1.6448975E-6 double:2367.3217;
        r2 = r2 - r4;
        r7.f18059h = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 1;
        r7.f18055d = r1;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
    L_0x0061:
        if (r0 == 0) goto L_0x000b;
    L_0x0063:
        r0.close();	 Catch:{ Exception -> 0x0067 }
        goto L_0x000b;
    L_0x0067:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0069:
        r1 = move-exception;
        if (r0 == 0) goto L_0x000b;
    L_0x006c:
        r0.close();	 Catch:{ Exception -> 0x0070 }
        goto L_0x000b;
    L_0x0070:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0072:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.close();	 Catch:{ Exception -> 0x007c }
    L_0x007b:
        throw r0;
    L_0x007c:
        r1 = move-exception;
        goto L_0x007b;
    L_0x007e:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    private void m14046a(String str, C3362a c3362a, SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        double d = 0.0d;
        if (c3362a.m14248b() && C3200h.m13362c().m13390i()) {
            System.currentTimeMillis();
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            String g = c3362a.m14253g();
            try {
                double parseDouble;
                float parseFloat;
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString(ParamKey.KEY_MSG_ERRORS));
                int i;
                if (parseInt == 161) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    if (jSONObject2.has("clf")) {
                        String string = jSONObject2.getString("clf");
                        if (string.equals("0")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                            d = Double.parseDouble(jSONObject3.getString("x"));
                            parseDouble = Double.parseDouble(jSONObject3.getString("y"));
                            parseFloat = Float.parseFloat(jSONObject2.getString(CommonConstants.RADIUS));
                        } else {
                            String[] split = string.split("\\|");
                            d = Double.parseDouble(split[0]);
                            parseDouble = Double.parseDouble(split[1]);
                            parseFloat = Float.parseFloat(split[2]);
                        }
                    }
                    i = 1;
                    parseFloat = 0.0f;
                    parseDouble = 0.0d;
                } else {
                    if (parseInt == 167) {
                        sQLiteDatabase.delete("bdcltb09", "id = \"" + g + "\"", null);
                        return;
                    }
                    i = 1;
                    parseFloat = 0.0f;
                    parseDouble = 0.0d;
                }
                if (obj == null) {
                    d += 1235.4323d;
                    parseDouble += 2367.3217d;
                    float f = 4326.0f + parseFloat;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(BaiduNaviParams.KEY_TIME, Double.valueOf(d));
                    contentValues.put("tag", Float.valueOf(f));
                    contentValues.put("type", Double.valueOf(parseDouble));
                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                    try {
                        if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + g + "\"", null) <= 0) {
                            contentValues.put("id", g);
                            sQLiteDatabase.insert("bdcltb09", null, contentValues);
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    private void m14047a(String str, List<ScanResult> list) {
        SQLiteDatabase sQLiteDatabase;
        if (str == null || str.equals(this.f18054c)) {
            sQLiteDatabase = null;
        } else {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f18052m, null);
            m14045a(str, sQLiteDatabase);
        }
        if (list != null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f18052m, null);
            }
            m14048a((List) list, sQLiteDatabase);
        }
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            sQLiteDatabase.close();
        }
    }

    /* renamed from: a */
    private void m14048a(List<ScanResult> list, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        System.currentTimeMillis();
        this.f18056e = false;
        if (list != null && list.size() != 0 && sQLiteDatabase != null && list != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            Object obj = null;
            double[] dArr = new double[8];
            Object obj2 = null;
            int i2 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            int i3 = 0;
            for (ScanResult scanResult : list) {
                if (i3 > 10) {
                    break;
                }
                if (i3 > 0) {
                    stringBuffer.append(",");
                }
                i3++;
                stringBuffer.append("\"").append(Jni.encode2(scanResult.BSSID.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""))).append("\"");
            }
            Cursor cursor = null;
            Cursor rawQuery;
            try {
                rawQuery = sQLiteDatabase.rawQuery("select * from wof where id in (" + stringBuffer.toString() + ");", null);
                try {
                    if (rawQuery.moveToFirst()) {
                        while (!rawQuery.isAfterLast()) {
                            double d3 = rawQuery.getDouble(1) - 113.2349d;
                            double d4 = rawQuery.getDouble(2) - 432.1238d;
                            int i4 = rawQuery.getInt(4);
                            int i5 = rawQuery.getInt(5);
                            if (i5 <= 8 || i5 <= i4) {
                                int i6;
                                Object obj3;
                                float[] fArr;
                                if (!this.f18055d) {
                                    if (obj == null) {
                                        int i7;
                                        if (obj2 != null) {
                                            int i8 = 0;
                                            while (i8 < i2) {
                                                Object obj4;
                                                double d5;
                                                double d6;
                                                fArr = new float[1];
                                                Location.distanceBetween(d4, d3, dArr[i8 + 1], dArr[i8], fArr);
                                                if (fArr[0] < 1000.0f) {
                                                    obj4 = 1;
                                                    d5 = d + dArr[i8];
                                                    d6 = dArr[i8 + 1] + d2;
                                                    i5 = i + 1;
                                                } else {
                                                    obj4 = obj;
                                                    i5 = i;
                                                    d6 = d2;
                                                    d5 = d;
                                                }
                                                i8 += 2;
                                                d2 = d6;
                                                d = d5;
                                                obj = obj4;
                                                i = i5;
                                            }
                                            if (obj == null) {
                                                if (i2 >= 8) {
                                                    break;
                                                }
                                                i4 = i2 + 1;
                                                dArr[i2] = d3;
                                                i7 = i4 + 1;
                                                dArr[i4] = d4;
                                                i6 = i7;
                                                obj3 = obj2;
                                            } else {
                                                d += d3;
                                                d2 += d4;
                                                i++;
                                                i6 = i2;
                                                obj3 = obj2;
                                            }
                                        } else {
                                            i4 = i2 + 1;
                                            dArr[i2] = d3;
                                            i7 = i4 + 1;
                                            dArr[i4] = d4;
                                            i3 = 1;
                                            i6 = i7;
                                        }
                                    } else {
                                        fArr = new float[1];
                                        Location.distanceBetween(d4, d3, d2 / ((double) i), d / ((double) i), fArr);
                                        if (fArr[0] > 1000.0f) {
                                            rawQuery.moveToNext();
                                        } else {
                                            i6 = i2;
                                            obj3 = obj2;
                                        }
                                    }
                                } else {
                                    fArr = new float[1];
                                    Location.distanceBetween(d4, d3, this.f18059h, this.f18058g, fArr);
                                    if (((double) fArr[0]) > this.f18057f + 2000.0d) {
                                        rawQuery.moveToNext();
                                    } else {
                                        obj = 1;
                                        d += d3;
                                        d2 += d4;
                                        i++;
                                        i6 = i2;
                                        obj3 = obj2;
                                    }
                                }
                                if (i > 4) {
                                    break;
                                }
                                rawQuery.moveToNext();
                                i2 = i6;
                                obj2 = obj3;
                            } else {
                                rawQuery.moveToNext();
                            }
                        }
                        if (i > 0) {
                            this.f18056e = true;
                            this.f18060i = d / ((double) i);
                            this.f18061j = d2 / ((double) i);
                        }
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    cursor = rawQuery;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th3) {
                rawQuery = null;
                th = th3;
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: b */
    private String m14049b(boolean z) {
        double d;
        double d2;
        boolean z2;
        boolean z3;
        double d3 = 0.0d;
        if (this.f18056e) {
            d = this.f18060i;
            d2 = this.f18061j;
            d3 = 246.4d;
            z2 = true;
            z3 = true;
        } else if (this.f18055d) {
            d = this.f18058g;
            d2 = this.f18059h;
            d3 = this.f18057f;
            z2 = C3200h.m13362c().m13390i();
            z3 = true;
        } else {
            z2 = false;
            z3 = false;
            d2 = 0.0d;
            d = 0.0d;
        }
        if (!z3) {
            return z ? "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"63\"}}";
        } else {
            if (z) {
                return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(true)});
            }
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + C3391g.m14431a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(z2)});
        }
    }

    /* renamed from: d */
    private void m14053d() {
        try {
            File file = new File(f18051l);
            File file2 = new File(f18052m);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
            this.f18053a = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: e */
    private void m14054e() {
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        boolean z = true;
        try {
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(f18052m, null);
        } catch (Exception e) {
            openOrCreateDatabase = sQLiteDatabase;
        }
        if (openOrCreateDatabase != null) {
            try {
                long queryNumEntries = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "wof");
                long queryNumEntries2 = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "bdcltb09");
                boolean z2 = queryNumEntries > BNOffScreenParams.MIN_ENTER_INTERVAL;
                if (queryNumEntries2 <= BNOffScreenParams.MIN_ENTER_INTERVAL) {
                    z = false;
                }
                openOrCreateDatabase.close();
                if (z2 || z) {
                    new C3333a().execute(new Boolean[]{Boolean.valueOf(z2), Boolean.valueOf(z)});
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public BDLocation m14055a(final String str, final List<ScanResult> list, boolean z) {
        if (!this.f18053a) {
            m14053d();
        }
        String str2 = "{\"result\":\"null\"}";
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        String str3 = (FutureTask) newSingleThreadExecutor.submit(new Callable<String>(this) {
            /* renamed from: c */
            final /* synthetic */ C3335a f18047c;

            /* renamed from: a */
            public String m14035a() {
                this.f18047c.m14047a(str, list);
                return this.f18047c.m14049b(true);
            }

            public /* synthetic */ Object call() throws Exception {
                return m14035a();
            }
        });
        try {
            str3 = (String) str3.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } catch (ExecutionException e2) {
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } catch (TimeoutException e3) {
            if (z) {
                C3301g.m13879a().m13885a("old offlineLocation Timeout Exception!");
            }
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } finally {
            newSingleThreadExecutor.shutdown();
        }
        return new BDLocation(str3);
    }

    /* renamed from: a */
    public BDLocation m14056a(boolean z) {
        BDLocation bDLocation = null;
        if (!this.f18053a) {
            m14053d();
        }
        C3362a f = C3364b.m14262a().m14280f();
        String g = (f == null || !f.m14251e()) ? null : f.m14253g();
        C3372e p = C3376f.m14355a().m14380p();
        if (p != null) {
            bDLocation = m14055a(g, p.f18275a, true);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Float.valueOf(bDLocation.getRadius())}));
            if (p != null && p.m14330a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(p.m14339c(15));
            }
            if (f != null) {
                stringBuffer.append(f.m14255i());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(C3391g.m14449e(C3377f.getServiceContext()));
            stringBuffer.append(C3381b.m14398a().m14399a(false));
            stringBuffer.append(C3181a.m13265a().m13283f());
            C3301g.m13880a(C3301g.f17908a, Jni.encode(stringBuffer.toString()));
        }
        return bDLocation;
    }

    /* renamed from: a */
    public void m14057a(String str, C3362a c3362a, C3372e c3372e, BDLocation bDLocation) {
        if (!this.f18053a) {
            m14053d();
        }
        int i = (c3362a.m14248b() && C3200h.m13362c().m13390i()) ? 0 : true;
        int i2 = (bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f)) ? true : 0;
        if (c3372e.f18275a == null) {
            i2 = true;
        }
        if ((i == 0 || r0 == 0) && !this.f18062k) {
            this.f18062k = true;
            new C3334b().execute(new Object[]{str, c3362a, c3372e, bDLocation});
        }
    }

    /* renamed from: b */
    public void m14058b() {
        if (this.f18063n == null) {
            this.f18063n = new Handler();
        }
        this.f18063n.postDelayed(new C33311(this), 3000);
    }
}
