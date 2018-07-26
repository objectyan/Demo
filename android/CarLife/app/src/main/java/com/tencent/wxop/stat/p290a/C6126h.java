package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.tencent.wxop.stat.C6155e;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.C6162l;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.h */
public class C6126h extends C6119e {
    /* renamed from: m */
    private static String f24786m = null;
    /* renamed from: n */
    private static String f24787n = null;
    /* renamed from: a */
    private C6155e f24788a = null;

    public C6126h(Context context, int i, C6155e c6155e, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24788a = c6155e.m21965h();
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.MONITOR_STAT;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        if (this.f24788a == null) {
            return false;
        }
        jSONObject.put("na", this.f24788a.m21951a());
        jSONObject.put("rq", this.f24788a.m21955b());
        jSONObject.put("rp", this.f24788a.m21958c());
        jSONObject.put("rt", this.f24788a.m21961d());
        jSONObject.put("tm", this.f24788a.m21962e());
        jSONObject.put("rc", this.f24788a.m21963f());
        jSONObject.put("sp", this.f24788a.m21964g());
        if (f24787n == null) {
            f24787n = C6144m.m21892n(this.l);
        }
        C6150s.m21920a(jSONObject, "av", f24787n);
        if (f24786m == null) {
            f24786m = C6144m.m21887i(this.l);
        }
        C6150s.m21920a(jSONObject, Config.OPERATOR, f24786m);
        jSONObject.put(NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, C6162l.m22161a(this.l).m22169b());
        return true;
    }
}
