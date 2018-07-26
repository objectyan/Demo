package com.baidu.tts.jni;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

public class EmbeddedSynthesizerEngine {
    private static final String TAG = "EmbeddedSynthesizerEngine";
    private static OnNewDataListener mNewDataListener = null;

    public interface OnNewDataListener {
        int onNewData(byte[] bArr, int i);
    }

    public static native int bdTTSDomainDataInit(byte[] bArr, long j);

    public static native int bdTTSDomainDataUninit(long j);

    public static native int bdTTSEngineInit(byte[] bArr, byte[] bArr2, long[] jArr);

    public static native int bdTTSEngineUninit(long j);

    public static native String bdTTSGetDatParam(String str);

    public static native int bdTTSGetDataFileParam(byte[] bArr, int i, byte[] bArr2);

    public static native synchronized String bdTTSGetEngineParam();

    public static native int bdTTSGetLicense(Context context, String str, String str2, String str3, String str4, String str5);

    public static native int bdTTSGetTestAuthorize();

    public static native int bdTTSReInitData(byte[] bArr, long j);

    public static native int bdTTSSetParam(long j, int i, long j2);

    public static native int bdTTSSetParamFloat(long j, int i, float f);

    public static native int bdTTSSetText(long j, byte[] bArr, int i);

    public static native synchronized int bdTTSSynthesis(long j, byte[] bArr, int i);

    public static native int bdTTSVerifyDataFile(byte[] bArr);

    public static native synchronized int bdTTSVerifyLicense(Context context, String str, String str2, String str3, byte[] bArr);

    public static native int getEngineMinVersion();

    public static native int loadEnglishEngine(byte[] bArr, byte[] bArr2, long j);

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
        } catch (Throwable th2) {
            LoggerProxy.m17002e(TAG, "so file BDSpeechDecoder_V1 load fail");
        }
        try {
            LoggerProxy.m17001d(TAG, "before load bd_etts");
            System.loadLibrary("bd_etts");
        } catch (Throwable th3) {
            LoggerProxy.m17002e(TAG, "so file bd_etts load fail");
        }
        try {
            LoggerProxy.m17001d(TAG, "before load bdtts");
            System.loadLibrary("bdtts");
            LoggerProxy.m17001d(TAG, "after load bdtts");
        } catch (Throwable th4) {
            LoggerProxy.m17002e(TAG, "so file bdtts load fail");
        }
    }

    public static void setOnNewDataListener(OnNewDataListener listener) {
        mNewDataListener = listener;
    }

    public static int newAudioDataCallback(byte[] audioData, int progress) {
        return mNewDataListener.onNewData(audioData, progress);
    }
}
