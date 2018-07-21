package com.baidu.ufosdk.util;

import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinkedList
{
  private final int a = 2000;
  
  public final boolean add(Object paramObject)
  {
    if (size() == this.a) {
      removeFirst();
    }
    return super.add(paramObject);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(((Object)localIterator.next()).toString());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */