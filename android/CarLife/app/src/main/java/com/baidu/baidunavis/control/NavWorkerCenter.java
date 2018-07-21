package com.baidu.baidunavis.control;

import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNDownloadPage;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentCallable;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.mapframework.nirvana.schedule.TaskType;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerCenterAbs;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.BNWorkerTask;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class NavWorkerCenter
  extends BNWorkerCenterAbs
{
  private Map<Integer, WeakReference<LooperTask>> mMainTaskMap = new ConcurrentHashMap();
  private Module module = Module.NAV_MODULE;
  private QueueToken normalToken = ConcurrentManager.obtainTaskQueue(this.module);
  
  private ScheduleConfig getConfig(BNWorkerConfig paramBNWorkerConfig)
  {
    if (paramBNWorkerConfig == null) {
      return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
    }
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject3;
    switch (paramBNWorkerConfig.type)
    {
    default: 
      localObject1 = DataTaskType.forUpdateData();
      localObject2 = localObject3;
    case 4: 
    case 5: 
    case 6: 
    case 9: 
      switch (paramBNWorkerConfig.tag)
      {
      }
      break;
    }
    for (paramBNWorkerConfig = ScheduleTag.NULL;; paramBNWorkerConfig = ScheduleTag.SETUP)
    {
      if ((localObject2 == null) || (paramBNWorkerConfig == null)) {
        break label256;
      }
      return new ScheduleConfig((TaskType)localObject2, paramBNWorkerConfig);
      localObject2 = UITaskType.forPage(BNRouteGuideFragment.class.getName());
      localObject1 = localObject4;
      break;
      localObject2 = UITaskType.forPage(BNDownloadPage.class.getName());
      localObject1 = localObject4;
      break;
      localObject2 = UITaskType.forPage(BNCruiserFragment.class.getName());
      localObject1 = localObject4;
      break;
      localObject1 = DataTaskType.forUpdateData();
      localObject2 = localObject3;
      break;
      localObject1 = DataTaskType.forDownload();
      localObject2 = localObject3;
      break;
      localObject1 = DataTaskType.forStatictics();
      localObject2 = localObject3;
      break;
    }
    label256:
    if ((localObject1 != null) && (paramBNWorkerConfig != null)) {
      return new ScheduleConfig((TaskType)localObject1, paramBNWorkerConfig);
    }
    return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
  }
  
  public <K, T> boolean cancelTask(BNWorkerTask<K, T> paramBNWorkerTask, boolean paramBoolean)
  {
    paramBoolean = super.cancelTask(paramBNWorkerTask, paramBoolean);
    if (paramBNWorkerTask != null)
    {
      LogUtil.e(BNWorkerCenter.TAG, "cancelTask() taskid=" + paramBNWorkerTask.hashCode());
      if (!this.mMainTaskMap.containsKey(Integer.valueOf(paramBNWorkerTask.hashCode()))) {
        break label151;
      }
      WeakReference localWeakReference = (WeakReference)this.mMainTaskMap.get(Integer.valueOf(paramBNWorkerTask.hashCode()));
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((LooperTask)localWeakReference.get()).cancel();
        this.mMainTaskMap.remove(Integer.valueOf(paramBNWorkerTask.hashCode()));
        LogUtil.e(BNWorkerCenter.TAG, "cancelTask() cancel ok in base.");
      }
    }
    for (;;)
    {
      LogUtil.e(BNWorkerCenter.TAG, "cancelTask() superRet=" + paramBoolean);
      return paramBoolean;
      label151:
      LogUtil.e(BNWorkerCenter.TAG, "cancelTask() not found in base queue.");
    }
  }
  
  public <K, T> void submitMainThreadTask(final BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (paramBNWorkerNormalTask == null) {
      return;
    }
    LooperTask local2 = new LooperTask()
    {
      public void run()
      {
        if (paramBNWorkerNormalTask != null) {}
        try
        {
          paramBNWorkerNormalTask.call();
          return;
        }
        catch (Exception localException)
        {
          LogUtil.e(BNWorkerCenter.TAG, "mianthreadtask:" + paramBNWorkerNormalTask.getTaskName() + " - execute ex. ex=" + localException.getMessage());
        }
      }
    };
    this.mMainTaskMap.put(Integer.valueOf(paramBNWorkerNormalTask.hashCode()), new WeakReference(local2));
    LooperManager.executeTask(this.module, local2, getConfig(paramBNWorkerConfig));
  }
  
  public <K, T> void submitQueneTask(final BNWorkerNormalTask<K, T> paramBNWorkerNormalTask, BNWorkerConfig paramBNWorkerConfig)
  {
    paramBNWorkerNormalTask = new ConcurrentTask()
    {
      public void run()
      {
        if (paramBNWorkerNormalTask != null) {}
        try
        {
          paramBNWorkerNormalTask.call();
          return;
        }
        catch (Exception localException)
        {
          LogUtil.e(BNWorkerCenter.TAG, "quenetask:" + paramBNWorkerNormalTask.getTaskName() + " - execute ex. ex=" + localException.getMessage());
        }
      }
    };
    paramBNWorkerNormalTask.setQueueToken(this.normalToken);
    ConcurrentManager.executeTask(this.module, paramBNWorkerNormalTask, getConfig(paramBNWorkerConfig));
  }
  
  public <K, T> Future<?> submitTask(BNWorkerTask<K, T> paramBNWorkerTask, BNWorkerConfig paramBNWorkerConfig)
  {
    if (!checkTask(paramBNWorkerTask)) {
      paramBNWorkerConfig = null;
    }
    FutureTask localFutureTask;
    do
    {
      return paramBNWorkerConfig;
      localFutureTask = ConcurrentManager.submitTask(this.module, new NavConcurrentCallable(paramBNWorkerTask), getConfig(paramBNWorkerConfig));
      paramBNWorkerConfig = localFutureTask;
    } while (localFutureTask == null);
    this.taskFutures.put(paramBNWorkerTask, localFutureTask);
    return localFutureTask;
  }
  
  private static class NavConcurrentCallable<K, T>
    extends ConcurrentCallable<T>
  {
    private BNWorkerTask<K, T> workerTask = null;
    
    public NavConcurrentCallable(BNWorkerTask<K, T> paramBNWorkerTask)
    {
      this.workerTask = paramBNWorkerTask;
    }
    
    public T call()
    {
      if (this.workerTask != null) {
        try
        {
          Object localObject = this.workerTask.call();
          return (T)localObject;
        }
        catch (Exception localException)
        {
          LogUtil.e(BNWorkerCenter.TAG, "concurrenttask:" + this.workerTask.getTaskName() + " - execute ex. ex=" + localException.getMessage());
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavWorkerCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */