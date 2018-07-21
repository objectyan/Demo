package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.d.e;
import cz.msebera.android.httpclient.e.d.c;
import cz.msebera.android.httpclient.e.i;
import cz.msebera.android.httpclient.e.k;
import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.e.o;
import cz.msebera.android.httpclient.e.p;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.r;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
public class ag
  implements o, cz.msebera.android.httpclient.m.d<cz.msebera.android.httpclient.e.b.b>, Closeable
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final a b = new a();
  private final f c;
  private final t d;
  private final AtomicBoolean e;
  
  public ag()
  {
    this(h());
  }
  
  public ag(long paramLong, TimeUnit paramTimeUnit)
  {
    this(h(), null, null, null, paramLong, paramTimeUnit);
  }
  
  public ag(cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> paramd)
  {
    this(paramd, null, null);
  }
  
  public ag(cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> paramd, l paraml)
  {
    this(paramd, null, paraml);
  }
  
  public ag(cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> paramd, p<cz.msebera.android.httpclient.e.b.b, u> paramp)
  {
    this(paramd, paramp, null);
  }
  
  public ag(cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> paramd, p<cz.msebera.android.httpclient.e.b.b, u> paramp, l paraml)
  {
    this(paramd, paramp, null, paraml, -1L, TimeUnit.MILLISECONDS);
  }
  
  public ag(cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> paramd, p<cz.msebera.android.httpclient.e.b.b, u> paramp, x paramx, l paraml, long paramLong, TimeUnit paramTimeUnit)
  {
    this.c = new f(new b(this.b, paramp), 2, 20, paramLong, paramTimeUnit);
    this.d = new t(paramd, paramx, paraml);
    this.e = new AtomicBoolean(false);
  }
  
  public ag(p<cz.msebera.android.httpclient.e.b.b, u> paramp)
  {
    this(h(), paramp, null);
  }
  
  ag(f paramf, cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> paramb, x paramx, l paraml)
  {
    this.c = paramf;
    this.d = new t(paramb, paramx, paraml);
    this.e = new AtomicBoolean(false);
  }
  
  private String a(g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id: ").append(paramg.g()).append("]");
    localStringBuilder.append("[route: ").append(paramg.h()).append("]");
    paramg = paramg.l();
    if (paramg != null) {
      localStringBuilder.append("[state: ").append(paramg).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String b(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ").append(paramb).append("]");
    if (paramObject != null) {
      localStringBuilder.append("[state: ").append(paramObject).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String c(cz.msebera.android.httpclient.e.b.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    cz.msebera.android.httpclient.m.h localh = this.c.f();
    paramb = this.c.a(paramb);
    localStringBuilder.append("[total kept alive: ").append(localh.c()).append("; ");
    localStringBuilder.append("route allocated: ").append(paramb.a() + paramb.c());
    localStringBuilder.append(" of ").append(paramb.d()).append("; ");
    localStringBuilder.append("total allocated: ").append(localh.a() + localh.c());
    localStringBuilder.append(" of ").append(localh.d()).append("]");
    return localStringBuilder.toString();
  }
  
  private static cz.msebera.android.httpclient.d.d<cz.msebera.android.httpclient.e.d.a> h()
  {
    return e.a().a("http", c.a()).a("https", cz.msebera.android.httpclient.e.e.f.a()).b();
  }
  
  public int a(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.c.b(paramb);
  }
  
  public cz.msebera.android.httpclient.d.f a(r paramr)
  {
    return this.b.a(paramr);
  }
  
  public k a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    if (this.a.a()) {
      this.a.a("Connection request: " + b(paramb, paramObject) + c(paramb));
    }
    new k()
    {
      public j a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, ExecutionException, i
      {
        return ag.this.a(this.a, paramAnonymousLong, paramAnonymousTimeUnit);
      }
      
      public boolean a()
      {
        return this.a.cancel(true);
      }
    };
  }
  
  protected j a(Future<g> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, i
  {
    try
    {
      paramTimeUnit = (g)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
        throw new InterruptedException();
      }
    }
    catch (TimeoutException paramFuture)
    {
      throw new i("Timeout waiting for connection from pool");
    }
    if (paramTimeUnit.i() != null) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Pool entry with no connection");
      if (this.a.a()) {
        this.a.a("Connection leased: " + a(paramTimeUnit) + c((cz.msebera.android.httpclient.e.b.b)paramTimeUnit.h()));
      }
      paramFuture = h.a(paramTimeUnit);
      return paramFuture;
    }
  }
  
  public void a()
  {
    this.a.a("Closing expired connections");
    this.c.c();
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.a.a()) {
      this.a.a("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
    }
    this.c.a(paramLong, paramTimeUnit);
  }
  
  public void a(cz.msebera.android.httpclient.d.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(cz.msebera.android.httpclient.d.f paramf)
  {
    this.b.a(paramf);
  }
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, int paramInt)
  {
    this.c.a(paramb, paramInt);
  }
  
  public void a(j paramj, cz.msebera.android.httpclient.e.b.b paramb, int paramInt, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Managed Connection");
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    for (;;)
    {
      try
      {
        u localu = (u)h.a(paramj).i();
        if (paramb.e() != null)
        {
          localr = paramb.e();
          InetSocketAddress localInetSocketAddress = paramb.c();
          paramb = this.b.a(localr);
          paramj = paramb;
          if (paramb == null) {
            paramj = this.b.a();
          }
          paramb = paramj;
          if (paramj == null) {
            paramb = cz.msebera.android.httpclient.d.f.a;
          }
          this.d.a(localu, localr, localInetSocketAddress, paramInt, paramb, paramg);
          return;
        }
      }
      finally {}
      r localr = paramb.a();
    }
  }
  
  public void a(j paramj, cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Managed Connection");
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    try
    {
      u localu = (u)h.a(paramj).i();
      this.d.a(localu, paramb.a(), paramg);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(j paramj, Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 339
    //   4: invokestatic 210	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_1
    //   11: invokestatic 341	cz/msebera/android/httpclient/i/c/h:b	(Lcz/msebera/android/httpclient/j;)Lcz/msebera/android/httpclient/i/c/g;
    //   14: astore 7
    //   16: aload 7
    //   18: ifnonnull +6 -> 24
    //   21: aload_1
    //   22: monitorexit
    //   23: return
    //   24: aload 7
    //   26: invokevirtual 254	cz/msebera/android/httpclient/i/c/g:i	()Ljava/lang/Object;
    //   29: checkcast 313	cz/msebera/android/httpclient/e/u
    //   32: astore 8
    //   34: aload 8
    //   36: invokeinterface 343 1 0
    //   41: ifeq +117 -> 158
    //   44: aload 5
    //   46: ifnull +211 -> 257
    //   49: aload 7
    //   51: aload_2
    //   52: invokevirtual 344	cz/msebera/android/httpclient/i/c/g:a	(Ljava/lang/Object;)V
    //   55: aload 7
    //   57: lload_3
    //   58: aload 5
    //   60: invokevirtual 345	cz/msebera/android/httpclient/i/c/g:a	(JLjava/util/concurrent/TimeUnit;)V
    //   63: aload_0
    //   64: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   67: invokevirtual 213	cz/msebera/android/httpclient/h/b:a	()Z
    //   70: ifeq +88 -> 158
    //   73: lload_3
    //   74: lconst_0
    //   75: lcmp
    //   76: ifle +189 -> 265
    //   79: new 108	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 347
    //   89: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 5
    //   94: lload_3
    //   95: invokevirtual 351	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   98: l2d
    //   99: ldc2_w 352
    //   102: ddiv
    //   103: invokevirtual 356	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 358
    //   109: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   120: new 108	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 360
    //   130: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: aload 7
    //   136: invokespecial 265	cz/msebera/android/httpclient/i/c/ag:a	(Lcz/msebera/android/httpclient/i/c/g;)Ljava/lang/String;
    //   139: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 362
    //   145: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 221	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 86	cz/msebera/android/httpclient/i/c/ag:c	Lcz/msebera/android/httpclient/i/c/f;
    //   162: astore_2
    //   163: aload 8
    //   165: invokeinterface 343 1 0
    //   170: ifeq +102 -> 272
    //   173: aload 7
    //   175: invokevirtual 364	cz/msebera/android/httpclient/i/c/g:b	()Z
    //   178: ifeq +94 -> 272
    //   181: iconst_1
    //   182: istore 6
    //   184: aload_2
    //   185: aload 7
    //   187: iload 6
    //   189: invokevirtual 367	cz/msebera/android/httpclient/i/c/f:a	(Lcz/msebera/android/httpclient/m/e;Z)V
    //   192: aload_0
    //   193: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   196: invokevirtual 213	cz/msebera/android/httpclient/h/b:a	()Z
    //   199: ifeq +50 -> 249
    //   202: aload_0
    //   203: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   206: new 108	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 369
    //   216: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: aload 7
    //   222: invokespecial 265	cz/msebera/android/httpclient/i/c/ag:a	(Lcz/msebera/android/httpclient/i/c/g;)Ljava/lang/String;
    //   225: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: aload 7
    //   231: invokevirtual 128	cz/msebera/android/httpclient/i/c/g:h	()Ljava/lang/Object;
    //   234: checkcast 267	cz/msebera/android/httpclient/e/b/b
    //   237: invokespecial 219	cz/msebera/android/httpclient/i/c/ag:c	(Lcz/msebera/android/httpclient/e/b/b;)Ljava/lang/String;
    //   240: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 221	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   249: aload_1
    //   250: monitorexit
    //   251: return
    //   252: astore_2
    //   253: aload_1
    //   254: monitorexit
    //   255: aload_2
    //   256: athrow
    //   257: getstatic 59	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   260: astore 5
    //   262: goto -213 -> 49
    //   265: ldc_w 371
    //   268: astore_2
    //   269: goto -153 -> 116
    //   272: iconst_0
    //   273: istore 6
    //   275: goto -91 -> 184
    //   278: astore_2
    //   279: aload_0
    //   280: getfield 86	cz/msebera/android/httpclient/i/c/ag:c	Lcz/msebera/android/httpclient/i/c/f;
    //   283: astore 5
    //   285: aload 8
    //   287: invokeinterface 343 1 0
    //   292: ifeq +82 -> 374
    //   295: aload 7
    //   297: invokevirtual 364	cz/msebera/android/httpclient/i/c/g:b	()Z
    //   300: ifeq +74 -> 374
    //   303: iconst_1
    //   304: istore 6
    //   306: aload 5
    //   308: aload 7
    //   310: iload 6
    //   312: invokevirtual 367	cz/msebera/android/httpclient/i/c/f:a	(Lcz/msebera/android/httpclient/m/e;Z)V
    //   315: aload_0
    //   316: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   319: invokevirtual 213	cz/msebera/android/httpclient/h/b:a	()Z
    //   322: ifeq +50 -> 372
    //   325: aload_0
    //   326: getfield 73	cz/msebera/android/httpclient/i/c/ag:a	Lcz/msebera/android/httpclient/h/b;
    //   329: new 108	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 369
    //   339: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: aload 7
    //   345: invokespecial 265	cz/msebera/android/httpclient/i/c/ag:a	(Lcz/msebera/android/httpclient/i/c/g;)Ljava/lang/String;
    //   348: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: aload 7
    //   354: invokevirtual 128	cz/msebera/android/httpclient/i/c/g:h	()Ljava/lang/Object;
    //   357: checkcast 267	cz/msebera/android/httpclient/e/b/b
    //   360: invokespecial 219	cz/msebera/android/httpclient/i/c/ag:c	(Lcz/msebera/android/httpclient/e/b/b;)Ljava/lang/String;
    //   363: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 221	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   372: aload_2
    //   373: athrow
    //   374: iconst_0
    //   375: istore 6
    //   377: goto -71 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ag
    //   0	380	1	paramj	j
    //   0	380	2	paramObject	Object
    //   0	380	3	paramLong	long
    //   0	380	5	paramTimeUnit	TimeUnit
    //   182	194	6	bool	boolean
    //   14	339	7	localg	g
    //   32	254	8	localu	u
    // Exception table:
    //   from	to	target	type
    //   10	16	252	finally
    //   21	23	252	finally
    //   24	34	252	finally
    //   158	181	252	finally
    //   184	249	252	finally
    //   249	251	252	finally
    //   253	255	252	finally
    //   279	303	252	finally
    //   306	372	252	finally
    //   372	374	252	finally
    //   34	44	278	finally
    //   49	73	278	finally
    //   79	116	278	finally
    //   116	158	278	finally
    //   257	262	278	finally
  }
  
  public void a(r paramr, cz.msebera.android.httpclient.d.a parama)
  {
    this.b.a(paramr, parama);
  }
  
  public void a(r paramr, cz.msebera.android.httpclient.d.f paramf)
  {
    this.b.a(paramr, paramf);
  }
  
  public cz.msebera.android.httpclient.d.a b(r paramr)
  {
    return this.b.b(paramr);
  }
  
  public cz.msebera.android.httpclient.m.h b(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.c.a(paramb);
  }
  
  public void b()
  {
    if (this.e.compareAndSet(false, true)) {
      this.a.a("Connection manager is shutting down");
    }
    try
    {
      this.c.b();
      this.a.a("Connection manager shut down");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.a.a("I/O exception shutting down connection manager", localIOException);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void b(j paramj, cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Managed Connection");
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    try
    {
      h.a(paramj).a();
      return;
    }
    finally {}
  }
  
  public cz.msebera.android.httpclient.d.f c()
  {
    return this.b.a();
  }
  
  public void close()
  {
    b();
  }
  
  public int d()
  {
    return this.c.d();
  }
  
  public int e()
  {
    return this.c.e();
  }
  
  public cz.msebera.android.httpclient.m.h f()
  {
    return this.c.f();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      b();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public cz.msebera.android.httpclient.d.a g()
  {
    return this.b.b();
  }
  
  static class a
  {
    private final Map<r, cz.msebera.android.httpclient.d.f> a = new ConcurrentHashMap();
    private final Map<r, cz.msebera.android.httpclient.d.a> b = new ConcurrentHashMap();
    private volatile cz.msebera.android.httpclient.d.f c;
    private volatile cz.msebera.android.httpclient.d.a d;
    
    public cz.msebera.android.httpclient.d.f a()
    {
      return this.c;
    }
    
    public cz.msebera.android.httpclient.d.f a(r paramr)
    {
      return (cz.msebera.android.httpclient.d.f)this.a.get(paramr);
    }
    
    public void a(cz.msebera.android.httpclient.d.a parama)
    {
      this.d = parama;
    }
    
    public void a(cz.msebera.android.httpclient.d.f paramf)
    {
      this.c = paramf;
    }
    
    public void a(r paramr, cz.msebera.android.httpclient.d.a parama)
    {
      this.b.put(paramr, parama);
    }
    
    public void a(r paramr, cz.msebera.android.httpclient.d.f paramf)
    {
      this.a.put(paramr, paramf);
    }
    
    public cz.msebera.android.httpclient.d.a b()
    {
      return this.d;
    }
    
    public cz.msebera.android.httpclient.d.a b(r paramr)
    {
      return (cz.msebera.android.httpclient.d.a)this.b.get(paramr);
    }
  }
  
  static class b
    implements cz.msebera.android.httpclient.m.b<cz.msebera.android.httpclient.e.b.b, u>
  {
    private final ag.a a;
    private final p<cz.msebera.android.httpclient.e.b.b, u> b;
    
    b(ag.a parama, p<cz.msebera.android.httpclient.e.b.b, u> paramp)
    {
      if (parama != null)
      {
        this.a = parama;
        if (paramp == null) {
          break label34;
        }
      }
      for (;;)
      {
        this.b = paramp;
        return;
        parama = new ag.a();
        break;
        label34:
        paramp = ae.a;
      }
    }
    
    public u a(cz.msebera.android.httpclient.e.b.b paramb)
      throws IOException
    {
      Object localObject2 = null;
      if (paramb.e() != null) {
        localObject2 = this.a.b(paramb.e());
      }
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.a.b(paramb.a());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.a.b();
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = cz.msebera.android.httpclient.d.a.a;
      }
      return (u)this.b.a(paramb, (cz.msebera.android.httpclient.d.a)localObject1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */