package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.basic.BMExecutorsManager;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class n
{
  @Nullable
  private static Handler a;
  private static Map<Integer, LooperTask> b = new HashMap();
  
  public static void a(Runnable paramRunnable)
  {
    LooperTask local1 = new LooperTask()
    {
      public void run()
      {
        this.a.run();
        n.e().remove(Integer.valueOf(this.a.hashCode()));
      }
    };
    b.put(Integer.valueOf(paramRunnable.hashCode()), local1);
    LooperManager.executeTask(Module.UNFINISHED_MODULE, local1, ScheduleConfig.forData());
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    LooperTask local2 = new LooperTask(paramLong)
    {
      public void run()
      {
        this.a.run();
        n.e().remove(Integer.valueOf(this.a.hashCode()));
      }
    };
    b.put(Integer.valueOf(paramRunnable.hashCode()), local2);
    LooperManager.executeTask(Module.UNFINISHED_MODULE, local2, ScheduleConfig.forData());
  }
  
  public static boolean a()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static void b()
  {
    if (!a()) {
      throw new RuntimeException("Expected to run on UI thread!");
    }
  }
  
  public static void b(@NotNull Runnable paramRunnable)
  {
    paramRunnable = new ConcurrentTask()
    {
      public void run()
      {
        this.a.run();
      }
    };
    ConcurrentManager.executeTask(Module.UNFINISHED_MODULE, paramRunnable, ScheduleConfig.forData());
  }
  
  public static void c()
  {
    if (a()) {
      throw new RuntimeException("Expected to run on UI thread!");
    }
  }
  
  public static void c(@NotNull Runnable paramRunnable)
    throws InterruptedException, InvocationTargetException
  {
    paramRunnable = BMExecutorsManager.CACHED_EXECUTOR_SERVICE.submit(paramRunnable);
    try
    {
      paramRunnable.get();
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      throw new InvocationTargetException(paramRunnable);
    }
  }
  
  public static void d()
  {
    Iterator localIterator = b.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((LooperTask)b.remove(Integer.valueOf(i))).cancel();
    }
  }
  
  public static void d(Runnable paramRunnable)
  {
    paramRunnable = (LooperTask)b.remove(Integer.valueOf(paramRunnable.hashCode()));
    if (paramRunnable != null) {
      paramRunnable.cancel();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */