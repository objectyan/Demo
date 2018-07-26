package com.baidu.che.codriver.sdk.handler;

import com.baidu.carlife.model.C1942q;
import com.baidu.che.codriver.sdk.p081a.C2600j;
import com.baidu.che.codriver.sdk.p081a.C2600j.C1822a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.ui.routeguide.fsm.RGState;

/* compiled from: PlayerCommandHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.g */
public class C2633g implements C2603a {

    /* compiled from: PlayerCommandHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.g$a */
    private class C2632a implements C1822a {
        /* renamed from: a */
        final /* synthetic */ C2633g f8681a;

        private C2632a(C2633g c2633g) {
            this.f8681a = c2633g;
        }

        /* renamed from: a */
        public boolean mo1678a() {
            return true;
        }

        /* renamed from: b */
        public void mo1679b() {
            C2606l.m9828a().m9829a(C2606l.f8616b, "play", null);
        }

        /* renamed from: c */
        public void mo1680c() {
            C2606l.m9828a().m9829a(C2606l.f8616b, C1942q.f6139g, null);
        }

        /* renamed from: d */
        public void mo1681d() {
            C2606l.m9828a().m9829a(C2606l.f8616b, RGState.METHOD_NAME_EXIT, null);
        }

        /* renamed from: e */
        public void mo1682e() {
            C2606l.m9828a().m9829a(C2606l.f8616b, "prev", null);
        }

        /* renamed from: f */
        public void mo1683f() {
            C2606l.m9828a().m9829a(C2606l.f8616b, C2848p.f9294U, null);
        }

        /* renamed from: a */
        public void mo1674a(int mode) {
            C2606l.m9828a().m9829a(C2606l.f8616b, "switch.mode", String.valueOf(mode));
        }

        /* renamed from: g */
        public void mo1684g() {
            C2606l.m9828a().m9829a(C2606l.f8616b, "change", null);
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        if (C2848p.af.equals(param)) {
            C2600j.m9814a().m9815a(new C2632a());
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("reset".equals(param)) {
            C2600j.m9814a().m9815a(null);
        }
        return null;
    }
}
