package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class gr
  implements Closeable, Flushable
{
  static final Pattern a;
  private static final jc n;
  private final ih c;
  private long d;
  private final int e;
  private long f;
  private io g;
  private final LinkedHashMap<String, b> h;
  private int i;
  private boolean j;
  private boolean k;
  private final Executor l;
  private final Runnable m;
  
  static
  {
    if (!gr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = Pattern.compile("[a-z0-9_-]{1,120}");
      n = new jc()
      {
        public final je a()
        {
          return je.b;
        }
        
        public final void a_(in paramAnonymousin, long paramAnonymousLong)
          throws IOException
        {
          paramAnonymousin.f(paramAnonymousLong);
        }
        
        public final void close()
          throws IOException
        {}
        
        public final void flush()
          throws IOException
        {}
      };
      return;
    }
  }
  
  private void a(a parama)
    throws IOException
  {
    b localb;
    try
    {
      localb = parama.a;
      if (localb.f != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i1 = 0;
    while (i1 < this.e)
    {
      parama = localb.d[i1];
      this.c.a(parama);
      i1 += 1;
    }
    this.i += 1;
    localb.f = null;
    if ((localb.e | false))
    {
      localb.e = true;
      this.g.b("CLEAN").j(32);
      this.g.b(localb.a);
      localb.a(this.g);
      this.g.j(10);
    }
    for (;;)
    {
      this.g.flush();
      if ((this.f > this.d) || (a())) {
        this.l.execute(this.m);
      }
      return;
      this.h.remove(localb.a);
      this.g.b("REMOVE").j(32);
      this.g.b(localb.a);
      this.g.j(10);
    }
  }
  
  private boolean a()
  {
    return (this.i >= 2000) && (this.i >= this.h.size());
  }
  
  private boolean b()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void c()
  {
    try
    {
      if (b()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  private void d()
    throws IOException
  {
    while (this.f > this.d)
    {
      b localb = (b)this.h.values().iterator().next();
      if (localb.f != null) {
        localb.f.b = true;
      }
      int i1 = 0;
      while (i1 < this.e)
      {
        this.c.a(localb.c[i1]);
        this.f -= localb.b[i1];
        localb.b[i1] = 0L;
        i1 += 1;
      }
      this.i += 1;
      this.g.b("REMOVE").j(32).b(localb.a).j(10);
      this.h.remove(localb.a);
      if (a()) {
        this.l.execute(this.m);
      }
    }
  }
  
  public final void close()
    throws IOException
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((!this.j) || (this.k))
        {
          this.k = true;
          return;
        }
        b[] arrayOfb = (b[])this.h.values().toArray(new b[this.h.size()]);
        int i2 = arrayOfb.length;
        i1 = 0;
        if (i1 < i2)
        {
          ??? = arrayOfb[i1];
          if (((b)???).f == null) {
            break label143;
          }
          a locala = ((b)???).f;
          synchronized (locala.c)
          {
            locala.c.a(locala);
          }
        }
        d();
      }
      finally {}
      this.g.close();
      this.g = null;
      this.k = true;
      continue;
      label143:
      i1 += 1;
    }
  }
  
  /* Error */
  public final void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 179	com/indooratlas/android/sdk/_internal/gr:j	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 196	com/indooratlas/android/sdk/_internal/gr:c	()V
    //   18: aload_0
    //   19: invokespecial 192	com/indooratlas/android/sdk/_internal/gr:d	()V
    //   22: aload_0
    //   23: getfield 95	com/indooratlas/android/sdk/_internal/gr:g	Lcom/indooratlas/android/sdk/_internal/io;
    //   26: invokeinterface 114 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	gr
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public final class a
  {
    final gr.b a;
    boolean b;
  }
  
  final class b
  {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    gr.a f;
    
    final void a(io paramio)
      throws IOException
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramio.j(32).j(l);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */