package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class hc
  implements Closeable
{
  private static final ExecutorService l;
  public final gi a;
  final boolean b;
  long c = 0L;
  long d;
  public hm e = new hm();
  final hm f = new hm();
  final ho g;
  final Socket h;
  public final hb i;
  final c j;
  private final b m;
  private final Map<Integer, hd> n = new HashMap();
  private final String o;
  private int p;
  private int q;
  private boolean r;
  private long s = System.nanoTime();
  private final ExecutorService t;
  private Map<Integer, hk> u;
  private final hl v;
  private int w;
  private boolean x = false;
  private final Set<Integer> y = new LinkedHashSet();
  
  static
  {
    if (!hc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), gy.a("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private hc(a parama)
    throws IOException
  {
    this.a = parama.f;
    this.v = parama.g;
    this.b = parama.h;
    this.m = parama.e;
    int i1;
    if (parama.h)
    {
      i1 = 1;
      this.q = i1;
      if ((parama.h) && (this.a == gi.d)) {
        this.q += 2;
      }
      i1 = i2;
      if (parama.h) {
        i1 = 1;
      }
      this.w = i1;
      if (parama.h) {
        this.e.a(7, 0, 16777216);
      }
      this.o = parama.b;
      if (this.a != gi.d) {
        break label368;
      }
      this.g = new hh();
      this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), gy.a(String.format("OkHttp %s Push Observer", new Object[] { this.o }), true));
      this.f.a(7, 0, 65535);
      this.f.a(5, 0, 16384);
    }
    for (;;)
    {
      this.d = this.f.b();
      this.h = parama.a;
      this.i = this.g.a(parama.d, this.b);
      this.j = new c(this.g.a(parama.c, this.b), (byte)0);
      new Thread(this.j).start();
      return;
      i1 = 2;
      break;
      label368:
      if (this.a != gi.c) {
        break label397;
      }
      this.g = new hn();
      this.t = null;
    }
    label397:
    throw new AssertionError(this.a);
  }
  
  /* Error */
  private void a(gz paramgz1, gz paramgz2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 87	com/indooratlas/android/sdk/_internal/hc:k	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 258	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 245	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 259	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: getfield 219	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   25: astore 5
    //   27: aload 5
    //   29: monitorenter
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 261	com/indooratlas/android/sdk/_internal/hc:r	Z
    //   36: ifeq +160 -> 196
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 5
    //   43: monitorexit
    //   44: aconst_null
    //   45: astore_1
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 125	com/indooratlas/android/sdk/_internal/hc:n	Ljava/util/Map;
    //   52: invokeinterface 266 1 0
    //   57: ifne +337 -> 394
    //   60: aload_0
    //   61: getfield 125	com/indooratlas/android/sdk/_internal/hc:n	Ljava/util/Map;
    //   64: invokeinterface 270 1 0
    //   69: aload_0
    //   70: getfield 125	com/indooratlas/android/sdk/_internal/hc:n	Ljava/util/Map;
    //   73: invokeinterface 273 1 0
    //   78: anewarray 275	com/indooratlas/android/sdk/_internal/hd
    //   81: invokeinterface 281 2 0
    //   86: checkcast 283	[Lcom/indooratlas/android/sdk/_internal/hd;
    //   89: astore 6
    //   91: aload_0
    //   92: getfield 125	com/indooratlas/android/sdk/_internal/hc:n	Ljava/util/Map;
    //   95: invokeinterface 286 1 0
    //   100: aload_0
    //   101: iconst_0
    //   102: invokespecial 289	com/indooratlas/android/sdk/_internal/hc:a	(Z)V
    //   105: aload_0
    //   106: getfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   109: ifnull +279 -> 388
    //   112: aload_0
    //   113: getfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   116: invokeinterface 270 1 0
    //   121: aload_0
    //   122: getfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   125: invokeinterface 273 1 0
    //   130: anewarray 293	com/indooratlas/android/sdk/_internal/hk
    //   133: invokeinterface 281 2 0
    //   138: checkcast 295	[Lcom/indooratlas/android/sdk/_internal/hk;
    //   141: astore 7
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: astore 5
    //   153: aload 6
    //   155: ifnull +114 -> 269
    //   158: aload 6
    //   160: arraylength
    //   161: istore 4
    //   163: iconst_0
    //   164: istore_3
    //   165: iload_3
    //   166: iload 4
    //   168: if_icmpge +98 -> 266
    //   171: aload 6
    //   173: iload_3
    //   174: aaload
    //   175: astore 5
    //   177: aload 5
    //   179: aload_2
    //   180: invokevirtual 298	com/indooratlas/android/sdk/_internal/hd:a	(Lcom/indooratlas/android/sdk/_internal/gz;)V
    //   183: aload_1
    //   184: astore 5
    //   186: iload_3
    //   187: iconst_1
    //   188: iadd
    //   189: istore_3
    //   190: aload 5
    //   192: astore_1
    //   193: goto -28 -> 165
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield 261	com/indooratlas/android/sdk/_internal/hc:r	Z
    //   201: aload_0
    //   202: getfield 300	com/indooratlas/android/sdk/_internal/hc:p	I
    //   205: istore_3
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_0
    //   209: getfield 219	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   212: iload_3
    //   213: aload_1
    //   214: getstatic 303	com/indooratlas/android/sdk/_internal/gy:a	[B
    //   217: invokeinterface 308 4 0
    //   222: aload 5
    //   224: monitorexit
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -181 -> 46
    //   230: astore_1
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload 5
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: goto -196 -> 46
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    //   250: astore 8
    //   252: aload_1
    //   253: astore 5
    //   255: aload_1
    //   256: ifnull -70 -> 186
    //   259: aload 8
    //   261: astore 5
    //   263: goto -77 -> 186
    //   266: aload_1
    //   267: astore 5
    //   269: aload 7
    //   271: ifnull +75 -> 346
    //   274: aload 7
    //   276: arraylength
    //   277: istore 4
    //   279: iconst_0
    //   280: istore_3
    //   281: iload_3
    //   282: iload 4
    //   284: if_icmpge +62 -> 346
    //   287: aload 7
    //   289: iload_3
    //   290: aaload
    //   291: astore_1
    //   292: aload_1
    //   293: getfield 309	com/indooratlas/android/sdk/_internal/hk:c	J
    //   296: ldc2_w 310
    //   299: lcmp
    //   300: ifne +14 -> 314
    //   303: aload_1
    //   304: getfield 313	com/indooratlas/android/sdk/_internal/hk:b	J
    //   307: ldc2_w 310
    //   310: lcmp
    //   311: ifne +11 -> 322
    //   314: new 315	java/lang/IllegalStateException
    //   317: dup
    //   318: invokespecial 316	java/lang/IllegalStateException:<init>	()V
    //   321: athrow
    //   322: aload_1
    //   323: aload_1
    //   324: getfield 313	com/indooratlas/android/sdk/_internal/hk:b	J
    //   327: lconst_1
    //   328: lsub
    //   329: putfield 309	com/indooratlas/android/sdk/_internal/hk:c	J
    //   332: aload_1
    //   333: getfield 319	com/indooratlas/android/sdk/_internal/hk:a	Ljava/util/concurrent/CountDownLatch;
    //   336: invokevirtual 324	java/util/concurrent/CountDownLatch:countDown	()V
    //   339: iload_3
    //   340: iconst_1
    //   341: iadd
    //   342: istore_3
    //   343: goto -62 -> 281
    //   346: aload_0
    //   347: getfield 219	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   350: invokeinterface 327 1 0
    //   355: aload 5
    //   357: astore_1
    //   358: aload_0
    //   359: getfield 209	com/indooratlas/android/sdk/_internal/hc:h	Ljava/net/Socket;
    //   362: invokevirtual 330	java/net/Socket:close	()V
    //   365: aload_1
    //   366: ifnull +17 -> 383
    //   369: aload_1
    //   370: athrow
    //   371: astore_1
    //   372: aload 5
    //   374: ifnull -16 -> 358
    //   377: aload 5
    //   379: astore_1
    //   380: goto -22 -> 358
    //   383: return
    //   384: astore_1
    //   385: goto -20 -> 365
    //   388: aconst_null
    //   389: astore 7
    //   391: goto -243 -> 148
    //   394: aconst_null
    //   395: astore 6
    //   397: goto -292 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	hc
    //   0	400	1	paramgz1	gz
    //   0	400	2	paramgz2	gz
    //   164	179	3	i1	int
    //   161	124	4	i2	int
    //   25	353	5	localObject	Object
    //   89	307	6	arrayOfhd	hd[]
    //   141	249	7	arrayOfhk	hk[]
    //   250	10	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   32	41	230	finally
    //   196	208	230	finally
    //   231	233	230	finally
    //   30	32	235	finally
    //   41	44	235	finally
    //   208	225	235	finally
    //   233	235	235	finally
    //   236	239	235	finally
    //   21	30	241	java/io/IOException
    //   239	241	241	java/io/IOException
    //   48	105	245	finally
    //   105	148	245	finally
    //   148	150	245	finally
    //   246	248	245	finally
    //   177	183	250	java/io/IOException
    //   346	355	371	java/io/IOException
    //   358	365	384	java/io/IOException
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l1 = System.nanoTime();
        this.s = l1;
        return;
      }
      finally {}
      long l1 = Long.MAX_VALUE;
    }
  }
  
  /* Error */
  private hk c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 291	com/indooratlas/android/sdk/_internal/hc:u	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 439 2 0
    //   22: checkcast 293	com/indooratlas/android/sdk/_internal/hk
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	hc
    //   0	40	1	paramInt	int
    //   25	7	2	localhk	hk
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 142	com/indooratlas/android/sdk/_internal/hc:f	Lcom/indooratlas/android/sdk/_internal/hm;
    //   6: astore_2
    //   7: aload_2
    //   8: getfield 449	com/indooratlas/android/sdk/_internal/hm:a	I
    //   11: bipush 16
    //   13: iand
    //   14: ifeq +14 -> 28
    //   17: aload_2
    //   18: getfield 452	com/indooratlas/android/sdk/_internal/hm:d	[I
    //   21: iconst_4
    //   22: iaload
    //   23: istore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: ldc 90
    //   30: istore_1
    //   31: goto -7 -> 24
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	hc
    //   23	8	1	i1	int
    //   6	12	2	localhm	hm
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	34	finally
  }
  
  final hd a(int paramInt)
  {
    try
    {
      hd localhd = (hd)this.n.get(Integer.valueOf(paramInt));
      return localhd;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final hd a(List<he> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = false;
    if (!paramBoolean) {
      bool = true;
    }
    synchronized (this.i)
    {
      try
      {
        if (this.r) {
          throw new IOException("shutdown");
        }
      }
      finally {}
    }
    int i1 = this.q;
    this.q += 2;
    hd localhd = new hd(i1, this, bool, false, paramList);
    if (localhd.a())
    {
      this.n.put(Integer.valueOf(i1), localhd);
      a(false);
    }
    this.i.a(bool, i1, paramList);
    if (!paramBoolean) {
      this.i.b();
    }
    return localhd;
  }
  
  final void a(final int paramInt, final long paramLong)
  {
    l.execute(new gu("OkHttp Window Update %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) })
    {
      public final void b()
      {
        try
        {
          hc.this.i.a(paramInt, paramLong);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  final void a(final int paramInt, final gz paramgz)
  {
    l.submit(new gu("OkHttp %s stream %d", new Object[] { this.o, Integer.valueOf(paramInt) })
    {
      public final void b()
      {
        try
        {
          hc.this.b(paramInt, paramgz);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public final void a(int paramInt, boolean paramBoolean, in paramin, long paramLong)
    throws IOException
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.i.a(paramBoolean, paramInt, paramin, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.d), this.i.c());
        this.d -= i1;
        l1 -= i1;
        hb localhb = this.i;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label170;
        }
        bool = true;
        localhb.a(bool, paramInt, paramin, i1);
        if (l1 <= 0L) {
          break;
        }
        try
        {
          if (this.d > 0L) {
            continue;
          }
          if (!this.n.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramin)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  final hd b(int paramInt)
  {
    try
    {
      hd localhd = (hd)this.n.remove(Integer.valueOf(paramInt));
      if ((localhd != null) && (this.n.isEmpty())) {
        a(true);
      }
      notifyAll();
      return localhd;
    }
    finally {}
  }
  
  public final void b()
    throws IOException
  {
    this.i.b();
  }
  
  final void b(int paramInt, gz paramgz)
    throws IOException
  {
    this.i.a(paramInt, paramgz);
  }
  
  public final void close()
    throws IOException
  {
    a(gz.a, gz.l);
  }
  
  public static final class a
  {
    public Socket a;
    public String b;
    public ip c;
    public io d;
    hc.b e = hc.b.a;
    public gi f = gi.c;
    hl g = hl.a;
    boolean h = true;
    
    public a()
      throws IOException
    {}
  }
  
  public static abstract class b
  {
    public static final b a = new b()
    {
      public final void a(hd paramAnonymoushd)
        throws IOException
      {
        paramAnonymoushd.a(gz.k);
      }
    };
    
    public static void a() {}
    
    public abstract void a(hd paramhd)
      throws IOException;
  }
  
  final class c
    extends gu
    implements ha.a
  {
    final ha a;
    
    private c(ha paramha)
    {
      super(new Object[] { hc.a(hc.this) });
      this.a = paramha;
    }
    
    public final void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (hc.this)
        {
          hc localhc = hc.this;
          localhc.d += paramLong;
          hc.this.notifyAll();
          return;
        }
      }
      ??? = hc.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((hd)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public final void a(int paramInt, gz paramgz)
    {
      if (hc.a(hc.this, paramInt)) {
        hc.a(hc.this, paramInt, paramgz);
      }
      hd localhd;
      do
      {
        return;
        localhd = hc.this.b(paramInt);
      } while (localhd == null);
      localhd.c(paramgz);
    }
    
    public final void a(int paramInt, iq arg2)
    {
      ??? = ???.c;
      synchronized (hc.this)
      {
        hd[] arrayOfhd = (hd[])hc.e(hc.this).values().toArray(new hd[hc.e(hc.this).size()]);
        hc.i(hc.this);
        int j = arrayOfhd.length;
        int i = 0;
        if (i < j)
        {
          ??? = arrayOfhd[i];
          if ((???.c > paramInt) && (???.b()))
          {
            ???.c(gz.k);
            hc.this.b(???.c);
          }
          i += 1;
        }
      }
    }
    
    public final void a(int paramInt, List<he> paramList)
    {
      hc.a(hc.this, paramInt, paramList);
    }
    
    public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        hk localhk = hc.c(hc.this, paramInt1);
        if (localhk != null)
        {
          if ((localhk.c != -1L) || (localhk.b == -1L)) {
            throw new IllegalStateException();
          }
          localhk.c = System.nanoTime();
          localhk.a.countDown();
        }
        return;
      }
      hc.a(hc.this, paramInt1, paramInt2);
    }
    
    public final void a(boolean paramBoolean, int paramInt1, ip paramip, int paramInt2)
      throws IOException
    {
      if (hc.a(hc.this, paramInt1)) {
        hc.a(hc.this, paramInt1, paramip, paramInt2, paramBoolean);
      }
      hd localhd;
      do
      {
        return;
        localhd = hc.this.a(paramInt1);
        if (localhd == null)
        {
          hc.this.a(paramInt1, gz.c);
          paramip.f(paramInt2);
          return;
        }
        if ((!hd.j) && (Thread.holdsLock(localhd))) {
          throw new AssertionError();
        }
        localhd.f.a(paramip, paramInt2);
      } while (!paramBoolean);
      localhd.e();
    }
    
    public final void a(boolean paramBoolean, final hm paramhm)
    {
      for (;;)
      {
        int i;
        synchronized (hc.this)
        {
          int j = hc.this.f.b();
          if (paramBoolean)
          {
            localhm = hc.this.f;
            localhm.c = 0;
            localhm.b = 0;
            localhm.a = 0;
            Arrays.fill(localhm.d, 0);
          }
          hm localhm = hc.this.f;
          i = 0;
          if (i < 10)
          {
            if (!paramhm.a(i)) {
              break label387;
            }
            localhm.a(i, paramhm.b(i), paramhm.d[i]);
            break label387;
          }
          if (hc.this.a == gi.d) {
            hc.c().execute(new gu("OkHttp %s ACK Settings", new Object[] { hc.a(hc.this) })
            {
              public final void b()
              {
                try
                {
                  hc.this.i.a(paramhm);
                  return;
                }
                catch (IOException localIOException) {}
              }
            });
          }
          i = hc.this.f.b();
          if ((i == -1) || (i == j)) {
            break label379;
          }
          l = i - j;
          if (!hc.g(hc.this))
          {
            paramhm = hc.this;
            paramhm.d += l;
            if (l > 0L) {
              paramhm.notifyAll();
            }
            hc.h(hc.this);
          }
          if (hc.e(hc.this).isEmpty()) {
            break label374;
          }
          paramhm = (hd[])hc.e(hc.this).values().toArray(new hd[hc.e(hc.this).size()]);
          hc.c().execute(new gu("OkHttp %s settings", new Object[] { hc.a(hc.this) })
          {
            public final void b()
            {
              hc.f(hc.this);
              hc.b.a();
            }
          });
          if ((paramhm == null) || (l == 0L)) {
            break label373;
          }
          j = paramhm.length;
          i = 0;
          if (i >= j) {
            break label373;
          }
        }
        synchronized (paramhm[i])
        {
          ???.a(l);
          i += 1;
          continue;
          paramhm = finally;
          throw paramhm;
        }
        label373:
        return;
        label374:
        paramhm = null;
        continue;
        label379:
        paramhm = null;
        long l = 0L;
        continue;
        label387:
        i += 1;
      }
    }
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, final List<he> paramList, hf paramhf)
    {
      int j = 0;
      int k = 0;
      int i = 0;
      boolean bool = true;
      if (hc.a(hc.this, paramInt))
      {
        hc.a(hc.this, paramInt, paramList, paramBoolean2);
        return;
      }
      synchronized (hc.this)
      {
        if (hc.b(hc.this)) {
          return;
        }
      }
      hd localhd = hc.this.a(paramInt);
      if (localhd == null) {
        if ((paramhf == hf.b) || (paramhf == hf.c)) {
          break label506;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          hc.this.a(paramInt, gz.c);
          return;
        }
        if (paramInt <= hc.c(hc.this)) {
          return;
        }
        if (paramInt % 2 == hc.d(hc.this) % 2) {
          return;
        }
        paramList = new hd(paramInt, hc.this, paramBoolean1, paramBoolean2, paramList);
        hc.b(hc.this, paramInt);
        hc.e(hc.this).put(Integer.valueOf(paramInt), paramList);
        hc.c().execute(new gu("OkHttp %s stream %d", new Object[] { hc.a(hc.this), Integer.valueOf(paramInt) })
        {
          public final void b()
          {
            try
            {
              hc.f(hc.this).a(paramList);
              return;
            }
            catch (IOException localIOException1)
            {
              gs.a.log(Level.INFO, "FramedConnection.Listener failure for " + hc.a(hc.this), localIOException1);
              try
              {
                paramList.a(gz.b);
                return;
              }
              catch (IOException localIOException2) {}
            }
          }
        });
        return;
        if (paramhf == hf.a) {}
        for (i = 1; i != 0; i = 0)
        {
          localhd.b(gz.b);
          hc.this.b(paramInt);
          return;
        }
        if ((!hd.j) && (Thread.holdsLock(localhd))) {
          throw new AssertionError();
        }
        ??? = null;
        for (;;)
        {
          try
          {
            if (localhd.e == null)
            {
              paramInt = j;
              if (paramhf == hf.c) {
                paramInt = 1;
              }
              if (paramInt != 0)
              {
                paramList = gz.b;
                paramBoolean1 = bool;
                if (paramList == null) {
                  break label485;
                }
                localhd.b(paramList);
                if (!paramBoolean2) {
                  break;
                }
                localhd.e();
                return;
              }
              localhd.e = paramList;
              paramBoolean1 = localhd.a();
              localhd.notifyAll();
              paramList = ???;
              continue;
            }
            paramInt = k;
          }
          finally {}
          if (paramhf == hf.b) {
            paramInt = 1;
          }
          if (paramInt != 0)
          {
            paramList = gz.e;
            paramBoolean1 = bool;
          }
          else
          {
            paramhf = new ArrayList();
            paramhf.addAll(localhd.e);
            paramhf.addAll(paramList);
            localhd.e = paramhf;
            paramBoolean1 = bool;
            paramList = ???;
            continue;
            label485:
            if (!paramBoolean1) {
              localhd.d.b(localhd.c);
            }
          }
        }
        label506:
        i = 1;
      }
    }
    
    /* Error */
    protected final void b()
    {
      // Byte code:
      //   0: getstatic 322	com/indooratlas/android/sdk/_internal/gz:g	Lcom/indooratlas/android/sdk/_internal/gz;
      //   3: astore_3
      //   4: getstatic 322	com/indooratlas/android/sdk/_internal/gz:g	Lcom/indooratlas/android/sdk/_internal/gz;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 22	com/indooratlas/android/sdk/_internal/hc$c:c	Lcom/indooratlas/android/sdk/_internal/hc;
      //   17: getfield 324	com/indooratlas/android/sdk/_internal/hc:b	Z
      //   20: ifne +16 -> 36
      //   23: aload_3
      //   24: astore_2
      //   25: aload_3
      //   26: astore_1
      //   27: aload_0
      //   28: getfield 34	com/indooratlas/android/sdk/_internal/hc$c:a	Lcom/indooratlas/android/sdk/_internal/ha;
      //   31: invokeinterface 328 1 0
      //   36: aload_3
      //   37: astore_2
      //   38: aload_3
      //   39: astore_1
      //   40: aload_0
      //   41: getfield 34	com/indooratlas/android/sdk/_internal/hc$c:a	Lcom/indooratlas/android/sdk/_internal/ha;
      //   44: aload_0
      //   45: invokeinterface 331 2 0
      //   50: ifne -14 -> 36
      //   53: aload_3
      //   54: astore_2
      //   55: aload_3
      //   56: astore_1
      //   57: getstatic 333	com/indooratlas/android/sdk/_internal/gz:a	Lcom/indooratlas/android/sdk/_internal/gz;
      //   60: astore_3
      //   61: aload_3
      //   62: astore_2
      //   63: aload_3
      //   64: astore_1
      //   65: getstatic 336	com/indooratlas/android/sdk/_internal/gz:l	Lcom/indooratlas/android/sdk/_internal/gz;
      //   68: astore 5
      //   70: aload_0
      //   71: getfield 22	com/indooratlas/android/sdk/_internal/hc$c:c	Lcom/indooratlas/android/sdk/_internal/hc;
      //   74: aload_3
      //   75: aload 5
      //   77: invokestatic 339	com/indooratlas/android/sdk/_internal/hc:a	(Lcom/indooratlas/android/sdk/_internal/hc;Lcom/indooratlas/android/sdk/_internal/gz;Lcom/indooratlas/android/sdk/_internal/gz;)V
      //   80: aload_0
      //   81: getfield 34	com/indooratlas/android/sdk/_internal/hc$c:a	Lcom/indooratlas/android/sdk/_internal/ha;
      //   84: invokestatic 344	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
      //   87: return
      //   88: astore_1
      //   89: aload_2
      //   90: astore_1
      //   91: getstatic 299	com/indooratlas/android/sdk/_internal/gz:b	Lcom/indooratlas/android/sdk/_internal/gz;
      //   94: astore_3
      //   95: getstatic 299	com/indooratlas/android/sdk/_internal/gz:b	Lcom/indooratlas/android/sdk/_internal/gz;
      //   98: astore_1
      //   99: aload_0
      //   100: getfield 22	com/indooratlas/android/sdk/_internal/hc$c:c	Lcom/indooratlas/android/sdk/_internal/hc;
      //   103: aload_3
      //   104: aload_1
      //   105: invokestatic 339	com/indooratlas/android/sdk/_internal/hc:a	(Lcom/indooratlas/android/sdk/_internal/hc;Lcom/indooratlas/android/sdk/_internal/gz;Lcom/indooratlas/android/sdk/_internal/gz;)V
      //   108: aload_0
      //   109: getfield 34	com/indooratlas/android/sdk/_internal/hc$c:a	Lcom/indooratlas/android/sdk/_internal/ha;
      //   112: invokestatic 344	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
      //   115: return
      //   116: astore_2
      //   117: aload_1
      //   118: astore_3
      //   119: aload_2
      //   120: astore_1
      //   121: aload_0
      //   122: getfield 22	com/indooratlas/android/sdk/_internal/hc$c:c	Lcom/indooratlas/android/sdk/_internal/hc;
      //   125: aload_3
      //   126: aload 4
      //   128: invokestatic 339	com/indooratlas/android/sdk/_internal/hc:a	(Lcom/indooratlas/android/sdk/_internal/hc;Lcom/indooratlas/android/sdk/_internal/gz;Lcom/indooratlas/android/sdk/_internal/gz;)V
      //   131: aload_0
      //   132: getfield 34	com/indooratlas/android/sdk/_internal/hc$c:a	Lcom/indooratlas/android/sdk/_internal/ha;
      //   135: invokestatic 344	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_2
      //   141: goto -10 -> 131
      //   144: astore_1
      //   145: goto -24 -> 121
      //   148: astore_1
      //   149: goto -41 -> 108
      //   152: astore_1
      //   153: goto -73 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	c
      //   12	53	1	localObject1	Object
      //   88	1	1	localIOException1	IOException
      //   90	49	1	localObject2	Object
      //   144	1	1	localObject3	Object
      //   148	1	1	localIOException2	IOException
      //   152	1	1	localIOException3	IOException
      //   10	80	2	localObject4	Object
      //   116	4	2	localObject5	Object
      //   140	1	2	localIOException4	IOException
      //   3	123	3	localObject6	Object
      //   7	120	4	localgz1	gz
      //   68	8	5	localgz2	gz
      // Exception table:
      //   from	to	target	type
      //   13	23	88	java/io/IOException
      //   27	36	88	java/io/IOException
      //   40	53	88	java/io/IOException
      //   57	61	88	java/io/IOException
      //   65	70	88	java/io/IOException
      //   13	23	116	finally
      //   27	36	116	finally
      //   40	53	116	finally
      //   57	61	116	finally
      //   65	70	116	finally
      //   91	95	116	finally
      //   121	131	140	java/io/IOException
      //   95	99	144	finally
      //   99	108	148	java/io/IOException
      //   70	80	152	java/io/IOException
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */