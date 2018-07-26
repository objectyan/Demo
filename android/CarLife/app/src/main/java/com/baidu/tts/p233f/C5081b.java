package com.baidu.tts.p233f;

/* compiled from: AudioEncoderFormat */
/* renamed from: com.baidu.tts.f.b */
public enum C5081b {
    BV("0") {
        /* renamed from: b */
        public C5085c[] mo3880b() {
            return C5085c.m17263c();
        }
    },
    AMR("1") {
        /* renamed from: b */
        public C5085c[] mo3880b() {
            return C5085c.m17264d();
        }
    },
    OPUS("2") {
        /* renamed from: b */
        public C5085c[] mo3880b() {
            return C5085c.m17265e();
        }
    };
    
    /* renamed from: d */
    private final String f21005d;

    /* renamed from: b */
    public abstract C5085c[] mo3880b();

    private C5081b(String str) {
        this.f21005d = str;
    }

    /* renamed from: a */
    public String m17257a() {
        return this.f21005d;
    }

    /* renamed from: a */
    public static C5081b m17256a(String str) {
        for (C5081b c5081b : C5081b.values()) {
            if (c5081b.m17257a().equals(str)) {
                return c5081b;
            }
        }
        return null;
    }
}
