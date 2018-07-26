package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import com.tencent.wxop.stat.C6157g;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.g */
public class C6125g extends C6119e {
    /* renamed from: a */
    private C6157g f24785a = null;

    public C6125g(Context context, int i, C6157g c6157g, C6161k c6161k) {
        super(context, i, c6161k);
        this.f24785a = c6157g.m22057d();
    }

    /* renamed from: a */
    public C6124f mo5015a() {
        return C6124f.MTA_GAME_USER;
    }

    /* renamed from: a */
    public boolean mo5016a(JSONObject jSONObject) {
        if (this.f24785a == null) {
            return false;
        }
        C6150s.m21920a(jSONObject, "wod", this.f24785a.m22051a());
        C6150s.m21920a(jSONObject, "gid", this.f24785a.m22053b());
        C6150s.m21920a(jSONObject, OfflineMapKey.OFFLINE_LEVEL, this.f24785a.m22055c());
        return true;
    }
}
