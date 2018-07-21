package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.c;

public class NAEngine
  extends c
{
  private static final int a = 0;
  private static LongLinkClient b;
  private static boolean c = false;
  
  public NAEngine()
  {
    create();
  }
  
  public static boolean getFlaxLength(Bundle paramBundle)
  {
    return nativeGetFlaxLength(paramBundle);
  }
  
  public static String getIP(String paramString)
  {
    return nativeGetIP(paramString);
  }
  
  public static void initCVLogFilePath(String paramString)
  {
    nativeInitCVLogFilePath(paramString);
  }
  
  public static boolean initEngine(Context paramContext, String paramString)
  {
    if (!c) {
      initVI();
    }
    try
    {
      boolean bool = nativeInitEngine(paramContext, paramString);
      SysOSAPIv2.getInstance().init();
      return bool;
    }
    catch (Throwable paramContext)
    {
      com.baidu.platform.comjni.util.a.a(paramContext);
    }
    return false;
  }
  
  public static boolean initLongLinkClient()
  {
    if (b == null) {}
    try
    {
      b = LongLinkClient.create();
      return b != null;
    }
    catch (com.baidu.platform.comapi.a.a locala)
    {
      for (;;) {}
    }
  }
  
  public static void initVI()
  {
    nativeInitClass(new Bundle(), 0);
    c = true;
  }
  
  private native long nativeCreate();
  
  private static native void nativeEnableMonitor(boolean paramBoolean);
  
  private static native boolean nativeGetFlaxLength(Bundle paramBundle);
  
  private static native String nativeGetIP(String paramString);
  
  private static native void nativeInitCVLogFilePath(String paramString);
  
  private static native int nativeInitClass(Object paramObject, int paramInt);
  
  private static native boolean nativeInitEngine(Object paramObject, String paramString);
  
  private static native void nativeMonitorSetLogPriority(int paramInt);
  
  private native int nativeRelease(long paramLong);
  
  private static native void nativeSetHttpsEnable(boolean paramBoolean);
  
  private static native void nativeSetNewDomainEnable(boolean paramBoolean);
  
  private static native void nativeSetProxyInfo(String paramString, int paramInt);
  
  private static native boolean nativeStartSocketProc();
  
  private static native boolean nativeStartSocketProcByCache(String paramString);
  
  private static native void nativeUninitCVLogFilePath();
  
  private static native boolean nativeUninitEngine();
  
  public static void restartLongLink()
  {
    if (b != null) {}
    try
    {
      b.start();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void setHttpsEnable(boolean paramBoolean)
  {
    nativeSetHttpsEnable(paramBoolean);
  }
  
  public static void setMonitorEnable(boolean paramBoolean)
  {
    nativeEnableMonitor(paramBoolean);
    nativeMonitorSetLogPriority(1);
  }
  
  public static void setNewDomainEnable(boolean paramBoolean)
  {
    nativeSetNewDomainEnable(paramBoolean);
  }
  
  public static void setProxyInfo(String paramString, int paramInt)
  {
    nativeSetProxyInfo(paramString, paramInt);
  }
  
  public static boolean startSocketProc()
  {
    return nativeStartSocketProc();
  }
  
  public static boolean startSocketProcByCache(String paramString)
  {
    return nativeStartSocketProcByCache(paramString);
  }
  
  public static void stopLongLink()
  {
    if (b != null) {}
    try
    {
      b.stop();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void unInitCVLogFilePath() {}
  
  public static boolean unInitEngine()
  {
    try
    {
      if (b != null)
      {
        b.unRegister(null);
        b.release();
        b = null;
      }
      boolean bool = nativeUninitEngine();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.baidu.platform.comjni.util.a.a(localThrowable);
    }
    return false;
  }
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    return nativeRelease(this.mNativePointer);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comjni/engine/NAEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */