package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.h;
import com.baidu.platform.comapi.util.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class BMExecutorsManager
{
  public static final ExecutorService APP_COMMON_EXECUTOR_SERVICE;
  public static final ExecutorService BACKGROUND_SINGLE_EXECUTOR_SERVICE;
  public static final ExecutorService CACHED_EXECUTOR_SERVICE;
  public static final int CORE_NUM;
  public static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE;
  public static final ExecutorService SINGLE_EXECUTOR_SERVICE;
  
  static
  {
    if (Runtime.getRuntime().availableProcessors() > 1) {}
    for (int i = Runtime.getRuntime().availableProcessors() - 1;; i = 1)
    {
      CORE_NUM = i;
      CACHED_EXECUTOR_SERVICE = new c(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new h("MapAppCachedTP"));
      APP_COMMON_EXECUTOR_SERVICE = new c(CORE_NUM, CORE_NUM, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new h("APP_COMMON_TP"));
      SINGLE_EXECUTOR_SERVICE = new c(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new h("MapAppSingleTP"));
      SCHEDULED_EXECUTOR_SERVICE = new a(CORE_NUM, new h("MapAppScheduledTP"));
      BACKGROUND_SINGLE_EXECUTOR_SERVICE = new c(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new j("LowerPriorityMapAppSingleTP", 10));
      return;
    }
  }
  
  public static ExecutorService newAppCommonThreadPool(ThreadFactory paramThreadFactory)
  {
    return new c(CORE_NUM, CORE_NUM, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
  }
  
  public static ExecutorService newCachedThreadPool(ThreadFactory paramThreadFactory)
  {
    return new c(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), paramThreadFactory);
  }
  
  public static ExecutorService newFixedThreadPool(int paramInt, ThreadFactory paramThreadFactory)
  {
    return new c(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), paramThreadFactory);
  }
  
  public static ScheduledExecutorService newScheduledThreadPool(int paramInt, ThreadFactory paramThreadFactory)
  {
    return new a(paramInt, paramThreadFactory);
  }
  
  public static ExecutorService newSingleThreadExecutor(ThreadFactory paramThreadFactory)
  {
    return new c(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), paramThreadFactory);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/basic/BMExecutorsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */