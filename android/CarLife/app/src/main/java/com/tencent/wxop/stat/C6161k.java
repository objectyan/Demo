package com.tencent.wxop.stat;

/* renamed from: com.tencent.wxop.stat.k */
public class C6161k {
    /* renamed from: a */
    private String f25108a = null;
    /* renamed from: b */
    private String f25109b = null;
    /* renamed from: c */
    private String f25110c = null;
    /* renamed from: d */
    private boolean f25111d = false;
    /* renamed from: e */
    private boolean f25112e = false;

    /* renamed from: a */
    public void m22150a(String str) {
        this.f25110c = str;
    }

    /* renamed from: a */
    public void m22151a(boolean z) {
        this.f25111d = z;
    }

    /* renamed from: a */
    public boolean m22152a() {
        return this.f25111d;
    }

    /* renamed from: b */
    public String m22153b() {
        return this.f25110c;
    }

    /* renamed from: b */
    public void m22154b(String str) {
        this.f25108a = str;
    }

    /* renamed from: b */
    public void m22155b(boolean z) {
        this.f25112e = z;
    }

    /* renamed from: c */
    public String m22156c() {
        return this.f25108a;
    }

    /* renamed from: c */
    public void m22157c(String str) {
        this.f25109b = str;
    }

    /* renamed from: d */
    public String m22158d() {
        return this.f25109b;
    }

    /* renamed from: e */
    public boolean m22159e() {
        return this.f25112e;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f25108a + ", installChannel=" + this.f25109b + ", version=" + this.f25110c + ", sendImmediately=" + this.f25111d + ", isImportant=" + this.f25112e + "]";
    }
}
