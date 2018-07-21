package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.g.c;
import com.facebook.common.internal.k;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class m
  extends a<NativeMemoryChunk>
{
  private final int[] g;
  
  public m(c paramc, v paramv, w paramw)
  {
    super(paramc, paramv, paramw);
    paramc = paramv.d;
    this.g = new int[paramc.size()];
    int i = 0;
    while (i < this.g.length)
    {
      this.g[i] = paramc.keyAt(i);
      i += 1;
    }
    a();
  }
  
  protected void a(NativeMemoryChunk paramNativeMemoryChunk)
  {
    k.a(paramNativeMemoryChunk);
    paramNativeMemoryChunk.close();
  }
  
  protected int b(NativeMemoryChunk paramNativeMemoryChunk)
  {
    k.a(paramNativeMemoryChunk);
    return paramNativeMemoryChunk.b();
  }
  
  protected int c(int paramInt)
  {
    if (paramInt <= 0) {
      throw new a.b(Integer.valueOf(paramInt));
    }
    int[] arrayOfInt = this.g;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k >= paramInt) {
        return k;
      }
      i += 1;
    }
    return paramInt;
  }
  
  protected boolean c(NativeMemoryChunk paramNativeMemoryChunk)
  {
    k.a(paramNativeMemoryChunk);
    return !paramNativeMemoryChunk.a();
  }
  
  protected int d(int paramInt)
  {
    return paramInt;
  }
  
  public int g()
  {
    return this.g[0];
  }
  
  protected NativeMemoryChunk i(int paramInt)
  {
    return new NativeMemoryChunk(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */