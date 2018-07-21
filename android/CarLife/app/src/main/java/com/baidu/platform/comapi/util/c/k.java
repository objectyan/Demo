package com.baidu.platform.comapi.util.c;

import java.lang.reflect.Field;

public class k
{
  public static String a()
  {
    String str2 = a("com.baidu.needle.confirm.Confirm", "NEEDLE_VERSION");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredField(paramString2);
      paramString1.setAccessible(true);
      paramString1 = (String)paramString1.get(null);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */