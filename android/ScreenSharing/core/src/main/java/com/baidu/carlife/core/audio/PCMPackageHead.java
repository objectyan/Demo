package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit;
import java.util.Arrays;

/* compiled from: PCMPackageHead */
/* renamed from: com.baidu.carlife.core.audio.o */
public class PCMPackageHead {
    /* renamed from: a */
    private static final String f3138a = (AudioUtil.AUDIO + PCMPackageHead.class.getSimpleName());
    /* renamed from: b */
    private byte[] f3139b;
    /* renamed from: c */
    private int f3140c;
    /* renamed from: d */
    private int f3141d;
    /* renamed from: e */
    private AESManager f3142e = new AESManager();

    public PCMPackageHead() {
        AudioUtil.newInstance();
        this.f3140c = 12;
        AudioUtil.newInstance();
        this.f3141d = 12;
        this.f3139b = new byte[this.f3140c];
    }

    /* renamed from: a */
    public byte[] m4048a() {
        return this.f3139b;
    }

    /* renamed from: b */
    public int m4049b() {
        return this.f3140c;
    }

    /* renamed from: a */
    public void m4047a(int dataLen) {
        this.f3139b[0] = (byte) ((dataLen >> 24) & 255);
        this.f3139b[1] = (byte) ((dataLen >> 16) & 255);
        this.f3139b[2] = (byte) ((dataLen >> 8) & 255);
        this.f3139b[3] = (byte) (dataLen & 255);
    }

    /* renamed from: b */
    public void m4051b(int timeStamp) {
        this.f3139b[4] = (byte) ((timeStamp >> 24) & 255);
        this.f3139b[5] = (byte) ((timeStamp >> 16) & 255);
        this.f3139b[6] = (byte) ((timeStamp >> 8) & 255);
        this.f3139b[7] = (byte) (timeStamp & 255);
    }

    /* renamed from: c */
    public void m4052c() {
        int systemTimeLow32Bits = (int) (-1 & System.currentTimeMillis());
        this.f3139b[4] = (byte) ((systemTimeLow32Bits >> 24) & 255);
        this.f3139b[5] = (byte) ((systemTimeLow32Bits >> 16) & 255);
        this.f3139b[6] = (byte) ((systemTimeLow32Bits >> 8) & 255);
        this.f3139b[7] = (byte) (systemTimeLow32Bits & 255);
    }

    /* renamed from: c */
    public void m4053c(int type) {
        this.f3139b[8] = (byte) ((type >> 24) & 255);
        this.f3139b[9] = (byte) ((type >> 16) & 255);
        this.f3139b[10] = (byte) ((type >> 8) & 255);
        this.f3139b[11] = (byte) (type & 255);
    }

    /* renamed from: a */
    public int m4046a(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        Builder builder = CarlifeMusicInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        byte[] initParameter = builder.build().toByteArray();
        byte[] encryptData = initParameter;
        if (EncryptSetupManager.newInstance().getFlag() && initParameter.length > 0) {
            encryptData = this.f3142e.m4112a(initParameter, initParameter.length);
            if (encryptData == null) {
                LogUtil.e(f3138a, "encrypt failed!");
                return -1;
            }
        }
        System.arraycopy(encryptData, 0, byteData, this.f3140c, byteData.length > encryptData.length ? encryptData.length : byteData.length);
        if (encryptData.length > byteData.length) {
            LogUtil.d(f3138a, "initParameter.length>byteData.length!!");
        }
        LogUtil.d(f3138a, "byteData:" + Arrays.toString(byteData));
        return encryptData.length;
    }

    /* renamed from: b */
    public int m4050b(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        CarlifeTTSInit.Builder builder = CarlifeTTSInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        byte[] initParamter = builder.build().toByteArray();
        byte[] encryptData = initParamter;
        if (EncryptSetupManager.newInstance().getFlag() && initParamter.length > 0) {
            encryptData = this.f3142e.m4112a(initParamter, initParamter.length);
            if (encryptData == null) {
                LogUtil.e(f3138a, "encrypt failed!");
                return -1;
            }
        }
        System.arraycopy(encryptData, 0, byteData, this.f3141d, encryptData.length);
        return encryptData.length;
    }
}
