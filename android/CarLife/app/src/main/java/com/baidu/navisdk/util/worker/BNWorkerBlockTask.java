package com.baidu.navisdk.util.worker;

public abstract class BNWorkerBlockTask<K, T>
  extends BNWorkerTask<K, T>
{
  protected BNWorkerBlockTask(String paramString, K paramK)
  {
    super(paramString, paramK);
  }
  
  protected final void notifyResult(T paramT) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerBlockTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */