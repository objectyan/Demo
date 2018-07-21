package com.baidu.navisdk.util.task;

import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public abstract class TaskRunnable<K, T>
  extends BNWorkerNormalTask<K, T>
{
  public static final int TYPE_BG = 1;
  public static final int TYPE_MAIN = 0;
  private OnRunListener mRunListener;
  public int mType;
  
  public TaskRunnable(String paramString, K paramK, int paramInt)
  {
    super(paramString, paramK);
    this.mType = paramInt;
  }
  
  public abstract void doTask();
  
  public T execute()
  {
    doTask();
    if (this.mRunListener != null) {
      this.mRunListener.onComplete(this);
    }
    return null;
  }
  
  public void setOnRunListener(OnRunListener paramOnRunListener)
  {
    this.mRunListener = paramOnRunListener;
  }
  
  public static abstract interface OnRunListener
  {
    public abstract void onComplete(TaskRunnable<?, ?> paramTaskRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/task/TaskRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */