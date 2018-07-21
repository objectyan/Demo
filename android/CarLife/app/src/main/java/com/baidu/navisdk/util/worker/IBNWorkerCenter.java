package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Future;

public abstract interface IBNWorkerCenter
{
  public static final boolean MONITOR_TEST = LogUtil.LOGGABLE;
  
  public abstract <K, T> boolean cancelTask(BNWorkerTask<K, T> paramBNWorkerTask, boolean paramBoolean);
  
  public abstract <K, T> Future<?> removeTask(BNWorkerTask<K, T> paramBNWorkerTask);
  
  public abstract <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> paramBNWorkerBlockTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> paramBNWorkerCallbackTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> paramBNWorkerHandlerTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong);
  
  public abstract <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong);
  
  public abstract <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig);
  
  public abstract <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong);
  
  public abstract <K, T> Future<?> submitTask(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/IBNWorkerCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */