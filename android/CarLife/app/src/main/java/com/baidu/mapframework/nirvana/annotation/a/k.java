package com.baidu.mapframework.nirvana.annotation.a;

import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;

class k
{
  static String[] a = { "mb", "os", "sv", "net", "resid", "cuid", "bduid", "channel", "oem", "screen", "dpi", "ver", "sinan", "ctm" };
  public static final String b = "PHPUI";
  public static final String c = "bduss";
  
  private static void a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i])) {
        throw new RuntimeException(paramString + " is repeated, phoneinfo has contained the key");
      }
      i += 1;
    }
  }
  
  public static void a(String paramString, SignToken.SignTokenType paramSignTokenType)
  {
    b(paramString);
    if (SignToken.SignTokenType.MAP_PHPUI.equals(paramSignTokenType)) {
      a(paramString);
    }
    c(paramString);
  }
  
  private static void b(String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      throw new RuntimeException("key cant't be empty");
    }
  }
  
  public static void b(String paramString, SignToken.SignTokenType paramSignTokenType)
  {
    b(paramString);
    if (SignToken.SignTokenType.MAP_PHPUI.equals(paramSignTokenType)) {
      a(paramString);
    }
  }
  
  private static void c(String paramString)
  {
    if ("bduss".equals(paramString)) {
      throw new RuntimeException("bduss must be @PostParam");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */