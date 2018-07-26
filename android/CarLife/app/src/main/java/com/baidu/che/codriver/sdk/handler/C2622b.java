package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.p120e.C2534b;
import com.baidu.che.codriver.p120e.C2534b.C2532a;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.sdk.p081a.C2578b.C2576a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;

/* compiled from: BuleToothHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.b */
public class C2622b implements C2603a {
    /* renamed from: a */
    public static final String f8673a = "BuleToothHandler";

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8673a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param + data);
        if (C2848p.af.equals(param)) {
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("bt_phone_notify".equals(param)) {
            if ("0".equals(data)) {
                C2534b.m9598a().m9609a(C2532a.EMPTY);
            } else if ("2".equals(data)) {
                C2534b.m9598a().m9609a(C2532a.DOWNLOADED);
            } else if ("3".equals(data)) {
                C2534b.m9598a().m9609a(C2532a.REQUESTING);
            } else if ("1".equals(data)) {
                C2534b.m9598a().m9609a(C2532a.DOWNLOADING);
            }
        } else if ("bt_media_notify".equals(param)) {
            C2725h.m10214e(f8673a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param + data);
        } else if ("bt_status_notify".equals(param)) {
            if ("0".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.DISCONNECTED);
            } else if ("1".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.CONNECTING);
            } else if ("2".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.CONNECTED);
            } else if ("3".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.DISCONNECTING);
            } else if ("4".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.CANCELLING);
            } else if ("5".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.CANCELLED);
            } else if (C2578b.f8568g.equals(data)) {
                C2578b.m9741a().m9743a(C2576a.PAIRED);
            } else if ("7".equals(data)) {
                C2578b.m9741a().m9743a(C2576a.NOPAIR);
            }
        } else if ("bt_service_notify".equals(param)) {
            C2725h.m10214e(f8673a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param + data);
        } else if ("bt_driver".equals(param)) {
            if ("1".equals(data)) {
                C2578b.m9741a().m9742a(1);
            } else {
                C2578b.m9741a().m9742a(0);
            }
        }
        return null;
    }
}
