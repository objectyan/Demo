package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.LinkedList;

public class LooperBuffer
{
  private static final String a = LooperBuffer.class.getSimpleName();
  private static final long b = 16L;
  private static final long c = 800L;
  private static final long d = 100L;
  private final boolean e;
  private volatile boolean f;
  private final LinkedList<Runnable> g;
  private volatile int h = 0;
  private Handler i = new Handler(Looper.getMainLooper());
  private long j = 0L;
  
  public LooperBuffer(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = false;
    this.g = new LinkedList();
  }
  
  private void a()
  {
    synchronized (this.g)
    {
      long l = System.currentTimeMillis();
      if ((!this.g.isEmpty()) && (System.currentTimeMillis() - l < 16L)) {
        ((Runnable)this.g.removeFirst()).run();
      }
    }
    if (!this.g.isEmpty()) {
      b();
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.g)
    {
      this.g.addLast(paramRunnable);
      return;
    }
  }
  
  private void b()
  {
    if (this.h >= 3) {
      return;
    }
    this.h += 1;
    LooperManager.executeTask(Module.BASE_FRAMEWORK_MODULE, new LooperTask()
    {
      public void run()
      {
        LooperBuffer.a(LooperBuffer.this);
      }
    }, ScheduleConfig.forData());
  }
  
  private void c()
  {
    try
    {
      if (this.j == 0L) {
        this.j = System.currentTimeMillis();
      }
      this.i.postDelayed(new Runnable()
      {
        public void run()
        {
          if (!LooperBuffer.b(LooperBuffer.this)) {
            LooperBuffer.c(LooperBuffer.this);
          }
        }
      }, 100L);
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/baidu/mapframework/nirvana/looper/LooperBuffer:f	Z
    //   6: ifeq +14 -> 20
    //   9: aload_0
    //   10: getfield 63	com/baidu/mapframework/nirvana/looper/LooperBuffer:j	J
    //   13: lstore_1
    //   14: lload_1
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +9 -> 26
    //   20: iconst_1
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   29: aload_0
    //   30: getfield 63	com/baidu/mapframework/nirvana/looper/LooperBuffer:j	J
    //   33: lsub
    //   34: ldc2_w 16
    //   37: lcmp
    //   38: ifle +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 133	com/baidu/mapframework/nirvana/looper/LooperBuffer:stopAnim	()V
    //   45: iconst_0
    //   46: istore_3
    //   47: goto -25 -> 22
    //   50: astore 4
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 4
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	LooperBuffer
    //   13	2	1	l	long
    //   21	26	3	bool	boolean
    //   50	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	50	finally
    //   26	45	50	finally
  }
  
  private void e()
  {
    try
    {
      this.j = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void run(Runnable paramRunnable)
  {
    if (!this.e) {
      paramRunnable.run();
    }
    do
    {
      return;
      a(paramRunnable);
    } while (this.f);
    a();
  }
  
  public void startAnim()
  {
    try
    {
      this.f = true;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopAnim()
  {
    try
    {
      this.f = false;
      e();
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/LooperBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */