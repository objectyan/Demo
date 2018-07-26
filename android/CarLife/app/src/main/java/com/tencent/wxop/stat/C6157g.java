package com.tencent.wxop.stat;

/* renamed from: com.tencent.wxop.stat.g */
public class C6157g implements Cloneable {
    /* renamed from: a */
    private String f25076a = "";
    /* renamed from: b */
    private String f25077b = "";
    /* renamed from: c */
    private String f25078c = "";

    public C6157g(String str, String str2, String str3) {
        this.f25077b = str;
        this.f25076a = str2;
        this.f25078c = str3;
    }

    /* renamed from: a */
    public String m22051a() {
        return this.f25076a;
    }

    /* renamed from: a */
    public void m22052a(String str) {
        this.f25076a = str;
    }

    /* renamed from: b */
    public String m22053b() {
        return this.f25077b;
    }

    /* renamed from: b */
    public void m22054b(String str) {
        this.f25077b = str;
    }

    /* renamed from: c */
    public String m22055c() {
        return this.f25078c;
    }

    /* renamed from: c */
    public void m22056c(String str) {
        this.f25078c = str;
    }

    public /* synthetic */ Object clone() {
        return m22057d();
    }

    /* renamed from: d */
    public C6157g m22057d() {
        try {
            return (C6157g) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        return "StatGameUser [worldName=" + this.f25076a + ", account=" + this.f25077b + ", level=" + this.f25078c + "]";
    }
}
