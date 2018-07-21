package com.facebook.imagepipeline.i;

import com.facebook.common.e.a;
import java.io.Closeable;

public abstract class b
  implements e, Closeable
{
  private static final String a = "CloseableImage";
  
  public abstract int b();
  
  public abstract boolean c();
  
  public abstract void close();
  
  public g d()
  {
    return f.a;
  }
  
  public boolean e()
  {
    return false;
  }
  
  protected void finalize()
    throws Throwable
  {
    if (c()) {
      return;
    }
    a.d("CloseableImage", "finalize: %s %x still open.", new Object[] { getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)) });
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */