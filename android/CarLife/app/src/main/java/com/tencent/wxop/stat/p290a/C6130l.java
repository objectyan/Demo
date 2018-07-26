package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6135d;
import com.tencent.wxop.stat.p291b.C6144m;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.l */
public class C6130l extends C6119e {
    /* renamed from: a */
    private C6135d f24796a;
    /* renamed from: m */
    private JSONObject f24797m = null;

    public C6130l(Context context, int i, JSONObject jSONObject, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24796a = new C6135d(context);
        this.f24797m = jSONObject;
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.SESSION_ENV;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        if (this.f24757e != null) {
            jSONObject.put("ut", this.f24757e.m21839d());
        }
        if (this.f24797m != null) {
            jSONObject.put("cfg", this.f24797m);
        }
        if (C6144m.m21903y(this.l)) {
            jSONObject.put("ncts", 1);
        }
        this.f24796a.m21842a(jSONObject, null);
        return true;
    }
}
