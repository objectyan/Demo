package com.baidu.carlife.p087l;

import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.connect.p070a.C1199a;
import com.baidu.carlife.core.connect.p070a.C1200b;
import com.baidu.carlife.core.connect.p070a.C1203c;
import com.baidu.carlife.core.connect.p070a.C1208e;

/* compiled from: CarlifeCoreEncrypt */
/* renamed from: com.baidu.carlife.l.c */
public class C1666c {
    /* renamed from: a */
    private static final String f5146a = C1666c.class.getSimpleName();
    /* renamed from: b */
    private static C1666c f5147b;
    /* renamed from: c */
    private C1200b f5148c;

    private C1666c() {
    }

    /* renamed from: a */
    public static C1666c m6093a() {
        if (f5147b == null) {
            f5147b = new C1666c();
        }
        return f5147b;
    }

    /* renamed from: b */
    public void m6097b() {
        C1208e.m4120a();
        C1203c.m4115a().m4116a(C1157a.m3876a());
    }

    /* renamed from: a */
    public void m6095a(boolean flag) {
        C1208e.m4120a().m4132a(flag);
    }

    /* renamed from: c */
    public boolean m6099c() {
        return C1208e.m4120a().m4134b();
    }

    /* renamed from: d */
    public boolean m6100d() {
        return C1208e.m4120a().m4135c();
    }

    /* renamed from: a */
    public void m6094a(C1199a syncDone) {
        C1208e.m4120a().m4130a(syncDone);
    }

    /* renamed from: e */
    public void m6101e() {
        C1208e.m4120a().m4137e();
    }

    /* renamed from: a */
    public byte[] m6096a(byte[] rawData, int len) {
        if (this.f5148c == null) {
            this.f5148c = new C1200b();
        }
        return this.f5148c.m4112a(rawData, len);
    }

    /* renamed from: b */
    public byte[] m6098b(byte[] encryptData, int len) {
        if (this.f5148c == null) {
            this.f5148c = new C1200b();
        }
        return this.f5148c.m4113b(encryptData, len);
    }
}
