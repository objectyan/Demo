package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public abstract class BNWorkerTask<K, T>
  implements Callable<T>
{
  public static final String TAG = BNWorkerCenter.TAG;
  protected K inData = null;
  protected K[] inDatas = null;
  volatile boolean isCancelled = false;
  private String taskName = "CarNavi-poly";
  
  protected BNWorkerTask(String paramString, K paramK)
  {
    if (paramString != null) {
      this.taskName = ("CarNavi-" + paramString);
    }
    this.inData = paramK;
  }
  
  protected BNWorkerTask(String paramString, K[] paramArrayOfK)
  {
    if (paramString != null) {
      this.taskName = ("CarNavi-" + paramString);
    }
    this.inDatas = paramArrayOfK;
  }
  
  public final T call()
    throws Exception
  {
    return (T)executeWrapper();
  }
  
  protected abstract T execute();
  
  protected final T executeWrapper()
  {
    long l = 0L;
    if (LogUtil.LOGGABLE)
    {
      LogUtil.e(TAG, "start task execute. task=" + getTaskName());
      l = System.currentTimeMillis();
    }
    Future localFuture = null;
    localObject2 = null;
    localObject1 = localFuture;
    for (;;)
    {
      try
      {
        if (isCancelled()) {
          continue;
        }
        localObject1 = localFuture;
        localObject2 = execute();
        localObject1 = localObject2;
        localFuture = BNWorkerCenter.getInstance().removeTask(this);
        if (localFuture == null) {
          continue;
        }
        localObject1 = localObject2;
        if (!isCancelled())
        {
          localObject1 = localObject2;
          if (!localFuture.isCancelled()) {
            continue;
          }
        }
        localObject1 = localObject2;
        LogUtil.e(TAG, "task has been cancelled. task=" + getTaskName());
      }
      catch (Exception localException)
      {
        LogUtil.e(TAG, "task execute exception. ex=" + localException.getMessage());
        localObject2 = localObject1;
        if (!LogUtil.LOGGABLE) {
          continue;
        }
        localException.printStackTrace();
        localObject2 = localObject1;
        continue;
        localObject1 = localObject2;
        LogUtil.e(TAG, "task not found. task=" + getTaskName());
        continue;
        localObject1 = localException;
        BNWorkerCenter.getInstance().removeTask(this);
        localObject1 = localException;
        LogUtil.e(TAG, "not execute for the task has been cancelled. task=" + getTaskName());
        continue;
      }
      if (LogUtil.LOGGABLE) {
        LogUtil.e(TAG, "end task execute. task=" + getTaskName() + ", executeTime=" + (System.currentTimeMillis() - l));
      }
      return (T)localObject2;
      if (localFuture == null) {
        continue;
      }
      localObject1 = localObject2;
      notifyResult(localObject2);
    }
  }
  
  protected K getInData()
  {
    return (K)this.inData;
  }
  
  protected K[] getInDatas()
  {
    return this.inDatas;
  }
  
  public final String getTaskName()
  {
    return this.taskName;
  }
  
  public boolean isCancelled()
  {
    return this.isCancelled;
  }
  
  protected abstract void notifyResult(T paramT);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */