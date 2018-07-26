package com.baidu.carlife.p054k;

import com.baidu.carlife.logic.C1766h;
import com.baidu.carlife.model.C1926f;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1629c;
import com.baidu.carlife.util.C2180k;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FoodQueueRequest */
/* renamed from: com.baidu.carlife.k.i */
public class C1648i extends C1626e {
    /* renamed from: a */
    private String f5069a;
    /* renamed from: b */
    private String f5070b;
    /* renamed from: c */
    private int f5071c;
    /* renamed from: d */
    private int f5072d;
    /* renamed from: e */
    private int f5073e;
    /* renamed from: f */
    private C1926f f5074f;

    /* renamed from: a */
    public C1926f m5958a() {
        return this.f5074f;
    }

    public C1648i(String phoneNum, String cafeId, int distance, int num, int type) {
        this.tag = C1648i.class.getSimpleName();
        this.f5069a = phoneNum;
        this.f5070b = cafeId;
        this.f5071c = num;
        this.f5072d = type;
        this.f5073e = distance;
    }

    protected String getUrl() {
        return C1631f.m5916a(C1629c.QUEUE_REQ);
    }

    protected C1622d getPostRequestParams() {
        C1622d map = new C1622d();
        map.put("token", C1631f.f5001l);
        map.put("sid", this.f5070b);
        map.put(Config.MODEL, this.f5069a);
        map.put("p", String.valueOf(this.f5071c));
        map.put("type", String.valueOf(this.f5072d));
        String linuxTimestamp = String.valueOf(System.currentTimeMillis() / 1000);
        map.put("orderid", linuxTimestamp);
        map.put("t", linuxTimestamp);
        map.put(NaviStatConstants.K_NSC_KEY_SN, C2180k.m8280a(linuxTimestamp + C1631f.f5000k));
        return map;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        if (new JSONObject(data).optJSONObject("result") == null) {
            return -1;
        }
        C1766h.f5369c = true;
        C1766h.f5367a.put(this.f5070b, Integer.valueOf(this.f5073e));
        return 0;
    }
}
