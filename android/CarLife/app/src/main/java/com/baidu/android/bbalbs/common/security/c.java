package com.baidu.android.bbalbs.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  public static byte[] a(byte[] paramArrayOfByte)
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/bbalbs/common/security/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */