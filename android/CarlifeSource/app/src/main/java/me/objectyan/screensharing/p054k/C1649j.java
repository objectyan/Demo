package com.baidu.carlife.p054k;

import android.text.TextUtils;
import com.baidu.carlife.model.C1926f;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1629c;
import com.baidu.carlife.util.C2180k;
import com.baidu.mobstat.Config;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FoodUserQueueRequest */
/* renamed from: com.baidu.carlife.k.j */
public class C1649j extends C1626e {
    /* renamed from: a */
    private List<C1926f> f5075a;
    /* renamed from: b */
    private String f5076b;
    /* renamed from: c */
    private String f5077c;

    /* renamed from: a */
    public List<C1926f> m5959a() {
        return this.f5075a;
    }

    /* renamed from: a */
    public void m5960a(String orderId, String serialId) {
        this.f5076b = orderId;
        this.f5077c = serialId;
    }

    public C1649j() {
        this.tag = C1649j.class.getSimpleName();
    }

    protected String getUrl() {
        return C1631f.m5916a(C1629c.QUEUE_USER);
    }

    protected C1622d getPostRequestParams() {
        C1622d map = null;
        if (NaviAccountUtils.getInstance().isLogin()) {
            map = new C1622d();
            map.put(Config.MODEL, NaviAccountUtils.getInstance().getSecurePhoneNum());
            map.put("token", C1631f.f5001l);
            String linuxTimestamp = String.valueOf(System.currentTimeMillis() / 1000);
            map.put("t", linuxTimestamp);
            map.put(NaviStatConstants.K_NSC_KEY_SN, C2180k.m8280a(linuxTimestamp + C1631f.f5000k));
            if (!TextUtils.isEmpty(this.f5077c)) {
                map.put("orderid", this.f5076b);
                map.put("serialid", this.f5077c);
            }
        }
        return map;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject resultJson = new JSONObject(data).optJSONObject("result");
        if (resultJson == null) {
            return -1;
        }
        this.f5075a = C1926f.m7389a(resultJson.optJSONArray("queues"));
        return 0;
    }
}
