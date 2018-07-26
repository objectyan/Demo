package com.facebook.imagepipeline.p152i;

/* compiled from: ImmutableQualityInfo */
/* renamed from: com.facebook.imagepipeline.i.f */
public class C5538f implements C5537g {
    /* renamed from: a */
    public static final C5537g f22457a = C5538f.m19064a(Integer.MAX_VALUE, true, true);
    /* renamed from: b */
    int f22458b;
    /* renamed from: c */
    boolean f22459c;
    /* renamed from: d */
    boolean f22460d;

    private C5538f(int quality, boolean isOfGoodEnoughQuality, boolean isOfFullQuality) {
        this.f22458b = quality;
        this.f22459c = isOfGoodEnoughQuality;
        this.f22460d = isOfFullQuality;
    }

    /* renamed from: a */
    public int mo4104a() {
        return this.f22458b;
    }

    /* renamed from: b */
    public boolean mo4105b() {
        return this.f22459c;
    }

    /* renamed from: c */
    public boolean mo4106c() {
        return this.f22460d;
    }

    public int hashCode() {
        int i = 0;
        int i2 = (this.f22459c ? 4194304 : 0) ^ this.f22458b;
        if (this.f22460d) {
            i = 8388608;
        }
        return i2 ^ i;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof C5538f)) {
            return false;
        }
        C5538f that = (C5538f) other;
        if (this.f22458b == that.f22458b && this.f22459c == that.f22459c && this.f22460d == that.f22460d) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static C5537g m19064a(int quality, boolean isOfGoodEnoughQuality, boolean isOfFullQuality) {
        return new C5538f(quality, isOfGoodEnoughQuality, isOfFullQuality);
    }
}
