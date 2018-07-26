package com.baidu.location.p188h;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.baidu.location.h.d */
public class C3385d {
    /* renamed from: a */
    private static C3385d f18335a = null;
    /* renamed from: b */
    private static final double[] f18336b = new double[]{110.389648d, 105.070224d, 96.898845d, 95.617053d, 93.822557d, 91.387165d, 91.387165d, 89.079901d, 87.221341d, 86.259997d, 85.170461d, 85.234525d, 82.863261d, 81.901917d, 79.594685d, 80.395798d, 79.931142d, 77.800174d, 75.252622d, 73.490158d, 73.185732d, 73.874699d, 74.403435d, 74.099003d, 75.460905d, 76.77474d, 78.280852d, 78.15266d, 78.37698d, 78.8897d, 79.690818d, 81.196914d, 81.805762d, 83.888674d, 85.939538d, 87.862215d, 89.031847d, 90.057287d, 91.098741d, 92.156213d, 93.742421d, 95.825333d, 97.956327d, 97.123143d, 98.212679d, 99.206055d, 101.657471d, 102.52267d, 102.23427d, 105.022158d, 106.095662d, 107.858116d, 111.639396d, 109.588503d, 112.280343d, 117.792023d, 118.945559d, 114.203031d, 118.689303d, 123.143466d, 122.726858d, 120.932369d, 123.415857d, 122.374385d, 122.134054d, 121.586108d, 121.17271d, 120.676006d, 120.243409d, 122.790961d, 122.871076d, 121.300884d, 122.134052d, 123.736285d, 126.412019d, 128.559027d, 129.712627d, 131.218707d, 131.987795d, 133.622084d, 135.60888d, 131.378992d, 130.866224d, 128.623088d, 126.091572d, 124.393204d, 122.214164d, 119.65058d, 119.778772d, 118.561044d, 116.510192d, 114.811824d, 119.073776d, 116.446096d, 111.735536d, 110.389648d};
    /* renamed from: c */
    private static final double[] f18337c = new double[]{43.216755d, 42.378597d, 43.172612d, 44.421188d, 45.097508d, 45.565732d, 47.334548d, 48.687188d, 49.62362d, 48.947316d, 48.479092d, 47.334548d, 47.438596d, 46.03394d, 45.201556d, 43.344095d, 42.328663d, 41.395882d, 40.829126d, 39.955382d, 39.258748d, 38.361382d, 38.054394d, 37.168842d, 36.389553d, 35.362313d, 34.311457d, 32.587581d, 31.572149d, 30.781055d, 30.438642d, 29.77743d, 30.09623d, 28.714766d, 27.71114d, 27.581258d, 27.014504d, 27.781984d, 27.510415d, 26.506787d, 26.707513d, 27.959095d, 27.29788d, 23.649404d, 23.62579d, 21.677574d, 20.780213d, 21.323353d, 22.185291d, 22.315173d, 22.515897d, 16.802289d, 13.198973d, 0.693351d, 1.541191d, 10.504055d, 15.591095d, 17.892375d, 19.951383d, 22.187501d, 25.375613d, 25.617568d, 30.627458d, 31.082902d, 31.894166d, 32.503117d, 32.805056d, 34.256784d, 35.155304d, 36.90119d, 37.83411d, 37.940728d, 38.64708d, 38.966937d, 40.979374d, 41.253698d, 42.069802d, 42.48888d, 44.65045d, 44.691252d, 48.620679d, 48.091311d, 49.194151d, 50.032311d, 53.274665d, 53.627577d, 53.892257d, 52.987929d, 52.017425d, 50.230825d, 50.186707d, 47.495779d, 47.341379d, 46.503219d, 45.245983d, 43.216755d};
    /* renamed from: d */
    private LinkedList<C3384b> f18338d = null;

    /* renamed from: com.baidu.location.h.d$a */
    class C3383a {
        /* renamed from: a */
        double f18329a;
        /* renamed from: b */
        double f18330b;
        /* renamed from: c */
        final /* synthetic */ C3385d f18331c;

        C3383a(C3385d c3385d, double d, double d2) {
            this.f18331c = c3385d;
            this.f18329a = d;
            this.f18330b = d2;
        }
    }

    /* renamed from: com.baidu.location.h.d$b */
    class C3384b {
        /* renamed from: a */
        C3383a f18332a;
        /* renamed from: b */
        C3383a f18333b;
        /* renamed from: c */
        final /* synthetic */ C3385d f18334c;

        C3384b(C3385d c3385d, C3383a c3383a, C3383a c3383a2) {
            this.f18334c = c3385d;
            this.f18332a = c3383a;
            this.f18333b = c3383a2;
        }

        /* renamed from: a */
        double m14423a(C3383a c3383a) {
            C3383a c3383a2 = new C3383a(this.f18334c, this.f18333b.f18329a - this.f18332a.f18329a, this.f18333b.f18330b - this.f18332a.f18330b);
            C3383a c3383a3 = new C3383a(this.f18334c, c3383a.f18329a - this.f18332a.f18329a, c3383a.f18330b - this.f18332a.f18330b);
            return (c3383a2.f18329a * c3383a3.f18330b) - (c3383a2.f18330b * c3383a3.f18329a);
        }

        /* renamed from: b */
        boolean m14424b(C3383a c3383a) {
            return this.f18334c.m14426a(m14423a(c3383a)) == 0 && c3383a.f18329a < Math.max(this.f18332a.f18329a, this.f18333b.f18329a) + 1.0E-8d && c3383a.f18329a > Math.min(this.f18332a.f18329a, this.f18333b.f18329a) - 1.0E-8d && c3383a.f18330b < Math.max(this.f18332a.f18330b, this.f18333b.f18330b) + 1.0E-8d && c3383a.f18330b > Math.min(this.f18332a.f18330b, this.f18333b.f18330b) - 1.0E-8d;
        }
    }

    private C3385d() {
        int length = f18336b.length;
        this.f18338d = new LinkedList();
        for (int i = 0; i < length - 1; i++) {
            this.f18338d.add(new C3384b(this, new C3383a(this, f18336b[i] * 100000.0d, f18337c[i] * 100000.0d), new C3383a(this, f18336b[i + 1] * 100000.0d, f18337c[i + 1] * 100000.0d)));
        }
    }

    /* renamed from: a */
    public static C3385d m14425a() {
        if (f18335a == null) {
            f18335a = new C3385d();
        }
        return f18335a;
    }

    /* renamed from: a */
    int m14426a(double d) {
        return d < (-4487126258331716666) ? -1 : d > 1.0E-8d ? 1 : 0;
    }

    /* renamed from: a */
    public boolean m14427a(double d, double d2) {
        try {
            C3383a c3383a = new C3383a(this, 100000.0d * d, 100000.0d * d2);
            int i = 0;
            Iterator it = this.f18338d.iterator();
            while (it.hasNext()) {
                C3384b c3384b = (C3384b) it.next();
                if (c3384b.m14424b(c3383a)) {
                    return true;
                }
                int a = m14426a(c3384b.m14423a(c3383a));
                int a2 = m14426a(c3384b.f18332a.f18330b - c3383a.f18330b);
                int a3 = m14426a(c3384b.f18333b.f18330b - c3383a.f18330b);
                int i2 = (a <= 0 || a2 > 0 || a3 <= 0) ? i : i + 1;
                if (a < 0 && a3 <= 0 && a2 > 0) {
                    i2--;
                }
                i = i2;
            }
            return i != 0;
        } catch (Exception e) {
            return true;
        }
    }
}
