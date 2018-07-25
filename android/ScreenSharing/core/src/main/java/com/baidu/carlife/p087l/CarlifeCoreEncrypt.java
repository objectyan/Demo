package com.baidu.carlife.p087l;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.connect.config.IConfigSyncDone;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.DebugLogUtil;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

/* compiled from: CarlifeCoreEncrypt */
/* renamed from: com.baidu.carlife.l.c */
public class CarlifeCoreEncrypt {
    /* renamed from: a */
    private static final String f5146a = com.baidu.carlife.p087l.CarlifeCoreEncrypt.class.getSimpleName();
    /* renamed from: b */
    private static com.baidu.carlife.p087l.CarlifeCoreEncrypt f5147b;
    /* renamed from: c */
    private AESManager f5148c;

    private CarlifeCoreEncrypt() {
    }

    /* renamed from: a */
    public static com.baidu.carlife.p087l.CarlifeCoreEncrypt m6093a() {
        if (f5147b == null) {
            f5147b = new com.baidu.carlife.p087l.CarlifeCoreEncrypt();
        }
        return f5147b;
    }

    /* renamed from: b */
    public void m6097b() {
        EncryptSetupManager.newInstance();
        DebugLogUtil.m4115a().m4116a(AppContext.getAppContext());
    }

    /* renamed from: a */
    public void m6095a(boolean flag) {
        EncryptSetupManager.newInstance().m4132a(flag);
    }

    /* renamed from: c */
    public boolean m6099c() {
        return EncryptSetupManager.newInstance().m4134b();
    }

    /* renamed from: d */
    public boolean m6100d() {
        return EncryptSetupManager.newInstance().getFlag();
    }

    /* renamed from: a */
    public void m6094a(IConfigSyncDone syncDone) {
        EncryptSetupManager.newInstance().m4130a(syncDone);
    }

    /* renamed from: e */
    public void m6101e() {
        EncryptSetupManager.newInstance().m4137e();
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
