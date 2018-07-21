package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
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
@NotThreadSafe
public class s
  extends a<t>
{
  private final y a;
  private final d c;
  
  public s(h paramh, w paramw, y paramy, j paramj)
  {
    super(paramh, paramw, paramj);
    this.a = ((y)cz.msebera.android.httpclient.o.a.a(paramy, "Response factory"));
    this.c = new d(128);
  }
  
  protected t b(h paramh)
    throws IOException, p, ai
  {
    this.c.a();
    if (paramh.a(this.c) == -1) {
      throw new ah("The target server failed to respond");
    }
    paramh = new x(0, this.c.e());
    paramh = this.b.d(this.c, paramh);
    return this.a.a(paramh, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */