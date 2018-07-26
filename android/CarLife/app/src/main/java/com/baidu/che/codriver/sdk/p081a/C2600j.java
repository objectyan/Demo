package com.baidu.che.codriver.sdk.p081a;

/* compiled from: CdPlayerManager */
/* renamed from: com.baidu.che.codriver.sdk.a.j */
public class C2600j {
    /* renamed from: a */
    private C1822a f8610a;
    /* renamed from: b */
    private C1822a f8611b;

    /* compiled from: CdPlayerManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.j$a */
    public interface C1822a {
        /* renamed from: b */
        public static final int f5644b = 0;
        /* renamed from: c */
        public static final int f5645c = 1;
        /* renamed from: d */
        public static final int f5646d = 2;

        /* renamed from: a */
        void mo1674a(int i);

        /* renamed from: a */
        boolean mo1678a();

        /* renamed from: b */
        void mo1679b();

        /* renamed from: c */
        void mo1680c();

        /* renamed from: d */
        void mo1681d();

        /* renamed from: e */
        void mo1682e();

        /* renamed from: f */
        void mo1683f();

        /* renamed from: g */
        void mo1684g();
    }

    /* compiled from: CdPlayerManager */
    /* renamed from: com.baidu.che.codriver.sdk.a.j$b */
    private static class C2599b {
        /* renamed from: a */
        private static C2600j f8609a = new C2600j();

        private C2599b() {
        }
    }

    /* renamed from: a */
    public static C2600j m9814a() {
        return C2599b.f8609a;
    }

    /* renamed from: a */
    public void m9815a(C1822a tool) {
        this.f8610a = tool;
    }

    /* renamed from: b */
    public void m9817b(C1822a tool) {
        this.f8611b = tool;
    }

    /* renamed from: b */
    public C1822a m9816b() {
        if (this.f8610a == null || (this.f8611b != null && this.f8611b.mo1678a())) {
            return this.f8611b;
        }
        return this.f8610a;
    }
}
