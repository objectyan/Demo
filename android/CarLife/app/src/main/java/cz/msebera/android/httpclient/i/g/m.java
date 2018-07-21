package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.d.c;
import cz.msebera.android.httpclient.i.l;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.y;
import java.io.IOException;

@NotThreadSafe
public class m
  extends a<cz.msebera.android.httpclient.x>
{
  private final y a;
  private final d c;
  
  public m(h paramh)
  {
    this(paramh, null, null, c.a);
  }
  
  public m(h paramh, c paramc)
  {
    this(paramh, null, null, paramc);
  }
  
  public m(h paramh, w paramw, y paramy, c paramc)
  {
    super(paramh, paramw, paramc);
    if (paramy != null) {}
    for (;;)
    {
      this.a = paramy;
      this.c = new d(128);
      return;
      paramy = l.a;
    }
  }
  
  @Deprecated
  public m(h paramh, w paramw, y paramy, j paramj)
  {
    super(paramh, paramw, paramj);
    this.a = ((y)cz.msebera.android.httpclient.o.a.a(paramy, "Response factory"));
    this.c = new d(128);
  }
  
  protected cz.msebera.android.httpclient.x a(h paramh)
    throws IOException, p, ai
  {
    this.c.a();
    if (paramh.a(this.c) == -1) {
      throw new ah("The target server failed to respond");
    }
    paramh = new cz.msebera.android.httpclient.k.x(0, this.c.e());
    paramh = this.b.d(this.c, paramh);
    return this.a.a(paramh, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */