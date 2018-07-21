package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.g;

public abstract class ConcurrentTask
  extends g
  implements Runnable
{
  private QueueToken queueToken = null;
  
  QueueToken getQueueToken()
  {
    return this.queueToken;
  }
  
  public void setQueueToken(QueueToken paramQueueToken)
  {
    this.queueToken = paramQueueToken;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/ConcurrentTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */