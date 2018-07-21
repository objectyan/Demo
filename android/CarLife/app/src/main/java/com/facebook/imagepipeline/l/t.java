package com.facebook.imagepipeline.l;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class t
{
  static final String a = "queueTime";
  @VisibleForTesting
  @GuardedBy("this")
  d b;
  @VisibleForTesting
  @GuardedBy("this")
  boolean c;
  @VisibleForTesting
  @GuardedBy("this")
  c d;
  @VisibleForTesting
  @GuardedBy("this")
  long e;
  @VisibleForTesting
  @GuardedBy("this")
  long f;
  private final Executor g;
  private final a h;
  private final Runnable i;
  private final Runnable j;
  private final int k;
  
  public t(Executor paramExecutor, a parama, int paramInt)
  {
    this.g = paramExecutor;
    this.h = parama;
    this.k = paramInt;
    this.i = new Runnable()
    {
      public void run()
      {
        t.a(t.this);
      }
    };
    this.j = new Runnable()
    {
      public void run()
      {
        t.b(t.this);
      }
    };
    this.b = null;
    this.c = false;
    this.d = c.a;
    this.e = 0L;
    this.f = 0L;
  }
  
  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      b.a().schedule(this.j, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    this.j.run();
  }
  
  private static boolean b(d paramd, boolean paramBoolean)
  {
    return (paramBoolean) || (d.e(paramd));
  }
  
  private void d()
  {
    this.g.execute(this.i);
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 63	com/facebook/imagepipeline/l/t:b	Lcom/facebook/imagepipeline/i/d;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 65	com/facebook/imagepipeline/l/t:c	Z
    //   16: istore_3
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 63	com/facebook/imagepipeline/l/t:b	Lcom/facebook/imagepipeline/i/d;
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 65	com/facebook/imagepipeline/l/t:c	Z
    //   27: aload_0
    //   28: getstatic 119	com/facebook/imagepipeline/l/t$c:c	Lcom/facebook/imagepipeline/l/t$c;
    //   31: putfield 69	com/facebook/imagepipeline/l/t:d	Lcom/facebook/imagepipeline/l/t$c;
    //   34: aload_0
    //   35: lload_1
    //   36: putfield 73	com/facebook/imagepipeline/l/t:f	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: iload_3
    //   44: invokestatic 121	com/facebook/imagepipeline/l/t:b	(Lcom/facebook/imagepipeline/i/d;Z)Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: getfield 51	com/facebook/imagepipeline/l/t:h	Lcom/facebook/imagepipeline/l/t$a;
    //   54: aload 4
    //   56: iload_3
    //   57: invokeinterface 124 3 0
    //   62: aload 4
    //   64: invokestatic 127	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   67: aload_0
    //   68: invokespecial 129	com/facebook/imagepipeline/l/t:f	()V
    //   71: return
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    //   79: astore 5
    //   81: aload 4
    //   83: invokestatic 127	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   86: aload_0
    //   87: invokespecial 129	com/facebook/imagepipeline/l/t:f	()V
    //   90: aload 5
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	t
    //   3	33	1	l	long
    //   16	41	3	bool	boolean
    //   10	53	4	locald1	d
    //   72	10	4	locald2	d
    //   79	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	41	72	finally
    //   74	76	72	finally
    //   41	62	79	finally
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 4
    //   5: lconst_0
    //   6: lstore_2
    //   7: iconst_0
    //   8: istore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 69	com/facebook/imagepipeline/l/t:d	Lcom/facebook/imagepipeline/l/t$c;
    //   15: getstatic 130	com/facebook/imagepipeline/l/t$c:d	Lcom/facebook/imagepipeline/l/t$c;
    //   18: if_acmpne +49 -> 67
    //   21: aload_0
    //   22: getfield 73	com/facebook/imagepipeline/l/t:f	J
    //   25: aload_0
    //   26: getfield 53	com/facebook/imagepipeline/l/t:k	I
    //   29: i2l
    //   30: ladd
    //   31: lload 4
    //   33: invokestatic 136	java/lang/Math:max	(JJ)J
    //   36: lstore_2
    //   37: iconst_1
    //   38: istore_1
    //   39: aload_0
    //   40: lload 4
    //   42: putfield 71	com/facebook/imagepipeline/l/t:e	J
    //   45: aload_0
    //   46: getstatic 138	com/facebook/imagepipeline/l/t$c:b	Lcom/facebook/imagepipeline/l/t$c;
    //   49: putfield 69	com/facebook/imagepipeline/l/t:d	Lcom/facebook/imagepipeline/l/t$c;
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_1
    //   55: ifeq +11 -> 66
    //   58: aload_0
    //   59: lload_2
    //   60: lload 4
    //   62: lsub
    //   63: invokespecial 140	com/facebook/imagepipeline/l/t:a	(J)V
    //   66: return
    //   67: aload_0
    //   68: getstatic 67	com/facebook/imagepipeline/l/t$c:a	Lcom/facebook/imagepipeline/l/t$c;
    //   71: putfield 69	com/facebook/imagepipeline/l/t:d	Lcom/facebook/imagepipeline/l/t$c;
    //   74: goto -22 -> 52
    //   77: astore 6
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 6
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	t
    //   8	47	1	m	int
    //   6	54	2	l1	long
    //   3	58	4	l2	long
    //   77	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	77	finally
    //   39	52	77	finally
    //   52	54	77	finally
    //   67	74	77	finally
    //   79	81	77	finally
  }
  
  public void a()
  {
    try
    {
      d locald = this.b;
      this.b = null;
      this.c = false;
      d.d(locald);
      return;
    }
    finally {}
  }
  
  public boolean a(d paramd, boolean paramBoolean)
  {
    if (!b(paramd, paramBoolean)) {
      return false;
    }
    try
    {
      d locald = this.b;
      this.b = d.a(paramd);
      this.c = paramBoolean;
      d.d(locald);
      return true;
    }
    finally {}
  }
  
  public boolean b()
  {
    long l3 = SystemClock.uptimeMillis();
    long l2 = 0L;
    int n = 0;
    for (;;)
    {
      try
      {
        if (!b(this.b, this.c)) {
          return false;
        }
        m = n;
        l1 = l2;
        switch (3.a[this.d.ordinal()])
        {
        case 2: 
          if (m != 0) {
            a(l1 - l3);
          }
          return true;
        }
      }
      finally {}
      long l1 = Math.max(this.f + this.k, l3);
      int m = 1;
      this.e = l3;
      this.d = c.b;
      continue;
      this.d = c.d;
      m = n;
      l1 = l2;
      continue;
      m = n;
      l1 = l2;
    }
  }
  
  public long c()
  {
    try
    {
      long l1 = this.f;
      long l2 = this.e;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd, boolean paramBoolean);
  }
  
  @VisibleForTesting
  static class b
  {
    private static ScheduledExecutorService a;
    
    static ScheduledExecutorService a()
    {
      if (a == null) {
        a = Executors.newSingleThreadScheduledExecutor();
      }
      return a;
    }
  }
  
  @VisibleForTesting
  static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */