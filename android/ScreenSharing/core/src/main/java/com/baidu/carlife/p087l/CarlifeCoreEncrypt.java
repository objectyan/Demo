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
    private static final String Tag = com.baidu.carlife.p087l.CarlifeCoreEncrypt.class.getSimpleName();
    /* renamed from: b */
    private static com.baidu.carlife.p087l.CarlifeCoreEncrypt sCarlifeCoreEncrypt;
    /* renamed from: c */
    private AESManager mAESManager;

    private CarlifeCoreEncrypt() {
    }

    /* renamed from: a */
    public static com.baidu.carlife.p087l.CarlifeCoreEncrypt newInstance() {
        if (sCarlifeCoreEncrypt == null) {
            sCarlifeCoreEncrypt = new com.baidu.carlife.p087l.CarlifeCoreEncrypt();
        }
        return sCarlifeCoreEncrypt;
    }

    /* renamed from: b */
    public void m6097b() {
        EncryptSetupManager.newInstance();
        DebugLogUtil.newInstance().setContext(AppContext.getAppContext());
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
    public boolean getFlag() {
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
    public byte[] encrypt(byte[] rawData, int len) {
        if (this.mAESManager == null) {
            this.mAESManager = new AESManager();
        }
        return this.mAESManager.encrypt(rawData, len);
    }

    /* renamed from: b */
    public byte[] decrypt(byte[] encryptData, int len) {
        if (this.mAESManager == null) {
            this.mAESManager = new AESManager();
        }
        return this.mAESManager.decrypt(encryptData, len);
    }
}
