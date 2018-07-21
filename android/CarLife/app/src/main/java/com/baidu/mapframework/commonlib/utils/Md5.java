package com.baidu.mapframework.commonlib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5
{
  public String str;
  
  public static String md5s(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      str1 = str2;
      ((MessageDigest)localObject).update(paramString.getBytes());
      str1 = str2;
      paramString = ((MessageDigest)localObject).digest();
      str1 = str2;
      localObject = new StringBuffer("");
      int i = 0;
      for (;;)
      {
        str1 = str2;
        if (i >= paramString.length) {
          break;
        }
        int k = paramString[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16)
        {
          str1 = str2;
          ((StringBuffer)localObject).append("0");
        }
        str1 = str2;
        ((StringBuffer)localObject).append(Integer.toHexString(j));
        i += 1;
      }
      str1 = str2;
      paramString = ((StringBuffer)localObject).toString();
      str1 = paramString;
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return str1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/Md5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */