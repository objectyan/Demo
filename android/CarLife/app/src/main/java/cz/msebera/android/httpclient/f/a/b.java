package cz.msebera.android.httpclient.f.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.f;
import cz.msebera.android.httpclient.l.j;
import java.util.Collection;

@Deprecated
@NotThreadSafe
public class b
  extends f
{
  public b(j paramj)
  {
    super(paramj);
  }
  
  public void a(Collection<String> paramCollection)
  {
    this.a.a("http.protocol.cookie-datepatterns", paramCollection);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.b("http.protocol.single-cookie-header", paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */