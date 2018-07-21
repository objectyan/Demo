package com.baidu.tts.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Util
{
  public static byte[] sha1(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA-1").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/SHA1Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */