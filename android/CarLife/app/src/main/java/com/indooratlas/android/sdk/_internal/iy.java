package com.indooratlas.android.sdk._internal;

import java.io.IOException;

final class iy
  implements io
{
  public final in a;
  public final jc b;
  private boolean c;
  
  public iy(jc paramjc)
  {
    this(paramjc, new in());
  }
  
  private iy(jc paramjc, in paramin)
  {
    if (paramjc == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.a = paramin;
    this.b = paramjc;
  }
  
  public final long a(jd paramjd)
    throws IOException
  {
    if (paramjd == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramjd.a(this.a, 2048L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      p();
    }
    return l1;
  }
  
  public final je a()
  {
    return this.b.a();
  }
  
  public final void a_(in paramin, long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(paramin, paramLong);
    p();
  }
  
  public final in b()
  {
    return this.a;
  }
  
  public final io b(iq paramiq)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramiq);
    return p();
  }
  
  public final io b(String paramString)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return p();
  }
  
  public final io b(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramArrayOfByte);
    return p();
  }
  
  public final io b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    return p();
  }
  
  public final io c()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.b;
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public final void close()
    throws IOException
  {
    if (this.c) {}
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          if (this.a.b > 0L)
          {
            this.b.a_(this.a, this.a.b);
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        try
        {
          this.b.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localThrowable2;
        }
      }
      this.c = true;
    } while (localObject2 == null);
    jf.a((Throwable)localObject2);
  }
  
  public final void flush()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.a_(this.a, this.a.b);
    }
    this.b.flush();
  }
  
  public final io g(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.e(paramInt);
    return p();
  }
  
  public final io h(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.d(paramInt);
    return p();
  }
  
  public final io i(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return p();
  }
  
  public final io i(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.h(paramLong);
    return p();
  }
  
  public final io j(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return p();
  }
  
  public final io j(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.g(paramLong);
    return p();
  }
  
  public final io p()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    Object localObject = this.a;
    long l2 = ((in)localObject).b;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      if (l1 > 0L) {
        this.b.a_(this.a, l1);
      }
      return this;
      localObject = ((in)localObject).a.g;
      l1 = l2;
      if (((ja)localObject).c < 2048)
      {
        l1 = l2;
        if (((ja)localObject).e) {
          l1 = l2 - (((ja)localObject).c - ((ja)localObject).b);
        }
      }
    }
  }
  
  public final String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */