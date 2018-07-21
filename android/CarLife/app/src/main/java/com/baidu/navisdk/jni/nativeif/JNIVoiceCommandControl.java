package com.baidu.navisdk.jni.nativeif;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams.VoiceRegActionFinishResult;

public class JNIVoiceCommandControl
{
  public static JNIVoiceCommandControl sInstance = new JNIVoiceCommandControl();
  
  public native int AsrCancelVoiceReg();
  
  public native int AsrGetVoiceASRRegResult(Bundle paramBundle);
  
  public native int AsrPause();
  
  public native int AsrResume();
  
  public native int AsrStart();
  
  public native int AsrStop();
  
  public native int AsrTriggerAppStatus(int paramInt);
  
  public native int AsrTriggerCityChange(int paramInt, boolean paramBoolean);
  
  public native int AsrTriggerDeviceLevel(int paramInt);
  
  public native int AsrTriggerNetStatus(int paramInt);
  
  public native int AsrTriggerProvinceChange(int paramInt, boolean paramBoolean);
  
  public native int AsrTriggerRecorderStatus(int paramInt);
  
  public native int AsrTriggerRegActionFinish(BNVoiceCommandParams.VoiceRegActionFinishResult paramVoiceRegActionFinishResult);
  
  public native int StartVoiceRegDecode();
  
  public native int StopVoiceRegDecode();
  
  public native int VoiceASRVerifyLicense(Context paramContext, String paramString, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIVoiceCommandControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */