package com.baidu.navisdk.jni.nativeif;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams.VoiceRegActionFinishResult;

public class JNIVoiceCommandControl {
    public static JNIVoiceCommandControl sInstance = new JNIVoiceCommandControl();

    public native int AsrCancelVoiceReg();

    public native int AsrGetVoiceASRRegResult(Bundle bundle);

    public native int AsrPause();

    public native int AsrResume();

    public native int AsrStart();

    public native int AsrStop();

    public native int AsrTriggerAppStatus(int i);

    public native int AsrTriggerCityChange(int i, boolean z);

    public native int AsrTriggerDeviceLevel(int i);

    public native int AsrTriggerNetStatus(int i);

    public native int AsrTriggerProvinceChange(int i, boolean z);

    public native int AsrTriggerRecorderStatus(int i);

    public native int AsrTriggerRegActionFinish(VoiceRegActionFinishResult voiceRegActionFinishResult);

    public native int StartVoiceRegDecode();

    public native int StopVoiceRegDecode();

    public native int VoiceASRVerifyLicense(Context context, String str, byte[] bArr, int i, byte[] bArr2);

    private JNIVoiceCommandControl() {
    }
}
