package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.e.y;
import cz.msebera.android.httpclient.i.c.s;
import cz.msebera.android.httpclient.r;
import java.util.HashMap;

@NotThreadSafe
public class g
  implements cz.msebera.android.httpclient.b.a
{
  private final HashMap<r, d> a = new HashMap();
  private final x b;
  
  public g()
  {
    this(null);
  }
  
  public g(x paramx)
  {
    if (paramx != null) {}
    for (;;)
    {
      this.b = paramx;
      return;
      paramx = s.a;
    }
  }
  
  public d a(r paramr)
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "HTTP host");
    return (d)this.a.get(c(paramr));
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(r paramr, d paramd)
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "HTTP host");
    this.a.put(c(paramr), paramd);
  }
  
  public void b(r paramr)
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "HTTP host");
    this.a.remove(c(paramr));
  }
  
  protected r c(r paramr)
  {
    r localr = paramr;
    if (paramr.b() <= 0) {}
    try
    {
      int i = this.b.a(paramr);
      localr = new r(paramr.a(), i, paramr.c());
      return localr;
    }
    catch (y localy) {}
    return paramr;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */