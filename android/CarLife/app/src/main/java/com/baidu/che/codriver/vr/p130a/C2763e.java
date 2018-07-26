package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: FlightSearchCommand */
/* renamed from: com.baidu.che.codriver.vr.a.e */
public class C2763e extends C2747a {
    /* renamed from: e */
    private NLPResponseData f9076e;

    public C2763e(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    public C2763e(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9076e = data;
        this.d = context;
        mo1958j();
    }
}
