package com.baidu.che.codriver.vr.record.aec;

import com.baidu.che.codriver.vr.record.C1749d;

/* compiled from: InsideRecordTool */
/* renamed from: com.baidu.che.codriver.vr.record.aec.c */
public class C2860c implements C1749d {
    /* renamed from: a */
    private C2861d f9362a;

    /* renamed from: a */
    public int mo1631a(byte[] inputData) {
        return -1;
    }

    /* renamed from: a */
    public void mo1632a() {
        if (this.f9362a != null && this.f9362a.isAlive()) {
            this.f9362a.m10827a();
        }
    }

    /* renamed from: b */
    public void mo1634b() {
        if (this.f9362a != null && this.f9362a.isAlive()) {
            this.f9362a.m10828b();
        }
    }

    /* renamed from: c */
    public void mo1635c() {
        if (this.f9362a == null || !this.f9362a.isAlive()) {
            this.f9362a = new C2861d();
        }
    }
}
