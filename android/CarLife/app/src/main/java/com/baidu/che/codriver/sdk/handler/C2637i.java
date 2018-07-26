package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.p081a.C2602k;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;

/* compiled from: SystemCommandHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.i */
public class C2637i implements C2603a {
    /* renamed from: a */
    public static final String f8685a = "SystemCommandHandler";

    /* compiled from: SystemCommandHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.i$1 */
    class C26361 implements C1981b {
        /* renamed from: a */
        final /* synthetic */ C2637i f8684a;

        C26361(C2637i this$0) {
            this.f8684a = this$0;
        }

        /* renamed from: a */
        public void mo1727a(String feature) {
            C2602k.m9819a().m9821a("close", feature);
        }

        /* renamed from: a */
        public void mo1728a(String feature, boolean isFromVrWakeUp) {
            C2602k.m9819a().m9821a("open", feature);
        }

        /* renamed from: b */
        public void mo1729b(String feature) {
            C2602k.m9819a().m9821a(OfflineMapKey.OFFLINE_UPDATE, feature);
        }

        /* renamed from: c */
        public void mo1730c(String feature) {
            C2602k.m9819a().m9821a("down", feature);
        }

        /* renamed from: d */
        public void mo1731d(String feature) {
            C2602k.m9819a().m9821a("max", feature);
        }

        /* renamed from: e */
        public void mo1732e(String feature) {
            C2602k.m9819a().m9821a("min", feature);
        }

        /* renamed from: f */
        public void mo1733f(String action) {
            C2602k.m9819a().m9821a("operate", action);
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10207b(f8685a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2602k.m9819a().m9820a(new C26361(this));
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("reset".equals(param)) {
            C2602k.m9819a().m9820a(null);
        }
        return null;
    }
}
