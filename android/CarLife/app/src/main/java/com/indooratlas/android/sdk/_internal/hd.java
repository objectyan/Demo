package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class hd
{
  long a = 0L;
  long b;
  final int c;
  final hc d;
  List<he> e;
  public final b f;
  final a g;
  public final c h = new c();
  public final c i = new c();
  private final List<he> k;
  private gz l = null;
  
  static
  {
    if (!hd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      return;
    }
  }
  
  hd(int paramInt, hc paramhc, boolean paramBoolean1, boolean paramBoolean2, List<he> paramList)
  {
    if (paramhc == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.c = paramInt;
    this.d = paramhc;
    this.b = paramhc.f.b();
    this.f = new b(paramhc.e.b(), (byte)0);
    this.g = new a();
    b.a(this.f, paramBoolean2);
    a.a(this.g, paramBoolean1);
    this.k = paramList;
  }
  
  private boolean d(gz paramgz)
  {
    if ((!j) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.l != null) {
        return false;
      }
      if ((b.a(this.f)) && (a.a(this.g))) {
        return false;
      }
    }
    finally {}
    this.l = paramgz;
    notifyAll();
    this.d.b(this.c);
    return true;
  }
  
  private void f()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  final void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public final void a(gz paramgz)
    throws IOException
  {
    if (!d(paramgz)) {
      return;
    }
    this.d.b(this.c, paramgz);
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	com/indooratlas/android/sdk/_internal/hd:l	Lcom/indooratlas/android/sdk/_internal/gz;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 90	com/indooratlas/android/sdk/_internal/hd:f	Lcom/indooratlas/android/sdk/_internal/hd$b;
    //   21: invokestatic 120	com/indooratlas/android/sdk/_internal/hd$b:a	(Lcom/indooratlas/android/sdk/_internal/hd$b;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 90	com/indooratlas/android/sdk/_internal/hd:f	Lcom/indooratlas/android/sdk/_internal/hd$b;
    //   31: invokestatic 144	com/indooratlas/android/sdk/_internal/hd$b:b	(Lcom/indooratlas/android/sdk/_internal/hd$b;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 93	com/indooratlas/android/sdk/_internal/hd:g	Lcom/indooratlas/android/sdk/_internal/hd$a;
    //   41: invokestatic 123	com/indooratlas/android/sdk/_internal/hd$a:a	(Lcom/indooratlas/android/sdk/_internal/hd$a;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 93	com/indooratlas/android/sdk/_internal/hd:g	Lcom/indooratlas/android/sdk/_internal/hd$a;
    //   51: invokestatic 146	com/indooratlas/android/sdk/_internal/hd$a:b	(Lcom/indooratlas/android/sdk/_internal/hd$a;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 180	com/indooratlas/android/sdk/_internal/hd:e	Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	hd
    //   1	67	1	bool	boolean
    //   8	55	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public final void b(gz paramgz)
  {
    if (!d(paramgz)) {
      return;
    }
    this.d.a(this.c, paramgz);
  }
  
  public final boolean b()
  {
    if ((this.c & 0x1) == 1) {}
    for (int m = 1; this.d.b == m; m = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public final List<he> c()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/indooratlas/android/sdk/_internal/hd:h	Lcom/indooratlas/android/sdk/_internal/hd$c;
    //   6: invokevirtual 188	com/indooratlas/android/sdk/_internal/hd$c:a_	()V
    //   9: aload_0
    //   10: getfield 180	com/indooratlas/android/sdk/_internal/hd:e	Ljava/util/List;
    //   13: ifnonnull +32 -> 45
    //   16: aload_0
    //   17: getfield 58	com/indooratlas/android/sdk/_internal/hd:l	Lcom/indooratlas/android/sdk/_internal/gz;
    //   20: ifnonnull +25 -> 45
    //   23: aload_0
    //   24: invokespecial 133	com/indooratlas/android/sdk/_internal/hd:f	()V
    //   27: goto -18 -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 54	com/indooratlas/android/sdk/_internal/hd:h	Lcom/indooratlas/android/sdk/_internal/hd$c;
    //   35: invokevirtual 190	com/indooratlas/android/sdk/_internal/hd$c:b	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield 54	com/indooratlas/android/sdk/_internal/hd:h	Lcom/indooratlas/android/sdk/_internal/hd$c;
    //   49: invokevirtual 190	com/indooratlas/android/sdk/_internal/hd$c:b	()V
    //   52: aload_0
    //   53: getfield 180	com/indooratlas/android/sdk/_internal/hd:e	Ljava/util/List;
    //   56: ifnull +12 -> 68
    //   59: aload_0
    //   60: getfield 180	com/indooratlas/android/sdk/_internal/hd:e	Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 142	java/io/IOException
    //   71: dup
    //   72: new 161	java/lang/StringBuilder
    //   75: dup
    //   76: ldc -93
    //   78: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 58	com/indooratlas/android/sdk/_internal/hd:l	Lcom/indooratlas/android/sdk/_internal/gz;
    //   85: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	hd
    //   30	9	1	localObject1	Object
    //   40	4	1	localObject2	Object
    //   63	4	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   2	9	40	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	95	40	finally
  }
  
  final void c(gz paramgz)
  {
    try
    {
      if (this.l == null)
      {
        this.l = paramgz;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramgz = finally;
      throw paramgz;
    }
  }
  
  public final jc d()
  {
    try
    {
      if ((this.e == null) && (!b())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.g;
  }
  
  final void e()
  {
    if ((!j) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      b.a(this.f, true);
      boolean bool = a();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  final class a
    implements jc
  {
    private final in c = new in();
    private boolean d;
    private boolean e;
    
    static
    {
      if (!hd.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    a() {}
    
    /* Error */
    private void a(boolean paramBoolean)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   13: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   16: invokevirtual 50	com/indooratlas/android/sdk/_internal/hd$c:a_	()V
      //   19: aload_0
      //   20: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   23: getfield 53	com/indooratlas/android/sdk/_internal/hd:b	J
      //   26: lconst_0
      //   27: lcmp
      //   28: ifgt +60 -> 88
      //   31: aload_0
      //   32: getfield 55	com/indooratlas/android/sdk/_internal/hd$a:e	Z
      //   35: ifne +53 -> 88
      //   38: aload_0
      //   39: getfield 57	com/indooratlas/android/sdk/_internal/hd$a:d	Z
      //   42: ifne +46 -> 88
      //   45: aload_0
      //   46: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   49: invokestatic 60	com/indooratlas/android/sdk/_internal/hd:d	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/gz;
      //   52: ifnonnull +36 -> 88
      //   55: aload_0
      //   56: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   59: invokestatic 62	com/indooratlas/android/sdk/_internal/hd:e	(Lcom/indooratlas/android/sdk/_internal/hd;)V
      //   62: goto -43 -> 19
      //   65: astore 6
      //   67: aload_0
      //   68: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   71: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   74: invokevirtual 64	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   77: aload 6
      //   79: athrow
      //   80: astore 6
      //   82: aload 5
      //   84: monitorexit
      //   85: aload 6
      //   87: athrow
      //   88: aload_0
      //   89: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   92: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   95: invokevirtual 64	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   98: aload_0
      //   99: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   102: invokestatic 67	com/indooratlas/android/sdk/_internal/hd:h	(Lcom/indooratlas/android/sdk/_internal/hd;)V
      //   105: aload_0
      //   106: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   109: getfield 53	com/indooratlas/android/sdk/_internal/hd:b	J
      //   112: aload_0
      //   113: getfield 38	com/indooratlas/android/sdk/_internal/hd$a:c	Lcom/indooratlas/android/sdk/_internal/in;
      //   116: getfield 68	com/indooratlas/android/sdk/_internal/in:b	J
      //   119: invokestatic 74	java/lang/Math:min	(JJ)J
      //   122: lstore_3
      //   123: aload_0
      //   124: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   127: astore 6
      //   129: aload 6
      //   131: aload 6
      //   133: getfield 53	com/indooratlas/android/sdk/_internal/hd:b	J
      //   136: lload_3
      //   137: lsub
      //   138: putfield 53	com/indooratlas/android/sdk/_internal/hd:b	J
      //   141: aload 5
      //   143: monitorexit
      //   144: aload_0
      //   145: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   148: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   151: invokevirtual 50	com/indooratlas/android/sdk/_internal/hd$c:a_	()V
      //   154: aload_0
      //   155: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   158: invokestatic 77	com/indooratlas/android/sdk/_internal/hd:a	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hc;
      //   161: astore 5
      //   163: aload_0
      //   164: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   167: invokestatic 80	com/indooratlas/android/sdk/_internal/hd:b	(Lcom/indooratlas/android/sdk/_internal/hd;)I
      //   170: istore_2
      //   171: iload_1
      //   172: ifeq +40 -> 212
      //   175: lload_3
      //   176: aload_0
      //   177: getfield 38	com/indooratlas/android/sdk/_internal/hd$a:c	Lcom/indooratlas/android/sdk/_internal/in;
      //   180: getfield 68	com/indooratlas/android/sdk/_internal/in:b	J
      //   183: lcmp
      //   184: ifne +28 -> 212
      //   187: iconst_1
      //   188: istore_1
      //   189: aload 5
      //   191: iload_2
      //   192: iload_1
      //   193: aload_0
      //   194: getfield 38	com/indooratlas/android/sdk/_internal/hd$a:c	Lcom/indooratlas/android/sdk/_internal/in;
      //   197: lload_3
      //   198: invokevirtual 85	com/indooratlas/android/sdk/_internal/hc:a	(IZLcom/indooratlas/android/sdk/_internal/in;J)V
      //   201: aload_0
      //   202: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   205: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   208: invokevirtual 64	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   211: return
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -25 -> 189
      //   217: astore 5
      //   219: aload_0
      //   220: getfield 31	com/indooratlas/android/sdk/_internal/hd$a:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   223: invokestatic 45	com/indooratlas/android/sdk/_internal/hd:g	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   226: invokevirtual 64	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   229: aload 5
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	a
      //   0	232	1	paramBoolean	boolean
      //   170	22	2	i	int
      //   122	76	3	l	long
      //   4	186	5	localObject1	Object
      //   217	13	5	localObject2	Object
      //   65	13	6	localObject3	Object
      //   80	6	6	localObject4	Object
      //   127	5	6	localhd	hd
      // Exception table:
      //   from	to	target	type
      //   19	62	65	finally
      //   9	19	80	finally
      //   67	80	80	finally
      //   82	85	80	finally
      //   88	144	80	finally
      //   154	171	217	finally
      //   175	187	217	finally
      //   189	201	217	finally
    }
    
    public final je a()
    {
      return hd.g(hd.this);
    }
    
    public final void a_(in paramin, long paramLong)
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(hd.this))) {
        throw new AssertionError();
      }
      this.c.a_(paramin, paramLong);
      while (this.c.b >= 16384L) {
        a(false);
      }
    }
    
    public final void close()
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(hd.this))) {
        throw new AssertionError();
      }
      synchronized (hd.this)
      {
        if (this.d) {
          return;
        }
        if (hd.this.g.e) {
          break label113;
        }
        if (this.c.b > 0L)
        {
          if (this.c.b <= 0L) {
            break label113;
          }
          a(true);
        }
      }
      hd.a(hd.this).a(hd.b(hd.this), true, null, 0L);
      label113:
      synchronized (hd.this)
      {
        this.d = true;
        hd.a(hd.this).b();
        hd.f(hd.this);
        return;
      }
    }
    
    public final void flush()
      throws IOException
    {
      if ((!a) && (Thread.holdsLock(hd.this))) {
        throw new AssertionError();
      }
      synchronized (hd.this)
      {
        hd.h(hd.this);
        if (this.c.b > 0L)
        {
          a(false);
          hd.a(hd.this).b();
        }
      }
    }
  }
  
  final class b
    implements jd
  {
    private final in c = new in();
    private final in d = new in();
    private final long e;
    private boolean f;
    private boolean g;
    
    static
    {
      if (!hd.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    private b(long paramLong)
    {
      this.e = paramLong;
    }
    
    /* Error */
    private void b()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	com/indooratlas/android/sdk/_internal/hd$b:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   4: invokestatic 57	com/indooratlas/android/sdk/_internal/hd:c	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   7: invokevirtual 62	com/indooratlas/android/sdk/_internal/hd$c:a_	()V
      //   10: aload_0
      //   11: getfield 43	com/indooratlas/android/sdk/_internal/hd$b:d	Lcom/indooratlas/android/sdk/_internal/in;
      //   14: getfield 64	com/indooratlas/android/sdk/_internal/in:b	J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +50 -> 69
      //   22: aload_0
      //   23: getfield 51	com/indooratlas/android/sdk/_internal/hd$b:g	Z
      //   26: ifne +43 -> 69
      //   29: aload_0
      //   30: getfield 66	com/indooratlas/android/sdk/_internal/hd$b:f	Z
      //   33: ifne +36 -> 69
      //   36: aload_0
      //   37: getfield 34	com/indooratlas/android/sdk/_internal/hd$b:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   40: invokestatic 69	com/indooratlas/android/sdk/_internal/hd:d	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/gz;
      //   43: ifnonnull +26 -> 69
      //   46: aload_0
      //   47: getfield 34	com/indooratlas/android/sdk/_internal/hd$b:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   50: invokestatic 72	com/indooratlas/android/sdk/_internal/hd:e	(Lcom/indooratlas/android/sdk/_internal/hd;)V
      //   53: goto -43 -> 10
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 34	com/indooratlas/android/sdk/_internal/hd$b:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   61: invokestatic 57	com/indooratlas/android/sdk/_internal/hd:c	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   64: invokevirtual 74	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   67: aload_1
      //   68: athrow
      //   69: aload_0
      //   70: getfield 34	com/indooratlas/android/sdk/_internal/hd$b:b	Lcom/indooratlas/android/sdk/_internal/hd;
      //   73: invokestatic 57	com/indooratlas/android/sdk/_internal/hd:c	(Lcom/indooratlas/android/sdk/_internal/hd;)Lcom/indooratlas/android/sdk/_internal/hd$c;
      //   76: invokevirtual 74	com/indooratlas/android/sdk/_internal/hd$c:b	()V
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	b
      //   56	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	53	56	finally
    }
    
    public final long a(in arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (hd.this)
      {
        b();
        if (this.f) {
          throw new IOException("stream closed");
        }
      }
      if (hd.d(hd.this) != null) {
        throw new IOException("stream was reset: " + hd.d(hd.this));
      }
      if (this.d.b == 0L) {
        return -1L;
      }
      paramLong = this.d.a(???, Math.min(paramLong, this.d.b));
      ??? = hd.this;
      ???.a += paramLong;
      if (hd.this.a >= hd.a(hd.this).e.b() / 2)
      {
        hd.a(hd.this).a(hd.b(hd.this), hd.this.a);
        hd.this.a = 0L;
      }
      synchronized (hd.a(hd.this))
      {
        ??? = hd.a(hd.this);
        ((hc)???).c += paramLong;
        if (hd.a(hd.this).c >= hd.a(hd.this).e.b() / 2)
        {
          hd.a(hd.this).a(0, hd.a(hd.this).c);
          hd.a(hd.this).c = 0L;
        }
        return paramLong;
      }
    }
    
    public final je a()
    {
      return hd.c(hd.this);
    }
    
    final void a(ip paramip, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!a)
      {
        l = paramLong;
        if (Thread.holdsLock(hd.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (hd.this)
        {
          if (this.d.b == 0L)
          {
            i = 1;
            this.d.a(this.c);
            if (i != 0) {
              hd.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (hd.this)
            {
              bool = this.g;
              if (this.d.b + l > this.e)
              {
                i = 1;
                if (i != 0)
                {
                  paramip.f(l);
                  hd.this.b(gz.h);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramip.f(l);
              return;
            }
            paramLong = paramip.a(this.c, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public final void close()
      throws IOException
    {
      synchronized (hd.this)
      {
        this.f = true;
        this.d.o();
        hd.this.notifyAll();
        hd.f(hd.this);
        return;
      }
    }
  }
  
  final class c
    extends il
  {
    c() {}
    
    protected final IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected final void a()
    {
      hd.this.b(gz.l);
    }
    
    public final void b()
      throws IOException
    {
      if (b_()) {
        throw a(null);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */