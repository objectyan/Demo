package com.baidu.android.pushservice.message;

/* renamed from: com.baidu.android.pushservice.message.e */
public class C0619e {
    /* renamed from: a */
    protected short f1933a;
    /* renamed from: b */
    protected short f1934b;
    /* renamed from: c */
    protected byte[] f1935c;
    /* renamed from: d */
    protected boolean f1936d;
    /* renamed from: e */
    protected boolean f1937e = false;
    /* renamed from: f */
    protected boolean f1938f;
    /* renamed from: g */
    private C0626k f1939g;

    public C0619e(short s) {
        this.f1933a = s;
    }

    /* renamed from: a */
    public void m2720a(C0626k c0626k) {
        this.f1939g = c0626k;
    }

    /* renamed from: a */
    public void m2721a(boolean z) {
        this.f1938f = z;
    }

    /* renamed from: a */
    public byte[] m2722a() {
        return this.f1935c;
    }

    /* renamed from: b */
    public boolean m2723b() {
        return this.f1936d;
    }

    /* renamed from: c */
    public boolean m2724c() {
        return this.f1938f;
    }

    /* renamed from: d */
    public C0626k m2725d() {
        return this.f1939g;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append(this.f1933a);
        stringBuffer.append(", version: ");
        stringBuffer.append(this.f1934b);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f1936d);
        return stringBuffer.toString();
    }
}
