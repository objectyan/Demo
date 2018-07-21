package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.g;

public abstract class ScheduleTask
  extends g
  implements Runnable
{
  private long a;
  
  public ScheduleTask(long paramLong)
  {
    this.a = paramLong;
  }
  
  public long getDelay()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/ScheduleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */