package com.baidu.tts.p245p;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.GetCUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetStatisticsInfo */
/* renamed from: com.baidu.tts.p.a */
public class C5154a {
    /* renamed from: a */
    public static String m17498a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("System", VERSION.RELEASE);
            jSONObject.put("SystemVersion", VERSION.SDK + "");
            jSONObject.put("PhoneModel", Build.MODEL);
            jSONObject.put("CPU", Build.CPU_ABI);
            jSONObject.put("NetworkType", CommonUtility.getNetworkInfo(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public static String m17499b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Cuid", GetCUID.getCUID(context));
            jSONObject.put("AppPackageName", context.getPackageName());
            jSONObject.put("SDKVersion", C5107b.m17306a().m17318j());
            jSONObject.put("soInfo", EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
