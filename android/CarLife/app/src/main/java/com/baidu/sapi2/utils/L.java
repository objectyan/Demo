package com.baidu.sapi2.utils;

import android.util.Log;

public final class L
{
  private static final String a = "SAPI";
  private static final String b = "%1$s\n%2$s";
  private static boolean c = false;
  
  private static void a(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (!c) {
      return;
    }
    String str = paramString;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString, paramVarArgs);
    }
    if (paramThrowable == null)
    {
      Log.println(paramInt, "SAPI", str);
      return;
    }
    if (str == null) {}
    for (paramString = paramThrowable.getMessage();; paramString = str)
    {
      str = String.format("%1$s\n%2$s", new Object[] { paramString, Log.getStackTraceString(paramThrowable) });
      break;
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    a(3, null, paramString, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    a(6, null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable)
  {
    a(6, paramThrowable, null, new Object[0]);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    a(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void enable(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    a(4, null, paramString, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    a(5, null, paramString, paramVarArgs);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/L.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */