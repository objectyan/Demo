package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

/* compiled from: NaviAudioManager */
/* renamed from: com.baidu.carlife.core.audio.m */
public class NaviAudioManager extends AudioSourceManagerBase {
    /* renamed from: a */
    private static final String f3114a = (AudioUtil.f3010n + NaviAudioManager.class.getSimpleName());
    /* renamed from: b */
    private PCMPackageHead f3115b = new PCMPackageHead();
    /* renamed from: c */
    private byte[] f3116c = new byte[120];
    /* renamed from: d */
    private int f3117d;
    /* renamed from: e */
    private int f3118e;
    /* renamed from: f */
    private Pair f3119f = new Pair();
    /* renamed from: g */
    private ArrayAdd f3120g = new ArrayAdd();
    /* renamed from: h */
    private AESManager f3121h = new AESManager();

    public NaviAudioManager() {
        AudioUtil.m3882a();
        this.f3118e = 12;
    }

    /* renamed from: a */
    public synchronized void mo1448a(int sampleRate, int channelConfig, int sampleFormat) {
        if (AudioUtil.m3883h()) {
            int revisedSampleRate;
            int revisedChannelConfig;
            int revisedFormat;
            LogUtil.d(f3114a, "sampleRate: " + sampleRate + " channelConfig: " + channelConfig + " sampleFormat: " + sampleFormat);
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
            this.f3115b.m4053c(CommonParams.bv);
            this.f3117d = this.f3115b.m4050b(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3116c);
            this.f3115b.m4047a(this.f3117d);
            System.arraycopy(this.f3115b.m4048a(), 0, this.f3116c, 0, this.f3118e);
            m4034b(this.f3116c, this.f3118e + this.f3117d);
        }
    }

    /* renamed from: a */
    public synchronized void mo1434a() {
        if (AudioUtil.m3883h()) {
            this.f3115b.m4053c(CommonParams.bw);
            this.f3115b.m4047a(0);
            m4034b(this.f3115b.m4048a(), this.f3115b.m4049b());
        }
    }

    /* renamed from: a */
    public synchronized void mo1449a(byte[] ttsPCMData, int dataLen) {
        byte[] sendData = ttsPCMData;
        int sendLen = dataLen;
        if (EncryptSetupManager.m4120a().m4135c() && dataLen > 0) {
            sendData = this.f3121h.m4112a(ttsPCMData, dataLen);
            if (sendData == null) {
                LogUtil.m4445e(f3114a, "encrypt failed!");
            } else {
                sendLen = sendData.length;
            }
        }
        if (AudioUtil.m3883h()) {
            this.f3115b.m4053c(CommonParams.bx);
            this.f3115b.m4047a(sendLen);
            this.f3115b.m4052c();
            this.f3120g.m3909a(this.f3115b.m4048a(), this.f3118e, sendData, sendLen, this.f3119f);
            m4034b(this.f3119f.m4057a(), this.f3119f.m4058b());
        }
    }

    /* renamed from: b */
    private int m4034b(byte[] data, int size) {
        if (AudioUtil.m3882a().m3895g()) {
            return -1;
        }
        return ConnectManager.m4228a().m4247e(data, size);
    }
}
