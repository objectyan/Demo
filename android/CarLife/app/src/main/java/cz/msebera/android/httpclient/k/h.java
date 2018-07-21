package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o;

@NotThreadSafe
public class h
  extends i
  implements o
{
  private n a;
  
  public h(am paramam)
  {
    super(paramam);
  }
  
  public h(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public h(String paramString1, String paramString2, ak paramak)
  {
    super(paramString1, paramString2, paramak);
  }
  
  public boolean expectContinue()
  {
    f localf = getFirstHeader("Expect");
    return (localf != null) && ("100-continue".equalsIgnoreCase(localf.d()));
  }
  
  public n getEntity()
  {
    return this.a;
  }
  
  public void setEntity(n paramn)
  {
    this.a = paramn;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */