package b.a.j;

import b.a.c.g;
import b.ab;
import b.ab.a;
import b.ad;
import b.ah;
import b.ai;
import b.e;
import b.f;
import b.y;
import b.y.a;
import b.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class a
  implements c.a, ah
{
  private static final List<z> e;
  private static final long f = 16777216L;
  private static final long g = 60000L;
  final ai a;
  int b;
  int c;
  private final ab h;
  private final Random i;
  private final String j;
  private e k;
  private final Runnable l;
  private c m;
  private d n;
  private ScheduledExecutorService o;
  private f p;
  private final ArrayDeque<ByteString> q = new ArrayDeque();
  private final ArrayDeque<Object> r = new ArrayDeque();
  private long s;
  private boolean t;
  private ScheduledFuture<?> u;
  private int v = -1;
  private String w;
  private boolean x;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = Collections.singletonList(z.b);
      return;
    }
  }
  
  public a(ab paramab, ai paramai, Random paramRandom)
  {
    if (!"GET".equals(paramab.b())) {
      throw new IllegalArgumentException("Request must be GET: " + paramab.b());
    }
    this.h = paramab;
    this.a = paramai;
    this.i = paramRandom;
    paramab = new byte[16];
    paramRandom.nextBytes(paramab);
    this.j = ByteString.of(paramab).base64();
    this.l = new Runnable()
    {
      public void run()
      {
        try
        {
          boolean bool;
          do
          {
            bool = a.this.h();
          } while (bool);
          return;
        }
        catch (IOException localIOException)
        {
          a.this.a(localIOException, null);
        }
      }
    };
  }
  
  private boolean a(ByteString paramByteString, int paramInt)
  {
    boolean bool2 = false;
    for (boolean bool1 = bool2;; bool1 = true)
    {
      try
      {
        if (!this.x)
        {
          bool1 = this.t;
          if (!bool1) {
            break label31;
          }
        }
        for (bool1 = bool2;; bool1 = bool2)
        {
          return bool1;
          label31:
          if (this.s + paramByteString.size() <= 16777216L) {
            break;
          }
          a(1001, null);
        }
        this.s += paramByteString.size();
      }
      finally {}
      this.r.add(new d(paramInt, paramByteString));
      i();
    }
  }
  
  private void i()
  {
    if ((!d) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (this.o != null) {
      this.o.execute(this.l);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	b/a/j/a:x	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: getfield 211	b/a/j/a:n	Lb/a/j/d;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: getstatic 215	okio/ByteString:EMPTY	Lokio/ByteString;
    //   23: invokevirtual 220	b/a/j/d:a	(Lokio/ByteString;)V
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: invokevirtual 223	b/a/j/a:a	(Ljava/lang/Exception;Lb/ad;)V
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	a
    //   16	4	1	locald	d
    //   27	3	1	localIOException	IOException
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	26	27	java/io/IOException
    //   2	11	35	finally
    //   12	19	35	finally
    //   36	38	35	finally
  }
  
  public ab a()
  {
    return this.h;
  }
  
  void a(ad paramad)
    throws ProtocolException
  {
    if (paramad.c() != 101) {
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramad.c() + " " + paramad.e() + "'");
    }
    String str = paramad.b("Connection");
    if (!"Upgrade".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + str + "'");
    }
    str = paramad.b("Upgrade");
    if (!"websocket".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + str + "'");
    }
    paramad = paramad.b("Sec-WebSocket-Accept");
    str = ByteString.encodeUtf8(this.j + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    if (!str.equals(paramad)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + paramad + "'");
    }
  }
  
  public void a(y paramy)
  {
    paramy = paramy.z().a(e).c();
    final int i1 = paramy.d();
    final ab localab = this.h.f().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", this.j).a("Sec-WebSocket-Version", "13").d();
    this.k = b.a.a.a.a(paramy, localab);
    this.k.a(new f()
    {
      /* Error */
      public void a(e paramAnonymouse, ad paramAnonymousad)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   4: aload_2
        //   5: invokevirtual 36	b/a/j/a:a	(Lb/ad;)V
        //   8: getstatic 41	b/a/a:a	Lb/a/a;
        //   11: aload_1
        //   12: invokevirtual 44	b/a/a:a	(Lb/e;)Lb/a/c/g;
        //   15: astore_1
        //   16: aload_1
        //   17: invokevirtual 49	b/a/c/g:d	()V
        //   20: new 51	b/a/j/a$b
        //   23: dup
        //   24: aload_1
        //   25: invokespecial 54	b/a/j/a$b:<init>	(Lb/a/c/g;)V
        //   28: astore_3
        //   29: aload_0
        //   30: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   33: getfield 57	b/a/j/a:a	Lb/ai;
        //   36: aload_0
        //   37: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   40: aload_2
        //   41: invokevirtual 62	b/ai:a	(Lb/ah;Lb/ad;)V
        //   44: new 64	java/lang/StringBuilder
        //   47: dup
        //   48: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   51: ldc 67
        //   53: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: aload_0
        //   57: getfield 22	b/a/j/a$2:a	Lb/ab;
        //   60: invokevirtual 76	b/ab:a	()Lb/u;
        //   63: invokevirtual 82	b/u:u	()Ljava/lang/String;
        //   66: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   69: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   72: astore_2
        //   73: aload_0
        //   74: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   77: aload_2
        //   78: aload_0
        //   79: getfield 24	b/a/j/a$2:b	I
        //   82: i2l
        //   83: aload_3
        //   84: invokevirtual 88	b/a/j/a:a	(Ljava/lang/String;JLb/a/j/a$f;)V
        //   87: aload_1
        //   88: invokevirtual 91	b/a/c/g:b	()Lb/a/c/c;
        //   91: invokevirtual 96	b/a/c/c:b	()Ljava/net/Socket;
        //   94: iconst_0
        //   95: invokevirtual 102	java/net/Socket:setSoTimeout	(I)V
        //   98: aload_0
        //   99: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   102: invokevirtual 103	b/a/j/a:d	()V
        //   105: return
        //   106: astore_1
        //   107: aload_0
        //   108: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   111: aload_1
        //   112: aload_2
        //   113: invokevirtual 106	b/a/j/a:a	(Ljava/lang/Exception;Lb/ad;)V
        //   116: aload_2
        //   117: invokestatic 111	b/a/c:a	(Ljava/io/Closeable;)V
        //   120: return
        //   121: astore_1
        //   122: aload_0
        //   123: getfield 20	b/a/j/a$2:c	Lb/a/j/a;
        //   126: aload_1
        //   127: aconst_null
        //   128: invokevirtual 106	b/a/j/a:a	(Ljava/lang/Exception;Lb/ad;)V
        //   131: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	132	0	this	2
        //   0	132	1	paramAnonymouse	e
        //   0	132	2	paramAnonymousad	ad
        //   28	56	3	localb	a.b
        // Exception table:
        //   from	to	target	type
        //   0	8	106	java/net/ProtocolException
        //   29	105	121	java/lang/Exception
      }
      
      public void a(e paramAnonymouse, IOException paramAnonymousIOException)
      {
        a.this.a(paramAnonymousIOException, null);
      }
    });
  }
  
  /* Error */
  void a(Exception paramException, ad paramad)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	b/a/j/a:x	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 172	b/a/j/a:x	Z
    //   17: aload_0
    //   18: getfield 330	b/a/j/a:p	Lb/a/j/a$f;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 330	b/a/j/a:p	Lb/a/j/a$f;
    //   27: aload_0
    //   28: getfield 332	b/a/j/a:u	Ljava/util/concurrent/ScheduledFuture;
    //   31: ifnull +14 -> 45
    //   34: aload_0
    //   35: getfield 332	b/a/j/a:u	Ljava/util/concurrent/ScheduledFuture;
    //   38: iconst_0
    //   39: invokeinterface 338 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 201	b/a/j/a:o	Ljava/util/concurrent/ScheduledExecutorService;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 201	b/a/j/a:o	Ljava/util/concurrent/ScheduledExecutorService;
    //   56: invokeinterface 341 1 0
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 143	b/a/j/a:a	Lb/ai;
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 346	b/ai:a	(Lb/ah;Ljava/lang/Throwable;Lb/ad;)V
    //   73: aload_3
    //   74: invokestatic 351	b/a/c:a	(Ljava/io/Closeable;)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_3
    //   85: invokestatic 351	b/a/c:a	(Ljava/io/Closeable;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramException	Exception
    //   0	90	2	paramad	ad
    //   21	64	3	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	45	78	finally
    //   45	61	78	finally
    //   61	63	78	finally
    //   79	81	78	finally
    //   63	73	83	finally
  }
  
  public void a(String paramString, long paramLong, f paramf)
    throws IOException
  {
    try
    {
      this.p = paramf;
      this.n = new d(paramf.a, paramf.c, this.i);
      this.o = new ScheduledThreadPoolExecutor(1, b.a.c.a(paramString, false));
      if (paramLong != 0L) {
        this.o.scheduleAtFixedRate(new e(null), paramLong, paramLong, TimeUnit.MILLISECONDS);
      }
      if (!this.r.isEmpty()) {
        i();
      }
      this.m = new c(paramf.a, paramf.b, this);
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, 60000L);
  }
  
  boolean a(int paramInt, String paramString, long paramLong)
  {
    boolean bool1 = true;
    Object localObject;
    try
    {
      b.b(paramInt);
      localObject = null;
      if (paramString != null)
      {
        ByteString localByteString = ByteString.encodeUtf8(paramString);
        localObject = localByteString;
        if (localByteString.size() > 123L) {
          throw new IllegalArgumentException("reason.size() > 123: " + paramString);
        }
      }
    }
    finally {}
    if (!this.x)
    {
      boolean bool2 = this.t;
      if (!bool2) {}
    }
    else
    {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      this.t = true;
      this.r.add(new c(paramInt, (ByteString)localObject, paramLong));
      i();
    }
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("text == null");
    }
    return a(ByteString.encodeUtf8(paramString), 1);
  }
  
  public boolean a(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException("bytes == null");
    }
    return a(paramByteString, 2);
  }
  
  public long b()
  {
    try
    {
      long l1 = this.s;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt == -1) {
      throw new IllegalArgumentException();
    }
    Object localObject2 = null;
    try
    {
      if (this.v != -1) {
        throw new IllegalStateException("already closed");
      }
    }
    finally {}
    this.v = paramInt;
    this.w = paramString;
    Object localObject1 = localObject2;
    if (this.t)
    {
      localObject1 = localObject2;
      if (this.r.isEmpty())
      {
        localObject1 = this.p;
        this.p = null;
        if (this.u != null) {
          this.u.cancel(false);
        }
        this.o.shutdown();
      }
    }
    try
    {
      this.a.a(this, paramInt, paramString);
      if (localObject1 != null) {
        this.a.b(this, paramInt, paramString);
      }
      return;
    }
    finally
    {
      b.a.c.a((Closeable)localObject1);
    }
  }
  
  public void b(String paramString)
    throws IOException
  {
    this.a.a(this, paramString);
  }
  
  public void b(ByteString paramByteString)
    throws IOException
  {
    this.a.a(this, paramByteString);
  }
  
  public void c()
  {
    this.k.c();
  }
  
  /* Error */
  public void c(ByteString paramByteString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	b/a/j/a:x	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 174	b/a/j/a:t	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 107	b/a/j/a:r	Ljava/util/ArrayDeque;
    //   20: invokevirtual 384	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 105	b/a/j/a:q	Ljava/util/ArrayDeque;
    //   35: aload_1
    //   36: invokevirtual 189	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: aload_0
    //   41: invokespecial 191	b/a/j/a:i	()V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 444	b/a/j/a:b	I
    //   49: iconst_1
    //   50: iadd
    //   51: putfield 444	b/a/j/a:b	I
    //   54: goto -26 -> 28
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	a
    //   0	62	1	paramByteString	ByteString
    //   23	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	57	finally
    //   31	54	57	finally
  }
  
  public void d()
    throws IOException
  {
    while (this.v == -1) {
      this.m.a();
    }
  }
  
  public void d(ByteString paramByteString)
  {
    try
    {
      this.c += 1;
      return;
    }
    finally
    {
      paramByteString = finally;
      throw paramByteString;
    }
  }
  
  boolean e()
    throws IOException
  {
    boolean bool = false;
    try
    {
      this.m.a();
      int i1 = this.v;
      if (i1 == -1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      a(localException, null);
    }
    return false;
  }
  
  /* Error */
  boolean e(ByteString paramByteString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	b/a/j/a:x	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 174	b/a/j/a:t	Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 107	b/a/j/a:r	Ljava/util/ArrayDeque;
    //   20: invokevirtual 384	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +9 -> 34
    //   28: iconst_0
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 105	b/a/j/a:q	Ljava/util/ArrayDeque;
    //   38: aload_1
    //   39: invokevirtual 189	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: invokespecial 191	b/a/j/a:i	()V
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -19 -> 30
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	a
    //   0	57	1	paramByteString	ByteString
    //   23	26	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	52	finally
    //   34	47	52	finally
  }
  
  int f()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int g()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean h()
    throws IOException
  {
    Object localObject4 = null;
    int i2 = -1;
    Object localObject10 = null;
    Object localObject8 = null;
    for (;;)
    {
      d locald;
      ByteString localByteString;
      Object localObject9;
      try
      {
        if (this.x) {
          return false;
        }
        locald = this.n;
        localByteString = (ByteString)this.q.poll();
        i1 = i2;
        localObject7 = localObject10;
        localObject1 = localObject8;
        if (localByteString == null)
        {
          localObject9 = this.r.poll();
          if (!(localObject9 instanceof c)) {
            break label179;
          }
          i1 = this.v;
          localObject7 = this.w;
          if (i1 != -1)
          {
            localObject1 = this.p;
            this.p = null;
            this.o.shutdown();
            localObject4 = localObject9;
          }
        }
        else
        {
          if (localByteString == null) {
            break label201;
          }
        }
      }
      finally {}
      try
      {
        locald.b(localByteString);
        return true;
      }
      finally
      {
        b.a.c.a((Closeable)localObject3);
      }
      this.u = this.o.schedule(new a(), ((c)localObject9).c, TimeUnit.MILLISECONDS);
      localObject4 = localObject9;
      Object localObject1 = localObject8;
      continue;
      label179:
      localObject4 = localObject9;
      int i1 = i2;
      Object localObject7 = localObject10;
      Object localObject3 = localObject8;
      if (localObject9 == null)
      {
        return false;
        label201:
        if ((localObject4 instanceof d))
        {
          localObject7 = ((d)localObject4).b;
          localObject4 = Okio.buffer(locald.a(((d)localObject4).a, ((ByteString)localObject7).size()));
          ((BufferedSink)localObject4).write((ByteString)localObject7);
          ((BufferedSink)localObject4).close();
          try
          {
            this.s -= ((ByteString)localObject7).size();
            continue;
          }
          finally {}
        }
        else
        {
          if (!(localObject6 instanceof c)) {
            break;
          }
          c localc = (c)localObject6;
          locald.a(localc.a, localc.b);
          if (localObject3 != null) {
            this.a.b(this, i1, (String)localObject7);
          }
        }
      }
    }
    throw new AssertionError();
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      a.this.c();
    }
  }
  
  static final class b
    extends a.f
  {
    private final g d;
    
    b(g paramg)
    {
      super(paramg.b().d, paramg.b().e);
      this.d = paramg;
    }
    
    public void close()
    {
      this.d.a(true, this.d.a());
    }
  }
  
  static final class c
  {
    final int a;
    final ByteString b;
    final long c;
    
    c(int paramInt, ByteString paramByteString, long paramLong)
    {
      this.a = paramInt;
      this.b = paramByteString;
      this.c = paramLong;
    }
  }
  
  static final class d
  {
    final int a;
    final ByteString b;
    
    d(int paramInt, ByteString paramByteString)
    {
      this.a = paramInt;
      this.b = paramByteString;
    }
  }
  
  private final class e
    implements Runnable
  {
    private e() {}
    
    public void run()
    {
      a.a(a.this);
    }
  }
  
  public static abstract class f
    implements Closeable
  {
    public final boolean a;
    public final BufferedSource b;
    public final BufferedSink c;
    
    public f(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.a = paramBoolean;
      this.b = paramBufferedSource;
      this.c = paramBufferedSink;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */