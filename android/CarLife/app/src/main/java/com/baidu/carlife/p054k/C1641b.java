package com.baidu.carlife.p054k;

import com.baidu.carlife.model.C1924d;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import java.util.List;
import org.json.JSONException;

/* compiled from: CarServiceManageRequest */
/* renamed from: com.baidu.carlife.k.b */
public class C1641b extends C1626e {
    /* renamed from: a */
    private String f5053a = "android";
    /* renamed from: b */
    private List<C1924d> f5054b;

    protected String getUrl() {
        return C1631f.m5914a(C1627a.CAR_SERVICE);
    }

    /* renamed from: a */
    public List<C1924d> m5948a() {
        return this.f5054b;
    }

    /* renamed from: a */
    public void m5950a(List<C1924d> carFactories) {
        this.f5054b = carFactories;
    }

    /* renamed from: b */
    public String m5951b() {
        return this.f5053a;
    }

    /* renamed from: a */
    public void m5949a(String type) {
        this.f5053a = type;
    }

    protected C1622d getUrlParams() {
        C1622d params = new C1622d();
        params.put("type", this.f5053a);
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        if (data == null || data.length() == 0) {
            return -3;
        }
        this.f5054b = C1924d.m7384a(data);
        return 0;
    }
}
