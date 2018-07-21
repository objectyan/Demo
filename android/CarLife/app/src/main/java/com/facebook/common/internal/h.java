package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class h<E>
  extends HashSet<E>
{
  private h(Set<E> paramSet)
  {
    super(paramSet);
  }
  
  public static <E> h<E> a(Set<E> paramSet)
  {
    return new h(paramSet);
  }
  
  public static <E> h<E> a(E... paramVarArgs)
  {
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramVarArgs);
    return new h(localHashSet);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */