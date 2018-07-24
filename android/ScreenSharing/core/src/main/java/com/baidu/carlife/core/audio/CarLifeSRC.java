package com.baidu.carlife.core.audio;

import android.util.Log;

public class CarLifeSRC {
    /* renamed from: a */
    private static final String f2968a = CarLifeSRC.class.getSimpleName();
    /* renamed from: b */
    private static final int f2969b = 5120;
    /* renamed from: c */
    private short[] f2970c = new short[5120];
    /* renamed from: d */
    private int f2971d = 10240;
    /* renamed from: e */
    private short[] f2972e = new short[this.f2971d];

    private native String hello();

    private native int init(int i, int i2, int i3, int i4);

    private native int resample(short[] sArr, int i, short[] sArr2);

    static {
        try {
            System.loadLibrary("CarLifeSRC");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            Log.d(f2968a, "could not load library!");
        }
    }

    /* renamed from: a */
    public int m3878a(int inSampleRate, int outSampleRate, int channel, int srcType) {
        return init(inSampleRate, outSampleRate, channel, srcType);
    }

    /* renamed from: a */
    public int m3880a(short[] inData, int inSize, short[] outData) {
        return resample(inData, inSize, outData);
    }

    /* renamed from: a */
    public int m3879a(byte[] inData, int inSize, byte[] outData, int offset) {
        AudioUtil.m3882a().m3885a(inData, inSize, offset, this.f2970c);
        int size = resample(this.f2970c, inSize / 2, this.f2972e);
        AudioUtil.m3882a().m3886a(this.f2972e, size, outData);
        return size * 2;
    }
}
