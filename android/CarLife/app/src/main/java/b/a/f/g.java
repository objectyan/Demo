package b.a.f;

import b.a.h.e;
import b.z;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class g
  implements Closeable
{
  static final ExecutorService a;
  private static final int w = 16777216;
  final boolean b;
  final b c;
  final Map<Integer, i> d = new LinkedHashMap();
  final String e;
  int f;
  int g;
  boolean h;
  final m i;
  long j = 0L;
  long k;
  n l = new n();
  final n m = new n();
  boolean n = false;
  final Socket o;
  final j p;
  final c q;
  final Set<Integer> r = new LinkedHashSet();
  private final ExecutorService t;
  private Map<Integer, l> u;
  private int v;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      s = bool;
      a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), b.a.c.a("OkHttp FramedConnection", true));
      return;
    }
  }
  
  g(a parama)
  {
    this.i = parama.f;
    this.b = parama.g;
    this.c = parama.e;
    if (parama.g) {}
    for (int i1 = 1;; i1 = 2)
    {
      this.g = i1;
      if (parama.g) {
        this.g += 2;
      }
      i1 = i2;
      if (parama.g) {
        i1 = 1;
      }
      this.v = i1;
      if (parama.g) {
        this.l.a(7, 16777216);
      }
      this.e = parama.b;
      this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a.c.a(b.a.c.a("OkHttp %s Push Observer", new Object[] { this.e }), true));
      this.m.a(7, 65535);
      this.m.a(5, 16384);
      this.k = this.m.d();
      this.o = parama.a;
      this.p = new j(parama.d, this.b);
      this.q = new c(new h(parama.c, this.b));
      return;
    }
  }
  
  private i c(int paramInt, List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false) {
      synchronized (this.p)
      {
        try
        {
          if (!this.h) {
            break;
          }
          throw new a();
        }
        finally {}
      }
    }
    int i2 = this.g;
    this.g += 2;
    i locali = new i(i2, this, bool, false, paramList);
    if ((paramBoolean) && (this.k != 0L)) {
      if (locali.b == 0L) {
        break label207;
      }
    }
    for (;;)
    {
      if (locali.b()) {
        this.d.put(Integer.valueOf(i2), locali);
      }
      if (paramInt == 0) {
        this.p.a(bool, i2, paramInt, paramList);
      }
      for (;;)
      {
        if (i1 != 0) {
          this.p.b();
        }
        return locali;
        i1 = 0;
        break;
        if (this.b) {
          throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        }
        this.p.a(paramInt, i2, paramList);
      }
      label207:
      int i1 = 1;
    }
  }
  
  i a(int paramInt)
  {
    try
    {
      i locali = (i)this.d.get(Integer.valueOf(paramInt));
      return locali;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public i a(int paramInt, List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.b) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    return c(paramInt, paramList, paramBoolean);
  }
  
  public i a(List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    return c(0, paramList, paramBoolean);
  }
  
  public z a()
  {
    return z.d;
  }
  
  void a(final int paramInt, final long paramLong)
  {
    a.execute(new b.a.b("OkHttp Window Update %s stream %d", new Object[] { this.e, Integer.valueOf(paramInt) })
    {
      public void d()
      {
        try
        {
          g.this.p.a(paramInt, paramLong);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void a(final int paramInt, final b paramb)
  {
    a.execute(new b.a.b("OkHttp %s stream %d", new Object[] { this.e, Integer.valueOf(paramInt) })
    {
      public void d()
      {
        try
        {
          g.this.b(paramInt, paramb);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void a(final int paramInt, final List<c> paramList)
  {
    try
    {
      if (this.r.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, b.b);
        return;
      }
      this.r.add(Integer.valueOf(paramInt));
      this.t.execute(new b.a.b("OkHttp %s Push Request[%s]", new Object[] { this.e, Integer.valueOf(paramInt) })
      {
        public void d()
        {
          if (g.this.i.a(paramInt, paramList)) {
            try
            {
              g.this.p.a(paramInt, b.f);
              synchronized (g.this)
              {
                g.this.r.remove(Integer.valueOf(paramInt));
                return;
              }
              return;
            }
            catch (IOException localIOException) {}
          }
        }
      });
      return;
    }
    finally {}
  }
  
  void a(final int paramInt1, BufferedSource paramBufferedSource, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2) {
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    }
    this.t.execute(new b.a.b("OkHttp %s Push Data[%s]", new Object[] { this.e, Integer.valueOf(paramInt1) })
    {
      public void d()
      {
        try
        {
          boolean bool = g.this.i.a(paramInt1, localBuffer, paramInt2, paramBoolean);
          if (bool) {
            g.this.p.a(paramInt1, b.f);
          }
          if ((bool) || (paramBoolean)) {
            synchronized (g.this)
            {
              g.this.r.remove(Integer.valueOf(paramInt1));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void a(int paramInt, boolean paramBoolean, List<c> paramList)
    throws IOException
  {
    this.p.a(paramBoolean, paramInt, paramList);
  }
  
  public void a(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.p.a(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.k), this.p.c());
        this.k -= i1;
        l1 -= i1;
        j localj = this.p;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label164;
        }
        bool = true;
        localj.a(bool, paramInt, paramBuffer, i1);
        if (l1 <= 0L) {
          break;
        }
        try
        {
          if (this.k > 0L) {
            continue;
          }
          if (!this.d.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramBuffer)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label164:
      boolean bool = false;
    }
  }
  
  void a(long paramLong)
  {
    this.k += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(b paramb)
    throws IOException
  {
    int i1;
    synchronized (this.p) {}
  }
  
  void a(b paramb1, b paramb2)
    throws IOException
  {
    if ((!s) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Object localObject = null;
    try
    {
      a(paramb1);
      paramb1 = (b)localObject;
    }
    catch (IOException paramb1)
    {
      i[] arrayOfi;
      for (;;) {}
    }
    arrayOfi = null;
    l[] arrayOfl = null;
    int i2;
    int i1;
    for (;;)
    {
      try
      {
        if (!this.d.isEmpty())
        {
          arrayOfi = (i[])this.d.values().toArray(new i[this.d.size()]);
          this.d.clear();
        }
        if (this.u != null)
        {
          arrayOfl = (l[])this.u.values().toArray(new l[this.u.size()]);
          this.u = null;
        }
        localObject = paramb1;
        if (arrayOfi == null) {
          break label211;
        }
        i2 = arrayOfi.length;
        i1 = 0;
        localObject = paramb1;
        if (i1 >= i2) {
          break label211;
        }
        localObject = arrayOfi[i1];
      }
      finally {}
      try
      {
        ((i)localObject).a(paramb2);
        localObject = paramb1;
      }
      catch (IOException localIOException)
      {
        localObject = paramb1;
        if (paramb1 == null) {
          continue;
        }
        localObject = localIOException;
        continue;
      }
      i1 += 1;
      paramb1 = (b)localObject;
    }
    label211:
    if (arrayOfl != null)
    {
      i2 = arrayOfl.length;
      i1 = 0;
      while (i1 < i2)
      {
        arrayOfl[i1].c();
        i1 += 1;
      }
    }
    try
    {
      this.p.close();
      paramb1 = (b)localObject;
      return;
    }
    catch (IOException paramb2)
    {
      try
      {
        for (;;)
        {
          this.o.close();
          if (paramb1 == null) {
            break;
          }
          throw paramb1;
          paramb2 = paramb2;
          paramb1 = (b)localObject;
          if (localObject == null) {
            paramb1 = paramb2;
          }
        }
      }
      catch (IOException paramb1)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(n paramn)
    throws IOException
  {
    synchronized (this.p)
    {
      try
      {
        if (this.h) {
          throw new a();
        }
      }
      finally {}
    }
    this.l.a(paramn);
    this.p.b(paramn);
  }
  
  void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.p.a();
      this.p.b(this.l);
      int i1 = this.l.d();
      if (i1 != 65535) {
        this.p.a(0, i1 - 65535);
      }
    }
    new Thread(this.q).start();
  }
  
  void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final l paraml)
  {
    a.execute(new b.a.b("OkHttp %s ping %08x%08x", new Object[] { this.e, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })
    {
      public void d()
      {
        try
        {
          g.this.b(paramBoolean, paramInt1, paramInt2, paraml);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public int b()
  {
    try
    {
      int i1 = this.d.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  i b(int paramInt)
  {
    try
    {
      i locali = (i)this.d.remove(Integer.valueOf(paramInt));
      notifyAll();
      return locali;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void b(int paramInt, b paramb)
    throws IOException
  {
    this.p.a(paramInt, paramb);
  }
  
  void b(final int paramInt, final List<c> paramList, final boolean paramBoolean)
  {
    this.t.execute(new b.a.b("OkHttp %s Push Headers[%s]", new Object[] { this.e, Integer.valueOf(paramInt) })
    {
      public void d()
      {
        boolean bool = g.this.i.a(paramInt, paramList, paramBoolean);
        if (bool) {}
        try
        {
          g.this.p.a(paramInt, b.f);
          if ((bool) || (paramBoolean)) {
            synchronized (g.this)
            {
              g.this.r.remove(Integer.valueOf(paramInt));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void b(boolean paramBoolean, int paramInt1, int paramInt2, l paraml)
    throws IOException
  {
    j localj = this.p;
    if (paraml != null) {}
    try
    {
      paraml.a();
      this.p.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  public int c()
  {
    try
    {
      int i1 = this.m.c(Integer.MAX_VALUE);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  l c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 431	b/a/f/g:u	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 431	b/a/f/g:u	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 468 2 0
    //   22: checkcast 433	b/a/f/l
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
    //   0	40	0	this	g
    //   0	40	1	paramInt	int
    //   25	7	2	locall	l
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  void c(final int paramInt, final b paramb)
  {
    this.t.execute(new b.a.b("OkHttp %s Push Reset[%s]", new Object[] { this.e, Integer.valueOf(paramInt) })
    {
      public void d()
      {
        g.this.i.a(paramInt, paramb);
        synchronized (g.this)
        {
          g.this.r.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  public void close()
    throws IOException
  {
    a(b.a, b.f);
  }
  
  public l d()
    throws IOException
  {
    l locall = new l();
    try
    {
      if (this.h) {
        throw new a();
      }
    }
    finally {}
    int i1 = this.v;
    this.v += 2;
    if (this.u == null) {
      this.u = new LinkedHashMap();
    }
    this.u.put(Integer.valueOf(i1), localObject);
    b(false, i1, 1330343787, (l)localObject);
    return (l)localObject;
  }
  
  boolean d(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public void e()
    throws IOException
  {
    this.p.b();
  }
  
  public void f()
    throws IOException
  {
    a(true);
  }
  
  public boolean g()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class a
  {
    Socket a;
    String b;
    BufferedSource c;
    BufferedSink d;
    g.b e = g.b.j;
    m f = m.a;
    boolean g;
    
    public a(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }
    
    public a a(g.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public a a(m paramm)
    {
      this.f = paramm;
      return this;
    }
    
    public a a(Socket paramSocket)
      throws IOException
    {
      return a(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
    }
    
    public a a(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.a = paramSocket;
      this.b = paramString;
      this.c = paramBufferedSource;
      this.d = paramBufferedSink;
      return this;
    }
    
    public g a()
      throws IOException
    {
      return new g(this);
    }
  }
  
  public static abstract class b
  {
    public static final b j = new b()
    {
      public void a(i paramAnonymousi)
        throws IOException
      {
        paramAnonymousi.a(b.e);
      }
    };
    
    public void a(g paramg) {}
    
    public abstract void a(i parami)
      throws IOException;
  }
  
  class c
    extends b.a.b
    implements h.b
  {
    final h a;
    
    c(h paramh)
    {
      super(new Object[] { g.this.e });
      this.a = paramh;
    }
    
    private void a(final n paramn)
    {
      g.a.execute(new b.a.b("OkHttp %s ACK Settings", new Object[] { g.this.e })
      {
        public void d()
        {
          try
          {
            g.this.p.a(paramn);
            return;
          }
          catch (IOException localIOException) {}
        }
      });
    }
    
    public void a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void a(int paramInt1, int paramInt2, List<c> paramList)
    {
      g.this.a(paramInt2, paramList);
    }
    
    public void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (g.this)
        {
          g localg = g.this;
          localg.k += paramLong;
          g.this.notifyAll();
          return;
        }
      }
      ??? = g.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((i)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public void a(int paramInt, b paramb)
    {
      if (g.this.d(paramInt)) {
        g.this.c(paramInt, paramb);
      }
      i locali;
      do
      {
        return;
        locali = g.this.b(paramInt);
      } while (locali == null);
      locali.c(paramb);
    }
    
    public void a(int paramInt, b arg2, ByteString paramByteString)
    {
      if (paramByteString.size() > 0) {}
      synchronized (g.this)
      {
        paramByteString = (i[])g.this.d.values().toArray(new i[g.this.d.size()]);
        g.this.h = true;
        int j = paramByteString.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramByteString[i];
          if ((???.a() > paramInt) && (???.c()))
          {
            ???.c(b.e);
            g.this.b(???.a());
          }
          i += 1;
        }
      }
    }
    
    public void a(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        l locall = g.this.c(paramInt1);
        if (locall != null) {
          locall.b();
        }
        return;
      }
      g.this.a(true, paramInt1, paramInt2, null);
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, final List<c> paramList)
    {
      if (g.this.d(paramInt1)) {
        g.this.b(paramInt1, paramList, paramBoolean);
      }
      i locali;
      do
      {
        return;
        synchronized (g.this)
        {
          if (g.this.h) {
            return;
          }
        }
        locali = g.this.a(paramInt1);
        if (locali == null)
        {
          if (paramInt1 <= g.this.f) {
            return;
          }
          if (paramInt1 % 2 == g.this.g % 2) {
            return;
          }
          paramList = new i(paramInt1, g.this, false, paramBoolean, paramList);
          g.this.f = paramInt1;
          g.this.d.put(Integer.valueOf(paramInt1), paramList);
          g.a.execute(new b.a.b("OkHttp %s stream %d", new Object[] { g.this.e, Integer.valueOf(paramInt1) })
          {
            public void d()
            {
              try
              {
                g.this.c.a(paramList);
                return;
              }
              catch (IOException localIOException1)
              {
                e.b().a(4, "FramedConnection.Listener failure for " + g.this.e, localIOException1);
                try
                {
                  paramList.a(b.b);
                  return;
                }
                catch (IOException localIOException2) {}
              }
            }
          });
          return;
        }
        locali.a(paramList);
      } while (!paramBoolean);
      locali.l();
    }
    
    public void a(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (g.this.d(paramInt1)) {
        g.this.a(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      }
      i locali;
      do
      {
        return;
        locali = g.this.a(paramInt1);
        if (locali == null)
        {
          g.this.a(paramInt1, b.b);
          paramBufferedSource.skip(paramInt2);
          return;
        }
        locali.a(paramBufferedSource, paramInt2);
      } while (!paramBoolean);
      locali.l();
    }
    
    public void a(boolean paramBoolean, n paramn)
    {
      long l2 = 0L;
      ??? = null;
      for (;;)
      {
        int i;
        long l1;
        synchronized (g.this)
        {
          i = g.this.m.d();
          if (paramBoolean) {
            g.this.m.a();
          }
          g.this.m.a(paramn);
          a(paramn);
          int j = g.this.m.d();
          l1 = l2;
          paramn = (n)???;
          if (j != -1)
          {
            l1 = l2;
            paramn = (n)???;
            if (j != i)
            {
              l2 = j - i;
              if (!g.this.n)
              {
                g.this.a(l2);
                g.this.n = true;
              }
              l1 = l2;
              paramn = (n)???;
              if (!g.this.d.isEmpty())
              {
                paramn = (i[])g.this.d.values().toArray(new i[g.this.d.size()]);
                l1 = l2;
              }
            }
          }
          g.a.execute(new b.a.b("OkHttp %s settings", new Object[] { g.this.e })
          {
            public void d()
            {
              g.this.c.a(g.this);
            }
          });
          if ((paramn == null) || (l1 == 0L)) {
            break;
          }
          j = paramn.length;
          i = 0;
          if (i >= j) {
            break;
          }
        }
        synchronized (paramn[i])
        {
          ((i)???).a(l1);
          i += 1;
          continue;
          paramn = finally;
          throw paramn;
        }
      }
    }
    
    /* Error */
    protected void d()
    {
      // Byte code:
      //   0: getstatic 222	b/a/f/b:c	Lb/a/f/b;
      //   3: astore_3
      //   4: getstatic 222	b/a/f/b:c	Lb/a/f/b;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 22	b/a/f/g$c:c	Lb/a/f/g;
      //   17: getfield 224	b/a/f/g:b	Z
      //   20: ifne +14 -> 34
      //   23: aload_3
      //   24: astore_2
      //   25: aload_3
      //   26: astore_1
      //   27: aload_0
      //   28: getfield 35	b/a/f/g$c:a	Lb/a/f/h;
      //   31: invokevirtual 227	b/a/f/h:a	()V
      //   34: aload_3
      //   35: astore_2
      //   36: aload_3
      //   37: astore_1
      //   38: aload_0
      //   39: getfield 35	b/a/f/g$c:a	Lb/a/f/h;
      //   42: aload_0
      //   43: invokevirtual 230	b/a/f/h:a	(Lb/a/f/h$b;)Z
      //   46: ifne -12 -> 34
      //   49: aload_3
      //   50: astore_2
      //   51: aload_3
      //   52: astore_1
      //   53: getstatic 232	b/a/f/b:a	Lb/a/f/b;
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: astore_1
      //   61: getstatic 234	b/a/f/b:f	Lb/a/f/b;
      //   64: astore 5
      //   66: aload_0
      //   67: getfield 22	b/a/f/g$c:c	Lb/a/f/g;
      //   70: aload_3
      //   71: aload 5
      //   73: invokevirtual 237	b/a/f/g:a	(Lb/a/f/b;Lb/a/f/b;)V
      //   76: aload_0
      //   77: getfield 35	b/a/f/g$c:a	Lb/a/f/h;
      //   80: invokestatic 242	b/a/c:a	(Ljava/io/Closeable;)V
      //   83: return
      //   84: astore_1
      //   85: aload_2
      //   86: astore_1
      //   87: getstatic 183	b/a/f/b:b	Lb/a/f/b;
      //   90: astore_2
      //   91: aload_2
      //   92: astore_1
      //   93: getstatic 183	b/a/f/b:b	Lb/a/f/b;
      //   96: astore_3
      //   97: aload_0
      //   98: getfield 22	b/a/f/g$c:c	Lb/a/f/g;
      //   101: aload_2
      //   102: aload_3
      //   103: invokevirtual 237	b/a/f/g:a	(Lb/a/f/b;Lb/a/f/b;)V
      //   106: aload_0
      //   107: getfield 35	b/a/f/g$c:a	Lb/a/f/h;
      //   110: invokestatic 242	b/a/c:a	(Ljava/io/Closeable;)V
      //   113: return
      //   114: astore_2
      //   115: aload_0
      //   116: getfield 22	b/a/f/g$c:c	Lb/a/f/g;
      //   119: aload_1
      //   120: aload 4
      //   122: invokevirtual 237	b/a/f/g:a	(Lb/a/f/b;Lb/a/f/b;)V
      //   125: aload_0
      //   126: getfield 35	b/a/f/g$c:a	Lb/a/f/h;
      //   129: invokestatic 242	b/a/c:a	(Ljava/io/Closeable;)V
      //   132: aload_2
      //   133: athrow
      //   134: astore_1
      //   135: goto -10 -> 125
      //   138: astore_1
      //   139: goto -33 -> 106
      //   142: astore_1
      //   143: goto -67 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	c
      //   12	49	1	localb1	b
      //   84	1	1	localIOException1	IOException
      //   86	34	1	localb2	b
      //   134	1	1	localIOException2	IOException
      //   138	1	1	localIOException3	IOException
      //   142	1	1	localIOException4	IOException
      //   10	92	2	localb3	b
      //   114	19	2	localObject	Object
      //   3	100	3	localb4	b
      //   7	114	4	localb5	b
      //   64	8	5	localb6	b
      // Exception table:
      //   from	to	target	type
      //   13	23	84	java/io/IOException
      //   27	34	84	java/io/IOException
      //   38	49	84	java/io/IOException
      //   53	57	84	java/io/IOException
      //   61	66	84	java/io/IOException
      //   13	23	114	finally
      //   27	34	114	finally
      //   38	49	114	finally
      //   53	57	114	finally
      //   61	66	114	finally
      //   87	91	114	finally
      //   93	97	114	finally
      //   115	125	134	java/io/IOException
      //   97	106	138	java/io/IOException
      //   66	76	142	java/io/IOException
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */