package com.baidu.platform.comapi.util;

import android.os.Build.VERSION;
import android.util.Log;

public class f
{
  public static boolean a = false;
  private static final String b = "BaiduMapLog";
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramString == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append(paramString);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    a("BaiduMapLog", paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.v(paramString1, "" + paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.d(paramString1, "" + paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    if (a) {
      Log.d(paramString, a(paramVarArgs, " "));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    return a("BaiduMapLog", paramInt);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    if (a) {
      return Log.isLoggable(paramString, paramInt);
    }
    return false;
  }
  
  public static void b(String paramString)
  {
    b("BaiduMapLog", paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, "" + paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.w(paramString1, "" + paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString)
  {
    c("BaiduMapLog", paramString);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, "" + paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.e(paramString1, "" + paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString)
  {
    d("BaiduMapLog", paramString);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, "" + paramString2);
    }
  }
  
  public static void e(String paramString)
  {
    e("BaiduMapLog", paramString);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a) {
      Log.e(paramString1, "" + paramString2);
    }
  }
  
  public static void f(String paramString)
  {
    f("BaiduMapLog", paramString);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if ((a) && (Build.VERSION.SDK_INT >= 8)) {
      Log.wtf(paramString1, "" + paramString2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */