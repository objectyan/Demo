package com.baidu.location.p193e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p193e.C3351e.C3350a;
import com.baidu.mobstat.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.b */
final class C3341b {
    /* renamed from: a */
    private final C3349d f18088a;
    /* renamed from: b */
    private int f18089b;
    /* renamed from: c */
    private double f18090c;
    /* renamed from: d */
    private double f18091d;
    /* renamed from: e */
    private Long f18092e;
    /* renamed from: f */
    private final C3340c f18093f = new C3340c(this, this, true);
    /* renamed from: g */
    private final C3340c f18094g = new C3340c(this, this, false);
    /* renamed from: h */
    private final SQLiteDatabase f18095h;
    /* renamed from: i */
    private final SQLiteDatabase f18096i;
    /* renamed from: j */
    private StringBuffer f18097j = null;
    /* renamed from: k */
    private StringBuffer f18098k = null;
    /* renamed from: l */
    private HashSet<Long> f18099l = new HashSet();
    /* renamed from: m */
    private ConcurrentHashMap<Long, Integer> f18100m = new ConcurrentHashMap();
    /* renamed from: n */
    private ConcurrentHashMap<Long, String> f18101n = new ConcurrentHashMap();
    /* renamed from: o */
    private StringBuffer f18102o = new StringBuffer();
    /* renamed from: p */
    private boolean f18103p = false;

    /* renamed from: com.baidu.location.e.b$b */
    private class C3336b extends Thread {
        /* renamed from: a */
        private String f18064a;
        /* renamed from: b */
        final /* synthetic */ C3341b f18065b;
        /* renamed from: c */
        private Long f18066c;
        /* renamed from: d */
        private BDLocation f18067d;
        /* renamed from: e */
        private BDLocation f18068e;
        /* renamed from: f */
        private BDLocation f18069f;
        /* renamed from: g */
        private String f18070g;
        /* renamed from: h */
        private LinkedHashMap<String, Integer> f18071h;

        private C3336b(C3341b c3341b, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.f18065b = c3341b;
            this.f18064a = str;
            this.f18066c = l;
            this.f18067d = bDLocation;
            this.f18068e = bDLocation2;
            this.f18069f = bDLocation3;
            this.f18070g = str2;
            this.f18071h = linkedHashMap;
        }

        public void run() {
            try {
                this.f18065b.m14088a(this.f18064a, this.f18066c, this.f18067d);
                this.f18065b.f18097j = null;
                this.f18065b.f18098k = null;
                this.f18065b.m14090a(this.f18071h);
                this.f18065b.m14082a(this.f18069f, this.f18067d, this.f18068e, this.f18064a, this.f18066c);
                if (this.f18070g != null) {
                    this.f18065b.f18088a.m14193k().m14213a(this.f18070g);
                }
            } catch (Exception e) {
            }
            this.f18071h = null;
            this.f18064a = null;
            this.f18070g = null;
            this.f18066c = null;
            this.f18067d = null;
            this.f18068e = null;
            this.f18069f = null;
        }
    }

    /* renamed from: com.baidu.location.e.b$a */
    private static final class C3338a {
        /* renamed from: a */
        double f18073a;
        /* renamed from: b */
        double f18074b;
        /* renamed from: c */
        double f18075c;

        private C3338a(double d, double d2, double d3) {
            this.f18073a = d;
            this.f18074b = d2;
            this.f18075c = d3;
        }
    }

    /* renamed from: com.baidu.location.e.b$c */
    private final class C3340c extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3341b f18077a;
        /* renamed from: b */
        private String f18078b;
        /* renamed from: c */
        private final String f18079c;
        /* renamed from: d */
        private String f18080d;
        /* renamed from: e */
        private C3341b f18081e;
        /* renamed from: f */
        private boolean f18082f = false;
        /* renamed from: p */
        private int f18083p = 0;
        /* renamed from: q */
        private long f18084q = -1;
        /* renamed from: r */
        private long f18085r = -1;
        /* renamed from: s */
        private long f18086s = -1;
        /* renamed from: t */
        private long f18087t = -1;

        /* renamed from: com.baidu.location.e.b$c$1 */
        class C33391 extends Thread {
            /* renamed from: a */
            final /* synthetic */ C3340c f18076a;

            C33391(C3340c c3340c) {
                this.f18076a = c3340c;
            }

            public void run() {
                Exception exception;
                Exception exception2;
                JSONObject jSONObject;
                Iterator keys;
                StringBuffer stringBuffer;
                StringBuffer stringBuffer2;
                Object obj;
                int i;
                int i2;
                int i3;
                String string;
                Double valueOf;
                int i4;
                int i5;
                Object obj2;
                Object obj3;
                super.run();
                if (this.f18076a.f18077a.f18095h == null || this.f18076a.f18077a.f18096i == null || !this.f18076a.f18077a.f18095h.isOpen() || !this.f18076a.f18077a.f18096i.isOpen()) {
                    this.f18076a.f18082f = false;
                    return;
                }
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                StringBuffer stringBuffer3;
                Object obj4;
                Object obj5;
                String str;
                Object obj6;
                int i6;
                int i7;
                Object obj7;
                int i8;
                Object obj8;
                JSONObject jSONObject4 = null;
                JSONObject jSONObject5 = null;
                JSONObject jSONObject6 = null;
                try {
                    if (this.f18076a.j != null) {
                        jSONObject2 = new JSONObject(this.f18076a.j);
                        try {
                            jSONObject5 = jSONObject2.has("model") ? jSONObject2.getJSONObject("model") : null;
                            try {
                                if (jSONObject2.has("rgc")) {
                                    jSONObject6 = jSONObject2.getJSONObject("rgc");
                                }
                            } catch (Exception e) {
                                exception = e;
                                jSONObject4 = jSONObject5;
                                jSONObject5 = jSONObject2;
                                exception2 = exception;
                                exception2.printStackTrace();
                                jSONObject2 = jSONObject5;
                                jSONObject3 = jSONObject4;
                                this.f18076a.f18077a.f18095h.beginTransaction();
                                this.f18076a.f18077a.f18096i.beginTransaction();
                                if (jSONObject6 != null) {
                                    this.f18076a.f18077a.f18088a.m14194l().m14242a(jSONObject6);
                                }
                                this.f18076a.f18085r = System.currentTimeMillis();
                                this.f18076a.f18081e.m14091a(jSONObject2.getString("bdlist").split(";"));
                                this.f18076a.f18081e.m14089a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                                jSONObject = jSONObject3.getJSONObject("cell");
                                keys = jSONObject.keys();
                                stringBuffer = new StringBuffer();
                                stringBuffer2 = new StringBuffer();
                                stringBuffer3 = new StringBuffer();
                                obj4 = 1;
                                obj = 1;
                                obj5 = 1;
                                i = 0;
                                i2 = 0;
                                i3 = 0;
                                while (keys.hasNext()) {
                                    str = (String) keys.next();
                                    string = jSONObject.getString(str);
                                    valueOf = Double.valueOf(string.split(",")[3]);
                                    if (obj == null) {
                                        obj = null;
                                    } else {
                                        try {
                                            stringBuffer2.append(',');
                                        } catch (Exception e2) {
                                            this.f18076a.m14065c();
                                            return;
                                        } finally {
                                            try {
                                                if (this.f18076a.f18077a.f18095h != null && this.f18076a.f18077a.f18095h.isOpen()) {
                                                    this.f18076a.f18077a.f18095h.endTransaction();
                                                }
                                                if (this.f18076a.f18077a.f18096i != null && this.f18076a.f18077a.f18096i.isOpen()) {
                                                    this.f18076a.f18077a.f18096i.endTransaction();
                                                }
                                            } catch (Exception e3) {
                                            }
                                            this.f18076a.j = null;
                                            this.f18076a.f18082f = false;
                                        }
                                    }
                                    stringBuffer2.append(str);
                                    i2++;
                                    if (valueOf.doubleValue() <= 0.0d) {
                                        if (obj5 == null) {
                                            obj5 = null;
                                        } else {
                                            stringBuffer3.append(',');
                                        }
                                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                        i3++;
                                        i4 = i;
                                        obj6 = obj4;
                                    } else {
                                        if (obj4 == null) {
                                            obj4 = null;
                                        } else {
                                            stringBuffer.append(',');
                                        }
                                        stringBuffer.append(str);
                                        i4 = i + 1;
                                        obj6 = obj4;
                                    }
                                    if (i2 >= 100) {
                                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                        obj = 1;
                                        stringBuffer2.setLength(0);
                                        i2 -= 100;
                                    }
                                    if (i3 >= 100) {
                                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                        obj5 = 1;
                                        stringBuffer3.setLength(0);
                                        i3 -= 100;
                                    }
                                    if (i4 < 100) {
                                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                        obj6 = 1;
                                        stringBuffer.setLength(0);
                                        i4 -= 100;
                                    }
                                    obj4 = obj6;
                                    i = i4;
                                }
                                if (i2 > 0) {
                                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                }
                                if (i3 > 0) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                }
                                if (i > 0) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                }
                                jSONObject = jSONObject3.getJSONObject("ap");
                                keys = jSONObject.keys();
                                i6 = 0;
                                i5 = 0;
                                i7 = 0;
                                obj2 = 1;
                                obj7 = 1;
                                obj6 = 1;
                                stringBuffer = new StringBuffer();
                                stringBuffer2 = new StringBuffer();
                                stringBuffer3 = new StringBuffer();
                                while (keys.hasNext()) {
                                    str = (String) keys.next();
                                    string = jSONObject.getString(str);
                                    valueOf = Double.valueOf(string.split(",")[3]);
                                    if (obj7 == null) {
                                        obj7 = null;
                                    } else {
                                        stringBuffer2.append(',');
                                    }
                                    stringBuffer2.append(str);
                                    i5++;
                                    if (valueOf.doubleValue() <= 0.0d) {
                                        if (obj6 == null) {
                                            obj6 = null;
                                        } else {
                                            stringBuffer3.append(',');
                                        }
                                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                        i4 = i7 + 1;
                                        i7 = i6;
                                        i8 = i4;
                                        obj8 = obj6;
                                        i = i8;
                                    } else {
                                        if (obj2 == null) {
                                            obj2 = null;
                                        } else {
                                            stringBuffer.append(',');
                                        }
                                        stringBuffer.append(str);
                                        obj3 = obj6;
                                        i = i7;
                                        i7 = i6 + 1;
                                        obj8 = obj3;
                                    }
                                    if (i5 >= 100) {
                                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                        obj7 = 1;
                                        stringBuffer2.setLength(0);
                                        i5 -= 100;
                                    }
                                    if (i >= 100) {
                                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                        obj8 = 1;
                                        stringBuffer3.setLength(0);
                                        i -= 100;
                                    }
                                    if (i7 <= 0) {
                                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                    }
                                    i6 = i7;
                                    i7 = i;
                                    obj6 = obj8;
                                }
                                if (i5 > 0) {
                                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                }
                                if (i7 > 0) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                }
                                if (i6 > 0) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                }
                                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                                this.f18076a.m14065c();
                                this.f18076a.f18077a.f18095h.setTransactionSuccessful();
                                this.f18076a.f18077a.f18096i.setTransactionSuccessful();
                                this.f18076a.f18077a.f18095h.endTransaction();
                                this.f18076a.f18077a.f18096i.endTransaction();
                                this.f18076a.j = null;
                                this.f18076a.f18082f = false;
                            }
                        } catch (Exception e4) {
                            exception = e4;
                            jSONObject5 = jSONObject2;
                            exception2 = exception;
                            exception2.printStackTrace();
                            jSONObject2 = jSONObject5;
                            jSONObject3 = jSONObject4;
                            this.f18076a.f18077a.f18095h.beginTransaction();
                            this.f18076a.f18077a.f18096i.beginTransaction();
                            if (jSONObject6 != null) {
                                this.f18076a.f18077a.f18088a.m14194l().m14242a(jSONObject6);
                            }
                            this.f18076a.f18085r = System.currentTimeMillis();
                            this.f18076a.f18081e.m14091a(jSONObject2.getString("bdlist").split(";"));
                            this.f18076a.f18081e.m14089a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                            jSONObject = jSONObject3.getJSONObject("cell");
                            keys = jSONObject.keys();
                            stringBuffer = new StringBuffer();
                            stringBuffer2 = new StringBuffer();
                            stringBuffer3 = new StringBuffer();
                            obj4 = 1;
                            obj = 1;
                            obj5 = 1;
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            while (keys.hasNext()) {
                                str = (String) keys.next();
                                string = jSONObject.getString(str);
                                valueOf = Double.valueOf(string.split(",")[3]);
                                if (obj == null) {
                                    stringBuffer2.append(',');
                                } else {
                                    obj = null;
                                }
                                stringBuffer2.append(str);
                                i2++;
                                if (valueOf.doubleValue() <= 0.0d) {
                                    if (obj4 == null) {
                                        stringBuffer.append(',');
                                    } else {
                                        obj4 = null;
                                    }
                                    stringBuffer.append(str);
                                    i4 = i + 1;
                                    obj6 = obj4;
                                } else {
                                    if (obj5 == null) {
                                        stringBuffer3.append(',');
                                    } else {
                                        obj5 = null;
                                    }
                                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                    i3++;
                                    i4 = i;
                                    obj6 = obj4;
                                }
                                if (i2 >= 100) {
                                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                    obj = 1;
                                    stringBuffer2.setLength(0);
                                    i2 -= 100;
                                }
                                if (i3 >= 100) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                    obj5 = 1;
                                    stringBuffer3.setLength(0);
                                    i3 -= 100;
                                }
                                if (i4 < 100) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                    obj6 = 1;
                                    stringBuffer.setLength(0);
                                    i4 -= 100;
                                }
                                obj4 = obj6;
                                i = i4;
                            }
                            if (i2 > 0) {
                                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            }
                            if (i3 > 0) {
                                this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            }
                            if (i > 0) {
                                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            }
                            jSONObject = jSONObject3.getJSONObject("ap");
                            keys = jSONObject.keys();
                            i6 = 0;
                            i5 = 0;
                            i7 = 0;
                            obj2 = 1;
                            obj7 = 1;
                            obj6 = 1;
                            stringBuffer = new StringBuffer();
                            stringBuffer2 = new StringBuffer();
                            stringBuffer3 = new StringBuffer();
                            while (keys.hasNext()) {
                                str = (String) keys.next();
                                string = jSONObject.getString(str);
                                valueOf = Double.valueOf(string.split(",")[3]);
                                if (obj7 == null) {
                                    stringBuffer2.append(',');
                                } else {
                                    obj7 = null;
                                }
                                stringBuffer2.append(str);
                                i5++;
                                if (valueOf.doubleValue() <= 0.0d) {
                                    if (obj2 == null) {
                                        stringBuffer.append(',');
                                    } else {
                                        obj2 = null;
                                    }
                                    stringBuffer.append(str);
                                    obj3 = obj6;
                                    i = i7;
                                    i7 = i6 + 1;
                                    obj8 = obj3;
                                } else {
                                    if (obj6 == null) {
                                        stringBuffer3.append(',');
                                    } else {
                                        obj6 = null;
                                    }
                                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                    i4 = i7 + 1;
                                    i7 = i6;
                                    i8 = i4;
                                    obj8 = obj6;
                                    i = i8;
                                }
                                if (i5 >= 100) {
                                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                    obj7 = 1;
                                    stringBuffer2.setLength(0);
                                    i5 -= 100;
                                }
                                if (i >= 100) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                    obj8 = 1;
                                    stringBuffer3.setLength(0);
                                    i -= 100;
                                }
                                if (i7 <= 0) {
                                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                }
                                i6 = i7;
                                i7 = i;
                                obj6 = obj8;
                            }
                            if (i5 > 0) {
                                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            }
                            if (i7 > 0) {
                                this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            }
                            if (i6 > 0) {
                                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            }
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                            this.f18076a.m14065c();
                            this.f18076a.f18077a.f18095h.setTransactionSuccessful();
                            this.f18076a.f18077a.f18096i.setTransactionSuccessful();
                            this.f18076a.f18077a.f18095h.endTransaction();
                            this.f18076a.f18077a.f18096i.endTransaction();
                            this.f18076a.j = null;
                            this.f18076a.f18082f = false;
                        }
                    }
                    jSONObject2 = null;
                    jSONObject5 = null;
                    jSONObject3 = jSONObject5;
                } catch (Exception e5) {
                    exception2 = e5;
                    exception2.printStackTrace();
                    jSONObject2 = jSONObject5;
                    jSONObject3 = jSONObject4;
                    this.f18076a.f18077a.f18095h.beginTransaction();
                    this.f18076a.f18077a.f18096i.beginTransaction();
                    if (jSONObject6 != null) {
                        this.f18076a.f18077a.f18088a.m14194l().m14242a(jSONObject6);
                    }
                    this.f18076a.f18085r = System.currentTimeMillis();
                    this.f18076a.f18081e.m14091a(jSONObject2.getString("bdlist").split(";"));
                    this.f18076a.f18081e.m14089a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                    jSONObject = jSONObject3.getJSONObject("cell");
                    keys = jSONObject.keys();
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    obj4 = 1;
                    obj = 1;
                    obj5 = 1;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj == null) {
                            stringBuffer2.append(',');
                        } else {
                            obj = null;
                        }
                        stringBuffer2.append(str);
                        i2++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj4 == null) {
                                stringBuffer.append(',');
                            } else {
                                obj4 = null;
                            }
                            stringBuffer.append(str);
                            i4 = i + 1;
                            obj6 = obj4;
                        } else {
                            if (obj5 == null) {
                                stringBuffer3.append(',');
                            } else {
                                obj5 = null;
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i3++;
                            i4 = i;
                            obj6 = obj4;
                        }
                        if (i2 >= 100) {
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj = 1;
                            stringBuffer2.setLength(0);
                            i2 -= 100;
                        }
                        if (i3 >= 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj5 = 1;
                            stringBuffer3.setLength(0);
                            i3 -= 100;
                        }
                        if (i4 < 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            obj6 = 1;
                            stringBuffer.setLength(0);
                            i4 -= 100;
                        }
                        obj4 = obj6;
                        i = i4;
                    }
                    if (i2 > 0) {
                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i3 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    jSONObject = jSONObject3.getJSONObject("ap");
                    keys = jSONObject.keys();
                    i6 = 0;
                    i5 = 0;
                    i7 = 0;
                    obj2 = 1;
                    obj7 = 1;
                    obj6 = 1;
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj7 == null) {
                            stringBuffer2.append(',');
                        } else {
                            obj7 = null;
                        }
                        stringBuffer2.append(str);
                        i5++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj2 == null) {
                                stringBuffer.append(',');
                            } else {
                                obj2 = null;
                            }
                            stringBuffer.append(str);
                            obj3 = obj6;
                            i = i7;
                            i7 = i6 + 1;
                            obj8 = obj3;
                        } else {
                            if (obj6 == null) {
                                stringBuffer3.append(',');
                            } else {
                                obj6 = null;
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i4 = i7 + 1;
                            i7 = i6;
                            i8 = i4;
                            obj8 = obj6;
                            i = i8;
                        }
                        if (i5 >= 100) {
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj7 = 1;
                            stringBuffer2.setLength(0);
                            i5 -= 100;
                        }
                        if (i >= 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj8 = 1;
                            stringBuffer3.setLength(0);
                            i -= 100;
                        }
                        if (i7 <= 0) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        }
                        i6 = i7;
                        i7 = i;
                        obj6 = obj8;
                    }
                    if (i5 > 0) {
                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i7 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i6 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                    this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                    this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                    this.f18076a.m14065c();
                    this.f18076a.f18077a.f18095h.setTransactionSuccessful();
                    this.f18076a.f18077a.f18096i.setTransactionSuccessful();
                    this.f18076a.f18077a.f18095h.endTransaction();
                    this.f18076a.f18077a.f18096i.endTransaction();
                    this.f18076a.j = null;
                    this.f18076a.f18082f = false;
                }
                try {
                    this.f18076a.f18077a.f18095h.beginTransaction();
                    this.f18076a.f18077a.f18096i.beginTransaction();
                } catch (Exception e6) {
                }
                if (jSONObject6 != null) {
                    this.f18076a.f18077a.f18088a.m14194l().m14242a(jSONObject6);
                }
                if (jSONObject2 != null && jSONObject2.has("type") && jSONObject2.getString("type").equals("0")) {
                    this.f18076a.f18085r = System.currentTimeMillis();
                }
                if (jSONObject2 != null && jSONObject2.has("bdlist")) {
                    this.f18076a.f18081e.m14091a(jSONObject2.getString("bdlist").split(";"));
                }
                if (jSONObject2 != null && jSONObject2.has("loadurl")) {
                    this.f18076a.f18081e.m14089a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                }
                if (jSONObject3 != null && jSONObject3.has("cell")) {
                    jSONObject = jSONObject3.getJSONObject("cell");
                    keys = jSONObject.keys();
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    obj4 = 1;
                    obj = 1;
                    obj5 = 1;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj == null) {
                            obj = null;
                        } else {
                            stringBuffer2.append(',');
                        }
                        stringBuffer2.append(str);
                        i2++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj5 == null) {
                                obj5 = null;
                            } else {
                                stringBuffer3.append(',');
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i3++;
                            i4 = i;
                            obj6 = obj4;
                        } else {
                            if (obj4 == null) {
                                obj4 = null;
                            } else {
                                stringBuffer.append(',');
                            }
                            stringBuffer.append(str);
                            i4 = i + 1;
                            obj6 = obj4;
                        }
                        if (i2 >= 100) {
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj = 1;
                            stringBuffer2.setLength(0);
                            i2 -= 100;
                        }
                        if (i3 >= 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj5 = 1;
                            stringBuffer3.setLength(0);
                            i3 -= 100;
                        }
                        if (i4 < 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            obj6 = 1;
                            stringBuffer.setLength(0);
                            i4 -= 100;
                        }
                        obj4 = obj6;
                        i = i4;
                    }
                    if (i2 > 0) {
                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i3 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                }
                if (jSONObject3 != null && jSONObject3.has("ap")) {
                    jSONObject = jSONObject3.getJSONObject("ap");
                    keys = jSONObject.keys();
                    i6 = 0;
                    i5 = 0;
                    i7 = 0;
                    obj2 = 1;
                    obj7 = 1;
                    obj6 = 1;
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj7 == null) {
                            obj7 = null;
                        } else {
                            stringBuffer2.append(',');
                        }
                        stringBuffer2.append(str);
                        i5++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj6 == null) {
                                obj6 = null;
                            } else {
                                stringBuffer3.append(',');
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i4 = i7 + 1;
                            i7 = i6;
                            i8 = i4;
                            obj8 = obj6;
                            i = i8;
                        } else {
                            if (obj2 == null) {
                                obj2 = null;
                            } else {
                                stringBuffer.append(',');
                            }
                            stringBuffer.append(str);
                            obj3 = obj6;
                            i = i7;
                            i7 = i6 + 1;
                            obj8 = obj3;
                        }
                        if (i5 >= 100) {
                            this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj7 = 1;
                            stringBuffer2.setLength(0);
                            i5 -= 100;
                        }
                        if (i >= 100) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj8 = 1;
                            stringBuffer3.setLength(0);
                            i -= 100;
                        }
                        if (i7 <= 0) {
                            this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        }
                        i6 = i7;
                        i7 = i;
                        obj6 = obj8;
                    }
                    if (i5 > 0) {
                        this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i7 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i6 > 0) {
                        this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                }
                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.f18076a.f18077a.f18095h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.f18076a.f18077a.f18096i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                if (!(jSONObject3 == null || jSONObject3.has("ap") || jSONObject3.has("cell"))) {
                    this.f18076a.m14065c();
                }
                this.f18076a.f18077a.f18095h.setTransactionSuccessful();
                this.f18076a.f18077a.f18096i.setTransactionSuccessful();
                try {
                    if (this.f18076a.f18077a.f18095h != null && this.f18076a.f18077a.f18095h.isOpen()) {
                        this.f18076a.f18077a.f18095h.endTransaction();
                    }
                    if (this.f18076a.f18077a.f18096i != null && this.f18076a.f18077a.f18096i.isOpen()) {
                        this.f18076a.f18077a.f18096i.endTransaction();
                    }
                } catch (Exception e7) {
                }
                this.f18076a.j = null;
                this.f18076a.f18082f = false;
            }
        }

        C3340c(C3341b c3341b, C3341b c3341b2, boolean z) {
            this.f18077a = c3341b;
            this.f18081e = c3341b2;
            if (z) {
                this.f18079c = "load";
            } else {
                this.f18079c = "update";
            }
            this.k = new HashMap();
            this.f18078b = C3349d.f18151b;
        }

        /* renamed from: a */
        private void m14062a(String str, String str2, String str3) {
            this.f18080d = str3;
            this.f18078b = String.format("http://%s/%s", new Object[]{str, str2});
            m13298a(false, "ofloc.map.baidu.com");
        }

        /* renamed from: c */
        private void m14065c() {
            this.f18083p++;
            this.f18084q = System.currentTimeMillis();
        }

        /* renamed from: d */
        private boolean m14066d() {
            if (this.f18083p < 2) {
                return true;
            }
            if (this.f18084q + 43200000 >= System.currentTimeMillis()) {
                return false;
            }
            this.f18083p = 0;
            this.f18084q = -1;
            return true;
        }

        /* renamed from: e */
        private void m14067e() {
            this.f18080d = null;
            if (!m14072m()) {
                this.f18080d = m14069g();
            } else if (this.f18085r == -1 || this.f18085r + 86400000 <= System.currentTimeMillis()) {
                this.f18080d = m14068f();
            }
            if (this.f18080d == null && (this.f18086s == -1 || this.f18086s + 86400000 <= System.currentTimeMillis())) {
                if (this.f18077a.f18088a.m14194l().m14243a()) {
                    this.f18080d = m14070k();
                } else {
                    this.f18080d = m14071l();
                }
            }
            if (this.f18080d != null) {
                m13299c("https://ofloc.map.baidu.com/offline_loc");
            }
        }

        /* renamed from: f */
        private String m14068f() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put("cuid", C3381b.m14398a().f18317b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", C3381b.f18312e + Config.TRACE_TODAY_VISIT_SPLIT + C3381b.f18311d);
            } catch (Exception e) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()) : null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        private java.lang.String m14069g() {
            /*
            r11 = this;
            r4 = 0;
            r1 = 0;
            r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r6.<init>();	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r0.<init>();	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r2 = r11.f18077a;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r2 = r2.f18096i;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r3 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 0;
            r8 = "CL";
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 1;
            r8 = 5;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 2;
            r8 = 50;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5 = 0;
            r2 = r2.rawQuery(r3, r5);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            if (r2 == 0) goto L_0x0196;
        L_0x003a:
            r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r3 == 0) goto L_0x0196;
        L_0x0040:
            r3 = r2.getCount();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5 = new org.json.JSONArray;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5.<init>();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
        L_0x0049:
            r7 = r2.isAfterLast();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r7 != 0) goto L_0x00ac;
        L_0x004f:
            r7 = 1;
            r7 = r2.getString(r7);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5.put(r7);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r2.moveToNext();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            goto L_0x0049;
        L_0x005b:
            r3 = move-exception;
            r3 = r1;
        L_0x005d:
            if (r3 == 0) goto L_0x0062;
        L_0x005f:
            r3.close();	 Catch:{ Exception -> 0x0179 }
        L_0x0062:
            if (r2 == 0) goto L_0x0193;
        L_0x0064:
            r2.close();	 Catch:{ Exception -> 0x0166 }
            r2 = r0;
        L_0x0068:
            if (r2 == 0) goto L_0x0190;
        L_0x006a:
            r0 = "model";
            r0 = r2.has(r0);
            if (r0 != 0) goto L_0x0190;
        L_0x0073:
            r4 = r11.f18087t;
            r6 = -1;
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x0089;
        L_0x007b:
            r4 = r11.f18087t;
            r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r4 = r4 + r6;
            r6 = java.lang.System.currentTimeMillis();
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 >= 0) goto L_0x0190;
        L_0x0089:
            r0 = r2.toString();
            r1 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0);
            r4 = java.lang.System.currentTimeMillis();
            r11.f18087t = r4;
            r0 = r1;
        L_0x0098:
            if (r2 == 0) goto L_0x00ab;
        L_0x009a:
            r1 = "model";
            r1 = r2.has(r1);
            if (r1 == 0) goto L_0x00ab;
        L_0x00a3:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0);
        L_0x00ab:
            return r0;
        L_0x00ac:
            r7 = "cell";
            r6.put(r7, r5);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5 = r3;
        L_0x00b3:
            r3 = r11.f18077a;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r3 = r3.f18096i;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r7 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r8 = 3;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 0;
            r10 = "AP";
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 1;
            r10 = 5;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 2;
            r10 = 50;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r7 = java.lang.String.format(r7, r8);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8 = 0;
            r3 = r3.rawQuery(r7, r8);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r3 == 0) goto L_0x010b;
        L_0x00e1:
            r7 = r3.moveToFirst();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r7 == 0) goto L_0x010b;
        L_0x00e7:
            r4 = r3.getCount();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x00f0:
            r8 = r3.isAfterLast();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r8 != 0) goto L_0x0105;
        L_0x00f6:
            r8 = 1;
            r8 = r3.getString(r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7.put(r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r3.moveToNext();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            goto L_0x00f0;
        L_0x0102:
            r4 = move-exception;
            goto L_0x005d;
        L_0x0105:
            r8 = "ap";
            r6.put(r8, r7);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x010b:
            r7 = "type";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "cuid";
            r8 = com.baidu.location.p188h.C3381b.m14398a();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.f18317b;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "ver";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "prod";
            r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = com.baidu.location.p188h.C3381b.f18312e;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = ":";
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = com.baidu.location.p188h.C3381b.f18311d;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.toString();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r5 != 0) goto L_0x014f;
        L_0x014d:
            if (r4 == 0) goto L_0x0155;
        L_0x014f:
            r4 = "model";
            r0.put(r4, r6);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x0155:
            if (r3 == 0) goto L_0x015a;
        L_0x0157:
            r3.close();	 Catch:{ Exception -> 0x0177 }
        L_0x015a:
            if (r2 == 0) goto L_0x0193;
        L_0x015c:
            r2.close();	 Catch:{ Exception -> 0x0162 }
            r2 = r0;
            goto L_0x0068;
        L_0x0162:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0068;
        L_0x0166:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0068;
        L_0x016a:
            r0 = move-exception;
            r2 = r1;
        L_0x016c:
            if (r1 == 0) goto L_0x0171;
        L_0x016e:
            r1.close();	 Catch:{ Exception -> 0x017c }
        L_0x0171:
            if (r2 == 0) goto L_0x0176;
        L_0x0173:
            r2.close();	 Catch:{ Exception -> 0x017e }
        L_0x0176:
            throw r0;
        L_0x0177:
            r3 = move-exception;
            goto L_0x015a;
        L_0x0179:
            r3 = move-exception;
            goto L_0x0062;
        L_0x017c:
            r1 = move-exception;
            goto L_0x0171;
        L_0x017e:
            r1 = move-exception;
            goto L_0x0176;
        L_0x0180:
            r0 = move-exception;
            goto L_0x016c;
        L_0x0182:
            r0 = move-exception;
            r1 = r3;
            goto L_0x016c;
        L_0x0185:
            r0 = move-exception;
            r0 = r1;
            r2 = r1;
            r3 = r1;
            goto L_0x005d;
        L_0x018b:
            r2 = move-exception;
            r2 = r1;
            r3 = r1;
            goto L_0x005d;
        L_0x0190:
            r0 = r1;
            goto L_0x0098;
        L_0x0193:
            r2 = r0;
            goto L_0x0068;
        L_0x0196:
            r5 = r4;
            goto L_0x00b3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.c.g():java.lang.String");
        }

        /* renamed from: k */
        private String m14070k() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put("ver", "1");
                    jSONObject.put("cuid", C3381b.m14398a().f18317b);
                    jSONObject.put("prod", C3381b.f18312e + Config.TRACE_TODAY_VISIT_SPLIT + C3381b.f18311d);
                    this.f18086s = System.currentTimeMillis();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()) : null;
        }

        /* renamed from: l */
        private String m14071l() {
            JSONObject jSONObject;
            try {
                JSONObject b = this.f18077a.f18088a.m14194l().m14245b();
                if (b != null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "3");
                        jSONObject.put("ver", "1");
                        jSONObject.put("cuid", C3381b.m14398a().f18317b);
                        jSONObject.put("prod", C3381b.f18312e + Config.TRACE_TODAY_VISIT_SPLIT + C3381b.f18311d);
                        jSONObject.put("rgc", b);
                        this.f18086s = System.currentTimeMillis();
                    } catch (Exception e) {
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()) : null;
        }

        /* renamed from: m */
        private boolean m14072m() {
            Cursor rawQuery;
            Throwable th;
            Cursor cursor = null;
            boolean z = true;
            try {
                rawQuery = this.f18077a.f18095h.rawQuery("SELECT COUNT(*) FROM AP;", null);
                try {
                    cursor = this.f18077a.f18095h.rawQuery("SELECT COUNT(*) FROM CL", null);
                    if (!(rawQuery == null || !rawQuery.moveToFirst() || cursor == null || !cursor.moveToFirst() || (rawQuery.getInt(0) == 0 && cursor.getInt(0) == 0))) {
                        z = false;
                    }
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
                    return z;
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
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            return z;
        }

        /* renamed from: a */
        public void mo2494a() {
            this.f18082f = true;
            this.h = this.f18078b;
            this.k.clear();
            this.k.put("qt", this.f18079c);
            this.k.put("req", this.f18080d);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                this.f18082f = false;
                m14065c();
                return;
            }
            new C33391(this).start();
        }

        /* renamed from: b */
        void mo2500b() {
            if (m14066d() && !this.f18082f) {
                this.f18077a.f18094g.m14067e();
            }
        }
    }

    C3341b(C3349d c3349d) {
        File file;
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        this.f18088a = c3349d;
        try {
            file = new File(this.f18088a.m14185c(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e) {
            openOrCreateDatabase = null;
        }
        this.f18095h = openOrCreateDatabase;
        if (this.f18095h != null) {
            try {
                this.f18095h.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.f18095h.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception e2) {
            }
        }
        try {
            file = new File(this.f18088a.m14185c(), "ofl_statistics.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e3) {
        }
        this.f18096i = sQLiteDatabase;
        if (this.f18096i != null) {
            try {
                this.f18096i.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.f18096i.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception e4) {
            }
        }
    }

    /* renamed from: a */
    private double m14076a(double d, double d2, double d3, double d4) {
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

    /* renamed from: a */
    private int m14077a(ArrayList<C3338a> arrayList, double d) {
        if (arrayList.size() == 0) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2;
            int i3;
            if (arrayList.size() >= 3) {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    d2 += ((C3338a) arrayList.get(i2)).f18073a;
                    d3 += ((C3338a) arrayList.get(i2)).f18074b;
                }
                d2 /= (double) arrayList.size();
                d3 /= (double) arrayList.size();
                int i4 = 0;
                int i5 = -1;
                double d4 = -1.0d;
                while (i4 < arrayList.size()) {
                    double a = m14076a(d3, d2, ((C3338a) arrayList.get(i4)).f18074b, ((C3338a) arrayList.get(i4)).f18073a);
                    if (a > d4) {
                        i2 = i4;
                    } else {
                        i2 = i5;
                        a = d4;
                    }
                    i4++;
                    i5 = i2;
                    d4 = a;
                }
                if (d4 > d && i5 >= 0 && i5 < arrayList.size()) {
                    i++;
                    arrayList.remove(i5);
                    i2 = 1;
                    i3 = i;
                    if (i2 == 1) {
                        return i3;
                    }
                    i = i3;
                }
            }
            i2 = 0;
            i3 = i;
            if (i2 == 1) {
                return i3;
            }
            i = i3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.baidu.location.BDLocation m14078a(java.lang.Long r20) {
        /*
        r19 = this;
        r2 = 0;
        r0 = r19;
        r0.f18103p = r2;
        r8 = 0;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r0 = r19;
        r2 = r0.f18092e;
        if (r2 == 0) goto L_0x0047;
    L_0x0011:
        r0 = r19;
        r2 = r0.f18092e;
        r0 = r20;
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0047;
    L_0x001d:
        r3 = 1;
        r0 = r19;
        r6 = r0.f18090c;
        r0 = r19;
        r4 = r0.f18091d;
        r0 = r19;
        r8 = r0.f18089b;
    L_0x002a:
        if (r3 == 0) goto L_0x0114;
    L_0x002c:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r8;
        r2.setRadius(r3);
        r2.setLatitude(r4);
        r2.setLongitude(r6);
        r3 = "cl";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x0046:
        return r2;
    L_0x0047:
        r2 = 0;
        r9 = java.util.Locale.US;
        r10 = "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;";
        r11 = 3;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r11[r12] = r20;
        r12 = 1;
        r13 = 15552000; // 0xed4e00 float:2.1792994E-38 double:7.683709E-317;
        r13 = java.lang.Integer.valueOf(r13);
        r11[r12] = r13;
        r12 = 2;
        r14 = java.lang.System.currentTimeMillis();
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r14 / r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r9 = java.lang.String.format(r9, r10, r11);
        r0 = r19;
        r10 = r0.f18095h;	 Catch:{ Exception -> 0x00fd, all -> 0x0108 }
        r11 = 0;
        r2 = r10.rawQuery(r9, r11);	 Catch:{ Exception -> 0x00fd, all -> 0x0108 }
        if (r2 == 0) goto L_0x00ec;
    L_0x007b:
        r9 = r2.moveToFirst();	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        if (r9 == 0) goto L_0x00ec;
    L_0x0081:
        r9 = "cl";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r10 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r12 = 0;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 <= 0) goto L_0x00ec;
    L_0x0092:
        r3 = 1;
        r9 = "x";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r6 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "y";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r4 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "r";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r8 = r2.getInt(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "timestamp";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = r2.getInt(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r10 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r9 = r9 + r10;
        r10 = (long) r9;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 >= 0) goto L_0x00d4;
    L_0x00cf:
        r9 = 1;
        r0 = r19;
        r0.f18103p = r9;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
    L_0x00d4:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r8 >= r9) goto L_0x00f6;
    L_0x00d8:
        r8 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
    L_0x00da:
        r0 = r19;
        r0.f18090c = r6;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r19;
        r0.f18091d = r4;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r19;
        r0.f18089b = r8;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r20;
        r1 = r19;
        r1.f18092e = r0;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
    L_0x00ec:
        if (r2 == 0) goto L_0x002a;
    L_0x00ee:
        r2.close();	 Catch:{ Exception -> 0x00f3 }
        goto L_0x002a;
    L_0x00f3:
        r2 = move-exception;
        goto L_0x002a;
    L_0x00f6:
        r9 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r9 >= r8) goto L_0x00da;
    L_0x00fa:
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        goto L_0x00da;
    L_0x00fd:
        r9 = move-exception;
        if (r2 == 0) goto L_0x002a;
    L_0x0100:
        r2.close();	 Catch:{ Exception -> 0x0105 }
        goto L_0x002a;
    L_0x0105:
        r2 = move-exception;
        goto L_0x002a;
    L_0x0108:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x010e:
        if (r3 == 0) goto L_0x0113;
    L_0x0110:
        r3.close();	 Catch:{ Exception -> 0x0117 }
    L_0x0113:
        throw r2;
    L_0x0114:
        r2 = 0;
        goto L_0x0046;
    L_0x0117:
        r3 = move-exception;
        goto L_0x0113;
    L_0x0119:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x010e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.baidu.location.BDLocation m14079a(java.util.LinkedHashMap<java.lang.String, java.lang.Integer> r34, com.baidu.location.BDLocation r35, int r36) {
        /*
        r33 = this;
        r0 = r33;
        r2 = r0.f18102o;
        r3 = 0;
        r2.setLength(r3);
        r6 = 0;
        r4 = 0;
        r2 = 0;
        if (r35 == 0) goto L_0x0386;
    L_0x000f:
        r2 = 1;
        r4 = r35.getLatitude();
        r6 = r35.getLongitude();
        r21 = r2;
    L_0x001a:
        r28 = 0;
        r26 = 0;
        r24 = 0;
        r23 = 0;
        r10 = new java.lang.StringBuffer;
        r10.<init>();
        r3 = 1;
        r2 = r34.entrySet();
        r11 = r2.iterator();
        r2 = 0;
        r8 = r2;
        r9 = r3;
    L_0x0033:
        r2 = r34.size();
        r3 = 30;
        r2 = java.lang.Math.min(r2, r3);
        if (r8 >= r2) goto L_0x0088;
    L_0x003f:
        r2 = r11.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r2 = r2.getValue();
        r2 = (java.lang.Integer) r2;
        r12 = r2.intValue();
        if (r12 >= 0) goto L_0x0060;
    L_0x0057:
        r2 = r2.intValue();
        r2 = -r2;
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0060:
        r12 = com.baidu.location.Jni.encode3(r3);
        if (r12 != 0) goto L_0x006c;
    L_0x0066:
        r3 = r9;
    L_0x0067:
        r2 = r8 + 1;
        r8 = r2;
        r9 = r3;
        goto L_0x0033;
    L_0x006c:
        r0 = r33;
        r13 = r0.f18101n;
        r13.put(r12, r3);
        if (r9 == 0) goto L_0x0082;
    L_0x0075:
        r9 = 0;
    L_0x0076:
        r0 = r33;
        r3 = r0.f18100m;
        r3.put(r12, r2);
        r10.append(r12);
        r3 = r9;
        goto L_0x0067;
    L_0x0082:
        r3 = 44;
        r10.append(r3);
        goto L_0x0076;
    L_0x0088:
        r2 = java.util.Locale.US;
        r3 = "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r10;
        r9 = 1;
        r10 = 7776000; // 0x76a700 float:1.0896497E-38 double:3.8418545E-317;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.System.currentTimeMillis();
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        r3 = java.lang.String.format(r2, r3, r8);
        r2 = 0;
        r0 = r33;
        r8 = r0.f18095h;	 Catch:{ Exception -> 0x034f, all -> 0x0349 }
        r9 = 0;
        r22 = r8.rawQuery(r3, r9);	 Catch:{ Exception -> 0x034f, all -> 0x0349 }
        if (r22 == 0) goto L_0x037d;
    L_0x00bb:
        r2 = r22.moveToFirst();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r2 == 0) goto L_0x037d;
    L_0x00c1:
        r29 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r29.<init>();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x00c6:
        r2 = r22.isAfterLast();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r2 != 0) goto L_0x0232;
    L_0x00cc:
        r2 = 0;
        r0 = r22;
        r2 = r0.getLong(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 1;
        r0 = r22;
        r10 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 2;
        r0 = r22;
        r8 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 3;
        r0 = r22;
        r12 = r0.getInt(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 4;
        r0 = r22;
        r14 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 5;
        r0 = r22;
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r33;
        r13 = r0.f18099l;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13.add(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r3 = r3 + r13;
        r0 = (long) r3;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = r0;
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r30 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r18 = r18 / r30;
        r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r3 >= 0) goto L_0x0163;
    L_0x0114:
        r0 = r33;
        r3 = r0.f18102o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = r3.length();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r3 <= 0) goto L_0x0128;
    L_0x011e:
        r0 = r33;
        r3 = r0.f18102o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = ",";
        r3.append(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x0128:
        r0 = r33;
        r3 = r0.f18102o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = java.util.Locale.US;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = "(%d,\"%s\",%d)";
        r17 = 3;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17 = r0;
        r18 = 0;
        r17[r18] = r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 1;
        r0 = r33;
        r0 = r0.f18101n;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r19 = r0;
        r0 = r19;
        r19 = r0.get(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 2;
        r19 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r19 = java.lang.Integer.valueOf(r19);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r16;
        r1 = r17;
        r13 = java.lang.String.format(r13, r0, r1);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3.append(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x0163:
        r16 = 0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 > 0) goto L_0x019b;
    L_0x0169:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x016e:
        r2 = move-exception;
        r2 = r22;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
    L_0x0179:
        if (r2 == 0) goto L_0x017e;
    L_0x017b:
        r2.close();	 Catch:{ Exception -> 0x0343 }
    L_0x017e:
        if (r3 == 0) goto L_0x0340;
    L_0x0180:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r4;
        r2.setRadius(r3);
        r2.setLatitude(r12);
        r2.setLongitude(r10);
        r3 = "wf";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x019a:
        return r2;
    L_0x019b:
        r14 = 0;
        r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01ad;
    L_0x01a1:
        r14 = 0;
        r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01ad;
    L_0x01a7:
        if (r12 <= 0) goto L_0x01ad;
    L_0x01a9:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r12 < r3) goto L_0x01b9;
    L_0x01ad:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x01b2:
        r2 = move-exception;
    L_0x01b3:
        if (r22 == 0) goto L_0x01b8;
    L_0x01b5:
        r22.close();	 Catch:{ Exception -> 0x0346 }
    L_0x01b8:
        throw r2;
    L_0x01b9:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x01d2;
    L_0x01be:
        r3 = r33;
        r14 = r3.m14076a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 <= 0) goto L_0x01d2;
    L_0x01cd:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x01d2:
        r0 = r33;
        r3 = r0.f18100m;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r3.get(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 30;
        r2 = java.lang.Math.max(r3, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 100;
        r2 = java.lang.Math.min(r3, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = 70;
        if (r2 <= r3) goto L_0x0229;
    L_0x01f2:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4629137466983448576; // 0x403e000000000000 float:0.0 double:30.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
    L_0x01fa:
        r14 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r12 = (double) r12;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r12 = java.lang.Math.max(r14, r12);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r12 = java.lang.Math.pow(r12, r14);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = -4634023872579145564; // 0xbfb0a3d70a3d70a4 float:9.121204E-33 double:-0.065;
        r12 = r12 * r14;
        r2 = r2 * r12;
        r18 = java.lang.Math.exp(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = new com.baidu.location.e.b$a;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r20 = 0;
        r14 = r10;
        r16 = r8;
        r13.<init>(r14, r16, r18);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r29;
        r0.add(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x0229:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
        goto L_0x01fa;
    L_0x0232:
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r33;
        r1 = r29;
        r0.m14077a(r1, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r10 = 0;
        r12 = 0;
        r8 = 0;
        r2 = 0;
        r16 = r2;
    L_0x0247:
        r2 = r29.size();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r16;
        if (r0 >= r2) goto L_0x0282;
    L_0x024f:
        r0 = r29;
        r1 = r16;
        r2 = r0.get(r1);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = (com.baidu.location.p193e.C3341b.C3338a) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = r2.f18075c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 0;
        r3 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1));
        if (r3 > 0) goto L_0x026a;
    L_0x0261:
        r2 = r8;
        r8 = r12;
    L_0x0263:
        r12 = r16 + 1;
        r16 = r12;
        r12 = r8;
        r8 = r2;
        goto L_0x0247;
    L_0x026a:
        r14 = r2.f18073a;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r2.f18075c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = r0;
        r14 = r14 * r18;
        r14 = r14 + r10;
        r10 = r2.f18074b;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r2.f18075c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = r0;
        r10 = r10 * r18;
        r10 = r10 + r12;
        r2 = r2.f18075c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r2 + r8;
        r8 = r10;
        r10 = r14;
        goto L_0x0263;
    L_0x0282:
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x0288:
        r2 = 0;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x028e:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x0294:
        r10 = r10 / r8;
        r12 = r12 / r8;
        r3 = 1;
        r8 = 0;
        r2 = 0;
        r32 = r2;
        r2 = r8;
        r8 = r32;
    L_0x029e:
        r9 = r29.size();	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        if (r8 >= r9) goto L_0x02cb;
    L_0x02a4:
        r0 = (double) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r18 = r0;
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = (com.baidu.location.p193e.C3341b.C3338a) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r14 = r2.f18073a;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = (com.baidu.location.p193e.C3341b.C3338a) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r0 = r2.f18074b;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r16 = r0;
        r9 = r33;
        r14 = r9.m14076a(r10, r12, r14, r16);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r14 = r14 + r18;
        r9 = (float) r14;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = r8 + 1;
        r8 = r2;
        r2 = r9;
        goto L_0x029e;
    L_0x02cb:
        r8 = r29.size();	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r8 = (float) r8;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = r2 / r8;
        r28 = java.lang.Math.round(r2);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = 30;
        r0 = r28;
        if (r0 >= r2) goto L_0x0333;
    L_0x02db:
        r28 = 30;
        r2 = r3;
        r8 = r12;
        r12 = r28;
    L_0x02e1:
        if (r21 != 0) goto L_0x02eb;
    L_0x02e3:
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r13 = 1;
        if (r3 > r13) goto L_0x02eb;
    L_0x02ea:
        r2 = 0;
    L_0x02eb:
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = r36;
        if (r3 >= r0) goto L_0x030e;
    L_0x02f3:
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = (double) r3;	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r16 = r0;
        r14 = r14 * r16;
        r3 = r34.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = (double) r3;	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r16 = r0;
        r14 = r14 / r16;
        r16 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x030e;
    L_0x030d:
        r2 = 0;
    L_0x030e:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x0369;
    L_0x0313:
        r3 = 1;
        if (r2 != r3) goto L_0x0369;
    L_0x0316:
        r3 = r33;
        r4 = r3.m14076a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r6 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0369;
    L_0x0325:
        r2 = 0;
        r3 = r2;
        r4 = r12;
        r12 = r8;
    L_0x0329:
        if (r22 == 0) goto L_0x017e;
    L_0x032b:
        r22.close();	 Catch:{ Exception -> 0x0330 }
        goto L_0x017e;
    L_0x0330:
        r2 = move-exception;
        goto L_0x017e;
    L_0x0333:
        r2 = 100;
        r0 = r28;
        if (r2 >= r0) goto L_0x036d;
    L_0x0339:
        r28 = 100;
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02e1;
    L_0x0340:
        r2 = 0;
        goto L_0x019a;
    L_0x0343:
        r2 = move-exception;
        goto L_0x017e;
    L_0x0346:
        r3 = move-exception;
        goto L_0x01b8;
    L_0x0349:
        r3 = move-exception;
        r22 = r2;
        r2 = r3;
        goto L_0x01b3;
    L_0x034f:
        r3 = move-exception;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0179;
    L_0x035a:
        r2 = move-exception;
        r2 = r22;
        r4 = r28;
        goto L_0x0179;
    L_0x0361:
        r3 = move-exception;
        r3 = r2;
        r4 = r12;
        r12 = r8;
        r2 = r22;
        goto L_0x0179;
    L_0x0369:
        r3 = r2;
        r4 = r12;
        r12 = r8;
        goto L_0x0329;
    L_0x036d:
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02e1;
    L_0x0373:
        r2 = r23;
        r8 = r24;
        r10 = r26;
        r12 = r28;
        goto L_0x02e1;
    L_0x037d:
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0329;
    L_0x0386:
        r21 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    /* renamed from: a */
    private void m14082a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            String format;
            String format2;
            if (bDLocation2 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && m14076a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
                format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", new Object[]{l});
                format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)});
                try {
                    this.f18095h.execSQL(format);
                    this.f18096i.execSQL(format2);
                } catch (Exception e) {
                }
            }
            if (bDLocation3 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("wf") && m14076a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 100.0d) {
                try {
                    format = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", new Object[]{this.f18097j.toString()});
                    format2 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", new Object[]{this.f18098k.toString()});
                    this.f18095h.execSQL(format);
                    this.f18096i.execSQL(format2);
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m14088a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.f18095h.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l}));
                } catch (Exception e) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", new Object[]{l, str});
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l});
                try {
                    this.f18096i.execSQL(format);
                    this.f18096i.execSQL(format2);
                } catch (Exception e2) {
                }
            }
            if (this.f18103p) {
                try {
                    this.f18096i.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)}));
                } catch (Exception e3) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m14089a(String str, String str2, String str3) {
        this.f18093f.m14062a(str, str2, str3);
    }

    /* renamed from: a */
    private void m14090a(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            String str;
            this.f18097j = new StringBuffer();
            this.f18098k = new StringBuffer();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            if (!(this.f18100m == null || this.f18100m.keySet() == null)) {
                int i = 1;
                int i2 = 1;
                for (Long l : this.f18100m.keySet()) {
                    try {
                        int i3;
                        int i4;
                        if (this.f18099l.contains(l)) {
                            if (i2 != 0) {
                                i2 = 0;
                            } else {
                                this.f18097j.append(',');
                                this.f18098k.append(',');
                            }
                            this.f18097j.append(l);
                            this.f18098k.append('(').append(l).append(',').append('\"').append((String) this.f18101n.get(l)).append('\"').append(',').append(100000).append(')');
                            i3 = i;
                            i4 = i2;
                        } else {
                            str = (String) this.f18101n.get(l);
                            if (i != 0) {
                                i = 0;
                            } else {
                                stringBuffer.append(',');
                                stringBuffer2.append(',');
                            }
                            stringBuffer.append(l);
                            stringBuffer2.append('(').append(l).append(',').append('\"').append(str).append('\"').append(",0)");
                            i3 = i;
                            i4 = i2;
                        }
                        i = i3;
                        i2 = i4;
                    } catch (Exception e) {
                        i = i;
                        i2 = i2;
                    }
                }
            }
            try {
                this.f18095h.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", new Object[]{this.f18097j.toString()}));
            } catch (Exception e2) {
            }
            if (this.f18102o != null && this.f18102o.length() > 0) {
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append(",");
                }
                stringBuffer2.append(this.f18102o);
            }
            try {
                String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", new Object[]{stringBuffer2.toString()});
                str = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", new Object[]{stringBuffer.toString()});
                if (stringBuffer2.length() > 0) {
                    this.f18096i.execSQL(format);
                }
                if (stringBuffer.length() > 0) {
                    this.f18096i.execSQL(str);
                }
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: a */
    private void m14091a(String[] strArr) {
        this.f18088a.m14195m().m14150a(strArr);
    }

    /* renamed from: a */
    Cursor m14096a(C3350a c3350a) {
        BDLocation bDLocation;
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setLocType(67);
        int i = 0;
        if (c3350a.f18162c) {
            double[] coorEncrypt;
            List list;
            String str = c3350a.f18161b;
            LinkedHashMap linkedHashMap = c3350a.f18168i;
            int i2 = c3350a.f18165f;
            BDLocation bDLocation3 = c3350a.f18166g;
            BDLocation bDLocation4 = null;
            Long valueOf = Long.valueOf(Long.MIN_VALUE);
            if (!(str == null || this.f18095h == null)) {
                valueOf = Jni.encode3(str);
                if (valueOf != null) {
                    bDLocation4 = m14078a(valueOf);
                }
            }
            BDLocation bDLocation5 = null;
            if (!(linkedHashMap == null || linkedHashMap.size() <= 0 || this.f18095h == null)) {
                this.f18100m.clear();
                this.f18099l.clear();
                this.f18101n.clear();
                bDLocation5 = m14079a(linkedHashMap, bDLocation4, i2);
            }
            Double d = null;
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            if (bDLocation4 != null) {
                d = Double.valueOf(bDLocation4.getLongitude());
                d2 = Double.valueOf(bDLocation4.getLatitude());
                coorEncrypt = Jni.coorEncrypt(bDLocation4.getLongitude(), bDLocation4.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation4.setCoorType("gcj");
                bDLocation4.setLatitude(coorEncrypt[1]);
                bDLocation4.setLongitude(coorEncrypt[0]);
                bDLocation4.setNetworkLocationType("cl");
            }
            if (bDLocation5 != null) {
                d3 = Double.valueOf(bDLocation5.getLongitude());
                d4 = Double.valueOf(bDLocation5.getLatitude());
                coorEncrypt = Jni.coorEncrypt(bDLocation5.getLongitude(), bDLocation5.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation5.setCoorType("gcj");
                bDLocation5.setLatitude(coorEncrypt[1]);
                bDLocation5.setLongitude(coorEncrypt[0]);
                bDLocation5.setNetworkLocationType("wf");
            }
            if (bDLocation4 != null && bDLocation5 == null) {
                i = 1;
            } else if (bDLocation4 == null && bDLocation5 != null) {
                i = 2;
            } else if (!(bDLocation4 == null || bDLocation5 == null)) {
                i = 4;
            }
            Object obj = c3350a.f18165f > 0 ? 1 : null;
            Object obj2 = (linkedHashMap == null || linkedHashMap.size() <= 0) ? 1 : null;
            if (obj != null) {
                if (bDLocation5 != null) {
                    d2 = d3;
                    bDLocation = bDLocation5;
                } else {
                    if (!(obj2 == null || bDLocation4 == null)) {
                        d4 = d2;
                        bDLocation = bDLocation4;
                        d2 = d;
                    }
                    d4 = null;
                    d2 = null;
                    bDLocation = bDLocation2;
                }
            } else if (bDLocation5 != null) {
                d2 = d3;
                bDLocation = bDLocation5;
            } else {
                if (bDLocation4 != null) {
                    d4 = d2;
                    bDLocation = bDLocation4;
                    d2 = d;
                }
                d4 = null;
                d2 = null;
                bDLocation = bDLocation2;
            }
            if (c3350a.f18164e && this.f18088a.m14195m().m14163m() && d4 != null && d2 != null) {
                bDLocation.setAddr(this.f18088a.m14194l().m14241a(d2.doubleValue(), d4.doubleValue()));
            }
            if (obj != null && c3350a.f18164e && bDLocation.getAddrStr() == null) {
                d4 = null;
                d2 = null;
                i = 0;
                bDLocation = bDLocation2;
            }
            if ((!c3350a.f18163d && !c3350a.f18167h) || d4 == null || d2 == null) {
                list = null;
            } else {
                List b = this.f18088a.m14194l().m14244b(d2.doubleValue(), d4.doubleValue());
                if (c3350a.f18163d) {
                    bDLocation.setPoiList(b);
                }
                list = b;
            }
            if (obj == null || !c3350a.f18163d || (list != null && list.size() > 0)) {
                i2 = i;
            } else {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            String str2 = null;
            if (c3350a.f18167h && list != null && list.size() > 0) {
                str2 = String.format(Locale.CHINA, "在%s附近", new Object[]{((Poi) list.get(0)).getName()});
                bDLocation.setLocationDescribe(str2);
            }
            if (obj != null && c3350a.f18167h && r4 == null) {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = null;
            if (c3350a.f18160a != null) {
                stringBuffer.append(c3350a.f18160a);
                stringBuffer.append(C3351e.m14202a(bDLocation5, bDLocation4, c3350a));
                stringBuffer.append(C3351e.m14201a(bDLocation, i2));
                str3 = stringBuffer.toString();
            }
            new C3336b(this, str, valueOf, bDLocation4, bDLocation5, bDLocation3, str3, linkedHashMap) {
                /* renamed from: a */
                final /* synthetic */ C3341b f18072a;
            }.start();
        } else {
            bDLocation = bDLocation2;
        }
        return C3351e.m14199a(bDLocation);
    }

    /* renamed from: a */
    SQLiteDatabase m14097a() {
        return this.f18096i;
    }

    /* renamed from: b */
    void m14098b() {
        this.f18094g.mo2500b();
    }
}
