package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.e.w;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Deprecated
public class e
  extends a
{
  public cz.msebera.android.httpclient.h.b i = new cz.msebera.android.httpclient.h.b(getClass());
  protected final cz.msebera.android.httpclient.e.e j;
  protected final cz.msebera.android.httpclient.e.a.f k;
  protected final Set<b> l;
  protected final Queue<b> m;
  protected final Queue<i> n;
  protected final Map<cz.msebera.android.httpclient.e.b.b, g> o;
  protected volatile boolean p;
  protected volatile int q;
  protected volatile int r;
  private final Lock s;
  private final long t;
  private final TimeUnit u;
  
  public e(cz.msebera.android.httpclient.e.e parame, cz.msebera.android.httpclient.e.a.f paramf, int paramInt)
  {
    this(parame, paramf, paramInt, -1L, TimeUnit.MILLISECONDS);
  }
  
  public e(cz.msebera.android.httpclient.e.e parame, cz.msebera.android.httpclient.e.a.f paramf, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    cz.msebera.android.httpclient.o.a.a(parame, "Connection operator");
    cz.msebera.android.httpclient.o.a.a(paramf, "Connections per route");
    this.s = this.b;
    this.l = this.c;
    this.j = parame;
    this.k = paramf;
    this.q = paramInt;
    this.m = f();
    this.n = g();
    this.o = h();
    this.t = paramLong;
    this.u = paramTimeUnit;
  }
  
  @Deprecated
  public e(cz.msebera.android.httpclient.e.e parame, cz.msebera.android.httpclient.l.j paramj)
  {
    this(parame, cz.msebera.android.httpclient.e.a.e.b(paramj), cz.msebera.android.httpclient.e.a.e.c(paramj));
  }
  
  private void b(b paramb)
  {
    paramb = paramb.c();
    if (paramb != null) {}
    try
    {
      paramb.close();
      return;
    }
    catch (IOException paramb)
    {
      this.i.a("I/O error closing connection", paramb);
    }
  }
  
  /* Error */
  protected b a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject, long paramLong, TimeUnit paramTimeUnit, j paramj)
    throws cz.msebera.android.httpclient.e.i, java.lang.InterruptedException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: lload_3
    //   4: lconst_0
    //   5: lcmp
    //   6: ifle +22 -> 28
    //   9: new 147	java/util/Date
    //   12: dup
    //   13: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   16: aload 5
    //   18: lload_3
    //   19: invokevirtual 157	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   22: ladd
    //   23: invokespecial 160	java/util/Date:<init>	(J)V
    //   26: astore 10
    //   28: aconst_null
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 165 1 0
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual 168	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/e/b/b;Z)Lcz/msebera/android/httpclient/i/c/a/g;
    //   46: astore 12
    //   48: aconst_null
    //   49: astore 11
    //   51: aload 5
    //   53: astore 9
    //   55: aload 5
    //   57: ifnonnull +128 -> 185
    //   60: aload_0
    //   61: getfield 170	cz/msebera/android/httpclient/i/c/a/e:p	Z
    //   64: ifne +133 -> 197
    //   67: iconst_1
    //   68: istore 8
    //   70: iload 8
    //   72: ldc -84
    //   74: invokestatic 177	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   81: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   84: ifeq +87 -> 171
    //   87: aload_0
    //   88: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   91: new 182	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   98: ldc -71
    //   100: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: ldc -62
    //   109: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 94	cz/msebera/android/httpclient/i/c/a/e:m	Ljava/util/Queue;
    //   116: invokeinterface 200 1 0
    //   121: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc -51
    //   126: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 82	cz/msebera/android/httpclient/i/c/a/e:l	Ljava/util/Set;
    //   133: invokeinterface 208 1 0
    //   138: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: ldc -46
    //   143: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 212	cz/msebera/android/httpclient/i/c/a/e:r	I
    //   150: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc -42
    //   155: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 88	cz/msebera/android/httpclient/i/c/a/e:q	I
    //   162: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   171: aload_0
    //   172: aload 12
    //   174: aload_2
    //   175: invokevirtual 223	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/i/c/a/g;Ljava/lang/Object;)Lcz/msebera/android/httpclient/i/c/a/b;
    //   178: astore 9
    //   180: aload 9
    //   182: ifnull +21 -> 203
    //   185: aload_0
    //   186: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   189: invokeinterface 226 1 0
    //   194: aload 9
    //   196: areturn
    //   197: iconst_0
    //   198: istore 8
    //   200: goto -130 -> 70
    //   203: aload 12
    //   205: invokevirtual 231	cz/msebera/android/httpclient/i/c/a/g:d	()I
    //   208: ifle +378 -> 586
    //   211: iconst_1
    //   212: istore 7
    //   214: aload_0
    //   215: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   218: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   221: ifeq +69 -> 290
    //   224: aload_0
    //   225: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   228: new 182	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   235: ldc -23
    //   237: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 12
    //   242: invokevirtual 231	cz/msebera/android/httpclient/i/c/a/g:d	()I
    //   245: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc -42
    //   250: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 12
    //   255: invokevirtual 235	cz/msebera/android/httpclient/i/c/a/g:b	()I
    //   258: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc -19
    //   263: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc -17
    //   272: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: ldc -15
    //   281: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   290: iload 7
    //   292: ifeq +29 -> 321
    //   295: aload_0
    //   296: getfield 212	cz/msebera/android/httpclient/i/c/a/e:r	I
    //   299: aload_0
    //   300: getfield 88	cz/msebera/android/httpclient/i/c/a/e:q	I
    //   303: if_icmpge +18 -> 321
    //   306: aload_0
    //   307: aload 12
    //   309: aload_0
    //   310: getfield 84	cz/msebera/android/httpclient/i/c/a/e:j	Lcz/msebera/android/httpclient/e/e;
    //   313: invokevirtual 244	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/i/c/a/g;Lcz/msebera/android/httpclient/e/e;)Lcz/msebera/android/httpclient/i/c/a/b;
    //   316: astore 5
    //   318: goto -267 -> 51
    //   321: iload 7
    //   323: ifeq +42 -> 365
    //   326: aload_0
    //   327: getfield 94	cz/msebera/android/httpclient/i/c/a/e:m	Ljava/util/Queue;
    //   330: invokeinterface 247 1 0
    //   335: ifne +30 -> 365
    //   338: aload_0
    //   339: invokevirtual 249	cz/msebera/android/httpclient/i/c/a/e:j	()V
    //   342: aload_0
    //   343: aload_1
    //   344: iconst_1
    //   345: invokevirtual 168	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/e/b/b;Z)Lcz/msebera/android/httpclient/i/c/a/g;
    //   348: astore 12
    //   350: aload_0
    //   351: aload 12
    //   353: aload_0
    //   354: getfield 84	cz/msebera/android/httpclient/i/c/a/e:j	Lcz/msebera/android/httpclient/e/e;
    //   357: invokevirtual 244	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/i/c/a/g;Lcz/msebera/android/httpclient/e/e;)Lcz/msebera/android/httpclient/i/c/a/b;
    //   360: astore 5
    //   362: goto -311 -> 51
    //   365: aload_0
    //   366: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   369: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   372: ifeq +43 -> 415
    //   375: aload_0
    //   376: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   379: new 182	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   386: ldc -5
    //   388: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   395: ldc -17
    //   397: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: ldc -15
    //   406: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   415: aload 11
    //   417: astore 13
    //   419: aload 11
    //   421: ifnonnull +27 -> 448
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   429: invokeinterface 255 1 0
    //   434: aload 12
    //   436: invokevirtual 258	cz/msebera/android/httpclient/i/c/a/e:a	(Ljava/util/concurrent/locks/Condition;Lcz/msebera/android/httpclient/i/c/a/g;)Lcz/msebera/android/httpclient/i/c/a/i;
    //   439: astore 13
    //   441: aload 6
    //   443: aload 13
    //   445: invokevirtual 263	cz/msebera/android/httpclient/i/c/a/j:a	(Lcz/msebera/android/httpclient/i/c/a/i;)V
    //   448: aload 12
    //   450: aload 13
    //   452: invokevirtual 264	cz/msebera/android/httpclient/i/c/a/g:a	(Lcz/msebera/android/httpclient/i/c/a/i;)V
    //   455: aload_0
    //   456: getfield 99	cz/msebera/android/httpclient/i/c/a/e:n	Ljava/util/Queue;
    //   459: aload 13
    //   461: invokeinterface 268 2 0
    //   466: pop
    //   467: aload 13
    //   469: aload 10
    //   471: invokevirtual 273	cz/msebera/android/httpclient/i/c/a/i:a	(Ljava/util/Date;)Z
    //   474: istore 8
    //   476: aload 12
    //   478: aload 13
    //   480: invokevirtual 275	cz/msebera/android/httpclient/i/c/a/g:b	(Lcz/msebera/android/httpclient/i/c/a/i;)V
    //   483: aload_0
    //   484: getfield 99	cz/msebera/android/httpclient/i/c/a/e:n	Ljava/util/Queue;
    //   487: aload 13
    //   489: invokeinterface 278 2 0
    //   494: pop
    //   495: aload 9
    //   497: astore 5
    //   499: aload 13
    //   501: astore 11
    //   503: iload 8
    //   505: ifne -454 -> 51
    //   508: aload 9
    //   510: astore 5
    //   512: aload 13
    //   514: astore 11
    //   516: aload 10
    //   518: ifnull -467 -> 51
    //   521: aload 9
    //   523: astore 5
    //   525: aload 13
    //   527: astore 11
    //   529: aload 10
    //   531: invokevirtual 281	java/util/Date:getTime	()J
    //   534: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   537: lcmp
    //   538: ifgt -487 -> 51
    //   541: new 143	cz/msebera/android/httpclient/e/i
    //   544: dup
    //   545: ldc_w 283
    //   548: invokespecial 286	cz/msebera/android/httpclient/e/i:<init>	(Ljava/lang/String;)V
    //   551: athrow
    //   552: astore_1
    //   553: aload_0
    //   554: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   557: invokeinterface 226 1 0
    //   562: aload_1
    //   563: athrow
    //   564: astore_1
    //   565: aload 12
    //   567: aload 13
    //   569: invokevirtual 275	cz/msebera/android/httpclient/i/c/a/g:b	(Lcz/msebera/android/httpclient/i/c/a/i;)V
    //   572: aload_0
    //   573: getfield 99	cz/msebera/android/httpclient/i/c/a/e:n	Ljava/util/Queue;
    //   576: aload 13
    //   578: invokeinterface 278 2 0
    //   583: pop
    //   584: aload_1
    //   585: athrow
    //   586: iconst_0
    //   587: istore 7
    //   589: goto -375 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	e
    //   0	592	1	paramb	cz.msebera.android.httpclient.e.b.b
    //   0	592	2	paramObject	Object
    //   0	592	3	paramLong	long
    //   0	592	5	paramTimeUnit	TimeUnit
    //   0	592	6	paramj	j
    //   212	376	7	i1	int
    //   68	436	8	bool	boolean
    //   53	469	9	localObject1	Object
    //   1	529	10	localDate	Date
    //   49	479	11	localObject2	Object
    //   46	520	12	localg	g
    //   417	160	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	552	finally
    //   60	67	552	finally
    //   70	171	552	finally
    //   171	180	552	finally
    //   203	211	552	finally
    //   214	290	552	finally
    //   295	318	552	finally
    //   326	362	552	finally
    //   365	415	552	finally
    //   424	448	552	finally
    //   476	495	552	finally
    //   529	552	552	finally
    //   565	586	552	finally
    //   448	476	564	finally
  }
  
  protected b a(g paramg, cz.msebera.android.httpclient.e.e parame)
  {
    if (this.i.a()) {
      this.i.a("Creating new connection [" + paramg.a() + "]");
    }
    parame = new b(parame, paramg.a(), this.t, this.u);
    this.s.lock();
    try
    {
      paramg.b(parame);
      this.r += 1;
      this.l.add(parame);
      return parame;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  protected b a(g paramg, Object paramObject)
  {
    Object localObject = null;
    this.s.lock();
    int i1 = 0;
    while (i1 == 0)
    {
      b localb;
      try
      {
        localb = paramg.a(paramObject);
        if (localb == null) {
          break label221;
        }
        if (this.i.a()) {
          this.i.a("Getting free connection [" + paramg.a() + "][" + paramObject + "]");
        }
        this.m.remove(localb);
        if (localb.a(System.currentTimeMillis()))
        {
          if (this.i.a()) {
            this.i.a("Closing expired free connection [" + paramg.a() + "][" + paramObject + "]");
          }
          b(localb);
          paramg.f();
          this.r -= 1;
          localObject = localb;
          continue;
        }
      }
      finally
      {
        this.s.unlock();
      }
      this.l.add(localb);
      i1 = 1;
      localObject = localb;
      continue;
      label221:
      int i2 = 1;
      i1 = i2;
      localObject = localb;
      if (this.i.a())
      {
        this.i.a("No free connections [" + paramg.a() + "][" + paramObject + "]");
        i1 = i2;
        localObject = localb;
      }
    }
    this.s.unlock();
    return (b)localObject;
  }
  
  public f a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    return new e.1(this, new j(), paramb, paramObject);
  }
  
  protected g a(cz.msebera.android.httpclient.e.b.b paramb, boolean paramBoolean)
  {
    this.s.lock();
    try
    {
      g localg2 = (g)this.o.get(paramb);
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = localg2;
        if (paramBoolean)
        {
          localg1 = b(paramb);
          this.o.put(paramb, localg1);
        }
      }
      return localg1;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  protected i a(Condition paramCondition, g paramg)
  {
    return new i(paramCondition, paramg);
  }
  
  public void a(int paramInt)
  {
    this.s.lock();
    try
    {
      this.q = paramInt;
      return;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = 0L;
    cz.msebera.android.httpclient.o.a.a(paramTimeUnit, "Time unit");
    if (paramLong > 0L) {
      l1 = paramLong;
    }
    if (this.i.a()) {
      this.i.a("Closing connections idle longer than " + l1 + " " + paramTimeUnit);
    }
    paramLong = System.currentTimeMillis();
    l1 = paramTimeUnit.toMillis(l1);
    this.s.lock();
    try
    {
      paramTimeUnit = this.m.iterator();
      while (paramTimeUnit.hasNext())
      {
        b localb = (b)paramTimeUnit.next();
        if (localb.g() <= paramLong - l1)
        {
          if (this.i.a()) {
            this.i.a("Closing connection last used @ " + new Date(localb.g()));
          }
          paramTimeUnit.remove();
          a(localb);
        }
      }
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  protected void a(cz.msebera.android.httpclient.e.b.b paramb)
  {
    this.s.lock();
    try
    {
      g localg = a(paramb, true);
      localg.f();
      if (localg.c()) {
        this.o.remove(paramb);
      }
      this.r -= 1;
      a(localg);
      return;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  protected void a(b paramb)
  {
    cz.msebera.android.httpclient.e.b.b localb = paramb.d();
    if (this.i.a()) {
      this.i.a("Deleting connection [" + localb + "][" + paramb.a() + "]");
    }
    this.s.lock();
    try
    {
      b(paramb);
      g localg = a(localb, true);
      localg.c(paramb);
      this.r -= 1;
      if (localg.c()) {
        this.o.remove(localb);
      }
      return;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  /* Error */
  public void a(b paramb, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 378	cz/msebera/android/httpclient/i/c/a/b:d	()Lcz/msebera/android/httpclient/e/b/b;
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   10: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   13: ifeq +48 -> 61
    //   16: aload_0
    //   17: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   20: new 182	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 388
    //   30: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 7
    //   35: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc -17
    //   40: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 382	cz/msebera/android/httpclient/i/c/a/b:a	()Ljava/lang/Object;
    //   47: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: ldc -15
    //   52: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 165 1 0
    //   70: aload_0
    //   71: getfield 170	cz/msebera/android/httpclient/i/c/a/e:p	Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 309	cz/msebera/android/httpclient/i/c/a/e:b	(Lcz/msebera/android/httpclient/i/c/a/b;)V
    //   82: aload_0
    //   83: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   86: invokeinterface 226 1 0
    //   91: return
    //   92: aload_0
    //   93: getfield 82	cz/msebera/android/httpclient/i/c/a/e:l	Ljava/util/Set;
    //   96: aload_1
    //   97: invokeinterface 389 2 0
    //   102: pop
    //   103: aload_0
    //   104: aload 7
    //   106: iconst_1
    //   107: invokevirtual 168	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/e/b/b;Z)Lcz/msebera/android/httpclient/i/c/a/g;
    //   110: astore 8
    //   112: iload_2
    //   113: ifeq +159 -> 272
    //   116: aload 8
    //   118: invokevirtual 231	cz/msebera/android/httpclient/i/c/a/g:d	()I
    //   121: iflt +151 -> 272
    //   124: aload_0
    //   125: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   128: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   131: ifeq +93 -> 224
    //   134: lload_3
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +127 -> 264
    //   140: new 182	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 391
    //   150: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload_3
    //   154: invokevirtual 345	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: ldc_w 347
    //   160: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 6
    //   173: aload_0
    //   174: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   177: new 182	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 393
    //   187: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 7
    //   192: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: ldc -17
    //   197: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 382	cz/msebera/android/httpclient/i/c/a/b:a	()Ljava/lang/Object;
    //   204: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: ldc_w 395
    //   210: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 6
    //   215: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   224: aload 8
    //   226: aload_1
    //   227: invokevirtual 396	cz/msebera/android/httpclient/i/c/a/g:a	(Lcz/msebera/android/httpclient/i/c/a/b;)V
    //   230: aload_1
    //   231: lload_3
    //   232: aload 5
    //   234: invokevirtual 398	cz/msebera/android/httpclient/i/c/a/b:a	(JLjava/util/concurrent/TimeUnit;)V
    //   237: aload_0
    //   238: getfield 94	cz/msebera/android/httpclient/i/c/a/e:m	Ljava/util/Queue;
    //   241: aload_1
    //   242: invokeinterface 268 2 0
    //   247: pop
    //   248: aload_0
    //   249: aload 8
    //   251: invokevirtual 376	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/i/c/a/g;)V
    //   254: aload_0
    //   255: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   258: invokeinterface 226 1 0
    //   263: return
    //   264: ldc_w 400
    //   267: astore 6
    //   269: goto -96 -> 173
    //   272: aload_0
    //   273: aload_1
    //   274: invokespecial 309	cz/msebera/android/httpclient/i/c/a/e:b	(Lcz/msebera/android/httpclient/i/c/a/b;)V
    //   277: aload 8
    //   279: invokevirtual 311	cz/msebera/android/httpclient/i/c/a/g:f	()V
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 212	cz/msebera/android/httpclient/i/c/a/e:r	I
    //   287: iconst_1
    //   288: isub
    //   289: putfield 212	cz/msebera/android/httpclient/i/c/a/e:r	I
    //   292: goto -44 -> 248
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   300: invokeinterface 226 1 0
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	e
    //   0	307	1	paramb	b
    //   0	307	2	paramBoolean	boolean
    //   0	307	3	paramLong	long
    //   0	307	5	paramTimeUnit	TimeUnit
    //   171	97	6	str	String
    //   4	187	7	localb	cz.msebera.android.httpclient.e.b.b
    //   110	168	8	localg	g
    // Exception table:
    //   from	to	target	type
    //   70	82	295	finally
    //   92	112	295	finally
    //   116	134	295	finally
    //   140	173	295	finally
    //   173	224	295	finally
    //   224	248	295	finally
    //   248	254	295	finally
    //   272	292	295	finally
  }
  
  /* Error */
  protected void a(g paramg)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 165 1 0
    //   11: aload_1
    //   12: ifnull +78 -> 90
    //   15: aload_1
    //   16: invokevirtual 402	cz/msebera/android/httpclient/i/c/a/g:g	()Z
    //   19: ifeq +71 -> 90
    //   22: aload_0
    //   23: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   26: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   29: ifeq +38 -> 67
    //   32: aload_0
    //   33: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   36: new 182	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 404
    //   46: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 292	cz/msebera/android/httpclient/i/c/a/g:a	()Lcz/msebera/android/httpclient/e/b/b;
    //   53: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: ldc -15
    //   58: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   67: aload_1
    //   68: invokevirtual 407	cz/msebera/android/httpclient/i/c/a/g:h	()Lcz/msebera/android/httpclient/i/c/a/i;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 409	cz/msebera/android/httpclient/i/c/a/i:d	()V
    //   80: aload_0
    //   81: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 226 1 0
    //   89: return
    //   90: aload_0
    //   91: getfield 99	cz/msebera/android/httpclient/i/c/a/e:n	Ljava/util/Queue;
    //   94: invokeinterface 247 1 0
    //   99: ifne +39 -> 138
    //   102: aload_0
    //   103: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   106: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   109: ifeq +13 -> 122
    //   112: aload_0
    //   113: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   116: ldc_w 411
    //   119: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getfield 99	cz/msebera/android/httpclient/i/c/a/e:n	Ljava/util/Queue;
    //   126: invokeinterface 413 1 0
    //   131: checkcast 270	cz/msebera/android/httpclient/i/c/a/i
    //   134: astore_1
    //   135: goto -63 -> 72
    //   138: aload_2
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   144: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   147: ifeq -75 -> 72
    //   150: aload_0
    //   151: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   154: ldc_w 415
    //   157: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   160: aload_2
    //   161: astore_1
    //   162: goto -90 -> 72
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   170: invokeinterface 226 1 0
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	e
    //   0	177	1	paramg	g
    //   1	160	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	67	165	finally
    //   67	72	165	finally
    //   76	80	165	finally
    //   90	122	165	finally
    //   122	135	165	finally
    //   140	160	165	finally
  }
  
  protected g b(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return new g(paramb, this.k);
  }
  
  public void b()
  {
    this.i.a("Closing expired connections");
    long l1 = System.currentTimeMillis();
    this.s.lock();
    try
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.a(l1))
        {
          if (this.i.a()) {
            this.i.a("Closing connection expired @ " + new Date(localb.h()));
          }
          localIterator.remove();
          a(localb);
        }
      }
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  public int c(cz.msebera.android.httpclient.e.b.b paramb)
  {
    int i1 = 0;
    this.s.lock();
    try
    {
      paramb = a(paramb, false);
      if (paramb != null) {
        i1 = paramb.e();
      }
      return i1;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  public void c()
  {
    this.s.lock();
    try
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (!localb.c().c())
        {
          localIterator.remove();
          a(localb);
        }
      }
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  public void d()
  {
    this.s.lock();
    Object localObject2;
    try
    {
      boolean bool = this.p;
      if (bool) {
        return;
      }
      this.p = true;
      Iterator localIterator1 = this.l.iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (b)localIterator1.next();
        localIterator1.remove();
        b((b)localObject2);
      }
      localIterator2 = this.m.iterator();
    }
    finally
    {
      this.s.unlock();
    }
    while (localIterator2.hasNext())
    {
      localObject2 = (b)localIterator2.next();
      localIterator2.remove();
      if (this.i.a()) {
        this.i.a("Closing connection [" + ((b)localObject2).d() + "][" + ((b)localObject2).a() + "]");
      }
      b((b)localObject2);
    }
    Iterator localIterator2 = this.n.iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (i)localIterator2.next();
      localIterator2.remove();
      ((i)localObject2).d();
    }
    this.o.clear();
    this.s.unlock();
  }
  
  protected Lock e()
  {
    return this.s;
  }
  
  protected Queue<b> f()
  {
    return new LinkedList();
  }
  
  protected Queue<i> g()
  {
    return new LinkedList();
  }
  
  protected Map<cz.msebera.android.httpclient.e.b.b, g> h()
  {
    return new HashMap();
  }
  
  public int i()
  {
    this.s.lock();
    try
    {
      int i1 = this.r;
      return i1;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  /* Error */
  protected void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 165 1 0
    //   9: aload_0
    //   10: getfield 94	cz/msebera/android/httpclient/i/c/a/e:m	Ljava/util/Queue;
    //   13: invokeinterface 413 1 0
    //   18: checkcast 127	cz/msebera/android/httpclient/i/c/a/b
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +18 -> 41
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 368	cz/msebera/android/httpclient/i/c/a/e:a	(Lcz/msebera/android/httpclient/i/c/a/b;)V
    //   31: aload_0
    //   32: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 226 1 0
    //   40: return
    //   41: aload_0
    //   42: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   45: invokevirtual 180	cz/msebera/android/httpclient/h/b:a	()Z
    //   48: ifeq -17 -> 31
    //   51: aload_0
    //   52: getfield 62	cz/msebera/android/httpclient/i/c/a/e:i	Lcz/msebera/android/httpclient/h/b;
    //   55: ldc_w 448
    //   58: invokevirtual 220	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   61: goto -30 -> 31
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 77	cz/msebera/android/httpclient/i/c/a/e:s	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 226 1 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	e
    //   21	7	1	localb	b
    //   64	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	64	finally
    //   26	31	64	finally
    //   41	61	64	finally
  }
  
  public int k()
  {
    return this.q;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */