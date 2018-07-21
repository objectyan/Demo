package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.d.c;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.y;
import java.io.IOException;

@NotThreadSafe
public class l
  extends cz.msebera.android.httpclient.i.g.a<cz.msebera.android.httpclient.x>
{
  public b a = new b(getClass());
  private final y c;
  private final d d;
  
  public l(h paramh)
  {
    this(paramh, null, null, c.a);
  }
  
  public l(h paramh, c paramc)
  {
    this(paramh, null, null, paramc);
  }
  
  public l(h paramh, w paramw, y paramy, c paramc)
  {
    super(paramh, paramw, paramc);
    if (paramy != null) {}
    for (;;)
    {
      this.c = paramy;
      this.d = new d(128);
      return;
      paramy = cz.msebera.android.httpclient.i.l.a;
    }
  }
  
  @Deprecated
  public l(h paramh, w paramw, y paramy, j paramj)
  {
    super(paramh, paramw, paramj);
    cz.msebera.android.httpclient.o.a.a(paramy, "Response factory");
    this.c = paramy;
    this.d = new d(128);
  }
  
  protected cz.msebera.android.httpclient.x a(h paramh)
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
      cz.msebera.android.httpclient.k.x localx = new cz.msebera.android.httpclient.k.x(0, this.d.e());
      if (this.b.b(this.d, localx))
      {
        paramh = this.b.d(this.d, localx);
        return this.c.a(paramh, null);
      }
      if ((j == -1) || (a(this.d, i))) {
        throw new aj("The server failed to respond with a valid HTTP response");
      }
      if (this.a.a()) {
        this.a.a("Garbage in response: " + this.d.toString());
      }
      i += 1;
    }
  }
  
  protected boolean a(d paramd, int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */