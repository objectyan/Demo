package com.baidu.location.p193e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.e.f */
final class C3353f {
    /* renamed from: d */
    private static final String f18177d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", new Object[]{Integer.valueOf(3000)});
    /* renamed from: e */
    private static final String f18178e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", new Object[]{Integer.valueOf(3)});
    /* renamed from: a */
    private String f18179a = null;
    /* renamed from: b */
    private final SQLiteDatabase f18180b;
    /* renamed from: c */
    private final C3352a f18181c;

    /* renamed from: com.baidu.location.e.f$a */
    private class C3352a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3353f f18170a;
        /* renamed from: b */
        private int f18171b;
        /* renamed from: c */
        private long f18172c;
        /* renamed from: d */
        private String f18173d;
        /* renamed from: e */
        private boolean f18174e;
        /* renamed from: f */
        private boolean f18175f;
        /* renamed from: p */
        private C3353f f18176p;

        C3352a(C3353f c3353f, C3353f c3353f2) {
            this.f18170a = c3353f;
            this.f18176p = c3353f2;
            this.f18173d = null;
            this.f18174e = false;
            this.f18175f = false;
            this.k = new HashMap();
            this.f18171b = 0;
            this.f18172c = -1;
        }

        /* renamed from: b */
        private void m14205b() {
            if (!this.f18174e) {
                this.f18173d = this.f18176p.m14211b();
                if (this.f18172c != -1 && this.f18172c + 86400000 <= System.currentTimeMillis()) {
                    this.f18171b = 0;
                    this.f18172c = -1;
                }
                if (this.f18173d != null && this.f18171b < 2) {
                    this.f18174e = true;
                    m13299c("https://ofloc.map.baidu.com/offline_loc");
                }
            }
        }

        /* renamed from: a */
        public void mo2494a() {
            this.k.clear();
            this.k.put("qt", "ofbh");
            this.k.put("req", this.f18173d);
            this.h = C3349d.f18151b;
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            this.f18175f = false;
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject != null && jSONObject.has(ParamKey.KEY_MSG_ERRORS) && jSONObject.getInt(ParamKey.KEY_MSG_ERRORS) == 161) {
                        this.f18175f = true;
                    }
                } catch (Exception e) {
                }
            }
            if (!this.f18175f) {
                this.f18171b++;
                this.f18172c = System.currentTimeMillis();
            }
            this.f18176p.m14210a(this.f18175f);
            this.f18174e = false;
        }
    }

    C3353f(SQLiteDatabase sQLiteDatabase) {
        this.f18180b = sQLiteDatabase;
        this.f18181c = new C3352a(this, this);
        if (this.f18180b != null && this.f18180b.isOpen()) {
            try {
                this.f18180b.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private void m14210a(boolean z) {
        if (z && this.f18179a != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", new Object[]{this.f18179a});
            try {
                if (this.f18179a.length() > 0) {
                    this.f18180b.execSQL(format);
                }
            } catch (Exception e) {
            }
        }
        this.f18179a = null;
    }

    /* renamed from: b */
    private String m14211b() {
        Throwable th;
        String str = null;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        Cursor rawQuery;
        try {
            rawQuery = this.f18180b.rawQuery(f18178e, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        rawQuery.moveToFirst();
                        while (!rawQuery.isAfterLast()) {
                            jSONArray.put(rawQuery.getString(1));
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(rawQuery.getLong(0));
                            rawQuery.moveToNext();
                        }
                        try {
                            jSONObject.put("ofloc", jSONArray);
                            str = jSONObject.toString();
                        } catch (JSONException e) {
                        }
                        this.f18179a = stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e3) {
                        }
                    }
                    return str;
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
            if (rawQuery != null) {
                try {
                    rawQuery.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            Object obj = str;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = str;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    /* renamed from: a */
    void m14212a() {
        this.f18181c.m14205b();
    }

    /* renamed from: a */
    void m14213a(String str) {
        String encodeOfflineLocationUpdateRequest = Jni.encodeOfflineLocationUpdateRequest(str);
        try {
            this.f18180b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", new Object[]{Long.valueOf(System.currentTimeMillis()), encodeOfflineLocationUpdateRequest}));
            this.f18180b.execSQL(f18177d);
        } catch (Exception e) {
        }
    }
}
