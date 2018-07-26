package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.e */
class C3161e {
    /* renamed from: a */
    private Context f17212a;
    /* renamed from: b */
    private List<HashMap<String, String>> f17213b = null;
    /* renamed from: c */
    private C3160a<String> f17214c = null;

    /* renamed from: com.baidu.lbsapi.auth.e$1 */
    class C31591 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3161e f17211a;

        C31591(C3161e c3161e) {
            this.f17211a = c3161e;
        }

        public void run() {
            this.f17211a.m13214a(this.f17211a.f17213b);
        }
    }

    /* renamed from: com.baidu.lbsapi.auth.e$a */
    interface C3160a<Result> {
        /* renamed from: a */
        void mo2493a(Result result);
    }

    protected C3161e(Context context) {
        this.f17212a = context;
    }

    /* renamed from: a */
    private List<HashMap<String, String>> m13211a(HashMap<String, String> hashMap, String[] strArr) {
        List<HashMap<String, String>> arrayList = new ArrayList();
        String str;
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                str2 = str2.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            arrayList.add(hashMap2);
        } else {
            for (Object put : strArr) {
                HashMap hashMap3 = new HashMap();
                for (String str22 : hashMap.keySet()) {
                    str22 = str22.toString();
                    hashMap3.put(str22, hashMap.get(str22));
                }
                hashMap3.put("mcode", put);
                arrayList.add(hashMap3);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m13213a(String str) {
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
        if (this.f17214c != null) {
            this.f17214c.mo2493a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    /* renamed from: a */
    private void m13214a(List<HashMap<String, String>> list) {
        C3152a.m13186a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            C3152a.m13188c("syncConnect failed,params list is null or size is 0");
            return;
        }
        JSONObject jSONObject;
        List arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            C3152a.m13186a("syncConnect resuest " + i + "  start!!!");
            HashMap hashMap = (HashMap) list.get(i);
            C3162f c3162f = new C3162f(this.f17212a);
            if (c3162f.m13222a()) {
                String a = c3162f.m13221a(hashMap);
                if (a == null) {
                    a = "";
                }
                C3152a.m13186a("syncConnect resuest " + i + "  result:" + a);
                arrayList.add(a);
                try {
                    jSONObject = new JSONObject(a);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        C3152a.m13186a("auth end and break");
                        m13213a(a);
                        return;
                    }
                } catch (JSONException e) {
                    C3152a.m13186a("continue-------------------------------");
                }
            } else {
                C3152a.m13186a("Current network is not available.");
                arrayList.add(C3155c.m13201a("Current network is not available."));
            }
            C3152a.m13186a("syncConnect end");
            i++;
        }
        C3152a.m13186a("--iiiiii:" + i + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() > 0 && i == list.size() && arrayList.size() > 0 && i == arrayList.size() && i - 1 > 0) {
            try {
                jSONObject = new JSONObject((String) arrayList.get(i - 1));
                if (jSONObject.has("status") && jSONObject.getInt("status") != 0) {
                    C3152a.m13186a("i-1 result is not 0,return first result");
                    m13213a((String) arrayList.get(0));
                }
            } catch (JSONException e2) {
                m13213a(C3155c.m13201a("JSONException:" + e2.getMessage()));
            }
        }
    }

    /* renamed from: a */
    protected void m13215a(HashMap<String, String> hashMap, String[] strArr, C3160a<String> c3160a) {
        this.f17213b = m13211a((HashMap) hashMap, strArr);
        this.f17214c = c3160a;
        new Thread(new C31591(this)).start();
    }
}
