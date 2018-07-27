package me.objectyan.screensharing.util;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.connect.config.AESManager;
import me.objectyan.screensharing.core.connect.config.DebugLogUtil;
import me.objectyan.screensharing.core.connect.config.EncryptSetupManager;
import me.objectyan.screensharing.core.connect.config.IConfigSyncDone;


public class CarlifeCoreEncrypt {

    private static final String Tag = me.objectyan.screensharing.util.CarlifeCoreEncrypt.class.getSimpleName();

    private static me.objectyan.screensharing.util.CarlifeCoreEncrypt sCarlifeCoreEncrypt;

    private AESManager mAESManager;

    private CarlifeCoreEncrypt() {
    }


    public static me.objectyan.screensharing.util.CarlifeCoreEncrypt newInstance() {
        if (sCarlifeCoreEncrypt == null) {
            sCarlifeCoreEncrypt = new me.objectyan.screensharing.util.CarlifeCoreEncrypt();
        }
        return sCarlifeCoreEncrypt;
    }


    public void m6097b() {
        EncryptSetupManager.newInstance();
        DebugLogUtil.newInstance().setContext(AppContext.getAppContext());
    }


    public void m6095a(boolean flag) {
        EncryptSetupManager.newInstance().m4132a(flag);
    }


    public boolean m6099c() {
        return EncryptSetupManager.newInstance().m4134b();
    }


    public boolean getFlag() {
        return EncryptSetupManager.newInstance().getFlag();
    }


    public void m6094a(IConfigSyncDone syncDone) {
        EncryptSetupManager.newInstance().m4130a(syncDone);
    }


    public void m6101e() {
        EncryptSetupManager.newInstance().m4137e();
    }


    public byte[] encrypt(byte[] rawData, int len) {
        if (this.mAESManager == null) {
            this.mAESManager = new AESManager();
        }
        return this.mAESManager.encrypt(rawData, len);
    }


    public byte[] decrypt(byte[] encryptData, int len) {
        if (this.mAESManager == null) {
            this.mAESManager = new AESManager();
        }
        return this.mAESManager.decrypt(encryptData, len);
    }
}
