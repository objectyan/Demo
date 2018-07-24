package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1937p;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VehicleLogoRequest */
/* renamed from: com.baidu.carlife.k.s */
public class C1660s extends C1626e {
    /* renamed from: a */
    private C1937p f5105a;
    /* renamed from: b */
    private String f5106b;

    public C1660s() {
        this.tag = C1660s.class.getSimpleName();
    }

    /* renamed from: a */
    public String m5972a() {
        return this.f5106b;
    }

    /* renamed from: a */
    public void m5973a(String vehicleChannel) {
        this.f5106b = vehicleChannel;
    }

    /* renamed from: b */
    public C1937p m5974b() {
        return this.f5105a;
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.VEHICLE_LOGO);
    }

    protected C1622d getUrlParams() {
        C1622d map = new C1622d();
        map.put("channel_number", this.f5106b);
        map.put("version", "2");
        return map;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        if (jsonData == null || !jsonData.has("logo_name") || !jsonData.has("logo_imageurl")) {
            return -1;
        }
        this.f5105a = new C1937p();
        this.f5105a.f6111a = jsonData.optString("logo_imageurl");
        this.f5105a.f6112b = jsonData.optString("logo_name");
        this.f5105a.f6113c = jsonData.optString("create_time");
        return 0;
    }
}
