package com.baidu.speech.utils;

import android.util.Log;

public class LogUtil
{
  public static final int DEBUG = 3;
  private static final boolean DEBUG_MODE = false;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int OFF = 7;
  private static final String PREFIX = "[BDASR_LOG] ";
  private static final String TAG = "LogUtil";
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  public static int logLevel = 7;
  
  static
  {
    setLogLevel(7);
  }
  
  public static void Test(String paramString)
  {
    if (3 < logLevel) {
      return;
    }
    Log.d("LogUtil", paramString);
  }
  
  private static String argsToString(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (3 < logLevel) {
      return;
    }
    Log.d("[BDASR_LOG] " + paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void d(String paramString, Throwable paramThrowable, String... paramVarArgs)
  {
    if (3 < logLevel) {
      return;
    }
    Log.d("[BDASR_LOG] " + paramString, argsToString(paramVarArgs), paramThrowable);
  }
  
  public static void d(String paramString, String... paramVarArgs)
  {
    if (3 < logLevel) {
      return;
    }
    Log.d("[BDASR_LOG] " + paramString, argsToString(paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (6 < logLevel) {
      return;
    }
    Log.e("[BDASR_LOG] " + paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void e(String paramString, Throwable paramThrowable, String... paramVarArgs)
  {
    if (6 < logLevel) {
      return;
    }
    Log.e("[BDASR_LOG] " + paramString, argsToString(paramVarArgs), paramThrowable);
  }
  
  public static void e(String paramString, String... paramVarArgs)
  {
    if (6 < logLevel) {
      return;
    }
    Log.e("[BDASR_LOG] " + paramString, argsToString(paramVarArgs));
  }
  
  public static void e(Throwable paramThrowable)
  {
    if (6 < logLevel) {
      return;
    }
    printStrackTrace(paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (4 < logLevel) {
      return;
    }
    Log.i("[BDASR_LOG] " + paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void i(String paramString, Throwable paramThrowable, String... paramVarArgs)
  {
    if (4 < logLevel) {
      return;
    }
    Log.i("[BDASR_LOG] " + paramString, argsToString(paramVarArgs), paramThrowable);
  }
  
  public static void i(String paramString, String... paramVarArgs)
  {
    if (4 < logLevel) {
      return;
    }
    Log.i("[BDASR_LOG] " + paramString, argsToString(paramVarArgs));
  }
  
  private static boolean isFilteredLog(int paramInt, String paramString)
  {
    return (paramString.contains("")) && (paramInt == 3);
  }
  
  public static boolean isLoggable(int paramInt)
  {
    return logLevel >= paramInt;
  }
  
  private static void printStrackTrace(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (paramThrowable.getStackTrace() != null))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("\n").append(paramThrowable.getLocalizedMessage());
      paramThrowable = paramThrowable.getStackTrace();
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramThrowable[i];
        localStringBuffer.append("\n").append(((StackTraceElement)localObject).toString());
        i += 1;
      }
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
    Log.i("[BDASR_LOG] LogUtil", "Changing log level to " + paramInt);
  }
  
  public static void setLogLevel(String paramString)
  {
    if ("VERBOSE".equals(paramString)) {
      logLevel = 2;
    }
    for (;;)
    {
      Log.i("LogUtil", "Changing log level to " + logLevel + "(" + paramString + ")");
      return;
      if ("DEBUG".equals(paramString)) {
        logLevel = 3;
      } else if ("INFO".equals(paramString)) {
        logLevel = 4;
      } else if ("WARN".equals(paramString)) {
        logLevel = 5;
      } else if ("ERROR".equals(paramString)) {
        logLevel = 6;
      } else if ("OFF".equals(paramString)) {
        logLevel = 7;
      }
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (2 < logLevel) {
      return;
    }
    Log.v("[BDASR_LOG] " + paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void v(String paramString, Throwable paramThrowable, String... paramVarArgs)
  {
    if (2 < logLevel) {
      return;
    }
    Log.v("[BDASR_LOG] " + paramString, argsToString(paramVarArgs), paramThrowable);
  }
  
  public static void v(String paramString, String... paramVarArgs)
  {
    if (2 < logLevel) {
      return;
    }
    Log.v("[BDASR_LOG] " + paramString, argsToString(paramVarArgs));
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (5 < logLevel) {
      return;
    }
    Log.w("[BDASR_LOG] " + paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void w(String paramString, Throwable paramThrowable, String... paramVarArgs)
  {
    if (5 < logLevel) {
      return;
    }
    Log.w("[BDASR_LOG] " + paramString, argsToString(paramVarArgs), paramThrowable);
  }
  
  public static void w(String paramString, String... paramVarArgs)
  {
    if (5 < logLevel) {
      return;
    }
    Log.w("[BDASR_LOG] " + paramString, argsToString(paramVarArgs));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */