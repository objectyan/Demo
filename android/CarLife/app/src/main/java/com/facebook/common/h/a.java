package com.facebook.common.h;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class a<T>
  implements Closeable, Cloneable
{
  private static Class<a> a = a.class;
  private static final c<Closeable> b = new a.1();
  @GuardedBy("this")
  private boolean c = false;
  private final d<T> d;
  
  private a(d<T> paramd)
  {
    this.d = ((d)k.a(paramd));
    paramd.c();
  }
  
  private a(T paramT, c<T> paramc)
  {
    this.d = new d(paramT, paramc);
  }
  
  @Nullable
  public static <T extends Closeable> a<T> a(@Nullable T paramT)
  {
    if (paramT == null) {
      return null;
    }
    return new a(paramT, b);
  }
  
  @Nullable
  public static <T> a<T> a(@Nullable T paramT, c<T> paramc)
  {
    if (paramT == null) {
      return null;
    }
    return new a(paramT, paramc);
  }
  
  public static <T> List<a<T>> a(Collection<a<T>> paramCollection)
  {
    if (paramCollection == null)
    {
      paramCollection = null;
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    for (;;)
    {
      paramCollection = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(b((a)localIterator.next()));
    }
  }
  
  public static void a(@Nullable Iterable<? extends a<?>> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        c((a)paramIterable.next());
      }
    }
  }
  
  public static boolean a(@Nullable a<?> parama)
  {
    return (parama != null) && (parama.d());
  }
  
  @Nullable
  public static <T> a<T> b(@Nullable a<T> parama)
  {
    if (parama != null) {
      return parama.c();
    }
    return null;
  }
  
  public static void c(@Nullable a<?> parama)
  {
    if (parama != null) {
      parama.close();
    }
  }
  
  /* Error */
  public T a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/h/a:c	Z
    //   6: ifne +21 -> 27
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: invokestatic 123	com/facebook/common/internal/k:b	(Z)V
    //   15: aload_0
    //   16: getfield 48	com/facebook/common/h/a:d	Lcom/facebook/common/h/d;
    //   19: invokevirtual 125	com/facebook/common/h/d:a	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -18 -> 11
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	a
    //   10	19	1	bool	boolean
    //   22	4	2	localObject1	Object
    //   32	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   11	23	32	finally
  }
  
  public a<T> b()
  {
    try
    {
      k.b(d());
      a locala = new a(this.d);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public a<T> c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 111	com/facebook/common/h/a:d	()Z
    //   6: ifeq +19 -> 25
    //   9: new 2	com/facebook/common/h/a
    //   12: dup
    //   13: aload_0
    //   14: getfield 48	com/facebook/common/h/a:d	Lcom/facebook/common/h/d;
    //   17: invokespecial 128	com/facebook/common/h/a:<init>	(Lcom/facebook/common/h/d;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	a
    //   20	7	1	locala	a
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public void close()
  {
    try
    {
      if (this.c) {
        return;
      }
      this.c = true;
      this.d.d();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/h/a:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   6	13	1	bool	boolean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  @VisibleForTesting
  public d<T> e()
  {
    try
    {
      d locald = this.d;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 111	com/facebook/common/h/a:d	()Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 48	com/facebook/common/h/a:d	Lcom/facebook/common/h/d;
    //   13: invokevirtual 125	com/facebook/common/h/d:a	()Ljava/lang/Object;
    //   16: invokestatic 149	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	a
    //   19	7	1	i	int
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/facebook/common/h/a:c	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: invokespecial 154	java/lang/Object:finalize	()V
    //   15: return
    //   16: aload_0
    //   17: monitorexit
    //   18: getstatic 27	com/facebook/common/h/a:a	Ljava/lang/Class;
    //   21: ldc -100
    //   23: iconst_3
    //   24: anewarray 5	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: invokestatic 149	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   33: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 48	com/facebook/common/h/a:d	Lcom/facebook/common/h/d;
    //   43: invokestatic 149	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   46: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: aload_0
    //   53: getfield 48	com/facebook/common/h/a:d	Lcom/facebook/common/h/d;
    //   56: invokevirtual 125	com/facebook/common/h/d:a	()Ljava/lang/Object;
    //   59: invokevirtual 166	java/lang/Object:getClass	()Ljava/lang/Class;
    //   62: invokevirtual 172	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 177	com/facebook/common/e/a:d	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: invokevirtual 119	com/facebook/common/h/a:close	()V
    //   73: aload_0
    //   74: invokespecial 154	java/lang/Object:finalize	()V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: invokespecial 154	java/lang/Object:finalize	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   78	4	1	localObject1	Object
    //   83	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   16	18	78	finally
    //   79	81	78	finally
    //   0	2	83	finally
    //   18	73	83	finally
    //   81	83	83	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/common/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */