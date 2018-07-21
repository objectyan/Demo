package com.baidu.android.pushservice.k;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class f
{
  private static int a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (paramBoolean) {
        str1 = str2.toUpperCase();
      }
      if (str1.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str1).append(paramString);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = a(localMessageDigest.digest(), "", paramBoolean);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    localObject2 = null;
    char[] arrayOfChar = null;
    Object localObject1 = arrayOfChar;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = arrayOfChar;
        localObject2 = paramString.toUpperCase();
        localObject1 = arrayOfChar;
        int j = ((String)localObject2).length() / 2;
        localObject1 = arrayOfChar;
        paramString = new byte[j];
        localObject1 = paramString;
        arrayOfChar = ((String)localObject2).toCharArray();
        localObject2 = paramString;
        if (arrayOfChar != null)
        {
          int i = 0;
          for (;;)
          {
            localObject2 = paramString;
            if (i >= j) {
              break;
            }
            int k = i * 2;
            if (k >= 0)
            {
              localObject1 = paramString;
              if ((k + 1 < arrayOfChar.length) && (i >= 0) && (i < j))
              {
                localObject1 = paramString;
                int m = a(arrayOfChar[k]);
                localObject1 = paramString;
                paramString[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
              }
            }
            i += 1;
          }
        }
      }
      return (byte[])localObject2;
    }
    catch (Exception paramString)
    {
      localObject2 = localObject1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */