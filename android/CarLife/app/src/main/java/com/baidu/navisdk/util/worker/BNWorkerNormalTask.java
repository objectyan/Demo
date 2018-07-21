package com.baidu.navisdk.util.worker;

public abstract class BNWorkerNormalTask<K, T>
  extends BNWorkerTask<K, T>
{
  protected BNWorkerNormalTask(String paramString, K paramK)
  {
    super(paramString, paramK);
  }
  
  public BNWorkerNormalTask(String paramString, K[] paramArrayOfK, boolean paramBoolean)
  {
    super(paramString, paramArrayOfK);
  }
  
  protected abstract T execute();
  
  protected final void notifyResult(T paramT) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerNormalTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */