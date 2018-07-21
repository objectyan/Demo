package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.d.d;
import cz.msebera.android.httpclient.e.d.c;
import cz.msebera.android.httpclient.e.k;
import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.e.o;
import cz.msebera.android.httpclient.e.p;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.n.g;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
public class e
  implements o, Closeable
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final t b;
  private final p<cz.msebera.android.httpclient.e.b.b, u> c;
  @GuardedBy("this")
  private u d;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.e.b.b e;
  @GuardedBy("this")
  private Object f;
  @GuardedBy("this")
  private long g;
  @GuardedBy("this")
  private long h;
  @GuardedBy("this")
  private boolean i;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.d.f j;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.d.a k;
  private final AtomicBoolean l;
  
  public e()
  {
    this(g(), null, null, null);
  }
  
  public e(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> paramb)
  {
    this(paramb, null, null, null);
  }
  
  public e(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> paramb, p<cz.msebera.android.httpclient.e.b.b, u> paramp)
  {
    this(paramb, paramp, null, null);
  }
  
  public e(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> paramb, p<cz.msebera.android.httpclient.e.b.b, u> paramp, x paramx, l paraml)
  {
    this.b = new t(paramb, paramx, paraml);
    if (paramp != null) {}
    for (;;)
    {
      this.c = paramp;
      this.h = Long.MAX_VALUE;
      this.j = cz.msebera.android.httpclient.d.f.a;
      this.k = cz.msebera.android.httpclient.d.a.a;
      this.l = new AtomicBoolean(false);
      return;
      paramp = ae.a;
    }
  }
  
  private static d<cz.msebera.android.httpclient.e.d.a> g()
  {
    return cz.msebera.android.httpclient.d.e.a().a("http", c.a()).a("https", cz.msebera.android.httpclient.e.e.f.a()).b();
  }
  
  private void h()
  {
    if (this.d != null) {
      this.a.a("Closing connection");
    }
    try
    {
      this.d.close();
      this.d = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (this.a.a()) {
          this.a.a("I/O exception closing connection", localIOException);
        }
      }
    }
  }
  
  private void i()
  {
    if (this.d != null) {
      this.a.a("Shutting down connection");
    }
    try
    {
      this.d.f();
      this.d = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (this.a.a()) {
          this.a.a("I/O exception shutting down connection", localIOException);
        }
      }
    }
  }
  
  private void j()
  {
    if ((this.d != null) && (System.currentTimeMillis() >= this.h))
    {
      if (this.a.a()) {
        this.a.a("Connection expired @ " + new Date(this.h));
      }
      h();
    }
  }
  
  public final k a(final cz.msebera.android.httpclient.e.b.b paramb, final Object paramObject)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Route");
    new k()
    {
      public j a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        return e.this.b(paramb, paramObject);
      }
      
      public boolean a()
      {
        return false;
      }
    };
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	cz/msebera/android/httpclient/i/c/e:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   21: ifne -7 -> 14
    //   24: aload_0
    //   25: invokespecial 202	cz/msebera/android/httpclient/i/c/e:j	()V
    //   28: goto -14 -> 14
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	e
    //   9	2	1	bool	boolean
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: ldc -51
    //   5: invokestatic 192	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_0
    //   10: getfield 97	cz/msebera/android/httpclient/i/c/e:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   13: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   16: istore 6
    //   18: iload 6
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   30: ifne -7 -> 23
    //   33: aload_3
    //   34: lload_1
    //   35: invokevirtual 211	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   38: lstore 4
    //   40: lload 4
    //   42: lstore_1
    //   43: lload 4
    //   45: lconst_0
    //   46: lcmp
    //   47: ifge +5 -> 52
    //   50: lconst_0
    //   51: lstore_1
    //   52: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   55: lstore 4
    //   57: aload_0
    //   58: getfield 213	cz/msebera/android/httpclient/i/c/e:g	J
    //   61: lload 4
    //   63: lload_1
    //   64: lsub
    //   65: lcmp
    //   66: ifgt -43 -> 23
    //   69: aload_0
    //   70: invokespecial 184	cz/msebera/android/httpclient/i/c/e:h	()V
    //   73: goto -50 -> 23
    //   76: astore_3
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_3
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	e
    //   0	81	1	paramLong	long
    //   0	81	3	paramTimeUnit	TimeUnit
    //   38	24	4	l1	long
    //   16	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	76	finally
    //   26	40	76	finally
    //   52	73	76	finally
  }
  
  public void a(cz.msebera.android.httpclient.d.a parama)
  {
    if (parama != null) {}
    for (;;)
    {
      try
      {
        this.k = parama;
        return;
      }
      finally {}
      parama = cz.msebera.android.httpclient.d.a.a;
    }
  }
  
  public void a(cz.msebera.android.httpclient.d.f paramf)
  {
    if (paramf != null) {}
    for (;;)
    {
      try
      {
        this.j = paramf;
        return;
      }
      finally {}
      paramf = cz.msebera.android.httpclient.d.f.a;
    }
  }
  
  public void a(j paramj, cz.msebera.android.httpclient.e.b.b paramb, int paramInt, g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Connection");
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    boolean bool;
    if (paramj == this.d)
    {
      bool = true;
      cz.msebera.android.httpclient.o.b.a(bool, "Connection not obtained from this manager");
      if (paramb.e() == null) {
        break label76;
      }
    }
    label76:
    for (paramj = paramb.e();; paramj = paramb.a())
    {
      paramb = paramb.c();
      this.b.a(this.d, paramj, paramb, paramInt, this.j, paramg);
      return;
      bool = false;
      break;
    }
  }
  
  public void a(j paramj, cz.msebera.android.httpclient.e.b.b paramb, g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Connection");
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    if (paramj == this.d) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection not obtained from this manager");
      this.b.a(this.d, paramb.a(), paramg);
      return;
    }
  }
  
  /* Error */
  public void a(j paramj, Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ldc -38
    //   8: invokestatic 192	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   17: if_acmpne +6 -> 23
    //   20: iconst_1
    //   21: istore 6
    //   23: iload 6
    //   25: ldc -34
    //   27: invokestatic 227	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   30: aload_0
    //   31: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   34: invokevirtual 144	cz/msebera/android/httpclient/h/b:a	()Z
    //   37: ifeq +29 -> 66
    //   40: aload_0
    //   41: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   44: new 163	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   51: ldc -8
    //   53: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 136	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   66: aload_0
    //   67: getfield 97	cz/msebera/android/httpclient/i/c/e:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   70: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   73: istore 6
    //   75: iload 6
    //   77: ifeq +6 -> 83
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   87: putfield 213	cz/msebera/android/httpclient/i/c/e:g	J
    //   90: aload_0
    //   91: getfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   94: invokeinterface 250 1 0
    //   99: ifne +38 -> 137
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 252	cz/msebera/android/httpclient/i/c/e:e	Lcz/msebera/android/httpclient/e/b/b;
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   117: aload_0
    //   118: ldc2_w 75
    //   121: putfield 78	cz/msebera/android/httpclient/i/c/e:h	J
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   129: goto -49 -> 80
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    //   137: aload_0
    //   138: aload_2
    //   139: putfield 254	cz/msebera/android/httpclient/i/c/e:f	Ljava/lang/Object;
    //   142: aload_0
    //   143: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   146: invokevirtual 144	cz/msebera/android/httpclient/h/b:a	()Z
    //   149: ifeq +68 -> 217
    //   152: lload_3
    //   153: lconst_0
    //   154: lcmp
    //   155: ifle +94 -> 249
    //   158: new 163	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 256
    //   168: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: lload_3
    //   172: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: ldc_w 261
    //   178: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 5
    //   183: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_1
    //   190: aload_0
    //   191: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   194: new 163	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 263
    //   204: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokevirtual 136	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   217: lload_3
    //   218: lconst_0
    //   219: lcmp
    //   220: ifle +36 -> 256
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 213	cz/msebera/android/httpclient/i/c/e:g	J
    //   228: aload 5
    //   230: lload_3
    //   231: invokevirtual 211	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   234: ladd
    //   235: putfield 78	cz/msebera/android/httpclient/i/c/e:h	J
    //   238: goto -114 -> 124
    //   241: astore_1
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   247: aload_1
    //   248: athrow
    //   249: ldc_w 265
    //   252: astore_1
    //   253: goto -63 -> 190
    //   256: aload_0
    //   257: ldc2_w 75
    //   260: putfield 78	cz/msebera/android/httpclient/i/c/e:h	J
    //   263: goto -139 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	e
    //   0	266	1	paramj	j
    //   0	266	2	paramObject	Object
    //   0	266	3	paramLong	long
    //   0	266	5	paramTimeUnit	TimeUnit
    //   1	75	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	132	finally
    //   12	20	132	finally
    //   23	66	132	finally
    //   66	75	132	finally
    //   124	129	132	finally
    //   242	249	132	finally
    //   83	124	241	finally
    //   137	152	241	finally
    //   158	190	241	finally
    //   190	217	241	finally
    //   223	238	241	finally
    //   256	263	241	finally
  }
  
  /* Error */
  j b(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 97	cz/msebera/android/httpclient/i/c/e:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: ifne +148 -> 160
    //   15: iconst_1
    //   16: istore_3
    //   17: iload_3
    //   18: ldc_w 268
    //   21: invokestatic 227	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   24: aload_0
    //   25: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   28: invokevirtual 144	cz/msebera/android/httpclient/h/b:a	()Z
    //   31: ifeq +30 -> 61
    //   34: aload_0
    //   35: getfield 65	cz/msebera/android/httpclient/i/c/e:a	Lcz/msebera/android/httpclient/h/b;
    //   38: new 163	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 270
    //   48: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 136	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   65: ifne +100 -> 165
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ldc_w 272
    //   75: invokestatic 227	cz/msebera/android/httpclient/o/b:a	(ZLjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 252	cz/msebera/android/httpclient/i/c/e:e	Lcz/msebera/android/httpclient/e/b/b;
    //   82: aload_1
    //   83: invokestatic 277	cz/msebera/android/httpclient/o/i:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   86: ifeq +14 -> 100
    //   89: aload_0
    //   90: getfield 254	cz/msebera/android/httpclient/i/c/e:f	Ljava/lang/Object;
    //   93: aload_2
    //   94: invokestatic 277	cz/msebera/android/httpclient/o/i:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   97: ifne +7 -> 104
    //   100: aload_0
    //   101: invokespecial 184	cz/msebera/android/httpclient/i/c/e:h	()V
    //   104: aload_0
    //   105: aload_1
    //   106: putfield 252	cz/msebera/android/httpclient/i/c/e:e	Lcz/msebera/android/httpclient/e/b/b;
    //   109: aload_0
    //   110: aload_2
    //   111: putfield 254	cz/msebera/android/httpclient/i/c/e:f	Ljava/lang/Object;
    //   114: aload_0
    //   115: invokespecial 202	cz/msebera/android/httpclient/i/c/e:j	()V
    //   118: aload_0
    //   119: getfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   122: ifnonnull +24 -> 146
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 74	cz/msebera/android/httpclient/i/c/e:c	Lcz/msebera/android/httpclient/e/p;
    //   130: aload_1
    //   131: aload_0
    //   132: getfield 90	cz/msebera/android/httpclient/i/c/e:k	Lcz/msebera/android/httpclient/d/a;
    //   135: invokeinterface 282 3 0
    //   140: checkcast 138	cz/msebera/android/httpclient/e/u
    //   143: putfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   146: aload_0
    //   147: iconst_1
    //   148: putfield 200	cz/msebera/android/httpclient/i/c/e:i	Z
    //   151: aload_0
    //   152: getfield 132	cz/msebera/android/httpclient/i/c/e:d	Lcz/msebera/android/httpclient/e/u;
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: areturn
    //   160: iconst_0
    //   161: istore_3
    //   162: goto -145 -> 17
    //   165: iconst_0
    //   166: istore_3
    //   167: goto -96 -> 71
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	e
    //   0	175	1	paramb	cz.msebera.android.httpclient.e.b.b
    //   0	175	2	paramObject	Object
    //   16	151	3	bool1	boolean
    //   1	68	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	15	170	finally
    //   17	61	170	finally
    //   61	68	170	finally
    //   71	100	170	finally
    //   100	104	170	finally
    //   104	146	170	finally
    //   146	156	170	finally
  }
  
  public void b()
  {
    try
    {
      if (this.l.compareAndSet(false, true)) {
        i();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(j paramj, cz.msebera.android.httpclient.e.b.b paramb, g paramg)
    throws IOException
  {}
  
  cz.msebera.android.httpclient.e.b.b c()
  {
    return this.e;
  }
  
  public void close()
  {
    b();
  }
  
  Object d()
  {
    return this.f;
  }
  
  public cz.msebera.android.httpclient.d.f e()
  {
    try
    {
      cz.msebera.android.httpclient.d.f localf = this.j;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public cz.msebera.android.httpclient.d.a f()
  {
    try
    {
      cz.msebera.android.httpclient.d.a locala = this.k;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */