package com.indooratlas.android.sdk._internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class bb {
    /* renamed from: a */
    int f23072a;
    /* renamed from: b */
    public JSONObject f23073b;

    public bb(JSONObject jSONObject) {
        m19979a(jSONObject);
    }

    /* renamed from: a */
    public final void m19979a(JSONObject jSONObject) {
        this.f23073b = jSONObject;
        this.f23072a = this.f23073b.optInt("positioning.maxMetricsPerRequest", 5);
    }

    /* renamed from: a */
    public final String m19978a() {
        try {
            return this.f23073b.getString("url");
        } catch (JSONException e) {
            throw new IllegalStateException("missing mandatory config key 'url'");
        }
    }

    /* renamed from: b */
    public final long m19980b() {
        return this.f23073b.optLong("positioningHibernateTimeout", 180000);
    }

    /* renamed from: c */
    public final String m19981c() {
        return this.f23073b.optString("key");
    }
}
