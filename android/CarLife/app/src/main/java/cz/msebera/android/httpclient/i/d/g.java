package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.g.b;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import java.util.Date;

@Immutable
public class g
  extends a
{
  private final String[] a;
  
  public g(String[] paramArrayOfString)
  {
    cz.msebera.android.httpclient.o.a.a(paramArrayOfString, "Array of date patterns");
    this.a = paramArrayOfString;
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for expires attribute");
    }
    Date localDate = b.a(paramString, this.a);
    if (localDate == null) {
      throw new l("Unable to parse expires attribute: " + paramString);
    }
    paramn.b(localDate);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */