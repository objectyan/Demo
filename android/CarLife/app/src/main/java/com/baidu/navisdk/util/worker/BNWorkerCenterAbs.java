package com.baidu.navisdk.util.worker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class BNWorkerCenterAbs
  implements IBNWorkerCenter
{
  private static final int MSG_MAINTHREAD_TASK_DELAY = 2;
  private static final int MSG_NORMAL_TASK_DELAY = 1;
  private static final int MSG_QUEUE_TASK_DELAY = 3;
  private static final int TYPE_MAINTHREAD_TASK_DELAY = 2;
  private static final int TYPE_NORMAL_TASK_DELAY = 1;
  private static final int TYPE_QUEUE_TASK_DELAY = 3;
  private Handler mHandler = new Handler(CommonHandlerThread.getInstance().getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      LogUtil.e(BNWorkerCenter.TAG, "handleMessage() what=hashcode=" + paramAnonymousMessage.what);
      if ((paramAnonymousMessage.arg1 == 1) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof BNWorkerCenterAbs.TaskWrapper)))
      {
        paramAnonymousMessage = (BNWorkerCenterAbs.TaskWrapper)paramAnonymousMessage.obj;
        BNWorkerCenterAbs.this.submitTask(paramAnonymousMessage.task, paramAnonymousMessage.config);
      }
      do
      {
        return;
        if ((paramAnonymousMessage.arg1 == 2) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof BNWorkerCenterAbs.TaskWrapper)))
        {
          paramAnonymousMessage = (BNWorkerCenterAbs.TaskWrapper)paramAnonymousMessage.obj;
          BNWorkerCenterAbs.this.submitMainThreadTask((BNWorkerNormalTask)paramAnonymousMessage.task, paramAnonymousMessage.config);
          return;
        }
      } while ((paramAnonymousMessage.arg1 != 3) || (paramAnonymousMessage.obj == null) || (!(paramAnonymousMessage.obj instanceof BNWorkerCenterAbs.TaskWrapper)));
      paramAnonymousMessage = (BNWorkerCenterAbs.TaskWrapper)paramAnonymousMessage.obj;
      BNWorkerCenterAbs.this.submitQueneTask((BNWorkerNormalTask)paramAnonymousMessage.task, paramAnonymousMessage.config);
    }
  };
  protected Map<BNWorkerTask<?, ?>, Future<?>> taskFutures = new ConcurrentHashMap();
  
  public <K, T> boolean cancelTask(BNWorkerTask<K, T> paramBNWorkerTask, boolean paramBoolean)
  {
    if (paramBNWorkerTask == null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "cancelTask() return for the task is null.");
      paramBoolean = false;
    }
    do
    {
      do
      {
        return paramBoolean;
        if ((LogUtil.LOGGABLE) && (paramBNWorkerTask != null)) {
          LogUtil.e(BNWorkerCenter.TAG, "cancelTask() task.hashcode=" + paramBNWorkerTask.hashCode());
        }
        boolean bool2 = false;
        try
        {
          paramBNWorkerTask.isCancelled = true;
          if (this.mHandler.hasMessages(paramBNWorkerTask.hashCode()))
          {
            this.mHandler.removeMessages(paramBNWorkerTask.hashCode());
            bool2 = true;
            LogUtil.e(BNWorkerCenter.TAG, "cancelTask() find in messages queue. task.hashcode=" + paramBNWorkerTask.hashCode() + " taskName:" + paramBNWorkerTask.getTaskName());
          }
          bool1 = bool2;
          if (paramBNWorkerTask != null)
          {
            bool1 = bool2;
            if (this.taskFutures.containsKey(paramBNWorkerTask))
            {
              bool1 = ((Future)this.taskFutures.get(paramBNWorkerTask)).cancel(paramBoolean);
              LogUtil.e(BNWorkerCenter.TAG, "cancelTask() find in taskFutures. task.hashcode=" + paramBNWorkerTask.hashCode() + " taskName:" + paramBNWorkerTask.getTaskName());
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (LogUtil.LOGGABLE) {
              localException.printStackTrace();
            }
            boolean bool1 = false;
          }
        }
        paramBoolean = bool1;
      } while (!LogUtil.LOGGABLE);
      paramBoolean = bool1;
    } while (paramBNWorkerTask == null);
    LogUtil.e(BNWorkerCenter.TAG, "cancelTask() taskName=" + paramBNWorkerTask.getTaskName() + ", isCancelOK=" + bool1);
    return bool1;
  }
  
  protected boolean checkTask(BNWorkerTask<?, ?> paramBNWorkerTask)
  {
    if (paramBNWorkerTask == null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "checkTask() task is null.");
      return false;
    }
    LogUtil.e(BNWorkerCenter.TAG, "checkTask() taskname=" + paramBNWorkerTask.getTaskName());
    return true;
  }
  
  public <K, T> Future<?> removeTask(BNWorkerTask<K, T> paramBNWorkerTask)
  {
    if ((paramBNWorkerTask != null) && (this.taskFutures.containsKey(paramBNWorkerTask))) {
      return (Future)this.taskFutures.remove(paramBNWorkerTask);
    }
    return null;
  }
  
  public <K, T> void submitBlockTask(BNWorkerBlockTask<K, T> paramBNWorkerBlockTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (paramBNWorkerBlockTask == null) {
      LogUtil.e(BNWorkerCenter.TAG, "submitBlockTask() task is null !!!");
    }
    do
    {
      for (;;)
      {
        return;
        paramBNWorkerBlockTask = submitTask(paramBNWorkerBlockTask, paramBNWorkerConfig);
        try
        {
          paramBNWorkerBlockTask.get();
          return;
        }
        catch (InterruptedException paramBNWorkerBlockTask)
        {
          if (LogUtil.LOGGABLE)
          {
            paramBNWorkerBlockTask.printStackTrace();
            return;
          }
        }
        catch (ExecutionException paramBNWorkerBlockTask) {}
      }
    } while (!LogUtil.LOGGABLE);
    paramBNWorkerBlockTask.printStackTrace();
  }
  
  public <K, T> void submitCallbackTask(BNWorkerCallbackTask<K, T> paramBNWorkerCallbackTask, BNWorkerConfig paramBNWorkerConfig)
  {
    submitTask(paramBNWorkerCallbackTask, paramBNWorkerConfig);
  }
  
  public <K, T> void submitHandlerTask(BNWorkerHandlerTask<K, T> paramBNWorkerHandlerTask, BNWorkerConfig paramBNWorkerConfig)
  {
    submitTask(paramBNWorkerHandlerTask, paramBNWorkerConfig);
  }
  
  public <K, T> void submitLooperChildThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig) {}
  
  public <K, T> void submitMainThreadTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig) {}
  
  public <K, T> void submitMainThreadTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (paramBNWorkerNormalTask == null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "submitMainThreadTaskDelay() task is null !!!");
      return;
    }
    paramBNWorkerConfig = new TaskWrapper(paramBNWorkerNormalTask, paramBNWorkerConfig);
    Message localMessage = this.mHandler.obtainMessage(paramBNWorkerNormalTask.hashCode());
    LogUtil.e(BNWorkerCenter.TAG, "submitMainThreadTaskDelay() what=hashcode=" + paramBNWorkerNormalTask.hashCode() + " taskName" + paramBNWorkerNormalTask.getTaskName());
    localMessage.arg1 = 2;
    localMessage.obj = paramBNWorkerConfig;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public <K, T> void submitNormalTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    submitTask(paramBNWorkerNormalTask, paramBNWorkerConfig);
  }
  
  public <K, T> void submitNormalTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (paramBNWorkerNormalTask == null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "submitNormalTaskDelay() task is null !!!");
      return;
    }
    paramBNWorkerConfig = new TaskWrapper(paramBNWorkerNormalTask, paramBNWorkerConfig);
    LogUtil.e(BNWorkerCenter.TAG, "submitNormalTaskDelay() what=hashcode=" + paramBNWorkerNormalTask.hashCode());
    paramBNWorkerNormalTask = this.mHandler.obtainMessage(paramBNWorkerNormalTask.hashCode());
    paramBNWorkerNormalTask.arg1 = 1;
    paramBNWorkerNormalTask.obj = paramBNWorkerConfig;
    this.mHandler.sendMessageDelayed(paramBNWorkerNormalTask, paramLong);
  }
  
  public <K, T> void submitQueneTask(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig) {}
  
  public <K, T> void submitQueneTaskDelay(BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig, long paramLong)
  {
    if (paramBNWorkerNormalTask == null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "submitQueneTaskDelay() task is null !!!");
      return;
    }
    paramBNWorkerConfig = new TaskWrapper(paramBNWorkerNormalTask, paramBNWorkerConfig);
    LogUtil.e(BNWorkerCenter.TAG, "submitQueneTaskDelay() what=hashcode=" + paramBNWorkerNormalTask.hashCode() + " taskName:" + paramBNWorkerNormalTask.getTaskName());
    paramBNWorkerNormalTask = this.mHandler.obtainMessage(paramBNWorkerNormalTask.hashCode());
    paramBNWorkerNormalTask.arg1 = 3;
    paramBNWorkerNormalTask.obj = paramBNWorkerConfig;
    this.mHandler.sendMessageDelayed(paramBNWorkerNormalTask, paramLong);
  }
  
  public abstract <K, T> Future<?> submitTask(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig);
  
  private static class TaskWrapper<K, T>
  {
    public BNWorkerConfig config = null;
    public BNWorkerTask<K, T> task = null;
    
    public TaskWrapper(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig)
    {
      this.task = paramBNWorkerTask;
      this.config = paramBNWorkerConfig;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerCenterAbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */