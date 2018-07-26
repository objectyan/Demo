package com.baidu.location.p194f;

import java.util.Locale;

/* renamed from: com.baidu.location.f.a */
public class C3362a {
    /* renamed from: a */
    public int f18200a;
    /* renamed from: b */
    public int f18201b;
    /* renamed from: c */
    public int f18202c;
    /* renamed from: d */
    public int f18203d;
    /* renamed from: e */
    public int f18204e;
    /* renamed from: f */
    public int f18205f;
    /* renamed from: g */
    public long f18206g;
    /* renamed from: h */
    public int f18207h;
    /* renamed from: i */
    public char f18208i;
    /* renamed from: j */
    public String f18209j;
    /* renamed from: k */
    private boolean f18210k;

    public C3362a() {
        this.f18200a = -1;
        this.f18201b = -1;
        this.f18202c = -1;
        this.f18203d = -1;
        this.f18204e = Integer.MAX_VALUE;
        this.f18205f = Integer.MAX_VALUE;
        this.f18206g = 0;
        this.f18207h = -1;
        this.f18208i = '0';
        this.f18209j = null;
        this.f18210k = false;
        this.f18206g = System.currentTimeMillis();
    }

    public C3362a(int i, int i2, int i3, int i4, int i5, char c) {
        this.f18200a = -1;
        this.f18201b = -1;
        this.f18202c = -1;
        this.f18203d = -1;
        this.f18204e = Integer.MAX_VALUE;
        this.f18205f = Integer.MAX_VALUE;
        this.f18206g = 0;
        this.f18207h = -1;
        this.f18208i = '0';
        this.f18209j = null;
        this.f18210k = false;
        this.f18200a = i;
        this.f18201b = i2;
        this.f18202c = i3;
        this.f18203d = i4;
        this.f18207h = i5;
        this.f18208i = c;
        this.f18206g = System.currentTimeMillis();
    }

    public C3362a(C3362a c3362a) {
        this(c3362a.f18200a, c3362a.f18201b, c3362a.f18202c, c3362a.f18203d, c3362a.f18207h, c3362a.f18208i);
        this.f18206g = c3362a.f18206g;
    }

    /* renamed from: a */
    public boolean m14246a() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f18206g > 0 && currentTimeMillis - this.f18206g < 3000;
    }

    /* renamed from: a */
    public boolean m14247a(C3362a c3362a) {
        return this.f18200a == c3362a.f18200a && this.f18201b == c3362a.f18201b && this.f18203d == c3362a.f18203d && this.f18202c == c3362a.f18202c;
    }

    /* renamed from: b */
    public boolean m14248b() {
        return this.f18200a > -1 && this.f18201b > 0;
    }

    /* renamed from: c */
    public boolean m14249c() {
        return this.f18200a == -1 && this.f18201b == -1 && this.f18203d == -1 && this.f18202c == -1;
    }

    /* renamed from: d */
    public boolean m14250d() {
        return this.f18200a > -1 && this.f18201b > -1 && this.f18203d == -1 && this.f18202c == -1;
    }

    /* renamed from: e */
    public boolean m14251e() {
        return this.f18200a > -1 && this.f18201b > -1 && this.f18203d > -1 && this.f18202c > -1;
    }

    /* renamed from: f */
    public void m14252f() {
        this.f18210k = true;
    }

    /* renamed from: g */
    public String m14253g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.f18201b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.f18200a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.f18203d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.f18202c + 203);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public String m14254h() {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", new Object[]{Integer.valueOf(this.f18202c), Integer.valueOf(this.f18203d), Integer.valueOf(this.f18200a), Integer.valueOf(this.f18201b)});
    }

    /* renamed from: i */
    public String m14255i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f18208i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(this.f18202c), Integer.valueOf(this.f18203d), Integer.valueOf(this.f18200a), Integer.valueOf(this.f18201b), Integer.valueOf(this.f18207h)}));
        if (this.f18210k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    /* renamed from: j */
    public String m14256j() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f18208i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", new Object[]{Integer.valueOf(this.f18202c), Integer.valueOf(this.f18203d), Integer.valueOf(this.f18200a), Integer.valueOf(this.f18201b), Integer.valueOf(this.f18207h)}));
        return stringBuffer.toString();
    }
}
