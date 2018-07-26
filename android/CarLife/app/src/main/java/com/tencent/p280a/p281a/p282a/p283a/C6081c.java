package com.tencent.p280a.p281a.p282a.p283a;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import org.json.JSONObject;

/* renamed from: com.tencent.a.a.a.a.c */
public final class C6081c {
    /* renamed from: a */
    String f24737a = null;
    /* renamed from: b */
    String f24738b = null;
    /* renamed from: c */
    String f24739c = "0";
    /* renamed from: d */
    long f24740d = 0;

    /* renamed from: a */
    static C6081c m21649a(String str) {
        C6081c c6081c = new C6081c();
        if (C6085h.m21666a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c6081c.f24737a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull(Config.DEVICE_MAC_ID)) {
                    c6081c.f24738b = jSONObject.getString(Config.DEVICE_MAC_ID);
                }
                if (!jSONObject.isNull("mid")) {
                    c6081c.f24739c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull(MapObjKey.OBJ_SL_TIME)) {
                    c6081c.f24740d = jSONObject.getLong(MapObjKey.OBJ_SL_TIME);
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return c6081c;
    }

    /* renamed from: b */
    private JSONObject m21650b() {
        JSONObject jSONObject = new JSONObject();
        try {
            C6085h.m21664a(jSONObject, "ui", this.f24737a);
            C6085h.m21664a(jSONObject, Config.DEVICE_MAC_ID, this.f24738b);
            C6085h.m21664a(jSONObject, "mid", this.f24739c);
            jSONObject.put(MapObjKey.OBJ_SL_TIME, this.f24740d);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final String m21651a() {
        return this.f24739c;
    }

    public final String toString() {
        return m21650b().toString();
    }
}
