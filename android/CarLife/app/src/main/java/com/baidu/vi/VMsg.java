package com.baidu.vi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class VMsg
{
  private static final boolean DEBUG = false;
  private static Handler g_viMsgHandler;
  private static HandlerThread looperThread;
  
  private static native void OnUserCommand1(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static void destroy()
  {
    if (looperThread != null) {
      looperThread.quit();
    }
    looperThread = null;
    g_viMsgHandler.removeCallbacksAndMessages(null);
    g_viMsgHandler = null;
  }
  
  public static void init()
  {
    looperThread = new HandlerThread("VIMsgThread");
    looperThread.start();
    g_viMsgHandler = new VIHandler(looperThread.getLooper());
  }
  
  private static void postMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (g_viMsgHandler == null) {
      return;
    }
    Handler localHandler = g_viMsgHandler;
    if (paramInt4 == 0) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramInt4))
    {
      Message.obtain(localHandler, paramInt1, paramInt2, paramInt3, localObject).sendToTarget();
      return;
    }
  }
  
  static class VIHandler
    extends Handler
  {
    public VIHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.obj == null) {}
      for (int i = 0;; i = ((Integer)paramMessage.obj).intValue())
      {
        VMsg.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, i);
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/vi/VMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */