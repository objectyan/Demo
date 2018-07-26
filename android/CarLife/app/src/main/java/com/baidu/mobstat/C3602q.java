package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.q */
class C3602q {
    /* renamed from: a */
    static C3602q f19654a = new C3602q();

    C3602q() {
    }

    /* renamed from: a */
    public void m15763a(Context context, String str, String str2) {
        String a;
        PackageManager packageManager = context.getPackageManager();
        Object obj = "unkown";
        if (!"android.intent.action.PACKAGE_REMOVED".equals(str)) {
            try {
                obj = packageManager.getPackageInfo(str2, 8192).versionName;
            } catch (Throwable e) {
                bd.m15429a(e);
            }
        }
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("n", str2);
            jSONObject.put(Config.APP_VERSION_CODE, str);
            jSONObject.put("v", obj);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_change", jSONArray);
            jSONObject2.put("meta-data", stringBuilder.toString());
            a = cs.m15617a(jSONObject2.toString().getBytes());
        } catch (Exception e2) {
            bd.m15431b(e2.getMessage());
            a = str3;
        }
        if (!TextUtils.isEmpty(a)) {
            C3585y.APP_CHANGE.m15290a(System.currentTimeMillis(), a);
        }
    }
}
