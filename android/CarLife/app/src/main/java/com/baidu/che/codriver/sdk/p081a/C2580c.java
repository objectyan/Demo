package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

/* compiled from: CdCommonManager */
/* renamed from: com.baidu.che.codriver.sdk.a.c */
public class C2580c {
    /* renamed from: a */
    private static final String f8573a = C2580c.class.getSimpleName();
    /* renamed from: b */
    private C2452p f8574b;
    /* renamed from: c */
    private C1695n f8575c;
    /* renamed from: d */
    private C2607m f8576d = null;

    /* compiled from: CdCommonManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.c$a */
    private static class C2579a {
        /* renamed from: a */
        private static C2580c f8572a = new C2580c();

        private C2579a() {
        }
    }

    /* renamed from: a */
    public static C2580c m9750a() {
        return C2579a.f8572a;
    }

    /* renamed from: b */
    public C2452p m9755b() {
        return this.f8574b;
    }

    /* renamed from: a */
    public void m9753a(C2452p tool) {
        this.f8574b = tool;
    }

    /* renamed from: c */
    public C1695n m9756c() {
        return this.f8575c;
    }

    /* renamed from: a */
    public void m9752a(C1695n tool) {
        this.f8575c = tool;
    }

    /* renamed from: a */
    public void m9751a(C2607m tool) {
        this.f8576d = tool;
        LocationUtil.getInstance().setNaviTool(tool);
    }

    /* renamed from: d */
    public C2607m m9757d() {
        return this.f8576d;
    }

    /* renamed from: a */
    public void m9754a(String func, String params) {
        C2725h.m10207b(f8573a, "-onReceiveNaviCmd---func:" + func + "--params:" + params);
        if (this.f8576d != null) {
            this.f8576d.onNaviCommand(func, params);
            StatisticManager.onEvent(StatisticConstants.VOICE_0005);
        }
    }
}
