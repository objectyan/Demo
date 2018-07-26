package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: ParkingCommand */
/* renamed from: com.baidu.che.codriver.vr.a.u */
public class C2787u extends C2747a {
    /* renamed from: e */
    public static final String f9134e = "ParkingCommand";
    /* renamed from: i */
    private static int f9135i;
    /* renamed from: f */
    NLPResponseData f9136f;
    /* renamed from: g */
    String f9137g;
    /* renamed from: h */
    private Context f9138h;

    public C2787u(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    public C2787u(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9136f = data;
        this.f9138h = context;
        mo1958j();
    }
}
