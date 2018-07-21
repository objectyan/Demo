package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.h;
import cz.msebera.android.httpclient.f.i;
import cz.msebera.android.httpclient.n.g;
import java.util.Collection;

@Immutable
public class x
  implements i, cz.msebera.android.httpclient.f.j
{
  private final String[] a;
  
  public x()
  {
    this(null);
  }
  
  public x(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
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
      return new w(paramj);
    }
    return new w();
  }
  
  public h a(g paramg)
  {
    return new w(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */