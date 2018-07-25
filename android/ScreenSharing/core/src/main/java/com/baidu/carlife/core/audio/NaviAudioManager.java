package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

/* compiled from: NaviAudioManager */
/* renamed from: com.baidu.carlife.core.audio.m */
public class NaviAudioManager extends AudioSourceManagerBase {
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + NaviAudioManager.class.getSimpleName());
    /* renamed from: b */
    private PCMPackageHead mPCMPackageHead = new PCMPackageHead();
    /* renamed from: c */
    private byte[] f3116c = new byte[120];
    /* renamed from: d */
    private int f3117d;
    /* renamed from: e */
    private int f3118e;
    /* renamed from: f */
    private Pair f3119f = new Pair();
    /* renamed from: g */
    private ArrayAdd mArrayAdd = new ArrayAdd();
    /* renamed from: h */
    private AESManager mAESManager = new AESManager();

    public NaviAudioManager() {
        AudioUtil.newInstance();
        this.f3118e = 12;
    }

    /* renamed from: a */
    public synchronized void send(int sampleRate, int channelConfig, int sampleFormat) {
        if (AudioUtil.getIs()) {
            int revisedSampleRate;
            int revisedChannelConfig;
            int revisedFormat;
            LogUtil.d(Tag, "sampleRate: " + sampleRate + " channelConfig: " + channelConfig + " sampleFormat: " + sampleFormat);
            if (sampleRate < 4000 || sampleRate > 48000) {
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
            this.mPCMPackageHead.m4053c(CommonParams.bv);
            this.f3117d = this.mPCMPackageHead.m4050b(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3116c);
            this.mPCMPackageHead.m4047a(this.f3117d);
            System.arraycopy(this.mPCMPackageHead.m4048a(), 0, this.f3116c, 0, this.f3118e);
            writeTTS(this.f3116c, this.f3118e + this.f3117d);
        }
    }

    /* renamed from: a */
    public synchronized void send() {
        if (AudioUtil.getIs()) {
            this.mPCMPackageHead.m4053c(CommonParams.bw);
            this.mPCMPackageHead.m4047a(0);
            writeTTS(this.mPCMPackageHead.m4048a(), this.mPCMPackageHead.m4049b());
        }
    }

    /* renamed from: a */
    public synchronized void send(byte[] ttsPCMData, int dataLen) {
        byte[] sendData = ttsPCMData;
        int sendLen = dataLen;
        if (EncryptSetupManager.newInstance().getFlag() && dataLen > 0) {
            sendData = this.mAESManager.m4112a(ttsPCMData, dataLen);
            if (sendData == null) {
                LogUtil.e(Tag, "encrypt failed!");
            } else {
                sendLen = sendData.length;
            }
        }
        if (AudioUtil.getIs()) {
            this.mPCMPackageHead.m4053c(CommonParams.bx);
            this.mPCMPackageHead.m4047a(sendLen);
            this.mPCMPackageHead.m4052c();
            this.mArrayAdd.merge(this.mPCMPackageHead.m4048a(), this.f3118e, sendData, sendLen, this.f3119f);
            writeTTS(this.f3119f.getData(), this.f3119f.getSize());
        }
    }

    /* renamed from: b */
    private int writeTTS(byte[] data, int size) {
        if (AudioUtil.newInstance().isBlueToothMode()) {
            return -1;
        }
        return ConnectManager.newInstance().writeTTS(data, size);
    }
}
