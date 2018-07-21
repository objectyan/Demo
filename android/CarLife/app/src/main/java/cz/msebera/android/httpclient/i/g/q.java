package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import cz.msebera.android.httpclient.v;
import java.io.IOException;

@Deprecated
@NotThreadSafe
public class q
  extends a<t>
{
  private final v a;
  private final d c;
  
  public q(h paramh, w paramw, v paramv, j paramj)
  {
    super(paramh, paramw, paramj);
    this.a = ((v)cz.msebera.android.httpclient.o.a.a(paramv, "Request factory"));
    this.c = new d(128);
  }
  
  protected t b(h paramh)
    throws IOException, p, ai
  {
    this.c.a();
    if (paramh.a(this.c) == -1) {
      throw new cz.msebera.android.httpclient.a("Client closed connection");
    }
    paramh = new x(0, this.c.e());
    paramh = this.b.c(this.c, paramh);
    return this.a.a(paramh);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */