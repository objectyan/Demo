package com.baidu.tts.c;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a
  extends ThreadPoolExecutor
{
  public a(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory, paramRejectedExecutionHandler);
  }
  
  public a(int paramInt, String paramString)
  {
    this(paramInt, paramString, new a());
  }
  
  public a(int paramInt, String paramString, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    this(paramInt, new com.baidu.tts.g.a.a(paramString), paramRejectedExecutionHandler);
  }
  
  public a(int paramInt, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    this(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(paramInt), paramThreadFactory, paramRejectedExecutionHandler);
  }
  
  public static class a
    implements RejectedExecutionHandler
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      LoggerProxy.d("LimitQueueThreadPoolExecutor", "rejectedExecution");
      if (!paramThreadPoolExecutor.isShutdown()) {}
      try
      {
        paramThreadPoolExecutor.getQueue().put(paramRunnable);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        Thread.currentThread().interrupt();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */