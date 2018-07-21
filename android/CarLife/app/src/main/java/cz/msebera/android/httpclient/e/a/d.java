package cz.msebera.android.httpclient.e.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.f;
import cz.msebera.android.httpclient.l.j;

@Deprecated
@NotThreadSafe
public class d
  extends f
{
  public d(j paramj)
  {
    super(paramj);
  }
  
  public void a(int paramInt)
  {
    this.a.b("http.conn-manager.max-total", paramInt);
  }
  
  public void a(long paramLong)
  {
    this.a.b("http.conn-manager.timeout", paramLong);
  }
  
  public void a(g paramg)
  {
    this.a.a("http.conn-manager.max-per-route", paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */