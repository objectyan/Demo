package com.indooratlas.android.sdk._internal;

import java.util.HashMap;
import java.util.Map;

public final class l
{
  private static volatile b a = new a((byte)0);
  
  public static b a()
  {
    return a;
  }
  
  static final class a
    implements l.b
  {
    public final <K, V> Map<K, V> a(Map<K, V> paramMap)
    {
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = new HashMap();
      }
      return (Map<K, V>)localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract <K, V> Map<K, V> a(Map<K, V> paramMap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */