package com.facebook.imagepipeline.l;

import com.facebook.common.e.a;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class b<T>
  implements j<T>
{
  private boolean a = false;
  
  protected abstract void a();
  
  protected void a(float paramFloat) {}
  
  protected void a(Exception paramException)
  {
    a.f(getClass(), "unhandled exception", paramException);
  }
  
  protected abstract void a(T paramT, boolean paramBoolean);
  
  protected abstract void a(Throwable paramThrowable);
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   19: aload_0
    //   20: invokevirtual 38	com/facebook/imagepipeline/l/b:a	()V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 40	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Exception;)V
    //   32: goto -21 -> 11
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	b
    //   6	2	1	bool	boolean
    //   26	3	2	localException	Exception
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	23	26	java/lang/Exception
    //   2	7	35	finally
    //   14	19	35	finally
    //   19	23	35	finally
    //   27	32	35	finally
  }
  
  /* Error */
  public void b(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: fload_1
    //   16: invokevirtual 42	com/facebook/imagepipeline/l/b:a	(F)V
    //   19: goto -8 -> 11
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 40	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Exception;)V
    //   28: goto -17 -> 11
    //   31: astore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	b
    //   0	36	1	paramFloat	float
    //   6	2	2	bool	boolean
    //   22	3	3	localException	Exception
    //   31	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	22	java/lang/Exception
    //   2	7	31	finally
    //   14	19	31	finally
    //   23	28	31	finally
  }
  
  /* Error */
  public void b(@javax.annotation.Nullable T paramT, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iload_2
    //   16: putfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   19: aload_0
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual 45	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Object;Z)V
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 40	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Exception;)V
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	b
    //   0	42	1	paramT	T
    //   0	42	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	25	28	java/lang/Exception
    //   2	7	37	finally
    //   14	19	37	finally
    //   19	25	37	finally
    //   29	34	37	finally
  }
  
  /* Error */
  public void b(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 16	com/facebook/imagepipeline/l/b:a	Z
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 50	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Throwable;)V
    //   24: goto -13 -> 11
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 40	com/facebook/imagepipeline/l/b:a	(Ljava/lang/Exception;)V
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	b
    //   0	41	1	paramThrowable	Throwable
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	24	27	java/lang/Exception
    //   2	7	36	finally
    //   14	19	36	finally
    //   19	24	36	finally
    //   28	33	36	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */