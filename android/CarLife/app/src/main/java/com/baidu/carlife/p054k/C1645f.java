package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1925e;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1629c;
import com.baidu.carlife.util.C2180k;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FoodCafeDetailRequest */
/* renamed from: com.baidu.carlife.k.f */
public class C1645f extends C1626e {
    /* renamed from: a */
    private C1925e f5063a;
    /* renamed from: b */
    private String f5064b;

    public C1645f(String cafeId, C1925e model) {
        this.tag = C1645f.class.getSimpleName();
        this.f5063a = model;
        this.f5064b = cafeId;
    }

    /* renamed from: a */
    public C1925e m5955a() {
        return this.f5063a;
    }

    protected C1622d getPostRequestParams() {
        C1622d map = new C1622d();
        map.put("token", C1631f.f5001l);
        map.put("sid", this.f5064b);
        long linuxTimestamp = System.currentTimeMillis() / 1000;
        map.put("t", String.valueOf(linuxTimestamp));
        map.put(NaviStatConstants.K_NSC_KEY_SN, C2180k.m8280a(linuxTimestamp + C1631f.f5000k));
        return map;
    }

    protected String getUrl() {
        return C1631f.m5916a(C1629c.CAFE_DETAIL);
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject resultJson = new JSONObject(data).optJSONObject("result");
        if (resultJson == null) {
            return -1;
        }
        this.f5063a = C1925e.m7386a(this.f5063a, resultJson);
        return 0;
    }
}
