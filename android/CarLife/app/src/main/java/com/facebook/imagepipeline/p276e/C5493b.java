package com.facebook.imagepipeline.p276e;

/* compiled from: ImageDecodeOptionsBuilder */
/* renamed from: com.facebook.imagepipeline.e.b */
public class C5493b {
    /* renamed from: a */
    private int f22329a = 100;
    /* renamed from: b */
    private int f22330b = -1;
    /* renamed from: c */
    private boolean f22331c;
    /* renamed from: d */
    private boolean f22332d;
    /* renamed from: e */
    private boolean f22333e;
    /* renamed from: f */
    private boolean f22334f;
    /* renamed from: g */
    private boolean f22335g;

    /* renamed from: a */
    public C5493b m18850a(C5492a options) {
        this.f22330b = options.f22323b;
        this.f22331c = options.f22324c;
        this.f22332d = options.f22325d;
        this.f22333e = options.f22326e;
        this.f22334f = options.f22327f;
        this.f22335g = options.f22328g;
        return this;
    }

    /* renamed from: a */
    public C5493b m18849a(int intervalMs) {
        this.f22329a = intervalMs;
        return this;
    }

    /* renamed from: a */
    public int m18848a() {
        return this.f22329a;
    }

    /* renamed from: b */
    public C5493b m18853b(int backgroundColor) {
        this.f22330b = backgroundColor;
        return this;
    }

    /* renamed from: b */
    public int m18852b() {
        return this.f22330b;
    }

    /* renamed from: a */
    public C5493b m18851a(boolean forceOldAnimationCode) {
        this.f22331c = forceOldAnimationCode;
        return this;
    }

    /* renamed from: c */
    public boolean m18856c() {
        return this.f22331c;
    }

    /* renamed from: b */
    public C5493b m18854b(boolean decodePreviewFrame) {
        this.f22332d = decodePreviewFrame;
        return this;
    }

    /* renamed from: d */
    public boolean m18858d() {
        return this.f22332d;
    }

    /* renamed from: e */
    public boolean m18860e() {
        return this.f22333e;
    }

    /* renamed from: c */
    public C5493b m18855c(boolean useLastFrameForPreview) {
        this.f22333e = useLastFrameForPreview;
        return this;
    }

    /* renamed from: f */
    public boolean m18861f() {
        return this.f22334f;
    }

    /* renamed from: d */
    public C5493b m18857d(boolean decodeAllFrames) {
        this.f22334f = decodeAllFrames;
        return this;
    }

    /* renamed from: e */
    public C5493b m18859e(boolean forceStaticImage) {
        this.f22335g = forceStaticImage;
        return this;
    }

    /* renamed from: g */
    public boolean m18862g() {
        return this.f22335g;
    }

    /* renamed from: h */
    public C5492a m18863h() {
        return new C5492a(this);
    }
}
