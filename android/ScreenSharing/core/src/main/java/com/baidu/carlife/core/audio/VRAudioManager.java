package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

/* compiled from: VRAudioManager */
/* renamed from: com.baidu.carlife.core.audio.q */
public class VRAudioManager extends AudioSourceManagerBase {
    /* renamed from: a */
    private static final String f3145a = (AudioUtil.f3010n + VRAudioManager.class.getSimpleName());
    /* renamed from: b */
    private PCMPackageHead f3146b = new PCMPackageHead();
    /* renamed from: c */
    private byte[] f3147c = new byte[120];
    /* renamed from: d */
    private int f3148d;
    /* renamed from: e */
    private int f3149e;
    /* renamed from: f */
    private Pair f3150f = new Pair();
    /* renamed from: g */
    private ArrayAdd f3151g = new ArrayAdd();
    /* renamed from: h */
    private AESManager f3152h = new AESManager();

    public VRAudioManager() {
        AudioUtil.m3882a();
        this.f3149e = 12;
    }

    /* renamed from: a */
    public synchronized void mo1448a(int sampleRate, int channelConfig, int sampleFormat) {
        if (AudioUtil.m3883h()) {
            int revisedSampleRate;
            int revisedChannelConfig;
            int revisedFormat;
            LogUtil.d(f3145a, "sampleRate: " + sampleRate + " channelConfig: " + channelConfig + " sampleFormat: " + sampleFormat);
            if (sampleRate < m_AppUI.MSG_APP_SAVESCREEN || sampleRate > 48000) {
                revisedSampleRate = 16000;
            } else {
                revisedSampleRate = sampleRate;
            }
            if (channelConfig == 1 && channelConfig == 2) {
                revisedChannelConfig = channelConfig;
            } else {
                revisedChannelConfig = 1;
            }
            if (sampleFormat == 8 && sampleFormat == 16) {
                revisedFormat = sampleFormat;
            } else {
                revisedFormat = 16;
            }
            this.f3146b.m4053c(CommonParams.bz);
            this.f3148d = this.f3146b.m4050b(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3147c);
            this.f3146b.m4047a(this.f3148d);
            System.arraycopy(this.f3146b.m4048a(), 0, this.f3147c, 0, this.f3149e);
            m4059b(this.f3147c, this.f3149e + this.f3148d);
        }
    }

    /* renamed from: a */
    public synchronized void mo1434a() {
        if (AudioUtil.m3883h()) {
            LogUtil.d(f3145a, "VR stop");
            this.f3146b.m4053c(CommonParams.bB);
            this.f3146b.m4047a(0);
            m4059b(this.f3146b.m4048a(), this.f3146b.m4049b());
        }
    }

    /* renamed from: a */
    public synchronized void mo1449a(byte[] data, int len) {
        byte[] sendData = data;
        int sendLen = len;
        if (EncryptSetupManager.m4120a().m4135c() && len > 0) {
            sendData = this.f3152h.m4112a(data, len);
            if (sendData == null) {
                LogUtil.m4445e(f3145a, "encrypt failed!");
            } else {
                sendLen = sendData.length;
            }
        }
        if (AudioUtil.m3883h()) {
            LogUtil.d(f3145a, "VR write " + sendLen);
            this.f3146b.m4053c(CommonParams.bA);
            this.f3146b.m4047a(sendLen);
            this.f3146b.m4052c();
            this.f3151g.m3909a(this.f3146b.m4048a(), this.f3149e, sendData, sendLen, this.f3150f);
            m4059b(this.f3150f.m4057a(), this.f3150f.m4058b());
        }
    }

    /* renamed from: b */
    private int m4059b(byte[] data, int size) {
        if (AudioUtil.m3882a().m3895g()) {
            return -1;
        }
        return ConnectManager.m4228a().m4251g(data, size);
    }
}
