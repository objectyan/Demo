package com.baidu.navisdk.util.worker;

public abstract class BNWorkerCallbackTask<K, T>
  extends BNWorkerTask<K, T>
{
  public BNWorkerCallbackTask(String paramString, K paramK)
  {
    super(paramString, paramK);
  }
  
  public abstract void callback(T paramT);
  
  protected final void notifyResult(T paramT)
  {
    callback(paramT);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerCallbackTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */