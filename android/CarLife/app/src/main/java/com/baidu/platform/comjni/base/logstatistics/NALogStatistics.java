package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.c;

public class NALogStatistics
  extends c
{
  public NALogStatistics()
  {
    create();
  }
  
  public static native boolean nativeAddLog(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public static native long nativeCreate();
  
  public static native int nativeRelease(long paramLong);
  
  public static native boolean nativeSave(long paramLong);
  
  public boolean addLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    return nativeAddLog(this.mNativePointer, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    int i = 0;
    if (this.mNativePointer != 0L)
    {
      i = nativeRelease(this.mNativePointer);
      this.mNativePointer = 0L;
    }
    return i;
  }
  
  public boolean saveLog()
  {
    return nativeSave(this.mNativePointer);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/base/logstatistics/NALogStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */