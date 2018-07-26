package com.tencent.wxop.stat.p291b;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.params.TrafficParams.Key;
import com.tencent.wxop.stat.C6162l;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.b.d */
public class C6135d {
    /* renamed from: a */
    static C6137f f24897a;
    /* renamed from: d */
    private static C6133b f24898d = C6144m.m21872b();
    /* renamed from: e */
    private static JSONObject f24899e = new JSONObject();
    /* renamed from: b */
    Integer f24900b = null;
    /* renamed from: c */
    String f24901c = null;

    public C6135d(Context context) {
        try {
            C6135d.m21840a(context);
            this.f24900b = C6144m.m21891m(context.getApplicationContext());
            this.f24901c = C6162l.m22161a(context).m22169b();
        } catch (Throwable th) {
            f24898d.m21826b(th);
        }
    }

    /* renamed from: a */
    static synchronized C6137f m21840a(Context context) {
        C6137f c6137f;
        synchronized (C6135d.class) {
            if (f24897a == null) {
                f24897a = new C6137f(context.getApplicationContext());
            }
            c6137f = f24897a;
        }
        return c6137f;
    }

    /* renamed from: a */
    public static void m21841a(Context context, Map<String, String> map) {
        if (map != null) {
            for (Entry entry : new HashMap(map).entrySet()) {
                f24899e.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public void m21842a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f24897a != null) {
                f24897a.m21843a(jSONObject2, thread);
            }
            C6150s.m21920a(jSONObject2, NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, this.f24901c);
            if (this.f24900b != null) {
                jSONObject2.put(Key.ALA_REQUEST_PARAM_KEY_TN, this.f24900b);
            }
            if (thread == null) {
                jSONObject.put(Config.EVENT_PART, jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f24899e != null && f24899e.length() > 0) {
                jSONObject.put("eva", f24899e);
            }
        } catch (Throwable th) {
            f24898d.m21826b(th);
        }
    }
}
