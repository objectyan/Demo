package com.baidu.carlife.logic;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.audio.C1163a;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit;
import java.util.Arrays;

/* compiled from: PCMPackageHeadVR */
/* renamed from: com.baidu.carlife.logic.p */
public class C1857p {
    /* renamed from: a */
    public static final int f5737a = 12;
    /* renamed from: b */
    public static final int f5738b = 12;
    /* renamed from: c */
    private static final String f5739c = (C1163a.f3010n + C1857p.class.getSimpleName());
    /* renamed from: d */
    private byte[] f5740d = new byte[this.f5741e];
    /* renamed from: e */
    private int f5741e = 12;
    /* renamed from: f */
    private int f5742f = 12;

    /* renamed from: a */
    public byte[] m7050a() {
        return this.f5740d;
    }

    /* renamed from: b */
    public int m7051b() {
        return this.f5741e;
    }

    /* renamed from: a */
    public void m7049a(int dataLen) {
        this.f5740d[0] = (byte) ((dataLen >> 24) & 255);
        this.f5740d[1] = (byte) ((dataLen >> 16) & 255);
        this.f5740d[2] = (byte) ((dataLen >> 8) & 255);
        this.f5740d[3] = (byte) (dataLen & 255);
    }

    /* renamed from: b */
    public void m7053b(int timeStamp) {
        this.f5740d[4] = (byte) ((timeStamp >> 24) & 255);
        this.f5740d[5] = (byte) ((timeStamp >> 16) & 255);
        this.f5740d[6] = (byte) ((timeStamp >> 8) & 255);
        this.f5740d[7] = (byte) (timeStamp & 255);
    }

    /* renamed from: c */
    public void m7054c() {
        int systemTimeLow32Bits = (int) (-1 & System.currentTimeMillis());
        this.f5740d[4] = (byte) ((systemTimeLow32Bits >> 24) & 255);
        this.f5740d[5] = (byte) ((systemTimeLow32Bits >> 16) & 255);
        this.f5740d[6] = (byte) ((systemTimeLow32Bits >> 8) & 255);
        this.f5740d[7] = (byte) (systemTimeLow32Bits & 255);
    }

    /* renamed from: c */
    public void m7055c(int type) {
        this.f5740d[8] = (byte) ((type >> 24) & 255);
        this.f5740d[9] = (byte) ((type >> 16) & 255);
        this.f5740d[10] = (byte) ((type >> 8) & 255);
        this.f5740d[11] = (byte) (type & 255);
    }

    /* renamed from: a */
    public int m7048a(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        Builder builder = CarlifeMusicInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        CarlifeMusicInit musicAudioTrackInitParameter = builder.build();
        byte[] initParameter = musicAudioTrackInitParameter.toByteArray();
        System.arraycopy(initParameter, 0, byteData, this.f5741e, byteData.length > initParameter.length ? initParameter.length : byteData.length);
        if (initParameter.length > byteData.length) {
            C1260i.m4435b(f5739c, "initParameter.length>byteData.length!!");
        }
        C1260i.m4435b(f5739c, "byteData:" + Arrays.toString(byteData));
        return musicAudioTrackInitParameter.getSerializedSize();
    }

    /* renamed from: b */
    public int m7052b(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        CarlifeTTSInit.Builder builder = CarlifeTTSInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        CarlifeTTSInit ttsAudioTrackInitParameter = builder.build();
        System.arraycopy(ttsAudioTrackInitParameter.toByteArray(), 0, byteData, this.f5742f, ttsAudioTrackInitParameter.toByteArray().length);
        return ttsAudioTrackInitParameter.getSerializedSize();
    }
}
