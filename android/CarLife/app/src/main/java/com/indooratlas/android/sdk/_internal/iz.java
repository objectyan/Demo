package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;

final class iz
  implements ip
{
  public final in a;
  public final jd b;
  private boolean c;
  
  public iz(jd paramjd)
  {
    this(paramjd, new in());
  }
  
  private iz(jd paramjd, in paramin)
  {
    if (paramjd == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.a = paramin;
    this.b = paramjd;
  }
  
  private boolean b(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    while (this.a.b < paramLong) {
      if (this.b.a(this.a, 2048L) == -1L) {
        return false;
      }
    }
    return true;
  }
  
  public final long a(byte paramByte)
    throws IOException
  {
    long l2 = 0L;
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      l1 = l2;
      if (0L < this.a.b) {
        break;
      }
    } while (this.b.a(this.a, 2048L) != -1L);
    long l1 = -1L;
    return l1;
    do
    {
      l2 = this.a.a(paramByte, l1);
      l1 = l2;
      if (l2 != -1L) {
        break;
      }
      l1 = this.a.b;
    } while (this.b.a(this.a, 2048L) != -1L);
    return -1L;
  }
  
  public final long a(in paramin, long paramLong)
    throws IOException
  {
    if (paramin == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.b == 0L) && (this.b.a(this.a, 2048L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.a.b);
    return this.a.a(paramin, paramLong);
  }
  
  public final je a()
  {
    return this.b.a();
  }
  
  public final void a(long paramLong)
    throws IOException
  {
    if (!b(paramLong)) {
      throw new EOFException();
    }
  }
  
  public final in b()
  {
    return this.a;
  }
  
  public final iq c(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public final void close()
    throws IOException
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.o();
  }
  
  public final boolean d()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    return (this.a.d()) && (this.b.a(this.a, 2048L) == -1L);
  }
  
  public final byte e()
    throws IOException
  {
    a(1L);
    return this.a.e();
  }
  
  public final byte[] e(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.e(paramLong);
  }
  
  public final short f()
    throws IOException
  {
    a(2L);
    return this.a.f();
  }
  
  public final void f(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.a.b);
      this.a.f(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.a.b != 0L) || (this.b.a(this.a, 2048L) != -1L));
    throw new EOFException();
  }
  
  public final int g()
    throws IOException
  {
    a(4L);
    return this.a.g();
  }
  
  public final short h()
    throws IOException
  {
    a(2L);
    return jf.a(this.a.f());
  }
  
  public final int i()
    throws IOException
  {
    a(4L);
    return jf.a(this.a.g());
  }
  
  public final long j()
    throws IOException
  {
    a(1L);
    int i = 0;
    while (b(i + 1))
    {
      byte b1 = this.a.b(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
      }
      i += 1;
    }
    return this.a.j();
  }
  
  public final String m()
    throws IOException
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      in localin = new in();
      this.a.a(localin, 0L, Math.min(32L, this.a.b));
      throw new EOFException("\\n not found: size=" + this.a.b + " content=" + localin.k().b() + "...");
    }
    return this.a.d(l);
  }
  
  public final byte[] n()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.n();
  }
  
  public final String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */