package com.loopj.android.http;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;

public class LogHandler
  implements LogInterface
{
  boolean mLoggingEnabled = true;
  int mLoggingLevel = 2;
  
  @TargetApi(8)
  private void checkedWtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.wtf(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(3, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    log(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(6, paramString1, paramString2, paramThrowable);
  }
  
  public int getLoggingLevel()
  {
    return this.mLoggingLevel;
  }
  
  public void i(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(4, paramString1, paramString2, paramThrowable);
  }
  
  public boolean isLoggingEnabled()
  {
    return this.mLoggingEnabled;
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    logWithThrowable(paramInt, paramString1, paramString2, null);
  }
  
  public void logWithThrowable(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((isLoggingEnabled()) && (shouldLog(paramInt))) {}
    switch (paramInt)
    {
    case 7: 
    default: 
      return;
    case 2: 
      Log.v(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 6: 
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 8: 
      if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8)
      {
        checkedWtf(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void setLoggingEnabled(boolean paramBoolean)
  {
    this.mLoggingEnabled = paramBoolean;
  }
  
  public void setLoggingLevel(int paramInt)
  {
    this.mLoggingLevel = paramInt;
  }
  
  public boolean shouldLog(int paramInt)
  {
    return paramInt >= this.mLoggingLevel;
  }
  
  public void v(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(2, paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    log(5, paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(5, paramString1, paramString2, paramThrowable);
  }
  
  public void wtf(String paramString1, String paramString2)
  {
    log(8, paramString1, paramString2);
  }
  
  public void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    logWithThrowable(8, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/LogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */