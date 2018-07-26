package com.baidu.speechsynthesizer.utility;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

public class SpeechDecoder {
    private static final String TAG = "SpeechDecoder";
    private static OnDecodedDataListener mDecodedDataListener = null;

    public interface OnDecodedDataListener {
        void onDecodedData(byte[] bArr);
    }

    public static native int decodeWithCallback(byte[] bArr, Object obj);

    public native int decode(byte[] bArr, int i, short[] sArr, int[] iArr, int i2, int i3);

    static {
        try {
            LoggerProxy.m17001d(TAG, "before load gnustl_shared");
            System.loadLibrary("gnustl_shared");
        } catch (Throwable th) {
            LoggerProxy.m17002e(TAG, "so file gnustl_shared load fail");
        }
        try {
            LoggerProxy.m17001d(TAG, "before load BDSpeechDecoder_V1");
            System.loadLibrary("BDSpeechDecoder_V1");
            LoggerProxy.m17001d(TAG, "after load BDSpeechDecoder_V1");
        } catch (Throwable th2) {
            LoggerProxy.m17002e(TAG, "so file BDSpeechDecoder_V1 load fail");
        }
    }

    public int decodeWithCallback(byte[] intputData) {
        return decodeWithCallback(intputData, this);
    }

    public void decode_audio_callback(byte[] audio) {
        mDecodedDataListener.onDecodedData(audio);
    }

    public static void setOnDecodedDataListener(OnDecodedDataListener listener) {
        mDecodedDataListener = listener;
    }
}
