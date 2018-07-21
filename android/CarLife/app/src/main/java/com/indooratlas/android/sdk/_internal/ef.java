package com.indooratlas.android.sdk._internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class ef<K, V>
  extends LinkedHashMap<K, V>
{
  private int a = 500;
  
  public ef()
  {
    super(500);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */