package com.baidu.navisdk.util.worker;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class BNInnerWorkerCenter
  extends BNWorkerCenterAbs
{
  private static final int THREADPOOL_COUNT = 3;
  private static IBNWorkerCenter sInstance = null;
  private static final Object sInstanceLock = new Object();
  private ExecutorService executorService = null;
  
  private BNInnerWorkerCenter()
  {
    init();
  }
  
  public static IBNWorkerCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNInnerWorkerCenter();
      }
      return sInstance;
    }
  }
  
  private void init()
  {
    this.executorService = Executors.newFixedThreadPool(3);
  }
  
  public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig) {}
  
  public <K, T> Future<?> submitTask(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig)
  {
    paramBNWorkerConfig = null;
    if (!checkTask(paramBNWorkerTask)) {}
    Future localFuture;
    do
    {
      do
      {
        return paramBNWorkerConfig;
      } while (this.executorService == null);
      localFuture = this.executorService.submit(paramBNWorkerTask);
      paramBNWorkerConfig = localFuture;
    } while (localFuture == null);
    this.taskFutures.put(paramBNWorkerTask, localFuture);
    return localFuture;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNInnerWorkerCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */