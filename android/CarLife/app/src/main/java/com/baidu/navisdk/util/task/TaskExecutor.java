package com.baidu.navisdk.util.task;

import android.os.Looper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskExecutor
  implements TaskRunnable.OnRunListener
{
  private static final int STATE_ADD = 1;
  private static final int STATE_CANCLE = 4;
  private static final int STATE_END = 3;
  private static final int STATE_INIT = 0;
  private static final int STATE_START = 2;
  private static final String TAG = "TaskExecutor";
  private ArrayList<TaskRunnable<String, String>> mBackgroundTaskList = new ArrayList();
  private TaskCallback mCallbackListener;
  private ArrayList<TaskRunnable<String, String>> mMainTaskList = new ArrayList();
  private int mState = 0;
  
  public static TaskExecutor create()
  {
    return new TaskExecutor();
  }
  
  public TaskExecutor addTask(TaskRunnable<String, String> paramTaskRunnable)
  {
    if (this.mState == 3) {
      throw new RuntimeException("current taskExecutor has end, need renew instance");
    }
    this.mState = 1;
    switch (paramTaskRunnable.mType)
    {
    default: 
      return this;
    case 1: 
      paramTaskRunnable.setOnRunListener(this);
      this.mBackgroundTaskList.add(paramTaskRunnable);
      return this;
    }
    paramTaskRunnable.setOnRunListener(this);
    this.mMainTaskList.add(paramTaskRunnable);
    return this;
  }
  
  public void cancleAll()
  {
    this.mState = 4;
    Object localObject;
    TaskRunnable localTaskRunnable;
    if (!this.mBackgroundTaskList.isEmpty())
    {
      localObject = new ArrayList(this.mBackgroundTaskList);
      this.mBackgroundTaskList.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTaskRunnable = (TaskRunnable)((Iterator)localObject).next();
        BNWorkerCenter.getInstance().cancelTask(localTaskRunnable, false);
      }
    }
    if (!this.mMainTaskList.isEmpty())
    {
      localObject = new ArrayList(this.mMainTaskList);
      this.mMainTaskList.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTaskRunnable = (TaskRunnable)((Iterator)localObject).next();
        BNWorkerCenter.getInstance().cancelTask(localTaskRunnable, false);
      }
    }
  }
  
  public void onComplete(TaskRunnable<?, ?> paramTaskRunnable)
  {
    if (this.mMainTaskList.contains(paramTaskRunnable)) {
      this.mMainTaskList.remove(paramTaskRunnable);
    }
    if (this.mBackgroundTaskList.contains(paramTaskRunnable)) {
      this.mBackgroundTaskList.remove(paramTaskRunnable);
    }
    if ((this.mMainTaskList.isEmpty()) && (this.mBackgroundTaskList.isEmpty()))
    {
      this.mState = 3;
      if (this.mCallbackListener != null) {}
    }
    else
    {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.mCallbackListener.onComplete();
      return;
    }
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("onComplete-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        TaskExecutor.this.mCallbackListener.onComplete();
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public void setCallback(TaskCallback paramTaskCallback)
  {
    this.mCallbackListener = paramTaskCallback;
  }
  
  public void start()
  {
    if (this.mState == 3) {
      throw new RuntimeException("current taskExecutor has end, need renew instance");
    }
    if (this.mState == 4) {
      LogUtil.e("TaskExecutor", "start return state_cancle");
    }
    for (;;)
    {
      return;
      this.mState = 2;
      Iterator localIterator = new ArrayList(this.mBackgroundTaskList).iterator();
      TaskRunnable localTaskRunnable;
      while (localIterator.hasNext())
      {
        localTaskRunnable = (TaskRunnable)localIterator.next();
        BNWorkerCenter.getInstance().submitNormalTask(localTaskRunnable, new BNWorkerConfig(2, 0));
      }
      localIterator = new ArrayList(this.mMainTaskList).iterator();
      while (localIterator.hasNext())
      {
        localTaskRunnable = (TaskRunnable)localIterator.next();
        BNWorkerCenter.getInstance().submitMainThreadTask(localTaskRunnable, new BNWorkerConfig(2, 0));
      }
    }
  }
  
  public static abstract interface TaskCallback
  {
    public abstract void onComplete();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/task/TaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */