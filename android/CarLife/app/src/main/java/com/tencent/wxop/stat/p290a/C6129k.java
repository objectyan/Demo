package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.k */
public class C6129k extends C6119e {
    /* renamed from: a */
    Long f24793a = null;
    /* renamed from: m */
    String f24794m;
    /* renamed from: n */
    String f24795n;

    public C6129k(Context context, String str, String str2, int i, Long l, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24795n = str;
        this.f24794m = str2;
        this.f24793a = l;
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.PAGE_VIEW;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        C6150s.m21920a(jSONObject, "pi", this.f24794m);
        C6150s.m21920a(jSONObject, "rf", this.f24795n);
        if (this.f24793a != null) {
            jSONObject.put("du", this.f24793a);
        }
        return true;
    }
}
