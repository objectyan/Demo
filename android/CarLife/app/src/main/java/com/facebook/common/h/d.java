package com.facebook.common.h;

import com.facebook.common.e.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public class d<T>
{
  @GuardedBy("itself")
  private static final Map<Object, Integer> a = new IdentityHashMap();
  @GuardedBy("this")
  private T b;
  @GuardedBy("this")
  private int c;
  private final c<T> d;
  
  public d(T paramT, c<T> paramc)
  {
    this.b = k.a(paramT);
    this.d = ((c)k.a(paramc));
    this.c = 1;
    a(paramT);
  }
  
  private static void a(Object paramObject)
  {
    synchronized (a)
    {
      Integer localInteger = (Integer)a.get(paramObject);
      if (localInteger == null)
      {
        a.put(paramObject, Integer.valueOf(1));
        return;
      }
      a.put(paramObject, Integer.valueOf(localInteger.intValue() + 1));
    }
  }
  
  public static boolean a(d<?> paramd)
  {
    return (paramd != null) && (paramd.b());
  }
  
  private static void b(Object paramObject)
  {
    for (;;)
    {
      Integer localInteger;
      synchronized (a)
      {
        localInteger = (Integer)a.get(paramObject);
        if (localInteger == null)
        {
          a.f("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[] { paramObject.getClass() });
          return;
        }
        if (localInteger.intValue() == 1) {
          a.remove(paramObject);
        }
      }
      a.put(paramObject, Integer.valueOf(localInteger.intValue() - 1));
    }
  }
  
  /* Error */
  private int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 97	com/facebook/common/h/d:g	()V
    //   6: aload_0
    //   7: getfield 48	com/facebook/common/h/d:c	I
    //   10: ifle +28 -> 38
    //   13: iconst_1
    //   14: istore_2
    //   15: iload_2
    //   16: invokestatic 100	com/facebook/common/internal/k:a	(Z)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 48	com/facebook/common/h/d:c	I
    //   24: iconst_1
    //   25: isub
    //   26: putfield 48	com/facebook/common/h/d:c	I
    //   29: aload_0
    //   30: getfield 48	com/facebook/common/h/d:c	I
    //   33: istore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -25 -> 15
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	d
    //   33	4	1	i	int
    //   14	26	2	bool	boolean
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	43	finally
    //   15	34	43	finally
  }
  
  private void g()
  {
    if (!a(this)) {
      throw new a();
    }
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.b;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/facebook/common/h/d:c	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifle +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	d
    //   6	2	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void c()
  {
    try
    {
      g();
      this.c += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    if (f() == 0) {}
    try
    {
      Object localObject1 = this.b;
      this.b = null;
      this.d.a(localObject1);
      b(localObject1);
      return;
    }
    finally {}
  }
  
  public int e()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class a
    extends RuntimeException
  {
    public a()
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */