package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Future;

public class BNWorkerCenter
  implements IBNWorkerCenter
{
  public static final String TAG = BNWorkerCenter.class.getSimpleName();
  private static BNWorkerCenter sInstance = null;
  private static final Object sInstanceLock = new Object();
  private IBNWorkerCenter mCurWorkerCenter = null;
  
  public static IBNWorkerCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNWorkerCenter();
      }
      return sInstance;
    }
  }
  
  public static void init(IBNWorkerCenter paramIBNWorkerCenter)
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNWorkerCenter();
      }
      if (paramIBNWorkerCenter != null)
      {
        sInstance.setWorkerCenter(paramIBNWorkerCenter);
        LogUtil.e(TAG, "use the outer worker cetner.");
        return;
      }
    }
    sInstance.setWorkerCenter(BNInnerWorkerCenter.getInstance());
    LogUtil.e(TAG, "use the inner worker cetner.");
  }
  
  private void setWorkerCenter(IBNWorkerCenter paramIBNWorkerCenter)
  {
    if (paramIBNWorkerCenter == null)
    {
      LogUtil.e(TAG, "setWorkerCenter() worker center is null !!!");
      return;
    }
    if (this.mCurWorkerCenter != null)
    {
      LogUtil.e(TAG, "setWorkerCenter() return for cur workder center is not null !!!");
      return;
    }
    this.mCurWorkerCenter = paramIBNWorkerCenter;
  }
  
  public <K, T> boolean cancelTask(BNWorkerTask<K, T> paramBNWorkerTask, boolean paramBoolean)
  {
    if (this.mCurWorkerCenter != null) {
      return this.mCurWorkerCenter.cancelTask(paramBNWorkerTask, paramBoolean);
    }
    LogUtil.e(TAG, "worker center is null.");
    return false;
  }
  
  public <K, T> Future<?> removeTask(BNWorkerTask<K, T> paramBNWorkerTask)
  {
    if (this.mCurWorkerCenter != null) {
      return this.mCurWorkerCenter.removeTask(paramBNWorkerTask);
    }
    LogUtil.e(TAG, "worker center is null.");
    return null;
  }
  
  public <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> paramBNWorkerBlockTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerBlockTask.isCancelled = false;
      this.mCurWorkerCenter.submitBlockTask(paramBNWorkerBlockTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> paramBNWorkerCallbackTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerCallbackTask.isCancelled = false;
      this.mCurWorkerCenter.submitCallbackTask(paramBNWorkerCallbackTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> paramBNWorkerHandlerTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerHandlerTask.isCancelled = false;
      this.mCurWorkerCenter.submitHandlerTask(paramBNWorkerHandlerTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitLooperChildThreadTask(paramBNWorkerNormalTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitMainThreadTask(paramBNWorkerNormalTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitMainThreadTaskDelay(paramBNWorkerNormalTask, paramBNWorkerConfig, paramLong);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitNormalTask(paramBNWorkerNormalTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitNormalTaskDelay(paramBNWorkerNormalTask, paramBNWorkerConfig, paramLong);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitQueneTask(paramBNWorkerNormalTask, paramBNWorkerConfig);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerNormalTask.isCancelled = false;
      this.mCurWorkerCenter.submitQueneTaskDelay(paramBNWorkerNormalTask, paramBNWorkerConfig, paramLong);
      return;
    }
    LogUtil.e(TAG, "worker center is null.");
  }
  
  public <K, T> Future<?> submitTask(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (this.mCurWorkerCenter != null)
    {
      paramBNWorkerTask.isCancelled = false;
      return this.mCurWorkerCenter.submitTask(paramBNWorkerTask, paramBNWorkerConfig);
    }
    LogUtil.e(TAG, "worker center is null.");
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */