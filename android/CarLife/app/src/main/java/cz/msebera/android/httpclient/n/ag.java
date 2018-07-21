package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;

@ThreadSafe
public class ag
  implements o
{
  private final ah<n> a;
  
  public ag()
  {
    this(new ah());
  }
  
  protected ag(ah<n> paramah)
  {
    this.a = ((ah)a.a(paramah, "Pattern matcher"));
  }
  
  public n a(u paramu)
  {
    a.a(paramu, "HTTP request");
    return (n)this.a.b(b(paramu));
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString, n paramn)
  {
    a.a(paramString, "Pattern");
    a.a(paramn, "Handler");
    this.a.a(paramString, paramn);
  }
  
  protected String b(u paramu)
  {
    String str = paramu.getRequestLine().c();
    int i = str.indexOf("?");
    if (i != -1) {
      paramu = str.substring(0, i);
    }
    do
    {
      return paramu;
      i = str.indexOf("#");
      paramu = str;
    } while (i == -1);
    return str.substring(0, i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */