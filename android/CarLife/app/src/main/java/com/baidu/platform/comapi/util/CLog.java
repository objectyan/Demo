package com.baidu.platform.comapi.util;

public class CLog
{
  public static final boolean DEBUG = false;
  private static CLog a = null;
  
  public static CLog getInstance()
  {
    try
    {
      if ((a == null) && (a == null)) {
        a = new CLog();
      }
      CLog localCLog = a;
      return localCLog;
    }
    finally {}
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void e(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void i(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void w(String paramString, Throwable paramThrowable) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/CLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */