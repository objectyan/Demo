package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.m.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
class f
  extends a<cz.msebera.android.httpclient.e.b.b, u, g>
{
  private static final AtomicLong b = new AtomicLong();
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(f.class);
  private final long c;
  private final TimeUnit d;
  
  public f(cz.msebera.android.httpclient.m.b<cz.msebera.android.httpclient.e.b.b, u> paramb, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramb, paramInt1, paramInt2);
    this.c = paramLong;
    this.d = paramTimeUnit;
  }
  
  protected g a(cz.msebera.android.httpclient.e.b.b paramb, u paramu)
  {
    String str = Long.toString(b.getAndIncrement());
    return new g(this.a, str, paramb, paramu, this.c, this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */