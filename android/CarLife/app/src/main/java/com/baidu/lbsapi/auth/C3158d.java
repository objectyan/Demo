package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.d */
class C3158d {
    /* renamed from: a */
    private Context f17208a;
    /* renamed from: b */
    private HashMap<String, String> f17209b = null;
    /* renamed from: c */
    private C3157a<String> f17210c = null;

    /* renamed from: com.baidu.lbsapi.auth.d$1 */
    class C31561 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3158d f17207a;

        C31561(C3158d c3158d) {
            this.f17207a = c3158d;
        }

        public void run() {
            C3152a.m13186a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
            this.f17207a.m13206a(new C3162f(this.f17207a.f17208a).m13221a(this.f17207a.f17209b));
        }
    }

    /* renamed from: com.baidu.lbsapi.auth.d$a */
    interface C3157a<Result> {
        /* renamed from: a */
        void mo2492a(Result result);
    }

    protected C3158d(Context context) {
        this.f17208a = context;
    }

    /* renamed from: a */
    private HashMap<String, String> m13204a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            String str2 = str2.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* renamed from: a */
    private void m13206a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException e) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f17210c != null) {
            this.f17210c.mo2492a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    /* renamed from: a */
    protected void m13208a(HashMap<String, String> hashMap, C3157a<String> c3157a) {
        this.f17209b = m13204a((HashMap) hashMap);
        this.f17210c = c3157a;
        new Thread(new C31561(this)).start();
    }
}
