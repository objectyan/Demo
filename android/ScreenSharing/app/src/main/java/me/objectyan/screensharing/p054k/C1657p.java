package com.baidu.carlife.p054k;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1630d;
import com.baidu.carlife.util.C2186p;

/* compiled from: StatisticVehicleRequest */
/* renamed from: com.baidu.carlife.k.p */
public class C1657p extends C1626e {
    /* renamed from: a */
    private C1656a f5100a;

    /* compiled from: StatisticVehicleRequest */
    /* renamed from: com.baidu.carlife.k.p$a */
    public class C1656a {
        /* renamed from: a */
        public String f5095a;
        /* renamed from: b */
        public String f5096b;
        /* renamed from: c */
        public String f5097c;
        /* renamed from: d */
        public String f5098d;
        /* renamed from: e */
        final /* synthetic */ C1657p f5099e;

        public C1656a(C1657p this$0) {
            this.f5099e = this$0;
        }

        /* renamed from: a */
        public String m5967a(String time) {
            return "{\"connectedTime\":[" + time + "]}";
        }
    }

    /* renamed from: a */
    public void m5968a(C1656a params) {
        this.f5100a = params;
    }

    public C1657p() {
        this.tag = C1657p.class.getSimpleName();
    }

    protected String getUrl() {
        return C1631f.m5917a(C1630d.STATISTICS_VEHICLE);
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("channel", this.f5100a.f5095a);
        params.put("cuid", this.f5100a.f5096b);
        params.put("version", this.f5100a.f5097c);
        params.put("item", this.f5100a.f5098d);
        return params;
    }

    protected int responseSuccessCallBack(String data) {
        C2186p.m8304a().m8322c(CommonParams.ik);
        return 0;
    }
}
