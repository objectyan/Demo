package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.c.j;
import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.f;
import cz.msebera.android.httpclient.e.i;
import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.m.d;
import cz.msebera.android.httpclient.m.h;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
@ThreadSafe
public class af
  implements c, d<cz.msebera.android.httpclient.e.b.b>
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final j b;
  private final u c;
  private final e d;
  private final l e;
  
  public af()
  {
    this(ai.a());
  }
  
  public af(j paramj)
  {
    this(paramj, -1L, TimeUnit.MILLISECONDS);
  }
  
  public af(j paramj, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramj, paramLong, paramTimeUnit, new ak());
  }
  
  public af(j paramj, long paramLong, TimeUnit paramTimeUnit, l paraml)
  {
    a.a(paramj, "Scheme registry");
    a.a(paraml, "DNS resolver");
    this.b = paramj;
    this.e = paraml;
    this.d = a(paramj);
    this.c = new u(this.a, this.d, 2, 20, paramLong, paramTimeUnit);
  }
  
  public af(j paramj, l paraml)
  {
    this(paramj, -1L, TimeUnit.MILLISECONDS, paraml);
  }
  
  private String a(v paramv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id: ").append(paramv.g()).append("]");
    localStringBuilder.append("[route: ").append(paramv.h()).append("]");
    paramv = paramv.l();
    if (paramv != null) {
      localStringBuilder.append("[state: ").append(paramv).append("]");
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
    h localh = this.c.f();
    paramb = this.c.a(paramb);
    localStringBuilder.append("[total kept alive: ").append(localh.c()).append("; ");
    localStringBuilder.append("route allocated: ").append(paramb.a() + paramb.c());
    localStringBuilder.append(" of ").append(paramb.d()).append("; ");
    localStringBuilder.append("total allocated: ").append(localh.a() + localh.c());
    localStringBuilder.append(" of ").append(localh.d()).append("]");
    return localStringBuilder.toString();
  }
  
  public int a(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.c.b(paramb);
  }
  
  public j a()
  {
    return this.b;
  }
  
  protected e a(j paramj)
  {
    return new k(paramj, this.e);
  }
  
  public f a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    a.a(paramb, "HTTP route");
    if (this.a.a()) {
      this.a.a("Connection request: " + b(paramb, paramObject) + c(paramb));
    }
    return new af.1(this, this.c.b(paramb, paramObject));
  }
  
  t a(Future<v> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, i
  {
    try
    {
      paramTimeUnit = (v)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
        throw new InterruptedException();
      }
    }
    catch (ExecutionException paramTimeUnit)
    {
      Throwable localThrowable = paramTimeUnit.getCause();
      paramFuture = localThrowable;
      if (localThrowable == null) {
        paramFuture = paramTimeUnit;
      }
      this.a.b("Unexpected exception leasing connection from pool", paramFuture);
      throw new InterruptedException();
      if (paramTimeUnit.i() != null) {}
      for (boolean bool = true;; bool = false)
      {
        cz.msebera.android.httpclient.o.b.a(bool, "Pool entry with no connection");
        if (this.a.a()) {
          this.a.a("Connection leased: " + a(paramTimeUnit) + c((cz.msebera.android.httpclient.e.b.b)paramTimeUnit.h()));
        }
        paramFuture = new ad(this, this.d, paramTimeUnit);
        return paramFuture;
      }
    }
    catch (TimeoutException paramFuture)
    {
      throw new i("Timeout waiting for connection from pool");
    }
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
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, int paramInt)
  {
    this.c.a(paramb, paramInt);
  }
  
  /* Error */
  public void a(t paramt, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 230
    //   4: ldc_w 266
    //   7: invokestatic 267	cz/msebera/android/httpclient/o/a:a	(ZLjava/lang/String;)V
    //   10: aload_1
    //   11: checkcast 230	cz/msebera/android/httpclient/i/c/ad
    //   14: astore 6
    //   16: aload 6
    //   18: invokevirtual 271	cz/msebera/android/httpclient/i/c/ad:w	()Lcz/msebera/android/httpclient/e/c;
    //   21: aload_0
    //   22: if_acmpne +33 -> 55
    //   25: iconst_1
    //   26: istore 5
    //   28: iload 5
    //   30: ldc_w 273
    //   33: invokestatic 222	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   36: aload 6
    //   38: monitorenter
    //   39: aload 6
    //   41: invokevirtual 277	cz/msebera/android/httpclient/i/c/ad:v	()Lcz/msebera/android/httpclient/i/c/v;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnonnull +13 -> 61
    //   51: aload 6
    //   53: monitorexit
    //   54: return
    //   55: iconst_0
    //   56: istore 5
    //   58: goto -30 -> 28
    //   61: aload 6
    //   63: invokevirtual 279	cz/msebera/android/httpclient/i/c/ad:c	()Z
    //   66: ifeq +20 -> 86
    //   69: aload 6
    //   71: invokevirtual 282	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   74: istore 5
    //   76: iload 5
    //   78: ifne +8 -> 86
    //   81: aload 6
    //   83: invokevirtual 284	cz/msebera/android/httpclient/i/c/ad:f	()V
    //   86: aload 6
    //   88: invokevirtual 282	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   91: ifeq +107 -> 198
    //   94: aload 4
    //   96: ifnull +225 -> 321
    //   99: aload 4
    //   101: astore_1
    //   102: aload 7
    //   104: lload_2
    //   105: aload_1
    //   106: invokevirtual 285	cz/msebera/android/httpclient/i/c/v:a	(JLjava/util/concurrent/TimeUnit;)V
    //   109: aload_0
    //   110: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   113: invokevirtual 168	cz/msebera/android/httpclient/h/b:a	()Z
    //   116: ifeq +82 -> 198
    //   119: lload_2
    //   120: lconst_0
    //   121: lcmp
    //   122: ifle +206 -> 328
    //   125: new 91	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 287
    //   135: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: lload_2
    //   139: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: ldc -1
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 4
    //   149: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   160: new 91	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 289
    //   170: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: aload 7
    //   176: invokespecial 226	cz/msebera/android/httpclient/i/c/af:a	(Lcz/msebera/android/httpclient/i/c/v;)Ljava/lang/String;
    //   179: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 291
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 176	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   198: aload_0
    //   199: getfield 87	cz/msebera/android/httpclient/i/c/af:c	Lcz/msebera/android/httpclient/i/c/u;
    //   202: aload 7
    //   204: aload 6
    //   206: invokevirtual 282	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   209: invokevirtual 294	cz/msebera/android/httpclient/i/c/u:a	(Lcz/msebera/android/httpclient/m/e;Z)V
    //   212: aload_0
    //   213: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   216: invokevirtual 168	cz/msebera/android/httpclient/h/b:a	()Z
    //   219: ifeq +50 -> 269
    //   222: aload_0
    //   223: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   226: new 91	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 296
    //   236: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: aload 7
    //   242: invokespecial 226	cz/msebera/android/httpclient/i/c/af:a	(Lcz/msebera/android/httpclient/i/c/v;)Ljava/lang/String;
    //   245: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_0
    //   249: aload 7
    //   251: invokevirtual 112	cz/msebera/android/httpclient/i/c/v:h	()Ljava/lang/Object;
    //   254: checkcast 228	cz/msebera/android/httpclient/e/b/b
    //   257: invokespecial 174	cz/msebera/android/httpclient/i/c/af:c	(Lcz/msebera/android/httpclient/e/b/b;)Ljava/lang/String;
    //   260: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 176	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   269: aload 6
    //   271: monitorexit
    //   272: return
    //   273: astore_1
    //   274: aload 6
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   284: invokevirtual 168	cz/msebera/android/httpclient/h/b:a	()Z
    //   287: ifeq -201 -> 86
    //   290: aload_0
    //   291: getfield 62	cz/msebera/android/httpclient/i/c/af:a	Lcz/msebera/android/httpclient/h/b;
    //   294: ldc_w 298
    //   297: aload_1
    //   298: invokevirtual 300	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   301: goto -215 -> 86
    //   304: astore_1
    //   305: aload_0
    //   306: getfield 87	cz/msebera/android/httpclient/i/c/af:c	Lcz/msebera/android/httpclient/i/c/u;
    //   309: aload 7
    //   311: aload 6
    //   313: invokevirtual 282	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   316: invokevirtual 294	cz/msebera/android/httpclient/i/c/u:a	(Lcz/msebera/android/httpclient/m/e;Z)V
    //   319: aload_1
    //   320: athrow
    //   321: getstatic 40	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   324: astore_1
    //   325: goto -223 -> 102
    //   328: ldc_w 302
    //   331: astore_1
    //   332: goto -176 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	af
    //   0	335	1	paramt	t
    //   0	335	2	paramLong	long
    //   0	335	4	paramTimeUnit	TimeUnit
    //   26	51	5	bool	boolean
    //   14	298	6	localad	ad
    //   44	266	7	localv	v
    // Exception table:
    //   from	to	target	type
    //   39	46	273	finally
    //   51	54	273	finally
    //   198	269	273	finally
    //   269	272	273	finally
    //   274	277	273	finally
    //   305	321	273	finally
    //   81	86	279	java/io/IOException
    //   61	76	304	finally
    //   81	86	304	finally
    //   86	94	304	finally
    //   102	119	304	finally
    //   125	156	304	finally
    //   156	198	304	finally
    //   280	301	304	finally
    //   321	325	304	finally
  }
  
  public h b(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.c.a(paramb);
  }
  
  public void b()
  {
    this.a.a("Closing expired connections");
    this.c.c();
  }
  
  public void b(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void c()
  {
    this.a.a("Connection manager is shutting down");
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
  
  public int d()
  {
    return this.c.d();
  }
  
  public int e()
  {
    return this.c.e();
  }
  
  public h f()
  {
    return this.c.f();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      c();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */