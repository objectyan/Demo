package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.v */
public class C3607v {
    /* renamed from: a */
    public static JSONObject m15780a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", VERSION.SDK_INT);
            jSONObject.put("sv", VERSION.RELEASE);
            jSONObject.put(Config.CUID_SEC, de.m15675a(2, context));
            jSONObject.put(Config.DEVICE_WIDTH, de.m15680b(context));
            jSONObject.put("h", de.m15684c(context));
            jSONObject.put("ly", bc.f19435c);
            jSONObject.put("pv", "14");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put("pn", de.m15696h(2, context));
                jSONObject.put(Config.APP_VERSION_CODE, packageInfo.versionCode);
                jSONObject.put("n", packageInfo.versionName);
            } catch (Throwable e) {
                bd.m15429a(e);
            }
            jSONObject.put(Config.DEVICE_MAC_ID, de.m15682b(2, context));
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, de.m15692f(2, context));
            jSONObject.put(Config.MODEL, Build.MODEL);
            jSONObject.put(Config.DEVICE_NAME, de.m15677a(context, 2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            jSONObject2.put("send_index", 0);
            Object b = de.m15681b();
            String str = Config.ROM;
            if (b == null) {
                b = "";
            }
            jSONObject2.put(str, b);
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Throwable e2) {
            bd.m15432b(e2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m15781a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
            if (jSONArray == null || jSONArray.length() <= 0) {
                jSONObject2 = null;
            } else {
                jSONObject2 = (JSONObject) jSONArray.get(0);
            }
            jSONObject2 = jSONObject2 != null ? jSONObject2.getJSONObject(Config.HEADER_PART) : null;
        } catch (Exception e) {
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    /* renamed from: b */
    public static void m15782b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static void m15783c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put("send_index", jSONObject2.getLong("send_index") + 1);
        } catch (Exception e) {
        }
    }
}
