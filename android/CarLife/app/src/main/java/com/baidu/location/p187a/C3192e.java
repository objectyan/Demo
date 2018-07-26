package com.baidu.location.p187a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.mobstat.Config;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.e */
public class C3192e {
    /* renamed from: c */
    private static Object f17348c = new Object();
    /* renamed from: d */
    private static C3192e f17349d = null;
    /* renamed from: e */
    private static final String f17350e = (C3391g.m14456l() + "/hst.db");
    /* renamed from: a */
    C3191a f17351a = null;
    /* renamed from: b */
    C3191a f17352b = null;
    /* renamed from: f */
    private SQLiteDatabase f17353f = null;
    /* renamed from: g */
    private boolean f17354g = false;

    /* renamed from: com.baidu.location.a.e$a */
    class C3191a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3192e f17343a;
        /* renamed from: b */
        private String f17344b;
        /* renamed from: c */
        private String f17345c;
        /* renamed from: d */
        private boolean f17346d;
        /* renamed from: e */
        private boolean f17347e;

        C3191a(C3192e c3192e) {
            this.f17343a = c3192e;
            this.f17344b = null;
            this.f17345c = null;
            this.f17346d = true;
            this.f17347e = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.i = 1;
            this.h = C3391g.m14448e();
            String encodeTp4 = Jni.encodeTp4(this.f17345c);
            this.f17345c = null;
            this.k.put("bloc", encodeTp4);
        }

        /* renamed from: a */
        public void m13325a(String str, String str2) {
            if (!this.f17343a.f17354g) {
                this.f17343a.f17354g = true;
                this.f17344b = str;
                this.f17345c = str2;
                m13299c(C3391g.f18379f);
            }
        }

        /* renamed from: a */
        public void m13326a(String str, String str2, boolean z) {
            if (!this.f17343a.f17354g) {
                this.f17343a.f17354g = true;
                this.f17344b = str;
                this.f17345c = str2;
                this.f17346d = false;
                this.f17347e = z;
                if (this.f17347e) {
                    this.f17345c += "&imou=1";
                } else {
                    this.f17345c += "&imou=0";
                }
                m13299c(C3391g.f18379f);
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            JSONObject jSONObject = null;
            if (z && this.j != null) {
                try {
                    String str = this.j;
                    if (this.f17346d) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.has("content")) {
                            jSONObject = jSONObject2.getJSONObject("content");
                        }
                        if (jSONObject != null && jSONObject.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject.getJSONObject("imo").getString("mac"));
                            int i = jSONObject.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.f17344b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    if (this.f17343a.f17353f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        this.f17343a.f17353f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception e) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.f17344b.getBytes());
                                bundle.putInt("hotspot", i);
                                this.f17343a.m13330a(bundle);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            } else if (this.f17346d) {
                this.f17343a.m13336f();
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f17343a.f17354g = false;
        }
    }

    /* renamed from: a */
    public static C3192e m13329a() {
        C3192e c3192e;
        synchronized (f17348c) {
            if (f17349d == null) {
                f17349d = new C3192e();
            }
            c3192e = f17349d;
        }
        return c3192e;
    }

    /* renamed from: a */
    private void m13330a(Bundle bundle) {
        C3181a.m13265a().m13270a(bundle, 406);
    }

    /* renamed from: b */
    private String m13333b(boolean z) {
        C3362a f = C3364b.m14262a().m14280f();
        C3372e q = C3376f.m14355a().m14381q();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (f != null && f.m14248b()) {
            stringBuffer.append(f.m14255i());
        }
        if (q != null && q.m14330a() > 1) {
            stringBuffer.append(q.m14331a(15));
        } else if (C3376f.m14355a().m14377m() != null) {
            stringBuffer.append(C3376f.m14355a().m14377m());
        }
        if (z) {
            stringBuffer.append("&imo=1");
        }
        stringBuffer.append(C3381b.m14398a().m14399a(false));
        stringBuffer.append(C3181a.m13265a().m13283f());
        return stringBuffer.toString();
    }

    /* renamed from: f */
    private void m13336f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        m13330a(bundle);
    }

    /* renamed from: a */
    public void m13337a(String str) {
        JSONObject jSONObject = null;
        if (!this.f17354g) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has("content")) {
                    jSONObject = jSONObject2.getJSONObject("content");
                }
                if (jSONObject != null && jSONObject.has("imo")) {
                    Long valueOf = Long.valueOf(jSONObject.getJSONObject("imo").getString("mac"));
                    int i = jSONObject.getJSONObject("imo").getInt("mv");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                    contentValues.put("hst", Integer.valueOf(i));
                    try {
                        if (this.f17353f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                            contentValues.put("id", valueOf);
                            this.f17353f.insert("hstdata", null, contentValues);
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public void m13338a(boolean z) {
        if (this.f17352b == null) {
            this.f17352b = new C3191a(this);
        }
        if (this.f17352b != null) {
            WifiInfo l = C3376f.m14355a().m14376l();
            if (l != null && l.getBSSID() != null) {
                this.f17352b.m13326a(l.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, ""), m13333b(false), z);
            }
        }
    }

    /* renamed from: b */
    public void m13339b() {
        try {
            File file = new File(f17350e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f17353f = SQLiteDatabase.openOrCreateDatabase(file, null);
                this.f17353f.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f17353f.setVersion(1);
            }
        } catch (Exception e) {
            this.f17353f = null;
        }
    }

    /* renamed from: c */
    public void m13340c() {
        if (this.f17353f != null) {
            try {
                this.f17353f.close();
            } catch (Exception e) {
            } finally {
                this.f17353f = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public int m13341d() {
        /*
        r7 = this;
        r1 = 0;
        r0 = -3;
        r2 = r7.f17354g;
        if (r2 == 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r2 = com.baidu.location.p194f.C3376f.m14363j();	 Catch:{ Exception -> 0x007f }
        if (r2 == 0) goto L_0x0006;
    L_0x000d:
        r2 = r7.f17353f;	 Catch:{ Exception -> 0x007f }
        if (r2 == 0) goto L_0x0006;
    L_0x0011:
        r2 = com.baidu.location.p194f.C3376f.m14355a();	 Catch:{ Exception -> 0x007f }
        r2 = r2.m14376l();	 Catch:{ Exception -> 0x007f }
        if (r2 == 0) goto L_0x0006;
    L_0x001b:
        r3 = r2.getBSSID();	 Catch:{ Exception -> 0x007f }
        if (r3 == 0) goto L_0x0006;
    L_0x0021:
        r2 = r2.getBSSID();	 Catch:{ Exception -> 0x007f }
        r3 = ":";
        r4 = "";
        r2 = r2.replace(r3, r4);	 Catch:{ Exception -> 0x007f }
        r2 = com.baidu.location.Jni.encode3(r2);	 Catch:{ Exception -> 0x007f }
        r3 = r7.f17353f;	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r4.<init>();	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r5 = "select * from hstdata where id = \"";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r4 = "\";";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        r4 = 0;
        r1 = r3.rawQuery(r2, r4);	 Catch:{ Exception -> 0x006c, all -> 0x0075 }
        if (r1 == 0) goto L_0x006a;
    L_0x0057:
        r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x006c, all -> 0x0083 }
        if (r2 == 0) goto L_0x006a;
    L_0x005d:
        r2 = 1;
        r0 = r1.getInt(r2);	 Catch:{ Exception -> 0x006c, all -> 0x0083 }
    L_0x0062:
        if (r1 == 0) goto L_0x0006;
    L_0x0064:
        r1.close();	 Catch:{ Exception -> 0x0068 }
        goto L_0x0006;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0006;
    L_0x006a:
        r0 = -2;
        goto L_0x0062;
    L_0x006c:
        r2 = move-exception;
        if (r1 == 0) goto L_0x0006;
    L_0x006f:
        r1.close();	 Catch:{ Exception -> 0x0073 }
        goto L_0x0006;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0006;
    L_0x0075:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0079:
        if (r2 == 0) goto L_0x007e;
    L_0x007b:
        r2.close();	 Catch:{ Exception -> 0x0081 }
    L_0x007e:
        throw r1;	 Catch:{ Exception -> 0x007f }
    L_0x007f:
        r1 = move-exception;
        goto L_0x0006;
    L_0x0081:
        r2 = move-exception;
        goto L_0x007e;
    L_0x0083:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.e.d():int");
    }

    /* renamed from: e */
    public void m13342e() {
        Object obj;
        Cursor cursor;
        Cursor cursor2 = null;
        Object obj2 = 1;
        if (!this.f17354g) {
            String replace;
            try {
                if (!C3376f.m14363j() || this.f17353f == null) {
                    m13336f();
                    return;
                }
                WifiInfo l = C3376f.m14355a().m14376l();
                if (l == null || l.getBSSID() == null) {
                    m13336f();
                    return;
                }
                replace = l.getBSSID().replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                obj = null;
                try {
                    cursor2 = this.f17353f.rawQuery("select * from hstdata where id = \"" + Jni.encode3(replace) + "\";", null);
                    if (cursor2 != null) {
                        if (cursor2.moveToFirst()) {
                            int i = cursor2.getInt(1);
                            if ((System.currentTimeMillis() / 1000) - ((long) cursor2.getInt(2)) <= 259200) {
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", replace.getBytes());
                                bundle.putInt("hotspot", i);
                                m13330a(bundle);
                                obj2 = null;
                            }
                            obj = obj2;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e) {
                                }
                            }
                            if (obj == null) {
                                if (this.f17351a == null) {
                                    this.f17351a = new C3191a(this);
                                }
                                if (this.f17351a == null) {
                                    this.f17351a.m13325a(replace, m13333b(true));
                                }
                            }
                        }
                    }
                    int i2 = 1;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Exception e2) {
                    cursor = cursor2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (obj == null) {
                        if (this.f17351a == null) {
                            this.f17351a = new C3191a(this);
                        }
                        if (this.f17351a == null) {
                            this.f17351a.m13325a(replace, m13333b(true));
                        }
                    }
                } catch (Throwable th) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                }
                if (obj == null) {
                    if (this.f17351a == null) {
                        this.f17351a = new C3191a(this);
                    }
                    if (this.f17351a == null) {
                        this.f17351a.m13325a(replace, m13333b(true));
                    }
                }
            } catch (Exception e5) {
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                if (obj == null) {
                    if (this.f17351a == null) {
                        this.f17351a = new C3191a(this);
                    }
                    if (this.f17351a == null) {
                        this.f17351a.m13325a(replace, m13333b(true));
                    }
                }
            } catch (Exception e6) {
            } catch (Throwable th2) {
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e42) {
                    }
                }
            }
        }
    }
}
