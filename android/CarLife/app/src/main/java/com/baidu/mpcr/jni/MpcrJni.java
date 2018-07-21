package com.baidu.mpcr.jni;

public class MpcrJni
{
  public native String decryptStr(String paramString);
  
  public native String encryptStr(String paramString);
  
  public native void init();
  
  public native void unInit();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mpcr/jni/MpcrJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */