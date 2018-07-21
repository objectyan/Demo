package com.baidu.mpcr.jni;

public class MpcrAppJni
{
  private MpcrJni mMpcrJni = null;
  
  public String decryptStr(String paramString)
  {
    return this.mMpcrJni.decryptStr(paramString);
  }
  
  public String encryptStr(String paramString)
  {
    return this.mMpcrJni.encryptStr(paramString);
  }
  
  public void init()
  {
    this.mMpcrJni.init();
  }
  
  public void unInit()
  {
    this.mMpcrJni.unInit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mpcr/jni/MpcrAppJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */