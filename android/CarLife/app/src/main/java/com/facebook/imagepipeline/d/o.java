package com.facebook.imagepipeline.d;

import com.android.internal.util.Predicate;
import com.facebook.common.h.a;

public class o<K, V>
  implements p<K, V>
{
  private final p<K, V> a;
  private final r b;
  
  public o(p<K, V> paramp, r paramr)
  {
    this.a = paramp;
    this.b = paramr;
  }
  
  public int a(Predicate<K> paramPredicate)
  {
    return this.a.a(paramPredicate);
  }
  
  public a<V> a(K paramK)
  {
    paramK = this.a.a(paramK);
    if (paramK == null)
    {
      this.b.b();
      return paramK;
    }
    this.b.a();
    return paramK;
  }
  
  public a<V> a(K paramK, a<V> parama)
  {
    this.b.c();
    return this.a.a(paramK, parama);
  }
  
  public boolean b(Predicate<K> paramPredicate)
  {
    return this.a.b(paramPredicate);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */