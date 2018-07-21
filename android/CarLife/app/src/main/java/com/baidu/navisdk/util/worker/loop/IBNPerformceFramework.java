package com.baidu.navisdk.util.worker.loop;

import android.os.Message;

public abstract interface IBNPerformceFramework
{
  public abstract void markFinish(Message paramMessage);
  
  public abstract void markRunning(Message paramMessage);
  
  public abstract void markSubmit(Message paramMessage);
  
  public abstract void runInLooperBuffer(Runnable paramRunnable);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/loop/IBNPerformceFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */