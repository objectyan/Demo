package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.util.Map;

@Deprecated
@ThreadSafe
public class p
  implements q
{
  private final ah<n> a = new ah();
  
  public Map<String, n> a()
  {
    return this.a.a();
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString, n paramn)
  {
    a.a(paramString, "URI request pattern");
    a.a(paramn, "Request handler");
    this.a.a(paramString, paramn);
  }
  
  public void a(Map<String, n> paramMap)
  {
    this.a.b(paramMap);
  }
  
  public n b(String paramString)
  {
    return (n)this.a.b(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */