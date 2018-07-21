package com.baidu.mapframework.nirvana.concurrent;

public class QueueToken
{
  private final ConcurrentQueueRunner a;
  
  QueueToken(ConcurrentQueueRunner paramConcurrentQueueRunner)
  {
    this.a = paramConcurrentQueueRunner;
  }
  
  ConcurrentQueueRunner a()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/QueueToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */