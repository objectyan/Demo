package b.a.f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class i
{
  long a = 0L;
  long b;
  final int c;
  final g d;
  final a e;
  final c f = new c();
  final c g = new c();
  b h = null;
  private final List<c> j;
  private List<c> k;
  private final b l;
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  i(int paramInt, g paramg, boolean paramBoolean1, boolean paramBoolean2, List<c> paramList)
  {
    if (paramg == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.c = paramInt;
    this.d = paramg;
    this.b = paramg.m.d();
    this.l = new b(paramg.l.d());
    this.e = new a();
    this.l.b = paramBoolean2;
    this.e.b = paramBoolean1;
    this.j = paramList;
  }
  
  private boolean d(b paramb)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.h != null) {
        return false;
      }
      if ((this.l.b) && (this.e.b)) {
        return false;
      }
    }
    finally {}
    this.h = paramb;
    notifyAll();
    this.d.b(this.c);
    return true;
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(b paramb)
    throws IOException
  {
    if (!d(paramb)) {
      return;
    }
    this.d.b(this.c, paramb);
  }
  
  /* Error */
  void a(List<c> paramList)
  {
    // Byte code:
    //   0: getstatic 42	b/a/f/i:i	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 108	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 110	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 111	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 130	b/a/f/i:k	Ljava/util/List;
    //   29: ifnonnull +36 -> 65
    //   32: aload_0
    //   33: aload_1
    //   34: putfield 130	b/a/f/i:k	Ljava/util/List;
    //   37: aload_0
    //   38: invokevirtual 132	b/a/f/i:b	()Z
    //   41: istore_2
    //   42: aload_0
    //   43: invokevirtual 114	java/lang/Object:notifyAll	()V
    //   46: aload_0
    //   47: monitorexit
    //   48: iload_2
    //   49: ifne +15 -> 64
    //   52: aload_0
    //   53: getfield 71	b/a/f/i:d	Lb/a/f/g;
    //   56: aload_0
    //   57: getfield 69	b/a/f/i:c	I
    //   60: invokevirtual 117	b/a/f/g:b	(I)Lb/a/f/i;
    //   63: pop
    //   64: return
    //   65: new 134	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 135	java/util/ArrayList:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: aload_0
    //   75: getfield 130	b/a/f/i:k	Ljava/util/List;
    //   78: invokeinterface 141 2 0
    //   83: pop
    //   84: aload_3
    //   85: aload_1
    //   86: invokeinterface 141 2 0
    //   91: pop
    //   92: aload_0
    //   93: aload_3
    //   94: putfield 130	b/a/f/i:k	Ljava/util/List;
    //   97: goto -51 -> 46
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	i
    //   0	105	1	paramList	List<c>
    //   22	27	2	bool	boolean
    //   72	22	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   25	46	100	finally
    //   46	48	100	finally
    //   65	97	100	finally
    //   101	103	100	finally
  }
  
  public void a(List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    boolean bool = false;
    if (paramList == null) {
      try
      {
        throw new NullPointerException("responseHeaders == null");
      }
      finally {}
    }
    if (this.k != null) {
      throw new IllegalStateException("reply already sent");
    }
    this.k = paramList;
    if (!paramBoolean)
    {
      this.e.b = true;
      bool = true;
    }
    this.d.a(this.c, bool, paramList);
    if (bool) {
      this.d.e();
    }
  }
  
  void a(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.l.a(paramBufferedSource, paramInt);
  }
  
  public void b(b paramb)
  {
    if (!d(paramb)) {
      return;
    }
    this.d.a(this.c, paramb);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	b/a/f/i:h	Lb/a/f/b;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 91	b/a/f/i:l	Lb/a/f/i$b;
    //   21: getfield 96	b/a/f/i$b:b	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 91	b/a/f/i:l	Lb/a/f/i$b;
    //   31: getfield 164	b/a/f/i$b:a	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 94	b/a/f/i:e	Lb/a/f/i$a;
    //   41: getfield 97	b/a/f/i$a:b	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 94	b/a/f/i:e	Lb/a/f/i$a;
    //   51: getfield 165	b/a/f/i$a:a	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 130	b/a/f/i:k	Ljava/util/List;
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
    //   0	76	0	this	i
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
  
  void c(b paramb)
  {
    try
    {
      if (this.h == null)
      {
        this.h = paramb;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public boolean c()
  {
    if ((this.c & 0x1) == 1) {}
    for (int m = 1; this.d.b == m; m = 0) {
      return true;
    }
    return false;
  }
  
  public g d()
  {
    return this.d;
  }
  
  public List<c> e()
  {
    return this.j;
  }
  
  /* Error */
  public List<c> f()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	b/a/f/i:f	Lb/a/f/i$c;
    //   6: invokevirtual 172	b/a/f/i$c:enter	()V
    //   9: aload_0
    //   10: getfield 130	b/a/f/i:k	Ljava/util/List;
    //   13: ifnonnull +32 -> 45
    //   16: aload_0
    //   17: getfield 58	b/a/f/i:h	Lb/a/f/b;
    //   20: ifnonnull +25 -> 45
    //   23: aload_0
    //   24: invokevirtual 175	b/a/f/i:o	()V
    //   27: goto -18 -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 54	b/a/f/i:f	Lb/a/f/i$c;
    //   35: invokevirtual 177	b/a/f/i$c:a	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield 54	b/a/f/i:f	Lb/a/f/i$c;
    //   49: invokevirtual 177	b/a/f/i$c:a	()V
    //   52: aload_0
    //   53: getfield 130	b/a/f/i:k	Ljava/util/List;
    //   56: ifnull +12 -> 68
    //   59: aload_0
    //   60: getfield 130	b/a/f/i:k	Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 179	b/a/f/o
    //   71: dup
    //   72: aload_0
    //   73: getfield 58	b/a/f/i:h	Lb/a/f/b;
    //   76: invokespecial 181	b/a/f/o:<init>	(Lb/a/f/b;)V
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	i
    //   30	9	1	localObject1	Object
    //   40	4	1	localObject2	Object
    //   63	4	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   2	9	40	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	80	40	finally
  }
  
  public b g()
  {
    try
    {
      b localb = this.h;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Timeout h()
  {
    return this.f;
  }
  
  public Timeout i()
  {
    return this.g;
  }
  
  public Source j()
  {
    return this.l;
  }
  
  public Sink k()
  {
    try
    {
      if ((this.k == null) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.e;
  }
  
  void l()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.l.b = true;
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  void m()
    throws IOException
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.l.b) && (this.l.a))
        {
          if (this.e.b) {
            break label112;
          }
          if (this.e.a)
          {
            break label112;
            bool = b();
            if (m == 0) {
              break label95;
            }
            a(b.f);
            return;
          }
        }
        m = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.d.b(this.c);
      return;
      label112:
      int m = 1;
    }
  }
  
  void n()
    throws IOException
  {
    if (this.e.a) {
      throw new IOException("stream closed");
    }
    if (this.e.b) {
      throw new IOException("stream finished");
    }
    if (this.h != null) {
      throw new o(this.h);
    }
  }
  
  void o()
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
  
  final class a
    implements Sink
  {
    private static final long e = 16384L;
    boolean a;
    boolean b;
    private final Buffer f = new Buffer();
    
    static
    {
      if (!i.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        c = bool;
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
      //   1: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   13: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   16: invokevirtual 54	b/a/f/i$c:enter	()V
      //   19: aload_0
      //   20: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   23: getfield 56	b/a/f/i:b	J
      //   26: lconst_0
      //   27: lcmp
      //   28: ifgt +60 -> 88
      //   31: aload_0
      //   32: getfield 58	b/a/f/i$a:b	Z
      //   35: ifne +53 -> 88
      //   38: aload_0
      //   39: getfield 60	b/a/f/i$a:a	Z
      //   42: ifne +46 -> 88
      //   45: aload_0
      //   46: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   49: getfield 64	b/a/f/i:h	Lb/a/f/b;
      //   52: ifnonnull +36 -> 88
      //   55: aload_0
      //   56: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   59: invokevirtual 67	b/a/f/i:o	()V
      //   62: goto -43 -> 19
      //   65: astore 6
      //   67: aload_0
      //   68: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   71: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   74: invokevirtual 69	b/a/f/i$c:a	()V
      //   77: aload 6
      //   79: athrow
      //   80: astore 6
      //   82: aload 5
      //   84: monitorexit
      //   85: aload 6
      //   87: athrow
      //   88: aload_0
      //   89: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   92: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   95: invokevirtual 69	b/a/f/i$c:a	()V
      //   98: aload_0
      //   99: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   102: invokevirtual 72	b/a/f/i:n	()V
      //   105: aload_0
      //   106: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   109: getfield 56	b/a/f/i:b	J
      //   112: aload_0
      //   113: getfield 42	b/a/f/i$a:f	Lokio/Buffer;
      //   116: invokevirtual 76	okio/Buffer:size	()J
      //   119: invokestatic 82	java/lang/Math:min	(JJ)J
      //   122: lstore_3
      //   123: aload_0
      //   124: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   127: astore 6
      //   129: aload 6
      //   131: aload 6
      //   133: getfield 56	b/a/f/i:b	J
      //   136: lload_3
      //   137: lsub
      //   138: putfield 56	b/a/f/i:b	J
      //   141: aload 5
      //   143: monitorexit
      //   144: aload_0
      //   145: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   148: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   151: invokevirtual 54	b/a/f/i$c:enter	()V
      //   154: aload_0
      //   155: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   158: getfield 85	b/a/f/i:d	Lb/a/f/g;
      //   161: astore 5
      //   163: aload_0
      //   164: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   167: getfield 88	b/a/f/i:c	I
      //   170: istore_2
      //   171: iload_1
      //   172: ifeq +40 -> 212
      //   175: lload_3
      //   176: aload_0
      //   177: getfield 42	b/a/f/i$a:f	Lokio/Buffer;
      //   180: invokevirtual 76	okio/Buffer:size	()J
      //   183: lcmp
      //   184: ifne +28 -> 212
      //   187: iconst_1
      //   188: istore_1
      //   189: aload 5
      //   191: iload_2
      //   192: iload_1
      //   193: aload_0
      //   194: getfield 42	b/a/f/i$a:f	Lokio/Buffer;
      //   197: lload_3
      //   198: invokevirtual 93	b/a/f/g:a	(IZLokio/Buffer;J)V
      //   201: aload_0
      //   202: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   205: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   208: invokevirtual 69	b/a/f/i$c:a	()V
      //   211: return
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -25 -> 189
      //   217: astore 5
      //   219: aload_0
      //   220: getfield 35	b/a/f/i$a:d	Lb/a/f/i;
      //   223: getfield 49	b/a/f/i:g	Lb/a/f/i$c;
      //   226: invokevirtual 69	b/a/f/i$c:a	()V
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
      //   127	5	6	locali	i
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
    
    public void close()
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      synchronized (i.this)
      {
        if (this.a) {
          return;
        }
        if (i.this.e.b) {
          break label113;
        }
        if (this.f.size() > 0L)
        {
          if (this.f.size() <= 0L) {
            break label113;
          }
          a(true);
        }
      }
      i.this.d.a(i.this.c, true, null, 0L);
      label113:
      synchronized (i.this)
      {
        this.a = true;
        i.this.d.e();
        i.this.m();
        return;
      }
    }
    
    public void flush()
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      synchronized (i.this)
      {
        i.this.n();
        if (this.f.size() > 0L)
        {
          a(false);
          i.this.d.e();
        }
      }
    }
    
    public Timeout timeout()
    {
      return i.this.g;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      this.f.write(paramBuffer, paramLong);
      while (this.f.size() >= 16384L) {
        a(false);
      }
    }
  }
  
  private final class b
    implements Source
  {
    boolean a;
    boolean b;
    private final Buffer e = new Buffer();
    private final Buffer f = new Buffer();
    private final long g;
    
    static
    {
      if (!i.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        return;
      }
    }
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    /* Error */
    private void a()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	b/a/f/i$b:d	Lb/a/f/i;
      //   4: getfield 50	b/a/f/i:f	Lb/a/f/i$c;
      //   7: invokevirtual 55	b/a/f/i$c:enter	()V
      //   10: aload_0
      //   11: getfield 43	b/a/f/i$b:f	Lokio/Buffer;
      //   14: invokevirtual 59	okio/Buffer:size	()J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +50 -> 69
      //   22: aload_0
      //   23: getfield 61	b/a/f/i$b:b	Z
      //   26: ifne +43 -> 69
      //   29: aload_0
      //   30: getfield 63	b/a/f/i$b:a	Z
      //   33: ifne +36 -> 69
      //   36: aload_0
      //   37: getfield 34	b/a/f/i$b:d	Lb/a/f/i;
      //   40: getfield 67	b/a/f/i:h	Lb/a/f/b;
      //   43: ifnonnull +26 -> 69
      //   46: aload_0
      //   47: getfield 34	b/a/f/i$b:d	Lb/a/f/i;
      //   50: invokevirtual 70	b/a/f/i:o	()V
      //   53: goto -43 -> 10
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 34	b/a/f/i$b:d	Lb/a/f/i;
      //   61: getfield 50	b/a/f/i:f	Lb/a/f/i$c;
      //   64: invokevirtual 72	b/a/f/i$c:a	()V
      //   67: aload_1
      //   68: athrow
      //   69: aload_0
      //   70: getfield 34	b/a/f/i$b:d	Lb/a/f/i;
      //   73: getfield 50	b/a/f/i:f	Lb/a/f/i$c;
      //   76: invokevirtual 72	b/a/f/i$c:a	()V
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	b
      //   56	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	53	56	finally
    }
    
    private void b()
      throws IOException
    {
      if (this.a) {
        throw new IOException("stream closed");
      }
      if (i.this.h != null) {
        throw new o(i.this.h);
      }
    }
    
    void a(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!c)
      {
        l = paramLong;
        if (Thread.holdsLock(i.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (i.this)
        {
          if (this.f.size() == 0L)
          {
            i = 1;
            this.f.writeAll(this.e);
            if (i != 0) {
              i.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (i.this)
            {
              bool = this.b;
              if (this.f.size() + l > this.g)
              {
                i = 1;
                if (i != 0)
                {
                  paramBufferedSource.skip(l);
                  i.this.b(b.d);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramBufferedSource.skip(l);
              return;
            }
            paramLong = paramBufferedSource.read(this.e, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public void close()
      throws IOException
    {
      synchronized (i.this)
      {
        this.a = true;
        this.f.clear();
        i.this.notifyAll();
        i.this.m();
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (i.this)
      {
        a();
        b();
        if (this.f.size() == 0L) {
          return -1L;
        }
        paramLong = this.f.read(???, Math.min(paramLong, this.f.size()));
        ??? = i.this;
        ???.a += paramLong;
        if (i.this.a >= i.this.d.l.d() / 2)
        {
          i.this.d.a(i.this.c, i.this.a);
          i.this.a = 0L;
        }
        synchronized (i.this.d)
        {
          ??? = i.this.d;
          ((g)???).j += paramLong;
          if (i.this.d.j >= i.this.d.l.d() / 2)
          {
            i.this.d.a(0, i.this.d.j);
            i.this.d.j = 0L;
          }
          return paramLong;
        }
      }
    }
    
    public Timeout timeout()
    {
      return i.this.f;
    }
  }
  
  class c
    extends AsyncTimeout
  {
    c() {}
    
    public void a()
      throws IOException
    {
      if (exit()) {
        throw newTimeoutException(null);
      }
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void timedOut()
    {
      i.this.b(b.f);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */