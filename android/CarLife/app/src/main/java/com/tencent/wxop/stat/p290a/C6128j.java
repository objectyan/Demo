package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.C6162l;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.j */
public class C6128j extends C6119e {
    /* renamed from: a */
    private static String f24790a = null;
    /* renamed from: m */
    private String f24791m = null;
    /* renamed from: n */
    private String f24792n = null;

    public C6128j(Context context, int i, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24791m = C6162l.m22161a(context).m22169b();
        if (f24790a == null) {
            f24790a = C6144m.m21887i(context);
        }
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.NETWORK_MONITOR;
    }

    /* renamed from: a */
    public void m21736a(String str) {
        this.f24792n = str;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        C6150s.m21920a(jSONObject, Config.OPERATOR, f24790a);
        C6150s.m21920a(jSONObject, NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, this.f24791m);
        jSONObject.put("sp", this.f24792n);
        return true;
    }
}
