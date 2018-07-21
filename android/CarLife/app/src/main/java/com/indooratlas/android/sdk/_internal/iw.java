package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class iw
  implements jd
{
  private final ip a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  iw(ip paramip, Inflater paramInflater)
  {
    if (paramip == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramip;
    this.b = paramInflater;
  }
  
  public iw(jd paramjd, Inflater paramInflater)
  {
    this(ix.a(paramjd), paramInflater);
  }
  
  private void c()
    throws IOException
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.f(i);
  }
  
  public final long a(in paramin, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return 0L;
    }
    for (;;)
    {
      boolean bool = b();
      try
      {
        ja localja = paramin.f(1);
        int i = this.b.inflate(localja.a, localja.c, 2048 - localja.c);
        if (i > 0)
        {
          localja.c += i;
          paramin.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          if (localja.b == localja.c)
          {
            paramin.a = localja.a();
            jb.a(localja);
          }
        }
        else
        {
          if (!bool) {
            continue;
          }
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException paramin)
      {
        throw new IOException(paramin);
      }
    }
    return -1L;
  }
  
  public final je a()
  {
    return this.a.a();
  }
  
  public final boolean b()
    throws IOException
  {
    if (!this.b.needsInput()) {
      return false;
    }
    c();
    if (this.b.getRemaining() != 0) {
      throw new IllegalStateException("?");
    }
    if (this.a.d()) {
      return true;
    }
    ja localja = this.a.b().a;
    this.c = (localja.c - localja.b);
    this.b.setInput(localja.a, localja.b, this.c);
    return false;
  }
  
  public final void close()
    throws IOException
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */