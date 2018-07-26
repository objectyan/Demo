package com.baidu.che.codriver.protocol.p125a;

import android.text.TextUtils;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.che.codriver.protocol.C2556b;
import com.baidu.che.codriver.protocol.C2560a;
import com.baidu.che.codriver.protocol.C2566d;
import com.baidu.che.codriver.protocol.C2569e;
import com.baidu.che.codriver.protocol.C2569e.C2568a;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.navi.driveanalysis.CommonConstants;

/* compiled from: PlaceTask */
/* renamed from: com.baidu.che.codriver.protocol.a.c */
public class C2559c extends C2556b<Place> {
    /* renamed from: a */
    private static final String f8478a = "PlaceTask";
    /* renamed from: b */
    private String f8479b;
    /* renamed from: c */
    private String f8480c;
    /* renamed from: d */
    private boolean f8481d = false;

    public C2559c(C2566d<Place> listener, Class<Place> clazz, String query, String center) {
        super(listener, clazz);
        this.f8479b = query;
        this.f8480c = center;
    }

    public C2559c(C2566d<Place> listener, Class<Place> clazz, String query, boolean route) {
        super(listener, clazz);
        this.f8479b = query;
        this.f8481d = route;
    }

    /* renamed from: b */
    protected String mo1882b() {
        C2569e urlBuilder = new C2569e().m9697a(C2560a.f8486b).m9700b("place/v2/search");
        urlBuilder.m9698a("scope", "2");
        urlBuilder.m9698a("output", "json");
        urlBuilder.m9698a("region", LocationUtil.getInstance().getCity());
        urlBuilder.m9698a("ak", C2560a.f8485a);
        urlBuilder.m9698a("page_size", C2142b.f6818b);
        urlBuilder.m9698a("ret_coordtype", LocationUtil.getInstance().getCoordinateSysmem());
        if (!this.f8481d) {
            urlBuilder.m9698a(CommonConstants.RADIUS, "100000");
            if (TextUtils.isEmpty(this.f8480c)) {
                double lat = LocationUtil.getInstance().getLatitudeBd09ll();
                double lng = LocationUtil.getInstance().getLongitudeBd09ll();
                urlBuilder.m9698a("location", String.format("%.6f,%.6f", new Object[]{Double.valueOf(lat), Double.valueOf(lng)}));
            } else {
                this.f8479b = this.f8480c + "附近的" + this.f8479b;
            }
        }
        urlBuilder.m9698a("q", this.f8479b);
        String url = null;
        try {
            url = urlBuilder.m9701b();
        } catch (C2568a e) {
            C2725h.m10213d(f8478a, "Config url exception!!!!", e);
        }
        return url;
    }
}
