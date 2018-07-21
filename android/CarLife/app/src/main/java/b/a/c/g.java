package b.a.c;

import b.a.f.b;
import b.a.f.o;
import b.af;
import b.k;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

public final class g
{
  public final b.a a;
  private af c;
  private final k d;
  private final Object e;
  private final f f;
  private int g;
  private c h;
  private boolean i;
  private boolean j;
  private b.a.d.c k;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public g(k paramk, b.a parama, Object paramObject)
  {
    this.d = paramk;
    this.a = parama;
    this.f = new f(parama, g());
    this.e = paramObject;
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException
  {
    synchronized (this.d)
    {
      if (this.i) {
        throw new IllegalStateException("released");
      }
    }
    if (this.k != null) {
      throw new IllegalStateException("codec != null");
    }
    if (this.j) {
      throw new IOException("Canceled");
    }
    ??? = this.h;
    if ((??? != null) && (!((c)???).h)) {
      return (c)???;
    }
    ??? = b.a.a.a.a(this.d, this.a, this);
    if (??? != null)
    {
      this.h = ((c)???);
      return (c)???;
    }
    ??? = this.c;
    ??? = ???;
    if (??? == null) {
      ??? = this.f.b();
    }
    synchronized (this.d)
    {
      this.c = ((af)???);
      this.g = 0;
      ??? = new c((af)???);
      synchronized (this.d)
      {
        a((c)???);
        b.a.a.a.b(this.d, (c)???);
        this.h = ((c)???);
        if (this.j) {
          throw new IOException("Canceled");
        }
      }
    }
    localc.a(paramInt1, paramInt2, paramInt3, this.a.f(), paramBoolean);
    g().b(localc.a());
    return localc;
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    for (;;)
    {
      c localc1 = a(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.d)
      {
        if (localc1.c == 0) {
          return localc1;
        }
        if (!localc1.a(paramBoolean2)) {
          d();
        }
      }
    }
    return localc2;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    k localk = this.d;
    if (paramBoolean3) {}
    try
    {
      this.k = null;
      if (paramBoolean2) {
        this.i = true;
      }
      Object localObject1 = localObject4;
      if (this.h != null)
      {
        if (paramBoolean1) {
          this.h.h = true;
        }
        localObject1 = localObject4;
        if (this.k == null) {
          if (!this.i)
          {
            localObject1 = localObject4;
            if (!this.h.h) {}
          }
          else
          {
            b(this.h);
            localObject1 = localObject3;
            if (this.h.g.isEmpty())
            {
              this.h.i = System.nanoTime();
              localObject1 = localObject3;
              if (b.a.a.a.a(this.d, this.h)) {
                localObject1 = this.h;
              }
            }
            this.h = null;
          }
        }
      }
      if (localObject1 != null) {
        b.a.c.a(((c)localObject1).b());
      }
      return;
    }
    finally {}
  }
  
  private void b(c paramc)
  {
    int m = 0;
    int n = paramc.g.size();
    while (m < n)
    {
      if (((Reference)paramc.g.get(m)).get() == this)
      {
        paramc.g.remove(m);
        return;
      }
      m += 1;
    }
    throw new IllegalStateException();
  }
  
  private d g()
  {
    return b.a.a.a.a(this.d);
  }
  
  public b.a.d.c a()
  {
    synchronized (this.d)
    {
      b.a.d.c localc = this.k;
      return localc;
    }
  }
  
  /* Error */
  public b.a.d.c a(b.y paramy, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 190	b/y:a	()I
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual 192	b/y:b	()I
    //   9: istore 4
    //   11: aload_1
    //   12: invokevirtual 194	b/y:c	()I
    //   15: istore 5
    //   17: aload_1
    //   18: invokevirtual 197	b/y:t	()Z
    //   21: istore 6
    //   23: aload_0
    //   24: iload_3
    //   25: iload 4
    //   27: iload 5
    //   29: iload 6
    //   31: iload_2
    //   32: invokespecial 199	b/a/c/g:a	(IIIZZ)Lb/a/c/c;
    //   35: astore 7
    //   37: aload 7
    //   39: getfield 202	b/a/c/c:b	Lb/a/f/g;
    //   42: ifnull +37 -> 79
    //   45: new 204	b/a/f/f
    //   48: dup
    //   49: aload_1
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 202	b/a/c/c:b	Lb/a/f/g;
    //   56: invokespecial 207	b/a/f/f:<init>	(Lb/y;Lb/a/c/g;Lb/a/f/g;)V
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 43	b/a/c/g:d	Lb/k;
    //   64: astore 7
    //   66: aload 7
    //   68: monitorenter
    //   69: aload_0
    //   70: aload_1
    //   71: putfield 71	b/a/c/g:k	Lb/a/d/c;
    //   74: aload 7
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload 7
    //   81: invokevirtual 159	b/a/c/c:b	()Ljava/net/Socket;
    //   84: iload 4
    //   86: invokevirtual 213	java/net/Socket:setSoTimeout	(I)V
    //   89: aload 7
    //   91: getfield 216	b/a/c/c:d	Lokio/BufferedSource;
    //   94: invokeinterface 222 1 0
    //   99: iload 4
    //   101: i2l
    //   102: getstatic 228	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   105: invokevirtual 233	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   108: pop
    //   109: aload 7
    //   111: getfield 236	b/a/c/c:e	Lokio/BufferedSink;
    //   114: invokeinterface 239 1 0
    //   119: iload 5
    //   121: i2l
    //   122: getstatic 228	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   125: invokevirtual 233	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   128: pop
    //   129: new 241	b/a/e/a
    //   132: dup
    //   133: aload_1
    //   134: aload_0
    //   135: aload 7
    //   137: getfield 216	b/a/c/c:d	Lokio/BufferedSource;
    //   140: aload 7
    //   142: getfield 236	b/a/c/c:e	Lokio/BufferedSink;
    //   145: invokespecial 244	b/a/e/a:<init>	(Lb/y;Lb/a/c/g;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   148: astore_1
    //   149: goto -89 -> 60
    //   152: astore_1
    //   153: aload 7
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: new 246	b/a/c/e
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 249	b/a/c/e:<init>	(Ljava/io/IOException;)V
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	g
    //   0	168	1	paramy	b.y
    //   0	168	2	paramBoolean	boolean
    //   4	21	3	m	int
    //   9	91	4	n	int
    //   15	105	5	i1	int
    //   21	9	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   69	77	152	finally
    //   153	156	152	finally
    //   23	60	158	java/io/IOException
    //   60	69	158	java/io/IOException
    //   79	149	158	java/io/IOException
    //   156	158	158	java/io/IOException
  }
  
  public void a(c paramc)
  {
    if ((!b) && (!Thread.holdsLock(this.d))) {
      throw new AssertionError();
    }
    paramc.g.add(new a(this, this.e));
  }
  
  public void a(IOException paramIOException)
  {
    boolean bool1 = false;
    synchronized (this.d)
    {
      if ((paramIOException instanceof o))
      {
        paramIOException = (o)paramIOException;
        if (paramIOException.a == b.e) {
          this.g += 1;
        }
        if ((paramIOException.a != b.e) || (this.g > 1))
        {
          bool1 = true;
          this.c = null;
        }
      }
      boolean bool2;
      do
      {
        do
        {
          a(bool1, false, true);
          return;
        } while (((this.h == null) || (this.h.f())) && (!(paramIOException instanceof b.a.f.a)));
        bool2 = true;
        bool1 = bool2;
      } while (this.h.c != 0);
      if ((this.c != null) && (paramIOException != null)) {
        this.f.a(this.c, paramIOException);
      }
      this.c = null;
      bool1 = bool2;
    }
  }
  
  public void a(boolean paramBoolean, b.a.d.c paramc)
  {
    k localk = this.d;
    if (paramc != null) {}
    try
    {
      if (paramc != this.k) {
        throw new IllegalStateException("expected " + this.k + " but was " + paramc);
      }
    }
    finally
    {
      throw paramc;
      if (!paramBoolean)
      {
        paramc = this.h;
        paramc.c += 1;
      }
    }
  }
  
  public c b()
  {
    try
    {
      c localc = this.h;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c()
  {
    a(false, true, false);
  }
  
  public void d()
  {
    a(true, false, false);
  }
  
  public void e()
  {
    c localc1;
    do
    {
      synchronized (this.d)
      {
        this.j = true;
        b.a.d.c localc = this.k;
        localc1 = this.h;
        if (localc != null)
        {
          localc.c();
          return;
        }
      }
    } while (localc1 == null);
    localc1.e();
  }
  
  public boolean f()
  {
    return (this.c != null) || (this.f.a());
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<g>
  {
    public final Object a;
    
    a(g paramg, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */