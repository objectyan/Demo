package com.baidu.che.codriver.sdk.p081a;

import com.baidu.che.codriver.util.C2725h;

/* compiled from: CdMediaManager */
/* renamed from: com.baidu.che.codriver.sdk.a.e */
public class C2586e {
    /* renamed from: a */
    private C2584a f8580a;

    /* compiled from: CdMediaManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.e$a */
    public interface C2584a {
        /* renamed from: a */
        void mo1894a();

        /* renamed from: a */
        void mo1895a(String str);

        /* renamed from: b */
        void mo1896b();

        /* renamed from: b */
        void mo1897b(String str);

        /* renamed from: c */
        void mo1898c();

        /* renamed from: d */
        void mo1899d();

        /* renamed from: e */
        void mo1900e();

        /* renamed from: f */
        void mo1901f();

        /* renamed from: g */
        void mo1902g();

        /* renamed from: h */
        void mo1903h();

        /* renamed from: i */
        void mo1904i();

        /* renamed from: j */
        void mo1905j();
    }

    /* compiled from: CdMediaManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.e$b */
    private static class C2585b {
        /* renamed from: a */
        private static C2586e f8579a = new C2586e();

        private C2585b() {
        }
    }

    /* renamed from: a */
    public static C2586e m9780a() {
        return C2585b.f8579a;
    }

    /* renamed from: b */
    public C2584a m9783b() {
        return this.f8580a;
    }

    /* renamed from: a */
    public void m9781a(C2584a mMediaTool) {
        this.f8580a = mMediaTool;
    }

    /* renamed from: a */
    public void m9782a(String param, String data) {
        C2725h.m10207b("CdMediaManager", "param:" + param + ";data:" + data);
        C2606l.m9828a().m9829a(C2606l.f8620f, param, data);
    }
}
