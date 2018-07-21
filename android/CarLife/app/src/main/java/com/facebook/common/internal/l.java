package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class l
{
  public static <E> HashSet<E> a()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> a(int paramInt)
  {
    return new HashSet(paramInt);
  }
  
  public static <E> HashSet<E> a(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new HashSet((Collection)paramIterable);
    }
    return a(paramIterable.iterator());
  }
  
  public static <E> HashSet<E> a(Iterator<? extends E> paramIterator)
  {
    HashSet localHashSet = a();
    while (paramIterator.hasNext()) {
      localHashSet.add(paramIterator.next());
    }
    return localHashSet;
  }
  
  public static <E> HashSet<E> a(E... paramVarArgs)
  {
    HashSet localHashSet = a(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static <E> Set<E> a(Map<E, Boolean> paramMap)
  {
    return Collections.newSetFromMap(paramMap);
  }
  
  public static <E> Set<E> b()
  {
    return a(new IdentityHashMap());
  }
  
  public static <E> CopyOnWriteArraySet<E> c()
  {
    return new CopyOnWriteArraySet();
  }
  
  public static <E> LinkedHashSet<E> d()
  {
    return new LinkedHashSet();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */