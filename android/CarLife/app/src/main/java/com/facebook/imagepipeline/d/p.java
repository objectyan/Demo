package com.facebook.imagepipeline.d;

import com.android.internal.util.Predicate;
import com.facebook.common.h.a;
import javax.annotation.Nullable;

public abstract interface p<K, V>
{
  public abstract int a(Predicate<K> paramPredicate);
  
  @Nullable
  public abstract a<V> a(K paramK);
  
  @Nullable
  public abstract a<V> a(K paramK, a<V> parama);
  
  public abstract boolean b(Predicate<K> paramPredicate);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */