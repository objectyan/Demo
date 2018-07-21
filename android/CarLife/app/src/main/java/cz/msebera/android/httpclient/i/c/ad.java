package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.b.f;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.m;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
@NotThreadSafe
class ad
  implements t
{
  private final c a;
  private final e b;
  private volatile v c;
  private volatile boolean d;
  private volatile long e;
  
  ad(c paramc, e parame, v paramv)
  {
    a.a(paramc, "Connection manager");
    a.a(parame, "Connection operator");
    a.a(paramv, "HTTP pool entry");
    this.a = paramc;
    this.b = parame;
    this.c = paramv;
    this.d = false;
    this.e = Long.MAX_VALUE;
  }
  
  private w x()
  {
    v localv = this.c;
    if (localv == null) {
      return null;
    }
    return (w)localv.i();
  }
  
  private w y()
  {
    v localv = this.c;
    if (localv == null) {
      throw new i();
    }
    return (w)localv.i();
  }
  
  private v z()
  {
    v localv = this.c;
    if (localv == null) {
      throw new i();
    }
    return localv;
  }
  
  public x a()
    throws p, IOException
  {
    return y().a();
  }
  
  public Object a(String paramString)
  {
    w localw = y();
    if ((localw instanceof g)) {
      return ((g)localw).a(paramString);
    }
    return null;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.e = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.e = -1L;
  }
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, g paramg, j paramj)
    throws IOException
  {
    a.a(paramb, "Route");
    a.a(paramj, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new i();
      }
    }
    finally {}
    Object localObject = this.c.a();
    cz.msebera.android.httpclient.o.b.a(localObject, "Route tracker");
    boolean bool;
    w localw;
    r localr;
    e locale;
    if (!((f)localObject).k())
    {
      bool = true;
      cz.msebera.android.httpclient.o.b.a(bool, "Connection already open");
      localw = (w)this.c.i();
      localr = paramb.e();
      locale = this.b;
      if (localr == null) {
        break label150;
      }
    }
    label150:
    for (localObject = localr;; localObject = paramb.a())
    {
      locale.a(localw, (r)localObject, paramb.b(), paramg, paramj);
      try
      {
        if (this.c != null) {
          break label159;
        }
        throw new InterruptedIOException();
      }
      finally {}
      bool = false;
      break;
    }
    label159:
    paramb = this.c.a();
    if (localr == null) {
      paramb.a(localw.m());
    }
    for (;;)
    {
      return;
      paramb.a(localr, localw.m());
    }
  }
  
  public void a(g paramg, j paramj)
    throws IOException
  {
    a.a(paramj, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new i();
      }
    }
    finally {}
    Object localObject = this.c.a();
    cz.msebera.android.httpclient.o.b.a(localObject, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(((f)localObject).k(), "Connection not open");
    cz.msebera.android.httpclient.o.b.a(((f)localObject).g(), "Protocol layering without a tunnel not supported");
    if (!((f)localObject).i()) {}
    w localw;
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Multiple protocol layering not supported");
      localObject = ((f)localObject).a();
      localw = (w)this.c.i();
      this.b.a(localw, (r)localObject, paramg, paramj);
      try
      {
        if (this.c != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    this.c.a().c(localw.m());
  }
  
  public void a(o paramo)
    throws p, IOException
  {
    y().a(paramo);
  }
  
  public void a(r paramr, boolean paramBoolean, j paramj)
    throws IOException
  {
    a.a(paramr, "Next proxy");
    a.a(paramj, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new i();
      }
    }
    finally {}
    Object localObject = this.c.a();
    cz.msebera.android.httpclient.o.b.a(localObject, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(((f)localObject).k(), "Connection not open");
    localObject = (w)this.c.i();
    ((w)localObject).a(null, paramr, paramBoolean, paramj);
    try
    {
      if (this.c == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.c.a().b(paramr, paramBoolean);
  }
  
  public void a(u paramu)
    throws p, IOException
  {
    y().a(paramu);
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    y().a(paramx);
  }
  
  public void a(Object paramObject)
  {
    z().a(paramObject);
  }
  
  public void a(String paramString, Object paramObject)
  {
    w localw = y();
    if ((localw instanceof g)) {
      ((g)localw).a(paramString, paramObject);
    }
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public void a(boolean paramBoolean, j paramj)
    throws IOException
  {
    a.a(paramj, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new i();
      }
    }
    finally {}
    Object localObject = this.c.a();
    cz.msebera.android.httpclient.o.b.a(localObject, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(((f)localObject).k(), "Connection not open");
    if (!((f)localObject).g()) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection is already tunnelled");
      localObject = ((f)localObject).a();
      w localw = (w)this.c.i();
      localw.a(null, (r)localObject, paramBoolean, paramj);
      try
      {
        if (this.c != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    this.c.a().b(paramBoolean);
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    return y().a(paramInt);
  }
  
  public Object b(String paramString)
  {
    w localw = y();
    if ((localw instanceof g)) {
      return ((g)localw).b(paramString);
    }
    return null;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	cz/msebera/android/httpclient/i/c/ad:c	Lcz/msebera/android/httpclient/i/c/v;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 42	cz/msebera/android/httpclient/i/c/ad:d	Z
    //   17: aload_0
    //   18: getfield 40	cz/msebera/android/httpclient/i/c/ad:c	Lcz/msebera/android/httpclient/i/c/v;
    //   21: invokevirtual 55	cz/msebera/android/httpclient/i/c/v:i	()Ljava/lang/Object;
    //   24: checkcast 57	cz/msebera/android/httpclient/e/w
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 200 1 0
    //   34: aload_0
    //   35: getfield 36	cz/msebera/android/httpclient/i/c/ad:a	Lcz/msebera/android/httpclient/e/c;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 46	cz/msebera/android/httpclient/i/c/ad:e	J
    //   43: getstatic 204	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 209 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 40	cz/msebera/android/httpclient/i/c/ad:c	Lcz/msebera/android/httpclient/i/c/v;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ad
    //   27	2	1	localw	w
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void b(int paramInt)
  {
    y().b(paramInt);
  }
  
  public boolean c()
  {
    w localw = x();
    if (localw != null) {
      return localw.c();
    }
    return false;
  }
  
  public void close()
    throws IOException
  {
    v localv = this.c;
    if (localv != null)
    {
      w localw = (w)localv.i();
      localv.a().c();
      localw.close();
    }
  }
  
  public boolean d()
  {
    w localw = x();
    if (localw != null) {
      return localw.d();
    }
    return true;
  }
  
  public int e()
  {
    return y().e();
  }
  
  public void f()
    throws IOException
  {
    v localv = this.c;
    if (localv != null)
    {
      w localw = (w)localv.i();
      localv.a().c();
      localw.f();
    }
  }
  
  public m g()
  {
    return y().g();
  }
  
  public InetAddress h()
  {
    return y().h();
  }
  
  public void h_()
    throws IOException
  {
    y().h_();
  }
  
  public int i()
  {
    return y().i();
  }
  
  public void i_()
  {
    try
    {
      if (this.c == null) {
        return;
      }
      this.a.a(this, this.e, TimeUnit.MILLISECONDS);
      this.c = null;
      return;
    }
    finally {}
  }
  
  public InetAddress j()
  {
    return y().j();
  }
  
  public int k()
  {
    return y().k();
  }
  
  public boolean l()
  {
    return y().m();
  }
  
  public cz.msebera.android.httpclient.e.b.b m()
  {
    return z().c();
  }
  
  public SSLSession n()
  {
    Object localObject = y();
    SSLSession localSSLSession = null;
    localObject = ((w)localObject).t();
    if ((localObject instanceof SSLSocket)) {
      localSSLSession = ((SSLSocket)localObject).getSession();
    }
    return localSSLSession;
  }
  
  public void o()
  {
    this.d = true;
  }
  
  public void p()
  {
    this.d = false;
  }
  
  public boolean q()
  {
    return this.d;
  }
  
  public Object r()
  {
    return z().l();
  }
  
  public String s()
  {
    return null;
  }
  
  public Socket t()
  {
    return y().t();
  }
  
  v u()
  {
    return this.c;
  }
  
  v v()
  {
    v localv = this.c;
    this.c = null;
    return localv;
  }
  
  public c w()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */