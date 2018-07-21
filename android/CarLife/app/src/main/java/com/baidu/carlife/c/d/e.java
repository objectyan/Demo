package com.baidu.carlife.c.d;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class e<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private c<K, V> a;
  private c<K, V> b;
  private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
  private int d = 0;
  
  public int a()
  {
    return this.d;
  }
  
  protected c<K, V> a(K paramK)
  {
    for (c localc = this.a;; localc = localc.c) {
      if ((localc == null) || (localc.a.equals(paramK))) {
        return localc;
      }
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    c localc = a(paramK);
    if (localc != null) {
      return (V)localc.b;
    }
    b(paramK, paramV);
    return null;
  }
  
  protected c<K, V> b(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new c(paramK, paramV);
    this.d += 1;
    if (this.b == null)
    {
      this.a = paramK;
      this.b = this.a;
      return paramK;
    }
    this.b.c = paramK;
    paramK.d = this.b;
    this.b = paramK;
    return paramK;
  }
  
  public V b(@NonNull K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.d -= 1;
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).a_(paramK);
      }
    }
    if (paramK.d != null)
    {
      paramK.d.c = paramK.c;
      if (paramK.c == null) {
        break label134;
      }
      paramK.c.d = paramK.d;
    }
    for (;;)
    {
      paramK.c = null;
      paramK.d = null;
      return (V)paramK.b;
      this.a = paramK.c;
      break;
      label134:
      this.b = paramK.d;
    }
  }
  
  public Iterator<Map.Entry<K, V>> b()
  {
    b localb = new b(this.b, this.a);
    this.c.put(localb, Boolean.valueOf(false));
    return localb;
  }
  
  public e<K, V>.d c()
  {
    d locald = new d(null);
    this.c.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public Map.Entry<K, V> d()
  {
    return this.a;
  }
  
  public Map.Entry<K, V> e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool3;
      } while (!(paramObject instanceof e));
      localObject1 = (e)paramObject;
      bool1 = bool3;
    } while (a() != ((e)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((e)localObject1).iterator();
    for (;;)
    {
      if ((((Iterator)paramObject).hasNext()) && (((Iterator)localObject1).hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
        Object localObject2 = ((Iterator)localObject1).next();
        if (localEntry == null)
        {
          bool1 = bool3;
          if (localObject2 != null) {
            break;
          }
        }
        if ((localEntry != null) && (!localEntry.equals(localObject2))) {
          return false;
        }
      }
    }
    if ((!((Iterator)paramObject).hasNext()) && (!((Iterator)localObject1).hasNext())) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  @NonNull
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.a, this.b);
    this.c.put(locala, Boolean.valueOf(false));
    return locala;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static class a<K, V>
    extends e.e<K, V>
  {
    a(e.c<K, V> paramc1, e.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    e.c<K, V> a(e.c<K, V> paramc)
    {
      return paramc.c;
    }
    
    e.c<K, V> b(e.c<K, V> paramc)
    {
      return paramc.d;
    }
  }
  
  private static class b<K, V>
    extends e.e<K, V>
  {
    b(e.c<K, V> paramc1, e.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    e.c<K, V> a(e.c<K, V> paramc)
    {
      return paramc.d;
    }
    
    e.c<K, V> b(e.c<K, V> paramc)
    {
      return paramc.c;
    }
  }
  
  static class c<K, V>
    implements Map.Entry<K, V>
  {
    @NonNull
    final K a;
    @NonNull
    final V b;
    c<K, V> c;
    c<K, V> d;
    
    c(@NonNull K paramK, @NonNull V paramV)
    {
      this.a = paramK;
      this.b = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
      } while ((this.a.equals(((c)paramObject).a)) && (this.b.equals(((c)paramObject).b)));
      return false;
    }
    
    @NonNull
    public K getKey()
    {
      return (K)this.a;
    }
    
    @NonNull
    public V getValue()
    {
      return (V)this.b;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString()
    {
      return this.a + "=" + this.b;
    }
  }
  
  private class d
    implements e.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private e.c<K, V> b;
    private boolean c = true;
    
    private d() {}
    
    public Map.Entry<K, V> a()
    {
      if (this.c)
      {
        this.c = false;
        this.b = e.a(e.this);
        return this.b;
      }
      if (this.b != null) {}
      for (e.c localc = this.b.c;; localc = null)
      {
        this.b = localc;
        break;
      }
    }
    
    public void a_(@NonNull e.c<K, V> paramc)
    {
      if (paramc == this.b)
      {
        this.b = this.b.d;
        if (this.b != null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.c = bool;
        return;
      }
    }
    
    public boolean hasNext()
    {
      if (this.c) {
        if (e.a(e.this) == null) {}
      }
      while ((this.b != null) && (this.b.c != null))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public void remove() {}
  }
  
  private static abstract class e<K, V>
    implements e.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    e.c<K, V> a;
    e.c<K, V> b;
    
    e(e.c<K, V> paramc1, e.c<K, V> paramc2)
    {
      this.a = paramc2;
      this.b = paramc1;
    }
    
    private e.c<K, V> b()
    {
      if ((this.b == this.a) || (this.a == null)) {
        return null;
      }
      return a(this.b);
    }
    
    abstract e.c<K, V> a(e.c<K, V> paramc);
    
    public Map.Entry<K, V> a()
    {
      e.c localc = this.b;
      this.b = b();
      return localc;
    }
    
    public void a_(@NonNull e.c<K, V> paramc)
    {
      if ((this.a == paramc) && (paramc == this.b))
      {
        this.b = null;
        this.a = null;
      }
      if (this.a == paramc) {
        this.a = b(this.a);
      }
      if (this.b == paramc) {
        this.b = b();
      }
    }
    
    abstract e.c<K, V> b(e.c<K, V> paramc);
    
    public boolean hasNext()
    {
      return this.b != null;
    }
    
    public void remove() {}
  }
  
  static abstract interface f<K, V>
  {
    public abstract void a_(@NonNull e.c<K, V> paramc);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */