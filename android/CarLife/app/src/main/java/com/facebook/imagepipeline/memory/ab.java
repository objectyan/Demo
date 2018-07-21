package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.o;
import java.io.IOException;
import java.io.OutputStream;

public abstract class ab
  extends OutputStream
{
  public abstract int b();
  
  public abstract y c();
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      o.b(localIOException);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */