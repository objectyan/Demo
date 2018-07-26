package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.p120e.C2534b;
import com.baidu.che.codriver.sdk.p081a.C2598i;
import com.baidu.che.codriver.sdk.p081a.C2598i.C1752b;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: PhoneCommandHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.f */
public class C2630f implements C2603a {
    /* renamed from: a */
    public static final String f8680a = "PhoneCommandHandler";

    /* compiled from: PhoneCommandHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.f$a */
    private class C2629a implements C1752b {
        /* renamed from: a */
        final /* synthetic */ C2630f f8679a;

        private C2629a(C2630f c2630f) {
            this.f8679a = c2630f;
        }

        /* renamed from: a */
        public void mo1636a(String num) {
            C2598i.m9805b().m9809a("call", num);
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8680a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param + "data:" + data);
        if (C2848p.af.equals(param)) {
            C2598i.m9805b().m9807a(new C2629a());
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("notify_phone_status".equals(param)) {
            C2598i.m9805b().m9808a(data);
        } else if ("phone_book_data".equals(param) && data != null) {
            C2534b.m9598a().m9613c(data);
        } else if ("reset".equals(param)) {
            C2598i.m9805b().m9807a(null);
        }
        return null;
    }
}
