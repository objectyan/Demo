package me.objectyan.screensharing.core.audio;

import android.util.Log;

public class CarLifeSRC {

    private static final String Tag = CarLifeSRC.class.getSimpleName();

    private static final int lenOne = 5120;

    private short[] mShortsOne = new short[this.lenOne];

    private int lenTwo = 10240;

    private short[] mShortsTwo = new short[this.lenTwo];

    private native int init(int i, int i2, int i3, int i4);

    private native int resample(short[] sArr, int i, short[] sArr2);

    static {
        try {
            System.loadLibrary("CarLifeSRC");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            Log.d(Tag, "could not load library!");
        }
    }


    public int initSampleRate(int inSampleRate, int outSampleRate, int channel, int srcType) {
        return init(inSampleRate, outSampleRate, channel, srcType);
    }


    public int reSampleData(short[] inData, int inSize, short[] outData) {
        return resample(inData, inSize, outData);
    }


    public int m3879a(byte[] inData, int inSize, byte[] outData, int offset) {
        AudioUtil.newInstance().m3885a(inData, inSize, offset, this.mShortsOne);
        int size = resample(this.mShortsOne, inSize / 2, this.mShortsTwo);
        AudioUtil.newInstance().m3886a(this.mShortsTwo, size, outData);
        return size * 2;
    }
}
