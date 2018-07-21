package com.baidu.platform.comjni.util;

import com.baidu.platform.comjni.a;

@Deprecated
public class JNIMD5
  extends a
{
  public static native String EncodeUrlParamsValue(String paramString);
  
  public static native String GetSignMD5String(String paramString);
  
  public static native String GetWebSignMD5String(String paramString);
  
  public static native String SignOpra(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comjni/util/JNIMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */