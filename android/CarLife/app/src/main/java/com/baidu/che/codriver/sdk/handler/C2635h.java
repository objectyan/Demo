package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.p081a.C1695n;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2608a;
import com.baidu.che.codriver.sdk.p081a.C1695n.C2609b;
import com.baidu.che.codriver.sdk.p081a.C2580c;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;

/* compiled from: PrivateRadioHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.h */
public class C2635h implements C2603a {
    /* renamed from: a */
    private static final String f8683a = C2635h.class.getSimpleName();

    /* compiled from: PrivateRadioHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.h$1 */
    class C26341 implements C1695n {
        /* renamed from: a */
        final /* synthetic */ C2635h f8682a;

        C26341(C2635h this$0) {
            this.f8682a = this$0;
        }

        /* renamed from: a */
        public void mo1619a(C2609b model, C2608a listener) {
            C2606l.m9828a().m9829a(C2606l.f8625k, "open", new Gson().toJson(model));
        }

        /* renamed from: a */
        public void mo1618a() {
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8683a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2580c.m9750a().m9752a(new C26341(this));
            C2606l.m9828a().m9831a(pkg, cmdType);
        }
        return null;
    }
}
