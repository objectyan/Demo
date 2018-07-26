package com.baidu.location.indoor.p197b;

/* renamed from: com.baidu.location.indoor.b.c */
final class C3415c {
    /* renamed from: a */
    double f18500a;
    /* renamed from: b */
    double f18501b;
    /* renamed from: c */
    int f18502c = Integer.MAX_VALUE;
    /* renamed from: d */
    int f18503d = Integer.MAX_VALUE;
    /* renamed from: e */
    int f18504e = Integer.MAX_VALUE;

    C3415c() {
    }

    /* renamed from: a */
    private double m14591a(double d, double d2) {
        return Math.sqrt((d * d) + (d2 * d2));
    }

    /* renamed from: a */
    double m14592a() {
        return m14591a(this.f18500a, this.f18501b);
    }

    /* renamed from: a */
    double m14593a(C3415c c3415c) {
        return Math.sqrt(((this.f18500a - c3415c.f18500a) * (this.f18500a - c3415c.f18500a)) + ((this.f18501b - c3415c.f18501b) * (this.f18501b - c3415c.f18501b)));
    }
}
