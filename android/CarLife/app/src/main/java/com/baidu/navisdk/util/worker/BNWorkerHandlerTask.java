package com.baidu.navisdk.util.worker;

import android.os.Handler;
import android.os.Message;

public abstract class BNWorkerHandlerTask<K, T>
  extends BNWorkerTask<K, T>
{
  private Handler handler = null;
  private int rspMsgWhat = 55537;
  
  public BNWorkerHandlerTask(String paramString, K paramK, Handler paramHandler, int paramInt)
  {
    super(paramString, paramK);
    this.handler = paramHandler;
    this.rspMsgWhat = paramInt;
  }
  
  protected final void notifyResult(T paramT)
  {
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage();
      localMessage.what = this.rspMsgWhat;
      localMessage.obj = paramT;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerHandlerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */