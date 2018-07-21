package com.baidu.mapframework.nirvana.looper;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

class IdleRunner
{
  private static final boolean a;
  private final LinkedList<Runnable> b = new LinkedList();
  private final Handler c;
  private boolean d;
  private final MessageQueue.IdleHandler e = new MessageQueue.IdleHandler()
  {
    /* Error */
    public boolean queueIdle()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/baidu/mapframework/nirvana/looper/IdleRunner$1:a	Lcom/baidu/mapframework/nirvana/looper/IdleRunner;
      //   4: invokestatic 25	com/baidu/mapframework/nirvana/looper/IdleRunner:a	(Lcom/baidu/mapframework/nirvana/looper/IdleRunner;)Ljava/util/LinkedList;
      //   7: invokevirtual 30	java/util/LinkedList:isEmpty	()Z
      //   10: ifne +21 -> 31
      //   13: aload_0
      //   14: getfield 14	com/baidu/mapframework/nirvana/looper/IdleRunner$1:a	Lcom/baidu/mapframework/nirvana/looper/IdleRunner;
      //   17: invokestatic 25	com/baidu/mapframework/nirvana/looper/IdleRunner:a	(Lcom/baidu/mapframework/nirvana/looper/IdleRunner;)Ljava/util/LinkedList;
      //   20: invokevirtual 34	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
      //   23: checkcast 36	java/lang/Runnable
      //   26: invokeinterface 39 1 0
      //   31: aload_0
      //   32: getfield 14	com/baidu/mapframework/nirvana/looper/IdleRunner$1:a	Lcom/baidu/mapframework/nirvana/looper/IdleRunner;
      //   35: astore_1
      //   36: aload_1
      //   37: monitorenter
      //   38: aload_0
      //   39: getfield 14	com/baidu/mapframework/nirvana/looper/IdleRunner$1:a	Lcom/baidu/mapframework/nirvana/looper/IdleRunner;
      //   42: invokestatic 25	com/baidu/mapframework/nirvana/looper/IdleRunner:a	(Lcom/baidu/mapframework/nirvana/looper/IdleRunner;)Ljava/util/LinkedList;
      //   45: invokevirtual 30	java/util/LinkedList:isEmpty	()Z
      //   48: ifeq +26 -> 74
      //   51: aload_0
      //   52: getfield 14	com/baidu/mapframework/nirvana/looper/IdleRunner$1:a	Lcom/baidu/mapframework/nirvana/looper/IdleRunner;
      //   55: iconst_0
      //   56: invokestatic 42	com/baidu/mapframework/nirvana/looper/IdleRunner:a	(Lcom/baidu/mapframework/nirvana/looper/IdleRunner;Z)Z
      //   59: pop
      //   60: aload_1
      //   61: monitorexit
      //   62: iconst_0
      //   63: ireturn
      //   64: astore_1
      //   65: ldc 44
      //   67: aload_1
      //   68: invokestatic 49	com/baidu/mapframework/nirvana/n:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   71: goto -40 -> 31
      //   74: aload_1
      //   75: monitorexit
      //   76: iconst_1
      //   77: ireturn
      //   78: astore_2
      //   79: aload_1
      //   80: monitorexit
      //   81: aload_2
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	1
      //   64	16	1	localException	Exception
      //   78	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	31	64	java/lang/Exception
      //   38	62	78	finally
      //   74	76	78	finally
      //   79	81	78	finally
    }
  };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  IdleRunner(Handler paramHandler)
  {
    this.c = paramHandler;
    this.d = false;
  }
  
  void a(Runnable paramRunnable)
  {
    if (a) {
      try
      {
        this.b.addLast(paramRunnable);
        if (!this.d)
        {
          this.d = true;
          Looper.getMainLooper().getQueue().addIdleHandler(this.e);
        }
        return;
      }
      finally {}
    }
    this.c.post(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/IdleRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */