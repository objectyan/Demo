package com.facebook.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.b.a.c;
import com.facebook.b.a.c.a;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class e
  implements j, com.facebook.common.b.a
{
  public static final int a = 1;
  private static final Class<?> d = e.class;
  private static final long e = TimeUnit.HOURS.toMillis(2L);
  private static final long f = TimeUnit.MINUTES.toMillis(30L);
  private static final double g = 0.02D;
  private static final long h = -1L;
  private static final String i = "disk_entries_list";
  @VisibleForTesting
  @GuardedBy("mLock")
  Map<Integer, String> b = new HashMap();
  @VisibleForTesting
  @GuardedBy("mLock")
  final Set<String> c;
  private final long j;
  private final long k;
  private final CountDownLatch l = new CountDownLatch(1);
  private long m;
  private final c n;
  private final SharedPreferences o;
  @GuardedBy("mLock")
  private long p;
  private final long q;
  private final com.facebook.common.j.a r;
  private final d s;
  private final i t;
  private final com.facebook.b.a.a u;
  private final a v;
  private final com.facebook.common.l.b w;
  private final Object x = new Object();
  
  public e(d paramd, i parami, b paramb, c paramc, com.facebook.b.a.a parama, @Nullable com.facebook.common.b.b paramb1, Context paramContext)
  {
    this.j = paramb.b;
    this.k = paramb.c;
    this.m = paramb.c;
    this.r = com.facebook.common.j.a.a();
    this.s = paramd;
    this.t = parami;
    this.p = -1L;
    this.n = paramc;
    this.q = paramb.a;
    this.u = parama;
    this.v = new a();
    if (paramb1 != null) {
      paramb1.a(this);
    }
    this.w = com.facebook.common.l.f.b();
    this.o = a(paramContext, this.s.b());
    this.c = new HashSet();
    Executors.newSingleThreadExecutor().execute(new Runnable()
    {
      public void run()
      {
        synchronized (e.a(e.this))
        {
          e.b(e.this);
          e.c(e.this).countDown();
          return;
        }
      }
    });
  }
  
  private static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getSharedPreferences("disk_entries_list" + paramString, 0);
  }
  
  private com.facebook.a.a a(d.d paramd, com.facebook.b.a.d paramd1, String paramString)
    throws IOException
  {
    synchronized (this.x)
    {
      paramd = paramd.a(paramd1);
      a(Integer.valueOf(paramd1.hashCode()), paramString);
      this.v.b(paramd.c(), 1L);
      return paramd;
    }
  }
  
  private d.d a(String paramString, com.facebook.b.a.d paramd)
    throws IOException
  {
    h();
    return this.s.a(paramString, paramd);
  }
  
  private static Integer a(Map<Integer, String> paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getValue().equals(paramString)) {
        return (Integer)localEntry.getKey();
      }
    }
    return Integer.valueOf(0);
  }
  
  private Collection<d.c> a(Collection<d.c> paramCollection)
  {
    long l1 = this.w.a();
    long l2 = e;
    ArrayList localArrayList1 = new ArrayList(paramCollection.size());
    ArrayList localArrayList2 = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      d.c localc = (d.c)paramCollection.next();
      if (localc.b() > l1 + l2) {
        localArrayList1.add(localc);
      } else {
        localArrayList2.add(localc);
      }
    }
    Collections.sort(localArrayList2, this.t.a());
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  private void a(double paramDouble)
  {
    synchronized (this.x)
    {
      try
      {
        this.v.b();
        j();
        long l1 = this.v.c();
        a(l1 - (l1 * paramDouble), c.a.d);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.u.a(com.facebook.b.a.a.a.o, d, "trimBy: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  @GuardedBy("mLock")
  private void a(long paramLong, c.a parama)
    throws IOException
  {
    for (;;)
    {
      long l2;
      int i1;
      long l1;
      d.c localc;
      try
      {
        Object localObject = a(this.s.g());
        l2 = this.v.c();
        i1 = 0;
        l1 = 0L;
        localObject = ((Collection)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localc = (d.c)((Iterator)localObject).next();
          if (l1 <= l2 - paramLong) {}
        }
        else
        {
          this.v.b(-l1, -i1);
          this.s.c();
          return;
        }
      }
      catch (IOException parama)
      {
        this.u.a(com.facebook.b.a.a.a.o, d, "evictAboveSize: " + parama.getMessage(), parama);
        throw parama;
      }
      long l3 = this.s.a(localc);
      a(localc.a());
      if (l3 > 0L)
      {
        i1 += 1;
        l1 += l3;
        this.n.g(new l().a(localc.a()).a(parama).a(l3).b(l2 - l1).c(paramLong));
      }
    }
  }
  
  @GuardedBy("mLock")
  private void a(Integer paramInteger)
  {
    String str = (String)this.b.remove(paramInteger);
    if (str != null)
    {
      this.c.remove(str);
      f.a(paramInteger, this.o);
    }
  }
  
  @GuardedBy("mLock")
  private void a(Integer paramInteger, String paramString)
  {
    this.b.put(paramInteger, paramString);
    this.c.add(paramString);
    f.a(paramInteger, paramString, this.o);
  }
  
  @GuardedBy("mLock")
  private void a(String paramString)
  {
    a(a(this.b, paramString));
  }
  
  @VisibleForTesting
  static String f(com.facebook.b.a.d paramd)
  {
    try
    {
      if ((paramd instanceof com.facebook.b.a.f)) {
        return h((com.facebook.b.a.d)((com.facebook.b.a.f)paramd).a().get(0));
      }
      paramd = h(paramd);
      return paramd;
    }
    catch (UnsupportedEncodingException paramd)
    {
      throw new RuntimeException(paramd);
    }
  }
  
  private static List<String> g(com.facebook.b.a.d paramd)
  {
    try
    {
      if ((paramd instanceof com.facebook.b.a.f))
      {
        List localList = ((com.facebook.b.a.f)paramd).a();
        localArrayList = new ArrayList(localList.size());
        int i1 = 0;
        for (;;)
        {
          paramd = localArrayList;
          if (i1 >= localList.size()) {
            break;
          }
          localArrayList.add(h((com.facebook.b.a.d)localList.get(i1)));
          i1 += 1;
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(h(paramd));
      paramd = localArrayList;
      return paramd;
    }
    catch (UnsupportedEncodingException paramd)
    {
      throw new RuntimeException(paramd);
    }
  }
  
  private static String h(com.facebook.b.a.d paramd)
    throws UnsupportedEncodingException
  {
    return com.facebook.common.m.d.b(paramd.toString().getBytes("UTF-8"));
  }
  
  private void h()
    throws IOException
  {
    synchronized (this.x)
    {
      boolean bool = j();
      i();
      long l1 = this.v.c();
      if ((l1 > this.m) && (!bool))
      {
        this.v.b();
        j();
      }
      if (l1 > this.m) {
        a(this.m * 9L / 10L, c.a.a);
      }
      return;
    }
  }
  
  @GuardedBy("mLock")
  private void i()
  {
    if (this.r.a(com.facebook.common.j.a.a.a, this.k - this.v.c()))
    {
      this.m = this.j;
      return;
    }
    this.m = this.k;
  }
  
  @GuardedBy("mLock")
  private boolean j()
  {
    boolean bool = false;
    long l1 = this.w.a();
    if ((!this.v.a()) || (this.p == -1L) || (l1 - this.p > f))
    {
      k();
      this.p = l1;
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("mLock")
  private void k()
  {
    long l2 = 0L;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    long l1 = -1L;
    long l3 = this.w.a();
    long l4 = e;
    HashSet localHashSet = new HashSet();
    do
    {
      try
      {
        Iterator localIterator = this.s.g().iterator();
        while (localIterator.hasNext())
        {
          d.c localc = (d.c)localIterator.next();
          i4 += 1;
          l2 += localc.d();
          if (localc.b() > l3 + l4)
          {
            i3 = 1;
            i2 += 1;
            i1 = (int)(i1 + localc.d());
            l1 = Math.max(localc.b() - l3, l1);
          }
          else
          {
            localHashSet.add(localc.a());
          }
        }
        if (i3 == 0) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        this.u.a(com.facebook.b.a.a.a.p, d, "calcFileCacheSize: " + localIOException.getMessage(), localIOException);
        return;
      }
      this.u.a(com.facebook.b.a.a.a.d, d, "Future timestamp found in " + i2 + " files , with a total size of " + i1 + " bytes, and a maximum time delta of " + l1 + "ms", null);
    } while ((this.v.d() == i4) && (this.v.c() == l2));
    this.c.clear();
    this.c.addAll(localIOException);
    this.b = f.a(this.o, this.c);
    this.v.a(l2, i4);
  }
  
  public long a(long paramLong)
  {
    l1 = 0L;
    localObject1 = this.x;
    l2 = l1;
    for (;;)
    {
      try
      {
        l4 = this.w.a();
        l2 = l1;
        localObject2 = this.s.g();
        l2 = l1;
        l5 = this.v.c();
        i1 = 0;
        l3 = 0L;
        l2 = l1;
        localObject2 = ((Collection)localObject2).iterator();
      }
      catch (IOException localIOException)
      {
        long l4;
        Object localObject2;
        long l5;
        int i1;
        long l3;
        d.c localc;
        long l6;
        this.u.a(com.facebook.b.a.a.a.o, d, "clearOldEntries: " + localIOException.getMessage(), localIOException);
        return l2;
        l2 = l1;
        l1 = Math.max(l1, l6);
        continue;
        l2 = l1;
        this.s.c();
        l2 = l1;
        if (i1 <= 0) {
          continue;
        }
        l2 = l1;
        j();
        l2 = l1;
        this.v.b(-l3, -i1);
        l2 = l1;
        continue;
      }
      finally {}
      l2 = l1;
      if (!((Iterator)localObject2).hasNext()) {
        continue;
      }
      l2 = l1;
      localc = (d.c)((Iterator)localObject2).next();
      l2 = l1;
      l6 = Math.max(1L, Math.abs(l4 - localc.b()));
      if (l6 < paramLong) {
        continue;
      }
      l2 = l1;
      l6 = this.s.a(localc);
      l2 = l1;
      a(localc.a());
      if (l6 > 0L)
      {
        i1 += 1;
        l3 += l6;
        l2 = l1;
        this.n.g(new l().a(localc.a()).a(c.a.b).a(l6).b(l5 - l3));
      }
    }
  }
  
  /* Error */
  public com.facebook.a.a a(com.facebook.b.a.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 373	com/facebook/b/b/l
    //   6: dup
    //   7: invokespecial 374	com/facebook/b/b/l:<init>	()V
    //   10: aload_1
    //   11: invokevirtual 527	com/facebook/b/b/l:a	(Lcom/facebook/b/a/d;)Lcom/facebook/b/b/l;
    //   14: astore 6
    //   16: aload_1
    //   17: invokeinterface 226 1 0
    //   22: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: astore 8
    //   27: aload_0
    //   28: getfield 115	com/facebook/b/b/e:x	Ljava/lang/Object;
    //   31: astore 7
    //   33: aload 7
    //   35: monitorenter
    //   36: aconst_null
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 113	com/facebook/b/b/e:b	Ljava/util/Map;
    //   43: aload 8
    //   45: invokeinterface 530 2 0
    //   50: ifeq +66 -> 116
    //   53: aload_0
    //   54: getfield 113	com/facebook/b/b/e:b	Ljava/util/Map;
    //   57: aload 8
    //   59: invokeinterface 532 2 0
    //   64: checkcast 400	java/lang/String
    //   67: astore 5
    //   69: aload 6
    //   71: aload 5
    //   73: invokevirtual 377	com/facebook/b/b/l:a	(Ljava/lang/String;)Lcom/facebook/b/b/l;
    //   76: pop
    //   77: aload_0
    //   78: getfield 134	com/facebook/b/b/e:s	Lcom/facebook/b/b/d;
    //   81: aload 5
    //   83: aload_1
    //   84: invokeinterface 535 3 0
    //   89: astore_3
    //   90: aload_3
    //   91: ifnonnull +108 -> 199
    //   94: aload_0
    //   95: getfield 140	com/facebook/b/b/e:n	Lcom/facebook/b/a/c;
    //   98: aload 6
    //   100: invokeinterface 537 2 0
    //   105: aload_0
    //   106: aload 8
    //   108: invokespecial 419	com/facebook/b/b/e:a	(Ljava/lang/Integer;)V
    //   111: aload 7
    //   113: monitorexit
    //   114: aload_3
    //   115: areturn
    //   116: aload_1
    //   117: invokestatic 539	com/facebook/b/b/e:g	(Lcom/facebook/b/a/d;)Ljava/util/List;
    //   120: astore 9
    //   122: iconst_0
    //   123: istore_2
    //   124: aload 4
    //   126: astore_3
    //   127: iload_2
    //   128: aload 9
    //   130: invokeinterface 444 1 0
    //   135: if_icmpge -45 -> 90
    //   138: aload 9
    //   140: iload_2
    //   141: invokeinterface 435 2 0
    //   146: checkcast 400	java/lang/String
    //   149: astore 5
    //   151: aload_0
    //   152: getfield 176	com/facebook/b/b/e:c	Ljava/util/Set;
    //   155: aload 5
    //   157: invokeinterface 542 2 0
    //   162: ifne +6 -> 168
    //   165: goto +102 -> 267
    //   168: aload 6
    //   170: aload 5
    //   172: invokevirtual 377	com/facebook/b/b/l:a	(Ljava/lang/String;)Lcom/facebook/b/b/l;
    //   175: pop
    //   176: aload_0
    //   177: getfield 134	com/facebook/b/b/e:s	Lcom/facebook/b/b/d;
    //   180: aload 5
    //   182: aload_1
    //   183: invokeinterface 535 3 0
    //   188: astore_3
    //   189: aload_3
    //   190: astore 4
    //   192: aload_3
    //   193: ifnull +74 -> 267
    //   196: goto -106 -> 90
    //   199: aload_0
    //   200: getfield 140	com/facebook/b/b/e:n	Lcom/facebook/b/a/c;
    //   203: aload 6
    //   205: invokeinterface 544 2 0
    //   210: aload_0
    //   211: aload 8
    //   213: aload 5
    //   215: invokespecial 235	com/facebook/b/b/e:a	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   218: goto -107 -> 111
    //   221: astore_1
    //   222: aload 7
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: aload_0
    //   229: getfield 146	com/facebook/b/b/e:u	Lcom/facebook/b/a/a;
    //   232: getstatic 488	com/facebook/b/a/a$a:p	Lcom/facebook/b/a/a$a;
    //   235: getstatic 74	com/facebook/b/b/e:d	Ljava/lang/Class;
    //   238: ldc_w 546
    //   241: aload_1
    //   242: invokeinterface 354 5 0
    //   247: aload 6
    //   249: aload_1
    //   250: invokevirtual 549	com/facebook/b/b/l:a	(Ljava/io/IOException;)Lcom/facebook/b/b/l;
    //   253: pop
    //   254: aload_0
    //   255: getfield 140	com/facebook/b/b/e:n	Lcom/facebook/b/a/c;
    //   258: aload 6
    //   260: invokeinterface 551 2 0
    //   265: aconst_null
    //   266: areturn
    //   267: iload_2
    //   268: iconst_1
    //   269: iadd
    //   270: istore_2
    //   271: goto -147 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	e
    //   0	274	1	paramd	com.facebook.b.a.d
    //   123	148	2	i1	int
    //   89	104	3	localObject1	Object
    //   37	154	4	localObject2	Object
    //   1	213	5	str	String
    //   14	245	6	locall	l
    //   31	192	7	localObject3	Object
    //   25	187	8	localInteger	Integer
    //   120	19	9	localList	List
    // Exception table:
    //   from	to	target	type
    //   39	90	221	finally
    //   94	111	221	finally
    //   111	114	221	finally
    //   116	122	221	finally
    //   127	165	221	finally
    //   168	189	221	finally
    //   199	218	221	finally
    //   222	225	221	finally
    //   27	36	227	java/io/IOException
    //   225	227	227	java/io/IOException
  }
  
  public com.facebook.a.a a(com.facebook.b.a.d paramd, com.facebook.b.a.j paramj)
    throws IOException
  {
    locall = new l().a(paramd);
    this.n.c(locall);
    Object localObject1;
    synchronized (this.x)
    {
      localObject1 = Integer.valueOf(paramd.hashCode());
      if (this.b.containsKey(localObject1))
      {
        localObject1 = (String)this.b.get(localObject1);
        locall.a((String)localObject1);
      }
    }
  }
  
  public d.a a()
    throws IOException
  {
    return this.s.e();
  }
  
  public boolean b()
  {
    return this.s.a();
  }
  
  /* Error */
  public boolean b(com.facebook.b.a.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 8
    //   11: astore 5
    //   13: aload_0
    //   14: getfield 115	com/facebook/b/b/e:x	Ljava/lang/Object;
    //   17: astore 9
    //   19: aload 8
    //   21: astore 5
    //   23: aload 9
    //   25: monitorenter
    //   26: iconst_0
    //   27: istore 4
    //   29: aload 6
    //   31: astore 5
    //   33: aload_1
    //   34: invokeinterface 226 1 0
    //   39: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: astore 8
    //   44: aload 6
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 113	com/facebook/b/b/e:b	Ljava/util/Map;
    //   52: aload 8
    //   54: invokeinterface 530 2 0
    //   59: ifeq +65 -> 124
    //   62: aload 6
    //   64: astore 5
    //   66: aload_0
    //   67: getfield 113	com/facebook/b/b/e:b	Ljava/util/Map;
    //   70: aload 8
    //   72: invokeinterface 532 2 0
    //   77: checkcast 400	java/lang/String
    //   80: astore 6
    //   82: aload 6
    //   84: astore 5
    //   86: aload_0
    //   87: getfield 134	com/facebook/b/b/e:s	Lcom/facebook/b/b/d;
    //   90: aload 6
    //   92: aload_1
    //   93: invokeinterface 588 3 0
    //   98: istore_3
    //   99: iload_3
    //   100: ifeq +15 -> 115
    //   103: aload 6
    //   105: astore 5
    //   107: aload_0
    //   108: aload 8
    //   110: aload 6
    //   112: invokespecial 235	com/facebook/b/b/e:a	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   115: aload 6
    //   117: astore 5
    //   119: aload 9
    //   121: monitorexit
    //   122: iload_3
    //   123: ireturn
    //   124: aload 6
    //   126: astore 5
    //   128: aload_1
    //   129: invokestatic 539	com/facebook/b/b/e:g	(Lcom/facebook/b/a/d;)Ljava/util/List;
    //   132: astore 10
    //   134: iconst_0
    //   135: istore_2
    //   136: aload 7
    //   138: astore 6
    //   140: iload 4
    //   142: istore_3
    //   143: aload 7
    //   145: astore 5
    //   147: iload_2
    //   148: aload 10
    //   150: invokeinterface 444 1 0
    //   155: if_icmpge -56 -> 99
    //   158: aload 7
    //   160: astore 5
    //   162: aload 10
    //   164: iload_2
    //   165: invokeinterface 435 2 0
    //   170: checkcast 400	java/lang/String
    //   173: astore 6
    //   175: aload 6
    //   177: astore 5
    //   179: aload_0
    //   180: getfield 176	com/facebook/b/b/e:c	Ljava/util/Set;
    //   183: aload 6
    //   185: invokeinterface 542 2 0
    //   190: ifne +6 -> 196
    //   193: goto +72 -> 265
    //   196: aload 6
    //   198: astore 5
    //   200: aload_0
    //   201: getfield 134	com/facebook/b/b/e:s	Lcom/facebook/b/b/d;
    //   204: aload 6
    //   206: aload_1
    //   207: invokeinterface 588 3 0
    //   212: istore_3
    //   213: iload_3
    //   214: istore 4
    //   216: iload_3
    //   217: ifeq +48 -> 265
    //   220: goto -121 -> 99
    //   223: astore 6
    //   225: aload 9
    //   227: monitorexit
    //   228: aload 6
    //   230: athrow
    //   231: astore 6
    //   233: aload_0
    //   234: getfield 140	com/facebook/b/b/e:n	Lcom/facebook/b/a/c;
    //   237: new 373	com/facebook/b/b/l
    //   240: dup
    //   241: invokespecial 374	com/facebook/b/b/l:<init>	()V
    //   244: aload_1
    //   245: invokevirtual 527	com/facebook/b/b/l:a	(Lcom/facebook/b/a/d;)Lcom/facebook/b/b/l;
    //   248: aload 5
    //   250: invokevirtual 377	com/facebook/b/b/l:a	(Ljava/lang/String;)Lcom/facebook/b/b/l;
    //   253: aload 6
    //   255: invokevirtual 549	com/facebook/b/b/l:a	(Ljava/io/IOException;)Lcom/facebook/b/b/l;
    //   258: invokeinterface 551 2 0
    //   263: iconst_0
    //   264: ireturn
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: aload 6
    //   271: astore 7
    //   273: goto -137 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	e
    //   0	276	1	paramd	com.facebook.b.a.d
    //   135	134	2	i1	int
    //   98	119	3	bool1	boolean
    //   27	188	4	bool2	boolean
    //   11	238	5	localObject1	Object
    //   1	204	6	localObject2	Object
    //   223	6	6	localObject3	Object
    //   231	39	6	localIOException1	IOException
    //   7	265	7	localIOException2	IOException
    //   4	105	8	localInteger	Integer
    //   17	209	9	localObject4	Object
    //   132	31	10	localList	List
    // Exception table:
    //   from	to	target	type
    //   33	44	223	finally
    //   48	62	223	finally
    //   66	82	223	finally
    //   86	99	223	finally
    //   107	115	223	finally
    //   119	122	223	finally
    //   128	134	223	finally
    //   147	158	223	finally
    //   162	175	223	finally
    //   179	193	223	finally
    //   200	213	223	finally
    //   225	228	223	finally
    //   13	19	231	java/io/IOException
    //   23	26	231	java/io/IOException
    //   228	231	231	java/io/IOException
  }
  
  @VisibleForTesting
  protected void c()
  {
    try
    {
      this.l.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      com.facebook.common.e.a.e(d, "Memory Index is not ready yet. ");
    }
  }
  
  public void c(com.facebook.b.a.d paramd)
  {
    synchronized (this.x)
    {
      label67:
      do
      {
        try
        {
          Integer localInteger = Integer.valueOf(paramd.hashCode());
          if (!this.b.containsKey(localInteger)) {
            break label67;
          }
          paramd = (String)this.b.get(localInteger);
          this.s.b(paramd);
          a(localInteger);
        }
        catch (IOException paramd)
        {
          for (;;)
          {
            int i1;
            String str;
            this.u.a(com.facebook.b.a.a.a.n, d, "delete: " + paramd.getMessage(), paramd);
          }
        }
        return;
        paramd = g(paramd);
        i1 = 0;
      } while (i1 >= paramd.size());
      str = (String)paramd.get(i1);
      this.s.b(str);
      i1 += 1;
    }
  }
  
  public long d()
  {
    return this.v.c();
  }
  
  public boolean d(com.facebook.b.a.d paramd)
  {
    for (;;)
    {
      int i1;
      synchronized (this.x)
      {
        int i2 = paramd.hashCode();
        if (this.b.containsKey(Integer.valueOf(i2))) {
          return true;
        }
        paramd = g(paramd);
        i1 = 0;
        if (i1 >= paramd.size()) {
          break;
        }
        String str = (String)paramd.get(i1);
        if (this.c.contains(str))
        {
          this.b.put(Integer.valueOf(i2), str);
          return true;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public void e()
  {
    synchronized (this.x)
    {
      try
      {
        this.s.d();
        this.c.clear();
        this.b.clear();
        f.a(this.o);
        this.v.b();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.u.a(com.facebook.b.a.a.a.o, d, "clearAll: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  public boolean e(com.facebook.b.a.d paramd)
  {
    String str;
    boolean bool;
    synchronized (this.x)
    {
      if (d(paramd)) {
        return true;
      }
      str = null;
      bool = false;
    }
    try
    {
      List localList = g(paramd);
      int i1 = 0;
      for (;;)
      {
        if (i1 < localList.size())
        {
          str = (String)localList.get(i1);
          bool = this.s.c(str, paramd);
          if (!bool) {}
        }
        else
        {
          if (bool) {
            a(Integer.valueOf(paramd.hashCode()), str);
          }
          return bool;
          paramd = finally;
          throw paramd;
        }
        i1 += 1;
      }
      return false;
    }
    catch (IOException paramd) {}
  }
  
  public void f()
  {
    synchronized (this.x)
    {
      j();
      long l1 = this.v.c();
      if ((this.q <= 0L) || (l1 <= 0L) || (l1 < this.q)) {
        return;
      }
      double d1 = 1.0D - this.q / l1;
      if (d1 > 0.02D) {
        a(d1);
      }
      return;
    }
  }
  
  public void g()
  {
    e();
  }
  
  @VisibleForTesting
  static class a
  {
    private boolean a = false;
    private long b = -1L;
    private long c = -1L;
    
    public void a(long paramLong1, long paramLong2)
    {
      try
      {
        this.c = paramLong2;
        this.b = paramLong1;
        this.a = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean a()
    {
      try
      {
        boolean bool = this.a;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void b()
    {
      try
      {
        this.a = false;
        this.c = -1L;
        this.b = -1L;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void b(long paramLong1, long paramLong2)
    {
      try
      {
        if (this.a)
        {
          this.b += paramLong1;
          this.c += paramLong2;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public long c()
    {
      try
      {
        long l = this.b;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public long d()
    {
      try
      {
        long l = this.c;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static class b
  {
    public final long a;
    public final long b;
    public final long c;
    
    public b(long paramLong1, long paramLong2, long paramLong3)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramLong3;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */