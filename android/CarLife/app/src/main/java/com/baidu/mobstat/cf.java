package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class cf {
    /* renamed from: a */
    private volatile long f19555a = 0;
    /* renamed from: b */
    private volatile long f19556b = 0;
    /* renamed from: c */
    private volatile long f19557c = 0;
    /* renamed from: d */
    private volatile long f19558d = 0;
    /* renamed from: e */
    private volatile long f19559e = 0;
    /* renamed from: f */
    private volatile int f19560f = 0;
    /* renamed from: g */
    private List<cg> f19561g = new ArrayList();

    public cf() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f19555a = currentTimeMillis;
        this.f19559e = currentTimeMillis;
    }

    /* renamed from: a */
    public void m15550a() {
        long currentTimeMillis = System.currentTimeMillis();
        m15557c(currentTimeMillis);
        this.f19556b = 0;
        this.f19557c = 0;
        this.f19558d = 0;
        this.f19559e = currentTimeMillis;
        this.f19560f = 0;
        this.f19560f = 0;
        this.f19561g.clear();
    }

    /* renamed from: a */
    public void m15552a(long j) {
        this.f19557c = j;
    }

    /* renamed from: b */
    public void m15555b(long j) {
        this.f19558d = j;
    }

    /* renamed from: a */
    public void m15551a(int i) {
        this.f19560f = i;
    }

    /* renamed from: a */
    public void m15553a(cg cgVar) {
        m15549a(this.f19561g, cgVar);
    }

    /* renamed from: a */
    private void m15549a(List<cg> list, cg cgVar) {
        if (list != null && cgVar != null) {
            int size = list.size();
            if (size == 0) {
                list.add(cgVar);
                return;
            }
            cg cgVar2 = (cg) list.get(size - 1);
            if (TextUtils.isEmpty(cgVar2.f19562a) || TextUtils.isEmpty(cgVar.f19562a)) {
                list.add(cgVar);
            } else if (!cgVar2.f19562a.equals(cgVar.f19562a) || cgVar2.f19567f == cgVar.f19567f) {
                list.add(cgVar);
            } else if (cgVar2.f19567f) {
                cgVar2.m15563a(cgVar);
            }
        }
    }

    /* renamed from: c */
    public void m15557c(long j) {
        this.f19555a = j;
    }

    /* renamed from: b */
    public long m15554b() {
        return this.f19555a;
    }

    /* renamed from: c */
    public long m15556c() {
        return this.f19556b;
    }

    /* renamed from: d */
    public void m15559d(long j) {
        this.f19556b = j;
    }

    /* renamed from: d */
    public JSONObject m15558d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f19555a);
            jSONObject.put(Config.SESSTION_END_TIME, this.f19556b);
            jSONObject.put("i", this.f19559e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f19557c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f19558d);
            jSONObject.put("pc", this.f19560f);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f19561g.size(); i++) {
                jSONArray.put(m15548a((cg) this.f19561g.get(i), this.f19555a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException e) {
            db.m15657a("StatSession.constructJSONObject() failed");
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m15548a(cg cgVar, long j) {
        long j2 = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", cgVar.m15562a());
            jSONObject.put("d", cgVar.m15565c());
            long d = cgVar.m15566d() - j;
            String str = Config.SESSTION_ACTIVITY_START;
            if (d >= 0) {
                j2 = d;
            }
            jSONObject.put(str, j2);
            jSONObject.put("t", cgVar.m15564b());
            jSONObject.put("at", cgVar.m15568f() ? 1 : 0);
            JSONObject e = cgVar.m15567e();
            if (!(e == null || e.length() == 0)) {
                jSONObject.put("ext", e);
            }
        } catch (Throwable e2) {
            db.m15662b(e2);
        }
        return jSONObject;
    }
}
