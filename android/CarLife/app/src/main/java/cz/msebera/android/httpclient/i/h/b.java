package cz.msebera.android.httpclient.i.h;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.d.f;
import cz.msebera.android.httpclient.r;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class b
  extends cz.msebera.android.httpclient.m.a<r, cz.msebera.android.httpclient.j, c>
{
  private static final AtomicLong a = new AtomicLong();
  
  public b()
  {
    super(new a(f.a, cz.msebera.android.httpclient.d.a.a), 2, 20);
  }
  
  public b(f paramf, cz.msebera.android.httpclient.d.a parama)
  {
    super(new a(paramf, parama), 2, 20);
  }
  
  @Deprecated
  public b(cz.msebera.android.httpclient.l.j paramj)
  {
    super(new a(paramj), 2, 20);
  }
  
  public b(cz.msebera.android.httpclient.m.b<r, cz.msebera.android.httpclient.j> paramb)
  {
    super(paramb, 2, 20);
  }
  
  protected c a(r paramr, cz.msebera.android.httpclient.j paramj)
  {
    return new c(Long.toString(a.getAndIncrement()), paramr, paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */