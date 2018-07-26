package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6154d;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.a */
public class C6120a extends C6119e {
    /* renamed from: a */
    private C6154d f24764a = null;

    public C6120a(Context context, int i, C6154d c6154d, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24764a = c6154d;
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.ADDITION;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        C6150s.m21920a(jSONObject, "qq", this.f24764a.m21945b());
        jSONObject.put("acc", this.f24764a.m21942a());
        return true;
    }
}
