package com.baidu.android.pushservice.jni;

import android.content.Context;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.k.a;
import com.baidu.android.pushservice.k.b;

public class BaiduAppSSOJni
{
  private static final String TAG = "BaiduAppSSOJni";
  
  static
  {
    try
    {
      System.loadLibrary("bdpush_V2_9");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static native byte[] decryptAES(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native byte[] decryptR(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] encryptAES(String paramString, int paramInt);
  
  public static native byte[] encryptR(byte[] paramArrayOfByte, int paramInt);
  
  public static String getDecrypted(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = getDecrypted(paramContext, paramString1, b.a(paramString2.getBytes()));
      if ((paramContext != null) && (paramContext.length > 0))
      {
        paramContext = new String(paramContext, "utf-8");
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static byte[] getDecrypted(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = getKey(str);
      if (paramString == null) {
        return null;
      }
      paramString = new String(paramString, "utf-8");
      if (paramString.length() > 0)
      {
        str = paramString.substring(0, 16);
        paramString = a.b(paramString.substring(16), str, paramArrayOfByte);
        return paramString;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      p.b("UnsatisfiedLinkError getDecrypted ", paramContext);
      return null;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getEncrypted(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getEncrypted(paramContext, paramString1, paramString2.getBytes());
    try
    {
      paramContext = b.a(paramContext, "utf-8");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static byte[] getEncrypted(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = getKey(str);
      if (paramString == null) {
        return null;
      }
      paramString = new String(paramString, "utf-8");
      if (paramString.length() > 0)
      {
        str = paramString.substring(0, 16);
        paramString = a.a(paramString.substring(16), str, paramArrayOfByte);
        return paramString;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      p.b("UnsatisfiedLinkError getEncrypted " + paramArrayOfByte, paramContext);
      return null;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static native byte[] getKey(String paramString);
  
  public static native boolean verify(byte[] paramArrayOfByte, String paramString, int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/jni/BaiduAppSSOJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */