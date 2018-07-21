package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract class gl
{
  public static gl a(gg paramgg, final byte[] paramArrayOfByte)
  {
    final int i = paramArrayOfByte.length;
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    gy.a(paramArrayOfByte.length, i);
    new gl()
    {
      public final gg a()
      {
        return this.a;
      }
      
      public final void a(io paramAnonymousio)
        throws IOException
      {
        paramAnonymousio.b(paramArrayOfByte, this.d, i);
      }
      
      public final long b()
      {
        return i;
      }
    };
  }
  
  public abstract gg a();
  
  public abstract void a(io paramio)
    throws IOException;
  
  public long b()
    throws IOException
  {
    return -1L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */