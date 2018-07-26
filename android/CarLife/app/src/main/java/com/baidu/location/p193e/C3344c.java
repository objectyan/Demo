package com.baidu.location.p193e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.c */
final class C3344c {
    /* renamed from: a */
    private final C3349d f18110a;
    /* renamed from: b */
    private final SQLiteDatabase f18111b;
    /* renamed from: c */
    private final C3343a f18112c;
    /* renamed from: d */
    private boolean f18113d;
    /* renamed from: e */
    private boolean f18114e;
    /* renamed from: f */
    private boolean f18115f;
    /* renamed from: g */
    private boolean f18116g;
    /* renamed from: h */
    private boolean f18117h;
    /* renamed from: i */
    private String[] f18118i;
    /* renamed from: j */
    private boolean f18119j;
    /* renamed from: k */
    private boolean f18120k;
    /* renamed from: l */
    private int f18121l;
    /* renamed from: m */
    private int f18122m;
    /* renamed from: n */
    private int f18123n;
    /* renamed from: o */
    private double f18124o;
    /* renamed from: p */
    private double f18125p;
    /* renamed from: q */
    private double f18126q;
    /* renamed from: r */
    private double f18127r;
    /* renamed from: s */
    private double f18128s;
    /* renamed from: t */
    private int f18129t;
    /* renamed from: u */
    private boolean f18130u = true;
    /* renamed from: v */
    private long f18131v = 8000;
    /* renamed from: w */
    private long f18132w = Config.BPLUS_DELAY_TIME;
    /* renamed from: x */
    private long f18133x = Config.BPLUS_DELAY_TIME;
    /* renamed from: y */
    private long f18134y = Config.BPLUS_DELAY_TIME;
    /* renamed from: z */
    private long f18135z = Config.BPLUS_DELAY_TIME;

    /* renamed from: com.baidu.location.e.c$a */
    private final class C3343a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3344c f18104a;
        /* renamed from: b */
        private int f18105b;
        /* renamed from: c */
        private long f18106c;
        /* renamed from: d */
        private long f18107d;
        /* renamed from: e */
        private boolean f18108e;
        /* renamed from: f */
        private final String f18109f;

        private C3343a(C3344c c3344c) {
            this.f18104a = c3344c;
            this.f18105b = 0;
            this.f18108e = false;
            this.f18106c = -1;
            this.f18107d = -1;
            this.k = new HashMap();
            this.f18109f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f", new Object[]{"1", C3381b.m14398a().f18317b, C3381b.f18312e, C3381b.f18311d, Float.valueOf(7.32f)}));
        }

        /* renamed from: b */
        private void m14100b() {
            if (!this.f18108e) {
                boolean z = false;
                try {
                    File file = new File(this.f18104a.f18110a.m14185c(), "ofl.config");
                    if (this.f18107d == -1 && file.exists()) {
                        JSONObject jSONObject;
                        Scanner scanner = new Scanner(file);
                        String next = scanner.next();
                        scanner.close();
                        JSONObject jSONObject2 = new JSONObject(next);
                        this.f18104a.f18113d = jSONObject2.getBoolean(NaviStatConstants.K_NSC_KEY_SETTING_ONLINE_ROUTE_FIRST);
                        this.f18104a.f18114e = jSONObject2.getBoolean("fl");
                        this.f18104a.f18115f = jSONObject2.getBoolean("on");
                        this.f18104a.f18116g = jSONObject2.getBoolean("wn");
                        this.f18104a.f18117h = jSONObject2.getBoolean("oc");
                        this.f18107d = jSONObject2.getLong("t");
                        if (jSONObject2.has(NaviStatConstants.K_NSC_KEY_SETTING_ONLINE_ROUTE_FIRST)) {
                            this.f18104a.f18120k = jSONObject2.getBoolean("olv2");
                        }
                        if (jSONObject2.has("cplist")) {
                            this.f18104a.f18118i = jSONObject2.getString("cplist").split(";");
                        }
                        if (jSONObject2.has("rgcgp")) {
                            this.f18104a.f18121l = jSONObject2.getInt("rgcgp");
                        }
                        if (jSONObject2.has("rgcon")) {
                            this.f18104a.f18119j = jSONObject2.getBoolean("rgcon");
                        }
                        if (jSONObject2.has("addrup")) {
                            this.f18104a.f18123n = jSONObject2.getInt("addrup");
                        }
                        if (jSONObject2.has("poiup")) {
                            this.f18104a.f18122m = jSONObject2.getInt("poiup");
                        }
                        if (jSONObject2.has("oflp")) {
                            jSONObject = jSONObject2.getJSONObject("oflp");
                            if (jSONObject.has("0")) {
                                this.f18104a.f18124o = jSONObject.getDouble("0");
                            }
                            if (jSONObject.has("1")) {
                                this.f18104a.f18125p = jSONObject.getDouble("1");
                            }
                            if (jSONObject.has("2")) {
                                this.f18104a.f18126q = jSONObject.getDouble("2");
                            }
                            if (jSONObject.has("3")) {
                                this.f18104a.f18127r = jSONObject.getDouble("3");
                            }
                            if (jSONObject.has("4")) {
                                this.f18104a.f18128s = jSONObject.getDouble("4");
                            }
                        }
                        if (jSONObject2.has("onlt")) {
                            jSONObject = jSONObject2.getJSONObject("onlt");
                            if (jSONObject.has("0")) {
                                this.f18104a.f18135z = jSONObject.getLong("0");
                            }
                            if (jSONObject.has("1")) {
                                this.f18104a.f18134y = jSONObject.getLong("1");
                            }
                            if (jSONObject.has("2")) {
                                this.f18104a.f18131v = jSONObject.getLong("2");
                            }
                            if (jSONObject.has("3")) {
                                this.f18104a.f18132w = jSONObject.getLong("3");
                            }
                            if (jSONObject.has("4")) {
                                this.f18104a.f18133x = jSONObject.getLong("4");
                            }
                        }
                        if (jSONObject2.has("minapn")) {
                            this.f18104a.f18129t = jSONObject2.getInt("minapn");
                        }
                    }
                    if (this.f18107d == -1 && file.exists()) {
                    }
                    if (this.f18107d != -1 && this.f18107d + 86400000 <= System.currentTimeMillis()) {
                        z = true;
                    }
                } catch (Exception e) {
                }
                if ((this.f18107d == -1 || r0) && m14101c() && C3391g.m14437a(this.f18104a.f18110a.m14183b())) {
                    this.f18108e = true;
                    m13299c("https://ofloc.map.baidu.com/offline_loc");
                }
            }
        }

        /* renamed from: c */
        private boolean m14101c() {
            boolean z = true;
            if (this.f18105b >= 2) {
                if (this.f18106c + 86400000 < System.currentTimeMillis()) {
                    this.f18105b = 0;
                    this.f18106c = -1;
                } else {
                    z = false;
                }
            }
            return !z ? z : z;
        }

        /* renamed from: a */
        public void mo2494a() {
            this.k.clear();
            this.k.put("qt", "conf");
            this.k.put("req", this.f18109f);
            this.h = C3349d.f18151b;
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                this.f18105b++;
                this.f18106c = System.currentTimeMillis();
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    Object obj = "1";
                    long j = 0;
                    if (jSONObject.has("ofl")) {
                        j = jSONObject.getLong("ofl");
                    }
                    if (jSONObject.has("ver")) {
                        obj = jSONObject.getString("ver");
                    }
                    if ((j & 1) == 1) {
                        this.f18104a.f18113d = true;
                    }
                    if ((j & 2) == 2) {
                        this.f18104a.f18114e = true;
                    }
                    if ((j & 4) == 4) {
                        this.f18104a.f18115f = true;
                    }
                    if ((j & 8) == 8) {
                        this.f18104a.f18116g = true;
                    }
                    if ((16 & j) == 16) {
                        this.f18104a.f18117h = true;
                    }
                    if ((32 & j) == 32) {
                        this.f18104a.f18119j = true;
                    }
                    if ((j & 64) == 64) {
                        this.f18104a.f18120k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        this.f18104a.f18118i = jSONObject.getString("cplist").split(";");
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        this.f18104a.m14150a(jSONObject.getString("bklist").split(";"));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3;
                        jSONObject = jSONObject.getJSONObject("para");
                        if (jSONObject.has("rgcgp")) {
                            this.f18104a.f18121l = jSONObject.getInt("rgcgp");
                        }
                        if (jSONObject.has("addrup")) {
                            this.f18104a.f18123n = jSONObject.getInt("addrup");
                        }
                        if (jSONObject.has("poiup")) {
                            this.f18104a.f18122m = jSONObject.getInt("poiup");
                        }
                        if (jSONObject.has("oflp")) {
                            jSONObject3 = jSONObject.getJSONObject("oflp");
                            if (jSONObject3.has("0")) {
                                this.f18104a.f18124o = jSONObject3.getDouble("0");
                            }
                            if (jSONObject3.has("1")) {
                                this.f18104a.f18125p = jSONObject3.getDouble("1");
                            }
                            if (jSONObject3.has("2")) {
                                this.f18104a.f18126q = jSONObject3.getDouble("2");
                            }
                            if (jSONObject3.has("3")) {
                                this.f18104a.f18127r = jSONObject3.getDouble("3");
                            }
                            if (jSONObject3.has("4")) {
                                this.f18104a.f18128s = jSONObject3.getDouble("4");
                            }
                        }
                        if (jSONObject.has("onlt")) {
                            jSONObject3 = jSONObject.getJSONObject("onlt");
                            if (jSONObject3.has("0")) {
                                this.f18104a.f18135z = jSONObject3.getLong("0");
                            }
                            if (jSONObject3.has("1")) {
                                this.f18104a.f18134y = jSONObject3.getLong("1");
                            }
                            if (jSONObject3.has("2")) {
                                this.f18104a.f18131v = jSONObject3.getLong("2");
                            }
                            if (jSONObject3.has("3")) {
                                this.f18104a.f18132w = jSONObject3.getLong("3");
                            }
                            if (jSONObject3.has("4")) {
                                this.f18104a.f18133x = jSONObject3.getLong("4");
                            }
                        }
                        if (jSONObject.has("minapn")) {
                            this.f18104a.f18129t = jSONObject.getInt("minapn");
                        }
                    }
                    jSONObject2.put(NaviStatConstants.K_NSC_KEY_SETTING_ONLINE_ROUTE_FIRST, this.f18104a.f18113d);
                    jSONObject2.put("olv2", this.f18104a.f18120k);
                    jSONObject2.put("fl", this.f18104a.f18114e);
                    jSONObject2.put("on", this.f18104a.f18115f);
                    jSONObject2.put("wn", this.f18104a.f18116g);
                    jSONObject2.put("oc", this.f18104a.f18117h);
                    this.f18107d = System.currentTimeMillis();
                    jSONObject2.put("t", this.f18107d);
                    jSONObject2.put("ver", obj);
                    jSONObject2.put("rgcon", this.f18104a.f18119j);
                    jSONObject2.put("rgcgp", this.f18104a.f18121l);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("0", this.f18104a.f18124o);
                    jSONObject4.put("1", this.f18104a.f18125p);
                    jSONObject4.put("2", this.f18104a.f18126q);
                    jSONObject4.put("3", this.f18104a.f18127r);
                    jSONObject4.put("4", this.f18104a.f18128s);
                    jSONObject2.put("oflp", jSONObject4);
                    jSONObject4 = new JSONObject();
                    jSONObject4.put("0", this.f18104a.f18135z);
                    jSONObject4.put("1", this.f18104a.f18134y);
                    jSONObject4.put("2", this.f18104a.f18131v);
                    jSONObject4.put("3", this.f18104a.f18132w);
                    jSONObject4.put("4", this.f18104a.f18133x);
                    jSONObject2.put("onlt", jSONObject4);
                    jSONObject2.put("addrup", this.f18104a.f18123n);
                    jSONObject2.put("poiup", this.f18104a.f18122m);
                    jSONObject2.put("minapn", this.f18104a.f18129t);
                    File file = new File(this.f18104a.f18110a.m14185c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception e) {
                    this.f18105b++;
                    this.f18106c = System.currentTimeMillis();
                }
            }
            this.f18108e = false;
        }
    }

    C3344c(C3349d c3349d, SQLiteDatabase sQLiteDatabase) {
        this.f18110a = c3349d;
        this.f18113d = false;
        this.f18114e = false;
        this.f18115f = false;
        this.f18116g = false;
        this.f18117h = false;
        this.f18119j = false;
        this.f18120k = false;
        this.f18121l = 6;
        this.f18122m = 30;
        this.f18123n = 30;
        this.f18124o = 0.0d;
        this.f18125p = 0.0d;
        this.f18126q = 0.0d;
        this.f18127r = 0.0d;
        this.f18128s = 0.0d;
        this.f18129t = 8;
        this.f18118i = new String[0];
        this.f18111b = sQLiteDatabase;
        this.f18112c = new C3343a();
        if (this.f18111b != null && this.f18111b.isOpen()) {
            try {
                this.f18111b.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception e) {
            }
        }
        m14157g();
    }

    /* renamed from: a */
    int m14148a() {
        return this.f18129t;
    }

    /* renamed from: a */
    long m14149a(String str) {
        return str.equals("2G") ? this.f18131v : str.equals("3G") ? this.f18132w : str.equals("4G") ? this.f18133x : str.equals("WIFI") ? this.f18134y : str.equals("unknown") ? this.f18135z : Config.BPLUS_DELAY_TIME;
    }

    /* renamed from: a */
    void m14150a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        if (this.f18111b != null && this.f18111b.isOpen() && stringBuffer.length() > 0) {
            try {
                this.f18111b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", new Object[]{stringBuffer.toString()}));
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    double m14151b() {
        return this.f18124o;
    }

    /* renamed from: b */
    boolean m14152b(String str) {
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = this.f18111b.rawQuery(String.format(Locale.US, "SELECT * FROM BLACK WHERE NAME IN (\"%s\");", new Object[]{str}), null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
        }
        return z ? z : z;
    }

    /* renamed from: c */
    double m14153c() {
        return this.f18125p;
    }

    /* renamed from: d */
    double m14154d() {
        return this.f18126q;
    }

    /* renamed from: e */
    double m14155e() {
        return this.f18127r;
    }

    /* renamed from: f */
    double m14156f() {
        return this.f18128s;
    }

    /* renamed from: g */
    void m14157g() {
        this.f18112c.m14100b();
    }

    /* renamed from: h */
    boolean m14158h() {
        return this.f18113d;
    }

    /* renamed from: i */
    boolean m14159i() {
        return this.f18120k;
    }

    /* renamed from: j */
    boolean m14160j() {
        return this.f18115f;
    }

    /* renamed from: k */
    boolean m14161k() {
        return this.f18116g;
    }

    /* renamed from: l */
    boolean m14162l() {
        return this.f18114e;
    }

    /* renamed from: m */
    boolean m14163m() {
        return this.f18119j;
    }

    /* renamed from: n */
    boolean m14164n() {
        return this.f18130u;
    }

    /* renamed from: o */
    int m14165o() {
        return this.f18121l;
    }

    /* renamed from: p */
    String[] m14166p() {
        return this.f18118i;
    }

    /* renamed from: q */
    int m14167q() {
        return this.f18123n;
    }

    /* renamed from: r */
    int m14168r() {
        return this.f18122m;
    }
}
