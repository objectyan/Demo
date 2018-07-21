package com.facebook.imagepipeline.d;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class g<K, V>
{
  private final v<V> a;
  @GuardedBy("this")
  private final LinkedHashMap<K, V> b = new LinkedHashMap();
  @GuardedBy("this")
  private int c = 0;
  
  public g(v<V> paramv)
  {
    this.a = paramv;
  }
  
  private int d(V paramV)
  {
    if (paramV == null) {
      return 0;
    }
    return this.a.a(paramV);
  }
  
  @Nullable
  public V a(K paramK, V paramV)
  {
    try
    {
      Object localObject = this.b.remove(paramK);
      this.c -= d(localObject);
      this.b.put(paramK, paramV);
      this.c += d(paramV);
      return (V)localObject;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @VisibleForTesting
  ArrayList<K> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b.keySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey()))) {
          localArrayList.add(localEntry);
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public boolean a(K paramK)
  {
    try
    {
      boolean bool = this.b.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public V b(K paramK)
  {
    try
    {
      paramK = this.b.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @VisibleForTesting
  ArrayList<V> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b.values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ArrayList<V> b(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey())))
        {
          localArrayList.add(localEntry.getValue());
          this.c -= d(localEntry.getValue());
          localIterator.remove();
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public int c()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public V c(K paramK)
  {
    try
    {
      paramK = this.b.remove(paramK);
      this.c -= d(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public int d()
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
  
  /* Error */
  @Nullable
  public K e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/facebook/imagepipeline/d/g:b	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 131	java/util/LinkedHashMap:isEmpty	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: areturn
    //   20: aload_0
    //   21: getfield 27	com/facebook/imagepipeline/d/g:b	Ljava/util/LinkedHashMap;
    //   24: invokevirtual 62	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   27: invokeinterface 78 1 0
    //   32: invokeinterface 88 1 0
    //   37: astore_2
    //   38: goto -22 -> 16
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	g
    //   9	2	1	bool	boolean
    //   15	23	2	localObject1	Object
    //   41	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	41	finally
    //   20	38	41	finally
  }
  
  public ArrayList<V> f()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b.values());
      this.b.clear();
      this.c = 0;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */