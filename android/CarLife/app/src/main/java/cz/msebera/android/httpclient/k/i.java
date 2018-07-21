package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.u;

@NotThreadSafe
public class i
  extends a
  implements u
{
  private final String a;
  private final String b;
  private am c;
  
  public i(am paramam)
  {
    this.c = ((am)cz.msebera.android.httpclient.o.a.a(paramam, "Request line"));
    this.a = paramam.a();
    this.b = paramam.c();
  }
  
  public i(String paramString1, String paramString2)
  {
    this.a = ((String)cz.msebera.android.httpclient.o.a.a(paramString1, "Method name"));
    this.b = ((String)cz.msebera.android.httpclient.o.a.a(paramString2, "Request URI"));
    this.c = null;
  }
  
  public i(String paramString1, String paramString2, ak paramak)
  {
    this(new o(paramString1, paramString2, paramak));
  }
  
  public ak getProtocolVersion()
  {
    return getRequestLine().b();
  }
  
  public am getRequestLine()
  {
    if (this.c == null) {
      this.c = new o(this.a, this.b, ac.d);
    }
    return this.c;
  }
  
  public String toString()
  {
    return this.a + ' ' + this.b + ' ' + this.headergroup;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */