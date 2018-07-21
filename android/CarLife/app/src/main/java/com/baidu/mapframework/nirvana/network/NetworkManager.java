package com.baidu.mapframework.nirvana.network;

import com.baidu.mapframework.nirvana.b;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.d;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.n;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;

public class NetworkManager
{
  private static final ExecutorService a = d.a("NetworkManager");
  
  public static void excuteRunnable(@NotNull Runnable paramRunnable)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          this.a.run();
          return;
        }
        catch (Exception localException)
        {
          n.a("NetworkManager executeTask exception", localException);
        }
      }
    });
  }
  
  public static void executeTask(@NotNull Module paramModule, @NotNull NetworkTask paramNetworkTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramNetworkTask, paramScheduleConfig)) {
      return;
    }
    e.b().a(c.d, paramNetworkTask, paramModule, paramScheduleConfig);
    a.execute(new Runnable()
    {
      public void run()
      {
        e.b().a(this.a);
        try
        {
          this.a.a.run();
          e.b().b(this.a);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            n.a("NetworkManager executeTask exception", localException);
            b localb = this.a.getExceptionCallback();
            if (localb != null) {
              localb.a(localException);
            } else {
              e.a("NetworkManager", localException);
            }
          }
        }
      }
    });
  }
  
  public static ExecutorService getAppNetworkThreadPool()
  {
    return a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/NetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */