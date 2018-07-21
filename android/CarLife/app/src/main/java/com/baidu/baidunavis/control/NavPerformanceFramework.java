package com.baidu.baidunavis.control;

import android.os.Message;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.looper.LooperBuffer;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.navisdk.util.worker.loop.IBNPerformceFramework;

public class NavPerformanceFramework
  implements IBNPerformceFramework
{
  private static final String TAG = NavPerformanceFramework.class.getSimpleName();
  private ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
  private Module module = Module.NAV_MODULE;
  
  public void markFinish(Message paramMessage)
  {
    e.b().b(paramMessage);
  }
  
  public void markRunning(Message paramMessage)
  {
    e.b().a(paramMessage);
  }
  
  public void markSubmit(Message paramMessage)
  {
    e.b().a(c.c, paramMessage, this.module, this.config);
  }
  
  public void runInLooperBuffer(Runnable paramRunnable)
  {
    e.c().run(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavPerformanceFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */