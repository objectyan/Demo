package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.o.a;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

@Deprecated
public class b
  extends cz.msebera.android.httpclient.i.c.b
{
  private final long f;
  private long g;
  private final long h;
  private long i;
  
  public b(e parame, cz.msebera.android.httpclient.e.b.b paramb)
  {
    this(parame, paramb, -1L, TimeUnit.MILLISECONDS);
  }
  
  public b(e parame, cz.msebera.android.httpclient.e.b.b paramb, long paramLong, TimeUnit paramTimeUnit)
  {
    super(parame, paramb);
    a.a(paramb, "HTTP route");
    this.f = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.h = (this.f + paramTimeUnit.toMillis(paramLong));; this.h = Long.MAX_VALUE)
    {
      this.i = this.h;
      return;
    }
  }
  
  public b(e parame, cz.msebera.android.httpclient.e.b.b paramb, ReferenceQueue<Object> paramReferenceQueue)
  {
    super(parame, paramb);
    a.a(paramb, "HTTP route");
    this.f = System.currentTimeMillis();
    this.h = Long.MAX_VALUE;
    this.i = this.h;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    this.g = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.g + paramTimeUnit.toMillis(paramLong);; paramLong = Long.MAX_VALUE)
    {
      this.i = Math.min(this.h, paramLong);
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    return paramLong >= this.i;
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected final w c()
  {
    return this.b;
  }
  
  protected final cz.msebera.android.httpclient.e.b.b d()
  {
    return this.c;
  }
  
  protected final c e()
  {
    return null;
  }
  
  public long f()
  {
    return this.f;
  }
  
  public long g()
  {
    return this.g;
  }
  
  public long h()
  {
    return this.i;
  }
  
  public long i()
  {
    return this.h;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */