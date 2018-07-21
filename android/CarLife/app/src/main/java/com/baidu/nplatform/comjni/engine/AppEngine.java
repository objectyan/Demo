package com.baidu.nplatform.comjni.engine;

import android.os.Bundle;
import com.baidu.navisdk.vi.VMsg;

public class AppEngine
{
  private static final int eBundle = 0;
  
  public static boolean GetFlaxLength(Bundle paramBundle)
  {
    return JNIEngine.GetFlaxLength(paramBundle);
  }
  
  public static boolean InitEngine(Bundle paramBundle)
  {
    try
    {
      JNIEngine.initClass(new Bundle(), 0);
      boolean bool = JNIEngine.InitEngine(paramBundle);
      return bool;
    }
    catch (Throwable paramBundle) {}
    return false;
  }
  
  public static boolean StartSocketProc()
  {
    return JNIEngine.StartSocketProc();
  }
  
  public static boolean UnInitEngine()
  {
    try
    {
      boolean bool = JNIEngine.UnInitEngine();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static void despatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    VMsg.dispatchMessage(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comjni/engine/AppEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */