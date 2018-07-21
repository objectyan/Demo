package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.h;
import cz.msebera.android.httpclient.f.i;
import cz.msebera.android.httpclient.n.g;
import java.util.Collection;

@Immutable
public class n
  implements i, cz.msebera.android.httpclient.f.j
{
  private final String[] a;
  private final a b;
  
  public n()
  {
    this(null, a.a);
  }
  
  public n(String[] paramArrayOfString)
  {
    this(null, a.a);
  }
  
  public n(String[] paramArrayOfString, a parama)
  {
    this.a = paramArrayOfString;
    this.b = parama;
  }
  
  public h a(cz.msebera.android.httpclient.l.j paramj)
  {
    if (paramj != null)
    {
      Object localObject = null;
      Collection localCollection = (Collection)paramj.a("http.protocol.cookie-datepatterns");
      paramj = (cz.msebera.android.httpclient.l.j)localObject;
      if (localCollection != null) {
        paramj = (String[])localCollection.toArray(new String[localCollection.size()]);
      }
      return new m(paramj, this.b);
    }
    return new m(null, this.b);
  }
  
  public h a(g paramg)
  {
    return new m(this.a);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */