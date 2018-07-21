package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.m;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.p;
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
public abstract class a
  implements t, g
{
  private final c a;
  private volatile w b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile long e;
  
  protected a(c paramc, w paramw)
  {
    this.a = paramc;
    this.b = paramw;
    this.c = false;
    this.d = false;
    this.e = Long.MAX_VALUE;
  }
  
  public x a()
    throws p, IOException
  {
    w localw = v();
    a(localw);
    p();
    return localw.a();
  }
  
  public Object a(String paramString)
  {
    w localw = v();
    a(localw);
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
  
  protected final void a(w paramw)
    throws i
  {
    if ((y()) || (paramw == null)) {
      throw new i();
    }
  }
  
  public void a(o paramo)
    throws p, IOException
  {
    w localw = v();
    a(localw);
    p();
    localw.a(paramo);
  }
  
  public void a(u paramu)
    throws p, IOException
  {
    w localw = v();
    a(localw);
    p();
    localw.a(paramu);
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    w localw = v();
    a(localw);
    p();
    localw.a(paramx);
  }
  
  public void a(String paramString, Object paramObject)
  {
    w localw = v();
    a(localw);
    if ((localw instanceof g)) {
      ((g)localw).a(paramString, paramObject);
    }
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    w localw = v();
    a(localw);
    return localw.a(paramInt);
  }
  
  public Object b(String paramString)
  {
    w localw = v();
    a(localw);
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
    //   3: getfield 32	cz/msebera/android/httpclient/i/c/a:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 32	cz/msebera/android/httpclient/i/c/a:d	Z
    //   19: aload_0
    //   20: invokevirtual 52	cz/msebera/android/httpclient/i/c/a:p	()V
    //   23: aload_0
    //   24: invokevirtual 100	cz/msebera/android/httpclient/i/c/a:f	()V
    //   27: aload_0
    //   28: getfield 26	cz/msebera/android/httpclient/i/c/a:a	Lcz/msebera/android/httpclient/e/c;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 36	cz/msebera/android/httpclient/i/c/a:e	J
    //   36: getstatic 104	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   39: invokeinterface 109 5 0
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: astore_2
    //   53: goto -26 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	a
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    //   52	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	23	47	finally
    //   23	27	47	finally
    //   27	44	47	finally
    //   23	27	52	java/io/IOException
  }
  
  public void b(int paramInt)
  {
    w localw = v();
    a(localw);
    localw.b(paramInt);
  }
  
  public boolean c()
  {
    w localw = v();
    if (localw == null) {
      return false;
    }
    return localw.c();
  }
  
  public boolean d()
  {
    if (y()) {}
    w localw;
    do
    {
      return true;
      localw = v();
    } while (localw == null);
    return localw.d();
  }
  
  public int e()
  {
    w localw = v();
    a(localw);
    return localw.e();
  }
  
  public m g()
  {
    w localw = v();
    a(localw);
    return localw.g();
  }
  
  public InetAddress h()
  {
    w localw = v();
    a(localw);
    return localw.h();
  }
  
  public void h_()
    throws IOException
  {
    w localw = v();
    a(localw);
    localw.h_();
  }
  
  public int i()
  {
    w localw = v();
    a(localw);
    return localw.i();
  }
  
  /* Error */
  public void i_()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	cz/msebera/android/httpclient/i/c/a:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 32	cz/msebera/android/httpclient/i/c/a:d	Z
    //   19: aload_0
    //   20: getfield 26	cz/msebera/android/httpclient/i/c/a:a	Lcz/msebera/android/httpclient/e/c;
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 36	cz/msebera/android/httpclient/i/c/a:e	J
    //   28: getstatic 104	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 109 5 0
    //   36: goto -25 -> 11
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	a
    //   6	2	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
  
  public InetAddress j()
  {
    w localw = v();
    a(localw);
    return localw.j();
  }
  
  public int k()
  {
    w localw = v();
    a(localw);
    return localw.k();
  }
  
  public boolean l()
  {
    w localw = v();
    a(localw);
    return localw.m();
  }
  
  public SSLSession n()
  {
    Object localObject = v();
    a((w)localObject);
    if (!c()) {}
    do
    {
      return null;
      localObject = ((w)localObject).t();
    } while (!(localObject instanceof SSLSocket));
    return ((SSLSocket)localObject).getSession();
  }
  
  public void o()
  {
    this.c = true;
  }
  
  public void p()
  {
    this.c = false;
  }
  
  public boolean q()
  {
    return this.c;
  }
  
  public Socket t()
  {
    w localw = v();
    a(localw);
    if (!c()) {
      return null;
    }
    return localw.t();
  }
  
  protected void u()
  {
    try
    {
      this.b = null;
      this.e = Long.MAX_VALUE;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected w v()
  {
    return this.b;
  }
  
  protected c w()
  {
    return this.a;
  }
  
  @Deprecated
  protected final void x()
    throws InterruptedIOException
  {
    if (y()) {
      throw new InterruptedIOException("Connection has been shut down");
    }
  }
  
  protected boolean y()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */