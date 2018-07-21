package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.g;
import java.util.concurrent.Callable;

public abstract class ConcurrentCallable<T>
  extends g
  implements Callable<T>
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/ConcurrentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */