package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class g
{
  private static final int a = 0;
  private static final SparseIntArray b = new SparseIntArray(0);
  
  public static v a()
  {
    return new v(0, b(), b);
  }
  
  private static int b()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216) {
      return i / 4 * 3;
    }
    return i / 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */