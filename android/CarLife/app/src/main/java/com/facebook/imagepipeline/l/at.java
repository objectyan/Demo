package com.facebook.imagepipeline.l;

import android.util.Pair;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class at<T>
  implements ai<T>
{
  @VisibleForTesting
  static final String a = "ThrottlingProducer";
  private final ai<T> b;
  private final int c;
  @GuardedBy("this")
  private int d;
  @GuardedBy("this")
  private final ConcurrentLinkedQueue<Pair<j<T>, aj>> e;
  private final Executor f;
  
  public at(int paramInt, Executor paramExecutor, ai<T> paramai)
  {
    this.c = paramInt;
    this.f = ((Executor)k.a(paramExecutor));
    this.b = ((ai)k.a(paramai));
    this.e = new ConcurrentLinkedQueue();
    this.d = 0;
  }
  
  /* Error */
  public void a(j<T> paramj, aj paramaj)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 69 1 0
    //   6: aload_2
    //   7: invokeinterface 72 1 0
    //   12: ldc 17
    //   14: invokeinterface 77 3 0
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 57	com/facebook/imagepipeline/l/at:d	I
    //   25: aload_0
    //   26: getfield 39	com/facebook/imagepipeline/l/at:c	I
    //   29: if_icmplt +31 -> 60
    //   32: aload_0
    //   33: getfield 55	com/facebook/imagepipeline/l/at:e	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 83	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   41: invokevirtual 87	java/util/concurrent/ConcurrentLinkedQueue:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_1
    //   46: istore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_3
    //   50: ifne +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 89	com/facebook/imagepipeline/l/at:b	(Lcom/facebook/imagepipeline/l/j;Lcom/facebook/imagepipeline/l/aj;)V
    //   59: return
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 57	com/facebook/imagepipeline/l/at:d	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 57	com/facebook/imagepipeline/l/at:d	I
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -25 -> 47
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	at
    //   0	80	1	paramj	j<T>
    //   0	80	2	paramaj	aj
    //   46	26	3	i	int
    // Exception table:
    //   from	to	target	type
    //   21	45	75	finally
    //   47	49	75	finally
    //   60	70	75	finally
    //   76	78	75	finally
  }
  
  void b(j<T> paramj, aj paramaj)
  {
    paramaj.c().a(paramaj.b(), "ThrottlingProducer", null);
    this.b.a(new a(paramj, null), paramaj);
  }
  
  private class a
    extends m<T, T>
  {
    private a()
    {
      super();
    }
    
    private void c()
    {
      synchronized (at.this)
      {
        final Pair localPair = (Pair)at.a(at.this).poll();
        if (localPair == null) {
          at.b(at.this);
        }
        if (localPair != null) {
          at.c(at.this).execute(new Runnable()
          {
            public void run()
            {
              at.this.b((j)localPair.first, (aj)localPair.second);
            }
          });
        }
        return;
      }
    }
    
    protected void a()
    {
      d().b();
      c();
    }
    
    protected void a(T paramT, boolean paramBoolean)
    {
      d().b(paramT, paramBoolean);
      if (paramBoolean) {
        c();
      }
    }
    
    protected void a(Throwable paramThrowable)
    {
      d().b(paramThrowable);
      c();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */