package com.baidu.carlife.p054k;

import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import org.json.JSONException;

/* compiled from: VehicleConfigRequest */
/* renamed from: com.baidu.carlife.k.r */
public class C1659r extends C1626e {
    /* renamed from: a */
    private boolean f5103a;
    /* renamed from: b */
    private String f5104b;

    public C1659r(String vehicleChannel) {
        this.f5103a = false;
        this.tag = C1659r.class.getSimpleName();
        this.f5104b = vehicleChannel;
    }

    /* renamed from: a */
    public boolean m5971a() {
        return this.f5103a;
    }

    protected C1622d getUrlParams() {
        C1622d map = new C1622d();
        map.put("channel_number", this.f5104b);
        return map;
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.VEHICLE_CONFIG);
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        this.f5103a = false;
        if ("1".equals(data)) {
            this.f5103a = true;
        }
        return 0;
    }
}
