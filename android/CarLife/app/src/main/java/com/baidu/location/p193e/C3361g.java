package com.baidu.location.p193e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.Poi;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.g */
final class C3361g {
    /* renamed from: b */
    private static final double[] f18194b = new double[]{45.0d, 135.0d, 225.0d, 315.0d};
    /* renamed from: a */
    private final C3349d f18195a;
    /* renamed from: c */
    private final int f18196c;
    /* renamed from: d */
    private final SQLiteDatabase f18197d;
    /* renamed from: e */
    private int f18198e = -1;
    /* renamed from: f */
    private int f18199f = -1;

    /* renamed from: com.baidu.location.e.g$a */
    private static final class C3355a {
        /* renamed from: a */
        private double f18182a;
        /* renamed from: b */
        private double f18183b;

        private C3355a(double d, double d2) {
            this.f18182a = d;
            this.f18183b = d2;
        }
    }

    /* renamed from: com.baidu.location.e.g$b */
    private enum C3356b {
        AREA("RGCAREA", Regular.CATEGORY_AREA_VALUE, "addrv", 0, 1000) {
            /* renamed from: a */
            List<String> mo2504a(JSONObject jSONObject, String str, int i) {
                Iterator keys = jSONObject.keys();
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                List<String> arrayList = new ArrayList();
                int i2 = 0;
                while (keys.hasNext()) {
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    String str8 = (String) keys.next();
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str8);
                        if (jSONObject2.has("cy")) {
                            str2 = jSONObject2.getString("cy");
                        }
                        if (jSONObject2.has("cyc")) {
                            str3 = jSONObject2.getString("cyc");
                        }
                        if (jSONObject2.has("prov")) {
                            str4 = jSONObject2.getString("prov");
                        }
                        if (jSONObject2.has("ctc")) {
                            str5 = jSONObject2.getString("ctc");
                        }
                        if (jSONObject2.has(Config.EXCEPTION_CRASH_TYPE)) {
                            str6 = jSONObject2.getString(Config.EXCEPTION_CRASH_TYPE);
                        }
                        if (jSONObject2.has("dist")) {
                            str7 = jSONObject2.getString("dist");
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("(\"").append(str8).append("\",\"").append(str2).append("\",\"").append(str3).append("\",\"").append(str4).append("\",\"").append(str6).append("\",\"").append(str5).append("\",\"").append(str7).append("\",").append(System.currentTimeMillis() / 1000).append(",\"\")");
                        C3356b.m14225b(stringBuffer2, str8, str, 0);
                    } catch (JSONException e) {
                    }
                    if (i2 % 50 == 49 && stringBuffer.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCAREA", stringBuffer}));
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
                        stringBuffer.setLength(0);
                    }
                    i2++;
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCAREA", stringBuffer}));
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
                    stringBuffer.setLength(0);
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", new Object[]{Integer.valueOf(i)}));
                return arrayList;
            }
        },
        ROAD("RGCROAD", "road", "addrv", 1000, 10000) {
            /* renamed from: a */
            List<String> mo2504a(JSONObject jSONObject, String str, int i) {
                Iterator keys = jSONObject.keys();
                List<String> arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    JSONArray jSONArray;
                    JSONArray jSONArray2 = null;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String str2 = (String) keys.next();
                    C3356b.m14225b(stringBuffer, str2, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(str2);
                    } catch (JSONException e) {
                        jSONArray = jSONArray2;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Object obj = null;
                            Object obj2 = null;
                            Object obj3 = null;
                            Object obj4 = null;
                            String str3 = null;
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                if (jSONObject2.has("st")) {
                                    str3 = jSONObject2.getString("st");
                                }
                                if (jSONObject2.has("x1")) {
                                    obj = Double.valueOf(jSONObject2.getDouble("x1"));
                                }
                                if (jSONObject2.has("y1")) {
                                    obj2 = Double.valueOf(jSONObject2.getDouble("y1"));
                                }
                                if (jSONObject2.has("x2")) {
                                    obj3 = Double.valueOf(jSONObject2.getDouble("x2"));
                                }
                                if (jSONObject2.has("y2")) {
                                    obj4 = Double.valueOf(jSONObject2.getDouble("y2"));
                                }
                                if (!(str3 == null || obj == null || obj2 == null || obj3 == null || obj4 == null)) {
                                    if (stringBuffer2.length() > 0) {
                                        stringBuffer2.append(",");
                                    }
                                    stringBuffer2.append("(NULL,\"").append(str2).append("\",\"").append(str3).append("\",").append(obj).append(",").append(obj2).append(",").append(obj3).append(",").append(obj4).append(")");
                                }
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", new Object[]{Integer.valueOf(i)}));
                return arrayList;
            }
        },
        SITE("RGCSITE", "site", "addrv", 100, 50000) {
            /* renamed from: a */
            List<String> mo2504a(JSONObject jSONObject, String str, int i) {
                Iterator keys = jSONObject.keys();
                List<String> arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    JSONArray jSONArray;
                    JSONArray jSONArray2 = null;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String str2 = (String) keys.next();
                    C3356b.m14225b(stringBuffer, str2, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(str2);
                    } catch (JSONException e) {
                        jSONArray = jSONArray2;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Object obj = null;
                            Object obj2 = null;
                            String str3 = null;
                            String str4 = null;
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                if (jSONObject2.has("st")) {
                                    str3 = jSONObject2.getString("st");
                                }
                                if (jSONObject2.has("stn")) {
                                    str4 = jSONObject2.getString("stn");
                                }
                                if (jSONObject2.has("x")) {
                                    obj = Double.valueOf(jSONObject2.getDouble("x"));
                                }
                                if (jSONObject2.has("y")) {
                                    obj2 = Double.valueOf(jSONObject2.getDouble("y"));
                                }
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(",");
                                }
                                stringBuffer2.append("(NULL,\"").append(str2).append("\",\"").append(str3).append("\",\"").append(str4).append("\",").append(obj).append(",").append(obj2).append(")");
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", new Object[]{Integer.valueOf(i)}));
                return arrayList;
            }
        },
        POI("RGCPOI", "poi", "poiv", 1000, 5000) {
            /* renamed from: a */
            List<String> mo2504a(JSONObject jSONObject, String str, int i) {
                Iterator keys = jSONObject.keys();
                List<String> arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    JSONArray jSONArray;
                    JSONArray jSONArray2 = null;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String str2 = (String) keys.next();
                    C3356b.m14225b(stringBuffer, str2, str, 1);
                    try {
                        jSONArray = jSONObject.getJSONArray(str2);
                    } catch (JSONException e) {
                        jSONArray = jSONArray2;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Object obj = null;
                            Object obj2 = null;
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            Object obj3 = null;
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                if (jSONObject2.has("pid")) {
                                    str3 = jSONObject2.getString("pid");
                                }
                                if (jSONObject2.has("ne")) {
                                    str4 = jSONObject2.getString("ne");
                                }
                                if (jSONObject2.has("tp")) {
                                    str5 = jSONObject2.getString("tp");
                                }
                                if (jSONObject2.has("rk")) {
                                    obj3 = Integer.valueOf(jSONObject2.getInt("rk"));
                                }
                                if (jSONObject2.has("x")) {
                                    obj = Double.valueOf(jSONObject2.getDouble("x"));
                                }
                                if (jSONObject2.has("y")) {
                                    obj2 = Double.valueOf(jSONObject2.getDouble("y"));
                                }
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(",");
                                }
                                stringBuffer2.append("(\"").append(str3).append("\",\"").append(str2).append("\",\"").append(str4).append("\",\"").append(str5).append("\",").append(obj).append(",").append(obj2).append(",").append(obj3).append(")");
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", new Object[]{Integer.valueOf(i)}));
                return arrayList;
            }
        };
        
        /* renamed from: e */
        private final int f18189e;
        /* renamed from: f */
        private final String f18190f;
        /* renamed from: g */
        private final String f18191g;
        /* renamed from: h */
        private final String f18192h;
        /* renamed from: i */
        private final int f18193i;

        private C3356b(String str, String str2, String str3, int i, int i2) {
            this.f18190f = str;
            this.f18191g = str2;
            this.f18192h = str3;
            this.f18189e = i;
            this.f18193i = i2;
        }

        /* renamed from: a */
        private String m14218a(int i, double d, double d2) {
            HashSet hashSet = new HashSet();
            hashSet.add(C3361g.m14237b(i, d, d2));
            double d3 = ((double) this.f18189e) * 1.414d;
            if (this.f18189e > 0) {
                for (double a : C3361g.f18194b) {
                    double[] a2 = C3361g.m14238b(d2, d, d3, a);
                    hashSet.add(C3361g.m14237b(i, a2[1], a2[0]));
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", new Object[]{this.f18190f, stringBuffer.toString()});
        }

        /* renamed from: a */
        private String m14222a(JSONObject jSONObject) {
            Iterator keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", new Object[]{this.f18190f, stringBuffer});
        }

        /* renamed from: b */
        private static void m14225b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"").append(str).append("\",\"").append(str2).append("\",").append(i).append(",").append(System.currentTimeMillis() / 86400000).append(")");
        }

        /* renamed from: a */
        abstract List<String> mo2504a(JSONObject jSONObject, String str, int i);
    }

    C3361g(C3349d c3349d, SQLiteDatabase sQLiteDatabase, int i) {
        this.f18195a = c3349d;
        this.f18197d = sQLiteDatabase;
        this.f18196c = i;
        if (this.f18197d != null && this.f18197d.isOpen()) {
            try {
                this.f18197d.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
                this.f18197d.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
                this.f18197d.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
                this.f18197d.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
                this.f18197d.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private double m14233a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d5 - d3) * (d - d3)) + ((d6 - d4) * (d2 - d4));
        if (d7 <= 0.0d) {
            return Math.sqrt(((d - d3) * (d - d3)) + ((d2 - d4) * (d2 - d4)));
        }
        double d8 = ((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4));
        if (d7 >= d8) {
            return Math.sqrt(((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6)));
        }
        d7 /= d8;
        d8 = ((d5 - d3) * d7) + d3;
        d7 = (d7 * (d6 - d4)) + d4;
        return Math.sqrt(((d7 - d2) * (d7 - d2)) + ((d - d8) * (d - d8)));
    }

    /* renamed from: a */
    private static int m14234a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = 60000;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) (((double) i3) + (d * ((double) i2)))) + i;
    }

    /* renamed from: b */
    private static String m14237b(int i, double d, double d2) {
        int i2 = i * 5;
        char[] cArr = new char[(i + 1)];
        C3355a c3355a = new C3355a(90.0d, -90.0d);
        C3355a c3355a2 = new C3355a(180.0d, -180.0d);
        int i3 = 1;
        Object obj = 1;
        int i4 = 0;
        while (i3 <= i2) {
            C3355a c3355a3;
            double d3;
            int i5;
            int i6;
            if (obj != null) {
                c3355a3 = c3355a2;
                d3 = d;
            } else {
                c3355a3 = c3355a;
                d3 = d2;
            }
            double a = (c3355a3.f18183b + c3355a3.f18182a) / 2.0d;
            i4 <<= 1;
            if (((int) (d3 * 1000000.0d)) > ((int) (1000000.0d * a))) {
                c3355a3.f18183b = a;
                i5 = i4 | 1;
            } else {
                c3355a3.f18182a = a;
                i5 = i4;
            }
            if (i3 % 5 == 0) {
                cArr[(i3 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i5);
                i6 = 0;
            } else {
                i6 = i5;
            }
            i3++;
            obj = obj == null ? 1 : null;
            i4 = i6;
        }
        cArr[i] = '\u0000';
        StringBuffer stringBuffer = new StringBuffer();
        for (i5 = 0; i5 < i; i5++) {
            stringBuffer.append(cArr[i5]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static double[] m14238b(double d, double d2, double d3, double d4) {
        double[] dArr = new double[2];
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        double toRadians3 = Math.toRadians(d4);
        double asin = Math.asin((Math.sin(toRadians) * Math.cos(d3 / 6378137.0d)) + ((Math.cos(toRadians) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians3)));
        toRadians = Math.atan2((Math.sin(toRadians3) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians), Math.cos(d3 / 6378137.0d) - (Math.sin(toRadians) * Math.sin(asin))) + toRadians2;
        dArr[0] = Math.toDegrees(asin);
        dArr[1] = Math.toDegrees(toRadians);
        return dArr;
    }

    /* renamed from: c */
    private double m14239c(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double toRadians = Math.toRadians(d);
        Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d5 = Math.toRadians(d5);
        d6 = Math.toRadians(d6);
        d5 = (Math.sin(d5 / 2.0d) * ((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.sin(d5 / 2.0d))) + (Math.sin(d6 / 2.0d) * Math.sin(d6 / 2.0d));
        return (Math.atan2(Math.sqrt(d5), Math.sqrt(1.0d - d5)) * 2.0d) * 6378137.0d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    com.baidu.location.Address m14241a(double r32, double r34) {
        /*
        r31 = this;
        r24 = 0;
        r23 = 0;
        r22 = 0;
        r21 = 0;
        r20 = 0;
        r25 = 0;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r4 = com.baidu.location.p193e.C3361g.C3356b.SITE;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r0 = r31;
        r5 = r0.f18196c;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r6 = r32;
        r8 = r34;
        r4 = r4.m14218a(r5, r6, r8);	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r0 = r31;
        r5 = r0.f18197d;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r6 = 0;
        r4 = r5.rawQuery(r4, r6);	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x02e4, all -> 0x02df }
        if (r5 == 0) goto L_0x031f;
    L_0x002c:
        r6 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r16 = r6;
        r14 = r11;
        r15 = r12;
    L_0x0035:
        r5 = r4.isAfterLast();	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        if (r5 != 0) goto L_0x0074;
    L_0x003b:
        r5 = 2;
        r19 = r4.getString(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 3;
        r18 = r4.getString(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 5;
        r10 = r4.getDouble(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 4;
        r12 = r4.getDouble(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = r31;
        r6 = r34;
        r8 = r32;
        r8 = r5.m14239c(r6, r8, r10, r12);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1));
        if (r5 >= 0) goto L_0x0319;
    L_0x005d:
        r5 = com.baidu.location.p193e.C3361g.C3356b.SITE;	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = r5.f18189e;	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r6 = (double) r5;
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r5 > 0) goto L_0x0319;
    L_0x0068:
        r5 = r18;
        r6 = r19;
    L_0x006c:
        r4.moveToNext();	 Catch:{ Exception -> 0x02e9, all -> 0x02df }
        r16 = r8;
        r14 = r5;
        r15 = r6;
        goto L_0x0035;
    L_0x0074:
        r5 = r14;
        r6 = r15;
    L_0x0076:
        if (r4 == 0) goto L_0x0314;
    L_0x0078:
        r4.close();	 Catch:{ Exception -> 0x0117 }
        r18 = r5;
        r10 = r6;
    L_0x007e:
        if (r18 != 0) goto L_0x013f;
    L_0x0080:
        r11 = 0;
        r4 = com.baidu.location.p193e.C3361g.C3356b.ROAD;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r0 = r31;
        r5 = r0.f18196c;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r6 = r32;
        r8 = r34;
        r4 = r4.m14218a(r5, r6, r8);	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r0 = r31;
        r5 = r0.f18197d;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r6 = 0;
        r19 = r5.rawQuery(r4, r6);	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r4 = r19.moveToFirst();	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        if (r4 == 0) goto L_0x0138;
    L_0x009e:
        r26 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r4 = "wgs842mc";
        r0 = r32;
        r2 = r34;
        r29 = com.baidu.location.Jni.coorEncrypt(r0, r2, r4);	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        r4 = r10;
    L_0x00af:
        r5 = r19.isAfterLast();	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        if (r5 != 0) goto L_0x0139;
    L_0x00b5:
        r5 = 2;
        r0 = r19;
        r28 = r0.getString(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 3;
        r0 = r19;
        r6 = r0.getDouble(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 4;
        r0 = r19;
        r8 = r0.getDouble(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = "wgs842mc";
        r5 = com.baidu.location.Jni.coorEncrypt(r6, r8, r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r6 = 5;
        r0 = r19;
        r6 = r0.getDouble(r6);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = 6;
        r0 = r19;
        r8 = r0.getDouble(r8);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r10 = "wgs842mc";
        r16 = com.baidu.location.Jni.coorEncrypt(r6, r8, r10);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r6 = 0;
        r6 = r29[r6];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = 1;
        r8 = r29[r8];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r10 = 0;
        r10 = r5[r10];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r12 = 1;
        r12 = r5[r12];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 0;
        r14 = r16[r5];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 1;
        r16 = r16[r5];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = r31;
        r6 = r5.m14233a(r6, r8, r10, r12, r14, r16);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1));
        if (r5 >= 0) goto L_0x030f;
    L_0x0102:
        r5 = com.baidu.location.p193e.C3361g.C3356b.ROAD;	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = r5.f18189e;	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = (double) r5;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 > 0) goto L_0x030f;
    L_0x010d:
        r4 = r6;
        r10 = r28;
    L_0x0110:
        r19.moveToNext();	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        r26 = r4;
        r4 = r10;
        goto L_0x00af;
    L_0x0117:
        r4 = move-exception;
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x011d:
        r4 = move-exception;
        r4 = r10;
        r5 = r11;
        r6 = r12;
    L_0x0121:
        if (r4 == 0) goto L_0x0314;
    L_0x0123:
        r4.close();	 Catch:{ Exception -> 0x012b }
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x012b:
        r4 = move-exception;
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x0131:
        r4 = move-exception;
    L_0x0132:
        if (r10 == 0) goto L_0x0137;
    L_0x0134:
        r10.close();	 Catch:{ Exception -> 0x02a5 }
    L_0x0137:
        throw r4;
    L_0x0138:
        r4 = r10;
    L_0x0139:
        if (r19 == 0) goto L_0x030c;
    L_0x013b:
        r19.close();	 Catch:{ Exception -> 0x025a }
        r10 = r4;
    L_0x013f:
        r4 = com.baidu.location.p193e.C3361g.C3356b.AREA;
        r0 = r31;
        r5 = r0.f18196c;
        r6 = r32;
        r8 = r34;
        r5 = r4.m14218a(r5, r6, r8);
        r4 = 0;
        r0 = r31;
        r6 = r0.f18197d;	 Catch:{ Exception -> 0x0276, all -> 0x0299 }
        r7 = 0;
        r4 = r6.rawQuery(r5, r7);	 Catch:{ Exception -> 0x0276, all -> 0x0299 }
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        if (r5 == 0) goto L_0x02fe;
    L_0x015d:
        r5 = r4.isAfterLast();	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        if (r5 != 0) goto L_0x02fe;
    L_0x0163:
        r5 = "country";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        r9 = r4.getString(r5);	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        r5 = "countrycode";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02b6, all -> 0x02af }
        r8 = r4.getString(r5);	 Catch:{ Exception -> 0x02b6, all -> 0x02af }
        r5 = "province";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02c0, all -> 0x02af }
        r7 = r4.getString(r5);	 Catch:{ Exception -> 0x02c0, all -> 0x02af }
        r5 = "city";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02c8, all -> 0x02af }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x02c8, all -> 0x02af }
        r5 = "citycode";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02ce, all -> 0x02af }
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x02ce, all -> 0x02af }
        r11 = "district";
        r11 = r4.getColumnIndex(r11);	 Catch:{ Exception -> 0x02d2, all -> 0x02af }
        r25 = r4.getString(r11);	 Catch:{ Exception -> 0x02d2, all -> 0x02af }
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
    L_0x01ac:
        if (r4 == 0) goto L_0x01b1;
    L_0x01ae:
        r4.close();	 Catch:{ Exception -> 0x02aa }
    L_0x01b1:
        if (r11 == 0) goto L_0x01c1;
    L_0x01b3:
        r4 = new java.lang.String;
        r11 = r11.getBytes();
        r11 = com.baidu.android.bbalbs.common.security.Base64.decode(r11);
        r4.<init>(r11);
        r11 = r4;
    L_0x01c1:
        if (r9 == 0) goto L_0x01d1;
    L_0x01c3:
        r4 = new java.lang.String;
        r9 = r9.getBytes();
        r9 = com.baidu.android.bbalbs.common.security.Base64.decode(r9);
        r4.<init>(r9);
        r9 = r4;
    L_0x01d1:
        if (r8 == 0) goto L_0x01e1;
    L_0x01d3:
        r4 = new java.lang.String;
        r8 = r8.getBytes();
        r8 = com.baidu.android.bbalbs.common.security.Base64.decode(r8);
        r4.<init>(r8);
        r8 = r4;
    L_0x01e1:
        if (r7 == 0) goto L_0x01f1;
    L_0x01e3:
        r4 = new java.lang.String;
        r7 = r7.getBytes();
        r7 = com.baidu.android.bbalbs.common.security.Base64.decode(r7);
        r4.<init>(r7);
        r7 = r4;
    L_0x01f1:
        if (r6 == 0) goto L_0x0201;
    L_0x01f3:
        r4 = new java.lang.String;
        r6 = r6.getBytes();
        r6 = com.baidu.android.bbalbs.common.security.Base64.decode(r6);
        r4.<init>(r6);
        r6 = r4;
    L_0x0201:
        if (r5 == 0) goto L_0x0211;
    L_0x0203:
        r4 = new java.lang.String;
        r5 = r5.getBytes();
        r5 = com.baidu.android.bbalbs.common.security.Base64.decode(r5);
        r4.<init>(r5);
        r5 = r4;
    L_0x0211:
        if (r10 == 0) goto L_0x0221;
    L_0x0213:
        r4 = new java.lang.String;
        r10 = r10.getBytes();
        r10 = com.baidu.android.bbalbs.common.security.Base64.decode(r10);
        r4.<init>(r10);
        r10 = r4;
    L_0x0221:
        if (r18 == 0) goto L_0x02f1;
    L_0x0223:
        r4 = new java.lang.String;
        r12 = r18.getBytes();
        r12 = com.baidu.android.bbalbs.common.security.Base64.decode(r12);
        r4.<init>(r12);
    L_0x0230:
        r12 = new com.baidu.location.Address$Builder;
        r12.<init>();
        r11 = r12.country(r11);
        r9 = r11.countryCode(r9);
        r8 = r9.province(r8);
        r7 = r8.city(r7);
        r6 = r7.cityCode(r6);
        r5 = r6.district(r5);
        r5 = r5.street(r10);
        r4 = r5.streetNumber(r4);
        r4 = r4.build();
        return r4;
    L_0x025a:
        r5 = move-exception;
        r10 = r4;
        goto L_0x013f;
    L_0x025e:
        r4 = move-exception;
        r5 = r11;
        r4 = r10;
    L_0x0261:
        if (r5 == 0) goto L_0x030c;
    L_0x0263:
        r5.close();	 Catch:{ Exception -> 0x0269 }
        r10 = r4;
        goto L_0x013f;
    L_0x0269:
        r5 = move-exception;
        r10 = r4;
        goto L_0x013f;
    L_0x026d:
        r4 = move-exception;
        r19 = r11;
    L_0x0270:
        if (r19 == 0) goto L_0x0275;
    L_0x0272:
        r19.close();	 Catch:{ Exception -> 0x02a8 }
    L_0x0275:
        throw r4;
    L_0x0276:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        r9 = r24;
    L_0x0281:
        if (r4 == 0) goto L_0x02f5;
    L_0x0283:
        r4.close();	 Catch:{ Exception -> 0x028f }
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x028f:
        r4 = move-exception;
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x0299:
        r5 = move-exception;
        r30 = r5;
        r5 = r4;
        r4 = r30;
    L_0x029f:
        if (r5 == 0) goto L_0x02a4;
    L_0x02a1:
        r5.close();	 Catch:{ Exception -> 0x02ad }
    L_0x02a4:
        throw r4;
    L_0x02a5:
        r5 = move-exception;
        goto L_0x0137;
    L_0x02a8:
        r5 = move-exception;
        goto L_0x0275;
    L_0x02aa:
        r4 = move-exception;
        goto L_0x01b1;
    L_0x02ad:
        r5 = move-exception;
        goto L_0x02a4;
    L_0x02af:
        r5 = move-exception;
        r30 = r5;
        r5 = r4;
        r4 = r30;
        goto L_0x029f;
    L_0x02b6:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        goto L_0x0281;
    L_0x02c0:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        goto L_0x0281;
    L_0x02c8:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        goto L_0x0281;
    L_0x02ce:
        r5 = move-exception;
        r5 = r20;
        goto L_0x0281;
    L_0x02d2:
        r11 = move-exception;
        goto L_0x0281;
    L_0x02d4:
        r4 = move-exception;
        goto L_0x0270;
    L_0x02d6:
        r4 = move-exception;
        r5 = r19;
        r4 = r10;
        goto L_0x0261;
    L_0x02db:
        r5 = move-exception;
        r5 = r19;
        goto L_0x0261;
    L_0x02df:
        r5 = move-exception;
        r10 = r4;
        r4 = r5;
        goto L_0x0132;
    L_0x02e4:
        r5 = move-exception;
        r5 = r11;
        r6 = r12;
        goto L_0x0121;
    L_0x02e9:
        r7 = move-exception;
        goto L_0x0121;
    L_0x02ec:
        r5 = move-exception;
        r5 = r14;
        r6 = r15;
        goto L_0x0121;
    L_0x02f1:
        r4 = r18;
        goto L_0x0230;
    L_0x02f5:
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x02fe:
        r5 = r25;
        r6 = r20;
        r7 = r21;
        r8 = r22;
        r9 = r23;
        r11 = r24;
        goto L_0x01ac;
    L_0x030c:
        r10 = r4;
        goto L_0x013f;
    L_0x030f:
        r10 = r4;
        r4 = r26;
        goto L_0x0110;
    L_0x0314:
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x0319:
        r8 = r16;
        r5 = r14;
        r6 = r15;
        goto L_0x006c;
    L_0x031f:
        r5 = r11;
        r6 = r12;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.g.a(double, double):com.baidu.location.Address");
    }

    /* renamed from: a */
    void m14242a(JSONObject jSONObject) {
        if (this.f18197d != null && this.f18197d.isOpen()) {
            try {
                this.f18197d.beginTransaction();
                for (C3356b c3356b : C3356b.values()) {
                    if (jSONObject.has(c3356b.f18191g)) {
                        String str = "";
                        if (jSONObject.has(c3356b.f18192h)) {
                            str = jSONObject.getString(c3356b.f18192h);
                        }
                        List<String> arrayList = new ArrayList();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(c3356b.f18191g);
                        arrayList.add(c3356b.m14222a(jSONObject2));
                        arrayList.addAll(c3356b.mo2504a(jSONObject2, str, c3356b.f18193i));
                        for (String str2 : arrayList) {
                            this.f18197d.execSQL(str2);
                        }
                    }
                }
                this.f18197d.setTransactionSuccessful();
                this.f18198e = -1;
                this.f18199f = -1;
                try {
                    this.f18197d.endTransaction();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                try {
                    this.f18197d.endTransaction();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    this.f18197d.endTransaction();
                } catch (Exception e4) {
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    boolean m14243a() {
        Cursor rawQuery;
        Throwable th;
        Cursor cursor = null;
        if (this.f18195a.m14195m().m14163m() && this.f18199f == -1 && this.f18198e == -1 && this.f18197d != null && this.f18197d.isOpen()) {
            try {
                rawQuery = this.f18197d.rawQuery("SELECT COUNT(*) FROM RGCSITE;", null);
                try {
                    rawQuery.moveToFirst();
                    this.f18199f = rawQuery.getInt(0);
                    cursor = this.f18197d.rawQuery("SELECT COUNT(*) FROM RGCAREA;", null);
                    cursor.moveToFirst();
                    this.f18198e = cursor.getInt(0);
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                        }
                    }
                    return this.f18199f == 0 ? false : false;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f18199f == 0) {
                }
            } catch (Throwable th3) {
                th = th3;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        if (this.f18199f == 0 && this.f18198e == 0) {
            return true;
        }
    }

    /* renamed from: b */
    List<Poi> m14244b(double d, double d2) {
        Cursor cursor;
        Throwable th;
        List<Poi> arrayList = new ArrayList();
        Object obj = null;
        Cursor rawQuery;
        try {
            rawQuery = this.f18197d.rawQuery(C3356b.POI.m14218a(this.f18196c, d, d2), null);
            try {
                if (rawQuery.moveToFirst()) {
                    int i = 0;
                    while (!rawQuery.isAfterLast()) {
                        int a;
                        String string = rawQuery.getString(0);
                        String string2 = rawQuery.getString(2);
                        double d3 = rawQuery.getDouble(4);
                        double d4 = rawQuery.getDouble(5);
                        int i2 = rawQuery.getInt(6);
                        double c = m14239c(d2, d, d4, d3);
                        if (c < ((double) C3356b.POI.f18189e)) {
                            Poi poi = new Poi(new String(Base64.decode(string.getBytes())), new String(Base64.decode(string2.getBytes())), 1.0d);
                            a = C3361g.m14234a(i2, Math.round((float) c));
                            if (a > i) {
                                obj = poi;
                                rawQuery.moveToNext();
                                i = a;
                            }
                        }
                        a = i;
                        rawQuery.moveToNext();
                        i = a;
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
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                    }
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
                return arrayList;
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
        } catch (Exception e5) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            if (obj != null) {
                arrayList.add(obj);
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        if (obj != null) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* renamed from: b */
    JSONObject m14245b() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        String str = "SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey";
        String str2 = "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)";
        try {
            if (this.f18197d != null && this.f18197d.isOpen()) {
                HashSet hashSet;
                String string;
                String[] strArr;
                JSONObject jSONObject2;
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                cursor2 = this.f18197d.rawQuery(String.format(str, new Object[]{Integer.valueOf(0), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.f18195a.m14195m().m14167q())}), null);
                cursor = this.f18197d.rawQuery(String.format(str, new Object[]{Integer.valueOf(1), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.f18195a.m14195m().m14168r())}), null);
                if (cursor2.moveToFirst()) {
                    hashSet = new HashSet();
                    while (!cursor2.isAfterLast()) {
                        str = cursor2.getString(0);
                        string = cursor2.getString(1);
                        jSONArray3.put(str);
                        hashSet.add(string);
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("\"").append(str).append("\"");
                        cursor2.moveToNext();
                    }
                    strArr = new String[hashSet.size()];
                    hashSet.toArray(strArr);
                    for (Object put : strArr) {
                        jSONArray4.put(put);
                    }
                }
                if (cursor.moveToFirst()) {
                    hashSet = new HashSet();
                    while (!cursor.isAfterLast()) {
                        str = cursor.getString(0);
                        string = cursor.getString(1);
                        jSONArray.put(str);
                        hashSet.add(string);
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("\"").append(str).append("\"");
                        cursor.moveToNext();
                    }
                    strArr = new String[hashSet.size()];
                    hashSet.toArray(strArr);
                    for (Object put2 : strArr) {
                        jSONArray2.put(put2);
                    }
                }
                if (jSONArray3.length() != 0) {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("gk", jSONArray3);
                    jSONObject2.put("ver", jSONArray4);
                    jSONObject.put(GeoPointInfo.KEY_ADDR, jSONObject2);
                }
                if (jSONArray.length() != 0) {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("gk", jSONArray);
                    jSONObject2.put("ver", jSONArray2);
                    jSONObject.put("poi", jSONObject2);
                }
            }
            if (stringBuffer2.length() > 0) {
                this.f18197d.execSQL(String.format(Locale.US, str2, new Object[]{Integer.valueOf(0), stringBuffer2.toString()}));
            }
            if (stringBuffer.length() > 0) {
                this.f18197d.execSQL(String.format(Locale.US, str2, new Object[]{Integer.valueOf(1), stringBuffer.toString()}));
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e6) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e7) {
                }
            }
        }
        return (jSONObject.has("poi") || jSONObject.has(GeoPointInfo.KEY_ADDR)) ? jSONObject : null;
    }
}
