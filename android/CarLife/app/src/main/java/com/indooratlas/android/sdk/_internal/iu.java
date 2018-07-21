package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class iu
  implements jc
{
  private final io a;
  private final Deflater b;
  private final ir c;
  private boolean d;
  private final CRC32 e = new CRC32();
  
  public iu(jc paramjc)
  {
    if (paramjc == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.b = new Deflater(-1, true);
    this.a = ix.a(paramjc);
    this.c = new ir(this.a, this.b);
    paramjc = this.a.b();
    paramjc.c(8075);
    paramjc.b(8);
    paramjc.b(0);
    paramjc.d(0);
    paramjc.b(0);
    paramjc.b(0);
  }
  
  private void b(in paramin, long paramLong)
  {
    for (paramin = paramin.a; paramLong > 0L; paramin = paramin.f)
    {
      int i = (int)Math.min(paramLong, paramin.c - paramin.b);
      this.e.update(paramin.a, paramin.b, i);
      paramLong -= i;
    }
  }
  
  public final je a()
  {
    return this.a.a();
  }
  
  public final void a_(in paramin, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return;
    }
    b(paramin, paramLong);
    this.c.a_(paramin, paramLong);
  }
  
  public final void close()
    throws IOException
  {
    if (this.d) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        this.c.b();
        this.a.g((int)this.e.getValue());
        this.a.g(this.b.getTotalIn());
        try
        {
          this.b.end();
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label72:
            if (localThrowable3 != null) {
              localThrowable2 = localThrowable3;
            }
          }
        }
        try
        {
          this.a.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable4)
        {
          Object localObject3 = localThrowable2;
          if (localThrowable2 != null) {
            break label72;
          }
          localObject3 = localThrowable4;
          break label72;
        }
        this.d = true;
        if (localObject2 == null) {
          continue;
        }
        jf.a((Throwable)localObject2);
        return;
      }
      catch (Throwable localThrowable3)
      {
        for (;;) {}
      }
    }
  }
  
  public final void flush()
    throws IOException
  {
    this.c.flush();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/iu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */