package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1925e;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1629c;
import com.baidu.carlife.util.C2180k;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FoodNearCafeRequest */
/* renamed from: com.baidu.carlife.k.h */
public class C1647h extends C1626e {
    /* renamed from: a */
    private int f5067a;
    /* renamed from: b */
    private List<C1925e> f5068b;

    public C1647h() {
        this.tag = C1647h.class.getSimpleName();
    }

    /* renamed from: a */
    public List<C1925e> m5956a() {
        return this.f5068b;
    }

    protected String getUrl() {
        return C1631f.m5916a(C1629c.CAFE_NEAR);
    }

    /* renamed from: b */
    public int m5957b() {
        return this.f5067a;
    }

    protected C1622d getPostRequestParams() {
        LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
        if (currentPoint == null) {
            return null;
        }
        C1622d map = new C1622d();
        map.put("token", C1631f.f5001l);
        long linuxTimestamp = System.currentTimeMillis() / 1000;
        map.put("t", String.valueOf(linuxTimestamp));
        map.put(NaviStatConstants.K_NSC_KEY_SN, C2180k.m8280a(linuxTimestamp + C1631f.f5000k));
        map.put("lat", String.valueOf(currentPoint.latitude));
        map.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, String.valueOf(currentPoint.longitude));
        map.put("page", String.valueOf(this.f5067a));
        return map;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject dataJson = new JSONObject(data);
        if (dataJson == null || !dataJson.has("result")) {
            return -3;
        }
        JSONObject resultJson = dataJson.optJSONObject("result");
        JSONArray jsonArray = resultJson.optJSONArray("shops");
        if (jsonArray == null) {
            return -3;
        }
        int arrayLength = jsonArray.length();
        if (arrayLength < 1) {
            return -3;
        }
        this.f5067a = resultJson.optInt("nextPage");
        this.f5068b = new ArrayList();
        for (int i = 0; i < arrayLength; i++) {
            C1925e model = C1925e.m7387a(jsonArray.optJSONObject(i));
            if (model != null) {
                this.f5068b.add(model);
            }
        }
        return 0;
    }
}
