package com.baidu.speech.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class BDSSDKLoader
{
  public static native void SetLogLevel(int paramInt);
  
  public static native int getEngineVersion();
  
  public static BDSSDKInterface getSDKObjectForSDKType(String paramString, Context paramContext)
  {
    String str2 = paramContext.getApplicationInfo().nativeLibraryDir;
    String str1 = str2;
    if (!str2.endsWith("/"))
    {
      str1 = str2;
      if (str2.length() > 0) {
        str1 = str2 + "/";
      }
    }
    setLibrarySearchPath(str1);
    setJavaContext(paramContext);
    str1 = paramContext.getCacheDir().getAbsolutePath() + "/";
    paramContext = paramContext.getFilesDir().getAbsolutePath() + "/";
    makeDir(paramContext);
    setWriteableTempPath(str1);
    setWriteableLibraryDataPath(paramContext);
    setWriteableUserDataPath(paramContext);
    return BDSCoreJniInterface.getNewSDK(paramString);
  }
  
  public static void loadLibraries()
    throws Exception
  {
    try
    {
      System.loadLibrary("bdEASRAndroid");
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          System.loadLibrary("bdSpilWakeup");
          try
          {
            System.loadLibrary("BaiduSpeechSDK");
            return;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
            throw new IOException("Can not load BaiduSpeechSDK library");
          }
          localThrowable1 = localThrowable1;
          localThrowable1.printStackTrace();
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public static boolean makeDir(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if ((!paramString.isDirectory()) || (!paramString.canWrite())) {}
      }
      else {
        while (paramString.mkdirs()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static native void setJavaContext(Context paramContext);
  
  private static native void setLibrarySearchPath(String paramString);
  
  public static native void setWriteableLibraryDataPath(String paramString);
  
  public static native void setWriteableTempPath(String paramString);
  
  public static native void setWriteableUserDataPath(String paramString);
  
  public static abstract interface BDSCoreEventListener
  {
    public abstract void receiveCoreEvent(BDSMessage paramBDSMessage, BDSSDKLoader.BDSSDKInterface paramBDSSDKInterface);
  }
  
  public static abstract interface BDSSDKInterface
  {
    public abstract void EchoMessage(BDSMessage paramBDSMessage);
    
    public abstract boolean instanceInitialized();
    
    public abstract int postMessage(BDSMessage paramBDSMessage);
    
    public abstract void release();
    
    public abstract void setListener(BDSSDKLoader.BDSCoreEventListener paramBDSCoreEventListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSSDKLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */