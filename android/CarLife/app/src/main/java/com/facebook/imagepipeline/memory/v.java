package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.k;
import javax.annotation.Nullable;

public class v
{
  public static final int a = -1;
  public final int b;
  public final int c;
  public final SparseIntArray d;
  public final int e;
  public final int f;
  public final int g;
  
  public v(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt1, paramInt2, paramSparseIntArray, 0, Integer.MAX_VALUE, -1);
  }
  
  public v(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      this.c = paramInt1;
      this.b = paramInt2;
      this.d = paramSparseIntArray;
      this.e = paramInt3;
      this.f = paramInt4;
      this.g = paramInt5;
      return;
    }
  }
  
  public v(int paramInt, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt, paramInt, paramSparseIntArray, 0, Integer.MAX_VALUE, -1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */