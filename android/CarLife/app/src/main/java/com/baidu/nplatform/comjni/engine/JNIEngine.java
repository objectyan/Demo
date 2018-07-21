package com.baidu.nplatform.comjni.engine;

import android.os.Bundle;

public class JNIEngine
{
  public static native boolean GetFlaxLength(Bundle paramBundle);
  
  public static native boolean InitEngine(Bundle paramBundle);
  
  public static native boolean StartSocketProc();
  
  public static native boolean UnInitEngine();
  
  public static native int initClass(Object paramObject, int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comjni/engine/JNIEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */