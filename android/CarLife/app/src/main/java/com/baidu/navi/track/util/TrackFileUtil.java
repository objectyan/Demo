package com.baidu.navi.track.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TrackFileUtil
{
  private static final String UID = "";
  
  public static String getMD5EncryptedString(String paramString)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        System.out.println("Exception while encrypting to md5");
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    ((MessageDigest)localObject).update(paramString.getBytes(), 0, paramString.length());
    for (paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16); paramString.length() < 32; paramString = "0" + paramString) {}
    return paramString;
  }
  
  public static String getMd5OfFile(String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    MessageDigest localMessageDigest;
    try
    {
      paramString = new FileInputStream(paramString);
      localObject1 = localObject2;
      arrayOfByte = new byte['Ѐ'];
      localObject1 = localObject2;
      localMessageDigest = MessageDigest.getInstance("MD5");
      i = 0;
      while (i != -1)
      {
        localObject1 = localObject2;
        int j = paramString.read(arrayOfByte);
        i = j;
        if (j > 0)
        {
          localObject1 = localObject2;
          localMessageDigest.update(arrayOfByte, 0, j);
          i = j;
          continue;
          return ((String)localObject2).toUpperCase();
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      localObject2 = localObject1;
    }
    localObject1 = localObject2;
    paramString.close();
    localObject1 = localObject2;
    byte[] arrayOfByte = localMessageDigest.digest();
    int i = 0;
    paramString = (String)localObject2;
    for (;;)
    {
      localObject1 = paramString;
      localObject2 = paramString;
      if (i >= arrayOfByte.length) {
        break;
      }
      localObject1 = paramString;
      paramString = paramString + Integer.toString((arrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
  }
  
  public static String trackFileSign(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    paramString1 = new File(paramString1 + File.separator + paramString2 + ".bin.gz");
    if (!paramString1.exists()) {
      return "";
    }
    paramString1 = getMd5OfFile(paramString1.getAbsolutePath());
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    paramString1 = getMD5EncryptedString(paramString1 + "" + paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    return new StringBuffer(paramString1).reverse().toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/util/TrackFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */