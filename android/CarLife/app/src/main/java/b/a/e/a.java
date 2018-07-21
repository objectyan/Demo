package b.a.e;

import b.a.c.g;
import b.a.d.e;
import b.a.d.h;
import b.a.d.i;
import b.a.d.k;
import b.ab;
import b.ad;
import b.ad.a;
import b.ae;
import b.af;
import b.t;
import b.t.a;
import b.u;
import b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class a
  implements b.a.d.c
{
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private static final int k = 4;
  private static final int l = 5;
  private static final int m = 6;
  final y b;
  final g c;
  final BufferedSource d;
  final BufferedSink e;
  int f = 0;
  
  public a(y paramy, g paramg, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.b = paramy;
    this.c = paramg;
    this.d = paramBufferedSource;
    this.e = paramBufferedSink;
  }
  
  private Source b(ad paramad)
    throws IOException
  {
    if (!e.d(paramad)) {
      return b(0L);
    }
    if ("chunked".equalsIgnoreCase(paramad.b("Transfer-Encoding"))) {
      return a(paramad.a().a());
    }
    long l1 = e.a(paramad);
    if (l1 != -1L) {
      return b(l1);
    }
    return h();
  }
  
  public ae a(ad paramad)
    throws IOException
  {
    Source localSource = b(paramad);
    return new h(paramad.g(), Okio.buffer(localSource));
  }
  
  public Sink a(long paramLong)
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new d(paramLong);
  }
  
  public Sink a(ab paramab, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramab.a("Transfer-Encoding"))) {
      return g();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public Source a(u paramu)
    throws IOException
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new c(paramu);
  }
  
  public void a()
    throws IOException
  {
    this.e.flush();
  }
  
  public void a(ab paramab)
    throws IOException
  {
    String str = i.a(paramab, this.c.b().a().b().type());
    a(paramab.c(), str);
  }
  
  public void a(t paramt, String paramString)
    throws IOException
  {
    if (this.f != 0) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.e.writeUtf8(paramString).writeUtf8("\r\n");
    int n = 0;
    int i1 = paramt.a();
    while (n < i1)
    {
      this.e.writeUtf8(paramt.a(n)).writeUtf8(": ").writeUtf8(paramt.b(n)).writeUtf8("\r\n");
      n += 1;
    }
    this.e.writeUtf8("\r\n");
    this.f = 1;
  }
  
  void a(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  public ad.a b()
    throws IOException
  {
    return e();
  }
  
  public Source b(long paramLong)
    throws IOException
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 5;
    return new e(paramLong);
  }
  
  public void c()
  {
    b.a.c.c localc = this.c.b();
    if (localc != null) {
      localc.e();
    }
  }
  
  public boolean d()
  {
    return this.f == 6;
  }
  
  public ad.a e()
    throws IOException
  {
    if ((this.f != 1) && (this.f != 3)) {
      throw new IllegalStateException("state: " + this.f);
    }
    try
    {
      k localk;
      do
      {
        localk = k.a(this.d.readUtf8LineStrict());
        localObject = new ad.a().a(localk.d).a(localk.e).a(localk.f).a(f());
      } while (localk.e == 100);
      this.f = 4;
      return (ad.a)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.c);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public t f()
    throws IOException
  {
    t.a locala = new t.a();
    for (;;)
    {
      String str = this.d.readUtf8LineStrict();
      if (str.length() == 0) {
        break;
      }
      b.a.a.a.a(locala, str);
    }
    return locala.a();
  }
  
  public Sink g()
  {
    if (this.f != 1) {
      throw new IllegalStateException("state: " + this.f);
    }
    this.f = 2;
    return new b();
  }
  
  public Source h()
    throws IOException
  {
    if (this.f != 4) {
      throw new IllegalStateException("state: " + this.f);
    }
    if (this.c == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.f = 5;
    this.c.d();
    return new f();
  }
  
  private abstract class a
    implements Source
  {
    protected final ForwardingTimeout a = new ForwardingTimeout(a.this.d.timeout());
    protected boolean b;
    
    private a() {}
    
    protected final void a(boolean paramBoolean)
      throws IOException
    {
      if (a.this.f == 6) {}
      do
      {
        return;
        if (a.this.f != 5) {
          throw new IllegalStateException("state: " + a.this.f);
        }
        a.this.a(this.a);
        a.this.f = 6;
      } while (a.this.c == null);
      g localg = a.this.c;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localg.a(paramBoolean, a.this);
        return;
      }
    }
    
    public Timeout timeout()
    {
      return this.a;
    }
  }
  
  private final class b
    implements Sink
  {
    private final ForwardingTimeout b = new ForwardingTimeout(a.this.e.timeout());
    private boolean c;
    
    b() {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	b/a/e/a$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 44	b/a/e/a$b:c	Z
      //   19: aload_0
      //   20: getfield 18	b/a/e/a$b:a	Lb/a/e/a;
      //   23: getfield 27	b/a/e/a:e	Lokio/BufferedSink;
      //   26: ldc 46
      //   28: invokeinterface 50 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 18	b/a/e/a$b:a	Lb/a/e/a;
      //   38: aload_0
      //   39: getfield 38	b/a/e/a$b:b	Lokio/ForwardingTimeout;
      //   42: invokevirtual 53	b/a/e/a:a	(Lokio/ForwardingTimeout;)V
      //   45: aload_0
      //   46: getfield 18	b/a/e/a$b:a	Lb/a/e/a;
      //   49: iconst_3
      //   50: putfield 57	b/a/e/a:f	I
      //   53: goto -42 -> 11
      //   56: astore_2
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	b
      //   6	2	1	bool	boolean
      //   56	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	56	finally
      //   14	53	56	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	b/a/e/a$b:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 18	b/a/e/a$b:a	Lb/a/e/a;
      //   18: getfield 27	b/a/e/a:e	Lokio/BufferedSink;
      //   21: invokeinterface 61 1 0
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
    
    public Timeout timeout()
    {
      return this.b;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      a.this.e.writeHexadecimalUnsignedLong(paramLong);
      a.this.e.writeUtf8("\r\n");
      a.this.e.write(paramBuffer, paramLong);
      a.this.e.writeUtf8("\r\n");
    }
  }
  
  private class c
    extends a.a
  {
    private static final long e = -1L;
    private final u f;
    private long g = -1L;
    private boolean h = true;
    
    c(u paramu)
    {
      super(null);
      this.f = paramu;
    }
    
    private void a()
      throws IOException
    {
      if (this.g != -1L) {
        a.this.d.readUtf8LineStrict();
      }
      try
      {
        this.g = a.this.d.readHexadecimalUnsignedLong();
        String str = a.this.d.readUtf8LineStrict().trim();
        if ((this.g < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.g == 0L)
      {
        this.h = false;
        e.a(a.this.b.g(), this.f, a.this.f());
        a(true);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.h) && (!b.a.c.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (!this.h) {
        return -1L;
      }
      if ((this.g == 0L) || (this.g == -1L))
      {
        a();
        if (!this.h) {
          return -1L;
        }
      }
      paramLong = a.this.d.read(paramBuffer, Math.min(paramLong, this.g));
      if (paramLong == -1L)
      {
        a(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.g -= paramLong;
      return paramLong;
    }
  }
  
  private final class d
    implements Sink
  {
    private final ForwardingTimeout b = new ForwardingTimeout(a.this.e.timeout());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      a.this.a(this.b);
      a.this.f = 3;
    }
    
    public void flush()
      throws IOException
    {
      if (this.c) {
        return;
      }
      a.this.e.flush();
    }
    
    public Timeout timeout()
    {
      return this.b;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.c) {
        throw new IllegalStateException("closed");
      }
      b.a.c.a(paramBuffer.size(), 0L, paramLong);
      if (paramLong > this.d) {
        throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
      }
      a.this.e.write(paramBuffer, paramLong);
      this.d -= paramLong;
    }
  }
  
  private class e
    extends a.a
  {
    private long e;
    
    public e(long paramLong)
      throws IOException
    {
      super(null);
      this.e = paramLong;
      if (this.e == 0L) {
        a(true);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.e != 0L) && (!b.a.c.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false);
      }
      this.b = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e == 0L) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = a.this.d.read(paramBuffer, Math.min(this.e, paramLong));
        if (l == -1L)
        {
          a(false);
          throw new ProtocolException("unexpected end of stream");
        }
        this.e -= l;
        paramLong = l;
      } while (this.e != 0L);
      a(true);
      return l;
    }
  }
  
  private class f
    extends a.a
  {
    private boolean e;
    
    f()
    {
      super(null);
    }
    
    public void close()
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
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.b) {
        throw new IllegalStateException("closed");
      }
      if (this.e) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = a.this.d.read(paramBuffer, paramLong);
        paramLong = l;
      } while (l != -1L);
      this.e = true;
      a(true);
      return -1L;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */