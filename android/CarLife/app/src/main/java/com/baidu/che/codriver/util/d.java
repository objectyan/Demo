package com.baidu.che.codriver.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static String b = "AES";
  private static String c = "AES/CBC/PKCS5Padding";
  private static final String d = "0123456789abcdef";
  
  public static String a(String paramString)
  {
    String str = "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(localMessageDigest.digest());
      return paramString.toLowerCase();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = a[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, b);
    Cipher localCipher = Cipher.getInstance(c);
    localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("0123456789abcdef".getBytes()));
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  public static String b(String paramString)
    throws IOException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes());
    localGZIPOutputStream.close();
    if (localByteArrayOutputStream != null) {}
    try
    {
      localByteArrayOutputStream.close();
      return localByteArrayOutputStream.toString("UTF-8");
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append("0123456789ABCDEF".charAt(paramArrayOfByte[i] >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, b);
    Cipher localCipher = Cipher.getInstance(c);
    localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("0123456789abcdef".getBytes()));
    return localCipher.doFinal(paramArrayOfByte1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */