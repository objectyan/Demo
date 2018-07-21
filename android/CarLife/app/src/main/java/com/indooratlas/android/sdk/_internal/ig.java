package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.util.List;

public final class ig
{
  public final fn a;
  public final fw b;
  ie c;
  public ii d;
  public boolean e;
  public hx f;
  private go g;
  private boolean h;
  
  public ig(fw paramfw, fn paramfn)
  {
    this.b = paramfw;
    this.a = paramfn;
    this.c = new ie(paramfn, c());
  }
  
  private ii a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException, id
  {
    synchronized (this.b)
    {
      if (this.h) {
        throw new IllegalStateException("released");
      }
    }
    if (this.f != null) {
      throw new IllegalStateException("stream != null");
    }
    if (this.e) {
      throw new IOException("Canceled");
    }
    ??? = this.d;
    if ((??? != null) && (!((ii)???).j)) {
      return (ii)???;
    }
    ??? = gs.b.a(this.b, this.a, this);
    if (??? != null)
    {
      this.d = ((ii)???);
      return (ii)???;
    }
    ??? = this.g;
    if (??? == null) {
      ??? = this.c.a();
    }
    for (;;)
    {
      synchronized (this.b)
      {
        this.g = ((go)???);
        ??? = new ii((go)???);
        a((ii)???);
        synchronized (this.b)
        {
          gs.b.b(this.b, (ii)???);
          this.d = ((ii)???);
          if (this.e) {
            throw new IOException("Canceled");
          }
        }
      }
      localii.a(paramInt1, paramInt2, paramInt3, this.a.f, paramBoolean);
      c().b(localii.a);
      return localii;
    }
  }
  
  private ii b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, id
  {
    for (;;)
    {
      ii localii1 = a(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.b)
      {
        if (localii1.f == 0) {
          return localii1;
        }
        if (!localii1.a(paramBoolean2)) {
          a(new IOException());
        }
      }
    }
    return localii2;
  }
  
  private gx c()
  {
    return gs.b.a(this.b);
  }
  
  /* Error */
  public final hx a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws id, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 125	com/indooratlas/android/sdk/_internal/ig:b	(IIIZZ)Lcom/indooratlas/android/sdk/_internal/ii;
    //   11: astore 6
    //   13: aload 6
    //   15: getfield 128	com/indooratlas/android/sdk/_internal/ii:e	Lcom/indooratlas/android/sdk/_internal/hc;
    //   18: ifnull +39 -> 57
    //   21: new 130	com/indooratlas/android/sdk/_internal/ht
    //   24: dup
    //   25: aload_0
    //   26: aload 6
    //   28: getfield 128	com/indooratlas/android/sdk/_internal/ii:e	Lcom/indooratlas/android/sdk/_internal/hc;
    //   31: invokespecial 133	com/indooratlas/android/sdk/_internal/ht:<init>	(Lcom/indooratlas/android/sdk/_internal/ig;Lcom/indooratlas/android/sdk/_internal/hc;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 26	com/indooratlas/android/sdk/_internal/ig:b	Lcom/indooratlas/android/sdk/_internal/fw;
    //   40: astore 7
    //   42: aload 7
    //   44: monitorenter
    //   45: aload_0
    //   46: aload 6
    //   48: putfield 55	com/indooratlas/android/sdk/_internal/ig:f	Lcom/indooratlas/android/sdk/_internal/hx;
    //   51: aload 7
    //   53: monitorexit
    //   54: aload 6
    //   56: areturn
    //   57: aload 6
    //   59: getfield 136	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   62: iload_2
    //   63: invokevirtual 142	java/net/Socket:setSoTimeout	(I)V
    //   66: aload 6
    //   68: getfield 145	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   71: invokeinterface 150 1 0
    //   76: iload_2
    //   77: i2l
    //   78: getstatic 156	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   81: invokevirtual 161	com/indooratlas/android/sdk/_internal/je:a	(JLjava/util/concurrent/TimeUnit;)Lcom/indooratlas/android/sdk/_internal/je;
    //   84: pop
    //   85: aload 6
    //   87: getfield 164	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   90: invokeinterface 167 1 0
    //   95: iload_3
    //   96: i2l
    //   97: getstatic 156	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   100: invokevirtual 161	com/indooratlas/android/sdk/_internal/je:a	(JLjava/util/concurrent/TimeUnit;)Lcom/indooratlas/android/sdk/_internal/je;
    //   103: pop
    //   104: new 169	com/indooratlas/android/sdk/_internal/hs
    //   107: dup
    //   108: aload_0
    //   109: aload 6
    //   111: getfield 145	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   114: aload 6
    //   116: getfield 164	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   119: invokespecial 172	com/indooratlas/android/sdk/_internal/hs:<init>	(Lcom/indooratlas/android/sdk/_internal/ig;Lcom/indooratlas/android/sdk/_internal/ip;Lcom/indooratlas/android/sdk/_internal/io;)V
    //   122: astore 6
    //   124: goto -88 -> 36
    //   127: astore 6
    //   129: new 44	com/indooratlas/android/sdk/_internal/id
    //   132: dup
    //   133: aload 6
    //   135: invokespecial 174	com/indooratlas/android/sdk/_internal/id:<init>	(Ljava/io/IOException;)V
    //   138: athrow
    //   139: astore 6
    //   141: aload 7
    //   143: monitorexit
    //   144: aload 6
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ig
    //   0	147	1	paramInt1	int
    //   0	147	2	paramInt2	int
    //   0	147	3	paramInt3	int
    //   0	147	4	paramBoolean1	boolean
    //   0	147	5	paramBoolean2	boolean
    //   11	112	6	localObject1	Object
    //   127	7	6	localIOException	IOException
    //   139	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	36	127	java/io/IOException
    //   36	45	127	java/io/IOException
    //   57	124	127	java/io/IOException
    //   144	147	127	java/io/IOException
    //   45	54	139	finally
    //   141	144	139	finally
  }
  
  public final ii a()
  {
    try
    {
      ii localii = this.d;
      return localii;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(ii paramii)
  {
    paramii.i.add(new WeakReference(this));
  }
  
  public final void a(IOException paramIOException)
  {
    synchronized (this.b)
    {
      if ((this.d != null) && (this.d.f == 0))
      {
        if ((this.g != null) && (paramIOException != null))
        {
          ie localie = this.c;
          go localgo = this.g;
          if ((localgo.b.type() != Proxy.Type.DIRECT) && (localie.a.g != null)) {
            localie.a.g.connectFailed(localie.a.a.a(), localgo.b.address(), paramIOException);
          }
          localie.b.a(localgo);
        }
        this.g = null;
      }
      a(true, false, true);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, hx paramhx)
  {
    fw localfw = this.b;
    if (paramhx != null) {}
    try
    {
      if (paramhx != this.f) {
        throw new IllegalStateException("expected " + this.f + " but was " + paramhx);
      }
    }
    finally
    {
      throw paramhx;
      if (!paramBoolean)
      {
        paramhx = this.d;
        paramhx.f += 1;
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    fw localfw = this.b;
    if (paramBoolean3) {}
    for (;;)
    {
      try
      {
        this.f = null;
        if (paramBoolean2) {
          this.h = true;
        }
        if (this.d == null) {
          break label234;
        }
        if (paramBoolean1) {
          this.d.j = true;
        }
        if ((this.f != null) || ((!this.h) && (!this.d.j))) {
          break label234;
        }
        ii localii = this.d;
        int j = localii.i.size();
        int i = 0;
        if (i < j)
        {
          if (((Reference)localii.i.get(i)).get() == this)
          {
            localii.i.remove(i);
            if (this.d.i.isEmpty())
            {
              this.d.k = System.nanoTime();
              if (gs.b.a(this.b, this.d))
              {
                localii = this.d;
                this.d = null;
                if (localii != null) {
                  gy.a(localii.c);
                }
              }
            }
          }
          else
          {
            i += 1;
          }
        }
        else {
          throw new IllegalStateException();
        }
      }
      finally {}
      Object localObject2 = null;
      continue;
      label234:
      localObject2 = null;
    }
  }
  
  public final void b()
  {
    a(false, true, false);
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */