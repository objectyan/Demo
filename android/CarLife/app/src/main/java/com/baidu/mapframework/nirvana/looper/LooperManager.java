package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.b;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.n;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

public class LooperManager
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private static final IdleRunner b = new IdleRunner(a);
  
  private static Runnable a(BaseLooperTask paramBaseLooperTask, final ScheduleConfig paramScheduleConfig)
  {
    new Runnable()
    {
      public void run()
      {
        e.c().run(new Runnable()
        {
          public void run()
          {
            e.b().a(LooperManager.2.this.a);
            try
            {
              if ((!LooperManager.2.this.a.isCancel()) && (LooperManager.2.this.b.isLifecycleActive())) {
                LooperManager.2.this.a.run();
              }
              e.b().b(LooperManager.2.this.a);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b localb = LooperManager.2.this.a.getExceptionCallback();
                if (localb != null) {
                  localb.a(localException);
                } else {
                  e.a("LooperManager", localException);
                }
              }
            }
          }
        });
      }
    };
  }
  
  public static DiscreteQueueToken createDiscreteQueue(Module paramModule)
  {
    return new DiscreteQueueToken(new DiscreteRunner(a));
  }
  
  public static void destroyDiscreteQueue(DiscreteQueueToken paramDiscreteQueueToken)
  {
    paramDiscreteQueueToken.a().a();
  }
  
  public static void executeTask(@NotNull Module paramModule, @NotNull LooperTask paramLooperTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramLooperTask, paramScheduleConfig)) {
      return;
    }
    e.b().a(c.c, paramLooperTask, paramModule, paramScheduleConfig);
    paramModule = a(paramLooperTask, paramScheduleConfig);
    paramLooperTask.setOnCancel(new Runnable()
    {
      public void run()
      {
        LooperManager.a().removeCallbacks(this.a);
      }
    });
    a.postDelayed(paramModule, paramLooperTask.getDelay());
  }
  
  public static void executeTaskDiscreted(@NotNull Module paramModule, @NotNull DiscreteQueueToken paramDiscreteQueueToken, @NotNull DiscreteLooperTask paramDiscreteLooperTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if ((!n.a(paramModule, paramDiscreteLooperTask, paramScheduleConfig)) || (paramDiscreteQueueToken == null)) {
      return;
    }
    paramDiscreteLooperTask.appendDescription("executeTaskDiscreted");
    paramDiscreteLooperTask.appendDescription("DiscreteQueueToken " + paramDiscreteQueueToken.hashCode());
    e.b().a(c.c, paramDiscreteLooperTask, paramModule, paramScheduleConfig);
    paramDiscreteQueueToken.a().a(a(paramDiscreteLooperTask, paramScheduleConfig));
  }
  
  public static void executeTaskWhenIdle(@NotNull Module paramModule, @NotNull DiscreteLooperTask paramDiscreteLooperTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramDiscreteLooperTask, paramScheduleConfig)) {
      return;
    }
    paramDiscreteLooperTask.appendDescription("executeTaskWhenIdle");
    e.b().a(c.c, paramDiscreteLooperTask, paramModule, paramScheduleConfig);
    b.a(a(paramDiscreteLooperTask, paramScheduleConfig));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/LooperManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */