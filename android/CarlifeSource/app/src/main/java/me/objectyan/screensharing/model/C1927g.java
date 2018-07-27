package com.baidu.carlife.model;

import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.mobstat.Config;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.ui.ugc.control.UgcOperationActController.UgcPostHttpConstans;
import org.json.JSONObject;

/* compiled from: HomeDiscoverParkModel */
/* renamed from: com.baidu.carlife.model.g */
public class C1927g {
    /* renamed from: a */
    public String f6011a;
    /* renamed from: b */
    public String f6012b;
    /* renamed from: c */
    public String f6013c;
    /* renamed from: d */
    public String f6014d;
    /* renamed from: e */
    public String f6015e;
    /* renamed from: f */
    public String f6016f;
    /* renamed from: g */
    public String f6017g;
    /* renamed from: h */
    public double f6018h;
    /* renamed from: i */
    public double f6019i;
    /* renamed from: j */
    public int f6020j;
    /* renamed from: k */
    public int f6021k;
    /* renamed from: l */
    public int f6022l;

    /* renamed from: a */
    public static C1927g m7393a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        C1927g model = new C1927g();
        model.f6011a = jsonObject.optString("parkId");
        model.f6012b = jsonObject.optString("name");
        model.f6013c = jsonObject.optString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYNAME);
        model.f6014d = jsonObject.optString("areaName");
        model.f6015e = jsonObject.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
        model.f6016f = jsonObject.optString(SearchParamKey.PRICE);
        model.f6017g = jsonObject.optString("priceUnit");
        model.f6020j = jsonObject.optInt("leftNum");
        model.f6021k = jsonObject.optInt(Config.EXCEPTION_MEMORY_TOTAL);
        model.f6018h = jsonObject.optDouble("latitude");
        model.f6019i = jsonObject.optDouble("longitude");
        model.f6022l = jsonObject.optInt("distance");
        return model;
    }
}
