package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.b;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.d;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.n;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class ConcurrentManager
{
  private static final ExecutorService a = ;
  private static final ExecutorService b = d.b("ConcurrentManager.UI.worker");
  private static final int c = 1;
  private static final ScheduledThreadPoolExecutor d = d.b("ConcurrentManager.SCHEDULE.worker", 1);
  
  private static Runnable a(@NotNull Runnable paramRunnable, final b paramb, final ScheduleConfig paramScheduleConfig)
  {
    new Runnable()
    {
      public void run()
      {
        e.b().a(this.a);
        try
        {
          if (paramScheduleConfig.isLifecycleActive()) {
            this.a.run();
          }
          e.b().b(this.a);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (paramb != null) {
              paramb.a(localException);
            } else {
              e.a("ConcurrentManager", localException);
            }
          }
        }
      }
    };
  }
  
  private static boolean a(ScheduleConfig paramScheduleConfig)
  {
    try
    {
      boolean bool = paramScheduleConfig.getType() instanceof UITaskType;
      return bool;
    }
    catch (Exception paramScheduleConfig) {}
    return false;
  }
  
  public static void executeTask(@NotNull Module paramModule, @NotNull ConcurrentTask paramConcurrentTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramConcurrentTask, paramScheduleConfig)) {
      return;
    }
    e.b().a(c.b, paramConcurrentTask, paramModule, paramScheduleConfig);
    paramModule = a(paramConcurrentTask, paramConcurrentTask.getExceptionCallback(), paramScheduleConfig);
    if (paramConcurrentTask.getQueueToken() == null)
    {
      if (a(paramScheduleConfig))
      {
        b.execute(paramModule);
        return;
      }
      a.execute(paramModule);
      return;
    }
    paramConcurrentTask.getQueueToken().a().a(paramModule);
  }
  
  public static QueueToken obtainTaskQueue(Module paramModule)
  {
    return new QueueToken(new ConcurrentQueueRunner(a));
  }
  
  public static void scheduleTask(@NotNull Module paramModule, @NotNull ScheduleTask paramScheduleTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramScheduleTask, paramScheduleConfig)) {
      return;
    }
    e.b().a(c.b, paramScheduleTask, paramModule, paramScheduleConfig);
    paramModule = a(paramScheduleTask, paramScheduleTask.getExceptionCallback(), paramScheduleConfig);
    d.schedule(paramModule, paramScheduleTask.getDelay(), TimeUnit.MILLISECONDS);
  }
  
  public static <T> FutureTask submitTask(@NotNull Module paramModule, @NotNull ConcurrentCallable<T> paramConcurrentCallable, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramConcurrentCallable, paramScheduleConfig)) {
      new FutureTask(new Callable()
      {
        public T call()
          throws Exception
        {
          return null;
        }
      });
    }
    FutureTask localFutureTask = new FutureTask(paramConcurrentCallable);
    e.b().a(c.b, localFutureTask, paramModule, paramScheduleConfig);
    paramModule = a(localFutureTask, paramConcurrentCallable.getExceptionCallback(), paramScheduleConfig);
    if (paramConcurrentCallable.getQueueToken() == null)
    {
      if (a(paramScheduleConfig))
      {
        b.execute(paramModule);
        return localFutureTask;
      }
      a.execute(paramModule);
      return localFutureTask;
    }
    paramConcurrentCallable.getQueueToken().a().a(paramModule);
    return localFutureTask;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/ConcurrentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */