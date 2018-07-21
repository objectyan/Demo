package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.jni.control.EnvironmentUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class JNIStatisticsControl
{
  private static final String KEY_LOG_HEAD_CHANNEL = "channel";
  private static final String KEY_LOG_HEAD_UID = "duid";
  public static JNIStatisticsControl sInstance = new JNIStatisticsControl();
  
  private int setLogHeaderParam(String paramString1, String paramString2)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("channel", paramString1);
      localBundle.putString("duid", paramString2);
      int i = setLogHeaderParam(localBundle);
      return i;
    }
    catch (Throwable paramString1) {}
    return -1;
  }
  
  public native void clearOldNetWorkDataRecord();
  
  public void exit()
  {
    try
    {
      writeTmpLogFile();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public native void getAllNetWorkDataSize(Bundle paramBundle);
  
  public native int getStatisticsResult(String paramString, Bundle paramBundle);
  
  public void init()
  {
    String str = PackageUtil.getChannel();
    try
    {
      setLogHeaderParam(str, EnvironmentUtil.getCuid());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public native int recordStatisticsItem(String paramString);
  
  public native int setLogHeaderParam(Bundle paramBundle);
  
  public native int setTTSTextPlayResult(String paramString1, String paramString2);
  
  public native int upLoadStatistics();
  
  public native int writeTmpLogFile();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNIStatisticsControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */