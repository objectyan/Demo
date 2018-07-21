package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.io.Serializable;

@Immutable
public class b
  implements f, Serializable, Cloneable
{
  private static final long a = -5427236326487562174L;
  private final String b;
  private final String c;
  
  public b(String paramString1, String paramString2)
  {
    this.b = ((String)a.a(paramString1, "Name"));
    this.c = paramString2;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public String d()
  {
    return this.c;
  }
  
  public cz.msebera.android.httpclient.g[] e()
    throws ai
  {
    if (this.c != null) {
      return g.a(this.c, null);
    }
    return new cz.msebera.android.httpclient.g[0];
  }
  
  public String toString()
  {
    return k.b.a(null, this).toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */