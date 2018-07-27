package com.baidu.carlife.p054k;

import android.text.TextUtils;
import com.baidu.carlife.logic.C1766h;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1629c;
import com.baidu.carlife.util.C2180k;
import com.baidu.carlife.util.C2201w;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FoodCancelQueueRequest */
/* renamed from: com.baidu.carlife.k.g */
public class C1646g extends C1626e {
    /* renamed from: a */
    public String f5065a;
    /* renamed from: b */
    public String f5066b;

    public C1646g(String orderId, String serialId) {
        this.tag = C1646g.class.getSimpleName();
        this.f5065a = orderId;
        this.f5066b = serialId;
    }

    protected C1622d getPostRequestParams() {
        C1622d map = new C1622d();
        map.put("token", C1631f.f5001l);
        map.put("orderid", this.f5065a);
        map.put("serialid", this.f5066b);
        String linuxTimestamp = String.valueOf(System.currentTimeMillis() / 1000);
        map.put("t", linuxTimestamp);
        map.put(NaviStatConstants.K_NSC_KEY_SN, C2180k.m8280a(linuxTimestamp + C1631f.f5000k));
        return map;
    }

    protected String getUrl() {
        return C1631f.m5916a(C1629c.QUEUE_CANCEL);
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject resultJson = new JSONObject(data).optJSONObject("result");
        if (resultJson == null) {
            return -1;
        }
        String sucMsg = resultJson.optString("msg");
        if (!TextUtils.isEmpty(sucMsg)) {
            C2201w.m8373a(sucMsg, 0);
        }
        C1766h.f5369c = true;
        return 0;
    }
}
