package com.tencent.wxop.stat;

/* renamed from: com.tencent.wxop.stat.e */
public class C6155e implements Cloneable {
    /* renamed from: a */
    public static final int f25020a = 0;
    /* renamed from: b */
    public static final int f25021b = 1;
    /* renamed from: c */
    public static final int f25022c = 2;
    /* renamed from: d */
    private String f25023d = null;
    /* renamed from: e */
    private long f25024e = 0;
    /* renamed from: f */
    private long f25025f = 0;
    /* renamed from: g */
    private int f25026g = 0;
    /* renamed from: h */
    private long f25027h = 0;
    /* renamed from: i */
    private int f25028i = 0;
    /* renamed from: j */
    private int f25029j = 1;

    public C6155e(String str) {
        this.f25023d = str;
    }

    public C6155e(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f25023d = str;
        this.f25024e = j;
        this.f25025f = j2;
        this.f25026g = i;
        this.f25027h = j3;
        this.f25028i = i2;
        this.f25029j = i3;
    }

    /* renamed from: a */
    public String m21951a() {
        return this.f25023d;
    }

    /* renamed from: a */
    public void m21952a(int i) {
        this.f25026g = i;
    }

    /* renamed from: a */
    public void m21953a(long j) {
        this.f25024e = j;
    }

    /* renamed from: a */
    public void m21954a(String str) {
        this.f25023d = str;
    }

    /* renamed from: b */
    public long m21955b() {
        return this.f25024e;
    }

    /* renamed from: b */
    public void m21956b(int i) {
        this.f25028i = i;
    }

    /* renamed from: b */
    public void m21957b(long j) {
        this.f25025f = j;
    }

    /* renamed from: c */
    public long m21958c() {
        return this.f25025f;
    }

    /* renamed from: c */
    public void m21959c(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f25029j = i;
    }

    /* renamed from: c */
    public void m21960c(long j) {
        this.f25027h = j;
    }

    public /* synthetic */ Object clone() {
        return m21965h();
    }

    /* renamed from: d */
    public int m21961d() {
        return this.f25026g;
    }

    /* renamed from: e */
    public long m21962e() {
        return this.f25027h;
    }

    /* renamed from: f */
    public int m21963f() {
        return this.f25028i;
    }

    /* renamed from: g */
    public int m21964g() {
        return this.f25029j;
    }

    /* renamed from: h */
    public C6155e m21965h() {
        try {
            return (C6155e) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
