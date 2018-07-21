package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
@ThreadSafe
public class d
  implements c
{
  public static final String b = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
  private static final AtomicLong c = new AtomicLong();
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final cz.msebera.android.httpclient.e.c.j d;
  private final e e;
  @GuardedBy("this")
  private v f;
  @GuardedBy("this")
  private ad g;
  @GuardedBy("this")
  private volatile boolean h;
  
  public d()
  {
    this(ai.a());
  }
  
  public d(cz.msebera.android.httpclient.e.c.j paramj)
  {
    a.a(paramj, "Scheme registry");
    this.d = paramj;
    this.e = a(paramj);
  }
  
  private void a(cz.msebera.android.httpclient.j paramj)
  {
    try
    {
      paramj.f();
      return;
    }
    catch (IOException paramj)
    {
      while (!this.a.a()) {}
      this.a.a("I/O exception shutting down connection", paramj);
    }
  }
  
  private void d()
  {
    if (!this.h) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection manager has been shut down");
      return;
    }
  }
  
  public cz.msebera.android.httpclient.e.c.j a()
  {
    return this.d;
  }
  
  protected e a(cz.msebera.android.httpclient.e.c.j paramj)
  {
    return new k(paramj);
  }
  
  public final cz.msebera.android.httpclient.e.f a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    return new d.1(this, paramb, paramObject);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    a.a(paramTimeUnit, "Time unit");
    try
    {
      d();
      long l = paramTimeUnit.toMillis(paramLong);
      paramLong = l;
      if (l < 0L) {
        paramLong = 0L;
      }
      l = System.currentTimeMillis();
      if ((this.f != null) && (this.f.m() <= l - paramLong))
      {
        this.f.f();
        this.f.a().c();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(t paramt, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 141
    //   4: ldc -113
    //   6: invokestatic 144	cz/msebera/android/httpclient/o/a:a	(ZLjava/lang/String;)V
    //   9: aload_1
    //   10: checkcast 141	cz/msebera/android/httpclient/i/c/ad
    //   13: astore 6
    //   15: aload 6
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 59	cz/msebera/android/httpclient/i/c/d:a	Lcz/msebera/android/httpclient/h/b;
    //   22: invokevirtual 83	cz/msebera/android/httpclient/h/b:a	()Z
    //   25: ifeq +29 -> 54
    //   28: aload_0
    //   29: getfield 59	cz/msebera/android/httpclient/i/c/d:a	Lcz/msebera/android/httpclient/h/b;
    //   32: new 146	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   39: ldc -107
    //   41: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 162	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   54: aload 6
    //   56: invokevirtual 166	cz/msebera/android/httpclient/i/c/ad:u	()Lcz/msebera/android/httpclient/i/c/v;
    //   59: ifnonnull +7 -> 66
    //   62: aload 6
    //   64: monitorexit
    //   65: return
    //   66: aload 6
    //   68: invokevirtual 170	cz/msebera/android/httpclient/i/c/ad:w	()Lcz/msebera/android/httpclient/e/c;
    //   71: aload_0
    //   72: if_acmpne +40 -> 112
    //   75: iconst_1
    //   76: istore 5
    //   78: iload 5
    //   80: ldc -84
    //   82: invokestatic 97	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 90	cz/msebera/android/httpclient/i/c/d:h	Z
    //   91: ifeq +27 -> 118
    //   94: aload_0
    //   95: aload 6
    //   97: invokespecial 174	cz/msebera/android/httpclient/i/c/d:a	(Lcz/msebera/android/httpclient/j;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: aload 6
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload 6
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: iconst_0
    //   113: istore 5
    //   115: goto -37 -> 78
    //   118: aload 6
    //   120: invokevirtual 176	cz/msebera/android/httpclient/i/c/ad:c	()Z
    //   123: ifeq +17 -> 140
    //   126: aload 6
    //   128: invokevirtual 179	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   131: ifne +9 -> 140
    //   134: aload_0
    //   135: aload 6
    //   137: invokespecial 174	cz/msebera/android/httpclient/i/c/d:a	(Lcz/msebera/android/httpclient/j;)V
    //   140: aload 6
    //   142: invokevirtual 179	cz/msebera/android/httpclient/i/c/ad:q	()Z
    //   145: ifeq +96 -> 241
    //   148: aload_0
    //   149: getfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   152: astore 7
    //   154: aload 4
    //   156: ifnull +117 -> 273
    //   159: aload 4
    //   161: astore_1
    //   162: aload 7
    //   164: lload_2
    //   165: aload_1
    //   166: invokevirtual 181	cz/msebera/android/httpclient/i/c/v:a	(JLjava/util/concurrent/TimeUnit;)V
    //   169: aload_0
    //   170: getfield 59	cz/msebera/android/httpclient/i/c/d:a	Lcz/msebera/android/httpclient/h/b;
    //   173: invokevirtual 83	cz/msebera/android/httpclient/h/b:a	()Z
    //   176: ifeq +65 -> 241
    //   179: lload_2
    //   180: lconst_0
    //   181: lcmp
    //   182: ifle +98 -> 280
    //   185: new 146	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   192: ldc -73
    //   194: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: lload_2
    //   198: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: ldc -68
    //   203: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 4
    //   208: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 59	cz/msebera/android/httpclient/i/c/d:a	Lcz/msebera/android/httpclient/h/b;
    //   219: new 146	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   226: ldc -66
    //   228: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 162	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   241: aload 6
    //   243: invokevirtual 193	cz/msebera/android/httpclient/i/c/ad:v	()Lcz/msebera/android/httpclient/i/c/v;
    //   246: pop
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 195	cz/msebera/android/httpclient/i/c/d:g	Lcz/msebera/android/httpclient/i/c/ad;
    //   252: aload_0
    //   253: getfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   256: invokevirtual 197	cz/msebera/android/httpclient/i/c/v:e	()Z
    //   259: ifeq +8 -> 267
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   267: aload_0
    //   268: monitorexit
    //   269: aload 6
    //   271: monitorexit
    //   272: return
    //   273: getstatic 201	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   276: astore_1
    //   277: goto -115 -> 162
    //   280: ldc -53
    //   282: astore_1
    //   283: goto -68 -> 215
    //   286: astore_1
    //   287: aload 6
    //   289: invokevirtual 193	cz/msebera/android/httpclient/i/c/ad:v	()Lcz/msebera/android/httpclient/i/c/v;
    //   292: pop
    //   293: aload_0
    //   294: aconst_null
    //   295: putfield 195	cz/msebera/android/httpclient/i/c/d:g	Lcz/msebera/android/httpclient/i/c/ad;
    //   298: aload_0
    //   299: getfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   302: invokevirtual 197	cz/msebera/android/httpclient/i/c/v:e	()Z
    //   305: ifeq +8 -> 313
    //   308: aload_0
    //   309: aconst_null
    //   310: putfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   313: aload_1
    //   314: athrow
    //   315: astore_1
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_1
    //   319: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	d
    //   0	320	1	paramt	t
    //   0	320	2	paramLong	long
    //   0	320	4	paramTimeUnit	TimeUnit
    //   76	38	5	bool	boolean
    //   13	275	6	localad	ad
    //   152	11	7	localv	v
    // Exception table:
    //   from	to	target	type
    //   18	54	106	finally
    //   54	65	106	finally
    //   66	75	106	finally
    //   78	87	106	finally
    //   102	105	106	finally
    //   107	110	106	finally
    //   269	272	106	finally
    //   318	320	106	finally
    //   118	140	286	finally
    //   140	154	286	finally
    //   162	179	286	finally
    //   185	215	286	finally
    //   215	241	286	finally
    //   273	277	286	finally
    //   87	102	315	finally
    //   241	267	315	finally
    //   267	269	315	finally
    //   287	313	315	finally
    //   313	315	315	finally
    //   316	318	315	finally
  }
  
  t b(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    a.a(paramb, "Route");
    for (;;)
    {
      try
      {
        d();
        if (this.a.a()) {
          this.a.a("Get connection for route " + paramb);
        }
        if (this.g == null)
        {
          bool = true;
          cz.msebera.android.httpclient.o.b.a(bool, "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
          if ((this.f != null) && (!this.f.b().equals(paramb)))
          {
            this.f.f();
            this.f = null;
          }
          if (this.f == null)
          {
            paramObject = Long.toString(c.getAndIncrement());
            w localw = this.e.a();
            this.f = new v(this.a, (String)paramObject, paramb, localw, 0L, TimeUnit.MILLISECONDS);
          }
          long l = System.currentTimeMillis();
          if (this.f.a(l))
          {
            this.f.f();
            this.f.a().c();
          }
          this.g = new ad(this, this.e, this.f);
          paramb = this.g;
          return paramb;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b()
  {
    try
    {
      d();
      long l = System.currentTimeMillis();
      if ((this.f != null) && (this.f.a(l)))
      {
        this.f.f();
        this.f.a().c();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 90	cz/msebera/android/httpclient/i/c/d:h	Z
    //   7: aload_0
    //   8: getfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   18: invokevirtual 131	cz/msebera/android/httpclient/i/c/v:f	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 195	cz/msebera/android/httpclient/i/c/d:g	Lcz/msebera/android/httpclient/i/c/ad;
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 125	cz/msebera/android/httpclient/i/c/d:f	Lcz/msebera/android/httpclient/i/c/v;
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 195	cz/msebera/android/httpclient/i/c/d:g	Lcz/msebera/android/httpclient/i/c/ad;
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	d
    //   34	12	1	localObject1	Object
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	finally
    //   2	7	47	finally
    //   21	33	47	finally
    //   35	47	47	finally
    //   48	50	47	finally
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */