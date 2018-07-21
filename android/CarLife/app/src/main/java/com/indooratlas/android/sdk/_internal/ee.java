package com.indooratlas.android.sdk._internal;

import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class ee
{
  private static a a = new b();
  
  public static final String a(Class paramClass)
  {
    return a(paramClass.getSimpleName());
  }
  
  public static final String a(String paramString)
  {
    if (paramString.startsWith("IA")) {}
    for (;;)
    {
      String str = paramString;
      if (paramString.length() > 23) {
        str = paramString.substring(0, 23);
      }
      return str;
      paramString = "IA" + paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a.a(paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    a.a(paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return a.a(paramString, paramInt);
  }
  
  private static String b(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return paramString;
    }
    try
    {
      paramVarArgs = String.format(Locale.US, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalFormatException paramVarArgs)
    {
      Log.e(a("Logger"), "formatting message failed: " + paramString);
    }
    return paramString;
  }
  
  public static abstract class a
  {
    public abstract void a(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract boolean a(String paramString, int paramInt);
  }
  
  public static final class b
    extends ee.a
  {
    public final void a(String paramString1, String paramString2, Object... paramVarArgs)
    {
      Log.e(paramString1, ee.a(paramString2, paramVarArgs));
    }
    
    public final void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      Log.e(paramString1, ee.a(paramString2, paramVarArgs), paramThrowable);
    }
    
    public final boolean a(String paramString, int paramInt)
    {
      return Log.isLoggable(paramString, paramInt);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */