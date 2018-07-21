package com.baidu.navisdk.util.worker.loop;

import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.comapi.base.MsgHandler;

public abstract class BNMainLooperMsgHandler
  extends MsgHandler
{
  public BNMainLooperMsgHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    final Message localMessage = Message.obtain();
    localMessage.copyFrom(paramMessage);
    BNPerformceFramework.getInstance().runInLooperBuffer(new Runnable()
    {
      public void run()
      {
        BNPerformceFramework.getInstance().markRunning(localMessage);
        BNMainLooperMsgHandler.this.onMessage(localMessage);
        BNPerformceFramework.getInstance().markFinish(localMessage);
        localMessage.recycle();
      }
    });
  }
  
  public abstract void onMessage(Message paramMessage);
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    BNPerformceFramework.getInstance().markSubmit(paramMessage);
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/loop/BNMainLooperMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */