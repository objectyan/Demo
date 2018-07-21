package com.facebook.common.g;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class e
{
  private static final Set<d> a = Collections.newSetFromMap(new WeakHashMap());
  
  public static Iterable<d> a()
  {
    return a;
  }
  
  public static void a(d paramd)
  {
    a.add(paramd);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */