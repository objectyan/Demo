package com.baidu.android.pushservice.p029h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.p031j.C0567f;
import com.baidu.android.pushservice.p031j.C0568g;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.g */
public class C0541g extends C0540m {
    /* renamed from: e */
    private static C0541g f1788e = null;
    /* renamed from: c */
    private String f1789c;
    /* renamed from: d */
    private C0567f f1790d;

    private C0541g(Context context) {
        super(context);
        this.f1789c = "LbsSender";
        this.f1790d = null;
        this.b = "https://lbsonline.pushct.baidu.com/lbsupload";
    }

    /* renamed from: a */
    public static C0541g m2318a(Context context) {
        if (f1788e == null) {
            f1788e = new C0541g(context);
        }
        return f1788e;
    }

    /* renamed from: a */
    String mo1289a(boolean z) {
        return C0568g.m2440a(this.a, z);
    }

    /* renamed from: a */
    public void m2320a(C0567f c0567f) {
        this.f1790d = c0567f;
    }

    /* renamed from: a */
    void mo1290a(String str) {
        JSONObject jSONObject;
        C0568g.m2441a(this.a, System.currentTimeMillis());
        try {
            jSONObject = new JSONObject(str);
            jSONObject = jSONObject.has("lbsInfo") ? jSONObject.optJSONObject("lbsInfo") : null;
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object a = C0568g.m2439a(this.a, jSONObject);
            if (this.f1790d != null && !TextUtils.isEmpty(a)) {
                this.f1790d.m2436a(0, a);
                this.f1790d = null;
            }
        }
    }

    /* renamed from: a */
    void mo1291a(String str, HashMap<String, String> hashMap) {
        hashMap.put("method", "uploadGeo");
        hashMap.put("data", str);
    }

    /* renamed from: a */
    boolean mo1292a() {
        return true;
    }

    /* renamed from: b */
    boolean mo1293b() {
        return true;
    }
}
