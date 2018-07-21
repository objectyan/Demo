package com.baidu.mapframework.commonlib.asynchttp;

public abstract interface LogInterface
{
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  public static final int WTF = 8;
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int getLoggingLevel();
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isLoggingEnabled();
  
  public abstract void setLoggingEnabled(boolean paramBoolean);
  
  public abstract void setLoggingLevel(int paramInt);
  
  public abstract boolean shouldLog(int paramInt);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void wtf(String paramString1, String paramString2);
  
  public abstract void wtf(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/LogInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */