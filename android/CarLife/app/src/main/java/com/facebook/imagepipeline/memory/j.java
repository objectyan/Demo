package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class j
{
  private static final int a = 5;
  private static final int b = 2;
  
  public static v a()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(1024, 5);
    localSparseIntArray.put(2048, 5);
    localSparseIntArray.put(4096, 5);
    localSparseIntArray.put(8192, 5);
    localSparseIntArray.put(16384, 5);
    localSparseIntArray.put(32768, 5);
    localSparseIntArray.put(65536, 5);
    localSparseIntArray.put(131072, 5);
    localSparseIntArray.put(262144, 2);
    localSparseIntArray.put(524288, 2);
    localSparseIntArray.put(1048576, 2);
    return new v(b(), c(), localSparseIntArray);
  }
  
  private static int b()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return 3145728;
    }
    if (i < 33554432) {
      return 6291456;
    }
    return 12582912;
  }
  
  private static int c()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return i / 2;
    }
    return i / 4 * 3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */