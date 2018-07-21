package com.baidu.platform.comapi.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static final String a = "AES/ECB/PKCS5Padding";
  private static final String b = "AES";
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    paramString = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] b(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    paramString = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */