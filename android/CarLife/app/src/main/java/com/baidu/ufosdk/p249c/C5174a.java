package com.baidu.ufosdk.p249c;

import android.annotation.SuppressLint;
import com.baidu.ufosdk.util.C5210c;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RecordTransformer */
/* renamed from: com.baidu.ufosdk.c.a */
public final class C5174a {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static String m17564a(Map map) {
        if (map == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    jSONObject.put(str, (String) obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(str, (Integer) obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(str, (Long) obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(str, (Float) obj);
                } else {
                    C5210c.m17736d("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
            } catch (Throwable e) {
                C5210c.m17733a("Could not create JSON object for key " + str, e);
            }
        }
        C5210c.m17734b("json is " + jSONObject.toString());
        return jSONObject.toString();
    }
}
