package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class hs
  implements hx
{
  final ig a;
  final ip b;
  final io c;
  int d = 0;
  private hv e;
  
  public hs(ig paramig, ip paramip, io paramio)
  {
    this.a = paramig;
    this.b = paramip;
    this.c = paramio;
  }
  
  public final gn a(gm paramgm)
    throws IOException
  {
    Object localObject;
    if (!hv.c(paramgm)) {
      localObject = a(0L);
    }
    for (;;)
    {
      return new hz(paramgm.f, ix.a((jd)localObject));
      if ("chunked".equalsIgnoreCase(paramgm.a("Transfer-Encoding")))
      {
        localObject = this.e;
        if (this.d != 4) {
          throw new IllegalStateException("state: " + this.d);
        }
        this.d = 5;
        localObject = new c((hv)localObject);
      }
      else
      {
        long l = hy.a(paramgm);
        if (l != -1L)
        {
          localObject = a(l);
        }
        else
        {
          if (this.d != 4) {
            throw new IllegalStateException("state: " + this.d);
          }
          if (this.a == null) {
            throw new IllegalStateException("streamAllocation == null");
          }
          this.d = 5;
          this.a.a(true, false, false);
          localObject = new f((byte)0);
        }
      }
    }
  }
  
  public final jc a(gk paramgk, long paramLong)
    throws IOException
  {
    if ("chunked".equalsIgnoreCase(paramgk.a("Transfer-Encoding")))
    {
      if (this.d != 1) {
        throw new IllegalStateException("state: " + this.d);
      }
      this.d = 2;
      return new b((byte)0);
    }
    if (paramLong != -1L)
    {
      if (this.d != 1) {
        throw new IllegalStateException("state: " + this.d);
      }
      this.d = 2;
      return new d(paramLong, (byte)0);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public final jd a(long paramLong)
    throws IOException
  {
    if (this.d != 4) {
      throw new IllegalStateException("state: " + this.d);
    }
    this.d = 5;
    return new e(paramLong);
  }
  
  public final void a()
  {
    ii localii = this.a.a();
    if (localii != null) {
      gy.a(localii.b);
    }
  }
  
  public final void a(gd paramgd, String paramString)
    throws IOException
  {
    if (this.d != 0) {
      throw new IllegalStateException("state: " + this.d);
    }
    this.c.b(paramString).b("\r\n");
    int i = 0;
    int j = paramgd.a.length / 2;
    while (i < j)
    {
      this.c.b(paramgd.a(i)).b(": ").b(paramgd.b(i)).b("\r\n");
      i += 1;
    }
    this.c.b("\r\n");
    this.d = 1;
  }
  
  public final void a(gk paramgk)
    throws IOException
  {
    this.e.a();
    Object localObject = this.e.c.a().a().b.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramgk.b);
    localStringBuilder.append(' ');
    int i;
    if ((!paramgk.g()) && (localObject == Proxy.Type.HTTP))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      localStringBuilder.append(paramgk.a);
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      localObject = localStringBuilder.toString();
      a(paramgk.c, (String)localObject);
      return;
      i = 0;
      break;
      label115:
      localStringBuilder.append(ib.a(paramgk.a));
    }
  }
  
  public final void a(hv paramhv)
  {
    this.e = paramhv;
  }
  
  public final void a(ic paramic)
    throws IOException
  {
    if (this.d != 1) {
      throw new IllegalStateException("state: " + this.d);
    }
    this.d = 3;
    paramic.a(this.c);
  }
  
  public final gm.a b()
    throws IOException
  {
    return d();
  }
  
  public final void c()
    throws IOException
  {
    this.c.flush();
  }
  
  public final gm.a d()
    throws IOException
  {
    if ((this.d != 1) && (this.d != 3)) {
      throw new IllegalStateException("state: " + this.d);
    }
    try
    {
      if localif;
      do
      {
        localif = if.a(this.b.m());
        localObject = new gm.a();
        ((gm.a)localObject).b = localif.a;
        ((gm.a)localObject).c = localif.b;
        ((gm.a)localObject).d = localif.c;
        localObject = ((gm.a)localObject).a(e());
      } while (localif.b == 100);
      this.d = 4;
      return (gm.a)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.a);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public final gd e()
    throws IOException
  {
    gd.a locala = new gd.a();
    for (;;)
    {
      String str = this.b.m();
      if (str.length() == 0) {
        break;
      }
      gs.b.a(locala, str);
    }
    return locala.a();
  }
  
  abstract class a
    implements jd
  {
    protected final it a = new it(hs.this.b.a());
    protected boolean b;
    
    private a() {}
    
    public final je a()
    {
      return this.a;
    }
    
    protected final void a(boolean paramBoolean)
      throws IOException
    {
      if (hs.this.d == 6) {}
      do
      {
        return;
        if (hs.this.d != 5) {
          throw new IllegalStateException("state: " + hs.this.d);
        }
        hs.a(this.a);
        hs.this.d = 6;
      } while (hs.this.a == null);
      ig localig = hs.this.a;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localig.a(paramBoolean, hs.this);
        return;
      }
    }
  }
  
  final class b
    implements jc
  {
    private final it b = new it(hs.this.c.a());
    private boolean c;
    
    private b() {}
    
    public final je a()
    {
      return this.b;
    }
    
    public final void a_(in paramin, long paramLong)
      throws IOException
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      hs.this.c.i(paramLong);
      hs.this.c.b("\r\n");
      hs.this.c.a_(paramin, paramLong);
      hs.this.c.b("\r\n");
    }
    
    /* Error */
    public final void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 46	com/indooratlas/android/sdk/_internal/hs$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 46	com/indooratlas/android/sdk/_internal/hs$b:c	Z
      //   19: aload_0
      //   20: getfield 18	com/indooratlas/android/sdk/_internal/hs$b:a	Lcom/indooratlas/android/sdk/_internal/hs;
      //   23: getfield 26	com/indooratlas/android/sdk/_internal/hs:c	Lcom/indooratlas/android/sdk/_internal/io;
      //   26: ldc 68
      //   28: invokeinterface 62 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 36	com/indooratlas/android/sdk/_internal/hs$b:b	Lcom/indooratlas/android/sdk/_internal/it;
      //   38: invokestatic 71	com/indooratlas/android/sdk/_internal/hs:a	(Lcom/indooratlas/android/sdk/_internal/it;)V
      //   41: aload_0
      //   42: getfield 18	com/indooratlas/android/sdk/_internal/hs$b:a	Lcom/indooratlas/android/sdk/_internal/hs;
      //   45: iconst_3
      //   46: putfield 75	com/indooratlas/android/sdk/_internal/hs:d	I
      //   49: goto -38 -> 11
      //   52: astore_2
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	b
      //   6	2	1	bool	boolean
      //   52	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	52	finally
      //   14	49	52	finally
    }
    
    /* Error */
    public final void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 46	com/indooratlas/android/sdk/_internal/hs$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 18	com/indooratlas/android/sdk/_internal/hs$b:a	Lcom/indooratlas/android/sdk/_internal/hs;
      //   18: getfield 26	com/indooratlas/android/sdk/_internal/hs:c	Lcom/indooratlas/android/sdk/_internal/io;
      //   21: invokeinterface 78 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	b
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
  }
  
  final class c
    extends hs.a
  {
    private long e = -1L;
    private boolean f = true;
    private final hv g;
    
    c(hv paramhv)
      throws IOException
    {
      super((byte)0);
      this.g = paramhv;
    }
    
    public final long a(in paramin, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (!this.f) {}
      do
      {
        return -1L;
        if ((this.e != 0L) && (this.e != -1L)) {
          break;
        }
        if (this.e != -1L) {
          hs.this.b.m();
        }
        try
        {
          this.e = hs.this.b.j();
          String str = hs.this.b.m().trim();
          if ((this.e < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + str + "\"");
          }
        }
        catch (NumberFormatException paramin)
        {
          throw new ProtocolException(paramin.getMessage());
        }
        if (this.e == 0L)
        {
          this.f = false;
          this.g.a(hs.this.e());
          a(true);
        }
      } while (!this.f);
      paramLong = hs.this.b.a(paramin, Math.min(paramLong, this.e));
      if (paramLong == -1L)
      {
        a(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.e -= paramLong;
      return paramLong;
    }
    
    public final void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.f) && (!gy.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class d
    implements jc
  {
    private final it b = new it(hs.this.c.a());
    private boolean c;
    private long d;
    
    private d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public final je a()
    {
      return this.b;
    }
    
    public final void a_(in paramin, long paramLong)
      throws IOException
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      gy.a(paramin.b, paramLong);
      if (paramLong > this.d) {
        throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
      }
      hs.this.c.a_(paramin, paramLong);
      this.d -= paramLong;
    }
    
    public final void close()
      throws IOException
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      hs.a(this.b);
      hs.this.d = 3;
    }
    
    public final void flush()
      throws IOException
    {
      if (this.c) {
        return;
      }
      hs.this.c.flush();
    }
  }
  
  final class e
    extends hs.a
  {
    private long e;
    
    public e(long paramLong)
      throws IOException
    {
      super((byte)0);
      this.e = paramLong;
      if (this.e == 0L) {
        a(true);
      }
    }
    
    public final long a(in paramin, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e == 0L) {
        return -1L;
      }
      paramLong = hs.this.b.a(paramin, Math.min(this.e, paramLong));
      if (paramLong == -1L)
      {
        a(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.e -= paramLong;
      if (this.e == 0L) {
        a(true);
      }
      return paramLong;
    }
    
    public final void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.e != 0L) && (!gy.a(this, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
  }
  
  final class f
    extends hs.a
  {
    private boolean e;
    
    private f()
    {
      super((byte)0);
    }
    
    public final long a(in paramin, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e) {
        return -1L;
      }
      paramLong = hs.this.b.a(paramin, paramLong);
      if (paramLong == -1L)
      {
        this.e = true;
        a(true);
        return -1L;
      }
      return paramLong;
    }
    
    public final void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if (!this.e) {
        a(false);
      }
      this.b = true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */