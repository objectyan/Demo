package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;

@Deprecated
public class SimpleLog
  implements Serializable, Log
{
  protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
  public static final int LOG_LEVEL_ALL = 0;
  public static final int LOG_LEVEL_DEBUG = 2;
  public static final int LOG_LEVEL_ERROR = 5;
  public static final int LOG_LEVEL_FATAL = 6;
  public static final int LOG_LEVEL_INFO = 3;
  public static final int LOG_LEVEL_OFF = 7;
  public static final int LOG_LEVEL_TRACE = 1;
  public static final int LOG_LEVEL_WARN = 4;
  protected static DateFormat dateFormatter;
  protected static String dateTimeFormat;
  protected static boolean showDateTime = false;
  protected static boolean showLogName = false;
  protected static boolean showShortName = false;
  protected static final Properties simpleLogProps = null;
  protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
  protected int currentLogLevel;
  protected String logName;
  
  public SimpleLog(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void debug(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void debug(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void error(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void error(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void fatal(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void fatal(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLevel()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void info(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void info(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isDebugEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isErrorEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isFatalEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isInfoEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isLevelEnabled(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isTraceEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isWarnEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void log(int paramInt, Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLevel(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void trace(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void trace(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void warn(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void warn(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void write(StringBuffer paramStringBuffer)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/commons/logging/impl/SimpleLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */