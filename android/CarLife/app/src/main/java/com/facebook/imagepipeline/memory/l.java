package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.g.c;
import com.facebook.common.internal.k;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class l
  extends a<byte[]>
  implements f
{
  private final int[] g;
  
  public l(c paramc, v paramv, w paramw)
  {
    super(paramc, paramv, paramw);
    paramc = paramv.d;
    this.g = new int[paramc.size()];
    int i = 0;
    while (i < paramc.size())
    {
      this.g[i] = paramc.keyAt(i);
      i += 1;
    }
    a();
  }
  
  protected void a(byte[] paramArrayOfByte)
  {
    k.a(paramArrayOfByte);
  }
  
  protected int b(byte[] paramArrayOfByte)
  {
    k.a(paramArrayOfByte);
    return paramArrayOfByte.length;
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
  
  protected int d(int paramInt)
  {
    return paramInt;
  }
  
  public int g()
  {
    return this.g[0];
  }
  
  protected byte[] i(int paramInt)
  {
    return new byte[paramInt];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */