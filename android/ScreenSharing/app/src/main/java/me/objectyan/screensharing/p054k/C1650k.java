package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1927g;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.util.C2180k;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HomeDiscoverParkRequest */
/* renamed from: com.baidu.carlife.k.k */
public class C1650k extends C1626e {
    /* renamed from: a */
    private List<C1927g> f5078a;

    public C1650k() {
        this.tag = C1650k.class.getSimpleName();
    }

    /* renamed from: a */
    public List<C1927g> m5961a() {
        return this.f5078a;
    }

    protected String getUrl() {
        return "http://api.soargift.com:8998/parkApi/queryNearbyParkInfoList";
    }

    protected C1622d getPostRequestParams() {
        LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
        if (currentPoint == null) {
            return null;
        }
        C1622d params = new C1622d();
        String userName = "baiducarlife";
        String userPwd = "84e08663f0e03dd5479133dd1a370320";
        GeoPoint geoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(currentPoint.longitude, currentPoint.latitude);
        double longitude = ((double) geoPoint.getLongitudeE6()) / 100000.0d;
        double latitude = ((double) geoPoint.getLatitudeE6()) / 100000.0d;
        params.put("userName", userName);
        params.put("userPwd", userPwd);
        params.put("longitude", String.valueOf(longitude));
        params.put("latitude", String.valueOf(latitude));
        params.put("secretSign", C2180k.m8280a(userName + userPwd + latitude + longitude).toLowerCase());
        params.put("distance", "1000");
        params.put("pageSize", "50");
        params.put("currentPage", "1");
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONArray jsonArray = new JSONObject(data).optJSONArray("parkDistanceList");
        if (jsonArray != null) {
            int arrayLength = jsonArray.length();
            if (arrayLength >= 1) {
                this.f5078a = new ArrayList();
                for (int i = 0; i < arrayLength; i++) {
                    C1927g model = C1927g.m7393a(jsonArray.optJSONObject(i));
                    if (model != null) {
                        this.f5078a.add(model);
                    }
                }
                return 0;
            }
        }
        return -3;
    }
}
