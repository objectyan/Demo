package com.baidu.platform.comjni.base.versionupdate;

import com.baidu.platform.comjni.a;

public class NAVersionUpdate
  extends a
{
  private int a = 0;
  
  private native int nativeCreate();
  
  private native int nativeRelease(int paramInt);
  
  private native void nativeSetVerUpdateParams(int paramInt, String paramString1, String paramString2);
  
  public int create()
  {
    this.a = nativeCreate();
    return this.a;
  }
  
  public int release()
  {
    try
    {
      int i = nativeRelease(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setVerUpdateParams(String paramString1, String paramString2)
  {
    try
    {
      nativeSetVerUpdateParams(this.a, paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/base/versionupdate/NAVersionUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */