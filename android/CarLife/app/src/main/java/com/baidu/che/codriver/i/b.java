package com.baidu.che.codriver.i;

import android.text.TextUtils;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;

public class b
{
  private static final String a = "RawTextUtils";
  
  public static String a(String paramString)
  {
    String str = null;
    if (paramString.length() == 1) {
      str = b(paramString);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = a(paramString2);
    if (str == null) {
      return paramString1;
    }
    paramString1 = paramString1.replaceAll(paramString2, str);
    h.b("RawTextUtils", "replaceJson params = " + paramString1 + ";replaceText = " + str);
    return paramString1;
  }
  
  public static String b(String paramString)
  {
    String str = c.f(paramString);
    h.b("RawTextUtils", "rawText = " + paramString + ";pinyinText = " + str);
    paramString = null;
    if (b(str, "YI")) {
      paramString = "1";
    }
    do
    {
      return paramString;
      if (b(str, "ER|E")) {
        return "2";
      }
      if (b(str, "SAN|SHAN|SANG|SHANG|ZHANG|ZANG|ZHAN")) {
        return "3";
      }
      if (b(str, "SI")) {
        return "4";
      }
      if (b(str, "WU|WO")) {
        return "5";
      }
      if (b(str, "LIU|LU")) {
        return "6";
      }
      if (b(str, "QI|QU")) {
        return "7";
      }
      if (b(str, "BA")) {
        return "8";
      }
      if (b(str, "JIU")) {
        return "9";
      }
    } while (!b(str, "SHI"));
    return "10";
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    return paramString1.matches(paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */