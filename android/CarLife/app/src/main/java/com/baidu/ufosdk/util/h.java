package com.baidu.ufosdk.util;

public final class h
{
  private static long a;
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - a;
    if ((0L < l2) && (l2 < 500L)) {
      return true;
    }
    a = l1;
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */