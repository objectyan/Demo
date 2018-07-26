package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.i */
public class C6127i extends C6119e {
    /* renamed from: a */
    public static final C6161k f24789a;

    static {
        C6161k c6161k = new C6161k();
        f24789a = c6161k;
        c6161k.m22154b("A9VH9B8L4GX4");
    }

    public C6127i(Context context) {
        super(context, 0, f24789a);
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.NETWORK_DETECTOR;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        C6150s.m21920a(jSONObject, "actky", C6156f.m21988b(this.l));
        return true;
    }
}
