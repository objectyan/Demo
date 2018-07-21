package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class i
{
  public static final int a = 4194304;
  public static final int b = Runtime.getRuntime().availableProcessors();
  private static final int c = 131072;
  
  public static SparseIntArray a(int paramInt1, int paramInt2, int paramInt3)
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    while (paramInt1 <= paramInt2)
    {
      localSparseIntArray.put(paramInt1, paramInt3);
      paramInt1 *= 2;
    }
    return localSparseIntArray;
  }
  
  public static v a()
  {
    return new v(4194304, b * 4194304, a(131072, 4194304, b), 131072, 4194304, b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */