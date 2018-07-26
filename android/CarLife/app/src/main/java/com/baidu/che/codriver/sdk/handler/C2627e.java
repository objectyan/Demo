package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.p081a.C2593g;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: NLPHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.e */
public class C2627e implements C2603a {
    /* renamed from: a */
    public static final String f8678a = "NLPHandler";

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8678a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("nlp".equals(param)) {
            C2593g.m9796a().m9797a(data);
        }
        return null;
    }
}
