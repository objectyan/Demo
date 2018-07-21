package com.baidu.navisdk.util.worker.loop;

import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;

public class BNPerformceFramework
  implements IBNPerformceFramework
{
  public static final String TAG = BNPerformceFramework.class.getSimpleName();
  private static BNPerformceFramework sInstance = null;
  private static final Object sInstanceLock = new Object();
  private IBNPerformceFramework mFramework = null;
  
  public static BNPerformceFramework getInstance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNPerformceFramework();
      }
      return sInstance;
    }
  }
  
  public static void init(IBNPerformceFramework paramIBNPerformceFramework)
  {
    getInstance().setFramework(paramIBNPerformceFramework);
  }
  
  private void setFramework(IBNPerformceFramework paramIBNPerformceFramework)
  {
    if (this.mFramework != null)
    {
      LogUtil.e(TAG, "setFramework() framework is not null.");
      return;
    }
    if (paramIBNPerformceFramework == null)
    {
      LogUtil.e(TAG, "setFramework() framework is null.");
      return;
    }
    this.mFramework = paramIBNPerformceFramework;
  }
  
  public void markFinish(Message paramMessage)
  {
    if (paramMessage == null)
    {
      LogUtil.e(TAG, "markFinish() message is null.");
      return;
    }
    if (this.mFramework != null)
    {
      this.mFramework.markFinish(paramMessage);
      return;
    }
    LogUtil.e(TAG, "markFinish() framework is null.");
  }
  
  public void markRunning(Message paramMessage)
  {
    if (paramMessage == null)
    {
      LogUtil.e(TAG, "markRunning() message is null.");
      return;
    }
    if (this.mFramework != null)
    {
      this.mFramework.markRunning(paramMessage);
      return;
    }
    LogUtil.e(TAG, "markRunning() framework is null.");
  }
  
  public void markSubmit(Message paramMessage)
  {
    if (this.mFramework != null)
    {
      this.mFramework.markSubmit(paramMessage);
      return;
    }
    LogUtil.e(TAG, "markSubmit() framework is null.");
  }
  
  public void runInLooperBuffer(Runnable paramRunnable)
  {
    if (paramRunnable == null)
    {
      LogUtil.e(TAG, "runInLooperBuffer() runnable is null.");
      return;
    }
    if (this.mFramework != null)
    {
      this.mFramework.runInLooperBuffer(paramRunnable);
      return;
    }
    LogUtil.e(TAG, "runInLooperBuffer() framework is null.");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/loop/BNPerformceFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */