package com.tencent.mm.sdk.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class e
  extends Handler
  implements g.a
{
  private Looper aN = getLooper();
  private Handler.Callback aO;
  a aP;
  
  e(Looper paramLooper, a parama)
  {
    super(paramLooper);
    this.aP = parama;
  }
  
  e(a parama)
  {
    this.aP = parama;
  }
  
  public final void c(Runnable paramRunnable, g paramg)
  {
    if (this.aP != null) {
      this.aP.b(paramRunnable, paramg);
    }
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    if ((paramMessage.getCallback() != null) || (this.aO != null)) {
      super.dispatchMessage(paramMessage);
    }
    do
    {
      return;
      System.currentTimeMillis();
      Debug.threadCpuTimeNanos();
      handleMessage(paramMessage);
    } while (this.aP == null);
    this.aN.getThread();
    System.currentTimeMillis();
    Debug.threadCpuTimeNanos();
  }
  
  public final void handleMessage(Message paramMessage) {}
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (paramMessage != null) {}
    Runnable localRunnable;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msg is null", bool);
      localRunnable = paramMessage.getCallback();
      if (localRunnable != null) {
        break;
      }
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    long l = paramLong - SystemClock.uptimeMillis();
    if (paramMessage.getTarget() == null) {}
    for (Object localObject = this;; localObject = paramMessage.getTarget())
    {
      localObject = new g(this.aN.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
      if (l > 0L) {
        ((g)localObject).aY = l;
      }
      Message localMessage = Message.obtain(paramMessage.getTarget(), (Runnable)localObject);
      localMessage.what = paramMessage.what;
      localMessage.arg1 = paramMessage.arg1;
      localMessage.arg2 = paramMessage.arg2;
      localMessage.obj = paramMessage.obj;
      localMessage.replyTo = paramMessage.replyTo;
      localMessage.setData(paramMessage.getData());
      paramMessage.recycle();
      if (this.aP != null) {
        this.aP.a(localRunnable, (g)localObject);
      }
      bool = super.sendMessageAtTime(localMessage, paramLong);
      if ((!bool) && (this.aP != null)) {
        this.aP.b(localRunnable, (g)localObject);
      }
      return bool;
    }
  }
  
  public final String toString()
  {
    return "MMInnerHandler{listener = " + this.aP + "}";
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable, g paramg);
    
    public abstract void b(Runnable paramRunnable, g paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */