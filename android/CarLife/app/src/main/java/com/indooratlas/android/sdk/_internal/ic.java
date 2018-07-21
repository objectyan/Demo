package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.ProtocolException;

public final class ic
  implements jc
{
  public final in a = new in();
  private boolean b;
  private final int c;
  
  public ic()
  {
    this(-1);
  }
  
  public ic(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final je a()
  {
    return je.b;
  }
  
  public final void a(jc paramjc)
    throws IOException
  {
    in localin = new in();
    this.a.a(localin, 0L, this.a.b);
    paramjc.a_(localin, localin.b);
  }
  
  public final void a_(in paramin, long paramLong)
    throws IOException
  {
    if (this.b) {
      throw new IllegalStateException("closed");
    }
    gy.a(paramin.b, paramLong);
    if ((this.c != -1) && (this.a.b > this.c - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.c + " bytes");
    }
    this.a.a_(paramin, paramLong);
  }
  
  public final void close()
    throws IOException
  {
    if (this.b) {}
    do
    {
      return;
      this.b = true;
    } while (this.a.b >= this.c);
    throw new ProtocolException("content-length promised " + this.c + " bytes, but received " + this.a.b);
  }
  
  public final void flush()
    throws IOException
  {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */