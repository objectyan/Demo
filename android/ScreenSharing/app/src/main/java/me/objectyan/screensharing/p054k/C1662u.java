package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1943r;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1630d;
import com.baidu.navi.track.database.DataService;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.util.common.PackageUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WeatherRequest */
/* renamed from: com.baidu.carlife.k.u */
public class C1662u extends C1626e {
    /* renamed from: a */
    public C1943r f5110a;
    /* renamed from: b */
    private int f5111b;

    public C1662u() {
        this.tag = C1662u.class.getSimpleName();
        GeoLocateModel local = GeoLocateModel.getInstance();
        if (local != null && local.getCurrentDistrict() != null) {
            this.f5111b = local.getCurrentDistrict().mId;
        }
    }

    /* renamed from: a */
    public C1943r m5978a() {
        return this.f5110a;
    }

    protected String getUrl() {
        return C1631f.m5917a(C1630d.WEATHER);
    }

    protected C1622d getPostRequestParams() {
        C1622d map = new C1622d();
        map.put("cityID", String.valueOf(this.f5111b));
        map.put("cuid", PackageUtil.getCuid());
        map.toSign();
        return map;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        this.f5110a = new C1943r();
        this.f5110a.f6166a = jsonData.optString("weather");
        this.f5110a.f6167b = jsonData.optString("temperature");
        this.f5110a.f6168c = jsonData.optString("washCar");
        this.f5110a.f6170e = jsonData.optString(DataService.EXTRA_LIMIT);
        this.f5110a.f6169d = jsonData.optString("place");
        this.f5110a.f6171f = jsonData.optString("tmpSection");
        this.f5110a.f6169d = jsonData.optString("place");
        this.f5110a.f6172g = jsonData.optInt("pm25");
        return 0;
    }
}
