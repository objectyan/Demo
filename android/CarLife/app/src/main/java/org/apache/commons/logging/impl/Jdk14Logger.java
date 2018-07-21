package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

@Deprecated
public class Jdk14Logger
  implements Serializable, Log
{
  protected static final Level dummyLevel = null;
  protected transient Logger logger;
  protected String name;
  
  public Jdk14Logger(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void debug(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void debug(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void error(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void error(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void fatal(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void fatal(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Logger getLogger()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void info(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void info(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDebugEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isErrorEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isFatalEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isInfoEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTraceEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isWarnEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void trace(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void trace(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void warn(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void warn(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/commons/logging/impl/Jdk14Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */