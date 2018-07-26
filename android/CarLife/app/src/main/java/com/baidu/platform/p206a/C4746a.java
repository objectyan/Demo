package com.baidu.platform.p206a;

import android.content.Context;

/* compiled from: ApplicationProvider */
/* renamed from: com.baidu.platform.a.a */
class C4746a {
    /* renamed from: a */
    private Context f19738a;

    /* compiled from: ApplicationProvider */
    /* renamed from: com.baidu.platform.a.a$a */
    private static class C4745a {
        /* renamed from: a */
        public static final C4746a f19737a = new C4746a();

        private C4745a() {
        }
    }

    /* renamed from: a */
    public static C4746a m15797a() {
        return C4745a.f19737a;
    }

    private C4746a() {
        try {
            Object invoke = Class.forName("com.baidu.baidumaps.BaiduMapApplication").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                this.f19738a = (Context) invoke;
                return;
            }
            throw new RuntimeException("BaiduMapApplication.getInstance() return null!");
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public Context m15798b() {
        return this.f19738a;
    }
}
