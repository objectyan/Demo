package com.facebook.imagepipeline.d;

import com.facebook.common.internal.m;

public class k
  implements m<q>
{
  private static final int a = Integer.MAX_VALUE;
  private static final int b = Integer.MAX_VALUE;
  
  private int c()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return 1048576;
    }
    if (i < 33554432) {
      return 2097152;
    }
    return 4194304;
  }
  
  public q a()
  {
    int i = c();
    return new q(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */