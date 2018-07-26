package com.baidu.che.codriver.util;

import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;

/* compiled from: CdAccountManager */
/* renamed from: com.baidu.che.codriver.util.b */
public class C2715b {
    /* renamed from: a */
    private static C2715b f8887a;

    /* renamed from: a */
    public static C2715b m10137a() {
        if (f8887a == null) {
            synchronized (C2715b.class) {
                f8887a = new C2715b();
            }
        }
        return f8887a;
    }

    /* renamed from: b */
    public boolean m10138b() {
        return NaviAccountUtils.getInstance().isLogin();
    }

    /* renamed from: c */
    public SapiAccount m10139c() {
        return SapiAccountManager.getInstance().getSession();
    }
}
