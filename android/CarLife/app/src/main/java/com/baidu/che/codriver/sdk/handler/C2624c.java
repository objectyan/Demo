package com.baidu.che.codriver.sdk.handler;

import android.view.KeyEvent;
import com.baidu.che.codriver.sdk.p081a.C2583d;
import com.baidu.che.codriver.sdk.p081a.C2583d.C2581a;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;

/* compiled from: HardKeyHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.c */
public class C2624c implements C2603a {
    /* renamed from: a */
    public static final String f8675a = "HardKeyCommandHandler";

    /* compiled from: HardKeyHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.c$1 */
    class C26231 implements C2581a {
        /* renamed from: a */
        final /* synthetic */ C2624c f8674a;

        C26231(C2624c this$0) {
            this.f8674a = this$0;
        }

        /* renamed from: a */
        public void mo1891a(int arg0, KeyEvent arg1) {
            C2583d.m9763a().m9765a("down", String.valueOf(arg0));
        }

        /* renamed from: b */
        public void mo1893b(int arg0, KeyEvent arg1) {
            C2583d.m9763a().m9765a(OfflineMapKey.OFFLINE_UPDATE, String.valueOf(arg0));
        }

        /* renamed from: a */
        public void mo1890a(int keyCode) {
            C2583d.m9763a().m9765a("click", String.valueOf(keyCode));
        }

        /* renamed from: b */
        public void mo1892b(int keyCode) {
            C2583d.m9763a().m9765a("long_click", String.valueOf(keyCode));
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8675a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2583d.m9763a().m9764a(new C26231(this));
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("reset".equals(param)) {
            C2583d.m9763a().m9764a(null);
        }
        return null;
    }
}
