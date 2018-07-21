package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ThreadSafe
class c
  implements cz.msebera.android.httpclient.c.b, cz.msebera.android.httpclient.e.j, Closeable
{
  public cz.msebera.android.httpclient.h.b a;
  private final o b;
  private final cz.msebera.android.httpclient.j c;
  private volatile boolean d;
  private volatile Object e;
  private volatile long f;
  private volatile TimeUnit g;
  private volatile boolean h;
  
  public c(cz.msebera.android.httpclient.h.b paramb, o paramo, cz.msebera.android.httpclient.j paramj)
  {
    this.a = paramb;
    this.b = paramo;
    this.c = paramj;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    synchronized (this.c)
    {
      this.f = paramLong;
      this.g = paramTimeUnit;
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    this.e = paramObject;
  }
  
  public boolean a()
  {
    boolean bool = this.h;
    this.a.a("Cancelling request execution");
    b();
    return !bool;
  }
  
  public void b()
  {
    synchronized (this.c)
    {
      if (this.h) {
        return;
      }
      this.h = true;
      try
      {
        this.c.f();
        this.a.a("Connection discarded");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (this.a.a()) {
            this.a.a(localIOException.getMessage(), localIOException);
          }
          this.b.a(this.c, null, 0L, TimeUnit.MILLISECONDS);
        }
      }
      finally
      {
        this.b.a(this.c, null, 0L, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void close()
    throws IOException
  {
    b();
  }
  
  public void d()
  {
    this.d = true;
  }
  
  public void e()
  {
    this.d = false;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public void i_()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.h) {
          return;
        }
        this.h = true;
        if (this.d)
        {
          this.b.a(this.c, this.e, this.f, this.g);
          return;
        }
      }
      try
      {
        this.c.close();
        this.a.a("Connection discarded");
        this.b.a(this.c, null, 0L, TimeUnit.MILLISECONDS);
      }
      catch (IOException localIOException)
      {
        if (this.a.a()) {
          this.a.a(localIOException.getMessage(), localIOException);
        }
        this.b.a(this.c, null, 0L, TimeUnit.MILLISECONDS);
      }
      finally
      {
        this.b.a(this.c, null, 0L, TimeUnit.MILLISECONDS);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */