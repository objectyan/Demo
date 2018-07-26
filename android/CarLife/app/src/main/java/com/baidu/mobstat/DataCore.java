package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataCore {
    /* renamed from: a */
    private static JSONObject f19353a = new JSONObject();
    /* renamed from: b */
    private static DataCore f19354b = new DataCore();
    /* renamed from: c */
    private JSONArray f19355c = new JSONArray();
    /* renamed from: d */
    private JSONArray f19356d = new JSONArray();
    /* renamed from: e */
    private JSONArray f19357e = new JSONArray();
    /* renamed from: f */
    private boolean f19358f = false;
    /* renamed from: g */
    private volatile int f19359g = 0;
    /* renamed from: h */
    private StatService$WearListener f19360h;

    public static DataCore instance() {
        return f19354b;
    }

    private DataCore() {
    }

    public int getCacheFileSzie() {
        return this.f19359g;
    }

    public void putSession(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (m15281a(jSONObject.toString())) {
                db.m15661b("data to put exceed limit, will not put");
                return;
            }
            synchronized (this.f19355c) {
                try {
                    this.f19355c.put(this.f19355c.length(), jSONObject);
                } catch (Throwable e) {
                    db.m15659a(e);
                }
            }
        }
    }

    public void putSession(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                putSession(jSONObject);
                db.m15657a("Load last session:" + jSONObject);
            } catch (Throwable e) {
                db.m15659a(e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m15278a(org.json.JSONObject r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, long r22, java.lang.String r24, java.lang.String r25, int r26, boolean r27) {
        /*
        r17 = this;
        r0 = r17;
        r6 = r0.f19356d;
        monitor-enter(r6);
        r0 = r17;
        r2 = r0.f19356d;	 Catch:{ all -> 0x007f }
        r5 = r2.length();	 Catch:{ all -> 0x007f }
        if (r21 == 0) goto L_0x001a;
    L_0x000f:
        r2 = "";
        r0 = r21;
        r2 = r0.equals(r2);	 Catch:{ JSONException -> 0x0077 }
        if (r2 == 0) goto L_0x0025;
    L_0x001a:
        r2 = "s";
        r3 = "0|";
        r0 = r18;
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0077 }
    L_0x0025:
        r4 = 0;
        r2 = r5;
    L_0x0027:
        if (r4 >= r5) goto L_0x0131;
    L_0x0029:
        r0 = r17;
        r3 = r0.f19356d;	 Catch:{ JSONException -> 0x008a }
        r7 = r3.getJSONObject(r4);	 Catch:{ JSONException -> 0x008a }
        r3 = "i";
        r8 = r7.getString(r3);	 Catch:{ JSONException -> 0x008a }
        r3 = "l";
        r9 = r7.getString(r3);	 Catch:{ JSONException -> 0x008a }
        r3 = "t";
        r10 = r7.getLong(r3);	 Catch:{ JSONException -> 0x008a }
        r12 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r10 = r10 / r12;
        r3 = 0;
        r12 = "d";
        r3 = r7.getInt(r12);	 Catch:{ JSONException -> 0x0082 }
    L_0x0052:
        r12 = "h";
        r12 = r7.optString(r12);	 Catch:{ JSONException -> 0x008a }
        r13 = "p";
        r13 = r7.optString(r13);	 Catch:{ JSONException -> 0x008a }
        r14 = "v";
        r14 = r7.optInt(r14);	 Catch:{ JSONException -> 0x008a }
        r15 = "at";
        r15 = r7.optBoolean(r15);	 Catch:{ JSONException -> 0x008a }
        r10 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1));
        if (r10 != 0) goto L_0x0074;
    L_0x0072:
        if (r3 == 0) goto L_0x008f;
    L_0x0074:
        r4 = r4 + 1;
        goto L_0x0027;
    L_0x0077:
        r2 = move-exception;
        r2 = "event put s fail";
        com.baidu.mobstat.db.m15657a(r2);	 Catch:{ all -> 0x007f }
        goto L_0x0025;
    L_0x007f:
        r2 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x007f }
        throw r2;
    L_0x0082:
        r12 = move-exception;
        r12 = "old version data, No duration Tag";
        com.baidu.mobstat.db.m15657a(r12);	 Catch:{ JSONException -> 0x008a }
        goto L_0x0052;
    L_0x008a:
        r3 = move-exception;
    L_0x008b:
        com.baidu.mobstat.db.m15659a(r3);	 Catch:{ all -> 0x007f }
        goto L_0x0074;
    L_0x008f:
        r0 = r19;
        r3 = r8.equals(r0);	 Catch:{ JSONException -> 0x008a }
        if (r3 == 0) goto L_0x0074;
    L_0x0097:
        r0 = r20;
        r3 = r9.equals(r0);	 Catch:{ JSONException -> 0x008a }
        if (r3 == 0) goto L_0x0074;
    L_0x009f:
        r0 = r24;
        r3 = r12.equals(r0);	 Catch:{ JSONException -> 0x008a }
        if (r3 == 0) goto L_0x0074;
    L_0x00a7:
        r0 = r25;
        r3 = r13.equals(r0);	 Catch:{ JSONException -> 0x008a }
        if (r3 == 0) goto L_0x0074;
    L_0x00af:
        r0 = r26;
        if (r14 != r0) goto L_0x0074;
    L_0x00b3:
        r0 = r27;
        if (r15 != r0) goto L_0x0074;
    L_0x00b7:
        r3 = "c";
        r0 = r18;
        r3 = r0.getInt(r3);	 Catch:{ JSONException -> 0x008a }
        r8 = "c";
        r8 = r7.getInt(r8);	 Catch:{ JSONException -> 0x008a }
        r8 = r8 + r3;
        r3 = "s";
        r3 = r7.optString(r3);	 Catch:{ JSONException -> 0x008a }
        if (r3 == 0) goto L_0x00da;
    L_0x00d1:
        r9 = "";
        r9 = r3.equalsIgnoreCase(r9);	 Catch:{ JSONException -> 0x008a }
        if (r9 == 0) goto L_0x00dd;
    L_0x00da:
        r3 = "0|";
    L_0x00dd:
        r9 = "t";
        r0 = r18;
        r10 = r0.getLong(r9);	 Catch:{ JSONException -> 0x008a }
        r9 = "t";
        r12 = r7.getLong(r9);	 Catch:{ JSONException -> 0x008a }
        r10 = r10 - r12;
        r9 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x008a }
        r9.<init>();	 Catch:{ JSONException -> 0x008a }
        r3 = r9.append(r3);	 Catch:{ JSONException -> 0x008a }
        r3 = r3.append(r10);	 Catch:{ JSONException -> 0x008a }
        r9 = "|";
        r3 = r3.append(r9);	 Catch:{ JSONException -> 0x008a }
        r2 = r3.toString();	 Catch:{ JSONException -> 0x008a }
        r3 = "c";
        r7.remove(r3);	 Catch:{ JSONException -> 0x012c }
        r3 = "c";
        r7.put(r3, r8);	 Catch:{ JSONException -> 0x012c }
        r3 = "s";
        r7.put(r3, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x0118:
        if (r4 >= r5) goto L_0x011c;
    L_0x011a:
        monitor-exit(r6);	 Catch:{ all -> 0x007f }
    L_0x011b:
        return;
    L_0x011c:
        r0 = r17;
        r2 = r0.f19356d;	 Catch:{ JSONException -> 0x0127 }
        r0 = r18;
        r2.put(r5, r0);	 Catch:{ JSONException -> 0x0127 }
    L_0x0125:
        monitor-exit(r6);	 Catch:{ all -> 0x007f }
        goto L_0x011b;
    L_0x0127:
        r2 = move-exception;
        com.baidu.mobstat.db.m15659a(r2);	 Catch:{ all -> 0x007f }
        goto L_0x0125;
    L_0x012c:
        r2 = move-exception;
        r3 = r2;
        r2 = r4;
        goto L_0x008b;
    L_0x0131:
        r4 = r2;
        goto L_0x0118;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, boolean):void");
    }

    /* renamed from: a */
    private boolean m15281a(String str) {
        return (str.getBytes().length + ch.m15571a().m15594b()) + this.f19359g > Config.MAX_CACHE_JSON_CAPACITY;
    }

    public void putEvent(Context context, JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (m15281a(jSONObject.toString())) {
                db.m15661b("data to put exceed limit, will not put");
                return;
            }
            int i = 0;
            String str = "";
            str = "";
            str = "";
            str = "";
            try {
                String string = jSONObject.getString("i");
                String string2 = jSONObject.getString("l");
                long j = jSONObject.getLong("t") / 3600000;
                String optString = jSONObject.optString("s");
                String optString2 = jSONObject.optString("h");
                String optString3 = jSONObject.optString("p");
                int optInt = jSONObject.optInt("v");
                boolean optBoolean = jSONObject.optBoolean("at");
                CharSequence optString4 = jSONObject.optString("ext");
                CharSequence optString5 = jSONObject.optString(Config.EVENT_ATTR);
                try {
                    i = jSONObject.getInt("d");
                } catch (JSONException e) {
                    db.m15657a("old version data, No duration Tag");
                }
                Object obj = null;
                if (!(TextUtils.isEmpty(optString4) || new JSONObject().toString().equals(optString4))) {
                    obj = 1;
                }
                Object obj2 = null;
                if (!TextUtils.isEmpty(optString5)) {
                    obj2 = 1;
                }
                if (i == 0 && r3 == null && r4 == null) {
                    m15278a(jSONObject, string, string2, optString, j, optString2, optString3, optInt, optBoolean);
                    return;
                }
                synchronized (this.f19356d) {
                    i = this.f19356d.length();
                    try {
                        jSONObject.put("s", "0");
                        this.f19356d.put(i, jSONObject);
                    } catch (Throwable e2) {
                        db.m15659a(e2);
                    }
                }
            } catch (Throwable e22) {
                db.m15659a(e22);
            }
        }
    }

    public void putEvent(Context context, String str, String str2, int i, long j, long j2, String str3, String str4, int i2, boolean z, ExtraInfo extraInfo, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("i", str);
            jSONObject.put("l", str2);
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", j2);
            jSONObject.put("h", str3);
            jSONObject.put("p", str4);
            jSONObject.put("v", i2);
            jSONObject.put("at", z ? 1 : 0);
            if (!(extraInfo == null || extraInfo.dumpToJson().length() == 0)) {
                jSONObject.put("ext", extraInfo.dumpToJson());
            }
            if (map != null) {
                JSONArray jSONArray = new JSONArray();
                for (Entry entry : map.entrySet()) {
                    String str5 = (String) entry.getKey();
                    String str6 = (String) entry.getValue();
                    if (!(TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6) || m15282a(str6, 1024))) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(Config.APP_KEY, str5);
                        jSONObject2.put("v", str6);
                        jSONArray.put(jSONObject2);
                    }
                }
                if (jSONArray.length() != 0) {
                    jSONObject.put(Config.EVENT_ATTR, jSONArray);
                }
            }
            putEvent(context, jSONObject, false);
            db.m15657a("put event:" + jSONObject.toString());
        } catch (Throwable e) {
            db.m15659a(e);
        }
    }

    /* renamed from: a */
    private static boolean m15282a(String str, int i) {
        if (str == null) {
            return false;
        }
        int length;
        try {
            length = str.getBytes().length;
        } catch (Exception e) {
            length = 0;
        }
        if (length > i) {
            return true;
        }
        return false;
    }

    public void installHeader(Context context) {
        synchronized (f19353a) {
            CooperService.m15264a().getHeadObject().m15507a(context, f19353a);
        }
    }

    public synchronized void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.f19355c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f19355c.toString()));
            }
            synchronized (this.f19356d) {
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.f19356d.toString()));
            }
            synchronized (f19353a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(f19353a.toString()));
            }
        } catch (Exception e) {
            db.m15657a("flushLogWithoutHeader() construct cache error");
        }
        String jSONObject2 = jSONObject.toString();
        if (m15280a()) {
            db.m15657a("cache.json exceed 204800B,stop flush.");
        } else {
            int length = jSONObject2.getBytes().length;
            if (length >= Config.MAX_CACHE_JSON_CAPACITY) {
                m15279a(true);
            } else {
                this.f19359g = length;
                db.m15657a("flush:cacheFileSize is:" + this.f19359g + ", capacity is:" + Config.MAX_CACHE_JSON_CAPACITY);
                cu.m15630a(context, de.m15706q(context) + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
                synchronized (this.f19357e) {
                    jSONObject2 = this.f19357e.toString();
                    db.m15657a("flush wifi data: " + jSONObject2);
                    cu.m15630a(context, Config.LAST_AP_INFO_FILE_NAME, jSONObject2, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15279a(boolean z) {
        this.f19358f = z;
    }

    /* renamed from: a */
    private boolean m15280a() {
        return this.f19358f;
    }

    public void loadLastSession(Context context) {
        if (context != null) {
            String str = de.m15706q(context) + Config.LAST_SESSION_FILE_NAME;
            if (cu.m15635c(context, str)) {
                String a = cu.m15628a(context, str);
                if (TextUtils.isEmpty(a)) {
                    db.m15657a("loadLastSession(): last_session.json file not found.");
                    return;
                }
                cu.m15630a(context, str, new JSONObject().toString(), false);
                putSession(a);
                flush(context);
            }
        }
    }

    public void loadWifiData(Context context) {
        if (context != null && cu.m15635c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray;
                JSONArray jSONArray2 = new JSONArray(cu.m15628a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray2.length();
                if (length >= 10) {
                    jSONArray = new JSONArray();
                    for (int i = length - 10; i < length; i++) {
                        jSONArray.put(jSONArray2.get(i));
                    }
                } else {
                    jSONArray = jSONArray2;
                }
                CharSequence g = de.m15694g(1, context);
                if (!TextUtils.isEmpty(g)) {
                    jSONArray.put(g);
                }
                synchronized (this.f19357e) {
                    this.f19357e = jSONArray;
                    db.m15657a("wifiPart: " + this.f19357e.toString());
                }
            } catch (Throwable e) {
                db.m15662b(e);
            }
        }
    }

    public void loadStatData(Context context) {
        int i = 0;
        if (context != null) {
            String str = de.m15706q(context) + Config.STAT_CACHE_FILE_NAME;
            if (cu.m15635c(context, str)) {
                str = cu.m15628a(context, str);
                if (str.equals("")) {
                    db.m15657a("stat_cache file not found.");
                    return;
                }
                db.m15657a("loadStatData, ");
                try {
                    this.f19359g = str.getBytes().length;
                    db.m15657a("load Stat Data:cacheFileSize is:" + this.f19359g);
                    JSONObject jSONObject = new JSONObject(str);
                    db.m15657a("Load cache:" + str);
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (currentTimeMillis - jSONObject2.getLong("s") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                            putSession(jSONObject2);
                        }
                    }
                    JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        if (currentTimeMillis - jSONObject3.getLong("t") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                            putEvent(context, jSONObject3, true);
                        }
                        i++;
                    }
                    if (!isPartEmpty()) {
                        try {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                            synchronized (f19353a) {
                                f19353a = jSONObject4;
                            }
                        } catch (Throwable e) {
                            db.m15659a(e);
                        }
                    }
                } catch (JSONException e2) {
                    db.m15657a("Load stat data error:" + e2);
                }
            }
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        bu headObject = CooperService.m15264a().getHeadObject();
        if (TextUtils.isEmpty(headObject.f19507f)) {
            headObject.m15507a(context, jSONObject2);
        } else {
            headObject.m15509b(context, jSONObject2);
        }
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2.put("t", currentTimeMillis);
            jSONObject2.put("ss", currentTimeMillis);
            jSONObject2.put(Config.WIFI_LOCATION, jSONArray);
            jSONObject2.put(Config.SEQUENCE_INDEX, 0);
            jSONObject2.put("sign", CooperService.m15264a().getUUID());
            jSONObject2.put(Config.APP_KEY, str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            try {
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                try {
                    jSONObject.put(Config.EVENT_PART, jSONArray);
                    try {
                        jSONObject.put(Config.EXCEPTION_PART, jSONArray);
                        return jSONObject.toString();
                    } catch (Throwable e) {
                        db.m15659a(e);
                        return null;
                    }
                } catch (Throwable e2) {
                    db.m15659a(e2);
                    return null;
                }
            } catch (Throwable e22) {
                db.m15659a(e22);
                return null;
            }
        } catch (Throwable e222) {
            db.m15659a(e222);
            return null;
        }
    }

    /* renamed from: a */
    private void m15276a(Context context, JSONObject jSONObject, boolean z) {
        Object obj = 1;
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.TRACE_APPLICATION_SESSION, z ? 1 : 0);
            } catch (Exception e) {
            }
            try {
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception e2) {
            }
            try {
                jSONObject.put(Config.TRACE_PART, jSONObject2);
            } catch (Exception e3) {
                obj = null;
            }
            if (obj != null) {
                m15275a(context, jSONObject, jSONObject2);
            }
        }
    }

    /* renamed from: a */
    private void m15275a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        int a = m15270a(jSONObject);
        try {
            long j2;
            JSONObject jSONObject3 = jSONObject.getJSONObject(Config.HEADER_PART);
            if (jSONObject3 != null) {
                j2 = jSONObject3.getLong("ss");
            } else {
                j2 = 0;
            }
            j = j2;
        } catch (Exception e) {
            j = 0;
        }
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        m15274a(context, jSONObject2, j, a);
    }

    /* renamed from: a */
    private int m15270a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        int i;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.HEADER_PART);
            i = (jSONObject2.getLong("ss") <= 0 || jSONObject2.getLong(Config.SEQUENCE_INDEX) != 0) ? 0 : 1;
        } catch (Exception e) {
            i = 0;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
            if (jSONArray == null || jSONArray.length() == 0) {
                return i;
            }
            int i2 = 0;
            int i3 = i;
            while (i2 < jSONArray.length()) {
                try {
                    jSONObject2 = (JSONObject) jSONArray.get(i2);
                    long j = jSONObject2.getLong("c");
                    if (jSONObject2.getLong(Config.SESSTION_END_TIME) == 0 || j != 0) {
                        i = i3;
                    } else {
                        i = i3 + 1;
                    }
                    i2++;
                    i3 = i;
                } catch (Exception e2) {
                    return i3;
                }
            }
            return i3;
        } catch (Exception e3) {
            return i;
        }
    }

    /* renamed from: a */
    private void m15274a(Context context, JSONObject jSONObject, long j, int i) {
        int i2;
        int i3;
        long j2;
        long longValue = cq.m15605a().m15609b(context).longValue();
        if (longValue <= 0 && i != 0) {
            cq.m15605a().m15607a(context, j);
            longValue = j;
        }
        m15277a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue));
        if (i != 0) {
            long longValue2 = cq.m15605a().m15612c(context).longValue();
            longValue = j - longValue2;
            if (longValue2 != 0 && longValue <= 0) {
                longValue = -1;
            } else if (longValue2 == 0) {
                longValue = 0;
            }
            cq.m15605a().m15610b(context, j);
            cq.m15605a().m15613c(context, longValue);
        } else {
            longValue = cq.m15605a().m15614d(context).longValue();
        }
        m15277a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
        CharSequence charSequence = "";
        Object obj = "";
        String e = cq.m15605a().m15615e(context);
        if (!TextUtils.isEmpty(e) && e.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
            String[] split = e.split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (split != null && split.length == 2) {
                charSequence = split[0];
                obj = split[1];
            }
        }
        if (TextUtils.isEmpty(obj)) {
            i2 = 0;
        } else {
            try {
                i2 = Integer.valueOf(obj).intValue();
            } catch (Exception e2) {
                i2 = 0;
            }
        }
        String a = dg.m15713a(j);
        if (TextUtils.isEmpty(charSequence) || a.equals(charSequence)) {
            i3 = i + i2;
        } else {
            i3 = i;
        }
        if (i != 0) {
            cq.m15605a().m15608a(context, a + Config.TRACE_TODAY_VISIT_SPLIT + i3);
        }
        m15277a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i3));
        if (TextUtils.isEmpty(charSequence)) {
            j2 = 0;
        } else {
            try {
                j2 = (long) Integer.valueOf(charSequence).intValue();
            } catch (Exception e3) {
                j2 = 0;
            }
        }
        if (j2 == 0 || TextUtils.isEmpty(charSequence) || a.equals(charSequence) || i == 0) {
            Object f = cq.m15605a().m15616f(context);
            if (TextUtils.isEmpty(f)) {
                obj = null;
            } else {
                try {
                    obj = new JSONArray(f);
                } catch (Exception e4) {
                    obj = null;
                }
            }
            if (obj == null) {
                obj = new JSONArray();
            }
            m15277a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
            return;
        }
        obj = m15271a(context, j2, (long) i2);
        cq.m15605a().m15611b(context, obj.toString());
        m15277a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
    }

    /* renamed from: a */
    private JSONArray m15271a(Context context, long j, long j2) {
        Collection subList;
        List<JSONObject> arrayList = new ArrayList();
        Object f = cq.m15605a().m15616f(context);
        if (!TextUtils.isEmpty(f)) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                if (!(jSONArray == null || jSONArray.length() == 0)) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add((JSONObject) jSONArray.get(i));
                    }
                }
            } catch (Exception e) {
            }
        }
        for (JSONObject jSONObject : arrayList) {
            try {
                JSONObject jSONObject2;
                if (jSONObject2.getLong("day") == j) {
                    f = null;
                    break;
                }
            } catch (Exception e2) {
            }
        }
        int i2 = 1;
        if (f != null) {
            try {
                jSONObject2 = new JSONObject();
                jSONObject2.put("day", j);
                jSONObject2.put("count", j2);
                arrayList.add(jSONObject2);
            } catch (Exception e3) {
            }
        }
        i2 = arrayList.size();
        if (i2 > 5) {
            subList = arrayList.subList(i2 - 5, i2);
        } else {
            f = arrayList;
        }
        return new JSONArray(subList);
    }

    /* renamed from: a */
    private void m15277a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            if (!jSONObject.has(Config.TRACE_VISIT)) {
                try {
                    jSONObject.put(Config.TRACE_VISIT, new JSONObject());
                } catch (Exception e) {
                }
            }
            try {
                ((JSONObject) jSONObject.get(Config.TRACE_VISIT)).put(str, obj);
            } catch (Exception e2) {
            }
        }
    }

    public void saveLogDataToSend(Context context, boolean z, boolean z2) {
        db.m15657a("sendLogData() begin.");
        bu headObject = CooperService.m15264a().getHeadObject();
        if (headObject != null) {
            synchronized (f19353a) {
                if (TextUtils.isEmpty(headObject.f19507f)) {
                    headObject.m15507a(context, f19353a);
                } else {
                    headObject.m15509b(context, f19353a);
                }
                db.m15657a("constructHeader() begin." + f19353a + f19353a.length());
            }
            if (TextUtils.isEmpty(headObject.f19507f)) {
                db.m15663c("不能在manifest.xml中找到APP Key||can't find app key in manifest.xml.");
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        synchronized (f19353a) {
            try {
                f19353a.put("t", System.currentTimeMillis());
                f19353a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                f19353a.put("ss", ch.m15571a().m15603e());
                synchronized (this.f19357e) {
                    f19353a.put(Config.WIFI_LOCATION, this.f19357e);
                }
                f19353a.put("sign", CooperService.m15264a().getUUID());
                jSONObject.put(Config.HEADER_PART, f19353a);
                synchronized (this.f19355c) {
                    try {
                        jSONObject.put(Config.PRINCIPAL_PART, this.f19355c);
                        synchronized (this.f19356d) {
                            try {
                                jSONObject.put(Config.EVENT_PART, this.f19356d);
                                try {
                                    jSONObject.put(Config.EXCEPTION_PART, new JSONArray());
                                    m15276a(context, jSONObject, z2);
                                    String jSONObject2 = jSONObject.toString();
                                    db.m15657a("---Send Data is:" + jSONObject2);
                                    m15273a(context, jSONObject2);
                                    clearCache(context);
                                } catch (Throwable e) {
                                    db.m15659a(e);
                                    return;
                                }
                            } catch (Throwable e2) {
                                db.m15659a(e2);
                                return;
                            }
                        }
                    } catch (Throwable e22) {
                        db.m15659a(e22);
                        return;
                    }
                }
            } catch (Throwable e222) {
                db.m15659a(e222);
            }
        }
    }

    /* renamed from: a */
    private void m15273a(Context context, String str) {
        if (this.f19360h == null || !this.f19360h.onSendLogData(str)) {
            by.m15524a().m15543a(context, str);
        } else {
            db.m15657a("log data has been passed to app level");
        }
    }

    public boolean isPartEmpty() {
        boolean z;
        synchronized (this.f19355c) {
            z = this.f19355c.length() == 0;
        }
        return z;
    }

    public void clearCache(Context context) {
        m15279a(false);
        synchronized (f19353a) {
            f19353a = new JSONObject();
        }
        installHeader(context);
        m15272a(context);
    }

    /* renamed from: a */
    private void m15272a(Context context) {
        synchronized (this.f19356d) {
            this.f19356d = new JSONArray();
        }
        synchronized (this.f19355c) {
            this.f19355c = new JSONArray();
        }
        synchronized (this.f19357e) {
            this.f19357e = new JSONArray();
        }
        flush(context);
    }
}
