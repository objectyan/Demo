package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class ir
  implements jc
{
  private final io a;
  private final Deflater b;
  private boolean c;
  
  ir(io paramio, Deflater paramDeflater)
  {
    if (paramio == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramio;
    this.b = paramDeflater;
  }
  
  public ir(jc paramjc, Deflater paramDeflater)
  {
    this(ix.a(paramjc), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void a(boolean paramBoolean)
    throws IOException
  {
    in localin = this.a.b();
    ja localja;
    label119:
    do
    {
      localja = localin.f(1);
      if (paramBoolean) {}
      for (int i = this.b.deflate(localja.a, localja.c, 2048 - localja.c, 2);; i = this.b.deflate(localja.a, localja.c, 2048 - localja.c))
      {
        if (i <= 0) {
          break label119;
        }
        localja.c += i;
        localin.b += i;
        this.a.p();
        break;
      }
    } while (!this.b.needsInput());
    if (localja.b == localja.c)
    {
      localin.a = localja.a();
      jb.a(localja);
    }
  }
  
  public final je a()
  {
    return this.a.a();
  }
  
  public final void a_(in paramin, long paramLong)
    throws IOException
  {
    jf.a(paramin.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      ja localja = paramin.a;
      int i = (int)Math.min(paramLong, localja.c - localja.b);
      this.b.setInput(localja.a, localja.b, i);
      a(false);
      paramin.b -= i;
      localja.b += i;
      if (localja.b == localja.c)
      {
        paramin.a = localja.a();
        jb.a(localja);
      }
      paramLong -= i;
    }
  }
  
  final void b()
    throws IOException
  {
    this.b.finish();
    a(false);
  }
  
  public final void close()
    throws IOException
  {
    if (this.c) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      try
      {
        b();
        try
        {
          this.b.end();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label34:
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        try
        {
          this.a.close();
          localObject3 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject2;
          if (localObject2 != null) {
            break label34;
          }
          localObject3 = localThrowable3;
          break label34;
        }
        this.c = true;
        if (localObject3 == null) {
          continue;
        }
        jf.a((Throwable)localObject3);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        for (;;) {}
      }
    }
  }
  
  public final void flush()
    throws IOException
  {
    a(true);
    this.a.flush();
  }
  
  public final String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */