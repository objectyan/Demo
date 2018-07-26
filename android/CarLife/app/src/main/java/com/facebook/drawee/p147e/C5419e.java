package com.facebook.drawee.p147e;

import com.facebook.common.internal.C5350k;
import java.util.Arrays;

/* compiled from: RoundingParams */
/* renamed from: com.facebook.drawee.e.e */
public class C5419e {
    /* renamed from: a */
    private C5418a f22148a = C5418a.BITMAP_ONLY;
    /* renamed from: b */
    private boolean f22149b = false;
    /* renamed from: c */
    private float[] f22150c = null;
    /* renamed from: d */
    private int f22151d = 0;
    /* renamed from: e */
    private float f22152e = 0.0f;
    /* renamed from: f */
    private int f22153f = 0;
    /* renamed from: g */
    private float f22154g = 0.0f;

    /* compiled from: RoundingParams */
    /* renamed from: com.facebook.drawee.e.e$a */
    public enum C5418a {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    /* renamed from: a */
    public C5419e m18618a(boolean roundAsCircle) {
        this.f22149b = roundAsCircle;
        return this;
    }

    /* renamed from: a */
    public boolean m18620a() {
        return this.f22149b;
    }

    /* renamed from: a */
    public C5419e m18613a(float radius) {
        Arrays.fill(m18612i(), radius);
        return this;
    }

    /* renamed from: a */
    public C5419e m18614a(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        float[] radii = m18612i();
        radii[1] = topLeft;
        radii[0] = topLeft;
        radii[3] = topRight;
        radii[2] = topRight;
        radii[5] = bottomRight;
        radii[4] = bottomRight;
        radii[7] = bottomLeft;
        radii[6] = bottomLeft;
        return this;
    }

    /* renamed from: a */
    public C5419e m18619a(float[] radii) {
        boolean z;
        C5350k.m18310a((Object) radii);
        if (radii.length == 8) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18316a(z, (Object) "radii should have exactly 8 values");
        System.arraycopy(radii, 0, m18612i(), 0, 8);
        return this;
    }

    /* renamed from: b */
    public float[] m18622b() {
        return this.f22150c;
    }

    /* renamed from: a */
    public C5419e m18617a(C5418a roundingMethod) {
        this.f22148a = roundingMethod;
        return this;
    }

    /* renamed from: c */
    public C5418a m18623c() {
        return this.f22148a;
    }

    /* renamed from: a */
    public C5419e m18615a(int overlayColor) {
        this.f22151d = overlayColor;
        this.f22148a = C5418a.OVERLAY_COLOR;
        return this;
    }

    /* renamed from: d */
    public int m18625d() {
        return this.f22151d;
    }

    /* renamed from: i */
    private float[] m18612i() {
        if (this.f22150c == null) {
            this.f22150c = new float[8];
        }
        return this.f22150c;
    }

    /* renamed from: e */
    public static C5419e m18611e() {
        return new C5419e().m18618a(true);
    }

    /* renamed from: b */
    public static C5419e m18608b(float radius) {
        return new C5419e().m18613a(radius);
    }

    /* renamed from: b */
    public static C5419e m18609b(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        return new C5419e().m18614a(topLeft, topRight, bottomRight, bottomLeft);
    }

    /* renamed from: b */
    public static C5419e m18610b(float[] radii) {
        return new C5419e().m18619a(radii);
    }

    /* renamed from: c */
    public C5419e m18624c(float width) {
        C5350k.m18316a(width >= 0.0f, (Object) "the border width cannot be < 0");
        this.f22152e = width;
        return this;
    }

    /* renamed from: f */
    public float m18627f() {
        return this.f22152e;
    }

    /* renamed from: b */
    public C5419e m18621b(int color) {
        this.f22153f = color;
        return this;
    }

    /* renamed from: g */
    public int m18628g() {
        return this.f22153f;
    }

    /* renamed from: a */
    public C5419e m18616a(int color, float width) {
        C5350k.m18316a(width >= 0.0f, (Object) "the border width cannot be < 0");
        this.f22152e = width;
        this.f22153f = color;
        return this;
    }

    /* renamed from: d */
    public C5419e m18626d(float padding) {
        C5350k.m18316a(padding >= 0.0f, (Object) "the padding cannot be < 0");
        this.f22154g = padding;
        return this;
    }

    /* renamed from: h */
    public float m18629h() {
        return this.f22154g;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C5419e that = (C5419e) o;
        if (this.f22149b == that.f22149b && this.f22151d == that.f22151d && Float.compare(that.f22152e, this.f22152e) == 0 && this.f22153f == that.f22153f && Float.compare(that.f22154g, this.f22154g) == 0 && this.f22148a == that.f22148a) {
            return Arrays.equals(this.f22150c, that.f22150c);
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i;
        int i2 = 0;
        if (this.f22148a != null) {
            result = this.f22148a.hashCode();
        } else {
            result = 0;
        }
        int i3 = result * 31;
        if (this.f22149b) {
            i = 1;
        } else {
            i = 0;
        }
        i3 = (i3 + i) * 31;
        if (this.f22150c != null) {
            i = Arrays.hashCode(this.f22150c);
        } else {
            i = 0;
        }
        i3 = (((i3 + i) * 31) + this.f22151d) * 31;
        if (this.f22152e != 0.0f) {
            i = Float.floatToIntBits(this.f22152e);
        } else {
            i = 0;
        }
        i = (((i3 + i) * 31) + this.f22153f) * 31;
        if (this.f22154g != 0.0f) {
            i2 = Float.floatToIntBits(this.f22154g);
        }
        return i + i2;
    }
}
