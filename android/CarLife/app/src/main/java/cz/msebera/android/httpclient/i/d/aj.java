package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.h;
import cz.msebera.android.httpclient.f.i;
import cz.msebera.android.httpclient.n.g;
import java.util.Collection;

@Immutable
public class aj
  implements i, cz.msebera.android.httpclient.f.j
{
  private final String[] a;
  private final boolean b;
  
  public aj()
  {
    this(null, false);
  }
  
  public aj(String[] paramArrayOfString, boolean paramBoolean)
  {
    this.a = paramArrayOfString;
    this.b = paramBoolean;
  }
  
  public h a(cz.msebera.android.httpclient.l.j paramj)
  {
    if (paramj != null)
    {
      String[] arrayOfString = null;
      Collection localCollection = (Collection)paramj.a("http.protocol.cookie-datepatterns");
      if (localCollection != null) {
        arrayOfString = (String[])localCollection.toArray(new String[localCollection.size()]);
      }
      return new ai(arrayOfString, paramj.a("http.protocol.single-cookie-header", false));
    }
    return new ai();
  }
  
  public h a(g paramg)
  {
    return new ai(this.a, this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */