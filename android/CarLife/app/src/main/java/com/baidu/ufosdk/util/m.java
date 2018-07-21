package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@SuppressLint({"InlinedApi"})
public final class m
{
  private static String a()
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a("W", false));
    localStringBuffer.append(a("9", true));
    localStringBuffer.append(localRandom.nextInt(1) + 1);
    localStringBuffer.append(a("Y", true));
    localStringBuffer.append("abe");
    localStringBuffer.append(a("y", true));
    localStringBuffer.append("1a88");
    return localStringBuffer.toString();
  }
  
  @SuppressLint({"TrulyRandom"})
  public static String a(String paramString)
  {
    localObject = null;
    try
    {
      Key localKey = d(a());
      Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
      int k = localCipher.getBlockSize();
      paramString = paramString.getBytes();
      int j = paramString.length;
      int i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramString, 0, arrayOfByte, 0, paramString.length);
      localCipher.init(1, localKey, new IvParameterSpec(b().getBytes()));
      paramString = localCipher.doFinal(arrayOfByte);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
    return new String(Base64.encodeToString(paramString, 0));
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length)
      {
        if (!paramBoolean) {
          break;
        }
        return localStringBuffer.reverse().toString();
      }
      localStringBuffer.append(Integer.toHexString(paramString[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    for (;;)
    {
      if (i >= 9)
      {
        localStringBuilder.append(localStringBuilder);
        return localStringBuilder.toString();
      }
      localStringBuilder.append(String.valueOf(i));
      i += 1;
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      Key localKey = d(a());
      Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
      localCipher.init(2, localKey, new IvParameterSpec(b().getBytes()));
      paramString = localCipher.doFinal(Base64.decode(paramString, 0));
      return new String(paramString).trim();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject1 = MessageDigest.getInstance("MD5");
      if (localObject1 != null)
      {
        ((MessageDigest)localObject1).reset();
        ((MessageDigest)localObject1).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject1).digest();
        localObject1 = new StringBuilder();
        int j = paramString.length;
        i = 0;
        if (i >= j) {
          return ((StringBuilder)localObject1).toString();
        }
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        int i;
        localNoSuchAlgorithmException.printStackTrace();
        Object localObject2 = null;
        continue;
        ((StringBuilder)localObject2).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
    }
    return "";
  }
  
  private static Key d(String paramString)
  {
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw paramString;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */