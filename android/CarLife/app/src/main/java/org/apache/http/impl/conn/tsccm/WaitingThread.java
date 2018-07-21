package org.apache.http.impl.conn.tsccm;

import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class WaitingThread
{
  public WaitingThread(Condition paramCondition, RouteSpecificPool paramRouteSpecificPool)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean await(Date paramDate)
    throws InterruptedException
  {
    throw new RuntimeException("Stub!");
  }
  
  public final Condition getCondition()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final RouteSpecificPool getPool()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final Thread getThread()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void interrupt()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void wakeup()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/conn/tsccm/WaitingThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */