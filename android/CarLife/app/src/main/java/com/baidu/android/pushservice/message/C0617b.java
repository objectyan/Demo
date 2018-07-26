package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.p026e.C0486b;
import com.baidu.android.pushservice.p031j.C0578p;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.b */
public class C0617b extends C0616c {
    public C0617b(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C0621g mo1295a(C0619e c0619e) {
        JSONObject jSONObject;
        int i = -1;
        C0621g c0621g = new C0621g();
        try {
            jSONObject = new JSONObject(new String(c0619e.f1935c));
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            i = jSONObject.optInt("ret", -1);
        }
        if (i == 0) {
            C0486b.m2076a(this.a);
        } else if (i == 5003) {
            C0486b.m2076a(this.a);
        } else if (i == 2002) {
            C0580j.m2614a(this.a).m2617a(null, null);
            C0578p.m2565e(this.a);
        }
        c0621g.m2740a(i);
        return c0621g;
    }
}
