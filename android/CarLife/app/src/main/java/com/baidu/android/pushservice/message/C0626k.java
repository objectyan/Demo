package com.baidu.android.pushservice.message;

import java.io.Serializable;

/* renamed from: com.baidu.android.pushservice.message.k */
public class C0626k implements Serializable {
    /* renamed from: a */
    private String f1969a;
    /* renamed from: b */
    private String f1970b;
    /* renamed from: c */
    private long f1971c;
    /* renamed from: d */
    private int f1972d;
    /* renamed from: e */
    private byte[] f1973e;
    /* renamed from: f */
    private long f1974f;
    /* renamed from: g */
    private long f1975g;
    /* renamed from: h */
    private long f1976h;
    /* renamed from: i */
    private boolean f1977i = false;

    /* renamed from: a */
    public void m2753a(int i) {
        this.f1972d = i;
    }

    /* renamed from: a */
    public void m2754a(long j) {
        this.f1974f = j;
    }

    /* renamed from: a */
    public void m2755a(String str) {
        this.f1969a = str;
    }

    /* renamed from: a */
    public void m2756a(boolean z) {
        this.f1977i = z;
    }

    /* renamed from: a */
    public void m2757a(byte[] bArr) {
        this.f1973e = bArr;
    }

    /* renamed from: a */
    public boolean m2758a() {
        return this.f1977i;
    }

    /* renamed from: b */
    public long m2759b() {
        return this.f1974f;
    }

    /* renamed from: b */
    public void m2760b(long j) {
        this.f1975g = j;
    }

    /* renamed from: b */
    public void m2761b(String str) {
        this.f1970b = str;
    }

    /* renamed from: c */
    public long m2762c() {
        return this.f1975g;
    }

    /* renamed from: c */
    public void m2763c(long j) {
        this.f1976h = j;
    }

    /* renamed from: d */
    public long m2764d() {
        return this.f1976h;
    }

    /* renamed from: d */
    public void m2765d(long j) {
        this.f1971c = j;
    }

    /* renamed from: e */
    public String m2766e() {
        return this.f1969a;
    }

    /* renamed from: f */
    public String m2767f() {
        return this.f1970b;
    }

    /* renamed from: g */
    public long m2768g() {
        return this.f1971c;
    }

    /* renamed from: h */
    public String m2769h() {
        return String.valueOf(this.f1971c);
    }

    /* renamed from: i */
    public int m2770i() {
        return this.f1972d;
    }

    /* renamed from: j */
    public byte[] m2771j() {
        return this.f1973e;
    }

    public String toString() {
        return "type:" + this.f1972d + " appid:" + this.f1969a + " msgId:" + this.f1971c + " isAlarm:  " + this.f1977i + " pkgName:  " + this.f1970b;
    }
}
