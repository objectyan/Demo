package com.baidu.android.pushservice.p029h;

import android.text.TextUtils;

/* renamed from: com.baidu.android.pushservice.h.e */
public class C0538e {
    /* renamed from: a */
    public String f1765a;
    /* renamed from: b */
    public int f1766b;
    /* renamed from: c */
    public int f1767c;
    /* renamed from: d */
    private int f1768d;
    /* renamed from: e */
    private String f1769e;
    /* renamed from: f */
    private long f1770f;
    /* renamed from: g */
    private String f1771g;
    /* renamed from: h */
    private int f1772h;
    /* renamed from: i */
    private String f1773i;
    /* renamed from: j */
    private int f1774j;
    /* renamed from: k */
    private String f1775k;
    /* renamed from: l */
    private String f1776l;
    /* renamed from: m */
    private int f1777m;
    /* renamed from: n */
    private int f1778n;
    /* renamed from: o */
    private String f1779o;
    /* renamed from: p */
    private String f1780p;
    /* renamed from: q */
    private String f1781q;
    /* renamed from: r */
    private String f1782r;

    /* renamed from: a */
    public String m2278a() {
        return this.f1769e;
    }

    /* renamed from: a */
    public void m2279a(int i) {
        this.f1768d = i;
    }

    /* renamed from: a */
    public void m2280a(long j) {
        this.f1770f = j;
    }

    /* renamed from: a */
    public void m2281a(String str) {
        this.f1769e = str;
    }

    /* renamed from: b */
    public String m2282b() {
        return this.f1782r;
    }

    /* renamed from: b */
    public void m2283b(int i) {
        this.f1772h = i;
    }

    /* renamed from: b */
    public void m2284b(String str) {
        this.f1771g = str;
    }

    /* renamed from: c */
    public C0535n m2285c() {
        return new C0535n(this.f1769e, this.f1770f, this.f1771g, this.f1778n, this.f1779o);
    }

    /* renamed from: c */
    public void m2286c(int i) {
        this.f1774j = i;
    }

    /* renamed from: c */
    public void m2287c(String str) {
        this.f1773i = str;
    }

    /* renamed from: d */
    public C0543i m2288d() {
        C0543i c0543i = new C0543i(m2285c());
        c0543i.f1794a = this.f1777m;
        c0543i.i = this.f1775k;
        c0543i.f1795b = this.f1773i;
        c0543i.f1796c = this.f1781q;
        return c0543i;
    }

    /* renamed from: d */
    public void m2289d(int i) {
        this.f1777m = i;
    }

    /* renamed from: d */
    public void m2290d(String str) {
        this.f1775k = str;
    }

    /* renamed from: e */
    public C0545k m2291e() {
        C0545k c0545k = new C0545k(m2285c());
        c0545k.f1805c = this.f1772h;
        c0545k.f1803a = this.f1773i;
        c0545k.f1804b = this.f1774j;
        Object obj = this.f1781q;
        if (!TextUtils.isEmpty(obj)) {
            c0545k.f1806k = obj;
        }
        return c0545k;
    }

    /* renamed from: e */
    public void m2292e(int i) {
        this.f1778n = i;
    }

    /* renamed from: e */
    public void m2293e(String str) {
        this.f1776l = str;
    }

    /* renamed from: f */
    public C0536b m2294f() {
        C0536b c0536b = new C0536b(m2285c());
        c0536b.f1755a = this.f1775k;
        c0536b.f1756b = this.f1776l;
        c0536b.f1757c = this.f1780p;
        return c0536b;
    }

    /* renamed from: f */
    public void m2295f(int i) {
        this.f1766b = i;
    }

    /* renamed from: f */
    public void m2296f(String str) {
        this.f1779o = str;
    }

    /* renamed from: g */
    public C0539f m2297g() {
        C0539f c0539f = new C0539f(m2285c());
        c0539f.f1783a = this.f1775k;
        return c0539f;
    }

    /* renamed from: g */
    public void m2298g(int i) {
        this.f1767c = i;
    }

    /* renamed from: g */
    public void m2299g(String str) {
        this.f1780p = str;
    }

    /* renamed from: h */
    public C0542h m2300h() {
        C0542h c0542h = new C0542h(m2285c());
        c0542h.j = this.f1782r;
        c0542h.f1791a = this.f1765a;
        c0542h.f1792b = this.f1766b;
        c0542h.f1793c = this.f1767c;
        return c0542h;
    }

    /* renamed from: h */
    public void m2301h(String str) {
        this.f1782r = str;
    }

    /* renamed from: i */
    public void m2302i(String str) {
        this.f1781q = str;
    }

    /* renamed from: j */
    public void m2303j(String str) {
        this.f1765a = str;
    }
}
