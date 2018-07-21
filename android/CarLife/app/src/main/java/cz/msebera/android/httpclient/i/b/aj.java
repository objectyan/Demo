package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.j;
import cz.msebera.android.httpclient.b.r;
import cz.msebera.android.httpclient.c.c;
import cz.msebera.android.httpclient.n.g;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

class aj<V>
  implements Callable<V>
{
  private final q a;
  private final j b;
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final long d = System.currentTimeMillis();
  private long e = -1L;
  private long f = -1L;
  private final g g;
  private final r<V> h;
  private final c<V> i;
  private final ad j;
  
  aj(j paramj, q paramq, g paramg, r<V> paramr, c<V> paramc, ad paramad)
  {
    this.b = paramj;
    this.h = paramr;
    this.a = paramq;
    this.g = paramg;
    this.i = paramc;
    this.j = paramad;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public long b()
  {
    return this.e;
  }
  
  public long c()
  {
    return this.f;
  }
  
  public V call()
    throws Exception
  {
    if (!this.c.get()) {
      try
      {
        this.j.a().incrementAndGet();
        this.e = System.currentTimeMillis();
        try
        {
          this.j.b().decrementAndGet();
          Object localObject1 = this.b.a(this.a, this.h, this.g);
          this.f = System.currentTimeMillis();
          this.j.c().a(this.e);
          if (this.i != null) {
            this.i.a(localObject1);
          }
          return (V)localObject1;
        }
        catch (Exception localException)
        {
          this.j.d().a(this.e);
          this.f = System.currentTimeMillis();
          if (this.i != null) {
            this.i.a(localException);
          }
          throw localException;
        }
        throw new IllegalStateException("call has been cancelled for request " + this.a.getURI());
      }
      finally
      {
        this.j.e().a(this.e);
        this.j.f().a(this.e);
        this.j.a().decrementAndGet();
      }
    }
  }
  
  public void d()
  {
    this.c.set(true);
    if (this.i != null) {
      this.i.a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */