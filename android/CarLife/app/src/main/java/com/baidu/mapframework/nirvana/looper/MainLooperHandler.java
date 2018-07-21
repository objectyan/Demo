package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapframework.nirvana.b;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.n;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import org.jetbrains.annotations.NotNull;

public abstract class MainLooperHandler
  extends Handler
{
  private final ScheduleConfig config;
  private b exceptionCallback;
  private final Module module;
  
  public MainLooperHandler(@NotNull Module paramModule, @NotNull ScheduleConfig paramScheduleConfig)
  {
    super(Looper.getMainLooper());
    this.module = paramModule;
    this.config = paramScheduleConfig;
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
  }
  
  public b getExceptionCallback()
  {
    return this.exceptionCallback;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    final Message localMessage = Message.obtain();
    localMessage.copyFrom(paramMessage);
    e.c().run(new Runnable()
    {
      public void run()
      {
        e.b().a(localMessage);
        try
        {
          MainLooperHandler.this.onMessage(localMessage);
          e.b().b(localMessage);
          localMessage.recycle();
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            n.a("MainLooperHandler handleMessage exception", localException);
            if (MainLooperHandler.this.exceptionCallback != null) {
              MainLooperHandler.this.exceptionCallback.a(localException);
            }
          }
        }
      }
    });
  }
  
  public abstract void onMessage(Message paramMessage);
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    e.b().a(c.c, paramMessage, this.module, this.config);
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
  
  public void setExceptionCallback(b paramb)
  {
    this.exceptionCallback = paramb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/MainLooperHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */