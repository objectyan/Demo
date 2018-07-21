package com.baidu.mapframework.nirvana.looper;

import com.baidu.mapframework.nirvana.g;

public abstract class BaseLooperTask
  extends g
  implements Runnable
{
  private boolean isCancel = false;
  private Runnable onCancelRunnable = null;
  
  public void cancel()
  {
    try
    {
      this.isCancel = true;
      if (this.onCancelRunnable != null) {
        this.onCancelRunnable.run();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isCancel()
  {
    try
    {
      boolean bool = this.isCancel;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void setOnCancel(Runnable paramRunnable)
  {
    try
    {
      this.onCancelRunnable = paramRunnable;
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/BaseLooperTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */