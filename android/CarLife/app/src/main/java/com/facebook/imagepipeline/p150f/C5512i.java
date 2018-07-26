package com.facebook.imagepipeline.p150f;

import com.facebook.common.p263n.C5374b;
import com.facebook.imagepipeline.p150f.C2947h.C2946a;

/* compiled from: ImagePipelineExperiments */
/* renamed from: com.facebook.imagepipeline.f.i */
public class C5512i {
    /* renamed from: a */
    private final int f22381a;
    /* renamed from: b */
    private final boolean f22382b;
    /* renamed from: c */
    private boolean f22383c;
    /* renamed from: d */
    private final int f22384d;

    /* compiled from: ImagePipelineExperiments */
    /* renamed from: com.facebook.imagepipeline.f.i$a */
    public static class C5511a {
        /* renamed from: a */
        private static final int f22375a = 5;
        /* renamed from: b */
        private final C2946a f22376b;
        /* renamed from: c */
        private int f22377c = 0;
        /* renamed from: d */
        private boolean f22378d = false;
        /* renamed from: e */
        private boolean f22379e = false;
        /* renamed from: f */
        private int f22380f = 5;

        public C5511a(C2946a configBuilder) {
            this.f22376b = configBuilder;
        }

        /* renamed from: a */
        public C2946a m18928a(boolean decodeFileDescriptorEnabled) {
            this.f22379e = decodeFileDescriptorEnabled;
            return this.f22376b;
        }

        /* renamed from: a */
        public C2946a m18927a(int forceSmallCacheThresholdBytes) {
            this.f22377c = forceSmallCacheThresholdBytes;
            return this.f22376b;
        }

        /* renamed from: b */
        public C2946a m18931b(boolean webpSupportEnabled) {
            this.f22378d = webpSupportEnabled;
            return this.f22376b;
        }

        /* renamed from: b */
        public C2946a m18930b(int throttlingMaxSimultaneousRequests) {
            this.f22380f = throttlingMaxSimultaneousRequests;
            return this.f22376b;
        }

        /* renamed from: a */
        public C5512i m18929a() {
            return new C5512i(this, this.f22376b);
        }
    }

    private C5512i(C5511a builder, C2946a configBuilder) {
        boolean z;
        boolean z2 = true;
        this.f22381a = builder.f22377c;
        if (builder.f22378d && C5374b.f21965e) {
            z = true;
        } else {
            z = false;
        }
        this.f22382b = z;
        if (!(configBuilder.a() && builder.f22379e)) {
            z2 = false;
        }
        this.f22383c = z2;
        this.f22384d = builder.f22380f;
    }

    /* renamed from: a */
    public boolean m18933a() {
        return this.f22383c;
    }

    /* renamed from: b */
    public int m18934b() {
        return this.f22381a;
    }

    /* renamed from: c */
    public boolean m18935c() {
        return this.f22382b;
    }

    /* renamed from: d */
    public int m18936d() {
        return this.f22384d;
    }

    /* renamed from: a */
    public static C5511a m18932a(C2946a configBuilder) {
        return new C5511a(configBuilder);
    }
}
