package com.baidu.carlife.radio.p080b;

/* compiled from: Parameters */
/* renamed from: com.baidu.carlife.radio.b.l */
public class C2124l {
    /* renamed from: a */
    private String f6728a;
    /* renamed from: b */
    private String f6729b;
    /* renamed from: c */
    private C1843u f6730c;
    /* renamed from: d */
    private String f6731d;
    /* renamed from: e */
    private String f6732e;

    /* compiled from: Parameters */
    /* renamed from: com.baidu.carlife.radio.b.l$a */
    public static final class C2123a {
        /* renamed from: a */
        private String f6723a;
        /* renamed from: b */
        private String f6724b;
        /* renamed from: c */
        private C1843u f6725c;
        /* renamed from: d */
        private String f6726d;
        /* renamed from: e */
        private String f6727e;

        private C2123a() {
        }

        /* renamed from: a */
        public static C2123a m7996a() {
            return new C2123a();
        }

        /* renamed from: a */
        public C2123a m7998a(String id) {
            this.f6723a = id;
            return this;
        }

        /* renamed from: b */
        public C2123a m8000b(String channelId) {
            this.f6724b = channelId;
            return this;
        }

        /* renamed from: a */
        public C2123a m7997a(C1843u callback) {
            this.f6725c = callback;
            return this;
        }

        /* renamed from: c */
        public C2123a m8001c(String controlState) {
            this.f6726d = controlState;
            return this;
        }

        /* renamed from: d */
        public C2123a m8003d(String query) {
            this.f6727e = query;
            return this;
        }

        /* renamed from: b */
        public C2123a m7999b() {
            return C2123a.m7996a().m8000b(this.f6724b).m7997a(this.f6725c).m8001c(this.f6726d).m8003d(this.f6727e);
        }

        /* renamed from: c */
        public C2124l m8002c() {
            C2124l parameters = new C2124l();
            parameters.f6728a = this.f6723a;
            parameters.f6732e = this.f6727e;
            parameters.f6730c = this.f6725c;
            parameters.f6731d = this.f6726d;
            parameters.f6729b = this.f6724b;
            return parameters;
        }
    }

    private C2124l() {
    }

    /* renamed from: a */
    public String m8009a() {
        return this.f6728a;
    }

    /* renamed from: b */
    public String m8010b() {
        return this.f6732e;
    }

    /* renamed from: c */
    public String m8011c() {
        return this.f6729b;
    }

    /* renamed from: d */
    public C1843u m8012d() {
        return this.f6730c;
    }

    /* renamed from: e */
    public String m8013e() {
        return this.f6731d;
    }
}
