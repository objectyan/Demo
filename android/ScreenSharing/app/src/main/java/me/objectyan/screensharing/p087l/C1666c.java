package com.baidu.carlife.p087l;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.connect.config.IConfigSyncDone;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.DebugLogUtil;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

/* compiled from: CarlifeCoreEncrypt */
/* renamed from: com.baidu.carlife.l.c */
public class C1666c {
    /* renamed from: a */
    private static final String f5146a = C1666c.class.getSimpleName();
    /* renamed from: b */
    private static C1666c f5147b;
    /* renamed from: c */
    private AESManager f5148c;

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
        EncryptSetupManager.m4120a();
        DebugLogUtil.m4115a().m4116a(AppContext.m3876a());
    }

    /* renamed from: a */
    public void m6095a(boolean flag) {
        EncryptSetupManager.m4120a().m4132a(flag);
    }

    /* renamed from: c */
    public boolean m6099c() {
        return EncryptSetupManager.m4120a().m4134b();
    }

    /* renamed from: d */
    public boolean m6100d() {
        return EncryptSetupManager.m4120a().m4135c();
    }

    /* renamed from: a */
    public void m6094a(IConfigSyncDone syncDone) {
        EncryptSetupManager.m4120a().m4130a(syncDone);
    }

    /* renamed from: e */
    public void m6101e() {
        EncryptSetupManager.m4120a().m4137e();
    }

    /* renamed from: a */
    public byte[] m6096a(byte[] rawData, int len) {
        if (this.f5148c == null) {
            this.f5148c = new AESManager();
        }
        return this.f5148c.m4112a(rawData, len);
    }

    /* renamed from: b */
    public byte[] m6098b(byte[] encryptData, int len) {
        if (this.f5148c == null) {
            this.f5148c = new AESManager();
        }
        return this.f5148c.m4113b(encryptData, len);
    }
}
