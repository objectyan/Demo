package com.baidu.speech.easr;

public class VoicePreProcess {
    static {
        try {
            synchronized (VoicePreProcess.class) {
                System.loadLibrary("FPALG");
            }
        } catch (UnsatisfiedLinkError e) {
        }
    }

    private VoicePreProcess() {
    }

    public static native synchronized int initJni(int i, int i2, int i3, double d, double d2);

    public static native synchronized int process(byte[] bArr, byte[] bArr2, short[] sArr);

    public static native synchronized int releaseJni(int i);
}
