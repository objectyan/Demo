package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import cz.msebera.android.httpclient.y;
import java.io.IOException;

@Deprecated
@ThreadSafe
public class q
  extends cz.msebera.android.httpclient.i.g.a<t>
{
  public b a = new b(getClass());
  private final y c;
  private final d d;
  private final int e;
  
  public q(h paramh, w paramw, y paramy, j paramj)
  {
    super(paramh, paramw, paramj);
    cz.msebera.android.httpclient.o.a.a(paramy, "Response factory");
    this.c = paramy;
    this.d = new d(128);
    this.e = a(paramj);
  }
  
  protected int a(j paramj)
  {
    return paramj.a("http.connection.max-status-line-garbage", Integer.MAX_VALUE);
  }
  
  protected t b(h paramh)
    throws IOException, p
  {
    int i = 0;
    for (;;)
    {
      this.d.a();
      int j = paramh.a(this.d);
      if ((j == -1) && (i == 0)) {
        throw new ah("The target server failed to respond");
      }
      x localx = new x(0, this.d.e());
      if (this.b.b(this.d, localx))
      {
        paramh = this.b.d(this.d, localx);
        return this.c.a(paramh, null);
      }
      if ((j == -1) || (i >= this.e)) {
        throw new aj("The server failed to respond with a valid HTTP response");
      }
      if (this.a.a()) {
        this.a.a("Garbage in response: " + this.d.toString());
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */