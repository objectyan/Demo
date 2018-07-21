package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.g.c;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.common.internal.l;
import com.facebook.common.internal.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class a<V>
  implements s<V>
{
  final c a;
  final v b;
  @VisibleForTesting
  final SparseArray<e<V>> c;
  @VisibleForTesting
  final Set<V> d;
  @VisibleForTesting
  @GuardedBy("this")
  final a e;
  @VisibleForTesting
  @GuardedBy("this")
  final a f;
  private final Class<?> g = getClass();
  private boolean h;
  private final w i;
  
  public a(c paramc, v paramv, w paramw)
  {
    this.a = ((c)k.a(paramc));
    this.b = ((v)k.a(paramv));
    this.i = ((w)k.a(paramw));
    this.c = new SparseArray();
    a(new SparseIntArray(0));
    this.d = l.b();
    this.f = new a();
    this.e = new a();
  }
  
  /* Error */
  private void a(SparseIntArray paramSparseIntArray)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 57	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 74	com/facebook/imagepipeline/memory/a:c	Landroid/util/SparseArray;
    //   11: invokevirtual 98	android/util/SparseArray:clear	()V
    //   14: aload_0
    //   15: getfield 65	com/facebook/imagepipeline/memory/a:b	Lcom/facebook/imagepipeline/memory/v;
    //   18: getfield 101	com/facebook/imagepipeline/memory/v:d	Landroid/util/SparseIntArray;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnull +76 -> 101
    //   28: iconst_0
    //   29: istore_2
    //   30: iload_2
    //   31: aload 6
    //   33: invokevirtual 105	android/util/SparseIntArray:size	()I
    //   36: if_icmpge +57 -> 93
    //   39: aload 6
    //   41: iload_2
    //   42: invokevirtual 109	android/util/SparseIntArray:keyAt	(I)I
    //   45: istore_3
    //   46: aload 6
    //   48: iload_2
    //   49: invokevirtual 112	android/util/SparseIntArray:valueAt	(I)I
    //   52: istore 4
    //   54: aload_1
    //   55: iload_3
    //   56: iconst_0
    //   57: invokevirtual 116	android/util/SparseIntArray:get	(II)I
    //   60: istore 5
    //   62: aload_0
    //   63: getfield 74	com/facebook/imagepipeline/memory/a:c	Landroid/util/SparseArray;
    //   66: iload_3
    //   67: new 118	com/facebook/imagepipeline/memory/e
    //   70: dup
    //   71: aload_0
    //   72: iload_3
    //   73: invokevirtual 120	com/facebook/imagepipeline/memory/a:d	(I)I
    //   76: iload 4
    //   78: iload 5
    //   80: invokespecial 123	com/facebook/imagepipeline/memory/e:<init>	(III)V
    //   83: invokevirtual 127	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -60 -> 30
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 129	com/facebook/imagepipeline/memory/a:h	Z
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aload_0
    //   102: iconst_1
    //   103: putfield 129	com/facebook/imagepipeline/memory/a:h	Z
    //   106: goto -8 -> 98
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	a
    //   0	114	1	paramSparseIntArray	SparseIntArray
    //   29	61	2	j	int
    //   45	28	3	k	int
    //   52	25	4	m	int
    //   60	19	5	n	int
    //   21	26	6	localSparseIntArray	SparseIntArray
    // Exception table:
    //   from	to	target	type
    //   2	23	109	finally
    //   30	86	109	finally
    //   93	98	109	finally
    //   101	106	109	finally
  }
  
  private void g()
  {
    label39:
    for (;;)
    {
      try
      {
        if (e()) {
          if (this.f.b == 0)
          {
            break label39;
            k.b(bool);
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  @SuppressLint({"InvalidAccessToGuardedField"})
  private void h()
  {
    if (com.facebook.common.e.a.a(2)) {
      com.facebook.common.e.a.a(this.g, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.e.a), Integer.valueOf(this.e.b), Integer.valueOf(this.f.a), Integer.valueOf(this.f.b));
    }
  }
  
  public V a(int paramInt)
  {
    g();
    paramInt = c(paramInt);
    Object localObject5;
    try
    {
      e locale1 = f(paramInt);
      if (locale1 != null)
      {
        localObject5 = locale1.c();
        if (localObject5 != null)
        {
          k.b(this.d.add(localObject5));
          paramInt = c(localObject5);
          j = d(paramInt);
          this.e.a(j);
          this.f.b(j);
          this.i.a(j);
          h();
          if (com.facebook.common.e.a.a(2)) {
            com.facebook.common.e.a.a(this.g, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject5)), Integer.valueOf(paramInt));
          }
          return (V)localObject5;
        }
      }
      j = d(paramInt);
      if (!h(j)) {
        throw new d(this.b.b, this.e.b, this.f.b, j);
      }
    }
    finally {}
    this.e.a(j);
    if (localObject1 != null) {
      ((e)localObject1).e();
    }
    Object localObject2 = null;
    try
    {
      localObject5 = b(paramInt);
      localObject2 = localObject5;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          this.e.b(j);
          e locale2 = f(paramInt);
          if (locale2 == null) {
            break label300;
          }
          locale2.f();
          o.a(localThrowable);
        }
        finally {}
      }
    }
    try
    {
      k.b(this.d.add(localObject2));
      d();
      this.i.b(j);
      h();
      if (com.facebook.common.e.a.a(2)) {
        com.facebook.common.e.a.a(this.g, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject2)), Integer.valueOf(paramInt));
      }
      return (V)localObject2;
    }
    finally {}
  }
  
  protected void a()
  {
    this.a.a(this);
    this.i.a(this);
  }
  
  public void a(com.facebook.common.g.a parama)
  {
    c();
  }
  
  public void a(V paramV)
  {
    k.a(paramV);
    int j = c(paramV);
    int k = d(j);
    for (;;)
    {
      try
      {
        e locale = f(j);
        if (!this.d.remove(paramV))
        {
          com.facebook.common.e.a.e(this.g, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] { Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(j) });
          b(paramV);
          this.i.c(k);
          h();
          return;
        }
        if ((locale == null) || (locale.a()) || (e()) || (!d(paramV)))
        {
          if (locale != null) {
            locale.f();
          }
          if (com.facebook.common.e.a.a(2)) {
            com.facebook.common.e.a.a(this.g, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(j));
          }
          b(paramV);
          this.e.b(k);
          this.i.c(k);
          continue;
        }
        locale.a(paramV);
      }
      finally {}
      this.f.a(k);
      this.e.b(k);
      this.i.d(k);
      if (com.facebook.common.e.a.a(2)) {
        com.facebook.common.e.a.a(this.g, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(j));
      }
    }
  }
  
  protected abstract V b(int paramInt);
  
  protected void b() {}
  
  @VisibleForTesting
  protected abstract void b(V paramV);
  
  protected abstract int c(int paramInt);
  
  protected abstract int c(V paramV);
  
  @VisibleForTesting
  void c()
  {
    ArrayList localArrayList = new ArrayList(this.c.size());
    Object localObject2 = new SparseIntArray();
    int j = 0;
    for (;;)
    {
      try
      {
        Object localObject3;
        if (j < this.c.size())
        {
          localObject3 = (e)this.c.valueAt(j);
          if (((e)localObject3).b() > 0) {
            localArrayList.add(localObject3);
          }
          ((SparseIntArray)localObject2).put(this.c.keyAt(j), ((e)localObject3).g());
          j += 1;
        }
        else
        {
          a((SparseIntArray)localObject2);
          this.f.a();
          h();
          b();
          j = 0;
          if (j >= localArrayList.size()) {
            break;
          }
          localObject2 = (e)localArrayList.get(j);
          localObject3 = ((e)localObject2).d();
          if (localObject3 == null) {
            j += 1;
          } else {
            b(localObject3);
          }
        }
      }
      finally {}
    }
  }
  
  protected abstract int d(int paramInt);
  
  @VisibleForTesting
  void d()
  {
    try
    {
      if (e()) {
        e(this.b.c);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected boolean d(V paramV)
  {
    k.a(paramV);
    return true;
  }
  
  @VisibleForTesting
  void e(int paramInt)
  {
    for (;;)
    {
      int k;
      int j;
      try
      {
        k = Math.min(this.e.b + this.f.b - paramInt, this.f.b);
        if (k <= 0) {
          return;
        }
        if (com.facebook.common.e.a.a(2)) {
          com.facebook.common.e.a.a(this.g, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.e.b + this.f.b), Integer.valueOf(k));
        }
        h();
        j = 0;
        if ((j >= this.c.size()) || (k <= 0))
        {
          h();
          if (!com.facebook.common.e.a.a(2)) {
            continue;
          }
          com.facebook.common.e.a.a(this.g, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.e.b + this.f.b));
          continue;
        }
        locale = (e)this.c.valueAt(j);
      }
      finally {}
      e locale;
      while (k > 0)
      {
        Object localObject2 = locale.d();
        if (localObject2 == null) {
          break;
        }
        b(localObject2);
        k -= locale.a;
        this.f.b(locale.a);
      }
      j += 1;
    }
  }
  
  /* Error */
  @VisibleForTesting
  boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	com/facebook/imagepipeline/memory/a:e	Lcom/facebook/imagepipeline/memory/a$a;
    //   6: getfield 135	com/facebook/imagepipeline/memory/a$a:b	I
    //   9: aload_0
    //   10: getfield 92	com/facebook/imagepipeline/memory/a:f	Lcom/facebook/imagepipeline/memory/a$a;
    //   13: getfield 135	com/facebook/imagepipeline/memory/a$a:b	I
    //   16: iadd
    //   17: aload_0
    //   18: getfield 65	com/facebook/imagepipeline/memory/a:b	Lcom/facebook/imagepipeline/memory/v;
    //   21: getfield 286	com/facebook/imagepipeline/memory/v:c	I
    //   24: if_icmple +22 -> 46
    //   27: iconst_1
    //   28: istore_1
    //   29: iload_1
    //   30: ifeq +12 -> 42
    //   33: aload_0
    //   34: getfield 69	com/facebook/imagepipeline/memory/a:i	Lcom/facebook/imagepipeline/memory/w;
    //   37: invokeinterface 303 1 0
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: iconst_0
    //   47: istore_1
    //   48: goto -19 -> 29
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	a
    //   28	20	1	bool	boolean
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	51	finally
    //   33	42	51	finally
  }
  
  /* Error */
  @VisibleForTesting
  e<V> f(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/facebook/imagepipeline/memory/a:c	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 304	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 118	com/facebook/imagepipeline/memory/e
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +12 -> 27
    //   18: aload_0
    //   19: getfield 129	com/facebook/imagepipeline/memory/a:h	Z
    //   22: istore_2
    //   23: iload_2
    //   24: ifne +7 -> 31
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: areturn
    //   31: iconst_2
    //   32: invokestatic 145	com/facebook/common/e/a:a	(I)Z
    //   35: ifeq +17 -> 52
    //   38: aload_0
    //   39: getfield 52	com/facebook/imagepipeline/memory/a:g	Ljava/lang/Class;
    //   42: ldc_w 306
    //   45: iload_1
    //   46: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokestatic 309	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   52: aload_0
    //   53: iload_1
    //   54: invokevirtual 311	com/facebook/imagepipeline/memory/a:g	(I)Lcom/facebook/imagepipeline/memory/e;
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 74	com/facebook/imagepipeline/memory/a:c	Landroid/util/SparseArray;
    //   62: iload_1
    //   63: aload_3
    //   64: invokevirtual 127	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   67: goto -40 -> 27
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramInt	int
    //   22	2	2	bool	boolean
    //   13	51	3	locale	e
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	70	finally
    //   18	23	70	finally
    //   31	52	70	finally
    //   52	67	70	finally
  }
  
  public Map<String, Integer> f()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      int j = 0;
      while (j < this.c.size())
      {
        int k = this.c.keyAt(j);
        e locale = (e)this.c.valueAt(j);
        localHashMap.put("buckets_used_" + d(k), Integer.valueOf(locale.g()));
        j += 1;
      }
      localHashMap.put("soft_cap", Integer.valueOf(this.b.c));
      localHashMap.put("hard_cap", Integer.valueOf(this.b.b));
      localHashMap.put("used_count", Integer.valueOf(this.e.a));
      localHashMap.put("used_bytes", Integer.valueOf(this.e.b));
      localHashMap.put("free_count", Integer.valueOf(this.f.a));
      localHashMap.put("free_bytes", Integer.valueOf(this.f.b));
      return localHashMap;
    }
    finally {}
  }
  
  e<V> g(int paramInt)
  {
    return new e(d(paramInt), Integer.MAX_VALUE, 0);
  }
  
  @VisibleForTesting
  boolean h(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        int j = this.b.b;
        if (paramInt > j - this.e.b)
        {
          this.i.c();
          return bool;
        }
        int k = this.b.c;
        if (paramInt > k - (this.e.b + this.f.b)) {
          e(k - paramInt);
        }
        if (paramInt > j - (this.e.b + this.f.b)) {
          this.i.c();
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  @VisibleForTesting
  @NotThreadSafe
  static class a
  {
    private static final String c = "com.facebook.imagepipeline.memory.BasePool.Counter";
    int a;
    int b;
    
    public void a()
    {
      this.a = 0;
      this.b = 0;
    }
    
    public void a(int paramInt)
    {
      this.a += 1;
      this.b += paramInt;
    }
    
    public void b(int paramInt)
    {
      if ((this.b >= paramInt) && (this.a > 0))
      {
        this.a -= 1;
        this.b -= paramInt;
        return;
      }
      com.facebook.common.e.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.b), Integer.valueOf(this.a) });
    }
  }
  
  public static class b
    extends RuntimeException
  {
    public b(Object paramObject)
    {
      super();
    }
  }
  
  public static class c
    extends RuntimeException
  {
    public c(Object paramObject)
    {
      super();
    }
  }
  
  public static class d
    extends RuntimeException
  {
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
  
  public static class e
    extends a.b
  {
    public e(Object paramObject)
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */