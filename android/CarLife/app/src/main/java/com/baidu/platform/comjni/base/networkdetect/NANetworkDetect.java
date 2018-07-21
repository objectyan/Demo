package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.c;

public class NANetworkDetect
  extends c
{
  public NANetworkDetect()
  {
    create();
  }
  
  private native long nativeCreate();
  
  private native boolean nativeNetworkDetect(long paramLong, String paramString);
  
  private native int nativeRelease(long paramLong);
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    return nativeRelease(this.mNativePointer);
  }
  
  public boolean networkDetect(String paramString)
  {
    return nativeNetworkDetect(this.mNativePointer, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/base/networkdetect/NANetworkDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */