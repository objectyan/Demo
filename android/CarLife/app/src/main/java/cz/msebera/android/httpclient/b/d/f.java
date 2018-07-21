package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.g.a;
import cz.msebera.android.httpclient.o;

@NotThreadSafe
public abstract class f
  extends n
  implements o
{
  private cz.msebera.android.httpclient.n entity;
  
  public Object clone()
    throws CloneNotSupportedException
  {
    f localf = (f)super.clone();
    if (this.entity != null) {
      localf.entity = ((cz.msebera.android.httpclient.n)a.a(this.entity));
    }
    return localf;
  }
  
  public boolean expectContinue()
  {
    cz.msebera.android.httpclient.f localf = getFirstHeader("Expect");
    return (localf != null) && ("100-continue".equalsIgnoreCase(localf.d()));
  }
  
  public cz.msebera.android.httpclient.n getEntity()
  {
    return this.entity;
  }
  
  public void setEntity(cz.msebera.android.httpclient.n paramn)
  {
    this.entity = paramn;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */