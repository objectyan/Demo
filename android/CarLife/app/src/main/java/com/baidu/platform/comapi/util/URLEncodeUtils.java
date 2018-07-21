package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.a;

public final class URLEncodeUtils
  extends a
{
  public static String generateSign(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return nativeMD5Sign(paramString);
    }
    if (paramInt == 2) {
      return nativeWebSign(paramString);
    }
    if (paramInt == 3) {
      return nativeOperSign(paramString);
    }
    return "";
  }
  
  public static String getMD5String(String paramString)
  {
    return MD5.getMD5String(paramString);
  }
  
  private static native String nativeMD5Sign(String paramString);
  
  private static native String nativeOperSign(String paramString);
  
  private static native String nativeUrlEncode(String paramString);
  
  private static native String nativeWebSign(String paramString);
  
  public static String urlEncode(String paramString)
  {
    return nativeUrlEncode(paramString);
  }
  
  public static class a
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/URLEncodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */