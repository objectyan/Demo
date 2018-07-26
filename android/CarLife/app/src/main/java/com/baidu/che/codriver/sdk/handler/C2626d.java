package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.p081a.C2586e;
import com.baidu.che.codriver.sdk.p081a.C2586e.C2584a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;

/* compiled from: MediaCommandHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.d */
public class C2626d implements C2603a {
    /* renamed from: a */
    public static final String f8677a = "MediaCommandHandler";

    /* compiled from: MediaCommandHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.d$1 */
    class C26251 implements C2584a {
        /* renamed from: a */
        final /* synthetic */ C2626d f8676a;

        C26251(C2626d this$0) {
            this.f8676a = this$0;
        }

        /* renamed from: a */
        public void mo1894a() {
            C2586e.m9780a().m9782a("radio", null);
        }

        /* renamed from: b */
        public void mo1896b() {
            C2586e.m9780a().m9782a("radio", "close");
        }

        /* renamed from: c */
        public void mo1898c() {
            C2586e.m9780a().m9782a("fm", null);
        }

        /* renamed from: a */
        public void mo1895a(String channel) {
            C2586e.m9780a().m9782a("fm", channel);
        }

        /* renamed from: d */
        public void mo1899d() {
            C2586e.m9780a().m9782a("am", null);
        }

        /* renamed from: b */
        public void mo1897b(String channel) {
            C2586e.m9780a().m9782a("am", channel);
        }

        /* renamed from: e */
        public void mo1900e() {
            C2586e.m9780a().m9782a("usb", null);
        }

        /* renamed from: f */
        public void mo1901f() {
            C2586e.m9780a().m9782a("cd", null);
        }

        /* renamed from: g */
        public void mo1902g() {
            C2586e.m9780a().m9782a("aux", null);
        }

        /* renamed from: h */
        public void mo1903h() {
            C2586e.m9780a().m9782a("ipod", null);
        }

        /* renamed from: i */
        public void mo1904i() {
            C2586e.m9780a().m9782a(NaviStatConstants.K_NSC_KEY_FINISHNAVI_BT, null);
        }

        /* renamed from: j */
        public void mo1905j() {
            C2586e.m9780a().m9782a("mymusic", null);
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8677a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2586e.m9780a().m9781a(new C26251(this));
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("reset".equals(param)) {
            C2586e.m9780a().m9781a(null);
        }
        return null;
    }
}
