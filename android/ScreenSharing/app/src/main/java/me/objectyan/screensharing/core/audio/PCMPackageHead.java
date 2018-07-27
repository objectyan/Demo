package me.objectyan.screensharing.core.audio;

import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.connect.config.AESManager;
import me.objectyan.screensharing.core.connect.config.EncryptSetupManager;
import me.objectyan.screensharing.protobuf.CarlifeMusicInitProto.CarlifeMusicInit;
import me.objectyan.screensharing.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder;
import me.objectyan.screensharing.protobuf.CarlifeTTSInitProto.CarlifeTTSInit;

import java.util.Arrays;


public class PCMPackageHead {

    private static final String Tag = (AudioUtil.AUDIO + PCMPackageHead.class.getSimpleName());

    private byte[] f3139b;

    private int f3140c;

    private int f3141d;

    private AESManager mAESManager = new AESManager();

    public PCMPackageHead() {
        AudioUtil.newInstance();
        this.f3140c = 12;
        AudioUtil.newInstance();
        this.f3141d = 12;
        this.f3139b = new byte[this.f3140c];
    }


    public byte[] m4048a() {
        return this.f3139b;
    }


    public int m4049b() {
        return this.f3140c;
    }


    public void m4047a(int dataLen) {
        this.f3139b[0] = (byte) ((dataLen >> 24) & 255);
        this.f3139b[1] = (byte) ((dataLen >> 16) & 255);
        this.f3139b[2] = (byte) ((dataLen >> 8) & 255);
        this.f3139b[3] = (byte) (dataLen & 255);
    }


    public void m4051b(int timeStamp) {
        this.f3139b[4] = (byte) ((timeStamp >> 24) & 255);
        this.f3139b[5] = (byte) ((timeStamp >> 16) & 255);
        this.f3139b[6] = (byte) ((timeStamp >> 8) & 255);
        this.f3139b[7] = (byte) (timeStamp & 255);
    }


    public void m4052c() {
        int systemTimeLow32Bits = (int) (-1 & System.currentTimeMillis());
        this.f3139b[4] = (byte) ((systemTimeLow32Bits >> 24) & 255);
        this.f3139b[5] = (byte) ((systemTimeLow32Bits >> 16) & 255);
        this.f3139b[6] = (byte) ((systemTimeLow32Bits >> 8) & 255);
        this.f3139b[7] = (byte) (systemTimeLow32Bits & 255);
    }


    public void m4053c(int type) {
        this.f3139b[8] = (byte) ((type >> 24) & 255);
        this.f3139b[9] = (byte) ((type >> 16) & 255);
        this.f3139b[10] = (byte) ((type >> 8) & 255);
        this.f3139b[11] = (byte) (type & 255);
    }


    public int encryptMusicLength(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        Builder builder = CarlifeMusicInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        byte[] initParameter = builder.build().toByteArray();
        byte[] encryptData = initParameter;
        if (EncryptSetupManager.newInstance().getFlag() && initParameter.length > 0) {
            encryptData = this.mAESManager.encrypt(initParameter, initParameter.length);
            if (encryptData == null) {
                Log.e(Tag, "encrypt failed!");
                return -1;
            }
        }
        System.arraycopy(encryptData, 0, byteData, this.f3140c, byteData.length > encryptData.length ? encryptData.length : byteData.length);
        if (encryptData.length > byteData.length) {
            Log.d(Tag, "initParameter.length>byteData.length!!");
        }
        Log.d(Tag, "byteData:" + Arrays.toString(byteData));
        return encryptData.length;
    }


    public int encryptTTSLength(int sampleRate, int channelConfig, int sampleFormat, byte[] byteData) {
        CarlifeTTSInit.Builder builder = CarlifeTTSInit.newBuilder();
        builder.setSampleRate(sampleRate);
        builder.setChannelConfig(channelConfig);
        builder.setSampleFormat(sampleFormat);
        byte[] initParamter = builder.build().toByteArray();
        byte[] encryptData = initParamter;
        if (EncryptSetupManager.newInstance().getFlag() && initParamter.length > 0) {
            encryptData = this.mAESManager.encrypt(initParamter, initParamter.length);
            if (encryptData == null) {
                Log.e(Tag, "encrypt failed!");
                return -1;
            }
        }
        System.arraycopy(encryptData, 0, byteData, this.f3141d, encryptData.length);
        return encryptData.length;
    }
}
