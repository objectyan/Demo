package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p023b.C0438g;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.speech.asr.SpeechConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.e.d */
public class C0488d extends C0487c {
    /* renamed from: d */
    protected boolean f1593d = false;

    public C0488d(C0496l c0496l, Context context) {
        super(c0496l, context);
    }

    /* renamed from: b */
    protected String mo1284b(String str) {
        String jSONObject;
        String str2;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("response_params");
            String string = jSONObject3.getString("user_id");
            String string2 = jSONObject3.getString(SpeechConstant.APP_ID);
            jSONObject3.put("channel_id", C0580j.m2614a(this.a).m2615a());
            this.b.f1609g = string;
            this.b.f1608f = string2;
            jSONObject = jSONObject2.toString();
            try {
                if (this.b.f1603a.equals("method_sdk_bind")) {
                    C0438g c0438g = (C0438g) C0439h.m1902a(this.a).m1898b(this.b.f1611i);
                    if (c0438g != null) {
                        c0438g.m1863a(string2);
                        c0438g.m1866b(this.b.f1607e);
                        C0578p.m2526a(this.a, C0439h.m1902a(this.a).m1903a(c0438g), 3);
                        return jSONObject;
                    }
                }
                str2 = jSONObject;
            } catch (JSONException e) {
                str2 = jSONObject;
            }
        } catch (JSONException e2) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(this.b.f1604b) && this.b.f1604b.equals("internal")) {
            return str2;
        }
        if (!TextUtils.isEmpty(this.b.f1614l) && C0448d.m1945g(this.a)) {
            return str2;
        }
        C0437f c0437f = new C0437f();
        c0437f.m1866b(this.b.f1607e);
        c0437f.m1863a(this.b.f1608f);
        c0437f.f1375f = this.b.f1609g;
        c0437f.m1900a(this.b.f1613k);
        c0437f.m1865b((int) C0430a.m1854a());
        jSONObject = C0432b.m1870a(this.a).m1878a(c0437f, this.f1593d);
        C0432b.m1870a(this.a).m1881a("r_v2", jSONObject);
        C0578p.m2526a(this.a, jSONObject, 0);
        return str2;
    }
}
